/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.beans.PropertyChangeListener
 *  java.beans.PropertyChangeSupport
 *  java.lang.Boolean
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.commons.client.config;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import tech.ordinaryroad.live.chat.client.commons.base.exception.BaseException;
import tech.ordinaryroad.live.chat.client.commons.util.OrLiveChatHttpUtil;

public abstract class BaseLiveChatClientConfig {
    protected final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport((Object)this);
    public static final long DEFAULT_HEARTBEAT_INITIAL_DELAY = 15L;
    public static final long DEFAULT_HEARTBEAT_PERIOD = 25L;
    public static final long DEFAULT_MIN_SEND_DANMU_PERIOD = 3000L;
    public static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = 5000L;
    private String websocketUri;
    private String forwardWebsocketUri;
    private String cookie;
    private Object roomId;
    private boolean autoReconnect;
    private int reconnectDelay;
    private long heartbeatInitialDelay;
    private long heartbeatPeriod;
    private long minSendDanmuPeriod;
    private long handshakeTimeoutMillis;
    private String socks5ProxyHost;
    private int socks5ProxyPort;
    private String socks5ProxyUsername;
    private String socks5ProxyPassword;

    public void setWebsocketUri(String websocketUri) {
        String oldValue = this.websocketUri;
        this.websocketUri = websocketUri;
        this.propertyChangeSupport.firePropertyChange("websocketUri", (Object)oldValue, (Object)websocketUri);
    }

    public void setForwardWebsocketUri(String forwardWebsocketUri) {
        String oldValue = this.forwardWebsocketUri;
        this.forwardWebsocketUri = forwardWebsocketUri;
        this.propertyChangeSupport.firePropertyChange("forwardWebsocketUri", (Object)oldValue, (Object)forwardWebsocketUri);
    }

    public void setCookie(String cookie) {
        String oldValue = this.cookie;
        this.cookie = cookie;
        this.propertyChangeSupport.firePropertyChange("cookie", (Object)oldValue, (Object)cookie);
    }

    public void setRoomId(Object roomId) {
        if (!(roomId instanceof Number) && !(roomId instanceof String)) {
            throw new BaseException("房间ID仅支持数字或字符串，所传参数类型：" + roomId.getClass() + "值：" + roomId);
        }
        Object oldValue = this.roomId;
        this.roomId = roomId;
        this.propertyChangeSupport.firePropertyChange("roomId", oldValue, roomId);
    }

    public void setAutoReconnect(boolean autoReconnect) {
        boolean oldValue = this.autoReconnect;
        this.autoReconnect = autoReconnect;
        this.propertyChangeSupport.firePropertyChange("autoReconnect", oldValue, autoReconnect);
    }

    public void setReconnectDelay(int reconnectDelay) {
        int oldValue = this.reconnectDelay;
        this.reconnectDelay = reconnectDelay;
        this.propertyChangeSupport.firePropertyChange("reconnectDelay", oldValue, reconnectDelay);
    }

    public void setHeartbeatInitialDelay(long heartbeatInitialDelay) {
        long oldValue = this.heartbeatInitialDelay;
        this.heartbeatInitialDelay = heartbeatInitialDelay;
        this.propertyChangeSupport.firePropertyChange("heartbeatInitialDelay", (Object)oldValue, (Object)heartbeatInitialDelay);
    }

    public void setHeartbeatPeriod(long heartbeatPeriod) {
        long oldValue = this.heartbeatPeriod;
        this.heartbeatPeriod = heartbeatPeriod;
        this.propertyChangeSupport.firePropertyChange("heartbeatPeriod", (Object)oldValue, (Object)heartbeatPeriod);
    }

    public void setMinSendDanmuPeriod(long minSendDanmuPeriod) {
        long oldValue = this.minSendDanmuPeriod;
        this.minSendDanmuPeriod = minSendDanmuPeriod;
        this.propertyChangeSupport.firePropertyChange("minSendDanmuPeriod", (Object)oldValue, (Object)minSendDanmuPeriod);
    }

