//
// Decompiled by FernFlower - 951ms
//
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class aaaaab {
    @NotNull
    public static final aaaaaa Companion;
    static Object aaaaaa;
    public static aaaaab instance;
    @NotNull
    private String BilibiliID;
    @NotNull
    private String cardKeyValue;
    @NotNull
    private String douyinID;
    private boolean isCardKeyModeEnabled;
    private boolean isGiftMsgDisplay;
    private boolean isNameDisplay;
    @NotNull
    private String kuaishouCookie;
    @NotNull
    private String kuaishouID;
    @NotNull
    private aaaacB liveType;
    @NotNull
    private String tiktokCookie;
    @NotNull
    private String tiktokID;

    static {
        byte[] var8 = "t¬r\u000fXº\u0089\u0006Ô<X\u008aHÂ\u0082\u008cú|\u0086\u000bLêYÚÊÄÖáMS1kïÎìgî\u0096¸áé¤*)ÓùW\u0016".getBytes("ISO_8859_1");
        byte[] var7 = "åhÑ\u001c!ÖN1".getBytes("ISO_8859_1");
        int var3 = var8.length;
        int var2 = 0;

        while(true) {
            int var1;
            switch (var8[var2] & 255) {
                case 0:
                    var1 = 0x09b07f83;
                    break;
                case 1:
                    var1 = 0x567f8399;
                    break;
                case 2:
                    var1 = 0x6b19a25a;
                    break;
                case 3:
                    var1 = -474097136;
                    break;
                case 4:
                    var1 = 0x1d01828c;
                    break;
                case 5:
                    var1 = -127256708;
                    break;
                case 6:
                    var1 = -2028056772;
                    break;
                case 7:
                    var1 = 0x6982de51;
                    break;
                case 8:
                    var1 = -1070532923;
                    break;
                case 9:
                    var1 = -1546530299;
                    break;
                case 10:
                    var1 = 0x04f06e4e;
                    break;
                case 11:
                    var1 = 0x6ac8bf59;
                    break;
                case 12:
                    var1 = -1346613934;
                    break;
                case 13:
                    var1 = -2070012197;
                    break;
                case 14:
                    var1 = 0x479be7c1;
                    break;
                case 15:
                    var1 = -1370125504;
                    break;
                case 16:
                    var1 = 0x12c8ee30;
                    break;
                case 17:
                    var1 = 0x097a52b5;
                    break;
                case 18:
                    var1 = 0x7b97bd77;
                    break;
                case 19:
                    var1 = 0x2b0ae3c3;
                    break;
                case 20:
                    var1 = -65031251;
                    break;
                case 21:
                    var1 = 0x41862dd5;
                    break;
                case 22:
                    var1 = 0x0863f0e4;
                    break;
                case 23:
                    var1 = -2117458297;
                    break;
                case 24:
                    var1 = 0x7278c74c;
                    break;
                case 25:
                    var1 = -2113522192;
                    break;
                case 26:
                    var1 = -1648219500;
                    break;
                case 27:
                    var1 = -1894807461;
                    break;
                case 28:
                    var1 = 0x0eb8711d;
                    break;
                case 29:
                    var1 = 0x436a3cf9;
                    break;
                case 30:
                    var1 = -1574054556;
                    break;
                case 31:
                    var1 = 0x251cbc61;
                    break;
                case 32:
                    var1 = 0x2fb2aa46;
                    break;
                case 33:
                    var1 = 0x14ed5b33;
                    break;
                case 34:
                    var1 = 0x314f9c6e;
                    break;
                case 35:
                    var1 = -1577971043;
                    break;
                case 36:
                    var1 = -971732761;
                    break;
                case 37:
                    var1 = 0x2082eea7;
                    break;
                case 38:
                    var1 = 0x74738989;
                    break;
                case 39:
                    var1 = -824232250;
                    break;
                case 40:
                    var1 = 0x5d6fd760;
                    break;
                case 41:
                    var1 = -1577560118;
                    break;
                case 42:
                    var1 = 0x5bc82eab;
                    break;
                case 43:
                    var1 = 0x2862e2fc;
                    break;
                case 44:
                    var1 = 0x6a567228;
                    break;
                case 45:
                    var1 = -1804893339;
                    break;
                case 46:
                    var1 = -1063217188;
                    break;
                case 47:
                    var1 = -693945307;
                    break;
                case 48:
                    var1 = -29870508;
                    break;
                case 49:
                    var1 = -1666022496;
                    break;
                case 50:
                    var1 = -698749744;
                    break;
                case 51:
                    var1 = -1489061618;
                    break;
                case 52:
                    var1 = -644900354;
                    break;
                case 53:
                    var1 = 0x4e50b126;
                    break;
                case 54:
                    var1 = -736033206;
                    break;
                case 55:
                    var1 = -892362041;
                    break;
                case 56:
                    var1 = -921288609;
                    break;
                case 57:
                    var1 = -2024134701;
                    break;
                case 58:
                    var1 = -1394386090;
                    break;
                case 59:
                    var1 = -512052017;
                    break;
                case 60:
                    var1 = 0x3c7c2873;
                    break;
                case 61:
                    var1 = -26307554;
                    break;
                case 62:
                    var1 = -277214734;
                    break;
                case 63:
                    var1 = -1803327337;
                    break;
                case 64:
                    var1 = -642698068;
                    break;
                case 65:
                    var1 = -1191138887;
                    break;
                case 66:
                    var1 = -288041207;
                    break;
                case 67:
                    var1 = 0x0d66d50d;
                    break;
                case 68:
                    var1 = 0x507a2e1a;
                    break;
                case 69:
                    var1 = -139483427;
                    break;
                case 70:
                    var1 = -1277787114;
                    break;
                case 71:
                    var1 = -1482142053;
                    break;
                case 72:
                    var1 = 0x0c079fd6;
                    break;
                case 73:
                    var1 = -20130929;
                    break;
                case 74:
                    var1 = 0x07f2b9d2;
                    break;
                case 75:
                    var1 = 0x3f891a31;
                    break;
                case 76:
                    var1 = 0x54d6036f;
                    break;
                case 77:
                    var1 = -1031876202;
                    break;
                case 78:
                    var1 = -474914601;
                    break;
                case 79:
                    var1 = 0x1f96f3cd;
                    break;
                case 80:
                    var1 = -1719389678;
                    break;
                case 81:
                    var1 = -191812944;
                    break;
                case 82:
                    var1 = 0x6e425667;
                    break;
                case 83:
                    var1 = 0x4f932643;
                    break;
                case 84:
                    var1 = -1832513217;
                    break;
                case 85:
                    var1 = -836860669;
                    break;
                case 86:
                    var1 = 0x6e87a702;
                    break;
                case 87:
                    var1 = -1829862514;
                    break;
                case 88:
                    var1 = -899225769;
                    break;
                case 89:
                    var1 = -2060955359;
                    break;
                case 90:
                    var1 = -240400436;
                    break;
                case 91:
                    var1 = -902530927;
                    break;
                case 92:
                    var1 = 0x48afdb36;
                    break;
                case 93:
                    var1 = 0x0616eb01;
                    break;
                case 94:
                    var1 = 0x12bc7f0b;
                    break;
                case 95:
                    var1 = 0x5b81fcbd;
                    break;
                case 96:
                    var1 = 0x33bc7b6d;
                    break;
                case 97:
                    var1 = -548832006;
                    break;
                case 98:
                    var1 = 0x411a8350;
                    break;
                case 99:
                    var1 = 0x58cb372c;
                    break;
                case 100:
                    var1 = 0x7a905f27;
                    break;
                case 101:
                    var1 = 0x718d1c2e;
                    break;
                case 102:
                    var1 = 0x5c18e4c8;
                    break;
                case 103:
                    var1 = 0x097cfbf8;
                    break;
                case 104:
                    var1 = 0x075e31a3;
                    break;
                case 105:
                    var1 = 0x4fc6f6c4;
                    break;
                case 106:
                    var1 = 0x2826cc2f;
                    break;
                case 107:
                    var1 = 0x663586f7;
                    break;
                case 108:
                    var1 = -895368540;
                    break;
                case 109:
                    var1 = 0x2a9574b7;
                    break;
                case 110:
                    var1 = 0x68914318;
                    break;
                case 111:
                    var1 = -1155392126;
                    break;
                case 112:
                    var1 = 0x70b3ea14;
                    break;
                case 113:
                    var1 = -563562577;
                    break;
                case 114:
                    var1 = -1617827866;
                    break;
                case 115:
                    var1 = -1371180475;
                    break;
                case 116:
                    var1 = 0x06985329;
                    break;
                case 117:
                    var1 = -338500248;
                    break;
                case 118:
                    var1 = -1472539642;
                    break;
                case 119:
                    var1 = 0x1cc4f2e2;
                    break;
                case 120:
                    var1 = -701330615;
                    break;
                case 121:
                    var1 = 0x3ed50417;
                    break;
                case 122:
                    var1 = 0x0a1f26b6;
                    break;
                case 123:
                    var1 = -744921942;
                    break;
                case 124:
                    var1 = -2028939971;
                    break;
                case 125:
                    var1 = 0x2af56eda;
                    break;
                case 126:
                    var1 = -1063595189;
                    break;
                case 127:
                    var1 = -421431028;
                    break;
                case 128:
                    var1 = 0x1cd0b43e;
                    break;
                case 129:
                    var1 = -1556535063;
                    break;
                case 130:
                    var1 = -560740194;
                    break;
                case 131:
                    var1 = 0x0ddb2f66;
                    break;
                case 132:
                    var1 = -670425585;
                    break;
                case 133:
                    var1 = 0x36e9905e;
                    break;
                case 134:
                    var1 = -692485766;
                    break;
                case 135:
                    var1 = -898419068;
                    break;
                case 136:
                    var1 = -1209285088;
                    break;
                case 137:
                    var1 = 0x42a436cb;
                    break;
                case 138:
                    var1 = -1897424327;
                    break;
                case 139:
                    var1 = -2136496145;
                    break;
                case 140:
                    var1 = 0x628407d1;
                    break;
                case 141:
                    var1 = 0x18cadd80;
                    break;
                case 142:
                    var1 = -962398893;
                    break;
                case 143:
                    var1 = -571617847;
                    break;
                case 144:
                    var1 = 0x65573c32;
                    break;
                case 145:
                    var1 = -247078887;
                    break;
                case 146:
                    var1 = -1276084887;
                    break;
                case 147:
                    var1 = -777992458;
                    break;
                case 148:
                    var1 = -123884411;
                    break;
                case 149:
                    var1 = 0x06eb946a;
                    break;
                case 150:
                    var1 = 0x3a3fbd62;
                    break;
                case 151:
                    var1 = -948356952;
                    break;
                case 152:
                    var1 = -225423989;
                    break;
                case 153:
                    var1 = -50112622;
                    break;
                case 154:
                    var1 = 0x6412a52a;
                    break;
                case 155:
                    var1 = 0x226c6b5c;
                    break;
                case 156:
                    var1 = 0x36ccf778;
                    break;
                case 157:
                    var1 = 0x118352f1;
                    break;
                case 158:
                    var1 = 0x24af5542;
                    break;
                case 159:
                    var1 = 0x13538276;
                    break;
                case 160:
                    var1 = 0x4d4fe563;
                    break;
                case 161:
                    var1 = -1659616070;
                    break;
                case 162:
                    var1 = 0x22bfbd24;
                    break;
                case 163:
                    var1 = -1449026380;
                    break;
                case 164:
                    var1 = -1509326827;
                    break;
                case 165:
                    var1 = 0x50d6c407;
                    break;
                case 166:
                    var1 = -493983597;
                    break;
                case 167:
                    var1 = 0x5f7a1b4d;
                    break;
                case 168:
                    var1 = 0x6ef4eb48;
                    break;
                case 169:
                    var1 = -1483093011;
                    break;
                case 170:
                    var1 = 0x05cecbb8;
                    break;
                case 171:
                    var1 = -1008311804;
                    break;
                case 172:
                    var1 = 0x6c04bcc0;
                    break;
                case 173:
                    var1 = 0x44ea80a5;
                    break;
                case 174:
                    var1 = 0x22d2dfe0;
                    break;
                case 175:
                    var1 = 0x47fcb935;
                    break;
                case 176:
                    var1 = 0x6780daa2;
                    break;
                case 177:
                    var1 = -329146731;
                    break;
                case 178:
                    var1 = -2064192024;
                    break;
                case 179:
                    var1 = 0x7cc03311;
                    break;
                case 180:
                    var1 = 0x1fc97bdf;
                    break;
                case 181:
                    var1 = 0x4712d89f;
                    break;
                case 182:
                    var1 = -953694200;
                    break;
                case 183:
                    var1 = 0x499bc59a;
                    break;
                case 184:
                    var1 = -366959616;
                    break;
                case 185:
                    var1 = -2008603775;
                    break;
                case 186:
                    var1 = -420026959;
                    break;
                case 187:
                    var1 = 0x3cd8e522;
                    break;
                case 188:
                    var1 = 0x0a5cb7a9;
                    break;
                case 189:
                    var1 = -437072773;
                    break;
                case 190:
                    var1 = 0x1df30738;
                    break;
                case 191:
                    var1 = 0x22945f7d;
                    break;
                case 192:
                    var1 = 0x427be990;
                    break;
                case 193:
                    var1 = -1058755809;
                    break;
                case 194:
                    var1 = 0x673371ae;
                    break;
                case 195:
                    var1 = -2118501133;
                    break;
                case 196:
                    var1 = -1271287494;
                    break;
                case 197:
                    var1 = -994311566;
                    break;
                case 198:
                    var1 = 0x336ed7b2;
                    break;
                case 199:
                    var1 = -1816400783;
                    break;
                case 200:
                    var1 = -2025553698;
                    break;
                case 201:
                    var1 = 0x7c86afe1;
                    break;
                case 202:
                    var1 = -36276236;
                    break;
                case 203:
                    var1 = 0x4142021b;
                    break;
                case 204:
                    var1 = 0x21c36188;
                    break;
                case 205:
                    var1 = 0x1ec1d755;
                    break;
                case 206:
                    var1 = 0x7a811e47;
                    break;
                case 207:
                    var1 = -968017242;
                    break;
                case 208:
                    var1 = 0x33c04aeb;
                    break;
                case 209:
                    var1 = 0x36932e9c;
                    break;
                case 210:
                    var1 = 0x2bb8fe3b;
                    break;
                case 211:
                    var1 = -514807316;
                    break;
                case 212:
                    var1 = -1979370123;
                    break;
                case 213:
                    var1 = 0x60b17abe;
                    break;
                case 214:
                    var1 = -1187343875;
                    break;
                case 215:
                    var1 = 0x05092c8d;
                    break;
                case 216:
                    var1 = 0x0f475b58;
                    break;
                case 217:
                    var1 = 0x64d709ff;
                    break;
                case 218:
                    var1 = 0x4aa1faa1;
                    break;
                case 219:
                    var1 = 0x7a748d86;
                    break;
                case 220:
                    var1 = -1537401572;
                    break;
                case 221:
                    var1 = 0x610117fb;
                    break;
                case 222:
                    var1 = -131620598;
                    break;
                case 223:
                    var1 = -376636323;
                    break;
                case 224:
                    var1 = 0x6ef071bf;
                    break;
                case 225:
                    var1 = -1637122709;
                    break;
                case 226:
                    var1 = -1448876328;
                    break;
                case 227:
                    var1 = 0x7293b623;
                    break;
                case 228:
                    var1 = -488051411;
                    break;
                case 229:
                    var1 = -1587014477;
                    break;
                case 230:
                    var1 = 0x2edd44ea;
                    break;
                case 231:
                    var1 = -1728049437;
                    break;
                case 232:
                    var1 = 0x6ae5b9ee;
                    break;
                case 233:
                    var1 = 0x7925a58a;
                    break;
                case 234:
                    var1 = 0x2ca32fbb;
                    break;
                case 235:
                    var1 = 0x5ad632e5;
                    break;
                case 236:
                    var1 = 0x10d108bc;
                    break;
                case 237:
                    var1 = -1418567881;
                    break;
                case 238:
                    var1 = -1955887793;
                    break;
                case 239:
                    var1 = 0x2d7b4f7f;
                    break;
                case 240:
                    var1 = -1776557204;
                    break;
                case 241:
                    var1 = -20835724;
                    break;
                case 242:
                    var1 = 0x3d4f6cd9;
                    break;
                case 243:
                    var1 = 0x62530034;
                    break;
                case 244:
                    var1 = -724934462;
                    break;
                case 245:
                    var1 = 0x0a80c8ce;
                    break;
                case 246:
                    var1 = 0x7d9fe47e;
                    break;
                case 247:
                    var1 = -204725352;
                    break;
                case 248:
                    var1 = 0x24659013;
                    break;
                case 249:
                    var1 = -817993483;
                    break;
                case 250:
                    var1 = -1692832391;
                    break;
                case 251:
                    var1 = -1656650965;
                    break;
                case 252:
                    var1 = -1989556668;
                    break;
                case 253:
                    var1 = -1647807935;
                    break;
                case 254:
                    var1 = 0x22418d70;
                    break;
                case 255:
                    var1 = -1217074732;
                    break;
                default:
                    var1 = 0x301d00a9;
            }

            byte var0 = (byte)var1;
            var1 = var2 + 1;
            var8[var2] = var0;
            if (var1 == var3) {
                Cipher var6 = Cipher.getInstance("DES/CBC/PKCS5Padding");
                var6.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(var7)), new IvParameterSpec(new byte[8]));
                byte[] var10 = var6.doFinal(var8);
                var1 = var10.length;
                MessageDigest var11 = MessageDigest.getInstance("SHA-256");
                var11.reset();
                int var5 = var1 - 32;
                var11.update(var10, 0, var5);
                var7 = var11.digest();
                var2 = 0;
                var1 = 0;

                int var4;
                do {
                    var4 = var2 | var10[var5 + var1] ^ var7[var1];
                    var3 = var1 + 1;
                    var2 = var4;
                    var1 = var3;
                } while(var3 != 32);

                if (var4 == 0) {
                    Object[] var12 = new Object[2];
                    aaaaaa = var12;
                    var1 = 0;
                    var2 = 0;

                    while(true) {
                        var3 = var2 + 1;
                        byte var9 = var10[var2];
                        var2 = var3 + 1;
                        var3 = (var10[var3] & 255) << 8 | var9 & 255;
                        var8 = new byte[var3];
                        System.arraycopy(var10, var2, var8, 0, var3);
                        var2 += var3;
                        var12[var1] = (new String(var8, "UTF-8")).intern();
                        if (var2 == var5) {
                            break;
                        }

                        ++var1;
                    }
                }

                Companion = new aaaaaa((DefaultConstructorMarker)null);
                return;
            }

            var2 = var1;
        }
    }

    public aaaaab() {
        this.liveType = aaaacB.我草你怎么反编译我模组aaaaex;
        this.douyinID = (String)aaaaaA((char)262864896);
        this.kuaishouID = (String)aaaaaA((char)1171456000);
        this.kuaishouCookie = (String)aaaaaA((char)1047396352);
        this.tiktokID = (String)aaaaaA((char)1504444416);
        this.tiktokCookie = (String)aaaaaA((char)1035599872);
        this.isGiftMsgDisplay = true;
        this.cardKeyValue = (String)aaaaaA((char)1523777536);
        this.BilibiliID = (String)aaaaaA((char)1934688256);
    }

    private static Object aaaaaA(char var0) {
        return ((Object[])aaaaaa)[var0];
    }

    @NotNull
    public static final aaaaab 你为什么要破解我的代码aaaaaw() {
        return Companion.你为什么要破解我的代码aaaaaa();
    }

    public static final void 你为什么要破解我的代码aaaaax(@NotNull aaaaab var0) {
        Companion.你为什么要破解我的代码aaaaab(var0);
    }

    @JvmStatic
    public static final void 你为什么要破解我的代码aaaaay() {
        Companion.你为什么要破解我的代码aaaaad();
    }

    @JvmStatic
    public static final void 你为什么要破解我的代码aaaaaz() {
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final aaaacB 你为什么要破解我的代码aaaaaa() {
        return this.liveType;
    }

    public final void 你为什么要破解我的代码aaaaab(@NotNull aaaacB var1) {
        Intrinsics.checkNotNullParameter(var1, (String)aaaaaA((char)1274806273));
        this.liveType = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaac() {
        return this.douyinID;
    }

    public final void 你为什么要破解我的代码aaaaad(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, (String)aaaaaA((char)-636747775));
        this.douyinID = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaae() {
        return this.kuaishouID;
    }

    public final void 你为什么要破解我的代码aaaaaf(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, (String)aaaaaA((char)867237889));
        this.kuaishouID = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaag() {
        return this.kuaishouCookie;
    }

    public final void 你为什么要破解我的代码aaaaah(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, (String)aaaaaA((char)-1541013503));
        this.kuaishouCookie = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaai() {
        return this.tiktokID;
    }

    public final void 你为什么要破解我的代码aaaaaj(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, (String)aaaaaA((char)1510080513));
        this.tiktokID = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaak() {
        return this.tiktokCookie;
    }

    public final void 你为什么要破解我的代码aaaaal(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, (String)aaaaaA((char)823459841));
        this.tiktokCookie = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    public final boolean 你为什么要破解我的代码aaaaam() {
        return this.isGiftMsgDisplay;
    }

    public final void 你为什么要破解我的代码aaaaan(boolean var1) {
        this.isGiftMsgDisplay = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    public final boolean 你为什么要破解我的代码aaaaao() {
        return this.isNameDisplay;
    }

    public final void 你为什么要破解我的代码aaaaap(boolean var1) {
        this.isNameDisplay = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    public final boolean 你为什么要破解我的代码aaaaaq() {
        return this.isCardKeyModeEnabled;
    }

    public final void 你为什么要破解我的代码aaaaar(boolean var1) {
        this.isCardKeyModeEnabled = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaas() {
        return this.cardKeyValue;
    }

    public final void 你为什么要破解我的代码aaaaat(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, (String)aaaaaA((char)-1429143551));
        this.cardKeyValue = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }

    @NotNull
    public final String 你为什么要破解我的代码aaaaau() {
        return this.BilibiliID;
    }

    public final void 你为什么要破解我的代码aaaaav(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, (String)aaaaaA((char)864157697));
        this.BilibiliID = var1;
        Companion.你为什么要破解我的代码aaaaae();
    }
}

