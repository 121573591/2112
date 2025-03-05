/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4185
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.screen;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaD;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_442;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_442.class}, priority=1500)
public class TitleScreenMixin {
    private class_4185 realmsButton = null;
    private final class_2561 expectedButtonText = class_2561.method_43471((String)"pixellivegame.button.realms");
    private static final boolean MODMENU_LOADED = TitleScreenMixin.isModLoaded("modmenu");

    private static boolean isModLoaded(String string) {
        try {
            return FabricLoader.getInstance().isModLoaded(string);
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void afterRender(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        this.identifyAndModifyRealmsButton();
    }

    private void identifyAndModifyRealmsButton() {
        if (this.realmsButton != null && !this.realmsButton.method_25369().equals((Object)this.expectedButtonText)) {
            this.realmsButton.method_25355(this.expectedButtonText);
            return;
        }
        class_442 class_4422 = (class_442)this;
        for (Object object : class_4422.method_25396()) {
            class_4185 class_41852;
            String string;
            if (!(object instanceof class_4185) || !(string = (class_41852 = (class_4185)object).method_25369().getString()).contains((CharSequence)"menu.online") && !string.contains((CharSequence)"Realms")) continue;
            this.realmsButton = class_41852;
            this.realmsButton.method_25355(this.expectedButtonText);
            break;
        }
    }

    @Inject(method={"removed"}, at={@At(value="TAIL")})
    private void onRemoved(CallbackInfo callbackInfo) {
        this.realmsButton = null;
    }

    @Inject(method={"mouseClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void onMouseClick(double d, double d2, int n, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (this.realmsButton != null && this.realmsButton.method_25405(d, d2)) {
            class_310.method_1551().method_1507((class_437)new aaaaaD());
            callbackInfoReturnable.setReturnValue((Object)true);
            callbackInfoReturnable.cancel();
        }
    }
}

