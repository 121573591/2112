/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
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

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaam;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveLikeEvent;
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

public final class aaaaas
implements class_8710 {
    @NotNull
    public static final aaaaam 我草你怎么反编译我模组aaaabt;
    @NotNull
    private final String 我草你怎么反编译我模组aaaaao;
    private final int 我草你怎么反编译我模组aaaabu;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaas> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaas> 我草你怎么反编译我模组aaaaai;
    static Object aaaabv;

    public aaaaas(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaas.aaaadB((char)-246677504)));
        this.我草你怎么反编译我模组aaaaao = string;
        this.我草你怎么反编译我模组aaaabu = n;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaF() {
        return this.我草你怎么反编译我模组aaaaao;
    }

    public final int 你为什么要破解我的代码aaaadv() {
        return this.我草你怎么反编译我模组aaaabu;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaas::你为什么要破解我的代码aaaady);
    }

    @NotNull
    public class_8710.class_9154<aaaaas> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaG() {
        return this.我草你怎么反编译我模组aaaaao;
    }

    public final int 你为什么要破解我的代码aaaaai() {
        return this.我草你怎么反编译我模组aaaabu;
    }

    @NotNull
    public final aaaaas 你为什么要破解我的代码aaaadw(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaas.aaaadB((char)-1763246080)));
        return new aaaaas(string, n);
    }

    public static /* synthetic */ aaaaas 你为什么要破解我的代码aaaadx(aaaaas aaaaas2, String string, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = aaaaas2.我草你怎么反编译我模组aaaaao;
        }
        if ((n2 & 2) != 0) {
            n = aaaaas2.我草你怎么反编译我模组aaaabu;
        }
        return aaaaas2.你为什么要破解我的代码aaaadw(string, n);
    }

    @NotNull
    public String toString() {
        return "LiveLikeEventPayload(username=" + this.我草你怎么反编译我模组aaaaao + ", likeCount=" + this.我草你怎么反编译我模组aaaabu + ")";
    }

    public int hashCode() {
        int n = this.我草你怎么反编译我模组aaaaao.hashCode();
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaabu);
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaas)) {
            return false;
        }
        aaaaas aaaaas2 = (aaaaas)object;
        if (!Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaaao, (Object)aaaaas2.我草你怎么反编译我模组aaaaao)) {
            return false;
        }
        return this.我草你怎么反编译我模组aaaabu == aaaaas2.我草你怎么反编译我模组aaaabu;
    }

    private static final void 你为什么要破解我的代码aaaady(aaaaas aaaaas2, ServerPlayNetworking.Context context) {
        String string = aaaaas2.你为什么要破解我的代码aaaaaG();
        int n = aaaaas2.你为什么要破解我的代码aaaaai();
        aaaaab.你为什么要破解我的代码aaaaaa().info(string + " liked the stream " + n + " times");
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().post((Object)new LiveLikeEvent(string, n));
    }

    private static final void 你为什么要破解我的代码aaaadz(aaaaas aaaaas2, class_2540 class_25402) {
        class_25402.method_10814(aaaaas2.我草你怎么反编译我模组aaaaao);
        class_25402.method_53002(aaaaas2.我草你怎么反编译我模组aaaabu);
    }

    private static final aaaaas 你为什么要破解我的代码aaaadA(class_2540 class_25402) {
        String string = class_25402.method_19772();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaas.aaaadB((char)907870209)));
        return new aaaaas(string, class_25402.readInt());
    }

    static {
        byte[] byArray = "Ó,hr¯^xanÕB³ /²bÅàëyî ØºþèßÍ\fTZã=fUÜØð-È80MK ½ÿY{ª¤ÇfºÁ¦÷¤oïë)\fµJ­\\|?Y".getBytes("ISO_8859_1");
        Object[] objectArray = "lü\n¢".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1488942343;
                case 1 -> 494483151;
                case 2 -> 1893621017;
                case 3 -> 1826071092;
                case 4 -> -1945026954;
                case 5 -> -550504357;
                case 6 -> -779159426;
                case 7 -> 343611303;
                case 8 -> -1294799812;
                case 9 -> 21160695;
                case 10 -> 1551612659;
                case 11 -> 69318672;
                case 12 -> -466890905;
                case 13 -> -2077602175;
                case 14 -> -467767951;
                case 15 -> -469121775;
                case 16 -> 1720600091;
                case 17 -> -659635237;
                case 18 -> -1990033856;
                case 19 -> -1685500147;
                case 20 -> -1590541108;
                case 21 -> 1900785507;
                case 22 -> 430907034;
                case 23 -> 1491591716;
                case 24 -> 2031783072;
                case 25 -> -1292330220;
                case 26 -> 196489214;
                case 27 -> -206054572;
                case 28 -> 1421301689;
                case 29 -> -126981245;
                case 30 -> -1855823255;
                case 31 -> 1946413119;
                case 32 -> 1495367225;
                case 33 -> 1918978002;
                case 34 -> 1442914729;
                case 35 -> 14323456;
                case 36 -> 2048218693;
                case 37 -> 293548599;
                case 38 -> -1033160848;
                case 39 -> 923454917;
                case 40 -> -897265606;
                case 41 -> -1886487358;
                case 42 -> -1078375838;
                case 43 -> -1165875510;
                case 44 -> 51159750;
                case 45 -> -888766909;
                case 46 -> 171940514;
                case 47 -> 451785062;
                case 48 -> 1443918195;
                case 49 -> 1597005503;
                case 50 -> -60907613;
                case 51 -> 340065054;
                case 52 -> -1828828200;
                case 53 -> 159697761;
                case 54 -> -244552092;
                case 55 -> 385800046;
                case 56 -> -75894543;
                case 57 -> -1898520771;
                case 58 -> -959117550;
                case 59 -> 1998416305;
                case 60 -> 2050273427;
                case 61 -> 1865131265;
                case 62 -> -1026689784;
                case 63 -> -700449664;
                case 64 -> -1673600758;
                case 65 -> -2128547221;
                case 66 -> 383507094;
                case 67 -> 1488881996;
                case 68 -> 2129408677;
                case 69 -> 750616967;
                case 70 -> 120511202;
                case 71 -> 297528661;
                case 72 -> 372530566;
                case 73 -> 1286573845;
                case 74 -> 1355084952;
                case 75 -> 995701905;
                case 76 -> -972161700;
                case 77 -> 194930248;
                case 78 -> -175126320;
                case 79 -> 1208319599;
                case 80 -> 1289326561;
                case 81 -> 1686537528;
                case 82 -> 30233063;
                case 83 -> 1972067780;
                case 84 -> -1177626073;
                case 85 -> 945777295;
                case 86 -> -291925473;
                case 87 -> 859160479;
                case 88 -> 1891586031;
                case 89 -> 1539644285;
                case 90 -> -440843767;
                case 91 -> -1619807814;
                case 92 -> -1599859915;
                case 93 -> 877591753;
                case 94 -> -1476661251;
                case 95 -> 1879282915;
                case 96 -> -1399402506;
                case 97 -> -908032280;
                case 98 -> 613821412;
                case 99 -> 1730385844;
                case 100 -> -1287623955;
                case 101 -> -606602132;
                case 102 -> -1027949526;
                case 103 -> -1043428000;
                case 104 -> -4630702;
                case 105 -> 264906683;
                case 106 -> -238824088;
                case 107 -> -605458922;
                case 108 -> -460646227;
                case 109 -> -1631999170;
                case 110 -> 632020014;
                case 111 -> 1085740895;
                case 112 -> 1983583159;
                case 113 -> -1582587850;
                case 114 -> -140030982;
                case 115 -> -181590333;
                case 116 -> 985852449;
                case 117 -> -563978529;
                case 118 -> -1683514675;
                case 119 -> -2011301629;
                case 120 -> 517664474;
                case 121 -> -2078099474;
                case 122 -> 1168724311;
                case 123 -> 920202034;
                case 124 -> -1925227174;
                case 125 -> -436793360;
                case 126 -> -483547345;
                case 127 -> -1390074231;
                case 128 -> 392265477;
                case 129 -> -551090346;
                case 130 -> -933077603;
                case 131 -> -628517411;
                case 132 -> -1233004135;
                case 133 -> 382841680;
                case 134 -> -1820287076;
                case 135 -> 1577834416;
                case 136 -> -935262646;
                case 137 -> -469531499;
                case 138 -> -1374278352;
                case 139 -> -772033577;
                case 140 -> -829886452;
                case 141 -> -1283430050;
                case 142 -> -109436795;
                case 143 -> 209713991;
                case 144 -> -259491969;
                case 145 -> -955397027;
                case 146 -> 2078336938;
                case 147 -> 1282923895;
                case 148 -> -845694727;
                case 149 -> 714043366;
                case 150 -> 1419344012;
                case 151 -> 1849621036;
                case 152 -> 1937479922;
                case 153 -> 956648220;
                case 154 -> 37209368;
                case 155 -> 640655740;
                case 156 -> 199437483;
                case 157 -> -509086844;
                case 158 -> -1425089942;
                case 159 -> -257967539;
                case 160 -> -245224034;
                case 161 -> -1622922272;
                case 162 -> -778085774;
                case 163 -> -842386600;
                case 164 -> 1859624727;
                case 165 -> 1221437017;
                case 166 -> -1044044269;
                case 167 -> -186644478;
                case 168 -> 358626848;
                case 169 -> 1160518470;
                case 170 -> 1253663561;
                case 171 -> -1181140744;
                case 172 -> -1192737333;
                case 173 -> 1824861947;
                case 174 -> -1548991849;
                case 175 -> -867221937;
                case 176 -> 711538533;
                case 177 -> -461841630;
                case 178 -> -418635134;
                case 179 -> 2066733582;
                case 180 -> 1562035749;
                case 181 -> 1458395854;
                case 182 -> -1983511699;
                case 183 -> 1957710068;
                case 184 -> -106915446;
                case 185 -> 761439899;
                case 186 -> -500869433;
                case 187 -> -581553959;
                case 188 -> 1807802490;
                case 189 -> 1209348363;
                case 190 -> -474503278;
                case 191 -> 107801992;
                case 192 -> 750327713;
                case 193 -> 1790598798;
                case 194 -> -50678618;
                case 195 -> 1033040699;
                case 196 -> -1441653019;
                case 197 -> 1125698753;
                case 198 -> -1226712141;
                case 199 -> -1619758557;
                case 200 -> 1864709806;
                case 201 -> -110521386;
                case 202 -> -1347813654;
                case 203 -> 2143651448;
                case 204 -> -1432904556;
                case 205 -> 1800338470;
                case 206 -> -2008985037;
                case 207 -> 1457489489;
                case 208 -> 1361761396;
                case 209 -> 234902133;
                case 210 -> -1074094065;
                case 211 -> -1886762007;
                case 212 -> -929310282;
                case 213 -> 1913769427;
                case 214 -> -1952844360;
                case 215 -> 1857257707;
                case 216 -> -2144615093;
                case 217 -> 775605237;
                case 218 -> -582819932;
                case 219 -> 1617120262;
                case 220 -> 1024500413;
                case 221 -> -1377057105;
                case 222 -> -525430356;
                case 223 -> -1973489486;
                case 224 -> 1068859628;
                case 225 -> -676806789;
                case 226 -> -1802330556;
                case 227 -> -1025561023;
                case 228 -> 530382675;
                case 229 -> 2100563341;
                case 230 -> 1032268072;
                case 231 -> 701070365;
                case 232 -> 791272104;
                case 233 -> 132172254;
                case 234 -> -1438274259;
                case 235 -> 842561833;
                case 236 -> 180698065;
                case 237 -> 1159941312;
                case 238 -> -2096641793;
                case 239 -> 168890044;
                case 240 -> 1343410809;
                case 241 -> -1108776405;
                case 242 -> -1470126704;
                case 243 -> -215534884;
                case 244 -> 1180629826;
                case 245 -> -1247056696;
                case 246 -> 1599728718;
                case 247 -> 1447973588;
                case 248 -> -244092879;
                case 249 -> 398585596;
                case 250 -> 995319765;
                case 251 -> 2044639748;
                case 252 -> -809280587;
                case 253 -> -107208166;
                case 254 -> 1340768446;
                case 255 -> -1006990965;
                default -> -1666732117;
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
            aaaabv = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabt = new aaaaam(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaas.aaaadB((char)1007616002)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaas.aaaadB((char)224395267)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaas::你为什么要破解我的代码aaaadz, aaaaas::你为什么要破解我的代码aaaadA);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaas.aaaadB((char)-2075852796)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaadB(char c) {
        return ((Object[])aaaabv)[c];
    }
}

