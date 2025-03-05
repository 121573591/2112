/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.stage;

import cn.pixellive.mc.game.PixelLiveGameMod;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1657.class})
public class PreventItemDropMixin {
    @Inject(method={"dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;"}, at={@At(value="HEAD")}, cancellable=true)
    private void onDropItem(class_1799 class_17992, boolean bl, boolean bl2, CallbackInfoReturnable<?> callbackInfoReturnable) {
        String string;
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() != null && PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj() != null && ((string = PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj()).equals((Object)"保卫小麦") || string.equals((Object)"建筑守卫战"))) {
            class_1657 class_16572 = (class_1657)this;
            if (!class_17992.method_7909().method_7876().startsWith("item.pointblank")) {
                callbackInfoReturnable.setReturnValue(null);
                callbackInfoReturnable.cancel();
                class_16572.method_31548().method_7394(class_17992.method_7972());
            }
        }
    }
}

