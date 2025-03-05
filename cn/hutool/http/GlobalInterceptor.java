/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package cn.hutool.http;

import cn.hutool.http.HttpInterceptor;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

public enum GlobalInterceptor {
    INSTANCE;

    private final HttpInterceptor.Chain<HttpRequest> requestInterceptors = new HttpInterceptor.Chain();
    private final HttpInterceptor.Chain<HttpResponse> responseInterceptors = new HttpInterceptor.Chain();

    public synchronized GlobalInterceptor addRequestInterceptor(HttpInterceptor<HttpRequest> interceptor) {
        this.requestInterceptors.addChain(interceptor);
        return this;
    }

    public synchronized GlobalInterceptor addResponseInterceptor(HttpInterceptor<HttpResponse> interceptor) {
        this.responseInterceptors.addChain(interceptor);
        return this;
    }

    public GlobalInterceptor clear() {
        this.clearRequest();
        this.clearResponse();
        return this;
    }

    public synchronized GlobalInterceptor clearRequest() {
        this.requestInterceptors.clear();
        return this;
    }

    public synchronized GlobalInterceptor clearResponse() {
        this.responseInterceptors.clear();
        return this;
    }

    HttpInterceptor.Chain<HttpRequest> getCopiedRequestInterceptor() {
        HttpInterceptor.Chain<HttpRequest> copied = new HttpInterceptor.Chain<HttpRequest>();
        for (HttpInterceptor httpInterceptor : this.requestInterceptors) {
            copied.addChain(httpInterceptor);
        }
        return copied;
    }

    HttpInterceptor.Chain<HttpResponse> getCopiedResponseInterceptor() {
        HttpInterceptor.Chain<HttpResponse> copied = new HttpInterceptor.Chain<HttpResponse>();
        for (HttpInterceptor httpInterceptor : this.responseInterceptors) {
            copied.addChain(httpInterceptor);
        }
        return copied;
    }
}

