/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_5498
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.model;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaf.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaag.aaaaac;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_5498;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_310.class})
public class CameraPerspectiveMixin {
    @Shadow
    @Final
    public class_315 field_1690;
    @Unique
    private class_5498 savedPerspective = null;

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void onTick(CallbackInfo callbackInfo) {
        class_310 class_3102 = (class_310)this;
        if (class_3102.field_1724 == null) {
            return;
        }
        aaaaaa aaaaaa2 = aaaaac.我草你怎么反编译我模组aaaafd.你为什么要破解我的代码aaaabQ(class_3102.field_1724.method_5628());
        if (aaaaaa2 != null && aaaaaa2.你为什么要破解我的代码aaaabh()) {
            if (this.savedPerspective == null) {
                this.savedPerspective = this.field_1690.method_31044();
                this.field_1690.method_31043(class_5498.field_26665);
            }
        } else if (this.savedPerspective != null) {
            this.field_1690.method_31043(this.savedPerspective);
            this.savedPerspective = null;
        }
    }
}

