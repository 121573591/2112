/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package javazoom.spi.mpeg.sampled.file.tag;

import javazoom.spi.mpeg.sampled.file.tag.MP3Tag;
import javazoom.spi.mpeg.sampled.file.tag.TagParseListener;

public interface MP3MetadataParser {
    public void addTagParseListener(TagParseListener var1);

    public void removeTagParseListener(TagParseListener var1);

    public MP3Tag[] getTags();
}

