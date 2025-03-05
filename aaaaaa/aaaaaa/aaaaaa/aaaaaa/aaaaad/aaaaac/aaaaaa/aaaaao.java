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
 *  net.minecraft.class_1934
 *  net.minecraft.class_2540
 *  net.minecraft.class_3222
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabM;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaaq;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import cn.pixellive.mc.game.PixelLiveGameMod;
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
import net.minecraft.class_1934;
import net.minecraft.class_2540;
import net.minecraft.class_3222;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;

public final class aaaaao
implements class_8710 {
    @NotNull
    public static final aaaaao 我草你怎么反编译我模组aaaabi;
    @NotNull
    private static final class_8710.class_9154<aaaaao> 我草你怎么反编译我模组aaaaah;
    @NotNull
    private static final class_9139<class_2540, aaaaao> 我草你怎么反编译我模组aaaaai;
    static Object aaaabj;

    private aaaaao() {
    }

    @NotNull
    public class_8710.class_9154<? extends class_8710> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaao::你为什么要破解我的代码aaaacY);
    }

    private static final void 你为什么要破解我的代码aaaaba(class_3222 class_32222) {
        String string;
        aaaaas aaaaas2 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
        String string2 = string = aaaaas2 != null ? aaaaas2.你为什么要破解我的代码aaaaaj() : null;
        if (Intrinsics.areEqual((Object)string, (Object)aaaabM.我草你怎么反编译我模组aaaadA.你为什么要破解我的代码aaaaaj())) {
            aaaabM.我草你怎么反编译我模组aaaadA.你为什么要破解我的代码aaaakK();
            class_1934 class_19342 = class_32222.field_13974.method_14257();
            switch (class_19342 == null ? -1 : aaaaaq.我草你怎么反编译我模组aaaaaa[class_19342.ordinal()]) {
                case 1: {
                    class_32222.method_7336(class_1934.field_9219);
                    break;
                }
                case 2: {
                    class_32222.method_7336(class_1934.field_9220);
                    break;
                }
                default: {
                    aaaaab.你为什么要破解我的代码aaaaaa().info("Player " + class_32222.method_5477() + " is not in Creative or Spectator mode, no action taken");
                    break;
                }
            }
        } else if (Intrinsics.areEqual((Object)string, (Object)aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaaaj())) {
            class_1934 class_19343 = class_32222.field_13974.method_14257();
            switch (class_19343 == null ? -1 : aaaaaq.我草你怎么反编译我模组aaaaaa[class_19343.ordinal()]) {
                case 3: {
                    class_32222.method_7336(class_1934.field_9219);
                    break;
                }
                case 2: {
                    class_32222.method_7336(class_1934.field_9216);
                    break;
                }
                default: {
                    aaaaab.你为什么要破解我的代码aaaaaa().info("Player " + class_32222.method_5477() + " is not in Creative or Spectator mode, no action taken");
                }
            }
        }
    }

    private static final void 你为什么要破解我的代码aaaacY(aaaaao aaaaao2, ServerPlayNetworking.Context context) {
        class_3222 class_32222 = context.player();
        class_32222.field_13995.execute(() -> aaaaao.你为什么要破解我的代码aaaaba(class_32222));
    }

    static {
        byte[] byArray = "ª~«a¯g+ºßÄ=¹ÍH\tÞ¹È¦_Ôs~eÔZãM|ñª9e).àâ4¬À\fóNF¿yÈ¡ó´Þ)òM|\t\"ûâøR#´E".getBytes("ISO_8859_1");
        Object[] objectArray = "_¦Q¥Iá¨".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -104037789;
                case 1 -> 1901144186;
                case 2 -> 811343133;
                case 3 -> 565169754;
                case 4 -> 296165419;
                case 5 -> -133050767;
                case 6 -> -155505557;
                case 7 -> -274210174;
                case 8 -> 894766977;
                case 9 -> 1859843885;
                case 10 -> -1668218381;
                case 11 -> 546161974;
                case 12 -> 1154039932;
                case 13 -> -1693957119;
                case 14 -> -886301167;
                case 15 -> 326768775;
                case 16 -> 2072420985;
                case 17 -> -91943422;
                case 18 -> 1075186953;
                case 19 -> -1693296508;
                case 20 -> -1715961484;
                case 21 -> 751474080;
                case 22 -> -1451027207;
                case 23 -> -1153591098;
                case 24 -> 878319083;
                case 25 -> 1554972720;
                case 26 -> 2004290709;
                case 27 -> 1549286431;
                case 28 -> -1886300239;
                case 29 -> -1983877546;
                case 30 -> 886717840;
                case 31 -> 537150815;
                case 32 -> 838829294;
                case 33 -> 1875429061;
                case 34 -> -1373559555;
                case 35 -> 597082465;
                case 36 -> -1626606921;
                case 37 -> 1070334548;
                case 38 -> -1277788085;
                case 39 -> 1861904652;
                case 40 -> 1867782991;
                case 41 -> 1620842777;
                case 42 -> 1183258448;
                case 43 -> -806708119;
                case 44 -> -1951004797;
                case 45 -> 1262146789;
                case 46 -> -746388136;
                case 47 -> 535372050;
                case 48 -> 1058565157;
                case 49 -> 838018148;
                case 50 -> 1189121721;
                case 51 -> 1384412677;
                case 52 -> 1734751831;
                case 53 -> 764988984;
                case 54 -> -1016544042;
                case 55 -> 11244091;
                case 56 -> 1835619859;
                case 57 -> -201949150;
                case 58 -> -53054448;
                case 59 -> -2144907386;
                case 60 -> 529200687;
                case 61 -> -1168136877;
                case 62 -> 1884565362;
                case 63 -> 1931541289;
                case 64 -> -1019379061;
                case 65 -> -1864595935;
                case 66 -> 44983963;
                case 67 -> 1310765595;
                case 68 -> -29943144;
                case 69 -> -1162046649;
                case 70 -> 528147538;
                case 71 -> -1033532615;
                case 72 -> -773232701;
                case 73 -> -373037086;
                case 74 -> 281488573;
                case 75 -> -1574652852;
                case 76 -> 588111132;
                case 77 -> -1226417960;
                case 78 -> 1878225478;
                case 79 -> -2091119812;
                case 80 -> -353638657;
                case 81 -> -1076649014;
                case 82 -> -830977881;
                case 83 -> -1615344718;
                case 84 -> -1703901674;
                case 85 -> -927099319;
                case 86 -> -726586068;
                case 87 -> -1412277011;
                case 88 -> -1366986947;
                case 89 -> -1896202458;
                case 90 -> 1705415369;
                case 91 -> 1225813043;
                case 92 -> 1670354712;
                case 93 -> 1488025039;
                case 94 -> -311028872;
                case 95 -> 1791672246;
                case 96 -> -1445216529;
                case 97 -> 283531964;
                case 98 -> -190848116;
                case 99 -> 1553629548;
                case 100 -> 1749126313;
                case 101 -> 186817247;
                case 102 -> -1049837801;
                case 103 -> -743182446;
                case 104 -> 330047043;
                case 105 -> -1743615519;
                case 106 -> 437244471;
                case 107 -> -1819891008;
                case 108 -> 599863361;
                case 109 -> -239178635;
                case 110 -> -1034129456;
                case 111 -> 496635242;
                case 112 -> -724679110;
                case 113 -> -738294400;
                case 114 -> -1088453712;
                case 115 -> -921743136;
                case 116 -> 2008381631;
                case 117 -> 1233956794;
                case 118 -> -1414980633;
                case 119 -> -1902486591;
                case 120 -> -1341538192;
                case 121 -> -655381996;
                case 122 -> -200114614;
                case 123 -> 492668892;
                case 124 -> -115017737;
                case 125 -> -1414962432;
                case 126 -> -997092306;
                case 127 -> 723763930;
                case 128 -> -1962942299;
                case 129 -> 1993524915;
                case 130 -> 737322142;
                case 131 -> -633880561;
                case 132 -> -784932856;
                case 133 -> -1679490498;
                case 134 -> -916604139;
                case 135 -> -405916290;
                case 136 -> -1876143747;
                case 137 -> 68761516;
                case 138 -> 1679630939;
                case 139 -> -1159442973;
                case 140 -> 669225024;
                case 141 -> -842726775;
                case 142 -> -1016150163;
                case 143 -> 1808978526;
                case 144 -> 540944059;
                case 145 -> -1028957444;
                case 146 -> -859667137;
                case 147 -> 1005171549;
                case 148 -> -252267238;
                case 149 -> 1302245030;
                case 150 -> 1684249261;
                case 151 -> 1768875169;
                case 152 -> 1330350826;
                case 153 -> -297121867;
                case 154 -> 1470878132;
                case 155 -> -1030304824;
                case 156 -> -570098638;
                case 157 -> -121222860;
                case 158 -> 214114163;
                case 159 -> 817604933;
                case 160 -> -123603631;
                case 161 -> 1425728657;
                case 162 -> 718713736;
                case 163 -> -1082345724;
                case 164 -> 708268398;
                case 165 -> 1426885282;
                case 166 -> -2099328791;
                case 167 -> 1757736397;
                case 168 -> 1244984529;
                case 169 -> 324288798;
                case 170 -> 1421522829;
                case 171 -> 1782882975;
                case 172 -> -284314904;
                case 173 -> -452698626;
                case 174 -> -2099311794;
                case 175 -> -907511645;
                case 176 -> 116229106;
                case 177 -> -1345633142;
                case 178 -> 1212783651;
                case 179 -> 1485526428;
                case 180 -> -1283749110;
                case 181 -> -1949631346;
                case 182 -> -1121191041;
                case 183 -> 1271416315;
                case 184 -> -1520700324;
                case 185 -> 1498787174;
                case 186 -> -1761826494;
                case 187 -> -55798265;
                case 188 -> -251679911;
                case 189 -> 1884051446;
                case 190 -> -1935415132;
                case 191 -> 2019134319;
                case 192 -> -561091722;
                case 193 -> 2130599949;
                case 194 -> 394337845;
                case 195 -> 212361475;
                case 196 -> 1553580421;
                case 197 -> 356370168;
                case 198 -> -1437459936;
                case 199 -> 2094702316;
                case 200 -> 923656437;
                case 201 -> 1329923794;
                case 202 -> 668316310;
                case 203 -> -326377404;
                case 204 -> -608210754;
                case 205 -> 139007631;
                case 206 -> 1754763248;
                case 207 -> 549032710;
                case 208 -> -1975271768;
                case 209 -> -278725973;
                case 210 -> 32184733;
                case 211 -> 2064140919;
                case 212 -> 800255243;
                case 213 -> -1608394537;
                case 214 -> -1946692717;
                case 215 -> 28687374;
                case 216 -> -1496708647;
                case 217 -> 1674545194;
                case 218 -> 706324399;
                case 219 -> 169966577;
                case 220 -> -1948438562;
                case 221 -> -1098969528;
                case 222 -> -1409555252;
                case 223 -> 1405482948;
                case 224 -> -1738008844;
                case 225 -> 882736341;
                case 226 -> -687998311;
                case 227 -> -518099928;
                case 228 -> 2114826958;
                case 229 -> 1882398362;
                case 230 -> 584918987;
                case 231 -> -359808574;
                case 232 -> 1388171853;
                case 233 -> -779354140;
                case 234 -> -762399392;
                case 235 -> 1613067694;
                case 236 -> -910047387;
                case 237 -> -1831069336;
                case 238 -> -152409094;
                case 239 -> -2123683897;
                case 240 -> 232758968;
                case 241 -> -1696282473;
                case 242 -> -1132637996;
                case 243 -> -1053925933;
                case 244 -> 433418461;
                case 245 -> 1558598374;
                case 246 -> -723977093;
                case 247 -> 241663524;
                case 248 -> -865814430;
                case 249 -> 1031903335;
                case 250 -> -969674277;
                case 251 -> 2100576148;
                case 252 -> -1237329835;
                case 253 -> -1042594521;
                case 254 -> 645123889;
                case 255 -> 1804921770;
                default -> 816459112;
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
            Object[] objectArray2 = new Object[3];
            objectArray = objectArray2;
            aaaabj = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabi = new aaaaao();
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaao.aaaacZ((char)75825152)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaao.aaaacZ((char)-1695219711)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56431((Object)我草你怎么反编译我模组aaaabi);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaao.aaaacZ((char)-704839678)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaacZ(char c) {
        return ((Object[])aaaabj)[c];
    }
}

