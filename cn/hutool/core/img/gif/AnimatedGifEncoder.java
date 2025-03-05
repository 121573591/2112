/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Color
 *  java.awt.Graphics2D
 *  java.awt.Image
 *  java.awt.image.BufferedImage
 *  java.awt.image.DataBufferByte
 *  java.io.BufferedOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.file.Files
 *  java.nio.file.OpenOption
 *  java.nio.file.Path
 *  java.nio.file.Paths
 */
package cn.hutool.core.img.gif;

import cn.hutool.core.img.gif.LZWEncoder;
import cn.hutool.core.img.gif.NeuQuant;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnimatedGifEncoder {
    protected int width;
    protected int height;
    protected Color transparent = null;
    protected boolean transparentExactMatch = false;
    protected Color background = null;
    protected int transIndex;
    protected int repeat = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected OutputStream out;
    protected BufferedImage image;
    protected byte[] pixels;
    protected byte[] indexedPixels;
    protected int colorDepth;
    protected byte[] colorTab;
    protected boolean[] usedEntry = new boolean[256];
    protected int palSize = 7;
    protected int dispose = -1;
    protected boolean closeStream = false;
    protected boolean firstFrame = true;
    protected boolean sizeSet = false;
    protected int sample = 10;

    public void setDelay(int ms) {
        this.delay = Math.round((float)((float)ms / 10.0f));
    }

    public void setDispose(int code) {
        if (code >= 0) {
            this.dispose = code;
        }
    }

    public void setRepeat(int iter) {
        if (iter >= 0) {
            this.repeat = iter;
        }
    }

    public void setTransparent(Color c) {
        this.setTransparent(c, false);
    }

    public void setTransparent(Color c, boolean exactMatch) {
        this.transparent = c;
        this.transparentExactMatch = exactMatch;
    }

    public void setBackground(Color c) {
        this.background = c;
    }

    public boolean addFrame(BufferedImage im) {
        if (im == null || !this.started) {
            return false;
        }
        boolean ok = true;
        try {
            if (!this.sizeSet) {
                this.setSize(im.getWidth(), im.getHeight());
            }
            this.image = im;
            this.getImagePixels();
            this.analyzePixels();
            if (this.firstFrame) {
                this.writeLSD();
                this.writePalette();
                if (this.repeat >= 0) {
                    this.writeNetscapeExt();
                }
            }
            this.writeGraphicCtrlExt();
            this.writeImageDesc();
            if (!this.firstFrame) {
                this.writePalette();
            }
            this.writePixels();
            this.firstFrame = false;
        }
        catch (IOException e) {
            ok = false;
        }
        return ok;
    }

    public boolean finish() {
        if (!this.started) {
            return false;
        }
        boolean ok = true;
        this.started = false;
        try {
            this.out.write(59);
            this.out.flush();
            if (this.closeStream) {
                this.out.close();
            }
        }
        catch (IOException e) {
            ok = false;
        }
        this.transIndex = 0;
        this.out = null;
        this.image = null;
        this.pixels = null;
        this.indexedPixels = null;
        this.colorTab = null;
        this.closeStream = false;
        this.firstFrame = true;
        return ok;
    }

    public void setFrameRate(float fps) {
        if (fps != 0.0f) {
            this.delay = Math.round((float)(100.0f / fps));
        }
    }

    public void setQuality(int quality) {
        if (quality < 1) {
            quality = 1;
        }
        this.sample = quality;
    }

    public void setSize(int w, int h) {
        if (this.started && !this.firstFrame) {
            return;
        }
        this.width = w;
        this.height = h;
        if (this.width < 1) {
            this.width = 320;
        }
        if (this.height < 1) {
            this.height = 240;
        }
        this.sizeSet = true;
    }

    public boolean start(OutputStream os) {
        if (os == null) {
            return false;
        }
        boolean ok = true;
        this.closeStream = false;
        this.out = os;
        try {
            this.writeString("GIF89a");
        }
        catch (IOException e) {
            ok = false;
        }
        this.started = ok;
        return this.started;
    }

    public boolean start(String file) {
        boolean ok;
        try {
            this.out = new BufferedOutputStream(Files.newOutputStream((Path)Paths.get((String)file, (String[])new String[0]), (OpenOption[])new OpenOption[0]));
            ok = this.start(this.out);
            this.closeStream = true;
        }
        catch (IOException e) {
            ok = false;
        }
        this.started = ok;
        return this.started;
    }

    public boolean isStarted() {
        return this.started;
    }

    protected void analyzePixels() {
        int len = this.pixels.length;
        int nPix = len / 3;
        this.indexedPixels = new byte[nPix];
        NeuQuant nq = new NeuQuant(this.pixels, len, this.sample);
        this.colorTab = nq.process();
        for (int i = 0; i < this.colorTab.length; i += 3) {
            byte temp = this.colorTab[i];
            this.colorTab[i] = this.colorTab[i + 2];
            this.colorTab[i + 2] = temp;
            this.usedEntry[i / 3] = false;
        }
        int k = 0;
        for (int i = 0; i < nPix; ++i) {
            int index = nq.map(this.pixels[k++] & 0xFF, this.pixels[k++] & 0xFF, this.pixels[k++] & 0xFF);
            this.usedEntry[index] = true;
            this.indexedPixels[i] = (byte)index;
        }
        this.pixels = null;
        this.colorDepth = 8;
        this.palSize = 7;
        if (this.transparent != null) {
            this.transIndex = this.transparentExactMatch ? this.findExact(this.transparent) : this.findClosest(this.transparent);
        }
    }

    protected int findClosest(Color c) {
        if (this.colorTab == null) {
            return -1;
        }
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int minpos = 0;
        int dmin = 0x1000000;
        int len = this.colorTab.length;
        for (int i = 0; i < len; ++i) {
            int dr = r - (this.colorTab[i++] & 0xFF);
            int dg = g - (this.colorTab[i++] & 0xFF);
            int db = b - (this.colorTab[i] & 0xFF);
            int d = dr * dr + dg * dg + db * db;
            int index = i / 3;
            if (!this.usedEntry[index] || d >= dmin) continue;
            dmin = d;
            minpos = index;
        }
        return minpos;
    }

    boolean isColorUsed(Color c) {
        return this.findExact(c) != -1;
    }

    protected int findExact(Color c) {
        if (this.colorTab == null) {
            return -1;
        }
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int len = this.colorTab.length / 3;
        for (int index = 0; index < len; ++index) {
            int i = index * 3;
            if (!this.usedEntry[index] || r != (this.colorTab[i] & 0xFF) || g != (this.colorTab[i + 1] & 0xFF) || b != (this.colorTab[i + 2] & 0xFF)) continue;
            return index;
        }
        return -1;
    }

    protected void getImagePixels() {
        int w = this.image.getWidth();
        int h = this.image.getHeight();
        int type = this.image.getType();
        if (w != this.width || h != this.height || type != 5) {
            BufferedImage temp = new BufferedImage(this.width, this.height, 5);
            Graphics2D g = temp.createGraphics();
            g.setColor(this.background);
            g.fillRect(0, 0, this.width, this.height);
            g.drawImage((Image)this.image, 0, 0, null);
            this.image = temp;
        }
        this.pixels = ((DataBufferByte)this.image.getRaster().getDataBuffer()).getData();
    }

    protected void writeGraphicCtrlExt() throws IOException {
        int disp;
        int transp;
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        if (this.transparent == null) {
            transp = 0;
            disp = 0;
        } else {
            transp = 1;
            disp = 2;
        }
        if (this.dispose >= 0) {
            disp = this.dispose & 7;
        }
        this.out.write(0 | (disp <<= 2) | 0 | transp);
        this.writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }

    protected void writeImageDesc() throws IOException {
        this.out.write(44);
        this.writeShort(0);
        this.writeShort(0);
        this.writeShort(this.width);
        this.writeShort(this.height);
        if (this.firstFrame) {
            this.out.write(0);
        } else {
            this.out.write(0x80 | this.palSize);
        }
    }

    protected void writeLSD() throws IOException {
        this.writeShort(this.width);
        this.writeShort(this.height);
        this.out.write(0xF0 | this.palSize);
        this.out.write(0);
        this.out.write(0);
    }

    protected void writeNetscapeExt() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        this.writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        this.writeShort(this.repeat);
        this.out.write(0);
    }

    protected void writePalette() throws IOException {
        this.out.write(this.colorTab, 0, this.colorTab.length);
        int n = 768 - this.colorTab.length;
        for (int i = 0; i < n; ++i) {
            this.out.write(0);
        }
    }

    protected void writePixels() throws IOException {
        LZWEncoder encoder = new LZWEncoder(this.width, this.height, this.indexedPixels, this.colorDepth);
        encoder.encode(this.out);
    }

    protected void writeShort(int value) throws IOException {
        this.out.write(value & 0xFF);
        this.out.write(value >> 8 & 0xFF);
    }

    protected void writeString(String s) throws IOException {
        for (int i = 0; i < s.length(); ++i) {
            this.out.write((int)((byte)s.charAt(i)));
        }
    }
}

