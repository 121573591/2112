/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.InvalidAlgorithmParameterException
 *  java.security.InvalidKeyException
 *  java.security.Key
 *  java.security.SecureRandom
 *  java.security.spec.AlgorithmParameterSpec
 *  javax.crypto.Cipher
 */
package cn.hutool.crypto;

import cn.hutool.crypto.SecureUtil;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;

public class CipherWrapper {
    private final Cipher cipher;
    private AlgorithmParameterSpec params;
    private SecureRandom random;

    public CipherWrapper(String algorithm) {
        this(SecureUtil.createCipher(algorithm));
    }

    public CipherWrapper(Cipher cipher) {
        this.cipher = cipher;
    }

    public AlgorithmParameterSpec getParams() {
        return this.params;
    }

    public CipherWrapper setParams(AlgorithmParameterSpec params) {
        this.params = params;
        return this;
    }

    public CipherWrapper setRandom(SecureRandom random) {
        this.random = random;
        return this;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public CipherWrapper initMode(int mode, Key key) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = this.cipher;
        AlgorithmParameterSpec params = this.params;
        SecureRandom random = this.random;
        if (null != params) {
            if (null != random) {
                cipher.init(mode, key, params, random);
            } else {
                cipher.init(mode, key, params);
            }
        } else if (null != random) {
            cipher.init(mode, key, random);
        } else {
            cipher.init(mode, key);
        }
        return this;
    }
}

