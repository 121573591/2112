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
 *  net.minecraft.class_2540
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9139
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaab;
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
import net.minecraft.class_2540;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaaaap
implements class_8710 {
    @NotNull
    public static final aaaaab 我草你怎么反编译我模组aaaabj;
    @NotNull
    private final String 我草你怎么反编译我模组aaaabk;
    private final int 我草你怎么反编译我模组aaaabl;
    private final int 我草你怎么反编译我模组aaaabm;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaap> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaap> 我草你怎么反编译我模组aaaaai;
    static Object aaaabn;

    public aaaaap(@NotNull String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaap.aaaadg((char)46792704)));
        this.我草你怎么反编译我模组aaaabk = string;
        this.我草你怎么反编译我模组aaaabl = n;
        this.我草你怎么反编译我模组aaaabm = n2;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaacZ() {
        return this.我草你怎么反编译我模组aaaabk;
    }

    public final int 你为什么要破解我的代码aaaada() {
        return this.我草你怎么反编译我模组aaaabl;
    }

    public final int 你为什么要破解我的代码aaaadb() {
        return this.我草你怎么反编译我模组aaaabm;
    }

    @NotNull
    public class_8710.class_9154<? extends class_8710> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaaG() {
        return this.我草你怎么反编译我模组aaaabk;
    }

    public final int 你为什么要破解我的代码aaaaai() {
        return this.我草你怎么反编译我模组aaaabl;
    }

    public final int 你为什么要破解我的代码aaaaaj() {
        return this.我草你怎么反编译我模组aaaabm;
    }

    @NotNull
    public final aaaaap 你为什么要破解我的代码aaaadc(@NotNull String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaap.aaaadg((char)-967704576)));
        return new aaaaap(string, n, n2);
    }

    public static /* synthetic */ aaaaap 你为什么要破解我的代码aaaadd(aaaaap aaaaap2, String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            string = aaaaap2.我草你怎么反编译我模组aaaabk;
        }
        if ((n3 & 2) != 0) {
            n = aaaaap2.我草你怎么反编译我模组aaaabl;
        }
        if ((n3 & 4) != 0) {
            n2 = aaaaap2.我草你怎么反编译我模组aaaabm;
        }
        return aaaaap2.你为什么要破解我的代码aaaadc(string, n, n2);
    }

    @NotNull
    public String toString() {
        return "KeyBindEventPayload(eventType=" + this.我草你怎么反编译我模组aaaabk + ", count=" + this.我草你怎么反编译我模组aaaabl + ", progress=" + this.我草你怎么反编译我模组aaaabm + ")";
    }

    public int hashCode() {
        int n = this.我草你怎么反编译我模组aaaabk.hashCode();
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaabl);
        n = n * 31 + Integer.hashCode((int)this.我草你怎么反编译我模组aaaabm);
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaap)) {
            return false;
        }
        aaaaap aaaaap2 = (aaaaap)object;
        if (!Intrinsics.areEqual((Object)this.我草你怎么反编译我模组aaaabk, (Object)aaaaap2.我草你怎么反编译我模组aaaabk)) {
            return false;
        }
        if (this.我草你怎么反编译我模组aaaabl != aaaaap2.我草你怎么反编译我模组aaaabl) {
            return false;
        }
        return this.我草你怎么反编译我模组aaaabm == aaaaap2.我草你怎么反编译我模组aaaabm;
    }

    private static final void 你为什么要破解我的代码aaaade(aaaaap aaaaap2, class_2540 class_25402) {
        class_25402.method_10814(aaaaap2.我草你怎么反编译我模组aaaabk);
        class_25402.method_53002(aaaaap2.我草你怎么反编译我模组aaaabl);
        class_25402.method_53002(aaaaap2.我草你怎么反编译我模组aaaabm);
    }

    private static final aaaaap 你为什么要破解我的代码aaaadf(class_2540 class_25402) {
        String string = class_25402.method_19772();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)((String)aaaaap.aaaadg((char)-372375551)));
        return new aaaaap(string, class_25402.readInt(), class_25402.readInt());
    }

    static {
        byte[] byArray = "?~|:«î÷9¨j¹ÇCà¸ÅFÃ»Ç sÔÌlad# \\¤:#ôÿæVè\nóÇÜ÷LÛntâ¡[£gMF­­';n­¹T±ì#óÔ(Ã,¨°".getBytes("ISO_8859_1");
        Object[] objectArray = "Ïplñ¶Ù".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1112166378;
                case 1 -> 1879805816;
                case 2 -> -2034171349;
                case 3 -> 789803846;
                case 4 -> 677293166;
                case 5 -> -800827270;
                case 6 -> 1599978148;
                case 7 -> -146511309;
                case 8 -> -1668201648;
                case 9 -> 1046097600;
                case 10 -> -1182205585;
                case 11 -> 697213956;
                case 12 -> -438094325;
                case 13 -> 1432428357;
                case 14 -> -1583564696;
                case 15 -> -2103670433;
                case 16 -> -696437560;
                case 17 -> 261870533;
                case 18 -> 954156042;
                case 19 -> -549722163;
                case 20 -> -1625709569;
                case 21 -> -714131437;
                case 22 -> -1601860043;
                case 23 -> 211749132;
                case 24 -> -178066771;
                case 25 -> 2028752505;
                case 26 -> -1130713212;
                case 27 -> -1754030380;
                case 28 -> -207127206;
                case 29 -> -397811839;
                case 30 -> 1293754344;
                case 31 -> -1706513672;
                case 32 -> 627792335;
                case 33 -> 117446420;
                case 34 -> -1951052880;
                case 35 -> -814790377;
                case 36 -> 751021283;
                case 37 -> -673952650;
                case 38 -> 1383106994;
                case 39 -> -820506797;
                case 40 -> 2112013418;
                case 41 -> -2109508449;
                case 42 -> -1222209783;
                case 43 -> 304690969;
                case 44 -> -704141763;
                case 45 -> 396235358;
                case 46 -> 1591669130;
                case 47 -> 459799610;
                case 48 -> -496645666;
                case 49 -> -1475306169;
                case 50 -> -1477490397;
                case 51 -> -1118713959;
                case 52 -> 1741611380;
                case 53 -> -771778297;
                case 54 -> 803346055;
                case 55 -> 1772623781;
                case 56 -> -1640906954;
                case 57 -> -1630601363;
                case 58 -> 1723949386;
                case 59 -> -1971570190;
                case 60 -> 681483096;
                case 61 -> 463510974;
                case 62 -> -2090875647;
                case 63 -> 834029595;
                case 64 -> 2092066441;
                case 65 -> -1827830421;
                case 66 -> -1494389734;
                case 67 -> -1243280382;
                case 68 -> -531632851;
                case 69 -> -895826051;
                case 70 -> -1462891474;
                case 71 -> -1076192117;
                case 72 -> -1415125624;
                case 73 -> -605423534;
                case 74 -> 1769999803;
                case 75 -> -1502351165;
                case 76 -> -722061162;
                case 77 -> -1565896503;
                case 78 -> -1414248186;
                case 79 -> -349716962;
                case 80 -> 611851171;
                case 81 -> -1118346098;
                case 82 -> 12135009;
                case 83 -> 215697916;
                case 84 -> -826550795;
                case 85 -> -2078362543;
                case 86 -> -128777304;
                case 87 -> 1833043346;
                case 88 -> -1281738817;
                case 89 -> 1595252262;
                case 90 -> 1464266414;
                case 91 -> -1980286052;
                case 92 -> -1926291007;
                case 93 -> -1887602469;
                case 94 -> -360934578;
                case 95 -> -1949367209;
                case 96 -> -166482569;
                case 97 -> -680801499;
                case 98 -> -1578198541;
                case 99 -> 248401200;
                case 100 -> 767151428;
                case 101 -> -1140260992;
                case 102 -> -303521195;
                case 103 -> -904938991;
                case 104 -> -830246340;
                case 105 -> 955775758;
                case 106 -> 227353608;
                case 107 -> 1389730407;
                case 108 -> -2143515287;
                case 109 -> 865955489;
                case 110 -> -1232310487;
                case 111 -> -412662220;
                case 112 -> -465532198;
                case 113 -> 1797643452;
                case 114 -> -1902529236;
                case 115 -> -279277496;
                case 116 -> 738789036;
                case 117 -> -493510544;
                case 118 -> -1631457311;
                case 119 -> -2049953725;
                case 120 -> -1200822092;
                case 121 -> 891187301;
                case 122 -> -1298931342;
                case 123 -> -382451235;
                case 124 -> -726393982;
                case 125 -> 246032690;
                case 126 -> 1749529068;
                case 127 -> 1904362737;
                case 128 -> -1105880382;
                case 129 -> 1262672982;
                case 130 -> 923253750;
                case 131 -> -1273085153;
                case 132 -> 595230663;
                case 133 -> 1945923305;
                case 134 -> 1952685824;
                case 135 -> -1454704144;
                case 136 -> -1413854655;
                case 137 -> 1602504167;
                case 138 -> 890354466;
                case 139 -> 90121432;
                case 140 -> -1221485089;
                case 141 -> 1539295379;
                case 142 -> 112362353;
                case 143 -> -178624494;
                case 144 -> -304739266;
                case 145 -> 757775493;
                case 146 -> -477335844;
                case 147 -> 496788522;
                case 148 -> -2114006653;
                case 149 -> 1546827919;
                case 150 -> 1299080885;
                case 151 -> 277272605;
                case 152 -> -1153205318;
                case 153 -> 954022661;
                case 154 -> 1297218286;
                case 155 -> -1946285273;
                case 156 -> 156166692;
                case 157 -> -170251371;
                case 158 -> -1187661697;
                case 159 -> 642306367;
                case 160 -> -845796824;
                case 161 -> -2047037093;
                case 162 -> -600084552;
                case 163 -> -821835712;
                case 164 -> 1372063462;
                case 165 -> 238079817;
                case 166 -> -1516418741;
                case 167 -> -1376662588;
                case 168 -> 683893048;
                case 169 -> -760996442;
                case 170 -> 1153952714;
                case 171 -> -1582456378;
                case 172 -> -30428915;
                case 173 -> 1547467735;
                case 174 -> 1930893782;
                case 175 -> 2044683261;
                case 176 -> -1363924703;
                case 177 -> 64994974;
                case 178 -> 831884180;
                case 179 -> 903491924;
                case 180 -> 1300194127;
                case 181 -> 935042002;
                case 182 -> -101192894;
                case 183 -> 665657702;
                case 184 -> 1956294555;
                case 185 -> 1273842845;
                case 186 -> 152448682;
                case 187 -> 385646744;
                case 188 -> 832652035;
                case 189 -> -539181257;
                case 190 -> -1381648455;
                case 191 -> -56174515;
                case 192 -> -249236559;
                case 193 -> 1016547417;
                case 194 -> 1261045999;
                case 195 -> -225748297;
                case 196 -> -1383121863;
                case 197 -> 984753781;
                case 198 -> -566698279;
                case 199 -> -1610774537;
                case 200 -> 602324828;
                case 201 -> 1744655212;
                case 202 -> 1334445105;
                case 203 -> 231491443;
                case 204 -> 114190505;
                case 205 -> 1121151376;
                case 206 -> 1176124112;
                case 207 -> 310432861;
                case 208 -> -946536820;
                case 209 -> 1784390159;
                case 210 -> -1590953824;
                case 211 -> -1025767170;
                case 212 -> 461423136;
                case 213 -> -723571172;
                case 214 -> 2020078841;
                case 215 -> -1176562291;
                case 216 -> 2045531744;
                case 217 -> 933458863;
                case 218 -> -838163252;
                case 219 -> -115955921;
                case 220 -> 1535585780;
                case 221 -> 1389292000;
                case 222 -> -735366741;
                case 223 -> 1403907309;
                case 224 -> -2057496069;
                case 225 -> 1341562979;
                case 226 -> 1174112636;
                case 227 -> 792795928;
                case 228 -> 2020462771;
                case 229 -> -1622231339;
                case 230 -> 1470663834;
                case 231 -> 717055650;
                case 232 -> -1579777897;
                case 233 -> 240662754;
                case 234 -> -830699594;
                case 235 -> 1477866407;
                case 236 -> -585320982;
                case 237 -> 1200306814;
                case 238 -> 240476900;
                case 239 -> -143147141;
                case 240 -> -1823785963;
                case 241 -> -1658574492;
                case 242 -> 614683468;
                case 243 -> 2082118867;
                case 244 -> 1669776187;
                case 245 -> 1311217168;
                case 246 -> -616830491;
                case 247 -> 1783603409;
                case 248 -> 97080811;
                case 249 -> 1008731130;
                case 250 -> -1583826499;
                case 251 -> -841699450;
                case 252 -> -1949235506;
                case 253 -> -296914287;
                case 254 -> 282598498;
                case 255 -> 2105475531;
                default -> 1748981923;
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
            aaaabn = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaabj = new aaaaab(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaap.aaaadg((char)1092091906)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaap.aaaadg((char)-14745597)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaap::你为什么要破解我的代码aaaade, aaaaap::你为什么要破解我的代码aaaadf);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaap.aaaadg((char)-1308098556)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaadg(char c) {
        return ((Object[])aaaabn)[c];
    }
}

