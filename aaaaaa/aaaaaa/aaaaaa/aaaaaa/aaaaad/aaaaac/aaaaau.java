/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
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

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacs;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaax;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaak.aaaaaa;
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

public final class aaaaau
implements class_8710 {
    @NotNull
    public static final aaaaax 我草你怎么反编译我模组aaaaaT;
    private final boolean 我草你怎么反编译我模组aaaaab;
    private final int 我草你怎么反编译我模组aaaaaU;
    private final int 我草你怎么反编译我模组aaaaaV;
    private final int 我草你怎么反编译我模组aaaaae;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaau> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaau> 我草你怎么反编译我模组aaaaai;
    static Object aaaaaW;

    public aaaaau(boolean bl, int n, int n2, int n3) {
        this.我草你怎么反编译我模组aaaaab = bl;
        this.我草你怎么反编译我模组aaaaaU = n;
        this.我草你怎么反编译我模组aaaaaV = n2;
        this.我草你怎么反编译我模组aaaaae = n3;
    }

    public final boolean 你为什么要破解我的代码aaaaaa() {
        return this.我草你怎么反编译我模组aaaaab;
    }

    public final int 你为什么要破解我的代码aaaacg() {
        return this.我草你怎么反编译我模组aaaaaU;
    }

    public final int 你为什么要破解我的代码aaaach() {
        return this.我草你怎么反编译我模组aaaaaV;
    }

    public final int 你为什么要破解我的代码aaaaad() {
        return this.我草你怎么反编译我模组aaaaae;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, (arg_0, arg_1) -> aaaaau.你为什么要破解我的代码aaaacn(this, arg_0, arg_1));
    }

    private final void 你为什么要破解我的代码aaaaci(aaaaau aaaaau2) {
        boolean bl;
        boolean bl2 = aaaaau2.你为什么要破解我的代码aaaaah();
        int n = aaaaau2.你为什么要破解我的代码aaaaai();
        int n2 = aaaaau2.你为什么要破解我的代码aaaaaj();
        int n3 = aaaaau2.你为什么要破解我的代码aaaaak();
        if (bl2) {
            this.你为什么要破解我的代码aaaacj();
            return;
        }
        int n4 = aaaaax.你为什么要破解我的代码aaaaab(我草你怎么反编译我模组aaaaaT, (String)aaaaau.aaaacq((char)448069632), 23);
        int n5 = aaaaax.你为什么要破解我的代码aaaaab(我草你怎么反编译我模组aaaaaT, (String)aaaaau.aaaacq((char)717094913), 23);
        int n6 = aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaaf();
        boolean bl3 = n4 != n || n5 != n2;
        boolean bl4 = bl = n6 != n3;
        if (!bl3 && !bl) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaau.aaaacq((char)-553517054));
            return;
        }
        if (bl3) {
            this.你为什么要破解我的代码aaaack(n4, n5, n, n2);
        }
        if (bl) {
            this.你为什么要破解我的代码aaaaav(n3);
        }
    }

    private final void 你为什么要破解我的代码aaaacj() {
        aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaku(true);
        aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaag(20);
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaau.aaaacq((char)-1396768765));
    }

    private final void 你为什么要破解我的代码aaaack(int n, int n2, int n3, int n4) {
        if (n != n3) {
            aaaaaa.你为什么要破解我的代码aaaaad(aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaaa(), (String)aaaaau.aaaacq((char)1005322240), n3);
            aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaom(n3);
            aaaaab.你为什么要破解我的代码aaaaaa().info("更新区域X: " + n + " -> " + n3);
        }
        if (n2 != n4) {
            aaaaaa.你为什么要破解我的代码aaaaad(aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaaa(), (String)aaaaau.aaaacq((char)-336068607), n4);
            aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaon(n4);
            aaaaab.你为什么要破解我的代码aaaaaa().info("更新区域Z: " + n2 + " -> " + n4);
        }
    }

    private final void 你为什么要破解我的代码aaaaav(int n) {
        aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaag(n);
        aaaaab.你为什么要破解我的代码aaaaaa().info("更新挑战次数: " + aaaacs.我草你怎么反编译我模组aaaaep.你为什么要破解我的代码aaaaaf() + " -> " + n);
    }

    @NotNull
    public class_8710.class_9154<aaaaau> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final boolean 你为什么要破解我的代码aaaaah() {
        return this.我草你怎么反编译我模组aaaaab;
    }

    public final int 你为什么要破解我的代码aaaaai() {
        return this.我草你怎么反编译我模组aaaaaU;
    }

    public final int 你为什么要破解我的代码aaaaaj() {
        return this.我草你怎么反编译我模组aaaaaV;
    }

    public final int 你为什么要破解我的代码aaaaak() {
        return this.我草你怎么反编译我模组aaaaae;
    }

    @NotNull
    public final aaaaau 你为什么要破解我的代码aaaacl(boolean bl, int n, int n2, int n3) {
        return new aaaaau(bl, n, n2, n3);
    }

    public static /* synthetic */ aaaaau 你为什么要破解我的代码aaaacm(aaaaau aaaaau2, boolean bl, int n, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            bl = aaaaau2.我草你怎么反编译我模组aaaaab;
        }
        if ((n4 & 2) != 0) {
            n = aaaaau2.我草你怎么反编译我模组aaaaaU;
        }
        if ((n4 & 4) != 0) {
            n2 = aaaaau2.我草你怎么反编译我模组aaaaaV;
        }
        if ((n4 & 8) != 0) {
            n3 = aaaaau2.我草你怎么反编译我模组aaaaae;
        }
        return aaaaau2.你为什么要破解我的代码aaaacl(bl, n, n2, n3);
    }

    @NotNull
    public String toString() {
        return "WheatGuardianSettingsPayload(isReset=" + this.我草你怎么反编译我模组aaaaab + ", areaX=" + this.我草你怎么反编译我模组aaaaaU + ", areaZ=" + this.我草你怎么反编译我模组aaaaaV + ", challengeNum=" + this.我草你怎么反编译我模组aaaaae + ")";
    }

    public int hashCode() {
        int n = Boolean.hashCode((boolean)this.我草你怎么反编译我模组aaaaab);
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaaaU);
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaaaV);
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaaae);
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaau)) {
            return false;
        }
        aaaaau aaaaau2 = (aaaaau)object;
        if (this.我草你怎么反编译我模组aaaaab != aaaaau2.我草你怎么反编译我模组aaaaab) {
            return false;
        }
        if (this.我草你怎么反编译我模组aaaaaU != aaaaau2.我草你怎么反编译我模组aaaaaU) {
            return false;
        }
        if (this.我草你怎么反编译我模组aaaaaV != aaaaau2.我草你怎么反编译我模组aaaaaV) {
            return false;
        }
        return this.我草你怎么反编译我模组aaaaae == aaaaau2.我草你怎么反编译我模组aaaaae;
    }

    private static final void 你为什么要破解我的代码aaaacn(aaaaau aaaaau2, aaaaau aaaaau3, ServerPlayNetworking.Context context) {
        Intrinsics.checkNotNullParameter((Object)aaaaau2, (String)((String)aaaaau.aaaacq((char)947912708)));
        Intrinsics.checkNotNull((Object)aaaaau3);
        aaaaau2.你为什么要破解我的代码aaaaci(aaaaau3);
    }

    private static final void 你为什么要破解我的代码aaaaco(aaaaau aaaaau2, class_2540 class_25402) {
        class_25402.method_52964(aaaaau2.我草你怎么反编译我模组aaaaab);
        class_25402.method_53002(aaaaau2.我草你怎么反编译我模组aaaaaU);
        class_25402.method_53002(aaaaau2.我草你怎么反编译我模组aaaaaV);
        class_25402.method_53002(aaaaau2.我草你怎么反编译我模组aaaaae);
    }

    private static final aaaaau 你为什么要破解我的代码aaaacp(class_2540 class_25402) {
        return new aaaaau(class_25402.readBoolean(), class_25402.readInt(), class_25402.readInt(), class_25402.readInt());
    }

    static {
        byte[] byArray = "àµãÕË<ÊHÐlî¨ÿß¤K  3 Êîç1»JK¶ô{¸ÔûáO)#Fk*SüÜ¯ìÛWÂKéÀ?\rÈñEIÙZöÃ,F·£Ï' E»ª*¸p1@qùrPTT:rµÄ;òu°UÙ¿ëè1ªÄ¤á§gNäI÷d¨£yá2ó¯!×F|z|¶S¢Úû^ÀQª".getBytes("ISO_8859_1");
        Object[] objectArray = "õV«Å¬ÊÑB".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1399515597;
                case 1 -> -1544237064;
                case 2 -> -559601091;
                case 3 -> 1087365430;
                case 4 -> -1535184675;
                case 5 -> 1949131300;
                case 6 -> -967839022;
                case 7 -> -1015943397;
                case 8 -> -540897469;
                case 9 -> 1953608997;
                case 10 -> 737742618;
                case 11 -> 247044224;
                case 12 -> 1484601347;
                case 13 -> 758028713;
                case 14 -> 1517634401;
                case 15 -> -1681303749;
                case 16 -> -115761071;
                case 17 -> 1819113300;
                case 18 -> 406255650;
                case 19 -> 1165146159;
                case 20 -> 159853436;
                case 21 -> 1863394477;
                case 22 -> -1734651938;
                case 23 -> -2116031712;
                case 24 -> 596306043;
                case 25 -> 1650263229;
                case 26 -> 819673460;
                case 27 -> 837099806;
                case 28 -> -430894279;
                case 29 -> 227693647;
                case 30 -> -622727519;
                case 31 -> -1227115954;
                case 32 -> -1431578623;
                case 33 -> -2082953167;
                case 34 -> 479875572;
                case 35 -> -678149380;
                case 36 -> 685155581;
                case 37 -> -463207854;
                case 38 -> 56157698;
                case 39 -> -603172901;
                case 40 -> 342050437;
                case 41 -> -350488162;
                case 42 -> 287341682;
                case 43 -> -1318655650;
                case 44 -> -1922524045;
                case 45 -> -1137907496;
                case 46 -> 148620026;
                case 47 -> 1399814849;
                case 48 -> 761306690;
                case 49 -> 1378162127;
                case 50 -> -947500958;
                case 51 -> -773266748;
                case 52 -> -727845354;
                case 53 -> 97338904;
                case 54 -> -555501431;
                case 55 -> 760892246;
                case 56 -> 18845658;
                case 57 -> 437073110;
                case 58 -> -1962129850;
                case 59 -> -869371571;
                case 60 -> -754276556;
                case 61 -> 841078872;
                case 62 -> 989961384;
                case 63 -> 890328595;
                case 64 -> 1283088695;
                case 65 -> 1450475919;
                case 66 -> 502253196;
                case 67 -> 163810524;
                case 68 -> 1272836271;
                case 69 -> 968826591;
                case 70 -> -1628314328;
                case 71 -> 1566151493;
                case 72 -> 403488983;
                case 73 -> -300200512;
                case 74 -> 409642181;
                case 75 -> -1789856466;
                case 76 -> -1781907927;
                case 77 -> 492762186;
                case 78 -> 981254194;
                case 79 -> 625745360;
                case 80 -> -840356175;
                case 81 -> 721587822;
                case 82 -> 372252682;
                case 83 -> -320792372;
                case 84 -> -740778182;
                case 85 -> -990219872;
                case 86 -> -1399572208;
                case 87 -> -1929988546;
                case 88 -> 1281554858;
                case 89 -> 1169008653;
                case 90 -> 2130235969;
                case 91 -> 569294183;
                case 92 -> 1577695617;
                case 93 -> -1463146041;
                case 94 -> 1734502208;
                case 95 -> -661445057;
                case 96 -> 770621801;
                case 97 -> -1872784669;
                case 98 -> -152067784;
                case 99 -> 1755811860;
                case 100 -> -806984431;
                case 101 -> 480684195;
                case 102 -> 2134489929;
                case 103 -> -1335925209;
                case 104 -> -1134848821;
                case 105 -> -395493343;
                case 106 -> -1944989494;
                case 107 -> 990669975;
                case 108 -> 358729800;
                case 109 -> -343715174;
                case 110 -> -124171070;
                case 111 -> 576755699;
                case 112 -> -874081128;
                case 113 -> -50371815;
                case 114 -> -2049696622;
                case 115 -> 1608090156;
                case 116 -> -1196488833;
                case 117 -> 771588646;
                case 118 -> 1035420005;
                case 119 -> -1432694627;
                case 120 -> 149631231;
                case 121 -> -874677971;
                case 122 -> 1419700711;
                case 123 -> 2019577545;
                case 124 -> -1511225999;
                case 125 -> -331741654;
                case 126 -> 1078149296;
                case 127 -> -1383614854;
                case 128 -> 422703010;
                case 129 -> 1847339355;
                case 130 -> 2129886469;
                case 131 -> 868045173;
                case 132 -> -1815692988;
                case 133 -> 680190803;
                case 134 -> -262997671;
                case 135 -> -1076500977;
                case 136 -> 1344258738;
                case 137 -> -272043069;
                case 138 -> -1840493368;
                case 139 -> -384586461;
                case 140 -> 1114933227;
                case 141 -> 1704422282;
                case 142 -> 497726987;
                case 143 -> -1380239900;
                case 144 -> -1689782421;
                case 145 -> 1995255304;
                case 146 -> 235558926;
                case 147 -> 632848609;
                case 148 -> -860932625;
                case 149 -> -1744787959;
                case 150 -> -1932262683;
                case 151 -> 1935913823;
                case 152 -> -1155357290;
                case 153 -> 1870812642;
                case 154 -> -150890420;
                case 155 -> -1351082729;
                case 156 -> 1485302630;
                case 157 -> -1195637748;
                case 158 -> 95705590;
                case 159 -> 1061652835;
                case 160 -> -773209738;
                case 161 -> -885937532;
                case 162 -> 1115060871;
                case 163 -> -1772156688;
                case 164 -> -1875065447;
                case 165 -> -627152710;
                case 166 -> 1704326022;
                case 167 -> 644982320;
                case 168 -> -790713451;
                case 169 -> -1527177225;
                case 170 -> -1885443310;
                case 171 -> 884002167;
                case 172 -> 1836019036;
                case 173 -> -1160675650;
                case 174 -> 1255445740;
                case 175 -> 1778464211;
                case 176 -> 1383751811;
                case 177 -> -1039165013;
                case 178 -> -1225427009;
                case 179 -> 1727439737;
                case 180 -> 190797176;
                case 181 -> 1093492659;
                case 182 -> -996117877;
                case 183 -> 208661148;
                case 184 -> -28693579;
                case 185 -> 2057469182;
                case 186 -> -1896156280;
                case 187 -> -649078172;
                case 188 -> 1728671701;
                case 189 -> 1253083266;
                case 190 -> -1920390474;
                case 191 -> -60351589;
                case 192 -> -1451559907;
                case 193 -> -1907980032;
                case 194 -> -433636178;
                case 195 -> 40771680;
                case 196 -> 776963381;
                case 197 -> 1703945211;
                case 198 -> -1144864332;
                case 199 -> 1244507413;
                case 200 -> 89461831;
                case 201 -> 1228279302;
                case 202 -> 439124116;
                case 203 -> 1206360053;
                case 204 -> 25760206;
                case 205 -> -610624570;
                case 206 -> 2119614425;
                case 207 -> -1275540452;
                case 208 -> -752173488;
                case 209 -> 683042416;
                case 210 -> -455827908;
                case 211 -> -758599093;
                case 212 -> -719342329;
                case 213 -> -2065267587;
                case 214 -> 1924353492;
                case 215 -> 1420392100;
                case 216 -> 1132132832;
                case 217 -> -566311958;
                case 218 -> -284290712;
                case 219 -> -829429634;
                case 220 -> 1931032997;
                case 221 -> 1644678916;
                case 222 -> 1514827191;
                case 223 -> 1740691640;
                case 224 -> 1548430061;
                case 225 -> 708464748;
                case 226 -> 2063199163;
                case 227 -> 670907247;
                case 228 -> 1991318258;
                case 229 -> -364554770;
                case 230 -> 2083733415;
                case 231 -> -459967126;
                case 232 -> 16328541;
                case 233 -> -2004901779;
                case 234 -> -32709402;
                case 235 -> 1683982502;
                case 236 -> 2120461399;
                case 237 -> 1334355999;
                case 238 -> -889236527;
                case 239 -> 705896697;
                case 240 -> 2080892137;
                case 241 -> 299329621;
                case 242 -> -728402029;
                case 243 -> -716593520;
                case 244 -> -1156789926;
                case 245 -> -1224589336;
                case 246 -> -80343253;
                case 247 -> 328191420;
                case 248 -> 967355551;
                case 249 -> 1194103757;
                case 250 -> 1345915820;
                case 251 -> 1071210126;
                case 252 -> 1962677645;
                case 253 -> -1967396463;
                case 254 -> 321397745;
                case 255 -> -1770052679;
                default -> -1207769467;
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
            Object[] objectArray2 = new Object[8];
            objectArray = objectArray2;
            aaaaaW = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaT = new aaaaax(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaau.aaaacq((char)756613125)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaau.aaaacq((char)1190199302)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaau::你为什么要破解我的代码aaaaco, aaaaau::你为什么要破解我的代码aaaacp);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaau.aaaacq((char)805044231)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaacq(char c) {
        return ((Object[])aaaaaW)[c];
    }
}

