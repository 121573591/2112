/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.eventbus.Subscribe
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.RangesKt
 *  kotlin.text.MatchResult
 *  kotlin.text.Regex
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.GlobalScope
 *  net.minecraft.class_1259$class_1260
 *  net.minecraft.class_1259$class_1261
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1538
 *  net.minecraft.class_1541
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1928
 *  net.minecraft.class_1928$class_4310
 *  net.minecraft.class_1928$class_4312
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2960
 *  net.minecraft.class_3002
 *  net.minecraft.class_3004
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_4466
 *  net.minecraft.class_5250
 *  net.minecraft.class_5894
 *  net.minecraft.class_6880
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaD;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaJ;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaZ;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaabb;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaabh;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaca;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacj;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaadh;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaC;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaR;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaS;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaae;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaag;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaam;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaav;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabA;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabQ;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabo;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacc;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacx;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacy;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaadb;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaaj;
import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.game.ExplosionEvent;
import cn.pixellive.mc.game.event.live.LiveChatEvent;
import cn.pixellive.mc.game.event.live.LiveEnterRoomEvent;
import cn.pixellive.mc.game.event.live.LiveGiftEvent;
import cn.pixellive.mc.game.event.live.LiveLikeEvent;
import com.google.common.eventbus.Subscribe;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import net.minecraft.class_1259;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1538;
import net.minecraft.class_1541;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1928;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2960;
import net.minecraft.class_3002;
import net.minecraft.class_3004;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_4466;
import net.minecraft.class_5250;
import net.minecraft.class_5894;
import net.minecraft.class_6880;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nDailyParkourStage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyParkourStage.kt\ncn/pixellive/mc/game/stage/DailyParkourStage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2028:1\n1855#2,2:2029\n1855#2,2:2031\n1855#2,2:2033\n1855#2:2035\n1864#2,3:2036\n1856#2:2039\n1855#2,2:2040\n1855#2,2:2042\n1855#2,2:2044\n1855#2,2:2046\n1855#2,2:2048\n1855#2,2:2050\n1855#2,2:2052\n1864#2,3:2054\n1855#2,2:2057\n1855#2,2:2059\n1549#2:2061\n1620#2,3:2062\n1855#2,2:2065\n1855#2,2:2067\n1855#2,2:2069\n1855#2,2:2071\n1855#2,2:2073\n1855#2,2:2075\n766#2:2078\n857#2,2:2079\n1855#2,2:2081\n1855#2,2:2083\n1855#2,2:2085\n1855#2,2:2087\n1855#2,2:2089\n1#3:2077\n*S KotlinDebug\n*F\n+ 1 DailyParkourStage.kt\ncn/pixellive/mc/game/stage/DailyParkourStage\n*L\n170#1:2029,2\n228#1:2031,2\n271#1:2033,2\n319#1:2035\n332#1:2036,3\n319#1:2039\n350#1:2040,2\n500#1:2042,2\n514#1:2044,2\n618#1:2046,2\n638#1:2048,2\n661#1:2050,2\n686#1:2052,2\n799#1:2054,3\n1284#1:2057,2\n1410#1:2059,2\n1422#1:2061\n1422#1:2062,3\n1473#1:2065,2\n1483#1:2067,2\n1488#1:2069,2\n1493#1:2071,2\n1500#1:2073,2\n1550#1:2075,2\n1574#1:2078\n1574#1:2079,2\n1669#1:2081,2\n1796#1:2083,2\n1840#1:2085,2\n1951#1:2087,2\n1964#1:2089,2\n*E\n"})
public final class aaaabH
extends aaaaas {
    @NotNull
    public static final aaaabH 我草你怎么反编译我模组aaaadh;
    @NotNull
    private static final Map<class_3222, Long> 我草你怎么反编译我模组aaaadi;
    @NotNull
    private static final Map<class_3222, Long> 我草你怎么反编译我模组aaaadj;
    @NotNull
    private static final Map<class_3222, Long> 我草你怎么反编译我模组aaaadk;
    @NotNull
    private static final aaaabo 我草你怎么反编译我模组aaaadl;
    @NotNull
    private static final Set<String> 我草你怎么反编译我模组aaaadm;
    @Nullable
    private static MinecraftServer 我草你怎么反编译我模组aaaaad;
    @NotNull
    private static final class_243 我草你怎么反编译我模组aaaacl;
    private static int 我草你怎么反编译我模组aaaaae;
    private static int 我草你怎么反编译我模组aaaadn;
    private static boolean 我草你怎么反编译我模组aaaado;
    private static int 我草你怎么反编译我模组aaaadp;
    @NotNull
    private static final class_243 我草你怎么反编译我模组aaaadq;
    private static final double 我草你怎么反编译我模组aaaadr;
    private static final int 我草你怎么反编译我模组aaaads;
    private static final int 我草你怎么反编译我模组aaaadt;
    @NotNull
    private static final Map<class_3222, Long> 我草你怎么反编译我模组aaaadu;
    private static final long 我草你怎么反编译我模组aaaadv;
    private static class_3002 我草你怎么反编译我模组aaaaah;
    private static class_3002 我草你怎么反编译我模组aaaadw;
    private static class_3002 我草你怎么反编译我模组aaaadx;
    private static class_3002 我草你怎么反编译我模组aaaaaj;
    private static int 我草你怎么反编译我模组aaaaan;
    private static int 我草你怎么反编译我模组aaaaak;
    private static int 我草你怎么反编译我模组aaaaal;
    private static boolean 我草你怎么反编译我模组aaaady;
    @NotNull
    private static final List<class_243> 我草你怎么反编译我模组aaaadz;
    static Object aaaadA;

    private aaaabH() {
    }

    public final int 你为什么要破解我的代码aaaacx() {
        return 我草你怎么反编译我模组aaaaae;
    }

    public final void 你为什么要破解我的代码aaaacy(int n) {
        我草你怎么反编译我模组aaaaae = n;
    }

    public final int 你为什么要破解我的代码aaaaiG() {
        return 我草你怎么反编译我模组aaaadn;
    }

    public final void 你为什么要破解我的代码aaaaiH(int n) {
        我草你怎么反编译我模组aaaadn = n;
    }

    public final int 你为什么要破解我的代码aaaacz() {
        return 我草你怎么反编译我模组aaaaak;
    }

    public final void 你为什么要破解我的代码aaaacA(int n) {
        我草你怎么反编译我模组aaaaak = n;
    }

    public final int 你为什么要破解我的代码aaaaaf() {
        return 我草你怎么反编译我模组aaaaal;
    }

    public final void 你为什么要破解我的代码aaaaag(int n) {
        我草你怎么反编译我模组aaaaal = n;
    }

    @Override
    @NotNull
    public String 你为什么要破解我的代码aaaaaj() {
        return (String)aaaabH.aaaajG((char)-692715520);
    }

    @Override
    @NotNull
    public String 你为什么要破解我的代码aaaaak() {
        return (String)aaaabH.aaaajG((char)266665985);
    }

    @Override
    public void 你为什么要破解我的代码aaaaal(@NotNull MinecraftServer minecraftServer) {
        Intrinsics.checkNotNullParameter((Object)minecraftServer, (String)((String)aaaabH.aaaajG((char)211419138)));
        try {
            class_3218 class_32182;
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaabH.aaaajG((char)679477251));
            我草你怎么反编译我模组aaaaad = minecraftServer;
            class_3218 class_32183 = minecraftServer.method_30002();
            Intrinsics.checkNotNullExpressionValue((Object)class_32183, (String)((String)aaaabH.aaaajG((char)-1479081980)));
            PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaak(class_32183);
            MinecraftServer minecraftServer2 = 我草你怎么反编译我模组aaaaad;
            Intrinsics.checkNotNull((Object)minecraftServer2);
            class_3218 class_32184 = class_32182 = minecraftServer2.method_30002();
            boolean bl = false;
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19392)).method_20758(false, minecraftServer);
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19391)).method_20758(false, minecraftServer);
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19393)).method_20758(false, minecraftServer);
            ((class_1928.class_4312)class_32184.method_8450().method_20746(class_1928.field_19399)).method_35236(0, minecraftServer);
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19390)).method_20758(false, minecraftServer);
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19406)).method_20758(false, minecraftServer);
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19396)).method_20758(false, minecraftServer);
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19400)).method_20758(false, minecraftServer);
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19397)).method_20758(false, minecraftServer);
            ((class_1928.class_4310)class_32184.method_8450().method_20746(class_1928.field_19394)).method_20758(false, minecraftServer);
            this.你为什么要破解我的代码aaaaao(minecraftServer);
            PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().register((Object)this);
            List list = minecraftServer.method_3760().method_14571();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)((String)aaaabH.aaaajG((char)-845414395)));
            class_32182 = (Iterable)list;
            boolean bl2 = false;
            for (Object object : class_32182) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl3 = false;
                Intrinsics.checkNotNull((Object)class_32222);
                我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiN(class_32222);
            }
            aaaaac.你为什么要破解我的代码aaaaaa(minecraftServer, (Set<class_2248>)((Set)new HashSet()));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaabH.aaaajG((char)-1398734842));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)aaaabH.aaaajG((char)988086279), (Throwable)exception);
            throw exception;
        }
    }

    private final void 你为什么要破解我的代码aaaaao(MinecraftServer minecraftServer) {
        Object[] objectArray;
        Object[] objectArray2 = objectArray = minecraftServer.method_3837().method_12970(class_2960.method_60655((String)((String)aaaabH.aaaajG((char)-169279480)), (String)((String)aaaabH.aaaajG((char)1334509577))), (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)-1517551606))));
        boolean bl = false;
        objectArray2.method_5416(class_1259.class_1260.field_5782);
        objectArray2.method_12956(我草你怎么反编译我模组aaaaal);
        objectArray2.method_12954(我草你怎么反编译我模组aaaaak);
        Object[] objectArray3 = objectArray;
        Intrinsics.checkNotNullExpressionValue((Object)objectArray3, (String)((String)aaaabH.aaaajG((char)-1543700469)));
        我草你怎么反编译我模组aaaaah = objectArray3;
        objectArray2 = objectArray = minecraftServer.method_3837().method_12970(class_2960.method_60655((String)((String)aaaabH.aaaajG((char)-63373304)), (String)((String)aaaabH.aaaajG((char)-1022164980))), (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)-681639923))));
        bl = false;
        objectArray2.method_5416(class_1259.class_1260.field_5785);
        objectArray2.method_12956(33);
        objectArray2.method_12954(1);
        Object[] objectArray4 = objectArray;
        Intrinsics.checkNotNullExpressionValue((Object)objectArray4, (String)((String)aaaabH.aaaajG((char)-631308277)));
        我草你怎么反编译我模组aaaadw = objectArray4;
        objectArray = new Object[]{10};
        objectArray2 = objectArray = minecraftServer.method_3837().method_12970(class_2960.method_60655((String)((String)aaaabH.aaaajG((char)-1603141624)), (String)((String)aaaabH.aaaajG((char)143982606))), (class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-875102193)), (Object[])objectArray));
        bl = false;
        objectArray2.method_5416(class_1259.class_1260.field_5780);
        objectArray2.method_5409(class_1259.class_1261.field_5791);
        objectArray2.method_14091(false);
        Object[] objectArray5 = objectArray;
        Intrinsics.checkNotNullExpressionValue((Object)objectArray5, (String)((String)aaaabH.aaaajG((char)2076114955)));
        我草你怎么反编译我模组aaaadx = objectArray5;
        objectArray2 = objectArray = minecraftServer.method_3837().method_12970(class_2960.method_60655((String)((String)aaaabH.aaaajG((char)-1207369720)), (String)((String)aaaabH.aaaajG((char)-1563951088))), (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)-1248919535))));
        bl = false;
        objectArray2.method_5416(class_1259.class_1260.field_5783);
        objectArray2.method_12956(aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaaa());
        objectArray2.method_12954(0);
        objectArray2.method_14091(true);
        Object[] objectArray6 = objectArray;
        Intrinsics.checkNotNullExpressionValue((Object)objectArray6, (String)((String)aaaabH.aaaajG((char)630063115)));
        我草你怎么反编译我模组aaaaaj = objectArray6;
        List list = minecraftServer.method_3760().method_14571();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)((String)aaaabH.aaaajG((char)1639251973)));
        Iterable iterable = (Iterable)list;
        boolean bl2 = false;
        for (Object object : iterable) {
            class_3222 class_32222 = (class_3222)object;
            boolean bl3 = false;
            class_3002 class_30022 = 我草你怎么反编译我模组aaaaah;
            if (class_30022 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-1036517358)));
                class_30022 = null;
            }
            class_30022.method_14088(class_32222);
            class_3002 class_30023 = 我草你怎么反编译我模组aaaadw;
            if (class_30023 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-1205862381)));
                class_30023 = null;
            }
            class_30023.method_14088(class_32222);
            class_3002 class_30024 = 我草你怎么反编译我模组aaaadx;
            if (class_30024 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-972029932)));
                class_30024 = null;
            }
            class_30024.method_14088(class_32222);
            class_3002 class_30025 = 我草你怎么反编译我模组aaaaaj;
            if (class_30025 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)143458325)));
                class_30025 = null;
            }
            class_30025.method_14088(class_32222);
        }
    }

    @Override
    public void 你为什么要破解我的代码aaaaam(@NotNull MinecraftServer minecraftServer) {
        class_3004 class_30042;
        Intrinsics.checkNotNullParameter((Object)minecraftServer, (String)((String)aaaabH.aaaajG((char)-1267662846)));
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaabH.aaaajG((char)-1999962090));
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().unregister((Object)this);
        class_3004 class_30043 = class_30042 = minecraftServer.method_3837();
        boolean bl = false;
        class_3002 class_30022 = 我草你怎么反编译我模组aaaaah;
        if (class_30022 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1931935762)));
            class_30022 = null;
        }
        class_30043.method_12973(class_30022);
        class_3002 class_30023 = 我草你怎么反编译我模组aaaadw;
        if (class_30023 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-1888747501)));
            class_30023 = null;
        }
        class_30043.method_12973(class_30023);
        class_3002 class_30024 = 我草你怎么反编译我模组aaaadx;
        if (class_30024 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1910243348)));
            class_30024 = null;
        }
        class_30043.method_12973(class_30024);
        class_3002 class_30025 = 我草你怎么反编译我模组aaaaaj;
        if (class_30025 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)537591829)));
            class_30025 = null;
        }
        class_30043.method_12973(class_30025);
        我草你怎么反编译我模组aaaaad = null;
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaal();
        我草你怎么反编译我模组aaaadn = 0;
        我草你怎么反编译我模组aaaaan = 0;
        我草你怎么反编译我模组aaaadi.clear();
        我草你怎么反编译我模组aaaadj.clear();
        我草你怎么反编译我模组aaaadk.clear();
    }

    @Override
    @NotNull
    public class_243 你为什么要破解我的代码aaaabQ() {
        MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
        if (minecraftServer != null && (minecraftServer = minecraftServer.method_3760()) != null && (minecraftServer = minecraftServer.method_14571()) != null) {
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)class_32222);
                我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaacU(class_32222);
                class_32222.method_6033(class_32222.method_6063());
            }
        }
        if (我草你怎么反编译我模组aaaadn == 0) {
            return 我草你怎么反编译我模组aaaacl;
        }
        return (class_243)我草你怎么反编译我模组aaaadz.get(我草你怎么反编译我模组aaaadn);
    }

    public final void 你为什么要破解我的代码aaaabJ(@NotNull class_3222 class_32222) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)871235607)));
        class_32222.method_6033(class_32222.method_6063());
        class_32222.method_7344().method_7580(20);
        class_32222.method_7344().method_7581(0.0f);
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-272170984));
        aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)1269891097))), (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)374603802))), 10, 70, 20);
        class_32222.method_6092(new class_1293(class_1294.field_5925, -1, 0, false, false));
        MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
        Intrinsics.checkNotNull((Object)minecraftServer);
        ((class_1928.class_4310)minecraftServer.method_3767().method_20746(class_1928.field_19400)).method_20758(false, 我草你怎么反编译我模组aaaaad);
        MinecraftServer minecraftServer2 = 我草你怎么反编译我模组aaaaad;
        Intrinsics.checkNotNull((Object)minecraftServer2);
        ((class_1928.class_4310)minecraftServer2.method_3767().method_20746(class_1928.field_19397)).method_20758(false, 我草你怎么反编译我模组aaaaad);
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam.你为什么要破解我的代码aaaaaa(class_32222, this.你为什么要破解我的代码aaaabQ().field_1352, this.你为什么要破解我的代码aaaabQ().field_1351, this.你为什么要破解我的代码aaaabQ().field_1350);
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaaan(@NotNull aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaad aaaaad2) {
        block12: {
            boolean bl;
            class_3222 class_32222;
            boolean bl2;
            Iterable iterable;
            Intrinsics.checkNotNullParameter((Object)aaaaad2, (String)((String)aaaabH.aaaajG((char)-2127560677)));
            int n = 我草你怎么反编译我模组aaaaae;
            我草你怎么反编译我模组aaaaae = n + 1;
            if (我草你怎么反编译我模组aaaaae % 5 == 0) {
                MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
                if (minecraftServer != null && (minecraftServer = minecraftServer.method_3760()) != null && (minecraftServer = minecraftServer.method_14571()) != null) {
                    iterable = (Iterable)minecraftServer;
                    bl2 = false;
                    for (Object object : iterable) {
                        class_32222 = (class_3222)object;
                        bl = false;
                        class_243 class_2432 = class_32222.method_19538();
                        if (class_2432.method_1022(我草你怎么反编译我模组aaaadq) < 5.0) {
                            if (!我草你怎么反编译我模组aaaado) {
                                我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiP();
                            }
                        } else if (我草你怎么反编译我模组aaaado) {
                            我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiQ();
                        }
                        Iterable iterable2 = (Iterable)我草你怎么反编译我模组aaaadz;
                        boolean bl3 = false;
                        int n2 = 0;
                        for (Object object2 : iterable2) {
                            int n3;
                            if ((n3 = n2++) < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            class_243 class_2433 = (class_243)object2;
                            int n4 = n3;
                            boolean bl4 = false;
                            if (!(class_2432.method_1022(class_2433) < 3.0)) continue;
                            if (n4 <= 我草你怎么反编译我模组aaaadn) continue;
                            Intrinsics.checkNotNull((Object)class_32222);
                            我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiO(class_32222, n4);
                        }
                    }
                }
                this.你为什么要破解我的代码aaaadg();
            }
            if (我草你怎么反编译我模组aaaado && 我草你怎么反编译我模组aaaaae % 20 == 0) {
                this.你为什么要破解我的代码aaaaiR();
            }
            if (我草你怎么反编译我模组aaaaae % 20 != 0) break block12;
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer != null && (minecraftServer = minecraftServer.method_3760()) != null && (minecraftServer = minecraftServer.method_14571()) != null) {
                iterable = (Iterable)minecraftServer;
                bl2 = false;
                for (Object object : iterable) {
                    class_32222 = (class_3222)object;
                    bl = false;
                    Intrinsics.checkNotNull((Object)class_32222);
                    我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaacU(class_32222);
                }
            }
        }
    }

    public final void 你为什么要破解我的代码aaaaiI(@NotNull class_3222 class_32222) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)1402142743)));
        我草你怎么反编译我模组aaaadn = 0;
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam.你为什么要破解我的代码aaaaaa(class_32222, aaaabH.我草你怎么反编译我模组aaaacl.field_1352, aaaabH.我草你怎么反编译我模组aaaacl.field_1351, aaaabH.我草你怎么反编译我模组aaaacl.field_1350);
        this.你为什么要破解我的代码aaaaiJ(class_32222);
    }

    public final void 你为什么要破解我的代码aaaaiJ(@NotNull class_3222 class_32222) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)1979252759)));
        class_32222.method_6092(new class_1293(class_1294.field_5925, -1, 0, false, false));
        class_32222.method_7344().method_7580(20);
        class_32222.method_7344().method_7581(2.0f);
    }

    private final void 你为什么要破解我的代码aaaaiK(class_3222 class_32222) {
        class_32222.method_6012();
        class_32222.method_6092(new class_1293(class_1294.field_5925, -1, 0, false, false));
    }

    private final class_243 你为什么要破解我的代码aaaaiL() {
        int n = RangesKt.coerceAtLeast((int)(我草你怎么反编译我模组aaaadn - 1), (int)0);
        return (class_243)我草你怎么反编译我模组aaaadz.get(n);
    }

    private final class_243 你为什么要破解我的代码aaaaiM() {
        int n = RangesKt.coerceAtMost((int)(我草你怎么反编译我模组aaaadn + 1), (int)(我草你怎么反编译我模组aaaadz.size() - 1));
        return (class_243)我草你怎么反编译我模组aaaadz.get(n);
    }

    private final void 你为什么要破解我的代码aaaadg() {
        block19: {
            boolean bl;
            class_3222 class_32222;
            boolean bl2;
            Iterable iterable;
            class_3002 class_30022 = 我草你怎么反编译我模组aaaaah;
            if (class_30022 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-808255470)));
                class_30022 = null;
            }
            class_30022.method_12954(我草你怎么反编译我模组aaaaak);
            class_3002 class_30023 = 我草你怎么反编译我模组aaaaah;
            if (class_30023 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-373817326)));
                class_30023 = null;
            }
            class_30023.method_12956(我草你怎么反编译我模组aaaaal);
            class_3002 class_30024 = 我草你怎么反编译我模组aaaaah;
            if (class_30024 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1915486226)));
                class_30024 = null;
            }
            String string = (String)aaaabH.aaaajG((char)1547960348);
            Object[] objectArray = new Object[2];
            class_3002 class_30025 = 我草你怎么反编译我模组aaaaah;
            if (class_30025 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)172752914)));
                class_30025 = null;
            }
            objectArray[0] = class_30025.method_12955();
            class_3002 class_30026 = 我草你怎么反编译我模组aaaaah;
            if (class_30026 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-303497198)));
                class_30026 = null;
            }
            objectArray[1] = class_30026.method_12960();
            class_30024.method_5413((class_2561)class_2561.method_43469((String)string, (Object[])objectArray));
            class_3002 class_30027 = 我草你怎么反编译我模组aaaadw;
            if (class_30027 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-1165688813)));
                class_30027 = null;
            }
            class_30027.method_12954(我草你怎么反编译我模组aaaadn);
            class_3002 class_30028 = 我草你怎么反编译我模组aaaadw;
            if (class_30028 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)136314899)));
                class_30028 = null;
            }
            class_30028.method_12956(33);
            class_3002 class_30029 = 我草你怎么反编译我模组aaaadw;
            if (class_30029 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)884015123)));
                class_30029 = null;
            }
            objectArray = new Object[]{我草你怎么反编译我模组aaaadn, 33};
            class_30029.method_5413((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-855048163)), (Object[])objectArray));
            this.你为什么要破解我的代码aaaaas();
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer != null && (minecraftServer = minecraftServer.method_3760()) != null && (minecraftServer = minecraftServer.method_14571()) != null) {
                iterable = (Iterable)minecraftServer;
                bl2 = false;
                for (Object object : iterable) {
                    class_32222 = (class_3222)object;
                    bl = false;
                    class_3002 class_300210 = 我草你怎么反编译我模组aaaaah;
                    if (class_300210 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)467927058)));
                        class_300210 = null;
                    }
                    class_300210.method_14088(class_32222);
                    class_3002 class_300211 = 我草你怎么反编译我模组aaaadw;
                    if (class_300211 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-1546649581)));
                        class_300211 = null;
                    }
                    class_300211.method_14088(class_32222);
                    class_3002 class_300212 = 我草你怎么反编译我模组aaaadx;
                    if (class_300212 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)689176596)));
                        class_300212 = null;
                    }
                    class_300212.method_14088(class_32222);
                    class_3002 class_300213 = 我草你怎么反编译我模组aaaaaj;
                    if (class_300213 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-2017591275)));
                        class_300213 = null;
                    }
                    class_300213.method_14088(class_32222);
                }
            }
            if (!我草你怎么反编译我模组aaaado) break block19;
            class_3002 class_300214 = 我草你怎么反编译我模组aaaadx;
            if (class_300214 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-2118909932)));
                class_300214 = null;
            }
            class_300214.method_5408((float)我草你怎么反编译我模组aaaadp / 10.0f);
            class_3002 class_300215 = 我草你怎么反编译我模组aaaadx;
            if (class_300215 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1112145940)));
                class_300215 = null;
            }
            objectArray = new Object[]{我草你怎么反编译我模组aaaadp};
            class_300215.method_5413((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)20512783)), (Object[])objectArray));
            MinecraftServer minecraftServer2 = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer2 != null && (minecraftServer2 = minecraftServer2.method_3760()) != null && (minecraftServer2 = minecraftServer2.method_14571()) != null) {
                iterable = (Iterable)minecraftServer2;
                bl2 = false;
                for (Object object : iterable) {
                    class_32222 = (class_3222)object;
                    bl = false;
                    class_3002 class_300216 = 我草你怎么反编译我模组aaaadx;
                    if (class_300216 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-609288172)));
                        class_300216 = null;
                    }
                    class_300216.method_14088(class_32222);
                }
            }
        }
    }

    private final void 你为什么要破解我的代码aaaaas() {
        aaaabh aaaabh2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak();
        String string = aaaabh2.你为什么要破解我的代码aaaabd().你为什么要破解我的代码aaaaaa();
        String string2 = (String)aaaabh2.你为什么要破解我的代码aaaaao().get((Object)string);
        if (string2 == null) {
            string2 = string;
        }
        String string3 = string2;
        int n = aaaabh2.你为什么要破解我的代码aaaaaa();
        float f = (float)我草你怎么反编译我模组aaaaan / (float)n;
        class_3002 class_30022 = 我草你怎么反编译我模组aaaaaj;
        if (class_30022 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1795293205)));
            class_30022 = null;
        }
        class_30022.method_12954(我草你怎么反编译我模组aaaaan);
        class_3002 class_30023 = 我草你怎么反编译我模组aaaaaj;
        if (class_30023 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-2019229675)));
            class_30023 = null;
        }
        class_30023.method_5416(f < 0.33f ? class_1259.class_1260.field_5784 : (f < 0.66f ? class_1259.class_1260.field_5782 : class_1259.class_1260.field_5785));
        class_3002 class_30024 = 我草你怎么反编译我模组aaaaaj;
        if (class_30024 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1740439573)));
            class_30024 = null;
        }
        Object[] objectArray = new Object[]{"§6§l" + string3, 我草你怎么反编译我模组aaaaan, n};
        class_30024.method_5413((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-1995636706)), (Object[])objectArray));
    }

    private final void 你为什么要破解我的代码aaaaiN(class_3222 class_32222) {
        class_32222.method_6092(new class_1293(class_1294.field_5925, -1, 0, false, false));
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam.你为什么要破解我的代码aaaaaa(class_32222, aaaabH.我草你怎么反编译我模组aaaacl.field_1352, aaaabH.我草你怎么反编译我模组aaaacl.field_1351, aaaabH.我草你怎么反编译我模组aaaacl.field_1350);
    }

    private final void 你为什么要破解我的代码aaaacU(class_3222 class_32222) {
        class_32222.method_7344().method_7580(20);
        class_32222.method_7344().method_7581(0.0f);
        if (!class_32222.method_6059(class_1294.field_5925)) {
            class_32222.method_6092(new class_1293(class_1294.field_5925, -1, 0, false, false));
        }
    }

    public final void 你为什么要破解我的代码aaaaiO(@NotNull class_3222 class_32222, int n) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)766836759)));
        我草你怎么反编译我模组aaaadn = n;
        class_3002 class_30022 = 我草你怎么反编译我模组aaaadw;
        if (class_30022 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1190985747)));
            class_30022 = null;
        }
        class_30022.method_12954(我草你怎么反编译我模组aaaadn);
        class_3002 class_30023 = 我草你怎么反编译我模组aaaadw;
        if (class_30023 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1558315027)));
            class_30023 = null;
        }
        Object[] objectArray = new Object[]{我草你怎么反编译我模组aaaadn, 33};
        class_30023.method_5413((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-1929576419)), (Object[])objectArray));
        if (n > 0) {
            objectArray = new Object[]{"§b" + n};
            class_2561 class_25612 = (class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-894042081)), (Object[])objectArray);
            objectArray = new Object[]{"§a" + n, "§a" + (我草你怎么反编译我模组aaaadz.size() - 1)};
            aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, class_25612, (class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)1699086368)), (Object[])objectArray), 3, 10, 3);
            aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-1727725535));
        }
        if (n == 我草你怎么反编译我模组aaaadz.size() - 1 && !我草你怎么反编译我模组aaaady) {
            this.你为什么要破解我的代码aaaaiP();
        }
        this.你为什么要破解我的代码aaaadg();
    }

    private final void 你为什么要破解我的代码aaaaiP() {
        block2: {
            我草你怎么反编译我模组aaaado = true;
            我草你怎么反编译我模组aaaadp = 10;
            class_3002 class_30022 = 我草你怎么反编译我模组aaaadx;
            if (class_30022 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)778895380)));
                class_30022 = null;
            }
            class_30022.method_14091(true);
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block2;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)class_32222);
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)-2116550622))), (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)2068709411))), 10, 70, 20);
                aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-2053439452));
            }
        }
    }

    private final void 你为什么要破解我的代码aaaaiQ() {
        block2: {
            我草你怎么反编译我模组aaaado = false;
            class_3002 class_30022 = 我草你怎么反编译我模组aaaadx;
            if (class_30022 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)141819924)));
                class_30022 = null;
            }
            class_30022.method_14091(false);
            我草你怎么反编译我模组aaaadp = 10;
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block2;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)class_32222);
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)1944780837))), (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)1696858150))), 10, 70, 20);
                aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-1056702425));
            }
        }
    }

    private final void 你为什么要破解我的代码aaaaiR() {
        int n = 我草你怎么反编译我模组aaaadp;
        我草你怎么反编译我模组aaaadp = n + -1;
        class_3002 class_30022 = 我草你怎么反编译我模组aaaadx;
        if (class_30022 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)1070989332)));
            class_30022 = null;
        }
        class_30022.method_5408((float)我草你怎么反编译我模组aaaadp / 10.0f);
        class_3002 class_30023 = 我草你怎么反编译我模组aaaadx;
        if (class_30023 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)316014612)));
            class_30023 = null;
        }
        Object[] objectArray = new Object[]{我草你怎么反编译我模组aaaadp};
        class_30023.method_5413((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)689569807)), (Object[])objectArray));
        MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
        if (minecraftServer != null && (minecraftServer = minecraftServer.method_3760()) != null && (minecraftServer = minecraftServer.method_14571()) != null) {
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-574160856));
                Intrinsics.checkNotNull((Object)class_32222);
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, class_2561.method_30163((String)("§6" + 我草你怎么反编译我模组aaaadp)), (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)-373817303))), 0, 20, 5);
            }
        }
        if (我草你怎么反编译我模组aaaadp <= 0) {
            this.你为什么要破解我的代码aaaada();
        }
    }

    private final void 你为什么要破解我的代码aaaada() {
        我草你怎么反编译我模组aaaado = false;
        class_3002 class_30022 = 我草你怎么反编译我模组aaaadx;
        if (class_30022 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-1398603756)));
            class_30022 = null;
        }
        class_30022.method_14091(false);
        int n = 我草你怎么反编译我模组aaaaak;
        我草你怎么反编译我模组aaaaak = n + 1;
        我草你怎么反编译我模组aaaadn = 0;
        MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
        if (minecraftServer != null && (minecraftServer = minecraftServer.method_3760()) != null && (minecraftServer = minecraftServer.method_14571()) != null) {
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                class_243 class_2432 = (class_243)我草你怎么反编译我模组aaaadz.get(0);
                Intrinsics.checkNotNull((Object)class_32222);
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam.你为什么要破解我的代码aaaaaa(class_32222, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
                aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-995819478));
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)-2044329941))), (class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)371458092))), 10, 70, 20);
                我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiJ(class_32222);
            }
        }
        this.你为什么要破解我的代码aaaadg();
    }

    @Override
    @NotNull
    public MinecraftServer 你为什么要破解我的代码aaaabR() {
        MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
        Intrinsics.checkNotNull((Object)minecraftServer);
        return minecraftServer;
    }

    private final void 你为什么要破解我的代码aaaaiS(class_3222 class_32222, int n) {
        if (this.你为什么要破解我的代码aaaajn(class_32222)) {
            return;
        }
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2++;
            boolean bl = false;
            我草你怎么反编译我模组aaaadl.你为什么要破解我的代码aaaaaa((Function0<Unit>)((Function0)new aaaaaC(class_32222)));
        }
    }

    private final void 你为什么要破解我的代码aaaaiT(class_3222 class_32222, int n) {
        if (this.你为什么要破解我的代码aaaajn(class_32222)) {
            return;
        }
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2++;
            boolean bl = false;
            我草你怎么反编译我模组aaaadl.你为什么要破解我的代码aaaaaa((Function0<Unit>)((Function0)new aaaacy(class_32222)));
        }
    }

    private final void 你为什么要破解我的代码aaaaiU(class_3222 class_32222, int n) {
        if (this.你为什么要破解我的代码aaaajn(class_32222)) {
            return;
        }
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2++;
            boolean bl = false;
            我草你怎么反编译我模组aaaadl.你为什么要破解我的代码aaaaaa((Function0<Unit>)((Function0)new aaaabQ(class_32222)));
        }
    }

    private final int 你为什么要破解我的代码aaaaiV(class_243 class_2432) {
        int n = 0;
        double d = 0.0;
        d = Double.MAX_VALUE;
        Iterable iterable = (Iterable)我草你怎么反编译我模组aaaadz;
        boolean bl = false;
        int n2 = 0;
        for (Object object : iterable) {
            int n3;
            if ((n3 = n2++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            class_243 class_2433 = (class_243)object;
            int n4 = n3;
            boolean bl2 = false;
            double d2 = class_2432.method_1022(class_2433);
            if (!(d2 < d) || !(d2 < 3.0)) continue;
            d = d2;
            n = n4;
        }
        return n;
    }

    public final void 你为什么要破解我的代码aaaaiW(@NotNull class_3222 class_32222, int n) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)870514711)));
        int n2 = RangesKt.coerceAtLeast((int)(我草你怎么反编译我模组aaaadn - n), (int)0);
        class_243 class_2432 = (class_243)我草你怎么反编译我模组aaaadz.get(n2);
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam.你为什么要破解我的代码aaaaaa(class_32222, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        this.你为什么要破解我的代码aaaaiO(class_32222, n2);
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-1793982419));
    }

    public final void 你为什么要破解我的代码aaaaiX(@NotNull class_3222 class_32222) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-790691817)));
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam.你为什么要破解我的代码aaaaaa(class_32222, aaaabH.我草你怎么反编译我模组aaaacl.field_1352, aaaabH.我草你怎么反编译我模组aaaacl.field_1351, aaaabH.我草你怎么反编译我模组aaaacl.field_1350);
        this.你为什么要破解我的代码aaaaiO(class_32222, 0);
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)408158254));
    }

    private final void 你为什么要破解我的代码aaaaiY(class_3222 class_32222, int n) {
        if (this.你为什么要破解我的代码aaaajn(class_32222)) {
            return;
        }
        double d = n;
        long l = ((Number)我草你怎么反编译我模组aaaadk.getOrDefault((Object)class_32222, (Object)System.currentTimeMillis())).longValue();
        long l2 = l > System.currentTimeMillis() ? l + (long)(d * (double)1000) : System.currentTimeMillis() + (long)(d * (double)1000);
        Long l3 = l2;
        我草你怎么反编译我模组aaaadk.put((Object)class_32222, (Object)l3);
        double d2 = 18.75;
        BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)new aaaaag(class_32222, d2, null), (int)2, null);
    }

    public final void 你为什么要破解我的代码aaaaiZ(@NotNull class_3222 class_32222) {
        class_1538 class_15382;
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-411697129)));
        class_1538 class_15383 = class_15382 = new class_1538(class_1299.field_6112, class_32222.method_37908());
        boolean bl = false;
        class_15383.method_29498(true);
        class_1538 class_15384 = class_15382;
        class_15384.method_33574(class_32222.method_19538());
        class_32222.method_37908().method_8649((class_1297)class_15384);
        class_32222.method_5643(class_32222.method_37908().method_48963().method_48809(), 6.0f);
        double d = Math.toRadians((double)class_32222.method_36454());
        double d2 = 0.8;
        double d3 = 0.9;
        double d4 = d2 * Math.sin((double)d);
        double d5 = d3;
        double d6 = -d2 * Math.cos((double)d);
        class_32222.method_18799(new class_243(d4, d5, d6));
        class_32222.field_6037 = true;
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaaeo(@NotNull ExplosionEvent explosionEvent) {
        Intrinsics.checkNotNullParameter((Object)explosionEvent, (String)((String)aaaabH.aaaajG((char)-2009989093)));
        explosionEvent.getExplosion().method_8352();
    }

    private final void 你为什么要破解我的代码aaaaja(class_3222 class_32222) {
        class_1541 class_15412;
        class_1937 class_19372 = class_32222.method_37908();
        Intrinsics.checkNotNull((Object)class_19372, (String)((String)aaaabH.aaaajG((char)1595473967)));
        class_3218 class_32182 = (class_3218)class_19372;
        double d = 3.0;
        class_32222.method_6092(new class_1293(class_1294.field_5907, 40, 3, false, false));
        double d2 = Random.Default.nextDouble() * (double)2 * Math.PI;
        double d3 = d * Math.cos((double)d2);
        double d4 = d * Math.sin((double)d2);
        double d5 = class_32222.method_23317() + d3;
        double d6 = class_32222.method_23321() + d4;
        class_1541 class_15413 = class_15412 = new class_1541((class_1937)class_32182, d5, class_32222.method_23318() + 0.5, d6, (class_1309)class_32222);
        boolean bl = false;
        class_15413.method_6967(10);
        class_1541 class_15414 = class_15412;
        class_32182.method_8649((class_1297)class_15414);
        class_32182.method_14199((class_2394)class_2398.field_11251, d5, class_32222.method_23318() + 0.5, d6, 10, 0.5, 0.5, 0.5, 0.1);
    }

    private final void 你为什么要破解我的代码aaaajb(class_3222 class_32222, String string) {
        class_1937 class_19372 = class_32222.method_37908();
        double d = class_32222.method_23317() + (Random.Default.nextDouble() - 0.5) * (double)10;
        double d2 = class_32222.method_23318() + Random.Default.nextDouble() * (double)2;
        double d3 = class_32222.method_23321() + (Random.Default.nextDouble() - 0.5) * (double)10;
        Object[] objectArray = class_1299.field_20346;
        aaaacx aaaacx2 = new aaaacx(class_19372, (class_1299<class_4466>)objectArray);
        aaaacx2.method_30634(d, d2, d3);
        aaaacx2.method_29514(99999);
        aaaacx2.method_29513(class_32222.method_5667());
        aaaacx2.method_29505((class_1657)class_32222);
        aaaacx2.method_5980((class_1309)class_32222);
        objectArray = new Object[]{class_2561.method_43470((String)("§c" + string))};
        aaaacx2.method_5665((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-1949827024)), (Object[])objectArray));
        aaaacx2.method_5880(true);
        class_19372.method_8649((class_1297)aaaacx2);
    }

    public final void 你为什么要破解我的代码aaaajc(@NotNull class_3222 class_32222, int n) {
        class_1293 class_12932;
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-335806441)));
        if (this.你为什么要破解我的代码aaaajn(class_32222)) {
            return;
        }
        class_6880 class_68802 = class_1294.field_5916;
        int n2 = n * 20;
        class_1293 class_12933 = class_12932 = class_32222.method_6112(class_68802);
        int n3 = class_12933 != null ? class_12933.method_5584() : 0;
        class_32222.method_6092(new class_1293(class_68802, n3 + n2, 0));
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-325189583));
    }

    private final boolean 你为什么要破解我的代码aaaajd(class_3222 class_32222) {
        MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
        return (minecraftServer != null && (minecraftServer = minecraftServer.method_3760()) != null ? minecraftServer.method_14602(class_32222.method_5667()) : null) != null;
    }

    public final void 你为什么要破解我的代码aaaaje(@NotNull class_3222 class_32222, int n) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-722534377)));
        if (this.你为什么要破解我的代码aaaajn(class_32222)) {
            return;
        }
        int n2 = n;
        long l = ((Number)我草你怎么反编译我模组aaaadi.getOrDefault((Object)class_32222, (Object)System.currentTimeMillis())).longValue();
        long l2 = l > System.currentTimeMillis() ? l + (long)(n2 * 1000) : System.currentTimeMillis() + (long)(n2 * 1000);
        Long l3 = l2;
        我草你怎么反编译我模组aaaadi.put((Object)class_32222, (Object)l3);
        BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)new aaaacc(class_32222, null), (int)2, null);
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)419889202));
    }

    public final void 你为什么要破解我的代码aaaajf(@NotNull class_3222 class_32222, int n) {
        class_1293 class_12932;
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-4718569)));
        if (this.你为什么要破解我的代码aaaajn(class_32222)) {
            return;
        }
        class_6880 class_68802 = class_1294.field_5909;
        int n2 = n * 20;
        class_1293 class_12933 = class_12932 = class_32222.method_6112(class_68802);
        int n3 = class_12933 != null ? class_12933.method_5584() : 0;
        class_32222.method_6092(new class_1293(class_68802, n3 + n2, 1));
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-187301837));
    }

    public final void 你为什么要破解我的代码aaaajg(@NotNull class_3222 class_32222, int n) {
        class_1293 class_12932;
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-1577779177)));
        if (this.你为什么要破解我的代码aaaajn(class_32222)) {
            return;
        }
        class_6880 class_68802 = class_1294.field_5919;
        int n2 = n * 20;
        class_1293 class_12933 = class_12932 = class_32222.method_6112(class_68802);
        int n3 = class_12933 != null ? class_12933.method_5584() : 0;
        class_32222.method_6092(new class_1293(class_68802, n3 + n2, 0));
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-1928462284));
    }

    public final void 你为什么要破解我的代码aaaajh(@NotNull class_3222 class_32222, int n) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-826540009)));
        int n2 = RangesKt.coerceAtMost((int)(我草你怎么反编译我模组aaaadn + n), (int)(我草你怎么反编译我模组aaaadz.size() - 1));
        class_243 class_2432 = (class_243)我草你怎么反编译我模组aaaadz.get(n2);
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam.你为什么要破解我的代码aaaaaa(class_32222, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        this.你为什么要破解我的代码aaaaiO(class_32222, n2);
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)555745333));
    }

    public final void 你为什么要破解我的代码aaaaji(@NotNull class_3222 class_32222) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)261423127)));
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam.你为什么要破解我的代码aaaaaa(class_32222, aaaabH.我草你怎么反编译我模组aaaadq.field_1352, aaaabH.我草你怎么反编译我模组aaaadq.field_1351, aaaabH.我草你怎么反编译我模组aaaadq.field_1350);
        this.你为什么要破解我的代码aaaaiO(class_32222, 我草你怎么反编译我模组aaaadz.size() - 1);
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-1981677514));
    }

    public final void 你为什么要破解我的代码aaaajj(@NotNull class_3222 class_32222, int n) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)243269655)));
        int n2 = n;
        long l = ((Number)我草你怎么反编译我模组aaaadj.getOrDefault((Object)class_32222, (Object)System.currentTimeMillis())).longValue();
        long l2 = l > System.currentTimeMillis() ? l + (long)(n2 * 1000) : System.currentTimeMillis() + (long)(n2 * 1000);
        Long l3 = l2;
        我草你怎么反编译我模组aaaadj.put((Object)class_32222, (Object)l3);
        class_32222.method_31549().field_7478 = true;
        class_32222.method_31549().field_7479 = true;
        class_32222.method_7355();
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)1896415287));
        BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)new aaaaaa(class_32222, null), (int)2, null);
    }

    public final void 你为什么要破解我的代码aaaajk(@NotNull class_3222 class_32222, int n) {
        class_1293 class_12932;
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)2008350743)));
        class_6880 class_68802 = class_1294.field_5904;
        int n2 = n * 20;
        class_1293 class_12933 = class_12932 = class_32222.method_6112(class_68802);
        int n3 = class_12933 != null ? class_12933.method_5584() : 0;
        class_32222.method_6092(new class_1293(class_68802, n3 + n2, 1));
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-820838344));
    }

    public final void 你为什么要破解我的代码aaaajl(@NotNull class_3222 class_32222, int n) {
        class_1293 class_12932;
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-100007913)));
        class_6880 class_68802 = class_1294.field_5913;
        int n2 = n * 20;
        class_1293 class_12933 = class_12932 = class_32222.method_6112(class_68802);
        int n3 = class_12933 != null ? class_12933.method_5584() : 0;
        class_32222.method_6092(new class_1293(class_68802, n3 + n2, 1));
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)-1305280455));
    }

    private final void 你为什么要破解我的代码aaaajm(class_3222 class_32222) {
        class_1799 class_17992 = new class_1799((class_1935)class_1802.field_8463);
        class_32222.method_7270(class_17992);
        class_1937 class_19372 = class_32222.method_37908();
        Intrinsics.checkNotNull((Object)class_19372, (String)((String)aaaabH.aaaajG((char)246612015)));
        class_3218 class_32182 = (class_3218)class_19372;
        class_32182.method_14199((class_2394)class_2398.field_11201, class_32222.method_23317(), class_32222.method_23318() + 1.0, class_32222.method_23321(), 5, 0.5, 0.5, 0.5, 0.1);
    }

    private final boolean 你为什么要破解我的代码aaaajn(class_3222 class_32222) {
        Long l = (Long)我草你怎么反编译我模组aaaadu.get((Object)class_32222);
        if (l == null) {
            return false;
        }
        long l2 = l;
        return System.currentTimeMillis() < l2;
    }

    public final void 你为什么要破解我的代码aaaajo(@NotNull class_3222 class_32222, int n) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-1409679337)));
        class_6880[] class_6880Array = new class_6880[]{class_1294.field_5916, class_1294.field_5909, class_1294.field_5919};
        class_6880Array = (class_6880[])CollectionsKt.listOf((Object[])class_6880Array);
        boolean bl = false;
        for (class_6880 class_68802 : class_6880Array) {
            class_6880 class_68803 = class_68802;
            boolean bl2 = false;
            class_32222.method_6016(class_68803);
        }
        我草你怎么反编译我模组aaaadi.remove((Object)class_32222);
        我草你怎么反编译我模组aaaadk.remove((Object)class_32222);
        Long l = (Long)我草你怎么反编译我模组aaaadu.get((Object)class_32222);
        long l2 = l != null ? l : System.currentTimeMillis();
        long l3 = 5000L * (long)n;
        long l4 = l2 > System.currentTimeMillis() ? l2 + l3 : System.currentTimeMillis() + l3;
        Long l5 = l4;
        我草你怎么反编译我模组aaaadu.put((Object)class_32222, (Object)l5);
        aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((String)aaaabH.aaaajG((char)1994326074));
        BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), null, null, (Function2)new aaaaam(class_32222, null), (int)3, null);
    }

    public final void 你为什么要破解我的代码aaaajp(@NotNull class_3222 class_32222, int n) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)1483669527)));
        try {
            List list = (List)new ArrayList();
            List list2 = (List)new ArrayList();
            int n2 = 我草你怎么反编译我模组aaaadz.size() - 1;
            for (int i = 1; i < n2; ++i) {
                list.add(我草你怎么反编译我模组aaaadz.get(i));
                list2.add((Object)i);
            }
            if (list.isEmpty()) {
                class_32222.method_43496((class_2561)class_2561.method_43471((String)((String)aaaabH.aaaajG((char)-1622671301))));
                return;
            }
            BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)new aaaaaS(n, (List<Integer>)list2, class_32222, null), (int)2, null);
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)aaaabH.aaaajG((char)-507641796), (Throwable)exception);
        }
    }

    public final void 你为什么要破解我的代码aaaahd(@NotNull String string, int n, @NotNull String string2, @NotNull String string3) {
        block14: {
            Collection collection;
            int n2;
            block38: {
                boolean bl;
                boolean bl2;
                Object object3;
                Object object22;
                block37: {
                    block36: {
                        block35: {
                            block34: {
                                block33: {
                                    block32: {
                                        block31: {
                                            block30: {
                                                block29: {
                                                    MinecraftServer minecraftServer;
                                                    block28: {
                                                        block27: {
                                                            block26: {
                                                                block25: {
                                                                    block24: {
                                                                        block23: {
                                                                            block22: {
                                                                                block21: {
                                                                                    block20: {
                                                                                        block19: {
                                                                                            block18: {
                                                                                                block17: {
                                                                                                    block16: {
                                                                                                        block15: {
                                                                                                            Iterable iterable;
                                                                                                            block13: {
                                                                                                                MinecraftServer minecraftServer2;
                                                                                                                Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)2123628605)));
                                                                                                                Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaabH.aaaajG((char)1356333118)));
                                                                                                                Intrinsics.checkNotNullParameter((Object)string3, (String)((String)aaaabH.aaaajG((char)-990707649)));
                                                                                                                Integer n3 = this.你为什么要破解我的代码aaaadR(string);
                                                                                                                String string4 = n3 != null && n3 > 1 ? "盲盒" + this.你为什么要破解我的代码aaaadS(n3) + "号_事件音效" : string + "_事件音效";
                                                                                                                aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac(string4);
                                                                                                                MinecraftServer minecraftServer3 = 我草你怎么反编译我模组aaaaad;
                                                                                                                if (minecraftServer3 != null && (minecraftServer3 = minecraftServer3.method_3760()) != null && (minecraftServer3 = minecraftServer3.method_14571()) != null) {
                                                                                                                    iterable = (Iterable)minecraftServer3;
                                                                                                                    boolean bl3 = false;
                                                                                                                    for (Object object22 : iterable) {
                                                                                                                        object3 = (class_3222)object22;
                                                                                                                        boolean bl4 = false;
                                                                                                                        Intrinsics.checkNotNull((Object)object3);
                                                                                                                        我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaaX((class_3222)object3, string3, n, string2, string);
                                                                                                                    }
                                                                                                                }
                                                                                                                if ((minecraftServer2 = 我草你怎么反编译我模组aaaaad) == null || (minecraftServer2 = minecraftServer2.method_3760()) == null || (minecraftServer2 = minecraftServer2.method_14571()) == null || (minecraftServer2 = (class_3222)CollectionsKt.firstOrNull((List)minecraftServer2)) == null) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                minecraftServer = minecraftServer2;
                                                                                                                if (n3 == null) break block13;
                                                                                                                this.你为什么要破解我的代码aaaahe(string2, n, n3);
                                                                                                                break block14;
                                                                                                            }
                                                                                                            Iterable iterable2 = (Iterable)aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaay();
                                                                                                            n2 = 0;
                                                                                                            iterable = iterable2;
                                                                                                            collection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable2, (int)10));
                                                                                                            bl2 = false;
                                                                                                            for (Object object3 : iterable) {
                                                                                                                aaaabb aaaabb2 = (aaaabb)object3;
                                                                                                                Collection collection2 = collection;
                                                                                                                bl = false;
                                                                                                                collection2.add((Object)aaaabb2.你为什么要破解我的代码aaaaaa());
                                                                                                            }
                                                                                                            if (!((List)collection).contains((Object)string)) break block15;
                                                                                                            this.你为什么要破解我的代码aaaabq(string, n, string2, string3);
                                                                                                            break block14;
                                                                                                        }
                                                                                                        if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-2086535104)))) break block16;
                                                                                                        this.你为什么要破解我的代码aaaaiW((class_3222)minecraftServer, n);
                                                                                                        break block14;
                                                                                                    }
                                                                                                    if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)1923678273)))) break block17;
                                                                                                    this.你为什么要破解我的代码aaaaiX((class_3222)minecraftServer);
                                                                                                    break block14;
                                                                                                }
                                                                                                if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)231735362)))) break block18;
                                                                                                this.你为什么要破解我的代码aaaajc((class_3222)minecraftServer, n);
                                                                                                break block14;
                                                                                            }
                                                                                            if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-1924399037)))) break block19;
                                                                                            this.你为什么要破解我的代码aaaaje((class_3222)minecraftServer, n);
                                                                                            break block14;
                                                                                        }
                                                                                        if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)797507652)))) break block20;
                                                                                        this.你为什么要破解我的代码aaaajf((class_3222)minecraftServer, n);
                                                                                        break block14;
                                                                                    }
                                                                                    if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)217907269)))) break block21;
                                                                                    this.你为什么要破解我的代码aaaajg((class_3222)minecraftServer, n);
                                                                                    break block14;
                                                                                }
                                                                                if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)399310918)))) break block22;
                                                                                this.你为什么要破解我的代码aaaajh((class_3222)minecraftServer, n);
                                                                                break block14;
                                                                            }
                                                                            if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-1584070585)))) break block23;
                                                                            this.你为什么要破解我的代码aaaaji((class_3222)minecraftServer);
                                                                            break block14;
                                                                        }
                                                                        if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-1411645368)))) break block24;
                                                                        this.你为什么要破解我的代码aaaajp((class_3222)minecraftServer, n);
                                                                        break block14;
                                                                    }
                                                                    if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-1510670263)))) break block25;
                                                                    this.你为什么要破解我的代码aaaajj((class_3222)minecraftServer, n);
                                                                    break block14;
                                                                }
                                                                if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)29687882)))) break block26;
                                                                this.你为什么要破解我的代码aaaajk((class_3222)minecraftServer, n);
                                                                break block14;
                                                            }
                                                            if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)223346763)))) break block27;
                                                            this.你为什么要破解我的代码aaaajl((class_3222)minecraftServer, n);
                                                            break block14;
                                                        }
                                                        if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)1241710668)))) break block28;
                                                        this.你为什么要破解我的代码aaaajo((class_3222)minecraftServer, n);
                                                        break block14;
                                                    }
                                                    if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)2099576909)))) break block29;
                                                    this.你为什么要破解我的代码aaaaiY((class_3222)minecraftServer, n);
                                                    break block14;
                                                }
                                                if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-1482096562)))) break block30;
                                                this.你为什么要破解我的代码aaaadu((String)aaaabH.aaaajG((char)1705181263), n);
                                                break block14;
                                            }
                                            if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-121044912)))) break block31;
                                            this.你为什么要破解我的代码aaaadu((String)aaaabH.aaaajG((char)901513297), n);
                                            break block14;
                                        }
                                        if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)633864274)))) break block32;
                                        this.你为什么要破解我的代码aaaadu((String)aaaabH.aaaajG((char)-2086862765), n);
                                        break block14;
                                    }
                                    if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-725548972)))) break block33;
                                    BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), null, null, (Function2)new aaaabA(n, null), (int)3, null);
                                    break block14;
                                }
                                if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)1073086549)))) break block34;
                                BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), null, null, (Function2)new aaaadb(n, null), (int)3, null);
                                break block14;
                            }
                            if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-1397096362)))) break block35;
                            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
                            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block14;
                            collection = (Iterable)minecraftServer;
                            bl2 = false;
                            object22 = collection.iterator();
                            while (object22.hasNext()) {
                                Object object4 = object3 = object22.next();
                                bl = false;
                                for (int i = 0; i < n; ++i) {
                                    int n4 = i;
                                    boolean bl5 = false;
                                    MinecraftServer minecraftServer4 = 我草你怎么反编译我模组aaaaad;
                                    if (minecraftServer4 == null) continue;
                                    minecraftServer4.execute(() -> aaaabH.你为什么要破解我的代码aaaaju((class_3222)object4, string2));
                                }
                            }
                            break block14;
                        }
                        if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)720437335)))) break block36;
                        MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
                        if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block14;
                        collection = (Iterable)minecraftServer;
                        bl2 = false;
                        object22 = collection.iterator();
                        while (object22.hasNext()) {
                            Object object5 = object3 = object22.next();
                            bl = false;
                            Intrinsics.checkNotNull((Object)object5);
                            我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiS((class_3222)object5, n);
                        }
                        break block14;
                    }
                    if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)1045299288)))) break block37;
                    MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
                    if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block14;
                    collection = (Iterable)minecraftServer;
                    bl2 = false;
                    object22 = collection.iterator();
                    while (object22.hasNext()) {
                        Object object6 = object3 = object22.next();
                        bl = false;
                        Intrinsics.checkNotNull((Object)object6);
                        我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiT((class_3222)object6, n);
                    }
                    break block14;
                }
                if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)-306970535)))) break block38;
                MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
                if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block14;
                collection = (Iterable)minecraftServer;
                bl2 = false;
                object22 = collection.iterator();
                while (object22.hasNext()) {
                    Object object7 = object3 = object22.next();
                    bl = false;
                    Intrinsics.checkNotNull((Object)object7);
                    我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiU((class_3222)object7, n);
                }
                break block14;
            }
            if (Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)1367998554)))) {
                for (int i = 0; i < n; ++i) {
                    n2 = i;
                    boolean bl = false;
                    MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
                    if (minecraftServer != null && (minecraftServer = minecraftServer.method_3760()) != null && (minecraftServer = (collection = minecraftServer.method_14571())) != null) {
                        Intrinsics.checkNotNull((Object)minecraftServer);
                        Iterable iterable = (Iterable)collection;
                        boolean bl6 = false;
                        for (Object object : iterable) {
                            class_3222 class_32222 = (class_3222)object;
                            boolean bl7 = false;
                            class_1799 class_17992 = new class_1799((class_1935)class_1802.field_8463);
                            class_32222.method_7270(class_17992);
                            class_1937 class_19372 = class_32222.method_37908();
                            Intrinsics.checkNotNull((Object)class_19372, (String)((String)aaaabH.aaaajG((char)168362031)));
                            class_3218 class_32182 = (class_3218)class_19372;
                            class_32182.method_14199((class_2394)class_2398.field_11201, class_32222.method_23317(), class_32222.method_23318() + 1.0, class_32222.method_23321(), 5, 0.5, 0.5, 0.5, 0.1);
                        }
                    }
                    Thread.sleep((long)500L);
                }
            }
        }
    }

    public final void 你为什么要破解我的代码aaaajq(@NotNull aaaabH aaaabH2, @NotNull String string, int n, int n2, @NotNull String string2) {
        Intrinsics.checkNotNullParameter((Object)aaaabH2, (String)((String)aaaabH.aaaajG((char)-1477574565)));
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)857931837)));
        Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaabH.aaaajG((char)1446772798)));
        LiveGiftEvent liveGiftEvent = new LiveGiftEvent(string2, (String)aaaabH.aaaajG((char)-1620901796), n, aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaabA(), (String)aaaabH.aaaajG((char)-1758592931));
        try {
            我草你怎么反编译我模组aaaaak += n2;
            aaaabH2.你为什么要破解我的代码aaaahd(string, n, string2, (String)aaaabH.aaaajG((char)711262300));
            aaaaab.你为什么要破解我的代码aaaaaa().info("天天跑酷按键事件执行成功: " + string + ", 次数: " + n);
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error("天天跑酷按键事件执行失败: " + string, (Throwable)exception);
        }
    }

    public static /* synthetic */ void 你为什么要破解我的代码aaaajr(aaaabH aaaabH2, aaaabH aaaabH3, String string, int n, int n2, String string2, int n3, Object object) {
        if ((n3 & 8) != 0) {
            string2 = (String)aaaabH.aaaajG((char)1751449693);
        }
        aaaabH2.你为什么要破解我的代码aaaajq(aaaabH3, string, n, n2, string2);
    }

    private final void 你为什么要破解我的代码aaaadu(String string, int n) {
        block2: {
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block2;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                for (int i = 0; i < n; ++i) {
                    int n2 = i;
                    boolean bl3 = false;
                    MinecraftServer minecraftServer2 = 我草你怎么反编译我模组aaaaad;
                    if (minecraftServer2 == null) continue;
                    minecraftServer2.execute(() -> aaaabH.你为什么要破解我的代码aaaajv(class_32222, string));
                }
            }
        }
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaaaO(@NotNull LiveGiftEvent liveGiftEvent) {
        Intrinsics.checkNotNullParameter((Object)liveGiftEvent, (String)((String)aaaabH.aaaajG((char)-1252982757)));
        int n = liveGiftEvent.getGiftCount();
        if (n > 0) {
            Object object;
            int n2;
            Object object2;
            Object object32;
            Object object4;
            aaaadh aaaadh2;
            Iterable iterable;
            block7: {
                iterable = (Iterable)aaaacB.你为什么要破解我的代码aaaaar();
                aaaadh2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa();
                object4 = iterable;
                for (Object object32 : object4) {
                    object2 = (aaaacB)((Object)object32);
                    n2 = 0;
                    if (!Intrinsics.areEqual((Object)((aaaacB)((Object)object2)).你为什么要破解我的代码aaaabA(), (Object)liveGiftEvent.getLiveType())) continue;
                    object = object32;
                    break block7;
                }
                object = null;
            }
            Intrinsics.checkNotNull(object);
            List<aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag> list = aaaadh2.你为什么要破解我的代码aaaaac((aaaacB)((Object)object));
            if (list.isEmpty()) {
                return;
            }
            object4 = (Iterable)list;
            boolean bl = false;
            object32 = object4;
            object2 = (Collection)new ArrayList();
            n2 = 0;
            Object object5 = object32.iterator();
            while (object5.hasNext()) {
                Object object6 = object5.next();
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag aaaaag2 = (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag)object6;
                boolean bl2 = false;
                if (!Intrinsics.areEqual((Object)aaaaag2.你为什么要破解我的代码aaaaaa(), (Object)liveGiftEvent.getGiftName())) continue;
                object2.add(object6);
            }
            iterable = (List)object2;
            if (iterable.isEmpty()) {
                return;
            }
            object4 = aaaaaj.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(liveGiftEvent.getUsername());
            for (Object object32 : iterable) {
                object5 = object32.你为什么要破解我的代码aaaaag();
                if ((object5 instanceof aaaacj ? (aaaacj)object5 : null) == null) continue;
                object2 = object2;
                n2 = ((aaaacj)object2).你为什么要破解我的代码aaaaab() * n;
                this.你为什么要破解我的代码aaaahd(((aaaacj)object2).你为什么要破解我的代码aaaaaa(), n2, (String)object4, liveGiftEvent.getGiftName());
                我草你怎么反编译我模组aaaaak += ((aaaacj)object2).你为什么要破解我的代码aaaaac() * n;
            }
            if (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaam()) {
                this.你为什么要破解我的代码aaaabx((String)object4, liveGiftEvent.getGiftName(), n);
            }
        }
    }

    public final void 你为什么要破解我的代码aaaahe(@NotNull String string, int n, int n2) {
        List<aaaaaD> list;
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)498925630)));
        switch (n2) {
            case 1: {
                List<aaaaaD> list2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaak();
                break;
            }
            case 2: {
                List<aaaaaD> list2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaaL();
                break;
            }
            case 3: {
                List<aaaaaD> list2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaaN();
                break;
            }
            case 4: {
                List<aaaaaD> list2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaaP();
                break;
            }
            case 5: {
                List<aaaaaD> list2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaaR();
                break;
            }
            default: {
                List<aaaaaD> list2 = list = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaak();
            }
        }
        if (list.isEmpty()) {
            return;
        }
        BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), null, null, (Function2)new aaaaav(n, list, string, null), (int)3, null);
    }

    public final void 你为什么要破解我的代码aaaajs(@NotNull aaaaaD aaaaaD2, @NotNull String string) {
        block2: {
            MinecraftServer minecraftServer;
            Intrinsics.checkNotNullParameter((Object)aaaaaD2, (String)((String)aaaabH.aaaajG((char)-851115938)));
            Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-49676226)));
            String string2 = aaaaaD2.你为什么要破解我的代码aaaaaa();
            int n = aaaaaD2.你为什么要破解我的代码aaaaah().你为什么要破解我的代码aaaaaa();
            int n2 = aaaaaD2.你为什么要破解我的代码aaaaah().你为什么要破解我的代码aaaaab();
            我草你怎么反编译我模组aaaaak += n2;
            MinecraftServer minecraftServer2 = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer2 != null) {
                minecraftServer2.execute(() -> aaaabH.你为什么要破解我的代码aaaajw(string2, n, string));
            }
            if ((minecraftServer = 我草你怎么反编译我模组aaaaad) == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block2;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)class_32222);
                Object[] objectArray = new Object[]{"§c" + aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaan(string2)};
                class_2561 class_25612 = (class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-1691680673)), (Object[])objectArray);
                objectArray = new Object[]{"§6" + string};
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, class_25612, (class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-1890189216)), (Object[])objectArray), 10, 70, 20);
                objectArray = new Object[]{"§a" + string, "§c" + string2};
                class_32222.method_7353((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)1872625761)), (Object[])objectArray), false);
            }
        }
    }

    /*
     * WARNING - bad return control flow
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Integer 你为什么要破解我的代码aaaadR(String string) {
        String[] stringArray = new String[]{(String)aaaabH.aaaajG((char)346357858), (String)aaaabH.aaaajG((char)-599130013), (String)aaaabH.aaaajG((char)-610729884)};
        List list = CollectionsKt.listOf((Object[])stringArray);
        for (String string2 : list) {
            Integer n;
            block24: {
                block23: {
                    block22: {
                        block21: {
                            String string3;
                            Regex regex = new Regex(string2);
                            MatchResult matchResult = Regex.find$default((Regex)regex, (CharSequence)string, (int)0, (int)2, null);
                            if (matchResult == null) continue;
                            MatchResult matchResult2 = matchResult;
                            String string4 = string3 = (String)matchResult2.getGroupValues().get(1);
                            switch (string4.hashCode()) {
                                case 19968: {
                                    if (string4.equals((Object)((String)aaaabH.aaaajG((char)-1731002267)))) break;
                                    return null;
                                }
                                case 49: {
                                    if (string4.equals((Object)((String)aaaabH.aaaajG((char)1144782950)))) break;
                                    return null;
                                }
                                case 50: {
                                    if (!string4.equals((Object)((String)aaaabH.aaaajG((char)-808124313)))) {
                                        return null;
                                    }
                                    break block21;
                                }
                                case 51: {
                                    if (!string4.equals((Object)((String)aaaabH.aaaajG((char)-1015873432)))) {
                                        return null;
                                    }
                                    break block22;
                                }
                                case 52: {
                                    if (!string4.equals((Object)((String)aaaabH.aaaajG((char)-1121189783)))) {
                                        return null;
                                    }
                                    break block23;
                                }
                                case 20116: {
                                    if (!string4.equals((Object)((String)aaaabH.aaaajG((char)-1134624662)))) {
                                        return null;
                                    }
                                    break block24;
                                }
                                case 53: {
                                    if (!string4.equals((Object)((String)aaaabH.aaaajG((char)679870571)))) {
                                        return null;
                                    }
                                    break block24;
                                }
                                case 19977: {
                                    if (!string4.equals((Object)((String)aaaabH.aaaajG((char)793968748)))) {
                                        return null;
                                    }
                                    break block22;
                                }
                                case 22235: {
                                    if (!string4.equals((Object)((String)aaaabH.aaaajG((char)-811794323)))) {
                                        return null;
                                    }
                                    break block23;
                                }
                                case 20108: {
                                    if (!string4.equals((Object)((String)aaaabH.aaaajG((char)-937557906)))) {
                                        return null;
                                    }
                                    break block21;
                                }
                            }
                            n = 1;
                            return n;
                        }
                        n = 2;
                        return n;
                    }
                    n = 3;
                    return n;
                }
                n = 4;
                return n;
            }
            n = 5;
            return n;
            return null;
        }
        if (!Intrinsics.areEqual((Object)string, (Object)((String)aaaabH.aaaajG((char)73072751)))) return null;
        Integer n = 1;
        return n;
    }

    public final void 你为什么要破解我的代码aaaabq(@NotNull String string, int n, @NotNull String string2, @NotNull String string3) {
        Object object;
        block2: {
            Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-790822800)));
            Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaabH.aaaajG((char)1630011454)));
            Intrinsics.checkNotNullParameter((Object)string3, (String)((String)aaaabH.aaaajG((char)1338507327)));
            aaaabh aaaabh2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak();
            Iterable iterable = (Iterable)aaaabh2.你为什么要破解我的代码aaaaay();
            for (Object object2 : iterable) {
                aaaabb aaaabb2 = (aaaabb)object2;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)aaaabb2.你为什么要破解我的代码aaaaaa(), (Object)string)) continue;
                object = object2;
                break block2;
            }
            object = null;
        }
        aaaabb aaaabb3 = (aaaabb)object;
        if (aaaabb3 == null) {
            return;
        }
        aaaabb aaaabb4 = aaaabb3;
        BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), null, null, (Function2)new aaaaae(n, aaaabb4, string2, string, null), (int)3, null);
    }

    public final void 你为什么要破解我的代码aaaajt(@NotNull aaaaaD aaaaaD2, @NotNull String string, @NotNull String string2) {
        block2: {
            MinecraftServer minecraftServer;
            Intrinsics.checkNotNullParameter((Object)aaaaaD2, (String)((String)aaaabH.aaaajG((char)1926889566)));
            Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-1155727298)));
            Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaabH.aaaajG((char)-1576664976)));
            String string3 = aaaaaD2.你为什么要破解我的代码aaaaaa();
            int n = aaaaaD2.你为什么要破解我的代码aaaaah().你为什么要破解我的代码aaaaaa();
            int n2 = aaaaaD2.你为什么要破解我的代码aaaaah().你为什么要破解我的代码aaaaab();
            我草你怎么反编译我模组aaaaak += n2;
            MinecraftServer minecraftServer2 = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer2 != null) {
                minecraftServer2.execute(() -> aaaabH.你为什么要破解我的代码aaaajx(string3, n, string, string2));
            }
            if ((minecraftServer = 我草你怎么反编译我模组aaaaad) == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block2;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)class_32222);
                Object[] objectArray = new Object[]{"§c" + aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaan(string3)};
                class_2561 class_25612 = (class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-850919329)), (Object[])objectArray);
                objectArray = new Object[]{"§6" + string};
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, class_25612, (class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-1065353120)), (Object[])objectArray), 10, 70, 20);
                objectArray = new Object[]{"§a" + string, "§c" + string2 + ": " + string3};
                class_32222.method_43496((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)2055995489)), (Object[])objectArray));
            }
        }
    }

    private final String 你为什么要破解我的代码aaaadS(int n) {
        return switch (n) {
            case 1 -> (String)aaaabH.aaaajG((char)1477443685);
            case 2 -> (String)aaaabH.aaaajG((char)1333985390);
            case 3 -> (String)aaaabH.aaaajG((char)-603586452);
            case 4 -> (String)aaaabH.aaaajG((char)-1446182803);
            case 5 -> (String)aaaabH.aaaajG((char)-882114454);
            default -> throw new IllegalArgumentException("不支持的数字: " + n);
        };
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaadM(@NotNull LiveEnterRoomEvent liveEnterRoomEvent) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)liveEnterRoomEvent, (String)((String)aaaabH.aaaajG((char)-1664614373)));
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block1;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                String string = aaaaaj.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(liveEnterRoomEvent.getUsername());
                Object[] objectArray = new Object[]{"§6" + string};
                class_32222.field_13987.method_14364((class_2596)new class_5894((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-1852768143)), (Object[])objectArray)));
            }
        }
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaabv(@NotNull LiveLikeEvent liveLikeEvent) {
        Intrinsics.checkNotNullParameter((Object)liveLikeEvent, (String)((String)aaaabH.aaaajG((char)1040646171)));
        aaaabh aaaabh2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak();
        int n = aaaabh2.你为什么要破解我的代码aaaaaa();
        我草你怎么反编译我模组aaaaan += liveLikeEvent.getLikeCount();
        while (我草你怎么反编译我模组aaaaan >= n) {
            aaaaaJ aaaaaJ2 = aaaabh2.你为什么要破解我的代码aaaabd();
            this.你为什么要破解我的代码aaaahd(aaaaaJ2.你为什么要破解我的代码aaaaaa(), aaaaaJ2.你为什么要破解我的代码aaaaab(), (String)aaaabH.aaaajG((char)-1281425294), (String)aaaabH.aaaajG((char)1266876531));
            我草你怎么反编译我模组aaaaak += aaaaaJ2.你为什么要破解我的代码aaaaac();
            我草你怎么反编译我模组aaaaan -= n;
        }
        this.你为什么要破解我的代码aaaaeM();
        this.你为什么要破解我的代码aaaaas();
    }

    public final void 你为什么要破解我的代码aaaaeM() {
        class_3002 class_30022;
        String string;
        aaaabh aaaabh2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak();
        int n = aaaabh2.你为什么要破解我的代码aaaaaa();
        String string2 = aaaabh2.你为什么要破解我的代码aaaabd().你为什么要破解我的代码aaaaaa();
        String string3 = (String)aaaabh2.你为什么要破解我的代码aaaaao().get((Object)string2);
        if (string3 == null) {
            string3 = string = string2;
        }
        if ((class_30022 = 我草你怎么反编译我模组aaaaaj) == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-434110443)));
            class_30022 = null;
        }
        class_30022.method_12956(n);
        class_3002 class_30023 = 我草你怎么反编译我模组aaaaaj;
        if (class_30023 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-1616642027)));
            class_30023 = null;
        }
        class_30023.method_12954(我草你怎么反编译我模组aaaaan);
        float f = (float)我草你怎么反编译我模组aaaaan / (float)n;
        class_3002 class_30024 = 我草你怎么反编译我模组aaaaaj;
        if (class_30024 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-32636907)));
            class_30024 = null;
        }
        class_30024.method_5416(f < 0.33f ? class_1259.class_1260.field_5784 : (f < 0.66f ? class_1259.class_1260.field_5782 : class_1259.class_1260.field_5785));
        class_3002 class_30025 = 我草你怎么反编译我模组aaaaaj;
        if (class_30025 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaabH.aaaajG((char)-1623195627)));
            class_30025 = null;
        }
        Object[] objectArray = new Object[]{"§6§l" + string, 我草你怎么反编译我模组aaaaan, n};
        class_30025.method_5413((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-590479330)), (Object[])objectArray));
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaabw(@NotNull LiveChatEvent liveChatEvent) {
        Intrinsics.checkNotNullParameter((Object)liveChatEvent, (String)((String)aaaabH.aaaajG((char)-1469579237)));
        aaaaab.你为什么要破解我的代码aaaaaa().info("处理直播弹幕事件: " + liveChatEvent.getUsername() + " - " + liveChatEvent.getMessage());
        String string = liveChatEvent.getMessage().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaabH.aaaajG((char)-1420885900)));
        String string2 = string;
        String string3 = liveChatEvent.getUsername();
        List<aaaaca> list = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaak().你为什么要破解我的代码aaaaae();
        String string4 = aaaaaj.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(liveChatEvent.getUsername());
        for (aaaaca aaaaca2 : list) {
            String string5 = aaaaca2.你为什么要破解我的代码aaaaaa().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)string5, (String)((String)aaaabH.aaaajG((char)435880052)));
            if (!Intrinsics.areEqual((Object)string2, (Object)string5)) continue;
            aaaaab.你为什么要破解我的代码aaaaaa().info("触发弹幕事件 - 用户: " + string3 + ", 内容: " + string2 + ", 事件类型: " + aaaaca2.你为什么要破解我的代码aaaaab() + ", 次数: " + aaaaca2.你为什么要破解我的代码aaaaac());
            if (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaam()) {
                this.你为什么要破解我的代码aaaabx(string4, aaaaca2.你为什么要破解我的代码aaaaab(), aaaaca2.你为什么要破解我的代码aaaaac());
            }
            this.你为什么要破解我的代码aaaajq(this, aaaaca2.你为什么要破解我的代码aaaaab(), aaaaca2.你为什么要破解我的代码aaaaac(), aaaaca2.你为什么要破解我的代码aaaaad(), string4);
        }
    }

    private final void 你为什么要破解我的代码aaaabV(String string) {
        block1: {
            class_5250 class_52502 = class_2561.method_43471((String)string);
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block1;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                class_32222.method_43496((class_2561)class_52502);
            }
        }
    }

    public final void 你为什么要破解我的代码aaaabx(@NotNull String string, @NotNull String string2, int n) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-1984692162)));
            Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaabH.aaaajG((char)250019903)));
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block2;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                Object[] objectArray;
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                if (n > 1) {
                    objectArray = new Object[]{class_2561.method_43470((String)("§a" + string)), class_2561.method_43470((String)("§e" + string2 + "x" + n))};
                    class_32222.method_7353((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)-1883438987)), (Object[])objectArray), false);
                    continue;
                }
                objectArray = new Object[]{class_2561.method_43470((String)("§a" + string)), class_2561.method_43470((String)("§e" + string2))};
                class_32222.method_7353((class_2561)class_2561.method_43469((String)((String)aaaabH.aaaajG((char)142016629)), (Object[])objectArray), false);
            }
        }
    }

    public final void 你为什么要破解我的代码aaaaaX(@NotNull class_3222 class_32222, @NotNull String string, int n, @NotNull String string2, @NotNull String string3) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)aaaabH.aaaajG((char)-935591913)));
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-1282736065)));
        Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaabH.aaaajG((char)1169686590)));
        Intrinsics.checkNotNullParameter((Object)string3, (String)((String)aaaabH.aaaajG((char)-657653699)));
        BuildersKt.launch$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), null, null, (Function2)new aaaaaR(string3, string2, n, class_32222, null), (int)3, null);
    }

    private static final void 你为什么要破解我的代码aaaaju(class_3222 class_32222, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-1526464394)));
        Intrinsics.checkNotNull((Object)class_32222);
        我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaajb(class_32222, string);
    }

    private static final void 你为什么要破解我的代码aaaajv(class_3222 class_32222, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-1974534025)));
        class_32222.field_13995.method_3734().method_44252(class_32222.method_5671(), "/playanimation " + class_32222.method_5477().getString() + " " + string);
    }

    private static final void 你为什么要破解我的代码aaaajw(String string, int n, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-707657608)));
        Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaabH.aaaajG((char)868221046)));
        我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaahd(string, n, string2, (String)aaaabH.aaaajG((char)-653393809));
    }

    private static final void 你为什么要破解我的代码aaaajx(String string, int n, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaabH.aaaajG((char)-971046792)));
        Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaabH.aaaajG((char)-2091057034)));
        Intrinsics.checkNotNullParameter((Object)string3, (String)((String)aaaabH.aaaajG((char)1582170233)));
        我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaahd(string, n, string2, string3);
    }

    public static final /* synthetic */ Map 你为什么要破解我的代码aaaajy() {
        return 我草你怎么反编译我模组aaaadk;
    }

    public static final /* synthetic */ boolean 你为什么要破解我的代码aaaajz(aaaabH aaaabH2, class_3222 class_32222) {
        return aaaabH2.你为什么要破解我的代码aaaajd(class_32222);
    }

    public static final /* synthetic */ MinecraftServer 你为什么要破解我的代码aaaacl() {
        return 我草你怎么反编译我模组aaaaad;
    }

    public static final /* synthetic */ Map 你为什么要破解我的代码aaaajA() {
        return 我草你怎么反编译我模组aaaadi;
    }

    public static final /* synthetic */ Map 你为什么要破解我的代码aaaajB() {
        return 我草你怎么反编译我模组aaaadj;
    }

    public static final /* synthetic */ boolean 你为什么要破解我的代码aaaajC(aaaabH aaaabH2, class_3222 class_32222) {
        return aaaabH2.你为什么要破解我的代码aaaajn(class_32222);
    }

    public static final /* synthetic */ Map 你为什么要破解我的代码aaaajD() {
        return 我草你怎么反编译我模组aaaadu;
    }

    public static final /* synthetic */ List 你为什么要破解我的代码aaaajE() {
        return 我草你怎么反编译我模组aaaadz;
    }

    public static final /* synthetic */ void 你为什么要破解我的代码aaaajF(aaaabH aaaabH2, class_3222 class_32222) {
        aaaabH2.你为什么要破解我的代码aaaaja(class_32222);
    }

    static {
        byte[] byArray = "tÞL#0H}E{çB×·®+b<r¤ÊÑZbt$cºYµ>\b®d¤(Õ¥£z6I,7S\r%IÅ$)ã=¬-B\\:Ë¤$jP.NB\føüùë·Á½G@Qd¦:*3óDE((\bÅ;®-=¢h~ºE=×Ö>Ïà¼O\néÆyFÒ$ÂH3]ÅÓkmÚÙ\"¡Óè¯¸a»¤®tç5á[½ß>(è¾î¦Æ`\bi\"©üµN¨@^þpy©$¶y÷Ò3Æ¿êQ´óh$QAïÁ4·»ÓPú\b>¾7u7ÕÍ1³Pp@¦,CÎ\nÍöTô»^L@]­ÛÏ[\"B^¡£'?¬b¤Uÿwr¢újþ\baÐ?³\fµ¯ÐC\"Òø!Ú&¬wT¸üò5¢B=ÿ³\\j­S©ä«§(A¡V2|<c;D£¶<RRKÉÿ¦H\fLÍâ`F& dPí&<\rÉ#é¹ùÔÆ|©ùpNz.¶úÏÃ#qPdQ·ODqdóTZîÀ¡3I±Ü`ð2¬,d¬?ty b ù$QeûÊW­öö¯r\fF¤Ç¿c¦Ä- x@¸MÃ;þ§7|jº$· : B,ÎÕ1§°/6½L@öØ=ÄÍLHðX¢ûPWnh¤ÆVøÖU~ù«±\b_ÌD|×L4åC{ \bÑ\b@õÃ¦úuÛ.dmÃëèESÊy;K½yÝ¸Ód¡X]ë)Gå IhYVÁwR2r»¼(.\r¾#É?¬¹ðÓ;¶ú¦÷Ê&ªgäî.mdö\rË¸å0LÆ ,GMMApúØM*2»,n\rS+#JújÉ{Î\noçÝ¸¢3Ø~Ñ@u3Ró¼»YåOQnì¤áÒAÇþ³úÊ§Ñ2zóvü¶.ýìRdÎ¹ÛäÉòdª·z»ÞÎ{ô YJ¡{ùqZ[ÈÜ¥'­\tg-aâíz/ ÆI©°æ*pt2²@vø9Y¯8T[¤Z¨Ûg1³ßKM_5·½Cî7[\nÄN;û®9>Àøõ6\bÎ¢&ÔUÞ¯¾Ù+þl²Ë¬`\n#ä\tÌË»ôo?º×k9Õ} $\rsÝ*VXyi1 ÌÅáñKzLäÖ8p=LÖÁm9E?÷idâzPZ´$b±Ó¸ý/A Hóu@f§ôÏðo:Û^ðu[«~²8JãÀÏ3Éæhm­ºÝÀ¡±ODHqShXV÷rh7ä\\é:G(m[Þ¼÷IN§±(p%y;¡T9/\b8\"UÆiY¡ú1'ûÊ ¢Ç\r\bDÅ§ñ(Ã¨UÒlÍÐ5 È¡ s/2ÅÁOÛVIN`2qÑl,AÜÒ]{ÖÊÿo(¦èÅèa-øÔ¿MTôÛmýÕ¹&wËZ1÷Nv\tÊ`PýU~³ô2Yõð«,sjT{ åÙºêRx/äS»Ý:ÑÀïícøêWvä-*S_Å\nJiæQêdI¸O>bT¿¿¸jéþ)âm§+l¦U¼ÚaÛó÷^ÓËû @Íµé\\sÉFûZ&À®6ð·ó<b@îh\fþ±cIuæBÌkþA(WÇ\t+eüOïHíXUÚ\t\"YDMEê8wµoDãXì%Ãh~ÂbÀìNÚ.ÞZX~÷F»Ð^Îgí£¿íDJE±ÜG:ÛÏÞ&^leÁy\\ú²Ã ù!¿Ûû¶Gìëó>®%Ç\nA £UK!ZÒ÷òù>ã\n3½|®ª§)Â®y7ptìqµçpïOFQûj<Û­Yªæ3ù[U´B÷¶Ñü¨¬3\bcù³G\f¦$¼fj©vIÁÁÜ¤JgÊ4Ü[é){j*ã.ÔfÞWO@ÔRöpyAÆ¡Ôúwß)$ðÄuÁ4®æÇþ¬%ï\f¡>vPAæ,æáp^vù<ÿãÈèë×a¿¶Ü¤|¥ô8¸g/¹a´ù§^^É3Wüæ. QúÍ©\rDÙ&Þ×(£¦bèw<+TìY¥{5Æh­/y¹Í¹«ÊÖ<R®\\M:BBð$½¿\rjU0É(ÌULX@Ö*sFBfÅ ÿ]\næOð-\"ÜÏzWÀ\t6RôÎ%ÖõïyÊùÌQîWw«Æ¨9$ÝÞ÷ß¢@.èÁMÕcðÜò±Ä:ÀÓÙ\n0àM¨ÀË\\Cbú£êyÅv¨]Ëð¯5@bùñ9qþ»ÊÈj0½ü+ñC\n ;1î3\t­ÝÏæ3rKÇ~^N}~!~É³p,Ý?z?MZ¾ðåèç½V?¬&aüQå<TNyNs%FX3\fDzÕd©ßÕóN¾½å)Ýs¹Ù{à£éôCr ò©\fF²sÙå'úÉúu¸A]WSqA(ünVW-Í>ð5ì[á»:p)7\r«üO'Ð'º©ìëÑÏ»dC¤XNò/@ÎN|ï½Áâ\".CVFa4ÑêwTA'mAÕ9szæ°n­ð@ôp,lböi©# 5pËÇ@vÊ)ÉçS¸å·ä~Ê(L¾ï\\\\ ô°°\n yëÎ?(¯0ÄºÎ åcó«½vIí(ø§0¨`¢Èµ%ËÝE6ÌtºlkSî5)Ó2Ê<Þ¢T¥\tÍ}Ê.£÷`5´*²µÌJú§Á1JÞ~lâ¹~'®©+=]e?rÈ0+:SW¢ÚÛp¹²þ¿Pcf`j%\fN¹LAL\rÖ·öÐ+ñÔù'A5òÓ{àqSÖG(LàÐ%ô]³Fy{²\\÷6ÿQ|ÈxI¡.Z½1²ÂàxbWð{ºdgÖUApóÝ­M4nû`µ!L!v;ÏTã|_ñ)U°vÛÇÉèÇÚÌ¾*cÝä>¬ä ú;<ÝKsXöáüØ>¡z±M³PZÊ%.'¾Íc~LÉ¤ôÇQ ½ôÝéyÛ\bÆMãBxCÒU)¥ÜÎªVÙ#Rø­gòþ¤Iw´<L,â.eò@;MkÊÖÃÉêX.vå ¨Ë7Þ@èöMi¡6»ð#'÷ôÆÖº:\"î´n`o«³G`Ù7n#óGþóg:ëDRIfÝ¦[H+ßF\tN!Ü=Õ¿°¨9:m7fWVlP­ÌµA;KE¿¿&Ùþõ;ëÔn±«oª9)sfôÏÎ@Í¼¯)©9;AEG8ßn[]¹@~M{1´pXÁº>écÈ¶ºÄÓ -w¥¦jHÿózïÚr¬ièÒëðb­ Ê¼>}énArVé´qÑ3lo¹'àX^òÏ³ÊË5G! yÁ¸dä4²iK8I¬ qMb\të".getBytes("ISO_8859_1");
        Object[] objectArray = "×|·Þé'".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1488302009;
                case 1 -> 2053449069;
                case 2 -> 1904110652;
                case 3 -> -1464310554;
                case 4 -> 803379256;
                case 5 -> -565086369;
                case 6 -> -24343338;
                case 7 -> -1898836784;
                case 8 -> -170085417;
                case 9 -> 2057776594;
                case 10 -> 1196307781;
                case 11 -> 169417599;
                case 12 -> -1511396434;
                case 13 -> 1263004044;
                case 14 -> 1521700652;
                case 15 -> 1430243283;
                case 16 -> 806103290;
                case 17 -> -856042382;
                case 18 -> 1139963654;
                case 19 -> 843774948;
                case 20 -> -814302878;
                case 21 -> 901708485;
                case 22 -> -194264000;
                case 23 -> -1077190444;
                case 24 -> -1381244862;
                case 25 -> -1091627481;
                case 26 -> -2018610810;
                case 27 -> -1499676221;
                case 28 -> -218227552;
                case 29 -> -1236237153;
                case 30 -> 587182407;
                case 31 -> -697906186;
                case 32 -> 1120346282;
                case 33 -> 1642498912;
                case 34 -> 1927363459;
                case 35 -> 995449967;
                case 36 -> 442534893;
                case 37 -> 2130197117;
                case 38 -> -1812315084;
                case 39 -> 1278069636;
                case 40 -> -1408706023;
                case 41 -> -650872773;
                case 42 -> 1638790087;
                case 43 -> 407496042;
                case 44 -> 1285627635;
                case 45 -> -2012405513;
                case 46 -> 1339462342;
                case 47 -> -1604807370;
                case 48 -> -86608206;
                case 49 -> 1202465998;
                case 50 -> 1053620996;
                case 51 -> -28352288;
                case 52 -> -1575724032;
                case 53 -> -310160444;
                case 54 -> 89658295;
                case 55 -> -537446515;
                case 56 -> -1580520292;
                case 57 -> -2019054659;
                case 58 -> -1550302706;
                case 59 -> 2134002395;
                case 60 -> -1805083282;
                case 61 -> 2133859299;
                case 62 -> 1623146084;
                case 63 -> -356527797;
                case 64 -> -149558633;
                case 65 -> 1642509841;
                case 66 -> 732210210;
                case 67 -> -1524759692;
                case 68 -> -165020839;
                case 69 -> 1678399464;
                case 70 -> -397662374;
                case 71 -> 1551476018;
                case 72 -> 1887161595;
                case 73 -> 1759448653;
                case 74 -> 1517966490;
                case 75 -> 2040396511;
                case 76 -> 262393986;
                case 77 -> 1973497657;
                case 78 -> -742311963;
                case 79 -> 600763160;
                case 80 -> -754899083;
                case 81 -> -145220464;
                case 82 -> -230794617;
                case 83 -> -140331612;
                case 84 -> 2034355006;
                case 85 -> -1505551063;
                case 86 -> -1730678736;
                case 87 -> 1586462824;
                case 88 -> 242950423;
                case 89 -> 309057925;
                case 90 -> -497082423;
                case 91 -> 926195336;
                case 92 -> 1842514626;
                case 93 -> -644922481;
                case 94 -> 1926873481;
                case 95 -> 1252941411;
                case 96 -> -2087987034;
                case 97 -> 407310621;
                case 98 -> 93718896;
                case 99 -> 213821963;
                case 100 -> 2035142915;
                case 101 -> 342561231;
                case 102 -> -3216440;
                case 103 -> -92018648;
                case 104 -> 13311193;
                case 105 -> 910356188;
                case 106 -> -1093653979;
                case 107 -> -384120388;
                case 108 -> -1694480843;
                case 109 -> -829015012;
                case 110 -> 703952372;
                case 111 -> 35586859;
                case 112 -> -635586576;
                case 113 -> -1708008895;
                case 114 -> 617609176;
                case 115 -> -2100680688;
                case 116 -> 742310927;
                case 117 -> 2102855083;
                case 118 -> -126734025;
                case 119 -> -2102459295;
                case 120 -> 461194112;
                case 121 -> 871999924;
                case 122 -> -728097714;
                case 123 -> -1274853379;
                case 124 -> 520305271;
                case 125 -> 603508126;
                case 126 -> -1905405650;
                case 127 -> -800037735;
                case 128 -> -21849666;
                case 129 -> -1512759978;
                case 130 -> -1291890450;
                case 131 -> 75487411;
                case 132 -> 1913986538;
                case 133 -> -736690425;
                case 134 -> -1810887970;
                case 135 -> 1841713921;
                case 136 -> 2042938132;
                case 137 -> -1294553587;
                case 138 -> -573223956;
                case 139 -> -1993051319;
                case 140 -> 178218924;
                case 141 -> -1930541942;
                case 142 -> -2129999821;
                case 143 -> 1089145380;
                case 144 -> -232880518;
                case 145 -> 344371292;
                case 146 -> -844055766;
                case 147 -> 526129319;
                case 148 -> 2102798539;
                case 149 -> -701625570;
                case 150 -> -995658331;
                case 151 -> -1310655450;
                case 152 -> -559121150;
                case 153 -> 565623626;
                case 154 -> 825381341;
                case 155 -> -1954446735;
                case 156 -> -1282561980;
                case 157 -> -939237816;
                case 158 -> -1819783425;
                case 159 -> -565260899;
                case 160 -> 1769324607;
                case 161 -> 434400725;
                case 162 -> 1530454902;
                case 163 -> -1334818784;
                case 164 -> -1025174597;
                case 165 -> -279049661;
                case 166 -> 932168360;
                case 167 -> 691018783;
                case 168 -> -277799999;
                case 169 -> 969242390;
                case 170 -> 898274486;
                case 171 -> -449326408;
                case 172 -> -1067007974;
                case 173 -> -1567287919;
                case 174 -> 446688844;
                case 175 -> 923083297;
                case 176 -> -1818699394;
                case 177 -> -153682836;
                case 178 -> -1983442797;
                case 179 -> 1823087440;
                case 180 -> -767558392;
                case 181 -> -402160735;
                case 182 -> 1763974027;
                case 183 -> -714401685;
                case 184 -> -125887569;
                case 185 -> -519421294;
                case 186 -> 448060498;
                case 187 -> 872431585;
                case 188 -> 1165127809;
                case 189 -> 89157787;
                case 190 -> 362174441;
                case 191 -> 1684501112;
                case 192 -> -1713061366;
                case 193 -> -1293374728;
                case 194 -> 2017177379;
                case 195 -> 1234102192;
                case 196 -> -148829864;
                case 197 -> 723350218;
                case 198 -> 980621143;
                case 199 -> 384822037;
                case 200 -> 773121273;
                case 201 -> 164169102;
                case 202 -> -1331830342;
                case 203 -> -273387328;
                case 204 -> -212172753;
                case 205 -> 1994019733;
                case 206 -> 1414327389;
                case 207 -> -948346540;
                case 208 -> -318318101;
                case 209 -> 418394275;
                case 210 -> 29550421;
                case 211 -> -882182330;
                case 212 -> -981243078;
                case 213 -> -1330833502;
                case 214 -> -1846392663;
                case 215 -> 748124849;
                case 216 -> -1719086852;
                case 217 -> 1807156118;
                case 218 -> 1973738764;
                case 219 -> 1898456493;
                case 220 -> -1732127394;
                case 221 -> -1048817615;
                case 222 -> -2066263205;
                case 223 -> -252238725;
                case 224 -> -1359676710;
                case 225 -> 1947176569;
                case 226 -> -449632620;
                case 227 -> 2113198078;
                case 228 -> -250840424;
                case 229 -> -637941742;
                case 230 -> -801780289;
                case 231 -> -1858216462;
                case 232 -> 607338956;
                case 233 -> 872655165;
                case 234 -> 893130541;
                case 235 -> 2112261244;
                case 236 -> 2009037903;
                case 237 -> -1460964077;
                case 238 -> 294979411;
                case 239 -> -375926814;
                case 240 -> -888565299;
                case 241 -> -905522443;
                case 242 -> -1053838233;
                case 243 -> 476359017;
                case 244 -> 282640053;
                case 245 -> -869482001;
                case 246 -> 564912997;
                case 247 -> 201242855;
                case 248 -> 1895608529;
                case 249 -> 154491657;
                case 250 -> -808617701;
                case 251 -> 2112064517;
                case 252 -> 809352806;
                case 253 -> -584966319;
                case 254 -> -120657167;
                case 255 -> 1334027891;
                default -> -1924945919;
            });
        } while (n != n2);
        Cipher cipher = Cipher.getInstance((String)"DES/CBC/PKCS5Padding");
        cipher.init(2, (Key)SecretKeyFactory.getInstance((String)"DES").generateSecret((KeySpec)new DESKeySpec(objectArray)), (AlgorithmParameterSpec)new IvParameterSpec(new byte[8]));
        byArray = cipher.doFinal(byArray);
        n2 = byArray.length;
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-256");
        messageDigest.reset();
        n = n2 - 32;
        messageDigest.update(byArray, 0, n);
        objectArray = messageDigest.digest();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        do {
            n4 |= byArray[n + n3] ^ objectArray[n3];
        } while (++n3 != 32);
        if (n4 == 0) {
            Object[] objectArray2 = new Object[122];
            objectArray = objectArray2;
            aaaadA = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaadv = 5000L;
        我草你怎么反编译我模组aaaadt = 1;
        我草你怎么反编译我模组aaaads = 1;
        我草你怎么反编译我模组aaaadr = 5.0;
        我草你怎么反编译我模组aaaadh = new aaaabH();
        我草你怎么反编译我模组aaaadi = (Map)new LinkedHashMap();
        我草你怎么反编译我模组aaaadj = (Map)new LinkedHashMap();
        我草你怎么反编译我模组aaaadk = (Map)new LinkedHashMap();
        我草你怎么反编译我模组aaaadl = new aaaabo();
        Object[] objectArray3 = new String[]{(String)aaaabH.aaaajG((char)1269235796), (String)aaaabH.aaaajG((char)-565051307), (String)aaaabH.aaaajG((char)-389545898), (String)aaaabH.aaaajG((char)515440730), (String)aaaabH.aaaajG((char)-90898345), (String)aaaabH.aaaajG((char)-1153564584), (String)aaaabH.aaaajG((char)-1436417959)};
        我草你怎么反编译我模组aaaadm = SetsKt.setOf((Object[])objectArray3);
        我草你怎么反编译我模组aaaacl = new class_243(-1707.0, 73.0, -207.0);
        我草你怎么反编译我模组aaaadp = 10;
        我草你怎么反编译我模组aaaadq = new class_243(-750.0, 170.0, -893.0);
        我草你怎么反编译我模组aaaadu = (Map)new LinkedHashMap();
        我草你怎么反编译我模组aaaaal = 5;
        objectArray3 = new class_243[]{new class_243(-1707.0, 73.0, -207.0), new class_243(-1614.0, 86.0, -206.0), new class_243(-1617.0, 87.0, -116.0), new class_243(-1656.0, 107.0, -15.0), new class_243(-1689.0, 106.0, -1.0), new class_243(-1658.0, 113.0, 23.0), new class_243(-1444.0, 67.0, -238.0), new class_243(-1397.0, 67.0, 43.0), new class_243(-1406.0, 230.0, 153.0), new class_243(-1461.0, 136.0, 176.0), new class_243(-1551.0, 79.0, 183.0), new class_243(-1538.0, 75.0, 315.0), new class_243(-1625.0, 67.0, -500.0), new class_243(-1573.0, 89.0, -555.0), new class_243(-1559.0, 101.0, -589.0), new class_243(-1540.0, 121.0, -622.0), new class_243(-1322.0, 107.0, -651.0), new class_243(-1198.0, 101.0, -650.0), new class_243(-1052.0, 67.0, -202.0), new class_243(-953.0, 84.0, -191.0), new class_243(-905.0, 83.0, -176.0), new class_243(-878.0, 89.0, -156.0), new class_243(-914.0, 91.0, -96.0), new class_243(-1105.0, 134.0, 143.0), new class_243(-1170.0, 143.0, 166.0), new class_243(-1145.0, 161.0, 211.0), new class_243(-1083.0, 171.0, 256.0), new class_243(-1111.0, 168.0, 277.0), new class_243(-1038.0, 196.0, 270.0), new class_243(-658.0, 138.0, -832.0), new class_243(-521.0, 149.0, -904.0), new class_243(-468.0, 164.0, -1048.0), new class_243(-655.0, 177.0, -1091.0), new class_243(-750.0, 170.0, -893.0)};
        我草你怎么反编译我模组aaaadz = CollectionsKt.listOf((Object[])objectArray3);
    }

    private static Object aaaajG(char c) {
        return ((Object[])aaaadA)[c];
    }
}

