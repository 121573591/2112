/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package net.lingala.zip4j.crypto;

import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.enums.AesKeyStrength;

public class AesCipherUtil {
    private static final int START_INDEX = 0;

    public static byte[] derivePasswordBasedKey(byte[] salt, char[] password, AesKeyStrength aesKeyStrength, boolean useUtf8ForPassword) throws ZipException {
        int macLength;
        PBKDF2Parameters parameters = new PBKDF2Parameters("HmacSHA1", "ISO-8859-1", salt, 1000);
        PBKDF2Engine engine = new PBKDF2Engine(parameters);
        int keyLength = aesKeyStrength.getKeyLength();
        int derivedKeyLength = keyLength + (macLength = aesKeyStrength.getMacLength()) + 2;
        byte[] derivedKey = engine.deriveKey(password, derivedKeyLength, useUtf8ForPassword);
        if (derivedKey != null && derivedKey.length == derivedKeyLength) {
            return derivedKey;
        }
        String message = String.format((String)"Derived Key invalid for Key Length [%d] MAC Length [%d]", (Object[])new Object[]{keyLength, macLength});
        throw new ZipException(message);
    }

    public static byte[] derivePasswordVerifier(byte[] derivedKey, AesKeyStrength aesKeyStrength) {
        byte[] derivedPasswordVerifier = new byte[2];
        int keyMacLength = aesKeyStrength.getKeyLength() + aesKeyStrength.getMacLength();
        System.arraycopy((Object)derivedKey, (int)keyMacLength, (Object)derivedPasswordVerifier, (int)0, (int)2);
        return derivedPasswordVerifier;
    }

    public static MacBasedPRF getMacBasedPRF(byte[] derivedKey, AesKeyStrength aesKeyStrength) {
        int macLength = aesKeyStrength.getMacLength();
        byte[] macKey = new byte[macLength];
        System.arraycopy((Object)derivedKey, (int)aesKeyStrength.getKeyLength(), (Object)macKey, (int)0, (int)macLength);
        MacBasedPRF macBasedPRF = new MacBasedPRF("HmacSHA1");
        macBasedPRF.init(macKey);
        return macBasedPRF;
    }

    public static AESEngine getAESEngine(byte[] derivedKey, AesKeyStrength aesKeyStrength) throws ZipException {
        int keyLength = aesKeyStrength.getKeyLength();
        byte[] aesKey = new byte[keyLength];
        System.arraycopy((Object)derivedKey, (int)0, (Object)aesKey, (int)0, (int)keyLength);
        return new AESEngine(aesKey);
    }

    public static void prepareBuffAESIVBytes(byte[] buff, int nonce) {
        buff[0] = (byte)nonce;
        buff[1] = (byte)(nonce >> 8);
        buff[2] = (byte)(nonce >> 16);
        buff[3] = (byte)(nonce >> 24);
        for (int i = 4; i <= 15; ++i) {
            buff[i] = 0;
        }
    }
}

