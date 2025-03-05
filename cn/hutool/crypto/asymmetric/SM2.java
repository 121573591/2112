/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.math.BigInteger
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  org.bouncycastle.crypto.CipherParameters
 *  org.bouncycastle.crypto.CryptoException
 *  org.bouncycastle.crypto.Digest
 *  org.bouncycastle.crypto.InvalidCipherTextException
 *  org.bouncycastle.crypto.digests.SM3Digest
 *  org.bouncycastle.crypto.engines.SM2Engine
 *  org.bouncycastle.crypto.engines.SM2Engine$Mode
 *  org.bouncycastle.crypto.params.ECPrivateKeyParameters
 *  org.bouncycastle.crypto.params.ECPublicKeyParameters
 *  org.bouncycastle.crypto.params.ParametersWithID
 *  org.bouncycastle.crypto.params.ParametersWithRandom
 *  org.bouncycastle.crypto.signers.DSAEncoding
 *  org.bouncycastle.crypto.signers.PlainDSAEncoding
 *  org.bouncycastle.crypto.signers.SM2Signer
 *  org.bouncycastle.crypto.signers.StandardDSAEncoding
 *  org.bouncycastle.util.BigIntegers
 *  org.bouncycastle.util.encoders.Hex
 */
package cn.hutool.crypto.asymmetric;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.CryptoException;
import cn.hutool.crypto.ECKeyUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AbstractAsymmetricCrypto;
import cn.hutool.crypto.asymmetric.KeyType;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.DSAEncoding;
import org.bouncycastle.crypto.signers.PlainDSAEncoding;
import org.bouncycastle.crypto.signers.SM2Signer;
import org.bouncycastle.crypto.signers.StandardDSAEncoding;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.encoders.Hex;

