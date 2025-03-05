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
 *  net.minecraft.class_310
 *  org.jetbrains.annotations.NotNull
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaab;

import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_310;
import org.jetbrains.annotations.NotNull;

public final class aaaaaa {
    static Object aaaaaa;

    public aaaaaa(@NotNull class_310 class_3102) {
        Intrinsics.checkNotNullParameter((Object)class_3102, (String)((String)aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaab.aaaaaa.aaaaaa((char)-817692672)));
    }

    static {
        byte[] byArray = "Ù>a/ûèÎh[«Ûö\fq+ª(¬5¦ËJëPncpg®\"$·¹Æ!Aä".getBytes("ISO_8859_1");
        Object[] objectArray = "íÙ4\bõ".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 386508735;
                case 1 -> -581643252;
                case 2 -> -1650753489;
                case 3 -> 250772666;
                case 4 -> -951021797;
                case 5 -> 1223400175;
                case 6 -> -1106718370;
                case 7 -> 885527291;
                case 8 -> -1728289302;
                case 9 -> -305227023;
                case 10 -> 1708442390;
                case 11 -> -1932619299;
                case 12 -> 342769434;
                case 13 -> -329446541;
                case 14 -> 595703257;
                case 15 -> -1299480573;
                case 16 -> -1073917277;
                case 17 -> -447513867;
                case 18 -> -1975956187;
                case 19 -> -1991460361;
                case 20 -> 2039268914;
                case 21 -> 329526728;
                case 22 -> 703030808;
                case 23 -> -213951285;
                case 24 -> 1919761401;
                case 25 -> -805509040;
                case 26 -> -2053080971;
                case 27 -> -1100627672;
                case 28 -> -1559992853;
                case 29 -> -1165504374;
                case 30 -> -557320530;
                case 31 -> -1489385405;
                case 32 -> -1199160910;
                case 33 -> -603095889;
                case 34 -> 968771097;
                case 35 -> -1246025996;
                case 36 -> 531678238;
                case 37 -> -310742770;
                case 38 -> 1495619530;
                case 39 -> -746610657;
                case 40 -> -852224995;
                case 41 -> 1814727514;
                case 42 -> -1169817159;
                case 43 -> 844450117;
                case 44 -> -58812341;
                case 45 -> -964616322;
                case 46 -> 2131730801;
                case 47 -> 1097151028;
                case 48 -> 558204038;
                case 49 -> 1467798089;
                case 50 -> -70341017;
                case 51 -> 1959210903;
                case 52 -> 1553440355;
                case 53 -> -178098320;
                case 54 -> -1756483417;
                case 55 -> -547518590;
                case 56 -> -1529781741;
                case 57 -> -410372034;
                case 58 -> 1323520956;
                case 59 -> -1965436918;
                case 60 -> -2052662750;
                case 61 -> 1309639001;
                case 62 -> 1814138165;
                case 63 -> -197511363;
                case 64 -> -1947686876;
                case 65 -> -1948609649;
                case 66 -> 1927873719;
                case 67 -> 505477444;
                case 68 -> -1930480266;
                case 69 -> -2072439444;
                case 70 -> -1687672144;
                case 71 -> 744347722;
                case 72 -> -1930429079;
                case 73 -> 1807322168;
                case 74 -> 398772578;
                case 75 -> 2132524767;
                case 76 -> -282172964;
                case 77 -> 826453252;
                case 78 -> 800057905;
                case 79 -> 916648698;
                case 80 -> 1211793755;
                case 81 -> -156793197;
                case 82 -> -664055618;
                case 83 -> -54364543;
                case 84 -> -494531925;
                case 85 -> 1996866851;
                case 86 -> -989954734;
                case 87 -> -587626480;
                case 88 -> 566226109;
                case 89 -> 1414241773;
                case 90 -> 331640685;
                case 91 -> -224112594;
                case 92 -> 518351094;
                case 93 -> 605492231;
                case 94 -> 1264225498;
                case 95 -> 1123890589;
                case 96 -> 1460141519;
                case 97 -> 486060713;
                case 98 -> -1936951575;
                case 99 -> 1509323010;
                case 100 -> 783092022;
                case 101 -> -117447663;
                case 102 -> -262164030;
                case 103 -> 990235814;
                case 104 -> -2069547112;
                case 105 -> 337086505;
                case 106 -> 1679644015;
                case 107 -> 339125462;
                case 108 -> 377946465;
                case 109 -> -803376083;
                case 110 -> -664321307;
                case 111 -> 1886689579;
                case 112 -> 534311622;
                case 113 -> -1240993836;
                case 114 -> -683046849;
                case 115 -> -1740399340;
                case 116 -> 1219320910;
                case 117 -> -1088918251;
                case 118 -> 386920022;
                case 119 -> 2084578670;
                case 120 -> -1573210167;
                case 121 -> 1263207338;
                case 122 -> 531816250;
                case 123 -> 621594764;
                case 124 -> 1696129877;
                case 125 -> -282695913;
                case 126 -> -970055198;
                case 127 -> -687829350;
                case 128 -> 1182593400;
                case 129 -> -620202528;
                case 130 -> -12120192;
                case 131 -> 524004049;
                case 132 -> 1028798790;
                case 133 -> -716734572;
                case 134 -> 829376825;
                case 135 -> 33453015;
                case 136 -> 1051256642;
                case 137 -> -952046430;
                case 138 -> -959704183;
                case 139 -> -914829235;
                case 140 -> -270583252;
                case 141 -> -1477315320;
                case 142 -> -868625087;
                case 143 -> 788949335;
                case 144 -> 1030493067;
                case 145 -> 356478413;
                case 146 -> 463889002;
                case 147 -> 422466053;
                case 148 -> -1266240031;
                case 149 -> 1809705729;
                case 150 -> 244586718;
                case 151 -> 620955088;
                case 152 -> 89175391;
                case 153 -> 1696324251;
                case 154 -> 1547889677;
                case 155 -> 65659041;
                case 156 -> 535065979;
                case 157 -> -1243405826;
                case 158 -> 1696329828;
                case 159 -> 496989554;
                case 160 -> 1912327065;
                case 161 -> 1667268280;
                case 162 -> 1171190332;
                case 163 -> 1136683185;
                case 164 -> 973574671;
                case 165 -> 1276824128;
                case 166 -> 391725201;
                case 167 -> -562780059;
                case 168 -> 415910869;
                case 169 -> 270838405;
                case 170 -> 1764206108;
                case 171 -> 995442600;
                case 172 -> -1055581369;
                case 173 -> 616003790;
                case 174 -> 1727348132;
                case 175 -> 1585644888;
                case 176 -> 795325800;
                case 177 -> -1892785499;
                case 178 -> 271293772;
                case 179 -> 1416030644;
                case 180 -> 1445531278;
                case 181 -> -582678725;
                case 182 -> 832603603;
                case 183 -> -553994514;
                case 184 -> -533206080;
                case 185 -> 1424823751;
                case 186 -> 1876431491;
                case 187 -> -301767299;
                case 188 -> 535795819;
                case 189 -> -1455249506;
                case 190 -> 246550213;
                case 191 -> 2090106663;
                case 192 -> -1783732563;
                case 193 -> 1818194214;
                case 194 -> 1725692566;
                case 195 -> -1312420003;
                case 196 -> -1548700384;
                case 197 -> -481758860;
                case 198 -> 952687378;
                case 199 -> -453170960;
                case 200 -> 250393224;
                case 201 -> 1110850019;
                case 202 -> -1819614067;
                case 203 -> -239005748;
                case 204 -> 851971488;
                case 205 -> -533854490;
                case 206 -> -1829074027;
                case 207 -> 169177898;
                case 208 -> 1094860111;
                case 209 -> -641321677;
                case 210 -> 1062841500;
                case 211 -> -2097914905;
                case 212 -> 1338192323;
                case 213 -> 1608108996;
                case 214 -> -1067928645;
                case 215 -> 1661511570;
                case 216 -> 593982719;
                case 217 -> -1868878339;
                case 218 -> 2035221185;
                case 219 -> 1651788268;
                case 220 -> -610263117;
                case 221 -> -71555017;
                case 222 -> -1814624757;
                case 223 -> -1988385404;
                case 224 -> -2138164615;
                case 225 -> -1648494980;
                case 226 -> -1139690752;
                case 227 -> 1436658480;
                case 228 -> -1327097775;
                case 229 -> 1058496428;
                case 230 -> 366760424;
                case 231 -> -950626341;
                case 232 -> -626949805;
                case 233 -> 1241485703;
                case 234 -> -1484859676;
                case 235 -> -1609202701;
                case 236 -> -1886205552;
                case 237 -> -1450152238;
                case 238 -> -66566840;
                case 239 -> 2011897975;
                case 240 -> 877569364;
                case 241 -> 1994084534;
                case 242 -> -1460553742;
                case 243 -> -601734111;
                case 244 -> -501891322;
                case 245 -> -1195931782;
                case 246 -> -1225255809;
                case 247 -> -176607904;
                case 248 -> 1420918108;
                case 249 -> 1774329048;
                case 250 -> -391668215;
                case 251 -> -49504097;
                case 252 -> -254530056;
                case 253 -> 964334773;
                case 254 -> 689166182;
                case 255 -> 710166012;
                default -> -1212272416;
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

