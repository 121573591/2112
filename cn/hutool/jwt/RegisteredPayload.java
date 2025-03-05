/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package cn.hutool.jwt;

import java.util.Date;

public interface RegisteredPayload<T extends RegisteredPayload<T>> {
    public static final String ISSUER = "iss";
    public static final String SUBJECT = "sub";
    public static final String AUDIENCE = "aud";
    public static final String EXPIRES_AT = "exp";
    public static final String NOT_BEFORE = "nbf";
    public static final String ISSUED_AT = "iat";
    public static final String JWT_ID = "jti";

    default public T setIssuer(String issuer) {
        return this.setPayload(ISSUER, issuer);
    }

    default public T setSubject(String subject) {
        return this.setPayload(SUBJECT, subject);
    }

    default public T setAudience(String ... audience) {
        return this.setPayload(AUDIENCE, audience);
    }

    default public T setExpiresAt(Date expiresAt) {
        return this.setPayload(EXPIRES_AT, expiresAt);
    }

    default public T setNotBefore(Date notBefore) {
        return this.setPayload(NOT_BEFORE, notBefore);
    }

    default public T setIssuedAt(Date issuedAt) {
        return this.setPayload(ISSUED_AT, issuedAt);
    }

    default public T setJWTId(String jwtId) {
        return this.setPayload(JWT_ID, jwtId);
    }

    public T setPayload(String var1, Object var2);
}

