/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.spec.AlgorithmParameterSpec
 *  javax.crypto.SecretKey
 *  javax.crypto.spec.IvParameterSpec
 */
package cn.hutool.crypto.symmetric;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class SM4
extends SymmetricCrypto {
    private static final long serialVersionUID = 1L;
    public static final String ALGORITHM_NAME = "SM4";

    public SM4() {
        super(ALGORITHM_NAME);
    }

    public SM4(byte[] key) {
        super(ALGORITHM_NAME, key);
    }

    public SM4(Mode mode, Padding padding) {
        this(mode.name(), padding.name());
    }

    public SM4(Mode mode, Padding padding, byte[] key) {
        this(mode, padding, key, null);
    }

    public SM4(Mode mode, Padding padding, byte[] key, byte[] iv) {
        this(mode.name(), padding.name(), key, iv);
    }

    public SM4(Mode mode, Padding padding, SecretKey key) {
        this(mode, padding, key, (IvParameterSpec)null);
    }

    public SM4(Mode mode, Padding padding, SecretKey key, byte[] iv) {
        this(mode, padding, key, ArrayUtil.isEmpty(iv) ? null : new IvParameterSpec(iv));
    }

    public SM4(Mode mode, Padding padding, SecretKey key, IvParameterSpec iv) {
        this(mode.name(), padding.name(), key, iv);
    }

    public SM4(String mode, String padding) {
        this(mode, padding, (byte[])null);
    }

    public SM4(String mode, String padding, byte[] key) {
        this(mode, padding, key, null);
    }

    public SM4(String mode, String padding, byte[] key, byte[] iv) {
        this(mode, padding, SecureUtil.generateKey(ALGORITHM_NAME, key), ArrayUtil.isEmpty(iv) ? null : new IvParameterSpec(iv));
    }

    public SM4(String mode, String padding, SecretKey key) {
        this(mode, padding, key, null);
    }

    public SM4(String mode, String padding, SecretKey key, IvParameterSpec iv) {
        super(StrUtil.format("SM4/{}/{}", mode, padding), key, (AlgorithmParameterSpec)iv);
    }
}

