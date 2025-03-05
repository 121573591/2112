/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package cn.hutool.core.codec;

import cn.hutool.core.codec.Decoder;
import cn.hutool.core.codec.Encoder;
import java.util.Arrays;

public class Base32Codec
implements Encoder<byte[], String>,
Decoder<CharSequence, byte[]> {
    public static Base32Codec INSTANCE = new Base32Codec();

    @Override
    public String encode(byte[] data) {
        return this.encode(data, false);
    }

    public String encode(byte[] data, boolean useHex) {
        Base32Encoder encoder = useHex ? Base32Encoder.HEX_ENCODER : Base32Encoder.ENCODER;
        return encoder.encode(data);
    }

    @Override
    public byte[] decode(CharSequence encoded) {
        return this.decode(encoded, false);
    }

    public byte[] decode(CharSequence encoded, boolean useHex) {
        Base32Decoder decoder = useHex ? Base32Decoder.HEX_DECODER : Base32Decoder.DECODER;
        return decoder.decode(encoded);
    }

    public static class Base32Decoder
    implements Decoder<CharSequence, byte[]> {
        private static final char BASE_CHAR = '0';
        public static final Base32Decoder DECODER = new Base32Decoder("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        public static final Base32Decoder HEX_DECODER = new Base32Decoder("0123456789ABCDEFGHIJKLMNOPQRSTUV");
        private final byte[] lookupTable = new byte[128];

        public Base32Decoder(String alphabet) {
            Arrays.fill((byte[])this.lookupTable, (byte)-1);
            int length = alphabet.length();
            for (int i = 0; i < length; ++i) {
                char c = alphabet.charAt(i);
                this.lookupTable[c - 48] = (byte)i;
                if (c < 'A' || c > 'Z') continue;
                this.lookupTable[Character.toLowerCase((char)c) - 48] = (byte)i;
            }
        }

        @Override
        public byte[] decode(CharSequence encoded) {
            String base32 = encoded.toString();
            int len = base32.endsWith("=") ? base32.indexOf("=") * 5 / 8 : base32.length() * 5 / 8;
            byte[] bytes = new byte[len];
            int index = 0;
            int offset = 0;
            for (int i = 0; i < base32.length(); ++i) {
                byte digit;
                int lookup = base32.charAt(i) - 48;
                if (lookup < 0 || lookup >= this.lookupTable.length || (digit = this.lookupTable[lookup]) < 0) continue;
                if (index <= 3) {
                    if ((index = (index + 5) % 8) == 0) {
                        int n = offset++;
                        bytes[n] = (byte)(bytes[n] | digit);
                        if (offset < bytes.length) continue;
                        break;
                    }
                    int n = offset;
                    bytes[n] = (byte)(bytes[n] | digit << 8 - index);
                    continue;
                }
                index = (index + 5) % 8;
                int n = offset++;
                bytes[n] = (byte)(bytes[n] | digit >>> index);
                if (offset >= bytes.length) break;
                int n2 = offset;
                bytes[n2] = (byte)(bytes[n2] | digit << 8 - index);
            }
            return bytes;
        }
    }

    public static class Base32Encoder
    implements Encoder<byte[], String> {
        private static final String DEFAULT_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
        private static final String HEX_ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUV";
        private static final Character DEFAULT_PAD = Character.valueOf((char)'=');
        private static final int[] BASE32_FILL = new int[]{-1, 4, 1, 6, 3};
        public static final Base32Encoder ENCODER = new Base32Encoder("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", DEFAULT_PAD);
        public static final Base32Encoder HEX_ENCODER = new Base32Encoder("0123456789ABCDEFGHIJKLMNOPQRSTUV", DEFAULT_PAD);
        private final char[] alphabet;
        private final Character pad;

        public Base32Encoder(String alphabet, Character pad) {
            this.alphabet = alphabet.toCharArray();
            this.pad = pad;
        }

        @Override
        public String encode(byte[] data) {
            int i = 0;
            int index = 0;
            int encodeLen = data.length * 8 / 5;
            if (encodeLen != 0) {
                encodeLen = encodeLen + 1 + BASE32_FILL[data.length * 8 % 5];
            }
            StringBuilder base32 = new StringBuilder(encodeLen);
            while (i < data.length) {
                int digit;
                int currByte;
                int n = currByte = data[i] >= 0 ? data[i] : data[i] + 256;
                if (index > 3) {
                    int nextByte = i + 1 < data.length ? (data[i + 1] >= 0 ? data[i + 1] : data[i + 1] + 256) : 0;
                    digit = currByte & 255 >> index;
                    index = (index + 5) % 8;
                    digit <<= index;
                    digit |= nextByte >> 8 - index;
                    ++i;
                } else {
                    digit = currByte >> 8 - (index + 5) & 0x1F;
                    if ((index = (index + 5) % 8) == 0) {
                        ++i;
                    }
                }
                base32.append(this.alphabet[digit]);
            }
            if (null != this.pad) {
                while (base32.length() < encodeLen) {
                    base32.append(this.pad.charValue());
                }
            }
            return base32.toString();
        }
    }
}

