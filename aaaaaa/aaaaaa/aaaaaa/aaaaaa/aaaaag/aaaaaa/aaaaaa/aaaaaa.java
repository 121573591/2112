/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runtime
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.RejectedExecutionHandler
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy
 *  java.util.concurrent.TimeUnit
 *  net.minecraft.class_1299
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaa.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaa.aaaaaa.aaaaab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

public class aaaaaa
extends aaaaab {
    private static final int 我草你怎么反编译我模组aaaaaa;
    private static final int 我草你怎么反编译我模组aaaaab;
    private static final int 我草你怎么反编译我模组aaaaac;
    private static final int 我草你怎么反编译我模组aaaaad;
    private static final int 我草你怎么反编译我模组aaaaae;
    private static final int 我草你怎么反编译我模组aaaaaf;
    private static final int 我草你怎么反编译我模组aaaaag;
    private static final double[] 我草你怎么反编译我模组aaaaah;
    private final List<aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaaa.aaaaab> 我草你怎么反编译我模组aaaaai = Collections.synchronizedList((List)new ArrayList());
    private final ThreadPoolExecutor 我草你怎么反编译我模组aaaaaj;
    private final int 我草你怎么反编译我模组aaaaak;
    private List<class_2338> 我草你怎么反编译我模组aaaaal = Collections.synchronizedList((List)new ArrayList());
    private double 我草你怎么反编译我模组aaaaam = 1.0;
    public static boolean $skidonion$1057090736;

    public aaaaaa(class_1299<? extends aaaaaa> class_12992, class_1937 class_19372) {
        super(class_12992, class_19372);
        this.我草你怎么反编译我模组aaaaak = Runtime.getRuntime().availableProcessors();
        this.我草你怎么反编译我模组aaaaaj = new ThreadPoolExecutor(this.我草你怎么反编译我模组aaaaak / 2, this.我草你怎么反编译我模组aaaaak, 60L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue(), (RejectedExecutionHandler)new ThreadPoolExecutor.CallerRunsPolicy());
        this.你为什么要破解我的代码aaaaaa();
    }

    private native void 你为什么要破解我的代码aaaaaa();

    @Override
    protected native void 你为什么要破解我的代码aaaaab();

    private native void 你为什么要破解我的代码aaaaac();

    private native void 你为什么要破解我的代码aaaaad();

    private native void 你为什么要破解我的代码aaaaae();

    private native void 你为什么要破解我的代码aaaaaf(List<class_2338> var1);

    private native int 你为什么要破解我的代码aaaaag(double var1);

    private native List<class_2338> 你为什么要破解我的代码aaaaah(int var1);

    private native boolean 你为什么要破解我的代码aaaaai(class_2338 var1);

    private native void 你为什么要破解我的代码aaaaaj(class_2338 var1);

    private native void 你为什么要破解我的代码aaaaak(class_1937 var1, class_243 var2);

    public native void registerControllers(AnimatableManager.ControllerRegistrar var1);

    private native PlayState 你为什么要破解我的代码aaaaal(AnimationState<aaaaaa> var1);

    @Override
    protected native void 你为什么要破解我的代码aaaaam();

    @Override
    protected native void 你为什么要破解我的代码aaaaan();

    private native /* synthetic */ void 你为什么要破解我的代码aaaaao(class_1937 var1, class_243 var2, aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaaa.aaaaab[] var3);

    private static native /* synthetic */ int 你为什么要破解我的代码aaaaap(class_2338 var0, class_2338 var1, class_2338 var2);

    private native /* synthetic */ void 你为什么要破解我的代码aaaaaq(List var1);

    private native /* synthetic */ void 你为什么要破解我的代码aaaaar(List var1);

    static {
        ___.___(54, aaaaaa.class);
        ____.___54_200(aaaaaa.class);
    }

    private static native Object aaaaas(char var0);
}

