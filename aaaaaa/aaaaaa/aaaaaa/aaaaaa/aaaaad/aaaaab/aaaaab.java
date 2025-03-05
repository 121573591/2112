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

public final class aaaaab {
    static Object aaaaaa;

    public aaaaab(@NotNull class_310 class_3102) {
        Intrinsics.checkNotNullParameter((Object)class_3102, (String)((String)aaaaab.aaaaaa((char)-221773824)));
    }

    static {
        byte[] byArray = "Ìõyøìíòß¾Áõ¶{Àuã¨J/òB\f`ñìl5ëÒ\"Gb_ü".getBytes("ISO_8859_1");
        Object[] objectArray = "ÓMid·3;".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -425818311;
                case 1 -> 1448003107;
                case 2 -> 1142232674;
                case 3 -> -1593016763;
                case 4 -> 427694112;
                case 5 -> -1228084328;
                case 6 -> -1832755487;
                case 7 -> -1915363423;
                case 8 -> -1220512950;
                case 9 -> -291370319;
                case 10 -> 48212894;
                case 11 -> -716543920;
                case 12 -> -424509867;
                case 13 -> -1966392215;
                case 14 -> 1959777795;
                case 15 -> -613959662;
                case 16 -> 712151759;
                case 17 -> -1386935309;
                case 18 -> -1589213904;
                case 19 -> 768892149;
                case 20 -> -1360930517;
                case 21 -> 545571076;
                case 22 -> -1269946755;
                case 23 -> -996064102;
                case 24 -> 216426265;
                case 25 -> 1214904863;
                case 26 -> -779872489;
                case 27 -> -2049075321;
                case 28 -> 1772093658;
                case 29 -> 1813934813;
                case 30 -> -1973846802;
                case 31 -> 109251309;
                case 32 -> 552313957;
                case 33 -> -708348438;
                case 34 -> 789286536;
                case 35 -> -386909034;
                case 36 -> -407877284;
                case 37 -> -707951422;
                case 38 -> 1961778252;
                case 39 -> 42583505;
                case 40 -> 1035037363;
                case 41 -> 804518138;
                case 42 -> -858698311;
                case 43 -> -1502483592;
                case 44 -> -1286975888;
                case 45 -> 1497614016;
                case 46 -> 318037887;
                case 47 -> 1305620083;
                case 48 -> -1338040834;
                case 49 -> 22652702;
                case 50 -> -478319243;
                case 51 -> 103886226;
                case 52 -> 738150613;
                case 53 -> 165236453;
                case 54 -> -1161364564;
                case 55 -> -150829123;
                case 56 -> -410599635;
                case 57 -> -2134088693;
                case 58 -> 1287278618;
                case 59 -> 1212527148;
                case 60 -> -608044791;
                case 61 -> -1211270237;
                case 62 -> -645668831;
                case 63 -> 1206125699;
                case 64 -> 2134041711;
                case 65 -> -951306995;
                case 66 -> 756107897;
                case 67 -> -640854288;
                case 68 -> 1892884614;
                case 69 -> -466009432;
                case 70 -> -507352167;
                case 71 -> -1160381805;
                case 72 -> -820891288;
                case 73 -> -331481906;
                case 74 -> 705123123;
                case 75 -> -1890582952;
                case 76 -> -1097563214;
                case 77 -> -1970484864;
                case 78 -> 276076663;
                case 79 -> -142286243;
                case 80 -> 1061318088;
                case 81 -> -1030456511;
                case 82 -> -831796265;
                case 83 -> 1154761598;
                case 84 -> -1518039935;
                case 85 -> -2018353946;
                case 86 -> -1760684035;
                case 87 -> -309384689;
                case 88 -> -1015208817;
                case 89 -> 648260795;
                case 90 -> 1259032376;
                case 91 -> 2062478529;
                case 92 -> -924554738;
                case 93 -> -1875859517;
                case 94 -> -901781997;
                case 95 -> -1895703531;
                case 96 -> 170381899;
                case 97 -> 1234725190;
                case 98 -> -1774673825;
                case 99 -> 1733769699;
                case 100 -> -2033528774;
                case 101 -> -1209646026;
                case 102 -> -858064067;
                case 103 -> 1071058222;
                case 104 -> 503949820;
                case 105 -> 1288592864;
                case 106 -> 148738838;
                case 107 -> 1992948670;
                case 108 -> -1113244766;
                case 109 -> -2026332891;
                case 110 -> -827587447;
                case 111 -> -891281429;
                case 112 -> 1942544046;
                case 113 -> -864136382;
                case 114 -> -66709345;
                case 115 -> 1833272064;
                case 116 -> -2006333438;
                case 117 -> 2060458078;
                case 118 -> 1600270797;
                case 119 -> -1882860254;
                case 120 -> -1634628758;
                case 121 -> -1367423685;
                case 122 -> -1776857302;
                case 123 -> 686315766;
                case 124 -> 1090232731;
                case 125 -> -1808034181;
                case 126 -> -2049764607;
                case 127 -> -1459079404;
                case 128 -> 831004200;
                case 129 -> -1492072883;
                case 130 -> -349918294;
                case 131 -> -1963146178;
                case 132 -> -964431066;
                case 133 -> 1393902050;
                case 134 -> 1143834016;
                case 135 -> -64470907;
                case 136 -> -1511432763;
                case 137 -> 1794324276;
                case 138 -> -803919417;
                case 139 -> 838545230;
                case 140 -> 1002534262;
                case 141 -> 126004071;
                case 142 -> -236081940;
                case 143 -> -2124061117;
                case 144 -> 2012869364;
                case 145 -> 1932939343;
                case 146 -> 1149931660;
                case 147 -> 2123187995;
                case 148 -> 798000913;
                case 149 -> -265666809;
                case 150 -> 1554252352;
                case 151 -> -1816598635;
                case 152 -> 254250585;
                case 153 -> -1937149019;
                case 154 -> 599575337;
                case 155 -> -723780313;
                case 156 -> 1747832941;
                case 157 -> -17302748;
                case 158 -> -253660879;
                case 159 -> -990318634;
                case 160 -> 1878891194;
                case 161 -> 687691593;
                case 162 -> -524596773;
                case 163 -> 716328589;
                case 164 -> 1475707219;
                case 165 -> 1900773492;
                case 166 -> 1155171186;
                case 167 -> -2058515274;
                case 168 -> 684685072;
                case 169 -> -1871415268;
                case 170 -> 1858499485;
                case 171 -> -1170285114;
                case 172 -> -1734273209;
                case 173 -> -1586924872;
                case 174 -> 1049861044;
                case 175 -> -396268561;
                case 176 -> 1681542268;
                case 177 -> -1724127971;
                case 178 -> 447951715;
                case 179 -> 545153275;
                case 180 -> -1471826212;
                case 181 -> -1739971268;
                case 182 -> -1213709215;
                case 183 -> -168267946;
                case 184 -> -1897894999;
                case 185 -> -2021240742;
                case 186 -> 109741544;
                case 187 -> 1167644696;
                case 188 -> -1986719798;
                case 189 -> -266363045;
                case 190 -> -251687573;
                case 191 -> 1054216970;
                case 192 -> -2013249825;
                case 193 -> 264469165;
                case 194 -> 752294743;
                case 195 -> 750493426;
                case 196 -> -685581064;
                case 197 -> -1993548204;
                case 198 -> 1627354103;
                case 199 -> -501376025;
                case 200 -> -423049210;
                case 201 -> 1024320678;
                case 202 -> 1297290896;
                case 203 -> 809122199;
                case 204 -> 1336994204;
                case 205 -> 1808302756;
                case 206 -> 1729192331;
                case 207 -> -896133579;
                case 208 -> 2022553783;
                case 209 -> 707320698;
                case 210 -> -387463228;
                case 211 -> 1040191295;
                case 212 -> -540825967;
                case 213 -> -207310584;
                case 214 -> 931773400;
                case 215 -> -1367591728;
                case 216 -> -1103297170;
                case 217 -> 281594544;
                case 218 -> 2133951304;
                case 219 -> 1604114580;
                case 220 -> -1291757621;
                case 221 -> 162946495;
                case 222 -> -482051446;
                case 223 -> 1204545023;
                case 224 -> -642243482;
                case 225 -> 807396057;
                case 226 -> -1812362895;
                case 227 -> 947253708;
                case 228 -> -434255927;
                case 229 -> -1017786705;
                case 230 -> -1232545314;
                case 231 -> 1311493132;
                case 232 -> 234013924;
                case 233 -> 1894322991;
                case 234 -> -1621624409;
                case 235 -> 736521977;
                case 236 -> 139761476;
                case 237 -> 913474129;
                case 238 -> 1258689195;
                case 239 -> -152795979;
                case 240 -> -1359405051;
                case 241 -> 2053852978;
                case 242 -> -277884334;
                case 243 -> -1940387095;
                case 244 -> -1179382317;
                case 245 -> -1275830828;
                case 246 -> -1862587716;
                case 247 -> 579710594;
                case 248 -> 557834604;
                case 249 -> 556736868;
                case 250 -> -1359540850;
                case 251 -> -1952521888;
                case 252 -> 1505396690;
                case 253 -> -492558716;
                case 254 -> -1009005513;
                case 255 -> -346367247;
                default -> 1373604911;
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

