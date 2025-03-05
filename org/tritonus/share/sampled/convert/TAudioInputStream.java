/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  javax.sound.sampled.AudioFormat
 *  javax.sound.sampled.AudioInputStream
 */
package org.tritonus.share.sampled.convert;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TAudioInputStream
extends AudioInputStream {
    private Map<String, Object> m_properties;
    private Map<String, Object> m_unmodifiableProperties;

    public TAudioInputStream(InputStream inputStream2, AudioFormat audioFormat, long lLengthInFrames) {
        super(inputStream2, audioFormat, lLengthInFrames);
        this.initMaps((Map<String, Object>)new HashMap());
    }

    public TAudioInputStream(InputStream inputStream2, AudioFormat audioFormat, long lLengthInFrames, Map<String, Object> properties) {
        super(inputStream2, audioFormat, lLengthInFrames);
        this.initMaps(properties);
    }

    private void initMaps(Map<String, Object> properties) {
        this.m_properties = properties;
        this.m_unmodifiableProperties = Collections.unmodifiableMap(this.m_properties);
    }

    public Map<String, Object> properties() {
        return this.m_unmodifiableProperties;
    }

    protected void setProperty(String key, Object value) {
        this.m_properties.put((Object)key, value);
    }
}

