/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_4185
 *  net.minecraft.class_437
 *  net.minecraft.class_525
 *  net.minecraft.class_7845
 *  net.minecraft.class_7845$class_7939
 *  net.minecraft.class_8021
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.screen;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaao;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_525;
import net.minecraft.class_7845;
import net.minecraft.class_8021;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets={"net.minecraft.client.gui.screen.world.CreateWorldScreen$GameTab"})
public class CreateWorldScreenMixin {
    private class_7845.class_7939 adder;
    private class_525 createWorldScreen;

    @Redirect(method={"<init>"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/widget/GridWidget;createAdder(I)Lnet/minecraft/client/gui/widget/GridWidget$Adder;"))
    private class_7845.class_7939 injectButton(class_7845 class_78452, int n) {
        class_7845.class_7939 class_79392;
        this.adder = class_79392 = class_78452.method_48636(8).method_47610(n);
        return class_79392;
    }

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void captureCreateWorldScreen(class_525 class_5252, CallbackInfo callbackInfo) {
        this.createWorldScreen = class_5252;
    }

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void injectButton(CallbackInfo callbackInfo) {
        class_4185 class_41853 = class_4185.method_46430((class_2561)class_2561.method_43471((String)"pixellivegame.choose_game.title"), class_41852 -> class_310.method_1551().execute(() -> class_310.method_1551().method_1507((class_437)new aaaaao(this.createWorldScreen, null)))).method_46432(210).method_46431();
        this.adder.method_47612((class_8021)class_41853);
    }
}

