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
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.class_2540
 *  net.minecraft.class_3222
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaadh;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2540;
import net.minecraft.class_3222;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;

public final class aaaaae
implements class_8710 {
    @NotNull
    public static final aaaaae 我草你怎么反编译我模组aaaaat;
    @NotNull
    private static final class_8710.class_9154<aaaaae> 我草你怎么反编译我模组aaaaah;
    @NotNull
    private static final class_9139<class_2540, aaaaae> 我草你怎么反编译我模组aaaaai;
    static Object aaaaau;

    private aaaaae() {
    }

    @NotNull
    public class_8710.class_9154<? extends class_8710> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaae::你为什么要破解我的代码aaaabb);
    }

    private static final void 你为什么要破解我的代码aaaaba(class_3222 class_32222) {
        String string = aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaac().toJson((Object)aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa());
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaae.aaaabc((char)-1045364736)));
        ServerPlayNetworking.send((class_3222)class_32222, (class_8710)new aaaaad(string));
        aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaae.aaaabc((char)1149501441), (Object)class_32222.method_5477().getString());
    }

    private static final void 你为什么要破解我的代码aaaabb(aaaaae aaaaae2, ServerPlayNetworking.Context context) {
        class_3222 class_32222 = context.player();
        class_32222.field_13995.execute(() -> aaaaae.你为什么要破解我的代码aaaaba(class_32222));
    }

    static {
        byte[] byArray = "Å$~Ñ7¾é6&$E$>w¶@Ë)eÑaò¯5È@xE±/6=~FÌ{ ^º¥\r¥]ñÔàyÏ×ý¥6mÓî@@vêI²>ÁaTªZ}<ágz­ÿü¬P\fÓg\nÖ°\tC4­Ddg-AÜäò[é2".getBytes("ISO_8859_1");
        Object[] objectArray = "J\tXáºãf".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1185551970;
                case 1 -> 856483780;
                case 2 -> -1102994174;
                case 3 -> -1804043070;
                case 4 -> -448207326;
                case 5 -> 1306335856;
                case 6 -> 858391435;
                case 7 -> 1143843091;
                case 8 -> -2010262457;
                case 9 -> -1268307699;
                case 10 -> -328726396;
                case 11 -> 197112520;
                case 12 -> -2070469514;
                case 13 -> -1728721004;
                case 14 -> 827486212;
                case 15 -> 1059315287;
                case 16 -> 903384702;
                case 17 -> -756376359;
                case 18 -> 540506137;
                case 19 -> -1965877318;
                case 20 -> -453174330;
                case 21 -> -1401457200;
                case 22 -> -2082639387;
                case 23 -> -1221074118;
                case 24 -> 2114701263;
                case 25 -> -436789347;
                case 26 -> -193962755;
                case 27 -> 1492262612;
                case 28 -> -823203433;
                case 29 -> -1367438559;
                case 30 -> -536468281;
                case 31 -> -2063381742;
                case 32 -> 2105190535;
                case 33 -> 1151852780;
                case 34 -> 2103008911;
                case 35 -> 2110753994;
                case 36 -> -2029059474;
                case 37 -> 1832086230;
                case 38 -> 1525986549;
                case 39 -> -1475569405;
                case 40 -> 689317530;
                case 41 -> -1372985081;
                case 42 -> 604463569;
                case 43 -> -562476611;
                case 44 -> -1100471777;
                case 45 -> -1209075661;
                case 46 -> -457352952;
                case 47 -> 902658488;
                case 48 -> -425118032;
                case 49 -> 23688885;
                case 50 -> 142347797;
                case 51 -> 1224440777;
                case 52 -> 843596440;
                case 53 -> -195875221;
                case 54 -> 386853543;
                case 55 -> 1708737170;
                case 56 -> 1410798614;
                case 57 -> 706750243;
                case 58 -> -656610714;
                case 59 -> 752417353;
                case 60 -> 1221503372;
                case 61 -> -335452958;
                case 62 -> -1477248157;
                case 63 -> 0xDDD02D;
                case 64 -> 158175987;
                case 65 -> 546173419;
                case 66 -> -767230398;
                case 67 -> -1481439009;
                case 68 -> -947975474;
                case 69 -> -86475839;
                case 70 -> -1153330451;
                case 71 -> -1250383605;
                case 72 -> -1237482988;
                case 73 -> 2020012394;
                case 74 -> -302837202;
                case 75 -> 1589273419;
                case 76 -> 1500228087;
                case 77 -> 417647274;
                case 78 -> 1068131044;
                case 79 -> 2065331336;
                case 80 -> -689231975;
                case 81 -> 1119879169;
                case 82 -> 332821035;
                case 83 -> 1455662417;
                case 84 -> -87514875;
                case 85 -> -1234444069;
                case 86 -> 2121637721;
                case 87 -> 947044009;
                case 88 -> 1659419859;
                case 89 -> -167500298;
                case 90 -> -1984148942;
                case 91 -> -1642533068;
                case 92 -> -2013647897;
                case 93 -> 62790952;
                case 94 -> 123625148;
                case 95 -> 1478366276;
                case 96 -> 1091372853;
                case 97 -> -1505966421;
                case 98 -> -1130394311;
                case 99 -> 610461705;
                case 100 -> -1636828809;
                case 101 -> 163056932;
                case 102 -> 740852815;
                case 103 -> -745511104;
                case 104 -> 58194850;
                case 105 -> 389462389;
                case 106 -> -270701875;
                case 107 -> -1908207862;
                case 108 -> -1243633230;
                case 109 -> -350380048;
                case 110 -> 1372867219;
                case 111 -> -2122989256;
                case 112 -> 1756853627;
                case 113 -> 424550428;
                case 114 -> 1414553080;
                case 115 -> 729372244;
                case 116 -> -659539253;
                case 117 -> -1036442345;
                case 118 -> 2006010172;
                case 119 -> 570642069;
                case 120 -> 1679684859;
                case 121 -> 820710170;
                case 122 -> -2020360337;
                case 123 -> 2007962240;
                case 124 -> -1431789946;
                case 125 -> -781702371;
                case 126 -> 1976770012;
                case 127 -> -1192053618;
                case 128 -> -75662618;
                case 129 -> -1074201076;
                case 130 -> -2114849994;
                case 131 -> -1220462479;
                case 132 -> 2100515833;
                case 133 -> 679481841;
                case 134 -> -1574332831;
                case 135 -> 1109505452;
                case 136 -> 481847335;
                case 137 -> -941412293;
                case 138 -> -2017518086;
                case 139 -> 1386474793;
                case 140 -> 147395709;
                case 141 -> 1949599574;
                case 142 -> -1229031715;
                case 143 -> -1290786574;
                case 144 -> -1445300758;
                case 145 -> -505434474;
                case 146 -> -920490960;
                case 147 -> -1942395547;
                case 148 -> 55873375;
                case 149 -> 1743374772;
                case 150 -> 379242021;
                case 151 -> -2001322163;
                case 152 -> 1588311160;
                case 153 -> 982729021;
                case 154 -> -108007795;
                case 155 -> 230035382;
                case 156 -> 866203646;
                case 157 -> 362591873;
                case 158 -> -904548262;
                case 159 -> -697491124;
                case 160 -> -554719250;
                case 161 -> 894971178;
                case 162 -> 1316290947;
                case 163 -> -1821632516;
                case 164 -> -769188187;
                case 165 -> -1832211156;
                case 166 -> -653330711;
                case 167 -> -404502087;
                case 168 -> 818045556;
                case 169 -> -625888176;
                case 170 -> 47793106;
                case 171 -> -1390923264;
                case 172 -> -3808891;
                case 173 -> 2088977823;
                case 174 -> -86577496;
                case 175 -> 224019619;
                case 176 -> 583386236;
                case 177 -> 1555462299;
                case 178 -> -1275716280;
                case 179 -> 621394892;
                case 180 -> -616519331;
                case 181 -> 1208863983;
                case 182 -> -303687997;
                case 183 -> 379400881;
                case 184 -> -1575962460;
                case 185 -> -881090166;
                case 186 -> -1459166888;
                case 187 -> 532686147;
                case 188 -> 1183657955;
                case 189 -> -791897058;
                case 190 -> 734408807;
                case 191 -> 1450942903;
                case 192 -> -804091631;
                case 193 -> -1966416897;
                case 194 -> 1590913115;
                case 195 -> 1868020636;
                case 196 -> -1119362753;
                case 197 -> 1061698342;
                case 198 -> 399439720;
                case 199 -> -978243643;
                case 200 -> -1126414309;
                case 201 -> 967646113;
                case 202 -> 2109167110;
                case 203 -> -413161922;
                case 204 -> -1243673778;
                case 205 -> 948719716;
                case 206 -> 966286957;
                case 207 -> 25068937;
                case 208 -> 109200116;
                case 209 -> -2087435817;
                case 210 -> -1222125513;
                case 211 -> -1225566754;
                case 212 -> -414772666;
                case 213 -> 1077961406;
                case 214 -> -1908122088;
                case 215 -> 1869224553;
                case 216 -> 1116176734;
                case 217 -> -1037206925;
                case 218 -> -436599734;
                case 219 -> -265214161;
                case 220 -> 1967768441;
                case 221 -> 1529245397;
                case 222 -> 2114083600;
                case 223 -> -991736600;
                case 224 -> 42295983;
                case 225 -> 1848017888;
                case 226 -> 854311099;
                case 227 -> 1835559584;
                case 228 -> 1975692689;
                case 229 -> 1256802865;
                case 230 -> -1922166443;
                case 231 -> -1899903918;
                case 232 -> 2038512654;
                case 233 -> 477081180;
                case 234 -> -315541872;
                case 235 -> 899196864;
                case 236 -> 2035978604;
                case 237 -> 795136942;
                case 238 -> 1957434849;
                case 239 -> 433794629;
                case 240 -> 1134694432;
                case 241 -> 751091027;
                case 242 -> 1023992767;
                case 243 -> 1528579967;
                case 244 -> -1030497166;
                case 245 -> -187567400;
                case 246 -> -530192369;
                case 247 -> 1260994881;
                case 248 -> -1774693766;
                case 249 -> 1569099482;
                case 250 -> -728225107;
                case 251 -> 278428851;
                case 252 -> -1640352928;
                case 253 -> -1182764414;
                case 254 -> -1022913378;
                case 255 -> -1959128666;
                default -> 709474413;
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
            aaaaau = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaat = new aaaaae();
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaae.aaaabc((char)-1271595006)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaae.aaaabc((char)1820655619)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56431((Object)我草你怎么反编译我模组aaaaat);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaae.aaaabc((char)1602158596)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaabc(char c) {
        return ((Object[])aaaaau)[c];
    }
}

