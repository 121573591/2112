/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.bilibili.config;

import tech.ordinaryroad.live.chat.client.codec.bilibili.constant.ProtoverEnum;
import tech.ordinaryroad.live.chat.client.commons.util.OrLiveChatNumberUtil;
import tech.ordinaryroad.live.chat.client.servers.netty.client.config.BaseNettyClientConfig;

public class BilibiliLiveChatClientConfig
extends BaseNettyClientConfig {
    private ProtoverEnum protover;

    public Long getRoomId() {
        return OrLiveChatNumberUtil.parseLong(super.getRoomId());
    }

    public void setProtover(ProtoverEnum protover) {
        ProtoverEnum oldValue = this.protover;
        this.protover = protover;
        this.propertyChangeSupport.firePropertyChange("protover", (Object)oldValue, (Object)protover);
    }

    private static ProtoverEnum $default$protover() {
        return ProtoverEnum.NORMAL_BROTLI;
    }

    protected BilibiliLiveChatClientConfig(BilibiliLiveChatClientConfigBuilder<?, ?> b) {
        super((BaseNettyClientConfig.BaseNettyClientConfigBuilder<?, ?>)b);
        this.protover = ((BilibiliLiveChatClientConfigBuilder)b).protover$set ? ((BilibiliLiveChatClientConfigBuilder)b).protover$value : BilibiliLiveChatClientConfig.$default$protover();
    }

    public static BilibiliLiveChatClientConfigBuilder<?, ?> builder() {
        return new BilibiliLiveChatClientConfigBuilderImpl();
    }

    public BilibiliLiveChatClientConfigBuilder<?, ?> toBuilder() {
        return new BilibiliLiveChatClientConfigBuilderImpl().$fillValuesFrom(this);
    }

    public ProtoverEnum getProtover() {
        return this.protover;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BilibiliLiveChatClientConfig)) {
            return false;
        }
        BilibiliLiveChatClientConfig other = (BilibiliLiveChatClientConfig)o;
        if (!other.canEqual(this)) {
            return false;
        }
        ProtoverEnum this$protover = this.getProtover();
        ProtoverEnum other$protover = other.getProtover();
        return !(this$protover == null ? other$protover != null : !this$protover.equals((Object)other$protover));
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof BilibiliLiveChatClientConfig;
    }

    @Override
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        ProtoverEnum $protover = this.getProtover();
        result = result * 59 + ($protover == null ? 43 : $protover.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BilibiliLiveChatClientConfig(protover=" + (Object)((Object)this.getProtover()) + ")";
    }

    public BilibiliLiveChatClientConfig() {
        this.protover = BilibiliLiveChatClientConfig.$default$protover();
    }

    public BilibiliLiveChatClientConfig(ProtoverEnum protover) {
        this.protover = protover;
    }

    public static abstract class BilibiliLiveChatClientConfigBuilder<C extends BilibiliLiveChatClientConfig, B extends BilibiliLiveChatClientConfigBuilder<C, B>>
    extends BaseNettyClientConfig.BaseNettyClientConfigBuilder<C, B> {
        private boolean protover$set;
        private ProtoverEnum protover$value;

        @Override
        protected B $fillValuesFrom(C instance) {
            super.$fillValuesFrom(instance);
            BilibiliLiveChatClientConfigBuilder.$fillValuesFromInstanceIntoBuilder(instance, this);
            return (B)this.self();
        }

        private static void $fillValuesFromInstanceIntoBuilder(BilibiliLiveChatClientConfig instance, BilibiliLiveChatClientConfigBuilder<?, ?> b) {
            b.protover(instance.protover);
        }

        public B protover(ProtoverEnum protover) {
            this.protover$value = protover;
            this.protover$set = true;
            return (B)this.self();
        }

        @Override
        protected abstract B self();

        @Override
        public abstract C build();

        @Override
        public String toString() {
            return "BilibiliLiveChatClientConfig.BilibiliLiveChatClientConfigBuilder(super=" + super.toString() + ", protover$value=" + (Object)((Object)this.protover$value) + ")";
        }
    }

    private static final class BilibiliLiveChatClientConfigBuilderImpl
    extends BilibiliLiveChatClientConfigBuilder<BilibiliLiveChatClientConfig, BilibiliLiveChatClientConfigBuilderImpl> {
        private BilibiliLiveChatClientConfigBuilderImpl() {
        }

        @Override
        protected BilibiliLiveChatClientConfigBuilderImpl self() {
            return this;
        }

        @Override
        public BilibiliLiveChatClientConfig build() {
            return new BilibiliLiveChatClientConfig(this);
        }
    }
}

