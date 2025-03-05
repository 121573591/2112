/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.util.List
 *  javax.script.ScriptEngine
 */
package tech.ordinaryroad.live.chat.client.douyin.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.system.JavaInfo;
import java.lang.reflect.Method;
import java.util.List;
import javax.script.ScriptEngine;
import tech.ordinaryroad.live.chat.client.codec.douyin.constant.DouyinGiftCountCalculationTimeEnum;
import tech.ordinaryroad.live.chat.client.commons.util.OrLiveChatHttpUtil;
import tech.ordinaryroad.live.chat.client.servers.netty.client.config.BaseNettyClientConfig;

public class DouyinLiveChatClientConfig
extends BaseNettyClientConfig {
    private static final ScriptEngine DEFAULT_ENGINE = DouyinLiveChatClientConfig.createScriptEngine();
    public static final List<String> WEB_SOCKET_URIS = CollUtil.newArrayList("wss://webcast5-ws-web-lq.douyin.com/webcast/im/push/v2/", "wss://webcast5-ws-web-lf.douyin.com/webcast/im/push/v2/", "wss://webcast5-ws-web-hl.douyin.com/webcast/im/push/v2/");
    private long heartbeatInitialDelay;
    private long heartbeatPeriod;
    private int aggregatorMaxContentLength;
    private int maxFramePayloadLength;
    private String versionCode;
    private String webcastSdkVersion;
    private String updateVersionCode;
    private String userAgent;
    private ScriptEngine scriptEngine;
    private DouyinGiftCountCalculationTimeEnum giftCountCalculationTime;

    public String getBrowserVersion() {
        return StrUtil.removePrefix(this.getUserAgent(), "Mozilla/");
    }

    public static ScriptEngine createScriptEngine() {
        JavaInfo javaInfo = new JavaInfo();
        Class nashornScriptEngineFactoryClass = javaInfo.getVersionFloat() >= 11.0f ? Class.forName((String)"org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory") : Class.forName((String)"jdk.nashorn.api.scripting.NashornScriptEngineFactory");
        Object factory2 = nashornScriptEngineFactoryClass.getConstructor(new Class[0]).newInstance(new Object[0]);
        Method getScriptEngine = nashornScriptEngineFactoryClass.getDeclaredMethod("getScriptEngine", new Class[]{String[].class});
        return (ScriptEngine)getScriptEngine.invoke(factory2, new Object[]{new String[]{"--language=es6"}});
    }

    private static long $default$heartbeatInitialDelay() {
        return 5L;
    }

    private static long $default$heartbeatPeriod() {
        return 10L;
    }

    private static int $default$aggregatorMaxContentLength() {
        return 0x4000000;
    }

    private static int $default$maxFramePayloadLength() {
        return 0x4000000;
    }

    private static String $default$versionCode() {
        return "180800";
    }

    private static String $default$webcastSdkVersion() {
        return "1.0.14-beta.0";
    }

    private static String $default$updateVersionCode() {
        return "1.0.14-beta.0";
    }

    private static String $default$userAgent() {
        return OrLiveChatHttpUtil.USER_AGENT;
    }

    private static ScriptEngine $default$scriptEngine() {
        return DEFAULT_ENGINE;
    }

    private static DouyinGiftCountCalculationTimeEnum $default$giftCountCalculationTime() {
        return DouyinGiftCountCalculationTimeEnum.IMMEDIATELY;
    }

    protected DouyinLiveChatClientConfig(DouyinLiveChatClientConfigBuilder<?, ?> b) {
        super((BaseNettyClientConfig.BaseNettyClientConfigBuilder<?, ?>)b);
        this.heartbeatInitialDelay = ((DouyinLiveChatClientConfigBuilder)b).heartbeatInitialDelay$set ? ((DouyinLiveChatClientConfigBuilder)b).heartbeatInitialDelay$value : DouyinLiveChatClientConfig.$default$heartbeatInitialDelay();
        this.heartbeatPeriod = ((DouyinLiveChatClientConfigBuilder)b).heartbeatPeriod$set ? ((DouyinLiveChatClientConfigBuilder)b).heartbeatPeriod$value : DouyinLiveChatClientConfig.$default$heartbeatPeriod();
        this.aggregatorMaxContentLength = ((DouyinLiveChatClientConfigBuilder)b).aggregatorMaxContentLength$set ? ((DouyinLiveChatClientConfigBuilder)b).aggregatorMaxContentLength$value : DouyinLiveChatClientConfig.$default$aggregatorMaxContentLength();
        this.maxFramePayloadLength = ((DouyinLiveChatClientConfigBuilder)b).maxFramePayloadLength$set ? ((DouyinLiveChatClientConfigBuilder)b).maxFramePayloadLength$value : DouyinLiveChatClientConfig.$default$maxFramePayloadLength();
        this.versionCode = ((DouyinLiveChatClientConfigBuilder)b).versionCode$set ? ((DouyinLiveChatClientConfigBuilder)b).versionCode$value : DouyinLiveChatClientConfig.$default$versionCode();
        this.webcastSdkVersion = ((DouyinLiveChatClientConfigBuilder)b).webcastSdkVersion$set ? ((DouyinLiveChatClientConfigBuilder)b).webcastSdkVersion$value : DouyinLiveChatClientConfig.$default$webcastSdkVersion();
        this.updateVersionCode = ((DouyinLiveChatClientConfigBuilder)b).updateVersionCode$set ? ((DouyinLiveChatClientConfigBuilder)b).updateVersionCode$value : DouyinLiveChatClientConfig.$default$updateVersionCode();
        this.userAgent = ((DouyinLiveChatClientConfigBuilder)b).userAgent$set ? ((DouyinLiveChatClientConfigBuilder)b).userAgent$value : DouyinLiveChatClientConfig.$default$userAgent();
        this.scriptEngine = ((DouyinLiveChatClientConfigBuilder)b).scriptEngine$set ? ((DouyinLiveChatClientConfigBuilder)b).scriptEngine$value : DouyinLiveChatClientConfig.$default$scriptEngine();
        this.giftCountCalculationTime = ((DouyinLiveChatClientConfigBuilder)b).giftCountCalculationTime$set ? ((DouyinLiveChatClientConfigBuilder)b).giftCountCalculationTime$value : DouyinLiveChatClientConfig.$default$giftCountCalculationTime();
    }

    public static DouyinLiveChatClientConfigBuilder<?, ?> builder() {
        return new DouyinLiveChatClientConfigBuilderImpl();
    }

    public DouyinLiveChatClientConfigBuilder<?, ?> toBuilder() {
        return new DouyinLiveChatClientConfigBuilderImpl().$fillValuesFrom(this);
    }

    @Override
    public long getHeartbeatInitialDelay() {
        return this.heartbeatInitialDelay;
    }

    @Override
    public long getHeartbeatPeriod() {
        return this.heartbeatPeriod;
    }

    @Override
    public int getAggregatorMaxContentLength() {
        return this.aggregatorMaxContentLength;
    }

    @Override
    public int getMaxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getWebcastSdkVersion() {
        return this.webcastSdkVersion;
    }

    public String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public ScriptEngine getScriptEngine() {
        return this.scriptEngine;
    }

    public DouyinGiftCountCalculationTimeEnum getGiftCountCalculationTime() {
        return this.giftCountCalculationTime;
    }

    @Override
    public void setHeartbeatInitialDelay(long heartbeatInitialDelay) {
        this.heartbeatInitialDelay = heartbeatInitialDelay;
    }

    @Override
    public void setHeartbeatPeriod(long heartbeatPeriod) {
        this.heartbeatPeriod = heartbeatPeriod;
    }

    @Override
    public void setAggregatorMaxContentLength(int aggregatorMaxContentLength) {
        this.aggregatorMaxContentLength = aggregatorMaxContentLength;
    }

    @Override
    public void setMaxFramePayloadLength(int maxFramePayloadLength) {
        this.maxFramePayloadLength = maxFramePayloadLength;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public void setWebcastSdkVersion(String webcastSdkVersion) {
        this.webcastSdkVersion = webcastSdkVersion;
    }

    public void setUpdateVersionCode(String updateVersionCode) {
        this.updateVersionCode = updateVersionCode;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setScriptEngine(ScriptEngine scriptEngine) {
        this.scriptEngine = scriptEngine;
    }

    public void setGiftCountCalculationTime(DouyinGiftCountCalculationTimeEnum giftCountCalculationTime) {
        this.giftCountCalculationTime = giftCountCalculationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DouyinLiveChatClientConfig)) {
            return false;
        }
        DouyinLiveChatClientConfig other = (DouyinLiveChatClientConfig)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getHeartbeatInitialDelay() != other.getHeartbeatInitialDelay()) {
            return false;
        }
        if (this.getHeartbeatPeriod() != other.getHeartbeatPeriod()) {
            return false;
        }
        if (this.getAggregatorMaxContentLength() != other.getAggregatorMaxContentLength()) {
            return false;
        }
        if (this.getMaxFramePayloadLength() != other.getMaxFramePayloadLength()) {
            return false;
        }
        String this$versionCode = this.getVersionCode();
        String other$versionCode = other.getVersionCode();
        if (this$versionCode == null ? other$versionCode != null : !this$versionCode.equals((Object)other$versionCode)) {
            return false;
        }
        String this$webcastSdkVersion = this.getWebcastSdkVersion();
        String other$webcastSdkVersion = other.getWebcastSdkVersion();
        if (this$webcastSdkVersion == null ? other$webcastSdkVersion != null : !this$webcastSdkVersion.equals((Object)other$webcastSdkVersion)) {
            return false;
        }
        String this$updateVersionCode = this.getUpdateVersionCode();
        String other$updateVersionCode = other.getUpdateVersionCode();
        if (this$updateVersionCode == null ? other$updateVersionCode != null : !this$updateVersionCode.equals((Object)other$updateVersionCode)) {
            return false;
        }
        String this$userAgent = this.getUserAgent();
        String other$userAgent = other.getUserAgent();
        if (this$userAgent == null ? other$userAgent != null : !this$userAgent.equals((Object)other$userAgent)) {
            return false;
        }
        ScriptEngine this$scriptEngine = this.getScriptEngine();
        ScriptEngine other$scriptEngine = other.getScriptEngine();
        if (this$scriptEngine == null ? other$scriptEngine != null : !this$scriptEngine.equals((Object)other$scriptEngine)) {
            return false;
        }
        DouyinGiftCountCalculationTimeEnum this$giftCountCalculationTime = this.getGiftCountCalculationTime();
        DouyinGiftCountCalculationTimeEnum other$giftCountCalculationTime = other.getGiftCountCalculationTime();
        return !(this$giftCountCalculationTime == null ? other$giftCountCalculationTime != null : !this$giftCountCalculationTime.equals((Object)other$giftCountCalculationTime));
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof DouyinLiveChatClientConfig;
    }

    @Override
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $heartbeatInitialDelay = this.getHeartbeatInitialDelay();
        result = result * 59 + (int)($heartbeatInitialDelay >>> 32 ^ $heartbeatInitialDelay);
        long $heartbeatPeriod = this.getHeartbeatPeriod();
        result = result * 59 + (int)($heartbeatPeriod >>> 32 ^ $heartbeatPeriod);
        result = result * 59 + this.getAggregatorMaxContentLength();
        result = result * 59 + this.getMaxFramePayloadLength();
        String $versionCode = this.getVersionCode();
        result = result * 59 + ($versionCode == null ? 43 : $versionCode.hashCode());
        String $webcastSdkVersion = this.getWebcastSdkVersion();
        result = result * 59 + ($webcastSdkVersion == null ? 43 : $webcastSdkVersion.hashCode());
        String $updateVersionCode = this.getUpdateVersionCode();
        result = result * 59 + ($updateVersionCode == null ? 43 : $updateVersionCode.hashCode());
        String $userAgent = this.getUserAgent();
        result = result * 59 + ($userAgent == null ? 43 : $userAgent.hashCode());
        ScriptEngine $scriptEngine = this.getScriptEngine();
        result = result * 59 + ($scriptEngine == null ? 43 : $scriptEngine.hashCode());
        DouyinGiftCountCalculationTimeEnum $giftCountCalculationTime = this.getGiftCountCalculationTime();
        result = result * 59 + ($giftCountCalculationTime == null ? 43 : $giftCountCalculationTime.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DouyinLiveChatClientConfig(heartbeatInitialDelay=" + this.getHeartbeatInitialDelay() + ", heartbeatPeriod=" + this.getHeartbeatPeriod() + ", aggregatorMaxContentLength=" + this.getAggregatorMaxContentLength() + ", maxFramePayloadLength=" + this.getMaxFramePayloadLength() + ", versionCode=" + this.getVersionCode() + ", webcastSdkVersion=" + this.getWebcastSdkVersion() + ", updateVersionCode=" + this.getUpdateVersionCode() + ", userAgent=" + this.getUserAgent() + ", scriptEngine=" + this.getScriptEngine() + ", giftCountCalculationTime=" + (Object)((Object)this.getGiftCountCalculationTime()) + ")";
    }

    public DouyinLiveChatClientConfig() {
        this.heartbeatInitialDelay = DouyinLiveChatClientConfig.$default$heartbeatInitialDelay();
        this.heartbeatPeriod = DouyinLiveChatClientConfig.$default$heartbeatPeriod();
        this.aggregatorMaxContentLength = DouyinLiveChatClientConfig.$default$aggregatorMaxContentLength();
        this.maxFramePayloadLength = DouyinLiveChatClientConfig.$default$maxFramePayloadLength();
        this.versionCode = DouyinLiveChatClientConfig.$default$versionCode();
        this.webcastSdkVersion = DouyinLiveChatClientConfig.$default$webcastSdkVersion();
        this.updateVersionCode = DouyinLiveChatClientConfig.$default$updateVersionCode();
        this.userAgent = DouyinLiveChatClientConfig.$default$userAgent();
        this.scriptEngine = DouyinLiveChatClientConfig.$default$scriptEngine();
        this.giftCountCalculationTime = DouyinLiveChatClientConfig.$default$giftCountCalculationTime();
    }

    public DouyinLiveChatClientConfig(long heartbeatInitialDelay, long heartbeatPeriod, int aggregatorMaxContentLength, int maxFramePayloadLength, String versionCode, String webcastSdkVersion, String updateVersionCode, String userAgent, ScriptEngine scriptEngine, DouyinGiftCountCalculationTimeEnum giftCountCalculationTime) {
        this.heartbeatInitialDelay = heartbeatInitialDelay;
        this.heartbeatPeriod = heartbeatPeriod;
        this.aggregatorMaxContentLength = aggregatorMaxContentLength;
        this.maxFramePayloadLength = maxFramePayloadLength;
        this.versionCode = versionCode;
        this.webcastSdkVersion = webcastSdkVersion;
        this.updateVersionCode = updateVersionCode;
        this.userAgent = userAgent;
        this.scriptEngine = scriptEngine;
        this.giftCountCalculationTime = giftCountCalculationTime;
    }

    public static abstract class DouyinLiveChatClientConfigBuilder<C extends DouyinLiveChatClientConfig, B extends DouyinLiveChatClientConfigBuilder<C, B>>
    extends BaseNettyClientConfig.BaseNettyClientConfigBuilder<C, B> {
        private boolean heartbeatInitialDelay$set;
        private long heartbeatInitialDelay$value;
        private boolean heartbeatPeriod$set;
        private long heartbeatPeriod$value;
        private boolean aggregatorMaxContentLength$set;
        private int aggregatorMaxContentLength$value;
        private boolean maxFramePayloadLength$set;
        private int maxFramePayloadLength$value;
        private boolean versionCode$set;
        private String versionCode$value;
        private boolean webcastSdkVersion$set;
        private String webcastSdkVersion$value;
        private boolean updateVersionCode$set;
        private String updateVersionCode$value;
        private boolean userAgent$set;
        private String userAgent$value;
        private boolean scriptEngine$set;
        private ScriptEngine scriptEngine$value;
        private boolean giftCountCalculationTime$set;
        private DouyinGiftCountCalculationTimeEnum giftCountCalculationTime$value;

        @Override
        protected B $fillValuesFrom(C instance) {
            super.$fillValuesFrom(instance);
            DouyinLiveChatClientConfigBuilder.$fillValuesFromInstanceIntoBuilder(instance, this);
            return (B)this.self();
        }

        private static void $fillValuesFromInstanceIntoBuilder(DouyinLiveChatClientConfig instance, DouyinLiveChatClientConfigBuilder<?, ?> b) {
            b.heartbeatInitialDelay(instance.heartbeatInitialDelay);
            b.heartbeatPeriod(instance.heartbeatPeriod);
            b.aggregatorMaxContentLength(instance.aggregatorMaxContentLength);
            b.maxFramePayloadLength(instance.maxFramePayloadLength);
            b.versionCode(instance.versionCode);
            b.webcastSdkVersion(instance.webcastSdkVersion);
            b.updateVersionCode(instance.updateVersionCode);
            b.userAgent(instance.userAgent);
            b.scriptEngine(instance.scriptEngine);
            b.giftCountCalculationTime(instance.giftCountCalculationTime);
        }

        @Override
        public B heartbeatInitialDelay(long heartbeatInitialDelay) {
            this.heartbeatInitialDelay$value = heartbeatInitialDelay;
            this.heartbeatInitialDelay$set = true;
            return (B)this.self();
        }

        @Override
        public B heartbeatPeriod(long heartbeatPeriod) {
            this.heartbeatPeriod$value = heartbeatPeriod;
            this.heartbeatPeriod$set = true;
            return (B)this.self();
        }

        @Override
        public B aggregatorMaxContentLength(int aggregatorMaxContentLength) {
            this.aggregatorMaxContentLength$value = aggregatorMaxContentLength;
            this.aggregatorMaxContentLength$set = true;
            return (B)this.self();
        }

        @Override
        public B maxFramePayloadLength(int maxFramePayloadLength) {
            this.maxFramePayloadLength$value = maxFramePayloadLength;
            this.maxFramePayloadLength$set = true;
            return (B)this.self();
        }

        public B versionCode(String versionCode) {
            this.versionCode$value = versionCode;
            this.versionCode$set = true;
            return (B)this.self();
        }

        public B webcastSdkVersion(String webcastSdkVersion) {
            this.webcastSdkVersion$value = webcastSdkVersion;
            this.webcastSdkVersion$set = true;
            return (B)this.self();
        }

        public B updateVersionCode(String updateVersionCode) {
            this.updateVersionCode$value = updateVersionCode;
            this.updateVersionCode$set = true;
            return (B)this.self();
        }

        public B userAgent(String userAgent) {
            this.userAgent$value = userAgent;
            this.userAgent$set = true;
            return (B)this.self();
        }

        public B scriptEngine(ScriptEngine scriptEngine) {
            this.scriptEngine$value = scriptEngine;
            this.scriptEngine$set = true;
            return (B)this.self();
        }

        public B giftCountCalculationTime(DouyinGiftCountCalculationTimeEnum giftCountCalculationTime) {
            this.giftCountCalculationTime$value = giftCountCalculationTime;
            this.giftCountCalculationTime$set = true;
            return (B)this.self();
        }

        @Override
        protected abstract B self();

        @Override
        public abstract C build();

        @Override
        public String toString() {
            return "DouyinLiveChatClientConfig.DouyinLiveChatClientConfigBuilder(super=" + super.toString() + ", heartbeatInitialDelay$value=" + this.heartbeatInitialDelay$value + ", heartbeatPeriod$value=" + this.heartbeatPeriod$value + ", aggregatorMaxContentLength$value=" + this.aggregatorMaxContentLength$value + ", maxFramePayloadLength$value=" + this.maxFramePayloadLength$value + ", versionCode$value=" + this.versionCode$value + ", webcastSdkVersion$value=" + this.webcastSdkVersion$value + ", updateVersionCode$value=" + this.updateVersionCode$value + ", userAgent$value=" + this.userAgent$value + ", scriptEngine$value=" + this.scriptEngine$value + ", giftCountCalculationTime$value=" + (Object)((Object)this.giftCountCalculationTime$value) + ")";
        }
    }

    private static final class DouyinLiveChatClientConfigBuilderImpl
    extends DouyinLiveChatClientConfigBuilder<DouyinLiveChatClientConfig, DouyinLiveChatClientConfigBuilderImpl> {
        private DouyinLiveChatClientConfigBuilderImpl() {
        }

        @Override
        protected DouyinLiveChatClientConfigBuilderImpl self() {
            return this;
        }

        @Override
        public DouyinLiveChatClientConfig build() {
            return new DouyinLiveChatClientConfig(this);
        }
    }
}

