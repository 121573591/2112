/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.ByteArrayInputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.InputStream
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 */
package cn.hutool.crypto.digest.mac;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.CryptoException;
import cn.hutool.crypto.digest.mac.MacEngine;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class Mac
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final MacEngine engine;

    public Mac(MacEngine engine) {
        this.engine = engine;
    }

    public MacEngine getEngine() {
        return this.engine;
    }

    public byte[] digest(String data, Charset charset) {
        return this.digest(StrUtil.bytes((CharSequence)data, charset));
    }

    public byte[] digest(String data) {
        return this.digest(data, CharsetUtil.CHARSET_UTF_8);
    }

    public String digestBase64(String data, boolean isUrlSafe) {
        return this.digestBase64(data, CharsetUtil.CHARSET_UTF_8, isUrlSafe);
    }

    public String digestBase64(String data, Charset charset, boolean isUrlSafe) {
        byte[] digest = this.digest(data, charset);
        return isUrlSafe ? Base64.encodeUrlSafe(digest) : Base64.encode(digest);
    }

    public String digestHex(String data, Charset charset) {
        return HexUtil.encodeHexStr(this.digest(data, charset));
    }

    public String digestHex(String data) {
        return this.digestHex(data, CharsetUtil.CHARSET_UTF_8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public byte[] digest(File file) throws CryptoException {
        BufferedInputStream in = null;
        try {
            in = FileUtil.getInputStream(file);
            byte[] byArray = this.digest((InputStream)in);
            return byArray;
        }
        finally {
            IoUtil.close((Closeable)in);
        }
    }

    public String digestHex(File file) {
        return HexUtil.encodeHexStr(this.digest(file));
    }

    public byte[] digest(byte[] data) {
        return this.digest((InputStream)new ByteArrayInputStream(data), -1);
    }

    public String digestHex(byte[] data) {
        return HexUtil.encodeHexStr(this.digest(data));
    }

    public byte[] digest(InputStream data) {
        return this.digest(data, 8192);
    }

    public String digestHex(InputStream data) {
        return HexUtil.encodeHexStr(this.digest(data));
    }

    public byte[] digest(InputStream data, int bufferLength) {
        return this.engine.digest(data, bufferLength);
    }

    public String digestHex(InputStream data, int bufferLength) {
        return HexUtil.encodeHexStr(this.digest(data, bufferLength));
    }

    public boolean verify(byte[] digest, byte[] digestToCompare) {
        return MessageDigest.isEqual((byte[])digest, (byte[])digestToCompare);
    }

    public int getMacLength() {
        return this.engine.getMacLength();
    }

    public String getAlgorithm() {
        return this.engine.getAlgorithm();
    }
}

