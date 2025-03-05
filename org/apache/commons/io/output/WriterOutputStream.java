/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.Writer
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CoderResult
 *  java.nio.charset.CodingErrorAction
 */
package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class WriterOutputStream
extends OutputStream {
    private static final int BUFFER_SIZE = 1024;
    private final Writer writer;
    private final CharsetDecoder decoder;
    private final boolean writeImmediately;
    private final ByteBuffer decoderIn = ByteBuffer.allocate((int)128);
    private final CharBuffer decoderOut;

    public WriterOutputStream(Writer writer, CharsetDecoder decoder) {
        this(writer, decoder, 1024, false);
    }

    public WriterOutputStream(Writer writer, CharsetDecoder decoder, int bufferSize, boolean writeImmediately) {
        WriterOutputStream.checkIbmJdkWithBrokenUTF16(decoder.charset());
        this.writer = writer;
        this.decoder = decoder;
        this.writeImmediately = writeImmediately;
        this.decoderOut = CharBuffer.allocate((int)bufferSize);
    }

    public WriterOutputStream(Writer writer, Charset charset, int bufferSize, boolean writeImmediately) {
        this(writer, charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?"), bufferSize, writeImmediately);
    }

    public WriterOutputStream(Writer writer, Charset charset) {
        this(writer, charset, 1024, false);
    }

    public WriterOutputStream(Writer writer, String charsetName, int bufferSize, boolean writeImmediately) {
        this(writer, Charset.forName((String)charsetName), bufferSize, writeImmediately);
    }

    public WriterOutputStream(Writer writer, String charsetName) {
        this(writer, charsetName, 1024, false);
    }

    @Deprecated
    public WriterOutputStream(Writer writer) {
        this(writer, Charset.defaultCharset(), 1024, false);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        while (len > 0) {
            int c = Math.min((int)len, (int)this.decoderIn.remaining());
            this.decoderIn.put(b, off, c);
            this.processInput(false);
            len -= c;
            off += c;
        }
        if (this.writeImmediately) {
            this.flushOutput();
        }
    }

    public void write(byte[] b) throws IOException {
        this.write(b, 0, b.length);
    }

    public void write(int b) throws IOException {
        this.write(new byte[]{(byte)b}, 0, 1);
    }

    public void flush() throws IOException {
        this.flushOutput();
        this.writer.flush();
    }

    public void close() throws IOException {
        this.processInput(true);
        this.flushOutput();
        this.writer.close();
    }

    private void processInput(boolean endOfInput) throws IOException {
        CoderResult coderResult;
        this.decoderIn.flip();
        while ((coderResult = this.decoder.decode(this.decoderIn, this.decoderOut, endOfInput)).isOverflow()) {
            this.flushOutput();
        }
        if (!coderResult.isUnderflow()) {
            throw new IOException("Unexpected coder result");
        }
        this.decoderIn.compact();
    }

    private void flushOutput() throws IOException {
        if (this.decoderOut.position() > 0) {
            this.writer.write(this.decoderOut.array(), 0, this.decoderOut.position());
            this.decoderOut.rewind();
        }
    }

    private static void checkIbmJdkWithBrokenUTF16(Charset charset) {
        if (!"UTF-16".equals((Object)charset.name())) {
            return;
        }
        String TEST_STRING_2 = "vés";
        byte[] bytes = "vés".getBytes(charset);
        CharsetDecoder charsetDecoder2 = charset.newDecoder();
        ByteBuffer bb2 = ByteBuffer.allocate((int)16);
        CharBuffer cb2 = CharBuffer.allocate((int)"vés".length());
        int len = bytes.length;
        for (int i = 0; i < len; ++i) {
            bb2.put(bytes[i]);
            bb2.flip();
            try {
                charsetDecoder2.decode(bb2, cb2, i == len - 1);
            }
            catch (IllegalArgumentException e) {
                throw new UnsupportedOperationException("UTF-16 requested when running on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
            }
            bb2.compact();
        }
        cb2.rewind();
        if (!"vés".equals((Object)cb2.toString())) {
            throw new UnsupportedOperationException("UTF-16 requested when running on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
        }
    }
}

