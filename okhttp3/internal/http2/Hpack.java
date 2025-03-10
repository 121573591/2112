/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Huffman;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" ,\n\n \n\b\n\n\b\n$\n\b\n\b\f\n\n\n\b\bÆ 20:B\t\b¢\bJ020¢\bJ\n00\t0\bH¢\b\nR#\f00\t0\b8¢\f\n\b\f\r\bR0\t8XT¢\n\bR0\t8XT¢\n\bR0\t8XT¢\n\bR0\t8XT¢\n\bR0\t8XT¢\n\bR0\t8XT¢\n\bR\b008¢\f\n\b\b¨"}, d2={"Lokhttp3/internal/http2/Hpack;", "", "<init>", "()V", "Lokio/ByteString;", "name", "checkLowercase", "(Lokio/ByteString;)Lokio/ByteString;", "", "", "nameToFirstIndex", "()Ljava/util/Map;", "NAME_TO_FIRST_INDEX", "Ljava/util/Map;", "getNAME_TO_FIRST_INDEX", "PREFIX_4_BITS", "I", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "", "Lokhttp3/internal/http2/Header;", "STATIC_HEADER_TABLE", "[Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "Reader", "Writer", "okhttp"})
public final class Hpack {
    @NotNull
    public static final Hpack INSTANCE = new Hpack();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    @NotNull
    private static final Header[] STATIC_HEADER_TABLE;
    @NotNull
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;

    private Hpack() {
    }

    @NotNull
    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    @NotNull
    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap result = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int n = STATIC_HEADER_TABLE.length;
        for (int i = 0; i < n; ++i) {
            if (result.containsKey((Object)Hpack.STATIC_HEADER_TABLE[i].name)) continue;
            Integer n2 = i;
            ((Map)result).put((Object)Hpack.STATIC_HEADER_TABLE[i].name, (Object)n2);
        }
        Map map = Collections.unmodifiableMap((Map)((Map)result));
        Intrinsics.checkNotNullExpressionValue((Object)map, (String)"unmodifiableMap(result)");
        return map;
    }

    @NotNull
    public final ByteString checkLowercase(@NotNull ByteString name) throws IOException {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        int n = name.size();
        for (int i = 0; i < n; ++i) {
            byte by = name.getByte(i);
            boolean bl = 65 <= by ? by < 91 : false;
            if (!bl) continue;
            throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
        }
        return name;
    }

    static {
        Header[] headerArray = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        STATIC_HEADER_TABLE = headerArray;
        NAME_TO_FIRST_INDEX = INSTANCE.nameToFirstIndex();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" R\n\n \n\n \n\b\n\b\n\n\b\b\n \n\n\b\n\n\b\n\n\b\n\n\b\n!\n\b\n\n\b 20B#\b00\b\b0¢\b\bJ\n0\tH¢\b\nJ\f0\tH¢\b\fJ02\r0H¢\bJ020H¢\bJ\b00¢\bJ02\r0H¢\bJ0\t2\r020H¢\bJ02\r0H¢\bJ\r0¢\bJ 0H¢\b J\r!0¢\b!\"J\r#0\t¢\b#J$0\t2\r0H¢\b$%J(02&02'0¢\b()J+0\t2*0H¢\b+%J,0\tH¢\b,J-0\t2\r0H¢\b-%J.0\tH¢\b.R0\n00/8@X¢\n\b01R208@X¢\n\b23R408@X¢\n\b43R6\b0058X¢\n\b67R08X¢\n\b3R08@X¢\n\b3R808@X¢\n\b83R098X¢\n\b:¨;"}, d2={"Lokhttp3/internal/http2/Hpack$Reader;", "", "Lokio/Source;", "source", "", "headerTableSizeSetting", "maxDynamicTableByteCount", "<init>", "(Lokio/Source;II)V", "", "adjustDynamicTableByteCount", "()V", "clearDynamicTable", "index", "dynamicTableIndex", "(I)I", "bytesToRecover", "evictToRecoverBytes", "", "Lokhttp3/internal/http2/Header;", "getAndResetHeaderList", "()Ljava/util/List;", "Lokio/ByteString;", "getName", "(I)Lokio/ByteString;", "entry", "insertIntoDynamicTable", "(ILokhttp3/internal/http2/Header;)V", "", "isStaticHeader", "(I)Z", "()I", "readByte", "readByteString", "()Lokio/ByteString;", "readHeaders", "readIndexedHeader", "(I)V", "firstByte", "prefixMask", "readInt", "(II)I", "nameIndex", "readLiteralHeaderWithIncrementalIndexingIndexedName", "readLiteralHeaderWithIncrementalIndexingNewName", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "I", "headerCount", "", "headerList", "Ljava/util/List;", "nextHeaderIndex", "Lokio/BufferedSource;", "Lokio/BufferedSource;", "okhttp"})
    public static final class Reader {
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        @NotNull
        private final List<Header> headerList;
        @NotNull
        private final BufferedSource source;
        @JvmField
        @NotNull
        public Header[] dynamicTable;
        private int nextHeaderIndex;
        @JvmField
        public int headerCount;
        @JvmField
        public int dynamicTableByteCount;

        @JvmOverloads
        public Reader(@NotNull Source source2, int headerTableSizeSetting, int maxDynamicTableByteCount) {
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            this.headerTableSizeSetting = headerTableSizeSetting;
            this.maxDynamicTableByteCount = maxDynamicTableByteCount;
            this.headerList = (List)new ArrayList();
            this.source = Okio.buffer(source2);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
        }

        public /* synthetic */ Reader(Source source2, int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n3 & 4) != 0) {
                n2 = n;
            }
            this(source2, n, n2);
        }

        @NotNull
        public final List<Header> getAndResetHeaderList() {
            List result = CollectionsKt.toList((Iterable)((Iterable)this.headerList));
            this.headerList.clear();
            return result;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private final void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount < this.dynamicTableByteCount) {
                if (this.maxDynamicTableByteCount == 0) {
                    this.clearDynamicTable();
                } else {
                    this.evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt.fill$default((Object[])this.dynamicTable, null, (int)0, (int)0, (int)6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int bytesToRecover) {
            int bytesToRecover2 = bytesToRecover;
            int entriesToEvict = 0;
            if (bytesToRecover2 > 0) {
                for (int j = this.dynamicTable.length - 1; j >= this.nextHeaderIndex && bytesToRecover2 > 0; --j) {
                    Header toEvict;
                    Intrinsics.checkNotNull((Object)this.dynamicTable[j]);
                    bytesToRecover2 -= toEvict.hpackSize;
                    this.dynamicTableByteCount -= toEvict.hpackSize;
                    int n = this.headerCount;
                    this.headerCount = n + -1;
                    ++entriesToEvict;
                }
                System.arraycopy((Object)this.dynamicTable, (int)(this.nextHeaderIndex + 1), (Object)this.dynamicTable, (int)(this.nextHeaderIndex + 1 + entriesToEvict), (int)this.headerCount);
                this.nextHeaderIndex += entriesToEvict;
            }
            return entriesToEvict;
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int index;
                int b = Util.and(this.source.readByte(), 255);
                if (b == 128) {
                    throw new IOException("index == 0");
                }
                if ((b & 0x80) == 128) {
                    index = this.readInt(b, 127);
                    this.readIndexedHeader(index - 1);
                    continue;
                }
                if (b == 64) {
                    this.readLiteralHeaderWithIncrementalIndexingNewName();
                    continue;
                }
                if ((b & 0x40) == 64) {
                    index = this.readInt(b, 63);
                    this.readLiteralHeaderWithIncrementalIndexingIndexedName(index - 1);
                    continue;
                }
                if ((b & 0x20) == 32) {
                    this.maxDynamicTableByteCount = this.readInt(b, 31);
                    if (this.maxDynamicTableByteCount < 0 || this.maxDynamicTableByteCount > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    this.adjustDynamicTableByteCount();
                    continue;
                }
                if (b == 16 || b == 0) {
                    this.readLiteralHeaderWithoutIndexingNewName();
                    continue;
                }
                index = this.readInt(b, 15);
                this.readLiteralHeaderWithoutIndexingIndexedName(index - 1);
            }
        }

        private final void readIndexedHeader(int index) throws IOException {
            if (this.isStaticHeader(index)) {
                Header staticEntry = INSTANCE.getSTATIC_HEADER_TABLE()[index];
                this.headerList.add((Object)staticEntry);
            } else {
                int dynamicTableIndex = this.dynamicTableIndex(index - INSTANCE.getSTATIC_HEADER_TABLE().length);
                if (dynamicTableIndex < 0 || dynamicTableIndex >= this.dynamicTable.length) {
                    throw new IOException("Header index too large " + (index + 1));
                }
                Collection collection = (Collection)this.headerList;
                Header header = this.dynamicTable[dynamicTableIndex];
                Intrinsics.checkNotNull((Object)header);
                collection.add((Object)header);
            }
        }

        private final int dynamicTableIndex(int index) {
            return this.nextHeaderIndex + 1 + index;
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int index) throws IOException {
            ByteString name = this.getName(index);
            ByteString value = this.readByteString();
            this.headerList.add((Object)new Header(name, value));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            ByteString name = INSTANCE.checkLowercase(this.readByteString());
            ByteString value = this.readByteString();
            this.headerList.add((Object)new Header(name, value));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int nameIndex) throws IOException {
            ByteString name = this.getName(nameIndex);
            ByteString value = this.readByteString();
            this.insertIntoDynamicTable(-1, new Header(name, value));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            ByteString name = INSTANCE.checkLowercase(this.readByteString());
            ByteString value = this.readByteString();
            this.insertIntoDynamicTable(-1, new Header(name, value));
        }

        private final ByteString getName(int index) throws IOException {
            ByteString byteString;
            if (this.isStaticHeader(index)) {
                byteString = Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[index].name;
            } else {
                int dynamicTableIndex = this.dynamicTableIndex(index - INSTANCE.getSTATIC_HEADER_TABLE().length);
                if (dynamicTableIndex < 0 || dynamicTableIndex >= this.dynamicTable.length) {
                    throw new IOException("Header index too large " + (index + 1));
                }
                Header header = this.dynamicTable[dynamicTableIndex];
                Intrinsics.checkNotNull((Object)header);
                byteString = header.name;
            }
            return byteString;
        }

        private final boolean isStaticHeader(int index) {
            return index >= 0 && index <= INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final void insertIntoDynamicTable(int index, Header entry) {
            int index2 = index;
            this.headerList.add((Object)entry);
            int delta = entry.hpackSize;
            if (index2 != -1) {
                Header header = this.dynamicTable[this.dynamicTableIndex(index2)];
                Intrinsics.checkNotNull((Object)header);
                delta -= header.hpackSize;
            }
            if (delta > this.maxDynamicTableByteCount) {
                this.clearDynamicTable();
                return;
            }
            int bytesToRecover = this.dynamicTableByteCount + delta - this.maxDynamicTableByteCount;
            int entriesEvicted = this.evictToRecoverBytes(bytesToRecover);
            if (index2 == -1) {
                if (this.headerCount + 1 > this.dynamicTable.length) {
                    Header[] doubled = new Header[this.dynamicTable.length * 2];
                    System.arraycopy((Object)this.dynamicTable, (int)0, (Object)doubled, (int)this.dynamicTable.length, (int)this.dynamicTable.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = doubled;
                }
                int n = this.nextHeaderIndex;
                this.nextHeaderIndex = n + -1;
                index2 = n;
                this.dynamicTable[index2] = entry;
                n = this.headerCount;
                this.headerCount = n + 1;
            } else {
                index2 += this.dynamicTableIndex(index2) + entriesEvicted;
                this.dynamicTable[index2] = entry;
            }
            this.dynamicTableByteCount += delta;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        public final int readInt(int firstByte, int prefixMask) throws IOException {
            int b;
            int prefix = firstByte & prefixMask;
            if (prefix < prefixMask) {
                return prefix;
            }
            int result = prefixMask;
            int shift = 0;
            while (((b = this.readByte()) & 0x80) != 0) {
                result += (b & 0x7F) << shift;
                shift += 7;
            }
            return result += b << shift;
        }

        @NotNull
        public final ByteString readByteString() throws IOException {
            ByteString byteString;
            int firstByte = this.readByte();
            boolean huffmanDecode = (firstByte & 0x80) == 128;
            long length = this.readInt(firstByte, 127);
            if (huffmanDecode) {
                Buffer decodeBuffer = new Buffer();
                Huffman.INSTANCE.decode(this.source, length, decodeBuffer);
                byteString = decodeBuffer.readByteString();
            } else {
                byteString = this.source.readByteString(length);
            }
            return byteString;
        }

        @JvmOverloads
        public Reader(@NotNull Source source2, int headerTableSizeSetting) {
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            this(source2, headerTableSizeSetting, 0, 4, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" D\n\n \n\b\n \n\n \n\n\b\n\n\b\n\n\b\n\n\b\n \n\b\b\n\n\b\f 20B%\b\b\b0\b\b00¢\b\b\tJ0\nH¢\b\fJ\r0\nH¢\b\r\fJ020H¢\bJ0\n20H¢\bJ0\n20¢\bJ0\n20¢\bJ0\n2\f\b00¢\bJ%\"0\n202 02!0¢\b\"#R%\n00$8@X¢\n\b%&R'08@X¢\n\b'(R)08@X¢\n\b)*R+08@X¢\n\b+(R08@X¢\n\b(R,08@X¢\n\b,(R-08@X¢\n\b-(R08X¢\n\b.R/08@X¢\n\b/(R08X¢\n\b*¨0"}, d2={"Lokhttp3/internal/http2/Hpack$Writer;", "", "", "headerTableSizeSetting", "", "useCompression", "Lokio/Buffer;", "out", "<init>", "(IZLokio/Buffer;)V", "", "adjustDynamicTableByteCount", "()V", "clearDynamicTable", "bytesToRecover", "evictToRecoverBytes", "(I)I", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "(Lokhttp3/internal/http2/Header;)V", "resizeHeaderTable", "(I)V", "Lokio/ByteString;", "data", "writeByteString", "(Lokio/ByteString;)V", "", "headerBlock", "writeHeaders", "(Ljava/util/List;)V", "value", "prefixMask", "bits", "writeInt", "(III)V", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "I", "emitDynamicTableSizeUpdate", "Z", "headerCount", "maxDynamicTableByteCount", "nextHeaderIndex", "Lokio/Buffer;", "smallestHeaderTableSizeSetting", "okhttp"})
    public static final class Writer {
        @JvmField
        public int headerTableSizeSetting;
        private final boolean useCompression;
        @NotNull
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private boolean emitDynamicTableSizeUpdate;
        @JvmField
        public int maxDynamicTableByteCount;
        @JvmField
        @NotNull
        public Header[] dynamicTable;
        private int nextHeaderIndex;
        @JvmField
        public int headerCount;
        @JvmField
        public int dynamicTableByteCount;

        @JvmOverloads
        public Writer(int headerTableSizeSetting, boolean useCompression, @NotNull Buffer out) {
            Intrinsics.checkNotNullParameter((Object)out, (String)"out");
            this.headerTableSizeSetting = headerTableSizeSetting;
            this.useCompression = useCompression;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = this.headerTableSizeSetting;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
        }

        public /* synthetic */ Writer(int n, boolean bl, Buffer buffer, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 1) != 0) {
                n = 4096;
            }
            if ((n2 & 2) != 0) {
                bl = true;
            }
            this(n, bl, buffer);
        }

        private final void clearDynamicTable() {
            ArraysKt.fill$default((Object[])this.dynamicTable, null, (int)0, (int)0, (int)6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int bytesToRecover) {
            int bytesToRecover2 = bytesToRecover;
            int entriesToEvict = 0;
            if (bytesToRecover2 > 0) {
                for (int j = this.dynamicTable.length - 1; j >= this.nextHeaderIndex && bytesToRecover2 > 0; --j) {
                    Header header = this.dynamicTable[j];
                    Intrinsics.checkNotNull((Object)header);
                    bytesToRecover2 -= header.hpackSize;
                    Header header2 = this.dynamicTable[j];
                    Intrinsics.checkNotNull((Object)header2);
                    this.dynamicTableByteCount -= header2.hpackSize;
                    int n = this.headerCount;
                    this.headerCount = n + -1;
                    ++entriesToEvict;
                }
                System.arraycopy((Object)this.dynamicTable, (int)(this.nextHeaderIndex + 1), (Object)this.dynamicTable, (int)(this.nextHeaderIndex + 1 + entriesToEvict), (int)this.headerCount);
                Arrays.fill((Object[])this.dynamicTable, (int)(this.nextHeaderIndex + 1), (int)(this.nextHeaderIndex + 1 + entriesToEvict), null);
                this.nextHeaderIndex += entriesToEvict;
            }
            return entriesToEvict;
        }

        private final void insertIntoDynamicTable(Header entry) {
            int delta = entry.hpackSize;
            if (delta > this.maxDynamicTableByteCount) {
                this.clearDynamicTable();
                return;
            }
            int bytesToRecover = this.dynamicTableByteCount + delta - this.maxDynamicTableByteCount;
            this.evictToRecoverBytes(bytesToRecover);
            if (this.headerCount + 1 > this.dynamicTable.length) {
                Header[] doubled = new Header[this.dynamicTable.length * 2];
                System.arraycopy((Object)this.dynamicTable, (int)0, (Object)doubled, (int)this.dynamicTable.length, (int)this.dynamicTable.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = doubled;
            }
            int n = this.nextHeaderIndex;
            this.nextHeaderIndex = n + -1;
            int index = n;
            this.dynamicTable[index] = entry;
            n = this.headerCount;
            this.headerCount = n + 1;
            this.dynamicTableByteCount += delta;
        }

        public final void writeHeaders(@NotNull List<Header> headerBlock) throws IOException {
            Intrinsics.checkNotNullParameter(headerBlock, (String)"headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                if (this.smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount) {
                    this.writeInt(this.smallestHeaderTableSizeSetting, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                this.writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int n = headerBlock.size();
            for (int i = 0; i < n; ++i) {
                Header header = (Header)headerBlock.get(i);
                ByteString name = header.name.toAsciiLowercase();
                ByteString value = header.value;
                int headerIndex = -1;
                int headerNameIndex = -1;
                Integer staticIndex = (Integer)INSTANCE.getNAME_TO_FIRST_INDEX().get((Object)name);
                if (staticIndex != null) {
                    headerNameIndex = staticIndex + 1;
                    boolean bl = 2 <= headerNameIndex ? headerNameIndex < 8 : false;
                    if (bl) {
                        if (Intrinsics.areEqual((Object)Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[headerNameIndex - 1].value, (Object)value)) {
                            headerIndex = headerNameIndex;
                        } else if (Intrinsics.areEqual((Object)Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[headerNameIndex].value, (Object)value)) {
                            headerIndex = headerNameIndex + 1;
                        }
                    }
                }
                if (headerIndex == -1) {
                    int n2 = this.dynamicTable.length;
                    for (int j = this.nextHeaderIndex + 1; j < n2; ++j) {
                        Header header2 = this.dynamicTable[j];
                        Intrinsics.checkNotNull((Object)header2);
                        if (!Intrinsics.areEqual((Object)header2.name, (Object)name)) continue;
                        Header header3 = this.dynamicTable[j];
                        Intrinsics.checkNotNull((Object)header3);
                        if (Intrinsics.areEqual((Object)header3.value, (Object)value)) {
                            headerIndex = j - this.nextHeaderIndex + INSTANCE.getSTATIC_HEADER_TABLE().length;
                            break;
                        }
                        if (headerNameIndex != -1) continue;
                        headerNameIndex = j - this.nextHeaderIndex + INSTANCE.getSTATIC_HEADER_TABLE().length;
                    }
                }
                if (headerIndex != -1) {
                    this.writeInt(headerIndex, 127, 128);
                    continue;
                }
                if (headerNameIndex == -1) {
                    this.out.writeByte(64);
                    this.writeByteString(name);
                    this.writeByteString(value);
                    this.insertIntoDynamicTable(header);
                    continue;
                }
                if (name.startsWith(Header.PSEUDO_PREFIX) && !Intrinsics.areEqual((Object)Header.TARGET_AUTHORITY, (Object)name)) {
                    this.writeInt(headerNameIndex, 15, 0);
                    this.writeByteString(value);
                    continue;
                }
                this.writeInt(headerNameIndex, 63, 64);
                this.writeByteString(value);
                this.insertIntoDynamicTable(header);
            }
        }

        public final void writeInt(int value, int prefixMask, int bits) {
            int value2 = value;
            if (value2 < prefixMask) {
                this.out.writeByte(bits | value2);
                return;
            }
            this.out.writeByte(bits | prefixMask);
            value2 -= prefixMask;
            while (value2 >= 128) {
                int b = value2 & 0x7F;
                this.out.writeByte(b | 0x80);
                value2 >>>= 7;
            }
            this.out.writeByte(value2);
        }

        public final void writeByteString(@NotNull ByteString data) throws IOException {
            Intrinsics.checkNotNullParameter((Object)data, (String)"data");
            if (this.useCompression && Huffman.INSTANCE.encodedLength(data) < data.size()) {
                Buffer huffmanBuffer = new Buffer();
                Huffman.INSTANCE.encode(data, huffmanBuffer);
                ByteString huffmanBytes = huffmanBuffer.readByteString();
                this.writeInt(huffmanBytes.size(), 127, 128);
                this.out.write(huffmanBytes);
            } else {
                this.writeInt(data.size(), 127, 0);
                this.out.write(data);
            }
        }

        public final void resizeHeaderTable(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int effectiveHeaderTableSize = Math.min((int)headerTableSizeSetting, (int)16384);
            if (this.maxDynamicTableByteCount == effectiveHeaderTableSize) {
                return;
            }
            if (effectiveHeaderTableSize < this.maxDynamicTableByteCount) {
                this.smallestHeaderTableSizeSetting = Math.min((int)this.smallestHeaderTableSizeSetting, (int)effectiveHeaderTableSize);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = effectiveHeaderTableSize;
            this.adjustDynamicTableByteCount();
        }

        private final void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount < this.dynamicTableByteCount) {
                if (this.maxDynamicTableByteCount == 0) {
                    this.clearDynamicTable();
                } else {
                    this.evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
                }
            }
        }

        @JvmOverloads
        public Writer(int headerTableSizeSetting, @NotNull Buffer out) {
            Intrinsics.checkNotNullParameter((Object)out, (String)"out");
            this(headerTableSizeSetting, false, out, 2, null);
        }

        @JvmOverloads
        public Writer(@NotNull Buffer out) {
            Intrinsics.checkNotNullParameter((Object)out, (String)"out");
            this(0, false, out, 3, null);
        }
    }
}

