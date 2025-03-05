/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.function.Consumer
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking$Context
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.minecraft.class_1299
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_746
 *  net.minecraft.class_8710
 *  net.minecraft.class_897
 *  net.minecraft.class_9779
 *  org.jetbrains.annotations.NotNull
 */
package cn.pixellive.mc.game.client;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaZ;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaabG;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaabI;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacW;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaah;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaP;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaao;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabD;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabH;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabM;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabr;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabv;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacs;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaadf;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaD;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaae;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaaf;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaaj;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaan;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaal;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaai;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaak;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaap;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaat;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaau;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaab.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaac;
import cn.pixellive.mc.game.PixelLiveGameMod;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_1299;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_5617;
import net.minecraft.class_746;
import net.minecraft.class_8710;
import net.minecraft.class_897;
import net.minecraft.class_9779;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nPixelLiveGameClientMod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PixelLiveGameClientMod.kt\ncn/pixellive/mc/game/client/PixelLiveGameClientMod\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,629:1\n1855#2,2:630\n1855#2,2:632\n1#3:634\n215#4,2:635\n*S KotlinDebug\n*F\n+ 1 PixelLiveGameClientMod.kt\ncn/pixellive/mc/game/client/PixelLiveGameClientMod\n*L\n223#1:630,2\n289#1:632,2\n560#1:635,2\n*E\n"})
public final class PixelLiveGameClientMod
implements ClientModInitializer {
    @NotNull
    public static final aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaab 我草你怎么反编译我模组aaaaaa;
    @NotNull
    private final Map<String, class_304> 我草你怎么反编译我模组aaaaab;
    private boolean 我草你怎么反编译我模组aaaaac;
    @NotNull
    private final ConcurrentHashMap<String, Long> 我草你怎么反编译我模组aaaaad;
    private final long 我草你怎么反编译我模组aaaaae;
    @NotNull
    private static final String 我草你怎么反编译我模组aaaaaf;
    static Object aaaaag;

    public PixelLiveGameClientMod() {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-20316160)), (Object)new class_304((String)PixelLiveGameClientMod.aaaaaD((char)-124125183), 66, (String)PixelLiveGameClientMod.aaaaaD((char)-1022754814))), TuplesKt.to((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-563871741)), (Object)new class_304((String)PixelLiveGameClientMod.aaaaaD((char)1914437636), 86, (String)PixelLiveGameClientMod.aaaaaD((char)-1892483070))), TuplesKt.to((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-192872443)), (Object)new class_304((String)PixelLiveGameClientMod.aaaaaD((char)1809973254), 75, (String)PixelLiveGameClientMod.aaaaaD((char)348651522))), TuplesKt.to((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1741619207)), (Object)new class_304((String)PixelLiveGameClientMod.aaaaaD((char)1172504584), 90, (String)PixelLiveGameClientMod.aaaaaD((char)242352130))), TuplesKt.to((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-846790647)), (Object)new class_304((String)PixelLiveGameClientMod.aaaaaD((char)-1912340470), 78, (String)PixelLiveGameClientMod.aaaaaD((char)1158348802))), TuplesKt.to((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-1849360373)), (Object)new class_304((String)PixelLiveGameClientMod.aaaaaD((char)-1688338420), 74, (String)PixelLiveGameClientMod.aaaaaD((char)1218183170)))};
        this.我草你怎么反编译我模组aaaaab = MapsKt.mapOf((Pair[])pairArray);
        this.我草你怎么反编译我模组aaaaad = new ConcurrentHashMap();
        this.我草你怎么反编译我模组aaaaae = 10L;
    }

    public void onInitializeClient() {
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1442250739));
        try {
            String string;
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)99942414));
            PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaan(this);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1736572913));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-413204464));
            this.你为什么要破解我的代码aaaaab();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)1377370129));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1899757550));
            this.你为什么要破解我的代码aaaaad();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1529675757));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)522977300));
            this.你为什么要破解我的代码aaaaac();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-584253419));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-440270826));
            this.你为什么要破解我的代码aaaaao();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)945881111));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1111883752));
            this.你为什么要破解我的代码aaaaap();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)676921369));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)331546650));
            this.你为什么要破解我的代码aaaaar();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-142737381));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-498991076));
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaac.aaaaaa.aaaaaa.你为什么要破解我的代码aaaaab();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1922039779));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-871825378));
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaap.我草你怎么反编译我模组aaaabj.你为什么要破解我的代码aaaaaa();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)516161567));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-118030304));
            aaaaas aaaaas2 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
            String string2 = string = aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null;
            if (string != null) {
                aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaac(string);
                this.你为什么要破解我的代码aaaaae();
            }
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)621477921));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)475398178));
            ClientPlayNetworking.registerGlobalReceiver(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaai.我草你怎么反编译我模组aaaaah, PixelLiveGameClientMod::你为什么要破解我的代码aaaaas);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)862060579));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1946025948));
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-714407899));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)1703149606));
            this.你为什么要破解我的代码aaaaaa();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)193789991));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)2090532904));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)1039007785), (Throwable)exception);
            throw exception;
        }
    }

    private final void 你为什么要破解我的代码aaaaaa() {
        try {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaan.aaaaab.你为什么要破解我的代码aaaaaa();
            ClientPlayNetworking.registerGlobalReceiver(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaaf.我草你怎么反编译我模组aaaaah, PixelLiveGameClientMod::你为什么要破解我的代码aaaaau);
            aaaaaa.你为什么要破解我的代码aaaaaf();
            HudRenderCallback.EVENT.register(PixelLiveGameClientMod::你为什么要破解我的代码aaaaav);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)927072298));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)20578347), (Throwable)exception);
            throw exception;
        }
    }

    private final void 你为什么要破解我的代码aaaaab() {
        try {
            Iterable iterable = (Iterable)this.我草你怎么反编译我模组aaaaab.values();
            boolean bl = false;
            for (Object object : iterable) {
                class_304 class_3042 = (class_304)object;
                boolean bl2 = false;
                KeyBindingHelper.registerKeyBinding((class_304)class_3042);
                aaaaab.你为什么要破解我的代码aaaaaa().info("注册按键绑定: " + class_3042.method_1431());
            }
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)815923244), (Throwable)exception);
            throw exception;
        }
    }

    public final void 你为什么要破解我的代码aaaaac() {
        try {
            if (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaq() && !this.我草你怎么反编译我模组aaaaac) {
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaar.aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac((Consumer<String>)((Consumer)arg_0 -> PixelLiveGameClientMod.你为什么要破解我的代码aaaaaw(this, arg_0)));
                this.我草你怎么反编译我模组aaaaac = true;
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1648689107));
                this.你为什么要破解我的代码aaaaae();
            } else if (!aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaq() && this.我草你怎么反编译我模组aaaaac) {
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaar.aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaad();
                this.我草你怎么反编译我模组aaaaac = false;
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1292763090));
            }
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)-53018577), (Throwable)exception);
        }
    }

    private final void 你为什么要破解我的代码aaaaad() {
        try {
            ClientTickEvents.END_CLIENT_TICK.register(arg_0 -> PixelLiveGameClientMod.你为什么要破解我的代码aaaaax(this, arg_0));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)1840578608));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)490602545), (Throwable)exception);
            throw exception;
        }
    }

    private final void 你为什么要破解我的代码aaaaae() {
        try {
            Object object = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
            if (object == null || (object = ((aaaaas)object).你为什么要破解我的代码aaaaaj()) == null) {
                return;
            }
            Object object2 = object;
            aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaac((String)object2);
            HashSet hashSet = new HashSet();
            Iterable iterable = (Iterable)aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaabj();
            boolean bl = false;
            for (Object object3 : iterable) {
                aaaabG aaaabG2 = (aaaabG)object3;
                boolean bl2 = false;
                hashSet.add((Object)aaaabG2.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa());
            }
            hashSet.add((Object)aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaabh().你为什么要破解我的代码aaaaaa());
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaar.aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaab((Set<String>)((Set)hashSet));
            aaaaab.你为什么要破解我的代码aaaaaa().info("已更新允许的按键组合: " + hashSet);
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)-682950606), (Throwable)exception);
        }
    }

    private final void 你为什么要破解我的代码aaaaaf(String string) {
        long l = System.currentTimeMillis();
        Object object = this.我草你怎么反编译我模组aaaaad.getOrDefault((Object)string, (Object)0L);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)((String)PixelLiveGameClientMod.aaaaaD((char)-647757773)));
        long l2 = ((Number)object).longValue();
        if (l - l2 < this.我草你怎么反编译我模组aaaaae) {
            return;
        }
        Object object2 = l;
        ((Map)this.我草你怎么反编译我模组aaaaad).put((Object)string, object2);
        if (!aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaq()) {
            return;
        }
        Object object3 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
        if (object3 == null || (object3 = ((aaaaas)object3).你为什么要破解我的代码aaaaaj()) == null) {
            return;
        }
        Object object4 = object3;
        aaaaab.你为什么要破解我的代码aaaaaa().info("检测到按键组合: " + string);
        try {
            Object object5;
            Iterable iterable;
            block7: {
                aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaac((String)object4);
                iterable = (Iterable)aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaabj();
                for (Object object6 : iterable) {
                    aaaabG aaaabG2 = (aaaabG)object6;
                    boolean bl = false;
                    if (!Intrinsics.areEqual((Object)aaaabG2.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa(), (Object)string)) continue;
                    object5 = object6;
                    break block7;
                }
                object5 = null;
            }
            object2 = (aaaabG)object5;
            if (object2 != null) {
                iterable = object2;
                boolean bl = false;
                aaaaab.你为什么要破解我的代码aaaaaa().info("触发按键事件: " + iterable.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaab() + ", 次数: " + iterable.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac());
                ClientPlayNetworking.send((class_8710)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaap(iterable.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaab(), iterable.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac(), iterable.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaad()));
            }
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)-512098252), (Throwable)exception);
        }
    }

    private final void 你为什么要破解我的代码aaaaag(class_310 class_3102) {
        try {
            String string;
            aaaaas aaaaas2 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
            String string2 = string = aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null;
            if (string == null) {
                return;
            }
            aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaac(string);
            String string3 = aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaabh().你为什么要破解我的代码aaaaaa();
            if (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaar.aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaj(string3)) {
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1497694155));
                class_746 class_7462 = class_3102.field_1724;
                String string4 = class_7462 != null && (class_7462 = class_7462.method_5477()) != null ? class_7462.getString() : null;
                if (string4 == null) {
                    return;
                }
                String string5 = string4;
                aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaae(string5);
                return;
            }
            Object object = this.我草你怎么反编译我模组aaaaab.get((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1198063616)));
            Intrinsics.checkNotNull((Object)object);
            if (((class_304)object).method_1436()) {
                this.你为什么要破解我的代码aaaaah();
            } else {
                Object object2 = this.我草你怎么反编译我模组aaaaab.get((Object)((String)PixelLiveGameClientMod.aaaaaD((char)416874499)));
                Intrinsics.checkNotNull((Object)object2);
                if (((class_304)object2).method_1436()) {
                    this.你为什么要破解我的代码aaaaai(class_3102);
                } else {
                    Object object3 = this.我草你怎么反编译我模组aaaaab.get((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-1280507899)));
                    Intrinsics.checkNotNull((Object)object3);
                    if (((class_304)object3).method_1436() && !aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaq()) {
                        this.你为什么要破解我的代码aaaaaj(class_3102);
                    } else {
                        Object object4 = this.我草你怎么反编译我模组aaaaab.get((Object)((String)PixelLiveGameClientMod.aaaaaD((char)589168649)));
                        Intrinsics.checkNotNull((Object)object4);
                        if (((class_304)object4).method_1436()) {
                            this.你为什么要破解我的代码aaaaak(class_3102);
                        } else {
                            Object object5 = this.我草你怎么反编译我模组aaaaab.get((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-745734137)));
                            Intrinsics.checkNotNull((Object)object5);
                            if (((class_304)object5).method_1436()) {
                                this.你为什么要破解我的代码aaaaal();
                            } else {
                                Object object6 = this.我草你怎么反编译我模组aaaaab.get((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-131268597)));
                                Intrinsics.checkNotNull((Object)object6);
                                if (((class_304)object6).method_1436()) {
                                    this.你为什么要破解我的代码aaaaam(class_3102);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)2055995444), (Throwable)exception);
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void 你为什么要破解我的代码aaaaah() {
        block11: {
            v0 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
            v1 = var1_1 = v0 != null ? v0.你为什么要破解我的代码aaaaaj() : null;
            if (var1_1 == null) break block11;
            switch (var1_1.hashCode()) {
                case 630370341: {
                    if (!var1_1.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-769130442)))) {
                        break;
                    }
                    ** GOTO lbl23
                }
                case 1943330462: {
                    if (!var1_1.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)82378807)))) {
                        break;
                    }
                    ** GOTO lbl23
                }
                case 80702676: {
                    if (!var1_1.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1611595832)))) {
                        break;
                    }
                    ** GOTO lbl23
                }
                case 657401329: {
                    if (!var1_1.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-9306055)))) {
                        break;
                    }
                    ** GOTO lbl23
                }
                case 703077094: {
                    if (!var1_1.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1977679930)))) break;