    public void setHandshakeTimeoutMillis(long handshakeTimeoutMillis) {
        long oldValue = this.handshakeTimeoutMillis;
        this.handshakeTimeoutMillis = handshakeTimeoutMillis;
        this.propertyChangeSupport.firePropertyChange("handshakeTimeoutMillis", (Object)oldValue, (Object)handshakeTimeoutMillis);
    }

    public void setSocks5ProxyHost(String socks5ProxyHost) {
        String oldValue = this.socks5ProxyHost;
        this.socks5ProxyHost = socks5ProxyHost;
        this.propertyChangeSupport.firePropertyChange("socks5ProxyHost", (Object)oldValue, (Object)socks5ProxyHost);
        OrLiveChatHttpUtil.updateProxyHost(socks5ProxyHost);
    }

    public void setSocks5ProxyPort(int socks5ProxyPort) {
        int oldValue = this.socks5ProxyPort;
        this.socks5ProxyPort = socks5ProxyPort;
        this.propertyChangeSupport.firePropertyChange("socks5ProxyPort", oldValue, socks5ProxyPort);
        OrLiveChatHttpUtil.updateProxyPort(socks5ProxyPort);
    }

    public void setSocks5ProxyUsername(String socks5ProxyUsername) {
        String oldValue = this.socks5ProxyUsername;
        this.socks5ProxyUsername = socks5ProxyUsername;
        this.propertyChangeSupport.firePropertyChange("socks5ProxyUsername", (Object)oldValue, (Object)socks5ProxyUsername);
        OrLiveChatHttpUtil.updateProxyUsername(socks5ProxyUsername);
    }

