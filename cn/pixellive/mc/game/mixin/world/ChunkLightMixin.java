/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_2338
 *  net.minecraft.class_3558
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.world;

import net.minecraft.class_2338;
import net.minecraft.class_3558;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_3558.class})
public class ChunkLightMixin {
    @Inject(method={"checkBlock"}, at={@At(value="HEAD")}, cancellable=true)
    private void onCheckBlock(class_2338 class_23382, CallbackInfo callbackInfo) {
        if (class_23382.method_10264() > 1700) {
            callbackInfo.cancel();
        }
    }
}

