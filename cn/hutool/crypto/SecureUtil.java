/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Key
 *  java.security.KeyPair
 *  java.security.KeyStore
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PrivateKey
 *  java.security.Provider
 *  java.security.PublicKey
 *  java.security.Security
 *  java.security.Signature
 *  java.security.cert.Certificate
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.util.Map
 *  javax.crypto.Cipher
 *  javax.crypto.Mac
 *  javax.crypto.SecretKey
 *  org.bouncycastle.crypto.AlphabetMapper
 */
package cn.hutool.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.SystemPropsUtil;
import cn.hutool.crypto.CryptoException;
import cn.hutool.crypto.GlobalBouncyCastleProvider;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SignUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.DESede;
import cn.hutool.crypto.symmetric.PBKDF2;
import cn.hutool.crypto.symmetric.RC4;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.crypto.symmetric.ZUC;
import cn.hutool.crypto.symmetric.fpe.FPE;
import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.crypto.AlphabetMapper;

public class SecureUtil {
    public static String HUTOOL_CRYPTO_DECODE_HEX = "hutool.crypto.decodeHex";
    public static final int DEFAULT_KEY_SIZE = 1024;

    public static SecretKey generateKey(String algorithm) {
        return KeyUtil.generateKey(algorithm);
    }

    public static SecretKey generateKey(String algorithm, int keySize) {
        return KeyUtil.generateKey(algorithm, keySize);
    }

    public static SecretKey generateKey(String algorithm, byte[] key) {
        return KeyUtil.generateKey(algorithm, key);
    }

    public static SecretKey generateDESKey(String algorithm, byte[] key) {
        return KeyUtil.generateDESKey(algorithm, key);
    }

    public static SecretKey generatePBEKey(String algorithm, char[] key) {
        return KeyUtil.generatePBEKey(algorithm, key);
    }

    public static SecretKey generateKey(String algorithm, KeySpec keySpec) {
        return KeyUtil.generateKey(algorithm, keySpec);
    }

    public static PrivateKey generatePrivateKey(String algorithm, byte[] key) {
        return KeyUtil.generatePrivateKey(algorithm, key);
    }

    public static PrivateKey generatePrivateKey(String algorithm, KeySpec keySpec) {
        return KeyUtil.generatePrivateKey(algorithm, keySpec);
    }

    public static PrivateKey generatePrivateKey(KeyStore keyStore, String alias, char[] password) {
        return KeyUtil.generatePrivateKey(keyStore, alias, password);
    }

    public static PublicKey generatePublicKey(String algorithm, byte[] key) {
        return KeyUtil.generatePublicKey(algorithm, key);
    }

    public static PublicKey generatePublicKey(String algorithm, KeySpec keySpec) {
        return KeyUtil.generatePublicKey(algorithm, keySpec);
    }

    public static KeyPair generateKeyPair(String algorithm) {
        return KeyUtil.generateKeyPair(algorithm);
    }

    public static KeyPair generateKeyPair(String algorithm, int keySize) {
        return KeyUtil.generateKeyPair(algorithm, keySize);
    }

    public static KeyPair generateKeyPair(String algorithm, int keySize, byte[] seed) {
        return KeyUtil.generateKeyPair(algorithm, keySize, seed);
    }

    public static KeyPair generateKeyPair(String algorithm, AlgorithmParameterSpec params) {
        return KeyUtil.generateKeyPair(algorithm, params);
    }

    public static KeyPair generateKeyPair(String algorithm, byte[] seed, AlgorithmParameterSpec params) {
        return KeyUtil.generateKeyPair(algorithm, seed, params);
    }

    public static String getAlgorithmAfterWith(String algorithm) {
        return KeyUtil.getAlgorithmAfterWith(algorithm);
    }

    public static String generateAlgorithm(AsymmetricAlgorithm asymmetricAlgorithm, DigestAlgorithm digestAlgorithm) {
        String digestPart = null == digestAlgorithm ? "NONE" : digestAlgorithm.name();
        return StrUtil.format("{}with{}", digestPart, asymmetricAlgorithm.getValue());
    }

