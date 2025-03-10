/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.net.SocketAddress
 *  java.net.URI
 *  java.util.List
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 2\n\n\n\b\n\n \n\n \n\n \n\n\b\n \n\n\b\bÆ 20B\t\b¢\bJ-0\n2\b02\b02\b\t0\bH¢\b\fJ\b00\r2\b0H¢\b¨"}, d2={"Lokhttp3/internal/proxy/NullProxySelector;", "Ljava/net/ProxySelector;", "<init>", "()V", "Ljava/net/URI;", "uri", "Ljava/net/SocketAddress;", "sa", "Ljava/io/IOException;", "ioe", "", "connectFailed", "(Ljava/net/URI;Ljava/net/SocketAddress;Ljava/io/IOException;)V", "", "Ljava/net/Proxy;", "select", "(Ljava/net/URI;)Ljava/util/List;", "okhttp"})
@SourceDebugExtension(value={"SMAP\nNullProxySelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullProxySelector.kt\nokhttp3/internal/proxy/NullProxySelector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n1#2:37\n*E\n"})
public final class NullProxySelector
extends ProxySelector {
    @NotNull
    public static final NullProxySelector INSTANCE = new NullProxySelector();

    private NullProxySelector() {
    }

    @NotNull
    public List<Proxy> select(@Nullable URI uri) {
        if (uri == null) {
            boolean bl = false;
            String string = "uri must not be null";
            throw new IllegalArgumentException(string.toString());
        }
        return CollectionsKt.listOf((Object)Proxy.NO_PROXY);
    }

    public void connectFailed(@Nullable URI uri, @Nullable SocketAddress sa, @Nullable IOException ioe) {
    }
}

