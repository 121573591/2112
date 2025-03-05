/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Object
 *  net.minecraft.class_1297
 *  net.minecraft.class_1948
 *  net.minecraft.class_1948$class_5260
 *  net.minecraft.class_1948$class_5262
 *  net.minecraft.class_2338
 *  net.minecraft.class_6540
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.common;

import net.minecraft.class_1297;
import net.minecraft.class_1948;
import net.minecraft.class_2338;
import net.minecraft.class_6540;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1948.class})
public class SpawnHelperMixin {
    private static int spawnCount = 0;

    @Redirect(method={"setupSpawn"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;getBlockPos()Lnet/minecraft/util/math/BlockPos;"))
    private static class_2338 redirectGetBlockPos(class_1297 class_12972) {
        try {
            if (class_12972 == null) {
                return null;
            }
            return class_12972.method_24515();
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Inject(method={"setupSpawn"}, at={@At(value="HEAD")})
    private static void onSetupSpawnStart(int n, Iterable<class_1297> iterable, class_1948.class_5260 class_52602, class_6540 class_65402, CallbackInfoReturnable<class_1948.class_5262> callbackInfoReturnable) {
        try {
            spawnCount = 0;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Inject(method={"setupSpawn"}, at={@At(value="INVOKE", target="Ljava/util/Iterator;next()Ljava/lang/Object;")}, cancellable=true)
    private static void onEntityIteration(int n, Iterable<class_1297> iterable, class_1948.class_5260 class_52602, class_6540 class_65402, CallbackInfoReturnable<class_1948.class_5262> callbackInfoReturnable) {
        try {
            ++spawnCount;
            if (class_65402 == null || class_52602 == null) {
                callbackInfoReturnable.setReturnValue(null);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Inject(method={"setupSpawn"}, at={@At(value="RETURN")})
    private static void onSetupSpawnEnd(int n, Iterable<class_1297> iterable, class_1948.class_5260 class_52602, class_6540 class_65402, CallbackInfoReturnable<class_1948.class_5262> callbackInfoReturnable) {
        try {
            spawnCount = 0;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

