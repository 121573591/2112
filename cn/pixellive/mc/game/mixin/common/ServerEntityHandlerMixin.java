/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 *  net.minecraft.class_1308
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package cn.pixellive.mc.game.mixin.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_1308;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets={"net.minecraft.server.world.ServerWorld$ServerEntityHandler"})
public class ServerEntityHandlerMixin {
    @Redirect(method={"stopTracking(Lnet/minecraft/entity/Entity;)V"}, at=@At(value="INVOKE", target="Ljava/util/Set;remove(Ljava/lang/Object;)Z"))
    private boolean onRemove(Set<class_1308> set, Object object) {
        if (set != null && object instanceof class_1308) {
            try {
                return set.remove(object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                HashSet hashSet = new HashSet(set);
                hashSet.remove(object);
                set.clear();
                set.addAll((Collection)hashSet);
                return true;
            }
        }
        return false;
    }
}

