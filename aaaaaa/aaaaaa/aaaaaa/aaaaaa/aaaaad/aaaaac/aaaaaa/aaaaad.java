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

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaaj;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveChatEvent;
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

public final class aaaaad
implements class_8710 {
    @NotNull
    public static final aaaaaj 我草你怎么反编译我模组aaaaar;
    @NotNull
    private final String 我草你怎么反编译我模组aaaaao;
    @NotNull
    private final String 我草你怎么反编译我模组aaaaas;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaad> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaad> 我草你怎么反编译我模组aaaaai;
    static Object aaaaat;

    public aaaaad(@NotNull String string, @NotNull String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaad.aaaaba((char)-473235456)));
        Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaaad.aaaaba((char)384630785)));
        this.我草你怎么反编译我模组aaaaao = string;
        this.我草你怎么反编译我模组aaaaas = string2;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaF() {
        return this.我草你怎么反编译我模组aaaaao;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaT() {
        return this.我草你怎么反编译我模组aaaaas;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaad::你为什么要破解我的代码aaaaaX);
    }

    @NotNull
    public class_8710.class_9154<aaaaad> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaG() {
        return this.我草你怎么反编译我模组aaaaao;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaU() {
        return this.我草你怎么反编译我模组aaaaas;
    }

    @NotNull
    public final aaaaad 你为什么要破解我的代码aaaaaV(@NotNull String string, @NotNull String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaad.aaaaba((char)-1375862784)));
        Intrinsics.checkNotNullParameter((Object)string2, (String)((String)aaaaad.aaaaba((char)914161665)));
        return new aaaaad(string, string2);
    }

    public static /* synthetic */ aaaaad 你为什么要破解我的代码aaaaaW(aaaaad aaaaad2, String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string = aaaaad2.我草你怎么反编译我模组aaaaao;
        }
        if ((n & 2) != 0) {
            string2 = aaaaad2.我草你怎么反编译我模组aaaaas;
        }
        return aaaaad2.你为什么要破解我的代码aaaaaV(string, string2);
    }

    @NotNull
    public String toString() {
        return "LiveChatEventPayload(username=" + this.我草你怎么反编译我模组aaaaao + ", comment=" + this.我草你怎么反编译我模组aaaaas + ")";
    }

    public int hashCode() {
        int n = this.我草你怎么反编译我模组aaaaao.hashCode();
        n = n * 31 + this.我草你怎么反编译我模组aaaaas.hashCode();
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaad)) {
            return false;
        }
        aaaaad aaaaad2 = (aaaaad)object;
        if (!Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaaao, (Object)aaaaad2.我草你怎么反编译我模组aaaaao)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaaas, (Object)aaaaad2.我草你怎么反编译我模组aaaaas);
    }

    private static final void 你为什么要破解我的代码aaaaaX(aaaaad aaaaad2, ServerPlayNetworking.Context context) {
        String string = aaaaad2.你为什么要破解我的代码aaaaaG();
        String string2 = aaaaad2.你为什么要破解我的代码aaaaaU();
        aaaaab.你为什么要破解我的代码aaaaaa().info(string + " commented: " + string2);
        PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa().post((Object)new LiveChatEvent(string, string2));
    }

    private static final void 你为什么要破解我的代码aaaaaY(aaaaad aaaaad2, class_2540 class_25402) {
        class_25402.method_10814(aaaaad2.我草你怎么反编译我模组aaaaao);
        class_25402.method_10814(aaaaad2.我草你怎么反编译我模组aaaaas);
    }

    private static final aaaaad 你为什么要破解我的代码aaaaaZ(class_2540 class_25402) {
        String string = class_25402.method_19772();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaad.aaaaba((char)-763494398)));
        String string2 = class_25402.method_19772();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)((String)aaaaad.aaaaba((char)-110559230)));
        return new aaaaad(string, string2);
    }

    static {
        byte[] byArray = "Ân#KÍÛBF¸×ñ)\"oX_ÿÞr.Æjµ¬¼øØ­Äl~Ñ¦|Ed£äwépöþóéÎB{ï¤\nkØ0n%Ç|¥Ò\ròè¼9®!¦ (".getBytes("ISO_8859_1");
        Object[] objectArray = "!ç¼\fS,".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -674072452;
                case 1 -> -1205228849;
                case 2 -> 2023704618;
                case 3 -> -1347850912;
                case 4 -> -450364822;
                case 5 -> 333037982;
                case 6 -> 69172643;
                case 7 -> 800701795;
                case 8 -> -543013104;
                case 9 -> 969261093;
                case 10 -> 170199675;
                case 11 -> 2098375491;
                case 12 -> -1866308950;
                case 13 -> 1478918180;
                case 14 -> 1132558871;
                case 15 -> -1084531233;
                case 16 -> 1522302303;
                case 17 -> 757540053;
                case 18 -> -1622856722;
                case 19 -> -583167206;
                case 20 -> 495457406;
                case 21 -> 473425500;
                case 22 -> 789081987;
                case 23 -> -1197853665;
                case 24 -> -544515303;
                case 25 -> -890749378;
                case 26 -> 1458296259;
                case 27 -> -483358988;
                case 28 -> 474057431;
                case 29 -> -151882367;
                case 30 -> 1447780184;
                case 31 -> -828662025;
                case 32 -> -1457463891;
                case 33 -> 423552592;
                case 34 -> -442005790;
                case 35 -> 1386217474;
                case 36 -> 536764686;
                case 37 -> -381325895;
                case 38 -> -150843795;
                case 39 -> -164170;
                case 40 -> 729472564;
                case 41 -> -979907619;
                case 42 -> 2132662224;
                case 43 -> -1567108384;
                case 44 -> -18518771;
                case 45 -> 1103626137;
                case 46 -> 585968053;
                case 47 -> -972390473;
                case 48 -> -1800038161;
                case 49 -> -1148591112;
                case 50 -> 1012865428;
                case 51 -> 434302505;
                case 52 -> -24636918;
                case 53 -> -2128641186;
                case 54 -> -1615423935;
                case 55 -> 1896211615;
                case 56 -> 1822842508;
                case 57 -> 638843013;
                case 58 -> 237157918;
                case 59 -> 1752414153;
                case 60 -> 2060645692;
                case 61 -> -1992241997;
                case 62 -> 914127444;
                case 63 -> -957290706;
                case 64 -> 2040053426;
                case 65 -> 1951805972;
                case 66 -> 1630966276;
                case 67 -> -2024868501;
                case 68 -> -1611269575;
                case 69 -> -773947733;
                case 70 -> 1944610313;
                case 71 -> -2073317726;
                case 72 -> 1848106949;
                case 73 -> 792315056;
                case 74 -> 1521142648;
                case 75 -> -1766112538;
                case 76 -> -1059220803;
                case 77 -> -1802076665;
                case 78 -> 1291960553;
                case 79 -> -241973390;
                case 80 -> -1452393222;
                case 81 -> -373777278;
                case 82 -> -125509689;
                case 83 -> -390652975;
                case 84 -> -1390978030;
                case 85 -> -474977217;
                case 86 -> -1205612639;
                case 87 -> 1459764172;
                case 88 -> -2147112606;
                case 89 -> 1505176079;
                case 90 -> 1929587756;
                case 91 -> 1677162066;
                case 92 -> 708579355;
                case 93 -> 1719612416;
                case 94 -> 214009460;
                case 95 -> -1052038236;
                case 96 -> 428976709;
                case 97 -> -1281215926;
                case 98 -> -239371512;
                case 99 -> -235870670;
                case 100 -> 1580777408;
                case 101 -> 112698877;
                case 102 -> -404674442;
                case 103 -> 731973778;
                case 104 -> -338814175;
                case 105 -> -1220365719;
                case 106 -> 119423815;
                case 107 -> -1196597798;
                case 108 -> -1995349273;
                case 109 -> 843980855;
                case 110 -> 1719254757;
                case 111 -> -595768892;
                case 112 -> 1096556956;
                case 113 -> 2021250812;
                case 114 -> 1814611268;
                case 115 -> 2003855674;
                case 116 -> -436815662;
                case 117 -> 1974294253;
                case 118 -> -1038330059;
                case 119 -> 2037433992;
                case 120 -> 130512889;
                case 121 -> -757662086;
                case 122 -> 625997894;
                case 123 -> 2070681220;
                case 124 -> -322341276;
                case 125 -> 441979483;
                case 126 -> -1080878549;
                case 127 -> 427659560;
                case 128 -> 1434321712;
                case 129 -> -1556492191;
                case 130 -> -1863432487;
                case 131 -> 1208505395;
                case 132 -> 1986314598;
                case 133 -> 642258507;
                case 134 -> -362796402;
                case 135 -> 1738304190;
                case 136 -> -1246513073;
                case 137 -> 1458724424;
                case 138 -> -557969751;
                case 139 -> 1014950654;
                case 140 -> 2001338844;
                case 141 -> -1868821609;
                case 142 -> 1262900758;
                case 143 -> -1185956124;
                case 144 -> 1298977318;
                case 145 -> 470899491;
                case 146 -> 388696497;
                case 147 -> 919471719;
                case 148 -> 495452581;
                case 149 -> -1067026445;
                case 150 -> 591765068;
                case 151 -> -681166680;
                case 152 -> 1512594108;
                case 153 -> 47865712;
                case 154 -> 679767233;
                case 155 -> 1917014862;
                case 156 -> 536302907;
                case 157 -> 1924124032;
                case 158 -> 934643349;
                case 159 -> 424600349;
                case 160 -> 1608842630;
                case 161 -> -1400227350;
                case 162 -> 1733945619;
                case 163 -> -1507745898;
                case 164 -> -165272829;
                case 165 -> -184709642;
                case 166 -> 1734817367;
                case 167 -> 1570822183;
                case 168 -> -1720045185;
                case 169 -> -1209837394;
                case 170 -> -1903332652;
                case 171 -> -1222437477;
                case 172 -> -2121454938;
                case 173 -> 972057398;
                case 174 -> -1812369669;
                case 175 -> 1555595337;
                case 176 -> -478171178;
                case 177 -> -130925077;
                case 178 -> -1830560402;
                case 179 -> 618268773;
                case 180 -> 1776821214;
                case 181 -> -1379169364;
                case 182 -> 1707624449;
                case 183 -> -863214356;
                case 184 -> 1732064546;
                case 185 -> -1480851857;
                case 186 -> -1927395390;
                case 187 -> -1171109620;
                case 188 -> 264990997;
                case 189 -> -654912506;
                case 190 -> 337824456;
                case 191 -> -820277677;
                case 192 -> -1067671056;
                case 193 -> 852025255;
                case 194 -> -1796845557;
                case 195 -> -292221199;
                case 196 -> -2117001611;
                case 197 -> -825341953;
                case 198 -> 649087924;
                case 199 -> 790067564;
                case 200 -> 894981322;
                case 201 -> -323161795;
                case 202 -> -1508431731;
                case 203 -> -747540960;
                case 204 -> 1375151900;
                case 205 -> 525364712;
                case 206 -> 405775256;
                case 207 -> 11243725;
                case 208 -> -538973321;
                case 209 -> -51327910;
                case 210 -> -1859295261;
                case 211 -> 1613457583;
                case 212 -> -2113330819;
                case 213 -> -2105683046;
                case 214 -> -570807105;
                case 215 -> 1451508873;
                case 216 -> 1336754752;
                case 217 -> 356274055;
                case 218 -> -2031633560;
                case 219 -> 1823701664;
                case 220 -> -13688334;
                case 221 -> -1132751023;
                case 222 -> -1695245475;
                case 223 -> -579361398;
                case 224 -> 1199820507;
                case 225 -> 275084889;
                case 226 -> 107109336;
                case 227 -> -1320629104;
                case 228 -> 1308359985;
                case 229 -> 1238042168;
                case 230 -> 802659258;
                case 231 -> 1534170897;
                case 232 -> -1319877263;
                case 233 -> 1793409101;
                case 234 -> -734569525;
                case 235 -> -1339561800;
                case 236 -> 429186017;
                case 237 -> 992495310;
                case 238 -> -302366061;
                case 239 -> 1082495865;
                case 240 -> -876704267;
                case 241 -> -1531665834;
                case 242 -> 678281611;
                case 243 -> -2077752890;
                case 244 -> 1372328403;
                case 245 -> 1222775362;
                case 246 -> 1829263407;
                case 247 -> -1287129741;
                case 248 -> -529790203;
                case 249 -> -15496424;
                case 250 -> 1883336277;
                case 251 -> 763939727;
                case 252 -> 1699303213;
                case 253 -> -1917023331;
                case 254 -> 1733190289;
                case 255 -> -1009721925;
                default -> -2013514364;
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
            aaaaat = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaar = new aaaaaj(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaad.aaaaba((char)-2022506495)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaad.aaaaba((char)1041432579)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaad::你为什么要破解我的代码aaaaaY, aaaaad::你为什么要破解我的代码aaaaaZ);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaad.aaaaba((char)-157417468)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaaba(char c) {
        return ((Object[])aaaaat)[c];
    }
}

