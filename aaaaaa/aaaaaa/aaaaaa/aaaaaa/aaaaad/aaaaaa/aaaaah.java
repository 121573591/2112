/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.eventbus.Subscribe
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.file.Path
 *  java.time.Duration
 *  java.util.Timer
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_339
 *  net.minecraft.class_342
 *  net.minecraft.class_4185
 *  net.minecraft.class_437
 *  net.minecraft.class_7847
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaac;
import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveRoomConnectFailedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomConnectedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomDisconnectedEvent;
import com.google.common.eventbus.Subscribe;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Timer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_339;
import net.minecraft.class_342;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_7847;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;

@SourceDebugExtension(value={"SMAP\nConnectRoomScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectRoomScreen.kt\ncn/pixellive/mc/game/client/screen/ConnectRoomScreen\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,528:1\n1855#2,2:529\n1855#2,2:531\n1855#2,2:533\n*S KotlinDebug\n*F\n+ 1 ConnectRoomScreen.kt\ncn/pixellive/mc/game/client/screen/ConnectRoomScreen\n*L\n376#1:529,2\n449#1:531,2\n477#1:533,2\n*E\n"})
public final class aaaaah
extends class_437 {
    @NotNull
    public static final aaaaac 我草你怎么反编译我模组aaaaaH;
    @Nullable
    private Timer 我草你怎么反编译我模组aaaaaI;
    private class_342 我草你怎么反编译我模组aaaaaJ;
    private class_4185 我草你怎么反编译我模组aaaaaK;
    private class_4185 我草你怎么反编译我模组aaaaaL;
    private class_4185 我草你怎么反编译我模组aaaaaM;
    @NotNull
    private final OkHttpClient 我草你怎么反编译我模组aaaaaN;
    @NotNull
    private static final class_2561 我草你怎么反编译我模组aaaaaO;
    @NotNull
    private static final String 我草你怎么反编译我模组aaaaaP;
    @NotNull
    private static final String 我草你怎么反编译我模组aaaaaQ;
    @NotNull
    private static final Path 我草你怎么反编译我模组aaaaaR;
    public static boolean $skidonion$138451475;

    public aaaaah() {
        super(我草你怎么反编译我模组aaaaaO);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Duration duration = Duration.ofSeconds((long)180L);
        Intrinsics.checkNotNullExpressionValue((Object)duration, (String)((String)aaaaah.aaaabK((char)1568210944)));
        this.我草你怎么反编译我模组aaaaaN = builder.readTimeout(duration).build();
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().register((Object)this);
    }

    protected native void method_25426();

    private final native void 你为什么要破解我的代码aaaaaZ();

    private final native void 你为什么要破解我的代码aaaaba(class_4185 var1);

    public native void method_25432();

    private final native class_2561 你为什么要破解我的代码aaaabb();

    private final native void 你为什么要破解我的代码aaaabc();

    private final native void 你为什么要破解我的代码aaaabd();

    public native void method_25419();

    private final native void 你为什么要破解我的代码aaaabe();

    private final native Headers 你为什么要破解我的代码aaaabf();

    @Subscribe
    public final native void 你为什么要破解我的代码aaaabg(@Nullable LiveRoomConnectedEvent var1);

    @Subscribe
    public final native void 你为什么要破解我的代码aaaabh(@Nullable LiveRoomConnectFailedEvent var1);

    @Subscribe
    public final native void 你为什么要破解我的代码aaaabi(@Nullable LiveRoomDisconnectedEvent var1);

    private static final native void 你为什么要破解我的代码aaaabj(class_7847 var0);

    private static final native void 你为什么要破解我的代码aaaabk(class_7847 var0);

    private static final native void 你为什么要破解我的代码aaaabl(String var0);

    private static final native void 你为什么要破解我的代码aaaabm(aaaaah var0, class_4185 var1);

    private static final native void 你为什么要破解我的代码aaaabn(class_7847 var0);

    private static final native void 你为什么要破解我的代码aaaabo(String var0);

    private static final native void 你为什么要破解我的代码aaaabp(aaaaah var0, class_4185 var1);

    private static final native void 你为什么要破解我的代码aaaabq(aaaaah var0, class_4185 var1);

    private static final native void 你为什么要破解我的代码aaaabr(aaaaah var0, class_4185 var1);

    private static final native void 你为什么要破解我的代码aaaabs(aaaaah var0, class_4185 var1);

    private static final native void 你为什么要破解我的代码aaaabt(aaaaah var0, class_339 var1);

    private static final native class_2583 你为什么要破解我的代码aaaabu(class_2583 var0);

    private static final native class_2583 你为什么要破解我的代码aaaabv(class_2583 var0);

    private static final native class_2583 你为什么要破解我的代码aaaabw(class_2583 var0);

    private static final native class_2583 你为什么要破解我的代码aaaabx(class_2583 var0);

    private static final native void 你为什么要破解我的代码aaaaby();

    private static final native class_2583 你为什么要破解我的代码aaaabz(class_2583 var0);

    private static final native void 你为什么要破解我的代码aaaabA();

    private static final native void 你为什么要破解我的代码aaaabB(aaaaah var0, String var1);

    private static final native void 你为什么要破解我的代码aaaabC(aaaaah var0);

    private static final native class_2583 你为什么要破解我的代码aaaabD(class_2583 var0);

    private static final native class_2583 你为什么要破解我的代码aaaabE(class_2583 var0);

    private static final native class_2583 你为什么要破解我的代码aaaabF(class_2583 var0);

    public static final native /* synthetic */ class_2561 你为什么要破解我的代码aaaabG();

    public static final native /* synthetic */ Path 你为什么要破解我的代码aaaabH();

    public static final native /* synthetic */ void 你为什么要破解我的代码aaaabI(aaaaah var0, Timer var1);

    public static final native /* synthetic */ class_342 你为什么要破解我的代码aaaabJ(aaaaah var0);

    static {
        ___.___(70, aaaaah.class);
        ____.___70_410(aaaaah.class);
    }

    private static native Object aaaabK(char var0);
}

