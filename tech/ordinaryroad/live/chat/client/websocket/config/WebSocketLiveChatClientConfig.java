/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.websocket.config;

import tech.ordinaryroad.live.chat.client.servers.netty.client.config.BaseNettyClientConfig;

public class WebSocketLiveChatClientConfig
extends BaseNettyClientConfig {
    protected WebSocketLiveChatClientConfig(WebSocketLiveChatClientConfigBuilder<?, ?> b) {
        super((BaseNettyClientConfig.BaseNettyClientConfigBuilder<?, ?>)b);
    }

    public static WebSocketLiveChatClientConfigBuilder<?, ?> builder() {
        return new WebSocketLiveChatClientConfigBuilderImpl();
    }

    public WebSocketLiveChatClientConfigBuilder<?, ?> toBuilder() {
        return new WebSocketLiveChatClientConfigBuilderImpl().$fillValuesFrom(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WebSocketLiveChatClientConfig)) {
            return false;
        }
        WebSocketLiveChatClientConfig other = (WebSocketLiveChatClientConfig)o;
        return other.canEqual(this);
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof WebSocketLiveChatClientConfig;
    }

    @Override
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Override
    public String toString() {
        return "WebSocketLiveChatClientConfig()";
    }

    private static final class WebSocketLiveChatClientConfigBuilderImpl
    extends WebSocketLiveChatClientConfigBuilder<WebSocketLiveChatClientConfig, WebSocketLiveChatClientConfigBuilderImpl> {
        private WebSocketLiveChatClientConfigBuilderImpl() {
        }

        @Override
        protected WebSocketLiveChatClientConfigBuilderImpl self() {
            return this;
        }

        @Override
        public WebSocketLiveChatClientConfig build() {
            return new WebSocketLiveChatClientConfig(this);
        }
    }

    public static abstract class WebSocketLiveChatClientConfigBuilder<C extends WebSocketLiveChatClientConfig, B extends WebSocketLiveChatClientConfigBuilder<C, B>>
    extends BaseNettyClientConfig.BaseNettyClientConfigBuilder<C, B> {
        @Override
        protected B $fillValuesFrom(C instance) {
            super.$fillValuesFrom(instance);
            WebSocketLiveChatClientConfigBuilder.$fillValuesFromInstanceIntoBuilder(instance, this);
            return (B)this.self();
        }

        private static void $fillValuesFromInstanceIntoBuilder(WebSocketLiveChatClientConfig instance, WebSocketLiveChatClientConfigBuilder<?, ?> b) {
        }

        @Override
        protected abstract B self();

        @Override
        public abstract C build();

        @Override
        public String toString() {
            return "WebSocketLiveChatClientConfig.WebSocketLiveChatClientConfigBuilder(super=" + super.toString() + ")";
        }
    }
}

