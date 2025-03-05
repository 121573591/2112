/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1927
 *  org.jetbrains.annotations.NotNull
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 */
package cn.pixellive.mc.game.event.game;

import cn.pixellive.mc.game.event.CancellableEvent;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1927;
import org.jetbrains.annotations.NotNull;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;

public final class ExplosionEvent
extends CancellableEvent {
    @NotNull
    private final class_1927 explosion;
    private final boolean particles;
    public static boolean $skidonion$1125654744;

    public ExplosionEvent(@NotNull class_1927 class_19272, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)class_19272, (String)((String)ExplosionEvent.aaaaaa((char)-1790705664)));
        this.explosion = class_19272;
        this.particles = bl;
    }

    @NotNull
    public final class_1927 getExplosion() {
        return this.explosion;
    }

    public final boolean getParticles() {
        return this.particles;
    }

    static {
        ___.___(332, ExplosionEvent.class);
        ____.___332_30(ExplosionEvent.class);
    }

    private static native Object aaaaaa(char var0);
}

