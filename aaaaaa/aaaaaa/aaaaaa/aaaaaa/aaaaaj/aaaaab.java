/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Enum
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
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  net.minecraft.class_1308
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaj;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaj.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaj.aaaaaf;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_1308;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaaaab
extends Enum<aaaaab> {
    @NotNull
    private final String 我草你怎么反编译我模组aaaabe;
    private final int 我草你怎么反编译我模组aaaabf;
    private final boolean 我草你怎么反编译我模组aaaabg;
    @Nullable
    private final Function4<class_3218, class_243, String, Boolean, class_1308> 我草你怎么反编译我模组aaaabh;
    public static final /* enum */ aaaaab 我草你怎么反编译我模组aaaabi;
    public static final /* enum */ aaaaab 我草你怎么反编译我模组aaaabj;
    public static final /* enum */ aaaaab 我草你怎么反编译我模组aaaabk;
    public static final /* enum */ aaaaab 我草你怎么反编译我模组aaaabl;
    public static final /* enum */ aaaaab 我草你怎么反编译我模组aaaabm;
    public static final /* enum */ aaaaab 我草你怎么反编译我模组aaaabn;
    public static final /* enum */ aaaaab 我草你怎么反编译我模组aaaabo;
    private static final /* synthetic */ aaaaab[] 我草你怎么反编译我模组aaaabp;
    private static final /* synthetic */ EnumEntries 我草你怎么反编译我模组aaaaaX;
    static Object aaaabq;

    private aaaaab(String string2, int n2, boolean bl, Function4<? super class_3218, ? super class_243, ? super String, ? super Boolean, ? extends class_1308> function4) {
        this.我草你怎么反编译我模组aaaabe = string2;
        this.我草你怎么反编译我模组aaaabf = n2;
        this.我草你怎么反编译我模组aaaabg = bl;
        this.我草你怎么反编译我模组aaaabh = function4;
    }

    /* synthetic */ aaaaab(String string, int n, String string2, int n2, boolean bl, Function4 function4, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 4) != 0) {
            bl = false;
        }
        if ((n3 & 8) != 0) {
            function4 = null;
        }
        this(string2, n2, bl, (Function4<? super class_3218, ? super class_243, ? super String, ? super Boolean, ? extends class_1308>)function4);
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaau() {
        return this.我草你怎么反编译我模组aaaabe;
    }

    public final int 你为什么要破解我的代码aaaaav() {
        return this.我草你怎么反编译我模组aaaabf;
    }

    public final boolean 你为什么要破解我的代码aaaaaw() {
        return this.我草你怎么反编译我模组aaaabg;
    }

    @Nullable
    public final Function4<class_3218, class_243, String, Boolean, class_1308> 你为什么要破解我的代码aaaaax() {
        return this.我草你怎么反编译我模组aaaabh;
    }

    public final boolean 你为什么要破解我的代码aaaaay(@NotNull class_1308 class_13082) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)class_13082, (String)((String)aaaaab.aaaaaA((char)847577088)));
        if (this.我草你怎么反编译我模组aaaabg) {
            String string = class_13082.method_5864().toString();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaab.aaaaaA((char)-864813055)));
            String[] stringArray = new String[]{(String)aaaaab.aaaaaA((char)962396162)};
            bl = StringsKt.contains((CharSequence)string, (CharSequence)((CharSequence)StringsKt.split$default((CharSequence)this.我草你怎么反编译我模组aaaabe, (String[])stringArray, (boolean)false, (int)0, (int)6, null).get(1)), (boolean)true);
        } else {
            bl = Intrinsics.areEqual((Object)class_13082.method_5864().toString(), (Object)this.我草你怎么反编译我模组aaaabe);
        }
        return bl;
    }

    public static aaaaab[] values() {
        return (aaaaab[])我草你怎么反编译我模组aaaabp.clone();
    }

    public static aaaaab valueOf(String string) {
        return (aaaaab)Enum.valueOf(aaaaab.class, (String)string);
    }

    @NotNull
    public static EnumEntries<aaaaab> 你为什么要破解我的代码aaaaar() {
        return 我草你怎么反编译我模组aaaaaX;
    }

    static {
        byte[] byArray = "?P5KÔÑû$g7.ß:1ùQ ÝQiÇ¤ùZÈ±¢«ÝMne#MK@õ¨Ò§<r\rm^öÛëÐÛy&RaA`b!­X%ÎÈ|®8±;¤·n*®Ì'*a¡æÈdÔÓ5ØpþÂtu.¸§øt3CMc{¸ëëëÙ1ó\f°6Ü\b7\rnÒT÷Ó­Û¬s0¹àrãsÉ:­º0Eÿ¨k¼,÷J¤ÛaÇ%õÎC\tî©ökk?Þ]eïæÇ¢òrXÀ¶ï3Éòæm@>1qÁäM/ÕºAÂe´ûÈü¶NÕ#þÃÞ;ªØ¾¶ §".getBytes("ISO_8859_1");
        Object[] objectArray = "qp< /".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1027632633;
                case 1 -> -1692687283;
                case 2 -> 1678167210;
                case 3 -> -763551813;
                case 4 -> -804038005;
                case 5 -> -1445344474;
                case 6 -> 267907985;
                case 7 -> -661094260;
                case 8 -> 767527007;
                case 9 -> -1497641271;
                case 10 -> 733007366;
                case 11 -> 1231113156;
                case 12 -> -1486220579;
                case 13 -> 1861053133;
                case 14 -> -704503315;
                case 15 -> -679060850;
                case 16 -> -867597984;
                case 17 -> 553165418;
                case 18 -> 2083716669;
                case 19 -> 1096055811;
                case 20 -> -1671124180;
                case 21 -> -1718849822;
                case 22 -> 369118736;
                case 23 -> -96540129;
                case 24 -> 455172527;
                case 25 -> 1721734130;
                case 26 -> -60176601;
                case 27 -> 309154544;
                case 28 -> -1634212152;
                case 29 -> 982713387;
                case 30 -> -722972479;
                case 31 -> 820926615;
                case 32 -> 1412051911;
                case 33 -> -915980722;
                case 34 -> 1945435047;
                case 35 -> -440947803;
                case 36 -> -1824818820;
                case 37 -> -1991480872;
                case 38 -> -2071522929;
                case 39 -> 1602954702;
                case 40 -> 1473598843;
                case 41 -> -1240645864;
                case 42 -> 1369629634;
                case 43 -> 829062923;
                case 44 -> -1781685193;
                case 45 -> 542180321;
                case 46 -> 1517964305;
                case 47 -> -1313237013;
                case 48 -> 181991853;
                case 49 -> 783353779;
                case 50 -> -1405409672;
                case 51 -> 617174968;
                case 52 -> 673388077;
                case 53 -> 996311918;
                case 54 -> 364320289;
                case 55 -> 1132703539;
                case 56 -> -1949830849;
                case 57 -> 1576913798;
                case 58 -> -1680640760;
                case 59 -> 1469269420;
                case 60 -> 354231599;
                case 61 -> 838343656;
                case 62 -> -1989724101;
                case 63 -> -1897418402;
                case 64 -> -1117465862;
                case 65 -> 1207272305;
                case 66 -> -1525147917;
                case 67 -> -350126819;
                case 68 -> 914380471;
                case 69 -> 1852621013;
                case 70 -> -1826136696;
                case 71 -> 1283407358;
                case 72 -> -1547018698;
                case 73 -> -1519455682;
                case 74 -> -214815325;
                case 75 -> 764899207;
                case 76 -> 598028796;
                case 77 -> 1845593012;
                case 78 -> 435160677;
                case 79 -> 1002502725;
                case 80 -> -71089398;
                case 81 -> -946289879;
                case 82 -> 1211491609;
                case 83 -> -1178174332;
                case 84 -> 201156234;
                case 85 -> -366612060;
                case 86 -> 1379098084;
                case 87 -> -1784755642;
                case 88 -> 1156263016;
                case 89 -> -116147177;
                case 90 -> -549297518;
                case 91 -> 10958319;
                case 92 -> -1515763126;
                case 93 -> 666405115;
                case 94 -> -889600494;
                case 95 -> -1031629222;
                case 96 -> 812850519;
                case 97 -> 846589823;
                case 98 -> -155352688;
                case 99 -> 596256833;
                case 100 -> 629774031;
                case 101 -> -1926151904;
                case 102 -> -1224256427;
                case 103 -> 1256957455;
                case 104 -> 128132471;
                case 105 -> 541659996;
                case 106 -> 1549102302;
                case 107 -> 140658900;
                case 108 -> -1414430117;
                case 109 -> 216537964;
                case 110 -> 2085878281;
                case 111 -> -533821357;
                case 112 -> 645093361;
                case 113 -> 1758844752;
                case 114 -> 531757931;
                case 115 -> -1681205979;
                case 116 -> 1810704909;
                case 117 -> -1528182446;
                case 118 -> -748643810;
                case 119 -> -921073030;
                case 120 -> 399908340;
                case 121 -> -665955752;
                case 122 -> -2080380626;
                case 123 -> 1185604562;
                case 124 -> 534529920;
                case 125 -> 839671858;
                case 126 -> -1489838038;
                case 127 -> -192954275;
                case 128 -> 982373753;
                case 129 -> -1708555547;
                case 130 -> 1673516369;
                case 131 -> -1214748514;
                case 132 -> -51302162;
                case 133 -> 406200284;
                case 134 -> 1979837142;
                case 135 -> 1911333490;
                case 136 -> 380092917;
                case 137 -> -289286938;
                case 138 -> 2105742959;
                case 139 -> 1113382014;
                case 140 -> 2115777867;
                case 141 -> -838319624;
                case 142 -> 702400268;
                case 143 -> 386018783;
                case 144 -> -1258930103;
                case 145 -> -595017040;
                case 146 -> -1954523069;
                case 147 -> 1111321110;
                case 148 -> -837073447;
                case 149 -> 778036097;
                case 150 -> 1071365023;
                case 151 -> -1505516938;
                case 152 -> 1529112267;
                case 153 -> 878805552;
                case 154 -> -1691740029;
                case 155 -> 501789433;
                case 156 -> -2069371820;
                case 157 -> -1906378050;
                case 158 -> -1684971917;
                case 159 -> -498152224;
                case 160 -> 138203478;
                case 161 -> -520830807;
                case 162 -> -718217481;
                case 163 -> -970188958;
                case 164 -> -1241681768;
                case 165 -> -84978930;
                case 166 -> -1813477697;
                case 167 -> -1765419705;
                case 168 -> -289547159;
                case 169 -> -519083708;
                case 170 -> -912567334;
                case 171 -> -892165700;
                case 172 -> 158448579;
                case 173 -> -1393447675;
                case 174 -> -1651113492;
                case 175 -> -966019309;
                case 176 -> -225107776;
                case 177 -> 2103348395;
                case 178 -> 1591616516;
                case 179 -> 1800367168;
                case 180 -> -1457918897;
                case 181 -> -1215637348;
                case 182 -> 1992106181;
                case 183 -> -600495325;
                case 184 -> -493077354;
                case 185 -> 1109017346;
                case 186 -> -1239567486;
                case 187 -> 1528146825;
                case 188 -> 1639300264;
                case 189 -> 809562323;
                case 190 -> -561377680;
                case 191 -> -212846203;
                case 192 -> -1099892323;
                case 193 -> 91336704;
                case 194 -> -1308386244;
                case 195 -> 1270888633;
                case 196 -> 928708865;
                case 197 -> -1797613138;
                case 198 -> -1295187278;
                case 199 -> 140790361;
                case 200 -> -624773259;
                case 201 -> -875951258;
                case 202 -> 1355940408;
                case 203 -> -1318407787;
                case 204 -> 144399103;
                case 205 -> -13476446;
                case 206 -> -991940377;
                case 207 -> 747428022;
                case 208 -> 527378890;
                case 209 -> -1423786544;
                case 210 -> -1247889356;
                case 211 -> -1612829286;
                case 212 -> -1759597803;
                case 213 -> -881850202;
                case 214 -> -698180154;
                case 215 -> -1596940061;
                case 216 -> -334993332;
                case 217 -> -416248134;
                case 218 -> -1881132310;
                case 219 -> 292780584;
                case 220 -> 1911242780;
                case 221 -> -1319493048;
                case 222 -> -175000733;
                case 223 -> 387411001;
                case 224 -> 1755205053;
                case 225 -> 1610735319;
                case 226 -> -1950989669;
                case 227 -> 1657597723;
                case 228 -> -891896527;
                case 229 -> -172920223;
                case 230 -> -531911427;
                case 231 -> 870346401;
                case 232 -> 702882580;
                case 233 -> 356382567;
                case 234 -> -1734823264;
                case 235 -> 1355402188;
                case 236 -> 903424538;
                case 237 -> 1153995445;
                case 238 -> 738512954;
                case 239 -> -767875036;
                case 240 -> 420717745;
                case 241 -> -263101221;
                case 242 -> 525706217;
                case 243 -> 1347757558;
                case 244 -> -1371775279;
                case 245 -> -70675559;
                case 246 -> -1338409603;
                case 247 -> 2042945684;
                case 248 -> -2129508755;
                case 249 -> 1075405634;
                case 250 -> -1282818419;
                case 251 -> -1443729630;
                case 252 -> 48345460;
                case 253 -> 576434997;
                case 254 -> 405209491;
                case 255 -> -324227484;
                default -> -69869978;
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
            Object[] objectArray2 = new Object[15];
            objectArray = objectArray2;
            aaaabq = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabi = new aaaaab((String)aaaaab.aaaaaA((char)1084882947), 0, (String)aaaaab.aaaaaA((char)1661861892), 1, false, null, 12, null);
        我草你怎么反编译我模组aaaabj = new aaaaab((String)aaaaab.aaaaaA((char)565837829), 1, (String)aaaaab.aaaaaA((char)-1788870650), 2, false, null, 12, null);
        我草你怎么反编译我模组aaaabk = new aaaaab((String)aaaaab.aaaaaA((char)-956956665), 2, (String)aaaaab.aaaaaA((char)26804232), 3, false, null, 12, null);
        我草你怎么反编译我模组aaaabl = new aaaaab((String)aaaaab.aaaaaA((char)-109969399), 3, (String)aaaaab.aaaaaA((char)-9175036), 4, false, null, 12, null);
        我草你怎么反编译我模组aaaabm = new aaaaab((String)aaaaab.aaaaaA((char)1298464778), 4, (String)aaaaab.aaaaaA((char)1918042120), 5, false, null, 12, null);
        我草你怎么反编译我模组aaaabn = new aaaaab((String)aaaaab.aaaaaA((char)-463405044), 6, true, (Function4<? super class_3218, ? super class_243, ? super String, ? super Boolean, ? extends class_1308>)((Function4)aaaaad.我草你怎么反编译我模组aaaacM));
        我草你怎么反编译我模组aaaabo = new aaaaab((String)aaaaab.aaaaaA((char)917831694), 7, true, (Function4<? super class_3218, ? super class_243, ? super String, ? super Boolean, ? extends class_1308>)((Function4)aaaaaf.我草你怎么反编译我模组aaaaef));
        我草你怎么反编译我模组aaaabp = aaaaabArray = new aaaaab[]{aaaaab.我草你怎么反编译我模组aaaabi, aaaaab.我草你怎么反编译我模组aaaabj, aaaaab.我草你怎么反编译我模组aaaabk, aaaaab.我草你怎么反编译我模组aaaabl, aaaaab.我草你怎么反编译我模组aaaabm, aaaaab.我草你怎么反编译我模组aaaabn, aaaaab.我草你怎么反编译我模组aaaabo};
        我草你怎么反编译我模组aaaaaX = EnumEntriesKt.enumEntries((Enum[])我草你怎么反编译我模组aaaabp);
    }

    private static Object aaaaaA(char c) {
        return ((Object[])aaaabq)[c];
    }
}