lbl23:
                    // 5 sources

                    aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-912129989));
                    ClientPlayNetworking.send((class_8710)aaaaal.我草你怎么反编译我模组aaaaaI);
                }
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final void 你为什么要破解我的代码aaaaai(class_310 class_3102) {
        block24: {
            block26: {
                block29: {
                    block27: {
                        block23: {
                            block22: {
                                block25: {
                                    block28: {
                                        block21: {
                                            aaaaas aaaaas2 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
                                            aaaaab.你为什么要破解我的代码aaaaaa().info("打开设置界面: " + (aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null));
                                            aaaaas aaaaas3 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
                                            if (aaaaas3 == null) return;
                                            String string = aaaaas3.你为什么要破解我的代码aaaaaj();
                                            String string2 = string;
                                            if (string2 == null) return;
                                            switch (string2.hashCode()) {
                                                case 916506880: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-1586298820)))) {
                                                        return;
                                                    }
                                                    break block21;
                                                }
                                                case 1912904869: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-639172547)))) {
                                                        return;
                                                    }
                                                    break block22;
                                                }
                                                case 1121163920: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)624754750)))) {
                                                        return;
                                                    }
                                                    break block23;
                                                }
                                                case 812766903: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1684930623)))) {
                                                        return;
                                                    }
                                                    break block24;
                                                }
                                                case 630370341: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-558038986)))) {
                                                        return;
                                                    }
                                                    break block25;
                                                }
                                                case 1943330462: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)965148727)))) {
                                                        return;
                                                    }
                                                    break block26;
                                                }
                                                case 80702676: {
                                                    if (string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-478609352)))) break;
                                                    return;
                                                }
                                                case 1902430713: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-96468928)))) {
                                                        return;
                                                    }
                                                    break block27;
                                                }
                                                case 657401329: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-1072562119)))) {
                                                        return;
                                                    }
                                                    break block28;
                                                }
                                                case 703077094: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-2074673094)))) {
                                                        return;
                                                    }
                                                    break block29;
                                                }
                                            }
                                            class_3102.method_1507((class_437)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaab());
                                            return;
                                        }
                                        class_3102.method_1507((class_437)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaaa());
                                        return;
                                    }
                                    class_3102.method_1507((class_437)new aaaaaj());
                                    return;
                                }
                                class_3102.method_1507((class_437)new aaaaan());
                                return;
                            }
                            class_3102.method_1507((class_437)new aaaaae());
                            return;
                        }
                        class_3102.method_1507((class_437)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaai());
                        return;
                    }
                    class_3102.method_1507((class_437)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaad());
                    return;
                }
                class_3102.method_1507((class_437)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaak());
                return;
            }
            class_3102.method_1507((class_437)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaa.aaaaal());
            return;
        }
        class_3102.method_1507((class_437)new aaaaaf());
    }

    private final void 你为什么要破解我的代码aaaaaj(class_310 class_3102) {
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)1568276545));
        class_3102.method_1507((class_437)new aaaaaD(null, false));
    }

    private final void 你为什么要破解我的代码aaaaak(class_310 class_3102) {
        if (PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf() != null) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)211746882));
            Object object = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
            if (object != null && (object = ((aaaaas)object).你为什么要破解我的代码aaaaaj()) != null) {
                Object object2 = object;
                boolean bl = false;
                aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad((String)object2);
            }
            class_3102.method_1507((class_437)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaaf((String)PixelLiveGameClientMod.aaaaaD((char)-1941307325), 1, aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa(), false, 8, null));
        }
    }

    private final void 你为什么要破解我的代码aaaaal() {
        block3: {
            block2: {
                aaaaas aaaaas2 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
                if (Intrinsics.areEqual((Object)(aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null), (Object)((String)PixelLiveGameClientMod.aaaaaD((char)1301545016)))) break block2;
                aaaaas aaaaas3 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
                if (!Intrinsics.areEqual((Object)(aaaaas3 != null ? aaaaas3.你为什么要破解我的代码aaaaaj() : null), (Object)((String)PixelLiveGameClientMod.aaaaaD((char)-2007564233)))) break block3;
            }
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1904672700));
            ClientPlayNetworking.send((class_8710)aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaao.我草你怎么反编译我模组aaaabi);
        }
    }

    private final void 你为什么要破解我的代码aaaaam(class_310 class_3102) {
        block1: {
            if (PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf() == null) break block1;
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)1841365061));
            Object object = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
            if (object != null && (object = ((aaaaas)object).你为什么要破解我的代码aaaaaj()) != null) {
                Object object2 = object;
                boolean bl = false;
                aaaacW.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaac((String)object2);
                class_3102.method_1507((class_437)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaai());
            }
        }
    }

    private final void 你为什么要破解我的代码aaaaan(String string) {
        if (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaq()) {
            aaaabI.我草你怎么反编译我模组aaaaaL.你为什么要破解我的代码aaaaac(string);
            aaaaab.你为什么要破解我的代码aaaaaa().info("已加载 " + string + " 的按键配置");
            this.你为什么要破解我的代码aaaaae();
        }
    }

    private final void 你为什么要破解我的代码aaaaao() {
        try {
            ClientPlayNetworking.registerGlobalReceiver(aaaaah.我草你怎么反编译我模组aaaaah, (arg_0, arg_1) -> PixelLiveGameClientMod.你为什么要破解我的代码aaaaay(this, arg_0, arg_1));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)310247494), (Throwable)exception);
            throw exception;
        }
    }

    private final void 你为什么要破解我的代码aaaaap() {
        try {
            if (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaq()) {
                aaaaak aaaaak2 = aaaaau.你为什么要破解我的代码aaaaag(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaas());
                class_310.method_1551().execute(() -> PixelLiveGameClientMod.你为什么要破解我的代码aaaaaz(aaaaak2));
            } else {
                Pair<String, String> pair = this.你为什么要破解我的代码aaaaaq();
                String string = (String)pair.component1();
                String string2 = (String)pair.component2();
                aaaaat aaaaat2 = aaaaap.你为什么要破解我的代码aaaaac(string2, string, true, (String)PixelLiveGameClientMod.aaaaaD((char)708116551));
                Intrinsics.checkNotNull((Object)aaaaat2);
                HashMap<String, String> hashMap = aaaaat2.我草你怎么反编译我模组aaaaaa;
                Intrinsics.checkNotNull(hashMap);
                Map map = (Map)hashMap;
                boolean bl = false;
                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry;
                    Map.Entry entry2 = entry = (Map.Entry)iterator.next();
                    boolean bl2 = false;
                    String string3 = (String)entry2.getKey();
                    String string4 = (String)entry2.getValue();
                    aaaaab.你为什么要破解我的代码aaaaaa().info("加载游戏阶段: " + string3);
                }
                Set set = hashMap.keySet();
                aaaaap.我草你怎么反编译我模组aaaaaa = (List)new ArrayList(set != null ? (Collection)set : (Collection)SetsKt.emptySet());
            }
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)18939929));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)-604438456), (Throwable)exception);
            throw exception;
        }
    }

    private final Pair<String, String> 你为什么要破解我的代码aaaaaq() {
        String string = switch (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.我草你怎么反编译我模组aaaaaa[aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa().ordinal()]) {
            case 1 -> (String)PixelLiveGameClientMod.aaaaaD((char)687276105);
            case 2 -> (String)PixelLiveGameClientMod.aaaaaD((char)-187957174);
            case 3 -> (String)PixelLiveGameClientMod.aaaaaD((char)2050031691);
            case 4 -> (String)PixelLiveGameClientMod.aaaaaD((char)-1732902836);
            default -> throw new NoWhenBranchMatchedException();
        };
        String string2 = switch (aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.我草你怎么反编译我模组aaaaaa[aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa().ordinal()]) {
            case 1 -> aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac();
            case 2 -> aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaae();
            case 3 -> aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaai();
            case 4 -> aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaau();
            default -> throw new NoWhenBranchMatchedException();
        };
        aaaaab.你为什么要破解我的代码aaaaaa().info("获取平台信息 - 平台: " + string + ", 房间ID: " + string2);
        return new Pair((Object)string, (Object)string2);
    }

    private final void 你为什么要破解我的代码aaaaar() {
        try {
            boolean bl;
            class_1299<aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaaa> class_12992;
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1589968819));
            class_1299<aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaaa> class_12993 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaac.我草你怎么反编译我模组aaaaad;
            if (class_12993 != null) {
                class_12992 = class_12993;
                bl = false;
                EntityRendererRegistry.register(class_12992, PixelLiveGameClientMod::你为什么要破解我的代码aaaaaA);
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)1700266062));
            }
            class_1299<aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaaa> class_12994 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaac.我草你怎么反编译我模组aaaaae;
            if (class_12994 != null) {
                class_12992 = class_12994;
                bl = false;
                EntityRendererRegistry.register(class_12992, PixelLiveGameClientMod::你为什么要破解我的代码aaaaaB);
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)1312227407));
            }
            class_1299<aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaaa> class_12995 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaac.我草你怎么反编译我模组aaaaaf;
            if (class_12995 != null) {
                class_12992 = class_12995;
                bl = false;
                EntityRendererRegistry.register(class_12992, PixelLiveGameClientMod::你为什么要破解我的代码aaaaaC);
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1969422256));
            }
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameClientMod.aaaaaD((char)-1022164911));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)1607401554), (Throwable)exception);
            throw exception;
        }
    }

    private static final void 你为什么要破解我的代码aaaaas(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaai aaaaai2, ClientPlayNetworking.Context context) {
        aaaaac.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa(aaaaai2.你为什么要破解我的代码aaaabs());
    }

    private static final void 你为什么要破解我的代码aaaaat(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaaf aaaaaf2) {
        long l = System.currentTimeMillis();
        aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaab(new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaab.aaaaab(aaaaaf2.你为什么要破解我的代码aaaacy(), aaaaaf2.你为什么要破解我的代码aaaacz(), l + (long)2000, l, aaaaaf2.你为什么要破解我的代码aaaacA()));
        if (aaaaaf2.你为什么要破解我的代码aaaacA()) {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaaa.aaaaaa.你为什么要破解我的代码aaaaab();
        } else {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaaa.aaaaaa.你为什么要破解我的代码aaaaaa();
        }
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaan.aaaaab.你为什么要破解我的代码aaaaab();
    }

    private static final void 你为什么要破解我的代码aaaaau(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaaf aaaaaf2, ClientPlayNetworking.Context context) {
        class_310 class_3102 = class_310.method_1551();
        class_3102.execute(() -> PixelLiveGameClientMod.你为什么要破解我的代码aaaaat(aaaaaf2));
    }

    private static final void 你为什么要破解我的代码aaaaav(class_332 class_3322, class_9779 class_97792) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1755 == null) {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaaa.aaaaaa.你为什么要破解我的代码aaaaac(class_3322);
        }
    }

    private static final void 你为什么要破解我的代码aaaaaw(PixelLiveGameClientMod pixelLiveGameClientMod, String string) {
        Intrinsics.checkNotNullParameter((Object)pixelLiveGameClientMod, (String)((String)PixelLiveGameClientMod.aaaaaD((char)-913768365)));
        Intrinsics.checkNotNull((Object)string);
        if (((CharSequence)string).length() > 0) {
            pixelLiveGameClientMod.你为什么要破解我的代码aaaaaf(string);
        }
    }

    private static final void 你为什么要破解我的代码aaaaax(PixelLiveGameClientMod pixelLiveGameClientMod, class_310 class_3102) {
        Intrinsics.checkNotNullParameter((Object)pixelLiveGameClientMod, (String)((String)PixelLiveGameClientMod.aaaaaD((char)1389756499)));
        Intrinsics.checkNotNull((Object)class_3102);
        pixelLiveGameClientMod.你为什么要破解我的代码aaaaag(class_3102);
    }

    /*
     * Unable to fully structure code
     */
    private static final void 你为什么要破解我的代码aaaaay(PixelLiveGameClientMod var0, aaaaah var1_1, ClientPlayNetworking.Context var2_2) {
        block31: {
            block30: {
                block24: {
                    block26: {
                        block29: {
                            block23: {
                                block27: {
                                    block22: {
                                        block25: {
                                            block28: {
                                                block21: {
                                                    Intrinsics.checkNotNullParameter((Object)var0, (String)((String)PixelLiveGameClientMod.aaaaaD((char)-368312237)));
                                                    var3_3 = var1_1.你为什么要破解我的代码aaaaaG();
                                                    aaaaab.你为什么要破解我的代码aaaaaa().info("收到游戏阶段更新: " + var3_3);
                                                    var4_4 = var3_3;
                                                    switch (var4_4.hashCode()) {
                                                        case 916506880: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-2033844164)))) {
                                                                ** break;
                                                            }
                                                            break block21;
                                                        }
                                                        case 1912904869: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1969094717)))) {
                                                                ** break;
                                                            }
                                                            break block22;
                                                        }
                                                        case 1121163920: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)2076639294)))) {
                                                                ** break;
                                                            }
                                                            break block23;
                                                        }
                                                        case 812766903: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1185808447)))) {
                                                                ** break;
                                                            }
                                                            break block24;
                                                        }
                                                        case 630370341: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1926955062)))) {
                                                                ** break;
                                                            }
                                                            break block25;
                                                        }
                                                        case 1943330462: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)-1595932617)))) {
                                                                ** break;
                                                            }
                                                            break block26;
                                                        }
                                                        case 80702676: {
                                                            if (var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)651821112)))) break;
                                                            ** break;
                                                        }
                                                        case 1902430713: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)377552960)))) {
                                                                ** break;
                                                            }
                                                            break block27;
                                                        }
                                                        case 657401329: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)2121465913)))) {
                                                                ** break;
                                                            }
                                                            break block28;
                                                        }
                                                        case 703077094: {
                                                            if (!var4_4.equals((Object)((String)PixelLiveGameClientMod.aaaaaD((char)1346043962)))) {
                                                                ** break;
                                                            }
                                                            break block29;
                                                        }
                                                    }
                                                    v0 = aaaabM.我草你怎么反编译我模组aaaadA;
                                                    break block30;
                                                }
                                                v0 = aaaabv.我草你怎么反编译我模组aaaacL;
                                                break block30;
                                            }
                                            v0 = aaaaaP.我草你怎么反编译我模组aaaabK;
                                            break block30;
                                        }
                                        v0 = aaaacs.我草你怎么反编译我模组aaaaep;
                                        break block30;
                                    }
                                    v0 = aaaadf.我草你怎么反编译我模组aaaaeK;
                                    break block30;
                                }
                                v0 = aaaabD.我草你怎么反编译我模组aaaacN;
                                break block30;
                            }
                            v0 = aaaaad.我草你怎么反编译我模组aaaaaa;
                            break block30;
                        }
                        v0 = aaaabH.我草你怎么反编译我模组aaaadh;
                        break block30;
                    }
                    v0 = aaaaao.我草你怎么反编译我模组aaaabo;
                    break block30;
                }
                v0 = aaaabr.我草你怎么反编译我模组aaaacj;
                break block30;
