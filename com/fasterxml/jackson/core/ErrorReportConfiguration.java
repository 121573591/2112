/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.fasterxml.jackson.core;

import java.io.Serializable;

public class ErrorReportConfiguration
implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int DEFAULT_MAX_ERROR_TOKEN_LENGTH = 256;
    public static final int DEFAULT_MAX_RAW_CONTENT_LENGTH = 500;
    protected final int _maxErrorTokenLength;
    protected final int _maxRawContentLength;
    private static ErrorReportConfiguration DEFAULT = new ErrorReportConfiguration(256, 500);

    public static void overrideDefaultErrorReportConfiguration(ErrorReportConfiguration errorReportConfiguration) {
        DEFAULT = errorReportConfiguration == null ? new ErrorReportConfiguration(256, 500) : errorReportConfiguration;
    }

    protected ErrorReportConfiguration(int maxErrorTokenLength, int maxRawContentLength) {
        this._maxErrorTokenLength = maxErrorTokenLength;
        this._maxRawContentLength = maxRawContentLength;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ErrorReportConfiguration defaults() {
        return DEFAULT;
    }

    public Builder rebuild() {
        return new Builder(this);
    }

    public int getMaxErrorTokenLength() {
        return this._maxErrorTokenLength;
    }

    public int getMaxRawContentLength() {
        return this._maxRawContentLength;
    }

    static void validateMaxErrorTokenLength(int maxErrorTokenLength) throws IllegalArgumentException {
        if (maxErrorTokenLength < 0) {
            throw new IllegalArgumentException(String.format((String)"Value of maxErrorTokenLength (%d) cannot be negative", (Object[])new Object[]{maxErrorTokenLength}));
        }
    }

    static void validateMaxRawContentLength(int maxRawContentLength) {
        if (maxRawContentLength < 0) {
            throw new IllegalArgumentException(String.format((String)"Value of maxRawContentLength (%d) cannot be negative", (Object[])new Object[]{maxRawContentLength}));
        }
    }

    public static final class Builder {
        private int maxErrorTokenLength;
        private int maxRawContentLength;

        public Builder maxErrorTokenLength(int maxErrorTokenLength) {
            ErrorReportConfiguration.validateMaxErrorTokenLength(maxErrorTokenLength);
            this.maxErrorTokenLength = maxErrorTokenLength;
            return this;
        }

        public Builder maxRawContentLength(int maxRawContentLength) {
            ErrorReportConfiguration.validateMaxRawContentLength(maxRawContentLength);
            this.maxRawContentLength = maxRawContentLength;
            return this;
        }

        Builder() {
            this(256, 500);
        }

        Builder(int maxErrorTokenLength, int maxRawContentLength) {
            this.maxErrorTokenLength = maxErrorTokenLength;
            this.maxRawContentLength = maxRawContentLength;
        }

        Builder(ErrorReportConfiguration src) {
            this.maxErrorTokenLength = src._maxErrorTokenLength;
            this.maxRawContentLength = src._maxRawContentLength;
        }

        public ErrorReportConfiguration build() {
            return new ErrorReportConfiguration(this.maxErrorTokenLength, this.maxRawContentLength);
        }
    }
}

