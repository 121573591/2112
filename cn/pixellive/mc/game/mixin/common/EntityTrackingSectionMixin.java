/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  net.minecraft.class_238
 *  net.minecraft.class_5568
 *  net.minecraft.class_5572
 *  net.minecraft.class_5575
 *  net.minecraft.class_7927
 *  net.minecraft.class_7927$class_7928
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.common;

import net.minecraft.class_238;
import net.minecraft.class_5568;
import net.minecraft.class_5572;
import net.minecraft.class_5575;
import net.minecraft.class_7927;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_5572.class})
public class EntityTrackingSectionMixin<T extends class_5568> {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"forEach(Lnet/minecraft/util/math/Box;Lnet/minecraft/util/function/LazyIterationConsumer;)Lnet/minecraft/util/function/LazyIterationConsumer$NextIteration;"}, at={@At(value="HEAD")}, cancellable=true)
    private void onForEach(class_238 class_2383, class_7927<T> class_79272, CallbackInfoReturnable<class_7927.class_7928> callbackInfoReturnable) {
        try {
            EntityTrackingSectionMixin entityTrackingSectionMixin = this;
            synchronized (entityTrackingSectionMixin) {
                class_5572 class_55722 = (class_5572)this;
                for (class_5568 class_55682 : class_55722.method_31766()) {
                    if (class_55682 == null || !class_55682.method_5829().method_994(class_2383)) continue;
                    try {
                        if (!class_79272.accept((Object)class_55682).method_47543()) continue;
                        callbackInfoReturnable.setReturnValue((Object)class_7927.class_7928.field_41284);
                        return;
                    }
                    catch (Exception exception) {
                    }
                }
                callbackInfoReturnable.setReturnValue((Object)class_7927.class_7928.field_41283);
            }
        }
        catch (Exception exception) {
            callbackInfoReturnable.setReturnValue((Object)class_7927.class_7928.field_41283);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"forEach(Lnet/minecraft/util/TypeFilter;Lnet/minecraft/util/math/Box;Lnet/minecraft/util/function/LazyIterationConsumer;)Lnet/minecraft/util/function/LazyIterationConsumer$NextIteration;"}, at={@At(value="HEAD")}, cancellable=true)
    private <U extends T> void onForEachOfType(class_5575<T, U> class_55752, class_238 class_2383, class_7927<? super U> class_79272, CallbackInfoReturnable<class_7927.class_7928> callbackInfoReturnable) {
        try {
            EntityTrackingSectionMixin entityTrackingSectionMixin = this;
            synchronized (entityTrackingSectionMixin) {
                class_5572 class_55722 = (class_5572)this;
                for (class_5568 class_55682 : class_55722.method_31766()) {
                    class_5568 class_55683;
                    if (class_55682 == null || (class_55683 = (class_5568)class_55752.method_31796((Object)class_55682)) == null || !class_55683.method_5829().method_994(class_2383)) continue;
                    try {
                        if (!class_79272.accept((Object)class_55683).method_47543()) continue;
                        callbackInfoReturnable.setReturnValue((Object)class_7927.class_7928.field_41284);
                        return;
                    }
                    catch (Exception exception) {
                    }
                }
                callbackInfoReturnable.setReturnValue((Object)class_7927.class_7928.field_41283);
            }
        }
        catch (Exception exception) {
            callbackInfoReturnable.setReturnValue((Object)class_7927.class_7928.field_41283);
        }
    }
}

