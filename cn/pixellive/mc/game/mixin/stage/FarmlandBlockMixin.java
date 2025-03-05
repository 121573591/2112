/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2344
 *  net.minecraft.class_2680
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.stage;

import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2344;
import net.minecraft.class_2680;
import net.minecraft.class_3222;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2344.class})
public class FarmlandBlockMixin {
    @Inject(method={"onLandedUpon"}, at={@At(value="HEAD")}, cancellable=true)
    private void onLandedUpon(class_1937 class_19372, class_2680 class_26802, class_2338 class_23382, class_1297 class_12972, float f, CallbackInfo callbackInfo) {
        if (class_12972 instanceof class_3222) {
            callbackInfo.cancel();
        }
    }
}

