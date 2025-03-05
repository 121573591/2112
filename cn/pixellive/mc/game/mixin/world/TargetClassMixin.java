/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_2338
 *  net.minecraft.class_2791
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 */
package cn.pixellive.mc.game.mixin.world;

import net.minecraft.class_2338;
import net.minecraft.class_2791;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value={class_2791.class})
public class TargetClassMixin {
    @Overwrite
    public void method_12039(class_2338 class_23382) {
    }
}

