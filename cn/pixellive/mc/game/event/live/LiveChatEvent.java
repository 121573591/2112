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

public final class LiveChatEvent {
    @NotNull
    private final String username;
    @NotNull
    private final String message;
    public static boolean $skidonion$1553062669;

    public LiveChatEvent(@NotNull String string, @NotNull String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)LiveChatEvent.aaaaaa((char)2092892160)));
        Intrinsics.checkNotNullParameter((Object)string2, (String)((String)LiveChatEvent.aaaaaa((char)-1109131263)));
        this.username = string;
        this.message = string2;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    static {
        ___.___(340, LiveChatEvent.class);
        ____.___340_30(LiveChatEvent.class);
    }

    private static native Object aaaaaa(char var0);
}

