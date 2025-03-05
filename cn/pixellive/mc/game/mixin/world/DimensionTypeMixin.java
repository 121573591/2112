/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  net.minecraft.class_2874
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.world;

import net.minecraft.class_2874;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2874.class})
public class DimensionTypeMixin {
    @Inject(method={"height"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetHeight(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue((Object)2000);
    }

    @Inject(method={"logicalHeight"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetLogicalHeight(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue((Object)2000);
    }

    @Inject(method={"minY"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetMinY(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue((Object)-64);
    }
}

