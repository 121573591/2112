/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.commons.base.listener;

public interface IGiftMsgListener<T, GiftMsg> {
    default public void onGiftMsg(T t, GiftMsg msg) {
        this.onGiftMsg(msg);
    }

    default public void onGiftMsg(GiftMsg msg) {
    }
}

