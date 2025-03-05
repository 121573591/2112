/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.util.function.Predicate
 *  net.minecraft.class_1299
 *  net.minecraft.class_1439
 *  net.minecraft.class_1569
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.stage;

import java.util.function.Predicate;
import net.minecraft.class_1299;
import net.minecraft.class_1439;
import net.minecraft.class_1569;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1439.class})
public abstract class IronGolemTargetMixin {
    @Inject(method={"canTarget"}, at={@At(value="HEAD")}, cancellable=true)
    private void onCanTarget(class_1299<?> class_12992, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (((class_1439)this).method_6496() && class_12992 == class_1299.field_6097) {
            callbackInfoReturnable.setReturnValue((Object)false);
            return;
        }
        callbackInfoReturnable.setReturnValue((Object)true);
    }

    @ModifyArg(method={"initGoals"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/ai/goal/ActiveTargetGoal;<init>(Lnet/minecraft/entity/mob/MobEntity;Ljava/lang/Class;IZZLjava/util/function/Predicate;)V"), index=5)
    private Predicate<?> modifyTargetPredicate(Predicate<?> predicate) {
        return object -> object instanceof class_1569;
    }
}

