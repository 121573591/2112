/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.security.spec.AlgorithmParameterSpec
 *  org.bouncycastle.crypto.AlphabetMapper
 *  org.bouncycastle.jcajce.spec.FPEParameterSpec
 */
package cn.hutool.crypto.symmetric.fpe;

import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;
import java.io.Serializable;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AlphabetMapper;
import org.bouncycastle.jcajce.spec.FPEParameterSpec;

public class FPE
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final AES aes;
    private final AlphabetMapper mapper;

    public FPE(FPEMode mode, byte[] key, AlphabetMapper mapper) {
        this(mode, key, mapper, null);
    }

    public FPE(FPEMode mode, byte[] key, AlphabetMapper mapper, byte[] tweak) {
        if (null == mode) {
            mode = FPEMode.FF1;
        }
        if (null == tweak) {
            switch (mode) {
                case FF1: {
                    tweak = new byte[]{};
                    break;
                }
                case FF3_1: {
                    tweak = new byte[7];
                }
            }
        }
        this.aes = new AES(mode.value, Padding.NoPadding.name(), KeyUtil.generateKey(mode.value, key), (AlgorithmParameterSpec)new FPEParameterSpec(mapper.getRadix(), tweak));
        this.mapper = mapper;
    }

    public String encrypt(String data) {
        if (null == data) {
            return null;
        }
        return new String(this.encrypt(data.toCharArray()));
    }

    public char[] encrypt(char[] data) {
        if (null == data) {
            return null;
        }
        return this.mapper.convertToChars(this.aes.encrypt(this.mapper.convertToIndexes(data)));
    }

    public String decrypt(String data) {
        if (null == data) {
            return null;
        }
        return new String(this.decrypt(data.toCharArray()));
    }

    public char[] decrypt(char[] data) {
        if (null == data) {
            return null;
        }
        return this.mapper.convertToChars(this.aes.decrypt(this.mapper.convertToIndexes(data)));
    }

    public static enum FPEMode {
        FF1("FF1"),
        FF3_1("FF3-1");

        private final String value;

        private FPEMode(String name) {
            this.value = name;
        }

        public String getValue() {
            return this.value;
        }
    }
}

