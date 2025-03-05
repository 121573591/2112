/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  net.minecraft.class_1297
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.common;

import net.minecraft.class_1297;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1297.class})
public class EntityNameDisplayMixin {
    @Inject(method={"isCustomNameVisible"}, at={@At(value="RETURN")}, cancellable=true)
    private void alwaysShowCustomName(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        class_1297 class_12972 = (class_1297)this;
        if (class_12972.method_16914()) {
            callbackInfoReturnable.setReturnValue((Object)true);
        }
    }
}

