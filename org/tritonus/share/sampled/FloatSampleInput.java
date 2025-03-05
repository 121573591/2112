/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tritonus.share.sampled;

import org.tritonus.share.sampled.FloatSampleBuffer;

public interface FloatSampleInput {
    public void read(FloatSampleBuffer var1);

    public void read(FloatSampleBuffer var1, int var2, int var3);

    public boolean isDone();

    public int getChannels();

    public float getSampleRate();
}

