/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.handler.codec.DecoderResult
 *  io.netty.handler.codec.DecoderResultProvider
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;

public interface HttpObject
extends DecoderResultProvider {
    @Deprecated
    public DecoderResult getDecoderResult();
}

