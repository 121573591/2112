/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  net.minecraft.class_1308
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.stage;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import cn.pixellive.mc.game.PixelLiveGameMod;
import net.minecraft.class_1308;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1308.class})
public class UndeadEntityBurnMixin {
    @Inject(method={"isAffectedByDaylight"}, at={@At(value="HEAD")}, cancellable=true)
    private void preventDaylightBurning(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        String string;
        aaaaas aaaaas2 = PixelLiveGameMod.你为什么要破解我的代码aaaaaR();
        if (aaaaas2 != null && ((string = aaaaas2.你为什么要破解我的代码aaaaaj()) != null && (string.equalsIgnoreCase("逆境突围") || string.equalsIgnoreCase("怪兽争霸赛") || string.equalsIgnoreCase("保卫小麦")) || string.equalsIgnoreCase("建筑守卫战"))) {
            callbackInfoReturnable.setReturnValue((Object)false);
        }
    }
}

