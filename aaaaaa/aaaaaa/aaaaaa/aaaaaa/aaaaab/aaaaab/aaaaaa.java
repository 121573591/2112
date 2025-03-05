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
 *  net.minecraft.class_1937
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
import net.minecraft.class_1937;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

public final class aaaaaa {
    static Object aaaaaa;

    public aaaaaa(@NotNull MinecraftServer minecraftServer, @NotNull class_1937 class_19372) {
        Intrinsics.checkNotNullParameter((Object)minecraftServer, (String)((String)aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaaa.aaaaaa((char)-1640169472)));
        Intrinsics.checkNotNullParameter((Object)class_19372, (String)((String)aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab.aaaaaa.aaaaaa((char)-333447167)));
    }

    static {
        byte[] byArray = "¼\t?ÒË~«=uOª¥qºÊÅ\téë3¶e+¬°5Ý.\"'%tÍÔùøÁ tF-".getBytes("ISO_8859_1");
        Object[] objectArray = "^ÂSõârj".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 166482639;
                case 1 -> 1775768523;
                case 2 -> 748353327;
                case 3 -> -1859798922;
                case 4 -> 1532892200;
                case 5 -> -1959241609;
                case 6 -> -684323007;
                case 7 -> -97037328;
                case 8 -> -340500194;
                case 9 -> -1852157214;
                case 10 -> 817203657;
                case 11 -> -1011781351;
                case 12 -> -146930942;
                case 13 -> -865833430;
                case 14 -> -48746322;
                case 15 -> -1154144799;
                case 16 -> -259517586;
                case 17 -> 490135638;
                case 18 -> -327170619;
                case 19 -> -436876652;
                case 20 -> 1749470201;
                case 21 -> 1025181378;
                case 22 -> 827780387;
                case 23 -> 1686039803;
                case 24 -> 1236930176;
                case 25 -> 1775250095;
                case 26 -> 175283504;
                case 27 -> 1212761773;
                case 28 -> 872940535;
                case 29 -> 784558538;
                case 30 -> -1029476081;
                case 31 -> 166462437;
                case 32 -> 366562033;
                case 33 -> -2116501281;
                case 34 -> -444683500;
                case 35 -> -1549133000;
                case 36 -> 19377293;
                case 37 -> -1173910710;
                case 38 -> 1903019201;
                case 39 -> -571375758;
                case 40 -> 1525239985;
                case 41 -> -852693357;
                case 42 -> -863055801;
                case 43 -> 73163287;
                case 44 -> 1380963202;
                case 45 -> 1469773239;
                case 46 -> -740354068;
                case 47 -> 1344464099;
                case 48 -> -1091319435;
                case 49 -> -887919846;
                case 50 -> -708007400;
                case 51 -> -890382524;
                case 52 -> -910521185;
                case 53 -> -1605782873;
                case 54 -> -236790435;
                case 55 -> 417428328;
                case 56 -> -758293419;
                case 57 -> -436792133;
                case 58 -> -1441736743;
                case 59 -> 1958816742;
                case 60 -> -321506142;
                case 61 -> 792812620;
                case 62 -> 1581824100;
                case 63 -> -1820590639;
                case 64 -> -1540891436;
                case 65 -> -655640344;
                case 66 -> -1809251787;
                case 67 -> 528671753;
                case 68 -> 347868631;
                case 69 -> 1304832238;
                case 70 -> -381078809;
                case 71 -> -297709549;
                case 72 -> 357287786;
                case 73 -> 1330641118;
                case 74 -> 719178843;
                case 75 -> 86625459;
                case 76 -> 1433607739;
                case 77 -> 63312605;
                case 78 -> -2013837964;
                case 79 -> 1715940301;
                case 80 -> 705894116;
                case 81 -> 1595813621;
                case 82 -> 534936534;
                case 83 -> -2140867946;
                case 84 -> -1422299517;
                case 85 -> 1694240305;
                case 86 -> 862501711;
                case 87 -> -85472239;
                case 88 -> 318724412;
                case 89 -> 1052667709;
                case 90 -> 421035293;
                case 91 -> -2087108812;
                case 92 -> -1437758704;
                case 93 -> 1989495573;
                case 94 -> 1369396007;
                case 95 -> -1019739738;
                case 96 -> 1082467874;
                case 97 -> 527144182;
                case 98 -> -53429576;
                case 99 -> -825192979;
                case 100 -> 1123179520;
                case 101 -> -712340581;
                case 102 -> -1317224292;
                case 103 -> 1442306350;
                case 104 -> 837212480;
                case 105 -> 1702713099;
                case 106 -> -990594750;
                case 107 -> -1690541314;
                case 108 -> -391688784;
                case 109 -> 1512015179;
                case 110 -> 1112240271;
                case 111 -> -2101356691;
                case 112 -> 70820374;
                case 113 -> -1876327750;
                case 114 -> -1069445191;
                case 115 -> -449959697;
                case 116 -> -1865498288;
                case 117 -> 1362778404;
                case 118 -> 1990600815;
                case 119 -> -244532338;
                case 120 -> -9968942;
                case 121 -> 42870541;
                case 122 -> 603890803;
                case 123 -> -140049082;
                case 124 -> -1975723012;
                case 125 -> -2004543228;
                case 126 -> -1312264189;
                case 127 -> 453762318;
                case 128 -> -2141201295;
                case 129 -> -2011762440;
                case 130 -> -203799353;
                case 131 -> 1591817297;
                case 132 -> 610833225;
                case 133 -> 1451972221;
                case 134 -> 898747187;
                case 135 -> 1976177276;
                case 136 -> -1465536710;
                case 137 -> -561022002;
                case 138 -> -1865022362;
                case 139 -> -243991681;
                case 140 -> 2050563883;
                case 141 -> -62534134;
                case 142 -> -960118623;
                case 143 -> -1683544232;
                case 144 -> 755346419;
                case 145 -> -931870752;
                case 146 -> -1284706140;
                case 147 -> 838543750;
                case 148 -> 2041161601;
                case 149 -> 969283100;
                case 150 -> -1538081759;
                case 151 -> -1443894293;
                case 152 -> 1982589793;
                case 153 -> 710388880;
                case 154 -> 811438955;
                case 155 -> -447797152;
                case 156 -> 1857899552;
                case 157 -> -1275828475;
                case 158 -> 2108273491;
                case 159 -> 364954293;
                case 160 -> 121783538;
                case 161 -> 2120379971;
                case 162 -> -1430141591;
                case 163 -> 1540529076;
                case 164 -> -310542551;
                case 165 -> -711888962;
                case 166 -> -881811031;
                case 167 -> -1206725454;
                case 168 -> -940735410;
                case 169 -> 2035504734;
                case 170 -> 1096699749;
                case 171 -> -1772842007;
                case 172 -> -201545765;
                case 173 -> 703476774;
                case 174 -> 1293537913;
                case 175 -> -501891239;
                case 176 -> 1615069589;
                case 177 -> 343826028;
                case 178 -> 1481924474;
                case 179 -> 561924266;
                case 180 -> -2104026742;
                case 181 -> -871625592;
                case 182 -> 1965686384;
                case 183 -> -522721786;
                case 184 -> 1318549511;
                case 185 -> 1353183583;
                case 186 -> -610351060;
                case 187 -> 1021801672;
                case 188 -> -1242800939;
                case 189 -> 1763090330;
                case 190 -> 1027027282;
                case 191 -> 1971275282;
                case 192 -> -1070843558;
                case 193 -> -305483304;
                case 194 -> -1174071751;
                case 195 -> -1523308196;
                case 196 -> -1555381565;
                case 197 -> -2123760227;
                case 198 -> 837453821;
                case 199 -> 1838472547;
                case 200 -> 2134353928;
                case 201 -> 68836478;
                case 202 -> -479301289;
                case 203 -> 584992694;
                case 204 -> -712553264;
                case 205 -> 127320491;
                case 206 -> -2037467342;
                case 207 -> -1255889190;
                case 208 -> 2042628487;
                case 209 -> -489312001;
                case 210 -> -927052219;
                case 211 -> -779321636;
                case 212 -> 1299964608;
                case 213 -> 957761448;
                case 214 -> -1493865118;
                case 215 -> -223076468;
                case 216 -> 2117575752;
                case 217 -> -642159092;
                case 218 -> 916779672;
                case 219 -> -300361096;
                case 220 -> 1453710243;
                case 221 -> -1868501358;
                case 222 -> 230520203;
                case 223 -> -78552129;
                case 224 -> -873649468;
                case 225 -> -1708759814;
                case 226 -> 1745733029;
                case 227 -> -609687860;
                case 228 -> 1436471597;
                case 229 -> -27758529;
                case 230 -> 474199228;
                case 231 -> 859623878;
                case 232 -> -22315519;
                case 233 -> -1387493273;
                case 234 -> 1477801022;
                case 235 -> -92709751;
                case 236 -> -211171763;
                case 237 -> 641222060;
                case 238 -> 1355346820;
                case 239 -> 1039091540;
                case 240 -> -1373455073;
                case 241 -> 351086547;
                case 242 -> -1364073065;
                case 243 -> -583047370;
                case 244 -> -1378967052;
                case 245 -> 1098782112;
                case 246 -> 2123791293;
                case 247 -> 914286826;
                case 248 -> -755721063;
                case 249 -> -1937366895;
                case 250 -> 511047045;
                case 251 -> 1682010139;
                case 252 -> -499257954;
                case 253 -> 1677476475;
                case 254 -> -1691648219;
                case 255 -> 128218423;
                default -> -1535239340;
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
            Object[] objectArray2 = new Object[2];
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

