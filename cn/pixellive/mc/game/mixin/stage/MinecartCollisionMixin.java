/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1688
 *  net.minecraft.class_1937
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_6880
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.stage;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaP;
import cn.pixellive.mc.game.PixelLiveGameMod;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1688;
import net.minecraft.class_1937;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_6880;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1688.class})
public class MinecartCollisionMixin {
    private static final Map<class_1657, Long> lastCollisionTime = new HashMap();

    @Inject(method={"pushAwayFrom"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPushAwayFrom(class_1297 class_12972, CallbackInfo callbackInfo) {
        class_1657 class_16572;
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() instanceof aaaaaP && class_12972 instanceof class_1657 && !(class_16572 = (class_1657)class_12972).method_5715()) {
            long l = System.currentTimeMillis();
            Long l2 = (Long)lastCollisionTime.get((Object)class_16572);
            if (l2 != null && l - l2 < 1000L) {
                callbackInfo.cancel();
                return;
            }
            lastCollisionTime.put((Object)class_16572, (Object)l);
            class_1937 class_19372 = class_16572.method_37908();
            if (class_19372 instanceof class_3218) {
                class_3218 class_32182 = (class_3218)class_19372;
                class_19372 = (class_1688)this;
                double d = class_19372.method_23317();
                double d2 = class_19372.method_23318();
                double d3 = class_19372.method_23321();
                double d4 = class_16572.method_23317();
                double d5 = class_16572.method_23318();
                double d6 = class_16572.method_23321();
                class_32182.method_14199((class_2394)class_2398.field_11236, d, d2, d3, 6, 2.0, 2.0, 2.0, 0.1);
                class_32182.method_14199((class_2394)class_2398.field_11237, d, d2, d3, 3, 1.5, 1.5, 1.5, 0.05);
                class_32182.method_60511(null, d, d2, d3, (class_6880)class_3417.field_15152, class_3419.field_15245, 3.0f, 1.0f);
                class_32182.method_14199((class_2394)class_2398.field_11240, d4, d5 + 1.0, d6, 10, 0.2, 0.4, 0.2, 0.05);
                class_32182.method_14199((class_2394)class_2398.field_11239, d4, d5 + 0.5, d6, 5, 0.2, 0.2, 0.2, 0.1);
                class_16572.method_5762(0.0, 0.0, 1.2);
                class_16572.field_6037 = true;
            }
            callbackInfo.cancel();
        }
    }
}

