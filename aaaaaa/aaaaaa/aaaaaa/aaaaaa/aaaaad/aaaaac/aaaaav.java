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

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaP;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaat;
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

public final class aaaaav
implements class_8710 {
    @NotNull
    public static final aaaaat 我草你怎么反编译我模组aaaaaW;
    private final int 我草你怎么反编译我模组aaaaaX;
    private final int 我草你怎么反编译我模组aaaaaY;
    private final int 我草你怎么反编译我模组aaaaaZ;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaav> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaav> 我草你怎么反编译我模组aaaaai;
    static Object aaaaba;

    public aaaaav(int n, int n2, int n3) {
        this.我草你怎么反编译我模组aaaaaX = n;
        this.我草你怎么反编译我模组aaaaaY = n2;
        this.我草你怎么反编译我模组aaaaaZ = n3;
    }

    public final int 你为什么要破解我的代码aaaacq() {
        return this.我草你怎么反编译我模组aaaaaX;
    }

    public final int 你为什么要破解我的代码aaaacr() {
        return this.我草你怎么反编译我模组aaaaaY;
    }

    public final int 你为什么要破解我的代码aaaacs() {
        return this.我草你怎么反编译我模组aaaaaZ;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaav::你为什么要破解我的代码aaaacv);
    }

    @NotNull
    public class_8710.class_9154<aaaaav> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final int 你为什么要破解我的代码aaaaaw() {
        return this.我草你怎么反编译我模组aaaaaX;
    }

    public final int 你为什么要破解我的代码aaaaai() {
        return this.我草你怎么反编译我模组aaaaaY;
    }

    public final int 你为什么要破解我的代码aaaaaj() {
        return this.我草你怎么反编译我模组aaaaaZ;
    }

    @NotNull
    public final aaaaav 你为什么要破解我的代码aaaact(int n, int n2, int n3) {
        return new aaaaav(n, n2, n3);
    }

    public static /* synthetic */ aaaaav 你为什么要破解我的代码aaaacu(aaaaav aaaaav2, int n, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n = aaaaav2.我草你怎么反编译我模组aaaaaX;
        }
        if ((n4 & 2) != 0) {
            n2 = aaaaav2.我草你怎么反编译我模组aaaaaY;
        }
        if ((n4 & 4) != 0) {
            n3 = aaaaav2.我草你怎么反编译我模组aaaaaZ;
        }
        return aaaaav2.你为什么要破解我的代码aaaact(n, n2, n3);
    }

    @NotNull
    public String toString() {
        return "PeakChallengeSettingsPayload(timeChange=" + this.我草你怎么反编译我模组aaaaaX + ", newMaxChallenge=" + this.我草你怎么反编译我模组aaaaaY + ", height=" + this.我草你怎么反编译我模组aaaaaZ + ")";
    }

    public int hashCode() {
        int n = Integer.hashCode((int)this.我草你怎么反编译我模组aaaaaX);
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaaaY);
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaaaZ);
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaav)) {
            return false;
        }
        aaaaav aaaaav2 = (aaaaav)object;
        if (this.我草你怎么反编译我模组aaaaaX != aaaaav2.我草你怎么反编译我模组aaaaaX) {
            return false;
        }
        if (this.我草你怎么反编译我模组aaaaaY != aaaaav2.我草你怎么反编译我模组aaaaaY) {
            return false;
        }
        return this.我草你怎么反编译我模组aaaaaZ == aaaaav2.我草你怎么反编译我模组aaaaaZ;
    }

    private static final void 你为什么要破解我的代码aaaacv(aaaaav aaaaav2, ServerPlayNetworking.Context context) {
        int n = aaaaav2.你为什么要破解我的代码aaaaaw();
        int n2 = aaaaav2.你为什么要破解我的代码aaaaai();
        int n3 = aaaaav2.你为什么要破解我的代码aaaaaj();
        int n4 = aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaaeQ();
        int n5 = n4 + n;
        aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaaeT(n5);
        aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaaeS(aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaaeR() + n);
        aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaaag(n2);
        aaaaaP.我草你怎么反编译我模组aaaabK.你为什么要破解我的代码aaaafz(n3, true, false);
    }

    private static final void 你为什么要破解我的代码aaaacw(aaaaav aaaaav2, class_2540 class_25402) {
        class_25402.method_53002(aaaaav2.我草你怎么反编译我模组aaaaaX);
        class_25402.method_53002(aaaaav2.我草你怎么反编译我模组aaaaaY);
        class_25402.method_53002(aaaaav2.我草你怎么反编译我模组aaaaaZ);
    }

    private static final aaaaav 你为什么要破解我的代码aaaacx(class_2540 class_25402) {
        return new aaaaav(class_25402.readInt(), class_25402.readInt(), class_25402.readInt());
    }

    static {
        byte[] byArray = "/\\}f\\8ÔqÞ ­tEªjíÖÖmI|õ¨¬ÍÈò5C4Èd!¡¼$lw¤1°òòÉ¼ÉÕìá|ì,\ni|¡j4S«".getBytes("ISO_8859_1");
        Object[] objectArray = " ±È\fQº\t".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1039660345;
                case 1 -> 1672720060;
                case 2 -> 963184378;
                case 3 -> -2107100390;
                case 4 -> 680678237;
                case 5 -> -412869242;
                case 6 -> -818495640;
                case 7 -> -347599646;
                case 8 -> 819792160;
                case 9 -> 1134783598;
                case 10 -> -1904022332;
                case 11 -> 504101688;
                case 12 -> -1157778725;
                case 13 -> -1792986545;
                case 14 -> 2116571475;
                case 15 -> 254791065;
                case 16 -> 2003781963;
                case 17 -> 1361982307;
                case 18 -> 1882927060;
                case 19 -> -1974316388;
                case 20 -> 661971695;
                case 21 -> -1687341506;
                case 22 -> -2163717;
                case 23 -> 960719865;
                case 24 -> 1313683480;
                case 25 -> 211576019;
                case 26 -> -1436653572;
                case 27 -> 471533948;
                case 28 -> -539305085;
                case 29 -> 125866155;
                case 30 -> 1670360812;
                case 31 -> 936247843;
                case 32 -> 878583411;
                case 33 -> -1446259599;
                case 34 -> -1480957465;
                case 35 -> 681566914;
                case 36 -> -1122301285;
                case 37 -> -1402118709;
                case 38 -> -556588848;
                case 39 -> -1709237531;
                case 40 -> 680982519;
                case 41 -> 693131277;
                case 42 -> -382405790;
                case 43 -> 1229664638;
                case 44 -> -1413570328;
                case 45 -> -2006168804;
                case 46 -> -599309417;
                case 47 -> -312813563;
                case 48 -> -385961824;
                case 49 -> -1687591459;
                case 50 -> 2029688875;
                case 51 -> 445779812;
                case 52 -> -1402585566;
                case 53 -> -1036027704;
                case 54 -> 1576375629;
                case 55 -> 922136705;
                case 56 -> 1032565516;
                case 57 -> 1818146578;
                case 58 -> -1225856104;
                case 59 -> -592177338;
                case 60 -> 39971881;
                case 61 -> 1163749003;
                case 62 -> 2034774834;
                case 63 -> 1608823241;
                case 64 -> 1387579993;
                case 65 -> 974525153;
                case 66 -> -1765219732;
                case 67 -> -1753040888;
                case 68 -> -1209968052;
                case 69 -> 1742079541;
                case 70 -> -510145674;
                case 71 -> -508601335;
                case 72 -> 147803538;
                case 73 -> 452202402;
                case 74 -> 1267000832;
                case 75 -> -1533929445;
                case 76 -> 1417050944;
                case 77 -> -1323055381;
                case 78 -> 1302089820;
                case 79 -> 755502223;
                case 80 -> -426468562;
                case 81 -> 1851388446;
                case 82 -> 1729540418;
                case 83 -> -847937363;
                case 84 -> -1075549373;
                case 85 -> -849692683;
                case 86 -> 55216209;
                case 87 -> -276172143;
                case 88 -> 241758834;
                case 89 -> 1196597034;
                case 90 -> -1467677631;
                case 91 -> 2112445975;
                case 92 -> -797662170;
                case 93 -> -194526033;
                case 94 -> -51877465;
                case 95 -> -1800169547;
                case 96 -> 792560612;
                case 97 -> 1111527754;
                case 98 -> 232335696;
                case 99 -> -468919943;
                case 100 -> -246643249;
                case 101 -> -1856900009;
                case 102 -> -379438113;
                case 103 -> 475593958;
                case 104 -> -349706055;
                case 105 -> 513730585;
                case 106 -> 1116488455;
                case 107 -> 990702390;
                case 108 -> -1568855282;
                case 109 -> -1045447166;
                case 110 -> -1054171472;
                case 111 -> -1492107974;
                case 112 -> -1761025925;
                case 113 -> -970488218;
                case 114 -> 777810699;
                case 115 -> -421324513;
                case 116 -> 1372033599;
                case 117 -> 1505915483;
                case 118 -> -936424744;
                case 119 -> -413480143;
                case 120 -> -2015601066;
                case 121 -> -2098185800;
                case 122 -> 1001638520;
                case 123 -> 2047454450;
                case 124 -> 810488426;
                case 125 -> 1978247347;
                case 126 -> -1666404535;
                case 127 -> -57854096;
                case 128 -> 1535960372;
                case 129 -> 105971114;
                case 130 -> -401929328;
                case 131 -> 944212163;
                case 132 -> 917774569;
                case 133 -> 1180747517;
                case 134 -> 1642750126;
                case 135 -> 448235501;
                case 136 -> -865846271;
                case 137 -> -1968881101;
                case 138 -> 1408384180;
                case 139 -> 737511190;
                case 140 -> 2119264460;
                case 141 -> -1367828775;
                case 142 -> 757746231;
                case 143 -> -921690365;
                case 144 -> -1485609330;
                case 145 -> -902148644;
                case 146 -> -743895338;
                case 147 -> 1834971380;
                case 148 -> 1939157694;
                case 149 -> -2067862398;
                case 150 -> -1705721120;
                case 151 -> 1856191651;
                case 152 -> 1871443085;
                case 153 -> -1107516604;
                case 154 -> -193918736;
                case 155 -> -836604012;
                case 156 -> 716249364;
                case 157 -> -1111075378;
                case 158 -> -718578205;
                case 159 -> 1531509686;
                case 160 -> 262448443;
                case 161 -> 381060545;
                case 162 -> 100896262;
                case 163 -> -1263849775;
                case 164 -> 1293554142;
                case 165 -> -1887444599;
                case 166 -> 1930206206;
                case 167 -> 2032398271;
                case 168 -> -1060941697;
                case 169 -> 737246269;
                case 170 -> -86657465;
                case 171 -> -1774882906;
                case 172 -> -1416446111;
                case 173 -> -1487342776;
                case 174 -> 814900183;
                case 175 -> 1495945117;
                case 176 -> -255448930;
                case 177 -> -1412629894;
                case 178 -> 1561584239;
                case 179 -> 669991336;
                case 180 -> 2109349202;
                case 181 -> -510711160;
                case 182 -> 93670772;
                case 183 -> 1534831089;
                case 184 -> -2002369119;
                case 185 -> -1352925238;
                case 186 -> 696204110;
                case 187 -> 304201159;
                case 188 -> -1118277292;
                case 189 -> -1939057832;
                case 190 -> 157203354;
                case 191 -> 1250242081;
                case 192 -> 1779271262;
                case 193 -> -144974743;
                case 194 -> -1667829414;
                case 195 -> -1434363194;
                case 196 -> -656107579;
                case 197 -> 643591629;
                case 198 -> 1343472618;
                case 199 -> -566851280;
                case 200 -> 1566162943;
                case 201 -> -44696516;
                case 202 -> 1639401914;
                case 203 -> -49821430;
                case 204 -> 771462077;
                case 205 -> -1307591018;
                case 206 -> 1101196928;
                case 207 -> 1120487797;
                case 208 -> -228116572;
                case 209 -> 897499949;
                case 210 -> 521700989;
                case 211 -> 888761257;
                case 212 -> 1506048352;
                case 213 -> 807073932;
                case 214 -> -373375606;
                case 215 -> -321071331;
                case 216 -> 129791272;
                case 217 -> 1440970053;
                case 218 -> 215456178;
                case 219 -> 1241009503;
                case 220 -> 1920640293;
                case 221 -> -1983418841;
                case 222 -> 1739524050;
                case 223 -> -1159134758;
                case 224 -> -990813419;
                case 225 -> -1212597035;
                case 226 -> 544383503;
                case 227 -> -1354318972;
                case 228 -> -1432862281;
                case 229 -> 1023760237;
                case 230 -> -201120977;
                case 231 -> -1572270332;
                case 232 -> -697583509;
                case 233 -> -270586888;
                case 234 -> 1499677543;
                case 235 -> -1516544266;
                case 236 -> -1285875776;
                case 237 -> 1706173333;
                case 238 -> -378609165;
                case 239 -> -329158125;
                case 240 -> -1580550469;
                case 241 -> -1947901935;
                case 242 -> -423574095;
                case 243 -> -1171721825;
                case 244 -> 1906164101;
                case 245 -> 1420092039;
                case 246 -> -581151316;
                case 247 -> 1453454380;
                case 248 -> -73646251;
                case 249 -> 2032873454;
                case 250 -> 823396388;
                case 251 -> -272925851;
                case 252 -> 1027544485;
                case 253 -> -1053641837;
                case 254 -> 469529616;
                case 255 -> 1046907255;
                default -> -1607128248;
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
            Object[] objectArray2 = new Object[3];
            objectArray = objectArray2;
            aaaaba = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaW = new aaaaat(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaav.aaaacy((char)1469579264)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaav.aaaacy((char)-1862664191)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaav::你为什么要破解我的代码aaaacw, aaaaav::你为什么要破解我的代码aaaacx);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaav.aaaacy((char)186122242)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaacy(char c) {
        return ((Object[])aaaaba)[c];
    }
}

