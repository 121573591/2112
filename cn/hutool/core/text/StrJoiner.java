/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.function.Function
 */
package cn.hutool.core.text;

import cn.hutool.core.collection.ArrayIter;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.function.Function;

public class StrJoiner
implements Appendable,
Serializable {
    private static final long serialVersionUID = 1L;
    private Appendable appendable;
    private CharSequence delimiter;
    private CharSequence prefix;
    private CharSequence suffix;
    private boolean wrapElement;
    private NullMode nullMode = NullMode.NULL_STRING;
    private String emptyResult = "";
    private boolean hasContent;

    public static StrJoiner of(StrJoiner joiner) {
        StrJoiner joinerNew = new StrJoiner(joiner.delimiter, joiner.prefix, joiner.suffix);
        joinerNew.wrapElement = joiner.wrapElement;
        joinerNew.nullMode = joiner.nullMode;
        joinerNew.emptyResult = joiner.emptyResult;
        return joinerNew;
    }

    public static StrJoiner of(CharSequence delimiter) {
        return new StrJoiner(delimiter);
    }

    public static StrJoiner of(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        return new StrJoiner(delimiter, prefix, suffix);
    }

    public StrJoiner(CharSequence delimiter) {
        this(null, delimiter);
    }

    public StrJoiner(Appendable appendable, CharSequence delimiter) {
        this(appendable, delimiter, null, null);
    }

    public StrJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        this(null, delimiter, prefix, suffix);
    }

    public StrJoiner(Appendable appendable, CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        if (null != appendable) {
            this.appendable = appendable;
            this.checkHasContent(appendable);
        }
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public StrJoiner setDelimiter(CharSequence delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    public StrJoiner setPrefix(CharSequence prefix) {
        this.prefix = prefix;
        return this;
    }

    public StrJoiner setSuffix(CharSequence suffix) {
        this.suffix = suffix;
        return this;
    }

    public StrJoiner setWrapElement(boolean wrapElement) {
        this.wrapElement = wrapElement;
        return this;
    }

    public StrJoiner setNullMode(NullMode nullMode) {
        this.nullMode = nullMode;
        return this;
    }

    public StrJoiner setEmptyResult(String emptyResult) {
        this.emptyResult = emptyResult;
        return this;
    }

    public StrJoiner append(Object obj) {
        if (null == obj) {
            this.append((CharSequence)null);
        } else if (ArrayUtil.isArray(obj)) {
            this.append(new ArrayIter(obj));
        } else if (obj instanceof Iterator) {
            this.append((Iterator)obj);
        } else if (obj instanceof Iterable) {
            this.append(((Iterable)obj).iterator());
        } else {
            this.append(ObjectUtil.toString(obj));
        }
        return this;
    }

    public <T> StrJoiner append(T[] array) {
        if (null == array) {
            return this;
        }
        return this.append((Iterator<T>)new ArrayIter<T>(array));
    }

    public <T> StrJoiner append(Iterator<T> iterator) {
        if (null != iterator) {
            while (iterator.hasNext()) {
                this.append(iterator.next());
            }
        }
        return this;
    }

    public <T> StrJoiner append(T[] array, Function<T, ? extends CharSequence> toStrFunc) {
        return this.append(new ArrayIter<T>(array), (Function<? super E, ? extends CharSequence>)((Function)toStrFunc));
    }

    public <E> StrJoiner append(Iterable<E> iterable, Function<? super E, ? extends CharSequence> toStrFunc) {
        return this.append(IterUtil.getIter(iterable), toStrFunc);
    }

    public <E> StrJoiner append(Iterator<E> iterator, Function<? super E, ? extends CharSequence> toStrFunc) {
        if (null != iterator) {
            while (iterator.hasNext()) {
                this.append((CharSequence)toStrFunc.apply(iterator.next()));
            }
        }
        return this;
    }

    public StrJoiner append(CharSequence csq) {
        return this.append(csq, 0, StrUtil.length(csq));
    }

    public StrJoiner append(CharSequence csq, int startInclude, int endExclude) {
        if (null == csq) {
            switch (this.nullMode) {
                case IGNORE: {
                    return this;
                }
                case TO_EMPTY: {
                    csq = "";
                    break;
                }
                case NULL_STRING: {
                    csq = "null";
                    endExclude = "null".length();
                }
            }
        }
        try {
            Appendable appendable = this.prepare();
            if (this.wrapElement && StrUtil.isNotEmpty(this.prefix)) {
                appendable.append(this.prefix);
            }
            appendable.append(csq, startInclude, endExclude);
            if (this.wrapElement && StrUtil.isNotEmpty(this.suffix)) {
                appendable.append(this.suffix);
            }
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this;
    }

    public StrJoiner append(char c) {
        return this.append(String.valueOf((char)c));
    }

    public StrJoiner merge(StrJoiner strJoiner) {
        if (null != strJoiner && null != strJoiner.appendable) {
            String otherStr = strJoiner.toString();
            if (strJoiner.wrapElement) {
                this.append(otherStr);
            } else {
                this.append(otherStr, this.prefix.length(), otherStr.length());
            }
        }
        return this;
    }

    public int length() {
        return this.appendable != null ? this.appendable.toString().length() + StrUtil.length(this.suffix) : (null == this.emptyResult ? -1 : this.emptyResult.length());
    }

    public String toString() {
        if (null == this.appendable) {
            return this.emptyResult;
        }
        String result = this.appendable.toString();
        if (!this.wrapElement && StrUtil.isNotEmpty(this.suffix)) {
            result = result + this.suffix;
        }
        return result;
    }

    private Appendable prepare() throws IOException {
        if (this.hasContent) {
            this.appendable.append(this.delimiter);
        } else {
            if (null == this.appendable) {
                this.appendable = new StringBuilder();
            }
            if (!this.wrapElement && StrUtil.isNotEmpty(this.prefix)) {
                this.appendable.append(this.prefix);
            }
            this.hasContent = true;
        }
        return this.appendable;
    }

    private void checkHasContent(Appendable appendable) {
        if (appendable instanceof CharSequence) {
            CharSequence charSequence = (CharSequence)appendable;
            if (charSequence.length() > 0 && StrUtil.endWith(charSequence, this.delimiter)) {
                this.hasContent = true;
            }
        } else {
            String initStr = appendable.toString();
            if (StrUtil.isNotEmpty(initStr) && !StrUtil.endWith((CharSequence)initStr, this.delimiter)) {
                this.hasContent = true;
            }
        }
    }

    public static enum NullMode {
        IGNORE,
        TO_EMPTY,
        NULL_STRING;

    }
}

