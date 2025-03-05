/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_1269
 *  net.minecraft.class_1747
 *  net.minecraft.class_1750
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.stage;

import net.minecraft.class_1269;
import net.minecraft.class_1747;
import net.minecraft.class_1750;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1747.class})
public class BlockItemMixin {
    @Inject(method={"place(Lnet/minecraft/item/ItemPlacementContext;)Lnet/minecraft/util/ActionResult;"}, at={@At(value="INVOKE", target="Lnet/minecraft/item/BlockItem;place(Lnet/minecraft/item/ItemPlacementContext;Lnet/minecraft/block/BlockState;)Z")}, cancellable=true)
    public void placeInject(class_1750 class_17502, CallbackInfoReturnable<class_1269> callbackInfoReturnable) {
    }
}

