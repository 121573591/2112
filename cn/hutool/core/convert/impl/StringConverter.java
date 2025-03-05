/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.io.Reader
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.sql.Blob
 *  java.sql.Clob
 *  java.sql.SQLException
 *  java.util.TimeZone
 *  org.w3c.dom.Node
 */
package cn.hutool.core.convert.impl;

import cn.hutool.core.convert.AbstractConverter;
import cn.hutool.core.convert.ConvertException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.XmlUtil;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.TimeZone;
import org.w3c.dom.Node;

public class StringConverter
extends AbstractConverter<String> {
    private static final long serialVersionUID = 1L;

    @Override
    protected String convertInternal(Object value) {
        if (value instanceof TimeZone) {
            return ((TimeZone)value).getID();
        }
        if (value instanceof Node) {
            return XmlUtil.toStr((Node)value);
        }
        if (value instanceof Clob) {
            return StringConverter.clobToStr((Clob)value);
        }
        if (value instanceof Blob) {
            return StringConverter.blobToStr((Blob)value);
        }
        if (value instanceof Type) {
            return ((Type)value).getTypeName();
        }
        return this.convertToStr(value);
    }

    private static String clobToStr(Clob clob) {
        Reader reader = null;
        try {
            reader = clob.getCharacterStream();
            String string = IoUtil.read(reader);
            return string;
        }
        catch (SQLException e) {
            throw new ConvertException(e);
        }
        finally {
            IoUtil.close((Closeable)reader);
        }
    }

    private static String blobToStr(Blob blob) {
        InputStream in = null;
        try {
            in = blob.getBinaryStream();
            String string = IoUtil.read(in, CharsetUtil.CHARSET_UTF_8);
            return string;
        }
        catch (SQLException e) {
            throw new ConvertException(e);
        }
        finally {
            IoUtil.close((Closeable)in);
        }
    }
}

