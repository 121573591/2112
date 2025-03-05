/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Font
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  org.apache.poi.openxml4j.exceptions.InvalidFormatException
 *  org.apache.poi.util.Units
 *  org.apache.poi.xwpf.usermodel.ParagraphAlignment
 *  org.apache.poi.xwpf.usermodel.XWPFDocument
 *  org.apache.poi.xwpf.usermodel.XWPFParagraph
 *  org.apache.poi.xwpf.usermodel.XWPFRun
 */
package cn.hutool.poi.word;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.poi.exceptions.POIException;
import cn.hutool.poi.word.DocUtil;
import cn.hutool.poi.word.PicType;
import cn.hutool.poi.word.TableUtil;
import java.awt.Font;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Word07Writer
implements Closeable {
    private final XWPFDocument doc;
    protected File destFile;
    protected boolean isClosed;

    public Word07Writer() {
        this(new XWPFDocument());
    }

    public Word07Writer(File destFile) {
        this(DocUtil.create(destFile), destFile);
    }

    public Word07Writer(XWPFDocument doc) {
        this(doc, null);
    }

    public Word07Writer(XWPFDocument doc, File destFile) {
        this.doc = doc;
        this.destFile = destFile;
    }

    public XWPFDocument getDoc() {
        return this.doc;
    }

    public Word07Writer setDestFile(File destFile) {
        this.destFile = destFile;
        return this;
    }

    public Word07Writer addText(Font font, String ... texts) {
        return this.addText(null, font, texts);
    }

    public Word07Writer addText(ParagraphAlignment align, Font font, String ... texts) {
        XWPFParagraph p = this.doc.createParagraph();
        if (null != align) {
            p.setAlignment(align);
        }
        if (ArrayUtil.isNotEmpty(texts)) {
            for (String text : texts) {
                XWPFRun run = p.createRun();
                run.setText(text);
                if (null == font) continue;
                run.setFontFamily(font.getFamily());
                run.setFontSize(font.getSize());
                run.setBold(font.isBold());
                run.setItalic(font.isItalic());
            }
        }
        return this;
    }

    public Word07Writer addTable(Iterable<?> data) {
        TableUtil.createTable(this.doc, data);
        return this;
    }

    public Word07Writer addPicture(File picFile, int width, int height) {
        PicType picType;
        String fileName = picFile.getName();
        String extName = FileUtil.extName(fileName).toUpperCase();
        try {
            picType = PicType.valueOf(extName);
        }
        catch (IllegalArgumentException e) {
            picType = PicType.JPEG;
        }
        return this.addPicture((InputStream)FileUtil.getInputStream(picFile), picType, fileName, width, height);
    }

    public Word07Writer addPicture(InputStream in, PicType picType, String fileName, int width, int height) {
        return this.addPicture(in, picType, fileName, width, height, ParagraphAlignment.CENTER);
    }

    public Word07Writer addPicture(InputStream in, PicType picType, String fileName, int width, int height, ParagraphAlignment align) {
        XWPFParagraph paragraph = this.doc.createParagraph();
        paragraph.setAlignment(align);
        XWPFRun run = paragraph.createRun();
        try {
            run.addPicture(in, picType.getValue(), fileName, Units.toEMU((double)width), Units.toEMU((double)height));
        }
        catch (InvalidFormatException e) {
            throw new POIException(e);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        finally {
            IoUtil.close((Closeable)in);
        }
        return this;
    }

    public Word07Writer flush() throws IORuntimeException {
        return this.flush(this.destFile);
    }

    public Word07Writer flush(File destFile) throws IORuntimeException {
        Assert.notNull(destFile, "[destFile] is null, and you must call setDestFile(File) first or call flush(OutputStream).", new Object[0]);
        return this.flush((OutputStream)FileUtil.getOutputStream(destFile), true);
    }

    public Word07Writer flush(OutputStream out) throws IORuntimeException {
        return this.flush(out, false);
    }

    public Word07Writer flush(OutputStream out, boolean isCloseOut) throws IORuntimeException {
        Assert.isFalse(this.isClosed, "WordWriter has been closed!", new Object[0]);
        try {
            this.doc.write(out);
            out.flush();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        finally {
            if (isCloseOut) {
                IoUtil.close((Closeable)out);
            }
        }
        return this;
    }

    public void close() {
        if (null != this.destFile) {
            this.flush();
        }
        this.closeWithoutFlush();
    }

    protected void closeWithoutFlush() {
        IoUtil.close((Closeable)this.doc);
        this.isClosed = true;
    }
}

