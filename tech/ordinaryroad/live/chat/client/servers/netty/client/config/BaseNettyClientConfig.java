/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.servers.netty.client.config;

import tech.ordinaryroad.live.chat.client.commons.client.config.BaseLiveChatClientConfig;

public abstract class BaseNettyClientConfig
extends BaseLiveChatClientConfig {
    private int aggregatorMaxContentLength;
    private int maxFramePayloadLength;

    private static int $default$aggregatorMaxContentLength() {
        return 65536;
    }

    private static int $default$maxFramePayloadLength() {
        return 65536;
    }

    protected BaseNettyClientConfig(BaseNettyClientConfigBuilder<?, ?> b) {
        super(b);
        this.aggregatorMaxContentLength = ((BaseNettyClientConfigBuilder)b).aggregatorMaxContentLength$set ? ((BaseNettyClientConfigBuilder)b).aggregatorMaxContentLength$value : BaseNettyClientConfig.$default$aggregatorMaxContentLength();
        this.maxFramePayloadLength = ((BaseNettyClientConfigBuilder)b).maxFramePayloadLength$set ? ((BaseNettyClientConfigBuilder)b).maxFramePayloadLength$value : BaseNettyClientConfig.$default$maxFramePayloadLength();
    }

    public int getAggregatorMaxContentLength() {
        return this.aggregatorMaxContentLength;
    }

    public int getMaxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public void setAggregatorMaxContentLength(int aggregatorMaxContentLength) {
        this.aggregatorMaxContentLength = aggregatorMaxContentLength;
    }

    public void setMaxFramePayloadLength(int maxFramePayloadLength) {
        this.maxFramePayloadLength = maxFramePayloadLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseNettyClientConfig)) {
            return false;
        }
        BaseNettyClientConfig other = (BaseNettyClientConfig)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getAggregatorMaxContentLength() != other.getAggregatorMaxContentLength()) {
            return false;
        }
        return this.getMaxFramePayloadLength() == other.getMaxFramePayloadLength();
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof BaseNettyClientConfig;
    }

    @Override
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getAggregatorMaxContentLength();
        result = result * 59 + this.getMaxFramePayloadLength();
        return result;
    }

    @Override
    public String toString() {
        return "BaseNettyClientConfig(aggregatorMaxContentLength=" + this.getAggregatorMaxContentLength() + ", maxFramePayloadLength=" + this.getMaxFramePayloadLength() + ")";
    }

    public BaseNettyClientConfig() {
        this.aggregatorMaxContentLength = BaseNettyClientConfig.$default$aggregatorMaxContentLength();
        this.maxFramePayloadLength = BaseNettyClientConfig.$default$maxFramePayloadLength();
    }

    public BaseNettyClientConfig(int aggregatorMaxContentLength, int maxFramePayloadLength) {
        this.aggregatorMaxContentLength = aggregatorMaxContentLength;
        this.maxFramePayloadLength = maxFramePayloadLength;
    }

    public static abstract class BaseNettyClientConfigBuilder<C extends BaseNettyClientConfig, B extends BaseNettyClientConfigBuilder<C, B>>
    extends BaseLiveChatClientConfig.BaseLiveChatClientConfigBuilder<C, B> {
        private boolean aggregatorMaxContentLength$set;
        private int aggregatorMaxContentLength$value;
        private boolean maxFramePayloadLength$set;
        private int maxFramePayloadLength$value;

        @Override
        protected B $fillValuesFrom(C instance) {
            super.$fillValuesFrom(instance);
            BaseNettyClientConfigBuilder.$fillValuesFromInstanceIntoBuilder(instance, this);
            return (B)this.self();
        }

        private static void $fillValuesFromInstanceIntoBuilder(BaseNettyClientConfig instance, BaseNettyClientConfigBuilder<?, ?> b) {
            b.aggregatorMaxContentLength(instance.aggregatorMaxContentLength);
            b.maxFramePayloadLength(instance.maxFramePayloadLength);
        }

        public B aggregatorMaxContentLength(int aggregatorMaxContentLength) {
            this.aggregatorMaxContentLength$value = aggregatorMaxContentLength;
            this.aggregatorMaxContentLength$set = true;
            return (B)this.self();
        }

        public B maxFramePayloadLength(int maxFramePayloadLength) {
            this.maxFramePayloadLength$value = maxFramePayloadLength;
            this.maxFramePayloadLength$set = true;
            return (B)this.self();
        }

        @Override
        protected abstract B self();

        @Override
        public abstract C build();

        @Override
        public String toString() {
            return "BaseNettyClientConfig.BaseNettyClientConfigBuilder(super=" + super.toString() + ", aggregatorMaxContentLength$value=" + this.aggregatorMaxContentLength$value + ", maxFramePayloadLength$value=" + this.maxFramePayloadLength$value + ")";
        }
    }
}

