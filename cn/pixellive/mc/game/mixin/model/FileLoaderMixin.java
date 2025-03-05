/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.StandardCharsets
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  software.bernie.geckolib.loading.FileLoader
 */
package cn.pixellive.mc.game.mixin.model;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaam.aaaaaa;
import java.nio.charset.StandardCharsets;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import software.bernie.geckolib.loading.FileLoader;

@Mixin(value={FileLoader.class})
public class FileLoaderMixin {
    @Inject(method={"getFileContents"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    private static void onGetFileContents(class_2960 class_29602, class_3300 class_33002, CallbackInfoReturnable<String> callbackInfoReturnable) {
        String string;
        byte[] byArray;
        if (class_29602.method_12836().equals((Object)"pixellivegame") && (byArray = aaaaaa.你为什么要破解我的代码aaaaaa(string = "assets/" + class_29602.method_12836() + "/" + class_29602.method_12832())) != null) {
            callbackInfoReturnable.setReturnValue((Object)new String(byArray, StandardCharsets.UTF_8));
        }
    }
}

