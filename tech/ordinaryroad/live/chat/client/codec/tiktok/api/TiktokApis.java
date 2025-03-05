/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collections
 *  java.util.Optional
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.function.Function
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.api;

import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.ordinaryroad.live.chat.client.codec.tiktok.constant.TiktokGiftCountCalculationTimeEnum;
import tech.ordinaryroad.live.chat.client.codec.tiktok.constant.TiktokRoomStatusEnum;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokGiftMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.GiftMessage;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Response;
import tech.ordinaryroad.live.chat.client.codec.tiktok.room.RoomInitResult;
import tech.ordinaryroad.live.chat.client.commons.base.exception.BaseException;
import tech.ordinaryroad.live.chat.client.commons.util.OrJacksonUtil;
import tech.ordinaryroad.live.chat.client.commons.util.OrLiveChatHttpUtil;

public class TiktokApis {
    private static final Logger log = LoggerFactory.getLogger(TiktokApis.class);
    public static final String KEY_COOKIE_TTWID = "ttwid";
    public static final String KEY_COOKIE_MS_TOKEN = "msToken";
    private static final String PATTERN_SIGI_STATE = "<script id=\"SIGI_STATE\" type=\"application/json\">([\\s\\S]+)</script>";
    public static final Function<TiktokTtwidRequest, String> DEFAULT_TTWID_SUPPLIER = request -> {
        log.debug("ttwid generating");
        HttpResponse response = OrLiveChatHttpUtil.createGet("https://www.tiktok.com").execute();
        try {
            String ttwid = null;
            try {
                ttwid = response.getCookie(KEY_COOKIE_TTWID).getValue();
                Assert.notBlank(ttwid);
                log.debug("ttwid generated: {}", (Object)ttwid);
            }
            catch (Exception e) {
                log.error("ttwid generate failed", (Throwable)e);
            }
            String string = ttwid;
            return string;
        }
        finally {
            if (Collections.singletonList((Object)response).get(0) != null) {
                response.close();
            }
        }
    };
    public static final Function<TiktokTtwidRequest, String> HTTP_TTWID_SUPPLIER = request -> {
        log.debug("ttwid generating");
        HttpResponse response = OrLiveChatHttpUtil.createGet("https://douyin.wtf/api/douyin/web/generate_ttwid").execute();
        try {
            String ttwid = null;
            try {
                JsonNode jsonNode = OrJacksonUtil.getInstance().readTree(response.body());
                ttwid = jsonNode.get("data").get(KEY_COOKIE_TTWID).asText();
                Assert.notBlank(ttwid);
                log.debug("ttwid generated: {}", (Object)ttwid);
            }
            catch (Exception e) {
                log.error("ttwid generate failed", (Throwable)e);
            }
            String string = ttwid;
            return string;
        }
        finally {
            if (Collections.singletonList((Object)response).get(0) != null) {
                response.close();
            }
        }
    };
    private static Function<TiktokTtwidRequest, String> ttwidProvicer = DEFAULT_TTWID_SUPPLIER;
    private static Function<TiktokSignatureRequest, TiktokSignatureResult> signatureProvider;
    private static final TimedCache<String, GiftMessage> TIKTOK_GIFT_MSG_CACHE;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive exception aggregation
     */
    public static RoomInitResult roomInit(String browserVersion, String roomId, String cookie, RoomInitResult roomInitResult) {
        Assert.notBlank(cookie, "请传入cookie", new Object[0]);
        Assert.notNull(signatureProvider, "请配置签名Provider", new Object[0]);
        HttpResponse response = OrLiveChatHttpUtil.createGet(StrUtil.format("https://www.tiktok.com/@{}/live", roomId)).cookie(cookie).execute();
        try {
            RoomInitResult roomInitResult2;
            String sigiStateString = ReUtil.getGroup1(PATTERN_SIGI_STATE, (CharSequence)response.body());
            JsonNode sigiState = OrJacksonUtil.getInstance().readTree(sigiStateString);
            long realRoomId = sigiState.get("LiveRoom").get("liveRoomUserInfo").get("user").get("roomId").asLong();
            int roomStatus = sigiState.get("LiveRoom").get("liveRoomUserInfo").get("liveRoom").get("status").asInt();
            TiktokRoomStatusEnum roomStatusEnum = TiktokRoomStatusEnum.getByCode(roomStatus);
            log.debug("realRoomId: {}, roomStatus: {}, roomStatusEnum: {}", new Object[]{realRoomId, roomStatus, roomStatusEnum});
            TiktokSignatureResult tiktokSignatureResult = (TiktokSignatureResult)signatureProvider.apply((Object)TiktokSignatureRequest.builder().browserVersion(browserVersion).roomId(roomId).realRoomId(realRoomId).build());
            log.debug("tiktokSignatureResult: {}", (Object)tiktokSignatureResult);
            String userAgent = tiktokSignatureResult.getNavigator().getUser_agent();
            String signed_url = tiktokSignatureResult.getSigned_url();
            HttpRequest signedUrlRequest = OrLiveChatHttpUtil.createGet(signed_url);
            signedUrlRequest.header(Header.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
            signedUrlRequest.header(Header.ACCEPT_ENCODING, "gzip, deflate, br, zstd");
            signedUrlRequest.header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
            signedUrlRequest.header(Header.PRAGMA, "no_cache");
            signedUrlRequest.header(Header.CACHE_CONTROL, "no_cache");
            signedUrlRequest.header(Header.USER_AGENT, userAgent);
            String ttwid = (String)ttwidProvicer.apply((Object)TiktokTtwidRequest.builder().cookie(cookie).build());
            HttpResponse signedUrlResponse = signedUrlRequest.cookie(StrUtil.format("ttwid={}; {}", ttwid, cookie)).execute();
            try {
                log.debug("signedUrlResponse.status: {}", (Object)signedUrlResponse.getStatus());
                if (signedUrlResponse.getStatus() != 200) {
                    throw new BaseException("URL 签名访问失败");
                }
                String msToken = signedUrlResponse.getCookie(KEY_COOKIE_MS_TOKEN).getValue();
                Response webcastResponse = Response.parseFrom(signedUrlResponse.bodyBytes());
                log.debug("webcastResponse: {}", (Object)webcastResponse);
                roomInitResult = (RoomInitResult)Optional.ofNullable((Object)roomInitResult).orElse((Object)RoomInitResult.builder().build());
                roomInitResult.setTtwid(ttwid);
                roomInitResult.setMsToken(msToken);
                roomInitResult.setRealRoomId(realRoomId);
                roomInitResult.setRoomStatus(roomStatusEnum);
                roomInitResult.setWebcastResponse(webcastResponse);
                roomInitResult.setSigiState(sigiState);
                roomInitResult2 = roomInitResult;
            }
            catch (Throwable throwable) {
                if (Collections.singletonList((Object)signedUrlResponse).get(0) != null) {
                    signedUrlResponse.close();
                }
                throw throwable;
            }
            if (Collections.singletonList((Object)signedUrlResponse).get(0) != null) {
                signedUrlResponse.close();
            }
            return roomInitResult2;
        }
        finally {
            if (Collections.singletonList((Object)response).get(0) != null) {
                response.close();
            }
        }
    }

    public static int calculateGiftCount(TiktokGiftMsg msg, TiktokGiftCountCalculationTimeEnum calculationTimeEnum) {
        if (msg == null || msg.getMsg() == null) {
            return 0;
        }
        GiftMessage giftMessage = msg.getMsg();
        long giftCount = 0L;
        if (calculationTimeEnum == TiktokGiftCountCalculationTimeEnum.COMBO_END) {
            if (!giftMessage.getGift().getCombo() || giftMessage.getRepeatEnd() == 1) {
                long comboCount = giftMessage.getComboCount();
                if (giftMessage.getGroupCount() != 1L) {
                    comboCount = giftMessage.getGroupCount() * comboCount;
                }
                giftCount = comboCount;
            }
        } else {
            long groupId = giftMessage.getGroupId();
            long giftId = giftMessage.getGiftId();
            String key = groupId + "-" + msg.getUid() + "-" + giftId;
            if (TIKTOK_GIFT_MSG_CACHE.containsKey(key)) {
                GiftMessage giftMessageByGroupId = (GiftMessage)TIKTOK_GIFT_MSG_CACHE.get(key);
                long repeatCountByGroupId = giftMessageByGroupId.getRepeatCount();
                giftCount = giftMessage.getRepeatCount() - repeatCountByGroupId;
            } else {
                giftCount = giftMessage.getRepeatCount();
            }
            if (giftCount > 0L) {
                TIKTOK_GIFT_MSG_CACHE.put(key, giftMessage);
            }
        }
        msg.setCalculatedGiftCount((int)giftCount);
        return (int)giftCount;
    }

    public static Function<TiktokTtwidRequest, String> getTtwidProvicer() {
        return ttwidProvicer;
    }

    public static void setTtwidProvicer(Function<TiktokTtwidRequest, String> ttwidProvicer) {
        TiktokApis.ttwidProvicer = ttwidProvicer;
    }

    public static Function<TiktokSignatureRequest, TiktokSignatureResult> getSignatureProvider() {
        return signatureProvider;
    }

    public static void setSignatureProvider(Function<TiktokSignatureRequest, TiktokSignatureResult> signatureProvider) {
        TiktokApis.signatureProvider = signatureProvider;
    }

    static {
        TIKTOK_GIFT_MSG_CACHE = new TimedCache(300000L, new ConcurrentHashMap());
    }

    public static class TiktokSignatureRequest {
        private String browserVersion;
        private String roomId;
        private Long realRoomId;

        public static TiktokSignatureRequestBuilder builder() {
            return new TiktokSignatureRequestBuilder();
        }

        public String getBrowserVersion() {
            return this.browserVersion;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public Long getRealRoomId() {
            return this.realRoomId;
        }

        public void setBrowserVersion(String browserVersion) {
            this.browserVersion = browserVersion;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public void setRealRoomId(Long realRoomId) {
            this.realRoomId = realRoomId;
        }

        public TiktokSignatureRequest(String browserVersion, String roomId, Long realRoomId) {
            this.browserVersion = browserVersion;
            this.roomId = roomId;
            this.realRoomId = realRoomId;
        }

        public TiktokSignatureRequest() {
        }

        public static class TiktokSignatureRequestBuilder {
            private String browserVersion;
            private String roomId;
            private Long realRoomId;

            TiktokSignatureRequestBuilder() {
            }

            public TiktokSignatureRequestBuilder browserVersion(String browserVersion) {
                this.browserVersion = browserVersion;
                return this;
            }

            public TiktokSignatureRequestBuilder roomId(String roomId) {
                this.roomId = roomId;
                return this;
            }

            public TiktokSignatureRequestBuilder realRoomId(Long realRoomId) {
                this.realRoomId = realRoomId;
                return this;
            }

            public TiktokSignatureRequest build() {
                return new TiktokSignatureRequest(this.browserVersion, this.roomId, this.realRoomId);
            }

            public String toString() {
                return "TiktokApis.TiktokSignatureRequest.TiktokSignatureRequestBuilder(browserVersion=" + this.browserVersion + ", roomId=" + this.roomId + ", realRoomId=" + this.realRoomId + ")";
            }
        }
    }

    public static class TiktokSignatureResult {
        private String signature;
        private String verify_fp;
        private String signed_url;
        @JsonProperty(value="x-tt-params")
        private String x_tt_params;
        @JsonProperty(value="x-bogus")
        private String x_bogus;
        private Navigator navigator;

        public static TiktokSignatureResultBuilder builder() {
            return new TiktokSignatureResultBuilder();
        }

        public String getSignature() {
            return this.signature;
        }

        public String getVerify_fp() {
            return this.verify_fp;
        }

        public String getSigned_url() {
            return this.signed_url;
        }

        public String getX_tt_params() {
            return this.x_tt_params;
        }

        public String getX_bogus() {
            return this.x_bogus;
        }

        public Navigator getNavigator() {
            return this.navigator;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public void setVerify_fp(String verify_fp) {
            this.verify_fp = verify_fp;
        }

        public void setSigned_url(String signed_url) {
            this.signed_url = signed_url;
        }

        @JsonProperty(value="x-tt-params")
        public void setX_tt_params(String x_tt_params) {
            this.x_tt_params = x_tt_params;
        }

        @JsonProperty(value="x-bogus")
        public void setX_bogus(String x_bogus) {
            this.x_bogus = x_bogus;
        }

        public void setNavigator(Navigator navigator) {
            this.navigator = navigator;
        }

        public TiktokSignatureResult(String signature, String verify_fp, String signed_url, String x_tt_params, String x_bogus, Navigator navigator) {
            this.signature = signature;
            this.verify_fp = verify_fp;
            this.signed_url = signed_url;
            this.x_tt_params = x_tt_params;
            this.x_bogus = x_bogus;
            this.navigator = navigator;
        }

        public TiktokSignatureResult() {
        }

        public static class TiktokSignatureResultBuilder {
            private String signature;
            private String verify_fp;
            private String signed_url;
            private String x_tt_params;
            private String x_bogus;
            private Navigator navigator;

            TiktokSignatureResultBuilder() {
            }

            public TiktokSignatureResultBuilder signature(String signature) {
                this.signature = signature;
                return this;
            }

            public TiktokSignatureResultBuilder verify_fp(String verify_fp) {
                this.verify_fp = verify_fp;
                return this;
            }

            public TiktokSignatureResultBuilder signed_url(String signed_url) {
                this.signed_url = signed_url;
                return this;
            }

            @JsonProperty(value="x-tt-params")
            public TiktokSignatureResultBuilder x_tt_params(String x_tt_params) {
                this.x_tt_params = x_tt_params;
                return this;
            }

            @JsonProperty(value="x-bogus")
            public TiktokSignatureResultBuilder x_bogus(String x_bogus) {
                this.x_bogus = x_bogus;
                return this;
            }

            public TiktokSignatureResultBuilder navigator(Navigator navigator) {
                this.navigator = navigator;
                return this;
            }

            public TiktokSignatureResult build() {
                return new TiktokSignatureResult(this.signature, this.verify_fp, this.signed_url, this.x_tt_params, this.x_bogus, this.navigator);
            }

            public String toString() {
                return "TiktokApis.TiktokSignatureResult.TiktokSignatureResultBuilder(signature=" + this.signature + ", verify_fp=" + this.verify_fp + ", signed_url=" + this.signed_url + ", x_tt_params=" + this.x_tt_params + ", x_bogus=" + this.x_bogus + ", navigator=" + this.navigator + ")";
            }
        }

        public static class Navigator {
            private Double deviceScaleFactor;
            private String user_agent;
            private String browser_language;
            private String browser_platform;
            private String browser_name;
            private String browser_version;

            public static NavigatorBuilder builder() {
                return new NavigatorBuilder();
            }

            public Double getDeviceScaleFactor() {
                return this.deviceScaleFactor;
            }

            public String getUser_agent() {
                return this.user_agent;
            }

            public String getBrowser_language() {
                return this.browser_language;
            }

            public String getBrowser_platform() {
                return this.browser_platform;
            }

            public String getBrowser_name() {
                return this.browser_name;
            }

            public String getBrowser_version() {
                return this.browser_version;
            }

            public void setDeviceScaleFactor(Double deviceScaleFactor) {
                this.deviceScaleFactor = deviceScaleFactor;
            }

            public void setUser_agent(String user_agent) {
                this.user_agent = user_agent;
            }

            public void setBrowser_language(String browser_language) {
                this.browser_language = browser_language;
            }

            public void setBrowser_platform(String browser_platform) {
                this.browser_platform = browser_platform;
            }

            public void setBrowser_name(String browser_name) {
                this.browser_name = browser_name;
            }

            public void setBrowser_version(String browser_version) {
                this.browser_version = browser_version;
            }

            public Navigator(Double deviceScaleFactor, String user_agent, String browser_language, String browser_platform, String browser_name, String browser_version) {
                this.deviceScaleFactor = deviceScaleFactor;
                this.user_agent = user_agent;
                this.browser_language = browser_language;
                this.browser_platform = browser_platform;
                this.browser_name = browser_name;
                this.browser_version = browser_version;
            }

            public Navigator() {
            }

            public static class NavigatorBuilder {
                private Double deviceScaleFactor;
                private String user_agent;
                private String browser_language;
                private String browser_platform;
                private String browser_name;
                private String browser_version;

                NavigatorBuilder() {
                }

                public NavigatorBuilder deviceScaleFactor(Double deviceScaleFactor) {
                    this.deviceScaleFactor = deviceScaleFactor;
                    return this;
                }

                public NavigatorBuilder user_agent(String user_agent) {
                    this.user_agent = user_agent;
                    return this;
                }

                public NavigatorBuilder browser_language(String browser_language) {
                    this.browser_language = browser_language;
                    return this;
                }

                public NavigatorBuilder browser_platform(String browser_platform) {
                    this.browser_platform = browser_platform;
                    return this;
                }

                public NavigatorBuilder browser_name(String browser_name) {
                    this.browser_name = browser_name;
                    return this;
                }

                public NavigatorBuilder browser_version(String browser_version) {
                    this.browser_version = browser_version;
                    return this;
                }

                public Navigator build() {
                    return new Navigator(this.deviceScaleFactor, this.user_agent, this.browser_language, this.browser_platform, this.browser_name, this.browser_version);
                }

                public String toString() {
                    return "TiktokApis.TiktokSignatureResult.Navigator.NavigatorBuilder(deviceScaleFactor=" + this.deviceScaleFactor + ", user_agent=" + this.user_agent + ", browser_language=" + this.browser_language + ", browser_platform=" + this.browser_platform + ", browser_name=" + this.browser_name + ", browser_version=" + this.browser_version + ")";
                }
            }
        }
    }

    public static class TiktokTtwidRequest {
        private String cookie;

        public static TiktokTtwidRequestBuilder builder() {
            return new TiktokTtwidRequestBuilder();
        }

        public String getCookie() {
            return this.cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }

        public TiktokTtwidRequest(String cookie) {
            this.cookie = cookie;
        }

        public TiktokTtwidRequest() {
        }

        public static class TiktokTtwidRequestBuilder {
            private String cookie;

            TiktokTtwidRequestBuilder() {
            }

            public TiktokTtwidRequestBuilder cookie(String cookie) {
                this.cookie = cookie;
                return this;
            }

            public TiktokTtwidRequest build() {
                return new TiktokTtwidRequest(this.cookie);
            }

            public String toString() {
                return "TiktokApis.TiktokTtwidRequest.TiktokTtwidRequestBuilder(cookie=" + this.cookie + ")";
            }
        }
    }
}

