/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Rsp;

public interface RspOrBuilder
extends MessageOrBuilder {
    public int getA();

    public int getB();

    public int getC();

    public String getD();

    public ByteString getDBytes();

    public int getE();

    public boolean hasF();

    public Rsp.F getF();

    public Rsp.FOrBuilder getFOrBuilder();

    public String getG();

    public ByteString getGBytes();

    public long getH();

    public long getI();

    public long getJ();
}

