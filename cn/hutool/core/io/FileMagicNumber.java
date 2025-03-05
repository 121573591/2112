/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Arrays
 *  java.util.Objects
 */
package cn.hutool.core.io;

import cn.hutool.core.util.ArrayUtil;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

public enum FileMagicNumber {
    UNKNOWN(null, null){

        @Override
        public boolean match(byte[] bytes) {
            return false;
        }
    }
    ,
    JPEG("image/jpeg", "jpg"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 2 && Objects.equals((Object)bytes[0], (Object)-1) && Objects.equals((Object)bytes[1], (Object)-40) && Objects.equals((Object)bytes[2], (Object)-1);
        }
    }
    ,
    JXR("image/vnd.ms-photo", "jxr"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 2 && Objects.equals((Object)bytes[0], (Object)73) && Objects.equals((Object)bytes[1], (Object)73) && Objects.equals((Object)bytes[2], (Object)-68);
        }
    }
    ,
    APNG("image/apng", "apng"){

        @Override
        public boolean match(byte[] bytes) {
            boolean b;
            boolean bl = b = bytes.length > 8 && Objects.equals((Object)bytes[0], (Object)-119) && Objects.equals((Object)bytes[1], (Object)80) && Objects.equals((Object)bytes[2], (Object)78) && Objects.equals((Object)bytes[3], (Object)71) && Objects.equals((Object)bytes[4], (Object)13) && Objects.equals((Object)bytes[5], (Object)10) && Objects.equals((Object)bytes[6], (Object)26) && Objects.equals((Object)bytes[7], (Object)10);
            if (b) {
                int dataLength;
                for (int i = 8; i < bytes.length; i += dataLength + 4) {
                    try {
                        dataLength = new BigInteger(1, Arrays.copyOfRange((byte[])bytes, (int)i, (int)(i + 4))).intValue();
                        byte[] bytes1 = Arrays.copyOfRange((byte[])bytes, (int)(i += 4), (int)(i + 4));
                        String chunkType = new String(bytes1);
                        i += 4;
                        if (Objects.equals((Object)chunkType, (Object)"IDAT") || Objects.equals((Object)chunkType, (Object)"IEND")) {
                            return false;
                        }
                        if (!Objects.equals((Object)chunkType, (Object)"acTL")) continue;
                        return true;
                    }
                    catch (Exception e) {
                        return false;
                    }
                }
            }
            return false;
        }
    }
    ,
    PNG("image/png", "png"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)-119) && Objects.equals((Object)bytes[1], (Object)80) && Objects.equals((Object)bytes[2], (Object)78) && Objects.equals((Object)bytes[3], (Object)71);
        }
    }
    ,
    GIF("image/gif", "gif"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 2 && Objects.equals((Object)bytes[0], (Object)71) && Objects.equals((Object)bytes[1], (Object)73) && Objects.equals((Object)bytes[2], (Object)70);
        }
    }
    ,
    BMP("image/bmp", "bmp"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 1 && Objects.equals((Object)bytes[0], (Object)66) && Objects.equals((Object)bytes[1], (Object)77);
        }
    }
    ,
    TIFF("image/tiff", "tiff"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 4) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[0], (Object)73) && Objects.equals((Object)bytes[1], (Object)73) && Objects.equals((Object)bytes[2], (Object)42) && Objects.equals((Object)bytes[3], (Object)0);
            boolean flag2 = Objects.equals((Object)bytes[0], (Object)77) && Objects.equals((Object)bytes[1], (Object)77) && Objects.equals((Object)bytes[2], (Object)0) && Objects.equals((Object)bytes[3], (Object)42);
            return flag1 || flag2;
        }
    }
    ,
    DWG("image/vnd.dwg", "dwg"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 10 && Objects.equals((Object)bytes[0], (Object)65) && Objects.equals((Object)bytes[1], (Object)67) && Objects.equals((Object)bytes[2], (Object)49) && Objects.equals((Object)bytes[3], (Object)48);
        }
    }
    ,
    WEBP("image/webp", "webp"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 11 && Objects.equals((Object)bytes[8], (Object)87) && Objects.equals((Object)bytes[9], (Object)69) && Objects.equals((Object)bytes[10], (Object)66) && Objects.equals((Object)bytes[11], (Object)80);
        }
    }
    ,
    PSD("image/vnd.adobe.photoshop", "psd"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)56) && Objects.equals((Object)bytes[1], (Object)66) && Objects.equals((Object)bytes[2], (Object)80) && Objects.equals((Object)bytes[3], (Object)83);
        }
    }
    ,
    ICO("image/x-icon", "ico"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)0) && Objects.equals((Object)bytes[1], (Object)0) && Objects.equals((Object)bytes[2], (Object)1) && Objects.equals((Object)bytes[3], (Object)0);
        }
    }
    ,
    XCF("image/x-xcf", "xcf"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 9 && Objects.equals((Object)bytes[0], (Object)103) && Objects.equals((Object)bytes[1], (Object)105) && Objects.equals((Object)bytes[2], (Object)109) && Objects.equals((Object)bytes[3], (Object)112) && Objects.equals((Object)bytes[4], (Object)32) && Objects.equals((Object)bytes[5], (Object)120) && Objects.equals((Object)bytes[6], (Object)99) && Objects.equals((Object)bytes[7], (Object)102) && Objects.equals((Object)bytes[8], (Object)32) && Objects.equals((Object)bytes[9], (Object)118);
        }
    }
    ,
    WAV("audio/x-wav", "wav"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 11 && Objects.equals((Object)bytes[0], (Object)82) && Objects.equals((Object)bytes[1], (Object)73) && Objects.equals((Object)bytes[2], (Object)70) && Objects.equals((Object)bytes[3], (Object)70) && Objects.equals((Object)bytes[8], (Object)87) && Objects.equals((Object)bytes[9], (Object)65) && Objects.equals((Object)bytes[10], (Object)86) && Objects.equals((Object)bytes[11], (Object)69);
        }
    }
    ,
    MIDI("audio/midi", "midi"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)77) && Objects.equals((Object)bytes[1], (Object)84) && Objects.equals((Object)bytes[2], (Object)104) && Objects.equals((Object)bytes[3], (Object)100);
        }
    }
    ,
    MP3("audio/mpeg", "mp3"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 2) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[0], (Object)73) && Objects.equals((Object)bytes[1], (Object)68) && Objects.equals((Object)bytes[2], (Object)51);
            boolean flag2 = Objects.equals((Object)bytes[0], (Object)-1) && Objects.equals((Object)bytes[1], (Object)-5);
            boolean flag3 = Objects.equals((Object)bytes[0], (Object)-1) && Objects.equals((Object)bytes[1], (Object)-13);
            boolean flag4 = Objects.equals((Object)bytes[0], (Object)-1) && Objects.equals((Object)bytes[1], (Object)-14);
            return flag1 || flag2 || flag3 || flag4;
        }
    }
    ,
    OGG("audio/ogg", "ogg"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)79) && Objects.equals((Object)bytes[1], (Object)103) && Objects.equals((Object)bytes[2], (Object)103) && Objects.equals((Object)bytes[3], (Object)83);
        }
    }
    ,
    FLAC("audio/x-flac", "flac"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)102) && Objects.equals((Object)bytes[1], (Object)76) && Objects.equals((Object)bytes[2], (Object)97) && Objects.equals((Object)bytes[3], (Object)67);
        }
    }
    ,
    M4A("audio/mp4", "m4a"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 10 && Objects.equals((Object)bytes[4], (Object)102) && Objects.equals((Object)bytes[5], (Object)116) && Objects.equals((Object)bytes[6], (Object)121) && Objects.equals((Object)bytes[7], (Object)112) && Objects.equals((Object)bytes[8], (Object)77) && Objects.equals((Object)bytes[9], (Object)52) && Objects.equals((Object)bytes[10], (Object)65) || Objects.equals((Object)bytes[0], (Object)77) && Objects.equals((Object)bytes[1], (Object)52) && Objects.equals((Object)bytes[2], (Object)65) && Objects.equals((Object)bytes[3], (Object)32);
        }
    }
    ,
    AAC("audio/aac", "aac"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 1) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[0], (Object)-1) && Objects.equals((Object)bytes[1], (Object)-15);
            boolean flag2 = Objects.equals((Object)bytes[0], (Object)-1) && Objects.equals((Object)bytes[1], (Object)-7);
            return flag1 || flag2;
        }
    }
    ,
    AMR("audio/amr", "amr"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 11) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[0], (Object)35) && Objects.equals((Object)bytes[1], (Object)33) && Objects.equals((Object)bytes[2], (Object)65) && Objects.equals((Object)bytes[3], (Object)77) && Objects.equals((Object)bytes[4], (Object)82) && Objects.equals((Object)bytes[5], (Object)10);
            boolean flag2 = Objects.equals((Object)bytes[0], (Object)35) && Objects.equals((Object)bytes[1], (Object)33) && Objects.equals((Object)bytes[2], (Object)65) && Objects.equals((Object)bytes[3], (Object)77) && Objects.equals((Object)bytes[4], (Object)82) && Objects.equals((Object)bytes[5], (Object)95) && Objects.equals((Object)bytes[6], (Object)77) && Objects.equals((Object)bytes[7], (Object)67) && Objects.equals((Object)bytes[8], (Object)49) && Objects.equals((Object)bytes[9], (Object)46) && Objects.equals((Object)bytes[10], (Object)48) && Objects.equals((Object)bytes[11], (Object)10);
            return flag1 || flag2;
        }
    }
    ,
    AC3("audio/ac3", "ac3"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 2 && Objects.equals((Object)bytes[0], (Object)11) && Objects.equals((Object)bytes[1], (Object)119);
        }
    }
    ,
    AIFF("audio/x-aiff", "aiff"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 11 && Objects.equals((Object)bytes[0], (Object)70) && Objects.equals((Object)bytes[1], (Object)79) && Objects.equals((Object)bytes[2], (Object)82) && Objects.equals((Object)bytes[3], (Object)77) && Objects.equals((Object)bytes[8], (Object)65) && Objects.equals((Object)bytes[9], (Object)73) && Objects.equals((Object)bytes[10], (Object)70) && Objects.equals((Object)bytes[11], (Object)70);
        }
    }
    ,
    WOFF("font/woff", "woff"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 8) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[0], (Object)119) && Objects.equals((Object)bytes[1], (Object)79) && Objects.equals((Object)bytes[2], (Object)70) && Objects.equals((Object)bytes[3], (Object)70);
            boolean flag2 = Objects.equals((Object)bytes[4], (Object)0) && Objects.equals((Object)bytes[5], (Object)1) && Objects.equals((Object)bytes[6], (Object)0) && Objects.equals((Object)bytes[7], (Object)0);
            boolean flag3 = Objects.equals((Object)bytes[4], (Object)79) && Objects.equals((Object)bytes[5], (Object)84) && Objects.equals((Object)bytes[6], (Object)84) && Objects.equals((Object)bytes[7], (Object)79);
            boolean flag4 = Objects.equals((Object)bytes[4], (Object)116) && Objects.equals((Object)bytes[5], (Object)114) && Objects.equals((Object)bytes[6], (Object)117) && Objects.equals((Object)bytes[7], (Object)101);
            return flag1 && (flag2 || flag3 || flag4);
        }
    }
    ,
    WOFF2("font/woff2", "woff2"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 8) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[0], (Object)119) && Objects.equals((Object)bytes[1], (Object)79) && Objects.equals((Object)bytes[2], (Object)70) && Objects.equals((Object)bytes[3], (Object)50);
            boolean flag2 = Objects.equals((Object)bytes[4], (Object)0) && Objects.equals((Object)bytes[5], (Object)1) && Objects.equals((Object)bytes[6], (Object)0) && Objects.equals((Object)bytes[7], (Object)0);
            boolean flag3 = Objects.equals((Object)bytes[4], (Object)79) && Objects.equals((Object)bytes[5], (Object)84) && Objects.equals((Object)bytes[6], (Object)84) && Objects.equals((Object)bytes[7], (Object)79);
            boolean flag4 = Objects.equals((Object)bytes[4], (Object)116) && Objects.equals((Object)bytes[5], (Object)114) && Objects.equals((Object)bytes[6], (Object)117) && Objects.equals((Object)bytes[7], (Object)101);
            return flag1 && (flag2 || flag3 || flag4);
        }
    }
    ,
    TTF("font/ttf", "ttf"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 4 && Objects.equals((Object)bytes[0], (Object)0) && Objects.equals((Object)bytes[1], (Object)1) && Objects.equals((Object)bytes[2], (Object)0) && Objects.equals((Object)bytes[3], (Object)0) && Objects.equals((Object)bytes[4], (Object)0);
        }
    }
    ,
    OTF("font/otf", "otf"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 4 && Objects.equals((Object)bytes[0], (Object)79) && Objects.equals((Object)bytes[1], (Object)84) && Objects.equals((Object)bytes[2], (Object)84) && Objects.equals((Object)bytes[3], (Object)79) && Objects.equals((Object)bytes[4], (Object)0);
        }
    }
    ,
    EPUB("application/epub+zip", "epub"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 58 && Objects.equals((Object)bytes[0], (Object)80) && Objects.equals((Object)bytes[1], (Object)75) && Objects.equals((Object)bytes[2], (Object)3) && Objects.equals((Object)bytes[3], (Object)4) && Objects.equals((Object)bytes[30], (Object)109) && Objects.equals((Object)bytes[31], (Object)105) && Objects.equals((Object)bytes[32], (Object)109) && Objects.equals((Object)bytes[33], (Object)101) && Objects.equals((Object)bytes[34], (Object)116) && Objects.equals((Object)bytes[35], (Object)121) && Objects.equals((Object)bytes[36], (Object)112) && Objects.equals((Object)bytes[37], (Object)101) && Objects.equals((Object)bytes[38], (Object)97) && Objects.equals((Object)bytes[39], (Object)112) && Objects.equals((Object)bytes[40], (Object)112) && Objects.equals((Object)bytes[41], (Object)108) && Objects.equals((Object)bytes[42], (Object)105) && Objects.equals((Object)bytes[43], (Object)99) && Objects.equals((Object)bytes[44], (Object)97) && Objects.equals((Object)bytes[45], (Object)116) && Objects.equals((Object)bytes[46], (Object)105) && Objects.equals((Object)bytes[47], (Object)111) && Objects.equals((Object)bytes[48], (Object)110) && Objects.equals((Object)bytes[49], (Object)47) && Objects.equals((Object)bytes[50], (Object)101) && Objects.equals((Object)bytes[51], (Object)112) && Objects.equals((Object)bytes[52], (Object)117) && Objects.equals((Object)bytes[53], (Object)98) && Objects.equals((Object)bytes[54], (Object)43) && Objects.equals((Object)bytes[55], (Object)122) && Objects.equals((Object)bytes[56], (Object)105) && Objects.equals((Object)bytes[57], (Object)112);
        }
    }
    ,
    ZIP("application/zip", "zip"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 4) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[0], (Object)80) && Objects.equals((Object)bytes[1], (Object)75);
            boolean flag2 = Objects.equals((Object)bytes[2], (Object)3) || Objects.equals((Object)bytes[2], (Object)5) || Objects.equals((Object)bytes[2], (Object)7);
            boolean flag3 = Objects.equals((Object)bytes[3], (Object)4) || Objects.equals((Object)bytes[3], (Object)6) || Objects.equals((Object)bytes[3], (Object)8);
            return flag1 && flag2 && flag3;
        }
    }
    ,
    TAR("application/x-tar", "tar"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 261 && Objects.equals((Object)bytes[257], (Object)117) && Objects.equals((Object)bytes[258], (Object)115) && Objects.equals((Object)bytes[259], (Object)116) && Objects.equals((Object)bytes[260], (Object)97) && Objects.equals((Object)bytes[261], (Object)114);
        }
    }
    ,
    RAR("application/x-rar-compressed", "rar"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 6 && Objects.equals((Object)bytes[0], (Object)82) && Objects.equals((Object)bytes[1], (Object)97) && Objects.equals((Object)bytes[2], (Object)114) && Objects.equals((Object)bytes[3], (Object)33) && Objects.equals((Object)bytes[4], (Object)26) && Objects.equals((Object)bytes[5], (Object)7) && (Objects.equals((Object)bytes[6], (Object)0) || Objects.equals((Object)bytes[6], (Object)1));
        }
    }
    ,
    GZ("application/gzip", "gz"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 2 && Objects.equals((Object)bytes[0], (Object)31) && Objects.equals((Object)bytes[1], (Object)-117) && Objects.equals((Object)bytes[2], (Object)8);
        }
    }
    ,
    BZ2("application/x-bzip2", "bz2"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 2 && Objects.equals((Object)bytes[0], (Object)66) && Objects.equals((Object)bytes[1], (Object)90) && Objects.equals((Object)bytes[2], (Object)104);
        }
    }
    ,
    SevenZ("application/x-7z-compressed", "7z"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 6 && Objects.equals((Object)bytes[0], (Object)55) && Objects.equals((Object)bytes[1], (Object)122) && Objects.equals((Object)bytes[2], (Object)-68) && Objects.equals((Object)bytes[3], (Object)-81) && Objects.equals((Object)bytes[4], (Object)39) && Objects.equals((Object)bytes[5], (Object)28) && Objects.equals((Object)bytes[6], (Object)0);
        }
    }
    ,
    PDF("application/pdf", "pdf"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)-17) && Objects.equals((Object)bytes[1], (Object)-69) && Objects.equals((Object)bytes[2], (Object)-65)) {
                bytes = Arrays.copyOfRange((byte[])bytes, (int)3, (int)bytes.length);
            }
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)37) && Objects.equals((Object)bytes[1], (Object)80) && Objects.equals((Object)bytes[2], (Object)68) && Objects.equals((Object)bytes[3], (Object)70);
        }
    }
    ,
    EXE("application/x-msdownload", "exe"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 1 && Objects.equals((Object)bytes[0], (Object)77) && Objects.equals((Object)bytes[1], (Object)90);
        }
    }
    ,
    SWF("application/x-shockwave-flash", "swf"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 2 && (Objects.equals((Object)bytes[0], (Object)67) || Objects.equals((Object)bytes[0], (Object)70)) && Objects.equals((Object)bytes[1], (Object)87) && Objects.equals((Object)bytes[2], (Object)83);
        }
    }
    ,
    RTF("application/rtf", "rtf"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 4 && Objects.equals((Object)bytes[0], (Object)123) && Objects.equals((Object)bytes[1], (Object)92) && Objects.equals((Object)bytes[2], (Object)114) && Objects.equals((Object)bytes[3], (Object)116) && Objects.equals((Object)bytes[4], (Object)102);
        }
    }
    ,
    NES("application/x-nintendo-nes-rom", "nes"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)78) && Objects.equals((Object)bytes[1], (Object)69) && Objects.equals((Object)bytes[2], (Object)83) && Objects.equals((Object)bytes[3], (Object)26);
        }
    }
    ,
    CRX("application/x-google-chrome-extension", "crx"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)67) && Objects.equals((Object)bytes[1], (Object)114) && Objects.equals((Object)bytes[2], (Object)50) && Objects.equals((Object)bytes[3], (Object)52);
        }
    }
    ,
    CAB("application/vnd.ms-cab-compressed", "cab"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 4) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[0], (Object)77) && Objects.equals((Object)bytes[1], (Object)83) && Objects.equals((Object)bytes[2], (Object)67) && Objects.equals((Object)bytes[3], (Object)70);
            boolean flag2 = Objects.equals((Object)bytes[0], (Object)73) && Objects.equals((Object)bytes[1], (Object)83) && Objects.equals((Object)bytes[2], (Object)99) && Objects.equals((Object)bytes[3], (Object)40);
            return flag1 || flag2;
        }
    }
    ,
    PS("application/postscript", "ps"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 1 && Objects.equals((Object)bytes[0], (Object)37) && Objects.equals((Object)bytes[1], (Object)33);
        }
    }
    ,
    XZ("application/x-xz", "xz"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 5 && Objects.equals((Object)bytes[0], (Object)-3) && Objects.equals((Object)bytes[1], (Object)55) && Objects.equals((Object)bytes[2], (Object)122) && Objects.equals((Object)bytes[3], (Object)88) && Objects.equals((Object)bytes[4], (Object)90) && Objects.equals((Object)bytes[5], (Object)0);
        }
    }
    ,
    SQLITE("application/x-sqlite3", "sqlite"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 15 && Objects.equals((Object)bytes[0], (Object)83) && Objects.equals((Object)bytes[1], (Object)81) && Objects.equals((Object)bytes[2], (Object)76) && Objects.equals((Object)bytes[3], (Object)105) && Objects.equals((Object)bytes[4], (Object)116) && Objects.equals((Object)bytes[5], (Object)101) && Objects.equals((Object)bytes[6], (Object)32) && Objects.equals((Object)bytes[7], (Object)102) && Objects.equals((Object)bytes[8], (Object)111) && Objects.equals((Object)bytes[9], (Object)114) && Objects.equals((Object)bytes[10], (Object)109) && Objects.equals((Object)bytes[11], (Object)97) && Objects.equals((Object)bytes[12], (Object)116) && Objects.equals((Object)bytes[13], (Object)32) && Objects.equals((Object)bytes[14], (Object)51) && Objects.equals((Object)bytes[15], (Object)0);
        }
    }
    ,
    DEB("application/x-deb", "deb"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 20 && Objects.equals((Object)bytes[0], (Object)33) && Objects.equals((Object)bytes[1], (Object)60) && Objects.equals((Object)bytes[2], (Object)97) && Objects.equals((Object)bytes[3], (Object)114) && Objects.equals((Object)bytes[4], (Object)99) && Objects.equals((Object)bytes[5], (Object)104) && Objects.equals((Object)bytes[6], (Object)62) && Objects.equals((Object)bytes[7], (Object)10) && Objects.equals((Object)bytes[8], (Object)100) && Objects.equals((Object)bytes[9], (Object)101) && Objects.equals((Object)bytes[10], (Object)98) && Objects.equals((Object)bytes[11], (Object)105) && Objects.equals((Object)bytes[12], (Object)97) && Objects.equals((Object)bytes[13], (Object)110) && Objects.equals((Object)bytes[14], (Object)45) && Objects.equals((Object)bytes[15], (Object)98) && Objects.equals((Object)bytes[16], (Object)105) && Objects.equals((Object)bytes[17], (Object)110) && Objects.equals((Object)bytes[18], (Object)97) && Objects.equals((Object)bytes[19], (Object)114) && Objects.equals((Object)bytes[20], (Object)121);
        }
    }
    ,
    AR("application/x-unix-archive", "ar"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 6 && Objects.equals((Object)bytes[0], (Object)33) && Objects.equals((Object)bytes[1], (Object)60) && Objects.equals((Object)bytes[2], (Object)97) && Objects.equals((Object)bytes[3], (Object)114) && Objects.equals((Object)bytes[4], (Object)99) && Objects.equals((Object)bytes[5], (Object)104) && Objects.equals((Object)bytes[6], (Object)62);
        }
    }
    ,
    LZOP("application/x-lzop", "lzo"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 7 && Objects.equals((Object)bytes[0], (Object)-119) && Objects.equals((Object)bytes[1], (Object)76) && Objects.equals((Object)bytes[2], (Object)90) && Objects.equals((Object)bytes[3], (Object)79) && Objects.equals((Object)bytes[4], (Object)0) && Objects.equals((Object)bytes[5], (Object)13) && Objects.equals((Object)bytes[6], (Object)10) && Objects.equals((Object)bytes[7], (Object)26);
        }
    }
    ,
    LZ("application/x-lzip", "lz"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)76) && Objects.equals((Object)bytes[1], (Object)90) && Objects.equals((Object)bytes[2], (Object)73) && Objects.equals((Object)bytes[3], (Object)80);
        }
    }
    ,
    ELF("application/x-executable", "elf"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 52 && Objects.equals((Object)bytes[0], (Object)127) && Objects.equals((Object)bytes[1], (Object)69) && Objects.equals((Object)bytes[2], (Object)76) && Objects.equals((Object)bytes[3], (Object)70);
        }
    }
    ,
    LZ4("application/x-lz4", "lz4"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 4 && Objects.equals((Object)bytes[0], (Object)4) && Objects.equals((Object)bytes[1], (Object)34) && Objects.equals((Object)bytes[2], (Object)77) && Objects.equals((Object)bytes[3], (Object)24);
        }
    }
    ,
    BR("application/x-brotli", "br"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)-50) && Objects.equals((Object)bytes[1], (Object)-78) && Objects.equals((Object)bytes[2], (Object)-49) && Objects.equals((Object)bytes[3], (Object)-127);
        }
    }
    ,
    DCM("application/x-dicom", "dcm"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 128 && Objects.equals((Object)bytes[128], (Object)68) && Objects.equals((Object)bytes[129], (Object)73) && Objects.equals((Object)bytes[130], (Object)67) && Objects.equals((Object)bytes[131], (Object)77);
        }
    }
    ,
    RPM("application/x-rpm", "rpm"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 4 && Objects.equals((Object)bytes[0], (Object)-19) && Objects.equals((Object)bytes[1], (Object)-85) && Objects.equals((Object)bytes[2], (Object)-18) && Objects.equals((Object)bytes[3], (Object)-37);
        }
    }
    ,
    ZSTD("application/x-zstd", "zst"){

        @Override
        public boolean match(byte[] bytes) {
            boolean flag1;
            int length = bytes.length;
            if (length < 5) {
                return false;
            }
            byte[] buf1 = new byte[]{34, 35, 36, 37, 38, 39, 40};
            boolean bl = flag1 = ArrayUtil.contains(buf1, bytes[0]) && Objects.equals((Object)bytes[1], (Object)-75) && Objects.equals((Object)bytes[2], (Object)47) && Objects.equals((Object)bytes[3], (Object)-3);
            if (flag1) {
                return true;
            }
            if ((bytes[0] & 0xF0) == 80) {
                return bytes[1] == 42 && bytes[2] == 77 && bytes[3] == 24;
            }
            return false;
        }
    }
    ,
    MP4("video/mp4", "mp4"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 13) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[4], (Object)102) && Objects.equals((Object)bytes[5], (Object)116) && Objects.equals((Object)bytes[6], (Object)121) && Objects.equals((Object)bytes[7], (Object)112) && Objects.equals((Object)bytes[8], (Object)77) && Objects.equals((Object)bytes[9], (Object)83) && Objects.equals((Object)bytes[10], (Object)78) && Objects.equals((Object)bytes[11], (Object)86);
            boolean flag2 = Objects.equals((Object)bytes[4], (Object)102) && Objects.equals((Object)bytes[5], (Object)116) && Objects.equals((Object)bytes[6], (Object)121) && Objects.equals((Object)bytes[7], (Object)112) && Objects.equals((Object)bytes[8], (Object)105) && Objects.equals((Object)bytes[9], (Object)115) && Objects.equals((Object)bytes[10], (Object)111) && Objects.equals((Object)bytes[11], (Object)109);
            return flag1 || flag2;
        }
    }
    ,
    AVI("video/x-msvideo", "avi"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 11 && Objects.equals((Object)bytes[0], (Object)82) && Objects.equals((Object)bytes[1], (Object)73) && Objects.equals((Object)bytes[2], (Object)70) && Objects.equals((Object)bytes[3], (Object)70) && Objects.equals((Object)bytes[8], (Object)65) && Objects.equals((Object)bytes[9], (Object)86) && Objects.equals((Object)bytes[10], (Object)73) && Objects.equals((Object)bytes[11], (Object)32);
        }
    }
    ,
    WMV("video/x-ms-wmv", "wmv"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 9 && Objects.equals((Object)bytes[0], (Object)48) && Objects.equals((Object)bytes[1], (Object)38) && Objects.equals((Object)bytes[2], (Object)-78) && Objects.equals((Object)bytes[3], (Object)117) && Objects.equals((Object)bytes[4], (Object)-114) && Objects.equals((Object)bytes[5], (Object)102) && Objects.equals((Object)bytes[6], (Object)-49) && Objects.equals((Object)bytes[7], (Object)17) && Objects.equals((Object)bytes[8], (Object)-90) && Objects.equals((Object)bytes[9], (Object)-39);
        }
    }
    ,
    M4V("video/x-m4v", "m4v"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 12) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[4], (Object)102) && Objects.equals((Object)bytes[5], (Object)116) && Objects.equals((Object)bytes[6], (Object)121) && Objects.equals((Object)bytes[7], (Object)112) && Objects.equals((Object)bytes[8], (Object)77) && Objects.equals((Object)bytes[9], (Object)52) && Objects.equals((Object)bytes[10], (Object)86) && Objects.equals((Object)bytes[11], (Object)32);
            boolean flag2 = Objects.equals((Object)bytes[4], (Object)102) && Objects.equals((Object)bytes[5], (Object)116) && Objects.equals((Object)bytes[6], (Object)121) && Objects.equals((Object)bytes[7], (Object)112) && Objects.equals((Object)bytes[8], (Object)109) && Objects.equals((Object)bytes[9], (Object)112) && Objects.equals((Object)bytes[10], (Object)52) && Objects.equals((Object)bytes[11], (Object)50);
            return flag1 || flag2;
        }
    }
    ,
    FLV("video/x-flv", "flv"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)70) && Objects.equals((Object)bytes[1], (Object)76) && Objects.equals((Object)bytes[2], (Object)86) && Objects.equals((Object)bytes[3], (Object)1);
        }
    }
    ,
    MKV("video/x-matroska", "mkv"){

        @Override
        public boolean match(byte[] bytes) {
            boolean flag1;
            boolean bl = flag1 = bytes.length > 11 && Objects.equals((Object)bytes[0], (Object)26) && Objects.equals((Object)bytes[1], (Object)69) && Objects.equals((Object)bytes[2], (Object)-33) && Objects.equals((Object)bytes[3], (Object)-93);
            if (flag1) {
                byte[] bytes1 = new byte[]{66, -126, -120, 109, 97, 116, 114, 111, 115, 107, 97};
                int index = FileMagicNumber.indexOf(bytes, bytes1);
                return index > 0;
            }
            return false;
        }
    }
    ,
    WEBM("video/webm", "webm"){

        @Override
        public boolean match(byte[] bytes) {
            boolean flag1;
            boolean bl = flag1 = bytes.length > 8 && Objects.equals((Object)bytes[0], (Object)26) && Objects.equals((Object)bytes[1], (Object)69) && Objects.equals((Object)bytes[2], (Object)-33) && Objects.equals((Object)bytes[3], (Object)-93);
            if (flag1) {
                byte[] bytes1 = new byte[]{66, -126, -120, 119, 101, 98, 109};
                int index = FileMagicNumber.indexOf(bytes, bytes1);
                return index > 0;
            }
            return false;
        }
    }
    ,
    MOV("video/quicktime", "mov"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 12) {
                return false;
            }
            boolean flag1 = Objects.equals((Object)bytes[4], (Object)102) && Objects.equals((Object)bytes[5], (Object)116) && Objects.equals((Object)bytes[6], (Object)121) && Objects.equals((Object)bytes[7], (Object)112) && Objects.equals((Object)bytes[8], (Object)113) && Objects.equals((Object)bytes[9], (Object)116) && Objects.equals((Object)bytes[10], (Object)32) && Objects.equals((Object)bytes[11], (Object)32);
            boolean flag2 = Objects.equals((Object)bytes[4], (Object)109) && Objects.equals((Object)bytes[5], (Object)111) && Objects.equals((Object)bytes[6], (Object)111) && Objects.equals((Object)bytes[7], (Object)118);
            boolean flag3 = Objects.equals((Object)bytes[4], (Object)102) && Objects.equals((Object)bytes[5], (Object)114) && Objects.equals((Object)bytes[6], (Object)101) && Objects.equals((Object)bytes[7], (Object)101);
            boolean flag4 = Objects.equals((Object)bytes[4], (Object)109) && Objects.equals((Object)bytes[5], (Object)100) && Objects.equals((Object)bytes[6], (Object)97) && Objects.equals((Object)bytes[7], (Object)116);
            boolean flag5 = Objects.equals((Object)bytes[4], (Object)119) && Objects.equals((Object)bytes[5], (Object)105) && Objects.equals((Object)bytes[6], (Object)100) && Objects.equals((Object)bytes[7], (Object)101);
            boolean flag6 = Objects.equals((Object)bytes[4], (Object)112) && Objects.equals((Object)bytes[5], (Object)110) && Objects.equals((Object)bytes[6], (Object)111) && Objects.equals((Object)bytes[7], (Object)116);
            boolean flag7 = Objects.equals((Object)bytes[4], (Object)115) && Objects.equals((Object)bytes[5], (Object)107) && Objects.equals((Object)bytes[6], (Object)105) && Objects.equals((Object)bytes[7], (Object)112);
            return flag1 || flag2 || flag3 || flag4 || flag5 || flag6 || flag7;
        }
    }
    ,
    MPEG("video/mpeg", "mpg"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 3 && Objects.equals((Object)bytes[0], (Object)0) && Objects.equals((Object)bytes[1], (Object)0) && Objects.equals((Object)bytes[2], (Object)1) && bytes[3] >= -80 && bytes[3] <= -65;
        }
    }
    ,
    RMVB("video/vnd.rn-realvideo", "rmvb"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 4 && Objects.equals((Object)bytes[0], (Object)46) && Objects.equals((Object)bytes[1], (Object)82) && Objects.equals((Object)bytes[2], (Object)77) && Objects.equals((Object)bytes[3], (Object)70);
        }
    }
    ,
    M3GP("video/3gpp", "3gp"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 10 && Objects.equals((Object)bytes[4], (Object)102) && Objects.equals((Object)bytes[5], (Object)116) && Objects.equals((Object)bytes[6], (Object)121) && Objects.equals((Object)bytes[7], (Object)112) && Objects.equals((Object)bytes[8], (Object)51) && Objects.equals((Object)bytes[9], (Object)103) && Objects.equals((Object)bytes[10], (Object)112);
        }
    }
    ,
    DOC("application/msword", "doc"){

        @Override
        public boolean match(byte[] bytes) {
            boolean flag1;
            byte[] byte1 = new byte[]{-48, -49, 17, -32, -95, -79, 26, -31};
            boolean bl = flag1 = bytes.length > 515 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)8), (byte[])byte1);
            if (flag1) {
                byte[] byte2 = new byte[]{-20, -91, -63, 0};
                boolean flag2 = Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)512, (int)516), (byte[])byte2);
                byte[] byte3 = new byte[]{0, 10, 0, 0, 0, 77, 83, 87, 111, 114, 100, 68, 111, 99, 0, 16, 0, 0, 0, 87, 111, 114, 100, 46, 68, 111, 99, 117, 109, 101, 110, 116, 46, 56, 0, -12, 57, -78, 113};
                byte[] range = Arrays.copyOfRange((byte[])bytes, (int)2075, (int)2142);
                boolean flag3 = bytes.length > 2142 && FileMagicNumber.indexOf(range, byte3) > 0;
                return flag2 || flag3;
            }
            return false;
        }
    }
    ,
    XLS("application/vnd.ms-excel", "xls"){

        @Override
        public boolean match(byte[] bytes) {
            boolean flag1;
            byte[] byte1 = new byte[]{-48, -49, 17, -32, -95, -79, 26, -31};
            boolean bl = flag1 = bytes.length > 520 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)8), (byte[])byte1);
            if (flag1) {
                byte[] byte2 = new byte[]{-3, -1, -1, -1};
                boolean flag2 = Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)512, (int)516), (byte[])byte2) && (bytes[518] == 0 || bytes[518] == 2);
                byte[] byte3 = new byte[]{9, 8, 16, 0, 0, 6, 5, 0};
                boolean flag3 = Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)512, (int)520), (byte[])byte3);
                byte[] byte4 = new byte[]{-30, 0, 0, 0, 92, 0, 112, 0, 4, 0, 0, 67, 97, 108, 99};
                boolean flag4 = bytes.length > 2095 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)1568, (int)2095), (byte[])byte4);
                return flag2 || flag3 || flag4;
            }
            return false;
        }
    }
    ,
    PPT("application/vnd.ms-powerpoint", "ppt"){

        @Override
        public boolean match(byte[] bytes) {
            boolean flag1;
            byte[] byte1 = new byte[]{-48, -49, 17, -32, -95, -79, 26, -31};
            boolean bl = flag1 = bytes.length > 524 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)8), (byte[])byte1);
            if (flag1) {
                byte[] byte2 = new byte[]{-96, 70, 29, -16};
                byte[] byteRange = Arrays.copyOfRange((byte[])bytes, (int)512, (int)516);
                boolean flag2 = Arrays.equals((byte[])byteRange, (byte[])byte2);
                byte[] byte3 = new byte[]{0, 110, 30, -16};
                boolean flag3 = Arrays.equals((byte[])byteRange, (byte[])byte3);
                byte[] byte4 = new byte[]{15, 0, -24, 3};
                boolean flag4 = Arrays.equals((byte[])byteRange, (byte[])byte4);
                byte[] byte5 = new byte[]{-3, -1, -1, -1};
                boolean flag5 = Arrays.equals((byte[])byteRange, (byte[])byte5) && bytes[522] == 0 && bytes[523] == 0;
                byte[] byte6 = new byte[]{0, -71, 41, -24, 17, 0, 0, 0, 77, 83, 32, 80, 111, 119, 101, 114, 80, 111, 105, 110, 116, 32, 57, 55};
                boolean flag6 = bytes.length > 2096 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)2072, (int)2096), (byte[])byte6);
                return flag2 || flag3 || flag4 || flag5 || flag6;
            }
            return false;
        }
    }
    ,
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx"){

        @Override
        public boolean match(byte[] bytes) {
            return Objects.equals((Object)((Object)FileMagicNumber.matchDocument(bytes)), (Object)((Object)DOCX));
        }
    }
    ,
    PPTX("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx"){

        @Override
        public boolean match(byte[] bytes) {
            return Objects.equals((Object)((Object)FileMagicNumber.matchDocument(bytes)), (Object)((Object)PPTX));
        }
    }
    ,
    XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx"){

        @Override
        public boolean match(byte[] bytes) {
            return Objects.equals((Object)((Object)FileMagicNumber.matchDocument(bytes)), (Object)((Object)XLSX));
        }
    }
    ,
    WASM("application/wasm", "wasm"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 7 && Objects.equals((Object)bytes[0], (Object)0) && Objects.equals((Object)bytes[1], (Object)97) && Objects.equals((Object)bytes[2], (Object)115) && Objects.equals((Object)bytes[3], (Object)109) && Objects.equals((Object)bytes[4], (Object)1) && Objects.equals((Object)bytes[5], (Object)0) && Objects.equals((Object)bytes[6], (Object)0) && Objects.equals((Object)bytes[7], (Object)0);
        }
    }
    ,
    DEX("application/vnd.android.dex", "dex"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 36 && Objects.equals((Object)bytes[0], (Object)100) && Objects.equals((Object)bytes[1], (Object)101) && Objects.equals((Object)bytes[2], (Object)120) && Objects.equals((Object)bytes[3], (Object)10) && Objects.equals((Object)bytes[36], (Object)112);
        }
    }
    ,
    DEY("application/vnd.android.dey", "dey"){

        @Override
        public boolean match(byte[] bytes) {
            return bytes.length > 100 && Objects.equals((Object)bytes[0], (Object)100) && Objects.equals((Object)bytes[1], (Object)101) && Objects.equals((Object)bytes[2], (Object)121) && Objects.equals((Object)bytes[3], (Object)10) && DEX.match(Arrays.copyOfRange((byte[])bytes, (int)40, (int)100));
        }
    }
    ,
    EML("message/rfc822", "eml"){

        @Override
        public boolean match(byte[] bytes) {
            if (bytes.length < 8) {
                return false;
            }
            byte[] byte1 = new byte[]{70, 114, 111, 109, 32, 32, 32};
            byte[] byte2 = new byte[]{70, 114, 111, 109, 32, 63, 63, 63};
            byte[] byte3 = new byte[]{70, 114, 111, 109, 58, 32};
            byte[] byte4 = new byte[]{82, 101, 116, 117, 114, 110, 45, 80, 97, 116, 104, 58, 32};
            return Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)7), (byte[])byte1) || Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)8), (byte[])byte2) || Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)6), (byte[])byte3) || bytes.length > 13 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)13), (byte[])byte4);
        }
    }
    ,
    MDB("application/vnd.ms-access", "mdb"){

        @Override
        public boolean match(byte[] bytes) {
            byte[] byte1 = new byte[]{0, 1, 0, 0, 83, 116, 97, 110, 100, 97, 114, 100, 32, 74, 101, 116, 32, 68, 66};
            return bytes.length > 18 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)18), (byte[])byte1);
        }
    }
    ,
    CHM("application/vnd.ms-htmlhelp", "chm"){

        @Override
        public boolean match(byte[] bytes) {
            byte[] byte1 = new byte[]{73, 84, 83, 70};
            return bytes.length > 4 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)4), (byte[])byte1);
        }
    }
    ,
    CLASS("application/java-vm", "class"){

        @Override
        public boolean match(byte[] bytes) {
            byte[] byte1 = new byte[]{-54, -2, -70, -66};
            return bytes.length > 4 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)4), (byte[])byte1);
        }
    }
    ,
    TORRENT("application/x-bittorrent", "torrent"){

        @Override
        public boolean match(byte[] bytes) {
            byte[] byte1 = new byte[]{100, 56, 58, 97, 110, 110, 111, 117, 110, 99, 101};
            return bytes.length > 11 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)11), (byte[])byte1);
        }
    }
    ,
    WPD("application/vnd.wordperfect", "wpd"){

        @Override
        public boolean match(byte[] bytes) {
            byte[] byte1 = new byte[]{-1, 87, 80, 67};
            return bytes.length > 4 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)4), (byte[])byte1);
        }
    }
    ,
    DBX("", "dbx"){

        @Override
        public boolean match(byte[] bytes) {
            byte[] byte1 = new byte[]{-49, -83, 18, -2};
            return bytes.length > 4 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)4), (byte[])byte1);
        }
    }
    ,
    PST("application/vnd.ms-outlook-pst", "pst"){

        @Override
        public boolean match(byte[] bytes) {
            byte[] byte1 = new byte[]{33, 66, 68, 78};
            return bytes.length > 4 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)4), (byte[])byte1);
        }
    }
    ,
    RAM("audio/x-pn-realaudio", "ram"){

        @Override
        public boolean match(byte[] bytes) {
            byte[] byte1 = new byte[]{46, 114, 97, -3, 0};
            return bytes.length > 5 && Arrays.equals((byte[])Arrays.copyOfRange((byte[])bytes, (int)0, (int)5), (byte[])byte1);
        }
    };

    private final String mimeType;
    private final String extension;

    private FileMagicNumber(String mimeType, String extension) {
        this.mimeType = mimeType;
        this.extension = extension;
    }

    public static FileMagicNumber getMagicNumber(byte[] bytes) {
        FileMagicNumber number = (FileMagicNumber)((Object)Arrays.stream((Object[])FileMagicNumber.values()).filter(fileMagicNumber -> fileMagicNumber.match(bytes)).findFirst().orElse((Object)UNKNOWN));
        if (number.equals((Object)ZIP)) {
            FileMagicNumber fn = FileMagicNumber.matchDocument(bytes);
            return fn == UNKNOWN ? ZIP : fn;
        }
        return number;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getExtension() {
        return this.extension;
    }

    private static int indexOf(byte[] array, byte[] target) {
        if (array == null || target == null || array.length < target.length) {
            return -1;
        }
        if (target.length == 0) {
            return 0;
        }
        block0: for (int i = 0; i < array.length - target.length + 1; ++i) {
            for (int j = 0; j < target.length; ++j) {
                if (array[i + j] != target[j]) continue block0;
            }
            return i;
        }
        return -1;
    }

    private static boolean compareBytes(byte[] buf, byte[] slice, int startOffset) {
        int sl = slice.length;
        if (startOffset + sl > buf.length) {
            return false;
        }
        byte[] sub = Arrays.copyOfRange((byte[])buf, (int)startOffset, (int)(startOffset + sl));
        return Arrays.equals((byte[])sub, (byte[])slice);
    }

    private static FileMagicNumber matchOpenXmlMime(byte[] bytes, int offset) {
        byte[] word = new byte[]{119, 111, 114, 100, 47};
        byte[] ppt = new byte[]{112, 112, 116, 47};
        byte[] xl = new byte[]{120, 108, 47};
        if (FileMagicNumber.compareBytes(bytes, word, offset)) {
            return DOCX;
        }
        if (FileMagicNumber.compareBytes(bytes, ppt, offset)) {
            return PPTX;
        }
        if (FileMagicNumber.compareBytes(bytes, xl, offset)) {
            return XLSX;
        }
        return UNKNOWN;
    }

    private static FileMagicNumber matchDocument(byte[] bytes) {
        FileMagicNumber fileMagicNumber = FileMagicNumber.matchOpenXmlMime(bytes, 30);
        if (!fileMagicNumber.equals((Object)UNKNOWN)) {
            return fileMagicNumber;
        }
        byte[] bytes1 = new byte[]{91, 67, 111, 110, 116, 101, 110, 116, 95, 84, 121, 112, 101, 115, 93, 46, 120, 109, 108};
        byte[] bytes2 = new byte[]{95, 114, 101, 108, 115, 47, 46, 114, 101, 108, 115};
        byte[] bytes3 = new byte[]{100, 111, 99, 80, 114, 111, 112, 115};
        boolean flag1 = FileMagicNumber.compareBytes(bytes, bytes1, 30);
        boolean flag2 = FileMagicNumber.compareBytes(bytes, bytes2, 30);
        boolean flag3 = FileMagicNumber.compareBytes(bytes, bytes3, 30);
        if (!(flag1 || flag2 || flag3)) {
            return UNKNOWN;
        }
        int index = 0;
        for (int i = 0; i < 4; ++i) {
            FileMagicNumber fn;
            if ((index = FileMagicNumber.searchSignature(bytes, index + 4, 6000)) == -1 || (fn = FileMagicNumber.matchOpenXmlMime(bytes, index + 30)).equals((Object)UNKNOWN)) continue;
            return fn;
        }
        return UNKNOWN;
    }

    private static int searchSignature(byte[] bytes, int start, int rangeNum) {
        int index;
        byte[] signature = new byte[]{80, 75, 3, 4};
        int end = start + rangeNum;
        int length = bytes.length;
        if (end > length) {
            end = length;
        }
        return (index = FileMagicNumber.indexOf(Arrays.copyOfRange((byte[])bytes, (int)start, (int)end), signature)) == -1 ? -1 : start + index;
    }

    public abstract boolean match(byte[] var1);
}

