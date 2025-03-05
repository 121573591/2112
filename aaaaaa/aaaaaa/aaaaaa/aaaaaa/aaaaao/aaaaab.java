/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.eventbus.Subscribe
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.LinkedHashMap
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.function.Function
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_310
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaao;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaab.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaaf;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaan;
import cn.hutool.core.util.RandomUtil;
import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveChatEvent;
import cn.pixellive.mc.game.event.live.LiveRoomConnectFailedEvent;
import cn.pixellive.mc.game.live.bilibili.BilibiliConnectListener;
import cn.pixellive.mc.game.live.bilibili.BilibiliListener;
import cn.pixellive.mc.game.live.douyin.DouyinConnectListener;
import cn.pixellive.mc.game.live.douyin.DouyinListener;
import cn.pixellive.mc.game.live.kuaishou.KuaishouConnectListener;
import cn.pixellive.mc.game.live.kuaishou.KuaishouListener;
import cn.pixellive.mc.game.live.tiktok.TikTokConnectListener;
import cn.pixellive.mc.game.live.tiktok.TikTokListener;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.Subscribe;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.LinkedHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_310;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tech.ordinaryroad.live.chat.client.bilibili.client.BilibiliLiveChatClient;
import tech.ordinaryroad.live.chat.client.bilibili.config.BilibiliLiveChatClientConfig;
import tech.ordinaryroad.live.chat.client.codec.tiktok.api.TiktokApis;
import tech.ordinaryroad.live.chat.client.commons.client.enums.ClientStatusEnums;
import tech.ordinaryroad.live.chat.client.commons.util.OrLiveChatHttpUtil;
import tech.ordinaryroad.live.chat.client.douyin.client.DouyinLiveChatClient;
import tech.ordinaryroad.live.chat.client.douyin.config.DouyinLiveChatClientConfig;
import tech.ordinaryroad.live.chat.client.kuaishou.client.KuaishouLiveChatClient;
import tech.ordinaryroad.live.chat.client.kuaishou.config.KuaishouLiveChatClientConfig;
import tech.ordinaryroad.live.chat.client.servers.netty.client.base.BaseNettyClient;
import tech.ordinaryroad.live.chat.client.servers.netty.client.config.BaseNettyClientConfig;
import tech.ordinaryroad.live.chat.client.tiktok.client.TiktokLiveChatClient;
import tech.ordinaryroad.live.chat.client.tiktok.config.TiktokLiveChatClientConfig;

public class aaaaab {
    public static BaseNettyClient<?, ?, ?, ?, ?, ?, ?> 我草你怎么反编译我模组aaaaaa;
    private static final OkHttpClient 我草你怎么反编译我模组aaaaab;
    private static volatile ScheduledExecutorService 我草你怎么反编译我模组aaaaac;
    private static final AtomicInteger 我草你怎么反编译我模组aaaaad;
    private static final int 我草你怎么反编译我模组aaaaae;
    private static final int 我草你怎么反编译我模组aaaaaf;
    private static final int 我草你怎么反编译我模组aaaaag;
    private static final Function<TiktokApis.TiktokSignatureRequest, TiktokApis.TiktokSignatureResult> 我草你怎么反编译我模组aaaaah;
    static Object aaaaai;

    private aaaaab() {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().register((Object)this);
    }

    public static void 你为什么要破解我的代码aaaaaa() {
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaaa.你为什么要破解我的代码aaaaaa();
    }

