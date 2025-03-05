/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  javax.sound.sampled.AudioFormat
 *  javax.sound.sampled.SourceDataLine
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 *  org.slf4j.Logger
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaan;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDeviceBase;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;
import org.slf4j.Logger;

public class aaaaac
extends AudioDeviceBase {
    private static final Logger 我草你怎么反编译我模组aaaaaa;
    private SourceDataLine 我草你怎么反编译我模组aaaaab = null;
    private AudioFormat 我草你怎么反编译我模组aaaaac = null;
    private final float 我草你怎么反编译我模组aaaaad;
    private long 我草你怎么反编译我模组aaaaae = 0L;
    public static boolean $skidonion$512193837;

    public aaaaac(float f) {
        this.我草你怎么反编译我模组aaaaad = f;
    }

    @Override
    protected native void openImpl() throws JavaLayerException;

    @Override
    protected native void writeImpl(short[] var1, int var2, int var3) throws JavaLayerException;

    @Override
    protected native void flushImpl();

    @Override
    protected native void closeImpl();

    @Override
    public native int getPosition();

    private native byte[] 你为什么要破解我的代码aaaaaa(short[] var1, int var2, int var3);

    static {
        ___.___(210, aaaaac.class);
        ____.___210_70(aaaaac.class);
    }

    private static native Object aaaaab(char var0);
}

