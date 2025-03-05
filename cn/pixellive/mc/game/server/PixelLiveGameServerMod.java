/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonObject
 *  java.io.File
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.file.FileVisitor
 *  java.nio.file.Files
 *  java.nio.file.LinkOption
 *  java.nio.file.Path
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.api.DedicatedServerModInitializer
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.loader.api.FabricLoader
 *  org.jetbrains.annotations.NotNull
 */
package cn.pixellive.mc.game.server;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaadh;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaab;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaac;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaaP;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaao;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabD;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabH;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabM;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabr;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaabv;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaacs;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaac.aaaadf;
import cn.pixellive.mc.game.PixelLiveGameMod;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;

public final class PixelLiveGameServerMod
implements DedicatedServerModInitializer {
    @NotNull
    public static final aaaaaa 我草你怎么反编译我模组aaaaaa;
    private static boolean 我草你怎么反编译我模组aaaaab;
    static Object aaaaac;

    @Environment(value=EnvType.SERVER)
    public void onInitializeServer() {
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER) {
            Path path = FabricLoader.getInstance().getGameDir().toAbsolutePath().getParent().resolve((String)PixelLiveGameServerMod.aaaaaf((char)1361903616)).toAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)((String)PixelLiveGameServerMod.aaaaaf((char)145620993)));
            Path path2 = path;
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaac.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaac();
            System.out.println("尝试启用：" + aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaac.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa());
            if (this.你为什么要破解我的代码aaaaab(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaac.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()) != null) {
                PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaag(this.你为什么要破解我的代码aaaaab(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaac.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa()));
                System.out.println("已启用：" + PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf());
                aaaaas aaaaas2 = PixelLiveGameMod.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaf();
                Intrinsics.checkNotNull((Object)aaaaas2);
                aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
            } else {
                System.out.println("启用失败：" + aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaac.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa());
            }
            this.你为什么要破解我的代码aaaaaa(path2);
            this.你为什么要破解我的代码aaaaac(path2);
        }
    }

    private final void 你为什么要破解我的代码aaaaaa(Path path) {
        aaaaas aaaaas2 = this.你为什么要破解我的代码aaaaab(aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaab.aaaaac.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaaa());
        if (aaaaas2 != null) {
            File file;
            File file2 = path.resolve((String)PixelLiveGameServerMod.aaaaaf((char)-1295056894)).toFile();
            Intrinsics.checkNotNull((Object)file2);
            FilesKt.writeText$default((File)file2, (String)aaaaas2.你为什么要破解我的代码aaaaak(), null, (int)2, null);
            File file3 = new File(FabricLoader.getInstance().getGameDir().toFile(), (String)PixelLiveGameServerMod.aaaaaf((char)-2024275965));
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (!(file = new File(file3, aaaaas2.你为什么要破解我的代码aaaaaj())).exists()) {
                file.mkdir();
            }
            aaaadh.我草你怎么反编译我模组aaaaaa.你为什么要破解我的代码aaaaad(aaaaas2.你为什么要破解我的代码aaaaaj());
        }
    }

    /*
     * WARNING - bad return control flow
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final aaaaas 你为什么要破解我的代码aaaaab(String string) {
        aaaaas aaaaas2;
        block24: {
            block29: {
                block26: {
                    block27: {
                        block23: {
                            block22: {
                                block25: {
                                    block28: {
                                        block21: {
                                            String string2 = string;
                                            switch (string2.hashCode()) {
                                                case 916506880: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)-995033084)))) {
                                                        return null;
                                                    }
                                                    break block21;
                                                }
                                                case 1912904869: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)300941317)))) {
                                                        return null;
                                                    }
                                                    break block22;
                                                }
                                                case 1121163920: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)-1681522682)))) {
                                                        return null;
                                                    }
                                                    break block23;
                                                }
                                                case 812766903: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)-239403001)))) {
                                                        return null;
                                                    }
                                                    break block24;
                                                }
                                                case 630370341: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)2077360136)))) {
                                                        return null;
                                                    }
                                                    break block25;
                                                }
                                                case 1943330462: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)441778185)))) {
                                                        return null;
                                                    }
                                                    break block26;
                                                }
                                                case 80702676: {
                                                    if (string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)489160714)))) break;
                                                    return null;
                                                }
                                                case 1902430713: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)-581959669)))) {
                                                        return null;
                                                    }
                                                    break block27;
                                                }
                                                case 657401329: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)-1507786740)))) {
                                                        return null;
                                                    }
                                                    break block28;
                                                }
                                                case 703077094: {
                                                    if (!string2.equals((Object)((String)PixelLiveGameServerMod.aaaaaf((char)-131661811)))) {
                                                        return null;
                                                    }
                                                    break block29;
                                                }
                                            }
                                            aaaaas2 = aaaabM.我草你怎么反编译我模组aaaadA;
                                            return aaaaas2;
                                        }
                                        aaaaas2 = aaaabv.我草你怎么反编译我模组aaaacL;
                                        return aaaaas2;
                                    }
                                    aaaaas2 = aaaaaP.我草你怎么反编译我模组aaaabK;
                                    return aaaaas2;
                                }
                                aaaaas2 = aaaacs.我草你怎么反编译我模组aaaaep;
                                return aaaaas2;
                            }
                            aaaaas2 = aaaadf.我草你怎么反编译我模组aaaaeK;
                            return aaaaas2;
                        }
                        aaaaas2 = aaaaad.我草你怎么反编译我模组aaaaaa;
                        return aaaaas2;
                    }
                    aaaaas2 = aaaabD.我草你怎么反编译我模组aaaacN;
                    return aaaaas2;
                }
                aaaaas2 = aaaaao.我草你怎么反编译我模组aaaabo;
                return aaaaas2;
            }
            aaaaas2 = aaaabH.我草你怎么反编译我模组aaaadh;
            return aaaaas2;
        }
        aaaaas2 = aaaabr.我草你怎么反编译我模组aaaacj;
        return aaaaas2;
        return null;
    }

    private final void 你为什么要破解我的代码aaaaac(Path path) {
        Path path2 = path.resolve((String)PixelLiveGameServerMod.aaaaaf((char)-1974403070));
        if (Files.exists((Path)path2, (LinkOption[])new LinkOption[0])) {
            try {
                String string = Files.readString((Path)path2);
                Gson gson = new Gson();
                JsonObject jsonObject = (JsonObject)gson.fromJson((Reader)new StringReader(string), JsonObject.class);
                if (jsonObject.has((String)PixelLiveGameServerMod.aaaaaf((char)2144600078))) {
                    String string2 = jsonObject.get((String)PixelLiveGameServerMod.aaaaaf((char)1201602574)).getAsString();
                    Path path3 = FabricLoader.getInstance().getGameDir().resolve((String)PixelLiveGameServerMod.aaaaaf((char)-1619853297));
                    File file = new File(path3.toFile(), string2);
                    if (file.exists() && file.isDirectory()) {
                        Path path4 = path;
                        Files.walkFileTree((Path)file.toPath(), (FileVisitor)((FileVisitor)new aaaaab(path4, file)));
                    }
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public static final /* synthetic */ boolean 你为什么要破解我的代码aaaaad() {
        return 我草你怎么反编译我模组aaaaab;
    }

    public static final /* synthetic */ void 你为什么要破解我的代码aaaaae(boolean bl) {
        我草你怎么反编译我模组aaaaab = bl;
    }

    static {
        byte[] byArray = " C±üÙÛ®hê\tYL´ÊÁ=\tøR(8ü· \\E]\fKÒè©1Ö`Sä?\b}ØÈÓà\r`P>ë!?äõ9 ÄüM£>ä{ÞÞ·°ïÊ`JÌNÜûÊ.VÂ&Ó&ñ6Y@G[61wüëÀ-kË±Âé>ò06©lÞ8áÌæÝ$6rn)6aGpä[O¤[IéÎcÆsLMä\b1l/y]VyP¾ÈC7pcEôÎ´ËHö>w²\bÐ0wù§7ºw½DFØ´àW¸¥&_Ö´æøüGÛ³x%ÛÓ§õ½íj Nå¬6|¶5a1|eêüOáÃÿ~".getBytes("ISO_8859_1");
        Object[] objectArray = "\nMgVßæ".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1802084882;
                case 1 -> 1527088078;
                case 2 -> 689291347;
                case 3 -> -1372690038;
                case 4 -> 1358854927;
                case 5 -> 129316469;
                case 6 -> -354901860;
                case 7 -> -1021099521;
                case 8 -> 1770896216;
                case 9 -> 1975481221;
                case 10 -> -1623037192;
                case 11 -> 5489074;
                case 12 -> 1958413404;
                case 13 -> -589233795;
                case 14 -> 1025870508;
                case 15 -> 771720118;
                case 16 -> -587218457;
                case 17 -> -1090881367;
                case 18 -> 9877781;
                case 19 -> -395214314;
                case 20 -> -1798193888;
                case 21 -> 1548234907;
                case 22 -> 1486684838;
                case 23 -> -1780438904;
                case 24 -> 697675548;
                case 25 -> -1717348019;
                case 26 -> -1754182895;
                case 27 -> -1250928539;
                case 28 -> 377792998;
                case 29 -> -1401739749;
                case 30 -> -224705759;
                case 31 -> -598542941;
                case 32 -> -681640685;
                case 33 -> -17808942;
                case 34 -> 1286855355;
                case 35 -> 1000199871;
                case 36 -> -9743001;
                case 37 -> 181143211;
                case 38 -> 1416866829;
                case 39 -> -763420661;
                case 40 -> -1679228331;
                case 41 -> 862989261;
                case 42 -> 775288986;
                case 43 -> -1568969692;
                case 44 -> -972502264;
                case 45 -> -1155346512;
                case 46 -> 1954484787;
                case 47 -> -1889387307;
                case 48 -> 1609545359;
                case 49 -> -1029297660;
                case 50 -> 1537173557;
                case 51 -> -1744458317;
                case 52 -> 779852381;
                case 53 -> 1219118366;
                case 54 -> 175804732;
                case 55 -> -390931698;
                case 56 -> 2126084574;
                case 57 -> 2027584436;
                case 58 -> 1225520544;
                case 59 -> -500308664;
                case 60 -> 913958618;
                case 61 -> 1622650073;
                case 62 -> -491193142;
                case 63 -> -1731357607;
                case 64 -> 57669349;
                case 65 -> -1643420742;
                case 66 -> 286976780;
                case 67 -> -461372622;
                case 68 -> -2012508242;
                case 69 -> -1899015568;
                case 70 -> -504836648;
                case 71 -> -851258843;
                case 72 -> 554174802;
                case 73 -> 1747446059;
                case 74 -> 1649152080;
                case 75 -> -1255224848;
                case 76 -> -1498126281;
                case 77 -> -926421846;
                case 78 -> -512707094;
                case 79 -> -220206171;
                case 80 -> 1636483138;
                case 81 -> 1979600750;
                case 82 -> 1842101448;
                case 83 -> -905946568;
                case 84 -> 251688516;
                case 85 -> 151960212;
                case 86 -> -895176589;
                case 87 -> -1790076451;
                case 88 -> 298936249;
                case 89 -> 663252814;
                case 90 -> 538145367;
                case 91 -> 450169362;
                case 92 -> -861648907;
                case 93 -> 743869419;
                case 94 -> 492154647;
                case 95 -> 295546754;
                case 96 -> 1057399156;
                case 97 -> -746597341;
                case 98 -> -705259686;
                case 99 -> -725448140;
                case 100 -> -1616684837;
                case 101 -> -415530816;
                case 102 -> 1551749130;
                case 103 -> -1402851647;
                case 104 -> 863934790;
                case 105 -> 761508893;
                case 106 -> -1290883535;
                case 107 -> 1576884297;
                case 108 -> -1523676563;
                case 109 -> -274356150;
                case 110 -> -1307891636;
                case 111 -> 1428660089;
                case 112 -> -1061667726;
                case 113 -> -1436898218;
                case 114 -> -1198019871;
                case 115 -> 2013957657;
                case 116 -> -1658019783;
                case 117 -> 1693740751;
                case 118 -> 2030770985;
                case 119 -> 40683089;
                case 120 -> -862354082;
                case 121 -> 1452955899;
                case 122 -> -1104621468;
                case 123 -> -1024200303;
                case 124 -> 1369365882;
                case 125 -> 423415611;
                case 126 -> 1136148962;
                case 127 -> 443653439;
                case 128 -> -2009539438;
                case 129 -> 1480504052;
                case 130 -> 2011735401;
                case 131 -> -1049077300;
                case 132 -> 1498653425;
                case 133 -> -1658558674;
                case 134 -> 1630332072;
                case 135 -> -831020538;
                case 136 -> 1858437540;
                case 137 -> 1337673603;
                case 138 -> -937528900;
                case 139 -> -1015910936;
                case 140 -> 1805198217;
                case 141 -> -685552650;
                case 142 -> -591657773;
                case 143 -> -1488094787;
                case 144 -> -1419704537;
                case 145 -> -514836702;
                case 146 -> -1270658193;
                case 147 -> -923819478;
                case 148 -> -1092473217;
                case 149 -> 2117514245;
                case 150 -> 1865610243;
                case 151 -> -1019225752;
                case 152 -> -855907089;
                case 153 -> -164820257;
                case 154 -> 2012529099;
                case 155 -> -2051959446;
                case 156 -> 2022637473;
                case 157 -> 122582942;
                case 158 -> -528122525;
                case 159 -> 1858718204;
                case 160 -> -1081668922;
                case 161 -> -1356116290;
                case 162 -> 1516961911;
                case 163 -> 705934485;
                case 164 -> 139207243;
                case 165 -> 1946113219;
                case 166 -> -425288596;
                case 167 -> -761385331;
                case 168 -> -636709588;
                case 169 -> -1773465057;
                case 170 -> 492084593;
                case 171 -> 2072981046;
                case 172 -> 1706650415;
                case 173 -> -129757771;
                case 174 -> -1534081672;
                case 175 -> 1793372032;
                case 176 -> 1904314577;
                case 177 -> 1465589315;
                case 178 -> 372890708;
                case 179 -> 341262743;
                case 180 -> -1958020871;
                case 181 -> -1671999075;
                case 182 -> -1967603416;
                case 183 -> -591143528;
                case 184 -> -933062293;
                case 185 -> 729222721;
                case 186 -> 1170840161;
                case 187 -> 1455934149;
                case 188 -> 899040583;
                case 189 -> -688883828;
                case 190 -> -2138959056;
                case 191 -> -2003651663;
                case 192 -> 1668157275;
                case 193 -> 776286208;
                case 194 -> 179419311;
                case 195 -> -1096797972;
                case 196 -> -495102881;
                case 197 -> -1687352946;
                case 198 -> -330043296;
                case 199 -> -397711237;
                case 200 -> -1005802864;
                case 201 -> 119420741;
                case 202 -> 1608850103;
                case 203 -> -1086023460;
                case 204 -> 1206509154;
                case 205 -> 2125536532;
                case 206 -> 1718864890;
                case 207 -> 1662618502;
                case 208 -> 1228645538;
                case 209 -> -1417101049;
                case 210 -> -261013517;
                case 211 -> 1266642052;
                case 212 -> -32859464;
                case 213 -> 1690861885;
                case 214 -> -1596822537;
                case 215 -> -1071812449;
                case 216 -> -2146845293;
                case 217 -> -2085445056;
                case 218 -> -1387964419;
                case 219 -> 2021471334;
                case 220 -> -448492074;
                case 221 -> -1600997887;
                case 222 -> 1414828802;
                case 223 -> -876679029;
                case 224 -> 2096715032;
                case 225 -> -455994894;
                case 226 -> -74645820;
                case 227 -> 1794947088;
                case 228 -> -464882114;
                case 229 -> -1912358658;
                case 230 -> -765969282;
                case 231 -> 338262396;
                case 232 -> -270951386;
                case 233 -> -1466396793;
                case 234 -> 75527689;
                case 235 -> -487753299;
                case 236 -> -150193214;
                case 237 -> 1992530767;
                case 238 -> 796417082;
                case 239 -> -624202982;
                case 240 -> -2081896063;
                case 241 -> -1541295136;
                case 242 -> 701265879;
                case 243 -> 1190557924;
                case 244 -> 728789968;
                case 245 -> 3601270;
                case 246 -> -623820567;
                case 247 -> 2045953325;
                case 248 -> -967742041;
                case 249 -> -469256042;
                case 250 -> 603166105;
                case 251 -> 111103469;
                case 252 -> 352975049;
                case 253 -> 2033848803;
                case 254 -> -616073785;
                case 255 -> -2032064556;
                default -> 1028967419;
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
            Object[] objectArray2 = new Object[16];
            objectArray = objectArray2;
            aaaaac = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaa = new aaaaaa(null);
    }

    private static Object aaaaaf(char c) {
        return ((Object[])aaaaac)[c];
    }
}

