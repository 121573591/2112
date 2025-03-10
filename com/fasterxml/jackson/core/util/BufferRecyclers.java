/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.ThreadLocal
 *  java.lang.ref.SoftReference
 */
package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ThreadLocalBufferManager;
import java.lang.ref.SoftReference;

@Deprecated
public class BufferRecyclers {
    public static final String SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS = "com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers";
    private static final ThreadLocalBufferManager _bufferRecyclerTracker;
    protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef;

    @Deprecated
    public static BufferRecycler getBufferRecycler() {
        BufferRecycler br;
        SoftReference ref = (SoftReference)_recyclerRef.get();
        BufferRecycler bufferRecycler = br = ref == null ? null : (BufferRecycler)ref.get();
        if (br == null) {
            br = new BufferRecycler();
            ref = _bufferRecyclerTracker != null ? _bufferRecyclerTracker.wrapAndTrack(br) : new SoftReference((Object)br);
            _recyclerRef.set((Object)ref);
        }
        return br;
    }

    public static int releaseBuffers() {
        if (_bufferRecyclerTracker != null) {
            return _bufferRecyclerTracker.releaseBuffers();
        }
        return -1;
    }

    @Deprecated
    public static JsonStringEncoder getJsonStringEncoder() {
        return JsonStringEncoder.getInstance();
    }

    @Deprecated
    public static byte[] encodeAsUTF8(String text) {
        return JsonStringEncoder.getInstance().encodeAsUTF8(text);
    }

    @Deprecated
    public static char[] quoteAsJsonText(String rawText) {
        return JsonStringEncoder.getInstance().quoteAsString(rawText);
    }

    @Deprecated
    public static void quoteAsJsonText(CharSequence input, StringBuilder output) {
        JsonStringEncoder.getInstance().quoteAsString(input, output);
    }

    @Deprecated
    public static byte[] quoteAsJsonUTF8(String rawText) {
        return JsonStringEncoder.getInstance().quoteAsUTF8(rawText);
    }

    static {
        boolean trackReusableBuffers = false;
        try {
            trackReusableBuffers = "true".equals((Object)System.getProperty((String)SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS));
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        _bufferRecyclerTracker = trackReusableBuffers ? ThreadLocalBufferManager.instance() : null;
        _recyclerRef = new ThreadLocal();
    }
}

