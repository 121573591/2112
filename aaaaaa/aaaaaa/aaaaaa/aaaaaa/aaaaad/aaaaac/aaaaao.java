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

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaadf;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaac;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaak;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaal;
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

@SourceDebugExtension(value={"SMAP\nMonsterArenaControlPayload.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MonsterArenaControlPayload.kt\ncn/pixellive/mc/game/client/network/MonsterArenaControlPayload\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,76:1\n215#2,2:77\n*S KotlinDebug\n*F\n+ 1 MonsterArenaControlPayload.kt\ncn/pixellive/mc/game/client/network/MonsterArenaControlPayload\n*L\n38#1:77,2\n*E\n"})
public final class aaaaao
implements class_8710 {
    @NotNull
    public static final aaaaal 我草你怎么反编译我模组aaaaaJ;
    @NotNull
    private final aaaaak 我草你怎么反编译我模组aaaaaK;
    @NotNull
    private final Map<String, String> 我草你怎么反编译我模组aaaaaL;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaao> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaao> 我草你怎么反编译我模组aaaaai;
    static Object aaaaaM;

    public aaaaao(@NotNull aaaaak aaaaak2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaaak2), (String)((String)aaaaao.aaaabU((char)1529085952)));
        Intrinsics.checkNotNullParameter(map, (String)((String)aaaaao.aaaabU((char)-483327999)));
        this.我草你怎么反编译我模组aaaaaK = aaaaak2;
        this.我草你怎么反编译我模组aaaaaL = map;
    }

    public /* synthetic */ aaaaao(aaaaak aaaaak2, Map map, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        this(aaaaak2, (Map<String, String>)map);
    }

    @NotNull
    public final aaaaak 你为什么要破解我的代码aaaabK() {
        return this.我草你怎么反编译我模组aaaaaK;
    }

    @NotNull
    public final Map<String, String> 你为什么要破解我的代码aaaabL() {
        return this.我草你怎么反编译我模组aaaaaL;
    }

    @NotNull
    public class_8710.class_9154<aaaaao> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaao::你为什么要破解我的代码aaaabR);
    }

    @NotNull
    public final aaaaak 你为什么要破解我的代码aaaabM() {
        return this.我草你怎么反编译我模组aaaaaK;
    }

    @NotNull
    public final Map<String, String> 你为什么要破解我的代码aaaabN() {
        return this.我草你怎么反编译我模组aaaaaL;
    }

    @NotNull
    public final aaaaao 你为什么要破解我的代码aaaabO(@NotNull aaaaak aaaaak2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaaak2), (String)((String)aaaaao.aaaabU((char)-503644160)));
        Intrinsics.checkNotNullParameter(map, (String)((String)aaaaao.aaaabU((char)-1659699199)));
        return new aaaaao(aaaaak2, map);
    }

    public static /* synthetic */ aaaaao 你为什么要破解我的代码aaaabP(aaaaao aaaaao2, aaaaak aaaaak2, Map map, int n, Object object) {
        if ((n & 1) != 0) {
            aaaaak2 = aaaaao2.我草你怎么反编译我模组aaaaaK;
        }
        if ((n & 2) != 0) {
            map = aaaaao2.我草你怎么反编译我模组aaaaaL;
        }
        return aaaaao2.你为什么要破解我的代码aaaabO(aaaaak2, map);
    }

    @NotNull
    public String toString() {
        return "MonsterArenaControlPayload(controlType=" + this.我草你怎么反编译我模组aaaaaK + ", data=" + this.我草你怎么反编译我模组aaaaaL + ")";
    }

    public int hashCode() {
        int n = this.我草你怎么反编译我模组aaaaaK.hashCode();
        n = n * 31 + this.我草你怎么反编译我模组aaaaaL.hashCode();
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaao)) {
            return false;
        }
        aaaaao aaaaao2 = (aaaaao)object;
        if (this.我草你怎么反编译我模组aaaaaK != aaaaao2.我草你怎么反编译我模组aaaaaK) {
            return false;
        }
        return Intrinsics.areEqual(this.我草你怎么反编译我模组aaaaaL, aaaaao2.我草你怎么反编译我模组aaaaaL);
    }

    private static final void 你为什么要破解我的代码aaaabQ(aaaaao aaaaao2) {
        if (aaaaac.我草你怎么反编译我模组aaaaaa[aaaaao2.我草你怎么反编译我模组aaaaaK.ordinal()] == 1) {
            aaaadf.我草你怎么反编译我模组aaaaeK.你为什么要破解我的代码aaaaik();
        }
    }

    private static final void 你为什么要破解我的代码aaaabR(aaaaao aaaaao2, ServerPlayNetworking.Context context) {
        MinecraftServer minecraftServer = context.player().field_13995;
        minecraftServer.execute(() -> aaaaao.你为什么要破解我的代码aaaabQ(aaaaao2));
    }

    private static final void 你为什么要破解我的代码aaaabS(aaaaao aaaaao2, class_2540 class_25402) {
        class_25402.method_10817((Enum)aaaaao2.我草你怎么反编译我模组aaaaaK);
        class_25402.method_53002(aaaaao2.我草你怎么反编译我模组aaaaaL.size());
        Map<String, String> map = aaaaao2.我草你怎么反编译我模组aaaaaL;
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

    private static final aaaaao 你为什么要破解我的代码aaaabT(class_2540 class_25402) {
        aaaaak aaaaak2 = (aaaaak)class_25402.method_10818(aaaaak.class);
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
        Intrinsics.checkNotNull((Object)((Object)aaaaak2));
        return new aaaaao(aaaaak2, (Map<String, String>)map);
    }

    static {
        byte[] byArray = "qþ[;È¬Ø°ÃíOwþ7\"lmRÎAÖ=®0Rj1LXuß¾IÅÌp9ÂNý-Ë¨õ9qÁh­êé=QbÓf}ÁöâI2ÎáÛUäãÐü¥UB".getBytes("ISO_8859_1");
        Object[] objectArray = "[£Î:".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1235569703;
                case 1 -> 362738878;
                case 2 -> -31817450;
                case 3 -> 1877181752;
                case 4 -> 464123726;
                case 5 -> -1845706507;
                case 6 -> 1646326108;
                case 7 -> -1764130046;
                case 8 -> -1833551013;
                case 9 -> -1233077254;
                case 10 -> -259173574;
                case 11 -> 1302639008;
                case 12 -> 1771469144;
                case 13 -> -534073593;
                case 14 -> -474017910;
                case 15 -> -819672553;
                case 16 -> 1989673954;
                case 17 -> -1690214340;
                case 18 -> -1453492487;
                case 19 -> 1412925450;
                case 20 -> 325704077;
                case 21 -> -937113892;
                case 22 -> 1319665438;
                case 23 -> 1875560108;
                case 24 -> -1758469789;
                case 25 -> -881618053;
                case 26 -> 1943801689;
                case 27 -> -1995901333;
                case 28 -> -929607586;
                case 29 -> 379942852;
                case 30 -> -1675872911;
                case 31 -> -455044219;
                case 32 -> -178043431;
                case 33 -> -2107710477;
                case 34 -> 635628815;
                case 35 -> 723276701;
                case 36 -> 248834347;
                case 37 -> -153477831;
                case 38 -> 1817077297;
                case 39 -> -2142555693;
                case 40 -> -1497199845;
                case 41 -> -1274214158;
                case 42 -> -29828641;
                case 43 -> -1173050691;
                case 44 -> -1805287191;
                case 45 -> -1577982157;
                case 46 -> 1525769041;
                case 47 -> 8828151;
                case 48 -> 169790472;
                case 49 -> -1932725562;
                case 50 -> -1073775131;
                case 51 -> 1370509614;
                case 52 -> -353445453;
                case 53 -> 682596250;
                case 54 -> -1378812124;
                case 55 -> -558578447;
                case 56 -> -1487095578;
                case 57 -> 1981132436;
                case 58 -> 0x6CCCCC11;
                case 59 -> 2008075477;
                case 60 -> 172867885;
                case 61 -> 1720191211;
                case 62 -> -146634669;
                case 63 -> 663513712;
                case 64 -> 1595310741;
                case 65 -> -554495178;
                case 66 -> -783152867;
                case 67 -> 2137590381;
                case 68 -> -1223013814;
                case 69 -> -719878048;
                case 70 -> -60075708;
                case 71 -> -1140510715;
                case 72 -> -824254810;
                case 73 -> -513389513;
                case 74 -> -223194045;
                case 75 -> 325838051;
                case 76 -> -322042072;
                case 77 -> 1173883154;
                case 78 -> 1839188359;
                case 79 -> -673739332;
                case 80 -> -684257312;
                case 81 -> -513530854;
                case 82 -> 1290456467;
                case 83 -> 1259665190;
                case 84 -> -1212258676;
                case 85 -> -2143153520;
                case 86 -> -983751911;
                case 87 -> -1523800314;
                case 88 -> 9043484;
                case 89 -> 1834691740;
                case 90 -> -1125236060;
                case 91 -> -286930086;
                case 92 -> 2136806018;
                case 93 -> 1581420884;
                case 94 -> -257978293;
                case 95 -> 1981242982;
                case 96 -> 348024276;
                case 97 -> -76828944;
                case 98 -> -480874116;
                case 99 -> 871451247;
                case 100 -> -1653577224;
                case 101 -> 1328510072;
                case 102 -> 966199373;
                case 103 -> -172970626;
                case 104 -> -1556992180;
                case 105 -> -1715770309;
                case 106 -> -959653782;
                case 107 -> 1137673106;
                case 108 -> 1127612222;
                case 109 -> 266670337;
                case 110 -> 1274847058;
                case 111 -> 1139889920;
                case 112 -> 1295021897;
                case 113 -> 1267676865;
                case 114 -> 2139952674;
                case 115 -> 1540605130;
                case 116 -> 429994821;
                case 117 -> 83255593;
                case 118 -> 277508645;
                case 119 -> 2023941746;
                case 120 -> -1456131456;
                case 121 -> -1743500350;
                case 122 -> -1079846368;
                case 123 -> 729743527;
                case 124 -> -1104685625;
                case 125 -> -543552223;
                case 126 -> -1957159497;
                case 127 -> 2063727531;
                case 128 -> 1133475464;
                case 129 -> -1023177368;
                case 130 -> 499476073;
                case 131 -> 1600685321;
                case 132 -> 969857519;
                case 133 -> 507397847;
                case 134 -> -551697870;
                case 135 -> 1961618045;
                case 136 -> -1019937148;
                case 137 -> 1116241744;
                case 138 -> 586325659;
                case 139 -> -216596643;
                case 140 -> -731309292;
                case 141 -> -1999801814;
                case 142 -> 362784575;
                case 143 -> 1773250752;
                case 144 -> -2116504020;
                case 145 -> 1226186335;
                case 146 -> 1026271491;
                case 147 -> -108800367;
                case 148 -> 842675454;
                case 149 -> -1202948;
                case 150 -> 1405376385;
                case 151 -> -1578496209;
                case 152 -> -157919830;
                case 153 -> -1525449152;
                case 154 -> -470475248;
                case 155 -> 155373398;
                case 156 -> 2121228406;
                case 157 -> -708516267;
                case 158 -> -1374199378;
                case 159 -> -1361222625;
                case 160 -> 717557847;
                case 161 -> -880132202;
                case 162 -> 1836895441;
                case 163 -> 1585972202;
                case 164 -> -2128580077;
                case 165 -> 1846302941;
                case 166 -> -390423275;
                case 167 -> -1050395173;
                case 168 -> 281235212;
                case 169 -> -1639918849;
                case 170 -> 1300694241;
                case 171 -> 310781676;
                case 172 -> -473246685;
                case 173 -> 310121544;
                case 174 -> 201852311;
                case 175 -> -246174211;
                case 176 -> -53641241;
                case 177 -> 1625982079;
                case 178 -> -1182434293;
                case 179 -> 2094997492;
                case 180 -> -1820810426;
                case 181 -> -1076236376;
                case 182 -> -580509596;
                case 183 -> -607076171;
                case 184 -> -1338905330;
                case 185 -> 1549232501;
                case 186 -> -143016332;
                case 187 -> -249500315;
                case 188 -> 604360289;
                case 189 -> 792002317;
                case 190 -> -99552103;
                case 191 -> -1339732797;
                case 192 -> 1601417467;
                case 193 -> -506590923;
                case 194 -> -276485200;
                case 195 -> -1886855420;
                case 196 -> 1412779654;
                case 197 -> -2045249617;
                case 198 -> -2015782728;
                case 199 -> 1542459800;
                case 200 -> -600921676;
                case 201 -> -1141316449;
                case 202 -> -230126901;
                case 203 -> -846784916;
                case 204 -> 1451779747;
                case 205 -> -407088734;
                case 206 -> 773735849;
                case 207 -> 147465240;
                case 208 -> -1815179890;
                case 209 -> -1643001894;
                case 210 -> 141896136;
                case 211 -> -1346608176;
                case 212 -> 1326054543;
                case 213 -> -1735898210;
                case 214 -> 1333591879;
                case 215 -> -2034520370;
                case 216 -> 1684735167;
                case 217 -> -852170542;
                case 218 -> -1976464436;
                case 219 -> 1819043565;
                case 220 -> -1971323538;
                case 221 -> -2073973708;
                case 222 -> 1258476403;
                case 223 -> -1877344582;
                case 224 -> 1633342083;
                case 225 -> 319152505;
                case 226 -> 791916237;
                case 227 -> 1386088770;
                case 228 -> 1337249089;
                case 229 -> -1080072476;
                case 230 -> -505833077;
                case 231 -> 212394855;
                case 232 -> -2125457271;
                case 233 -> 68185017;
                case 234 -> 1119016546;
                case 235 -> 1600407256;
                case 236 -> -808791689;
                case 237 -> 161740978;
                case 238 -> -1128901912;
                case 239 -> -1692835919;
                case 240 -> -670065418;
                case 241 -> -946932051;
                case 242 -> 680718031;
                case 243 -> -536265567;
                case 244 -> -1496579387;
                case 245 -> 1869263574;
                case 246 -> 1921649630;
                case 247 -> -1321230154;
                case 248 -> 1846880421;
                case 249 -> -645855184;
                case 250 -> -345276611;
                case 251 -> -585787461;
                case 252 -> -1847095729;
                case 253 -> -342772279;
                case 254 -> 1614240634;
                case 255 -> -1801824786;
                default -> 11990531;
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
            aaaaaM = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaJ = new aaaaal(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaao.aaaabU((char)991559682)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaao.aaaabU((char)-2007433213)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaao::你为什么要破解我的代码aaaabS, aaaaao::你为什么要破解我的代码aaaabT);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaao.aaaabU((char)1855520772)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaabU(char c) {
        return ((Object[])aaaaaM)[c];
    }
}

