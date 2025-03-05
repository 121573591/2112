/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 */
package cn.pixellive.mc.game.event.game;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;

public final class AttackBlockEvent {
    @NotNull
    private final class_1657 player;
    @NotNull
    private final class_1937 world;
    @NotNull
    private final class_2338 pos;
    public static boolean $skidonion$191753304;

    public AttackBlockEvent(@NotNull class_1657 class_16572, @NotNull class_1937 class_19372, @NotNull class_2338 class_23382) {
        Intrinsics.checkNotNullParameter((Object)class_16572, (String)((String)AttackBlockEvent.aaaaaa((char)617086976)));
        Intrinsics.checkNotNullParameter((Object)class_19372, (String)((String)AttackBlockEvent.aaaaaa((char)-1070399487)));
        Intrinsics.checkNotNullParameter((Object)class_23382, (String)((String)AttackBlockEvent.aaaaaa((char)429719554)));
        this.player = class_16572;
        this.world = class_19372;
        this.pos = class_23382;
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
    public final class_1657 component1() {
        return this.player;
    }

    @NotNull
    public final class_1937 component2() {
        return this.world;
    }

    @NotNull
    public final class_2338 component3() {
        return this.pos;
    }

    @NotNull
    public final AttackBlockEvent copy(@NotNull class_1657 class_16572, @NotNull class_1937 class_19372, @NotNull class_2338 class_23382) {
        Intrinsics.checkNotNullParameter((Object)class_16572, (String)((String)AttackBlockEvent.aaaaaa((char)2068119552)));
        Intrinsics.checkNotNullParameter((Object)class_19372, (String)((String)AttackBlockEvent.aaaaaa((char)-2136997887)));
        Intrinsics.checkNotNullParameter((Object)class_23382, (String)((String)AttackBlockEvent.aaaaaa((char)-1810497534)));
        return new AttackBlockEvent(class_16572, class_19372, class_23382);
    }

    public static /* synthetic */ AttackBlockEvent copy$default(AttackBlockEvent attackBlockEvent, class_1657 class_16572, class_1937 class_19372, class_2338 class_23382, int n, Object object) {
        if ((n & 1) != 0) {
            class_16572 = attackBlockEvent.player;
        }
        if ((n & 2) != 0) {
            class_19372 = attackBlockEvent.world;
        }
        if ((n & 4) != 0) {
            class_23382 = attackBlockEvent.pos;
        }
        return attackBlockEvent.copy(class_16572, class_19372, class_23382);
    }

    @NotNull
    public String toString() {
        return "AttackBlockEvent(player=" + this.player + ", world=" + this.world + ", pos=" + this.pos + ")";
    }

    public int hashCode() {
        int n = this.player.hashCode();
        n = n * 31 + this.world.hashCode();
        n = n * 31 + this.pos.hashCode();
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AttackBlockEvent)) {
            return false;
        }
        AttackBlockEvent attackBlockEvent = (AttackBlockEvent)object;
        if (!Intrinsics.areEqual((Object)this.player, (Object)attackBlockEvent.player)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.world, (Object)attackBlockEvent.world)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.pos, (Object)attackBlockEvent.pos);
    }

    static {
        ___.___(331, AttackBlockEvent.class);
        ____.___331_120(AttackBlockEvent.class);
    }

    private static native Object aaaaaa(char var0);
}

