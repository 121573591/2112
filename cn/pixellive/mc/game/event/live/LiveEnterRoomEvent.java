/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 */
package cn.pixellive.mc.game.event.live;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;

public final class LiveEnterRoomEvent {
    @NotNull
    private final String username;
    public static boolean $skidonion$674325628;

    public LiveEnterRoomEvent(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)LiveEnterRoomEvent.aaaaaa((char)2059272192)));
        this.username = string;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    static {
        ___.___(333, LiveEnterRoomEvent.class);
        ____.___333_20(LiveEnterRoomEvent.class);
    }

    private static native Object aaaaaa(char var0);
}

