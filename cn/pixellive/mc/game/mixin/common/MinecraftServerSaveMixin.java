/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.server.MinecraftServer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 */
package cn.pixellive.mc.game.mixin.common;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value={MinecraftServer.class})
public class MinecraftServerSaveMixin {
    @Overwrite
    public boolean method_3723(boolean bl, boolean bl2, boolean bl3) {
        return false;
    }

    @Overwrite
    public boolean method_39218(boolean bl, boolean bl2, boolean bl3) {
        return false;
    }
}

