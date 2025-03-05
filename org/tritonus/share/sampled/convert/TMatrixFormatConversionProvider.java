/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  javax.sound.sampled.AudioFormat
 *  javax.sound.sampled.AudioFormat$Encoding
 */
package org.tritonus.share.sampled.convert;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.sampled.AudioFormat;
import org.tritonus.share.ArraySet;
import org.tritonus.share.sampled.AudioFormats;
import org.tritonus.share.sampled.convert.TSimpleFormatConversionProvider;

public abstract class TMatrixFormatConversionProvider
extends TSimpleFormatConversionProvider {
    private Map m_targetEncodingsFromSourceFormat = new HashMap();
    private Map m_targetFormatsFromSourceFormat = new HashMap();

    protected TMatrixFormatConversionProvider(List sourceFormats, List targetFormats, boolean[][] abConversionPossible) {
        super((Collection<AudioFormat>)sourceFormats, (Collection<AudioFormat>)targetFormats);
        for (int nSourceFormat = 0; nSourceFormat < sourceFormats.size(); ++nSourceFormat) {
            AudioFormat sourceFormat = (AudioFormat)sourceFormats.get(nSourceFormat);
            ArraySet supportedTargetEncodings = new ArraySet();
            this.m_targetEncodingsFromSourceFormat.put((Object)sourceFormat, supportedTargetEncodings);
            HashMap targetFormatsFromTargetEncodings = new HashMap();
            this.m_targetFormatsFromSourceFormat.put((Object)sourceFormat, (Object)targetFormatsFromTargetEncodings);
            for (int nTargetFormat = 0; nTargetFormat < targetFormats.size(); ++nTargetFormat) {
                AudioFormat targetFormat = (AudioFormat)targetFormats.get(nTargetFormat);
                if (!abConversionPossible[nSourceFormat][nTargetFormat]) continue;
                AudioFormat.Encoding targetEncoding = targetFormat.getEncoding();
                supportedTargetEncodings.add(targetEncoding);
                Object supportedTargetFormats = (Collection)targetFormatsFromTargetEncodings.get((Object)targetEncoding);
                if (supportedTargetFormats == null) {
                    supportedTargetFormats = new ArraySet();
                    targetFormatsFromTargetEncodings.put((Object)targetEncoding, supportedTargetFormats);
                }
                supportedTargetFormats.add((Object)targetFormat);
            }
        }
    }

    public AudioFormat.Encoding[] getTargetEncodings(AudioFormat sourceFormat) {
        for (Map.Entry entry : this.m_targetEncodingsFromSourceFormat.entrySet()) {
            AudioFormat format = (AudioFormat)entry.getKey();
            if (!AudioFormats.matches(format, sourceFormat)) continue;
            Collection targetEncodings = (Collection)entry.getValue();
            return (AudioFormat.Encoding[])targetEncodings.toArray((Object[])EMPTY_ENCODING_ARRAY);
        }
        return EMPTY_ENCODING_ARRAY;
    }

    public AudioFormat[] getTargetFormats(AudioFormat.Encoding targetEncoding, AudioFormat sourceFormat) {
        for (Map.Entry entry : this.m_targetFormatsFromSourceFormat.entrySet()) {
            AudioFormat format = (AudioFormat)entry.getKey();
            if (!AudioFormats.matches(format, sourceFormat)) continue;
            Map targetEncodings = (Map)entry.getValue();
            Collection targetFormats = (Collection)targetEncodings.get((Object)targetEncoding);
            if (targetFormats != null) {
                return (AudioFormat[])targetFormats.toArray((Object[])EMPTY_FORMAT_ARRAY);
            }
            return EMPTY_FORMAT_ARRAY;
        }
        return EMPTY_FORMAT_ARRAY;
    }
}

