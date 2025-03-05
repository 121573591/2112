/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.google.gson.JsonPrimitive
 *  com.google.gson.JsonSyntaxException
 *  java.io.File
 *  java.io.FileReader
 *  java.io.FileWriter
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.Appendable
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.nio.charset.StandardCharsets
 *  java.nio.file.Files
 *  java.nio.file.Path
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  javax.crypto.Cipher
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.IvParameterSpec
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.loader.api.FabricLoader
 */
package aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaak;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

public class aaaaaa {
    private static final Gson 我草你怎么反编译我模组aaaaaa;
    static Object aaaaab;

    public static String 你为什么要破解我的代码aaaaaa(Path path) {
        try {
            File file = new File(path.toFile(), (String)aaaaaa.aaaaag((char)-1556742144));
            String string = Files.readString((Path)file.toPath(), (Charset)StandardCharsets.UTF_8);
            JsonObject jsonObject = (JsonObject)我草你怎么反编译我模组aaaaaa.fromJson(string, JsonObject.class);
            JsonElement jsonElement = jsonObject.get((String)aaaaaa.aaaaag((char)-1872822271));
            return jsonElement != null ? jsonElement.getAsString() : null;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static HashMap<String, Object> 你为什么要破解我的代码aaaaab(Path path) {
        Iterator iterator;
        File file = new File(path.toFile(), (String)aaaaaa.aaaaag((char)23265280)).getAbsoluteFile();
        FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
        try {
            JsonObject jsonObject = JsonParser.parseReader((Reader)fileReader).getAsJsonObject();
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (((JsonElement)entry.getValue()).isJsonPrimitive()) {
                    JsonPrimitive jsonPrimitive = ((JsonElement)entry.getValue()).getAsJsonPrimitive();
                    if (jsonPrimitive.isString()) {
                        hashMap.put((Object)((String)entry.getKey()), (Object)jsonPrimitive.getAsString());
                        continue;
                    }
                    if (jsonPrimitive.isNumber()) {
                        hashMap.put((Object)((String)entry.getKey()), (Object)jsonPrimitive.getAsNumber());
                        continue;
                    }
                    if (!jsonPrimitive.isBoolean()) continue;
                    hashMap.put((Object)((String)entry.getKey()), (Object)jsonPrimitive.getAsBoolean());
                    continue;
                }
                if (!((JsonElement)entry.getValue()).isJsonObject()) continue;
                hashMap.put((Object)((String)entry.getKey()), (Object)((JsonElement)entry.getValue()).getAsJsonObject());
            }
            iterator = hashMap;
        }
        catch (Throwable throwable) {
            try {
                try {
                    fileReader.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                return null;
            }
        }
        fileReader.close();
        return iterator;
    }

    @Environment(value=EnvType.SERVER)
    public static HashMap<String, Object> 你为什么要破解我的代码aaaaac() {
        Iterator iterator;
        File file = new File(FabricLoader.getInstance().getConfigDir().toAbsolutePath().toFile(), (String)aaaaaa.aaaaag((char)1394868224)).getAbsoluteFile();
        FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
        try {
            JsonObject jsonObject = JsonParser.parseReader((Reader)fileReader).getAsJsonObject();
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (((JsonElement)entry.getValue()).isJsonPrimitive()) {
                    JsonPrimitive jsonPrimitive = ((JsonElement)entry.getValue()).getAsJsonPrimitive();
                    if (jsonPrimitive.isString()) {
                        hashMap.put((Object)((String)entry.getKey()), (Object)jsonPrimitive.getAsString());
                        continue;
                    }
                    if (jsonPrimitive.isNumber()) {
                        hashMap.put((Object)((String)entry.getKey()), (Object)jsonPrimitive.getAsNumber());
                        continue;
                    }
                    if (!jsonPrimitive.isBoolean()) continue;
                    hashMap.put((Object)((String)entry.getKey()), (Object)jsonPrimitive.getAsBoolean());
                    continue;
                }
                if (!((JsonElement)entry.getValue()).isJsonObject()) continue;
                hashMap.put((Object)((String)entry.getKey()), (Object)((JsonElement)entry.getValue()).getAsJsonObject());
            }
            iterator = hashMap;
        }
        catch (Throwable throwable) {
            try {
                try {
                    fileReader.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                return null;
            }
        }
        fileReader.close();
        return iterator;
    }

    public static void 你为什么要破解我的代码aaaaad(Path path, String string, Object object) {
        try {
            File file = new File(path.toFile(), (String)aaaaaa.aaaaag((char)1469906944)).getAbsoluteFile();
            String string2 = Files.readString((Path)file.toPath(), (Charset)StandardCharsets.UTF_8);
            JsonObject jsonObject = JsonParser.parseString((String)string2).getAsJsonObject();
            if (object instanceof String) {
                jsonObject.addProperty(string, (String)object);
            } else if (object instanceof Number) {
                jsonObject.addProperty(string, (Number)object);
            } else if (object instanceof Boolean) {
                jsonObject.addProperty(string, (Boolean)object);
            } else if (object instanceof JsonObject) {
                jsonObject.add(string, (JsonElement)((JsonObject)object));
            } else {
                throw new IllegalArgumentException("不支持的值类型: " + String.valueOf((Object)object.getClass()));
            }
            try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8);){
                我草你怎么反编译我模组aaaaaa.toJson((JsonElement)jsonObject, (Appendable)fileWriter);
            }
        }
        catch (JsonSyntaxException | IOException throwable) {
            // empty catch block
        }
    }

