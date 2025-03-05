/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Collection
 *  javax.sound.sampled.AudioFormat
 *  javax.sound.sampled.AudioFormat$Encoding
 */
package org.tritonus.share.sampled.convert;

import java.util.Collection;
import javax.sound.sampled.AudioFormat;
import org.tritonus.share.ArraySet;
import org.tritonus.share.TDebug;
import org.tritonus.share.sampled.convert.TSimpleFormatConversionProvider;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class TEncodingFormatConversionProvider
extends TSimpleFormatConversionProvider {
    protected TEncodingFormatConversionProvider(Collection<AudioFormat> sourceFormats, Collection<AudioFormat> targetFormats) {
        super(sourceFormats, targetFormats);
    }

    @Override
    public AudioFormat[] getTargetFormats(AudioFormat.Encoding targetEncoding, AudioFormat sourceFormat) {
        if (TDebug.TraceAudioConverter) {
            TDebug.out(">TEncodingFormatConversionProvider.getTargetFormats(AudioFormat.Encoding, AudioFormat):");
            TDebug.out("checking if conversion possible");
            TDebug.out("from: " + sourceFormat);
            TDebug.out("to: " + targetEncoding);
        }
        if (this.isConversionSupported(targetEncoding, sourceFormat)) {
            ArraySet result = new ArraySet();
            for (AudioFormat targetFormat : this.getCollectionTargetFormats()) {
                targetFormat = this.replaceNotSpecified(sourceFormat, targetFormat);
                result.add(targetFormat);
            }
            if (TDebug.TraceAudioConverter) {
                TDebug.out("< returning " + result.size() + " elements.");
            }
            return (AudioFormat[])result.toArray(EMPTY_FORMAT_ARRAY);
        }
        if (TDebug.TraceAudioConverter) {
            TDebug.out("< returning empty array.");
        }
        return EMPTY_FORMAT_ARRAY;
    }
}

