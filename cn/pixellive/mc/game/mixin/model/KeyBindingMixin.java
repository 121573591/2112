/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.model;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaf.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaag.aaaaac;
import net.minecraft.class_304;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_304.class})
public class KeyBindingMixin {
    @Shadow
    private boolean field_1653;

    @Inject(method={"isPressed"}, at={@At(value="HEAD")}, cancellable=true)
    private void onIsPressed(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        aaaaaa aaaaaa2;
        class_304 class_3042 = (class_304)this;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 != null && (aaaaaa2 = aaaaac.我草你怎么反编译我模组aaaafd.你为什么要破解我的代码aaaabQ(class_3102.field_1724.method_5628())) != null && aaaaaa2.你为什么要破解我的代码aaaabg() && this.isMovementBinding(class_3042)) {
            callbackInfoReturnable.setReturnValue((Object)false);
        }
    }

    private boolean isMovementBinding(class_304 class_3042) {
        return class_3042.method_1431().equals((Object)"key.forward") || class_3042.method_1431().equals((Object)"key.left") || class_3042.method_1431().equals((Object)"key.back") || class_3042.method_1431().equals((Object)"key.right") || class_3042.method_1431().equals((Object)"key.jump") || class_3042.method_1431().equals((Object)"key.sneak");
    }
}

