/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.net.Socket
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.net.Socket;
import kotlin.Metadata;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" (\n\n \n\n\b\n\n\b\n\n\b\n\n\b\bf 20J0H&¢\bJ0H&¢\bJ\t0\bH&¢\b\t\nJ\f0H&¢\b\f\r¨"}, d2={"Lokhttp3/Connection;", "", "Lokhttp3/Handshake;", "handshake", "()Lokhttp3/Handshake;", "Lokhttp3/Protocol;", "protocol", "()Lokhttp3/Protocol;", "Lokhttp3/Route;", "route", "()Lokhttp3/Route;", "Ljava/net/Socket;", "socket", "()Ljava/net/Socket;", "okhttp"})
public interface Connection {
    @NotNull
    public Route route();

    @NotNull
    public Socket socket();

    @Nullable
    public Handshake handshake();

    @NotNull
    public Protocol protocol();
}

