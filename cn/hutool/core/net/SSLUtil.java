/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.TrustManager
 */
package cn.hutool.core.net;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.net.SSLContextBuilder;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class SSLUtil {
    public static SSLContext createSSLContext(String protocol) throws IORuntimeException {
        return SSLContextBuilder.create().setProtocol(protocol).build();
    }

    public static SSLContext createSSLContext(String protocol, KeyManager keyManager, TrustManager trustManager) throws IORuntimeException {
        TrustManager[] trustManagerArray;
        KeyManager[] keyManagerArray;
        if (keyManager == null) {
            keyManagerArray = null;
        } else {
            KeyManager[] keyManagerArray2 = new KeyManager[1];
            keyManagerArray = keyManagerArray2;
            keyManagerArray2[0] = keyManager;
        }
        if (trustManager == null) {
            trustManagerArray = null;
        } else {
            TrustManager[] trustManagerArray2 = new TrustManager[1];
            trustManagerArray = trustManagerArray2;
            trustManagerArray2[0] = trustManager;
        }
        return SSLUtil.createSSLContext(protocol, keyManagerArray, trustManagerArray);
    }

    public static SSLContext createSSLContext(String protocol, KeyManager[] keyManagers, TrustManager[] trustManagers) throws IORuntimeException {
        return SSLContextBuilder.create().setProtocol(protocol).setKeyManagers(keyManagers).setTrustManagers(trustManagers).build();
    }
}

