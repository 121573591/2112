/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking$Context
 *  net.minecraft.class_2540
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabD;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaan;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaq;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_2540;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nMonsterBattleControlPayload.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MonsterBattleControlPayload.kt\ncn/pixellive/mc/game/client/network/MonsterBattleControlPayload\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,67:1\n215#2,2:68\n*S KotlinDebug\n*F\n+ 1 MonsterBattleControlPayload.kt\ncn/pixellive/mc/game/client/network/MonsterBattleControlPayload\n*L\n31#1:68,2\n*E\n"})
public final class aaaaay
implements class_8710 {
    @NotNull
    public static final aaaaan 我草你怎么反编译我模组aaaabg;
    @NotNull
    private final aaaaaB 我草你怎么反编译我模组aaaabh;
    @NotNull
    private final Map<String, String> 我草你怎么反编译我模组aaaaaL;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaay> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaay> 我草你怎么反编译我模组aaaaai;
    static Object aaaabi;

    public aaaaay(@NotNull aaaaaB aaaaaB2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaaaB2), (String)((String)aaaaay.aaaacY((char)-307101696)));
        Intrinsics.checkNotNullParameter(map, (String)((String)aaaaay.aaaacY((char)1694498817)));
        this.我草你怎么反编译我模组aaaabh = aaaaaB2;
        this.我草你怎么反编译我模组aaaaaL = map;
    }

    public /* synthetic */ aaaaay(aaaaaB aaaaaB2, Map map, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        this(aaaaaB2, (Map<String, String>)map);
    }

    @NotNull
    public final aaaaaB 你为什么要破解我的代码aaaacQ() {
        return this.我草你怎么反编译我模组aaaabh;
    }

    @NotNull
    public final Map<String, String> 你为什么要破解我的代码aaaabL() {
        return this.我草你怎么反编译我模组aaaaaL;
    }

    @NotNull
    public class_8710.class_9154<aaaaay> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaay::你为什么要破解我的代码aaaacV);
    }

    @NotNull
    public final aaaaaB 你为什么要破解我的代码aaaacR() {
        return this.我草你怎么反编译我模组aaaabh;
    }

    @NotNull
    public final Map<String, String> 你为什么要破解我的代码aaaabN() {
        return this.我草你怎么反编译我模组aaaaaL;
    }

    @NotNull
    public final aaaaay 你为什么要破解我的代码aaaacS(@NotNull aaaaaB aaaaaB2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaaaB2), (String)((String)aaaaay.aaaacY((char)-287309824)));
        Intrinsics.checkNotNullParameter(map, (String)((String)aaaaay.aaaacY((char)-2033188863)));
        return new aaaaay(aaaaaB2, map);
    }

    public static /* synthetic */ aaaaay 你为什么要破解我的代码aaaacT(aaaaay aaaaay2, aaaaaB aaaaaB2, Map map, int n, Object object) {
        if ((n & 1) != 0) {
            aaaaaB2 = aaaaay2.我草你怎么反编译我模组aaaabh;
        }
        if ((n & 2) != 0) {
            map = aaaaay2.我草你怎么反编译我模组aaaaaL;
        }
        return aaaaay2.你为什么要破解我的代码aaaacS(aaaaaB2, map);
    }

    @NotNull
    public String toString() {
        return "MonsterBattleControlPayload(controlType=" + this.我草你怎么反编译我模组aaaabh + ", data=" + this.我草你怎么反编译我模组aaaaaL + ")";
    }

    public int hashCode() {
        int n = this.我草你怎么反编译我模组aaaabh.hashCode();
        n = n * 31 + this.我草你怎么反编译我模组aaaaaL.hashCode();
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaay)) {
            return false;
        }
        aaaaay aaaaay2 = (aaaaay)object;
        if (this.我草你怎么反编译我模组aaaabh != aaaaay2.我草你怎么反编译我模组aaaabh) {
            return false;
        }
        return Intrinsics.areEqual(this.我草你怎么反编译我模组aaaaaL, aaaaay2.我草你怎么反编译我模组aaaaaL);
    }

    private static final void 你为什么要破解我的代码aaaacU(aaaaay aaaaay2) {
        if (aaaaaq.我草你怎么反编译我模组aaaaaa[aaaaay2.我草你怎么反编译我模组aaaabh.ordinal()] == 1) {
            aaaabD.我草你怎么反编译我模组aaaacN.你为什么要破解我的代码aaaaik();
        }
    }

    private static final void 你为什么要破解我的代码aaaacV(aaaaay aaaaay2, ServerPlayNetworking.Context context) {
        MinecraftServer minecraftServer = context.player().field_13995;
        minecraftServer.execute(() -> aaaaay.你为什么要破解我的代码aaaacU(aaaaay2));
    }

    private static final void 你为什么要破解我的代码aaaacW(aaaaay aaaaay2, class_2540 class_25402) {
        class_25402.method_10817((Enum)aaaaay2.我草你怎么反编译我模组aaaabh);
        class_25402.method_53002(aaaaay2.我草你怎么反编译我模组aaaaaL.size());
        Map<String, String> map = aaaaay2.我草你怎么反编译我模组aaaaaL;
        boolean bl = false;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry;
            Map.Entry entry2 = entry = (Map.Entry)iterator.next();
            boolean bl2 = false;
            String string = (String)entry2.getKey();
            String string2 = (String)entry2.getValue();
            class_25402.method_10814(string);
            class_25402.method_10814(string2);
        }
    }

    private static final aaaaay 你为什么要破解我的代码aaaacX(class_2540 class_25402) {
        aaaaaB aaaaaB2 = (aaaaaB)class_25402.method_10818(aaaaaB.class);
        int n = class_25402.readInt();
        Map map = (Map)new LinkedHashMap();
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2++;
            boolean bl = false;
            String string = class_25402.method_19772();
            String string2 = class_25402.method_19772();
            Intrinsics.checkNotNull((Object)string);
            Intrinsics.checkNotNull((Object)string2);
            map.put((Object)string, (Object)string2);
        }
        Intrinsics.checkNotNull((Object)((Object)aaaaaB2));
        return new aaaaay(aaaaaB2, (Map<String, String>)map);
    }

    static {
        byte[] byArray = "Å¿5VÝÛ+,>Í¾*sÃdÒ6Ôa>±!JZD®Ä|E4ãäá ÆîlçÉ©V\\]m2ëýÐ¥tÉ´Ê¶q¸LõbXLí,XçÃz".getBytes("ISO_8859_1");
        Object[] objectArray = "å¯û\rl'7".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 589767780;
                case 1 -> 323725827;
                case 2 -> -1379928179;
                case 3 -> 2047046791;
                case 4 -> 1003925023;
                case 5 -> 355299534;
                case 6 -> 1392841952;
                case 7 -> -612624045;
                case 8 -> -1216121087;
                case 9 -> 1286373631;
                case 10 -> -1410100640;
                case 11 -> 675763124;
                case 12 -> -396482837;
                case 13 -> -437255343;
                case 14 -> 966446199;
                case 15 -> -610634781;
                case 16 -> 1922971690;
                case 17 -> 1513266553;
                case 18 -> -1254894907;
                case 19 -> 229893839;
                case 20 -> 92839437;
                case 21 -> 847369360;
                case 22 -> 263574556;
                case 23 -> 1775393156;
                case 24 -> 821513221;
                case 25 -> 1493817390;
                case 26 -> 1130123191;
                case 27 -> 1335957355;
                case 28 -> -1600131077;
                case 29 -> -913792527;
                case 30 -> -263135093;
                case 31 -> 1026533234;
                case 32 -> 1702384795;
                case 33 -> -339829578;
                case 34 -> 73720112;
                case 35 -> 290983503;
                case 36 -> 1048265352;
                case 37 -> -43886580;
                case 38 -> 2112172719;
                case 39 -> -2133310595;
                case 40 -> 1559811106;
                case 41 -> -1082139171;
                case 42 -> 1700060176;
                case 43 -> -1617386754;
                case 44 -> -1983282811;
                case 45 -> 612612596;
                case 46 -> -142516055;
                case 47 -> 484605863;
                case 48 -> -127175616;
                case 49 -> 1002232215;
                case 50 -> 1663953082;
                case 51 -> -1847123585;
                case 52 -> 1602608280;
                case 53 -> -1138770638;
                case 54 -> -1849642558;
                case 55 -> 1730724957;
                case 56 -> 63327001;
                case 57 -> -1110923001;
                case 58 -> -214934416;
                case 59 -> -1805883236;
                case 60 -> 1858625557;
                case 61 -> -1084108748;
                case 62 -> -651885833;
                case 63 -> 544510815;
                case 64 -> 1073233132;
                case 65 -> -1922193480;
                case 66 -> 1578840545;
                case 67 -> 1777485862;
                case 68 -> 1432655964;
                case 69 -> 80010657;
                case 70 -> 1368735347;
                case 71 -> 328913981;
                case 72 -> -293772561;
                case 73 -> -1432707238;
                case 74 -> -62291608;
                case 75 -> -58311251;
                case 76 -> 520635843;
                case 77 -> 1515268118;
                case 78 -> 2097310362;
                case 79 -> 90402616;
                case 80 -> 761563805;
                case 81 -> -1349267673;
                case 82 -> -623929355;
                case 83 -> -49515758;
                case 84 -> 1355554709;
                case 85 -> -1463092647;
                case 86 -> -243975454;
                case 87 -> -447331466;
                case 88 -> -1160264206;
                case 89 -> 1179762375;
                case 90 -> -201747895;
                case 91 -> -1414717611;
                case 92 -> 929607075;
                case 93 -> -1659103530;
                case 94 -> 755383070;
                case 95 -> 1489460804;
                case 96 -> -948305551;
                case 97 -> 452451498;
                case 98 -> -808610450;
                case 99 -> -590994033;
                case 100 -> 42018366;
                case 101 -> 914492619;
                case 102 -> 1686277580;
                case 103 -> -893612641;
                case 104 -> 1462482419;
                case 105 -> -930286639;
                case 106 -> -1821146021;
                case 107 -> 889916519;
                case 108 -> 1404463531;
                case 109 -> 525028275;
                case 110 -> -1614862384;
                case 111 -> 612777062;
                case 112 -> 1342742204;
                case 113 -> -127964054;
                case 114 -> -1062970407;
                case 115 -> -465745758;
                case 116 -> 1282670389;
                case 117 -> -450031059;
                case 118 -> 350008450;
                case 119 -> 874881809;
                case 120 -> -1078947844;
                case 121 -> -809540942;
                case 122 -> 679675614;
                case 123 -> -617165081;
                case 124 -> -777441171;
                case 125 -> -42194887;
                case 126 -> -637666550;
                case 127 -> -1898297540;
                case 128 -> 254625770;
                case 129 -> -755465896;
                case 130 -> -545203625;
                case 131 -> -1757349042;
                case 132 -> -1327486933;
                case 133 -> 13788654;
                case 134 -> -1288514232;
                case 135 -> 1869661143;
                case 136 -> -704158736;
                case 137 -> -1749697082;
                case 138 -> 1378848582;
                case 139 -> 569494462;
                case 140 -> -1905972695;
                case 141 -> -1326772682;
                case 142 -> -124144120;
                case 143 -> -1456673271;
                case 144 -> -1118021626;
                case 145 -> -63385227;
                case 146 -> -182266592;
                case 147 -> -771137134;
                case 148 -> 141547918;
                case 149 -> 717226425;
                case 150 -> 1324992905;
                case 151 -> 1231635110;
                case 152 -> 1812431076;
                case 153 -> 470782219;
                case 154 -> 1816359562;
                case 155 -> -1358309036;
                case 156 -> 1199605347;
                case 157 -> 506572219;
                case 158 -> 861377309;
                case 159 -> -347758265;
                case 160 -> -986695889;
                case 161 -> -432991553;
                case 162 -> 1882584056;
                case 163 -> 377713715;
                case 164 -> 1214487293;
                case 165 -> 63167809;
                case 166 -> 675689162;
                case 167 -> 301948837;
                case 168 -> -623966344;
                case 169 -> 195859835;
                case 170 -> 716631512;
                case 171 -> 1733233049;
                case 172 -> -2004023598;
                case 173 -> 272192672;
                case 174 -> -1443422850;
                case 175 -> 399287117;
                case 176 -> -704912447;
                case 177 -> -111914779;
                case 178 -> 1024379759;
                case 179 -> 70308524;
                case 180 -> 1639828562;
                case 181 -> 353908198;
                case 182 -> -330660329;
                case 183 -> 1616188365;
                case 184 -> -1088981246;
                case 185 -> -1307706150;
                case 186 -> 637482306;
                case 187 -> -191005802;
                case 188 -> 1311084898;
                case 189 -> -1805565580;
                case 190 -> -865977600;
                case 191 -> -2027825628;
                case 192 -> -2145287881;
                case 193 -> -1431094459;
                case 194 -> 1187772563;
                case 195 -> -946106706;
                case 196 -> -2106441783;
                case 197 -> 218357238;
                case 198 -> 1299784542;
                case 199 -> 866049984;
                case 200 -> -1278328655;
                case 201 -> 1001113052;
                case 202 -> 1497468356;
                case 203 -> 570108474;
                case 204 -> -947928806;
                case 205 -> -321326635;
                case 206 -> 1862354000;
                case 207 -> 361205116;
                case 208 -> -735252405;
                case 209 -> -676629629;
                case 210 -> -1025825204;
                case 211 -> -1906441343;
                case 212 -> 1100594715;
                case 213 -> -1540452338;
                case 214 -> 675962293;
                case 215 -> 1306041740;
                case 216 -> 603018106;
                case 217 -> -96597652;
                case 218 -> -748007124;
                case 219 -> -1161183032;
                case 220 -> -545163997;
                case 221 -> 237925288;
                case 222 -> -600633978;
                case 223 -> 832659604;
                case 224 -> 1035097449;
                case 225 -> -1408573948;
                case 226 -> -1478351857;
                case 227 -> 1287560534;
                case 228 -> 2141822817;
                case 229 -> -1062649368;
                case 230 -> -1515811408;
                case 231 -> -447851821;
                case 232 -> -1934642707;
                case 233 -> -1912976061;
                case 234 -> 472384805;
                case 235 -> -636721953;
                case 236 -> 1985634579;
                case 237 -> -586108453;
                case 238 -> 1944647743;
                case 239 -> -934874328;
                case 240 -> 317763889;
                case 241 -> -1750665772;
                case 242 -> -250875103;
                case 243 -> 1642049956;
                case 244 -> 61822441;
                case 245 -> -1414894946;
                case 246 -> 200549370;
                case 247 -> 167312061;
                case 248 -> -926025071;
                case 249 -> 415551764;
                case 250 -> 231369573;
                case 251 -> -691959222;
                case 252 -> 1956748537;
                case 253 -> -1589262533;
                case 254 -> -1436088552;
                case 255 -> 178966656;
                default -> -1841796471;
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
            aaaabi = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabg = new aaaaan(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaay.aaaacY((char)0x620002)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaay.aaaacY((char)-1714094077)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaay::你为什么要破解我的代码aaaacW, aaaaay::你为什么要破解我的代码aaaacX);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaay.aaaacY((char)-455540732)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaacY(char c) {
        return ((Object[])aaaabi)[c];
    }
}

