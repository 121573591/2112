/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio.internal.-ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={" N\n\n \n\b\n\b\n\n\b\n\t\n\b\n\n\b\n\n\b\n\n\b\t\n\n\b\n\n\n\b\n\n\b7\b020 2020 2020H ¢\b\b\t'0\r20\n2\f0\n20\nH ¢\b 0\n2020\nH\b¢\b 0\n20\n20H\b¢\b020H ¢\b0*020H\f¢\b0\n*020\nH\f¢\b0\n*020\nH\f¢\b0*020H\f¢\b0*0 20H ¢\b 0*0!2\"0H ¢\b#$0*0H ¢\b$%$0\n*0\nH ¢\b$&$0'*0'H ¢\b$()0\n*0\n20H\f¢\b)*0*020H\f¢\b*+0*020H\f¢\b+-0,*0H ¢\b-.-0,*0H ¢\b-/-0,*0\nH ¢\b-010*020H\f¢\b12\"308 XD¢\f\n\b34\b56\" 708 X¢\n\b78\b;<\b9:¨="}, d2={"", "a", "", "aOffset", "b", "bOffset", "byteCount", "", "arrayRangeEquals", "([BI[BII)Z", "", "size", "offset", "", "checkOffsetAndCount", "(JJJ)V", "minOf", "(IJ)J", "(JI)J", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "resolveDefaultParameter", "(Lokio/Buffer$UnsafeCursor;)Lokio/Buffer$UnsafeCursor;", "", "other", "and", "(BI)I", "(BJ)J", "bitCount", "leftRotate", "(II)I", "sizeParam", "([BI)I", "Lokio/ByteString;", "position", "(Lokio/ByteString;I)I", "reverseBytes", "(I)I", "(J)J", "", "(S)S", "rightRotate", "shl", "shr", "", "toHexString", "(B)Ljava/lang/String;", "(I)Ljava/lang/String;", "(J)Ljava/lang/String;", "xor", "(BB)B", "DEFAULT__ByteString_size", "I", "getDEFAULT__ByteString_size", "()I", "DEFAULT__new_UnsafeCursor", "Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "okio"})
@JvmName(name="-SegmentedByteString")
@SourceDebugExtension(value={"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,187:1\n68#1:188\n74#1:189\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokio/-SegmentedByteString\n*L\n106#1:188\n107#1:189\n*E\n"})
public final class -SegmentedByteString {
    @NotNull
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
    private static final int DEFAULT__ByteString_size = -1234567890;

    public static final void checkOffsetAndCount(long size, long offset, long byteCount) {
        if ((offset | byteCount) < 0L || offset > size || size - offset < byteCount) {
            throw new ArrayIndexOutOfBoundsException("size=" + size + " offset=" + offset + " byteCount=" + byteCount);
        }
    }

    public static final short reverseBytes(short $this$reverseBytes) {
        int i = $this$reverseBytes & 0xFFFF;
        int reversed = (i & 0xFF00) >>> 8 | (i & 0xFF) << 8;
        return (short)reversed;
    }

    public static final int reverseBytes(int $this$reverseBytes) {
        return ($this$reverseBytes & 0xFF000000) >>> 24 | ($this$reverseBytes & 0xFF0000) >>> 8 | ($this$reverseBytes & 0xFF00) << 8 | ($this$reverseBytes & 0xFF) << 24;
    }

    public static final long reverseBytes(long $this$reverseBytes) {
        return ($this$reverseBytes & 0xFF00000000000000L) >>> 56 | ($this$reverseBytes & 0xFF000000000000L) >>> 40 | ($this$reverseBytes & 0xFF0000000000L) >>> 24 | ($this$reverseBytes & 0xFF00000000L) >>> 8 | ($this$reverseBytes & 0xFF000000L) << 8 | ($this$reverseBytes & 0xFF0000L) << 24 | ($this$reverseBytes & 0xFF00L) << 40 | ($this$reverseBytes & 0xFFL) << 56;
    }

    public static final int leftRotate(int $this$leftRotate, int bitCount) {
        boolean $i$f$leftRotate = false;
        return $this$leftRotate << bitCount | $this$leftRotate >>> 32 - bitCount;
    }

    public static final long rightRotate(long $this$rightRotate, int bitCount) {
        boolean $i$f$rightRotate = false;
        return $this$rightRotate >>> bitCount | $this$rightRotate << 64 - bitCount;
    }

    public static final int shr(byte $this$shr, int other) {
        boolean $i$f$shr = false;
        return $this$shr >> other;
    }

    public static final int shl(byte $this$shl, int other) {
        boolean $i$f$shl = false;
        return $this$shl << other;
    }

    public static final int and(byte $this$and, int other) {
        boolean $i$f$and = false;
        return $this$and & other;
    }

    public static final long and(byte $this$and, long other) {
        boolean $i$f$and = false;
        return (long)$this$and & other;
    }

    public static final byte xor(byte $this$xor, byte other) {
        boolean $i$f$xor = false;
        return (byte)($this$xor ^ other);
    }

    public static final long and(int $this$and, long other) {
        boolean $i$f$and = false;
        return (long)$this$and & other;
    }

    public static final long minOf(long a, int b) {
        boolean $i$f$minOf = false;
        return Math.min((long)a, (long)b);
    }

    public static final long minOf(int a, long b) {
        boolean $i$f$minOf = false;
        return Math.min((long)a, (long)b);
    }

    public static final boolean arrayRangeEquals(@NotNull byte[] a, int aOffset, @NotNull byte[] b, int bOffset, int byteCount) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        for (int i = 0; i < byteCount; ++i) {
            if (a[i + aOffset] == b[i + bOffset]) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String toHexString(byte $this$toHexString) {
        void $this$and$iv;
        byte $this$shr$iv;
        char[] result = new char[2];
        byte by = $this$toHexString;
        int other$iv = 4;
        boolean $i$f$shr = false;
        result[0] = -ByteString.getHEX_DIGIT_CHARS()[$this$shr$iv >> other$iv & 0xF];
        $this$shr$iv = $this$toHexString;
        other$iv = 15;
        boolean $i$f$and = false;
        result[1] = -ByteString.getHEX_DIGIT_CHARS()[$this$and$iv & other$iv];
        return StringsKt.concatToString((char[])result);
    }

    @NotNull
    public static final String toHexString(int $this$toHexString) {
        int i;
        if ($this$toHexString == 0) {
            return "0";
        }
        char[] result = new char[]{-ByteString.getHEX_DIGIT_CHARS()[$this$toHexString >> 28 & 0xF], -ByteString.getHEX_DIGIT_CHARS()[$this$toHexString >> 24 & 0xF], -ByteString.getHEX_DIGIT_CHARS()[$this$toHexString >> 20 & 0xF], -ByteString.getHEX_DIGIT_CHARS()[$this$toHexString >> 16 & 0xF], -ByteString.getHEX_DIGIT_CHARS()[$this$toHexString >> 12 & 0xF], -ByteString.getHEX_DIGIT_CHARS()[$this$toHexString >> 8 & 0xF], -ByteString.getHEX_DIGIT_CHARS()[$this$toHexString >> 4 & 0xF], -ByteString.getHEX_DIGIT_CHARS()[$this$toHexString & 0xF]};
        for (i = 0; i < result.length && result[i] == '0'; ++i) {
        }
        return StringsKt.concatToString((char[])result, (int)i, (int)result.length);
    }

    @NotNull
    public static final String toHexString(long $this$toHexString) {
        int i;
        if ($this$toHexString == 0L) {
            return "0";
        }
        char[] result = new char[]{-ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 60 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 56 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 52 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 48 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 44 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 40 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 36 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 32 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 28 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 24 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 20 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 16 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 12 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 8 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString >> 4 & 0xFL)], -ByteString.getHEX_DIGIT_CHARS()[(int)($this$toHexString & 0xFL)]};
        for (i = 0; i < result.length && result[i] == '0'; ++i) {
        }
        return StringsKt.concatToString((char[])result, (int)i, (int)result.length);
    }

    @NotNull
    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }

    @NotNull
    public static final Buffer.UnsafeCursor resolveDefaultParameter(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"unsafeCursor");
        if (unsafeCursor == DEFAULT__new_UnsafeCursor) {
            return new Buffer.UnsafeCursor();
        }
        return unsafeCursor;
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final int resolveDefaultParameter(@NotNull ByteString $this$resolveDefaultParameter, int position) {
        Intrinsics.checkNotNullParameter((Object)$this$resolveDefaultParameter, (String)"<this>");
        if (position == DEFAULT__ByteString_size) {
            return $this$resolveDefaultParameter.size();
        }
        return position;
    }

    public static final int resolveDefaultParameter(@NotNull byte[] $this$resolveDefaultParameter, int sizeParam) {
        Intrinsics.checkNotNullParameter((Object)$this$resolveDefaultParameter, (String)"<this>");
        if (sizeParam == DEFAULT__ByteString_size) {
            return $this$resolveDefaultParameter.length;
        }
        return sizeParam;
    }
}

