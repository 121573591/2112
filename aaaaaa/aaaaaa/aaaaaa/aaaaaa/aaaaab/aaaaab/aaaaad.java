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
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab;

import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

public final class aaaaad {
    static Object aaaaaa;

    public aaaaad(@NotNull MinecraftServer minecraftServer) {
        Intrinsics.checkNotNullParameter((Object)minecraftServer, (String)((String)aaaaad.aaaaaa((char)65798144)));
    }

    static {
        byte[] byArray = "ÑÎÒµ°\n\bpÑÌ^!¨ÍwñfVÂ~ÓÛë<ÅÅ%d¼÷".getBytes("ISO_8859_1");
        Object[] objectArray = "#C@4E*".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -2020233985;
                case 1 -> 32882844;
                case 2 -> 219215373;
                case 3 -> 1881281920;
                case 4 -> 1482221826;
                case 5 -> -280975269;
                case 6 -> -2000173105;
                case 7 -> 1439033638;
                case 8 -> -1524108643;
                case 9 -> -970355283;
                case 10 -> 1806493935;
                case 11 -> 660882967;
                case 12 -> 1466079476;
                case 13 -> 1861653004;
                case 14 -> 533263655;
                case 15 -> -2003584163;
                case 16 -> 731702356;
                case 17 -> -1518169877;
                case 18 -> -371048030;
                case 19 -> -1105987063;
                case 20 -> -1455965808;
                case 21 -> 1004954654;
                case 22 -> 1457076673;
                case 23 -> 236140833;
                case 24 -> 1588376435;
                case 25 -> 1680745801;
                case 26 -> -284384239;
                case 27 -> -1293876769;
                case 28 -> -40301460;
                case 29 -> 1194630960;
                case 30 -> -1119806330;
                case 31 -> -1452279506;
                case 32 -> -1341420163;
                case 33 -> 1366480550;
                case 34 -> 140080117;
                case 35 -> -519205891;
                case 36 -> 1180024721;
                case 37 -> 1899529220;
                case 38 -> -1813786494;
                case 39 -> 1087337701;
                case 40 -> 1507917199;
                case 41 -> -1885488566;
                case 42 -> -1655061494;
                case 43 -> 916753332;
                case 44 -> -1433662171;
                case 45 -> -707975616;
                case 46 -> -919624399;
                case 47 -> 1157061893;
                case 48 -> 1226725281;
                case 49 -> -2041992428;
                case 50 -> 498196190;
                case 51 -> 1269198686;
                case 52 -> 1319762007;
                case 53 -> -53919887;
                case 54 -> -1200286456;
                case 55 -> 822032481;
                case 56 -> 780546755;
                case 57 -> -1570093189;
                case 58 -> -133674565;
                case 59 -> -2069485780;
                case 60 -> 589302001;
                case 61 -> -1633165966;
                case 62 -> -1662625941;
                case 63 -> -1171829283;
                case 64 -> -713623716;
                case 65 -> -893074741;
                case 66 -> -862555805;
                case 67 -> -2138015149;
                case 68 -> 2012751052;
                case 69 -> -458498599;
                case 70 -> -1363046966;
                case 71 -> 1898898907;
                case 72 -> -271943132;
                case 73 -> 1522567963;
                case 74 -> 2013058026;
                case 75 -> 244821642;
                case 76 -> -406686404;
                case 77 -> -351784650;
                case 78 -> 1869053080;
                case 79 -> -1480337452;
                case 80 -> 1583131983;
                case 81 -> 146389835;
                case 82 -> -985873432;
                case 83 -> -830636929;
                case 84 -> 1217026752;
                case 85 -> -757660986;
                case 86 -> -1084174480;
                case 87 -> 1709533884;
                case 88 -> -1643424023;
                case 89 -> -666936921;
                case 90 -> -805718609;
                case 91 -> -357213094;
                case 92 -> -1245353038;
                case 93 -> -521562649;
                case 94 -> -141297909;
                case 95 -> 475300255;
                case 96 -> 1765858845;
                case 97 -> 468151880;
                case 98 -> 1650730622;
                case 99 -> 286856302;
                case 100 -> 1919849108;
                case 101 -> -38074644;
                case 102 -> 1697484120;
                case 103 -> -1972692440;
                case 104 -> -832819325;
                case 105 -> -1784486376;
                case 106 -> -462420764;
                case 107 -> -332815147;
                case 108 -> 1455368710;
                case 109 -> 1779422236;
                case 110 -> 905793787;
                case 111 -> -17490440;
                case 112 -> -209216102;
                case 113 -> -138722966;
                case 114 -> -1002916182;
                case 115 -> -468288459;
                case 116 -> -1187497390;
                case 117 -> -1559479277;
                case 118 -> 424257827;
                case 119 -> -1260095426;
                case 120 -> -2133793037;
                case 121 -> 1675893719;
                case 122 -> -1716213738;
                case 123 -> -603652256;
                case 124 -> 1189982972;
                case 125 -> 1070293013;
                case 126 -> -1755593169;
                case 127 -> -1912958113;
                case 128 -> 831798644;
                case 129 -> 151680732;
                case 130 -> -1441109183;
                case 131 -> -179151328;
                case 132 -> 189121712;
                case 133 -> 163661782;
                case 134 -> 1749435022;
                case 135 -> -691992073;
                case 136 -> 1586259329;
                case 137 -> -1412701031;
                case 138 -> -644257160;
                case 139 -> 533314129;
                case 140 -> -73512192;
                case 141 -> -1334729983;
                case 142 -> -525836910;
                case 143 -> 275494938;
                case 144 -> 1780081120;
                case 145 -> -1195411518;
                case 146 -> -1941428926;
                case 147 -> 1661509350;
                case 148 -> -1215678379;
                case 149 -> 1078291666;
                case 150 -> -512768347;
                case 151 -> -159505971;
                case 152 -> -661443188;
                case 153 -> 2063237625;
                case 154 -> 1902773986;
                case 155 -> 1519109736;
                case 156 -> -761717522;
                case 157 -> -209105609;
                case 158 -> -1780813379;
                case 159 -> 390993813;
                case 160 -> -2035282314;
                case 161 -> 880487606;
                case 162 -> -1234256039;
                case 163 -> 1394487638;
                case 164 -> -388317442;
                case 165 -> 199154960;
                case 166 -> -1321336129;
                case 167 -> 1606269289;
                case 168 -> -530453960;
                case 169 -> 560125424;
                case 170 -> -1454556261;
                case 171 -> -710636348;
                case 172 -> -208619132;
                case 173 -> 564832058;
                case 174 -> -867417266;
                case 175 -> -339294917;
                case 176 -> 850081975;
                case 177 -> -500545890;
                case 178 -> 1679564668;
                case 179 -> 813622851;
                case 180 -> -809486797;
                case 181 -> -1102509553;
                case 182 -> -135778286;
                case 183 -> 1186019208;
                case 184 -> 860355717;
                case 185 -> 1681503713;
                case 186 -> -1240868583;
                case 187 -> -1107642218;
                case 188 -> -1399476361;
                case 189 -> 622059443;
                case 190 -> -1715729464;
                case 191 -> 118436420;
                case 192 -> -1590078619;
                case 193 -> 596546682;
                case 194 -> 538330297;
                case 195 -> 999242548;
                case 196 -> 600621831;
                case 197 -> -427624792;
                case 198 -> 756877518;
                case 199 -> 1540900503;
                case 200 -> 1904611565;
                case 201 -> -1957086543;
                case 202 -> 1714410738;
                case 203 -> -2099376761;
                case 204 -> 311303109;
                case 205 -> 938564878;
                case 206 -> -1862597043;
                case 207 -> -1321339350;
                case 208 -> 1405248952;
                case 209 -> 1320963655;
                case 210 -> -409577256;
                case 211 -> 1521625959;
                case 212 -> -445293387;
                case 213 -> 298942409;
                case 214 -> 568251107;
                case 215 -> 219389796;
                case 216 -> 2050008912;
                case 217 -> -837283398;
                case 218 -> -1415229533;
                case 219 -> -478727354;
                case 220 -> -290376899;
                case 221 -> -983954007;
                case 222 -> -46593874;
                case 223 -> 602120569;
                case 224 -> 2039288323;
                case 225 -> 9136275;
                case 226 -> -764952519;
                case 227 -> 1474494142;
                case 228 -> -1989190035;
                case 229 -> 301315721;
                case 230 -> 1904440107;
                case 231 -> 1896603437;
                case 232 -> -992564113;
                case 233 -> -460011055;
                case 234 -> -493374768;
                case 235 -> 2009826724;
                case 236 -> 1107745696;
                case 237 -> -1040206393;
                case 238 -> -856224666;
                case 239 -> -847540705;
                case 240 -> -1046008001;
                case 241 -> 771547789;
                case 242 -> 1089153451;
                case 243 -> -127723451;
                case 244 -> -158198100;
                case 245 -> 2107058571;
                case 246 -> 1926790773;
                case 247 -> 434918220;
                case 248 -> -1309932333;
                case 249 -> -1032509958;
                case 250 -> -154093790;
                case 251 -> -1034623270;
                case 252 -> -404016334;
                case 253 -> -778878679;
                case 254 -> 1570587382;
                case 255 -> -1833913758;
                default -> -1206758837;
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
            Object[] objectArray2 = new Object[1];
            objectArray = objectArray2;
            aaaaaa = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
    }

    private static Object aaaaaa(char c) {
        return ((Object[])aaaaaa)[c];
    }
}

