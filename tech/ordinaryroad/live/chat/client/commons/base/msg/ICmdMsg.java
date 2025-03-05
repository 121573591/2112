/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.commons.base.msg;

import tech.ordinaryroad.live.chat.client.commons.base.msg.IMsg;

public interface ICmdMsg<CmdEnum extends Enum<CmdEnum>>
extends IMsg {
    public String getCmd();

    public void setCmd(String var1);

    public CmdEnum getCmdEnum();
}

