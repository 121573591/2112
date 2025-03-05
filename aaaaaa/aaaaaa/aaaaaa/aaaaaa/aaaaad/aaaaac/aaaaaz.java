/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.class_2540
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaag;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2540;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaaaaz
implements class_8710 {
    @NotNull
    public static final aaaaag 我草你怎么反编译我模组aaaabn;
    private final int 我草你怎么反编译我模组aaaaae;
    private final int 我草你怎么反编译我模组aaaabo;
    private final int 我草你怎么反编译我模组aaaabp;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaaz> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaaz> 我草你怎么反编译我模组aaaaai;
    static Object aaaabq;

    public aaaaaz(int n, int n2, int n3) {
        this.我草你怎么反编译我模组aaaaae = n;
        this.我草你怎么反编译我模组aaaabo = n2;
        this.我草你怎么反编译我模组aaaabp = n3;
    }

    public final int 你为什么要破解我的代码aaaaad() {
        return this.我草你怎么反编译我模组aaaaae;
    }

    public final int 你为什么要破解我的代码aaaadg() {
        return this.我草你怎么反编译我模组aaaabo;
    }

    public final int 你为什么要破解我的代码aaaadh() {
        return this.我草你怎么反编译我模组aaaabp;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, (arg_0, arg_1) -> aaaaaz.你为什么要破解我的代码aaaadl(this, arg_0, arg_1));
    }

    private final void 你为什么要破解我的代码aaaadi(aaaaaz aaaaaz2) {
        int n = aaaaaz2.你为什么要破解我的代码aaaaaw();
        int n2 = aaaaaz2.你为什么要破解我的代码aaaaai();
        int n3 = aaaaaz2.你为什么要破解我的代码aaaaaj();
        int n4 = aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
        int n5 = aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaah();
        int n6 = aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaac();
        if (n4 != n) {
            aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaag(n);
            aaaaab.你为什么要破解我的代码aaaaaa().info("更新挑战次数: " + n4 + " -> " + n);
        }
        if (n5 != n2) {
            aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaai(n2);
            aaaaab.你为什么要破解我的代码aaaaaa().info("更新目标距离: " + n5 + " -> " + n2);
        }
        if (n6 != n3) {
            aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(n3);
            aaaaab.你为什么要破解我的代码aaaaaa().info("更新死亡后退距离: " + n6 + " -> " + n3);
        }
    }

    @NotNull
    public class_8710.class_9154<aaaaaz> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final int 你为什么要破解我的代码aaaaaw() {
        return this.我草你怎么反编译我模组aaaaae;
    }

    public final int 你为什么要破解我的代码aaaaai() {
        return this.我草你怎么反编译我模组aaaabo;
    }

    public final int 你为什么要破解我的代码aaaaaj() {
        return this.我草你怎么反编译我模组aaaabp;
    }

    @NotNull
    public final aaaaaz 你为什么要破解我的代码aaaadj(int n, int n2, int n3) {
        return new aaaaaz(n, n2, n3);
    }

    public static /* synthetic */ aaaaaz 你为什么要破解我的代码aaaadk(aaaaaz aaaaaz2, int n, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n = aaaaaz2.我草你怎么反编译我模组aaaaae;
        }
        if ((n4 & 2) != 0) {
            n2 = aaaaaz2.我草你怎么反编译我模组aaaabo;
        }
        if ((n4 & 4) != 0) {
            n3 = aaaaaz2.我草你怎么反编译我模组aaaabp;
        }
        return aaaaaz2.你为什么要破解我的代码aaaadj(n, n2, n3);
    }

    @NotNull
    public String toString() {
        return "BreakOutSettingsPayload(challengeNum=" + this.我草你怎么反编译我模组aaaaae + ", goalDistance=" + this.我草你怎么反编译我模组aaaabo + ", deathPushback=" + this.我草你怎么反编译我模组aaaabp + ")";
    }

    public int hashCode() {
        int n = Integer.hashCode((int)this.我草你怎么反编译我模组aaaaae);
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaabo);
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaabp);
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaaz)) {
            return false;
        }
        aaaaaz aaaaaz2 = (aaaaaz)object;
        if (this.我草你怎么反编译我模组aaaaae != aaaaaz2.我草你怎么反编译我模组aaaaae) {
            return false;
        }
        if (this.我草你怎么反编译我模组aaaabo != aaaaaz2.我草你怎么反编译我模组aaaabo) {
            return false;
        }
        return this.我草你怎么反编译我模组aaaabp == aaaaaz2.我草你怎么反编译我模组aaaabp;
    }

    private static final void 你为什么要破解我的代码aaaadl(aaaaaz aaaaaz2, aaaaaz aaaaaz3, ServerPlayNetworking.Context context) {
        Intrinsics.checkNotNullParameter((Object)aaaaaz2, (String)((String)aaaaaz.aaaado((char)939851776)));
        Intrinsics.checkNotNull((Object)aaaaaz3);
        aaaaaz2.你为什么要破解我的代码aaaadi(aaaaaz3);
    }

    private static final void 你为什么要破解我的代码aaaadm(aaaaaz aaaaaz2, class_2540 class_25402) {
        class_25402.method_53002(aaaaaz2.我草你怎么反编译我模组aaaaae);
        class_25402.method_53002(aaaaaz2.我草你怎么反编译我模组aaaabo);
        class_25402.method_53002(aaaaaz2.我草你怎么反编译我模组aaaabp);
    }

    private static final aaaaaz 你为什么要破解我的代码aaaadn(class_2540 class_25402) {
        return new aaaaaz(class_25402.readInt(), class_25402.readInt(), class_25402.readInt());
    }

    static {
        byte[] byArray = "¬:±Ð²-Wá&k¥ºÒÞÀWò/\"æíØh-ìzyÂVX¯©MAR@\"jÝÓXu¹ýÐÍEoæ;?uãlÅßÝö]=ë¡0TÒã".getBytes("ISO_8859_1");
        Object[] objectArray = "Ç~)íáË[".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1480743502;
                case 1 -> -1362200066;
                case 2 -> -1173176681;
                case 3 -> 1651858239;
                case 4 -> -1499329024;
                case 5 -> -50503087;
                case 6 -> -1394898845;
                case 7 -> -1218477036;
                case 8 -> 1421351002;
                case 9 -> 89362260;
                case 10 -> -634101194;
                case 11 -> 1838900413;
                case 12 -> 2008366317;
                case 13 -> -2094000912;
                case 14 -> -237928309;
                case 15 -> 1613859891;
                case 16 -> -728490995;
                case 17 -> -1848853745;
                case 18 -> -1514126320;
                case 19 -> 2053370936;
                case 20 -> -909732376;
                case 21 -> 1732196160;
                case 22 -> 990987468;
                case 23 -> 1188494018;
                case 24 -> -1565119325;
                case 25 -> -1048182006;
                case 26 -> -2091550176;
                case 27 -> 1909192729;
                case 28 -> 1098022985;
                case 29 -> -298735492;
                case 30 -> -753868482;
                case 31 -> -904102409;
                case 32 -> -1220305221;
                case 33 -> 217357316;
                case 34 -> 849673408;
                case 35 -> -467646329;
                case 36 -> -1613732144;
                case 37 -> 527495553;
                case 38 -> -27650018;
                case 39 -> 1301776924;
                case 40 -> -622372737;
                case 41 -> 1983675766;
                case 42 -> 123094967;
                case 43 -> -1789520202;
                case 44 -> -1996851747;
                case 45 -> -1182186682;
                case 46 -> -423800958;
                case 47 -> -1945929211;
                case 48 -> -867886385;
                case 49 -> -462866085;
                case 50 -> -165338299;
                case 51 -> -1878051838;
                case 52 -> -1097011377;
                case 53 -> 427932118;
                case 54 -> 1765709983;
                case 55 -> 1563915307;
                case 56 -> -1470277124;
                case 57 -> -529256185;
                case 58 -> 2085251160;
                case 59 -> 1525949674;
                case 60 -> -772863057;
                case 61 -> -1853427473;
                case 62 -> -34684503;
                case 63 -> 1543447831;
                case 64 -> 761504037;
                case 65 -> 41030118;
                case 66 -> -1719542117;
                case 67 -> -145884553;
                case 68 -> -1699257515;
                case 69 -> -924717640;
                case 70 -> -450723899;
                case 71 -> 1465929219;
                case 72 -> 499749900;
                case 73 -> 243375326;
                case 74 -> 222243795;
                case 75 -> -2096491886;
                case 76 -> 322828787;
                case 77 -> 1148540604;
                case 78 -> 28942089;
                case 79 -> -1575543455;
                case 80 -> 1065382011;
                case 81 -> 1515573729;
                case 82 -> -941372350;
                case 83 -> -1282306210;
                case 84 -> -1823619934;
                case 85 -> 607842928;
                case 86 -> 1281903001;
                case 87 -> 575887492;
                case 88 -> 833823799;
                case 89 -> -1787472804;
                case 90 -> 151528145;
                case 91 -> -501305623;
                case 92 -> -962079843;
                case 93 -> 2004584786;
                case 94 -> -1741400156;
                case 95 -> 2063619094;
                case 96 -> -1719992020;
                case 97 -> 2005478459;
                case 98 -> -198602681;
                case 99 -> 226093671;
                case 100 -> 629799266;
                case 101 -> 1186660684;
                case 102 -> 1956166496;
                case 103 -> -954087944;
                case 104 -> -196023656;
                case 105 -> 693425665;
                case 106 -> 2102373035;
                case 107 -> 138997619;
                case 108 -> 673911856;
                case 109 -> -1751983293;
                case 110 -> 1442901357;
                case 111 -> 655316846;
                case 112 -> -1254285095;
                case 113 -> 1982964036;
                case 114 -> 1870293710;
                case 115 -> 106519037;
                case 116 -> -397485752;
                case 117 -> 1005910177;
                case 118 -> -779192069;
                case 119 -> -828828559;
                case 120 -> 805805149;
                case 121 -> -181969702;
                case 122 -> -152337373;
                case 123 -> -560903733;
                case 124 -> 1716729193;
                case 125 -> 865119278;
                case 126 -> -1520793912;
                case 127 -> 1516152204;
                case 128 -> 1005254008;
                case 129 -> 1643926559;
                case 130 -> -1986216175;
                case 131 -> -1569732587;
                case 132 -> 827932355;
                case 133 -> -1017894355;
                case 134 -> 2057670239;
                case 135 -> -236758990;
                case 136 -> 1703663655;
                case 137 -> 1339467502;
                case 138 -> 1081434394;
                case 139 -> -1622738582;
                case 140 -> -999573992;
                case 141 -> 742668416;
                case 142 -> -878248371;
                case 143 -> 589888598;
                case 144 -> -29944420;
                case 145 -> 944298666;
                case 146 -> -1273975158;
                case 147 -> 2023365351;
                case 148 -> -2067458305;
                case 149 -> 405025521;
                case 150 -> 451873104;
                case 151 -> 1943768229;
                case 152 -> 1420309169;
                case 153 -> -1427910534;
                case 154 -> 942109141;
                case 155 -> -834053813;
                case 156 -> -275303639;
                case 157 -> 1739089729;
                case 158 -> -1232309451;
                case 159 -> 1532471754;
                case 160 -> -371550476;
                case 161 -> 178783858;
                case 162 -> -521233282;
                case 163 -> -864717805;
                case 164 -> 804679498;
                case 165 -> 187481235;
                case 166 -> -1788313680;
                case 167 -> -1206524991;
                case 168 -> -2102967500;
                case 169 -> -672129405;
                case 170 -> 368899271;
                case 171 -> 373632691;
                case 172 -> 130708369;
                case 173 -> -198598289;
                case 174 -> 2039142836;
                case 175 -> -633022273;
                case 176 -> -1926161438;
                case 177 -> -22101531;
                case 178 -> -1769354502;
                case 179 -> -1208578226;
                case 180 -> -1327068899;
                case 181 -> -85894037;
                case 182 -> 1714922529;
                case 183 -> -325314700;
                case 184 -> 1868676006;
                case 185 -> 35245437;
                case 186 -> -1156133788;
                case 187 -> 803600526;
                case 188 -> 497775880;
                case 189 -> -922772526;
                case 190 -> -1525053555;
                case 191 -> -609098796;
                case 192 -> -101129205;
                case 193 -> 672977609;
                case 194 -> 1893129974;
                case 195 -> 695535038;
                case 196 -> -892016417;
                case 197 -> 1998937137;
                case 198 -> 166319908;
                case 199 -> -614614872;
                case 200 -> 1777365453;
                case 201 -> -131275992;
                case 202 -> -479983193;
                case 203 -> 939213528;
                case 204 -> 643072988;
                case 205 -> -1868880506;
                case 206 -> -532100714;
                case 207 -> 1358014124;
                case 208 -> 406249882;
                case 209 -> 2052567701;
                case 210 -> 0x9967766;
                case 211 -> -1154832580;
                case 212 -> 1767662479;
                case 213 -> -1650227027;
                case 214 -> -206064199;
                case 215 -> 945061618;
                case 216 -> 906129888;
                case 217 -> -1532493507;
                case 218 -> 1385070138;
                case 219 -> 428995334;
                case 220 -> -1510259934;
                case 221 -> 707263848;
                case 222 -> 1843883803;
                case 223 -> 289852198;
                case 224 -> -1170292603;
                case 225 -> 1312382133;
                case 226 -> -2143043881;
                case 227 -> -1457076649;
                case 228 -> -1293144172;
                case 229 -> 2075788742;
                case 230 -> -607344925;
                case 231 -> 22846089;
                case 232 -> -220786951;
                case 233 -> -795529500;
                case 234 -> 1428901060;
                case 235 -> -251552594;
                case 236 -> -1837382923;
                case 237 -> -819813925;
                case 238 -> -2043912725;
                case 239 -> 511056426;
                case 240 -> 48168206;
                case 241 -> 959650322;
                case 242 -> 449245598;
                case 243 -> 1790281888;
                case 244 -> -341510087;
                case 245 -> 49945205;
                case 246 -> 1855090259;
                case 247 -> -993984020;
                case 248 -> -186912391;
                case 249 -> -1909018992;
                case 250 -> 791639343;
                case 251 -> -1930573223;
                case 252 -> 784829370;
                case 253 -> 167909484;
                case 254 -> -1377559160;
                case 255 -> 1921829733;
                default -> -290393377;
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
            Object[] objectArray2 = new Object[4];
            objectArray = objectArray2;
            aaaabq = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabn = new aaaaag(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaaz.aaaado((char)1504378881)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaaz.aaaado((char)1051066370)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaaz::你为什么要破解我的代码aaaadm, aaaaaz::你为什么要破解我的代码aaaadn);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaaz.aaaado((char)-1654915069)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaado(char c) {
        return ((Object[])aaaabq)[c];
    }
}

