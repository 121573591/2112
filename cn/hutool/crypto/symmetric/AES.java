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
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AES
extends SymmetricCrypto {
    private static final long serialVersionUID = 1L;

    public AES() {
        super(SymmetricAlgorithm.AES);
    }

    public AES(byte[] key) {
        super(SymmetricAlgorithm.AES, key);
    }

    public AES(SecretKey key) {
        super(SymmetricAlgorithm.AES, key);
    }

    public AES(Mode mode, Padding padding) {
        this(mode.name(), padding.name());
    }

    public AES(Mode mode, Padding padding, byte[] key) {
        this(mode, padding, key, null);
    }

    public AES(Mode mode, Padding padding, byte[] key, byte[] iv) {
        this(mode.name(), padding.name(), key, iv);
    }

    public AES(Mode mode, Padding padding, SecretKey key) {
        this(mode, padding, key, (AlgorithmParameterSpec)((IvParameterSpec)null));
    }

    public AES(Mode mode, Padding padding, SecretKey key, byte[] iv) {
        this(mode, padding, key, (AlgorithmParameterSpec)(ArrayUtil.isEmpty(iv) ? null : new IvParameterSpec(iv)));
    }

    public AES(Mode mode, Padding padding, SecretKey key, AlgorithmParameterSpec paramsSpec) {
        this(mode.name(), padding.name(), key, paramsSpec);
    }

    public AES(String mode, String padding) {
        this(mode, padding, (byte[])null);
    }

    public AES(String mode, String padding, byte[] key) {
        this(mode, padding, key, null);
    }

    public AES(String mode, String padding, byte[] key, byte[] iv) {
        this(mode, padding, KeyUtil.generateKey(SymmetricAlgorithm.AES.getValue(), key), (AlgorithmParameterSpec)(ArrayUtil.isEmpty(iv) ? null : new IvParameterSpec(iv)));
    }

    public AES(String mode, String padding, SecretKey key) {
        this(mode, padding, key, null);
    }

    public AES(String mode, String padding, SecretKey key, AlgorithmParameterSpec paramsSpec) {
        super(StrUtil.format("AES/{}/{}", mode, padding), key, paramsSpec);
    }
}

