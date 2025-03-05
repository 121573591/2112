/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  org.jetbrains.annotations.NotNull
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 */
package cn.pixellive.mc.game.event.game;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import org.jetbrains.annotations.NotNull;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;

public final class BlockBreakEvent {
    @NotNull
    private final class_1657 player;
    @NotNull
    private final class_1937 world;
    @NotNull
    private final class_2338 pos;
    @NotNull
    private final class_2248 block;
    public static boolean $skidonion$1462669563;

    public BlockBreakEvent(@NotNull class_1657 class_16572, @NotNull class_1937 class_19372, @NotNull class_2338 class_23382, @NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_16572, (String)((String)BlockBreakEvent.aaaaaa((char)-1990852608)));
        Intrinsics.checkNotNullParameter((Object)class_19372, (String)((String)BlockBreakEvent.aaaaaa((char)-1289355263)));
        Intrinsics.checkNotNullParameter((Object)class_23382, (String)((String)BlockBreakEvent.aaaaaa((char)649986050)));
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)((String)BlockBreakEvent.aaaaaa((char)-801374205)));
        this.player = class_16572;
        this.world = class_19372;
        this.pos = class_23382;
        this.block = class_22482;
    }

    @NotNull
    public final class_1657 getPlayer() {
        return this.player;
    }

    @NotNull
    public final class_1937 getWorld() {
        return this.world;
    }

    @NotNull
    public final class_2338 getPos() {
        return this.pos;
    }

    @NotNull
    public final class_2248 getBlock() {
        return this.block;
    }

    static {
        ___.___(337, BlockBreakEvent.class);
        ____.___337_50(BlockBreakEvent.class);
    }

    private static native Object aaaaaa(char var0);
}