    public static Signature generateSignature(AsymmetricAlgorithm asymmetricAlgorithm, DigestAlgorithm digestAlgorithm) {
        try {
            return Signature.getInstance((String)SecureUtil.generateAlgorithm(asymmetricAlgorithm, digestAlgorithm));
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }

    public static KeyStore readJKSKeyStore(InputStream in, char[] password) {
        return KeyUtil.readJKSKeyStore(in, password);
    }

    public static KeyStore readKeyStore(String type, InputStream in, char[] password) {
        return KeyUtil.readKeyStore(type, in, password);
    }

    public static Certificate readX509Certificate(InputStream in, char[] password, String alias) {
        return KeyUtil.readX509Certificate(in, password, alias);
    }

    public static Certificate readX509Certificate(InputStream in) {
        return KeyUtil.readX509Certificate(in);
    }

    public static Certificate readCertificate(String type, InputStream in, char[] password, String alias) {
        return KeyUtil.readCertificate(type, in, password, alias);
    }

    public static Certificate readCertificate(String type, InputStream in) {
        return KeyUtil.readCertificate(type, in);
    }

    public static Certificate getCertificate(KeyStore keyStore, String alias) {
        return KeyUtil.getCertificate(keyStore, alias);
    }

    public static AES aes() {
        return new AES();
    }

    public static AES aes(byte[] key) {
        return new AES(key);
    }

    public static DES des() {
        return new DES();
    }

    public static DES des(byte[] key) {
        return new DES(key);
    }

    public static DESede desede() {
        return new DESede();
    }

    public static DESede desede(byte[] key) {
        return new DESede(key);
    }

    public static MD5 md5() {
        return new MD5();
    }

    public static String md5(String data) {
        return new MD5().digestHex(data);
    }

    public static String md5(InputStream data) {
        return new MD5().digestHex(data);
    }

    public static String md5(File dataFile) {
        return new MD5().digestHex(dataFile);
    }

    public static Digester sha1() {
        return new Digester(DigestAlgorithm.SHA1);
    }

    public static String sha1(String data) {
        return new Digester(DigestAlgorithm.SHA1).digestHex(data);
    }

    public static String sha1(InputStream data) {
        return new Digester(DigestAlgorithm.SHA1).digestHex(data);
    }

    public static String sha1(File dataFile) {
        return new Digester(DigestAlgorithm.SHA1).digestHex(dataFile);
    }

    public static Digester sha256() {
        return new Digester(DigestAlgorithm.SHA256);
    }

    public static String sha256(String data) {
        return new Digester(DigestAlgorithm.SHA256).digestHex(data);
    }

    public static String sha256(InputStream data) {
        return new Digester(DigestAlgorithm.SHA256).digestHex(data);
    }

    public static String sha256(File dataFile) {
        return new Digester(DigestAlgorithm.SHA256).digestHex(dataFile);
    }

    public static HMac hmac(HmacAlgorithm algorithm, String key) {
        return SecureUtil.hmac(algorithm, StrUtil.isNotEmpty(key) ? StrUtil.utf8Bytes(key) : null);
    }

    public static HMac hmac(HmacAlgorithm algorithm, byte[] key) {
        if (ArrayUtil.isEmpty(key)) {
            key = SecureUtil.generateKey(algorithm.getValue()).getEncoded();
        }
        return new HMac(algorithm, key);
    }

    public static HMac hmac(HmacAlgorithm algorithm, SecretKey key) {
        if (ObjectUtil.isNull(key)) {
            key = SecureUtil.generateKey(algorithm.getValue());
        }
        return new HMac(algorithm, (Key)key);
    }

    public static HMac hmacMd5(String key) {
        return SecureUtil.hmacMd5(StrUtil.isNotEmpty(key) ? StrUtil.utf8Bytes(key) : null);
    }

    public static HMac hmacMd5(byte[] key) {
        if (ArrayUtil.isEmpty(key)) {
            key = SecureUtil.generateKey(HmacAlgorithm.HmacMD5.getValue()).getEncoded();
        }
        return new HMac(HmacAlgorithm.HmacMD5, key);
    }

    public static HMac hmacMd5() {
        return new HMac(HmacAlgorithm.HmacMD5);
    }

    public static HMac hmacSha1(String key) {
        return SecureUtil.hmacSha1(StrUtil.isNotEmpty(key) ? StrUtil.utf8Bytes(key) : null);
    }

    public static HMac hmacSha1(byte[] key) {
        if (ArrayUtil.isEmpty(key)) {
            key = SecureUtil.generateKey(HmacAlgorithm.HmacMD5.getValue()).getEncoded();
        }
        return new HMac(HmacAlgorithm.HmacSHA1, key);
    }

    public static HMac hmacSha1() {
        return new HMac(HmacAlgorithm.HmacSHA1);
    }

    public static HMac hmacSha256(String key) {
        return SecureUtil.hmacSha256(StrUtil.isNotEmpty(key) ? StrUtil.utf8Bytes(key) : null);
    }

    public static HMac hmacSha256(byte[] key) {
        if (ArrayUtil.isEmpty(key)) {
            key = SecureUtil.generateKey(HmacAlgorithm.HmacMD5.getValue()).getEncoded();
        }
        return new HMac(HmacAlgorithm.HmacSHA256, key);
    }

    public static HMac hmacSha256() {
        return new HMac(HmacAlgorithm.HmacSHA256);
    }

    public static RSA rsa() {
        return new RSA();
    }

    public static RSA rsa(String privateKeyBase64, String publicKeyBase64) {
        return new RSA(privateKeyBase64, publicKeyBase64);
    }

    public static RSA rsa(byte[] privateKey, byte[] publicKey) {
        return new RSA(privateKey, publicKey);
    }

    public static Sign sign(SignAlgorithm algorithm) {
        return SignUtil.sign(algorithm);
    }

    public static Sign sign(SignAlgorithm algorithm, String privateKeyBase64, String publicKeyBase64) {
        return SignUtil.sign(algorithm, privateKeyBase64, publicKeyBase64);
    }

    public static Sign sign(SignAlgorithm algorithm, byte[] privateKey, byte[] publicKey) {
        return SignUtil.sign(algorithm, privateKey, publicKey);
    }

    public static String signParams(SymmetricCrypto crypto, Map<?, ?> params, String ... otherParams) {
        return SignUtil.signParams(crypto, params, otherParams);
    }

    public static String signParams(SymmetricCrypto crypto, Map<?, ?> params, String separator, String keyValueSeparator, boolean isIgnoreNull, String ... otherParams) {
        return SignUtil.signParams(crypto, params, separator, keyValueSeparator, isIgnoreNull, otherParams);
    }

    public static String signParamsMd5(Map<?, ?> params, String ... otherParams) {
        return SignUtil.signParamsMd5(params, otherParams);
    }

    public static String signParamsSha1(Map<?, ?> params, String ... otherParams) {
        return SignUtil.signParamsSha1(params, otherParams);
    }

    public static String signParamsSha256(Map<?, ?> params, String ... otherParams) {
        return SignUtil.signParamsSha256(params, otherParams);
    }

    public static String signParams(DigestAlgorithm digestAlgorithm, Map<?, ?> params, String ... otherParams) {
        return SignUtil.signParams(digestAlgorithm, params, otherParams);
    }

    public static String signParams(DigestAlgorithm digestAlgorithm, Map<?, ?> params, String separator, String keyValueSeparator, boolean isIgnoreNull, String ... otherParams) {
        return SignUtil.signParams(digestAlgorithm, params, separator, keyValueSeparator, isIgnoreNull, otherParams);
    }

    public static void addProvider(Provider provider) {
        Security.insertProviderAt((Provider)provider, (int)0);
    }

    public static byte[] decode(String key) {
        boolean decodeHex = SystemPropsUtil.getBoolean(HUTOOL_CRYPTO_DECODE_HEX, true);
        return decodeHex && Validator.isHex(key) ? HexUtil.decodeHex(key) : Base64.decode(key);
    }

    public static Cipher createCipher(String algorithm) {
        Cipher cipher;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            cipher = null == provider ? Cipher.getInstance((String)algorithm) : Cipher.getInstance((String)algorithm, (Provider)provider);
        }
        catch (Exception e) {
            throw new CryptoException(e);
        }
        return cipher;
    }

