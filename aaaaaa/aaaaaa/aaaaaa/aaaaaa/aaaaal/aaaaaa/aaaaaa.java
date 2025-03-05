/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
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
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import cn.pixellive.mc.game.PixelLiveGameMod;
import com.mojang.blaze3d.systems.RenderSystem;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;

@Environment(value=EnvType.CLIENT)
public class aaaaaa {
    private static final class_2960 我草你怎么反编译我模组aaaaaa;
    private static final class_2960 我草你怎么反编译我模组aaaaab;
    private static final int 我草你怎么反编译我模组aaaaac;
    private static final int 我草你怎么反编译我模组aaaaad;
    private static final int 我草你怎么反编译我模组aaaaae;
    private static long 我草你怎么反编译我模组aaaaaf;
    private static boolean 我草你怎么反编译我模组aaaaag;
    private static boolean 我草你怎么反编译我模组aaaaah;
    static Object aaaaai;

    public static void 你为什么要破解我的代码aaaaaa() {
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() == null) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaaa.aaaaad((char)-2132344832));
            return;
        }
        我草你怎么反编译我模组aaaaaf = System.currentTimeMillis();
        我草你怎么反编译我模组aaaaag = true;
        我草你怎么反编译我模组aaaaah = false;
    }

    public static void 你为什么要破解我的代码aaaaab() {
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() == null) {
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaaa.aaaaad((char)-717750271));
            return;
        }
        我草你怎么反编译我模组aaaaaf = System.currentTimeMillis();
        我草你怎么反编译我模组aaaaag = true;
        我草你怎么反编译我模组aaaaah = true;
    }

    public static void 你为什么要破解我的代码aaaaac(class_332 class_3322) {
        int n;
        if (!我草你怎么反编译我模组aaaaag) {
            return;
        }
        long l = System.currentTimeMillis() - 我草你怎么反编译我模组aaaaaf;
        int n2 = n = 我草你怎么反编译我模组aaaaah ? 2000 : 500;
        if (l > (long)n) {
            我草你怎么反编译我模组aaaaag = false;
            aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaaa.aaaaad((char)2032664578));
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        int n3 = (class_3102.method_22683().method_4486() - 16) / 2;
        int n4 = (class_3102.method_22683().method_4502() - 16) / 2;
        float f = 1.0f - (float)l / (float)n;
        class_2960 class_29602 = 我草你怎么反编译我模组aaaaah ? 我草你怎么反编译我模组aaaaab : 我草你怎么反编译我模组aaaaaa;
        RenderSystem.enableBlend();
        RenderSystem.setShaderTexture((int)0, (class_2960)class_29602);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f);
        class_3322.method_25290(class_29602, n3, n4, 0.0f, 0.0f, 16, 16, 16, 16);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.disableBlend();
    }

    static {
        byte[] byArray = "JzQ]Ë)£W\boÕÞÓ_³¾eÿWcàMPý5\fuðr{¹hÉK§):at[.¬Lì]È}»hþzÐ:S+Óá]N!Õï>~v³ÀÄª¸G\bâÁîÍu!s;Û¦¤oýµPRà¢¤9é\tXÂòO\nôáº»ªt`t8Õ§úçÝ\fQ7n\"<üIb2©¥Â·5PÛKG»EV/ät*ÂÅäÆwæX·êfrÌ æqíûAm1»iæ2j2ÐP-7íø´b!Ò6%Ú,û\r\nØÛ\"?@é".getBytes("ISO_8859_1");
        Object[] objectArray = "ÉS`·nÆ".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 232432647;
                case 1 -> -401248600;
                case 2 -> -737172081;
                case 3 -> 1081433545;
                case 4 -> 782842654;
                case 5 -> -286471719;
                case 6 -> 1500319551;
                case 7 -> -1263684138;
                case 8 -> 255447503;
                case 9 -> 1650154208;
                case 10 -> -211548028;
                case 11 -> 1610102786;
                case 12 -> -1412115750;
                case 13 -> 1928993352;
                case 14 -> 683835505;
                case 15 -> 787882687;
                case 16 -> 1762752488;
                case 17 -> -817585051;
                case 18 -> -617831610;
                case 19 -> 867149021;
                case 20 -> -624350963;
                case 21 -> -848832403;
                case 22 -> -769799603;
                case 23 -> 1462102339;
                case 24 -> -1934497746;
                case 25 -> -911059947;
                case 26 -> -233043184;
                case 27 -> 196691020;
                case 28 -> -1653102574;
                case 29 -> -33288951;
                case 30 -> -1226028522;
                case 31 -> 793542886;
                case 32 -> -1839883318;
                case 33 -> -1465221138;
                case 34 -> 1375734076;
                case 35 -> -684171053;
                case 36 -> -5386816;
                case 37 -> 334188534;
                case 38 -> 204825729;
                case 39 -> -1414479010;
                case 40 -> -1137795055;
                case 41 -> 995576586;
                case 42 -> 2123690680;
                case 43 -> -428930727;
                case 44 -> 1694171270;
                case 45 -> -182708186;
                case 46 -> 406880146;
                case 47 -> -7627992;
                case 48 -> 725834618;
                case 49 -> -1138027799;
                case 50 -> -1551840560;
                case 51 -> -1112881928;
                case 52 -> -1274364493;
                case 53 -> 1349526392;
                case 54 -> -267399865;
                case 55 -> 1245655894;
                case 56 -> 1387566327;
                case 57 -> 884706033;
                case 58 -> 144716155;
                case 59 -> 1239863158;
                case 60 -> -72546363;
                case 61 -> -1163007648;
                case 62 -> -327554467;
                case 63 -> -502478963;
                case 64 -> -280570201;
                case 65 -> 1814431458;
                case 66 -> 1729048180;
                case 67 -> 1111880254;
                case 68 -> -1694026963;
                case 69 -> -1683742465;
                case 70 -> 2112634681;
                case 71 -> 1468725570;
                case 72 -> 1783175563;
                case 73 -> 571391573;
                case 74 -> -325601302;
                case 75 -> 63298392;
                case 76 -> -341378980;
                case 77 -> 2088850245;
                case 78 -> 488654153;
                case 79 -> -1285637854;
                case 80 -> -1741501972;
                case 81 -> -930271587;
                case 82 -> 108011463;
                case 83 -> -1093791188;
                case 84 -> -915284294;
                case 85 -> 2094629554;
                case 86 -> -699561312;
                case 87 -> 1576583182;
                case 88 -> -1265431346;
                case 89 -> 664240696;
                case 90 -> 2138259121;
                case 91 -> 1618769923;
                case 92 -> 430632035;
                case 93 -> 806083694;
                case 94 -> 1403161593;
                case 95 -> -1755736751;
                case 96 -> 1445684564;
                case 97 -> 1421808511;
                case 98 -> 423394279;
                case 99 -> 1003576128;
                case 100 -> -1618430896;
                case 101 -> -386236444;
                case 102 -> 1527669768;
                case 103 -> 1662920507;
                case 104 -> -682646625;
                case 105 -> 844100596;
                case 106 -> -1965974620;
                case 107 -> 421335161;
                case 108 -> 34973912;
                case 109 -> -2042212130;
                case 110 -> 1789215881;
                case 111 -> 1398208768;
                case 112 -> 1474632931;
                case 113 -> 958761281;
                case 114 -> -1161534245;
                case 115 -> -61789877;
                case 116 -> -464207657;
                case 117 -> 629202100;
                case 118 -> 2116664352;
                case 119 -> -1427385140;
                case 120 -> 261832401;
                case 121 -> -1463402956;
                case 122 -> 502665323;
                case 123 -> -1525206090;
                case 124 -> 1441034227;
                case 125 -> -1073328452;
                case 126 -> 260364428;
                case 127 -> -426895736;
                case 128 -> 540504125;
                case 129 -> 1503148655;
                case 130 -> 1600556555;
                case 131 -> -2050029174;
                case 132 -> -1348866064;
                case 133 -> -1737394475;
                case 134 -> 322373916;
                case 135 -> -646216854;
                case 136 -> 2030975152;
                case 137 -> 1430335570;
                case 138 -> -658925464;
                case 139 -> -1328107556;
                case 140 -> 617533744;
                case 141 -> -1948526257;
                case 142 -> 151772970;
                case 143 -> 831764571;
                case 144 -> -1509702403;
                case 145 -> 159595086;
                case 146 -> -295988837;
                case 147 -> 96324043;
                case 148 -> -279255042;
                case 149 -> -832841063;
                case 150 -> 949655041;
                case 151 -> 1686247317;
                case 152 -> -1783778655;
                case 153 -> 1646839429;
                case 154 -> 359676846;
                case 155 -> -1169778662;
                case 156 -> 24411032;
                case 157 -> 1450371735;
                case 158 -> -664965438;
                case 159 -> -1107404153;
                case 160 -> 2070949636;
                case 161 -> 1456575300;
                case 162 -> 620050371;
                case 163 -> 894864515;
                case 164 -> -1779379614;
                case 165 -> 1063112867;
                case 166 -> 761911443;
                case 167 -> -2056935438;
                case 168 -> -206542758;
                case 169 -> -2118992543;
                case 170 -> -1765647685;
                case 171 -> 339239273;
                case 172 -> -861992954;
                case 173 -> -1233585258;
                case 174 -> -1458344602;
                case 175 -> -147965915;
                case 176 -> 2037794533;
                case 177 -> 614193577;
                case 178 -> -2007904572;
                case 179 -> 483513472;
                case 180 -> -1112068222;
                case 181 -> -1674908784;
                case 182 -> -1459373423;
                case 183 -> 485987265;
                case 184 -> 236420779;
                case 185 -> -1714216092;
                case 186 -> -1636170467;
                case 187 -> -777067551;
                case 188 -> 345493287;
                case 189 -> -586768521;
                case 190 -> -980361369;
                case 191 -> 1698256929;
                case 192 -> -1396313690;
                case 193 -> -1902462881;
                case 194 -> 1787001129;
                case 195 -> 1459919157;
                case 196 -> 1330357148;
                case 197 -> -1407705673;
                case 198 -> -1990397878;
                case 199 -> 970100936;
                case 200 -> -988064340;
                case 201 -> -1921980804;
                case 202 -> -1841020133;
                case 203 -> 1510831327;
                case 204 -> 898741843;
                case 205 -> 864880810;
                case 206 -> 76036644;
                case 207 -> -1157914426;
                case 208 -> -2130953972;
                case 209 -> 1314751799;
                case 210 -> -936674348;
                case 211 -> -1235135755;
                case 212 -> -144586827;
                case 213 -> 86721197;
                case 214 -> -318749840;
                case 215 -> 844937597;
                case 216 -> 191648051;
                case 217 -> -69311213;
                case 218 -> -1822004716;
                case 219 -> -1490357217;
                case 220 -> -1473839185;
                case 221 -> -1874354122;
                case 222 -> -457854787;
                case 223 -> -934615528;
                case 224 -> 1731074002;
                case 225 -> 457493498;
                case 226 -> 59346293;
                case 227 -> 1818036779;
                case 228 -> 2032859853;
                case 229 -> 657371810;
                case 230 -> 230876667;
                case 231 -> -2089967567;
                case 232 -> -1522026823;
                case 233 -> 261488153;
                case 234 -> -1368954857;
                case 235 -> 1850268558;
                case 236 -> 720050746;
                case 237 -> -1439591187;
                case 238 -> 1271760286;
                case 239 -> -1588659441;
                case 240 -> 1959217573;
                case 241 -> 1044439148;
                case 242 -> -1040242278;
                case 243 -> 339242583;
                case 244 -> -1437454221;
                case 245 -> -1027025924;
                case 246 -> 1898757502;
                case 247 -> -459776789;
                case 248 -> 375417906;
                case 249 -> -1254449294;
                case 250 -> -2018698818;
                case 251 -> -1259450732;
                case 252 -> -1273990621;
                case 253 -> -1249942033;
                case 254 -> 496917295;
                case 255 -> -1946303995;
                default -> -1212344026;
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
            Object[] objectArray2 = new Object[6];
            objectArray = objectArray2;
            aaaaai = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaae = 2000;
        我草你怎么反编译我模组aaaaad = 500;
        我草你怎么反编译我模组aaaaac = 16;
        我草你怎么反编译我模组aaaaaa = class_2960.method_60655((String)((String)aaaaaa.aaaaad((char)-1198653437)), (String)((String)aaaaaa.aaaaad((char)-1629487100)));
        我草你怎么反编译我模组aaaaab = class_2960.method_60655((String)((String)aaaaaa.aaaaad((char)-949682173)), (String)((String)aaaaaa.aaaaad((char)401145861)));
        我草你怎么反编译我模组aaaaaf = 0L;
        我草你怎么反编译我模组aaaaag = false;
        我草你怎么反编译我模组aaaaah = false;
    }

    private static Object aaaaad(char c) {
        return ((Object[])aaaaai)[c];
    }
}

