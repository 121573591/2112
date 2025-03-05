/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1937
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animatable.GeoEntity
 *  software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.util.GeckoLibUtil
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaa;

import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1937;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class aaaaab
extends class_1308
implements GeoEntity {
    private final AnimatableInstanceCache 我草你怎么反编译我模组aaaaaq = GeckoLibUtil.createInstanceCache((GeoAnimatable)this);
    private int 我草你怎么反编译我模组aaaaap = 0;
    public static boolean $skidonion$509664395;

    public aaaaab(class_1299<? extends class_1308> class_12992, class_1937 class_19372) {
        super(class_12992, class_19372);
        this.method_5875(true);
        this.method_5684(true);
    }

    public native void registerControllers(AnimatableManager.ControllerRegistrar var1);

    private native PlayState 你为什么要破解我的代码aaaaal(AnimationState<aaaaab> var1);

    public native AnimatableInstanceCache getAnimatableInstanceCache();

    public native void method_5773();

    static {
        ___.___(131, aaaaab.class);
        ____.___131_50(aaaaab.class);
    }

    private static native Object aaaaaa(char var0);
}

