/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.ArrayList
 *  java.util.List
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.class_2540
 *  net.minecraft.class_2561
 *  net.minecraft.class_5218
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaag;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import cn.pixellive.mc.game.PixelLiveGameMod;
import java.io.File;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2540;
import net.minecraft.class_2561;
import net.minecraft.class_5218;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nLiveEventPayload.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveEventPayload.kt\ncn/pixellive/mc/game/client/network/common/AuthorizedGamesPayload\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,227:1\n1855#2,2:228\n*S KotlinDebug\n*F\n+ 1 LiveEventPayload.kt\ncn/pixellive/mc/game/client/network/common/AuthorizedGamesPayload\n*L\n174#1:228,2\n*E\n"})
public final class aaaaac
implements class_8710 {
    @NotNull
    public static final aaaaag 我草你怎么反编译我模组aaaaap;
    @NotNull
    private final List<String> 我草你怎么反编译我模组aaaaaq;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaac> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaac> 我草你怎么反编译我模组aaaaai;
    static Object aaaaar;

    public aaaaac(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)((String)aaaaac.aaaaaT((char)-103809024)));
        this.我草你怎么反编译我模组aaaaaq = list;
    }

    @NotNull
    public final List<String> 你为什么要破解我的代码aaaaaM() {
        return this.我草你怎么反编译我模组aaaaaq;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaac::你为什么要破解我的代码aaaaaQ);
    }

    @NotNull
    public class_8710.class_9154<aaaaac> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final List<String> 你为什么要破解我的代码aaaaaN() {
        return this.我草你怎么反编译我模组aaaaaq;
    }

    @NotNull
    public final aaaaac 你为什么要破解我的代码aaaaaO(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)((String)aaaaac.aaaaaT((char)-565575680)));
        return new aaaaac(list);
    }

    public static /* synthetic */ aaaaac 你为什么要破解我的代码aaaaaP(aaaaac aaaaac2, List list, int n, Object object) {
        if ((n & 1) != 0) {
            list = aaaaac2.我草你怎么反编译我模组aaaaaq;
        }
        return aaaaac2.你为什么要破解我的代码aaaaaO(list);
    }

    @NotNull
    public String toString() {
        return "AuthorizedGamesPayload(authorizedGames=" + this.我草你怎么反编译我模组aaaaaq + ")";
    }

    public int hashCode() {
        return this.我草你怎么反编译我模组aaaaaq.hashCode();
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaac)) {
            return false;
        }
        aaaaac aaaaac2 = (aaaaac)object;
        return Intrinsics.areEqual(this.我草你怎么反编译我模组aaaaaq, aaaaac2.我草你怎么反编译我模组aaaaaq);
    }

    private static final void 你为什么要破解我的代码aaaaaQ(aaaaac aaaaac2, ServerPlayNetworking.Context context) {
        List<String> list = aaaaac2.我草你怎么反编译我模组aaaaaq;
        aaaaab.你为什么要破解我的代码aaaaaa().info(context.player().method_5477() + " received authorized games: " + list);
        if (PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaac() || new File(context.player().field_13995.method_27050(class_5218.field_24188).getParent().toFile(), (String)aaaaac.aaaaaT((char)622985217)).exists()) {
            aaaaas aaaaas2 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
            if (!CollectionsKt.contains((Iterable)((Iterable)list), (Object)(aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null)) && PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf() != null) {
                aaaaas aaaaas3 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
                context.player().field_13987.method_52396(class_2561.method_30163((String)("该服务端是您未授权的游戏类型: " + (aaaaas3 != null ? aaaaas3.你为什么要破解我的代码aaaaaj() : null))));
            }
        }
    }

    private static final void 你为什么要破解我的代码aaaaaR(aaaaac aaaaac2, class_2540 class_25402) {
        class_25402.method_53002(aaaaac2.我草你怎么反编译我模组aaaaaq.size());
        Iterable iterable = (Iterable)aaaaac2.我草你怎么反编译我模组aaaaaq;
        boolean bl = false;
        for (Object object : iterable) {
            String string = (String)object;
            boolean bl2 = false;
            class_25402.method_10814(string);
        }
    }

    private static final aaaaac 你为什么要破解我的代码aaaaaS(class_2540 class_25402) {
        int n = class_25402.readInt();
        List list = (List)new ArrayList();
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2++;
            boolean bl = false;
            String string = class_25402.method_19772();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaac.aaaaaT((char)1640300546)));
            list.add((Object)string);
        }
        return new aaaaac((List<String>)list);
    }

    static {
        byte[] byArray = "ý4\\ôÜ{Ç\b¹h¹P16âëÙ«AKwe,ZB²ULD:®~tÞ\t¿P-uýñ]ÌÕ ä_75ZàéS©ìÒÜì÷Êg@Ùø9LäØÀîÝ\nwLí¹(q!í \bPcÎé\tïWd¸ò#¦¢Û¸".getBytes("ISO_8859_1");
        Object[] objectArray = "ü'&ø¡²".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -2009720197;
                case 1 -> 1586778846;
                case 2 -> -1240720492;
                case 3 -> -1571474776;
                case 4 -> 1669484482;
                case 5 -> -423095984;
                case 6 -> -1395027915;
                case 7 -> -799005911;
                case 8 -> -412037503;
                case 9 -> -1008445416;
                case 10 -> -458852879;
                case 11 -> 322705616;
                case 12 -> -254202162;
                case 13 -> -1817410725;
                case 14 -> 250947676;
                case 15 -> 319281116;
                case 16 -> -661432203;
                case 17 -> -1716921960;
                case 18 -> -1310093393;
                case 19 -> -1214392105;
                case 20 -> -1911614471;
                case 21 -> 1769853624;
                case 22 -> -108383651;
                case 23 -> 716965565;
                case 24 -> -273488554;
                case 25 -> -1839319689;
                case 26 -> 13563726;
                case 27 -> 1853806990;
                case 28 -> 1719722452;
                case 29 -> -1711351584;
                case 30 -> 1171696821;
                case 31 -> -934693549;
                case 32 -> 1363561402;
                case 33 -> 353770356;
                case 34 -> 40697971;
                case 35 -> -748567661;
                case 36 -> 1350908756;
                case 37 -> -1192857759;
                case 38 -> -862021092;
                case 39 -> -518013363;
                case 40 -> 1167432711;
                case 41 -> -586645685;
                case 42 -> 984699174;
                case 43 -> 1643141449;
                case 44 -> -1217582422;
                case 45 -> -464073525;
                case 46 -> -1766662161;
                case 47 -> 1638025744;
                case 48 -> 341072318;
                case 49 -> 1351931513;
                case 50 -> -936347346;
                case 51 -> -704900254;
                case 52 -> -607631226;
                case 53 -> 460923057;
                case 54 -> 315498277;
                case 55 -> 931338431;
                case 56 -> 1831345922;
                case 57 -> 576890168;
                case 58 -> -1231248083;
                case 59 -> -318728138;
                case 60 -> -120683877;
                case 61 -> -1518890297;
                case 62 -> -1082542488;
                case 63 -> -1041719899;
                case 64 -> -1205995307;
                case 65 -> -931898126;
                case 66 -> -1011525329;
                case 67 -> 1771174728;
                case 68 -> 403794988;
                case 69 -> -1202748864;
                case 70 -> 468498708;
                case 71 -> -462559068;
                case 72 -> 1196437261;
                case 73 -> 910658582;
                case 74 -> 1724004474;
                case 75 -> 476106859;
                case 76 -> -1630069910;
                case 77 -> 1144399393;
                case 78 -> 1595345667;
                case 79 -> -783981680;
                case 80 -> -1992377678;
                case 81 -> 274489276;
                case 82 -> 451602722;
                case 83 -> -1044508789;
                case 84 -> -356475802;
                case 85 -> -443979526;
                case 86 -> 1749714797;
                case 87 -> 503863514;
                case 88 -> 161232065;
                case 89 -> 1086220211;
                case 90 -> -453116916;
                case 91 -> -1245133502;
                case 92 -> -1516375714;
                case 93 -> -2071518153;
                case 94 -> -1724633794;
                case 95 -> -570601075;
                case 96 -> 1150378570;
                case 97 -> 1835581673;
                case 98 -> -847713289;
                case 99 -> -592471813;
                case 100 -> -762207775;
                case 101 -> 390376076;
                case 102 -> -854103616;
                case 103 -> 1272920981;
                case 104 -> 247025248;
                case 105 -> 1386184423;
                case 106 -> -1880939366;
                case 107 -> -1615849191;
                case 108 -> -119153933;
                case 109 -> 1335924396;
                case 110 -> 1836936192;
                case 111 -> 74410596;
                case 112 -> -1705513202;
                case 113 -> 1821927099;
                case 114 -> 281946163;
                case 115 -> -1967266647;
                case 116 -> 993338170;
                case 117 -> -1138166439;
                case 118 -> -1194686052;
                case 119 -> -228828411;
                case 120 -> -259170017;
                case 121 -> -1391655783;
                case 122 -> 1141683400;
                case 123 -> -369387736;
                case 124 -> -1681352335;
                case 125 -> 137347062;
                case 126 -> -1419006083;
                case 127 -> -750300666;
                case 128 -> 193441441;
                case 129 -> 848299303;
                case 130 -> 217252369;
                case 131 -> -1049653008;
                case 132 -> 692961349;
                case 133 -> -1803052151;
                case 134 -> -1601311527;
                case 135 -> -1393375461;
                case 136 -> -1661654792;
                case 137 -> 415229558;
                case 138 -> 1253183787;
                case 139 -> -1667332566;
                case 140 -> 1363535711;
                case 141 -> -1750928038;
                case 142 -> -1416494844;
                case 143 -> -1595696254;
                case 144 -> -231125628;
                case 145 -> -2119109138;
                case 146 -> -1289747247;
                case 147 -> -17440433;
                case 148 -> 533795975;
                case 149 -> 1359963597;
                case 150 -> -542243154;
                case 151 -> 1275013223;
                case 152 -> 1445348412;
                case 153 -> -366437807;
                case 154 -> 1451200244;
                case 155 -> -1322256308;
                case 156 -> -961115411;
                case 157 -> -1584961841;
                case 158 -> 930029794;
                case 159 -> 1190139811;
                case 160 -> -969087559;
                case 161 -> -1283195668;
                case 162 -> -1491570935;
                case 163 -> -1021572270;
                case 164 -> 1607258683;
                case 165 -> -2045485463;
                case 166 -> -1844623992;
                case 167 -> 1801194947;
                case 168 -> -810201585;
                case 169 -> -1889276661;
                case 170 -> -1481441026;
                case 171 -> -596370436;
                case 172 -> -2128387329;
                case 173 -> -1980042826;
                case 174 -> 1220743078;
                case 175 -> 959719128;
                case 176 -> -288223418;
                case 177 -> 578299512;
                case 178 -> 1950928751;
                case 179 -> 1655343349;
                case 180 -> -477115856;
                case 181 -> 1080797893;
                case 182 -> 849060991;
                case 183 -> 380255575;
                case 184 -> -650124686;
                case 185 -> -989603644;
                case 186 -> -1334031162;
                case 187 -> 215582746;
                case 188 -> 243300586;
                case 189 -> 1009905732;
                case 190 -> -1989629987;
                case 191 -> 747964682;
                case 192 -> -1299975457;
                case 193 -> -1057649641;
                case 194 -> -2018933077;
                case 195 -> -1170316014;
                case 196 -> -1237908330;
                case 197 -> -925151277;
                case 198 -> 114441328;
                case 199 -> 1347224840;
                case 200 -> 1203418496;
                case 201 -> -827568831;
                case 202 -> -761137634;
                case 203 -> -1024814104;
                case 204 -> 1003229697;
                case 205 -> -569308257;
                case 206 -> -1129111233;
                case 207 -> -1018417576;
                case 208 -> 371807467;
                case 209 -> -624678299;
                case 210 -> -1486528697;
                case 211 -> -2053861123;
                case 212 -> -2002860899;
                case 213 -> 1662913463;
                case 214 -> -1607282908;
                case 215 -> -1877308700;
                case 216 -> 241410722;
                case 217 -> 1350829542;
                case 218 -> 258585906;
                case 219 -> -1464690109;
                case 220 -> 1360116755;
                case 221 -> -572847901;
                case 222 -> 2068819761;
                case 223 -> -212761213;
                case 224 -> -1140283613;
                case 225 -> 1036430993;
                case 226 -> -515629605;
                case 227 -> 1615408586;
                case 228 -> -1531467828;
                case 229 -> 360390282;
                case 230 -> -53780884;
                case 231 -> -1900013213;
                case 232 -> -1202210731;
                case 233 -> -1501997664;
                case 234 -> -1027277651;
                case 235 -> 219634078;
                case 236 -> -1806606169;
                case 237 -> 116562493;
                case 238 -> -357890858;
                case 239 -> 469355410;
                case 240 -> 337649276;
                case 241 -> 1191790213;
                case 242 -> 685313406;
                case 243 -> -1257577927;
                case 244 -> -1606441296;
                case 245 -> -973987296;
                case 246 -> 264091109;
                case 247 -> -220564329;
                case 248 -> -1278390348;
                case 249 -> -698681036;
                case 250 -> -1027501283;
                case 251 -> 673592777;
                case 252 -> -1807068718;
                case 253 -> -1968164977;
                case 254 -> 1490741358;
                case 255 -> -3613419;
                default -> 1855043673;
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
            Object[] objectArray2 = new Object[6];
            objectArray = objectArray2;
            aaaaar = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaap = new aaaaag(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaac.aaaaaT((char)1257766915)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaac.aaaaaT((char)152633348)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaac::你为什么要破解我的代码aaaaaR, aaaaac::你为什么要破解我的代码aaaaaS);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaac.aaaaaT((char)612499461)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaaaT(char c) {
        return ((Object[])aaaaar)[c];
    }
}

