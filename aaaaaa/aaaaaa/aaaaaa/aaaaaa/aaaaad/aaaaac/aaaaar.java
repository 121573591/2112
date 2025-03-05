/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.class_2338
 *  net.minecraft.class_2540
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacs;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaA;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaah;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaai;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2338;
import net.minecraft.class_2540;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nWheatGuardianControlPayload.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WheatGuardianControlPayload.kt\ncn/pixellive/mc/game/client/network/WheatGuardianControlPayload\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,103:1\n215#2,2:104\n*S KotlinDebug\n*F\n+ 1 WheatGuardianControlPayload.kt\ncn/pixellive/mc/game/client/network/WheatGuardianControlPayload\n*L\n41#1:104,2\n*E\n"})
public final class aaaaar
implements class_8710 {
    @NotNull
    public static final aaaaaA 我草你怎么反编译我模组aaaaaO;
    @NotNull
    private final aaaaah 我草你怎么反编译我模组aaaaaP;
    @NotNull
    private final Map<String, String> 我草你怎么反编译我模组aaaaaL;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaar> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaar> 我草你怎么反编译我模组aaaaai;
    static Object aaaaaQ;

    public aaaaar(@NotNull aaaaah aaaaah2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaaah2), (String)((String)aaaaar.aaaace((char)-1903755264)));
        Intrinsics.checkNotNullParameter(map, (String)((String)aaaaar.aaaace((char)-201261055)));
        this.我草你怎么反编译我模组aaaaaP = aaaaah2;
        this.我草你怎么反编译我模组aaaaaL = map;
    }

    public /* synthetic */ aaaaar(aaaaah aaaaah2, Map map, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        this(aaaaah2, (Map<String, String>)map);
    }

    @NotNull
    public final aaaaah 你为什么要破解我的代码aaaabW() {
        return this.我草你怎么反编译我模组aaaaaP;
    }

    @NotNull
    public final Map<String, String> 你为什么要破解我的代码aaaabL() {
        return this.我草你怎么反编译我模组aaaaaL;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaar::你为什么要破解我的代码aaaacb);
    }

    @NotNull
    public class_8710.class_9154<aaaaar> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final aaaaah 你为什么要破解我的代码aaaabX() {
        return this.我草你怎么反编译我模组aaaaaP;
    }

    @NotNull
    public final Map<String, String> 你为什么要破解我的代码aaaabN() {
        return this.我草你怎么反编译我模组aaaaaL;
    }

    @NotNull
    public final aaaaar 你为什么要破解我的代码aaaabY(@NotNull aaaaah aaaaah2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaaah2), (String)((String)aaaaar.aaaace((char)1618739200)));
        Intrinsics.checkNotNullParameter(map, (String)((String)aaaaar.aaaace((char)-1181024255)));
        return new aaaaar(aaaaah2, map);
    }

    public static /* synthetic */ aaaaar 你为什么要破解我的代码aaaabZ(aaaaar aaaaar2, aaaaah aaaaah2, Map map, int n, Object object) {
        if ((n & 1) != 0) {
            aaaaah2 = aaaaar2.我草你怎么反编译我模组aaaaaP;
        }
        if ((n & 2) != 0) {
            map = aaaaar2.我草你怎么反编译我模组aaaaaL;
        }
        return aaaaar2.你为什么要破解我的代码aaaabY(aaaaah2, map);
    }

    @NotNull
    public String toString() {
        return "WheatGuardianControlPayload(controlType=" + this.我草你怎么反编译我模组aaaaaP + ", data=" + this.我草你怎么反编译我模组aaaaaL + ")";
    }

    public int hashCode() {
        int n = this.我草你怎么反编译我模组aaaaaP.hashCode();
        n = n * 31 + this.我草你怎么反编译我模组aaaaaL.hashCode();
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaar)) {
            return false;
        }
        aaaaar aaaaar2 = (aaaaar)object;
        if (this.我草你怎么反编译我模组aaaaaP != aaaaar2.我草你怎么反编译我模组aaaaaP) {
            return false;
        }
        return Intrinsics.areEqual(this.我草你怎么反编译我模组aaaaaL, aaaaar2.我草你怎么反编译我模组aaaaaL);
    }

    private static final void 你为什么要破解我的代码aaaaca(aaaaar aaaaar2) {
        switch (aaaaai.我草你怎么反编译我模组aaaaaa[aaaaar2.我草你怎么反编译我模组aaaaaP.ordinal()]) {
            case 1: {
                aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaane();
                aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaamH(true);
                aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaabV((String)aaaaar.aaaace((char)1830617090));
                break;
            }
            case 2: {
                aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaik();
                aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaabV((String)aaaaar.aaaace((char)-763166717));
                break;
            }
            case 3: {
                int n = aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaakf().method_10263() + 2;
                int n2 = aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaakf().method_10260() + 2;
                class_2338 class_23382 = aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaamJ();
                class_2338 class_23383 = Intrinsics.areEqual((Object)class_23382, (Object)new class_2338(28, 107, 72)) ? new class_2338(class_23382.method_10263() - n + 1, class_23382.method_10264(), class_23382.method_10260() + n2 - 1) : new class_2338(28, 107, 72);
                aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaoo(class_23383);
                String string = Intrinsics.areEqual((Object)class_23383, (Object)new class_2338(28, 107, 72)) ? (String)aaaaar.aaaace((char)147587076) : (String)aaaaar.aaaace((char)-449576955);
                aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaabV(string);
            }
        }
    }

    private static final void 你为什么要破解我的代码aaaacb(aaaaar aaaaar2, ServerPlayNetworking.Context context) {
        MinecraftServer minecraftServer = context.player().field_13995;
        minecraftServer.execute(() -> aaaaar.你为什么要破解我的代码aaaaca(aaaaar2));
    }

    private static final void 你为什么要破解我的代码aaaacc(aaaaar aaaaar2, class_2540 class_25402) {
        class_25402.method_10817((Enum)aaaaar2.我草你怎么反编译我模组aaaaaP);
        class_25402.method_53002(aaaaar2.我草你怎么反编译我模组aaaaaL.size());
        Map<String, String> map = aaaaar2.我草你怎么反编译我模组aaaaaL;
        boolean bl = false;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry;
            Map.Entry entry2 = entry = (Map.Entry)iterator.next();
            boolean bl2 = false;
            String string = (String)entry2.getKey();
            String string2 = (String)entry2.getValue();
            class_25402.method_10814(string);
            class_25402.method_10814(string2);
        }
    }

    private static final aaaaar 你为什么要破解我的代码aaaacd(class_2540 class_25402) {
        aaaaah aaaaah2 = (aaaaah)class_25402.method_10818(aaaaah.class);
        int n = class_25402.readInt();
        Map map = (Map)new LinkedHashMap();
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2++;
            boolean bl = false;
            String string = class_25402.method_19772();
            String string2 = class_25402.method_19772();
            Intrinsics.checkNotNull((Object)string);
            Intrinsics.checkNotNull((Object)string2);
            map.put((Object)string, (Object)string2);
        }
        Intrinsics.checkNotNull((Object)((Object)aaaaah2));
        return new aaaaar(aaaaah2, (Map<String, String>)map);
    }

    static {
        byte[] byArray = "f$kÕCb·±PvñFb3Ò=£èÍFº7ZgøÈ\"ãï¦èþ»×à³Ë¨ÐAf\\=ø®EdñVìÌ7òèµL B(\rl±È¨\bdÉ¦Ø3Ý¹A<*·ßQwr³³3x¿x2´d(Àftr/×&`%ÝõÆLöä Ä+ÎCÝ-5\"¾O$1ÝëRÝ÷9 ÕÈ»È7\fn¼ÞÜËöÚ¼ôþ${e¥7³%÷FbZo¦@è7Y{ãyhÉÏÒMMQAªâÚÊ½YçE¶s±­ï¢D9(Cr/ÔÆ©&zJóY)QJiXÐJ4ÆÎIñPVF²çè?ÅµÒÆ[|ØýµHÄ¨ÿ-&ÅöFÒCsn´üpðë+Pò".getBytes("ISO_8859_1");
        Object[] objectArray = "öÇk£ªÒÍ".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1094803014;
                case 1 -> -1119955738;
                case 2 -> -192948152;
                case 3 -> 442145036;
                case 4 -> -237647676;
                case 5 -> -471729524;
                case 6 -> -2021097179;
                case 7 -> -1975120228;
                case 8 -> -1221220566;
                case 9 -> 514993343;
                case 10 -> -25172973;
                case 11 -> 776604862;
                case 12 -> 677654611;
                case 13 -> 1494232178;
                case 14 -> -1463068504;
                case 15 -> 498674706;
                case 16 -> 114000787;
                case 17 -> 1924716112;
                case 18 -> 2103511647;
                case 19 -> 1161214324;
                case 20 -> 1403119460;
                case 21 -> -1547438871;
                case 22 -> 914086550;
                case 23 -> 235344560;
                case 24 -> 1827553389;
                case 25 -> 1003194507;
                case 26 -> 2051470606;
                case 27 -> 1969420811;
                case 28 -> 1096388217;
                case 29 -> -1479978407;
                case 30 -> 945580666;
                case 31 -> 994169566;
                case 32 -> 73688526;
                case 33 -> 1958852732;
                case 34 -> -270386553;
                case 35 -> 1054468812;
                case 36 -> -1801355558;
                case 37 -> 1731220489;
                case 38 -> 80066122;
                case 39 -> -413832245;
                case 40 -> -603666171;
                case 41 -> 1503381264;
                case 42 -> -867361432;
                case 43 -> 1009612138;
                case 44 -> -647454601;
                case 45 -> -587487706;
                case 46 -> -164377822;
                case 47 -> -1450932855;
                case 48 -> -1604255775;
                case 49 -> 351568631;
                case 50 -> 1610970189;
                case 51 -> 619985150;
                case 52 -> 2072962747;
                case 53 -> -577011801;
                case 54 -> -391038280;
                case 55 -> -1110312652;
                case 56 -> -333165202;
                case 57 -> 1639182050;
                case 58 -> 982880991;
                case 59 -> -1942931370;
                case 60 -> -1855240679;
                case 61 -> 745461122;
                case 62 -> -1227731523;
                case 63 -> 1394683398;
                case 64 -> 187250395;
                case 65 -> -908236118;
                case 66 -> 901660810;
                case 67 -> 537878417;
                case 68 -> -1008644935;
                case 69 -> -490413410;
                case 70 -> 1915898534;
                case 71 -> 1243038671;
                case 72 -> -1165520778;
                case 73 -> -1399645567;
                case 74 -> -130823100;
                case 75 -> -1281698242;
                case 76 -> 6831022;
                case 77 -> -1709638355;
                case 78 -> -542849215;
                case 79 -> 1309083140;
                case 80 -> -1239601288;
                case 81 -> -1633113800;
                case 82 -> -1992283876;
                case 83 -> 107093820;
                case 84 -> 195411292;
                case 85 -> -2004697421;
                case 86 -> -745729451;
                case 87 -> 1349633150;
                case 88 -> -1303176665;
                case 89 -> 174019397;
                case 90 -> -1495526583;
                case 91 -> 287903686;
                case 92 -> 2105418566;
                case 93 -> -476809375;
                case 94 -> 1728946959;
                case 95 -> 921100884;
                case 96 -> -1222550985;
                case 97 -> 740640815;
                case 98 -> 1880184414;
                case 99 -> -1709732718;
                case 100 -> 700201447;
                case 101 -> 1797388783;
                case 102 -> -1560175094;
                case 103 -> -95665196;
                case 104 -> -1349301588;
                case 105 -> -1418569496;
                case 106 -> -1648881771;
                case 107 -> -166846527;
                case 108 -> 2058526712;
                case 109 -> -223761903;
                case 110 -> 703753741;
                case 111 -> -1915123058;
                case 112 -> 1733199918;
                case 113 -> 404484741;
                case 114 -> -203352937;
                case 115 -> 671767633;
                case 116 -> -847724180;
                case 117 -> 492433074;
                case 118 -> -1636080640;
                case 119 -> -1555030973;
                case 120 -> 501114394;
                case 121 -> -2051378237;
                case 122 -> -830514962;
                case 123 -> 46468346;
                case 124 -> 1906661081;
                case 125 -> 1173150505;
                case 126 -> -3314408;
                case 127 -> -918945103;
                case 128 -> 1304819865;
                case 129 -> 1475986301;
                case 130 -> -1407030320;
                case 131 -> -1946928979;
                case 132 -> -2002227990;
                case 133 -> -1194049457;
                case 134 -> -96151788;
                case 135 -> 1866043422;
                case 136 -> 1134209378;
                case 137 -> 334448373;
                case 138 -> 1641285597;
                case 139 -> -1545930949;
                case 140 -> -1557721499;
                case 141 -> -59769744;
                case 142 -> 910370325;
                case 143 -> 330555620;
                case 144 -> -1482070441;
                case 145 -> -1278273223;
                case 146 -> 862628136;
                case 147 -> -552530035;
                case 148 -> -1527091453;
                case 149 -> -532110200;
                case 150 -> 62846675;
                case 151 -> 1029708969;
                case 152 -> 719869062;
                case 153 -> -1952800778;
                case 154 -> 1675838252;
                case 155 -> -1817416343;
                case 156 -> 716485631;
                case 157 -> 1904769924;
                case 158 -> 1564210411;
                case 159 -> -360343397;
                case 160 -> 506928495;
                case 161 -> 1185047103;
                case 162 -> -241961801;
                case 163 -> 1446404534;
                case 164 -> 1707947059;
                case 165 -> -1070811756;
                case 166 -> 555539720;
                case 167 -> -822951723;
                case 168 -> -651181707;
                case 169 -> -420134557;
                case 170 -> 441046986;
                case 171 -> -2045331941;
                case 172 -> 651586906;
                case 173 -> -1784081499;
                case 174 -> -1937664223;
                case 175 -> 284610049;
                case 176 -> 2081031771;
                case 177 -> -115937743;
                case 178 -> -207364712;
                case 179 -> 341741888;
                case 180 -> -1755355868;
                case 181 -> -621296302;
                case 182 -> 1998803636;
                case 183 -> 887641723;
                case 184 -> -967610893;
                case 185 -> 1603779836;
                case 186 -> -599999629;
                case 187 -> 1662854544;
                case 188 -> -144526941;
                case 189 -> 1901043613;
                case 190 -> -1948204373;
                case 191 -> -1912429967;
                case 192 -> 1920842087;
                case 193 -> 862437301;
                case 194 -> -898242089;
                case 195 -> -156748145;
                case 196 -> -1939537562;
                case 197 -> -1376081824;
                case 198 -> -1108583519;
                case 199 -> -626795089;
                case 200 -> -997847654;
                case 201 -> 922695880;
                case 202 -> -2047497748;
                case 203 -> -1249744403;
                case 204 -> -760919730;
                case 205 -> 2131158729;
                case 206 -> -2033275151;
                case 207 -> -1456076494;
                case 208 -> -1070166813;
                case 209 -> 1136023289;
                case 210 -> -1456854696;
                case 211 -> -1630967267;
                case 212 -> -352295114;
                case 213 -> 2076937021;
                case 214 -> 229558348;
                case 215 -> -1035153827;
                case 216 -> -909862016;
                case 217 -> -370785248;
                case 218 -> -530338880;
                case 219 -> 844487531;
                case 220 -> 845835461;
                case 221 -> -914593116;
                case 222 -> 882026262;
                case 223 -> 465703668;
                case 224 -> 1238213336;
                case 225 -> 900564978;
                case 226 -> 1012385238;
                case 227 -> 1089936333;
                case 228 -> -367040249;
                case 229 -> -918176459;
                case 230 -> -1400257630;
                case 231 -> -941922576;
                case 232 -> 1274309088;
                case 233 -> 728870019;
                case 234 -> -1776309551;
                case 235 -> 2121584954;
                case 236 -> -638726785;
                case 237 -> -89506745;
                case 238 -> -1644978459;
                case 239 -> -356368676;
                case 240 -> -173998549;
                case 241 -> 410535755;
                case 242 -> -217871337;
                case 243 -> -96446177;
                case 244 -> -532915710;
                case 245 -> 1511883986;
                case 246 -> 643065922;
                case 247 -> -2556740;
                case 248 -> 547696287;
                case 249 -> 1160856571;
                case 250 -> -1901788893;
                case 251 -> -1761612857;
                case 252 -> 1974314400;
                case 253 -> -921383742;
                case 254 -> -378947792;
                case 255 -> -1615409667;
                default -> 1539805283;
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
            Object[] objectArray2 = new Object[9];
            objectArray = objectArray2;
            aaaaaQ = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaO = new aaaaaA(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaar.aaaace((char)-1123090426)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaar.aaaace((char)1924071431)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaar::你为什么要破解我的代码aaaacc, aaaaar::你为什么要破解我的代码aaaacd);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaar.aaaace((char)2034368520)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaace(char c) {
        return ((Object[])aaaaaQ)[c];
    }
}

