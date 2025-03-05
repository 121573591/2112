/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  org.jetbrains.annotations.Nullable
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package cn.pixellive.mc.game.animation.client.renderer.entity.player;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaa.aaaaab.aaaaaa;
import cn.pixellive.mc.game.animation.client.model.entity.player.FakePlayerEntityModel;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import org.jetbrains.annotations.Nullable;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FakePlayerEntityRenderer
extends GeoEntityRenderer<aaaaaa> {
    public FakePlayerEntityRenderer(class_5617.class_5618 class_56182) {
        super(class_56182, (GeoModel)new FakePlayerEntityModel());
    }

    public native void preRender(class_4587 var1, aaaaaa var2, BakedGeoModel var3, @Nullable class_4597 var4, @Nullable class_4588 var5, boolean var6, float var7, int var8, int var9, int var10);

    static {
        ___.___(334, FakePlayerEntityRenderer.class);
        ____.___334_40(FakePlayerEntityRenderer.class);
    }
}

