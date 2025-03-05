/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.security.InvalidAlgorithmParameterException
 *  java.security.InvalidKeyException
 *  java.security.Key
 *  java.security.KeyFactory
 *  java.security.KeyPair
 *  java.security.KeyPairGenerator
 *  java.security.KeyStore
 *  java.security.KeyStoreException
 *  java.security.NoSuchAlgorithmException
 *  java.security.PrivateKey
 *  java.security.Provider
 *  java.security.PublicKey
 *  java.security.SecureRandom
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateException
 *  java.security.cert.CertificateFactory
 *  java.security.interfaces.RSAPrivateCrtKey
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.ECGenParameterSpec
 *  java.security.spec.InvalidKeySpecException
 *  java.security.spec.KeySpec
 *  java.security.spec.PKCS8EncodedKeySpec
 *  java.security.spec.RSAPublicKeySpec
 *  java.security.spec.X509EncodedKeySpec
 *  javax.crypto.KeyGenerator
 *  javax.crypto.SecretKey
 *  javax.crypto.SecretKeyFactory
 *  javax.crypto.spec.DESKeySpec
 *  javax.crypto.spec.DESedeKeySpec
 *  javax.crypto.spec.PBEKeySpec
 *  javax.crypto.spec.SecretKeySpec
 */
