/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
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
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaac;
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

public final class aaaaag
implements class_8710 {
    @NotNull
    public static final aaaaac 我草你怎么反编译我模组aaaabq;
    @NotNull
    private final String 我草你怎么反编译我模组aaaabr;
    private final double 我草你怎么反编译我模组aaaabs;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaag> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaag> 我草你怎么反编译我模组aaaaai;
    static Object aaaabt;

    public aaaaag(@NotNull String string, double d) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaag.aaaadv((char)589758464)));
        this.我草你怎么反编译我模组aaaabr = string;
        this.我草你怎么反编译我模组aaaabs = d;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaado() {
        return this.我草你怎么反编译我模组aaaabr;
    }

    public final double 你为什么要破解我的代码aaaadp() {
        return this.我草你怎么反编译我模组aaaabs;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playS2C().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
    }

    @NotNull
    public class_8710.class_9154<aaaaag> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaG() {
        return this.我草你怎么反编译我模组aaaabr;
    }

    public final double 你为什么要破解我的代码aaaadq() {
        return this.我草你怎么反编译我模组aaaabs;
    }

    @NotNull
    public final aaaaag 你为什么要破解我的代码aaaadr(@NotNull String string, double d) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaag.aaaadv((char)-1316159488)));
        return new aaaaag(string, d);
    }

    public static /* synthetic */ aaaaag 你为什么要破解我的代码aaaads(aaaaag aaaaag2, String string, double d, int n, Object object) {
        if ((n & 1) != 0) {
            string = aaaaag2.我草你怎么反编译我模组aaaabr;
        }
        if ((n & 2) != 0) {
            d = aaaaag2.我草你怎么反编译我模组aaaabs;
        }
        return aaaaag2.你为什么要破解我的代码aaaadr(string, d);
    }

    @NotNull
    public String toString() {
        return "PlaySoundPayload(soundName=" + this.我草你怎么反编译我模组aaaabr + ", volume=" + this.我草你怎么反编译我模组aaaabs + ")";
    }

    public int hashCode() {
        int n = this.我草你怎么反编译我模组aaaabr.hashCode();
        n = n * 31 + Double.hashCode((double)this.我草你怎么反编译我模组aaaabs);
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaag)) {
            return false;
        }
        aaaaag aaaaag2 = (aaaaag)object;
        if (!Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaabr, (Object)aaaaag2.我草你怎么反编译我模组aaaabr)) {
            return false;
        }
        return Double.compare((double)this.我草你怎么反编译我模组aaaabs, (double)aaaaag2.我草你怎么反编译我模组aaaabs) == 0;
    }

    private static final void 你为什么要破解我的代码aaaadt(aaaaag aaaaag2, class_2540 class_25402) {
        class_25402.method_10814(aaaaag2.我草你怎么反编译我模组aaaabr);
        class_25402.method_52940(aaaaag2.我草你怎么反编译我模组aaaabs);
    }

    private static final aaaaag 你为什么要破解我的代码aaaadu(class_2540 class_25402) {
        String string = class_25402.method_19772();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaag.aaaadv((char)76677121)));
        return new aaaaag(string, class_25402.readDouble());
    }

    static {
        byte[] byArray = "ÏüØ»¸µäÊN;÷Ñ`üxÓMÐ¨ìé-³#2o\ntxd¸£ÜÕ#,4lVõÉðfd>CìNPÑ':#§?dÍDªHwÊ\\]é\fÈ®.C¯¬â.8y".getBytes("ISO_8859_1");
        Object[] objectArray = "v ÇKhT".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -533954694;
                case 1 -> 1106409274;
                case 2 -> 1059066727;
                case 3 -> 2017451669;
                case 4 -> 1382437804;
                case 5 -> 1014886779;
                case 6 -> -1175757538;
                case 7 -> -639880918;
                case 8 -> -744867729;
                case 9 -> -1461365433;
                case 10 -> -1389574227;
                case 11 -> -484452403;
                case 12 -> 1690899726;
                case 13 -> -879607205;
                case 14 -> -382109719;
                case 15 -> -1992782736;
                case 16 -> -668083443;
                case 17 -> -658732456;
                case 18 -> -1889837467;
                case 19 -> -396893517;
                case 20 -> 1928653032;
                case 21 -> 1153651659;
                case 22 -> -1823201713;
                case 23 -> 818860514;
                case 24 -> -1737766783;
                case 25 -> -1856357156;
                case 26 -> -1963482167;
                case 27 -> 1739691762;
                case 28 -> -527956500;
                case 29 -> 1226127437;
                case 30 -> 591245754;
                case 31 -> -1219940740;
                case 32 -> -1369766437;
                case 33 -> -1771830307;
                case 34 -> 131370764;
                case 35 -> 875035347;
                case 36 -> 972300663;
                case 37 -> 683167671;
                case 38 -> -1455817919;
                case 39 -> 889929878;
                case 40 -> 462514120;
                case 41 -> -392165125;
                case 42 -> -688735124;
                case 43 -> 1846252545;
                case 44 -> 2131936529;
                case 45 -> -196122628;
                case 46 -> 752704282;
                case 47 -> -147164811;
                case 48 -> -173372232;
                case 49 -> 128754927;
                case 50 -> -2062146951;
                case 51 -> -739540640;
                case 52 -> 1275163167;
                case 53 -> 2007592957;
                case 54 -> -122699209;
                case 55 -> -959686611;
                case 56 -> 1001629599;
                case 57 -> 1456775637;
                case 58 -> 166011517;
                case 59 -> -1747605556;
                case 60 -> 1399819685;
                case 61 -> -489638843;
                case 62 -> -1080150879;
                case 63 -> 139275781;
                case 64 -> 274078905;
                case 65 -> -1778254787;
                case 66 -> 1030416421;
                case 67 -> -1497371398;
                case 68 -> 415770269;
                case 69 -> -527322175;
                case 70 -> -1984656921;
                case 71 -> 1833980834;
                case 72 -> -2083854863;
                case 73 -> -1106164521;
                case 74 -> 521607572;
                case 75 -> 2016183890;
                case 76 -> 2078379184;
                case 77 -> -606373048;
                case 78 -> -891713212;
                case 79 -> 1555882420;
                case 80 -> -1344220565;
                case 81 -> 1980201666;
                case 82 -> -2104176166;
                case 83 -> 1817925230;
                case 84 -> 1931258244;
                case 85 -> 1067162127;
                case 86 -> -477671320;
                case 87 -> -345483820;
                case 88 -> 664768831;
                case 89 -> -991128424;
                case 90 -> 672330261;
                case 91 -> 2006603452;
                case 92 -> 1142832795;
                case 93 -> -1896373440;
                case 94 -> -1866857194;
                case 95 -> 984693798;
                case 96 -> -1554937107;
                case 97 -> -1706263790;
                case 98 -> -1630027714;
                case 99 -> 1502024745;
                case 100 -> -1500783582;
                case 101 -> 1309030326;
                case 102 -> 2106515275;
                case 103 -> 1460403876;
                case 104 -> 1627293374;
                case 105 -> 1168157506;
                case 106 -> -1841703509;
                case 107 -> -413974851;
                case 108 -> 2138488030;
                case 109 -> -714494258;
                case 110 -> 1045265943;
                case 111 -> 1018409555;
                case 112 -> -392090045;
                case 113 -> -81504208;
                case 114 -> 1247303796;
                case 115 -> 6177071;
                case 116 -> 1331585411;
                case 117 -> 1433288545;
                case 118 -> 2044039729;
                case 119 -> 2096168415;
                case 120 -> -1029614849;
                case 121 -> 315959473;
                case 122 -> 992777248;
                case 123 -> -1665796665;
                case 124 -> -718608;
                case 125 -> 2139998288;
                case 126 -> -341128194;
                case 127 -> 447286621;
                case 128 -> 912066696;
                case 129 -> -995984556;
                case 130 -> 1976487476;
                case 131 -> 89150708;
                case 132 -> 2047864507;
                case 133 -> -2021975693;
                case 134 -> 907619063;
                case 135 -> -1725523446;
                case 136 -> 1439338339;
                case 137 -> -1022540942;
                case 138 -> -1324844376;
                case 139 -> -1374662367;
                case 140 -> 1332568104;
                case 141 -> 1863767982;
                case 142 -> 824937956;
                case 143 -> -464585857;
                case 144 -> 1920799392;
                case 145 -> 1002072868;
                case 146 -> 1737340688;
                case 147 -> 1508354619;
                case 148 -> -818242005;
                case 149 -> -621810295;
                case 150 -> -2140234107;
                case 151 -> -1380627428;
                case 152 -> -1751766056;
                case 153 -> 1941558844;
                case 154 -> 997727318;
                case 155 -> 698866316;
                case 156 -> 260279759;
                case 157 -> -13529902;
                case 158 -> -1095105694;
                case 159 -> 373136981;
                case 160 -> -881966071;
                case 161 -> 1803804295;
                case 162 -> 1742527000;
                case 163 -> -162261039;
                case 164 -> -789168745;
                case 165 -> -1893680806;
                case 166 -> 2088364650;
                case 167 -> 4342742;
                case 168 -> -1426211511;
                case 169 -> -1259375309;
                case 170 -> -1969739648;
                case 171 -> -536454919;
                case 172 -> -1515964988;
                case 173 -> -74747875;
                case 174 -> -1573725498;
                case 175 -> 846011545;
                case 176 -> 1750132550;
                case 177 -> -341653530;
                case 178 -> 2041053338;
                case 179 -> 1253669345;
                case 180 -> 1856740140;
                case 181 -> -1228187570;
                case 182 -> -2043027866;
                case 183 -> -2018050165;
                case 184 -> 1418776913;
                case 185 -> 247494848;
                case 186 -> 682636517;
                case 187 -> -1702206850;
                case 188 -> 401745528;
                case 189 -> -1489110482;
                case 190 -> 702217010;
                case 191 -> -985715019;
                case 192 -> -445980219;
                case 193 -> 1356032089;
                case 194 -> -595475701;
                case 195 -> -515750258;
                case 196 -> 1952177187;
                case 197 -> 1800706819;
                case 198 -> -1620577517;
                case 199 -> 1391253760;
                case 200 -> -1797178055;
                case 201 -> -784658545;
                case 202 -> 197103911;
                case 203 -> 1463545734;
                case 204 -> 1076341560;
                case 205 -> -1801611097;
                case 206 -> -1880531229;
                case 207 -> 832566;
                case 208 -> 298715189;
                case 209 -> 412770925;
                case 210 -> 1425694355;
                case 211 -> -369746720;
                case 212 -> -1705261104;
                case 213 -> -1989585639;
                case 214 -> 879498140;
                case 215 -> 828152151;
                case 216 -> -157062044;
                case 217 -> 537611914;
                case 218 -> -471983933;
                case 219 -> 1659169241;
                case 220 -> -1184113559;
                case 221 -> 1324139272;
                case 222 -> -601565238;
                case 223 -> 1379352578;
                case 224 -> -1556974600;
                case 225 -> 555270662;
                case 226 -> 2018147148;
                case 227 -> -1454091601;
                case 228 -> 981669214;
                case 229 -> 402877073;
                case 230 -> 1172598276;
                case 231 -> 651297031;
                case 232 -> -444419440;
                case 233 -> 1791050335;
                case 234 -> 57736355;
                case 235 -> 1785575582;
                case 236 -> 773581130;
                case 237 -> 385027953;
                case 238 -> -1466570606;
                case 239 -> -1447122547;
                case 240 -> -721107685;
                case 241 -> -33286721;
                case 242 -> 2018642675;
                case 243 -> 45254018;
                case 244 -> -271596682;
                case 245 -> -1160584940;
                case 246 -> 1136741542;
                case 247 -> 1931698268;
                case 248 -> -1565943383;
                case 249 -> -1027932950;
                case 250 -> -30172502;
                case 251 -> -595733269;
                case 252 -> -360157195;
                case 253 -> 863517422;
                case 254 -> -1236496462;
                case 255 -> 1146788854;
                default -> 665355295;
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
            aaaabt = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabq = new aaaaac(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaag.aaaadv((char)-1672937470)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaag.aaaadv((char)0x30090003)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaag::你为什么要破解我的代码aaaadt, aaaaag::你为什么要破解我的代码aaaadu);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaag.aaaadv((char)-9437180)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaadv(char c) {
        return ((Object[])aaaabt)[c];
    }
}

