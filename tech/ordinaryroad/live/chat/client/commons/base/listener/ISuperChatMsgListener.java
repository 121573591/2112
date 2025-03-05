/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.commons.base.listener;

public interface ISuperChatMsgListener<T, SuperChatMsg> {
    default public void onSuperChatMsg(T t, SuperChatMsg msg) {
        this.onSuperChatMsg(msg);
    }

    default public void onSuperChatMsg(SuperChatMsg msg) {
    }
}

