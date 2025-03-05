/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  java.awt.image.BufferedImage
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.net.URL
 *  java.net.URLConnection
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.concurrent.CompletableFuture
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  javax.imageio.ImageIO
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1011
 *  net.minecraft.class_1011$class_1012
 *  net.minecraft.class_1043
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.concurrent.CompletableFuture;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.imageio.ImageIO;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaaaac {
    @NotNull
    public static final aaaaac 我草你怎么反编译我模组aaaaaa;
    @Nullable
    private static class_2960 我草你怎么反编译我模组aaaaab;
    @Nullable
    private static String 我草你怎么反编译我模组aaaaac;
    private static final int 我草你怎么反编译我模组aaaaad;
    static Object aaaaae;

    private aaaaac() {
    }

    public final void 你为什么要破解我的代码aaaaaa(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaac.aaaaae((char)-2004549632)));
        if (Intrinsics.areEqual((Object)string, (Object)我草你怎么反编译我模组aaaaac)) {
            return;
        }
        我草你怎么反编译我模组aaaaac = string;
        CompletableFuture.runAsync(() -> aaaaac.你为什么要破解我的代码aaaaad(string));
    }

    public final void 你为什么要破解我的代码aaaaab(@NotNull class_332 class_3322) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)class_3322, (String)((String)aaaaac.aaaaae((char)1089339393)));
            class_2960 class_29602 = 我草你怎么反编译我模组aaaaab;
            if (class_29602 == null) break block0;
            class_2960 class_29603 = class_29602;
            boolean bl = false;
            int n = class_310.method_1551().method_22683().method_4486();
            RenderSystem.enableBlend();
            class_3322.method_25290(class_29603, n - 我草你怎么反编译我模组aaaaad - 5, 5, 0.0f, 0.0f, 我草你怎么反编译我模组aaaaad, 我草你怎么反编译我模组aaaaad, 我草你怎么反编译我模组aaaaad, 我草你怎么反编译我模组aaaaad);
            RenderSystem.disableBlend();
        }
    }

    private static final void 你为什么要破解我的代码aaaaac(class_1011 class_10112) {
        Intrinsics.checkNotNullParameter((Object)class_10112, (String)((String)aaaaac.aaaaae((char)2133131266)));
        class_1043 class_10432 = new class_1043(class_10112);
        我草你怎么反编译我模组aaaaab = class_310.method_1551().method_1531().method_4617((String)aaaaac.aaaaae((char)-814612477), class_10432);
    }

    private static final void 你为什么要破解我的代码aaaaad(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaac.aaaaae((char)-1489633276)));
        try {
            URLConnection uRLConnection = new URL(string).openConnection();
            uRLConnection.setRequestProperty((String)aaaaac.aaaaae((char)1303969797), (String)aaaaac.aaaaae((char)-1595015162));
            BufferedImage bufferedImage = ImageIO.read((InputStream)uRLConnection.getInputStream());
            class_1011 class_10112 = new class_1011(class_1011.class_1012.field_4997, bufferedImage.getWidth(), bufferedImage.getHeight(), true);
            int n = bufferedImage.getWidth();
            for (int i = 0; i < n; ++i) {
                int n2 = bufferedImage.getHeight();
                for (int j = 0; j < n2; ++j) {
                    int n3 = bufferedImage.getRGB(i, j);
                    int n4 = n3 >> 24 & 0xFF;
                    int n5 = n3 >> 16 & 0xFF;
                    int n6 = n3 >> 8 & 0xFF;
                    int n7 = n3 & 0xFF;
                    int n8 = n4 << 24 | n7 << 16 | n6 << 8 | n5;
                    class_10112.method_4305(i, j, n8);
                }
            }
            class_310.method_1551().execute(() -> aaaaac.你为什么要破解我的代码aaaaac(class_10112));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static {
        byte[] byArray = "éQÊIÔëNNÉKB÷«B!$äðs[³t¡þX`ìØìÀ'8Î){âµÔ¿ò£µ)\tÌ-Â]Dw$x|46ÔÁo2!9È?&²ÏÛ»2ö<ù3\b..#ÈGæµÁß7h¸Á".getBytes("ISO_8859_1");
        Object[] objectArray = "<;=';".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1185878357;
                case 1 -> 1621628251;
                case 2 -> -1911150311;
                case 3 -> 436606995;
                case 4 -> -96634729;
                case 5 -> 1236716617;
                case 6 -> 825627920;
                case 7 -> 107611018;
                case 8 -> 1020444518;
                case 9 -> -1589152145;
                case 10 -> -455526237;
                case 11 -> -1895967968;
                case 12 -> 1804404576;
                case 13 -> -120882201;
                case 14 -> -573765982;
                case 15 -> 1116888423;
                case 16 -> 2070187046;
                case 17 -> -1682302263;
                case 18 -> 1424329462;
                case 19 -> 1780378687;
                case 20 -> 68339717;
                case 21 -> 1994583376;
                case 22 -> 342265434;
                case 23 -> -495219019;
                case 24 -> -449038852;
                case 25 -> 1384039150;
                case 26 -> 1027699982;
                case 27 -> -854888045;
                case 28 -> 951637769;
                case 29 -> 2131888065;
                case 30 -> -1176861952;
                case 31 -> -2139406886;
                case 32 -> 1408629302;
                case 33 -> -1298830099;
                case 34 -> 904963814;
                case 35 -> 2084414940;
                case 36 -> -718422445;
                case 37 -> 1569623417;
                case 38 -> 594473150;
                case 39 -> -441740004;
                case 40 -> -1244177160;
                case 41 -> -1341411625;
                case 42 -> 1923046497;
                case 43 -> -2142844493;
                case 44 -> -729987414;
                case 45 -> -1441600596;
                case 46 -> 363500541;
                case 47 -> -761747425;
                case 48 -> 2069134795;
                case 49 -> 1262904893;
                case 50 -> 331921269;
                case 51 -> -1579472776;
                case 52 -> -658318936;
                case 53 -> 2005158860;
                case 54 -> 71531109;
                case 55 -> 2000726706;
                case 56 -> -776468751;
                case 57 -> -1151157091;
                case 58 -> -190181577;
                case 59 -> 92994975;
                case 60 -> -711494364;
                case 61 -> 1624571120;
                case 62 -> 1956356040;
                case 63 -> 66126477;
                case 64 -> -1766875809;
                case 65 -> 1799908238;
                case 66 -> 1016424145;
                case 67 -> 525706652;
                case 68 -> -1826806141;
                case 69 -> 542975757;
                case 70 -> 1618846345;
                case 71 -> -1547035582;
                case 72 -> -423693518;
                case 73 -> -800627529;
                case 74 -> 2054481113;
                case 75 -> 1367384536;
                case 76 -> -909501109;
                case 77 -> 203675330;
                case 78 -> -1156871359;
                case 79 -> -1057744179;
                case 80 -> -1495574639;
                case 81 -> 1650112825;
                case 82 -> 1502699697;
                case 83 -> -849581835;
                case 84 -> -1185592692;
                case 85 -> -422425358;
                case 86 -> -971923405;
                case 87 -> -1446098221;
                case 88 -> 1873928683;
                case 89 -> 661314929;
                case 90 -> 250478203;
                case 91 -> -1209988312;
                case 92 -> 1197905270;
                case 93 -> -229922556;
                case 94 -> -1171306229;
                case 95 -> -1918667954;
                case 96 -> -816173523;
                case 97 -> 1411986462;
                case 98 -> 1993006354;
                case 99 -> 659335077;
                case 100 -> -454257070;
                case 101 -> 371385082;
                case 102 -> 1619526391;
                case 103 -> 1319956979;
                case 104 -> -327704645;
                case 105 -> 2120150873;
                case 106 -> 2048971819;
                case 107 -> 1244505672;
                case 108 -> -1288050200;
                case 109 -> 963185072;
                case 110 -> -1594988823;
                case 111 -> -697394676;
                case 112 -> 873151932;
                case 113 -> -1110885227;
                case 114 -> -1138214291;
                case 115 -> -343747547;
                case 116 -> -1538518460;
                case 117 -> -1534205655;
                case 118 -> -1279575500;
                case 119 -> 1890942854;
                case 120 -> -512223419;
                case 121 -> -505625447;
                case 122 -> -1069758418;
                case 123 -> -1831124892;
                case 124 -> -1679956326;
                case 125 -> 1565311803;
                case 126 -> -1698522129;
                case 127 -> 818115023;
                case 128 -> -562281414;
                case 129 -> -1811252590;
                case 130 -> -1330609867;
                case 131 -> -1298141697;
                case 132 -> -383282203;
                case 133 -> -203433245;
                case 134 -> -1055314466;
                case 135 -> -1955503802;
                case 136 -> -1356831902;
                case 137 -> -681592798;
                case 138 -> -1352682658;
                case 139 -> -1309583055;
                case 140 -> -881972198;
                case 141 -> 636724566;
                case 142 -> 630939584;
                case 143 -> 542278525;
                case 144 -> -606094853;
                case 145 -> -677662854;
                case 146 -> 555220675;
                case 147 -> 583191401;
                case 148 -> 365218209;
                case 149 -> 286576566;
                case 150 -> 1080608093;
                case 151 -> 589451824;
                case 152 -> -1836394017;
                case 153 -> 1662265046;
                case 154 -> -1255901581;
                case 155 -> 538801667;
                case 156 -> 1889614996;
                case 157 -> 1804752195;
                case 158 -> -406489960;
                case 159 -> -167292565;
                case 160 -> 78043861;
                case 161 -> -1140619412;
                case 162 -> 43044106;
                case 163 -> -1548390353;
                case 164 -> 707152980;
                case 165 -> 1611529888;
                case 166 -> -720142140;
                case 167 -> 1282715260;
                case 168 -> 1615536520;
                case 169 -> -1491452529;
                case 170 -> 1962249706;
                case 171 -> -1657114952;
                case 172 -> 4557339;
                case 173 -> 892673669;
                case 174 -> 248936781;
                case 175 -> -1649105751;
                case 176 -> 515881478;
                case 177 -> -1100126959;
                case 178 -> -354457095;
                case 179 -> -1190241236;
                case 180 -> -770003065;
                case 181 -> -530862051;
                case 182 -> 1760756363;
                case 183 -> -983187966;
                case 184 -> -899793131;
                case 185 -> 421317399;
                case 186 -> -668755839;
                case 187 -> 256621743;
                case 188 -> -1339912945;
                case 189 -> -17580414;
                case 190 -> -2137229394;
                case 191 -> 1869929684;
                case 192 -> 1266110930;
                case 193 -> 1229600644;
                case 194 -> -156024938;
                case 195 -> 1732631294;
                case 196 -> 1429180618;
                case 197 -> 2015039709;
                case 198 -> 362979514;
                case 199 -> 1415450283;
                case 200 -> 1111401678;
                case 201 -> -1958998015;
                case 202 -> -1866468620;
                case 203 -> 1458359725;
                case 204 -> -1405235862;
                case 205 -> 884554687;
                case 206 -> 1729197766;
                case 207 -> 1505640284;
                case 208 -> -234909625;
                case 209 -> -1044036552;
                case 210 -> 927153371;
                case 211 -> 1220497081;
                case 212 -> -1450662649;
                case 213 -> -236457292;
                case 214 -> 1163195924;
                case 215 -> 1652536362;
                case 216 -> -937672132;
                case 217 -> -2058580376;
                case 218 -> 1211842215;
                case 219 -> 1580487767;
                case 220 -> 1736701016;
                case 221 -> 782217290;
                case 222 -> -531429085;
                case 223 -> -114602386;
                case 224 -> -1751552880;
                case 225 -> 470613073;
                case 226 -> 3038051;
                case 227 -> 935758525;
                case 228 -> 714789540;
                case 229 -> -1696421354;
                case 230 -> -198348024;
                case 231 -> 103328289;
                case 232 -> 943232884;
                case 233 -> -1419126961;
                case 234 -> -221776345;
                case 235 -> -418671753;
                case 236 -> -1462378126;
                case 237 -> 1004542700;
                case 238 -> -610410640;
                case 239 -> 1928793312;
                case 240 -> 1449325214;
                case 241 -> 1399835105;
                case 242 -> -1365230976;
                case 243 -> -1300162149;
                case 244 -> -1261751611;
                case 245 -> -1379281346;
                case 246 -> 991816674;
                case 247 -> -223799609;
                case 248 -> -412696112;
                case 249 -> 786259940;
                case 250 -> 8453656;
                case 251 -> -570838196;
                case 252 -> 897167743;
                case 253 -> -1990840256;
                case 254 -> 1817007270;
                case 255 -> 657282942;
                default -> -473345240;
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
            Object[] objectArray2 = new Object[7];
            objectArray = objectArray2;
            aaaaae = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaa = new aaaaac();
        我草你怎么反编译我模组aaaaad = 32;
    }

    private static Object aaaaae(char c) {
        return ((Object[])aaaaae)[c];
    }
}

