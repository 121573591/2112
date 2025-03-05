/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.eventbus.Subscribe
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Random
 *  java.util.Set
 *  java.util.UUID
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  net.minecraft.class_1259$class_1260
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1299
 *  net.minecraft.class_1304
 *  net.minecraft.class_1308
 *  net.minecraft.class_1541
 *  net.minecraft.class_1642
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1928
 *  net.minecraft.class_1928$class_4310
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2960
 *  net.minecraft.class_3002
 *  net.minecraft.class_3004
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3730
 *  net.minecraft.class_5250
 *  net.minecraft.class_5894
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaZ;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaby;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacf;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacr;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacu;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaadh;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaw;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabI;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabU;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacP;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacm;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacv;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaaj;
import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.game.BlockPlaceEvent;
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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.minecraft.class_1259;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1308;
import net.minecraft.class_1541;
import net.minecraft.class_1642;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1928;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2960;
import net.minecraft.class_3002;
import net.minecraft.class_3004;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3730;
import net.minecraft.class_5250;
import net.minecraft.class_5894;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nMonsterArenaStage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MonsterArenaStage.kt\ncn/pixellive/mc/game/stage/MonsterArenaStage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,937:1\n1855#2,2:938\n1855#2,2:940\n766#2:942\n857#2,2:943\n1855#2:945\n1856#2:953\n1855#2,2:954\n766#2:957\n857#2,2:958\n1603#2,9:960\n1855#2:969\n1856#2:971\n1612#2:972\n1855#2,2:973\n1855#2,2:975\n1855#2,2:977\n1855#2,2:979\n518#2,7:981\n800#2,11:988\n1855#2,2:999\n766#2:1001\n857#2,2:1002\n1855#2,2:1004\n1855#2,2:1006\n372#3,7:946\n1#4:956\n1#4:970\n*S KotlinDebug\n*F\n+ 1 MonsterArenaStage.kt\ncn/pixellive/mc/game/stage/MonsterArenaStage\n*L\n204#1:938,2\n272#1:940,2\n336#1:942\n336#1:943,2\n337#1:945\n337#1:953\n360#1:954,2\n387#1:957\n387#1:958,2\n388#1:960,9\n388#1:969\n388#1:971\n388#1:972\n403#1:973,2\n452#1:975,2\n510#1:977,2\n529#1:979,2\n766#1:981,7\n905#1:988,11\n906#1:999,2\n912#1:1001\n912#1:1002,2\n913#1:1004,2\n922#1:1006,2\n338#1:946,7\n388#1:970\n*E\n"})
public final class aaaadf
extends aaaaas {
    @NotNull
    public static final aaaadf 我草你怎么反编译我模组aaaaeK;
    @Nullable
    private static MinecraftServer 我草你怎么反编译我模组aaaaad;
    @NotNull
    private static final class_243 我草你怎么反编译我模组aaaaag;
    private static int 我草你怎么反编译我模组aaaaan;
    private static class_3002 我草你怎么反编译我模组aaaaaj;
    @NotNull
    private static List<String> 我草你怎么反编译我模组aaaaap;
    @NotNull
    private static final ArrayDeque<aaaabI> 我草你怎么反编译我模组aaaacP;
    private static int 我草你怎么反编译我模组aaaacQ;
    private static final int 我草你怎么反编译我模组aaaacR;
    @NotNull
    private static List<String> 我草你怎么反编译我模组aaaaas;
    @NotNull
    private static final List<aaaacm> 我草你怎么反编译我模组aaaabn;
    private static long 我草你怎么反编译我模组aaaaar;
    private static long 我草你怎么反编译我模组aaaaaq;
    private static long 我草你怎么反编译我模组aaaacW;
    private static final long 我草你怎么反编译我模组aaaacX;
    private static final long 我草你怎么反编译我模组aaaacY;
    @NotNull
    private static final Map<UUID, Long> 我草你怎么反编译我模组aaaacZ;
    @NotNull
    private static final Set<UUID> 我草你怎么反编译我模组aaaada;
    static Object aaaaeL;

    private aaaadf() {
    }

    @Override
    @NotNull
    public String 你为什么要破解我的代码aaaaaj() {
        return (String)aaaadf.aaaapl((char)1233321984);
    }

    @Override
    @NotNull
    public String 你为什么要破解我的代码aaaaak() {
        return (String)aaaadf.aaaapl((char)1002438657);
    }

    @Override
    public void 你为什么要破解我的代码aaaaal(@NotNull MinecraftServer minecraftServer) {
        class_3002 class_30022;
        Intrinsics.checkNotNullParameter((Object)minecraftServer, (String)((String)aaaadf.aaaapl((char)-48955390)));
        我草你怎么反编译我模组aaaaad = minecraftServer;
        class_3218 class_32182 = minecraftServer.method_30002();
        Intrinsics.checkNotNullExpressionValue((Object)class_32182, (String)((String)aaaadf.aaaapl((char)1503592451)));
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaak(class_32182);
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().register((Object)this);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(this.你为什么要破解我的代码aaaaaj());
        aaaaac.你为什么要破解我的代码aaaaaa(minecraftServer, (Set<class_2248>)((Set)new HashSet()));
        aaaaab.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
        ((class_1928.class_4310)minecraftServer.method_30002().method_8450().method_20746(class_1928.field_19392)).method_20758(false, minecraftServer);
        ((class_1928.class_4310)minecraftServer.method_30002().method_8450().method_20746(class_1928.field_19391)).method_20758(false, minecraftServer);
        ((class_1928.class_4310)minecraftServer.method_30002().method_8450().method_20746(class_1928.field_19393)).method_20758(false, minecraftServer);
        aaaacu aaaacu2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaah();
        我草你怎么反编译我模组aaaaaq = aaaacu2.你为什么要破解我的代码aaaaai();
        我草你怎么反编译我模组aaaaap = aaaacu2.你为什么要破解我的代码aaaaag();
        我草你怎么反编译我模组aaaaas = aaaacu2.你为什么要破解我的代码aaaaam();
        class_3002 class_30023 = class_30022 = minecraftServer.method_3837().method_12970(class_2960.method_60655((String)((String)aaaadf.aaaapl((char)-324337660)), (String)((String)aaaadf.aaaapl((char)1046609925))), (class_2561)class_2561.method_43471((String)((String)aaaadf.aaaapl((char)1688666118))));
        boolean bl = false;
        class_30023.method_12956(aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaah().你为什么要破解我的代码aaaaaa());
        class_30023.method_12954(我草你怎么反编译我模组aaaaan);
        class_3002 class_30024 = class_30022;
        Intrinsics.checkNotNullExpressionValue((Object)class_30024, (String)((String)aaaadf.aaaapl((char)1802043399)));
        我草你怎么反编译我模组aaaaaj = class_30024;
        List list = minecraftServer.method_3760().method_14571();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)((String)aaaadf.aaaapl((char)259915784)));
        Iterable iterable = (Iterable)list;
        boolean bl2 = false;
        for (Object object : iterable) {
            class_3222 class_32222 = (class_3222)object;
            boolean bl3 = false;
            class_3002 class_30025 = 我草你怎么反编译我模组aaaaaj;
            if (class_30025 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaadf.aaaapl((char)-1704263671)));
                class_30025 = null;
            }
            class_30025.method_14088(class_32222);
        }
        this.你为什么要破解我的代码aaaaas();
    }

    @Override
    public void 你为什么要破解我的代码aaaaam(@NotNull MinecraftServer minecraftServer) {
        Intrinsics.checkNotNullParameter((Object)minecraftServer, (String)((String)aaaadf.aaaapl((char)932708354)));
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaal();
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().unregister((Object)this);
        this.你为什么要破解我的代码aaaaik();
        class_3004 class_30042 = minecraftServer.method_3837();
        class_3002 class_30022 = 我草你怎么反编译我模组aaaaaj;
        if (class_30022 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaadf.aaaapl((char)-1989214199)));
            class_30022 = null;
        }
        class_30042.method_12973(class_30022);
        aaaaab.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(false);
        ((class_1928.class_4310)minecraftServer.method_30002().method_8450().method_20746(class_1928.field_19392)).method_20758(true, minecraftServer);
        ((class_1928.class_4310)minecraftServer.method_30002().method_8450().method_20746(class_1928.field_19391)).method_20758(true, minecraftServer);
        ((class_1928.class_4310)minecraftServer.method_30002().method_8450().method_20746(class_1928.field_19393)).method_20758(true, minecraftServer);
        aaaaac.你为什么要破解我的代码aaaaac(minecraftServer);
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaahZ(@NotNull BlockPlaceEvent blockPlaceEvent) {
        Intrinsics.checkNotNullParameter((Object)blockPlaceEvent, (String)((String)aaaadf.aaaapl((char)-736296950)));
        blockPlaceEvent.setResult(class_1269.field_5814);
    }

    @Override
    @NotNull
    public class_243 你为什么要破解我的代码aaaabQ() {
        return 我草你怎么反编译我模组aaaaag;
    }

    @Override
    @NotNull
    public MinecraftServer 你为什么要破解我的代码aaaabR() {
        MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
        Intrinsics.checkNotNull((Object)minecraftServer);
        return minecraftServer;
    }

    private final void 你为什么要破解我的代码aaaaas() {
        aaaacu aaaacu2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaah();
        String string = aaaacu2.你为什么要破解我的代码aaaabv().你为什么要破解我的代码aaaaaa();
        String string2 = (String)aaaacu2.你为什么要破解我的代码aaaaao().get((Object)string);
        if (string2 == null) {
            string2 = string;
        }
        String string3 = string2;
        int n = aaaacu2.你为什么要破解我的代码aaaaaa();
        float f = (float)我草你怎么反编译我模组aaaaan / (float)n;
        class_3002 class_30022 = 我草你怎么反编译我模组aaaaaj;
        if (class_30022 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaadf.aaaapl((char)-848822263)));
            class_30022 = null;
        }
        class_30022.method_12954(我草你怎么反编译我模组aaaaan);
        class_3002 class_30023 = 我草你怎么反编译我模组aaaaaj;
        if (class_30023 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaadf.aaaapl((char)-1530003447)));
            class_30023 = null;
        }
        class_30023.method_5416(f < 0.33f ? class_1259.class_1260.field_5784 : (f < 0.66f ? class_1259.class_1260.field_5782 : class_1259.class_1260.field_5785));
        class_3002 class_30024 = 我草你怎么反编译我模组aaaaaj;
        if (class_30024 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaadf.aaaapl((char)-232980471)));
            class_30024 = null;
        }
        Object[] objectArray = new Object[]{"§6§l" + string3, 我草你怎么反编译我模组aaaaan, n};
        class_30024.method_5413((class_2561)class_2561.method_43469((String)((String)aaaadf.aaaapl((char)1672216582)), (Object[])objectArray));
        Object[] objectArray2 = 我草你怎么反编译我模组aaaaad;
        if (objectArray2 == null) {
            return;
        }
        objectArray = objectArray2;
        List list = objectArray.method_3760().method_14571();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)((String)aaaadf.aaaapl((char)1294729224)));
        Iterable iterable = (Iterable)list;
        boolean bl = false;
        for (Object object : iterable) {
            class_3222 class_32222 = (class_3222)object;
            boolean bl2 = false;
            class_3002 class_30025 = 我草你怎么反编译我模组aaaaaj;
            if (class_30025 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)((String)aaaadf.aaaapl((char)1303314441)));
                class_30025 = null;
            }
            class_30025.method_14088(class_32222);
        }
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaaan(@NotNull aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaad aaaaad2) {
        int n;
        Intrinsics.checkNotNullParameter((Object)aaaaad2, (String)((String)aaaadf.aaaapl((char)-1542455286)));
        this.你为什么要破解我的代码aaaaas();
        long l = System.currentTimeMillis();
        if (!((Collection)我草你怎么反编译我模组aaaacP).isEmpty() && (我草你怎么反编译我模组aaaacQ = (n = 我草你怎么反编译我模组aaaacQ) + 1) >= 5) {
            aaaabI aaaabI2 = (aaaabI)我草你怎么反编译我模组aaaacP.removeFirst();
            Intrinsics.checkNotNull((Object)aaaabI2);
            this.你为什么要破解我的代码aaaapd(aaaabI2);
            我草你怎么反编译我模组aaaacQ = 0;
        }
        if (l - 我草你怎么反编译我模组aaaaar >= 我草你怎么反编译我模组aaaaaq * (long)1000) {
            this.你为什么要破解我的代码aaaabp();
            我草你怎么反编译我模组aaaaar = l;
        }
        if (l - 我草你怎么反编译我模组aaaacW >= 我草你怎么反编译我模组aaaacX) {
            this.你为什么要破解我的代码aaaaib();
            我草你怎么反编译我模组aaaacW = l;
        }
    }

    private final void 你为什么要破解我的代码aaaapd(aaaabI aaaabI2) {
        class_1541 class_15412;
        class_1541 class_15413 = class_15412 = new class_1541((class_1937)aaaabI2.你为什么要破解我的代码aaaaaa(), aaaabI2.你为什么要破解我的代码aaaaab().field_1352, aaaabI2.你为什么要破解我的代码aaaaab().field_1351, aaaabI2.你为什么要破解我的代码aaaaab().field_1350, null);
        boolean bl = false;
        class_15413.method_6967(80);
        if (((CharSequence)aaaabI2.你为什么要破解我的代码aaaaac()).length() > 0) {
            class_15413.method_5665((class_2561)class_2561.method_43470((String)("§c" + aaaabI2.你为什么要破解我的代码aaaaac())));
            class_15413.method_5880(true);
        }
        class_1541 class_15414 = class_15412;
        aaaabI2.你为什么要破解我的代码aaaaaa().method_8649((class_1297)class_15414);
    }

    private final void 你为什么要破解我的代码aaaaib() {
        boolean bl;
        class_1297 class_12972;
        long l = System.currentTimeMillis();
        class_3218 class_32182 = this.你为什么要破解我的代码aaaabR().method_30002();
        Iterable iterable = class_32182.method_27909();
        Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)((String)aaaadf.aaaapl((char)1054998539)));
        Iterable iterable2 = iterable;
        boolean bl2 = false;
        Iterable iterable3 = iterable2;
        Object object2 = (Collection)new ArrayList();
        boolean bl3 = false;
        for (Map<UUID, Long> map : iterable3) {
            class_12972 = (class_1297)map;
            bl = false;
            if (!Intrinsics.areEqual((Object)class_12972.method_5864(), (Object)class_1299.field_6052)) continue;
            object2.add((Object)map);
        }
        iterable2 = (Iterable)((List)object2);
        bl2 = false;
        for (Object object2 : iterable2) {
            long l2;
            Object object3;
            Map<UUID, Long> map;
            class_1297 class_12973 = (class_1297)object2;
            boolean bl4 = false;
            map = 我草你怎么反编译我模组aaaacZ;
            Intrinsics.checkNotNullExpressionValue((Object)class_12973.method_5667(), (String)((String)aaaadf.aaaapl((char)-1214644212)));
            bl = false;
            Object object4 = map.get((Object)class_12972);
            if (object4 == null) {
                boolean bl5 = false;
                Long l3 = l;
                map.put((Object)class_12972, (Object)l3);
                object3 = l3;
            } else {
                object3 = object4;
            }
            if (l - (l2 = ((Number)object3).longValue()) < 我草你怎么反编译我模组aaaacY) continue;
            class_12973.method_5650(class_1297.class_5529.field_26999);
            我草你怎么反编译我模组aaaacZ.remove((Object)class_12973.method_5667());
        }
        我草你怎么反编译我模组aaaacZ.entrySet().removeIf(arg_0 -> aaaadf.你为什么要破解我的代码aaaapj(new aaaacv(class_32182), arg_0));
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaadM(@NotNull LiveEnterRoomEvent liveEnterRoomEvent) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)liveEnterRoomEvent, (String)((String)aaaadf.aaaapl((char)2093154314)));
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block1;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                String string = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaao() ? liveEnterRoomEvent.getUsername() : aaaaaj.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(liveEnterRoomEvent.getUsername());
                Object[] objectArray = new Object[]{"§6" + string};
                class_32222.field_13987.method_14364((class_2596)new class_5894((class_2561)class_2561.method_43469((String)((String)aaaadf.aaaapl((char)383057933)), (Object[])objectArray)));
            }
        }
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaaaO(@NotNull LiveGiftEvent liveGiftEvent) {
        Intrinsics.checkNotNullParameter((Object)liveGiftEvent, (String)((String)aaaadf.aaaapl((char)-678952950)));
        int n = liveGiftEvent.getGiftCount();
        if (n > 0) {
            aaaaag aaaaag2;
            Object object;
            boolean bl;
            aaaacB aaaacB2;
            Object object22;
            Object object3;
            aaaadh aaaadh2;
            Iterable iterable;
            block6: {
                iterable = (Iterable)aaaacB.你为什么要破解我的代码aaaaar();
                aaaadh2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa();
                object3 = iterable;
                for (Object object22 : object3) {
                    aaaacB2 = (aaaacB)((Object)object22);
                    bl = false;
                    if (!Intrinsics.areEqual((Object)aaaacB2.你为什么要破解我的代码aaaabA(), (Object)liveGiftEvent.getLiveType())) continue;
                    object = object22;
                    break block6;
                }
                object = null;
            }
            Intrinsics.checkNotNull(object);
            List<aaaaag> list = aaaadh2.你为什么要破解我的代码aaaaac((aaaacB)((Object)object));
            object3 = (Iterable)list;
            boolean bl2 = false;
            object22 = object3;
            aaaacB2 = (Collection)new ArrayList();
            bl = false;
            Object object4 = object22.iterator();
            while (object4.hasNext()) {
                Object object5 = object4.next();
                aaaaag2 = (aaaaag)object5;
                boolean bl3 = false;
                if (!Intrinsics.areEqual((Object)aaaaag2.你为什么要破解我的代码aaaaaa(), (Object)liveGiftEvent.getGiftName())) continue;
                aaaacB2.add(object5);
            }
            object3 = (Iterable)((List)aaaacB2);
            bl2 = false;
            object22 = object3;
            aaaacB2 = (Collection)new ArrayList();
            bl = false;
            object4 = object22;
            boolean bl4 = false;
            aaaaag2 = object4.iterator();
            while (aaaaag2.hasNext()) {
                aaaacr aaaacr2;
                Object object6;
                Object object7 = object6 = aaaaag2.next();
                boolean bl5 = false;
                aaaaag aaaaag3 = (aaaaag)object7;
                boolean bl6 = false;
                aaaaby aaaaby2 = aaaaag3.你为什么要破解我的代码aaaaag();
                if ((aaaaby2 instanceof aaaacr ? (aaaacr)aaaaby2 : null) == null) continue;
                aaaacr2 = aaaacr2;
                boolean bl7 = false;
                aaaacB2.add(aaaacr2);
            }
            iterable = (List)aaaacB2;
            if (iterable.isEmpty()) {
                return;
            }
            object3 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaao() ? liveGiftEvent.getUsername() : aaaaaj.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(liveGiftEvent.getUsername());
            Iterable iterable2 = iterable;
            boolean bl8 = false;
            for (Object object8 : iterable2) {
                object4 = (aaaacr)object8;
                bl4 = false;
                aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac(((aaaacr)object4).你为什么要破解我的代码aaaaaa() + "_事件音效");
                我草你怎么反编译我模组aaaaeK.你为什么要破解我的代码aaaaaW(liveGiftEvent.getGiftName(), ((aaaacr)object4).你为什么要破解我的代码aaaaab() * n, (String)object3, ((aaaacr)object4).你为什么要破解我的代码aaaaaa());
                我草你怎么反编译我模组aaaaeK.你为什么要破解我的代码aaaaig(((aaaacr)object4).你为什么要破解我的代码aaaaaa(), ((aaaacr)object4).你为什么要破解我的代码aaaaab() * n, (String)object3);
                if (!aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaam()) continue;
                我草你怎么反编译我模组aaaaeK.你为什么要破解我的代码aaaabx((String)object3, liveGiftEvent.getGiftName(), liveGiftEvent.getGiftCount());
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void 你为什么要破解我的代码aaaape(@NotNull aaaadf var1_1, @NotNull String var2_2, int var3_3, @NotNull String var4_4) {
        block38: {
            block32: {
                block29: {
                    block31: {
                        block27: {
                            block37: {
                                block36: {
                                    block35: {
                                        block30: {
                                            block34: {
                                                block28: {
                                                    block33: {
                                                        Intrinsics.checkNotNullParameter((Object)var1_1, (String)((String)aaaadf.aaaapl((char)378863630)));
                                                        Intrinsics.checkNotNullParameter((Object)var2_2, (String)((String)aaaadf.aaaapl((char)-1015087089)));
                                                        Intrinsics.checkNotNullParameter((Object)var4_4, (String)((String)aaaadf.aaaapl((char)-119275504)));
                                                        var5_5 = aaaaaj.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad((String)aaaadf.aaaapl((char)-2115239919));
                                                        var6_6 = null;
                                                        var6_6 = new LiveGiftEvent(var5_5, var2_2, var3_3, aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaabA(), (String)aaaadf.aaaapl((char)1661534225));
                                                        var7_7 = var2_2;
                                                        switch (var7_7.hashCode()) {
                                                            case 1164461369: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)895614994)))) {
                                                                    ** break;
                                                                }
                                                                break block27;
                                                            }
                                                            case 1164467835: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)-2098855917)))) {
                                                                    ** break;
                                                                }
                                                                break block28;
                                                            }
                                                            case 694408400: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)430506004)))) {
                                                                    ** break;
                                                                }
                                                                break block29;
                                                            }
                                                            case 29989902: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)11993109)))) {
                                                                    ** break;
                                                                }
                                                                break block30;
                                                            }
                                                            case 1247358190: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)-283049962)))) {
                                                                    ** break;
                                                                }
                                                                break block31;
                                                            }
                                                            case 876809396: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)935591959)))) {
                                                                    ** break;
                                                                }
                                                                break block32;
                                                            }
                                                            case 817296975: {
                                                                if (var7_7.equals((Object)((String)aaaadf.aaaapl((char)112394264)))) break;
                                                                ** break;
                                                            }
                                                            case 1247364656: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)1346240537)))) {
                                                                    ** break;
                                                                }
                                                                break block33;
                                                            }
                                                            case 37255458: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)-1585119206)))) {
                                                                    ** break;
                                                                }
                                                                break block34;
                                                            }
                                                            case 83226: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)66322459)))) {
                                                                    ** break;
                                                                }
                                                                break block35;
                                                            }
                                                            case 955568538: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)958398492)))) {
                                                                    ** break;
                                                                }
                                                                break block36;
                                                            }
                                                            case -425008076: {
                                                                if (!var7_7.equals((Object)((String)aaaadf.aaaapl((char)1744764957)))) {
                                                                    ** break;
                                                                }
                                                                break block37;
                                                            }
                                                        }
                                                        var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                                                        ** break;
                                                    }
                                                    var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                                                    ** break;
                                                }
                                                var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                                                ** break;
                                            }
                                            var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                                            ** break;
                                        }
                                        var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                                        ** break;
                                    }
                                    var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                                    ** break;
                                }
                                var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                                ** break;
                            }
                            var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                            ** break;
                        }
                        var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                        ** break;
                    }
                    var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                    ** break;
                }
                var1_1.你为什么要破解我的代码aaaaig(var2_2, var3_3, var4_4);
                ** break;
            }
            var1_1.你为什么要破解我的代码aaaaik();