    public static void 你为什么要破解我的代码aaaaae(Path path, Map<String, Object> map) {
        try {
            Map.Entry entry2;
            File file = new File(path.toFile(), (String)aaaaaa.aaaaag((char)-1688141824)).getAbsoluteFile();
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry2 : map.entrySet()) {
                Object object = entry2.getValue();
                if (object instanceof String) {
                    jsonObject.addProperty((String)entry2.getKey(), (String)object);
                    continue;
                }
                if (object instanceof Number) {
                    jsonObject.addProperty((String)entry2.getKey(), (Number)object);
                    continue;
                }
                if (object instanceof Boolean) {
                    jsonObject.addProperty((String)entry2.getKey(), (Boolean)object);
                    continue;
                }
                if (!(object instanceof JsonObject)) continue;
                jsonObject.add((String)entry2.getKey(), (JsonElement)((JsonObject)object));
            }
            Iterator iterator = file.getParentFile();
            if (!iterator.exists() && !iterator.mkdirs()) {
                throw new IOException("Failed to create directory: " + String.valueOf((Object)iterator));
            }
            entry2 = new FileWriter(file, StandardCharsets.UTF_8);
            try {
                我草你怎么反编译我模组aaaaaa.toJson((JsonElement)jsonObject, (Appendable)entry2);
            }
            finally {
                entry2.close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static boolean 你为什么要破解我的代码aaaaaf(Path path) {
        try {
            File file = new File(path.toFile(), (String)aaaaaa.aaaaag((char)1820459008)).getAbsoluteFile();
            if (!file.exists()) {
                return false;
            }
            String string = Files.readString((Path)file.toPath(), (Charset)StandardCharsets.UTF_8);
            JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
            return jsonObject.has((String)aaaaaa.aaaaag((char)-82575359));
        }
        catch (Exception exception) {
            return false;
        }
    }

    static {
        byte[] byArray = "ÙZwÐµAT]{LN-_ÙV(é~N¼þ6iÇ0öE$¾\\Ûòá¥_}#ÔY¤L%ØH¨è¸?Ý®Ü".getBytes("ISO_8859_1");
        Object[] objectArray = ".kàö!¥".getBytes("ISO_8859_1");
        int n = 0;
        int n2 = byArray.length;
        do {
            byArray[n++] = (byte)(switch (byArray[n] & 0xFF) {
                case 0 -> 1596066631;
                case 1 -> -469034055;
                case 2 -> 1691771556;
                case 3 -> 1080441789;
                case 4 -> -62275009;
                case 5 -> -1560060924;
                case 6 -> -1140571295;
                case 7 -> -1218169992;
                case 8 -> -1015697384;
                case 9 -> -959100983;
                case 10 -> 2052262097;
                case 11 -> -797001442;
                case 12 -> 128658664;
                case 13 -> -845564698;
                case 14 -> -640667912;
                case 15 -> 1572669509;
                case 16 -> -2001275769;
                case 17 -> 913347736;
                case 18 -> -2034537549;
                case 19 -> 1536973901;
                case 20 -> -2123105921;
                case 21 -> 920950590;
                case 22 -> -1946536086;
                case 23 -> 984268068;
                case 24 -> -270421848;
                case 25 -> -1018663162;
                case 26 -> 1760027482;
                case 27 -> 1780795401;
                case 28 -> -1982591653;
                case 29 -> -1770579600;
                case 30 -> -892141636;
                case 31 -> 2014432330;
                case 32 -> 822446608;
                case 33 -> 841070231;
                case 34 -> -1304355055;
                case 35 -> 589103058;
                case 36 -> 1928718144;
                case 37 -> -1603615883;
                case 38 -> 1176385954;
                case 39 -> -1289636002;
                case 40 -> 713455906;
                case 41 -> -348662429;
                case 42 -> 1032658698;
                case 43 -> 1917575860;
                case 44 -> 1290745867;
                case 45 -> -224388504;
                case 46 -> 1617095246;
                case 47 -> 1091382536;
                case 48 -> 1203102779;
                case 49 -> 1265580888;
                case 50 -> -290505072;
                case 51 -> -1103460366;
                case 52 -> -1140655058;
                case 53 -> -1374062107;
                case 54 -> -716192887;
                case 55 -> 296552691;
                case 56 -> 1531331940;
                case 57 -> -420015887;
                case 58 -> 11358501;
                case 59 -> -33794534;
                case 60 -> -606654258;
                case 61 -> 661272028;
                case 62 -> 866485079;
                case 63 -> -728230385;
                case 64 -> 2019255091;
                case 65 -> -1644934631;
                case 66 -> -544484533;
                case 67 -> 1374225124;
                case 68 -> -461368727;
                case 69 -> -1099689241;
                case 70 -> 794388576;
                case 71 -> 1283044799;
                case 72 -> -1422320895;
                case 73 -> 487589632;
                case 74 -> -338484226;
                case 75 -> -1112389927;
                case 76 -> 1082322179;
                case 77 -> -85127639;
                case 78 -> -186533137;
                case 79 -> -1414448268;
                case 80 -> -791496010;
                case 81 -> 84099062;
                case 82 -> -1378890071;
                case 83 -> 1165982041;
                case 84 -> -986546420;
                case 85 -> -2140703885;
                case 86 -> 316562067;
                case 87 -> 1820603005;
                case 88 -> -1296244210;
                case 89 -> 2105131744;
                case 90 -> -287315097;
                case 91 -> 2063135789;
                case 92 -> -922294320;
                case 93 -> 1238777939;
                case 94 -> 1133472645;
                case 95 -> 1450009746;
                case 96 -> -79428320;
                case 97 -> 1759937541;
                case 98 -> -413168519;
                case 99 -> 2053980187;
                case 100 -> -439147694;
                case 101 -> -506995077;
                case 102 -> 1540096841;
                case 103 -> 1230156573;
                case 104 -> -1951830700;
                case 105 -> -937214518;
                case 106 -> 805713039;
                case 107 -> 1937382220;
                case 108 -> 1325016904;
                case 109 -> -103733088;
                case 110 -> -378867389;
                case 111 -> -156515279;
                case 112 -> 1019795191;
                case 113 -> 502618325;
                case 114 -> 1841785713;
                case 115 -> 467879905;
                case 116 -> -972720282;
                case 117 -> -656227748;
                case 118 -> -1756393334;
                case 119 -> -404522110;
                case 120 -> 413700450;
                case 121 -> -875417139;
                case 122 -> -1081584531;
                case 123 -> -696175563;
                case 124 -> 1648318994;
                case 125 -> -1786594112;
                case 126 -> 1099739284;
                case 127 -> 276710262;
                case 128 -> -1447672812;
                case 129 -> 1920771394;
                case 130 -> -851682159;
                case 131 -> -344888895;
                case 132 -> -1842176263;
                case 133 -> -165376774;
                case 134 -> -1068530747;
                case 135 -> -1311822904;
                case 136 -> 313666901;
                case 137 -> 1515580908;
                case 138 -> -130353556;
                case 139 -> -369963348;
                case 140 -> -130948697;
                case 141 -> 521753656;
                case 142 -> -729503255;
                case 143 -> -2059022163;
                case 144 -> 1082850958;
                case 145 -> -931410132;
                case 146 -> -1797231621;
                case 147 -> 798473195;
                case 148 -> 88635193;
                case 149 -> -355305554;
                case 150 -> 1298743319;
                case 151 -> -107014528;
                case 152 -> -1381219704;
                case 153 -> -284287466;
                case 154 -> 1170977105;
                case 155 -> -1682449745;
                case 156 -> -2143888575;
                case 157 -> -428834705;
                case 158 -> 1920600589;
                case 159 -> -830295210;
                case 160 -> -595502972;
                case 161 -> -667581557;
                case 162 -> -1991550230;
                case 163 -> -1454645713;
                case 164 -> 2019339087;
                case 165 -> 1910004097;
                case 166 -> -109927994;
                case 167 -> -2124968841;
                case 168 -> -449905763;
                case 169 -> 1153802974;
                case 170 -> 1238077873;
                case 171 -> -2070085766;
                case 172 -> 2125610133;
                case 173 -> 1875432391;
                case 174 -> 1414446369;
                case 175 -> -849814785;
                case 176 -> 818240665;
                case 177 -> -124484168;
                case 178 -> -900257917;
                case 179 -> 896684051;
                case 180 -> 1630780314;
                case 181 -> 1202354359;
                case 182 -> -276855513;
                case 183 -> -130667468;
                case 184 -> -1033058645;
                case 185 -> 1474386728;
                case 186 -> -1736594211;
                case 187 -> -1582963753;
                case 188 -> 257940389;
                case 189 -> -1206667774;
                case 190 -> 214366419;
                case 191 -> -1010292084;
                case 192 -> 1028578174;
                case 193 -> -1973123595;
                case 194 -> 1160815066;
                case 195 -> -11814722;
                case 196 -> -1062464080;
                case 197 -> 507204676;
                case 198 -> 1131109870;
                case 199 -> -1532742222;
                case 200 -> 742284343;
                case 201 -> -1847395843;
                case 202 -> -2039893985;
                case 203 -> 1221886683;
                case 204 -> -267354465;
                case 205 -> 1674787186;
                case 206 -> 1387580867;
                case 207 -> 1285082923;
                case 208 -> -295731875;
                case 209 -> -480318220;
                case 210 -> 195820255;
                case 211 -> 1758869830;
                case 212 -> 1108156875;
                case 213 -> -1174045126;
                case 214 -> -538525282;
                case 215 -> -1352870094;
                case 216 -> 307418463;
                case 217 -> 457167111;
                case 218 -> -1078824037;
                case 219 -> 509901755;
                case 220 -> -188026430;
                case 221 -> -1517429290;
                case 222 -> -316162860;
                case 223 -> 1727762337;
                case 224 -> -677064880;
                case 225 -> 1443605034;
                case 226 -> 1776112124;
                case 227 -> 237158872;
                case 228 -> 205147709;
                case 229 -> -1524014644;
                case 230 -> 1393097668;
                case 231 -> -993558803;
                case 232 -> 75740956;
                case 233 -> -1869896400;
                case 234 -> -1573878558;
                case 235 -> 259678243;
                case 236 -> 105975978;
                case 237 -> -388600164;
                case 238 -> 1252015979;
                case 239 -> -354544669;
                case 240 -> 1006523260;
                case 241 -> 863374031;
                case 242 -> -755677675;
                case 243 -> -2002887952;
                case 244 -> -2050348490;
                case 245 -> 631183270;
                case 246 -> 577084261;
                case 247 -> 25569084;
                case 248 -> -2024994653;
                case 249 -> -1745388762;
                case 250 -> -1823426410;
                case 251 -> -1756953210;
                case 252 -> 201906869;
                case 253 -> -1897412467;
                case 254 -> -1941480006;
                case 255 -> -84721810;
                default -> -756574814;
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
            aaaaab = objectArray2;
            n2 = n;
            n = 0;
            do {
                n3 = byArray[n++] & 0xFF | (byArray[n++] & 0xFF) << 8;
                byte[] byArray2 = new byte[n3];
                System.arraycopy((Object)byArray, (int)n, (Object)byArray2, (int)0, (int)n3);
                objectArray[n5++] = (byte)new String(byArray2, "UTF-8").intern();
            } while ((n += n3) != n2);
        }
        我草你怎么反编译我模组aaaaaa = new GsonBuilder().setPrettyPrinting().create();
    }

    private static Object aaaaag(char c) {
        return ((Object[])aaaaab)[c];
    }
}

