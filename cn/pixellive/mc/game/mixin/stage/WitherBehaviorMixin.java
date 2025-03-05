/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.List
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1528
 *  net.minecraft.class_1687
 *  net.minecraft.class_2561
 *  net.minecraft.class_4051
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.stage;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import cn.pixellive.mc.game.PixelLiveGameMod;
import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1528;
import net.minecraft.class_1687;
import net.minecraft.class_2561;
import net.minecraft.class_4051;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1528.class})
public abstract class WitherBehaviorMixin {
    @Shadow
    private static class_4051 field_18125;
    @Shadow
    private int field_7082;
    @Shadow
    private final int[] field_7092 = new int[2];

    @Shadow
    protected abstract void method_6876(int var1, int var2);

    private boolean isMonsterBattleStage() {
        return PixelLiveGameMod.你为什么要破解我的代码aaaaaR() != null && PixelLiveGameMod.你为什么要破解我的代码aaaaaR().你为什么要破解我的代码aaaaaj().equalsIgnoreCase("怪兽争霸赛");
    }

    @Inject(method={"<clinit>"}, at={@At(value="TAIL")})
    private static void modifyTargetPredicate(CallbackInfo callbackInfo) {
        try {
            Field field = class_4051.class.getDeclaredField("predicate");
            field.setAccessible(true);
            field.set((Object)field_18125, class_13092 -> class_13092.method_5805() && class_13092.method_5864() != class_1299.field_6097);
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error("Failed to modify Wither target predicate", (Throwable)exception);
        }
    }

    @Redirect(method={"damage"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/boss/WitherEntity;getInvulnerableTimer()I"))
    private int redirectInvulnerableTimer(class_1528 class_15282) {
        if (this.isMonsterBattleStage()) {
            return 0;
        }
        return class_15282.method_6884();
    }

    @Shadow
    public abstract int method_6884();

    @Shadow
    public abstract boolean method_6872();

    @Inject(method={"onSummoned"}, at={@At(value="HEAD")}, cancellable=true)
    private void onEntitySummoned(CallbackInfo callbackInfo) {
        if (this.isMonsterBattleStage()) {
            class_1528 class_15282 = (class_1528)this;
            class_15282.method_6875(0);
            class_15282.method_6033(class_15282.method_6063());
            callbackInfo.cancel();
        }
    }

    @Inject(method={"setTrackedEntityId"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSetTrackedEntityId(int n, int n2, CallbackInfo callbackInfo) {
        if (!this.isMonsterBattleStage()) {
            return;
        }
        class_1528 class_15282 = (class_1528)this;
        if (n2 <= 0) {
            return;
        }
        class_1297 class_12972 = class_15282.method_37908().method_8469(n2);
        if (class_12972 != null) {
            class_2561 class_25612 = class_12972.method_5797();
            class_2561 class_25613 = class_15282.method_5797();
            if (class_25612 != null && class_25613 != null && class_25612.getString().equals((Object)class_25613.getString())) {
                callbackInfo.cancel();
            }
        }
    }

    @Inject(method={"mobTick"}, at={@At(value="HEAD")})
    private void onMobTick(CallbackInfo callbackInfo) {
        if (!this.isMonsterBattleStage()) {
            return;
        }
        class_1528 class_15282 = (class_1528)this;
        class_2561 class_25612 = class_15282.method_5797();
        List list = class_15282.method_37908().method_8390(class_1309.class, class_15282.method_5829().method_1009(20.0, 8.0, 20.0), class_13092 -> {
            if (class_13092 == class_15282) {
                return false;
            }
            class_2561 class_25613 = class_13092.method_5797();
            return class_13092.method_5805() && class_13092.method_5864() != class_1299.field_6097 && class_25613 != null && class_25612 != null && !class_25613.getString().equals((Object)class_25612.getString());
        });
        if (!list.isEmpty()) {
            class_1309 class_13093 = (class_1309)list.get(class_15282.method_59922().method_43048(list.size()));
            for (int i = 0; i < 3; ++i) {
                this.method_6876(i, class_13093.method_5628());
            }
        }
    }

    @ModifyVariable(method={"tickMovement"}, at=@At(value="STORE"), ordinal=0)
    private double modifyVerticalMovement(double d) {
        class_1528 class_15282 = (class_1528)this;
        if (this.isMonsterBattleStage() && class_15282.method_5968() instanceof class_1528) {
            return 0.0;
        }
        return d;
    }

    @Inject(method={"damage"}, at={@At(value="HEAD")}, cancellable=true)
    private void modifyDamageLogic(class_1282 class_12822, float f, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (!this.isMonsterBattleStage()) {
            return;
        }
        class_1528 class_15282 = (class_1528)this;
        class_1297 class_12972 = class_12822.method_5526();
        class_1297 class_12973 = class_12822.method_5529();
        if (this.isMonsterBattleStage()) {
            String string;
            String string2 = class_12973 != null && class_12973.method_5797() != null ? class_12973.method_5797().getString() : "";
            String string3 = class_15282.method_5797() != null ? class_15282.method_5797().getString() : "";
            boolean bl = false;
            if (class_12972 instanceof class_1687) {
                if (!(string2.isEmpty() || string3.isEmpty() || string2.equals((Object)string3))) {
                    bl = true;
                }
            } else if (class_12972 != null && (string = class_12972.method_5864().toString()).contains((CharSequence)"arrow") && !string2.isEmpty() && !string3.isEmpty() && !string2.equals((Object)string3)) {
                bl = true;
            }
            if (bl) {
                float f2 = class_15282.method_6032();
                float f3 = Math.max((float)0.0f, (float)(f2 - f));
                class_15282.method_6033(f3);
                aaaaab.你为什么要破解我的代码aaaaaa().info("实际扣除血量: " + f);
                aaaaab.你为什么要破解我的代码aaaaaa().info("当前血量: " + f3);
                callbackInfoReturnable.setReturnValue((Object)true);
            }
        }
    }
}

