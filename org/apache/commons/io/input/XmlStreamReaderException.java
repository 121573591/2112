/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package org.apache.commons.io.input;

import java.io.IOException;

public class XmlStreamReaderException
extends IOException {
    private static final long serialVersionUID = 1L;
    private final String bomEncoding;
    private final String xmlGuessEncoding;
    private final String xmlEncoding;
    private final String contentTypeMime;
    private final String contentTypeEncoding;

    public XmlStreamReaderException(String msg, String bomEnc, String xmlGuessEnc, String xmlEnc) {
        this(msg, null, null, bomEnc, xmlGuessEnc, xmlEnc);
    }

    public XmlStreamReaderException(String msg, String ctMime, String ctEnc, String bomEnc, String xmlGuessEnc, String xmlEnc) {
        super(msg);
        this.contentTypeMime = ctMime;
        this.contentTypeEncoding = ctEnc;
        this.bomEncoding = bomEnc;
        this.xmlGuessEncoding = xmlGuessEnc;
        this.xmlEncoding = xmlEnc;
    }

    public String getBomEncoding() {
        return this.bomEncoding;
    }

    public String getXmlGuessEncoding() {
        return this.xmlGuessEncoding;
    }

    public String getXmlEncoding() {
        return this.xmlEncoding;
    }

    public String getContentTypeMime() {
        return this.contentTypeMime;
    }

    public String getContentTypeEncoding() {
        return this.contentTypeEncoding;
    }
}

