/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1269
 *  net.minecraft.class_1750
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 */
package cn.pixellive.mc.game.event.game;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1269;
import net.minecraft.class_1750;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;

public final class BlockPlaceEvent {
    @NotNull
    private final class_1750 context;
    @Nullable
    private class_1269 result;
    public static boolean $skidonion$1262859261;

    public BlockPlaceEvent(@NotNull class_1750 class_17502, @Nullable class_1269 class_12692) {
        Intrinsics.checkNotNullParameter((Object)class_17502, (String)((String)BlockPlaceEvent.aaaaaa((char)-45875200)));
        this.context = class_17502;
        this.result = class_12692;
    }

    public /* synthetic */ BlockPlaceEvent(class_1750 class_17502, class_1269 class_12692, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            class_12692 = null;
        }
        this(class_17502, class_12692);
    }

    @NotNull
    public final class_1750 getContext() {
        return this.context;
    }

    @Nullable
    public final class_1269 getResult() {
        return this.result;
    }

    public final void setResult(@Nullable class_1269 class_12692) {
        this.result = class_12692;
    }

    static {
        ___.___(342, BlockPlaceEvent.class);
        ____.___342_50(BlockPlaceEvent.class);
    }

    private static native Object aaaaaa(char var0);
}

