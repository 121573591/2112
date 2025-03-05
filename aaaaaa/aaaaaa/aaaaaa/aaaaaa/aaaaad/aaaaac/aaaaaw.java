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

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaf;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaj;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaas;
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

@SourceDebugExtension(value={"SMAP\nBreakOutControlPayload.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BreakOutControlPayload.kt\ncn/pixellive/mc/game/client/network/BreakOutControlPayload\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,80:1\n215#2,2:81\n*S KotlinDebug\n*F\n+ 1 BreakOutControlPayload.kt\ncn/pixellive/mc/game/client/network/BreakOutControlPayload\n*L\n38#1:81,2\n*E\n"})
public final class aaaaaw
implements class_8710 {
    @NotNull
    public static final aaaaaj 我草你怎么反编译我模组aaaabe;
    @NotNull
    private final aaaaaf 我草你怎么反编译我模组aaaabf;
    @NotNull
    private final Map<String, String> 我草你怎么反编译我模组aaaaaL;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaaw> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaaw> 我草你怎么反编译我模组aaaaai;
    static Object aaaabg;

    public aaaaaw(@NotNull aaaaaf aaaaaf2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaaaf2), (String)((String)aaaaaw.aaaacQ((char)-565116928)));
        Intrinsics.checkNotNullParameter(map, (String)((String)aaaaaw.aaaacQ((char)1706754049)));
        this.我草你怎么反编译我模组aaaabf = aaaaaf2;
        this.我草你怎么反编译我模组aaaaaL = map;
    }

    public /* synthetic */ aaaaaw(aaaaaf aaaaaf2, Map map, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        this(aaaaaf2, (Map<String, String>)map);
    }

    @NotNull
    public final aaaaaf 你为什么要破解我的代码aaaacI() {
        return this.我草你怎么反编译我模组aaaabf;
    }

    @NotNull
    public final Map<String, String> 你为什么要破解我的代码aaaabL() {
        return this.我草你怎么反编译我模组aaaaaL;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, aaaaaw::你为什么要破解我的代码aaaacN);
    }

    @NotNull
    public class_8710.class_9154<aaaaaw> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final aaaaaf 你为什么要破解我的代码aaaacJ() {
        return this.我草你怎么反编译我模组aaaabf;
    }

    @NotNull
    public final Map<String, String> 你为什么要破解我的代码aaaabN() {
        return this.我草你怎么反编译我模组aaaaaL;
    }

    @NotNull
    public final aaaaaw 你为什么要破解我的代码aaaacK(@NotNull aaaaaf aaaaaf2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaaaf2), (String)((String)aaaaaw.aaaacQ((char)-777977856)));
        Intrinsics.checkNotNullParameter(map, (String)((String)aaaaaw.aaaacQ((char)1415905281)));
        return new aaaaaw(aaaaaf2, map);
    }

    public static /* synthetic */ aaaaaw 你为什么要破解我的代码aaaacL(aaaaaw aaaaaw2, aaaaaf aaaaaf2, Map map, int n, Object object) {
        if ((n & 1) != 0) {
            aaaaaf2 = aaaaaw2.我草你怎么反编译我模组aaaabf;
        }
        if ((n & 2) != 0) {
            map = aaaaaw2.我草你怎么反编译我模组aaaaaL;
        }
        return aaaaaw2.你为什么要破解我的代码aaaacK(aaaaaf2, map);
    }

    @NotNull
    public String toString() {
        return "BreakOutControlPayload(controlType=" + this.我草你怎么反编译我模组aaaabf + ", data=" + this.我草你怎么反编译我模组aaaaaL + ")";
    }

    public int hashCode() {
        int n = this.我草你怎么反编译我模组aaaabf.hashCode();
        n = n * 31 + this.我草你怎么反编译我模组aaaaaL.hashCode();
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaaw)) {
            return false;
        }
        aaaaaw aaaaaw2 = (aaaaaw)object;
        if (this.我草你怎么反编译我模组aaaabf != aaaaaw2.我草你怎么反编译我模组aaaabf) {
            return false;
        }
        return Intrinsics.areEqual(this.我草你怎么反编译我模组aaaaaL, aaaaaw2.我草你怎么反编译我模组aaaaaL);
    }

    private static final void 你为什么要破解我的代码aaaacM(aaaaaw aaaaaw2) {
        switch (aaaaas.我草你怎么反编译我模组aaaaaa[aaaaaw2.我草你怎么反编译我模组aaaabf.ordinal()]) {
            case 1: {
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaA();
                break;
            }
            case 2: {
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaabG();
                aaaaad.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaabV((String)aaaaaw.aaaacQ((char)1018429442));
            }
        }
    }

    private static final void 你为什么要破解我的代码aaaacN(aaaaaw aaaaaw2, ServerPlayNetworking.Context context) {
        MinecraftServer minecraftServer = context.player().field_13995;
        minecraftServer.execute(() -> aaaaaw.你为什么要破解我的代码aaaacM(aaaaaw2));
    }

    private static final void 你为什么要破解我的代码aaaacO(aaaaaw aaaaaw2, class_2540 class_25402) {
        class_25402.method_10817((Enum)aaaaaw2.我草你怎么反编译我模组aaaabf);
        class_25402.method_53002(aaaaaw2.我草你怎么反编译我模组aaaaaL.size());
        Map<String, String> map = aaaaaw2.我草你怎么反编译我模组aaaaaL;
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

    private static final aaaaaw 你为什么要破解我的代码aaaacP(class_2540 class_25402) {
        aaaaaf aaaaaf2 = (aaaaaf)class_25402.method_10818(aaaaaf.class);
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
        Intrinsics.checkNotNull((Object)((Object)aaaaaf2));
        return new aaaaaw(aaaaaf2, (Map<String, String>)map);
    }

    static {
        byte[] byArray = "° Þ³¿\feºQSÜ3WfØØeËÓÊ± `àÃ}tÒõiñÂ®\b¾0\r`¡=,o°û¤³\"Ç:Çomé4«´Àã¾+x-3õ ¥HÃögaC/S¹N»¢ëi/Ì¾×ñå*ûÍXÇôìYOXÈ/a2h\tíº`GT°Å¤½óÈ5".getBytes("ISO_8859_1");
        Object[] objectArray = "ìÇÏ\tÁi7".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1468921611;
                case 1 -> -425585058;
                case 2 -> -1975722984;
                case 3 -> -865744367;
                case 4 -> 1074547581;
                case 5 -> -1054247930;
                case 6 -> -518028779;
                case 7 -> -1439713922;
                case 8 -> -762118996;
                case 9 -> -437445502;
                case 10 -> 1604398419;
                case 11 -> -2028563995;
                case 12 -> 1845768512;
                case 13 -> -1099731529;
                case 14 -> 1853730790;
                case 15 -> -934085427;
                case 16 -> 107649939;
                case 17 -> -2044582146;
                case 18 -> -1535867943;
                case 19 -> -778890753;
                case 20 -> -793752326;
                case 21 -> -902326851;
                case 22 -> -1206849650;
                case 23 -> 1163307663;
                case 24 -> 1881874972;
                case 25 -> 2106807936;
                case 26 -> -135519928;
                case 27 -> -112962339;
                case 28 -> -1464682032;
                case 29 -> 1286256977;
                case 30 -> -694818356;
                case 31 -> 1761816241;
                case 32 -> -1180039415;
                case 33 -> 1060253223;
                case 34 -> 521455083;
                case 35 -> 305474934;
                case 36 -> 1617232678;
                case 37 -> -205113223;
                case 38 -> -1095353843;
                case 39 -> 1844473921;
                case 40 -> 1408565656;
                case 41 -> -1552692710;
                case 42 -> 888463075;
                case 43 -> -1764911118;
                case 44 -> 1340909417;
                case 45 -> 2024349903;
                case 46 -> -1429639905;
                case 47 -> -1316201191;
                case 48 -> 290886700;
                case 49 -> -871013958;
                case 50 -> 873517089;
                case 51 -> -256975949;
                case 52 -> -14143344;
                case 53 -> 1267638434;
                case 54 -> -1744237945;
                case 55 -> 1283404054;
                case 56 -> 942420839;
                case 57 -> -2139415192;
                case 58 -> 1032014094;
                case 59 -> 2147125872;
                case 60 -> -235479759;
                case 61 -> 1169408405;
                case 62 -> 210351295;
                case 63 -> 1935122434;
                case 64 -> 556789713;
                case 65 -> 2107851813;
                case 66 -> -1776573737;
                case 67 -> 1435389298;
                case 68 -> 1503451923;
                case 69 -> 1371961913;
                case 70 -> -208972933;
                case 71 -> 1386791813;
                case 72 -> 1712831338;
                case 73 -> -639128077;
                case 74 -> 775182898;
                case 75 -> 469661988;
                case 76 -> -599389398;
                case 77 -> -1263006852;
                case 78 -> -1108192416;
                case 79 -> -1794908065;
                case 80 -> -1616103749;
                case 81 -> -1442347742;
                case 82 -> -1389128672;
                case 83 -> -1705410870;
                case 84 -> 32071896;
                case 85 -> 1108127195;
                case 86 -> 486272011;
                case 87 -> 1685584032;
                case 88 -> -1262938643;
                case 89 -> -1976342335;
                case 90 -> 1709682284;
                case 91 -> -755097516;
                case 92 -> -1139883818;
                case 93 -> 1342345087;
                case 94 -> -1652587259;
                case 95 -> -2071909749;
                case 96 -> -981923511;
                case 97 -> -1961507190;
                case 98 -> 1295116446;
                case 99 -> 950350;
                case 100 -> -331775122;
                case 101 -> -1322637374;
                case 102 -> 575609834;
                case 103 -> 345107101;
                case 104 -> -782284541;
                case 105 -> 1209112605;
                case 106 -> 145823038;
                case 107 -> -1773536259;
                case 108 -> -1023838288;
                case 109 -> 1380568949;
                case 110 -> -1131888605;
                case 111 -> -1499464085;
                case 112 -> 1331731000;
                case 113 -> -1724814289;
                case 114 -> 1868456290;
                case 115 -> 106417488;
                case 116 -> 1340374338;
                case 117 -> 1554428841;
                case 118 -> -1460983832;
                case 119 -> -1738583481;
                case 120 -> 320731182;
                case 121 -> 1753265632;
                case 122 -> 1649288537;
                case 123 -> 734827803;
                case 124 -> -1594184618;
                case 125 -> -435351731;
                case 126 -> 1233076414;
                case 127 -> 152346262;
                case 128 -> 59949041;
                case 129 -> -1345751585;
                case 130 -> -1207514001;
                case 131 -> 947164773;
                case 132 -> 1580666442;
                case 133 -> 1227997224;
                case 134 -> -886511918;
                case 135 -> 1495913367;
                case 136 -> 1512599496;
                case 137 -> -1997523999;
                case 138 -> 287295412;
                case 139 -> 1907153067;
                case 140 -> -464591034;
                case 141 -> 977740455;
                case 142 -> -957310700;
                case 143 -> -605134251;
                case 144 -> 1532099937;
                case 145 -> -2006433036;
                case 146 -> -786787629;
                case 147 -> 1154814061;
                case 148 -> 2145488264;
                case 149 -> -1931527002;
                case 150 -> -1760014537;
                case 151 -> 1194150618;
                case 152 -> -1139756209;
                case 153 -> 1316640092;
                case 154 -> 581421138;
                case 155 -> 254041492;
                case 156 -> -1868902281;
                case 157 -> 1769292023;
                case 158 -> 1213024575;
                case 159 -> 2005074572;
                case 160 -> 839164099;
                case 161 -> 1498900865;
                case 162 -> -490059700;
                case 163 -> 1953156420;
                case 164 -> 168424705;
                case 165 -> 1647860291;
                case 166 -> 126421350;
                case 167 -> 1402806948;
                case 168 -> -34957692;
                case 169 -> -1489897085;
                case 170 -> -1970640369;
                case 171 -> 1200209365;
                case 172 -> -30458900;
                case 173 -> 1878118126;
                case 174 -> -1384954393;
                case 175 -> -204608316;
                case 176 -> -1700150979;
                case 177 -> -1529378875;
                case 178 -> -1289010890;
                case 179 -> -693304882;
                case 180 -> -1677592207;
                case 181 -> 1629513848;
                case 182 -> -1873347411;
                case 183 -> -1231184466;
                case 184 -> 491962806;
                case 185 -> 981757283;
                case 186 -> -1659636838;
                case 187 -> -460398602;
                case 188 -> 1383153197;
                case 189 -> -1365035420;
                case 190 -> 368872283;
                case 191 -> -1773957069;
                case 192 -> 1018322869;
                case 193 -> -2048127802;
                case 194 -> 903813831;
                case 195 -> -1219437858;
                case 196 -> -1767828923;
                case 197 -> -91382528;
                case 198 -> -1761943377;
                case 199 -> -432984744;
                case 200 -> 1767491930;
                case 201 -> -173065500;
                case 202 -> 1984052533;
                case 203 -> 1823689711;
                case 204 -> 577124683;
                case 205 -> -1224822485;
                case 206 -> 89239969;
                case 207 -> -1692880518;
                case 208 -> -650221178;
                case 209 -> 129699833;
                case 210 -> -1799401612;
                case 211 -> 850775708;
                case 212 -> 1581420062;
                case 213 -> -1810503412;
                case 214 -> 1885260858;
                case 215 -> 1662631164;
                case 216 -> -330088748;
                case 217 -> -515246243;
                case 218 -> 1985104040;
                case 219 -> 451573808;
                case 220 -> 274984210;
                case 221 -> 1566513856;
                case 222 -> -260016993;
                case 223 -> 519943906;
                case 224 -> -641871088;
                case 225 -> 1417747497;
                case 226 -> -91437561;
                case 227 -> -33167451;
                case 228 -> 1483187696;
                case 229 -> -531642870;
                case 230 -> -1124677206;
                case 231 -> -1062338163;
                case 232 -> 663271825;
                case 233 -> -1394337449;
                case 234 -> 1020380604;
                case 235 -> 1282808435;
                case 236 -> 1977911544;
                case 237 -> 1320139913;
                case 238 -> 785795588;
                case 239 -> 776862115;
                case 240 -> 150315241;
                case 241 -> -921107653;
                case 242 -> -1465687557;
                case 243 -> -1207297358;
                case 244 -> -704806860;
                case 245 -> 1359415048;
                case 246 -> 1008557970;
                case 247 -> -1935487815;
                case 248 -> 1641082428;
                case 249 -> -1648967496;
                case 250 -> -885740343;
                case 251 -> 1509193436;
                case 252 -> 1786689483;
                case 253 -> -1502926949;
                case 254 -> -2042694633;
                case 255 -> 1051924377;
                default -> -680986794;
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
            aaaabg = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabe = new aaaaaj(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaaw.aaaacQ((char)2027552771)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaaw.aaaacQ((char)-2006188028)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaaw::你为什么要破解我的代码aaaacO, aaaaaw::你为什么要破解我的代码aaaacP);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaaw.aaaacQ((char)2024669189)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaacQ(char c) {
        return ((Object[])aaaabg)[c];
    }
}

