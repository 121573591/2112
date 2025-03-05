/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Key
 *  java.security.spec.AlgorithmParameterSpec
 */
package cn.hutool.crypto.digest.mac;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.crypto.digest.mac.DefaultHMacEngine;
import cn.hutool.crypto.digest.mac.MacEngine;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class MacEngineFactory {
    public static MacEngine createEngine(String algorithm, Key key) {
        return MacEngineFactory.createEngine(algorithm, key, null);
    }

    public static MacEngine createEngine(String algorithm, Key key, AlgorithmParameterSpec spec) {
        if (algorithm.equalsIgnoreCase(HmacAlgorithm.HmacSM3.getValue())) {
            return SmUtil.createHmacSm3Engine(key.getEncoded());
        }
        return new DefaultHMacEngine(algorithm, key, spec);
    }
}

