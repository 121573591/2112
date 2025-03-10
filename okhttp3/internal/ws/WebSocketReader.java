/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.ProtocolException
 *  java.util.concurrent.TimeUnit
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okhttp3.internal.ws.MessageInflater;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" T\n\n\n\n \n\n \n\n\b\n\n\b\n\n\n\b\n\t\n\b\n\n\b\n\n\b\n\n\b\n\b\n\b\b 20:1B/000\b0\t0¢\b\nJ\r0\fH¢\b\rJ\r0\f¢\bJ0\fH¢\bJ0\fH¢\bJ0\fH¢\bJ0\fH¢\bJ0\fH¢\bR08@X¢\n\bR08X¢\n\bR08X¢\n\bR08@X¢\n\bR08X¢\n\bR08@X¢\n\bR08@X¢\n\bR!0 8X¢\n\b!\"R$0#8X¢\n\b$%R&08X¢\n\b&R(0'8@X¢\n\b()R\t08X¢\n\b\tR+0*8@X¢\n\b+,R\b08X¢\n\b\bR-08@X¢\n\b-R08¢\f\n\b.\b/0¨2"}, d2={"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "", "isClient", "Lokio/BufferedSource;", "source", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "frameCallback", "perMessageDeflate", "noContextTakeover", "<init>", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "", "close", "()V", "processNextFrame", "readControlFrame", "readHeader", "readMessage", "readMessageFrame", "readUntilNonControlFrame", "closed", "Z", "Lokio/Buffer;", "controlFrameBuffer", "Lokio/Buffer;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "frameLength", "J", "isControlFrame", "isFinalFrame", "Lokio/Buffer$UnsafeCursor;", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "", "maskKey", "[B", "messageFrameBuffer", "Lokhttp3/internal/ws/MessageInflater;", "messageInflater", "Lokhttp3/internal/ws/MessageInflater;", "", "opcode", "I", "readingCompressedMessage", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "FrameCallback", "okhttp"})
@SourceDebugExtension(value={"SMAP\nWebSocketReader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketReader.kt\nokhttp3/internal/ws/WebSocketReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,298:1\n1#2:299\n*E\n"})
public final class WebSocketReader
implements Closeable {
    private final boolean isClient;
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final FrameCallback frameCallback;
    private final boolean perMessageDeflate;
    private final boolean noContextTakeover;
    private boolean closed;
    private int opcode;
    private long frameLength;
    private boolean isFinalFrame;
    private boolean isControlFrame;
    private boolean readingCompressedMessage;
    @NotNull
    private final Buffer controlFrameBuffer;
    @NotNull
    private final Buffer messageFrameBuffer;
    @Nullable
    private MessageInflater messageInflater;
    @Nullable
    private final byte[] maskKey;
    @Nullable
    private final Buffer.UnsafeCursor maskCursor;

    public WebSocketReader(boolean isClient, @NotNull BufferedSource source2, @NotNull FrameCallback frameCallback, boolean perMessageDeflate, boolean noContextTakeover) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)frameCallback, (String)"frameCallback");
        this.isClient = isClient;
        this.source = source2;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = perMessageDeflate;
        this.noContextTakeover = noContextTakeover;
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        this.maskKey = this.isClient ? null : new byte[4];
        this.maskCursor = this.isClient ? null : new Buffer.UnsafeCursor();
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        this.readHeader();
        if (this.isControlFrame) {
            this.readControlFrame();
        } else {
            this.readMessageFrame();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void readHeader() throws IOException, ProtocolException {
        boolean isMasked;
        boolean reservedFlag3;
        boolean reservedFlag2;
        if (this.closed) {
            throw new IOException("closed");
        }
        int b0 = 0;
        long timeoutBefore = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            b0 = Util.and(this.source.readByte(), 255);
        }
        finally {
            this.source.timeout().timeout(timeoutBefore, TimeUnit.NANOSECONDS);
        }
        this.opcode = b0 & 0xF;
        this.isFinalFrame = (b0 & 0x80) != 0;
        boolean bl = this.isControlFrame = (b0 & 8) != 0;
        if (this.isControlFrame && !this.isFinalFrame) {
            throw new ProtocolException("Control frames must be final.");
        }
        boolean reservedFlag1 = (b0 & 0x40) != 0;
        switch (this.opcode) {
            case 1: 
            case 2: {
                boolean bl2;
                if (reservedFlag1) {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    bl2 = true;
                } else {
                    bl2 = false;
                }
                this.readingCompressedMessage = bl2;
                break;
            }
            default: {
                if (!reservedFlag1) break;
                throw new ProtocolException("Unexpected rsv1 flag");
            }
        }
        boolean bl3 = reservedFlag2 = (b0 & 0x20) != 0;
        if (reservedFlag2) {
            throw new ProtocolException("Unexpected rsv2 flag");
        }
        boolean bl4 = reservedFlag3 = (b0 & 0x10) != 0;
        if (reservedFlag3) {
            throw new ProtocolException("Unexpected rsv3 flag");
        }
        int b1 = Util.and(this.source.readByte(), 255);
        boolean bl5 = isMasked = (b1 & 0x80) != 0;
        if (isMasked == this.isClient) {
            throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
        }
        this.frameLength = b1 & 0x7F;
        if (this.frameLength == 126L) {
            this.frameLength = Util.and(this.source.readShort(), 65535);
        } else if (this.frameLength == 127L) {
            this.frameLength = this.source.readLong();
            if (this.frameLength < 0L) {
                throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
            }
        }
        if (this.isControlFrame && this.frameLength > 125L) {
            throw new ProtocolException("Control frame must be less than 125B.");
        }
        if (isMasked) {
            Intrinsics.checkNotNull((Object)this.maskKey);
            this.source.readFully(this.maskKey);
        }
    }

    private final void readControlFrame() throws IOException {
        if (this.frameLength > 0L) {
            this.source.readFully(this.controlFrameBuffer, this.frameLength);
            if (!this.isClient) {
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.checkNotNull((Object)unsafeCursor);
                this.controlFrameBuffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0L);
                Intrinsics.checkNotNull((Object)this.maskKey);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 9: {
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                break;
            }
            case 10: {
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                break;
            }
            case 8: {
                int code = 1005;
                String reason = "";
                long bufferSize = this.controlFrameBuffer.size();
                if (bufferSize == 1L) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (bufferSize != 0L) {
                    code = this.controlFrameBuffer.readShort();
                    reason = this.controlFrameBuffer.readUtf8();
                    String codeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(code);
                    if (codeExceptionMessage != null) {
                        throw new ProtocolException(codeExceptionMessage);
                    }
                }
                this.frameCallback.onReadClose(code, reason);
                this.closed = true;
                break;
            }
            default: {
                throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
            }
        }
    }

    private final void readMessageFrame() throws IOException {
        int opcode = this.opcode;
        if (opcode != 1 && opcode != 2) {
            throw new ProtocolException("Unknown opcode: " + Util.toHexString(opcode));
        }
        this.readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                MessageInflater messageInflater2;
                MessageInflater it = messageInflater2 = new MessageInflater(this.noContextTakeover);
                boolean bl = false;
                this.messageInflater = it;
                messageInflater = messageInflater2;
            }
            MessageInflater messageInflater3 = messageInflater;
            messageInflater3.inflate(this.messageFrameBuffer);
        }
        if (opcode == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            this.readHeader();
            if (!this.isControlFrame) break;
            this.readControlFrame();
        }
    }

    private final void readMessage() throws IOException {
        block4: {
            do {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (this.frameLength > 0L) {
                    this.source.readFully(this.messageFrameBuffer, this.frameLength);
                    if (!this.isClient) {
                        Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                        Intrinsics.checkNotNull((Object)unsafeCursor);
                        this.messageFrameBuffer.readAndWriteUnsafe(unsafeCursor);
                        this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                        Intrinsics.checkNotNull((Object)this.maskKey);
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                }
                if (this.isFinalFrame) break block4;
                this.readUntilNonControlFrame();
            } while (this.opcode == 0);
            throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
        }
    }

    public void close() throws IOException {
        block0: {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) break block0;
            messageInflater.close();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" $\n\n \n\b\n \n\n \n\n\b\n\n\b\bf 20J02020H&¢\b\bJ\n02\t0H&¢\b\nJ\n02\r0\fH&¢\b\nJ020\fH&¢\bJ020\fH&¢\b¨"}, d2={"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "", "code", "", "reason", "", "onReadClose", "(ILjava/lang/String;)V", "text", "onReadMessage", "(Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokio/ByteString;)V", "payload", "onReadPing", "onReadPong", "okhttp"})
    public static interface FrameCallback {
        public void onReadMessage(@NotNull String var1) throws IOException;

        public void onReadMessage(@NotNull ByteString var1) throws IOException;

        public void onReadPing(@NotNull ByteString var1);

        public void onReadPong(@NotNull ByteString var1);

        public void onReadClose(int var1, @NotNull String var2);
    }
}

