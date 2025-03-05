/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.bouncycastle.crypto.CipherParameters
 *  org.bouncycastle.crypto.Digest
 *  org.bouncycastle.crypto.Mac
 *  org.bouncycastle.crypto.macs.HMac
 *  org.bouncycastle.crypto.params.KeyParameter
 *  org.bouncycastle.crypto.params.ParametersWithIV
 */
package cn.hutool.crypto.digest.mac;

import cn.hutool.crypto.digest.mac.BCMacEngine;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class BCHMacEngine
extends BCMacEngine {
    public BCHMacEngine(Digest digest, byte[] key, byte[] iv) {
        this(digest, (CipherParameters)new ParametersWithIV((CipherParameters)new KeyParameter(key), iv));
    }

    public BCHMacEngine(Digest digest, byte[] key) {
        this(digest, (CipherParameters)new KeyParameter(key));
    }

    public BCHMacEngine(Digest digest, CipherParameters params) {
        this(new HMac(digest), params);
    }

    public BCHMacEngine(HMac mac, CipherParameters params) {
        super((Mac)mac, params);
    }

    public BCHMacEngine init(Digest digest, CipherParameters params) {
        return (BCHMacEngine)this.init((Mac)new HMac(digest), params);
    }
}