    private static void 你为什么要破解我的代码aaaaab() {
        if (我草你怎么反编译我模组aaaaac != null && !我草你怎么反编译我模组aaaaac.isShutdown()) {
            我草你怎么反编译我模组aaaaac.shutdown();
        }
        我草你怎么反编译我模组aaaaac = Executors.newSingleThreadScheduledExecutor();
        我草你怎么反编译我模组aaaaac.scheduleAtFixedRate(() -> {
            if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() != null) {
                aaaaab.你为什么要破解我的代码aaaaag();
            }
        }, 15L, 15L, TimeUnit.SECONDS);
    }

    private static int 你为什么要破解我的代码aaaaac() {
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab aaaaab2 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.instance;
        if (aaaaab2 != null && aaaaab2.你为什么要破解我的代码aaaaaa() == aaaacB.我草你怎么反编译我模组aaaaez) {
            return 48;
        }
        return 16;
    }

    public static void 你为什么要破解我的代码aaaaad(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab aaaaab2) {
        if (我草你怎么反编译我模组aaaaaa != null) {
            我草你怎么反编译我模组aaaaaa.disconnect();
            我草你怎么反编译我模组aaaaaa.destroy();
        }
        switch (aaaaab2.你为什么要破解我的代码aaaaaa()) {
            case 我草你怎么反编译我模组aaaaex: {
                BaseNettyClientConfig baseNettyClientConfig = ((DouyinLiveChatClientConfig.DouyinLiveChatClientConfigBuilder)DouyinLiveChatClientConfig.builder().roomId(aaaaab2.你为什么要破解我的代码aaaaac())).build();
                我草你怎么反编译我模组aaaaaa = new DouyinLiveChatClient((DouyinLiveChatClientConfig)baseNettyClientConfig, DouyinListener.INSTANCE, DouyinConnectListener.INSTANCE);
                我草你怎么反编译我模组aaaaaa.connect();
                break;
            }
            case 我草你怎么反编译我模组aaaaey: {
                BaseNettyClientConfig baseNettyClientConfig = ((KuaishouLiveChatClientConfig.KuaishouLiveChatClientConfigBuilder)((KuaishouLiveChatClientConfig.KuaishouLiveChatClientConfigBuilder)KuaishouLiveChatClientConfig.builder().roomId(aaaaab2.你为什么要破解我的代码aaaaae())).cookie(aaaaab2.你为什么要破解我的代码aaaaag())).build();
                我草你怎么反编译我模组aaaaaa = new KuaishouLiveChatClient((KuaishouLiveChatClientConfig)baseNettyClientConfig, KuaishouListener.INSTANCE, KuaishouConnectListener.INSTANCE);
                我草你怎么反编译我模组aaaaaa.connect();
                break;
            }
            case 我草你怎么反编译我模组aaaaez: {
                TiktokApis.setSignatureProvider(我草你怎么反编译我模组aaaaah);
                BaseNettyClientConfig baseNettyClientConfig = ((TiktokLiveChatClientConfig.TiktokLiveChatClientConfigBuilder)((TiktokLiveChatClientConfig.TiktokLiveChatClientConfigBuilder)TiktokLiveChatClientConfig.builder().cookie(aaaaab2.你为什么要破解我的代码aaaaak())).roomId(aaaaab2.你为什么要破解我的代码aaaaai())).build();
                我草你怎么反编译我模组aaaaaa = new TiktokLiveChatClient((TiktokLiveChatClientConfig)baseNettyClientConfig, TikTokListener.INSTANCE, TikTokConnectListener.INSTANCE);
                我草你怎么反编译我模组aaaaaa.connect();
                break;
            }
            case 我草你怎么反编译我模组aaaaeA: {
                BaseNettyClientConfig baseNettyClientConfig = ((BilibiliLiveChatClientConfig.BilibiliLiveChatClientConfigBuilder)BilibiliLiveChatClientConfig.builder().roomId(aaaaab2.你为什么要破解我的代码aaaaau())).build();
                我草你怎么反编译我模组aaaaaa = new BilibiliLiveChatClient((BilibiliLiveChatClientConfig)baseNettyClientConfig, BilibiliListener.INSTANCE, BilibiliConnectListener.INSTANCE);
                我草你怎么反编译我模组aaaaaa.connect();
            }
        }
    }

    public static boolean 你为什么要破解我的代码aaaaae() {
        return 我草你怎么反编译我模组aaaaaa != null && 我草你怎么反编译我模组aaaaaa.getStatus() == ClientStatusEnums.CONNECTED;
    }

    public static void 你为什么要破解我的代码aaaaaf() {
        if (我草你怎么反编译我模组aaaaaa != null) {
            我草你怎么反编译我模组aaaaaa.disconnect();
            我草你怎么反编译我模组aaaaaa.destroy();
        }
        我草你怎么反编译我模组aaaaaa = null;
    }

    private static void 你为什么要破解我的代码aaaaag() {
        try {
            String string;
            String string2;
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab aaaaab2 = aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.instance;
            if (aaaaab2 == null) {
                aaaaab.你为什么要破解我的代码aaaaah();
                return;
            }
            switch (aaaaab2.你为什么要破解我的代码aaaaaa()) {
                case 我草你怎么反编译我模组aaaaex: {
                    string2 = aaaaab2.你为什么要破解我的代码aaaaac();
                    string = (String)aaaaab.aaaaau((char)798883840);
                    break;
                }
                case 我草你怎么反编译我模组aaaaey: {
                    string2 = aaaaab2.你为什么要破解我的代码aaaaae();
                    string = (String)aaaaab.aaaaau((char)1522008065);
                    break;
                }
                case 我草你怎么反编译我模组aaaaez: {
                    string2 = aaaaab2.你为什么要破解我的代码aaaaai();
                    string = (String)aaaaab.aaaaau((char)-96010238);
                    break;
                }
                case 我草你怎么反编译我模组aaaaeA: {
                    string2 = aaaaab2.你为什么要破解我的代码aaaaau();
                    string = (String)aaaaab.aaaaau((char)1453391875);
                    break;
                }
                default: {
                    aaaaab.你为什么要破解我的代码aaaaah();
                    return;
                }
            }
            aaaaaf aaaaaf2 = aaaaan.你为什么要破解我的代码aaaaac(string2, string);
            if (aaaaaf2 == null || !aaaaaf2.你为什么要破解我的代码aaaaaa()) {
                System.out.println("false" + RandomUtil.randomInt(10, 50));
                aaaaab.你为什么要破解我的代码aaaaah();
                return;
            }
            if (!aaaaaa.你为什么要破解我的代码aaaaag(aaaaaf2.你为什么要破解我的代码aaaaab(), string, string2)) {
                System.out.println("true" + RandomUtil.randomInt(10, 50));
                aaaaab.你为什么要破解我的代码aaaaah();
                return;
            }
            if (我草你怎么反编译我模组aaaaad.get() > 0) {
                System.out.println("true" + RandomUtil.randomInt(100, 500));
                我草你怎么反编译我模组aaaaad.decrementAndGet();
            }
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaah();
        }
    }

    public static void 你为什么要破解我的代码aaaaah() {
        System.out.println("" + 我草你怎么反编译我模组aaaaad.get() + RandomUtil.randomInt(10, 50));
        int n = aaaaab.你为什么要破解我的代码aaaaac();
        int n2 = 我草你怎么反编译我模组aaaaad.get();
        if (n2 < n * 2) {
            我草你怎么反编译我模组aaaaad.incrementAndGet();
        }
        if (我草你怎么反编译我模组aaaaad.get() > Math.min((int)aaaaab.你为什么要破解我的代码aaaaac(), (int)48)) {
            aaaaab.你为什么要破解我的代码aaaaaf();
            PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectFailedEvent());
            System.out.println(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaai.aaaaab.我草你怎么反编译我模组aaaaae + aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaai.aaaaab.我草你怎么反编译我模组aaaaaf + RandomUtil.randomInt(1, 30));
            class_310.method_1551().method_1576().execute(() -> {
                while (true) {
                    try {
                        while (true) {
                            Thread.sleep((long)100000L);
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        continue;
                    }
                    break;
                }
            });
        }
    }

    public static DouyinLiveChatClient 你为什么要破解我的代码aaaaai() {
        return (DouyinLiveChatClient)我草你怎么反编译我模组aaaaaa;
    }

    public static KuaishouLiveChatClient 你为什么要破解我的代码aaaaaj() {
        return (KuaishouLiveChatClient)我草你怎么反编译我模组aaaaaa;
    }

    public static TiktokLiveChatClient 你为什么要破解我的代码aaaaak() {
        return (TiktokLiveChatClient)我草你怎么反编译我模组aaaaaa;
    }

    public static BilibiliLiveChatClient 你为什么要破解我的代码aaaaal() {
        return (BilibiliLiveChatClient)我草你怎么反编译我模组aaaaaa;
    }

    @Subscribe
    public void 你为什么要破解我的代码aaaaam(LiveChatEvent liveChatEvent) {
        new Thread(() -> {
            try {
                Thread.sleep((long)30000L);
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaai.aaaaab.你为什么要破解我的代码aaaaab(liveChatEvent.getUsername(), liveChatEvent.getMessage());
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }).start();
    }

    public static OkHttpClient 你为什么要破解我的代码aaaaan() {
        return 我草你怎么反编译我模组aaaaab;
    }

    public static void 你为什么要破解我的代码aaaaao() {
        if (我草你怎么反编译我模组aaaaac != null) {
            我草你怎么反编译我模组aaaaac.shutdown();
            try {
                if (!我草你怎么反编译我模组aaaaac.awaitTermination(5L, TimeUnit.SECONDS)) {
                    我草你怎么反编译我模组aaaaac.shutdownNow();
                }
            }
            catch (InterruptedException interruptedException) {
                我草你怎么反编译我模组aaaaac.shutdownNow();
            }
        }
        aaaaab.你为什么要破解我的代码aaaaaf();
    }

    static {
        byte[] byArray = ".À Üað%-ÿNc}ºÅ=^­zcej°b´éòÕ¢ª´)þ+Ãô²Ìu¤^FWÎÑÂG[ø½É]]v ÈÃª!&A2â÷H_fWUZÍ ´0À*\rmY~ÄÁsæ_j{\t¤èüÖ´0Û/¨­j0óæjÉ­\\/w\\4l.pxæ <Md?\bÚ«Z¿5wmWT2Ãß5ó|ßæm8Â3s'ª =|óÀÂP]®ÕI%êk¬Õ@½Í|nxJ\b/;õ9Ms\bÜÚÌÀÍ/½²\bE»©#>¼¹³¿,i9\n¢t¹¨`©R©£c0ÿbäfhÂ±ÕXòæ¬5uä7${ ±aøØT=\\\\RvzÁ¡ë~éÍ!µ#Wð$fm7uâpï sôÍOÐúm¬ÆÔ8¤cóäÝQµ:_?1±+ª(5±k%=´GiØ bÕìÞ-@ã&p\\¦;þR K¢¶¨åGCÞí?yAVÐÅ¸÷Ç;ºÙP`H_Cñ­hµMÖþøíñ:­ªEÇ'üÍdÖä<|<­ïuÌ;-{xêi¢@ûº¤\"0Ma0Ldißz¼.îß}õgðF³¾Ëo¢m²MP»úJC¶#ãß³/<ø=&3v@|¬­ûR®ïb}qõSI»?Cî¼w Ø¨¤S\"Yºxè-Æ6\n\n\r¿±¡kn¡\tmU<0ê_;sÎ®%ýHªìDS§Îüçg¸RÝi:Âí­ÖªA]é\t§)L 7\fÖ\"îéÍ§ï/ôÊsî!Bþ?\r<ÚíZEG=".getBytes("ISO_8859_1");
        Object[] objectArray = "^PèhC¬".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1817677578;
                case 1 -> 1812914711;
                case 2 -> -539457371;
                case 3 -> 1685327674;
                case 4 -> -1451977386;
                case 5 -> -1550479578;
                case 6 -> -159307304;
                case 7 -> 2077815830;
                case 8 -> -2086140630;
                case 9 -> -1924348491;
                case 10 -> 493621127;
                case 11 -> -550916012;
                case 12 -> -1015783555;
                case 13 -> -813473245;
                case 14 -> 443951716;
                case 15 -> -1931197809;
                case 16 -> -1841601674;
                case 17 -> -1066612040;
                case 18 -> 2103882840;
                case 19 -> -350956621;
                case 20 -> 318038167;
                case 21 -> -931728635;
                case 22 -> -172736867;
                case 23 -> 982067690;
                case 24 -> -1506200159;
                case 25 -> 43520504;
                case 26 -> 1934374233;
                case 27 -> -1191115697;
                case 28 -> 1118041227;
                case 29 -> -620630329;
                case 30 -> -1999862316;
                case 31 -> 732099578;
                case 32 -> 1382511363;
                case 33 -> -150654807;
                case 34 -> 1348883763;
                case 35 -> -447507595;
                case 36 -> 2065920485;
                case 37 -> 483329418;
                case 38 -> 2090602541;
                case 39 -> 1577539886;
                case 40 -> 731778501;
                case 41 -> 860886388;
                case 42 -> 1652304129;
                case 43 -> -419084182;
                case 44 -> 354399780;
                case 45 -> -498885954;
                case 46 -> 2132628749;
                case 47 -> 1720925419;
                case 48 -> -114827370;
                case 49 -> 876216172;
                case 50 -> 87568135;
                case 51 -> -1578456224;
                case 52 -> -1455847500;
                case 53 -> -1057325592;
                case 54 -> 1560637484;
                case 55 -> -253821644;
                case 56 -> 1255930111;
                case 57 -> -104628978;
                case 58 -> -1622721043;
                case 59 -> 562881427;
                case 60 -> 115162314;
                case 61 -> -618021746;
                case 62 -> 399979541;
                case 63 -> 1442600251;
                case 64 -> 900280843;
                case 65 -> 1976731550;
                case 66 -> -612747590;
                case 67 -> 672470136;
                case 68 -> -463388333;
                case 69 -> -532317199;
                case 70 -> -1017769673;
                case 71 -> -337653844;
                case 72 -> -1802627552;
                case 73 -> 1826005273;
                case 74 -> 1836358001;
                case 75 -> 1795974028;
                case 76 -> 1275454498;
                case 77 -> -1485709183;
                case 78 -> -1467824811;
                case 79 -> -2124955248;
                case 80 -> 825693647;
                case 81 -> 605883402;
                case 82 -> 1488050963;
                case 83 -> 233993665;
                case 84 -> -491753163;
                case 85 -> -2003430224;
                case 86 -> 126606265;
                case 87 -> 1421008885;
                case 88 -> -1531114210;
                case 89 -> 1036456868;
                case 90 -> -1339522;
                case 91 -> 686591329;
                case 92 -> 645637400;
                case 93 -> -1591587432;
                case 94 -> -715389465;
                case 95 -> -1250403396;
                case 96 -> -1774313396;
                case 97 -> 1855215432;
                case 98 -> 975856095;
                case 99 -> -267439197;
                case 100 -> -1401460517;
                case 101 -> 31124123;
                case 102 -> -55560370;
                case 103 -> 1809029652;
                case 104 -> 977983964;
                case 105 -> 1307784836;
                case 106 -> 1242293513;
                case 107 -> 1577348250;
                case 108 -> 909238340;
                case 109 -> 1530568670;
                case 110 -> -35676249;
                case 111 -> -225088446;
                case 112 -> -1688099172;
                case 113 -> 1560887883;
                case 114 -> -620287438;
                case 115 -> 454067149;
                case 116 -> 820235035;
                case 117 -> 507360002;
                case 118 -> 1136616563;
                case 119 -> -1964186583;
                case 120 -> 1089641131;
                case 121 -> -2052733919;
                case 122 -> 398076576;
                case 123 -> -1212718478;
                case 124 -> -782618407;
                case 125 -> 799559321;
                case 126 -> 659306750;
                case 127 -> 859419839;
                case 128 -> 1067812679;
                case 129 -> -1102033057;
                case 130 -> -2088106991;
                case 131 -> 948205373;
                case 132 -> -1997054456;
                case 133 -> 1008324876;
                case 134 -> 1728299473;
                case 135 -> -1801838384;
                case 136 -> -1696832053;
                case 137 -> 887449409;
                case 138 -> -2128608082;
                case 139 -> 1589064917;
                case 140 -> 23410981;
                case 141 -> 1937720735;
                case 142 -> -904412733;
                case 143 -> 219577885;
                case 144 -> 615253008;
                case 145 -> 1567830893;
                case 146 -> 1452114044;
                case 147 -> 265687291;
                case 148 -> 634574939;
                case 149 -> -222897498;
                case 150 -> -1025170717;
                case 151 -> 378291550;
                case 152 -> -1228597554;
                case 153 -> -2025307366;
                case 154 -> 253788644;
                case 155 -> -1133895057;
                case 156 -> 30897711;
                case 157 -> 1786146599;
                case 158 -> 660128722;
                case 159 -> 1824174203;
                case 160 -> -1274575273;
                case 161 -> 0x2666666B;
                case 162 -> -768393784;
                case 163 -> -1402647734;
                case 164 -> 1733603135;
                case 165 -> -1564004047;
                case 166 -> -2127814720;
                case 167 -> 2131946641;
                case 168 -> 1069161593;
                case 169 -> -741635337;
                case 170 -> 629171254;
                case 171 -> -1510674839;
                case 172 -> 1576144446;
                case 173 -> 1386759919;
                case 174 -> 186890368;
                case 175 -> -315762170;
                case 176 -> 2090891068;
                case 177 -> 591574595;
                case 178 -> 415644146;
                case 179 -> 2042836560;
                case 180 -> 1477176758;
                case 181 -> 1672121778;
                case 182 -> 733569328;
                case 183 -> 118055123;
                case 184 -> 1936281187;
                case 185 -> -777057966;
                case 186 -> -2017297822;
                case 187 -> -1645677934;
                case 188 -> 170893385;
                case 189 -> 563570134;
                case 190 -> 551309245;
                case 191 -> -1938864320;
                case 192 -> -181466008;
                case 193 -> 2063783074;
                case 194 -> 1993416929;
                case 195 -> 655490244;
                case 196 -> -1954612736;
                case 197 -> 108302519;
                case 198 -> -1682900743;
                case 199 -> 824684134;
                case 200 -> -335235737;
                case 201 -> -78333214;
                case 202 -> 230155642;
                case 203 -> 496382088;
                case 204 -> 378869111;
                case 205 -> -881387343;
                case 206 -> 1048234152;
                case 207 -> -1109849787;
                case 208 -> 281614978;
                case 209 -> -624629960;
                case 210 -> -613899845;
                case 211 -> 1653143336;
                case 212 -> 1539732723;
                case 213 -> 666326000;
                case 214 -> 1243194356;
                case 215 -> -4737559;
                case 216 -> -356883764;
                case 217 -> -1474014316;
                case 218 -> -591105921;
                case 219 -> 385965669;
                case 220 -> -690589714;
                case 221 -> 767027743;
                case 222 -> 1271216477;
                case 223 -> 459739410;
                case 224 -> 1384374508;
                case 225 -> -225437639;
                case 226 -> 933868910;
                case 227 -> -1105412565;
                case 228 -> 58455430;
                case 229 -> -1995310971;
                case 230 -> 1190143968;
                case 231 -> 1101936870;
                case 232 -> 1874868873;
                case 233 -> -1502423587;
                case 234 -> -1160323921;
                case 235 -> 545126415;
                case 236 -> -1655728190;
                case 237 -> -170379695;
                case 238 -> -1434654468;
                case 239 -> 920795081;
                case 240 -> 1294589354;
                case 241 -> -291625513;
                case 242 -> -93586832;
                case 243 -> 1313552582;
                case 244 -> 1358752730;
                case 245 -> 730019981;
                case 246 -> 1538169434;
                case 247 -> -1742214763;
                case 248 -> -1393309875;
                case 249 -> 1584275270;
                case 250 -> 1343566589;
                case 251 -> -85175933;
                case 252 -> 1708209180;
                case 253 -> 494450948;
                case 254 -> 1149211309;
                case 255 -> 1273974620;
                default -> -1140548664;
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
            Object[] objectArray2 = new Object[58];
            objectArray = objectArray2;
            aaaaai = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaag = 15;
        我草你怎么反编译我模组aaaaaf = 48;
        我草你怎么反编译我模组aaaaae = 16;
        我草你怎么反编译我模组aaaaab = new OkHttpClient();
        我草你怎么反编译我模组aaaaad = new AtomicInteger(0);
        我草你怎么反编译我模组aaaaah = tiktokSignatureRequest -> {
            String string = (String)aaaaab.aaaaau((char)-323026940);
            String string2 = tiktokSignatureRequest.getBrowserVersion();
            Long l = tiktokSignatureRequest.getRealRoomId();
            String string3 = (String)aaaaab.aaaaau((char)-618725371);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1815412742)), (Object)((String)aaaaab.aaaaau((char)-2028732409)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1540423688)), (Object)((String)aaaaab.aaaaau((char)793772041)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1092354058)), (Object)((String)aaaaab.aaaaau((char)-1387331573)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-1681260532)), (Object)((String)aaaaab.aaaaau((char)-17563639)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)833421325)), (Object)((String)aaaaab.aaaaau((char)1704656910)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-1453522929)), (Object)((String)aaaaab.aaaaau((char)-408813552)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-184877039)), (Object)((String)aaaaab.aaaaau((char)1988689938)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-265879533)), (Object)string2);
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-31326188)), (Object)((String)aaaaab.aaaaau((char)-1906638832)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)758579221)), (Object)((String)aaaaab.aaaaau((char)-1705836522)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-388169705)), (Object)((String)aaaaab.aaaaau((char)457572376)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)666828825)), (Object)((String)aaaaab.aaaaau((char)363134998)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1953562650)), (Object)((String)aaaaab.aaaaau((char)-986185701)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1690894364)), (Object)((String)aaaaab.aaaaau((char)1226178589)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1211170846)), (Object)((String)aaaaab.aaaaau((char)1286406175)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1128857632)), (Object)((String)aaaaab.aaaaau((char)-2040201183)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-1731723230)), (Object)((String)aaaaab.aaaaau((char)-260308970)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)807796771)), (Object)string3);
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-527630300)), (Object)((String)aaaaab.aaaaau((char)1105002533)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)2118123558)), (Object)((String)aaaaab.aaaaau((char)289800214)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1391525927)), (Object)((String)aaaaab.aaaaau((char)776798248)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)247857193)), (Object)((String)aaaaab.aaaaau((char)1175584810)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-1154547669)), (Object)String.valueOf((Object)l));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-116260820)), (Object)((String)aaaaab.aaaaau((char)-306905043)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-677248978)), (Object)((String)aaaaab.aaaaau((char)-1591607249)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-1875115984)), (Object)((String)aaaaab.aaaaau((char)1928986673)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-301137870)), (Object)((String)aaaaab.aaaaau((char)-247136225)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)1147469875)), (Object)((String)aaaaab.aaaaau((char)-742784972)));
            linkedHashMap.put((Object)((String)aaaaab.aaaaau((char)-907280331)), (Object)((String)aaaaab.aaaaau((char)917962806)));
            String string4 = string3 + "/webcast/im/fetch/?" + OrLiveChatHttpUtil.toParams(linkedHashMap);
            try {
                Request request = new Request.Builder().url(string).post(RequestBody.create(MediaType.parse((String)aaaaab.aaaaau((char)1250558007)), string4)).build();
                try (Response response = 我草你怎么反编译我模组aaaaab.newCall(request).execute();){
                    if (!response.isSuccessful()) return null;
                    if (response.body() == null) return null;
                    JsonNode jsonNode = new ObjectMapper().readTree(response.body().string());
                    TiktokApis.TiktokSignatureResult tiktokSignatureResult = new ObjectMapper().readValue(jsonNode.get((String)aaaaab.aaaaau((char)-1552482248)).toString(), TiktokApis.TiktokSignatureResult.class);
                    return tiktokSignatureResult;
                }
            }
            catch (Exception exception) {
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().error((String)aaaaab.aaaaau((char)1194328121), (Throwable)exception);
            }
            return null;
        };
        new aaaaab();
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            aaaaab.你为什么要破解我的代码aaaaab();
            new Thread(() -> {
                while (true) {
                    try {
                        while (true) {
                            Thread.sleep((long)180000L);
                            if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() == null) continue;
                            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaai.aaaaab.你为什么要破解我的代码aaaaaa();
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        continue;
                    }
                    break;
                }
            }).start();
        }
    }

    private static Object aaaaau(char c) {
        return ((Object[])aaaaai)[c];
    }
}

