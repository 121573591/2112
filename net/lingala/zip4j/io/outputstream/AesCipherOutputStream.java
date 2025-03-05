/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 */
package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.AESEncrypter;
import net.lingala.zip4j.io.outputstream.CipherOutputStream;
import net.lingala.zip4j.io.outputstream.ZipEntryOutputStream;
import net.lingala.zip4j.model.ZipParameters;

class AesCipherOutputStream
extends CipherOutputStream<AESEncrypter> {
    private byte[] pendingBuffer = new byte[16];
    private int pendingBufferLength = 0;

    public AesCipherOutputStream(ZipEntryOutputStream outputStream2, ZipParameters zipParameters, char[] password, boolean useUtf8ForPassword) throws IOException {
        super(outputStream2, zipParameters, password, useUtf8ForPassword);
    }

    @Override
    protected AESEncrypter initializeEncrypter(OutputStream outputStream2, ZipParameters zipParameters, char[] password, boolean useUtf8ForPassword) throws IOException {
        AESEncrypter encrypter = new AESEncrypter(password, zipParameters.getAesKeyStrength(), useUtf8ForPassword);
        this.writeAesEncryptionHeaderData(encrypter);
        return encrypter;
    }

    private void writeAesEncryptionHeaderData(AESEncrypter encrypter) throws IOException {
        this.writeHeaders(encrypter.getSaltBytes());
        this.writeHeaders(encrypter.getDerivedPasswordVerifier());
    }

    @Override
    public void write(int b) throws IOException {
        this.write(new byte[]{(byte)b});
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (len < 16 - this.pendingBufferLength) {
            System.arraycopy((Object)b, (int)off, (Object)this.pendingBuffer, (int)this.pendingBufferLength, (int)len);
            this.pendingBufferLength += len;
            return;
        }
        System.arraycopy((Object)b, (int)off, (Object)this.pendingBuffer, (int)this.pendingBufferLength, (int)(16 - this.pendingBufferLength));
        super.write(this.pendingBuffer, 0, this.pendingBuffer.length);
        off = 16 - this.pendingBufferLength;
        this.pendingBufferLength = 0;
        if ((len -= off) != 0 && len % 16 != 0) {
            System.arraycopy((Object)b, (int)(len + off - len % 16), (Object)this.pendingBuffer, (int)0, (int)(len % 16));
            this.pendingBufferLength = len % 16;
            len -= this.pendingBufferLength;
        }
        super.write(b, off, len);
    }

    @Override
    public void closeEntry() throws IOException {
        if (this.pendingBufferLength != 0) {
            super.write(this.pendingBuffer, 0, this.pendingBufferLength);
            this.pendingBufferLength = 0;
        }
        this.writeHeaders(((AESEncrypter)this.getEncrypter()).getFinalMac());
        super.closeEntry();
    }
}

