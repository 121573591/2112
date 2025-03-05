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

public final class LiveGiftEvent {
    @NotNull
    private final String username;
    @NotNull
    private final String giftName;
    private int giftCount;
    @NotNull
    private final String liveType;
    @NotNull
    private final String avatar;
    public static boolean $skidonion$503573557;

    public LiveGiftEvent(@NotNull String string, @NotNull String string2, int n, @NotNull String string3, @NotNull String string4) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)LiveGiftEvent.aaaaaa((char)-175767552)));
        Intrinsics.checkNotNullParameter((Object)string2, (String)((String)LiveGiftEvent.aaaaaa((char)-1509621759)));
        Intrinsics.checkNotNullParameter((Object)string3, (String)((String)LiveGiftEvent.aaaaaa((char)765198338)));
        Intrinsics.checkNotNullParameter((Object)string4, (String)((String)LiveGiftEvent.aaaaaa((char)-675938301)));
        this.username = string;
        this.giftName = string2;
        this.giftCount = n;
        this.liveType = string3;
        this.avatar = string4;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    @NotNull
    public final String getGiftName() {
        return this.giftName;
    }

    public final int getGiftCount() {
        return this.giftCount;
    }

    public final void setGiftCount(int n) {
        this.giftCount = n;
    }

    @NotNull
    public final String getLiveType() {
        return this.liveType;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    static {
        ___.___(329, LiveGiftEvent.class);
        ____.___329_70(LiveGiftEvent.class);
    }

    private static native Object aaaaaa(char var0);
}

