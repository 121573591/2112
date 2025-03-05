/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.Serializable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 */
package cn.hutool.crypto.symmetric;

import cn.hutool.core.io.IoUtil;
import cn.hutool.crypto.symmetric.SymmetricDecryptor;
import cn.hutool.crypto.symmetric.SymmetricEncryptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class XXTEA
implements SymmetricEncryptor,
SymmetricDecryptor,
Serializable {
    private static final long serialVersionUID = 1L;
    private static final int DELTA = -1640531527;
    private final byte[] key;

    public XXTEA(byte[] key) {
        this.key = key;
    }

    @Override
    public byte[] encrypt(byte[] data) {
        if (data.length == 0) {
            return data;
        }
        return XXTEA.toByteArray(XXTEA.encrypt(XXTEA.toIntArray(data, true), XXTEA.toIntArray(XXTEA.fixKey(this.key), false)), false);
    }

    @Override
    public void encrypt(InputStream data, OutputStream out, boolean isClose) {
        IoUtil.write(out, isClose, this.encrypt(IoUtil.readBytes(data)));
    }

    @Override
    public byte[] decrypt(byte[] data) {
        if (data.length == 0) {
            return data;
        }
        return XXTEA.toByteArray(XXTEA.decrypt(XXTEA.toIntArray(data, false), XXTEA.toIntArray(XXTEA.fixKey(this.key), false)), true);
    }

    @Override
    public void decrypt(InputStream data, OutputStream out, boolean isClose) {
        IoUtil.write(out, isClose, this.decrypt(IoUtil.readBytes(data)));
    }

    private static int[] encrypt(int[] v, int[] k) {
        int n = v.length - 1;
        if (n < 1) {
            return v;
        }
        int q = 6 + 52 / (n + 1);
        int z = v[n];
        int sum = 0;
        while (q-- > 0) {
            int y;
            int p;
            int e = (sum += -1640531527) >>> 2 & 3;
            for (p = 0; p < n; ++p) {
                y = v[p + 1];
                int n2 = p;
                int n3 = v[n2] + XXTEA.mx(sum, y, z, p, e, k);
                v[n2] = n3;
                z = n3;
            }
            y = v[0];
            int n4 = n;
            int n5 = v[n4] + XXTEA.mx(sum, y, z, p, e, k);
            v[n4] = n5;
            z = n5;
        }
        return v;
    }

    private static int[] decrypt(int[] v, int[] k) {
        int n = v.length - 1;
        if (n < 1) {
            return v;
        }
        int q = 6 + 52 / (n + 1);
        int y = v[0];
        for (int sum = q * -1640531527; sum != 0; sum -= -1640531527) {
            int z;
            int p;
            int e = sum >>> 2 & 3;
            for (p = n; p > 0; --p) {
                z = v[p - 1];
                int n2 = p;
                int n3 = v[n2] - XXTEA.mx(sum, y, z, p, e, k);
                v[n2] = n3;
                y = n3;
            }
            z = v[n];
            y = v[0] = v[0] - XXTEA.mx(sum, y, z, p, e, k);
        }
        return v;
    }

    private static int mx(int sum, int y, int z, int p, int e, int[] k) {
        return (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
    }

    private static byte[] fixKey(byte[] key) {
        if (key.length == 16) {
            return key;
        }
        byte[] fixedkey = new byte[16];
        System.arraycopy((Object)key, (int)0, (Object)fixedkey, (int)0, (int)Math.min((int)key.length, (int)16));
        return fixedkey;
    }

    private static int[] toIntArray(byte[] data, boolean includeLength) {
        int[] result;
        int n;
        int n2 = n = (data.length & 3) == 0 ? data.length >>> 2 : (data.length >>> 2) + 1;
        if (includeLength) {
            result = new int[n + 1];
            result[n] = data.length;
        } else {
            result = new int[n];
        }
        n = data.length;
        for (int i = 0; i < n; ++i) {
            int n3 = i >>> 2;
            result[n3] = result[n3] | (0xFF & data[i]) << ((i & 3) << 3);
        }
        return result;
    }

    private static byte[] toByteArray(int[] data, boolean includeLength) {
        int n = data.length << 2;
        if (includeLength) {
            int m = data[data.length - 1];
            if (m < (n -= 4) - 3 || m > n) {
                return null;
            }
            n = m;
        }
        byte[] result = new byte[n];
        for (int i = 0; i < n; ++i) {
            result[i] = (byte)(data[i >>> 2] >>> ((i & 3) << 3));
        }
        return result;
    }
}

