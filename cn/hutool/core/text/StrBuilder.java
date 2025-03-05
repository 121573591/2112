/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.StringIndexOutOfBoundsException
 *  java.lang.System
 *  java.util.Arrays
 */
package cn.hutool.core.text;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;
import java.io.Serializable;
import java.util.Arrays;

public class StrBuilder
implements CharSequence,
Appendable,
Serializable {
    private static final long serialVersionUID = 6341229705927508451L;
    public static final int DEFAULT_CAPACITY = 16;
    private char[] value;
    private int position;

    public static StrBuilder create() {
        return new StrBuilder();
    }

    public static StrBuilder create(int initialCapacity) {
        return new StrBuilder(initialCapacity);
    }

    public static StrBuilder create(CharSequence ... strs) {
        return new StrBuilder(strs);
    }

    public StrBuilder() {
        this(16);
    }

    public StrBuilder(int initialCapacity) {
        this.value = new char[initialCapacity];
    }

    public StrBuilder(CharSequence ... strs) {
        this(ArrayUtil.isEmpty(strs) ? 16 : StrBuilder.totalLength(strs) + 16);
        for (CharSequence str : strs) {
            this.append(str);
        }
    }

    public StrBuilder append(Object obj) {
        return this.insert(this.position, obj);
    }

    public StrBuilder append(char c) {
        return this.insert(this.position, c);
    }

    public StrBuilder append(char[] src) {
        if (ArrayUtil.isEmpty(src)) {
            return this;
        }
        return this.append(src, 0, src.length);
    }

    public StrBuilder append(char[] src, int srcPos, int length) {
        return this.insert(this.position, src, srcPos, length);
    }

    public StrBuilder append(CharSequence csq) {
        return this.insert(this.position, csq);
    }

    public StrBuilder append(CharSequence csq, int start, int end) {
        return this.insert(this.position, csq, start, end);
    }

    public StrBuilder insert(int index, Object obj) {
        if (obj instanceof CharSequence) {
            return this.insert(index, (CharSequence)obj);
        }
        return this.insert(index, Convert.toStr(obj));
    }

    public StrBuilder insert(int index, char c) {
        if (index < 0) {
            index = this.position + index;
        }
        if (index < 0) {
            throw new StringIndexOutOfBoundsException(index);
        }
        this.moveDataAfterIndex(index, 1);
        this.value[index] = c;
        this.position = Math.max((int)this.position, (int)index) + 1;
        return this;
    }

    public StrBuilder insert(int index, char[] src) {
        if (ArrayUtil.isEmpty(src)) {
            return this;
        }
        return this.insert(index, src, 0, src.length);
    }

    public StrBuilder insert(int index, char[] src, int srcPos, int length) {
        if (ArrayUtil.isEmpty(src) || srcPos > src.length || length <= 0) {
            return this;
        }
        if (index < 0) {
            index = this.position + index;
        }
        if (index < 0) {
            throw new StringIndexOutOfBoundsException(index);
        }
        if (srcPos < 0) {
            srcPos = 0;
        } else if (srcPos + length > src.length) {
            length = src.length - srcPos;
        }
        this.moveDataAfterIndex(index, length);
        System.arraycopy((Object)src, (int)srcPos, (Object)this.value, (int)index, (int)length);
        this.position = Math.max((int)this.position, (int)index) + length;
        return this;
    }

    public StrBuilder insert(int index, CharSequence csq) {
        if (index < 0) {
            index = this.position + index;
        }
        if (index < 0) {
            throw new StringIndexOutOfBoundsException(index);
        }
        if (null == csq) {
            csq = "";
        }
        int len = csq.length();
        this.moveDataAfterIndex(index, csq.length());
        if (csq instanceof String) {
            ((String)csq).getChars(0, len, this.value, index);
        } else if (csq instanceof StringBuilder) {
            ((StringBuilder)csq).getChars(0, len, this.value, index);
        } else if (csq instanceof StringBuffer) {
            ((StringBuffer)csq).getChars(0, len, this.value, index);
        } else if (csq instanceof StrBuilder) {
            ((StrBuilder)csq).getChars(0, len, this.value, index);
        } else {
            int i = 0;
            int j = this.position;
            while (i < len) {
                this.value[j] = csq.charAt(i);
                ++i;
                ++j;
            }
        }
        this.position = Math.max((int)this.position, (int)index) + len;
        return this;
    }

    public StrBuilder insert(int index, CharSequence csq, int start, int end) {
        int csqLen;
        if (csq == null) {
            csq = "null";
        }
        if (start > (csqLen = csq.length())) {
            return this;
        }
        if (start < 0) {
            start = 0;
        }
        if (end > csqLen) {
            end = csqLen;
        }
        if (start >= end) {
            return this;
        }
        if (index < 0) {
            index = this.position + index;
        }
        if (index < 0) {
            throw new StringIndexOutOfBoundsException(index);
        }
        int length = end - start;
        this.moveDataAfterIndex(index, length);
        int i = start;
        int j = this.position;
        while (i < end) {
            this.value[j] = csq.charAt(i);
            ++i;
            ++j;
        }
        this.position = Math.max((int)this.position, (int)index) + length;
        return this;
    }

    public StrBuilder getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        if (srcBegin < 0) {
            srcBegin = 0;
        }
        if (srcEnd < 0) {
            srcEnd = 0;
        } else if (srcEnd > this.position) {
            srcEnd = this.position;
        }
        if (srcBegin > srcEnd) {
            throw new StringIndexOutOfBoundsException("srcBegin > srcEnd");
        }
        System.arraycopy((Object)this.value, (int)srcBegin, (Object)dst, (int)dstBegin, (int)(srcEnd - srcBegin));
        return this;
    }

    public boolean hasContent() {
        return this.position > 0;
    }

    public boolean isEmpty() {
        return this.position == 0;
    }

    public StrBuilder clear() {
        return this.reset();
    }

    public StrBuilder reset() {
        this.position = 0;
        return this;
    }

    public StrBuilder delTo(int newPosition) {
        if (newPosition < 0) {
            newPosition = 0;
        }
        return this.del(newPosition, this.position);
    }

    public StrBuilder del(int start, int end) throws StringIndexOutOfBoundsException {
        int len;
        if (start < 0) {
            start = 0;
        }
        if (end >= this.position) {
            this.position = start;
            return this;
        }
        if (end < 0) {
            end = 0;
        }
        if ((len = end - start) > 0) {
            System.arraycopy((Object)this.value, (int)(start + len), (Object)this.value, (int)start, (int)(this.position - end));
            this.position -= len;
        } else if (len < 0) {
            throw new StringIndexOutOfBoundsException("Start is greater than End.");
        }
        return this;
    }

    public String toString(boolean isReset) {
        if (this.position > 0) {
            String s = new String(this.value, 0, this.position);
            if (isReset) {
                this.reset();
            }
            return s;
        }
        return "";
    }

    public String toStringAndReset() {
        return this.toString(true);
    }

    public String toString() {
        return this.toString(false);
    }

    public int length() {
        return this.position;
    }

    public char charAt(int index) {
        if (index < 0) {
            index = this.position + index;
        }
        if (index < 0 || index > this.position) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return this.value[index];
    }

    public CharSequence subSequence(int start, int end) {
        return this.subString(start, end);
    }

    public String subString(int start) {
        return this.subString(start, this.position);
    }

    public String subString(int start, int end) {
        return new String(this.value, start, end - start);
    }

    private void moveDataAfterIndex(int index, int length) {
        this.ensureCapacity(Math.max((int)this.position, (int)index) + length);
        if (index < this.position) {
            System.arraycopy((Object)this.value, (int)index, (Object)this.value, (int)(index + length), (int)(this.position - index));
        } else if (index > this.position) {
            Arrays.fill((char[])this.value, (int)this.position, (int)index, (char)' ');
        }
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity - this.value.length > 0) {
            this.expandCapacity(minimumCapacity);
        }
    }

    private void expandCapacity(int minimumCapacity) {
        int newCapacity = (this.value.length << 1) + 2;
        if (newCapacity - minimumCapacity < 0) {
            newCapacity = minimumCapacity;
        }
        if (newCapacity < 0) {
            throw new OutOfMemoryError("Capacity is too long and max than Integer.MAX");
        }
        this.value = Arrays.copyOf((char[])this.value, (int)newCapacity);
    }

    private static int totalLength(CharSequence ... strs) {
        int totalLength = 0;
        for (CharSequence str : strs) {
            totalLength += null == str ? 0 : str.length();
        }
        return totalLength;
    }
}

