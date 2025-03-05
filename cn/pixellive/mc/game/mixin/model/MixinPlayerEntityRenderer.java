/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_1007
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_742
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.model;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaa.aaaaab;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaa.aaaaab.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaag.aaaaac;
import net.minecraft.class_1007;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_742;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1007.class})
public class MixinPlayerEntityRenderer {
    @Inject(method={"render(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void render(class_742 class_7422, float f, float f2, class_4587 class_45872, class_4597 class_45972, int n, CallbackInfo callbackInfo) {
        int n2 = class_7422.method_5628();
        if (aaaaac.我草你怎么反编译我模组aaaafd.你为什么要破解我的代码aaaabS(n2)) {
            aaaaaa aaaaaa2 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaag.aaaaab.我草你怎么反编译我模组aaaaeY.你为什么要破解我的代码aaaabI(class_7422);
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaa.aaaaac aaaaac2 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaag.aaaaab.我草你怎么反编译我模组aaaaeY.你为什么要破解我的代码aaaabJ(class_7422);
            aaaaab aaaaab2 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaag.aaaaab.我草你怎么反编译我模组aaaaeY.你为什么要破解我的代码aaaabK(class_7422);
            if (aaaaaa2.你为什么要破解我的代码aaaaaz() == aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaf.aaaaaa.我草你怎么反编译我模组aaaadN) {
                aaaaaa2.你为什么要破解我的代码aaaaaA(aaaaac.我草你怎么反编译我模组aaaafd.你为什么要破解我的代码aaaabQ(n2));
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaab.aaaaaa.我草你怎么反编译我模组aaaaaC.你为什么要破解我的代码aaaaaj(aaaaaa2);
            } else {
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaac.aaaaaa.aaaaaa.我草你怎么反编译我模组aaaaab.method_3936((class_1297)aaaaaa2, class_7422.field_6241, class_310.method_1551().method_60646().method_60637(!class_7422.field_17892.method_54719().method_54746((class_1297)aaaaaa2)), class_45872, class_45972, n);
                if (aaaaaa2.你为什么要破解我的代码aaaaaz() == aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaf.aaaaaa.我草你怎么反编译我模组aaaadO) {
                    aaaaac2.field_6012 = class_7422.field_6012;
                    aaaaac2.field_6220 = class_7422.field_6220;
                    aaaaac2.field_6283 = class_7422.field_6283;
                    aaaaac2.field_6259 = class_7422.field_6259;
                    aaaaac2.field_6241 = class_7422.field_6241;
                    aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaac.aaaaaa.aaaaaa.我草你怎么反编译我模组aaaaad.method_3936((class_1297)aaaaac2, class_7422.field_6241, class_310.method_1551().method_60646().method_60637(!class_7422.field_17892.method_54719().method_54746((class_1297)aaaaac2)), class_45872, class_45972, n);
                } else if (aaaaaa2.你为什么要破解我的代码aaaaaz() == aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaf.aaaaaa.我草你怎么反编译我模组aaaadP) {
                    aaaaab2.field_6012 = class_7422.field_6012;
                    aaaaab2.field_6220 = class_7422.field_6220;
                    aaaaab2.field_6283 = class_7422.field_6283;
                    aaaaab2.field_6259 = class_7422.field_6259;
                    aaaaab2.field_6241 = class_7422.field_6241;
                    aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaac.aaaaaa.aaaaaa.我草你怎么反编译我模组aaaaac.method_3936((class_1297)aaaaab2, class_7422.field_6241, class_310.method_1551().method_60646().method_60637(!class_7422.field_17892.method_54719().method_54746((class_1297)aaaaab2)), class_45872, class_45972, n);
                }
            }
            callbackInfo.cancel();
        }
    }
}