    public void setSocks5ProxyPassword(String socks5ProxyPassword) {
        String oldValue = this.socks5ProxyPassword;
        this.socks5ProxyPassword = socks5ProxyPassword;
        this.propertyChangeSupport.firePropertyChange("socks5ProxyPassword", (Object)oldValue, (Object)socks5ProxyPassword);
        OrLiveChatHttpUtil.updateProxyPassword(socks5ProxyPassword);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private static boolean $default$autoReconnect() {
        return Boolean.TRUE;
    }

    private static int $default$reconnectDelay() {
        return 5;
    }

    private static long $default$heartbeatInitialDelay() {
        return 15L;
    }

    private static long $default$heartbeatPeriod() {
        return 25L;
    }

    private static long $default$minSendDanmuPeriod() {
        return 3000L;
    }

    private static long $default$handshakeTimeoutMillis() {
        return 5000L;
    }

    protected BaseLiveChatClientConfig(BaseLiveChatClientConfigBuilder<?, ?> b) {
        this.websocketUri = ((BaseLiveChatClientConfigBuilder)b).websocketUri;
        this.forwardWebsocketUri = ((BaseLiveChatClientConfigBuilder)b).forwardWebsocketUri;
        this.cookie = ((BaseLiveChatClientConfigBuilder)b).cookie;
        this.roomId = ((BaseLiveChatClientConfigBuilder)b).roomId;
        this.autoReconnect = ((BaseLiveChatClientConfigBuilder)b).autoReconnect$set ? ((BaseLiveChatClientConfigBuilder)b).autoReconnect$value : BaseLiveChatClientConfig.$default$autoReconnect();
        this.reconnectDelay = ((BaseLiveChatClientConfigBuilder)b).reconnectDelay$set ? ((BaseLiveChatClientConfigBuilder)b).reconnectDelay$value : BaseLiveChatClientConfig.$default$reconnectDelay();
        this.heartbeatInitialDelay = ((BaseLiveChatClientConfigBuilder)b).heartbeatInitialDelay$set ? ((BaseLiveChatClientConfigBuilder)b).heartbeatInitialDelay$value : BaseLiveChatClientConfig.$default$heartbeatInitialDelay();
        this.heartbeatPeriod = ((BaseLiveChatClientConfigBuilder)b).heartbeatPeriod$set ? ((BaseLiveChatClientConfigBuilder)b).heartbeatPeriod$value : BaseLiveChatClientConfig.$default$heartbeatPeriod();
        this.minSendDanmuPeriod = ((BaseLiveChatClientConfigBuilder)b).minSendDanmuPeriod$set ? ((BaseLiveChatClientConfigBuilder)b).minSendDanmuPeriod$value : BaseLiveChatClientConfig.$default$minSendDanmuPeriod();
        this.handshakeTimeoutMillis = ((BaseLiveChatClientConfigBuilder)b).handshakeTimeoutMillis$set ? ((BaseLiveChatClientConfigBuilder)b).handshakeTimeoutMillis$value : BaseLiveChatClientConfig.$default$handshakeTimeoutMillis();
        this.socks5ProxyHost = ((BaseLiveChatClientConfigBuilder)b).socks5ProxyHost;
        this.socks5ProxyPort = ((BaseLiveChatClientConfigBuilder)b).socks5ProxyPort;
        this.socks5ProxyUsername = ((BaseLiveChatClientConfigBuilder)b).socks5ProxyUsername;
        this.socks5ProxyPassword = ((BaseLiveChatClientConfigBuilder)b).socks5ProxyPassword;
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }

    public String getWebsocketUri() {
        return this.websocketUri;
    }

    public String getForwardWebsocketUri() {
        return this.forwardWebsocketUri;
    }

    public String getCookie() {
        return this.cookie;
    }

    public Object getRoomId() {
        return this.roomId;
    }

    public boolean isAutoReconnect() {
        return this.autoReconnect;
    }

    public int getReconnectDelay() {
        return this.reconnectDelay;
    }

    public long getHeartbeatInitialDelay() {
        return this.heartbeatInitialDelay;
    }

    public long getHeartbeatPeriod() {
        return this.heartbeatPeriod;
    }

    public long getMinSendDanmuPeriod() {
        return this.minSendDanmuPeriod;
    }

    public long getHandshakeTimeoutMillis() {
        return this.handshakeTimeoutMillis;
    }

    public String getSocks5ProxyHost() {
        return this.socks5ProxyHost;
    }

    public int getSocks5ProxyPort() {
        return this.socks5ProxyPort;
    }

    public String getSocks5ProxyUsername() {
        return this.socks5ProxyUsername;
    }

    public String getSocks5ProxyPassword() {
        return this.socks5ProxyPassword;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseLiveChatClientConfig)) {
            return false;
        }
        BaseLiveChatClientConfig other = (BaseLiveChatClientConfig)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isAutoReconnect() != other.isAutoReconnect()) {
            return false;
        }
        if (this.getReconnectDelay() != other.getReconnectDelay()) {
            return false;
        }
        if (this.getHeartbeatInitialDelay() != other.getHeartbeatInitialDelay()) {
            return false;
        }
        if (this.getHeartbeatPeriod() != other.getHeartbeatPeriod()) {
            return false;
        }
        if (this.getMinSendDanmuPeriod() != other.getMinSendDanmuPeriod()) {
            return false;
        }
        if (this.getHandshakeTimeoutMillis() != other.getHandshakeTimeoutMillis()) {
            return false;
        }
        if (this.getSocks5ProxyPort() != other.getSocks5ProxyPort()) {
            return false;
        }
        PropertyChangeSupport this$propertyChangeSupport = this.getPropertyChangeSupport();
        PropertyChangeSupport other$propertyChangeSupport = other.getPropertyChangeSupport();
        if (this$propertyChangeSupport == null ? other$propertyChangeSupport != null : !this$propertyChangeSupport.equals((Object)other$propertyChangeSupport)) {
            return false;
        }
        String this$websocketUri = this.getWebsocketUri();
        String other$websocketUri = other.getWebsocketUri();
        if (this$websocketUri == null ? other$websocketUri != null : !this$websocketUri.equals((Object)other$websocketUri)) {
            return false;
        }
        String this$forwardWebsocketUri = this.getForwardWebsocketUri();
        String other$forwardWebsocketUri = other.getForwardWebsocketUri();
        if (this$forwardWebsocketUri == null ? other$forwardWebsocketUri != null : !this$forwardWebsocketUri.equals((Object)other$forwardWebsocketUri)) {
            return false;
        }
        String this$cookie = this.getCookie();
        String other$cookie = other.getCookie();
        if (this$cookie == null ? other$cookie != null : !this$cookie.equals((Object)other$cookie)) {
            return false;
        }
        Object this$roomId = this.getRoomId();
        Object other$roomId = other.getRoomId();
        if (this$roomId == null ? other$roomId != null : !this$roomId.equals(other$roomId)) {
            return false;
        }
        String this$socks5ProxyHost = this.getSocks5ProxyHost();
        String other$socks5ProxyHost = other.getSocks5ProxyHost();
        if (this$socks5ProxyHost == null ? other$socks5ProxyHost != null : !this$socks5ProxyHost.equals((Object)other$socks5ProxyHost)) {
            return false;
        }
        String this$socks5ProxyUsername = this.getSocks5ProxyUsername();
        String other$socks5ProxyUsername = other.getSocks5ProxyUsername();
        if (this$socks5ProxyUsername == null ? other$socks5ProxyUsername != null : !this$socks5ProxyUsername.equals((Object)other$socks5ProxyUsername)) {
            return false;
        }
        String this$socks5ProxyPassword = this.getSocks5ProxyPassword();
        String other$socks5ProxyPassword = other.getSocks5ProxyPassword();
        return !(this$socks5ProxyPassword == null ? other$socks5ProxyPassword != null : !this$socks5ProxyPassword.equals((Object)other$socks5ProxyPassword));
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseLiveChatClientConfig;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isAutoReconnect() ? 79 : 97);
        result = result * 59 + this.getReconnectDelay();
        long $heartbeatInitialDelay = this.getHeartbeatInitialDelay();
        result = result * 59 + (int)($heartbeatInitialDelay >>> 32 ^ $heartbeatInitialDelay);
        long $heartbeatPeriod = this.getHeartbeatPeriod();
        result = result * 59 + (int)($heartbeatPeriod >>> 32 ^ $heartbeatPeriod);
        long $minSendDanmuPeriod = this.getMinSendDanmuPeriod();
        result = result * 59 + (int)($minSendDanmuPeriod >>> 32 ^ $minSendDanmuPeriod);
        long $handshakeTimeoutMillis = this.getHandshakeTimeoutMillis();
        result = result * 59 + (int)($handshakeTimeoutMillis >>> 32 ^ $handshakeTimeoutMillis);
        result = result * 59 + this.getSocks5ProxyPort();
        PropertyChangeSupport $propertyChangeSupport = this.getPropertyChangeSupport();
        result = result * 59 + ($propertyChangeSupport == null ? 43 : $propertyChangeSupport.hashCode());
        String $websocketUri = this.getWebsocketUri();
        result = result * 59 + ($websocketUri == null ? 43 : $websocketUri.hashCode());
        String $forwardWebsocketUri = this.getForwardWebsocketUri();
        result = result * 59 + ($forwardWebsocketUri == null ? 43 : $forwardWebsocketUri.hashCode());
        String $cookie = this.getCookie();
        result = result * 59 + ($cookie == null ? 43 : $cookie.hashCode());
        Object $roomId = this.getRoomId();
        result = result * 59 + ($roomId == null ? 43 : $roomId.hashCode());
        String $socks5ProxyHost = this.getSocks5ProxyHost();
        result = result * 59 + ($socks5ProxyHost == null ? 43 : $socks5ProxyHost.hashCode());
        String $socks5ProxyUsername = this.getSocks5ProxyUsername();
        result = result * 59 + ($socks5ProxyUsername == null ? 43 : $socks5ProxyUsername.hashCode());
        String $socks5ProxyPassword = this.getSocks5ProxyPassword();
        result = result * 59 + ($socks5ProxyPassword == null ? 43 : $socks5ProxyPassword.hashCode());
        return result;
    }

    public String toString() {
        return "BaseLiveChatClientConfig(propertyChangeSupport=" + this.getPropertyChangeSupport() + ", websocketUri=" + this.getWebsocketUri() + ", forwardWebsocketUri=" + this.getForwardWebsocketUri() + ", cookie=" + this.getCookie() + ", roomId=" + this.getRoomId() + ", autoReconnect=" + this.isAutoReconnect() + ", reconnectDelay=" + this.getReconnectDelay() + ", heartbeatInitialDelay=" + this.getHeartbeatInitialDelay() + ", heartbeatPeriod=" + this.getHeartbeatPeriod() + ", minSendDanmuPeriod=" + this.getMinSendDanmuPeriod() + ", handshakeTimeoutMillis=" + this.getHandshakeTimeoutMillis() + ", socks5ProxyHost=" + this.getSocks5ProxyHost() + ", socks5ProxyPort=" + this.getSocks5ProxyPort() + ", socks5ProxyUsername=" + this.getSocks5ProxyUsername() + ", socks5ProxyPassword=" + this.getSocks5ProxyPassword() + ")";
    }

    public BaseLiveChatClientConfig() {
        this.autoReconnect = BaseLiveChatClientConfig.$default$autoReconnect();
        this.reconnectDelay = BaseLiveChatClientConfig.$default$reconnectDelay();
        this.heartbeatInitialDelay = BaseLiveChatClientConfig.$default$heartbeatInitialDelay();
        this.heartbeatPeriod = BaseLiveChatClientConfig.$default$heartbeatPeriod();
        this.minSendDanmuPeriod = BaseLiveChatClientConfig.$default$minSendDanmuPeriod();
        this.handshakeTimeoutMillis = BaseLiveChatClientConfig.$default$handshakeTimeoutMillis();
    }

    public BaseLiveChatClientConfig(String websocketUri, String forwardWebsocketUri, String cookie, Object roomId, boolean autoReconnect, int reconnectDelay, long heartbeatInitialDelay, long heartbeatPeriod, long minSendDanmuPeriod, long handshakeTimeoutMillis, String socks5ProxyHost, int socks5ProxyPort, String socks5ProxyUsername, String socks5ProxyPassword) {
        this.websocketUri = websocketUri;
        this.forwardWebsocketUri = forwardWebsocketUri;
        this.cookie = cookie;
        this.roomId = roomId;
        this.autoReconnect = autoReconnect;
        this.reconnectDelay = reconnectDelay;
        this.heartbeatInitialDelay = heartbeatInitialDelay;
        this.heartbeatPeriod = heartbeatPeriod;
        this.minSendDanmuPeriod = minSendDanmuPeriod;
        this.handshakeTimeoutMillis = handshakeTimeoutMillis;
        this.socks5ProxyHost = socks5ProxyHost;
        this.socks5ProxyPort = socks5ProxyPort;
        this.socks5ProxyUsername = socks5ProxyUsername;
        this.socks5ProxyPassword = socks5ProxyPassword;
    }

    public static abstract class BaseLiveChatClientConfigBuilder<C extends BaseLiveChatClientConfig, B extends BaseLiveChatClientConfigBuilder<C, B>> {
        private String websocketUri;
        private String forwardWebsocketUri;
        private String cookie;
        private Object roomId;
        private boolean autoReconnect$set;
        private boolean autoReconnect$value;
        private boolean reconnectDelay$set;
        private int reconnectDelay$value;
        private boolean heartbeatInitialDelay$set;
        private long heartbeatInitialDelay$value;
        private boolean heartbeatPeriod$set;
        private long heartbeatPeriod$value;
        private boolean minSendDanmuPeriod$set;
        private long minSendDanmuPeriod$value;
        private boolean handshakeTimeoutMillis$set;
        private long handshakeTimeoutMillis$value;
        private String socks5ProxyHost;
        private int socks5ProxyPort;
        private String socks5ProxyUsername;
        private String socks5ProxyPassword;

        protected B $fillValuesFrom(C instance) {
            BaseLiveChatClientConfigBuilder.$fillValuesFromInstanceIntoBuilder(instance, this);
            return this.self();
        }

        private static void $fillValuesFromInstanceIntoBuilder(BaseLiveChatClientConfig instance, BaseLiveChatClientConfigBuilder<?, ?> b) {
            b.websocketUri(instance.websocketUri);
            b.forwardWebsocketUri(instance.forwardWebsocketUri);
            b.cookie(instance.cookie);
            b.roomId(instance.roomId);
            b.autoReconnect(instance.autoReconnect);
            b.reconnectDelay(instance.reconnectDelay);
            b.heartbeatInitialDelay(instance.heartbeatInitialDelay);
            b.heartbeatPeriod(instance.heartbeatPeriod);
            b.minSendDanmuPeriod(instance.minSendDanmuPeriod);
            b.handshakeTimeoutMillis(instance.handshakeTimeoutMillis);
            b.socks5ProxyHost(instance.socks5ProxyHost);
            b.socks5ProxyPort(instance.socks5ProxyPort);
            b.socks5ProxyUsername(instance.socks5ProxyUsername);
            b.socks5ProxyPassword(instance.socks5ProxyPassword);
        }

        public B websocketUri(String websocketUri) {
            this.websocketUri = websocketUri;
            return this.self();
        }

        public B forwardWebsocketUri(String forwardWebsocketUri) {
            this.forwardWebsocketUri = forwardWebsocketUri;
            return this.self();
        }

        public B cookie(String cookie) {
            this.cookie = cookie;
            return this.self();
        }

        public B roomId(Object roomId) {
            this.roomId = roomId;
            return this.self();
        }

        public B autoReconnect(boolean autoReconnect) {
            this.autoReconnect$value = autoReconnect;
            this.autoReconnect$set = true;
            return this.self();
        }

        public B reconnectDelay(int reconnectDelay) {
            this.reconnectDelay$value = reconnectDelay;
            this.reconnectDelay$set = true;
            return this.self();
        }

        public B heartbeatInitialDelay(long heartbeatInitialDelay) {
            this.heartbeatInitialDelay$value = heartbeatInitialDelay;
            this.heartbeatInitialDelay$set = true;
            return this.self();
        }

        public B heartbeatPeriod(long heartbeatPeriod) {
            this.heartbeatPeriod$value = heartbeatPeriod;
            this.heartbeatPeriod$set = true;
            return this.self();
        }

        public B minSendDanmuPeriod(long minSendDanmuPeriod) {
            this.minSendDanmuPeriod$value = minSendDanmuPeriod;
            this.minSendDanmuPeriod$set = true;
            return this.self();
        }

        public B handshakeTimeoutMillis(long handshakeTimeoutMillis) {
            this.handshakeTimeoutMillis$value = handshakeTimeoutMillis;
            this.handshakeTimeoutMillis$set = true;
            return this.self();
        }

        public B socks5ProxyHost(String socks5ProxyHost) {
            this.socks5ProxyHost = socks5ProxyHost;
            return this.self();
        }

        public B socks5ProxyPort(int socks5ProxyPort) {
            this.socks5ProxyPort = socks5ProxyPort;
            return this.self();
        }

        public B socks5ProxyUsername(String socks5ProxyUsername) {
            this.socks5ProxyUsername = socks5ProxyUsername;
            return this.self();
        }

        public B socks5ProxyPassword(String socks5ProxyPassword) {
            this.socks5ProxyPassword = socks5ProxyPassword;
            return this.self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "BaseLiveChatClientConfig.BaseLiveChatClientConfigBuilder(websocketUri=" + this.websocketUri + ", forwardWebsocketUri=" + this.forwardWebsocketUri + ", cookie=" + this.cookie + ", roomId=" + this.roomId + ", autoReconnect$value=" + this.autoReconnect$value + ", reconnectDelay$value=" + this.reconnectDelay$value + ", heartbeatInitialDelay$value=" + this.heartbeatInitialDelay$value + ", heartbeatPeriod$value=" + this.heartbeatPeriod$value + ", minSendDanmuPeriod$value=" + this.minSendDanmuPeriod$value + ", handshakeTimeoutMillis$value=" + this.handshakeTimeoutMillis$value + ", socks5ProxyHost=" + this.socks5ProxyHost + ", socks5ProxyPort=" + this.socks5ProxyPort + ", socks5ProxyUsername=" + this.socks5ProxyUsername + ", socks5ProxyPassword=" + this.socks5ProxyPassword + ")";
        }
    }
}

