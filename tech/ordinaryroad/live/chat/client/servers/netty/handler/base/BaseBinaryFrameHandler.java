/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.SimpleChannelInboundHandler
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.function.Consumer
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package tech.ordinaryroad.live.chat.client.servers.netty.handler.base;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.List;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.ordinaryroad.live.chat.client.commons.base.listener.IBaseMsgListener;
import tech.ordinaryroad.live.chat.client.commons.base.msg.ICmdMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IMsg;

public abstract class BaseBinaryFrameHandler<T extends BaseBinaryFrameHandler<?, ?, ?, ?>, CmdEnum extends Enum<CmdEnum>, Msg extends IMsg, MsgListener extends IBaseMsgListener<T, CmdEnum>>
extends SimpleChannelInboundHandler<Msg>
implements IBaseMsgListener<T, CmdEnum> {
    private static final Logger log = LoggerFactory.getLogger(BaseBinaryFrameHandler.class);
    private final Object roomId;
    protected final List<MsgListener> msgListeners;

    public BaseBinaryFrameHandler(List<MsgListener> msgListeners, Object roomId) {
        this.msgListeners = msgListeners;
        this.roomId = roomId;
        if ((this.msgListeners == null || this.msgListeners.isEmpty()) && log.isDebugEnabled()) {
            log.debug("listener not set");
        }
    }

    protected void channelRead0(ChannelHandlerContext ctx, Msg msg) {
        this.onMsg((T)this, (IMsg)msg);
        if (msg instanceof ICmdMsg) {
            ICmdMsg cmdMsg = (ICmdMsg)msg;
            Object cmdEnum = cmdMsg.getCmdEnum();
            if (cmdEnum == null) {
                this.onUnknownCmd((T)this, cmdMsg.getCmd(), (IMsg)cmdMsg);
            } else {
                this.onCmdMsg(this, cmdEnum, cmdMsg);
            }
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause.getCause() instanceof UnrecognizedPropertyException) {
            log.error("缺少字段：{}", (Object)cause.getMessage());
        } else {
            super.exceptionCaught(ctx, cause);
        }
    }

    @Override
    public void onMsg(T t, IMsg msg) {
        IBaseMsgListener.super.onMsg(t, msg);
        this.iteratorMsgListeners(msgListener -> msgListener.onMsg(t, msg));
    }

    @Override
    public void onCmdMsg(T t, CmdEnum cmd, ICmdMsg<CmdEnum> cmdMsg) {
        IBaseMsgListener.super.onCmdMsg(t, cmd, cmdMsg);
        this.iteratorMsgListeners(msgListener -> msgListener.onCmdMsg(t, cmd, cmdMsg));
    }

    @Override
    public void onUnknownCmd(T t, String cmdString, IMsg msg) {
        IBaseMsgListener.super.onUnknownCmd(t, cmdString, msg);
        this.iteratorMsgListeners(msgListener -> msgListener.onUnknownCmd(t, cmdString, msg));
    }

    public void iteratorMsgListeners(Consumer<MsgListener> consumer) {
        if (this.msgListeners.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.msgListeners.size(); ++i) {
            consumer.accept((Object)((IBaseMsgListener)this.msgListeners.get(i)));
        }
    }

    public String getRoomIdAsString() {
        if (this.roomId == null) {
            return "";
        }
        return this.roomId.toString();
    }

    public long getRoomIdAsLong() {
        String roomIdAsString = this.getRoomIdAsString();
        if (roomIdAsString.trim().isEmpty()) {
            return 0L;
        }
        return Long.parseLong((String)roomIdAsString);
    }

    public Object getRoomId() {
        return this.roomId;
    }
}

