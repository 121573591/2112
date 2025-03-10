/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.InternalError
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.SecureRandom
 */
package cn.hutool.core.lang;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class UUID
implements Serializable,
Comparable<UUID> {
    private static final long serialVersionUID = -1185015143654744140L;
    private final long mostSigBits;
    private final long leastSigBits;

    private UUID(byte[] data) {
        int i;
        long msb = 0L;
        long lsb = 0L;
        assert (data.length == 16) : "data must be 16 bytes in length";
        for (i = 0; i < 8; ++i) {
            msb = msb << 8 | (long)(data[i] & 0xFF);
        }
        for (i = 8; i < 16; ++i) {
            lsb = lsb << 8 | (long)(data[i] & 0xFF);
        }
        this.mostSigBits = msb;
        this.leastSigBits = lsb;
    }

    public UUID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
    }

    public static UUID fastUUID() {
        return UUID.randomUUID(false);
    }

    public static UUID randomUUID() {
        return UUID.randomUUID(true);
    }

    public static UUID randomUUID(boolean isSecure) {
        SecureRandom ng = isSecure ? Holder.NUMBER_GENERATOR : RandomUtil.getRandom();
        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] = (byte)(randomBytes[6] & 0xF);
        randomBytes[6] = (byte)(randomBytes[6] | 0x40);
        randomBytes[8] = (byte)(randomBytes[8] & 0x3F);
        randomBytes[8] = (byte)(randomBytes[8] | 0x80);
        return new UUID(randomBytes);
    }

    public static UUID nameUUIDFromBytes(byte[] name) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance((String)"MD5");
        }
        catch (NoSuchAlgorithmException nsae) {
            throw new InternalError("MD5 not supported");
        }
        byte[] md5Bytes = md.digest(name);
        md5Bytes[6] = (byte)(md5Bytes[6] & 0xF);
        md5Bytes[6] = (byte)(md5Bytes[6] | 0x30);
        md5Bytes[8] = (byte)(md5Bytes[8] & 0x3F);
        md5Bytes[8] = (byte)(md5Bytes[8] | 0x80);
        return new UUID(md5Bytes);
    }

    public static UUID fromString(String name) {
        String[] components = name.split("-");
        if (components.length != 5) {
            throw new IllegalArgumentException("Invalid UUID string: " + name);
        }
        for (int i = 0; i < 5; ++i) {
            components[i] = "0x" + components[i];
        }
        long mostSigBits = Long.decode((String)components[0]);
        mostSigBits <<= 16;
        mostSigBits |= Long.decode((String)components[1]).longValue();
        mostSigBits <<= 16;
        long leastSigBits = Long.decode((String)components[3]);
        leastSigBits <<= 48;
        return new UUID(mostSigBits |= Long.decode((String)components[2]).longValue(), leastSigBits |= Long.decode((String)components[4]).longValue());
    }

    public long getLeastSignificantBits() {
        return this.leastSigBits;
    }

    public long getMostSignificantBits() {
        return this.mostSigBits;
    }

    public int version() {
        return (int)(this.mostSigBits >> 12 & 0xFL);
    }

    public int variant() {
        return (int)(this.leastSigBits >>> (int)(64L - (this.leastSigBits >>> 62)) & this.leastSigBits >> 63);
    }

    public long timestamp() throws UnsupportedOperationException {
        this.checkTimeBase();
        return (this.mostSigBits & 0xFFFL) << 48 | (this.mostSigBits >> 16 & 0xFFFFL) << 32 | this.mostSigBits >>> 32;
    }

    public int clockSequence() throws UnsupportedOperationException {
        this.checkTimeBase();
        return (int)((this.leastSigBits & 0x3FFF000000000000L) >>> 48);
    }

    public long node() throws UnsupportedOperationException {
        this.checkTimeBase();
        return this.leastSigBits & 0xFFFFFFFFFFFFL;
    }

    public String toString() {
        return this.toString(false);
    }

    public String toString(boolean isSimple) {
        StringBuilder builder = StrUtil.builder(isSimple ? 32 : 36);
        builder.append(UUID.digits(this.mostSigBits >> 32, 8));
        if (!isSimple) {
            builder.append('-');
        }
        builder.append(UUID.digits(this.mostSigBits >> 16, 4));
        if (!isSimple) {
            builder.append('-');
        }
        builder.append(UUID.digits(this.mostSigBits, 4));
        if (!isSimple) {
            builder.append('-');
        }
        builder.append(UUID.digits(this.leastSigBits >> 48, 4));
        if (!isSimple) {
            builder.append('-');
        }
        builder.append(UUID.digits(this.leastSigBits, 12));
        return builder.toString();
    }

    public int hashCode() {
        long hilo = this.mostSigBits ^ this.leastSigBits;
        return (int)(hilo >> 32) ^ (int)hilo;
    }

    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != UUID.class) {
            return false;
        }
        UUID id = (UUID)obj;
        return this.mostSigBits == id.mostSigBits && this.leastSigBits == id.leastSigBits;
    }

    public int compareTo(UUID val) {
        int compare = Long.compare((long)this.mostSigBits, (long)val.mostSigBits);
        if (0 == compare) {
            compare = Long.compare((long)this.leastSigBits, (long)val.leastSigBits);
        }
        return compare;
    }

    private static String digits(long val, int digits) {
        long hi = 1L << digits * 4;
        return Long.toHexString((long)(hi | val & hi - 1L)).substring(1);
    }

    private void checkTimeBase() {
        if (this.version() != 1) {
            throw new UnsupportedOperationException("Not a time-based UUID");
        }
    }

    private static class Holder {
        static final SecureRandom NUMBER_GENERATOR = RandomUtil.getSecureRandom();

        private Holder() {
        }
    }
}

