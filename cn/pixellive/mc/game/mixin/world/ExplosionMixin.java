/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_1927
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.world;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaag;
import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.game.ExplosionEvent;
import net.minecraft.class_1927;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1927.class})
public class ExplosionMixin {
    @Inject(method={"affectWorld"}, at={@At(value="HEAD")}, cancellable=true)
    public void affectWorldInject(boolean bl, CallbackInfo callbackInfo) {
        ExplosionEvent explosionEvent = new ExplosionEvent((class_1927)aaaaag.你为什么要破解我的代码aaaaaa(this), bl);
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)explosionEvent);
        if (explosionEvent.getCancelled()) {
            callbackInfo.cancel();
        }
    }
}

