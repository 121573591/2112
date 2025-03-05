/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1564
 *  net.minecraft.class_1688
 *  net.minecraft.class_1937
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.stage;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaP;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import cn.pixellive.mc.game.PixelLiveGameMod;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1564;
import net.minecraft.class_1688;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1688.class})
public abstract class PeakChallengeCartSpeedMixin
extends class_1297 {
    private int tickCounter = 0;

    public PeakChallengeCartSpeedMixin(class_1299<?> class_12992, class_1937 class_19372) {
        super(class_12992, class_19372);
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void injectTick(CallbackInfo callbackInfo) {
        aaaaas aaaaas2 = PixelLiveGameMod.你为什么要破解我的代码aaaaaR();
        if (!(!(aaaaas2 instanceof aaaaaP) || this.method_5782() && this.method_31483() instanceof class_1564)) {
            ++this.tickCounter;
            if (this.tickCounter % 2 == 0) {
                this.method_5773();
            }
        }
    }
}

