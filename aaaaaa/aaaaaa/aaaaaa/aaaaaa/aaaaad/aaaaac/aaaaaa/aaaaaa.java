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
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.class_2540
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaar;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveEnterRoomEvent;
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
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2540;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaaaaa
implements class_8710 {
    @NotNull
    public static final aaaaar 我草你怎么反编译我模组aaaaan;
    @NotNull
    private final String 我草你怎么反编译我模组aaaaao;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaaa> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaaa> 我草你怎么反编译我模组aaaaai;
    static Object aaaaap;

    public aaaaaa(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaaa.aaaaaM((char)-2045968384)));
        this.我草你怎么反编译我模组aaaaao = string;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaF() {
        return this.我草你怎么反编译我模组aaaaao;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaaa::你为什么要破解我的代码aaaaaJ);
    }

    @NotNull
    public class_8710.class_9154<aaaaaa> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaG() {
        return this.我草你怎么反编译我模组aaaaao;
    }

    @NotNull
    public final aaaaaa 你为什么要破解我的代码aaaaaH(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaaa.aaaaaM((char)369950720)));
        return new aaaaaa(string);
    }

    public static /* synthetic */ aaaaaa 你为什么要破解我的代码aaaaaI(aaaaaa aaaaaa2, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = aaaaaa2.我草你怎么反编译我模组aaaaao;
        }
        return aaaaaa2.你为什么要破解我的代码aaaaaH(string);
    }

    @NotNull
    public String toString() {
        return "LiveEnterRoomEventPayload(username=" + this.我草你怎么反编译我模组aaaaao + ")";
    }

    public int hashCode() {
        return this.我草你怎么反编译我模组aaaaao.hashCode();
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaaa)) {
            return false;
        }
        aaaaaa aaaaaa2 = (aaaaaa)object;
        return Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaaao, (Object)aaaaaa2.我草你怎么反编译我模组aaaaao);
    }

    private static final void 你为什么要破解我的代码aaaaaJ(aaaaaa aaaaaa2, ServerPlayNetworking.Context context) {
        String string = aaaaaa2.我草你怎么反编译我模组aaaaao;
        aaaaab.你为什么要破解我的代码aaaaaa().info(string + " joined the room");
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().post((Object)new LiveEnterRoomEvent(string));
    }

    private static final void 你为什么要破解我的代码aaaaaK(aaaaaa aaaaaa2, class_2540 class_25402) {
        class_25402.method_10814(aaaaaa2.我草你怎么反编译我模组aaaaao);
    }

    private static final aaaaaa 你为什么要破解我的代码aaaaaL(class_2540 class_25402) {
        String string = class_25402.method_19772();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaaa.aaaaaM((char)-1613823999)));
        return new aaaaaa(string);
    }

    static {
        byte[] byArray = "aRTÑyàRHG=÷¹®/zÓ\f¥ù´|\nÉËB®FÌõ¹\r*\fB®Q(iÅÒêf·3ýi®ØyDùYÉ'×ó³¿áWEL±UÊ''TÔ3vÂ".getBytes("ISO_8859_1");
        Object[] objectArray = "¿Ja¥o¯0".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 802968384;
                case 1 -> -1337030164;
                case 2 -> 852881921;
                case 3 -> 884089954;
                case 4 -> 1901804028;
                case 5 -> -1906803338;
                case 6 -> 914451138;
                case 7 -> -1514072360;
                case 8 -> -1879290611;
                case 9 -> -921061501;
                case 10 -> -145768041;
                case 11 -> 897218894;
                case 12 -> -1835559977;
                case 13 -> -1569439;
                case 14 -> -1661556298;
                case 15 -> 1509797485;
                case 16 -> -11450379;
                case 17 -> -1964049864;
                case 18 -> 694889489;
                case 19 -> 308844911;
                case 20 -> 1935555969;
                case 21 -> 1505557705;
                case 22 -> 701861610;
                case 23 -> -871048588;
                case 24 -> -1085266581;
                case 25 -> 12477106;
                case 26 -> -373017837;
                case 27 -> -981777636;
                case 28 -> 2103771512;
                case 29 -> -2029576870;
                case 30 -> 706840894;
                case 31 -> -544513050;
                case 32 -> 1764198828;
                case 33 -> 1104306002;
                case 34 -> 590168840;
                case 35 -> 552335999;
                case 36 -> 878989269;
                case 37 -> 2050502127;
                case 38 -> -1778817934;
                case 39 -> -1133206945;
                case 40 -> -145634811;
                case 41 -> 1493574699;
                case 42 -> 1525668283;
                case 43 -> 880807960;
                case 44 -> -687359638;
                case 45 -> -710271772;
                case 46 -> -1477594220;
                case 47 -> -356929573;
                case 48 -> -398168791;
                case 49 -> 754081712;
                case 50 -> -171100586;
                case 51 -> -1224704338;
                case 52 -> 1665463913;
                case 53 -> -867127495;
                case 54 -> 990399979;
                case 55 -> -618370477;
                case 56 -> -899728381;
                case 57 -> 327827619;
                case 58 -> 598811238;
                case 59 -> 602051743;
                case 60 -> -295993163;
                case 61 -> -762286348;
                case 62 -> 244767396;
                case 63 -> 1155024483;
                case 64 -> -1552096801;
                case 65 -> -790442443;
                case 66 -> 810075269;
                case 67 -> 1953197326;
                case 68 -> 1191098844;
                case 69 -> -527113903;
                case 70 -> 520778123;
                case 71 -> 690155911;
                case 72 -> -792257859;
                case 73 -> 1042190284;
                case 74 -> -890272386;
                case 75 -> 987250106;
                case 76 -> 1718396057;
                case 77 -> 415244719;
                case 78 -> 461258803;
                case 79 -> -489765462;
                case 80 -> 766540551;
                case 81 -> -1162379880;
                case 82 -> -190577886;
                case 83 -> 1834314762;
                case 84 -> 1265839664;
                case 85 -> -1643268631;
                case 86 -> -1615376311;
                case 87 -> 1633749721;
                case 88 -> -1959413408;
                case 89 -> -677294777;
                case 90 -> -1493755816;
                case 91 -> 1573813793;
                case 92 -> 2024146495;
                case 93 -> 1199750775;
                case 94 -> 1118783765;
                case 95 -> -1813117027;
                case 96 -> -1027043829;
                case 97 -> 1627261056;
                case 98 -> -215552987;
                case 99 -> 853594289;
                case 100 -> 1967589064;
                case 101 -> -1492813024;
                case 102 -> -1174645716;
                case 103 -> 309127710;
                case 104 -> -91870202;
                case 105 -> 140439066;
                case 106 -> 1289231800;
                case 107 -> -1250221451;
                case 108 -> 1587752346;
                case 109 -> -1959390071;
                case 110 -> 1252525869;
                case 111 -> 1203073774;
                case 112 -> 43726920;
                case 113 -> 1993059763;
                case 114 -> -266408219;
                case 115 -> 1844703018;
                case 116 -> -840555017;
                case 117 -> -1121798151;
                case 118 -> -2142806234;
                case 119 -> -1181648335;
                case 120 -> 234315017;
                case 121 -> 2064247067;
                case 122 -> -691367348;
                case 123 -> -627008610;
                case 124 -> 346446403;
                case 125 -> 1005653102;
                case 126 -> -1419391401;
                case 127 -> -1886632327;
                case 128 -> 1790078363;
                case 129 -> 1574900294;
                case 130 -> 2099542563;
                case 131 -> 20409594;
                case 132 -> 413902906;
                case 133 -> -1579749852;
                case 134 -> -124429755;
                case 135 -> 610903831;
                case 136 -> 1220875262;
                case 137 -> 591825820;
                case 138 -> -896155392;
                case 139 -> -1148824692;
                case 140 -> -441282510;
                case 141 -> -1359184910;
                case 142 -> 162906758;
                case 143 -> 1097789171;
                case 144 -> 267849918;
                case 145 -> -1529471203;
                case 146 -> -823879715;
                case 147 -> -414676355;
                case 148 -> 1647181759;
                case 149 -> 807499111;
                case 150 -> -616249631;
                case 151 -> -1645760580;
                case 152 -> 1076169753;
                case 153 -> -20264824;
                case 154 -> -1459892029;
                case 155 -> 270859226;
                case 156 -> 1917430713;
                case 157 -> -1742738401;
                case 158 -> 1741252372;
                case 159 -> 1620071117;
                case 160 -> 1497365349;
                case 161 -> -1099446572;
                case 162 -> -663851212;
                case 163 -> 1109359677;
                case 164 -> 984544808;
                case 165 -> -1398390254;
                case 166 -> -341029231;
                case 167 -> -1412401754;
                case 168 -> -760740206;
                case 169 -> -1642985823;
                case 170 -> 1864979185;
                case 171 -> 1913051808;
                case 172 -> 583953378;
                case 173 -> -1748863667;
                case 174 -> -468766342;
                case 175 -> -1326504979;
                case 176 -> -1144712333;
                case 177 -> 1595004843;
                case 178 -> 352641403;
                case 179 -> 1353298781;
                case 180 -> -1397766597;
                case 181 -> -1994867145;
                case 182 -> -478849856;
                case 183 -> 1638584469;
                case 184 -> 973001035;
                case 185 -> -2119896236;
                case 186 -> -1826040229;
                case 187 -> 1826365326;
                case 188 -> 915048842;
                case 189 -> -757103409;
                case 190 -> 0x1F4F14FF;
                case 191 -> -1696649162;
                case 192 -> -1166648880;
                case 193 -> 753586222;
                case 194 -> -1452011318;
                case 195 -> 1066938365;
                case 196 -> 1084828071;
                case 197 -> 402297798;
                case 198 -> 700089294;
                case 199 -> -1910318698;
                case 200 -> 1478713506;
                case 201 -> -1728753532;
                case 202 -> 1146779471;
                case 203 -> 482554448;
                case 204 -> -531053724;
                case 205 -> -1311788440;
                case 206 -> -1559554636;
                case 207 -> 1132901074;
                case 208 -> -1456015704;
                case 209 -> -1329091518;
                case 210 -> -974457919;
                case 211 -> 174182916;
                case 212 -> -1629002093;
                case 213 -> -307332350;
                case 214 -> -823501455;
                case 215 -> 1205943184;
                case 216 -> -521807945;
                case 217 -> 1875756491;
                case 218 -> -118526469;
                case 219 -> 793051004;
                case 220 -> 569568271;
                case 221 -> 585469927;
                case 222 -> -517744292;
                case 223 -> -11559981;
                case 224 -> -184791422;
                case 225 -> -1283083408;
                case 226 -> 1901651440;
                case 227 -> -512120121;
                case 228 -> -1601543771;
                case 229 -> -337702410;
                case 230 -> -2039623862;
                case 231 -> -1630107951;
                case 232 -> 1088266157;
                case 233 -> -682250218;
                case 234 -> -1855350045;
                case 235 -> 1543851076;
                case 236 -> 1457782486;
                case 237 -> -35752305;
                case 238 -> -1514064188;
                case 239 -> -2092110600;
                case 240 -> -237957081;
                case 241 -> 1976060640;
                case 242 -> 659503169;
                case 243 -> -893827793;
                case 244 -> -525750359;
                case 245 -> 876192653;
                case 246 -> -1760380404;
                case 247 -> 1996127829;
                case 248 -> 1656648133;
                case 249 -> 396947550;
                case 250 -> -1692458948;
                case 251 -> -1440283284;
                case 252 -> -1608635632;
                case 253 -> 1697078361;
                case 254 -> 343851496;
                case 255 -> 2056519646;
                default -> 1874609214;
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
            aaaaap = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaan = new aaaaar(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaaa.aaaaaM((char)454098946)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaaa.aaaaaM((char)-2001403901)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaaa::你为什么要破解我的代码aaaaaK, aaaaaa::你为什么要破解我的代码aaaaaL);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaaa.aaaaaM((char)980353028)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaaaM(char c) {
        return ((Object[])aaaaap)[c];
    }
}

