/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufAllocator
 *  io.netty.buffer.Unpooled
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.DecoderResult
 *  io.netty.handler.stream.ChunkedInput
 *  io.netty.util.internal.ObjectUtil
 *  io.netty.util.internal.PlatformDependent
 *  java.io.File
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URLEncoder
 *  java.nio.charset.Charset
 *  java.util.AbstractMap$SimpleImmutableEntry
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Map$Entry
 *  java.util.regex.Pattern
 */
package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.FileUpload;
import io.netty.handler.codec.http.multipart.HttpData;
import io.netty.handler.codec.http.multipart.HttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.InternalAttribute;
import io.netty.handler.stream.ChunkedInput;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Pattern;

public class HttpPostRequestEncoder
implements ChunkedInput<HttpContent> {
    private static final Map.Entry[] percentEncodings = new Map.Entry[]{new AbstractMap.SimpleImmutableEntry((Object)Pattern.compile((String)"\\*"), (Object)"%2A"), new AbstractMap.SimpleImmutableEntry((Object)Pattern.compile((String)"\\+"), (Object)"%20"), new AbstractMap.SimpleImmutableEntry((Object)Pattern.compile((String)"~"), (Object)"%7E")};
    private final HttpDataFactory factory;
    private final HttpRequest request;
    private final Charset charset;
    private boolean isChunked;
    private final List<InterfaceHttpData> bodyListDatas;
    final List<InterfaceHttpData> multipartHttpDatas;
    private final boolean isMultipart;
    String multipartDataBoundary;
    String multipartMixedBoundary;
    private boolean headerFinalized;
    private final EncoderMode encoderMode;
    private boolean isLastChunk;
    private boolean isLastChunkSent;
    private FileUpload currentFileUpload;
    private boolean duringMixedMode;
    private long globalBodySize;
    private long globalProgress;
    private ListIterator<InterfaceHttpData> iterator;
    private ByteBuf currentBuffer;
    private InterfaceHttpData currentData;
    private boolean isKey = true;

    public HttpPostRequestEncoder(HttpRequest request, boolean multipart) throws ErrorDataEncoderException {
        this(new DefaultHttpDataFactory(16384L), request, multipart, HttpConstants.DEFAULT_CHARSET, EncoderMode.RFC1738);
    }

    public HttpPostRequestEncoder(HttpDataFactory factory2, HttpRequest request, boolean multipart) throws ErrorDataEncoderException {
        this(factory2, request, multipart, HttpConstants.DEFAULT_CHARSET, EncoderMode.RFC1738);
    }

    public HttpPostRequestEncoder(HttpDataFactory factory2, HttpRequest request, boolean multipart, Charset charset, EncoderMode encoderMode) throws ErrorDataEncoderException {
        this.request = (HttpRequest)ObjectUtil.checkNotNull((Object)request, (String)"request");
        this.charset = (Charset)ObjectUtil.checkNotNull((Object)charset, (String)"charset");
        this.factory = (HttpDataFactory)ObjectUtil.checkNotNull((Object)factory2, (String)"factory");
        if (HttpMethod.TRACE.equals(request.method())) {
            throw new ErrorDataEncoderException("Cannot create a Encoder if request is a TRACE");
        }
        this.bodyListDatas = new ArrayList();
        this.isLastChunk = false;
        this.isLastChunkSent = false;
        this.isMultipart = multipart;
        this.multipartHttpDatas = new ArrayList();
        this.encoderMode = encoderMode;
        if (this.isMultipart) {
            this.initDataMultipart();
        }
    }

    public void cleanFiles() {
        this.factory.cleanRequestHttpData(this.request);
    }

    public boolean isMultipart() {
        return this.isMultipart;
    }

    private void initDataMultipart() {
        this.multipartDataBoundary = HttpPostRequestEncoder.getNewMultipartDelimiter();
    }

    private void initMixedMultipart() {
        this.multipartMixedBoundary = HttpPostRequestEncoder.getNewMultipartDelimiter();
    }

    private static String getNewMultipartDelimiter() {
        return Long.toHexString((long)PlatformDependent.threadLocalRandom().nextLong());
    }

    public List<InterfaceHttpData> getBodyListAttributes() {
        return this.bodyListDatas;
    }

    public void setBodyHttpDatas(List<InterfaceHttpData> datas) throws ErrorDataEncoderException {
        ObjectUtil.checkNotNull(datas, (String)"datas");
        this.globalBodySize = 0L;
        this.bodyListDatas.clear();
        this.currentFileUpload = null;
        this.duringMixedMode = false;
        this.multipartHttpDatas.clear();
        for (InterfaceHttpData data : datas) {
            this.addBodyHttpData(data);
        }
    }

    public void addBodyAttribute(String name, String value) throws ErrorDataEncoderException {
        String svalue = value != null ? value : "";
        Attribute data = this.factory.createAttribute(this.request, (String)ObjectUtil.checkNotNull((Object)name, (String)"name"), svalue);
        this.addBodyHttpData(data);
    }

    public void addBodyFileUpload(String name, File file, String contentType, boolean isText) throws ErrorDataEncoderException {
        this.addBodyFileUpload(name, file.getName(), file, contentType, isText);
    }

    public void addBodyFileUpload(String name, String filename, File file, String contentType, boolean isText) throws ErrorDataEncoderException {
        ObjectUtil.checkNotNull((Object)name, (String)"name");
        ObjectUtil.checkNotNull((Object)file, (String)"file");
        if (filename == null) {
            filename = "";
        }
        String scontentType = contentType;
        String contentTransferEncoding = null;
        if (contentType == null) {
            scontentType = isText ? "text/plain" : "application/octet-stream";
        }
        if (!isText) {
            contentTransferEncoding = HttpPostBodyUtil.TransferEncodingMechanism.BINARY.value();
        }
        FileUpload fileUpload = this.factory.createFileUpload(this.request, name, filename, scontentType, contentTransferEncoding, null, file.length());
        try {
            fileUpload.setContent(file);
        }
        catch (IOException e) {
            throw new ErrorDataEncoderException(e);
        }
        this.addBodyHttpData(fileUpload);
    }

    public void addBodyFileUploads(String name, File[] file, String[] contentType, boolean[] isText) throws ErrorDataEncoderException {
        if (file.length != contentType.length && file.length != isText.length) {
            throw new IllegalArgumentException("Different array length");
        }
        for (int i = 0; i < file.length; ++i) {
            this.addBodyFileUpload(name, file[i], contentType[i], isText[i]);
        }
    }

    public void addBodyHttpData(InterfaceHttpData data) throws ErrorDataEncoderException {
        if (this.headerFinalized) {
            throw new ErrorDataEncoderException("Cannot add value once finalized");
        }
        this.bodyListDatas.add(ObjectUtil.checkNotNull((Object)data, (String)"data"));
        if (!this.isMultipart) {
            if (data instanceof Attribute) {
                Attribute attribute = (Attribute)data;
                try {
                    String key = this.encodeAttribute(attribute.getName(), this.charset);
                    String value = this.encodeAttribute(attribute.getValue(), this.charset);
                    Attribute newattribute = this.factory.createAttribute(this.request, key, value);
                    this.multipartHttpDatas.add((Object)newattribute);
                    this.globalBodySize += (long)(newattribute.getName().length() + 1) + newattribute.length() + 1L;
                }
                catch (IOException e) {
                    throw new ErrorDataEncoderException(e);
                }
            } else if (data instanceof FileUpload) {
                FileUpload fileUpload = (FileUpload)data;
                String key = this.encodeAttribute(fileUpload.getName(), this.charset);
                String value = this.encodeAttribute(fileUpload.getFilename(), this.charset);
                Attribute newattribute = this.factory.createAttribute(this.request, key, value);
                this.multipartHttpDatas.add((Object)newattribute);
                this.globalBodySize += (long)(newattribute.getName().length() + 1) + newattribute.length() + 1L;
            }
            return;
        }
        if (data instanceof Attribute) {
            InternalAttribute internal;
            if (this.duringMixedMode) {
                internal = new InternalAttribute(this.charset);
                internal.addValue("\r\n--" + this.multipartMixedBoundary + "--");
                this.multipartHttpDatas.add((Object)internal);
                this.multipartMixedBoundary = null;
                this.currentFileUpload = null;
                this.duringMixedMode = false;
            }
            internal = new InternalAttribute(this.charset);
            if (!this.multipartHttpDatas.isEmpty()) {
                internal.addValue("\r\n");
            }
            internal.addValue("--" + this.multipartDataBoundary + "\r\n");
            Attribute attribute = (Attribute)data;
            internal.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.FORM_DATA + "; " + HttpHeaderValues.NAME + "=\"" + attribute.getName() + "\"\r\n");
            internal.addValue(HttpHeaderNames.CONTENT_LENGTH + ": " + attribute.length() + "\r\n");
            Charset localcharset = attribute.getCharset();
            if (localcharset != null) {
                internal.addValue(HttpHeaderNames.CONTENT_TYPE + ": " + "text/plain" + "; " + HttpHeaderValues.CHARSET + '=' + localcharset.name() + "\r\n");
            }
            internal.addValue("\r\n");
            this.multipartHttpDatas.add((Object)internal);
            this.multipartHttpDatas.add((Object)data);
            this.globalBodySize += attribute.length() + (long)internal.size();
        } else if (data instanceof FileUpload) {
            boolean localMixed;
            FileUpload fileUpload = (FileUpload)data;
            InternalAttribute internal = new InternalAttribute(this.charset);
            if (!this.multipartHttpDatas.isEmpty()) {
                internal.addValue("\r\n");
            }
            if (this.duringMixedMode) {
                if (this.currentFileUpload != null && this.currentFileUpload.getName().equals((Object)fileUpload.getName())) {
                    localMixed = true;
                } else {
                    internal.addValue("--" + this.multipartMixedBoundary + "--");
                    this.multipartHttpDatas.add((Object)internal);
                    this.multipartMixedBoundary = null;
                    internal = new InternalAttribute(this.charset);
                    internal.addValue("\r\n");
                    localMixed = false;
                    this.currentFileUpload = fileUpload;
                    this.duringMixedMode = false;
                }
            } else if (this.encoderMode != EncoderMode.HTML5 && this.currentFileUpload != null && this.currentFileUpload.getName().equals((Object)fileUpload.getName())) {
                this.initMixedMultipart();
                InternalAttribute pastAttribute = (InternalAttribute)this.multipartHttpDatas.get(this.multipartHttpDatas.size() - 2);
                this.globalBodySize -= (long)pastAttribute.size();
                StringBuilder replacement = new StringBuilder(139 + this.multipartDataBoundary.length() + this.multipartMixedBoundary.length() * 2 + fileUpload.getFilename().length() + fileUpload.getName().length()).append("--").append(this.multipartDataBoundary).append("\r\n").append((CharSequence)HttpHeaderNames.CONTENT_DISPOSITION).append(": ").append((CharSequence)HttpHeaderValues.FORM_DATA).append("; ").append((CharSequence)HttpHeaderValues.NAME).append("=\"").append(fileUpload.getName()).append("\"\r\n").append((CharSequence)HttpHeaderNames.CONTENT_TYPE).append(": ").append((CharSequence)HttpHeaderValues.MULTIPART_MIXED).append("; ").append((CharSequence)HttpHeaderValues.BOUNDARY).append('=').append(this.multipartMixedBoundary).append("\r\n\r\n").append("--").append(this.multipartMixedBoundary).append("\r\n").append((CharSequence)HttpHeaderNames.CONTENT_DISPOSITION).append(": ").append((CharSequence)HttpHeaderValues.ATTACHMENT);
                if (!fileUpload.getFilename().isEmpty()) {
                    replacement.append("; ").append((CharSequence)HttpHeaderValues.FILENAME).append("=\"").append(this.currentFileUpload.getFilename()).append('\"');
                }
                replacement.append("\r\n");
                pastAttribute.setValue(replacement.toString(), 1);
                pastAttribute.setValue("", 2);
                this.globalBodySize += (long)pastAttribute.size();
                localMixed = true;
                this.duringMixedMode = true;
            } else {
                localMixed = false;
                this.currentFileUpload = fileUpload;
                this.duringMixedMode = false;
            }
            if (localMixed) {
                internal.addValue("--" + this.multipartMixedBoundary + "\r\n");
                if (fileUpload.getFilename().isEmpty()) {
                    internal.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.ATTACHMENT + "\r\n");
                } else {
                    internal.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.ATTACHMENT + "; " + HttpHeaderValues.FILENAME + "=\"" + fileUpload.getFilename() + "\"\r\n");
                }
            } else {
                internal.addValue("--" + this.multipartDataBoundary + "\r\n");
                if (fileUpload.getFilename().isEmpty()) {
                    internal.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.FORM_DATA + "; " + HttpHeaderValues.NAME + "=\"" + fileUpload.getName() + "\"\r\n");
                } else {
                    internal.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.FORM_DATA + "; " + HttpHeaderValues.NAME + "=\"" + fileUpload.getName() + "\"; " + HttpHeaderValues.FILENAME + "=\"" + fileUpload.getFilename() + "\"\r\n");
                }
            }
            internal.addValue(HttpHeaderNames.CONTENT_LENGTH + ": " + fileUpload.length() + "\r\n");
            internal.addValue(HttpHeaderNames.CONTENT_TYPE + ": " + fileUpload.getContentType());
            String contentTransferEncoding = fileUpload.getContentTransferEncoding();
            if (contentTransferEncoding != null && contentTransferEncoding.equals((Object)HttpPostBodyUtil.TransferEncodingMechanism.BINARY.value())) {
                internal.addValue("\r\n" + HttpHeaderNames.CONTENT_TRANSFER_ENCODING + ": " + HttpPostBodyUtil.TransferEncodingMechanism.BINARY.value() + "\r\n\r\n");
            } else if (fileUpload.getCharset() != null) {
                internal.addValue("; " + HttpHeaderValues.CHARSET + '=' + fileUpload.getCharset().name() + "\r\n\r\n");
            } else {
                internal.addValue("\r\n\r\n");
            }
            this.multipartHttpDatas.add((Object)internal);
            this.multipartHttpDatas.add((Object)data);
            this.globalBodySize += fileUpload.length() + (long)internal.size();
        }
    }

    public HttpRequest finalizeRequest() throws ErrorDataEncoderException {
        if (!this.headerFinalized) {
            if (this.isMultipart) {
                InternalAttribute internal = new InternalAttribute(this.charset);
                if (this.duringMixedMode) {
                    internal.addValue("\r\n--" + this.multipartMixedBoundary + "--");
                }
                internal.addValue("\r\n--" + this.multipartDataBoundary + "--\r\n");
                this.multipartHttpDatas.add((Object)internal);
                this.multipartMixedBoundary = null;
                this.currentFileUpload = null;
                this.duringMixedMode = false;
                this.globalBodySize += (long)internal.size();
            }
        } else {
            throw new ErrorDataEncoderException("Header already encoded");
        }
        this.headerFinalized = true;
        HttpHeaders headers = this.request.headers();
        List<String> contentTypes = headers.getAll((CharSequence)HttpHeaderNames.CONTENT_TYPE);
        List<String> transferEncoding = headers.getAll((CharSequence)HttpHeaderNames.TRANSFER_ENCODING);
        if (contentTypes != null) {
            headers.remove((CharSequence)HttpHeaderNames.CONTENT_TYPE);
            for (String contentType : contentTypes) {
                String lowercased = contentType.toLowerCase();
                if (lowercased.startsWith(HttpHeaderValues.MULTIPART_FORM_DATA.toString()) || lowercased.startsWith(HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())) continue;
                headers.add((CharSequence)HttpHeaderNames.CONTENT_TYPE, (Object)contentType);
            }
        }
        if (this.isMultipart) {
            String value = HttpHeaderValues.MULTIPART_FORM_DATA + "; " + HttpHeaderValues.BOUNDARY + '=' + this.multipartDataBoundary;
            headers.add((CharSequence)HttpHeaderNames.CONTENT_TYPE, (Object)value);
        } else {
            headers.add((CharSequence)HttpHeaderNames.CONTENT_TYPE, (Object)HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED);
        }
        long realSize = this.globalBodySize;
        if (!this.isMultipart) {
            --realSize;
        }
        this.iterator = this.multipartHttpDatas.listIterator();
        headers.set((CharSequence)HttpHeaderNames.CONTENT_LENGTH, (Object)String.valueOf((long)realSize));
        if (realSize > 8096L || this.isMultipart) {
            this.isChunked = true;
            if (transferEncoding != null) {
                headers.remove((CharSequence)HttpHeaderNames.TRANSFER_ENCODING);
                for (CharSequence v : transferEncoding) {
                    if (HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase(v)) continue;
                    headers.add((CharSequence)HttpHeaderNames.TRANSFER_ENCODING, (Object)v);
                }
            }
            HttpUtil.setTransferEncodingChunked(this.request, true);
            return new WrappedHttpRequest(this.request);
        }
        HttpContent chunk = this.nextChunk();
        if (this.request instanceof FullHttpRequest) {
            FullHttpRequest fullRequest = (FullHttpRequest)this.request;
            ByteBuf chunkContent = chunk.content();
            if (fullRequest.content() != chunkContent) {
                fullRequest.content().clear().writeBytes(chunkContent);
                chunkContent.release();
            }
            return fullRequest;
        }
        return new WrappedFullHttpRequest(this.request, chunk);
    }

    public boolean isChunked() {
        return this.isChunked;
    }

    private String encodeAttribute(String s, Charset charset) throws ErrorDataEncoderException {
        if (s == null) {
            return "";
        }
        try {
            String encoded = URLEncoder.encode((String)s, (String)charset.name());
            if (this.encoderMode == EncoderMode.RFC3986) {
                for (Map.Entry entry : percentEncodings) {
                    String replacement = (String)entry.getValue();
                    encoded = ((Pattern)entry.getKey()).matcher((CharSequence)encoded).replaceAll(replacement);
                }
            }
            return encoded;
        }
        catch (UnsupportedEncodingException e) {
            throw new ErrorDataEncoderException(charset.name(), e);
        }
    }

    private ByteBuf fillByteBuf() {
        int length = this.currentBuffer.readableBytes();
        if (length > 8096) {
            return this.currentBuffer.readRetainedSlice(8096);
        }
        ByteBuf slice = this.currentBuffer;
        this.currentBuffer = null;
        return slice;
    }

    private HttpContent encodeNextChunkMultipart(int sizeleft) throws ErrorDataEncoderException {
        ByteBuf buffer;
        if (this.currentData == null) {
            return null;
        }
        if (this.currentData instanceof InternalAttribute) {
            buffer = ((InternalAttribute)this.currentData).toByteBuf();
            this.currentData = null;
        } else {
            try {
                buffer = ((HttpData)this.currentData).getChunk(sizeleft);
            }
            catch (IOException e) {
                throw new ErrorDataEncoderException(e);
            }
            if (buffer.capacity() == 0) {
                this.currentData = null;
                return null;
            }
        }
        this.currentBuffer = this.currentBuffer == null ? buffer : Unpooled.wrappedBuffer((ByteBuf[])new ByteBuf[]{this.currentBuffer, buffer});
        if (this.currentBuffer.readableBytes() < 8096) {
            this.currentData = null;
            return null;
        }
        buffer = this.fillByteBuf();
        return new DefaultHttpContent(buffer);
    }

    private HttpContent encodeNextChunkUrlEncoded(int sizeleft) throws ErrorDataEncoderException {
        ByteBuf buffer;
        if (this.currentData == null) {
            return null;
        }
        int size = sizeleft;
        if (this.isKey) {
            String key = this.currentData.getName();
            buffer = Unpooled.wrappedBuffer((byte[])key.getBytes(this.charset));
            this.isKey = false;
            this.currentBuffer = this.currentBuffer == null ? Unpooled.wrappedBuffer((ByteBuf[])new ByteBuf[]{buffer, Unpooled.wrappedBuffer((byte[])"=".getBytes(this.charset))}) : Unpooled.wrappedBuffer((ByteBuf[])new ByteBuf[]{this.currentBuffer, buffer, Unpooled.wrappedBuffer((byte[])"=".getBytes(this.charset))});
            size -= buffer.readableBytes() + 1;
            if (this.currentBuffer.readableBytes() >= 8096) {
                buffer = this.fillByteBuf();
                return new DefaultHttpContent(buffer);
            }
        }
        try {
            buffer = ((HttpData)this.currentData).getChunk(size);
        }
        catch (IOException e) {
            throw new ErrorDataEncoderException(e);
        }
        ByteBuf delimiter = null;
        if (buffer.readableBytes() < size) {
            this.isKey = true;
            ByteBuf byteBuf = delimiter = this.iterator.hasNext() ? Unpooled.wrappedBuffer((byte[])"&".getBytes(this.charset)) : null;
        }
        if (buffer.capacity() == 0) {
            this.currentData = null;
            if (this.currentBuffer == null) {
                if (delimiter == null) {
                    return null;
                }
                this.currentBuffer = delimiter;
            } else if (delimiter != null) {
                this.currentBuffer = Unpooled.wrappedBuffer((ByteBuf[])new ByteBuf[]{this.currentBuffer, delimiter});
            }
            if (this.currentBuffer.readableBytes() >= 8096) {
                buffer = this.fillByteBuf();
                return new DefaultHttpContent(buffer);
            }
            return null;
        }
        this.currentBuffer = this.currentBuffer == null ? (delimiter != null ? Unpooled.wrappedBuffer((ByteBuf[])new ByteBuf[]{buffer, delimiter}) : buffer) : (delimiter != null ? Unpooled.wrappedBuffer((ByteBuf[])new ByteBuf[]{this.currentBuffer, buffer, delimiter}) : Unpooled.wrappedBuffer((ByteBuf[])new ByteBuf[]{this.currentBuffer, buffer}));
        if (this.currentBuffer.readableBytes() < 8096) {
            this.currentData = null;
            this.isKey = true;
            return null;
        }
        buffer = this.fillByteBuf();
        return new DefaultHttpContent(buffer);
    }

    public void close() throws Exception {
    }

    @Deprecated
    public HttpContent readChunk(ChannelHandlerContext ctx) throws Exception {
        return this.readChunk(ctx.alloc());
    }

    public HttpContent readChunk(ByteBufAllocator allocator) throws Exception {
        if (this.isLastChunkSent) {
            return null;
        }
        HttpContent nextChunk = this.nextChunk();
        this.globalProgress += (long)nextChunk.content().readableBytes();
        return nextChunk;
    }

    private HttpContent nextChunk() throws ErrorDataEncoderException {
        HttpContent chunk;
        if (this.isLastChunk) {
            this.isLastChunkSent = true;
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        int size = this.calculateRemainingSize();
        if (size <= 0) {
            ByteBuf buffer = this.fillByteBuf();
            return new DefaultHttpContent(buffer);
        }
        if (this.currentData != null) {
            chunk = this.isMultipart ? this.encodeNextChunkMultipart(size) : this.encodeNextChunkUrlEncoded(size);
            if (chunk != null) {
                return chunk;
            }
            size = this.calculateRemainingSize();
        }
        if (!this.iterator.hasNext()) {
            return this.lastChunk();
        }
        while (size > 0 && this.iterator.hasNext()) {
            this.currentData = (InterfaceHttpData)this.iterator.next();
            chunk = this.isMultipart ? this.encodeNextChunkMultipart(size) : this.encodeNextChunkUrlEncoded(size);
            if (chunk == null) {
                size = this.calculateRemainingSize();
                continue;
            }
            return chunk;
        }
        return this.lastChunk();
    }

    private int calculateRemainingSize() {
        int size = 8096;
        if (this.currentBuffer != null) {
            size -= this.currentBuffer.readableBytes();
        }
        return size;
    }

    private HttpContent lastChunk() {
        this.isLastChunk = true;
        if (this.currentBuffer == null) {
            this.isLastChunkSent = true;
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        ByteBuf buffer = this.currentBuffer;
        this.currentBuffer = null;
        return new DefaultHttpContent(buffer);
    }

    public boolean isEndOfInput() throws Exception {
        return this.isLastChunkSent;
    }

    public long length() {
        return this.isMultipart ? this.globalBodySize : this.globalBodySize - 1L;
    }

    public long progress() {
        return this.globalProgress;
    }

    private static final class WrappedFullHttpRequest
    extends WrappedHttpRequest
    implements FullHttpRequest {
        private final HttpContent content;

        private WrappedFullHttpRequest(HttpRequest request, HttpContent content) {
            super(request);
            this.content = content;
        }

        @Override
        public FullHttpRequest setProtocolVersion(HttpVersion version) {
            super.setProtocolVersion(version);
            return this;
        }

        @Override
        public FullHttpRequest setMethod(HttpMethod method) {
            super.setMethod(method);
            return this;
        }

        @Override
        public FullHttpRequest setUri(String uri) {
            super.setUri(uri);
            return this;
        }

        @Override
        public FullHttpRequest copy() {
            return this.replace(this.content().copy());
        }

        @Override
        public FullHttpRequest duplicate() {
            return this.replace(this.content().duplicate());
        }

        @Override
        public FullHttpRequest retainedDuplicate() {
            return this.replace(this.content().retainedDuplicate());
        }

        @Override
        public FullHttpRequest replace(ByteBuf content) {
            DefaultFullHttpRequest duplicate = new DefaultFullHttpRequest(this.protocolVersion(), this.method(), this.uri(), content);
            duplicate.headers().set(this.headers());
            duplicate.trailingHeaders().set(this.trailingHeaders());
            return duplicate;
        }

        @Override
        public FullHttpRequest retain(int increment) {
            this.content.retain(increment);
            return this;
        }

        @Override
        public FullHttpRequest retain() {
            this.content.retain();
            return this;
        }

        @Override
        public FullHttpRequest touch() {
            this.content.touch();
            return this;
        }

        @Override
        public FullHttpRequest touch(Object hint) {
            this.content.touch(hint);
            return this;
        }

        public ByteBuf content() {
            return this.content.content();
        }

        @Override
        public HttpHeaders trailingHeaders() {
            if (this.content instanceof LastHttpContent) {
                return ((LastHttpContent)this.content).trailingHeaders();
            }
            return EmptyHttpHeaders.INSTANCE;
        }

        public int refCnt() {
            return this.content.refCnt();
        }

        public boolean release() {
            return this.content.release();
        }

        public boolean release(int decrement) {
            return this.content.release(decrement);
        }
    }

    private static class WrappedHttpRequest
    implements HttpRequest {
        private final HttpRequest request;

        WrappedHttpRequest(HttpRequest request) {
            this.request = request;
        }

        @Override
        public HttpRequest setProtocolVersion(HttpVersion version) {
            this.request.setProtocolVersion(version);
            return this;
        }

        @Override
        public HttpRequest setMethod(HttpMethod method) {
            this.request.setMethod(method);
            return this;
        }

        @Override
        public HttpRequest setUri(String uri) {
            this.request.setUri(uri);
            return this;
        }

        @Override
        public HttpMethod getMethod() {
            return this.request.method();
        }

        @Override
        public HttpMethod method() {
            return this.request.method();
        }

        @Override
        public String getUri() {
            return this.request.uri();
        }

        @Override
        public String uri() {
            return this.request.uri();
        }

        @Override
        public HttpVersion getProtocolVersion() {
            return this.request.protocolVersion();
        }

        @Override
        public HttpVersion protocolVersion() {
            return this.request.protocolVersion();
        }

        @Override
        public HttpHeaders headers() {
            return this.request.headers();
        }

        public DecoderResult decoderResult() {
            return this.request.decoderResult();
        }

        @Override
        @Deprecated
        public DecoderResult getDecoderResult() {
            return this.request.getDecoderResult();
        }

        public void setDecoderResult(DecoderResult result) {
            this.request.setDecoderResult(result);
        }
    }

    public static class ErrorDataEncoderException
    extends Exception {
        private static final long serialVersionUID = 5020247425493164465L;

        public ErrorDataEncoderException() {
        }

        public ErrorDataEncoderException(String msg) {
            super(msg);
        }

        public ErrorDataEncoderException(Throwable cause) {
            super(cause);
        }

        public ErrorDataEncoderException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static enum EncoderMode {
        RFC1738,
        RFC3986,
        HTML5;

    }
}