package cn.hutool.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.CryptoException;
import cn.hutool.crypto.GlobalBouncyCastleProvider;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class KeyUtil {
    public static final String KEY_TYPE_JKS = "JKS";
    public static final String KEY_TYPE_JCEKS = "jceks";
    public static final String KEY_TYPE_PKCS12 = "pkcs12";
    public static final String CERT_TYPE_X509 = "X.509";
    public static final int DEFAULT_KEY_SIZE = 1024;
    public static final String SM2_DEFAULT_CURVE = "sm2p256v1";

    public static SecretKey generateKey(String algorithm) {
        return KeyUtil.generateKey(algorithm, -1);
    }

    public static SecretKey generateKey(String algorithm, int keySize) {
        return KeyUtil.generateKey(algorithm, keySize, null);
    }

    public static SecretKey generateKey(String algorithm, int keySize, SecureRandom random) {
        algorithm = KeyUtil.getMainAlgorithm(algorithm);
        KeyGenerator keyGenerator = KeyUtil.getKeyGenerator(algorithm);
        if (keySize <= 0 && SymmetricAlgorithm.AES.getValue().equals((Object)algorithm)) {
            keySize = 128;
        }
        if (keySize > 0) {
            if (null == random) {
                keyGenerator.init(keySize);
            } else {
                keyGenerator.init(keySize, random);
            }
        }
        return keyGenerator.generateKey();
    }

    public static SecretKey generateKey(String algorithm, byte[] key) {
        Assert.notBlank(algorithm, "Algorithm is blank!", new Object[0]);
        Object secretKey = algorithm.startsWith("PBE") ? KeyUtil.generatePBEKey(algorithm, null == key ? null : StrUtil.utf8Str(key).toCharArray()) : (algorithm.startsWith("DES") ? KeyUtil.generateDESKey(algorithm, key) : (null == key ? KeyUtil.generateKey(algorithm) : new SecretKeySpec(key, algorithm)));
        return secretKey;
    }

    public static SecretKey generateDESKey(String algorithm, byte[] key) {
        SecretKey secretKey;
        if (StrUtil.isBlank(algorithm) || !algorithm.startsWith("DES")) {
            throw new CryptoException("Algorithm [{}] is not a DES algorithm!", algorithm);
        }
        if (null == key) {
            secretKey = KeyUtil.generateKey(algorithm);
        } else {
            Object keySpec;
            try {
                keySpec = algorithm.startsWith("DESede") ? new DESedeKeySpec(key) : new DESKeySpec(key);
            }
            catch (InvalidKeyException e) {
                throw new CryptoException(e);
            }
            secretKey = KeyUtil.generateKey(algorithm, (KeySpec)keySpec);
        }
        return secretKey;
    }

    public static SecretKey generatePBEKey(String algorithm, char[] key) {
        if (StrUtil.isBlank(algorithm) || !algorithm.startsWith("PBE")) {
            throw new CryptoException("Algorithm [{}] is not a PBE algorithm!", algorithm);
        }
        if (null == key) {
            key = RandomUtil.randomString(32).toCharArray();
        }
        PBEKeySpec keySpec = new PBEKeySpec(key);
        return KeyUtil.generateKey(algorithm, (KeySpec)keySpec);
    }

    public static SecretKey generateKey(String algorithm, KeySpec keySpec) {
        SecretKeyFactory keyFactory = KeyUtil.getSecretKeyFactory(algorithm);
        try {
            return keyFactory.generateSecret(keySpec);
        }
        catch (InvalidKeySpecException e) {
            throw new CryptoException(e);
        }
    }

    public static PrivateKey generateRSAPrivateKey(byte[] key) {
        return KeyUtil.generatePrivateKey(AsymmetricAlgorithm.RSA.getValue(), key);
    }

    public static PrivateKey generatePrivateKey(String algorithm, byte[] key) {
        if (null == key) {
            return null;
        }
        return KeyUtil.generatePrivateKey(algorithm, (KeySpec)new PKCS8EncodedKeySpec(key));
    }

    public static PrivateKey generatePrivateKey(String algorithm, KeySpec keySpec) {
        if (null == keySpec) {
            return null;
        }
        algorithm = KeyUtil.getAlgorithmAfterWith(algorithm);
        try {
            return KeyUtil.getKeyFactory(algorithm).generatePrivate(keySpec);
        }
        catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    public static PrivateKey generatePrivateKey(KeyStore keyStore, String alias, char[] password) {
        try {
            return (PrivateKey)keyStore.getKey(alias, password);
        }
        catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    public static PublicKey generateRSAPublicKey(byte[] key) {
        return KeyUtil.generatePublicKey(AsymmetricAlgorithm.RSA.getValue(), key);
    }

    public static PublicKey generatePublicKey(String algorithm, byte[] key) {
        if (null == key) {
            return null;
        }
        return KeyUtil.generatePublicKey(algorithm, (KeySpec)new X509EncodedKeySpec(key));
    }

    public static PublicKey generatePublicKey(String algorithm, KeySpec keySpec) {
        if (null == keySpec) {
            return null;
        }
        algorithm = KeyUtil.getAlgorithmAfterWith(algorithm);
        try {
            return KeyUtil.getKeyFactory(algorithm).generatePublic(keySpec);
        }
        catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    public static KeyPair generateKeyPair(String algorithm) {
        int keySize = 1024;
        if ("ECIES".equalsIgnoreCase(algorithm)) {
            keySize = 256;
        }
        return KeyUtil.generateKeyPair(algorithm, keySize);
    }

    public static KeyPair generateKeyPair(String algorithm, int keySize) {
        return KeyUtil.generateKeyPair(algorithm, keySize, null);
    }

    public static KeyPair generateKeyPair(String algorithm, int keySize, byte[] seed) {
        if ("SM2".equalsIgnoreCase(algorithm)) {
            ECGenParameterSpec sm2p256v1 = new ECGenParameterSpec(SM2_DEFAULT_CURVE);
            return KeyUtil.generateKeyPair(algorithm, keySize, seed, new AlgorithmParameterSpec[]{sm2p256v1});
        }
        return KeyUtil.generateKeyPair(algorithm, keySize, seed, (AlgorithmParameterSpec[])null);
    }

    public static KeyPair generateKeyPair(String algorithm, AlgorithmParameterSpec params) {
        return KeyUtil.generateKeyPair(algorithm, null, params);
    }

    public static KeyPair generateKeyPair(String algorithm, byte[] seed, AlgorithmParameterSpec param) {
        return KeyUtil.generateKeyPair(algorithm, 1024, seed, param);
    }

    public static KeyPair generateKeyPair(String algorithm, int keySize, byte[] seed, AlgorithmParameterSpec ... params) {
        return KeyUtil.generateKeyPair(algorithm, keySize, RandomUtil.createSecureRandom(seed), params);
    }

    public static KeyPair generateKeyPair(String algorithm, int keySize, SecureRandom random, AlgorithmParameterSpec ... params) {
        algorithm = KeyUtil.getAlgorithmAfterWith(algorithm);
        KeyPairGenerator keyPairGen = KeyUtil.getKeyPairGenerator(algorithm);
        if (keySize > 0) {
            if ("EC".equalsIgnoreCase(algorithm) && keySize > 256) {
                keySize = 256;
            }
            if (null != random) {
                keyPairGen.initialize(keySize, random);
            } else {
                keyPairGen.initialize(keySize);
            }
        }
        if (ArrayUtil.isNotEmpty(params)) {
            for (AlgorithmParameterSpec param : params) {
                if (null == param) continue;
                try {
                    if (null != random) {
                        keyPairGen.initialize(param, random);
                        continue;
                    }
                    keyPairGen.initialize(param);
                }
                catch (InvalidAlgorithmParameterException e) {
                    throw new CryptoException(e);
                }
            }
        }
        return keyPairGen.generateKeyPair();
    }

    public static KeyPairGenerator getKeyPairGenerator(String algorithm) {
        KeyPairGenerator keyPairGen;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            keyPairGen = null == provider ? KeyPairGenerator.getInstance((String)KeyUtil.getMainAlgorithm(algorithm)) : KeyPairGenerator.getInstance((String)KeyUtil.getMainAlgorithm(algorithm), (Provider)provider);
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
        return keyPairGen;
    }

    public static KeyFactory getKeyFactory(String algorithm) {
        KeyFactory keyFactory;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            keyFactory = null == provider ? KeyFactory.getInstance((String)KeyUtil.getMainAlgorithm(algorithm)) : KeyFactory.getInstance((String)KeyUtil.getMainAlgorithm(algorithm), (Provider)provider);
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
        return keyFactory;
    }

    public static SecretKeyFactory getSecretKeyFactory(String algorithm) {
        SecretKeyFactory keyFactory;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            keyFactory = null == provider ? SecretKeyFactory.getInstance((String)KeyUtil.getMainAlgorithm(algorithm)) : SecretKeyFactory.getInstance((String)KeyUtil.getMainAlgorithm(algorithm), (Provider)provider);
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
        return keyFactory;
    }

    public static KeyGenerator getKeyGenerator(String algorithm) {
        KeyGenerator generator;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            generator = null == provider ? KeyGenerator.getInstance((String)KeyUtil.getMainAlgorithm(algorithm)) : KeyGenerator.getInstance((String)KeyUtil.getMainAlgorithm(algorithm), (Provider)provider);
        }
        catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
        return generator;
    }

    public static String getMainAlgorithm(String algorithm) {
        Assert.notBlank(algorithm, "Algorithm must be not blank!", new Object[0]);
        int slashIndex = algorithm.indexOf(47);
        if (slashIndex > 0) {
            return algorithm.substring(0, slashIndex);
        }
        return algorithm;
    }

    public static String getAlgorithmAfterWith(String algorithm) {
        Assert.notNull(algorithm, "algorithm must be not null !", new Object[0]);
        if (StrUtil.startWithIgnoreCase(algorithm, "ECIESWith")) {
            return "EC";
        }
        int indexOfWith = StrUtil.lastIndexOfIgnoreCase(algorithm, "with");
        if (indexOfWith > 0) {
            algorithm = StrUtil.subSuf(algorithm, indexOfWith + "with".length());
        }
        if ("ECDSA".equalsIgnoreCase(algorithm) || "SM2".equalsIgnoreCase(algorithm) || "ECIES".equalsIgnoreCase(algorithm)) {
            algorithm = "EC";
        }
        return algorithm;
    }

    public static KeyStore readJKSKeyStore(File keyFile, char[] password) {
        return KeyUtil.readKeyStore(KEY_TYPE_JKS, keyFile, password);
    }

    public static KeyStore readJKSKeyStore(InputStream in, char[] password) {
        return KeyUtil.readKeyStore(KEY_TYPE_JKS, in, password);
    }

    public static KeyStore readPKCS12KeyStore(File keyFile, char[] password) {
        return KeyUtil.readKeyStore(KEY_TYPE_PKCS12, keyFile, password);
    }

    public static KeyStore readPKCS12KeyStore(InputStream in, char[] password) {
        return KeyUtil.readKeyStore(KEY_TYPE_PKCS12, in, password);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static KeyStore readKeyStore(String type, File keyFile, char[] password) {
        BufferedInputStream in = null;
        try {
            in = FileUtil.getInputStream(keyFile);
            KeyStore keyStore = KeyUtil.readKeyStore(type, (InputStream)in, password);
            return keyStore;
        }
        finally {
            IoUtil.close((Closeable)in);
        }
    }

    public static KeyStore readKeyStore(String type, InputStream in, char[] password) {
        KeyStore keyStore = KeyUtil.getKeyStore(type);
        try {
            keyStore.load(in, password);
        }
        catch (Exception e) {
            throw new CryptoException(e);
        }
        return keyStore;
    }

    public static KeyStore getKeyStore(String type) {
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            return null == provider ? KeyStore.getInstance((String)type) : KeyStore.getInstance((String)type, (Provider)provider);
        }
        catch (KeyStoreException e) {
            throw new CryptoException(e);
        }
    }

    public static KeyPair getKeyPair(String type, InputStream in, char[] password, String alias) {
        KeyStore keyStore = KeyUtil.readKeyStore(type, in, password);
        return KeyUtil.getKeyPair(keyStore, password, alias);
    }

    public static KeyPair getKeyPair(KeyStore keyStore, char[] password, String alias) {
        PrivateKey privateKey;
        PublicKey publicKey;
        try {
            publicKey = keyStore.getCertificate(alias).getPublicKey();
            privateKey = (PrivateKey)keyStore.getKey(alias, password);
        }
        catch (Exception e) {
            throw new CryptoException(e);
        }
        return new KeyPair(publicKey, privateKey);
    }

    public static Certificate readX509Certificate(InputStream in, char[] password, String alias) {
        return KeyUtil.readCertificate(CERT_TYPE_X509, in, password, alias);
    }

    public static PublicKey readPublicKeyFromCert(InputStream in) {
        Certificate certificate = KeyUtil.readX509Certificate(in);
        if (null != certificate) {
            return certificate.getPublicKey();
        }
        return null;
    }

    public static Certificate readX509Certificate(InputStream in) {
        return KeyUtil.readCertificate(CERT_TYPE_X509, in);
    }

    public static Certificate readCertificate(String type, InputStream in, char[] password, String alias) {
        KeyStore keyStore = KeyUtil.readKeyStore(type, in, password);
        try {
            return keyStore.getCertificate(alias);
        }
        catch (KeyStoreException e) {
            throw new CryptoException(e);
        }
    }

    public static Certificate readCertificate(String type, InputStream in) {
        try {
            return KeyUtil.getCertificateFactory(type).generateCertificate(in);
        }
        catch (CertificateException e) {
            throw new CryptoException(e);
        }
    }

    public static Certificate getCertificate(KeyStore keyStore, String alias) {
        try {
            return keyStore.getCertificate(alias);
        }
        catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    public static CertificateFactory getCertificateFactory(String type) {
        CertificateFactory factory2;
        Provider provider = GlobalBouncyCastleProvider.INSTANCE.getProvider();
        try {
            factory2 = null == provider ? CertificateFactory.getInstance((String)type) : CertificateFactory.getInstance((String)type, (Provider)provider);
        }
        catch (CertificateException e) {
            throw new CryptoException(e);
        }
        return factory2;
    }

    public static byte[] encodeECPublicKey(PublicKey publicKey) {
        return BCUtil.encodeECPublicKey(publicKey);
    }

    public static PublicKey decodeECPoint(String encode, String curveName) {
        return BCUtil.decodeECPoint(encode, curveName);
    }

    public static PublicKey decodeECPoint(byte[] encodeByte, String curveName) {
        return BCUtil.decodeECPoint(encodeByte, curveName);
    }

    public static PublicKey getRSAPublicKey(PrivateKey privateKey) {
        if (privateKey instanceof RSAPrivateCrtKey) {
            RSAPrivateCrtKey privk = (RSAPrivateCrtKey)privateKey;
            return KeyUtil.getRSAPublicKey(privk.getModulus(), privk.getPublicExponent());
        }
        return null;
    }

    public static PublicKey getRSAPublicKey(String modulus, String publicExponent) {
        return KeyUtil.getRSAPublicKey(new BigInteger(modulus, 16), new BigInteger(publicExponent, 16));
    }

    public static PublicKey getRSAPublicKey(BigInteger modulus, BigInteger publicExponent) {
        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
        try {
            return KeyUtil.getKeyFactory("RSA").generatePublic((KeySpec)publicKeySpec);
        }
        catch (InvalidKeySpecException e) {
            throw new CryptoException(e);
        }
    }

    public static String toBase64(Key key) {
        return Base64.encode(key.getEncoded());
    }
}

