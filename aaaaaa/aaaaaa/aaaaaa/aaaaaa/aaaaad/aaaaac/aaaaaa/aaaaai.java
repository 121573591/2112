/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.minecraft.class_2540
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaah;
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
import net.minecraft.class_2540;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaaaai
implements class_8710 {
    @NotNull
    public static final aaaaah 我草你怎么反编译我模组aaaaaB;
    @NotNull
    private final String 我草你怎么反编译我模组aaaaaC;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaai> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaai> 我草你怎么反编译我模组aaaaai;
    static Object aaaaaD;

    public aaaaai(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaai.aaaabx((char)-674103296)));
        this.我草你怎么反编译我模组aaaaaC = string;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaabs() {
        return this.我草你怎么反编译我模组aaaaaC;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playS2C().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
    }

    @NotNull
    public class_8710.class_9154<aaaaai> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaG() {
        return this.我草你怎么反编译我模组aaaaaC;
    }

    @NotNull
    public final aaaaai 你为什么要破解我的代码aaaabt(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaai.aaaabx((char)1117650944)));
        return new aaaaai(string);
    }

    public static /* synthetic */ aaaaai 你为什么要破解我的代码aaaabu(aaaaai aaaaai2, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = aaaaai2.我草你怎么反编译我模组aaaaaC;
        }
        return aaaaai2.你为什么要破解我的代码aaaabt(string);
    }

    @NotNull
    public String toString() {
        return "AvatarDisplayPayload(avatarUrl=" + this.我草你怎么反编译我模组aaaaaC + ")";
    }

    public int hashCode() {
        return this.我草你怎么反编译我模组aaaaaC.hashCode();
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaai)) {
            return false;
        }
        aaaaai aaaaai2 = (aaaaai)object;
        return Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaaaC, (Object)aaaaai2.我草你怎么反编译我模组aaaaaC);
    }

    private static final void 你为什么要破解我的代码aaaabv(aaaaai aaaaai2, class_2540 class_25402) {
        class_25402.method_10814(aaaaai2.我草你怎么反编译我模组aaaaaC);
    }

    private static final aaaaai 你为什么要破解我的代码aaaabw(class_2540 class_25402) {
        String string = class_25402.method_19772();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaai.aaaabx((char)-1613889535)));
        return new aaaaai(string);
    }

    static {
        byte[] byArray = "þ­ý<ýÚ&\f\nÿÃLtZ\\ëpe»Àâü8[¨{.n\nxoÍÛ]IÅ5àgHüÂtÍ?W6F¯E\nx²/pNð?Êy»t¿®Ü¬er ±Ú9&d×\f".getBytes("ISO_8859_1");
        Object[] objectArray = "5ú¸".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1750886126;
                case 1 -> 1364432092;
                case 2 -> 90975989;
                case 3 -> 1474450794;
                case 4 -> -1204619794;
                case 5 -> -1016154238;
                case 6 -> -651303387;
                case 7 -> 634354407;
                case 8 -> 1460566639;
                case 9 -> 1926224102;
                case 10 -> 1077056562;
                case 11 -> -1358242023;
                case 12 -> -1928251314;
                case 13 -> -1383107070;
                case 14 -> -35775162;
                case 15 -> -137536433;
                case 16 -> -299220707;
                case 17 -> 1235720946;
                case 18 -> 303335425;
                case 19 -> 1623081529;
                case 20 -> -1375462967;
                case 21 -> 1049848067;
                case 22 -> -481633848;
                case 23 -> 1723101520;
                case 24 -> -1397375254;
                case 25 -> -206242451;
                case 26 -> -313233797;
                case 27 -> -562828984;
                case 28 -> 174260076;
                case 29 -> -1640396501;
                case 30 -> -1730238012;
                case 31 -> -1844872753;
                case 32 -> 1895228253;
                case 33 -> -1372585409;
                case 34 -> -1066151924;
                case 35 -> -1420002151;
                case 36 -> -1971569926;
                case 37 -> -620306337;
                case 38 -> 670650398;
                case 39 -> -1633109684;
                case 40 -> -163206313;
                case 41 -> -1880510962;
                case 42 -> 170716600;
                case 43 -> -1106193010;
                case 44 -> -262679770;
                case 45 -> 12547134;
                case 46 -> -806914537;
                case 47 -> 1469839878;
                case 48 -> 178081378;
                case 49 -> 219627104;
                case 50 -> -299692537;
                case 51 -> 787975073;
                case 52 -> 664120712;
                case 53 -> -949992939;
                case 54 -> -449959475;
                case 55 -> 1719671879;
                case 56 -> 128830382;
                case 57 -> 1084189800;
                case 58 -> -61622428;
                case 59 -> -39647735;
                case 60 -> 1853944267;
                case 61 -> 1672236864;
                case 62 -> -590072083;
                case 63 -> 266090419;
                case 64 -> 1093123332;
                case 65 -> -1021590469;
                case 66 -> -728589423;
                case 67 -> -39178018;
                case 68 -> 733138115;
                case 69 -> 1386134898;
                case 70 -> -1215085514;
                case 71 -> -905164304;
                case 72 -> -683900917;
                case 73 -> -335542726;
                case 74 -> -291869769;
                case 75 -> -910318244;
                case 76 -> -1797357808;
                case 77 -> 290718096;
                case 78 -> -736441390;
                case 79 -> 2007070656;
                case 80 -> -2121487589;
                case 81 -> -1248223577;
                case 82 -> -1770230310;
                case 83 -> -235176093;
                case 84 -> -2069840118;
                case 85 -> -1824778630;
                case 86 -> 718197802;
                case 87 -> -2007375857;
                case 88 -> 1946079910;
                case 89 -> 551102079;
                case 90 -> -1669796723;
                case 91 -> 2026090939;
                case 92 -> -26452059;
                case 93 -> -257437153;
                case 94 -> 413961764;
                case 95 -> -971900420;
                case 96 -> 1949867926;
                case 97 -> -501744669;
                case 98 -> 1317694264;
                case 99 -> 395241541;
                case 100 -> -387034376;
                case 101 -> 939735856;
                case 102 -> 708751332;
                case 103 -> 491881158;
                case 104 -> -1816904745;
                case 105 -> 1414259281;
                case 106 -> 288208692;
                case 107 -> -1282797932;
                case 108 -> 2021849412;
                case 109 -> -2075198599;
                case 110 -> -892623242;
                case 111 -> 1129710767;
                case 112 -> -945029472;
                case 113 -> 744144230;
                case 114 -> 1412479891;
                case 115 -> -537376447;
                case 116 -> -1667842009;
                case 117 -> 2074792895;
                case 118 -> 1462214855;
                case 119 -> -1245911951;
                case 120 -> -984187651;
                case 121 -> 713051458;
                case 122 -> -1349374157;
                case 123 -> 1251842312;
                case 124 -> -2079584048;
                case 125 -> 553857978;
                case 126 -> -690727295;
                case 127 -> 841940741;
                case 128 -> 506255470;
                case 129 -> 335022973;
                case 130 -> -1413738024;
                case 131 -> 1957953326;
                case 132 -> -167737254;
                case 133 -> 1949552009;
                case 134 -> -1990675659;
                case 135 -> 1857019260;
                case 136 -> -1791661299;
                case 137 -> -1822619559;
                case 138 -> 396553831;
                case 139 -> 690828251;
                case 140 -> -846491301;
                case 141 -> -1271839469;
                case 142 -> -1996863391;
                case 143 -> -1921878638;
                case 144 -> 193772931;
                case 145 -> 980542146;
                case 146 -> -694943316;
                case 147 -> -1220348695;
                case 148 -> 1615869751;
                case 149 -> 923528824;
                case 150 -> -12416451;
                case 151 -> -2125105235;
                case 152 -> 799458582;
                case 153 -> -1002255248;
                case 154 -> -1094969617;
                case 155 -> 379049365;
                case 156 -> -117677947;
                case 157 -> -1277323018;
                case 158 -> -889592135;
                case 159 -> 1516843178;
                case 160 -> 1342343273;
                case 161 -> -489447227;
                case 162 -> 2024886004;
                case 163 -> -1066749396;
                case 164 -> -670089284;
                case 165 -> -1963694250;
                case 166 -> 42116904;
                case 167 -> 1008794589;
                case 168 -> 1330247971;
                case 169 -> 1472987764;
                case 170 -> 1334419864;
                case 171 -> 933141900;
                case 172 -> 1585523867;
                case 173 -> 281855572;
                case 174 -> 1891476478;
                case 175 -> -1861074600;
                case 176 -> -1122487320;
                case 177 -> -741107207;
                case 178 -> -2008531891;
                case 179 -> -275156864;
                case 180 -> 522632839;
                case 181 -> 548167578;
                case 182 -> 98747058;
                case 183 -> -362608160;
                case 184 -> -2082472333;
                case 185 -> 479219376;
                case 186 -> 648785316;
                case 187 -> -2143625438;
                case 188 -> -1796654052;
                case 189 -> 1139812437;
                case 190 -> 955731612;
                case 191 -> -615901533;
                case 192 -> 1907139974;
                case 193 -> 1165534481;
                case 194 -> -56173523;
                case 195 -> -613538715;
                case 196 -> 623794621;
                case 197 -> -1956674402;
                case 198 -> -2117331692;
                case 199 -> 188915505;
                case 200 -> 515317419;
                case 201 -> 1542201297;
                case 202 -> -2129734476;
                case 203 -> -2028456213;
                case 204 -> -418823383;
                case 205 -> -803837636;
                case 206 -> 1722638293;
                case 207 -> -1412069933;
                case 208 -> 1510572361;
                case 209 -> -1018974208;
                case 210 -> 826761142;
                case 211 -> -1268477211;
                case 212 -> 1628373621;
                case 213 -> 1910022306;
                case 214 -> 338603515;
                case 215 -> 2031759136;
                case 216 -> 1370147691;
                case 217 -> -1580448834;
                case 218 -> 821588657;
                case 219 -> 1806865622;
                case 220 -> 283650473;
                case 221 -> -790621460;
                case 222 -> 414993655;
                case 223 -> 1850794135;
                case 224 -> 554498081;
                case 225 -> 735923357;
                case 226 -> 1914070647;
                case 227 -> -358261372;
                case 228 -> 419024715;
                case 229 -> -1317526838;
                case 230 -> -1461929169;
                case 231 -> 1647881953;
                case 232 -> 1303865882;
                case 233 -> 1316843935;
                case 234 -> -288948299;
                case 235 -> -1072148598;
                case 236 -> -507518125;
                case 237 -> 1878531240;
                case 238 -> -1001662770;
                case 239 -> -788332149;
                case 240 -> -9987367;
                case 241 -> 927415370;
                case 242 -> 1710051295;
                case 243 -> 670700785;
                case 244 -> -709703988;
                case 245 -> 1810805474;
                case 246 -> -1353063912;
                case 247 -> 872850014;
                case 248 -> 1847731699;
                case 249 -> 2071977854;
                case 250 -> -1704568620;
                case 251 -> -1487915694;
                case 252 -> -1613611521;
                case 253 -> 1502643343;
                case 254 -> 2000181441;
                case 255 -> 1771331395;
                default -> 367927351;
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
            Object[] objectArray2 = new Object[5];
            objectArray = objectArray2;
            aaaaaD = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaB = new aaaaah(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaai.aaaabx((char)806289410)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaai.aaaabx((char)1759969283)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaai::你为什么要破解我的代码aaaabv, aaaaai::你为什么要破解我的代码aaaabw);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaai.aaaabx((char)972423172)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaabx(char c) {
        return ((Object[])aaaaaD)[c];
    }
}

