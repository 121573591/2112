/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 *  java.util.function.Consumer
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;

public class aaaaaa
implements NativeKeyListener {
    private static final aaaaaa 我草你怎么反编译我模组aaaaaa;
    private final Set<Integer> 我草你怎么反编译我模组aaaaab = new HashSet();
    private Consumer<String> 我草你怎么反编译我模组aaaaac;
    private boolean 我草你怎么反编译我模组aaaaad = false;
    private final Set<String> 我草你怎么反编译我模组aaaaae = new HashSet();
    private final Set<String> 我草你怎么反编译我模组aaaaaf = new HashSet();
    private static final Map<Integer, String> 我草你怎么反编译我模组aaaaag;
    public static boolean $skidonion$2074051824;

    private aaaaaa() {
        Logger logger = Logger.getLogger((String)GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        Arrays.stream((Object[])logger.getHandlers()).forEach(arg_0 -> ((Logger)logger).removeHandler(arg_0));
        logger.setUseParentHandlers(false);
    }

    public static native aaaaaa 你为什么要破解我的代码aaaaaa();

    public native void 你为什么要破解我的代码aaaaab(Set<String> var1);

    public native void 你为什么要破解我的代码aaaaac(Consumer<String> var1);

    public native void 你为什么要破解我的代码aaaaad();

    @Override
    public native void nativeKeyPressed(NativeKeyEvent var1);

    @Override
    public native void nativeKeyReleased(NativeKeyEvent var1);

    @Override
    public native void nativeKeyTyped(NativeKeyEvent var1);

    private native void 你为什么要破解我的代码aaaaae();

    private native boolean 你为什么要破解我的代码aaaaaf(String var1);

    private native void 你为什么要破解我的代码aaaaag(String var1);

    private native String 你为什么要破解我的代码aaaaah();

    private native String 你为什么要破解我的代码aaaaai(String var1);

    public native boolean 你为什么要破解我的代码aaaaaj(String var1);

    static {
        ___.___(252, aaaaaa.class);
        ____.___252_140(aaaaaa.class);
    }

    private static native Object aaaaak(char var0);
}

