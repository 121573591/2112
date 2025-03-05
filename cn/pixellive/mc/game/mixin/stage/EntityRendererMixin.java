/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_4587
 *  net.minecraft.class_897
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package cn.pixellive.mc.game.mixin.stage;

import cn.pixellive.mc.game.PixelLiveGameMod;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_4587;
import net.minecraft.class_897;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_897.class})
public abstract class EntityRendererMixin<T extends class_1297> {
    @Redirect(method={"renderLabelIfPresent"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/util/math/MatrixStack;scale(FFF)V"))
    private void redirectScale(class_4587 class_45872, float f, float f2, float f3, T t) {
        class_238 class_2383 = t.method_5829();
        double d = (class_2383.field_1320 - class_2383.field_1323) * (class_2383.field_1325 - class_2383.field_1322) * (class_2383.field_1324 - class_2383.field_1321);
        double d2 = 1.0;
        float f4 = 1.0f;
        float f5 = 10.0f;
        float f6 = (float)Math.min((double)f5, (double)Math.max((double)f4, (double)((double)f4 + (d / d2 - 1.0) * (double)0.33f)));
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() != null && PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj() != null) {
            String string = PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj();
            if (string.equals((Object)"怪兽竞技场") || string.equals((Object)"怪兽争霸赛")) {
                class_45872.method_22905(f * f6, f2 * f6, f3 * f6);
            } else {
                class_45872.method_22905(f, f2, f3);
            }
        } else {
            class_45872.method_22905(f, f2, f3);
        }
    }
}

