/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_1757
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.Constant
 *  org.spongepowered.asm.mixin.injection.ModifyConstant
 */
package cn.pixellive.mc.game.mixin.stage;

import net.minecraft.class_1757;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value={class_1757.class})
public class ChorusFruitMixin {
    @ModifyConstant(method={"finishUsing"}, constant={@Constant(doubleValue=16.0)})
    private double modifyTeleportRange(double d) {
        return 500.0;
    }

    @ModifyConstant(method={"finishUsing"}, constant={@Constant(intValue=16, ordinal=0)})
    private int modifyAttempts(int n) {
        return 64;
    }

    @ModifyConstant(method={"finishUsing"}, constant={@Constant(intValue=16, ordinal=1)})
    private int modifyVerticalRange(int n) {
        return 100;
    }

    @ModifyConstant(method={"finishUsing"}, constant={@Constant(intValue=8)})
    private int modifyVerticalOffset(int n) {
        return 50;
    }
}

