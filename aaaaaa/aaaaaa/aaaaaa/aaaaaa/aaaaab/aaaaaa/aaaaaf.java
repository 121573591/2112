/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Float
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
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_243
 *  net.minecraft.class_2540
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaaa;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_243;
import net.minecraft.class_2540;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaaaaf
implements class_8710 {
    @NotNull
    public static final aaaaaa 我草你怎么反编译我模组aaaaba;
    private final float 我草你怎么反编译我模组aaaabb;
    @NotNull
    private final class_243 我草你怎么反编译我模组aaaabc;
    private final boolean 我草你怎么反编译我模组aaaabd;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaaf> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaaf> 我草你怎么反编译我模组aaaaai;
    static Object aaaabe;

    public aaaaaf(float f, @NotNull class_243 class_2432, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)class_2432, (String)((String)aaaaaf.aaaacI((char)-1286602752)));
        this.我草你怎么反编译我模组aaaabb = f;
        this.我草你怎么反编译我模组aaaabc = class_2432;
        this.我草你怎么反编译我模组aaaabd = bl;
    }

    public /* synthetic */ aaaaaf(float f, class_243 class_2432, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bl = false;
        }
        this(f, class_2432, bl);
    }

    public final float 你为什么要破解我的代码aaaacy() {
        return this.我草你怎么反编译我模组aaaabb;
    }

    @NotNull
    public final class_243 你为什么要破解我的代码aaaacz() {
        return this.我草你怎么反编译我模组aaaabc;
    }

    public final boolean 你为什么要破解我的代码aaaacA() {
        return this.我草你怎么反编译我模组aaaabd;
    }

    @NotNull
    public class_8710.class_9154<aaaaaf> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        我草你怎么反编译我模组aaaaba.你为什么要破解我的代码aaaaaa();
    }

    public final float 你为什么要破解我的代码aaaacB() {
        return this.我草你怎么反编译我模组aaaabb;
    }

    @NotNull
    public final class_243 你为什么要破解我的代码aaaacC() {
        return this.我草你怎么反编译我模组aaaabc;
    }

    public final boolean 你为什么要破解我的代码aaaaay() {
        return this.我草你怎么反编译我模组aaaabd;
    }

    @NotNull
    public final aaaaaf 你为什么要破解我的代码aaaacD(float f, @NotNull class_243 class_2432, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)class_2432, (String)((String)aaaaaf.aaaacI((char)1402863616)));
        return new aaaaaf(f, class_2432, bl);
    }

    public static /* synthetic */ aaaaaf 你为什么要破解我的代码aaaacE(aaaaaf aaaaaf2, float f, class_243 class_2432, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            f = aaaaaf2.我草你怎么反编译我模组aaaabb;
        }
        if ((n & 2) != 0) {
            class_2432 = aaaaaf2.我草你怎么反编译我模组aaaabc;
        }
        if ((n & 4) != 0) {
            bl = aaaaaf2.我草你怎么反编译我模组aaaabd;
        }
        return aaaaaf2.你为什么要破解我的代码aaaacD(f, class_2432, bl);
    }

    @NotNull
    public String toString() {
        return "DamageDisplayPacket(damage=" + this.我草你怎么反编译我模组aaaabb + ", position=" + this.我草你怎么反编译我模组aaaabc + ", isKill=" + this.我草你怎么反编译我模组aaaabd + ")";
    }

    public int hashCode() {
        int n = Float.hashCode((float)this.我草你怎么反编译我模组aaaabb);
        n = n * 31 + this.我草你怎么反编译我模组aaaabc.hashCode();
        n = n * 31 + Boolean.hashCode((boolean)this.我草你怎么反编译我模组aaaabd);
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaaf)) {
            return false;
        }
        aaaaaf aaaaaf2 = (aaaaaf)object;
        if (Float.compare((float)this.我草你怎么反编译我模组aaaabb, (float)aaaaaf2.我草你怎么反编译我模组aaaabb) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaabc, (Object)aaaaaf2.我草你怎么反编译我模组aaaabc)) {
            return false;
        }
        return this.我草你怎么反编译我模组aaaabd == aaaaaf2.我草你怎么反编译我模组aaaabd;
    }

    private static final void 你为什么要破解我的代码aaaacF(aaaaaf aaaaaf2, class_2540 class_25402) {
        aaaaab.你为什么要破解我的代码aaaaaa().info("[DamagePacket] 编码数据包: damage=" + aaaaaf2.我草你怎么反编译我模组aaaabb + ", pos=" + aaaaaf2.我草你怎么反编译我模组aaaabc + ", isKill=" + aaaaaf2.我草你怎么反编译我模组aaaabd);
        class_25402.method_52941(aaaaaf2.我草你怎么反编译我模组aaaabb);
        class_25402.method_52940(aaaaaf2.我草你怎么反编译我模组aaaabc.field_1352);
        class_25402.method_52940(aaaaaf2.我草你怎么反编译我模组aaaabc.field_1351);
        class_25402.method_52940(aaaaaf2.我草你怎么反编译我模组aaaabc.field_1350);
        class_25402.method_52964(aaaaaf2.我草你怎么反编译我模组aaaabd);
    }

    private static final aaaaaf 你为什么要破解我的代码aaaacG(class_2540 class_25402) {
        float f = class_25402.readFloat();
        double d = class_25402.readDouble();
        double d2 = class_25402.readDouble();
        double d3 = class_25402.readDouble();
        boolean bl = class_25402.readBoolean();
        return new aaaaaf(f, new class_243(d, d2, d3), bl);
    }

    @JvmStatic
    public static final void 你为什么要破解我的代码aaaacH() {
        我草你怎么反编译我模组aaaaba.你为什么要破解我的代码aaaaaa();
    }

    static {
        byte[] byArray = "`¸ïÈóÀX°0ëü*Q¤åMå-¢FëúMb`±`Æ$ñ\f«r2½1úèÓ.díÎgRÎ\tJü&Ê}s¶üç*±·¹%ÈQ".getBytes("ISO_8859_1");
        Object[] objectArray = "  }!4ðþ".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -747085261;
                case 1 -> -155905178;
                case 2 -> 195833299;
                case 3 -> 988854552;
                case 4 -> 375147176;
                case 5 -> 1962921531;
                case 6 -> 1442129707;
                case 7 -> -345765162;
                case 8 -> -239469234;
                case 9 -> 290465349;
                case 10 -> 2033908956;
                case 11 -> -802355352;
                case 12 -> 1095348095;
                case 13 -> -1228421676;
                case 14 -> -2050103579;
                case 15 -> -164664211;
                case 16 -> -1970721940;
                case 17 -> -2037833651;
                case 18 -> 627647891;
                case 19 -> -1591651012;
                case 20 -> -651653358;
                case 21 -> 2127913022;
                case 22 -> -530113609;
                case 23 -> 289640946;
                case 24 -> -1005995056;
                case 25 -> 580044940;
                case 26 -> 445903521;
                case 27 -> 17006169;
                case 28 -> 194522858;
                case 29 -> -423989853;
                case 30 -> 1092029671;
                case 31 -> 1339251400;
                case 32 -> -696967729;
                case 33 -> 63267802;
                case 34 -> -1951677558;
                case 35 -> 585188075;
                case 36 -> -1966212065;
                case 37 -> -1977706869;
                case 38 -> 2145797131;
                case 39 -> -1440461369;
                case 40 -> 1332860510;
                case 41 -> -216005155;
                case 42 -> 231306894;
                case 43 -> -474317835;
                case 44 -> -1306783334;
                case 45 -> 1635194661;
                case 46 -> -574665956;
                case 47 -> 1342795972;
                case 48 -> -21917957;
                case 49 -> -181064166;
                case 50 -> 22341188;
                case 51 -> -373350277;
                case 52 -> -677953657;
                case 53 -> -292632698;
                case 54 -> 774925110;
                case 55 -> -1393625138;
                case 56 -> 1477943983;
                case 57 -> 1469888962;
                case 58 -> -2050066614;
                case 59 -> 190519200;
                case 60 -> -650202265;
                case 61 -> -426218396;
                case 62 -> 2029093703;
                case 63 -> 1354807937;
                case 64 -> -1645587853;
                case 65 -> 675616778;
                case 66 -> -477252605;
                case 67 -> -604383703;
                case 68 -> -1639504364;
                case 69 -> -2100993479;
                case 70 -> 564128215;
                case 71 -> 1345684230;
                case 72 -> 869300412;
                case 73 -> -1791105115;
                case 74 -> -1358497567;
                case 75 -> 1336661884;
                case 76 -> -143942703;
                case 77 -> 94016040;
                case 78 -> 1080190667;
                case 79 -> -1236720232;
                case 80 -> 295554357;
                case 81 -> 752207628;
                case 82 -> 157953191;
                case 83 -> -1575494864;
                case 84 -> 56996391;
                case 85 -> -797066737;
                case 86 -> -1167641967;
                case 87 -> 1341090762;
                case 88 -> 1798293759;
                case 89 -> 1462078890;
                case 90 -> 1252824983;
                case 91 -> 274856927;
                case 92 -> -17856749;
                case 93 -> -1707802831;
                case 94 -> -714207756;
                case 95 -> 1917439089;
                case 96 -> 1222443195;
                case 97 -> -1419590912;
                case 98 -> 290436437;
                case 99 -> -2131588329;
                case 100 -> 837887278;
                case 101 -> -195897097;
                case 102 -> 1976591257;
                case 103 -> 1525284832;
                case 104 -> -96917332;
                case 105 -> -191663517;
                case 106 -> 746006537;
                case 107 -> -414790038;
                case 108 -> 2109440803;
                case 109 -> 1388856066;
                case 110 -> -222723422;
                case 111 -> 1894468176;
                case 112 -> 53451109;
                case 113 -> -763542158;
                case 114 -> 354398044;
                case 115 -> 221607173;
                case 116 -> -361556186;
                case 117 -> 907496118;
                case 118 -> 1887492858;
                case 119 -> -51595274;
                case 120 -> 1639343801;
                case 121 -> -454429330;
                case 122 -> -1282852280;
                case 123 -> 1850799677;
                case 124 -> 1946940282;
                case 125 -> -304095903;
                case 126 -> -44541960;
                case 127 -> -449443659;
                case 128 -> -795080455;
                case 129 -> 1486554902;
                case 130 -> -31063801;
                case 131 -> -44979326;
                case 132 -> 1098481069;
                case 133 -> -1497304149;
                case 134 -> 1086373763;
                case 135 -> -1701739476;
                case 136 -> -97413675;
                case 137 -> 2122768008;
                case 138 -> -1751076572;
                case 139 -> -21903717;
                case 140 -> 1660135263;
                case 141 -> 466094257;
                case 142 -> 1786130369;
                case 143 -> -1448832904;
                case 144 -> 1674807297;
                case 145 -> -818342293;
                case 146 -> -238310465;
                case 147 -> -1629154333;
                case 148 -> 779338572;
                case 149 -> 1357438078;
                case 150 -> 835098240;
                case 151 -> 1406213010;
                case 152 -> 965942393;
                case 153 -> 1567633760;
                case 154 -> -1551151788;
                case 155 -> -1915319548;
                case 156 -> 1405806112;
                case 157 -> 825724495;
                case 158 -> 579097133;
                case 159 -> 703191346;
                case 160 -> 125973233;
                case 161 -> 1146264982;
                case 162 -> -1878174622;
                case 163 -> -1265257200;
                case 164 -> -873212625;
                case 165 -> -924908870;
                case 166 -> 688312385;
                case 167 -> -498906310;
                case 168 -> -597439723;
                case 169 -> 248838589;
                case 170 -> 903824112;
                case 171 -> 224255192;
                case 172 -> -645757324;
                case 173 -> 403543664;
                case 174 -> 1256931105;
                case 175 -> -1964270467;
                case 176 -> 1203966147;
                case 177 -> 1865137208;
                case 178 -> -55189928;
                case 179 -> -1050604139;
                case 180 -> 1783837047;
                case 181 -> 693250078;
                case 182 -> -1098425955;
                case 183 -> -938260032;
                case 184 -> 598927821;
                case 185 -> -563995891;
                case 186 -> -1594375427;
                case 187 -> -218042855;
                case 188 -> 1289417406;
                case 189 -> 723743132;
                case 190 -> 524301805;
                case 191 -> 99655490;
                case 192 -> 548940008;
                case 193 -> -445624237;
                case 194 -> -329452882;
                case 195 -> 106912594;
                case 196 -> -709101409;
                case 197 -> -913594533;
                case 198 -> 1362570116;
                case 199 -> 1688732265;
                case 200 -> -1734328253;
                case 201 -> -496294732;
                case 202 -> -1019900402;
                case 203 -> -848240974;
                case 204 -> -998292463;
                case 205 -> -365792431;
                case 206 -> -1023489308;
                case 207 -> -1409087010;
                case 208 -> 1128697627;
                case 209 -> 363252791;
                case 210 -> 774475497;
                case 211 -> -1208291217;
                case 212 -> 1888877726;
                case 213 -> 977222652;
                case 214 -> 541711268;
                case 215 -> -1006606284;
                case 216 -> 109720489;
                case 217 -> -1545134971;
                case 218 -> 1887669065;
                case 219 -> 187172957;
                case 220 -> -1979429678;
                case 221 -> -1295141050;
                case 222 -> 885422028;
                case 223 -> 109489812;
                case 224 -> 1089894490;
                case 225 -> 66519494;
                case 226 -> 1800969967;
                case 227 -> 798720656;
                case 228 -> 56087594;
                case 229 -> 1441716198;
                case 230 -> -1298715707;
                case 231 -> 1036241072;
                case 232 -> -1663054961;
                case 233 -> -12496042;
                case 234 -> -2044769246;
                case 235 -> 1479495453;
                case 236 -> 214673727;
                case 237 -> -344982903;
                case 238 -> -870569208;
                case 239 -> 1241736155;
                case 240 -> -1342749214;
                case 241 -> 105181813;
                case 242 -> 361202263;
                case 243 -> 516258445;
                case 244 -> 1656481516;
                case 245 -> 1910666494;
                case 246 -> 352229875;
                case 247 -> 956699630;
                case 248 -> 1771488691;
                case 249 -> 452867000;
                case 250 -> -1046108967;
                case 251 -> 936867529;
                case 252 -> -1815425205;
                case 253 -> 1302160704;
                case 254 -> -357574794;
                case 255 -> 270749094;
                default -> -1740139012;
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
            aaaabe = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaba = new aaaaaa(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaaf.aaaacI((char)-1891303423)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaaf.aaaacI((char)127926274)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaaf::你为什么要破解我的代码aaaacF, aaaaaf::你为什么要破解我的代码aaaacG);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaaf.aaaacI((char)1511849987)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaacI(char c) {
        return ((Object[])aaaabe)[c];
    }
}

