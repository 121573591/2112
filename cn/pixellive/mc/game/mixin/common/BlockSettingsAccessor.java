/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_4970$class_2251
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package cn.pixellive.mc.game.mixin.common;

import net.minecraft.class_4970;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_4970.class_2251.class})
public interface BlockSettingsAccessor {
    @Accessor(value="resistance")
    public void setResistance(float var1);

    @Accessor(value="hardness")
    public void setHardness(float var1);
}

