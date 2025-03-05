/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.io.Reader
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.yaml.snakeyaml.DumperOptions
 *  org.yaml.snakeyaml.DumperOptions$FlowStyle
 *  org.yaml.snakeyaml.Yaml
 */
package cn.hutool.setting.yaml;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Dict;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class YamlUtil {
    public static Dict loadByPath(String path) {
        return YamlUtil.loadByPath(path, Dict.class);
    }

    public static <T> T loadByPath(String path, Class<T> type) {
        return YamlUtil.load(ResourceUtil.getStream(path), type);
    }

    public static <T> T load(InputStream in, Class<T> type) {
        return YamlUtil.load(IoUtil.getBomReader(in), type);
    }

    public static Dict load(Reader reader) {
        return YamlUtil.load(reader, Dict.class);
    }

    public static <T> T load(Reader reader, Class<T> type) {
        return YamlUtil.load(reader, type, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static <T> T load(Reader reader, Class<T> type, boolean isCloseReader) {
        Assert.notNull(reader, "Reader must be not null !", new Object[0]);
        if (null == type) {
            type = Object.class;
        }
        Yaml yaml = new Yaml();
        try {
            Object object = yaml.loadAs(reader, type);
            return (T)object;
        }
        finally {
            if (isCloseReader) {
                IoUtil.close((Closeable)reader);
            }
        }
    }

    public static void dump(Object object, Writer writer) {
        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        YamlUtil.dump(object, writer, options);
    }

    public static void dump(Object object, Writer writer, DumperOptions dumperOptions) {
        if (null == dumperOptions) {
            dumperOptions = new DumperOptions();
        }
        Yaml yaml = new Yaml(dumperOptions);
        yaml.dump(object, writer);
    }
}

