/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.Collection
 *  javax.sound.sampled.AudioFormat
 *  javax.sound.sampled.AudioFormat$Encoding
 */
package org.tritonus.share.sampled.convert;

import java.util.Collection;
import javax.sound.sampled.AudioFormat;
import org.tritonus.share.ArraySet;
import org.tritonus.share.TDebug;
import org.tritonus.share.sampled.AudioFormats;
import org.tritonus.share.sampled.convert.TFormatConversionProvider;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class TSimpleFormatConversionProvider
extends TFormatConversionProvider {
    private Collection<AudioFormat.Encoding> m_sourceEncodings = new ArraySet();
    private Collection<AudioFormat.Encoding> m_targetEncodings = new ArraySet();
    private Collection<AudioFormat> m_sourceFormats;
    private Collection<AudioFormat> m_targetFormats;

    protected TSimpleFormatConversionProvider(Collection<AudioFormat> sourceFormats, Collection<AudioFormat> targetFormats) {
        if (sourceFormats == null) {
            sourceFormats = new ArraySet();
        }
        if (targetFormats == null) {
            targetFormats = new ArraySet();
        }
        this.m_sourceFormats = sourceFormats;
        this.m_targetFormats = targetFormats;
        TSimpleFormatConversionProvider.collectEncodings(this.m_sourceFormats, this.m_sourceEncodings);
        TSimpleFormatConversionProvider.collectEncodings(this.m_targetFormats, this.m_targetEncodings);
    }

    protected void disable() {
        if (TDebug.TraceAudioConverter) {
            TDebug.out("TSimpleFormatConversionProvider.disable(): disabling " + this.getClass().getName());
        }
        this.m_sourceEncodings = new ArraySet();
        this.m_targetEncodings = new ArraySet();
        this.m_sourceFormats = new ArraySet();
        this.m_targetFormats = new ArraySet();
    }

    private static void collectEncodings(Collection<AudioFormat> formats, Collection<AudioFormat.Encoding> encodings) {
        for (AudioFormat format : formats) {
            encodings.add((Object)format.getEncoding());
        }
    }

    public AudioFormat.Encoding[] getSourceEncodings() {
        return (AudioFormat.Encoding[])this.m_sourceEncodings.toArray((Object[])EMPTY_ENCODING_ARRAY);
    }

    public AudioFormat.Encoding[] getTargetEncodings() {
        return (AudioFormat.Encoding[])this.m_targetEncodings.toArray((Object[])EMPTY_ENCODING_ARRAY);
    }

    public boolean isSourceEncodingSupported(AudioFormat.Encoding sourceEncoding) {
        return this.m_sourceEncodings.contains((Object)sourceEncoding);
    }

    public boolean isTargetEncodingSupported(AudioFormat.Encoding targetEncoding) {
        return this.m_targetEncodings.contains((Object)targetEncoding);
    }

    public AudioFormat.Encoding[] getTargetEncodings(AudioFormat sourceFormat) {
        if (this.isAllowedSourceFormat(sourceFormat)) {
            return this.getTargetEncodings();
        }
        return EMPTY_ENCODING_ARRAY;
    }

    public AudioFormat[] getTargetFormats(AudioFormat.Encoding targetEncoding, AudioFormat sourceFormat) {
        if (this.isConversionSupported(targetEncoding, sourceFormat)) {
            return (AudioFormat[])this.m_targetFormats.toArray((Object[])EMPTY_FORMAT_ARRAY);
        }
        return EMPTY_FORMAT_ARRAY;
    }

    protected boolean isAllowedSourceEncoding(AudioFormat.Encoding sourceEncoding) {
        return this.m_sourceEncodings.contains((Object)sourceEncoding);
    }

    protected boolean isAllowedTargetEncoding(AudioFormat.Encoding targetEncoding) {
        return this.m_targetEncodings.contains((Object)targetEncoding);
    }

    protected boolean isAllowedSourceFormat(AudioFormat sourceFormat) {
        for (AudioFormat format : this.m_sourceFormats) {
            if (!AudioFormats.matches(format, sourceFormat)) continue;
            return true;
        }
        return false;
    }

    protected boolean isAllowedTargetFormat(AudioFormat targetFormat) {
        for (AudioFormat format : this.m_targetFormats) {
            if (!AudioFormats.matches(format, targetFormat)) continue;
            return true;
        }
        return false;
    }

    protected Collection<AudioFormat.Encoding> getCollectionSourceEncodings() {
        return this.m_sourceEncodings;
    }

    protected Collection<AudioFormat.Encoding> getCollectionTargetEncodings() {
        return this.m_targetEncodings;
    }

    protected Collection<AudioFormat> getCollectionSourceFormats() {
        return this.m_sourceFormats;
    }

    protected Collection<AudioFormat> getCollectionTargetFormats() {
        return this.m_targetFormats;
    }

    protected static boolean doMatch(int i1, int i2) {
        return i1 == -1 || i2 == -1 || i1 == i2;
    }

    protected static boolean doMatch(float f1, float f2) {
        return f1 == -1.0f || f2 == -1.0f || (double)Math.abs((float)(f1 - f2)) < 1.0E-9;
    }

    protected AudioFormat replaceNotSpecified(AudioFormat sourceFormat, AudioFormat targetFormat) {
        boolean bSetSampleSize = false;
        boolean bSetChannels = false;
        boolean bSetSampleRate = false;
        boolean bSetFrameRate = false;
        if (targetFormat.getSampleSizeInBits() == -1 && sourceFormat.getSampleSizeInBits() != -1) {
            bSetSampleSize = true;
        }
        if (targetFormat.getChannels() == -1 && sourceFormat.getChannels() != -1) {
            bSetChannels = true;
        }
        if (targetFormat.getSampleRate() == -1.0f && sourceFormat.getSampleRate() != -1.0f) {
            bSetSampleRate = true;
        }
        if (targetFormat.getFrameRate() == -1.0f && sourceFormat.getFrameRate() != -1.0f) {
            bSetFrameRate = true;
        }
        if (bSetSampleSize || bSetChannels || bSetSampleRate || bSetFrameRate || targetFormat.getFrameSize() == -1 && sourceFormat.getFrameSize() != -1) {
            float sampleRate = bSetSampleRate ? sourceFormat.getSampleRate() : targetFormat.getSampleRate();
            float frameRate = bSetFrameRate ? sourceFormat.getFrameRate() : targetFormat.getFrameRate();
            int sampleSize = bSetSampleSize ? sourceFormat.getSampleSizeInBits() : targetFormat.getSampleSizeInBits();
            int channels = bSetChannels ? sourceFormat.getChannels() : targetFormat.getChannels();
            int frameSize = this.getFrameSize(targetFormat.getEncoding(), sampleRate, sampleSize, channels, frameRate, targetFormat.isBigEndian(), targetFormat.getFrameSize());
            targetFormat = new AudioFormat(targetFormat.getEncoding(), sampleRate, sampleSize, channels, frameSize, frameRate, targetFormat.isBigEndian());
        }
        return targetFormat;
    }

    protected int getFrameSize(AudioFormat.Encoding encoding, float sampleRate, int sampleSize, int channels, float frameRate, boolean bigEndian, int oldFrameSize) {
        if (sampleSize == -1 || channels == -1) {
            return -1;
        }
        return (sampleSize + 7) / 8 * channels;
    }
}

