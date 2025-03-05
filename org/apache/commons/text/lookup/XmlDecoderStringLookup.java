/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package org.apache.commons.text.lookup;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.text.lookup.AbstractStringLookup;

final class XmlDecoderStringLookup
extends AbstractStringLookup {
    static final XmlDecoderStringLookup INSTANCE = new XmlDecoderStringLookup();

    private XmlDecoderStringLookup() {
    }

    @Override
    public String lookup(String key) {
        return StringEscapeUtils.unescapeXml(key);
    }
}

