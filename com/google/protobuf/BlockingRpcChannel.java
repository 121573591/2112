/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;

public interface BlockingRpcChannel {
    public Message callBlockingMethod(Descriptors.MethodDescriptor var1, RpcController var2, Message var3, Message var4) throws ServiceException;
}

