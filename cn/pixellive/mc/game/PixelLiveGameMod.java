/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.eventbus.EventBus
 *  com.mojang.brigadier.CommandDispatcher
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.file.Path
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Random
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking$Context
 *  net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
 *  net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents
 *  net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents
 *  net.fabricmc.fabric.api.event.player.AttackBlockCallback
 *  net.fabricmc.fabric.api.event.player.AttackEntityCallback
 *  net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
 *  net.fabricmc.fabric.api.event.player.UseBlockCallback
 *  net.fabricmc.fabric.api.event.player.UseItemCallback
 *  net.fabricmc.fabric.api.message.v1.ServerMessageEvents
 *  net.fabricmc.fabric.api.networking.v1.PacketSender
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1271
 *  net.minecraft.class_1282
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1439
 *  net.minecraft.class_1541
 *  net.minecraft.class_1657
 *  net.minecraft.class_1747
 *  net.minecraft.class_1750
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1934
 *  net.minecraft.class_1937
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170$class_5364
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2556$class_7602
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3244
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_4466
 *  net.minecraft.class_5218
 *  net.minecraft.class_634
 *  net.minecraft.class_7157
 *  net.minecraft.class_7471
 *  net.minecraft.class_8710
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.pixellive.mc.game;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaZ;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaadh;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaag;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaP;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaao;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabD;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabH;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabM;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabr;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabv;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacs;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaadf;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaab.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaal;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaae;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaf;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaah;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaak;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaar;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaau;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaav;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaw;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaay;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaz;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaam;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaai;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaap;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaan.aaaaad;
import cn.pixellive.mc.game.client.PixelLiveGameClientMod;
import cn.pixellive.mc.game.event.game.AttackBlockEvent;
import cn.pixellive.mc.game.event.game.BlockBreakEvent;
import cn.pixellive.mc.game.event.game.BlockPlaceEvent;
import cn.pixellive.mc.game.server.PixelLiveGameServerMod;
import com.google.common.eventbus.EventBus;
import com.mojang.brigadier.CommandDispatcher;
import java.nio.file.Path;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1271;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1439;
import net.minecraft.class_1541;
import net.minecraft.class_1657;
import net.minecraft.class_1747;
import net.minecraft.class_1750;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1934;
import net.minecraft.class_1937;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2556;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3244;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_4466;
import net.minecraft.class_5218;
import net.minecraft.class_634;
import net.minecraft.class_7157;
import net.minecraft.class_7471;
import net.minecraft.class_8710;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nPixelLiveGameMod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PixelLiveGameMod.kt\ncn/pixellive/mc/game/PixelLiveGameMod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1048:1\n1#2:1049\n800#3,11:1050\n1855#3,2:1061\n*S KotlinDebug\n*F\n+ 1 PixelLiveGameMod.kt\ncn/pixellive/mc/game/PixelLiveGameMod\n*L\n616#1:1050,11\n616#1:1061,2\n*E\n"})
public final class PixelLiveGameMod
implements ModInitializer {
    @NotNull
    public static final aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa 我草你怎么反编译我模组aaaaaa;
    @NotNull
    public static final String 我草你怎么反编译我模组aaaaab;
    public static final int 我草你怎么反编译我模组aaaaac;
    public static final int 我草你怎么反编译我模组aaaaad;
    @NotNull
    private static final EventBus 我草你怎么反编译我模组aaaaae;
    private static boolean 我草你怎么反编译我模组aaaaaf;
    @Nullable
    private static aaaaas 我草你怎么反编译我模组aaaaag;
    @Nullable
    private static class_3218 我草你怎么反编译我模组aaaaah;
    public static PixelLiveGameClientMod 我草你怎么反编译我模组aaaaai;
    static Object aaaaaj;

    public void onInitialize() {
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)145883136));
        try {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaac.你为什么要破解我的代码aaaaaa();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-673120255));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)991821826));
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaad();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)1733951491));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)1232797700));
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaaa.aaaaaa.你为什么要破解我的代码aaaaaa();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1141833723));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-145948666));
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaae.aaaaaa.你为什么要破解我的代码aaaaaa();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-115933177));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1622343672));
            this.你为什么要破解我的代码aaaaaa();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1851064311));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-2117533686));
            this.你为什么要破解我的代码aaaaac();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1751121909));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)390856716));
            CommandRegistrationCallback.EVENT.register(PixelLiveGameMod::你为什么要破解我的代码aaaaap);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1382088691));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1493630962));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameMod.aaaabd((char)-1554776049), (Throwable)exception);
            throw exception;
        }
    }

    private final void 你为什么要破解我的代码aaaaaa() {
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-976289776));
        try {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1767178223));
            aaaaal.我草你怎么反编译我模组aaaaaI.你为什么要破解我的代码aaaaag();
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaae.我草你怎么反编译我模组aaaaat.你为什么要破解我的代码aaaaag();
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaao.我草你怎么反编译我模组aaaabi.你为什么要破解我的代码aaaaag();
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaaf.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1021575150));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)1231749139));
            Object object = 我草你怎么反编译我模组aaaaag;
            if (object == null || (object = ((aaaaas)object).你为什么要破解我的代码aaaaaj()) == null) {
                object = (String)PixelLiveGameMod.aaaabd((char)-832372716);
            }
            new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaah((String)object).你为什么要破解我的代码aaaaag();
            new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaad((String)PixelLiveGameMod.aaaabd((char)-886308844)).你为什么要破解我的代码aaaaag();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)1743257621));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1768423402));
            new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa(false, 7, 7, 1, true, false).你为什么要破解我的代码aaaaag();
            new aaaaav(0, 0, 500).你为什么要破解我的代码aaaaag();
            new aaaaau(false, 25, 25, 20).你为什么要破解我的代码aaaaag();
            new aaaaar(aaaaah.我草你怎么反编译我模组aaaadg, null, 2, null).你为什么要破解我的代码aaaaag();
            new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaao(aaaaak.我草你怎么反编译我模组aaaadD, null, 2, null).你为什么要破解我的代码aaaaag();
            new aaaaaz(20, -2800, 50).你为什么要破解我的代码aaaaag();
            new aaaaaw(aaaaaf.我草你怎么反编译我模组aaaacF, null, 2, null).你为什么要破解我的代码aaaaag();
            new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaab(20, false, false, 6, null).你为什么要破解我的代码aaaaag();
            new aaaaay(aaaaaB.我草你怎么反编译我模组aaaafk, null, 2, null).你为什么要破解我的代码aaaaag();
            new aaaaae(5).你为什么要破解我的代码aaaaag();
            new DoomsdaySurvivalSettingsPayload(5, false, false, false, 12, null).register();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)339935255));
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1883963368));
            new aaaaag((String)PixelLiveGameMod.aaaabd((char)-1859977196), 1.0).你为什么要破解我的代码aaaaag();
            aaaaad.你为什么要破解我的代码aaaaab();
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)945029145));
            try {
                class_243 class_2432 = class_243.field_1353;
                Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)((String)PixelLiveGameMod.aaaabd((char)1081278490)));
                new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaaf(0.0f, class_2432, false, 4, null).你为什么要破解我的代码aaaaag();
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1180893157));
            }
            catch (Exception exception) {
                aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameMod.aaaabd((char)-1694498788), (Throwable)exception);
                throw exception;
            }
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameMod.aaaabd((char)39649308), (Throwable)exception);
            throw exception;
        }
    }

    @Environment(value=EnvType.CLIENT)
    private final void 你为什么要破解我的代码aaaaab() {
        try {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)967311389));
            ClientTickEvents.START_CLIENT_TICK.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaq);
            ClientTickEvents.END_CLIENT_TICK.register(PixelLiveGameMod::你为什么要破解我的代码aaaaar);
            ClientPlayConnectionEvents.JOIN.register(PixelLiveGameMod::你为什么要破解我的代码aaaaas);
            ClientPlayConnectionEvents.DISCONNECT.register(PixelLiveGameMod::你为什么要破解我的代码aaaaat);
            ClientPlayNetworking.registerGlobalReceiver(aaaaag.我草你怎么反编译我模组aaaaah, PixelLiveGameMod::你为什么要破解我的代码aaaaav);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1794441186));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameMod.aaaabd((char)-765001697), (Throwable)exception);
            throw exception;
        }
    }

    private final void 你为什么要破解我的代码aaaaac() {
        try {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1044316128));
            if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                this.你为什么要破解我的代码aaaaab();
            }
            ServerWorldEvents.LOAD.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaw);
            ServerTickEvents.START_SERVER_TICK.register(PixelLiveGameMod::你为什么要破解我的代码aaaaax);
            ServerTickEvents.END_SERVER_TICK.register(PixelLiveGameMod::你为什么要破解我的代码aaaaay);
            ServerPlayConnectionEvents.JOIN.register((arg_0, arg_1, arg_2) -> PixelLiveGameMod.你为什么要破解我的代码aaaaaz(this, arg_0, arg_1, arg_2));
            ServerMessageEvents.ALLOW_CHAT_MESSAGE.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaA);
            ServerLifecycleEvents.SERVER_STOPPED.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaB);
            UseBlockCallback.EVENT.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaC);
            PlayerBlockBreakEvents.AFTER.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaD);
            AttackBlockCallback.EVENT.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaE);
            ServerLivingEntityEvents.ALLOW_DEATH.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaF);
            ServerLivingEntityEvents.AFTER_DEATH.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaG);
            UseBlockCallback.EVENT.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaH);
            UseItemCallback.EVENT.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaI);
            ServerLivingEntityEvents.ALLOW_DAMAGE.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaJ);
            AttackEntityCallback.EVENT.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaK);
            ServerPlayerEvents.AFTER_RESPAWN.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaL);
            ServerEntityEvents.ENTITY_LOAD.register(PixelLiveGameMod::你为什么要破解我的代码aaaaaM);
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaap.aaaaac.你为什么要破解我的代码aaaaaa();
            System.out.println((Object)((String)PixelLiveGameMod.aaaabd((char)-616497119)));
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error((String)PixelLiveGameMod.aaaabd((char)-1679687646), (Throwable)exception);
            throw exception;
        }
    }

    private final Path 你为什么要破解我的代码aaaaad(MinecraftServer minecraftServer) {
        Path path;
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            Path path2 = minecraftServer.method_27050(class_5218.field_24188).getParent();
            Intrinsics.checkNotNull((Object)path2);
            path = path2;
        } else {
            Path path3 = FabricLoader.getInstance().getGameDir().toAbsolutePath().getParent().resolve((String)PixelLiveGameMod.aaaabd((char)-2106392541)).toAbsolutePath();
            Intrinsics.checkNotNull((Object)path3);
            path = path3;
        }
        return path;
    }

    private final void 你为什么要破解我的代码aaaaae(MinecraftServer minecraftServer, class_3222 class_32222, Path path) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 正在加入 TNT填充 游戏阶段...");
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaabM.我草你怎么反编译我模组aaaadA;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty()) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-493027292));
            aaaabM.我草你怎么反编译我模组aaaadA.你为什么要破解我的代码aaaaab(path);
            if (!PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
                aaaabM.我草你怎么反编译我模组aaaadA.你为什么要破解我的代码aaaaal(minecraftServer);
                PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-968294363));
            }
        }
        class_243 class_2432 = aaaabM.我草你怎么反编译我模组aaaadA.你为什么要破解我的代码aaaabQ();
        aaaaam.你为什么要破解我的代码aaaaaa(class_32222, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 已传送至出生点 (" + class_2432.field_1352 + ", " + class_2432.field_1351 + ", " + class_2432.field_1350 + ")");
    }

    private final void 你为什么要破解我的代码aaaaaf(MinecraftServer minecraftServer, class_3222 class_32222) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 正在加入生存挑战游戏阶段...");
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaabv.我草你怎么反编译我模组aaaacL;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty() && !PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-2066481114));
            aaaabv.我草你怎么反编译我模组aaaacL.你为什么要破解我的代码aaaaal(minecraftServer);
            PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1534853081));
        }
    }

    private final void 你为什么要破解我的代码aaaaag(MinecraftServer minecraftServer, class_3222 class_32222) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 正在加入勇攀高峰游戏阶段...");
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaaaP.我草你怎么反编译我模组aaaabK;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty() && !PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)454164520));
            aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaaal(minecraftServer);
            PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1701248983));
        }
        class_243 class_2432 = aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaabQ();
        class_32222.method_6082(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, true);
        class_32222.method_7336(class_1934.field_9216);
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 已传送至出生点 (" + class_2432.field_1352 + ", " + class_2432.field_1351 + ", " + class_2432.field_1350 + ")");
    }

    private final void 你为什么要破解我的代码aaaaah(MinecraftServer minecraftServer, class_3222 class_32222, Path path) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 正在加入天天跑酷游戏阶段...");
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaabH.我草你怎么反编译我模组aaaadh;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty() && !PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-2080047062));
            aaaabH.我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaal(minecraftServer);
            PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1850867669));
        }
        class_243 class_2432 = aaaabH.我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaabQ();
        class_32222.method_6082(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, true);
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 已传送至出生点 (" + class_2432.field_1352 + ", " + class_2432.field_1351 + ", " + class_2432.field_1350 + ")");
    }

    private final void 你为什么要破解我的代码aaaaai(MinecraftServer minecraftServer, class_3222 class_32222, Path path) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 正在加入保卫小麦游戏阶段...");
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaacs.我草你怎么反编译我模组aaaaep;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty()) {
            aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaab(path);
            if (!PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-604831700));
                aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaal(minecraftServer);
                PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)1468071981));
            }
        } else {
            aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaadO(class_32222);
            aaaaab.你为什么要破解我的代码aaaaaa().info("已为玩家 " + class_32222.method_5477().getString() + " 填充物品栏");
        }
        class_243 class_2432 = aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaabQ();
        class_32222.method_6082(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, true);
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 已传送至出生点 (" + class_2432.field_1352 + ", " + class_2432.field_1351 + ", " + class_2432.field_1350 + ")");
    }

    private final void 你为什么要破解我的代码aaaaaj(MinecraftServer minecraftServer, class_3222 class_32222, Path path) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 正在加入怪兽竞技场游戏阶段...");
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaadf.我草你怎么反编译我模组aaaaeK;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty() && !PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1006567378));
            aaaadf.我草你怎么反编译我模组aaaaeK.你为什么要破解我的代码aaaaal(minecraftServer);
            PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-275447761));
        }
    }

    private final void 你为什么要破解我的代码aaaaak(MinecraftServer minecraftServer, class_3222 class_32222, Path path) {
        block2: {
            aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad.我草你怎么反编译我模组aaaaaa;
            Intrinsics.checkNotNull((Object)aaaaas2);
            aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(path);
            if (minecraftServer.method_3760().method_14571().isEmpty() && !PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaal(minecraftServer);
                PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
            }
            class_3222 class_32223 = class_32222;
            if (class_32223 != null) {
                class_32223.method_7336(class_1934.field_9216);
            }
            class_243 class_2432 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaabQ();
            class_3222 class_32224 = class_32222;
            if (class_32224 == null) break block2;
            class_32224.method_6082(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, true);
        }
    }

    private final void 你为什么要破解我的代码aaaaal(MinecraftServer minecraftServer, class_3222 class_32222, Path path) {
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaabD.我草你怎么反编译我模组aaaacN;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty() && !PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
            aaaabD.我草你怎么反编译我模组aaaacN.你为什么要破解我的代码aaaaal(minecraftServer);
            PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
        }
    }

    private final void 你为什么要破解我的代码aaaaam(MinecraftServer minecraftServer, class_3222 class_32222, Path path) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 正在加入建筑守卫战游戏阶段...");
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaaao.我草你怎么反编译我模组aaaabo;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty() && !PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-272957392));
            aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaaal(minecraftServer);
            PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-2021785551));
        }
        class_243 class_2432 = aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaabQ();
        class_32222.method_6082(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, true);
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 已传送至出生点 (" + class_2432.field_1352 + ", " + class_2432.field_1351 + ", " + class_2432.field_1350 + ")");
        minecraftServer.execute(() -> PixelLiveGameMod.你为什么要破解我的代码aaaaaN(class_32222));
    }

    private final void 你为什么要破解我的代码aaaaan(MinecraftServer minecraftServer, class_3222 class_32222, Path path) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 正在加入末日求生游戏阶段...");
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag = (aaaaas)aaaabr.我草你怎么反编译我模组aaaacj;
        Intrinsics.checkNotNull((Object)aaaaas2);
        aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        if (minecraftServer.method_3760().method_14571().isEmpty()) {
            aaaabr.我草你怎么反编译我模组aaaacj.你为什么要破解我的代码aaaaab(path);
            if (!PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) {
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)659226674));
                aaaabr.我草你怎么反编译我模组aaaacj.你为什么要破解我的代码aaaaal(minecraftServer);
                PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(true);
                aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1455292365));
            }
        }
        class_32222.method_6033(class_32222.method_6063());
        class_32222.method_7344().method_7580(20);
        class_32222.method_7344().method_7581(0.0f);
        class_32222.method_6092(new class_1293(class_1294.field_5925, 999999, 0, false, false));
        class_32222.method_7336(class_1934.field_9216);
        class_243 class_2432 = aaaabr.我草你怎么反编译我模组aaaacj.你为什么要破解我的代码aaaabQ();
        class_32222.method_6082(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, true);
        aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + class_32222.method_5477().getString() + " 已传送至出生点 (" + class_2432.field_1352 + ", " + class_2432.field_1351 + ", " + class_2432.field_1350 + ")");
    }

    private final Pair<String, String> 你为什么要破解我的代码aaaaao() {
        String string = switch (aaaaac.我草你怎么反编译我模组aaaaaa[aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa().ordinal()]) {
            case 1 -> (String)PixelLiveGameMod.aaaabd((char)43319348);
            case 2 -> (String)PixelLiveGameMod.aaaabd((char)1547763765);
            case 3 -> (String)PixelLiveGameMod.aaaabd((char)-1898905546);
            case 4 -> (String)PixelLiveGameMod.aaaabd((char)1103429687);
            default -> throw new NoWhenBranchMatchedException();
        };
        String string2 = switch (aaaaac.我草你怎么反编译我模组aaaaaa[aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaa().ordinal()]) {
            case 1 -> aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac();
            case 2 -> aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaae();
            case 3 -> aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaai();
            case 4 -> aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.Companion.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaau();
            default -> throw new NoWhenBranchMatchedException();
        };
        aaaaab.你为什么要破解我的代码aaaaaa().info("获取平台信息 - 平台: " + string + ", 房间ID: " + string2);
        return new Pair((Object)string, (Object)string2);
    }

    private static final void 你为什么要破解我的代码aaaaap(CommandDispatcher commandDispatcher, class_7157 class_71572, class_2170.class_5364 class_53642) {
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaag.aaaaah.aaaaaa.你为什么要破解我的代码aaaaaa((CommandDispatcher<class_2168>)commandDispatcher);
    }

    private static final void 你为什么要破解我的代码aaaaaq(class_310 class_3102) {
        Intrinsics.checkNotNull((Object)class_3102);
        我草你怎么反编译我模组aaaaae.post((Object)new aaaaaa(class_3102));
    }

    private static final void 你为什么要破解我的代码aaaaar(class_310 class_3102) {
        Intrinsics.checkNotNull((Object)class_3102);
        我草你怎么反编译我模组aaaaae.post((Object)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaab.aaaaab(class_3102));
    }

    private static final void 你为什么要破解我的代码aaaaas(class_634 class_6342, PacketSender packetSender, class_310 class_3102) {
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)1203961912));
        我草你怎么反编译我模组aaaaaf = !class_6342.method_48296().method_10756();
        List<String> list = aaaaap.我草你怎么反编译我模组aaaaaa;
        Intrinsics.checkNotNullExpressionValue(list, (String)((String)PixelLiveGameMod.aaaabd((char)1948057657)));
        ClientPlayNetworking.send((class_8710)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaac(list));
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1760362438));
    }

    private static final void 你为什么要破解我的代码aaaaat(class_634 class_6342, class_310 class_3102) {
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1643904965));
        aaaaad.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaah();
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
        if (aaaaas2 != null) {
            aaaaas aaaaas3 = 我草你怎么反编译我模组aaaaag;
            Intrinsics.checkNotNull((Object)aaaaas3);
            aaaaas2.你为什么要破解我的代码aaaaam(aaaaas3.你为什么要破解我的代码aaaabR());
        }
        我草你怎么反编译我模组aaaaag = null;
        我草你怎么反编译我模组aaaaah = null;
        我草你怎么反编译我模组aaaaaf = false;
    }

    private static final void 你为什么要破解我的代码aaaaau(aaaaag aaaaag2) {
        Intrinsics.checkNotNullParameter((Object)aaaaag2, (String)((String)PixelLiveGameMod.aaaabd((char)-1424097220)));
        aaaaab.你为什么要破解我的代码aaaaaa().info("播放音效: " + aaaaag2.你为什么要破解我的代码aaaado());
        aaaaad.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaaf(aaaaag2.你为什么要破解我的代码aaaado(), aaaaag2.你为什么要破解我的代码aaaadp());
    }

    private static final void 你为什么要破解我的代码aaaaav(aaaaag aaaaag2, ClientPlayNetworking.Context context) {
        Intrinsics.checkNotNullParameter((Object)aaaaag2, (String)((String)PixelLiveGameMod.aaaabd((char)-807534531)));
        Intrinsics.checkNotNullParameter((Object)context, (String)((String)PixelLiveGameMod.aaaabd((char)-2065301442)));
        class_310.method_1551().execute(() -> PixelLiveGameMod.你为什么要破解我的代码aaaaau(aaaaag2));
    }

    private static final void 你为什么要破解我的代码aaaaaw(MinecraftServer minecraftServer, class_3218 class_32182) {
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)270532671));
        Intrinsics.checkNotNull((Object)minecraftServer);
        Intrinsics.checkNotNull((Object)class_32182);
        我草你怎么反编译我模组aaaaae.post((Object)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaaa(minecraftServer, (class_1937)class_32182));
    }

    private static final void 你为什么要破解我的代码aaaaax(MinecraftServer minecraftServer) {
        Intrinsics.checkNotNull((Object)minecraftServer);
        我草你怎么反编译我模组aaaaae.post((Object)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaaf(minecraftServer));
    }

    private static final void 你为什么要破解我的代码aaaaay(MinecraftServer minecraftServer) {
        Intrinsics.checkNotNull((Object)minecraftServer);
        我草你怎么反编译我模组aaaaae.post((Object)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaad(minecraftServer));
    }

    /*
     * Unable to fully structure code
     */
    private static final void 你为什么要破解我的代码aaaaaz(PixelLiveGameMod var0, class_3244 var1_1, PacketSender var2_2, MinecraftServer var3_3) {
        block24: {
            block28: {
                block30: {
                    block33: {
                        block27: {
                            block31: {
                                block26: {
                                    block29: {
                                        block32: {
                                            block25: {
                                                Intrinsics.checkNotNullParameter((Object)var0, (String)((String)PixelLiveGameMod.aaaabd((char)440795200)));
                                                var4_4 = var1_1.field_14140;
                                                aaaaab.你为什么要破解我的代码aaaaaa().info("玩家 " + var4_4.method_5477().getString() + " 加入服务器");
                                                aaaaad.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaai();
                                                Intrinsics.checkNotNull((Object)var3_3);
                                                var5_5 = var0.你为什么要破解我的代码aaaaad(var3_3);
                                                var6_6 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaak.aaaaaa.你为什么要破解我的代码aaaaaa(var5_5);
                                                if (var6_6 != null) {
                                                    var7_7 = var0.你为什么要破解我的代码aaaaao();
                                                    var8_8 = (String)var7_7.component1();
                                                    var9_9 = (String)var7_7.component2();
                                                    aaaaai.你为什么要破解我的代码aaaaac(var9_9, var8_8, var6_6);
                                                    aaaaab.你为什么要破解我的代码aaaaaa().info("游戏阶段记录已发送: " + var6_6);
                                                }
                                                if ((var7_7 = var6_6) == null) break block24;
                                                switch (var7_7.hashCode()) {
                                                    case 916506880: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-1509949375)))) {
                                                            ** break;
                                                        }
                                                        break block25;
                                                    }
                                                    case 1912904869: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-1808727998)))) {
                                                            ** break;
                                                        }
                                                        break block26;
                                                    }
                                                    case 1121163920: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-923271101)))) {
                                                            ** break;
                                                        }
                                                        break block27;
                                                    }
                                                    case 812766903: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-524353468)))) {
                                                            ** break;
                                                        }
                                                        break block28;
                                                    }
                                                    case 630370341: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)1970274373)))) {
                                                            ** break;
                                                        }
                                                        break block29;
                                                    }
                                                    case 1943330462: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-1843658682)))) {
                                                            ** break;
                                                        }
                                                        break block30;
                                                    }
                                                    case 80702676: {
                                                        if (var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)1793982535)))) break;
                                                        ** break;
                                                    }
                                                    case 1902430713: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)2037645384)))) {
                                                            ** break;
                                                        }
                                                        break block31;
                                                    }
                                                    case 657401329: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-1957494711)))) {
                                                            ** break;
                                                        }
                                                        break block32;
                                                    }
                                                    case 703077094: {
                                                        if (!var7_7.equals((Object)((String)PixelLiveGameMod.aaaabd((char)209911882)))) {
                                                            ** break;
                                                        }
                                                        break block33;
                                                    }
                                                }
                                                Intrinsics.checkNotNull((Object)var4_4);
                                                var0.你为什么要破解我的代码aaaaae(var3_3, var4_4, var5_5);
                                                ** break;
                                            }
                                            Intrinsics.checkNotNull((Object)var4_4);
                                            var0.你为什么要破解我的代码aaaaaf(var3_3, var4_4);
                                            ** break;
                                        }
                                        Intrinsics.checkNotNull((Object)var4_4);
                                        var0.你为什么要破解我的代码aaaaag(var3_3, var4_4);
                                        ** break;
                                    }
                                    Intrinsics.checkNotNull((Object)var4_4);
                                    var0.你为什么要破解我的代码aaaaai(var3_3, var4_4, var5_5);
                                    ** break;
                                }
                                Intrinsics.checkNotNull((Object)var4_4);
                                var0.你为什么要破解我的代码aaaaaj(var3_3, var4_4, var5_5);
                                ** break;
                            }
                            Intrinsics.checkNotNull((Object)var4_4);
                            var0.你为什么要破解我的代码aaaaal(var3_3, var4_4, var5_5);
                            ** break;
                        }
                        var0.你为什么要破解我的代码aaaaak(var3_3, var4_4, var5_5);
                        ** break;
                    }
                    Intrinsics.checkNotNull((Object)var4_4);
                    var0.你为什么要破解我的代码aaaaah(var3_3, var4_4, var5_5);
                    ** break;
                }
                Intrinsics.checkNotNull((Object)var4_4);
                var0.你为什么要破解我的代码aaaaam(var3_3, var4_4, var5_5);
                ** break;
            }
            Intrinsics.checkNotNull((Object)var4_4);
            var0.你为什么要破解我的代码aaaaan(var3_3, var4_4, var5_5);
        }
        if (var6_6 != null) {
            aaaaab.你为什么要破解我的代码aaaaaa().info("加载音乐配置: " + var6_6);
            aaaaaZ.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad((String)var6_6);
        }
        if ((v0 = PixelLiveGameMod.我草你怎么反编译我模组aaaaag) == null || (v0 = v0.你为什么要破解我的代码aaaaaj()) == null) {
            v0 = (String)PixelLiveGameMod.aaaabd((char)-1174929388);
        }
        ServerPlayNetworking.send((class_3222)var4_4, (class_8710)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaah((String)v0));
        Intrinsics.checkNotNull((Object)var1_1);
        Intrinsics.checkNotNull((Object)var2_2);
        PixelLiveGameMod.我草你怎么反编译我模组aaaaae.post((Object)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaab(var1_1, var2_2, var3_3));
    }

    private static final boolean 你为什么要破解我的代码aaaaaA(class_7471 class_74712, class_3222 class_32222, class_2556.class_7602 class_76022) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("聊天消息: " + class_32222.method_5477().getString() + ": " + class_74712);
        Intrinsics.checkNotNull((Object)class_74712);
        Intrinsics.checkNotNull((Object)class_32222);
        Intrinsics.checkNotNull((Object)class_76022);
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaac aaaaac2 = new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaac(class_74712, class_32222, class_76022);
        我草你怎么反编译我模组aaaaae.post((Object)aaaaac2);
        return !aaaaac2.getCancelled();
    }

    private static final void 你为什么要破解我的代码aaaaaB(MinecraftServer minecraftServer) {
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-618266549));
        aaaaad.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaah();
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
            if (aaaaas2 != null) {
                Intrinsics.checkNotNull((Object)minecraftServer);
                aaaaas2.你为什么要破解我的代码aaaaam(minecraftServer);
            }
            我草你怎么反编译我模组aaaaag = null;
            PixelLiveGameServerMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaab(false);
        }
        Intrinsics.checkNotNull((Object)minecraftServer);
        我草你怎么反编译我模组aaaaae.post((Object)new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaae(minecraftServer));
    }

    private static final class_1269 你为什么要破解我的代码aaaaaC(class_1657 class_16572, class_1937 class_19372, class_1268 class_12682, class_3965 class_39652) {
        class_1799 class_17992 = class_16572.method_5998(class_12682);
        if (class_17992.method_7909() instanceof class_1747) {
            class_1750 class_17502 = new class_1750(class_16572, class_12682, class_17992, class_39652);
            BlockPlaceEvent blockPlaceEvent = new BlockPlaceEvent(class_17502, null, 2, null);
            我草你怎么反编译我模组aaaaae.post((Object)blockPlaceEvent);
            aaaaab.你为什么要破解我的代码aaaaaa().info("方块放置事件: " + class_16572.method_5477().getString());
            class_1269 class_12692 = blockPlaceEvent.getResult();
            if (class_12692 == null) {
                class_12692 = class_1269.field_5811;
            }
            return class_12692;
        }
        return class_1269.field_5811;
    }

    private static final void 你为什么要破解我的代码aaaaaD(class_1937 class_19372, class_1657 class_16572, class_2338 class_23382, class_2680 class_26802, class_2586 class_25862) {
        BlockBreakEvent blockBreakEvent;
        aaaaab.你为什么要破解我的代码aaaaaa().info("方块破坏事件: " + class_16572.method_5477().getString() + " at " + class_23382);
        class_1937 class_19373 = class_19372;
        if (class_19373 != null) {
            class_1937 class_19374 = class_19373;
            boolean bl = false;
            class_2680 class_26803 = class_26802;
            if (class_26803 != null) {
                class_2680 class_26804 = class_26803;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)class_16572);
                Intrinsics.checkNotNull((Object)class_23382);
                class_2248 class_22482 = class_26804.method_26204();
                Intrinsics.checkNotNullExpressionValue((Object)class_22482, (String)((String)PixelLiveGameMod.aaaabd((char)1719664716)));
                v3 = new BlockBreakEvent(class_16572, class_19374, class_23382, class_22482);
            } else {
                v3 = null;
            }
        } else {
            v3 = blockBreakEvent = null;
        }
        if (blockBreakEvent != null) {
            我草你怎么反编译我模组aaaaae.post(blockBreakEvent);
        }
    }

    private static final class_1269 你为什么要破解我的代码aaaaaE(class_1657 class_16572, class_1937 class_19372, class_1268 class_12682, class_2338 class_23382, class_2350 class_23502) {
        class_1269 class_12692;
        Intrinsics.checkNotNull((Object)class_16572);
        Intrinsics.checkNotNull((Object)class_19372);
        Intrinsics.checkNotNull((Object)class_23382);
        AttackBlockEvent attackBlockEvent = new AttackBlockEvent(class_16572, class_19372, class_23382);
        我草你怎么反编译我模组aaaaae.post((Object)attackBlockEvent);
        if (!aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaae(class_16572, class_19372, class_23382)) {
            aaaaab.你为什么要破解我的代码aaaaaa().info("阻止方块破坏: " + class_16572.method_5477().getString() + " at " + class_23382);
            class_12692 = class_1269.field_5814;
        } else {
            class_12692 = class_1269.field_5811;
        }
        return class_12692;
    }

    /*
     * WARNING - bad return control flow
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean 你为什么要破解我的代码aaaaaF(class_1309 class_13092, class_1282 class_12822, float f) {
        block13: {
            block15: {
                block17: {
                    block18: {
                        block14: {
                            block16: {
                                if (!(class_13092 instanceof class_3222)) break block13;
                                aaaaab.你为什么要破解我的代码aaaaaa().info("玩家死亡事件: " + ((class_3222)class_13092).method_5477().getString());
                                aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
                                if (aaaaas2 == null) return true;
                                String string = aaaaas2.你为什么要破解我的代码aaaaaj();
                                String string2 = string;
                                if (string2 == null) return true;
                                switch (string2.hashCode()) {
                                    case 1121163920: {
                                        if (!string2.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-95682493)))) {
                                            return true;
                                        }
                                        break block14;
                                    }
                                    case 812766903: {
                                        if (!string2.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-1562705852)))) {
                                            return true;
                                        }
                                        break block15;
                                    }
                                    case 630370341: {
                                        if (!string2.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-1838546875)))) {
                                            return true;
                                        }
                                        break block16;
                                    }
                                    case 1943330462: {
                                        if (!string2.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-815988666)))) {
                                            return true;
                                        }
                                        break block17;
                                    }
                                    case 657401329: {
                                        if (string2.equals((Object)((String)PixelLiveGameMod.aaaabd((char)847708233)))) break;
                                        return true;
                                    }
                                    case 703077094: {
                                        if (!string2.equals((Object)((String)PixelLiveGameMod.aaaabd((char)157483082)))) {
                                            return true;
                                        }
                                        break block18;
                                    }
                                }
                                aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaabJ((class_3222)class_13092);
                                return false;
                            }
                            aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaabJ((class_3222)class_13092);
                            return false;
                        }
                        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaabJ((class_3222)class_13092);
                        return false;
                    }
                    aaaabH.我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaabJ((class_3222)class_13092);
                    return false;
                }
                aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaabJ((class_3222)class_13092);
                return false;
            }
            aaaabr.我草你怎么反编译我模组aaaacj.你为什么要破解我的代码aaaabJ((class_3222)class_13092);
            return false;
            return true;
        }
        aaaaas aaaaas3 = 我草你怎么反编译我模组aaaaag;
        if (!Intrinsics.areEqual((Object)(aaaaas3 != null ? aaaaas3.你为什么要破解我的代码aaaaaj() : null), (Object)((String)PixelLiveGameMod.aaaabd((char)-1070792636)))) return true;
        String string = class_1299.method_5890((class_1299)class_13092.method_5864()).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)PixelLiveGameMod.aaaabd((char)-464781235)));
        String string3 = string;
        return true;
    }

    private static final void 你为什么要破解我的代码aaaaaG(class_1309 class_13092, class_1282 class_12822) {
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
        if (Intrinsics.areEqual((Object)(aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null), (Object)((String)PixelLiveGameMod.aaaabd((char)375455812)))) {
            Intrinsics.checkNotNull((Object)class_13092);
            Intrinsics.checkNotNull((Object)class_12822);
            aaaabr.我草你怎么反编译我模组aaaacj.你为什么要破解我的代码aaaagj(class_13092, class_12822);
        }
    }

    private static final class_1269 你为什么要破解我的代码aaaaaH(class_1657 class_16572, class_1937 class_19372, class_1268 class_12682, class_3965 class_39652) {
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
        if (StringsKt.equals$default((String)(aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null), (String)((String)PixelLiveGameMod.aaaabd((char)-1813446587)), (boolean)false, (int)2, null)) {
            class_1799 class_17992 = class_16572.method_5998(class_12682);
            if (class_16572 instanceof class_3222) {
                class_2338 class_23382 = class_39652.method_17777();
                Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)((String)PixelLiveGameMod.aaaabd((char)-1540620210)));
                if (aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaana(class_23382)) {
                    class_1792 class_17922 = class_17992.method_7909();
                    if (Intrinsics.areEqual((Object)class_17922, (Object)class_1802.field_8436)) {
                        aaaaab.你为什么要破解我的代码aaaaaa().info("使用喷溅药水: " + ((class_3222)class_16572).method_5477().getString());
                        class_3222 class_32222 = (class_3222)class_16572;
                        Intrinsics.checkNotNull((Object)class_39652);
                        aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaamU(class_32222, class_39652);
                        return class_1269.field_5814;
                    }
                    if (Intrinsics.areEqual((Object)class_17922, (Object)class_1802.field_8317)) {
                        aaaaab.你为什么要破解我的代码aaaaaa().info("种植小麦: " + ((class_3222)class_16572).method_5477().getString());
                        class_3222 class_32223 = (class_3222)class_16572;
                        Intrinsics.checkNotNull((Object)class_39652);
                        aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaamV(class_32223, class_39652);
                        return class_1269.field_5814;
                    }
                    if (Intrinsics.areEqual((Object)class_17922, (Object)class_1802.field_8324)) {
                        aaaaab.你为什么要破解我的代码aaaaaa().info("使用骨粉: " + ((class_3222)class_16572).method_5477().getString());
                        class_3222 class_32224 = (class_3222)class_16572;
                        Intrinsics.checkNotNull((Object)class_39652);
                        aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaamW(class_32224, class_39652);
                        return class_1269.field_5814;
                    }
                }
            }
        }
        return class_1269.field_5811;
    }

    private static final class_1271 你为什么要破解我的代码aaaaaI(class_1657 class_16572, class_1937 class_19372, class_1268 class_12682) {
        class_1271 class_12712;
        class_1799 class_17992 = class_16572.method_5998(class_12682);
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
        if (StringsKt.equals$default((String)(aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null), (String)((String)PixelLiveGameMod.aaaabd((char)-1316683707)), (boolean)false, (int)2, null)) {
            if (Intrinsics.areEqual((Object)class_17992.method_7909(), (Object)class_1802.field_8436)) {
                aaaaab.你为什么要破解我的代码aaaaaa().info("使用喷溅药水物品: " + class_16572.method_5477().getString());
                class_12712 = class_1271.method_22427((Object)class_17992);
            } else {
                class_12712 = class_1271.method_22430((Object)class_17992);
            }
        } else {
            aaaaas aaaaas3 = 我草你怎么反编译我模组aaaaag;
            if (StringsKt.equals$default((String)(aaaaas3 != null ? aaaaas3.你为什么要破解我的代码aaaaaj() : null), (String)((String)PixelLiveGameMod.aaaabd((char)-1187839930)), (boolean)false, (int)2, null)) {
                if (Intrinsics.areEqual((Object)class_17992.method_7909(), (Object)class_1802.field_8436)) {
                    class_2338 class_23382 = class_16572.method_24515();
                    Intrinsics.checkNotNull((Object)class_23382);
                    aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaadk(class_23382);
                    class_12712 = class_1271.method_22427((Object)class_17992);
                } else {
                    class_12712 = class_1271.method_22430((Object)class_17992);
                }
            } else {
                class_12712 = class_1271.method_22430((Object)class_17992);
            }
        }
        return class_12712;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final boolean 你为什么要破解我的代码aaaaaJ(class_1309 var0, class_1282 var1_1, float var2_2) {
        block15: {
            block12: {
                block14: {
                    block13: {
                        v0 = PixelLiveGameMod.我草你怎么反编译我模组aaaaag;
                        v1 = var3_3 = v0 != null ? v0.你为什么要破解我的代码aaaaaj() : null;
                        if (var3_3 == null) break block12;
                        switch (var3_3.hashCode()) {
                            case 1121163920: {
                                if (!var3_3.equals((Object)((String)PixelLiveGameMod.aaaabd((char)2145714243)))) {
                                    ** break;
                                }
                                break block13;
                            }
                            case 630370341: {
                                if (var3_3.equals((Object)((String)PixelLiveGameMod.aaaabd((char)-950861755)))) break;
                                ** break;
                            }
                            case 1943330462: {
                                if (!var3_3.equals((Object)((String)PixelLiveGameMod.aaaabd((char)985923654)))) {
                                    ** break;
                                }
                                break block14;
                            }
                        }
                        if (var0 instanceof class_3222 && var1_1.method_5526() instanceof class_4466) {
                            aaaaab.你为什么要破解我的代码aaaaaa().info("蜜蜂攻击玩家: " + ((class_3222)var0).method_5477().getString());
                            var0.method_6092(new class_1293(class_1294.field_5899, 200, 2));
                            v2 = var1_1.method_5526();
                            Intrinsics.checkNotNull((Object)v2, (String)((String)PixelLiveGameMod.aaaabd((char)-1836253105)));
                            var4_5 = (class_4466)v2;
                            var4_5.method_5768();
                        }
                        v3 = true;
                        break block15;
                    }
                    v4 = class_1299.method_5890((class_1299)var0.method_5864()).toString();
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)((String)PixelLiveGameMod.aaaabd((char)-1445527475)));
                    var4_5 = v4;
                    v5 = var5_7 = var0 instanceof class_1439 != false || Intrinsics.areEqual((Object)var4_5, (Object)((String)PixelLiveGameMod.aaaabd((char)-613482416))) != false;
                    v3 = !var5_7 || !(var1_1.method_5529() instanceof class_3222);
                    break block15;
                }
                if (var0 instanceof class_3222 && var1_1.method_5526() instanceof class_4466) {
                    aaaaab.你为什么要破解我的代码aaaaaa().info("蜜蜂攻击玩家: " + ((class_3222)var0).method_5477().getString());
                    var0.method_6092(new class_1293(class_1294.field_5899, 200, 2));
                    v6 = var1_1.method_5526();
                    Intrinsics.checkNotNull((Object)v6, (String)((String)PixelLiveGameMod.aaaabd((char)1807155279)));
                    var4_5 = (class_4466)v6;
                    var4_5.method_5768();
                }
                v3 = true;
                break block15;
            }
            v3 = var6_9 = true;
        }
        if (var6_9 && var1_1.method_5529() instanceof class_3222 && !(var0 instanceof class_1657)) {
            var3_4 = var0.method_17681();
            var4_6 = var0.method_17682();
            var5_8 = new Random();
            var7_10 = var0.method_23317() - (double)(var3_4 / (float)2) + var5_8.nextDouble() * (double)var3_4;
            var9_11 = var0.method_23318() + var5_8.nextDouble() * (double)var4_6;
            var11_12 = var0.method_23321() - (double)(var3_4 / (float)2) + var5_8.nextDouble() * (double)var3_4;
            var13_13 = new class_243(var7_10, var9_11, var11_12);
            var14_14 = var0.method_6032() - var2_2 <= 0.0f;
            var15_15 = new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaaf(var2_2, var13_13, var14_14);
            v7 = var0.method_37908().method_18456();
            Intrinsics.checkNotNullExpressionValue((Object)v7, (String)((String)PixelLiveGameMod.aaaabd((char)217645137)));
            var16_16 = (Iterable)v7;
            var17_17 = false;
            var18_18 = var16_16;
            var19_19 /* !! */  = (Collection)new ArrayList();
            var20_20 = false;
            for (Object var22_24 : var18_18) {
                if (!(var22_24 instanceof class_3222)) continue;
                var19_19 /* !! */ .add(var22_24);
            }
            var16_16 = (Iterable)((List)var19_19 /* !! */ );
            var17_17 = false;
            for (Collection var19_19 : var16_16) {
                var20_21 = (class_3222)var19_19 /* !! */ ;
                var21_23 = false;
                ServerPlayNetworking.send((class_3222)var20_21, (class_8710)var15_15);
            }
        }
        return var6_9;
    }

    private static final class_1269 你为什么要破解我的代码aaaaaK(class_1657 class_16572, class_1937 class_19372, class_1268 class_12682, class_1297 class_12972, class_3966 class_39662) {
        String string = class_1299.method_5890((class_1299)class_12972.method_5864()).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)PixelLiveGameMod.aaaabd((char)-539099059)));
        String string2 = string;
        aaaaab.你为什么要破解我的代码aaaaaa().info("Entity ID: " + string2);
        boolean bl = class_12972 instanceof class_1439 || Intrinsics.areEqual((Object)string2, (Object)((String)PixelLiveGameMod.aaaabd((char)1773862992)));
        aaaaab.你为什么要破解我的代码aaaaaa().info("Is Golem: " + bl);
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
        return Intrinsics.areEqual((Object)(aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null), (Object)((String)PixelLiveGameMod.aaaabd((char)1898119235))) && class_16572 instanceof class_3222 && bl ? class_1269.field_5814 : class_1269.field_5811;
    }

    private static final void 你为什么要破解我的代码aaaaaL(class_3222 class_32222, class_3222 class_32223, boolean bl) {
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
        if (StringsKt.equals$default((String)(aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null), (String)((String)PixelLiveGameMod.aaaabd((char)411828289)), (boolean)false, (int)2, null) && !bl) {
            aaaaab.你为什么要破解我的代码aaaaaa().info("玩家重生: " + class_32223.method_5477().getString());
            Intrinsics.checkNotNull((Object)class_32223);
            aaaabv.我草你怎么反编译我模组aaaacL.你为什么要破解我的代码aaaahN(class_32223);
        }
    }

    private static final void 你为什么要破解我的代码aaaaaM(class_1297 class_12972, class_3218 class_32182) {
        aaaaas aaaaas2 = 我草你怎么反编译我模组aaaaag;
        if (StringsKt.equals$default((String)(aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null), (String)((String)PixelLiveGameMod.aaaabd((char)-1374617535)), (boolean)false, (int)2, null) && Intrinsics.areEqual((Object)class_12972.method_5864(), (Object)class_1299.field_6063)) {
            Intrinsics.checkNotNull((Object)class_12972, (String)((String)PixelLiveGameMod.aaaabd((char)-1278934958)));
            class_1541 class_15412 = (class_1541)class_12972;
            class_15412.method_6967(40);
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)PixelLiveGameMod.aaaabd((char)-1966538669));
        }
    }

    private static final void 你为什么要破解我的代码aaaaaN(class_3222 class_32222) {
        Intrinsics.checkNotNullParameter((Object)class_32222, (String)((String)PixelLiveGameMod.aaaabd((char)-229834668)));
        aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaadO(class_32222);
        aaaaab.你为什么要破解我的代码aaaaaa().info("已为玩家 " + class_32222.method_5477().getString() + " 填充物品栏");
    }

    @NotNull
    public static final EventBus 你为什么要破解我的代码aaaaaO() {
        return 我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa();
    }

    public static final boolean 你为什么要破解我的代码aaaaaP() {
        return 我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaac();
    }

    public static final void 你为什么要破解我的代码aaaaaQ(boolean bl) {
        我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(bl);
    }

    @Nullable
    public static final aaaaas 你为什么要破解我的代码aaaaaR() {
        return 我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
    }

    public static final void 你为什么要破解我的代码aaaaaS(@Nullable aaaaas aaaaas2) {
        我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaag(aaaaas2);
    }

    @Nullable
    public static final class_3218 你为什么要破解我的代码aaaaaT() {
        return 我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaai();
    }

    @JvmStatic
    public static final void 你为什么要破解我的代码aaaaaU(@NotNull class_3218 class_32182) {
        我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaak(class_32182);
    }

    @JvmStatic
    public static final void 你为什么要破解我的代码aaaaaV() {
        我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaal();
    }

    public static final /* synthetic */ EventBus 你为什么要破解我的代码aaaaaW() {
        return 我草你怎么反编译我模组aaaaae;
    }

    public static final /* synthetic */ boolean 你为什么要破解我的代码aaaaaX() {
        return 我草你怎么反编译我模组aaaaaf;
    }

    public static final /* synthetic */ void 你为什么要破解我的代码aaaaaY(boolean bl) {
        我草你怎么反编译我模组aaaaaf = bl;
    }

    public static final /* synthetic */ aaaaas 你为什么要破解我的代码aaaaaZ() {
        return 我草你怎么反编译我模组aaaaag;
    }

    public static final /* synthetic */ void 你为什么要破解我的代码aaaaba(aaaaas aaaaas2) {
        我草你怎么反编译我模组aaaaag = aaaaas2;
    }

    public static final /* synthetic */ class_3218 你为什么要破解我的代码aaaabb() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public static final /* synthetic */ void 你为什么要破解我的代码aaaabc(class_3218 class_32182) {
        我草你怎么反编译我模组aaaaah = class_32182;
    }

    static {
        byte[] byArray = " O3y1ù{ñV]ï'ë÷ºÊ×6\bDÂóKE¬rµ]àÃ²æGêºJ8b.Âú*ÝX#6*ÀÒ×8ñÊ÷^ÿ(\b+öÐìM¸lô¡CT\\238Ó ê+\rÍÒþdóòèÍr½^½Ü¼PqÄÛãó©«FÂ\b¾²`k?>9jêð¾ Æéåt:w ¨Å7oRUÁgµUÌ!vÊ¬|³a:uº5ÄX}ÍoÁKnElÊ|Çæ0±¥wOä4ßê#ÔoÎ¢'ÑàðkñpË`ª¨]ÉfP[3y¡¢¤á\nº=\"NÞ\r-D`]Ôzt¯)éò^¨úêá¨t*_00X¿c/~â¥£SoLs]dBõAs¦¦¹³)îð\fâ\nv_*ÿÁ¡Ã¿ûuÎ£óoÐÐkqv<µ]ÊØ¦ç¼¥Á÷ç!Ù¦J¸¥.+ß%µ¤Z²1UÎ#ju9²µ¹Ô£°U¯³V3ës/?6;\bâèï¯ê\fÙ)Yn­Uf@4µ_¿!Çgnï¿:¤°û9)±¹ó«:áÕ¦Öh2À«&ÙÝ<\\Ë¬ãK5|.HUÊ\nîAÈç¶¥y}1YÀ®ËIÊ\rg © ìX$$x4¸4íÙÈ<û z´»§ÞfX_[{Ü#0Ä=Ç°vDñS]½u!Q¡¹¢Q´téPÍÁ¿¸ýt!61[³&Áù¤µ¡0¨vöER>q¬\ta¤ÊÉèWH¼9ËùJå«ÞU ¸Wµ%PJpÞ~4/òìHÕ½D±_\f+ê¨Ï¥w{9ovvåù2[\\KÞ±T,ðþñ¥á/½ã'Øh?Èí zÀúiïÒæKò;)i\bíýäÛ\\Jl#Úº+r<'²ROjñu¦P¿ëõäfw^¢ Gò[U@ºá¡\rz©iF] 8Xnx]Çýª`^'Åw>çÎµ´¶HÇ¾QÀ®È)_{×Áµù\r°êÿL*\nÞwZ×é¦z|ï\\ÞVk$Q·;Ø_oh¿h´¬?±è\rÊkÈwÔï_~/¨wQÝèA³plÈÎ\bìWÌt1O«(*'2ÚÎ½ðJ¸TËìô¿ÎÖ:GA2©ìäã¡ëWì×ëàÏ¼Kº¹æûzü­ººKëÔTã0³9:v½ú@Ö±^ªhé+È[7³\\,ÓÐ\"rÂ;³TR\"= ü¼ÕèPìq~n._fbïDÔô\nÖ¯2[Þm¨Î<¤È(às3HZÚÏÙÛ_Ì]!¹üÈ`Í¹\n+}`§ÖúF$Üí*ükþDØÌÙbyÜºÎ=áO_;gÈ(.4yx3Å±äYÞC¯%½«J6\bgP£íÖ/qÝ©LªúlñÜDR¹Wz·ù-C,oµ<­ÿÒñ²ú=éDä¢ñ0øÑÜ2ôD¬[ÆØ\nÖü|5&÷q¶iæX´æ<Á©£¸úZ!1Ô¸\f­y<&©¹¬näþûÚ^a9tUÏØþÇ°Y=ÎØí§ÏqõãhÏ®kÕç\nÒþ\fQ£hÏ¶Ý-ã\b¼]e\b*ÇÔÖ\b,rhO®\n1tY±ÔÄTÈGd§ t¨tÏX27{À¼¿ý¦ö°á|;0÷y>·fàð$Æ¶\f:% J\rRMÎ§ñe ÁØ+3Ø*-Oä8õrl ~\bÝÝ>&)\n*K äW\r9 Áñ½Ûn\\ÃsH«øÈ!2ç.LZ²c¿.²ì´x{ûèpÕ%\ráÄ#\r5\n/ì\nñS²ùþ}Ãl´Î 4w¹®ôÒxâÑ8¹ûfï³û¨ÌÊÀÁ-î`?¡#,?EÏ¥ÚôP>å{0­ðóm4_&gýµq +­Ï´!ÑÎ\"UáFOò·uñNzdøg³Þ&.²íÔf#mtLº¡2ÒèøËà|3¸îúS9á]hKé*gmÔÌ\\\f~¤úù~?æt÷¸¢`Ócé¯ÔgÝïÇ¬ÙnàXì1ã¿ÊlTÊÊ-¬hÒµ°`ÔÑ}¦2TõÁ©ß·ZªÛý\rñàtvÈ·ÆøÁîÛ¥Zºjfj´¦7Uó±^ÌØjÔdÐ\\L\fÝr!ö6ß.ëß_'6ÓñxçÀºùr¼(¨2ÅH\ràäOåj¸MmþÙtúV«¦0\\ø¾ ÑDbxüÈÞ5z¯K]f&\néÏz´thjcL\rÄ»Ús®9^ªZêDÔ?[B¾è*¶ê©Ã?\rë2{åùÏã#t³±$ºã\n.Ö_C/UNðÔ'¬;ÍËÕÄEÉÜÞÀ*Ø\nïÖ_NY\fãÊ°ÒlØ2Ã*¬vðoaÝ¯'0Ù+/TMÓþ*þå&®eÊz¬ãÅ,ÛöøÈ.!¡\tç\fkkm¢ZËJ\bºu$WºHG­Ù_hfª;1,ÏG©<}mY!}À¥I4m¥ýSeâñ*7zT«!ØÿÃ[ÙÄ^+{j«;ÑLKÄoæ­u}ÛÉÚÄÒë¼_Æ©^RS£µ³Ê Dp^vÅ×?ù7P¾j®:\\ôþÌþG¨öLÜ!åvr3o=½GÕuµUÕ¤\nDdjy5ñÜ|Übµ t;ilq.¡ñî?õc{x\fnÐÜ>TÑbðÊ½(òfo)6]yu§==q\"xx*CÄÿ£\bîä÷ÏëÎò´Nú;$¸?,Rb¡Ýkü©=ò`|0".getBytes("ISO_8859_1");
        Object[] objectArray = "\rÄß1óð".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 624781766;
                case 1 -> -205586977;
                case 2 -> -472155209;
                case 3 -> -179202907;
                case 4 -> 1784008883;
                case 5 -> 1528554435;
                case 6 -> -27639492;
                case 7 -> -256811957;
                case 8 -> 1479021419;
                case 9 -> 301466262;
                case 10 -> 1276842636;
                case 11 -> -1861983552;
                case 12 -> -209629981;
                case 13 -> -1648682122;
                case 14 -> -18690293;
                case 15 -> 1559419935;
                case 16 -> 341475464;
                case 17 -> -1598323981;
                case 18 -> 194174165;
                case 19 -> -403665280;
                case 20 -> 926771730;
                case 21 -> -600312783;
                case 22 -> -700500323;
                case 23 -> -7612168;
                case 24 -> 618478593;
                case 25 -> -1542140909;
                case 26 -> -660515854;
                case 27 -> 1539377294;
                case 28 -> -1051622898;
                case 29 -> 828873159;
                case 30 -> 2009703663;
                case 31 -> 2035804141;
                case 32 -> 109165823;
                case 33 -> 303510486;
                case 34 -> -1884561369;
                case 35 -> 1730079665;
                case 36 -> -114005980;
                case 37 -> -712648121;
                case 38 -> -968850499;
                case 39 -> -1204249652;
                case 40 -> -1508079099;
                case 41 -> 463340154;
                case 42 -> 783817348;
                case 43 -> -471535054;
                case 44 -> -2140346977;
                case 45 -> 1542572023;
                case 46 -> -1109179121;
                case 47 -> -1753619980;
                case 48 -> -165116731;
                case 49 -> 1361592024;
                case 50 -> 1169987878;
                case 51 -> -1361363244;
                case 52 -> -1680066678;
                case 53 -> -1594681729;
                case 54 -> 1026537818;
                case 55 -> 200519197;
                case 56 -> -639293792;
                case 57 -> 2105161762;
                case 58 -> 1158370926;
                case 59 -> -1816826065;
                case 60 -> -1255889135;
                case 61 -> -237869988;
                case 62 -> -910035478;
                case 63 -> 2017656709;
                case 64 -> -733878012;
                case 65 -> -621874203;
                case 66 -> 494377906;
                case 67 -> 1229785672;
                case 68 -> -1247924472;
                case 69 -> 953040042;
                case 70 -> 488165281;
                case 71 -> 917775870;
                case 72 -> -1591170108;
                case 73 -> 1000558614;
                case 74 -> -1206287180;
                case 75 -> -1957548471;
                case 76 -> -125096755;
                case 77 -> -575213268;
                case 78 -> 994108592;
                case 79 -> -1078433826;
                case 80 -> 1610167174;
                case 81 -> -672852316;
                case 82 -> -439284429;
                case 83 -> 200055892;
                case 84 -> -696310365;
                case 85 -> -1690612935;
                case 86 -> 1403531858;
                case 87 -> 352382314;
                case 88 -> 1044886637;
                case 89 -> -1181760682;
                case 90 -> -1997883369;
                case 91 -> 218565625;
                case 92 -> 1479122531;
                case 93 -> -1070596819;
                case 94 -> -1298382784;
                case 95 -> 1117323588;
                case 96 -> -1573883164;
                case 97 -> 641806011;
                case 98 -> -444090149;
                case 99 -> -297872495;
                case 100 -> 1928788748;
                case 101 -> 861664935;
                case 102 -> -1741367524;
                case 103 -> -661021890;
                case 104 -> -1412273535;
                case 105 -> -40895767;
                case 106 -> 933999486;
                case 107 -> -508436695;
                case 108 -> 1312389408;
                case 109 -> 395539923;
                case 110 -> -542292166;
                case 111 -> 961561606;
                case 112 -> -2050813945;
                case 113 -> -1146235090;
                case 114 -> -401467773;
                case 115 -> 1193604387;
                case 116 -> 1942761142;
                case 117 -> 489421193;
                case 118 -> 7227310;
                case 119 -> 2029207565;
                case 120 -> 1686969035;
                case 121 -> -1272998286;
                case 122 -> -80941288;
                case 123 -> -499363938;
                case 124 -> 2070028178;
                case 125 -> 1695741914;
                case 126 -> 407524669;
                case 127 -> 1430064277;
                case 128 -> 1166826821;
                case 129 -> 594873437;
                case 130 -> -1611701031;
                case 131 -> 1036025196;
                case 132 -> -1275894014;
                case 133 -> 1494312763;
                case 134 -> 1554953061;
                case 135 -> 2089366083;
                case 136 -> 1975041452;
                case 137 -> -366295876;
                case 138 -> 373665912;
                case 139 -> 321494882;
                case 140 -> -1963301124;
                case 141 -> 67510120;
                case 142 -> -2033520272;
                case 143 -> -179543215;
                case 144 -> -1456331550;
                case 145 -> 505381072;
                case 146 -> 2136781867;
                case 147 -> 2062215756;
                case 148 -> -177009643;
                case 149 -> 1143012217;
                case 150 -> -1930362266;
                case 151 -> -134093565;
                case 152 -> -190869363;
                case 153 -> 591892001;
                case 154 -> -1944382053;
                case 155 -> -13074534;
                case 156 -> -355588076;
                case 157 -> -1469523210;
                case 158 -> 1102046538;
                case 159 -> -152545900;
                case 160 -> 1236481510;
                case 161 -> -1484265675;
                case 162 -> 1752036738;
                case 163 -> 1749127454;
                case 164 -> 374001706;
                case 165 -> -367630642;
                case 166 -> 1063968651;
                case 167 -> -534269000;
                case 168 -> 811966444;
                case 169 -> -1327290783;
                case 170 -> -1270143143;
                case 171 -> 1041817007;
                case 172 -> 1063769143;
                case 173 -> -1181896325;
                case 174 -> -579910168;
                case 175 -> -533020400;
                case 176 -> 1455028926;
                case 177 -> -396212311;
                case 178 -> -712307624;
                case 179 -> -1983549833;
                case 180 -> -1906359896;
                case 181 -> 100704497;
                case 182 -> -909455529;
                case 183 -> 0xBB5B000;
                case 184 -> 958223837;
                case 185 -> 1868774624;
                case 186 -> 1878780284;
                case 187 -> 1412806126;
                case 188 -> -1109525594;
                case 189 -> -33283620;
                case 190 -> 1231325071;
                case 191 -> 1623467087;
                case 192 -> -1783429638;
                case 193 -> -667464587;
                case 194 -> 1532026817;
                case 195 -> -1089539905;
                case 196 -> 2137610997;
                case 197 -> -962446608;
                case 198 -> 236600180;
                case 199 -> -2114422167;
                case 200 -> -1793060939;
                case 201 -> 1312508375;
                case 202 -> 13527165;
                case 203 -> 1486020349;
                case 204 -> -735779784;
                case 205 -> 1303568850;
                case 206 -> 149195929;
                case 207 -> 1699114792;
                case 208 -> -1817730480;
                case 209 -> -1798073365;
                case 210 -> -1529452715;
                case 211 -> 2031471385;
                case 212 -> -538308158;
                case 213 -> -1417303474;
                case 214 -> -1673297433;
                case 215 -> -213710796;
                case 216 -> 1034594395;
                case 217 -> 1207297289;
                case 218 -> -1028273115;
                case 219 -> 230612813;
                case 220 -> -924574495;
                case 221 -> 1059470430;
                case 222 -> 427144496;
                case 223 -> 1006884091;
                case 224 -> 1121739290;
                case 225 -> -1272251109;
                case 226 -> 1263910710;
                case 227 -> 831310543;
                case 228 -> -1977488710;
                case 229 -> 264609927;
                case 230 -> -2126771903;
                case 231 -> 2016901442;
                case 232 -> 1002311597;
                case 233 -> -1355674012;
                case 234 -> 1236428614;
                case 235 -> 1524152689;
                case 236 -> 1003487335;
                case 237 -> 85088697;
                case 238 -> 388756083;
                case 239 -> -2041473696;
                case 240 -> 2100539592;
                case 241 -> 363856073;
                case 242 -> 708391946;
                case 243 -> -1328440149;
                case 244 -> 940344476;
                case 245 -> 931745943;
                case 246 -> 1959939679;
                case 247 -> -186390319;
                case 248 -> 2118373322;
                case 249 -> -174816624;
                case 250 -> -1536113581;
                case 251 -> 1370078575;
                case 252 -> -1350085480;
                case 253 -> -251031646;
                case 254 -> 1881722771;
                case 255 -> -193014209;
                default -> 609509205;
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
            aaaaaj = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaad = -64;
        我草你怎么反编译我模组aaaaac = 2000;
        我草你怎么反编译我模组aaaaab = (String)PixelLiveGameMod.aaaabd((char)-1118961579);
        我草你怎么反编译我模组aaaaaa = new aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa(null);
        我草你怎么反编译我模组aaaaae = new EventBus();
    }

    private static Object aaaabd(char c) {
        return ((Object[])aaaaaj)[c];
    }
}

