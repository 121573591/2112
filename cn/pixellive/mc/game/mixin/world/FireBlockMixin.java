/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2358
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.world;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaao;
import cn.pixellive.mc.game.PixelLiveGameMod;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2358;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2358.class})
public class FireBlockMixin {
    @Inject(method={"trySpreadingFire"}, at={@At(value="HEAD")}, cancellable=true)
    private void onFireSpread(class_1937 class_19372, class_2338 class_23382, int n, class_5819 class_58192, int n2, CallbackInfo callbackInfo) {
        aaaaao aaaaao2;
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() != null && PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj().equals((Object)"建筑守卫战") && !(aaaaao2 = aaaaao.我草你怎么反编译我模组aaaabo).你为什么要破解我的代码aaaacT(class_23382)) {
            this.clearFireInRadius(class_19372, class_23382, 3);
            callbackInfo.cancel();
        }
    }

    @Inject(method={"trySpreadingFire"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/World;removeBlock(Lnet/minecraft/util/math/BlockPos;Z)Z")})
    private void onBlockBurned(class_1937 class_19372, class_2338 class_23382, int n, class_5819 class_58192, int n2, CallbackInfo callbackInfo) {
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() != null && PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj().equals((Object)"建筑守卫战")) {
            aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaadi(class_23382);
        }
    }

    @Unique
    private void clearFireInRadius(class_1937 class_19372, class_2338 class_23382, int n) {
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    class_23392.method_10103(class_23382.method_10263() + i, class_23382.method_10264() + j, class_23382.method_10260() + k);
                    if (class_19372.method_8320((class_2338)class_23392).method_26204() != class_2246.field_10036) continue;
                    class_19372.method_8650((class_2338)class_23392, false);
                }
            }
        }
    }
}

