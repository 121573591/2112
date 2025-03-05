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

public final class aaaaaf {
    static Object aaaaaa;

    public aaaaaf(@NotNull MinecraftServer minecraftServer) {
        Intrinsics.checkNotNullParameter((Object)minecraftServer, (String)((String)aaaaaf.aaaaaa((char)-609943552)));
    }

    static {
        byte[] byArray = "ôÍæÜÉÔÚZoåÎÂ.Ú»w\t1!ÑÐª@ 3§ÑQù© °xt´5MéËvª".getBytes("ISO_8859_1");
        Object[] objectArray = "Nâ´Í7_a".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1571950291;
                case 1 -> -233473950;
                case 2 -> 1332342381;
                case 3 -> 56021476;
                case 4 -> -417141792;
                case 5 -> 1918662927;
                case 6 -> -1630884004;
                case 7 -> 1895147269;
                case 8 -> 1085993722;
                case 9 -> 1058100956;
                case 10 -> -1454357194;
                case 11 -> 1698495613;
                case 12 -> 1713765102;
                case 13 -> 103607390;
                case 14 -> -614547734;
                case 15 -> 1333273173;
                case 16 -> 82685693;
                case 17 -> 773894167;
                case 18 -> -1462509053;
                case 19 -> -386858004;
                case 20 -> 1105016311;
                case 21 -> 1141229515;
                case 22 -> -1523802612;
                case 23 -> 1818303682;
                case 24 -> 1343229962;
                case 25 -> -1640218847;
                case 26 -> -1565595367;
                case 27 -> 693317068;
                case 28 -> 763938634;
                case 29 -> 1405378036;
                case 30 -> 1551852295;
                case 31 -> 335908888;
                case 32 -> 668093807;
                case 33 -> -2098923698;
                case 34 -> -264620712;
                case 35 -> 1458069899;
                case 36 -> -1241957179;
                case 37 -> -1890629880;
                case 38 -> -1625622930;
                case 39 -> 1154614845;
                case 40 -> -631744547;
                case 41 -> -501107417;
                case 42 -> -583558232;
                case 43 -> -1112035676;
                case 44 -> 1619386481;
                case 45 -> 36731942;
                case 46 -> -888230920;
                case 47 -> 2053032589;
                case 48 -> -1872378293;
                case 49 -> -636208378;
                case 50 -> -2098639056;
                case 51 -> 1364702481;
                case 52 -> 557756173;
                case 53 -> 1357625360;
                case 54 -> -1667897118;
                case 55 -> 1608578331;
                case 56 -> -2064755482;
                case 57 -> 733971185;
                case 58 -> 1728596906;
                case 59 -> -950675946;
                case 60 -> -566503679;
                case 61 -> -2058670193;
                case 62 -> 1421398989;
                case 63 -> 180504841;
                case 64 -> -737353185;
                case 65 -> 567892055;
                case 66 -> 896258080;
                case 67 -> -480167472;
                case 68 -> -802370935;
                case 69 -> -367223952;
                case 70 -> 446636284;
                case 71 -> -311829500;
                case 72 -> 1369640947;
                case 73 -> -339653477;
                case 74 -> 863235354;
                case 75 -> -605840847;
                case 76 -> -1299653828;
                case 77 -> 907577980;
                case 78 -> -708387668;
                case 79 -> -377515075;
                case 80 -> -568104961;
                case 81 -> -1376325913;
                case 82 -> 478749064;
                case 83 -> 686943788;
                case 84 -> -536645461;
                case 85 -> -1024587193;
                case 86 -> -1819191071;
                case 87 -> -936089212;
                case 88 -> 1044910904;
                case 89 -> -1700175765;
                case 90 -> -280820518;
                case 91 -> -1564551318;
                case 92 -> -1440366030;
                case 93 -> 1923915215;
                case 94 -> -1495786957;
                case 95 -> -430338498;
                case 96 -> -1866978771;
                case 97 -> 1580871476;
                case 98 -> -754449270;
                case 99 -> -1879513654;
                case 100 -> 1966092820;
                case 101 -> 856064425;
                case 102 -> 343664086;
                case 103 -> 290475794;
                case 104 -> 450724460;
                case 105 -> 214795930;
                case 106 -> -1506266484;
                case 107 -> 666806719;
                case 108 -> 1671766196;
                case 109 -> -1020967133;
                case 110 -> -1944074087;
                case 111 -> 1763496052;
                case 112 -> 1282219554;
                case 113 -> -2025739439;
                case 114 -> -181067614;
                case 115 -> 370316591;
                case 116 -> -1491114257;
                case 117 -> 2114630840;
                case 118 -> 545409466;
                case 119 -> -1692034719;
                case 120 -> -2023480193;
                case 121 -> -14168446;
                case 122 -> 316197448;
                case 123 -> -990333834;
                case 124 -> -564768302;
                case 125 -> 1891107443;
                case 126 -> 791057630;
                case 127 -> -261493275;
                case 128 -> 1887135135;
                case 129 -> -627562791;
                case 130 -> -886204613;
                case 131 -> -2019023265;
                case 132 -> 1114715299;
                case 133 -> -258647149;
                case 134 -> 1799340585;
                case 135 -> 2033776953;
                case 136 -> 1246984006;
                case 137 -> -1174707506;
                case 138 -> -1317445257;
                case 139 -> 1215985873;
                case 140 -> -938701890;
                case 141 -> 1003730724;
                case 142 -> -871354720;
                case 143 -> 397658545;
                case 144 -> 601579019;
                case 145 -> -886872616;
                case 146 -> 1525519197;
                case 147 -> 92456128;
                case 148 -> -1030576488;
                case 149 -> 1791164855;
                case 150 -> 858708437;
                case 151 -> 1235491093;
                case 152 -> 1890828710;
                case 153 -> -431139464;
                case 154 -> -275883708;
                case 155 -> 989242286;
                case 156 -> 181006147;
                case 157 -> 508988758;
                case 158 -> -77275605;
                case 159 -> 1500637203;
                case 160 -> -124733600;
                case 161 -> 719781202;
                case 162 -> 1529009901;
                case 163 -> 1439887157;
                case 164 -> 599439146;
                case 165 -> -447620248;
                case 166 -> 1159002101;
                case 167 -> 222423296;
                case 168 -> -388227777;
                case 169 -> -214862652;
                case 170 -> 272660423;
                case 171 -> 1818647143;
                case 172 -> 1531877611;
                case 173 -> 1188541938;
                case 174 -> -1050734846;
                case 175 -> 42384276;
                case 176 -> 974814643;
                case 177 -> -14998288;
                case 178 -> -1077720381;
                case 179 -> -978597454;
                case 180 -> 1850434881;
                case 181 -> -1101688900;
                case 182 -> -244192080;
                case 183 -> -1550912984;
                case 184 -> -1999336393;
                case 185 -> -1477766242;
                case 186 -> -1622839406;
                case 187 -> 731811954;
                case 188 -> -913593202;
                case 189 -> -1174060618;
                case 190 -> 1270668876;
                case 191 -> 198833403;
                case 192 -> -133747817;
                case 193 -> -946371507;
                case 194 -> -647523911;
                case 195 -> -1611503270;
                case 196 -> 479642192;
                case 197 -> -629208127;
                case 198 -> 2096334927;
                case 199 -> 1061003875;
                case 200 -> -1319369371;
                case 201 -> -1075715351;
                case 202 -> -1963166266;
                case 203 -> -841395556;
                case 204 -> -1812305303;
                case 205 -> 1192619637;
                case 206 -> 118861597;
                case 207 -> -819538842;
                case 208 -> 497858449;
                case 209 -> -1231944503;
                case 210 -> 1080661381;
                case 211 -> 2126587823;
                case 212 -> -1140326386;
                case 213 -> -403156601;
                case 214 -> -722655563;
                case 215 -> 1753129350;
                case 216 -> -23951401;
                case 217 -> -1385514808;
                case 218 -> 1053740635;
                case 219 -> 1798510971;
                case 220 -> -1093190628;
                case 221 -> -1135675611;
                case 222 -> -189547871;
                case 223 -> -872514727;
                case 224 -> 671394523;
                case 225 -> -1783520966;
                case 226 -> 80157667;
                case 227 -> -62984216;
                case 228 -> 1789952832;
                case 229 -> 1339312301;
                case 230 -> -1865204354;
                case 231 -> 1643977621;
                case 232 -> -1220074171;
                case 233 -> -530290813;
                case 234 -> 1456759030;
                case 235 -> -182707682;
                case 236 -> 809551527;
                case 237 -> -2002918235;
                case 238 -> 1777441124;
                case 239 -> -234997537;
                case 240 -> 1252796974;
                case 241 -> 1433744784;
                case 242 -> -607630380;
                case 243 -> -2014669930;
                case 244 -> 305722622;
                case 245 -> -1559065413;
                case 246 -> -1984236972;
                case 247 -> 93263517;
                case 248 -> -336979639;
                case 249 -> 766019961;
                case 250 -> -977518765;
                case 251 -> 196973441;
                case 252 -> 1379596160;
                case 253 -> 927357250;
                case 254 -> -1575232134;
                case 255 -> 624548601;
                default -> 352847947;
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

