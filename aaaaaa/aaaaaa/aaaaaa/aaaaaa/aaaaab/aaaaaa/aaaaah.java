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
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaab;
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

public final class aaaaah
implements class_8710 {
    @NotNull
    public static final aaaaab 我草你怎么反编译我模组aaaabv;
    @NotNull
    private final String 我草你怎么反编译我模组aaaabw;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaah> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaah> 我草你怎么反编译我模组aaaaai;
    static Object aaaabx;

    public aaaaah(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaah.aaaadG((char)0xE0F0000)));
        this.我草你怎么反编译我模组aaaabw = string;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaadB() {
        return this.我草你怎么反编译我模组aaaabw;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playS2C().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
    }

    @NotNull
    public class_8710.class_9154<aaaaah> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaG() {
        return this.我草你怎么反编译我模组aaaabw;
    }

    @NotNull
    public final aaaaah 你为什么要破解我的代码aaaadC(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaah.aaaadG((char)1180631040)));
        return new aaaaah(string);
    }

    public static /* synthetic */ aaaaah 你为什么要破解我的代码aaaadD(aaaaah aaaaah2, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = aaaaah2.我草你怎么反编译我模组aaaabw;
        }
        return aaaaah2.你为什么要破解我的代码aaaadC(string);
    }

    @NotNull
    public String toString() {
        return "CurrentGameStagePayload(gameStageName=" + this.我草你怎么反编译我模组aaaabw + ")";
    }

    public int hashCode() {
        return this.我草你怎么反编译我模组aaaabw.hashCode();
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaah)) {
            return false;
        }
        aaaaah aaaaah2 = (aaaaah)object;
        return Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaabw, (Object)aaaaah2.我草你怎么反编译我模组aaaabw);
    }

    private static final void 你为什么要破解我的代码aaaadE(aaaaah aaaaah2, class_2540 class_25402) {
        class_25402.method_10814(aaaaah2.我草你怎么反编译我模组aaaabw);
    }

    private static final aaaaah 你为什么要破解我的代码aaaadF(class_2540 class_25402) {
        String string = class_25402.method_19772();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaah.aaaadG((char)-1456144383)));
        return new aaaaah(string);
    }

    static {
        byte[] byArray = "ÐæÊÇ5¸Xvý±/É%MNñ´/nûç4£ïÛ}âL~\\õL(»ú,C¢÷NõOípN©Ób]×Afg°ç+ ÝÎA¥G É¨\nÚØLÔ 7, ÿR)¼rrìh$üãFÔP".getBytes("ISO_8859_1");
        Object[] objectArray = "±vÑ`Ä¹".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -20116147;
                case 1 -> 153662087;
                case 2 -> -561218689;
                case 3 -> -2005879245;
                case 4 -> 1939374953;
                case 5 -> -1247908184;
                case 6 -> 708152810;
                case 7 -> -1384598179;
                case 8 -> 237339566;
                case 9 -> 2081827679;
                case 10 -> -493860891;
                case 11 -> 1829974030;
                case 12 -> 931527843;
                case 13 -> -1043108740;
                case 14 -> 764397361;
                case 15 -> 972714442;
                case 16 -> -1820597695;
                case 17 -> -764055744;
                case 18 -> 370650846;
                case 19 -> 1921041538;
                case 20 -> -2115626203;
                case 21 -> 1887031087;
                case 22 -> 1956613595;
                case 23 -> -1274371568;
                case 24 -> -1719920786;
                case 25 -> -1214697563;
                case 26 -> -1020336956;
                case 27 -> -46244884;
                case 28 -> 2008904917;
                case 29 -> 1448026559;
                case 30 -> 83681725;
                case 31 -> 2034205422;
                case 32 -> -598763595;
                case 33 -> -1958889216;
                case 34 -> -2129839910;
                case 35 -> -321008405;
                case 36 -> -1990514741;
                case 37 -> -1993307095;
                case 38 -> 1624621684;
                case 39 -> -1392242808;
                case 40 -> -619204155;
                case 41 -> -1601570688;
                case 42 -> -695288217;
                case 43 -> 1831705652;
                case 44 -> 114557327;
                case 45 -> -1172241506;
                case 46 -> -326508975;
                case 47 -> 309669838;
                case 48 -> -911348085;
                case 49 -> -1387972686;
                case 50 -> -1777695348;
                case 51 -> -1657664004;
                case 52 -> 1494524401;
                case 53 -> -603902221;
                case 54 -> -1126444229;
                case 55 -> -1924322041;
                case 56 -> 1063030409;
                case 57 -> 1292616965;
                case 58 -> 1804035587;
                case 59 -> 1572960570;
                case 60 -> -1789084680;
                case 61 -> 1835217248;
                case 62 -> -1797652910;
                case 63 -> -1621657236;
                case 64 -> -1551826065;
                case 65 -> 1804359780;
                case 66 -> 1955681667;
                case 67 -> 987628464;
                case 68 -> 1228235021;
                case 69 -> 522468086;
                case 70 -> -589242261;
                case 71 -> -1389969646;
                case 72 -> -984969707;
                case 73 -> 1591783;
                case 74 -> -1624157968;
                case 75 -> -333015636;
                case 76 -> 1295278693;
                case 77 -> 1555425835;
                case 78 -> 1717110760;
                case 79 -> -1308142538;
                case 80 -> -1073291953;
                case 81 -> -1005543020;
                case 82 -> -70659645;
                case 83 -> 1509503126;
                case 84 -> 622769154;
                case 85 -> 776044988;
                case 86 -> -502098615;
                case 87 -> 1348986023;
                case 88 -> 1236190524;
                case 89 -> 1962537716;
                case 90 -> 601480014;
                case 91 -> 1847625857;
                case 92 -> -197398278;
                case 93 -> 135193752;
                case 94 -> 157306442;
                case 95 -> -651002616;
                case 96 -> -844823655;
                case 97 -> -1035927458;
                case 98 -> 1441305732;
                case 99 -> 942076558;
                case 100 -> 1424810694;
                case 101 -> 1574530623;
                case 102 -> -1672202332;
                case 103 -> -103815752;
                case 104 -> 1104744016;
                case 105 -> 1039810388;
                case 106 -> -316971150;
                case 107 -> 380151600;
                case 108 -> 1926702031;
                case 109 -> 1006409140;
                case 110 -> -2118136706;
                case 111 -> 1036993254;
                case 112 -> 2025849975;
                case 113 -> -2027546277;
                case 114 -> 1765327933;
                case 115 -> -1472246160;
                case 116 -> -1623734419;
                case 117 -> -1146988387;
                case 118 -> -2015774936;
                case 119 -> 1986792903;
                case 120 -> -824863135;
                case 121 -> 1799622171;
                case 122 -> 1377395001;
                case 123 -> 1071701368;
                case 124 -> 925832773;
                case 125 -> -497187047;
                case 126 -> 2125147186;
                case 127 -> 1735154421;
                case 128 -> 1989611270;
                case 129 -> -331442110;
                case 130 -> -540403264;
                case 131 -> 2043397291;
                case 132 -> 471293585;
                case 133 -> 1624887670;
                case 134 -> -1482244297;
                case 135 -> -837717670;
                case 136 -> 1378512275;
                case 137 -> -285610684;
                case 138 -> 1994412922;
                case 139 -> 1465545372;
                case 140 -> 775473450;
                case 141 -> -1349801689;
                case 142 -> -1073029891;
                case 143 -> -199970608;
                case 144 -> 1042513546;
                case 145 -> -703626984;
                case 146 -> -1228736875;
                case 147 -> -111665965;
                case 148 -> 845959470;
                case 149 -> 998897227;
                case 150 -> 1039254378;
                case 151 -> -2048211608;
                case 152 -> -317121831;
                case 153 -> 1937794833;
                case 154 -> 233437089;
                case 155 -> -1448025530;
                case 156 -> 1266660896;
                case 157 -> -1325688286;
                case 158 -> -1305404512;
                case 159 -> 1355232089;
                case 160 -> -134453996;
                case 161 -> -1956086773;
                case 162 -> -2041155757;
                case 163 -> 1721186438;
                case 164 -> -1200845359;
                case 165 -> -205340479;
                case 166 -> -1553264259;
                case 167 -> -501602232;
                case 168 -> -1822153114;
                case 169 -> -1728292173;
                case 170 -> -1027259015;
                case 171 -> -1971803753;
                case 172 -> -659268029;
                case 173 -> 38797410;
                case 174 -> -1594684502;
                case 175 -> -1081956321;
                case 176 -> 1849567391;
                case 177 -> -1503908751;
                case 178 -> -211917897;
                case 179 -> 2103174050;
                case 180 -> -1871459036;
                case 181 -> -775466330;
                case 182 -> -1100487921;
                case 183 -> 326040073;
                case 184 -> -1701269195;
                case 185 -> -821739482;
                case 186 -> -555580628;
                case 187 -> -1786637028;
                case 188 -> 100588478;
                case 189 -> 769708380;
                case 190 -> 589676509;
                case 191 -> 937785854;
                case 192 -> 91620794;
                case 193 -> 1944877516;
                case 194 -> -73825308;
                case 195 -> 1852154337;
                case 196 -> 1528311469;
                case 197 -> -902869917;
                case 198 -> -621712298;
                case 199 -> 2117051771;
                case 200 -> -287572963;
                case 201 -> 1066107733;
                case 202 -> -108833704;
                case 203 -> 108008714;
                case 204 -> 1947561747;
                case 205 -> -38360797;
                case 206 -> -1619046623;
                case 207 -> -278820777;
                case 208 -> 126985983;
                case 209 -> -680860787;
                case 210 -> 227371689;
                case 211 -> -452886667;
                case 212 -> 394443309;
                case 213 -> 352065762;
                case 214 -> -457709363;
                case 215 -> -2030603970;
                case 216 -> 1446837904;
                case 217 -> 2146619119;
                case 218 -> -1009857524;
                case 219 -> 1671629303;
                case 220 -> -1323887137;
                case 221 -> -1040575333;
                case 222 -> 198959749;
                case 223 -> -1778124558;
                case 224 -> -908938598;
                case 225 -> 109892122;
                case 226 -> 487368642;
                case 227 -> -159455799;
                case 228 -> -888405802;
                case 229 -> -190694675;
                case 230 -> 1139388591;
                case 231 -> -1834462008;
                case 232 -> 1804202753;
                case 233 -> -44017518;
                case 234 -> 1107917817;
                case 235 -> -109604578;
                case 236 -> -517337120;
                case 237 -> 1373038051;
                case 238 -> 1206305769;
                case 239 -> -1798241326;
                case 240 -> 1992711640;
                case 241 -> -1288444872;
                case 242 -> 627101811;
                case 243 -> 410542596;
                case 244 -> -1994613804;
                case 245 -> -1845058119;
                case 246 -> -571586996;
                case 247 -> 644923612;
                case 248 -> 967436731;
                case 249 -> 1497184983;
                case 250 -> 49381553;
                case 251 -> -489070009;
                case 252 -> 199129110;
                case 253 -> 1272152246;
                case 254 -> -1272483817;
                case 255 -> -625751557;
                default -> -2059340328;
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
            aaaabx = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabv = new aaaaab(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaah.aaaadG((char)853999618)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaah.aaaadG((char)-913440765)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaah::你为什么要破解我的代码aaaadE, aaaaah::你为什么要破解我的代码aaaadF);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaah.aaaadG((char)596639748)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaadG(char c) {
        return ((Object[])aaaabx)[c];
    }
}

