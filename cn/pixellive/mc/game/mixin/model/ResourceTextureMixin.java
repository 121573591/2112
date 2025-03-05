/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  net.minecraft.class_1011
 *  net.minecraft.class_1049
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.model;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaam.aaaaaa;
import com.mojang.blaze3d.systems.RenderSystem;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.class_1011;
import net.minecraft.class_1049;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1049.class})
public abstract class ResourceTextureMixin {
    @Shadow
    protected final class_2960 field_5224;

    protected ResourceTextureMixin(class_2960 class_29602) {
        this.field_5224 = class_29602;
    }

    @Shadow
    protected abstract void method_22810(class_1011 var1, boolean var2, boolean var3);

    @Inject(method={"load"}, at={@At(value="HEAD")}, cancellable=true)
    private void onLoad(class_3300 class_33002, CallbackInfo callbackInfo) throws IOException {
        String string;
        byte[] byArray;
        if (this.field_5224.method_12836().equals((Object)"pixellivegame") && (byArray = aaaaaa.你为什么要破解我的代码aaaaaa(string = "assets/" + this.field_5224.method_12836() + "/" + this.field_5224.method_12832())) != null) {
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);){
                class_1011 class_10112 = class_1011.method_4309((InputStream)byteArrayInputStream);
                if (!RenderSystem.isOnRenderThreadOrInit()) {
                    RenderSystem.recordRenderCall(() -> {
                        this.method_22810(class_10112, true, false);
                        class_10112.close();
                    });
                } else {
                    this.method_22810(class_10112, true, false);
                    class_10112.close();
                }
                callbackInfo.cancel();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