public class SM2
extends AbstractAsymmetricCrypto<SM2> {
    private static final long serialVersionUID = 1L;
    private static final String ALGORITHM_SM2 = "SM2";
    protected SM2Engine engine;
    protected SM2Signer signer;
    private ECPrivateKeyParameters privateKeyParams;
    private ECPublicKeyParameters publicKeyParams;
    private DSAEncoding encoding = StandardDSAEncoding.INSTANCE;
    private Digest digest = new SM3Digest();
    private SM2Engine.Mode mode = SM2Engine.Mode.C1C3C2;

    public SM2() {
        this(null, (byte[])null);
    }

    public SM2(String privateKeyStr, String publicKeyStr) {
        this(SecureUtil.decode(privateKeyStr), SecureUtil.decode(publicKeyStr));
    }

    public SM2(byte[] privateKey, byte[] publicKey) {
        this(ECKeyUtil.decodePrivateKeyParams(privateKey), ECKeyUtil.decodePublicKeyParams(publicKey));
    }

    public SM2(PrivateKey privateKey, PublicKey publicKey) {
        this(BCUtil.toParams(privateKey), BCUtil.toParams(publicKey));
        if (null != privateKey) {
            this.privateKey = privateKey;
        }
        if (null != publicKey) {
            this.publicKey = publicKey;
        }
    }

    public SM2(String privateKeyHex, String publicKeyPointXHex, String publicKeyPointYHex) {
        this(BCUtil.toSm2Params(privateKeyHex), BCUtil.toSm2Params(publicKeyPointXHex, publicKeyPointYHex));
    }

    public SM2(byte[] privateKey, byte[] publicKeyPointX, byte[] publicKeyPointY) {
        this(BCUtil.toSm2Params(privateKey), BCUtil.toSm2Params(publicKeyPointX, publicKeyPointY));
    }

    public SM2(ECPrivateKeyParameters privateKeyParams, ECPublicKeyParameters publicKeyParams) {
        super(ALGORITHM_SM2, null, null);
        this.privateKeyParams = privateKeyParams;
        this.publicKeyParams = publicKeyParams;
        this.init();
    }

    public SM2 init() {
        if (null == this.privateKeyParams && null == this.publicKeyParams) {
            super.initKeys();
            this.privateKeyParams = BCUtil.toParams(this.privateKey);
            this.publicKeyParams = BCUtil.toParams(this.publicKey);
        }
        return this;
    }

    @Override
    public SM2 initKeys() {
        return this;
    }

    public byte[] encrypt(byte[] data) throws CryptoException {
        return this.encrypt(data, KeyType.PublicKey);
    }

    @Override
    public byte[] encrypt(byte[] data, KeyType keyType) throws CryptoException {
        if (KeyType.PublicKey != keyType) {
            throw new IllegalArgumentException("Encrypt is only support by public key");
        }
        return this.encrypt(data, (CipherParameters)new ParametersWithRandom(this.getCipherParameters(keyType)));
    }

    public byte[] encrypt(byte[] data, CipherParameters pubKeyParameters) throws CryptoException {
        this.lock.lock();
        SM2Engine engine = this.getEngine();
        try {
            engine.init(true, pubKeyParameters);
            byte[] byArray = engine.processBlock(data, 0, data.length);
            return byArray;
        }
        catch (InvalidCipherTextException e) {
            throw new CryptoException(e);
        }
        finally {
            this.lock.unlock();
        }
    }

    public byte[] decrypt(byte[] data) throws CryptoException {
        return this.decrypt(data, KeyType.PrivateKey);
    }

    @Override
    public byte[] decrypt(byte[] data, KeyType keyType) throws CryptoException {
        if (KeyType.PrivateKey != keyType) {
            throw new IllegalArgumentException("Decrypt is only support by private key");
        }
        return this.decrypt(data, this.getCipherParameters(keyType));
    }

    public byte[] decrypt(byte[] data, CipherParameters privateKeyParameters) throws CryptoException {
        this.lock.lock();
        SM2Engine engine = this.getEngine();
        try {
            engine.init(false, privateKeyParameters);
            byte[] byArray = engine.processBlock(data, 0, data.length);
            return byArray;
        }
        catch (InvalidCipherTextException e) {
            throw new CryptoException(e);
        }
        finally {
            this.lock.unlock();
        }
    }

    public String signHex(String dataHex) {
        return this.signHex(dataHex, null);
    }

    public byte[] sign(byte[] data) {
        return this.sign(data, null);
    }

    public String signHex(String dataHex, String idHex) {
        return HexUtil.encodeHexStr(this.sign(HexUtil.decodeHex(dataHex), HexUtil.decodeHex(idHex)));
    }

    public byte[] sign(byte[] data, byte[] id) {
        this.lock.lock();
        SM2Signer signer = this.getSigner();
        try {
            ParametersWithRandom param = new ParametersWithRandom(this.getCipherParameters(KeyType.PrivateKey));
            if (id != null) {
                param = new ParametersWithID((CipherParameters)param, id);
            }
            signer.init(true, (CipherParameters)param);
            signer.update(data, 0, data.length);
            byte[] byArray = signer.generateSignature();
            return byArray;
        }
        catch (org.bouncycastle.crypto.CryptoException e) {
            throw new CryptoException(e);
        }
        finally {
            this.lock.unlock();
        }
    }

    public boolean verifyHex(String dataHex, String signHex) {
        return this.verifyHex(dataHex, signHex, null);
    }

    public boolean verify(byte[] data, byte[] sign) {
        return this.verify(data, sign, null);
    }

    public boolean verifyHex(String dataHex, String signHex, String idHex) {
        return this.verify(HexUtil.decodeHex(dataHex), HexUtil.decodeHex(signHex), HexUtil.decodeHex(idHex));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean verify(byte[] data, byte[] sign, byte[] id) {
        this.lock.lock();
        SM2Signer signer = this.getSigner();
        try {
            CipherParameters param = this.getCipherParameters(KeyType.PublicKey);
            if (id != null) {
                param = new ParametersWithID(param, id);
            }
            signer.init(false, param);
            signer.update(data, 0, data.length);
            boolean bl = signer.verifySignature(sign);
            return bl;
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public SM2 setPrivateKey(PrivateKey privateKey) {
        super.setPrivateKey(privateKey);
        this.privateKeyParams = BCUtil.toParams(privateKey);
        return this;
    }

    public SM2 setPrivateKeyParams(ECPrivateKeyParameters privateKeyParams) {
        this.privateKeyParams = privateKeyParams;
        return this;
    }

    @Override
    public SM2 setPublicKey(PublicKey publicKey) {
        super.setPublicKey(publicKey);
        this.publicKeyParams = BCUtil.toParams(publicKey);
        return this;
    }

    public SM2 setPublicKeyParams(ECPublicKeyParameters publicKeyParams) {
        this.publicKeyParams = publicKeyParams;
        return this;
    }

    public SM2 usePlainEncoding() {
        return this.setEncoding((DSAEncoding)PlainDSAEncoding.INSTANCE);
    }

    public SM2 setEncoding(DSAEncoding encoding) {
        this.encoding = encoding;
        this.signer = null;
        return this;
    }

    public SM2 setDigest(Digest digest) {
        this.digest = digest;
        this.engine = null;
        this.signer = null;
        return this;
    }

    public SM2 setMode(SM2Engine.Mode mode) {
        this.mode = mode;
        this.engine = null;
        return this;
    }

    public byte[] getD() {
        return BigIntegers.asUnsignedByteArray((int)32, (BigInteger)this.getDBigInteger());
    }

    public String getDHex() {
        return new String(Hex.encode((byte[])this.getD()));
    }

    public BigInteger getDBigInteger() {
        return this.privateKeyParams.getD();
    }

    public byte[] getQ(boolean isCompressed) {
        return this.publicKeyParams.getQ().getEncoded(isCompressed);
    }

    private CipherParameters getCipherParameters(KeyType keyType) {
        switch (keyType) {
            case PublicKey: {
                Assert.notNull(this.publicKeyParams, "PublicKey must be not null !", new Object[0]);
                return this.publicKeyParams;
            }
            case PrivateKey: {
                Assert.notNull(this.privateKeyParams, "PrivateKey must be not null !", new Object[0]);
                return this.privateKeyParams;
            }
        }
        return null;
    }

    private SM2Engine getEngine() {
        if (null == this.engine) {
            Assert.notNull(this.digest, "digest must be not null !", new Object[0]);
            this.engine = new SM2Engine(this.digest, this.mode);
        }
        this.digest.reset();
        return this.engine;
    }

    private SM2Signer getSigner() {
        if (null == this.signer) {
            Assert.notNull(this.digest, "digest must be not null !", new Object[0]);
            this.signer = new SM2Signer(this.encoding, this.digest);
        }
        this.digest.reset();
        return this.signer;
    }
}

