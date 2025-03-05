/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.security.Key
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.spec.ECParameterSpec
 *  java.security.spec.ECPoint
 *  java.security.spec.ECPublicKeySpec
 *  java.security.spec.KeySpec
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.asn1.x9.X9ECParameters
 *  org.bouncycastle.crypto.params.AsymmetricKeyParameter
 *  org.bouncycastle.crypto.params.ECDomainParameters
 *  org.bouncycastle.crypto.params.ECPrivateKeyParameters
 *  org.bouncycastle.crypto.params.ECPublicKeyParameters
 *  org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey
 *  org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey
 *  org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util
 *  org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil
 *  org.bouncycastle.jce.spec.ECNamedCurveSpec
 *  org.bouncycastle.jce.spec.ECParameterSpec
 *  org.bouncycastle.math.ec.ECCurve
 *  org.bouncycastle.math.ec.ECPoint
 */
package cn.hutool.crypto;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.crypto.ECKeyUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.PemUtil;
import cn.hutool.crypto.SecureUtil;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

public class BCUtil {
    public static byte[] encodeECPrivateKey(PrivateKey privateKey) {
        return ((BCECPrivateKey)privateKey).getD().toByteArray();
    }

    public static byte[] encodeECPublicKey(PublicKey publicKey) {
        return BCUtil.encodeECPublicKey(publicKey, true);
    }

    public static byte[] encodeECPublicKey(PublicKey publicKey, boolean isCompressed) {
        return ((BCECPublicKey)publicKey).getQ().getEncoded(isCompressed);
    }

    public static PublicKey decodeECPoint(String encode, String curveName) {
        return BCUtil.decodeECPoint(SecureUtil.decode(encode), curveName);
    }

    public static PublicKey decodeECPoint(byte[] encodeByte, String curveName) {
        X9ECParameters x9ECParameters = ECUtil.getNamedCurveByName((String)curveName);
        ECCurve curve = x9ECParameters.getCurve();
        ECPoint point = EC5Util.convertPoint((org.bouncycastle.math.ec.ECPoint)curve.decodePoint(encodeByte));
        ECNamedCurveSpec ecSpec = new ECNamedCurveSpec(curveName, curve, x9ECParameters.getG(), x9ECParameters.getN());
        return KeyUtil.generatePublicKey("EC", (KeySpec)new ECPublicKeySpec(point, (ECParameterSpec)ecSpec));
    }

    public static ECDomainParameters toDomainParams(org.bouncycastle.jce.spec.ECParameterSpec parameterSpec) {
        return new ECDomainParameters(parameterSpec.getCurve(), parameterSpec.getG(), parameterSpec.getN(), parameterSpec.getH());
    }

    public static ECDomainParameters toDomainParams(String curveName) {
        return BCUtil.toDomainParams(ECUtil.getNamedCurveByName((String)curveName));
    }

    public static ECDomainParameters toDomainParams(X9ECParameters x9ECParameters) {
        return new ECDomainParameters(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH());
    }

    public static AsymmetricKeyParameter toParams(Key key) {
        return ECKeyUtil.toParams(key);
    }

    public static ECPrivateKeyParameters toSm2Params(String d) {
        return ECKeyUtil.toSm2PrivateParams(d);
    }

    public static ECPrivateKeyParameters toParams(String dHex, ECDomainParameters domainParameters) {
        return ECKeyUtil.toPrivateParams(dHex, domainParameters);
    }

    public static ECPrivateKeyParameters toSm2Params(byte[] d) {
        return ECKeyUtil.toSm2PrivateParams(d);
    }

    public static ECPrivateKeyParameters toParams(byte[] d, ECDomainParameters domainParameters) {
        return ECKeyUtil.toPrivateParams(d, domainParameters);
    }

    public static ECPrivateKeyParameters toSm2Params(BigInteger d) {
        return ECKeyUtil.toSm2PrivateParams(d);
    }

    public static ECPrivateKeyParameters toParams(BigInteger d, ECDomainParameters domainParameters) {
        return ECKeyUtil.toPrivateParams(d, domainParameters);
    }

    public static ECPublicKeyParameters toParams(BigInteger x, BigInteger y, ECDomainParameters domainParameters) {
        return ECKeyUtil.toPublicParams(x, y, domainParameters);
    }

    public static ECPublicKeyParameters toSm2Params(String xHex, String yHex) {
        return ECKeyUtil.toSm2PublicParams(xHex, yHex);
    }

    public static ECPublicKeyParameters toParams(String xHex, String yHex, ECDomainParameters domainParameters) {
        return ECKeyUtil.toPublicParams(xHex, yHex, domainParameters);
    }

    public static ECPublicKeyParameters toSm2Params(byte[] xBytes, byte[] yBytes) {
        return ECKeyUtil.toSm2PublicParams(xBytes, yBytes);
    }

    public static ECPublicKeyParameters toParams(byte[] xBytes, byte[] yBytes, ECDomainParameters domainParameters) {
        return ECKeyUtil.toPublicParams(xBytes, yBytes, domainParameters);
    }

    public static ECPublicKeyParameters toParams(PublicKey publicKey) {
        return ECKeyUtil.toPublicParams(publicKey);
    }

    public static ECPrivateKeyParameters toParams(PrivateKey privateKey) {
        return ECKeyUtil.toPrivateParams(privateKey);
    }

    public static PrivateKey readPemPrivateKey(InputStream pemStream) {
        return PemUtil.readPemPrivateKey(pemStream);
    }

    public static PublicKey readPemPublicKey(InputStream pemStream) {
        return PemUtil.readPemPublicKey(pemStream);
    }

    public static byte[] toPkcs1(PrivateKey privateKey) {
        PrivateKeyInfo pkInfo = PrivateKeyInfo.getInstance((Object)privateKey.getEncoded());
        try {
            return pkInfo.parsePrivateKey().toASN1Primitive().getEncoded();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public static byte[] toPkcs1(PublicKey publicKey) {
        SubjectPublicKeyInfo spkInfo = SubjectPublicKeyInfo.getInstance((Object)publicKey.getEncoded());
        try {
            return spkInfo.parsePublicKey().getEncoded();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }
}

