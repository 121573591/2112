/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  net.minecraft.class_1309
 *  net.minecraft.class_310
 *  net.minecraft.class_922
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.stage;

import cn.pixellive.mc.game.PixelLiveGameMod;
import net.minecraft.class_1309;
import net.minecraft.class_310;
import net.minecraft.class_922;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_922.class})
public abstract class LivingEntityRendererMixin<T extends class_1309> {
    @Inject(method={"hasLabel*"}, at={@At(value="HEAD")}, cancellable=true)
    private void onHasLabel(T t, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (t.method_16914()) {
            if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() != null) {
                if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj().equalsIgnoreCase("怪兽竞技场") || PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj().equalsIgnoreCase("怪兽争霸赛")) {
                    callbackInfoReturnable.setReturnValue((Object)true);
                } else if (!class_310.method_1551().field_1690.field_1842) {
                    callbackInfoReturnable.setReturnValue((Object)true);
                }
            } else if (!class_310.method_1551().field_1690.field_1842) {
                callbackInfoReturnable.setReturnValue((Object)true);
            }
        }
    }
}

