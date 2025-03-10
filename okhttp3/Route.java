/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 4\n\n \n\n \n\n \n\n\b\n\n\b\n\b\n\b\b\n\n\b 20B000¢\b\b\tJ0H¢\b\nJ0\r2\b\f0H¢\bJ0H¢\bJ0H¢\bJ\r0\r¢\bJ0H¢\bJ0H¢\bR08¢\f\n\b\bR08¢\f\n\b\bR08¢\f\n\b\b¨"}, d2={"Lokhttp3/Route;", "", "Lokhttp3/Address;", "address", "Ljava/net/Proxy;", "proxy", "Ljava/net/InetSocketAddress;", "socketAddress", "<init>", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "-deprecated_address", "()Lokhttp3/Address;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "-deprecated_proxy", "()Ljava/net/Proxy;", "requiresTunnel", "()Z", "-deprecated_socketAddress", "()Ljava/net/InetSocketAddress;", "", "toString", "()Ljava/lang/String;", "Lokhttp3/Address;", "Ljava/net/Proxy;", "Ljava/net/InetSocketAddress;", "okhttp"})
public final class Route {
    @NotNull
    private final Address address;
    @NotNull
    private final Proxy proxy;
    @NotNull
    private final InetSocketAddress socketAddress;

    public Route(@NotNull Address address, @NotNull Proxy proxy, @NotNull InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        Intrinsics.checkNotNullParameter((Object)proxy, (String)"proxy");
        Intrinsics.checkNotNullParameter((Object)socketAddress, (String)"socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    @JvmName(name="address")
    @NotNull
    public final Address address() {
        return this.address;
    }

    @JvmName(name="proxy")
    @NotNull
    public final Proxy proxy() {
        return this.proxy;
    }

    @JvmName(name="socketAddress")
    @NotNull
    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="address", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_address")
    @NotNull
    public final Address -deprecated_address() {
        return this.address;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="proxy", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_proxy")
    @NotNull
    public final Proxy -deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="socketAddress", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_socketAddress")
    @NotNull
    public final InetSocketAddress -deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof Route && Intrinsics.areEqual((Object)((Route)other).address, (Object)this.address) && Intrinsics.areEqual((Object)((Route)other).proxy, (Object)this.proxy) && Intrinsics.areEqual((Object)((Route)other).socketAddress, (Object)this.socketAddress);
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.address.hashCode();
        result = 31 * result + this.proxy.hashCode();
        result = 31 * result + this.socketAddress.hashCode();
        return result;
    }

    @NotNull
    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}

