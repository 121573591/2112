/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_3572
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.world;

import cn.pixellive.mc.game.PixelLiveGameMod;
import net.minecraft.class_3572;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_3572.class})
public class ChunkSkyLightMixin {
    @Inject(method={"method_51586"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSkyLightUpdate(CallbackInfo callbackInfo) {
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() != null && PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj().equalsIgnoreCase("勇攀高峰")) {
            callbackInfo.cancel();
        }
    }
}

