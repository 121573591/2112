/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  net.minecraft.class_1923
 *  net.minecraft.class_2487
 *  net.minecraft.class_2520
 *  net.minecraft.class_2839
 *  net.minecraft.class_2852
 *  net.minecraft.class_3218
 *  net.minecraft.class_4153
 *  net.minecraft.class_9240
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package cn.pixellive.mc.game.mixin.world;

import net.minecraft.class_1923;
import net.minecraft.class_2487;
import net.minecraft.class_2520;
import net.minecraft.class_2839;
import net.minecraft.class_2852;
import net.minecraft.class_3218;
import net.minecraft.class_4153;
import net.minecraft.class_9240;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2852.class})
public class ChunkSerializerMixin {
    @Inject(method={"deserialize"}, at={@At(value="HEAD")})
    private static void onDeserialize(class_3218 class_32182, class_4153 class_41532, class_9240 class_92402, class_1923 class_19232, class_2487 class_24872, CallbackInfoReturnable<class_2839> callbackInfoReturnable) {
        try {
            if (class_24872.method_10545("Heightmaps")) {
                String[] stringArray;
                class_2487 class_24873 = class_24872.method_10562("Heightmaps");
                for (String string : stringArray = new String[]{"WORLD_SURFACE", "MOTION_BLOCKING", "MOTION_BLOCKING_NO_LEAVES", "OCEAN_FLOOR"}) {
                    long[] lArray;
                    if (!class_24873.method_10545(string) || (lArray = class_24873.method_10565(string)).length == 52) continue;
                    class_24873.method_10551(string);
                }
                class_24872.method_10566("Heightmaps", (class_2520)class_24873);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

