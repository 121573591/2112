/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
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
public abstract class EntityIsRemovedMixin {
    @Inject(method={"isRemoved"}, at={@At(value="HEAD")}, cancellable=true)
    private void onIsRemoved(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        try {
            callbackInfoReturnable.setReturnValue((Object)(((class_1297)this).method_35049() != null ? 1 : 0));
        }
        catch (Exception exception) {
            callbackInfoReturnable.setReturnValue((Object)true);
        }
    }

    @Inject(method={"getRemovalReason"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetRemovalReason(CallbackInfoReturnable<class_1297.class_5529> callbackInfoReturnable) {
    }
}