lbl90:
            // 25 sources

            if ((v0 = aaaadf.我草你怎么反编译我模组aaaaad) == null || (v0 = v0.method_3760()) == null || (v0 = v0.method_14571()) == null) break block38;
            var8_8 = (Iterable)v0;
            var9_9 = false;
            for (Object var11_11 : var8_8) {
                var12_12 = (class_3222)var11_11;
                var13_13 = false;
                Intrinsics.checkNotNull((Object)var12_12);
                var1_1.你为什么要破解我的代码aaaaeE(var12_12, var6_6.getGiftName(), var3_3, var4_4, var2_2, false);
                if (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaam()) {
                    var14_14 = new Object[]{"§a" + var4_4, "§e" + var6_6.getGiftName() + "x" + var6_6.getGiftCount()};
                    var12_12.method_43496((class_2561)class_2561.method_43469((String)((String)aaaadf.aaaapl((char)-664272866)), (Object[])var14_14));
                }
                aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac(var2_2 + "_事件音效");
            }
        }
    }

    public static /* synthetic */ void 你为什么要破解我的代码aaaapf(aaaadf aaaadf2, aaaadf aaaadf3, String string, int n, String string2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = (String)aaaadf.aaaapl((char)1892548639);
        }
        if ((n2 & 4) != 0) {
            string2 = (String)aaaadf.aaaapl((char)-1119617007);
        }
        aaaadf2.你为什么要破解我的代码aaaape(aaaadf3, string, n, string2);
    }

    private final void 你为什么要破解我的代码aaaaeE(class_3222 class_32222, String string, int n, String string2, String string3, boolean bl) {
        String string4 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaan(string3);
        Object[] objectArray = new Object[]{"§c" + string4 + " x" + n};
        class_5250 class_52502 = class_2561.method_43469((String)((String)aaaadf.aaaapl((char)661061664)), (Object[])objectArray);
        Object[] objectArray2 = new Object[]{"§6" + string2, "§6" + string + " x" + n};
        objectArray = class_2561.method_43469((String)((String)aaaadf.aaaapl((char)-1420689375)), (Object[])objectArray2);
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, (class_2561)class_52502, (class_2561)objectArray, 10, 60, 10);
    }

    static /* synthetic */ void 你为什么要破解我的代码aaaapg(aaaadf aaaadf2, class_3222 class_32222, String string, int n, String string2, String string3, boolean bl, int n2, Object object) {
        if ((n2 & 0x20) != 0) {
            bl = false;
        }
        aaaadf2.你为什么要破解我的代码aaaaeE(class_32222, string, n, string2, string3, bl);
    }

    private final void 你为什么要破解我的代码aaaaaW(String string, int n, String string2, String string3) {
        block2: {
            MinecraftServer minecraftServer;
            String string4;
            aaaacu aaaacu2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaah();
            String string5 = (String)aaaacu2.你为什么要破解我的代码aaaaao().get((Object)string3);
            if (string5 == null) {
                string5 = string4 = string3;
            }
            if ((minecraftServer = 我草你怎么反编译我模组aaaaad) == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block2;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)class_32222);
                Object[] objectArray = new Object[]{"§6" + string2, "§6" + string, "§ex" + n};
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(class_32222, (class_2561)class_2561.method_43470((String)("§c" + string4 + " x" + n)), (class_2561)class_2561.method_43469((String)((String)aaaadf.aaaapl((char)-663945183)), (Object[])objectArray), 10, 70, 20);
            }
        }
    }

    private final void 你为什么要破解我的代码aaaabx(String string, String string2, int n) {
        block1: {
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block1;
            Iterable iterable = (Iterable)minecraftServer;
            boolean bl = false;
            for (Object object : iterable) {
                class_3222 class_32222 = (class_3222)object;
                boolean bl2 = false;
                Object[] objectArray = new Object[]{"§a" + string, "§a" + string2 + "x" + n};
                class_32222.method_43496((class_2561)class_2561.method_43469((String)((String)aaaadf.aaaapl((char)425000990)), (Object[])objectArray));
            }
        }
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaabv(@NotNull LiveLikeEvent liveLikeEvent) {
        Intrinsics.checkNotNullParameter((Object)liveLikeEvent, (String)((String)aaaadf.aaaapl((char)2112159754)));
        aaaacu aaaacu2 = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaah();
        int n = aaaacu2.你为什么要破解我的代码aaaaaa();
        我草你怎么反编译我模组aaaaan += liveLikeEvent.getLikeCount();
        while (我草你怎么反编译我模组aaaaan >= n) {
            aaaacf aaaacf2 = aaaacu2.你为什么要破解我的代码aaaabv();
            String string = this.你为什么要破解我的代码aaaabu(aaaacf2.你为什么要破解我的代码aaaaaa());
            this.你为什么要破解我的代码aaaaig(aaaacf2.你为什么要破解我的代码aaaaaa(), aaaacf2.你为什么要破解我的代码aaaaab(), (String)aaaadf.aaaapl((char)-1472856030));
            this.你为什么要破解我的代码aaaaaW(string, aaaacf2.你为什么要破解我的代码aaaaab(), (String)aaaadf.aaaapl((char)-1751449566), aaaacf2.你为什么要破解我的代码aaaaaa());
            我草你怎么反编译我模组aaaaan -= n;
        }
        this.你为什么要破解我的代码aaaaas();
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaabw(@NotNull LiveChatEvent liveChatEvent) {
        Intrinsics.checkNotNullParameter((Object)liveChatEvent, (String)((String)aaaadf.aaaapl((char)-553779190)));
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info("处理直播弹幕事件: " + liveChatEvent.getUsername() + " - " + liveChatEvent.getMessage());
        String string = liveChatEvent.getMessage().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaadf.aaaapl((char)-1213071325)));
        String string2 = string;
        String string3 = liveChatEvent.getUsername();
        List<aaaaad> list = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaah().你为什么要破解我的代码aaaaae();
        for (aaaaad aaaaad2 : list) {
            String string4 = aaaaad2.你为什么要破解我的代码aaaaaa().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)((String)aaaadf.aaaapl((char)-1927741405)));
            if (!Intrinsics.areEqual((Object)string2, (Object)string4)) continue;
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info("触发弹幕事件 - 用户: " + string3 + ", 内容: " + string2 + ", 事件类型: " + aaaaad2.你为什么要破解我的代码aaaaab() + ", 次数: " + aaaaad2.你为什么要破解我的代码aaaaac());
            String string5 = aaaaaj.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(liveChatEvent.getUsername());
            this.你为什么要破解我的代码aaaape(this, aaaaad2.你为什么要破解我的代码aaaaab(), aaaaad2.你为什么要破解我的代码aaaaac(), string5);
        }
    }

    private final String 你为什么要破解我的代码aaaabu(String string) {
        for (aaaacB aaaacB2 : aaaacB.你为什么要破解我的代码aaaaar()) {
            aaaaag aaaaag2;
            Object object;
            block2: {
                List<aaaaag> list = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac(aaaacB2);
                Iterable iterable = (Iterable)list;
                for (Object object2 : iterable) {
                    aaaaag aaaaag3 = (aaaaag)object2;
                    boolean bl = false;
                    aaaaby aaaaby2 = aaaaag3.你为什么要破解我的代码aaaaag();
                    aaaacr aaaacr2 = aaaaby2 instanceof aaaacr ? (aaaacr)aaaaby2 : null;
                    if (!Intrinsics.areEqual((Object)(aaaacr2 != null ? aaaacr2.你为什么要破解我的代码aaaaaa() : null), (Object)string)) continue;
                    object = object2;
                    break block2;
                }
                object = null;
            }
            if ((aaaaag2 = (aaaaag)object) == null) continue;
            return aaaaag2.你为什么要破解我的代码aaaaaa();
        }
        return string;
    }

    private final String 你为什么要破解我的代码aaaabs(String string) {
        return aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaao() ? string : aaaaaj.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(string);
    }

    private final void 你为什么要破解我的代码aaaabp() {
        Object object;
        Object object2;
        String string;
        String string2;
        block4: {
            String string3 = (String)CollectionsKt.random((Collection)((Collection)我草你怎么反编译我模组aaaaap), (Random)((Random)Random.Default));
            string2 = this.你为什么要破解我的代码aaaabs(string3);
            string = (String)CollectionsKt.random((Collection)((Collection)我草你怎么反编译我模组aaaaas), (Random)((Random)Random.Default));
            object2 = (Iterable)我草你怎么反编译我模组aaaabn;
            for (Object object3 : object2) {
                aaaacm aaaacm2 = (aaaacm)object3;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)aaaacm2.你为什么要破解我的代码aaaaaa(), (Object)string)) continue;
                object = object3;
                break block4;
            }
            object = null;
        }
        aaaacm aaaacm3 = (aaaacm)object;
        if (aaaacm3 != null) {
            int n = this.你为什么要破解我的代码aaaabt(string);
            object2 = this.你为什么要破解我的代码aaaabu(aaaacm3.你为什么要破解我的代码aaaaaa());
            aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac(aaaacm3.你为什么要破解我的代码aaaaaa() + "_事件音效");
            this.你为什么要破解我的代码aaaaaW((String)object2, n, string2, aaaacm3.你为什么要破解我的代码aaaaaa());
            if (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaam()) {
                this.你为什么要破解我的代码aaaabx(string2, (String)object2, 1);
            }
            this.你为什么要破解我的代码aaaaig(aaaacm3.你为什么要破解我的代码aaaaaa(), n, string2);
        } else {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().warn("不存在怪物：" + string);
        }
    }

    private final int 你为什么要破解我的代码aaaabt(String string) {
        for (aaaacB aaaacB2 : aaaacB.你为什么要破解我的代码aaaaar()) {
            aaaaag aaaaag2;
            aaaaby aaaaby2;
            aaaacr aaaacr2;
            Object object;
            block2: {
                List<aaaaag> list = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac(aaaacB2);
                Iterable iterable = (Iterable)list;
                for (Object object2 : iterable) {
                    aaaaag aaaaag3 = (aaaaag)object2;
                    boolean bl = false;
                    aaaaby aaaaby3 = aaaaag3.你为什么要破解我的代码aaaaag();
                    aaaacr aaaacr3 = aaaaby3 instanceof aaaacr ? (aaaacr)aaaaby3 : null;
                    if (!Intrinsics.areEqual((Object)(aaaacr3 != null ? aaaacr3.你为什么要破解我的代码aaaaaa() : null), (Object)string)) continue;
                    object = object2;
                    break block2;
                }
                object = null;
            }
            if ((aaaacr2 = (aaaaby2 = (aaaaag2 = (aaaaag)object) != null ? aaaaag2.你为什么要破解我的代码aaaaag() : null) instanceof aaaacr ? (aaaacr)aaaaby2 : null) == null) continue;
            return aaaacr2.你为什么要破解我的代码aaaaab();
        }
        return 1;
    }

    private final void 你为什么要破解我的代码aaaaig(String string, int n, String string2) {
        Object object;
        block3: {
            Iterable iterable = (Iterable)我草你怎么反编译我模组aaaabn;
            for (Object object2 : iterable) {
                aaaacm aaaacm2 = (aaaacm)object2;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)aaaacm2.你为什么要破解我的代码aaaaaa(), (Object)string)) continue;
                object = object2;
                break block3;
            }
            object = null;
        }
        aaaacm aaaacm3 = (aaaacm)object;
        if (aaaacm3 != null) {
            this.你为什么要破解我的代码aaaaph(aaaacm3, n, string2);
        } else {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().warn("未知的事件类型: " + string);
        }
    }

    private final void 你为什么要破解我的代码aaaaph(aaaacm aaaacm2, int n, String string) {
        class_3218 class_32182 = this.你为什么要破解我的代码aaaabR().method_30002();
        Intrinsics.checkNotNull((Object)class_32182, (String)((String)aaaadf.aaaapl((char)-1550778332)));
        class_3218 class_32183 = class_32182;
        for (int i = 0; i < n; ++i) {
            class_243 class_2432;
            int n2 = i;
            boolean bl = false;
            if (aaaacm2.你为什么要破解我的代码aaaaag() != null && Intrinsics.areEqual((Object)aaaacm2.你为什么要破解我的代码aaaaaa(), (Object)((String)aaaadf.aaaapl((char)-2049245157)))) {
                class_2432 = 我草你怎么反编译我模组aaaaeK.你为什么要破解我的代码aaaapi(我草你怎么反编译我模组aaaaag);
                我草你怎么反编译我模组aaaacP.add((Object)new aaaabI(class_32183, class_2432, string));
                continue;
            }
            if (aaaacm2.你为什么要破解我的代码aaaaag() != null) {
                try {
                    aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info("Attempting to spawn custom entity: " + aaaacm2.你为什么要破解我的代码aaaaaa());
                    class_2432 = (class_1308)aaaacm2.你为什么要破解我的代码aaaaag().invoke((Object)class_32183, (Object)我草你怎么反编译我模组aaaaag, (Object)string);
                    if (class_2432 != null) {
                        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info("Successfully spawned custom entity: " + aaaacm2.你为什么要破解我的代码aaaaaa());
                        continue;
                    }
                    aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().warn("Failed to spawn custom entity: " + aaaacm2.你为什么要破解我的代码aaaaaa());
                }
                catch (Exception exception) {
                    aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().error("Error spawning custom entity: " + aaaacm2.你为什么要破解我的代码aaaaaa(), (Throwable)exception);
                }
                continue;
            }
            if (aaaacm2.你为什么要破解我的代码aaaaaf() != null) {
                try {
                    Iterable iterable;
                    class_2432 = aaaacm2.你为什么要破解我的代码aaaaaf() + " " + aaaadf.我草你怎么反编译我模组aaaaag.field_1352 + " " + aaaadf.我草你怎么反编译我模组aaaaag.field_1351 + " " + aaaadf.我草你怎么反编译我模组aaaaag.field_1350 + " {CustomName:'{\"text\":\"§c" + string + "\"}',CustomNameVisible:1b}";
                    class_32183.method_8503().method_3734().method_44252(class_32183.method_8503().method_3739(), (String)class_2432);
                    Intrinsics.checkNotNullExpressionValue((Object)class_32183.method_27909(), (String)((String)aaaadf.aaaapl((char)42401803)));
                    boolean bl2 = false;
                    Object object = null;
                    for (Object object2 : iterable) {
                        class_1297 class_12972 = (class_1297)object2;
                        boolean bl3 = false;
                        class_2561 class_25612 = class_12972.method_5797();
                        boolean bl4 = Intrinsics.areEqual((Object)(class_25612 != null ? class_25612.getString() : null), (Object)("§c" + string)) && class_12972 instanceof class_1308;
                        if (!bl4) continue;
                        object = object2;
                    }
                    class_1297 class_12973 = (class_1297)object;
                    if (class_12973 == null) continue;
                    class_1297 class_12974 = class_12973;
                    boolean bl5 = false;
                }
                catch (Exception exception) {
                    aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().error("生成模组实体时发生错误: " + aaaacm2.你为什么要破解我的代码aaaaaf(), (Throwable)exception);
                }
                continue;
            }
            if (aaaacm2.你为什么要破解我的代码aaaaac() == null || (class_2432 = (class_1308)aaaacm2.你为什么要破解我的代码aaaaac().method_47821(class_32183, class_2338.method_49638((class_2374)((class_2374)我草你怎么反编译我模组aaaaag)), class_3730.field_16462)) == null) continue;
            class_2432.method_5808(aaaadf.我草你怎么反编译我模组aaaaag.field_1352, aaaadf.我草你怎么反编译我模组aaaaag.field_1351, aaaadf.我草你怎么反编译我模组aaaaag.field_1350, 0.0f, 0.0f);
            class_2432.method_5665((class_2561)class_2561.method_43470((String)("§c" + string)));
            class_2432.method_5880(true);
            if (!(class_2432 instanceof class_1642)) continue;
            if (!aaaacm2.你为什么要破解我的代码aaaaad()) {
                if (!aaaacm2.你为什么要破解我的代码aaaaae()) continue;
            }
            if (aaaacm2.你为什么要破解我的代码aaaaad()) {
                我草你怎么反编译我模组aaaaeK.你为什么要破解我的代码aaaaii((class_1642)class_2432);
                continue;
            }
            if (!aaaacm2.你为什么要破解我的代码aaaaae()) continue;
            我草你怎么反编译我模组aaaaeK.你为什么要破解我的代码aaaagL((class_1642)class_2432);
        }
    }

    private final class_243 你为什么要破解我的代码aaaapi(class_243 class_2432) {
        java.util.Random random = new java.util.Random();
        double d = -2.0 + random.nextDouble() * 4.0;
        double d2 = -2.0 + random.nextDouble() * 4.0;
        return new class_243(class_2432.field_1352 + d, class_2432.field_1351, class_2432.field_1350 + d2);
    }

    private final void 你为什么要破解我的代码aaaaii(class_1642 class_16422) {
        class_1642 class_16423;
        class_1642 class_16424 = class_16423 = class_16422;
        boolean bl = false;
        class_16424.method_5673(class_1304.field_6169, new class_1799((class_1935)class_1802.field_8862));
        class_16424.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8678));
        class_16424.method_5673(class_1304.field_6172, new class_1799((class_1935)class_1802.field_8416));
        class_16424.method_5673(class_1304.field_6166, new class_1799((class_1935)class_1802.field_8753));
        class_16424.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8845));
        class_16424.method_5946(class_1304.field_6169, 0.0f);
        class_16424.method_5946(class_1304.field_6174, 0.0f);
        class_16424.method_5946(class_1304.field_6172, 0.0f);
        class_16424.method_5946(class_1304.field_6166, 0.0f);
        class_16424.method_5946(class_1304.field_6173, 0.0f);
    }

    private final void 你为什么要破解我的代码aaaagL(class_1642 class_16422) {
        class_1642 class_16423;
        class_1642 class_16424 = class_16423 = class_16422;
        boolean bl = false;
        class_16424.method_5673(class_1304.field_6169, new class_1799((class_1935)class_1802.field_8805));
        class_16424.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8058));
        class_16424.method_5673(class_1304.field_6172, new class_1799((class_1935)class_1802.field_8348));
        class_16424.method_5673(class_1304.field_6166, new class_1799((class_1935)class_1802.field_8285));
        class_16424.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8802));
        class_16424.method_5946(class_1304.field_6169, 0.0f);
        class_16424.method_5946(class_1304.field_6174, 0.0f);
        class_16424.method_5946(class_1304.field_6172, 0.0f);
        class_16424.method_5946(class_1304.field_6166, 0.0f);
        class_16424.method_5946(class_1304.field_6173, 0.0f);
    }

    public final void 你为什么要破解我的代码aaaaik() {
        block5: {
            boolean bl;
            class_1297 class_12972;
            我草你怎么反编译我模组aaaacP.clear();
            我草你怎么反编译我模组aaaacQ = 0;
            class_3218 class_32182 = this.你为什么要破解我的代码aaaabR().method_30002();
            Iterable iterable = class_32182.method_27909();
            Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)((String)aaaadf.aaaapl((char)2114191371)));
            Iterable iterable2 = iterable;
            boolean bl2 = false;
            Iterable iterable3 = iterable2;
            Object object3 = (Collection)new ArrayList();
            boolean bl3 = false;
            for (Object object2 : iterable3) {
                if (!(object2 instanceof class_1308)) continue;
                object3.add(object2);
            }
            iterable2 = (Iterable)((List)object3);
            bl2 = false;
            for (Object object3 : iterable2) {
                class_1308 class_13082 = (class_1308)object3;
                boolean bl4 = false;
                class_13082.method_5650(class_1297.class_5529.field_26999);
            }
            Iterable iterable4 = class_32182.method_27909();
            Intrinsics.checkNotNullExpressionValue((Object)iterable4, (String)((String)aaaadf.aaaapl((char)-1803550709)));
            iterable2 = iterable4;
            bl2 = false;
            iterable3 = iterable2;
            object3 = (Collection)new ArrayList();
            bl3 = false;
            for (Object object2 : iterable3) {
                class_12972 = (class_1297)object2;
                bl = false;
                if (!Intrinsics.areEqual((Object)class_12972.method_5864(), (Object)class_1299.field_6052)) continue;
                object3.add(object2);
            }
            iterable2 = (Iterable)((List)object3);
            bl2 = false;
            for (Object object3 : iterable2) {
                class_1297 class_12973 = (class_1297)object3;
                boolean bl5 = false;
                class_12973.method_5650(class_1297.class_5529.field_26999);
            }
            我草你怎么反编译我模组aaaada.clear();
            我草你怎么反编译我模组aaaacZ.clear();
            MinecraftServer minecraftServer = 我草你怎么反编译我模组aaaaad;
            if (minecraftServer == null || (minecraftServer = minecraftServer.method_3760()) == null || (minecraftServer = minecraftServer.method_14571()) == null) break block5;
            object3 = (Iterable)minecraftServer;
            bl3 = false;
            for (Object object2 : object3) {
                class_12972 = (class_3222)object2;
                bl = false;
                class_12972.method_7353((class_2561)class_2561.method_43471((String)((String)aaaadf.aaaapl((char)64749605))), false);
            }
        }
    }

    @Subscribe
    public final void 你为什么要破解我的代码aaaaeo(@NotNull ExplosionEvent explosionEvent) {
        Intrinsics.checkNotNullParameter((Object)explosionEvent, (String)((String)aaaadf.aaaapl((char)-109182966)));
        explosionEvent.getExplosion().method_8352();
    }

    private static final boolean 你为什么要破解我的代码aaaapj(Function1 function1, Object object) {
        Intrinsics.checkNotNullParameter((Object)function1, (String)((String)aaaadf.aaaapl((char)-1472856026)));
        return (Boolean)function1.invoke(object);
    }

    public static final /* synthetic */ class_243 你为什么要破解我的代码aaaapk(aaaadf aaaadf2, class_243 class_2432) {
        return aaaadf2.你为什么要破解我的代码aaaapi(class_2432);
    }

    static {
        byte[] byArray = "wùqùìDlÖtLíÄê©L+Ä7z\f¦ÝõzµóÛ-Ì\f°QCÌQÊ($Æ°ÆÛÍäÃÇc3E%YcaàÙÖAë\t[ö>JMáîgÓ¥KûHàÁ\nYV¹Ú7Ð(oxÚ+ÚlGV²Pd«Í \nÙü7ºqò\t¹Uäùk~ÅmîIæO%aºÚÿ#3ß«_W¿A !a=Pc!Ì-w­nË+Ð|MpÉ°ïÄpÕKÿdµ;\fH\bºõèð»ã;óùÙÂ¢¾=äEqº×{údºdý°qÆ\rk[OqûÃé#R#ýô«Nw|³?¥y948ïÊ>v§ Ìþ÷ zõB/ì~úFªÞ@lrbö,Äs³ËËs¯c¬Ë]ÿýáRl%/õ1ihÕÊMÍÙws8OmÙ,Ø ÅÜ¶cø} ªs2µ?YhuÈI§VC8DQ­uZÉ¦­KÞ @4:ÛI$V½íëYNÈ¢cµ6W9¶5$æé)qñ\ftO$Â+¦¾YMºÌôØy@äIû&·ð8¼Wü6¨t&àqu\\)k¸»Òícùñ¯zEÀ½há¯Ôw·/ä à ~WÍ­ÿÁq6nKý½§r_À·zñR§P5(YË²¤ Øj+Aï-dªjr>0èüð^÷ \noH¨j©Ý?Há¸Ü{1.qÄ\r:Ó,ç+/ îEMröµVÏc÷HëÒsõï¤USM¾9rÍªÊòï=Çêá\n*øt?rl' í\b]þ\t\f*(b\n3YnÚ]¡KWªýö¯N¸aþÅÃ\röíßFÃU®þ¢i\bÔ\bJÉøå\"Ðir/gô$ê|1IëÙ?UéÑl¤à×$¥ü8)ô{Á½ìà²iMÇC0xsÇ¿¾±'''p=¿/æüzBÉ%}£ãvÚÄ·\tçn=_¨Ir®R±;R@à¿y5iFN6o)bH¼lô\\}é´$:£\b!Ñä]^¸7±ÏÜQOjS)A^öc½±¶ùáõ*Ë©e|ýORRßNæbWõ¾új±Öõ¤G\nÐÃ°:\fÊf\nÓë=FtÀÓZ#½W0nµsI=è{hÄ0åÌ¤tMÏø".getBytes("ISO_8859_1");
        Object[] objectArray = "Ø«Ê°³gÁ".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 220062019;
                case 1 -> 2009471446;
                case 2 -> -1057280500;
                case 3 -> 1403188043;
                case 4 -> -387539562;
                case 5 -> -822040901;
                case 6 -> -737396036;
                case 7 -> 1504416017;
                case 8 -> -1889302583;
                case 9 -> -799749273;
                case 10 -> -1528293791;
                case 11 -> -854138541;
                case 12 -> 1474536588;
                case 13 -> -952051026;
                case 14 -> 2131173945;
                case 15 -> -1899749068;
                case 16 -> -1150437743;
                case 17 -> 1667190757;
                case 18 -> -531075861;
                case 19 -> 466067199;
                case 20 -> 427804815;
                case 21 -> -1651353395;
                case 22 -> 911931707;
                case 23 -> 1495103746;
                case 24 -> 540338915;
                case 25 -> -1252482441;
                case 26 -> 380920592;
                case 27 -> -48396412;
                case 28 -> -143914201;
                case 29 -> 1169145042;
                case 30 -> 1980605491;
                case 31 -> -1049086028;
                case 32 -> 753138658;
                case 33 -> 1281916776;
                case 34 -> 253382784;
                case 35 -> -1835094627;
                case 36 -> 1106110389;
                case 37 -> 706106424;
                case 38 -> -381833829;
                case 39 -> 1526094351;
                case 40 -> 328788961;
                case 41 -> -737522640;
                case 42 -> -1383833819;
                case 43 -> -480585521;
                case 44 -> 1766753637;
                case 45 -> -1453893713;
                case 46 -> 551590909;
                case 47 -> -2055811451;
                case 48 -> 486605830;
                case 49 -> 401414441;
                case 50 -> -956165269;
                case 51 -> 833033777;
                case 52 -> 948585044;
                case 53 -> -1012193252;
                case 54 -> -251520494;
                case 55 -> 262767299;
                case 56 -> 1323976169;
                case 57 -> 1999023011;
                case 58 -> -1850762354;
                case 59 -> -376775671;
                case 60 -> 1526368736;
                case 61 -> 1492692011;
                case 62 -> 1439562685;
                case 63 -> -1587669837;
                case 64 -> -1323031480;
                case 65 -> -1056204828;
                case 66 -> 475329379;
                case 67 -> 1451275466;
                case 68 -> -1812728241;
                case 69 -> 1807920860;
                case 70 -> -521209401;
                case 71 -> 617547070;
                case 72 -> -850814567;
                case 73 -> -2059504710;
                case 74 -> 215405603;
                case 75 -> -1049852940;
                case 76 -> 882036472;
                case 77 -> 967660076;
                case 78 -> 1997297535;
                case 79 -> -1142192175;
                case 80 -> 1062109670;
                case 81 -> -1060631416;
                case 82 -> -538739398;
                case 83 -> 300503929;
                case 84 -> -382745298;
                case 85 -> -1634886149;
                case 86 -> -1804580115;
                case 87 -> -1394487283;
                case 88 -> 1307199189;
                case 89 -> 2051717236;
                case 90 -> 126173112;
                case 91 -> -1873758026;
                case 92 -> -315157055;
                case 93 -> 590677241;
                case 94 -> 1730229061;
                case 95 -> 392955176;
                case 96 -> -1959140670;
                case 97 -> 1336061963;
                case 98 -> -1853561836;
                case 99 -> -266485431;
                case 100 -> 291235484;
                case 101 -> 1298864110;
                case 102 -> -872962228;
                case 103 -> 849457717;
                case 104 -> 1865625535;
                case 105 -> 797277701;
                case 106 -> 1908793186;
                case 107 -> 1552773734;
                case 108 -> -983432854;
                case 109 -> 1120350366;
                case 110 -> -1552200185;
                case 111 -> 1229969073;
                case 112 -> -1228701576;
                case 113 -> 2045933471;
                case 114 -> 671502460;
                case 115 -> -610345287;
                case 116 -> -2080909062;
                case 117 -> -1805894885;
                case 118 -> 43027750;
                case 119 -> -1457949242;
                case 120 -> 330535735;
                case 121 -> -1970910765;
                case 122 -> 1001181867;
                case 123 -> -36388905;
                case 124 -> -1805984174;
                case 125 -> 359172442;
                case 126 -> 2051079050;
                case 127 -> 1055049031;
                case 128 -> 1655362179;
                case 129 -> 1073977986;
                case 130 -> -208787490;
                case 131 -> 2069540292;
                case 132 -> 314583945;
                case 133 -> -209996583;
                case 134 -> 287879944;
                case 135 -> -1454840488;
                case 136 -> 770432203;
                case 137 -> 1822601235;
                case 138 -> -1026252299;
                case 139 -> 292543210;
                case 140 -> -1782876608;
                case 141 -> -490432956;
                case 142 -> -1873647170;
                case 143 -> 539502548;
                case 144 -> -1130076502;
                case 145 -> 989474304;
                case 146 -> 527657129;
                case 147 -> -1388747937;
                case 148 -> -1809950552;
                case 149 -> 360270576;
                case 150 -> 1955354625;
                case 151 -> -1368201383;
                case 152 -> 1340762371;
                case 153 -> 2073224553;
                case 154 -> -640708833;
                case 155 -> -1285671277;
                case 156 -> -469113934;
                case 157 -> -510966530;
                case 158 -> 746584106;
                case 159 -> -505744677;
                case 160 -> 2009114103;
                case 161 -> 2138614869;
                case 162 -> -1735855465;
                case 163 -> -32606097;
                case 164 -> 1227656188;
                case 165 -> 1813606774;
                case 166 -> 1259769841;
                case 167 -> 1108313213;
                case 168 -> -1682151769;
                case 169 -> -1671803010;
                case 170 -> -829625500;
                case 171 -> -44527279;
                case 172 -> 224811426;
                case 173 -> 1850896784;
                case 174 -> -51083627;
                case 175 -> -1752053131;
                case 176 -> -333009617;
                case 177 -> -1224046311;
                case 178 -> 1557976862;
                case 179 -> 1072543137;
                case 180 -> 206403318;
                case 181 -> 733534218;
                case 182 -> 1595250284;
                case 183 -> 1214381648;
                case 184 -> -239954200;
                case 185 -> 963908406;
                case 186 -> 347234593;
                case 187 -> -1934096680;
                case 188 -> 1867316172;
                case 189 -> -33848808;
                case 190 -> 1272168740;
                case 191 -> -687402976;
                case 192 -> -618455632;
                case 193 -> -1454194667;
                case 194 -> 2045488792;
                case 195 -> -1612429810;
                case 196 -> -1789386643;
                case 197 -> 1859386177;
                case 198 -> -756867189;
                case 199 -> -558703424;
                case 200 -> 2038048605;
                case 201 -> -1388075118;
                case 202 -> 2028553842;
                case 203 -> -1874782560;
                case 204 -> 1181460944;
                case 205 -> -1264783529;
                case 206 -> -670271866;
                case 207 -> -1115360108;
                case 208 -> -1802836795;
                case 209 -> -1375837049;
                case 210 -> 1044897767;
                case 211 -> -602552166;
                case 212 -> 1616360754;
                case 213 -> -1970097363;
                case 214 -> 1135650254;
                case 215 -> 2083388017;
                case 216 -> -485917366;
                case 217 -> 1774805282;
                case 218 -> 35646294;
                case 219 -> 517127903;
                case 220 -> -1618227139;
                case 221 -> -907029225;
                case 222 -> -950083232;
                case 223 -> 1752532316;
                case 224 -> 2054296342;
                case 225 -> -1065667728;
                case 226 -> 1672804781;
                case 227 -> 2067618957;
                case 228 -> 64968869;
                case 229 -> -581450418;
                case 230 -> 2013772708;
                case 231 -> 1180998877;
                case 232 -> -60749076;
                case 233 -> -1231353870;
                case 234 -> -440472376;
                case 235 -> -671512905;
                case 236 -> -1768933026;
                case 237 -> 608273690;
                case 238 -> 1721171516;
                case 239 -> -233390501;
                case 240 -> 540454017;
                case 241 -> 779231091;
                case 242 -> 917961245;
                case 243 -> 647148621;
                case 244 -> 66187012;
                case 245 -> -1605078718;
                case 246 -> -285320721;
                case 247 -> -898401293;
                case 248 -> 2032145727;
                case 249 -> 505438075;
                case 250 -> 869433772;
                case 251 -> 258379846;
                case 252 -> -1870209414;
                case 253 -> -756476966;
                case 254 -> -1392846738;
                case 255 -> 1129487014;
                default -> -2116062582;
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
            Object[] objectArray2 = new Object[51];
            objectArray = objectArray2;
            aaaaeL = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaacR = 5;
        我草你怎么反编译我模组aaaaeK = new aaaadf();
        我草你怎么反编译我模组aaaaag = new class_243(0.513, 6.0, 3.451);
        Object[] objectArray3 = new String[]{(String)aaaadf.aaaapl((char)-865468377), (String)aaaadf.aaaapl((char)1841627176), (String)aaaadf.aaaapl((char)-1988886487), (String)aaaadf.aaaapl((char)1769078826), (String)aaaadf.aaaapl((char)44367915), (String)aaaadf.aaaapl((char)-711983060), (String)aaaadf.aaaapl((char)-1296629715), (String)aaaadf.aaaapl((char)1802371118), (String)aaaadf.aaaapl((char)-573243345), (String)aaaadf.aaaapl((char)-1067778000)};
        我草你怎么反编译我模组aaaaap = CollectionsKt.listOf((Object[])objectArray3);
        我草你怎么反编译我模组aaaacP = new ArrayDeque();
        我草你怎么反编译我模组aaaaas = CollectionsKt.emptyList();
        objectArray3 = new aaaacm[]{new aaaacm((String)aaaadf.aaaapl((char)10420248), 1, class_1299.field_6051, false, false, null, null, 120, null), new aaaacm((String)aaaadf.aaaapl((char)-1970536423), 1, class_1299.field_6051, true, false, null, null, 112, null), new aaaacm((String)aaaadf.aaaapl((char)-757137389), 1, class_1299.field_6051, false, true, null, null, 96, null), new aaaacm((String)aaaadf.aaaapl((char)984547354), 1, class_1299.field_6147, false, false, null, null, 120, null), new aaaacm((String)aaaadf.aaaapl((char)-1350303723), 1, class_1299.field_38095, false, false, null, null, 120, null), new aaaacm((String)aaaadf.aaaapl((char)-348782565), 1, null, false, false, null, aaaabU.我草你怎么反编译我模组aaaaed, 60, null), new aaaacm((String)aaaadf.aaaapl((char)573571100), 1, null, false, false, (String)aaaadf.aaaapl((char)-1391591375), null, 92, null), new aaaacm((String)aaaadf.aaaapl((char)657588253), 1, null, false, false, (String)aaaadf.aaaapl((char)-316866510), null, 92, null), new aaaacm((String)aaaadf.aaaapl((char)2078867474), 1, null, false, false, null, aaaacP.我草你怎么反编译我模组aaaaeO, 60, null), new aaaacm((String)aaaadf.aaaapl((char)-364904426), 1, null, false, false, null, aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaab.我草你怎么反编译我模组aaaaac, 60, null), new aaaacm((String)aaaadf.aaaapl((char)353828884), 1, null, false, false, null, aaaaaw.我草你怎么反编译我模组aaaacp, 60, null)};
        我草你怎么反编译我模组aaaabn = CollectionsKt.listOf((Object[])objectArray3);
        我草你怎么反编译我模组aaaaaq = 30L;
        我草你怎么反编译我模组aaaacX = 10000L;
        我草你怎么反编译我模组aaaacY = 10000L;
        我草你怎么反编译我模组aaaacZ = (Map)new LinkedHashMap();
        我草你怎么反编译我模组aaaada = (Set)new LinkedHashSet();
    }

    private static Object aaaapl(char c) {
        return ((Object[])aaaaeL)[c];
    }
}

