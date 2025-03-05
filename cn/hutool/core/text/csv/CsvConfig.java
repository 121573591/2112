/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package cn.hutool.core.text.csv;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class CsvConfig<T extends CsvConfig<T>>
implements Serializable {
    private static final long serialVersionUID = -8069578249066158459L;
    protected char fieldSeparator = (char)44;
    protected char textDelimiter = (char)34;
    protected Character commentCharacter = Character.valueOf((char)'#');
    protected Map<String, String> headerAlias = new LinkedHashMap();

    public T setFieldSeparator(char fieldSeparator) {
        this.fieldSeparator = fieldSeparator;
        return (T)this;
    }

    public T setTextDelimiter(char textDelimiter) {
        this.textDelimiter = textDelimiter;
        return (T)this;
    }

    public T disableComment() {
        return this.setCommentCharacter(null);
    }

    public T setCommentCharacter(Character commentCharacter) {
        this.commentCharacter = commentCharacter;
        return (T)this;
    }

    public T setHeaderAlias(Map<String, String> headerAlias) {
        this.headerAlias = headerAlias;
        return (T)this;
    }

    public T addHeaderAlias(String header, String alias) {
        this.headerAlias.put((Object)header, (Object)alias);
        return (T)this;
    }

    public T removeHeaderAlias(String header) {
        this.headerAlias.remove((Object)header);
        return (T)this;
    }
}

