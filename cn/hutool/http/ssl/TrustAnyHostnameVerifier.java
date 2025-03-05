/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSession
 */
package cn.hutool.http.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class TrustAnyHostnameVerifier
implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}

