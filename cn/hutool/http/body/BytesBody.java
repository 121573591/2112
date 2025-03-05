/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.http.body;

import cn.hutool.core.io.IoUtil;
import cn.hutool.http.body.RequestBody;
import java.io.OutputStream;

public class BytesBody
implements RequestBody {
    private final byte[] content;

    public static BytesBody create(byte[] content) {
        return new BytesBody(content);
    }

    public BytesBody(byte[] content) {
        this.content = content;
    }

    @Override
    public void write(OutputStream out) {
        IoUtil.write(out, false, this.content);
    }
}