lbl74:
                // 11 sources

                v0 = null;
            }
            PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaag(v0);
            v1 = var3_3;
            if (v1 == null) break block31;
            var5_5 = v1;
            var6_6 = false;
            var0.你为什么要破解我的代码aaaaan(var5_5);
        }
    }

    private static final void 你为什么要破解我的代码aaaaaz(aaaaak aaaaak2) {
        if (aaaaak2 == null) {
            return;
        }
        if (!aaaaak2.你为什么要破解我的代码aaaaaa()) {
            return;
        }
        String string = aaaaai.你为什么要破解我的代码aaaaaa();
        if (!Intrinsics.areEqual((Object)aaaaak2.我草你怎么反编译我模组aaaaaa, (Object)string)) {
            return;
        }
        String string2 = aaaaak2.我草你怎么反编译我模组aaaaab;
        CharSequence charSequence = string2;
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        try {
            Intrinsics.checkNotNull((Object)string2);
            String[] stringArray = new String[]{(String)PixelLiveGameClientMod.aaaaaD((char)1981546580)};
            aaaaap.我草你怎么反编译我模组aaaaaa = charSequence = StringsKt.split$default((CharSequence)string2, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaar(true);
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaae();
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaal.我草你怎么反编译我模组aaaaba.你为什么要破解我的代码aaaaad();
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameClientMod.aaaaaD((char)1488584789), (Throwable)exception);
        }
    }

    private static final class_897 你为什么要破解我的代码aaaaaA(class_5617.class_5618 class_56182) {
        Intrinsics.checkNotNull((Object)class_56182);
        return (class_897)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaab(class_56182);
    }

    private static final class_897 你为什么要破解我的代码aaaaaB(class_5617.class_5618 class_56182) {
        Intrinsics.checkNotNull((Object)class_56182);
        return (class_897)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaab(class_56182);
    }

    private static final class_897 你为什么要破解我的代码aaaaaC(class_5617.class_5618 class_56182) {
        Intrinsics.checkNotNull((Object)class_56182);
        return (class_897)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaab(class_56182);
    }

    static {
        byte[] byArray = "bp\fyä{¡Úß2íÂ»ë=cSÄRÛ©«w¼&9Þ©\f/8½ß÷õà­ÛÛÉçö½1ÈfÎ9¬Ín\t8uom´/@óu¼±ÇÔ¾Ðì­Ì êÁd(\\¦Êr[)è9:ê¡4Þ@þí:/ (ö¦OÚZ +Gùcf±CÌ iýýû f¾|@:u}[4=Ã0-ÿÜ6\r`¯®_s|¶dVhgB\"É~ÿlaY! <\"Rs*Cë±Í>·wêy­\nlp/Ó<DzÈuª¡î\bì1M²'*D7æç,h8-.WFo&îzúæC%)¶ZfÊÉÜ` zAãÂX-1)\bO3i«¯«êAüJÇ3ö?4ù,|¹ÓgË÷<¬+ãMxµðZ´dB<jesí>©h/pÉ1/à>ÚÂ*ÍÛ½C\\µâå7¹N/$N»ªðÔÎálÃ{sÓó8ÞA\bàá5î­ ËEá\tµY·AqÔ \t¯«eVõyÛ¢\f;Ø:ïÒÖD«)+õ²©ñ¹1\fåÌ½­P\\8X¡6;ã³-µ½ÿçF_ý$7;0?¬a@c!vwL;ÑFâß¨F*=\\oÃ2?©Ãã÷²«ÝÚ¤êQtk¯\t¢ZºR:±w;Eè¾¾ôGZú´ßæsÄ\fT¸\\ÛÄnvë%­^ñìrÒã$ÿ#+5nµ1ä#â¨0±¢ë¡GËçÁi^ÏfÎÔB¯2¯Û2\tìËg2`YÌþ'jÿKru°pÑó­ëÒÿl² óôAû'vÅ÷%_·].³:êðÑªN{:C{nÙy£ÝögXâúK´*<Ô}y¬NÎTEZ~\to±Lru¢×¨|]¤]X Äîþ) ºÛ.ÙWMä®]çËíÂ´z\rLiûTem½ÿÄ Uíx:J oèUKÒ\rÓ×Æ`'ºÒþÓ+Þ*UÙ¸çuyã«­Ï²´ÓÏàR*ÈE[c1$ãõI /Þ²AføÛ\r¿.}ÿ§8\b°oèO\"5Ø[^ÙÛÑP»×NMÒ`ßpÔüGØ\n ¤¦Îbà}àÌ¸9®Zç|ª?\\TèÜ¦áñ±ÌíSDe¹ÜàlâÒôNÅ¹ó'Nü³VÜgn·Ïxû@Z.K&Ã©¸3ÍÌ§þÙnO411E*õ¸_'ØXhüÇ\"Ó¥ÇhïäÈºe®x¦YFÒÐÇïôY-ÐàÎÒV(PDÍq¥^=ç_õÛÚ!^<Ùt3lã¬³eàm_5gÇ\t@dÒbür®t`1ÒlÉ\tìbn·bm*2\fmSk±\fÚæsO\b¿kûÝHÞ«Ò¸]\bPPS4JU²¯¸ÈÒ°¦LJx³}K\fOikZ$A:7ohÝ*Wtµ'ðgsÖä\"6u¦;)Ïnñ2`ëõ0LÃ!ÒÊ\f_]¥]Ö¾ÙåÉ:Y}{±\b3Høxo°.ìß9ÇD0:'·ìúßv¯U5¸· Ô`¬dzK#2'ß`Ãiõì©Ñvè~3¥;|^3:ËçÂ+q&Û1ó*pÞæÓù)N2ÔEfFuMö<À+xIç®â\fM»Êø´¥»8ÅÆßDzHègµ*XöÓ?ä4Üÿ÷×®uâþ¢À®Ì°hïQÖ\f/¿8ÚiÍ\"_Æ²°XÅ¤!ÁÖVAÀxÑ©£±0à>ÖöJ?£âo¦*@ÇE3i5ý©'/Ò­ZÕÿ0ÚXÌëXÃ{j\f¸(Àiwx)4 \ri\"N#Ôäs¨\r,Ç©ºVô®ìo;#*?Ë÷ÈÛrãpÎ¯9e·?1¨%>)2]®dÌhøÅÂÝäg]dòÕó?uè(ýíìçD­­¥|3ÚnKä¿µ\r÷kÈtÈÛ9ûÈ·Y5E§Sn¯P§è½22þ#êáãaA×¿Ba s,¤l«VÓÂy¯ÂòÍxnXÊµâlMoÊÝ%¸Â°Nlç\tú9¿ sYx» í¶:òò{Mº\bf!êµú\"¾úªNN4¼'HªVgJ§ìÌç>ðaó½{°~ûþ±W ÁÍ{´ý½Îæ¬fOXÊl¢fËXoBý|ËÚ|ÍòtS6´À·k¦ñ\"3Á\fäO¤'1¤}¤ê<3tòB0ôK&h^Ê/q¬`$IUNsx|eÇbP!¤°ãª×\rÐ\tâúd¯ÀiÜmÆm:R\nóüy:èµÄLwöÑ³÷Âç;ªnÀÿA,°Ý*SED?×Ü7¤zÚÁf¶Ç¦Ó§oò©\b÷i_çßÞ)îñ\t×I'?Ò*¹ßQz®fïóÌq\fZ&vóFõ¼@u\rûM×s\"qx[AD{bº³ÁSfÙÙ#f/\rÔ³®óâRli0Sß@¼9§±Vhð*ÿ{Fo*GUºÓCÛÄe!7a¹¨s~6¦åEÇ²ÈdÈtY@(aÖÿP^[xFë±,+Ö9®3Õ$ø1ú)Dþà±TPÛ¢Q¬\t4yM=·,íÃÜJ¤ê=»GiÕâöÍ}FÓjÅ©ÀØy,ôdG,Ö\\XhKXÚ/ _cZx7¤ÏþÌùN¾TÌ¦bKiã;Æu;­éÕMæ](Ð'3÷4u2? ø¥Fú¶ºú®£I7Î\r|¼Ñõºì[½)pH#×43ÿ¬ô¢û6ê¼iïj½þSò-éÉk7B 7{ÛS¹GQÉßöë«I'MIÀ".getBytes("ISO_8859_1");
        Object[] objectArray = "æ[üt%s½".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 969365202;
                case 1 -> 449093635;
                case 2 -> 1252348206;
                case 3 -> -1050196841;
                case 4 -> 1209961725;
                case 5 -> -780605799;
                case 6 -> 141218724;
                case 7 -> -320555737;
                case 8 -> 478774266;
                case 9 -> -1707258629;
                case 10 -> 742758557;
                case 11 -> -133252184;
                case 12 -> -2095325499;
                case 13 -> 801522702;
                case 14 -> -1612437168;
                case 15 -> -1796621432;
                case 16 -> -1063646889;
                case 17 -> 1276029063;
                case 18 -> 1629897803;
                case 19 -> -232343906;
                case 20 -> -2036210218;
                case 21 -> 5872538;
                case 22 -> 89960477;
                case 23 -> -671856261;
                case 24 -> 449953064;
                case 25 -> -1102541379;
                case 26 -> 216100454;
                case 27 -> -942650159;
                case 28 -> 496201048;
                case 29 -> -88870287;
                case 30 -> -1813088186;
                case 31 -> -535412003;
                case 32 -> 956251631;
                case 33 -> 1356427556;
                case 34 -> 424178751;
                case 35 -> 1361375934;
                case 36 -> -1012212461;
                case 37 -> -1671789192;
                case 38 -> 45492645;
                case 39 -> 1253561964;
                case 40 -> 1936616274;
                case 41 -> 1051909617;
                case 42 -> 1100254983;
                case 43 -> 45564134;
                case 44 -> 309499491;
                case 45 -> -780271122;
                case 46 -> 979551735;
                case 47 -> -1920182519;
                case 48 -> -1837618159;
                case 49 -> -967315223;
                case 50 -> -2011150347;
                case 51 -> -785100732;
                case 52 -> 947561589;
                case 53 -> -811805456;
                case 54 -> -1022674134;
                case 55 -> -1440705199;
                case 56 -> 584353306;
                case 57 -> -1895303730;
                case 58 -> 1895015186;
                case 59 -> 161980845;
                case 60 -> 1730525013;
                case 61 -> -1603107059;
                case 62 -> 1060358348;
                case 63 -> 866440608;
                case 64 -> 279511813;
                case 65 -> 469173825;
                case 66 -> -1699922890;
                case 67 -> 2049151287;
                case 68 -> -1800964254;
                case 69 -> -1815729335;
                case 70 -> 1546464918;
                case 71 -> -1126938069;
                case 72 -> -426940927;
                case 73 -> 457621995;
                case 74 -> 915542334;
                case 75 -> 1020290993;
                case 76 -> 1225661977;
                case 77 -> 1323947443;
                case 78 -> -1153978620;
                case 79 -> -568579080;
                case 80 -> -1157581372;
                case 81 -> -1565454631;
                case 82 -> 1875785541;
                case 83 -> -173806977;
                case 84 -> 1852926499;
                case 85 -> 2029857845;
                case 86 -> -1709971739;
                case 87 -> 644108743;
                case 88 -> -334983845;
                case 89 -> -132713773;
                case 90 -> 154161172;
                case 91 -> 1497598300;
                case 92 -> 1168169685;
                case 93 -> 323290293;
                case 94 -> 1827367090;
                case 95 -> 1931176256;
                case 96 -> 1173670167;
                case 97 -> 1483043930;
                case 98 -> 1474942454;
                case 99 -> 1641223867;
                case 100 -> -1309983695;
                case 101 -> 1697254144;
                case 102 -> 784020396;
                case 103 -> 1583919996;
                case 104 -> 394361659;
                case 105 -> 1266847693;
                case 106 -> 1226716769;
                case 107 -> -1397617735;
                case 108 -> 131697783;
                case 109 -> 61900284;
                case 110 -> -391514794;
                case 111 -> -1398451450;
                case 112 -> 47263625;
                case 113 -> 2016688979;
                case 114 -> 1330297812;
                case 115 -> 443115378;
                case 116 -> 1811358585;
                case 117 -> -461694673;
                case 118 -> -738976351;
                case 119 -> -461425984;
                case 120 -> 268009621;
                case 121 -> -1758232810;
                case 122 -> -338605954;
                case 123 -> -263449967;
                case 124 -> -1744751348;
                case 125 -> -1666535317;
                case 126 -> -2057847566;
                case 127 -> -2023264574;
                case 128 -> -1558444118;
                case 129 -> 417175143;
                case 130 -> 137355828;
                case 131 -> 1770772349;
                case 132 -> -1911054203;
                case 133 -> -466789410;
                case 134 -> -1003865369;
                case 135 -> -1305584670;
                case 136 -> 2101708767;
                case 137 -> 1295327900;
                case 138 -> 2041514841;
                case 139 -> -607850934;
                case 140 -> 1523124707;
                case 141 -> 911103875;
                case 142 -> 176281192;
                case 143 -> 1206850153;
                case 144 -> -594707714;
                case 145 -> 1646621336;
                case 146 -> -644813409;
                case 147 -> 1363284937;
                case 148 -> -2011935387;
                case 149 -> -258403166;
                case 150 -> 790428294;
                case 151 -> 732730260;
                case 152 -> 623896489;
                case 153 -> 1480185883;
                case 154 -> 1393251204;
                case 155 -> -1048891530;
                case 156 -> 1287208048;
                case 157 -> -1587456974;
                case 158 -> 1693540104;
                case 159 -> 2000844621;
                case 160 -> 983270923;
                case 161 -> 574294556;
                case 162 -> 664172162;
                case 163 -> -560950858;
                case 164 -> -730682017;
                case 165 -> 1333942048;
                case 166 -> -1886586327;
                case 167 -> 277556714;
                case 168 -> -726779704;
                case 169 -> -2140890813;
                case 170 -> 1901761524;
                case 171 -> -993741600;
                case 172 -> 921949400;
                case 173 -> 1697060912;
                case 174 -> -424491486;
                case 175 -> 2011024256;
                case 176 -> -1432761161;
                case 177 -> -870026022;
                case 178 -> 449207743;
                case 179 -> -1221157925;
                case 180 -> -725419158;
                case 181 -> -1884448482;
                case 182 -> 115167509;
                case 183 -> 759526054;
                case 184 -> 1110121253;
                case 185 -> -711557310;
                case 186 -> 429403803;
                case 187 -> 2069804939;
                case 188 -> -632588114;
                case 189 -> 1459043856;
                case 190 -> -678354998;
                case 191 -> -1810613389;
                case 192 -> -1888656090;
                case 193 -> 674116445;
                case 194 -> -1159456147;
                case 195 -> -753900998;
                case 196 -> -1698628094;
                case 197 -> 1723350448;
                case 198 -> 598270147;
                case 199 -> -827082440;
                case 200 -> 1441010049;
                case 201 -> -2009048950;
                case 202 -> 887145618;
                case 203 -> 184673358;
                case 204 -> 1303265085;
                case 205 -> -2070407124;
                case 206 -> 1527082607;
                case 207 -> -1495988016;
                case 208 -> 1775545828;
                case 209 -> 1063175905;
                case 210 -> -1031467953;
                case 211 -> -1843589173;
                case 212 -> 2068370542;
                case 213 -> -164288246;
                case 214 -> -1203001863;
                case 215 -> 945975732;
                case 216 -> -2057615185;
                case 217 -> -642238108;
                case 218 -> 1145079583;
                case 219 -> 337274027;
                case 220 -> 216302408;
                case 221 -> -1436729197;
                case 222 -> -258343282;
                case 223 -> -1076587120;
                case 224 -> 1648564111;
                case 225 -> 1257125868;
                case 226 -> -1067922701;
                case 227 -> -1607938244;
                case 228 -> -2011183379;
                case 229 -> -787656689;
                case 230 -> -1503655496;
                case 231 -> -1630719017;
                case 232 -> 786262714;
                case 233 -> 219350924;
                case 234 -> 615876192;
                case 235 -> -89920049;
                case 236 -> 1956884340;
                case 237 -> -1375065412;
                case 238 -> 331459156;
                case 239 -> 1679390535;
                case 240 -> 1095825740;
                case 241 -> -1329483834;
                case 242 -> 1529180766;
                case 243 -> 1461380828;
                case 244 -> 1301353496;
                case 245 -> 1512327587;
                case 246 -> -1003474803;
                case 247 -> 1719522593;
                case 248 -> 572223937;
                case 249 -> -2122182855;
                case 250 -> 409338600;
                case 251 -> 1579799807;
                case 252 -> -1460334982;
                case 253 -> -679956429;
                case 254 -> -1071434963;
                case 255 -> 1273857191;
                default -> -1547738817;
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
            Object[] objectArray2 = new Object[86];
            objectArray = objectArray2;
            aaaaag = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaf = (String)PixelLiveGameClientMod.aaaaaD((char)-546439166);
        我草你怎么反编译我模组aaaaaa = new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaab(null);
    }

    private static Object aaaaaD(char c) {
        return ((Object[])aaaaag)[c];
    }
}

