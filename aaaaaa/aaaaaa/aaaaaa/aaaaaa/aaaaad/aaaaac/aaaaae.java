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
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaao;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
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

public final class aaaaae
implements class_8710 {
    @NotNull
    public static final aaaaad 我草你怎么反编译我模组aaaaau;
    private final int 我草你怎么反编译我模组aaaaae;
    @JvmField
    @NotNull
    public static final class_8710.class_9154<aaaaae> 我草你怎么反编译我模组aaaaah;
    @JvmField
    @NotNull
    public static final class_9139<class_2540, aaaaae> 我草你怎么反编译我模组aaaaai;
    static Object aaaaav;

    public aaaaae(int n) {
        this.我草你怎么反编译我模组aaaaae = n;
    }

    public final int 你为什么要破解我的代码aaaaad() {
        return this.我草你怎么反编译我模组aaaaae;
    }

    public final void 你为什么要破解我的代码aaaaag() {
        PayloadTypeRegistry.playC2S().register(我草你怎么反编译我模组aaaaah, 我草你怎么反编译我模组aaaaai);
        ServerPlayNetworking.registerGlobalReceiver(我草你怎么反编译我模组aaaaah, (arg_0, arg_1) -> aaaaae.你为什么要破解我的代码aaaabf(this, arg_0, arg_1));
    }

    private final void 你为什么要破解我的代码aaaabc(aaaaae aaaaae2) {
        int n = aaaaae2.我草你怎么反编译我模组aaaaae;
        int n2 = aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaaaf();
        if (n2 != n) {
            aaaaao.我草你怎么反编译我模组aaaabo.你为什么要破解我的代码aaaaag(n);
            aaaaab.你为什么要破解我的代码aaaaaa().info("建筑守卫战: 更新每日挑战次数 " + n2 + " -> " + n);
        }
    }

    @NotNull
    public class_8710.class_9154<aaaaae> method_56479() {
        return 我草你怎么反编译我模组aaaaah;
    }

    public final int 你为什么要破解我的代码aaaaaw() {
        return this.我草你怎么反编译我模组aaaaae;
    }

    @NotNull
    public final aaaaae 你为什么要破解我的代码aaaabd(int n) {
        return new aaaaae(n);
    }

    public static /* synthetic */ aaaaae 你为什么要破解我的代码aaaabe(aaaaae aaaaae2, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = aaaaae2.我草你怎么反编译我模组aaaaae;
        }
        return aaaaae2.你为什么要破解我的代码aaaabd(n);
    }

    @NotNull
    public String toString() {
        return "FortressArchitectSettingsPayload(challengeNum=" + this.我草你怎么反编译我模组aaaaae + ")";
    }

    public int hashCode() {
        return Integer.hashCode((int)this.我草你怎么反编译我模组aaaaae);
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aaaaae)) {
            return false;
        }
        aaaaae aaaaae2 = (aaaaae)object;
        return this.我草你怎么反编译我模组aaaaae == aaaaae2.我草你怎么反编译我模组aaaaae;
    }

    private static final void 你为什么要破解我的代码aaaabf(aaaaae aaaaae2, aaaaae aaaaae3, ServerPlayNetworking.Context context) {
        Intrinsics.checkNotNullParameter((Object)aaaaae2, (String)((String)aaaaae.aaaabi((char)-66191360)));
        Intrinsics.checkNotNull((Object)aaaaae3);
        aaaaae2.你为什么要破解我的代码aaaabc(aaaaae3);
    }

    private static final void 你为什么要破解我的代码aaaabg(aaaaae aaaaae2, class_2540 class_25402) {
        class_25402.method_53002(aaaaae2.我草你怎么反编译我模组aaaaae);
    }

    private static final aaaaae 你为什么要破解我的代码aaaabh(class_2540 class_25402) {
        return new aaaaae(class_25402.readInt());
    }

    static {
        byte[] byArray = "ú[\nÄ´Q.\n±Êãz®ìöày5¯YÐ )çÖ­Hàé$­-mefÉÖ=z¤iq«¡d8@2\fGØ^äað\b°rU6xnG¶¢æ".getBytes("ISO_8859_1");
        Object[] objectArray = "o7­".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1310478273;
                case 1 -> -951016733;
                case 2 -> 1457804532;
                case 3 -> 731096876;
                case 4 -> -567535418;
                case 5 -> 1737347776;
                case 6 -> 1930433799;
                case 7 -> 265465952;
                case 8 -> 1796681984;
                case 9 -> 515029144;
                case 10 -> -1804957447;
                case 11 -> 1597063046;
                case 12 -> -980092676;
                case 13 -> -68381104;
                case 14 -> 1870414894;
                case 15 -> 1817081357;
                case 16 -> -1555440433;
                case 17 -> 30074389;
                case 18 -> 2021463191;
                case 19 -> 477640631;
                case 20 -> -1694262910;
                case 21 -> 1426407774;
                case 22 -> 1977106326;
                case 23 -> 261933791;
                case 24 -> -1751026068;
                case 25 -> 1221623143;
                case 26 -> 792006088;
                case 27 -> -1748695282;
                case 28 -> -1625215287;
                case 29 -> -153117109;
                case 30 -> 1183666242;
                case 31 -> -2009190321;
                case 32 -> 1570801673;
                case 33 -> -1009552291;
                case 34 -> -1222311657;
                case 35 -> -1454695976;
                case 36 -> -55654823;
                case 37 -> -1079632683;
                case 38 -> -137147358;
                case 39 -> 346572079;
                case 40 -> 491283709;
                case 41 -> 1523432739;
                case 42 -> -1270963140;
                case 43 -> -777578490;
                case 44 -> -1316299823;
                case 45 -> 782509850;
                case 46 -> -1330470015;
                case 47 -> -513782099;
                case 48 -> 1238719943;
                case 49 -> 1079457513;
                case 50 -> -11544987;
                case 51 -> 1019103210;
                case 52 -> -1159284868;
                case 53 -> -75489270;
                case 54 -> -792540294;
                case 55 -> -2094800158;
                case 56 -> -824715202;
                case 57 -> 1388189547;
                case 58 -> 263252408;
                case 59 -> -1182993391;
                case 60 -> -1395284205;
                case 61 -> -745351920;
                case 62 -> -1579224139;
                case 63 -> 986815607;
                case 64 -> 1920213422;
                case 65 -> -1115290433;
                case 66 -> -1241627879;
                case 67 -> 491123148;
                case 68 -> -123733710;
                case 69 -> 763272146;
                case 70 -> 1581977194;
                case 71 -> -721166809;
                case 72 -> 1020467524;
                case 73 -> 1804574721;
                case 74 -> -537440292;
                case 75 -> -769318947;
                case 76 -> 1753470232;
                case 77 -> 1164437197;
                case 78 -> 1795367939;
                case 79 -> -2087736747;
                case 80 -> -334648072;
                case 81 -> -529877322;
                case 82 -> 1188870049;
                case 83 -> 1595346740;
                case 84 -> -1026696684;
                case 85 -> 2121367513;
                case 86 -> 590282487;
                case 87 -> -480673093;
                case 88 -> 1528636154;
                case 89 -> -1651182590;
                case 90 -> -85461663;
                case 91 -> -1846039969;
                case 92 -> 427005168;
                case 93 -> -1738653307;
                case 94 -> 1995708229;
                case 95 -> 2100453342;
                case 96 -> 1234842854;
                case 97 -> 1319579792;
                case 98 -> -1212796532;
                case 99 -> -1830161898;
                case 100 -> 110738776;
                case 101 -> 1652190479;
                case 102 -> -316676166;
                case 103 -> 1957606618;
                case 104 -> 559216872;
                case 105 -> -1783413486;
                case 106 -> -826248515;
                case 107 -> -1857369852;
                case 108 -> -105885737;
                case 109 -> -684816235;
                case 110 -> 1281653051;
                case 111 -> -1003912356;
                case 112 -> 772775374;
                case 113 -> 2002024083;
                case 114 -> 1044059570;
                case 115 -> -360655934;
                case 116 -> -1005688629;
                case 117 -> -706884469;
                case 118 -> 1310805675;
                case 119 -> 1499825207;
                case 120 -> 988149029;
                case 121 -> 338979871;
                case 122 -> 1006020310;
                case 123 -> -1556390310;
                case 124 -> -952632331;
                case 125 -> 49424645;
                case 126 -> 1106417197;
                case 127 -> -1568778643;
                case 128 -> -1339306669;
                case 129 -> -1811498714;
                case 130 -> 354153809;
                case 131 -> -873307156;
                case 132 -> -2110303259;
                case 133 -> -1338518657;
                case 134 -> 1988147348;
                case 135 -> -1625570660;
                case 136 -> 466361499;
                case 137 -> -465766797;
                case 138 -> -992113533;
                case 139 -> -239497593;
                case 140 -> -1095473254;
                case 141 -> 300575142;
                case 142 -> -1857411164;
                case 143 -> 1444485059;
                case 144 -> -2056062738;
                case 145 -> 854943872;
                case 146 -> 225994352;
                case 147 -> 213409122;
                case 148 -> 1236531870;
                case 149 -> 1863687222;
                case 150 -> -1134459525;
                case 151 -> -1542289565;
                case 152 -> 252470605;
                case 153 -> -588891818;
                case 154 -> 807274088;
                case 155 -> 1977175097;
                case 156 -> -148336591;
                case 157 -> 1848342922;
                case 158 -> -1235607233;
                case 159 -> -1282761116;
                case 160 -> 694284507;
                case 161 -> -616086956;
                case 162 -> -1717449217;
                case 163 -> 1300370162;
                case 164 -> -1430311350;
                case 165 -> 418525707;
                case 166 -> 1574745702;
                case 167 -> 328845814;
                case 168 -> 333517809;
                case 169 -> -1661181553;
                case 170 -> -83644274;
                case 171 -> 1701243960;
                case 172 -> 1133636935;
                case 173 -> -1255438861;
                case 174 -> 1201571611;
                case 175 -> 1314514523;
                case 176 -> 1976858397;
                case 177 -> -1669176518;
                case 178 -> 1311912345;
                case 179 -> 801832187;
                case 180 -> -1817550776;
                case 181 -> 429368722;
                case 182 -> 1253360497;
                case 183 -> 343927970;
                case 184 -> -1634075783;
                case 185 -> -228557431;
                case 186 -> 949858720;
                case 187 -> 1858056871;
                case 188 -> -8535775;
                case 189 -> -1187659318;
                case 190 -> -1266796004;
                case 191 -> -1881825891;
                case 192 -> 1637847237;
                case 193 -> -1709157090;
                case 194 -> 376900178;
                case 195 -> 1580551549;
                case 196 -> -53676474;
                case 197 -> 954471288;
                case 198 -> 43870240;
                case 199 -> 847597129;
                case 200 -> -1842290866;
                case 201 -> 504272529;
                case 202 -> -1162639704;
                case 203 -> -605133826;
                case 204 -> 1804756812;
                case 205 -> 96566848;
                case 206 -> -1766013176;
                case 207 -> 1701426858;
                case 208 -> -631256157;
                case 209 -> -465165904;
                case 210 -> -1724902847;
                case 211 -> -1599569751;
                case 212 -> -1360553204;
                case 213 -> 217235853;
                case 214 -> -719882199;
                case 215 -> -875308430;
                case 216 -> 126989537;
                case 217 -> 1707588335;
                case 218 -> -1584539778;
                case 219 -> -166997052;
                case 220 -> 2131536851;
                case 221 -> 1739404959;
                case 222 -> -2080360139;
                case 223 -> 1870199107;
                case 224 -> -293890000;
                case 225 -> 782261565;
                case 226 -> -1969089676;
                case 227 -> 1966336042;
                case 228 -> -1459910212;
                case 229 -> -2002181186;
                case 230 -> 266382191;
                case 231 -> 192583908;
                case 232 -> -1214842703;
                case 233 -> -1537209037;
                case 234 -> -1349302316;
                case 235 -> 1105426212;
                case 236 -> 1395724207;
                case 237 -> 979213399;
                case 238 -> -1939150549;
                case 239 -> -642084476;
                case 240 -> -1134979211;
                case 241 -> 912474230;
                case 242 -> -386025106;
                case 243 -> -424328992;
                case 244 -> -359276057;
                case 245 -> -2019036691;
                case 246 -> -386437708;
                case 247 -> -1175635015;
                case 248 -> 481951979;
                case 249 -> -911157143;
                case 250 -> -38191152;
                case 251 -> 1859909036;
                case 252 -> -1917771224;
                case 253 -> 2059448243;
                case 254 -> -750171483;
                case 255 -> 1176214920;
                default -> -607459740;
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
            aaaaav = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaau = new aaaaad(null);
        class_8710.class_9154 class_91542 = class_8710.method_56483((String)((String)aaaaae.aaaabi((char)-300089343)));
        Intrinsics.checkNotNullExpressionValue((Object)class_91542, (String)((String)aaaaae.aaaabi((char)1070858242)));
        我草你怎么反编译我模组aaaaah = class_91542;
        class_9139 class_91392 = class_9139.method_56438(aaaaae::你为什么要破解我的代码aaaabg, aaaaae::你为什么要破解我的代码aaaabh);
        Intrinsics.checkNotNullExpressionValue((Object)class_91392, (String)((String)aaaaae.aaaabi((char)-1113391101)));
        我草你怎么反编译我模组aaaaai = class_91392;
    }

    private static Object aaaabi(char c) {
        return ((Object[])aaaaav)[c];
    }
}

