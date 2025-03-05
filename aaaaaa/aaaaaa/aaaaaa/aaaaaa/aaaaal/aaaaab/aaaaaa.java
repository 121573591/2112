/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.List
 *  java.util.concurrent.CopyOnWriteArrayList
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_327$class_6415
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_757
 *  net.minecraft.class_7833
 *  org.joml.Matrix4f
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaab;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaab.aaaaab;
import cn.pixellive.mc.game.PixelLiveGameMod;
import com.mojang.blaze3d.systems.RenderSystem;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import org.joml.Matrix4f;

@Environment(value=EnvType.CLIENT)
public class aaaaaa {
    private final List<aaaaab> 我草你怎么反编译我模组aaaaaa = new CopyOnWriteArrayList();
    private static aaaaaa 我草你怎么反编译我模组aaaaab;
    private static final float 我草你怎么反编译我模组aaaaac;
    private static final float 我草你怎么反编译我模组aaaaad;
    private static final float 我草你怎么反编译我模组aaaaae;
    private static final float 我草你怎么反编译我模组aaaaaf;
    private static final int 我草你怎么反编译我模组aaaaag;
    private static final float 我草你怎么反编译我模组aaaaah;
    private static final int 我草你怎么反编译我模组aaaaai;
    static Object aaaaaj;

