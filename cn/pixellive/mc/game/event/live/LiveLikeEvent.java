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

public final class LiveLikeEvent {
    @NotNull
    private final String username;
    private final int likeCount;
    public static boolean $skidonion$230650322;

    public LiveLikeEvent(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)LiveLikeEvent.aaaaaa((char)1788805120)));
        this.username = string;
        this.likeCount = n;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    static {
        ___.___(341, LiveLikeEvent.class);
        ____.___341_30(LiveLikeEvent.class);
    }

    private static native Object aaaaaa(char var0);
}

