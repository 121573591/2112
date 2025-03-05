/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
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
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.class_2540
 *  net.minecraft.class_3222
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabH;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaam;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2540;
import net.minecraft.class_3222;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaaaab
implements class_8710 {
    @NotNull
    public static final aaaaam 我草你怎么反编译我模组aaaaaj;
    private final int 我草你怎么反编译我模组aaaaak;
    private final boolean 我草你怎么反编译我模组aaaaal;
    private final boolean 我草你怎么反编译我模组aaaaam;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaab> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaab> 我草你怎么反编译我模组aaaaai;
    static Object aaaaan;

    public aaaaab(int n, boolean bl, boolean bl2) {
        this.我草你怎么反编译我模组aaaaak = n;
        this.我草你怎么反编译我模组aaaaal = bl;
        this.我草你怎么反编译我模组aaaaam = bl2;
    }

    public /* synthetic */ aaaaab(int n, boolean bl, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        this(n, bl, bl2);
    }

    public final int 你为什么要破解我的代码aaaaas() {
        return this.我草你怎么反编译我模组aaaaak;
    }

    public final boolean 你为什么要破解我的代码aaaaat() {
        return this.我草你怎么反编译我模组aaaaal;
    }

    public final boolean 你为什么要破解我的代码aaaaau() {
        return this.我草你怎么反编译我模组aaaaam;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, (arg_0, arg_1) -> aaaaab.你为什么要破解我的代码aaaaaC(this, arg_0, arg_1));
    }

    private final void 你为什么要破解我的代码aaaaav(int n) {
        int n2 = aaaabH.我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaaf();
        aaaabH.我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaag(n);
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info("更新每日挑战次数: " + n2 + " -> " + n);
    }

    @NotNull
    public class_8710.class_9154<aaaaab> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final int 你为什么要破解我的代码aaaaaw() {
        return this.我草你怎么反编译我模组aaaaak;
    }

    public final boolean 你为什么要破解我的代码aaaaax() {
        return this.我草你怎么反编译我模组aaaaal;
    }

    public final boolean 你为什么要破解我的代码aaaaay() {
        return this.我草你怎么反编译我模组aaaaam;
    }

    @NotNull
    public final aaaaab 你为什么要破解我的代码aaaaaz(int n, boolean bl, boolean bl2) {
        return new aaaaab(n, bl, bl2);
    }

    public static /* synthetic */ aaaaab 你为什么要破解我的代码aaaaaA(aaaaab aaaaab2, int n, boolean bl, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = aaaaab2.我草你怎么反编译我模组aaaaak;
        }
        if ((n2 & 2) != 0) {
            bl = aaaaab2.我草你怎么反编译我模组aaaaal;
        }
        if ((n2 & 4) != 0) {
            bl2 = aaaaab2.我草你怎么反编译我模组aaaaam;
        }
        return aaaaab2.你为什么要破解我的代码aaaaaz(n, bl, bl2);
    }

    @NotNull
    public String toString() {
        return "DailyParkourSettingsPayload(maxChallengeNumber=" + this.我草你怎么反编译我模组aaaaak + ", resetProgress=" + this.我草你怎么反编译我模组aaaaal + ", clearEffects=" + this.我草你怎么反编译我模组aaaaam + ")";
    }

    public int hashCode() {
        int n = Integer.hashCode((int)this.我草你怎么反编译我模组aaaaak);
        n = n * 31 + Boolean.hashCode((boolean)this.我草你怎么反编译我模组aaaaal);
        n = n * 31 + Boolean.hashCode((boolean)this.我草你怎么反编译我模组aaaaam);
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaab)) {
            return false;
        }
        aaaaab aaaaab2 = (aaaaab)object;
        if (this.我草你怎么反编译我模组aaaaak != aaaaab2.我草你怎么反编译我模组aaaaak) {
            return false;
        }
        if (this.我草你怎么反编译我模组aaaaal != aaaaab2.我草你怎么反编译我模组aaaaal) {
            return false;
        }
        return this.我草你怎么反编译我模组aaaaam == aaaaab2.我草你怎么反编译我模组aaaaam;
    }

    private static final void 你为什么要破解我的代码aaaaaB(aaaaab aaaaab2, aaaaab aaaaab3, class_3222 class_32222) {
        Intrinsics.checkNotNullParameter((Object)aaaaab3, (String)((String)aaaaab.aaaaaF((char)2056585216)));
        if (aaaaab2.我草你怎么反编译我模组aaaaak != aaaabH.我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaaf()) {
            aaaaab3.你为什么要破解我的代码aaaaav(aaaaab2.我草你怎么反编译我模组aaaaak);
        }
        if (aaaaab2.我草你怎么反编译我模组aaaaal) {
            Intrinsics.checkNotNull((Object)class_32222);
            aaaabH.我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiI(class_32222);
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info("已重置玩家 " + class_32222.method_5477().getString() + " 的进度");
        }
        if (aaaaab2.我草你怎么反编译我模组aaaaam) {
            class_32222.method_6012();
            Intrinsics.checkNotNull((Object)class_32222);
            aaaabH.我草你怎么反编译我模组aaaadh.你为什么要破解我的代码aaaaiJ(class_32222);
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info("已清除玩家 " + class_32222.method_5477().getString() + " 的效果");
        }
    }

    private static final void 你为什么要破解我的代码aaaaaC(aaaaab aaaaab2, aaaaab aaaaab3, ServerPlayNetworking.Context context) {
        Intrinsics.checkNotNullParameter((Object)aaaaab2, (String)((String)aaaaab.aaaaaF((char)1906769920)));
        class_3222 class_32222 = context.player();
        MinecraftServer minecraftServer = class_32222.field_13995;
        minecraftServer.execute(() -> aaaaab.你为什么要破解我的代码aaaaaB(aaaaab3, aaaaab2, class_32222));
    }

    private static final void 你为什么要破解我的代码aaaaaD(aaaaab aaaaab2, class_2540 class_25402) {
        class_25402.method_53002(aaaaab2.我草你怎么反编译我模组aaaaak);
        class_25402.method_52964(aaaaab2.我草你怎么反编译我模组aaaaal);
        class_25402.method_52964(aaaaab2.我草你怎么反编译我模组aaaaam);
    }

    private static final aaaaab 你为什么要破解我的代码aaaaaE(class_2540 class_25402) {
        return new aaaaab(class_25402.readInt(), class_25402.readBoolean(), class_25402.readBoolean());
    }

    static {
        byte[] byArray = "*Â¤;+mUIP³:Ð\\«u¡8,æuT);û¹|÷rd¡É\"×9õW¨¢{!_ä&¦<roLÎ]ÙMÜ¶¾T¢þÃ²¶#ÞÖ­ÀK".getBytes("ISO_8859_1");
        Object[] objectArray = "<mð¤,Î".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1942265915;
                case 1 -> -843700880;
                case 2 -> -1029237104;
                case 3 -> -1229090240;
                case 4 -> -1527753700;
                case 5 -> 394396321;
                case 6 -> 195527110;
                case 7 -> 1992433007;
                case 8 -> 1023142419;
                case 9 -> -1942901928;
                case 10 -> -111511035;
                case 11 -> 444007125;
                case 12 -> 1100123096;
                case 13 -> 2039839965;
                case 14 -> 1598130636;
                case 15 -> -611293513;
                case 16 -> -938975230;
                case 17 -> 563815927;
                case 18 -> 2053798528;
                case 19 -> -260297688;
                case 20 -> 1723400081;
                case 21 -> -314009853;
                case 22 -> -326204252;
                case 23 -> 610784865;
                case 24 -> 1872236251;
                case 25 -> 2134004895;
                case 26 -> -681196165;
                case 27 -> -2111411142;
                case 28 -> 603290180;
                case 29 -> -1671033068;
                case 30 -> -1446127703;
                case 31 -> -1740565144;
                case 32 -> 1318393902;
                case 33 -> 1791945013;
                case 34 -> 521760082;
                case 35 -> 604197343;
                case 36 -> -1025329793;
                case 37 -> 413717075;
                case 38 -> -875944426;
                case 39 -> -2097292731;
                case 40 -> 990445350;
                case 41 -> 1710017260;
                case 42 -> 1767184077;
                case 43 -> 613005319;
                case 44 -> -1270692115;
                case 45 -> -2030564124;
                case 46 -> -1482315344;
                case 47 -> -108590916;
                case 48 -> 1310947641;
                case 49 -> 2068604546;
                case 50 -> 1444539647;
                case 51 -> 371814913;
                case 52 -> -2146638908;
                case 53 -> -865582861;
                case 54 -> 569265435;
                case 55 -> 173957937;
                case 56 -> 752194662;
                case 57 -> 194582840;
                case 58 -> 1421767129;
                case 59 -> -277381696;
                case 60 -> 1225026712;
                case 61 -> -1433175709;
                case 62 -> -31218122;
                case 63 -> 2139476012;
                case 64 -> -784649678;
                case 65 -> -1916296432;
                case 66 -> -825158446;
                case 67 -> 1383649204;
                case 68 -> 766724746;
                case 69 -> 421167949;
                case 70 -> -585583722;
                case 71 -> 1356734951;
                case 72 -> -1572025466;
                case 73 -> 1545513419;
                case 74 -> 1103339630;
                case 75 -> -1437750950;
                case 76 -> 1910612303;
                case 77 -> 1382104159;
                case 78 -> 1541107382;
                case 79 -> -396396023;
                case 80 -> 479429275;
                case 81 -> 320556080;
                case 82 -> -374771129;
                case 83 -> -1262516355;
                case 84 -> -454768014;
                case 85 -> -103290551;
                case 86 -> -1878248610;
                case 87 -> 1674396227;
                case 88 -> 735679457;
                case 89 -> -1146892681;
                case 90 -> -560822714;
                case 91 -> 2071171292;
                case 92 -> 1784653290;
                case 93 -> 2053352421;
                case 94 -> 298774039;
                case 95 -> 298295116;
                case 96 -> -1693384060;
                case 97 -> -163953456;
                case 98 -> 1833783578;
                case 99 -> -1228691968;
                case 100 -> -464636498;
                case 101 -> 1001911805;
                case 102 -> -557834254;
                case 103 -> -2107864275;
                case 104 -> -1393908165;
                case 105 -> -1591649461;
                case 106 -> 60386489;
                case 107 -> 310377076;
                case 108 -> -25783858;
                case 109 -> -1783423522;
                case 110 -> -1533563615;
                case 111 -> -1518702359;
                case 112 -> 81230697;
                case 113 -> -5951989;
                case 114 -> 1058344058;
                case 115 -> -753191285;
                case 116 -> -2070339809;
                case 117 -> 2031088786;
                case 118 -> 1835239432;
                case 119 -> -1679401201;
                case 120 -> -2056368775;
                case 121 -> 1023028116;
                case 122 -> -1922084098;
                case 123 -> -402442461;
                case 124 -> -33937471;
                case 125 -> -1661044630;
                case 126 -> 981736893;
                case 127 -> 295160309;
                case 128 -> -1368412350;
                case 129 -> 1097073822;
                case 130 -> 1403608657;
                case 131 -> -1909960305;
                case 132 -> 1109306778;
                case 133 -> -1586132071;
                case 134 -> -690710978;
                case 135 -> 849073573;
                case 136 -> 1373781013;
                case 137 -> 882292954;
                case 138 -> -1049608096;
                case 139 -> 1140141463;
                case 140 -> -1680432431;
                case 141 -> -28326685;
                case 142 -> 195620508;
                case 143 -> -1914552492;
                case 144 -> 755053421;
                case 145 -> -1266441206;
                case 146 -> 1289334769;
                case 147 -> -164024743;
                case 148 -> -655465498;
                case 149 -> -947566712;
                case 150 -> 1871434300;
                case 151 -> -2087336050;
                case 152 -> 251091379;
                case 153 -> -1140545102;
                case 154 -> 1376621699;
                case 155 -> -70817028;
                case 156 -> 1445037944;
                case 157 -> 1192540090;
                case 158 -> 954619888;
                case 159 -> 786576243;
                case 160 -> -1130351531;
                case 161 -> 1897357280;
                case 162 -> 2040948516;
                case 163 -> -1412681056;
                case 164 -> -1339491633;
                case 165 -> 762129957;
                case 166 -> -637830771;
                case 167 -> 357163180;
                case 168 -> -1379299427;
                case 169 -> -1768268044;
                case 170 -> 1473402468;
                case 171 -> 421212074;
                case 172 -> 1140749154;
                case 173 -> -1586804075;
                case 174 -> -1360957928;
                case 175 -> 1206706311;
                case 176 -> 363810919;
                case 177 -> 700353540;
                case 178 -> 763314227;
                case 179 -> -1023933812;
                case 180 -> 296692424;
                case 181 -> -918860709;
                case 182 -> -1318925381;
                case 183 -> 224636477;
                case 184 -> 1705746495;
                case 185 -> -945912203;
                case 186 -> -736394483;
                case 187 -> -635730767;
                case 188 -> -430445211;
                case 189 -> 2108834761;
                case 190 -> -101616767;
                case 191 -> -1659933701;
                case 192 -> -1638571581;
                case 193 -> -743566087;
                case 194 -> -1548381993;
                case 195 -> 251104798;
                case 196 -> -349930506;
                case 197 -> -1175435101;
                case 198 -> -803906543;
                case 199 -> -285101792;
                case 200 -> 1351021099;
                case 201 -> -67917038;
                case 202 -> -1836818776;
                case 203 -> -1132770736;
                case 204 -> -663996886;
                case 205 -> 22924150;
                case 206 -> 805380271;
                case 207 -> 635302734;
                case 208 -> 621235307;
                case 209 -> -1539439079;
                case 210 -> -467493545;
                case 211 -> -1462097937;
                case 212 -> 356915746;
                case 213 -> 1716908140;
                case 214 -> -164207966;
                case 215 -> -1571394358;
                case 216 -> 516907758;
                case 217 -> -171457147;
                case 218 -> 2114373076;
                case 219 -> -2078849355;
                case 220 -> -47311194;
                case 221 -> 336591452;
                case 222 -> 1432616010;
                case 223 -> 1646698963;
                case 224 -> -1859790783;
                case 225 -> -855955998;
                case 226 -> 1577184703;
                case 227 -> -1034450039;
                case 228 -> 1586864813;
                case 229 -> 1050266141;
                case 230 -> -706214253;
                case 231 -> -424840652;
                case 232 -> -267710681;
                case 233 -> -2092448085;
                case 234 -> -1093699017;
                case 235 -> 1849439100;
                case 236 -> 108638968;
                case 237 -> 603285927;
                case 238 -> -509630280;
                case 239 -> -2121746050;
                case 240 -> 917468428;
                case 241 -> -1623426584;
                case 242 -> 771724558;
                case 243 -> 365426902;
                case 244 -> -698879651;
                case 245 -> 1504421206;
                case 246 -> -907102417;
                case 247 -> -1881900431;
                case 248 -> -1662111550;
                case 249 -> -917033794;
                case 250 -> 902199531;
                case 251 -> 43045575;
                case 252 -> 1931301894;
                case 253 -> -93995192;
                case 254 -> 1227436538;
                case 255 -> -554719191;
                default -> -1174007278;
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
            Object[] objectArray2 = new Object[4];
            objectArray = objectArray2;
            aaaaan = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaj = new aaaaam(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaab.aaaaaF((char)39256065)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaab.aaaaaF((char)-1133314046)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaab::你为什么要破解我的代码aaaaaD, aaaaab::你为什么要破解我的代码aaaaaE);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaab.aaaaaF((char)1977548803)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaaaF(char c) {
        return ((Object[])aaaaan)[c];
    }
}

