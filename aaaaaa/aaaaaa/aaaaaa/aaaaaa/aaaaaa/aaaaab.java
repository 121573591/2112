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
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class aaaaab {
    @NotNull
    public static final aaaaaa Companion;
    @NotNull
    private aaaacB liveType = aaaacB.我草你怎么反编译我模组aaaaex;
    @NotNull
    private String douyinID = (String)aaaaab.aaaaaA((char)262864896);
    @NotNull
    private String kuaishouID = (String)aaaaab.aaaaaA((char)1171456000);
    @NotNull
    private String kuaishouCookie = (String)aaaaab.aaaaaA((char)1047396352);
    @NotNull
    private String tiktokID = (String)aaaaab.aaaaaA((char)1504444416);
    @NotNull
    private String tiktokCookie = (String)aaaaab.aaaaaA((char)1035599872);
    private boolean isGiftMsgDisplay = true;
    private boolean isNameDisplay;
    private boolean isCardKeyModeEnabled;
    @NotNull
    private String cardKeyValue = (String)aaaaab.aaaaaA((char)1523777536);
    @NotNull
    private String BilibiliID = (String)aaaaab.aaaaaA((char)1934688256);
    public static aaaaab instance;
    static Object aaaaaa;

    @NotNull
    public final aaaacB 你为什么要破解我的代码aaaaaa() {
        return this.liveType;
    }

    public final void 你为什么要破解我的代码aaaaab(@NotNull aaaacB aaaacB2) {
        Intrinsics.checkNotNullParameter((Object)((Object)aaaacB2), (String)((String)aaaaab.aaaaaA((char)1274806273)));
        this.liveType = aaaacB2;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaac() {
        return this.douyinID;
    }

    public final void 你为什么要破解我的代码aaaaad(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaab.aaaaaA((char)-636747775)));
        this.douyinID = string;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaae() {
        return this.kuaishouID;
    }

    public final void 你为什么要破解我的代码aaaaaf(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaab.aaaaaA((char)867237889)));
        this.kuaishouID = string;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaag() {
        return this.kuaishouCookie;
    }

    public final void 你为什么要破解我的代码aaaaah(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaab.aaaaaA((char)-1541013503)));
        this.kuaishouCookie = string;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaai() {
        return this.tiktokID;
    }

    public final void 你为什么要破解我的代码aaaaaj(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaab.aaaaaA((char)1510080513)));
        this.tiktokID = string;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaak() {
        return this.tiktokCookie;
    }

    public final void 你为什么要破解我的代码aaaaal(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaab.aaaaaA((char)823459841)));
        this.tiktokCookie = string;
        Companion.你为什么要破解我的代码aaaaae();
    }

    public final boolean 你为什么要破解我的代码aaaaam() {
        return this.isGiftMsgDisplay;
    }

    public final void 你为什么要破解我的代码aaaaan(boolean bl) {
        this.isGiftMsgDisplay = bl;
        Companion.你为什么要破解我的代码aaaaae();
    }

    public final boolean 你为什么要破解我的代码aaaaao() {
        return this.isNameDisplay;
    }

    public final void 你为什么要破解我的代码aaaaap(boolean bl) {
        this.isNameDisplay = bl;
        Companion.你为什么要破解我的代码aaaaae();
    }

    public final boolean 你为什么要破解我的代码aaaaaq() {
        return this.isCardKeyModeEnabled;
    }

    public final void 你为什么要破解我的代码aaaaar(boolean bl) {
        this.isCardKeyModeEnabled = bl;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaas() {
        return this.cardKeyValue;
    }

    public final void 你为什么要破解我的代码aaaaat(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaab.aaaaaA((char)-1429143551)));
        this.cardKeyValue = string;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaau() {
        return this.BilibiliID;
    }

    public final void 你为什么要破解我的代码aaaaav(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)((String)aaaaab.aaaaaA((char)864157697)));
        this.BilibiliID = string;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public static final aaaaab 你为什么要破解我的代码aaaaaw() {
        return Companion.你为什么要破解我的代码aaaaaa();
    }

    public static final void 你为什么要破解我的代码aaaaax(@NotNull aaaaab aaaaab2) {
        Companion.你为什么要破解我的代码aaaaab(aaaaab2);
    }

    @JvmStatic
    public static final void 你为什么要破解我的代码aaaaay() {
        Companion.你为什么要破解我的代码aaaaad();
    }

    @JvmStatic
    public static final void 你为什么要破解我的代码aaaaaz() {
        Companion.你为什么要破解我的代码aaaaae();
    }

    static {
        byte[] byArray = "t¬rXºÔ<XHÂú|LêYÚÊÄÖáMS1kïÎìgî¸áé¤*)ÓùW".getBytes("ISO_8859_1");
        Object[] objectArray = "åhÑ!ÖN1".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 162561923;
                case 1 -> 1451197337;
                case 2 -> 1796842074;
                case 3 -> -474097136;
                case 4 -> 486638220;
                case 5 -> -127256708;
                case 6 -> -2028056772;
                case 7 -> 1770184273;
                case 8 -> -1070532923;
                case 9 -> -1546530299;
                case 10 -> 82865742;
                case 11 -> 1791541081;
                case 12 -> -1346613934;
                case 13 -> -2070012197;
                case 14 -> 1201399745;
                case 15 -> -1370125504;
                case 16 -> 315158064;
                case 17 -> 159011509;
                case 18 -> 2073542007;
                case 19 -> 722133955;
                case 20 -> -65031251;
                case 21 -> 1099312597;
                case 22 -> 140767460;
                case 23 -> -2117458297;
                case 24 -> 1920517964;
                case 25 -> -2113522192;
                case 26 -> -1648219500;
                case 27 -> -1894807461;
                case 28 -> 246968605;
                case 29 -> 1131035897;
                case 30 -> -1574054556;
                case 31 -> 622640225;
                case 32 -> 800238150;
                case 33 -> 351099699;
                case 34 -> 827300974;
                case 35 -> -1577971043;
                case 36 -> -971732761;
                case 37 -> 545451687;
                case 38 -> 1953728905;
                case 39 -> -824232250;
                case 40 -> 1567610720;
                case 41 -> -1577560118;
                case 42 -> 1539845803;
                case 43 -> 677569276;
                case 44 -> 1784050216;
                case 45 -> -1804893339;
                case 46 -> -1063217188;
                case 47 -> -693945307;
                case 48 -> -29870508;
                case 49 -> -1666022496;
                case 50 -> -698749744;
                case 51 -> -1489061618;
                case 52 -> -644900354;
                case 53 -> 1313911078;
                case 54 -> -736033206;
                case 55 -> -892362041;
                case 56 -> -921288609;
                case 57 -> -2024134701;
                case 58 -> -1394386090;
                case 59 -> -512052017;
                case 60 -> 1014769779;
                case 61 -> -26307554;
                case 62 -> -277214734;
                case 63 -> -1803327337;
                case 64 -> -642698068;
                case 65 -> -1191138887;
                case 66 -> -288041207;
                case 67 -> 224843021;
                case 68 -> 1350184474;
                case 69 -> -139483427;
                case 70 -> -1277787114;
                case 71 -> -1482142053;
                case 72 -> 201826262;
                case 73 -> -20130929;
                case 74 -> 133347794;
                case 75 -> 1065949745;
                case 76 -> 1423311727;
                case 77 -> -1031876202;
                case 78 -> -474914601;
                case 79 -> 529986509;
                case 80 -> -1719389678;
                case 81 -> -191812944;
                case 82 -> 1849841255;
                case 83 -> 1335043651;
                case 84 -> -1832513217;
                case 85 -> -836860669;
                case 86 -> 1854383874;
                case 87 -> -1829862514;
                case 88 -> -899225769;
                case 89 -> -2060955359;
                case 90 -> -240400436;
                case 91 -> -902530927;
                case 92 -> 1219484470;
                case 93 -> 102165249;
                case 94 -> 314343179;
                case 95 -> 1535245501;
                case 96 -> 867990381;
                case 97 -> -548832006;
                case 98 -> 1092256592;
                case 99 -> 1489712940;
                case 100 -> 2056281895;
                case 101 -> 1905073198;
                case 102 -> 1545135304;
                case 103 -> 159185912;
                case 104 -> 123613603;
                case 105 -> 1338439364;
                case 106 -> 673631279;
                case 107 -> 1714783991;
                case 108 -> -895368540;
                case 109 -> 714437815;
                case 110 -> 1754350360;
                case 111 -> -1155392126;
                case 112 -> 1890839060;
                case 113 -> -563562577;
                case 114 -> -1617827866;
                case 115 -> -1371180475;
                case 116 -> 110646057;
                case 117 -> -338500248;
                case 118 -> -1472539642;
                case 119 -> 482669282;
                case 120 -> -701330615;
                case 121 -> 1054147607;
                case 122 -> 169813686;
                case 123 -> -744921942;
                case 124 -> -2028939971;
                case 125 -> 720727770;
                case 126 -> -1063595189;
                case 127 -> -421431028;
                case 128 -> 483439678;
                case 129 -> -1556535063;
                case 130 -> -560740194;
                case 131 -> 232468326;
                case 132 -> -670425585;
                case 133 -> 921276510;
                case 134 -> -692485766;
                case 135 -> -898419068;
                case 136 -> -1209285088;
                case 137 -> 1118058187;
                case 138 -> -1897424327;
                case 139 -> -2136496145;
                case 140 -> 1652819921;
                case 141 -> 415948160;
                case 142 -> -962398893;
                case 143 -> -571617847;
                case 144 -> 1700215858;
                case 145 -> -247078887;
                case 146 -> -1276084887;
                case 147 -> -777992458;
                case 148 -> -123884411;
                case 149 -> 116102250;
                case 150 -> 977255778;
                case 151 -> -948356952;
                case 152 -> -225423989;
                case 153 -> -50112622;
                case 154 -> 1678943530;
                case 155 -> 577530716;
                case 156 -> 919402360;
                case 157 -> 293819121;
                case 158 -> 615470402;
                case 159 -> 324239990;
                case 160 -> 1297081699;
                case 161 -> -1659616070;
                case 162 -> 582991140;
                case 163 -> -1449026380;
                case 164 -> -1509326827;
                case 165 -> 1356252167;
                case 166 -> -493983597;
                case 167 -> 1601837901;
                case 168 -> 1861544776;
                case 169 -> -1483093011;
                case 170 -> 97438648;
                case 171 -> -1008311804;
                case 172 -> 1812249792;
                case 173 -> 1156219045;
                case 174 -> 584245216;
                case 175 -> 1207744821;
                case 176 -> 1736497826;
                case 177 -> -329146731;
                case 178 -> -2064192024;
                case 179 -> 2092970769;
                case 180 -> 533298143;
                case 181 -> 1192417439;
                case 182 -> -953694200;
                case 183 -> 1234945434;
                case 184 -> -366959616;
                case 185 -> -2008603775;
                case 186 -> -420026959;
                case 187 -> 1020847394;
                case 188 -> 173848489;
                case 189 -> -437072773;
                case 190 -> 502466360;
                case 191 -> 580149117;
                case 192 -> 1115416976;
                case 193 -> -1058755809;
                case 194 -> 1731424686;
                case 195 -> -2118501133;
                case 196 -> -1271287494;
                case 197 -> -994311566;
                case 198 -> 862902194;
                case 199 -> -1816400783;
                case 200 -> -2025553698;
                case 201 -> 2089201633;
                case 202 -> -36276236;
                case 203 -> 1094844955;
                case 204 -> 566452616;
                case 205 -> 516020053;
                case 206 -> 2055282247;
                case 207 -> -968017242;
                case 208 -> 868240107;
                case 209 -> 915615388;
                case 210 -> 733543995;
                case 211 -> -514807316;
                case 212 -> -1979370123;
                case 213 -> 1622244030;
                case 214 -> -1187343875;
                case 215 -> 84487309;
                case 216 -> 256334680;
                case 217 -> 1691814399;
                case 218 -> 1252129441;
                case 219 -> 2054458758;
                case 220 -> -1537401572;
                case 221 -> 1627461627;
                case 222 -> -131620598;
                case 223 -> -376636323;
                case 224 -> 1861251519;
                case 225 -> -1637122709;
                case 226 -> -1448876328;
                case 227 -> 1922283043;
                case 228 -> -488051411;
                case 229 -> -1587014477;
                case 230 -> 786253034;
                case 231 -> -1728049437;
                case 232 -> 1793440238;
                case 233 -> 2032510346;
                case 234 -> 748892091;
                case 235 -> 1523987173;
                case 236 -> 282134716;
                case 237 -> -1418567881;
                case 238 -> -1955887793;
                case 239 -> 763055999;
                case 240 -> -1776557204;
                case 241 -> -20835724;
                case 242 -> 1028615385;
                case 243 -> 1649606708;
                case 244 -> -724934462;
                case 245 -> 176212174;
                case 246 -> 2107630718;
                case 247 -> -204725352;
                case 248 -> 610635795;
                case 249 -> -817993483;
                case 250 -> -1692832391;
                case 251 -> -1656650965;
                case 252 -> -1989556668;
                case 253 -> -1647807935;
                case 254 -> 574721392;
                case 255 -> -1217074732;
                default -> 807207081;
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
            Object[] objectArray2 = new Object[2];
            objectArray = objectArray2;
            aaaaaa = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        Companion = new aaaaaa(null);
    }

    private static Object aaaaaA(char c) {
        return ((Object[])aaaaaa)[c];
    }
}

