/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.ObjectUtil
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.Callable
 */
package io.netty.handler.codec.http.cors;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.cors.CorsConfig;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public final class CorsConfigBuilder {
    final Set<String> origins;
    final boolean anyOrigin;
    boolean allowNullOrigin;
    boolean enabled = true;
    boolean allowCredentials;
    final Set<String> exposeHeaders = new HashSet();
    long maxAge;
    final Set<HttpMethod> requestMethods = new HashSet();
    final Set<String> requestHeaders = new HashSet();
    final Map<CharSequence, Callable<?>> preflightHeaders = new HashMap();
    private boolean noPreflightHeaders;
    boolean shortCircuit;
    boolean allowPrivateNetwork;

    public static CorsConfigBuilder forAnyOrigin() {
        return new CorsConfigBuilder();
    }

    public static CorsConfigBuilder forOrigin(String origin) {
        if ("*".equals((Object)origin)) {
            return new CorsConfigBuilder();
        }
        return new CorsConfigBuilder(origin);
    }

    public static CorsConfigBuilder forOrigins(String ... origins) {
        return new CorsConfigBuilder(origins);
    }

    CorsConfigBuilder(String ... origins) {
        this.origins = new LinkedHashSet((Collection)Arrays.asList((Object[])origins));
        this.anyOrigin = false;
    }

    CorsConfigBuilder() {
        this.anyOrigin = true;
        this.origins = Collections.emptySet();
    }

    public CorsConfigBuilder allowNullOrigin() {
        this.allowNullOrigin = true;
        return this;
    }

    public CorsConfigBuilder disable() {
        this.enabled = false;
        return this;
    }

    public CorsConfigBuilder exposeHeaders(String ... headers) {
        this.exposeHeaders.addAll((Collection)Arrays.asList((Object[])headers));
        return this;
    }

    public CorsConfigBuilder exposeHeaders(CharSequence ... headers) {
        for (CharSequence header : headers) {
            this.exposeHeaders.add((Object)header.toString());
        }
        return this;
    }

    public CorsConfigBuilder allowCredentials() {
        this.allowCredentials = true;
        return this;
    }

    public CorsConfigBuilder maxAge(long max) {
        this.maxAge = max;
        return this;
    }

    public CorsConfigBuilder allowedRequestMethods(HttpMethod ... methods) {
        this.requestMethods.addAll((Collection)Arrays.asList((Object[])methods));
        return this;
    }

    public CorsConfigBuilder allowedRequestHeaders(String ... headers) {
        this.requestHeaders.addAll((Collection)Arrays.asList((Object[])headers));
        return this;
    }

    public CorsConfigBuilder allowedRequestHeaders(CharSequence ... headers) {
        for (CharSequence header : headers) {
            this.requestHeaders.add((Object)header.toString());
        }
        return this;
    }

    public CorsConfigBuilder preflightResponseHeader(CharSequence name, Object ... values) {
        if (values.length == 1) {
            this.preflightHeaders.put((Object)name, (Object)new ConstantValueGenerator(values[0]));
        } else {
            this.preflightResponseHeader(name, (Iterable)Arrays.asList((Object[])values));
        }
        return this;
    }

    public <T> CorsConfigBuilder preflightResponseHeader(CharSequence name, Iterable<T> value) {
        this.preflightHeaders.put((Object)name, (Object)new ConstantValueGenerator(value));
        return this;
    }

    public <T> CorsConfigBuilder preflightResponseHeader(CharSequence name, Callable<T> valueGenerator) {
        this.preflightHeaders.put((Object)name, valueGenerator);
        return this;
    }

    public CorsConfigBuilder noPreflightResponseHeaders() {
        this.noPreflightHeaders = true;
        return this;
    }

    public CorsConfigBuilder shortCircuit() {
        this.shortCircuit = true;
        return this;
    }

    public CorsConfigBuilder allowPrivateNetwork() {
        this.allowPrivateNetwork = true;
        return this;
    }

    public CorsConfig build() {
        if (this.preflightHeaders.isEmpty() && !this.noPreflightHeaders) {
            this.preflightHeaders.put((Object)HttpHeaderNames.DATE, (Object)DateValueGenerator.INSTANCE);
            this.preflightHeaders.put((Object)HttpHeaderNames.CONTENT_LENGTH, (Object)new ConstantValueGenerator("0"));
        }
        return new CorsConfig(this);
    }

    private static final class DateValueGenerator
    implements Callable<Date> {
        static final DateValueGenerator INSTANCE = new DateValueGenerator();

        private DateValueGenerator() {
        }

        public Date call() throws Exception {
            return new Date();
        }
    }

    private static final class ConstantValueGenerator
    implements Callable<Object> {
        private final Object value;

        private ConstantValueGenerator(Object value) {
            this.value = ObjectUtil.checkNotNullWithIAE((Object)value, (String)"value");
        }

        public Object call() {
            return this.value;
        }
    }
}