    public static MessageDigest createMessageDigest(String algorithm) {
        MessageDigest messageDigest;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            messageDigest = null == provider ? MessageDigest.getInstance((String)algorithm) : MessageDigest.getInstance((String)algorithm, (Provider)provider);
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
        return messageDigest;
    }

    public static MessageDigest createJdkMessageDigest(String algorithm) {
        try {
            return MessageDigest.getInstance((String)algorithm);
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }

    public static Mac createMac(String algorithm) {
        Mac mac;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            mac = null == provider ? Mac.getInstance((String)algorithm) : Mac.getInstance((String)algorithm, (Provider)provider);
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
        return mac;
    }

    public static Signature createSignature(String algorithm) {
        Signature signature;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            signature = null == provider ? Signature.getInstance((String)algorithm) : Signature.getInstance((String)algorithm, (Provider)provider);
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
        return signature;
    }

    public static RC4 rc4(String key) {
        return new RC4(key);
    }

    public static void disableBouncyCastle() {
        GlobalBouncyCastleProvider.setUseBouncyCastle(false);
    }

    public static String pbkdf2(char[] password, byte[] salt) {
        return new PBKDF2().encryptHex(password, salt);
    }

    public static FPE fpe(FPE.FPEMode mode, byte[] key, AlphabetMapper mapper, byte[] tweak) {
        return new FPE(mode, key, mapper, tweak);
    }

    public static ZUC zuc128(byte[] key, byte[] iv) {
        return new ZUC(ZUC.ZUCAlgorithm.ZUC_128, key, iv);
    }

    public static ZUC zuc256(byte[] key, byte[] iv) {
        return new ZUC(ZUC.ZUCAlgorithm.ZUC_256, key, iv);
    }
}

