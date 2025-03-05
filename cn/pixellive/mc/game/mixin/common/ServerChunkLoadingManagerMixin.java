/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Void
 *  net.minecraft.class_3898
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.common;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.class_3898;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_3898.class})
public class ServerChunkLoadingManagerMixin {
    @Shadow
    private Int2ObjectMap<Int2ObjectOpenHashMap<Void>> field_18242;

    @Inject(method={"tickEntityMovement"}, at={@At(value="HEAD")})
    private void onTickEntityMovementStart(CallbackInfo callbackInfo) {
        try {
            if (this.field_18242 == null) {
                this.field_18242 = new Int2ObjectOpenHashMap();
            }
            this.field_18242.int2ObjectEntrySet().forEach(entry -> {
                if (entry.getValue() == null || ((Int2ObjectOpenHashMap)entry.getValue()).isEmpty()) {
                    entry.setValue((Object)new Int2ObjectOpenHashMap());
                }
            });
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Inject(method={"tickEntityMovement"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/world/ServerWorld;getPlayers()Ljava/util/List;", ordinal=0)})
    private void onEntityIteration(CallbackInfo callbackInfo) {
        try {
            this.field_18242.values().removeIf(int2ObjectOpenHashMap -> int2ObjectOpenHashMap == null || int2ObjectOpenHashMap.isEmpty());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Inject(method={"tickEntityMovement"}, at={@At(value="RETURN")})
    private void onTickEntityMovementEnd(CallbackInfo callbackInfo) {
        try {
            this.field_18242.values().removeIf(int2ObjectOpenHashMap -> int2ObjectOpenHashMap == null || int2ObjectOpenHashMap.isEmpty());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