    public static aaaaaa 你为什么要破解我的代码aaaaaa() {
        if (我草你怎么反编译我模组aaaaab == null) {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaaa.aaaaai((char)-407437312));
            我草你怎么反编译我模组aaaaab = new aaaaaa();
        }
        return 我草你怎么反编译我模组aaaaab;
    }

    public void 你为什么要破解我的代码aaaaab(aaaaab aaaaab2) {
        if (PixelLiveGameMod.你为什么要破解我的代码aaaaaR() == null) {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaaa.aaaaai((char)-278462463));
            return;
        }
        if (aaaaab2 == null || aaaaab2.我草你怎么反编译我模组aaaaab == null) {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().warn((String)aaaaaa.aaaaai((char)-927268862));
            return;
        }
        try {
            this.我草你怎么反编译我模组aaaaaa.add((Object)aaaaab2);
            if (aaaaab2.我草你怎么反编译我模组aaaaae) {
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaaa.aaaaaa.你为什么要破解我的代码aaaaab();
            } else {
                aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaal.aaaaaa.aaaaaa.你为什么要破解我的代码aaaaaa();
            }
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaan.aaaaab.你为什么要破解我的代码aaaaab();
        }
        catch (Exception exception) {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().error((String)aaaaaa.aaaaai((char)2021326851), (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void 你为什么要破解我的代码aaaaac(class_4587 class_45872, class_4184 class_41842, float f) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1687 == null) {
            return;
        }
        class_327 class_3272 = class_3102.field_1772;
        class_4597.class_4598 class_45982 = class_3102.method_22940().method_23000();
        long l = System.currentTimeMillis();
        this.我草你怎么反编译我模组aaaaaa.removeIf(aaaaab2 -> l > aaaaab2.我草你怎么反编译我模组aaaaac);
        if (!this.我草你怎么反编译我模组aaaaaa.isEmpty()) {
            this.你为什么要破解我的代码aaaaad();
            try {
                for (aaaaab aaaaab3 : this.我草你怎么反编译我模组aaaaaa) {
                    class_45872.method_22903();
                    try {
                        float f2;
                        double d = aaaaab3.我草你怎么反编译我模组aaaaab.field_1352 - class_41842.method_19326().field_1352;
                        double d2 = aaaaab3.我草你怎么反编译我模组aaaaab.field_1351 - class_41842.method_19326().field_1351;
                        double d3 = aaaaab3.我草你怎么反编译我模组aaaaab.field_1350 - class_41842.method_19326().field_1350;
                        float f3 = (float)(l - aaaaab3.我草你怎么反编译我模组aaaaad) / 2000.0f;
                        float f4 = 1.0f - f3;
                        float f5 = 0.5f * f3;
                        class_45872.method_22904(d, d2 += (double)f5, d3);
                        class_45872.method_22907(class_41842.method_23767());
                        class_45872.method_22907(class_7833.field_40714.rotationDegrees(180.0f));
                        double d4 = Math.sqrt((double)(d * d + d2 * d2 + d3 * d3));
                        if (d4 <= 5.0) {
                            f2 = 0.03f;
                        } else if (d4 >= 20.0) {
                            f2 = 0.065f;
                        } else {
                            float f6 = (float)(d4 - 5.0) / 15.0f;
                            f2 = 0.03f + f6 * 0.034999996f;
                        }
                        class_45872.method_22905(f2, f2, f2);
                        String string = String.format((String)((String)aaaaaa.aaaaai((char)48300036)), (Object[])new Object[]{Float.valueOf((float)aaaaab3.我草你怎么反编译我模组aaaaaa)});
                        float f7 = class_3272.method_1727(string);
                        Matrix4f matrix4f = class_45872.method_23760().method_23761();
                        int n = (int)(f4 * 255.0f) << 24 | 0xFFFFFFFF;
                        class_3272.method_27521(string, -f7 / 2.0f, 0.0f, n, false, matrix4f, (class_4597)class_45982, class_327.class_6415.field_33993, 0, 0xF000F0);
                    }
                    finally {
                        class_45872.method_22909();
                    }
                }
                class_45982.method_22993();
            }
            finally {
                this.你为什么要破解我的代码aaaaae();
            }
        }
    }

    private void 你为什么要破解我的代码aaaaad() {
        RenderSystem.getModelViewStack().pushMatrix();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.setShader(class_757::method_34540);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    private void 你为什么要破解我的代码aaaaae() {
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.getModelViewStack().popMatrix();
        RenderSystem.applyModelViewMatrix();
    }

    public static void 你为什么要破解我的代码aaaaaf() {
        aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaaa.aaaaai((char)-1412169723));
        try {
            WorldRenderEvents.AFTER_ENTITIES.register(worldRenderContext -> {
                RenderSystem.getModelViewStack().pushMatrix();
                try {
                    aaaaaa.你为什么要破解我的代码aaaaaa().你为什么要破解我的代码aaaaac(worldRenderContext.matrixStack(), worldRenderContext.camera(), 0.2f);
                }
                finally {
                    RenderSystem.getModelViewStack().popMatrix();
                    RenderSystem.applyModelViewMatrix();
                }
            });
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().info((String)aaaaaa.aaaaai((char)-235143162));
        }
        catch (Exception exception) {
            aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab.你为什么要破解我的代码aaaaaa().error((String)aaaaaa.aaaaai((char)1555628039), (Throwable)exception);
            throw new RuntimeException((String)aaaaaa.aaaaai((char)591986696), (Throwable)exception);
        }
    }

    static {
        byte[] byArray = "óßßÇ¸ªv,B×ß#a;6rÅÐ5¥bÑÄÑoÙ\tJj\n]$fº¬ÍaA)tp«hf÷LàûZ}ïäå[£ÔN9ð)6¡l§±ïLÀí¶ý0ß{-íà,É+´é @_ÄX­G7S\nXb-*\fÓ¥Èi^çgã¤=ÑÎ·wäÖs9î> ÚÌ½yÝôÀ\\[ê®_æ¦:gô\f\rFçjk &&OðÄçRj´ìO¿uå ¤iY\thËáLJ1Ýæ@£Î¬höX¯#{¹%B-cHêá¤ ±.§«çãwâAZ'ùmµç{Ô@Eµ])-ô×0£¸,Ä»±îÄ\n\"QJXeÊ½/ Ä<¼t!Qá/ôwý£)ÕTìà:é²Ó^9þ%X³\r]î\\1ÏC´x_øÈòiÑ DNG_Ìt,Ä\".{0´çñh¬NG\\ÐM\bèkwL:,ÕlÝæIÏKÔStX<_JV´6-HâØ¦$³n'£X¼=QùÇaJ¤Z0Á¨ ò".getBytes("ISO_8859_1");
        Object[] objectArray = "ê~uRÛ".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> -1194776189;
                case 1 -> -884011666;
                case 2 -> 1999866381;
                case 3 -> 189050633;
                case 4 -> 958807715;
                case 5 -> -549890603;
                case 6 -> -434724622;
                case 7 -> 990922347;
                case 8 -> -1490930249;
                case 9 -> 593590796;
                case 10 -> 456726239;
                case 11 -> 945600898;
                case 12 -> -1775506280;
                case 13 -> 1825735342;
                case 14 -> 1406417374;
                case 15 -> -1444127256;
                case 16 -> 1148445655;
                case 17 -> -147930080;
                case 18 -> 551369363;
                case 19 -> 843678748;
                case 20 -> -1781272850;
                case 21 -> 1867610451;
                case 22 -> 75287816;
                case 23 -> 1834244510;
                case 24 -> 159902469;
                case 25 -> -358149799;
                case 26 -> 292972959;
                case 27 -> -1071746218;
                case 28 -> -1883597098;
                case 29 -> -2122072838;
                case 30 -> 428502357;
                case 31 -> 0x9914991;
                case 32 -> 143048468;
                case 33 -> -516683214;
                case 34 -> -522351273;
                case 35 -> -896870700;
                case 36 -> -1086419095;
                case 37 -> -738493404;
                case 38 -> -31242955;
                case 39 -> -1863438412;
                case 40 -> -1748001792;
                case 41 -> -1645119858;
                case 42 -> -521124638;
                case 43 -> -119811084;
                case 44 -> 708042312;
                case 45 -> -705891160;
                case 46 -> 1953824805;
                case 47 -> 1008725585;
                case 48 -> 1313666370;
                case 49 -> -2051810359;
                case 50 -> -63968372;
                case 51 -> 941810070;
                case 52 -> -762828144;
                case 53 -> 1420483160;
                case 54 -> -852886606;
                case 55 -> -527775710;
                case 56 -> 1182738588;
                case 57 -> 143602525;
                case 58 -> 273119277;
                case 59 -> -159199923;
                case 60 -> 28467275;
                case 61 -> 9688819;
                case 62 -> -1537062761;
                case 63 -> 1820817012;
                case 64 -> 1253541082;
                case 65 -> 2093985838;
                case 66 -> -796776919;
                case 67 -> 1524979376;
                case 68 -> -1106796675;
                case 69 -> -1904012319;
                case 70 -> -1025867999;
                case 71 -> -1274429829;
                case 72 -> -1573019152;
                case 73 -> -1047096125;
                case 74 -> -813897056;
                case 75 -> -946121978;
                case 76 -> -1555073153;
                case 77 -> -1122641959;
                case 78 -> 757752541;
                case 79 -> 38448670;
                case 80 -> -1269235094;
                case 81 -> -745730193;
                case 82 -> 782026265;
                case 83 -> -2069271238;
                case 84 -> 1764849679;
                case 85 -> 1566061578;
                case 86 -> -29012765;
                case 87 -> 391664656;
                case 88 -> -1686564251;
                case 89 -> -1705035247;
                case 90 -> -116139073;
                case 91 -> -2067569073;
                case 92 -> 1532366729;
                case 93 -> 514507723;
                case 94 -> 1705409331;
                case 95 -> 1923945792;
                case 96 -> 267740864;
                case 97 -> -1712252507;
                case 98 -> 1602181968;
                case 99 -> -700976148;
                case 100 -> -397100956;
                case 101 -> 1173581372;
                case 102 -> 80943436;
                case 103 -> 238061594;
                case 104 -> -954181957;
                case 105 -> -562058216;
                case 106 -> -530039435;
                case 107 -> 2001675695;
                case 108 -> 902395732;
                case 109 -> -1469361948;
                case 110 -> -216259196;
                case 111 -> -146543542;
                case 112 -> -2136612414;
                case 113 -> 1864375222;
                case 114 -> -382677786;
                case 115 -> -203595897;
                case 116 -> 1496034396;
                case 117 -> 983277415;
                case 118 -> -506845861;
                case 119 -> -2051267332;
                case 120 -> -2123307715;
                case 121 -> -833690861;
                case 122 -> -1573322628;
                case 123 -> 1745673986;
                case 124 -> 1849699679;
                case 125 -> 1146858204;
                case 126 -> 907847294;
                case 127 -> 1256933397;
                case 128 -> 680568162;
                case 129 -> -1803477127;
                case 130 -> 1749264381;
                case 131 -> 1117772086;
                case 132 -> 1161869612;
                case 133 -> -756947341;
                case 134 -> 1908903586;
                case 135 -> 891013269;
                case 136 -> -1613192669;
                case 137 -> -51782234;
                case 138 -> -328833946;
                case 139 -> 1731010247;
                case 140 -> -871189894;
                case 141 -> 1379535233;
                case 142 -> -304593873;
                case 143 -> -836821785;
                case 144 -> 1731509313;
                case 145 -> 1357217203;
                case 146 -> 319714167;
                case 147 -> 521753482;
                case 148 -> -1490604502;
                case 149 -> 1337079030;
                case 150 -> -1087595330;
                case 151 -> -305003658;
                case 152 -> -1628721154;
                case 153 -> 2059218128;
                case 154 -> 1910786272;
                case 155 -> -1639007163;
                case 156 -> -1478600904;
                case 157 -> 1192310813;
                case 158 -> -1763336821;
                case 159 -> -1279765701;
                case 160 -> -2109090312;
                case 161 -> -1397463694;
                case 162 -> -1147667791;
                case 163 -> -1091201991;
                case 164 -> -276294264;
                case 165 -> 78109082;
                case 166 -> -1803546074;
                case 167 -> 487742397;
                case 168 -> 2037267496;
                case 169 -> -174946354;
                case 170 -> 2145417921;
                case 171 -> -38866121;
                case 172 -> -1755574199;
                case 173 -> -1769001044;
                case 174 -> 1249701253;
                case 175 -> 386782668;
                case 176 -> -2043407672;
                case 177 -> -803571811;
                case 178 -> 1698144862;
                case 179 -> -1374402273;
                case 180 -> -1492976370;
                case 181 -> -5893077;
                case 182 -> -1446806160;
                case 183 -> 2129945443;
                case 184 -> -1787669247;
                case 185 -> 924997865;
                case 186 -> 1763510681;
                case 187 -> -713201759;
                case 188 -> -57982991;
                case 189 -> -551576395;
                case 190 -> 589785184;
                case 191 -> 477732934;
                case 192 -> 1795940079;
                case 193 -> -1942139284;
                case 194 -> -1024870913;
                case 195 -> 407836163;
                case 196 -> -1981623598;
                case 197 -> 129279510;
                case 198 -> 297568062;
                case 199 -> 1149944900;
                case 200 -> 1955181711;
                case 201 -> -1423356121;
                case 202 -> -1132556265;
                case 203 -> -1403765196;
                case 204 -> -181367606;
                case 205 -> -1849002298;
                case 206 -> 1810006625;
                case 207 -> 2101465767;
                case 208 -> -885410447;
                case 209 -> -663547653;
                case 210 -> 861386318;
                case 211 -> 1357096070;
                case 212 -> 984000831;
                case 213 -> 1277190389;
                case 214 -> -869120278;
                case 215 -> 769545892;
                case 216 -> 336301738;
                case 217 -> -704515867;
                case 218 -> 2077134226;
                case 219 -> -472634419;
                case 220 -> 1739107525;
                case 221 -> -1898542544;
                case 222 -> 515327047;
                case 223 -> 535149575;
                case 224 -> -1197081262;
                case 225 -> 1283326396;
                case 226 -> 261402458;
                case 227 -> 1216459947;
                case 228 -> -396456519;
                case 229 -> 1558164251;
                case 230 -> -1575056933;
                case 231 -> 1489840570;
                case 232 -> 711879108;
                case 233 -> -457039656;
                case 234 -> -944658035;
                case 235 -> -60522583;
                case 236 -> 705640365;
                case 237 -> 1882198456;
                case 238 -> 2009438482;
                case 239 -> -1647382168;
                case 240 -> 2105330843;
                case 241 -> -523496753;
                case 242 -> 1636663700;
                case 243 -> -486724627;
                case 244 -> -2049157523;
                case 245 -> 1161511159;
                case 246 -> -1328337965;
                case 247 -> -976382415;
                case 248 -> -1363811068;
                case 249 -> -1076052725;
                case 250 -> -1244524168;
                case 251 -> -1994966575;
                case 252 -> -2135329031;
                case 253 -> 2056469227;
                case 254 -> -1581014717;
                case 255 -> -681158784;
                default -> 1434829397;
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
            Object[] objectArray2 = new Object[9];
            objectArray = objectArray2;
            aaaaaj = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaai = -1;
        我草你怎么反编译我模组aaaaah = 0.5f;
        我草你怎么反编译我模组aaaaag = 2000;
        我草你怎么反编译我模组aaaaaf = 20.0f;
        我草你怎么反编译我模组aaaaae = 5.0f;
        我草你怎么反编译我模组aaaaad = 0.065f;
        我草你怎么反编译我模组aaaaac = 0.03f;
    }

    private static Object aaaaai(char c) {
        return ((Object[])aaaaaj)[c];
    }
}

