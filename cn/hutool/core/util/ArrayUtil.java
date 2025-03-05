/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.SafeVarargs
 *  java.lang.String
 *  java.lang.System
 *  java.lang.reflect.Array
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Random
 *  java.util.Set
 *  java.util.function.Function
 *  java.util.stream.Collectors
 */
package cn.hutool.core.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.UniqueKeySet;
import cn.hutool.core.comparator.CompareUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.lang.Matcher;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.text.StrJoiner;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PrimitiveArrayUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayUtil
extends PrimitiveArrayUtil {
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> T[] defaultIfEmpty(T[] array, T[] defaultArray) {
        return ArrayUtil.isEmpty(array) ? defaultArray : array;
    }

    public static boolean isEmpty(Object array) {
        if (array != null) {
            if (ArrayUtil.isArray(array)) {
                return 0 == Array.getLength((Object)array);
            }
            return false;
        }
        return true;
    }

    public static <T> boolean isNotEmpty(T[] array) {
        return null != array && array.length != 0;
    }

    public static boolean isNotEmpty(Object array) {
        return !ArrayUtil.isEmpty(array);
    }

    public static <T> boolean hasNull(T ... array) {
        if (ArrayUtil.isNotEmpty(array)) {
            for (T element : array) {
                if (!ObjectUtil.isNull(element)) continue;
                return true;
            }
        }
        return array == null;
    }

    public static <T> boolean isAllNull(T ... array) {
        return null == ArrayUtil.firstNonNull(array);
    }

    public static <T> T firstNonNull(T ... array) {
        return (T)ArrayUtil.firstMatch(ObjectUtil::isNotNull, array);
    }

    public static <T> T firstMatch(Matcher<T> matcher, T ... array) {
        int index = ArrayUtil.matchIndex(matcher, array);
        if (index < 0) {
            return null;
        }
        return array[index];
    }

    public static <T> int matchIndex(Matcher<T> matcher, T ... array) {
        return ArrayUtil.matchIndex(matcher, 0, array);
    }

    public static <T> int matchIndex(Matcher<T> matcher, int beginIndexInclude, T ... array) {
        Assert.notNull(matcher, "Matcher must be not null !", new Object[0]);
        if (ArrayUtil.isNotEmpty(array)) {
            for (int i = beginIndexInclude; i < array.length; ++i) {
                if (!matcher.match(array[i])) continue;
                return i;
            }
        }
        return -1;
    }

    public static <T> T[] newArray(Class<?> componentType, int newSize) {
        return (Object[])Array.newInstance(componentType, (int)newSize);
    }

    public static Object[] newArray(int newSize) {
        return new Object[newSize];
    }

    public static Class<?> getComponentType(Object array) {
        return null == array ? null : array.getClass().getComponentType();
    }

    public static Class<?> getComponentType(Class<?> arrayClass) {
        return null == arrayClass ? null : arrayClass.getComponentType();
    }

    public static Class<?> getArrayType(Class<?> componentType) {
        return Array.newInstance(componentType, (int)0).getClass();
    }

    public static Object[] cast(Class<?> type, Object arrayObj) throws NullPointerException, IllegalArgumentException {
        if (null == arrayObj) {
            throw new NullPointerException("Argument [arrayObj] is null !");
        }
        if (!arrayObj.getClass().isArray()) {
            throw new IllegalArgumentException("Argument [arrayObj] is not array !");
        }
        if (null == type) {
            return (Object[])arrayObj;
        }
        Class componentType = type.isArray() ? type.getComponentType() : type;
        Object[] array = (Object[])arrayObj;
        Object[] result = ArrayUtil.newArray(componentType, array.length);
        System.arraycopy((Object)array, (int)0, result, (int)0, (int)array.length);
        return result;
    }

    @SafeVarargs
    public static <T> T[] append(T[] buffer, T ... newElements) {
        if (ArrayUtil.isEmpty(buffer)) {
            return newElements;
        }
        return ArrayUtil.insert(buffer, buffer.length, newElements);
    }

    @SafeVarargs
    public static <T> Object append(Object array, T ... newElements) {
        if (ArrayUtil.isEmpty(array)) {
            return newElements;
        }
        return ArrayUtil.insert(array, ArrayUtil.length(array), newElements);
    }

    public static <T> T[] setOrAppend(T[] buffer, int index, T value) {
        if (index < buffer.length) {
            Array.set(buffer, (int)index, value);
            return buffer;
        }
        if (ArrayUtil.isEmpty(buffer)) {
            T[] values = ArrayUtil.newArray(value.getClass(), 1);
            values[0] = value;
            return ArrayUtil.append(buffer, values);
        }
        return ArrayUtil.append(buffer, value);
    }

    public static Object setOrAppend(Object array, int index, Object value) {
        if (index < ArrayUtil.length(array)) {
            Array.set((Object)array, (int)index, (Object)value);
            return array;
        }
        return ArrayUtil.append(array, value);
    }

    public static <T> T[] replace(T[] buffer, int index, T ... values) {
        if (ArrayUtil.isEmpty(values)) {
            return buffer;
        }
        if (ArrayUtil.isEmpty(buffer)) {
            return values;
        }
        if (index < 0) {
            return ArrayUtil.insert(buffer, 0, values);
        }
        if (index >= buffer.length) {
            return ArrayUtil.append(buffer, values);
        }
        if (buffer.length >= values.length + index) {
            System.arraycopy(values, (int)0, buffer, (int)index, (int)values.length);
            return buffer;
        }
        int newArrayLength = index + values.length;
        T[] result = ArrayUtil.newArray(buffer.getClass().getComponentType(), newArrayLength);
        System.arraycopy(buffer, (int)0, result, (int)0, (int)index);
        System.arraycopy(values, (int)0, result, (int)index, (int)values.length);
        return result;
    }

    public static <T> T[] insert(T[] buffer, int index, T ... newElements) {
        return (Object[])ArrayUtil.insert(buffer, index, newElements);
    }

    public static <T> Object insert(Object array, int index, T ... newElements) {
        if (ArrayUtil.isEmpty(newElements)) {
            return array;
        }
        if (ArrayUtil.isEmpty(array)) {
            return newElements;
        }
        int len = ArrayUtil.length(array);
        if (index < 0) {
            index = index % len + len;
        }
        Class originComponentType = array.getClass().getComponentType();
        Object newEleArr = newElements;
        if (originComponentType.isPrimitive()) {
            newEleArr = Convert.convert(array.getClass(), newElements);
        }
        Object result = Array.newInstance((Class)originComponentType, (int)(Math.max((int)len, (int)index) + newElements.length));
        System.arraycopy((Object)array, (int)0, (Object)result, (int)0, (int)Math.min((int)len, (int)index));
        System.arraycopy(newEleArr, (int)0, (Object)result, (int)index, (int)newElements.length);
        if (index < len) {
            System.arraycopy((Object)array, (int)index, (Object)result, (int)(index + newElements.length), (int)(len - index));
        }
        return result;
    }

    public static <T> T[] resize(T[] data, int newSize, Class<?> componentType) {
        if (newSize < 0) {
            return data;
        }
        T[] newArray = ArrayUtil.newArray(componentType, newSize);
        if (newSize > 0 && ArrayUtil.isNotEmpty(data)) {
            System.arraycopy(data, (int)0, newArray, (int)0, (int)Math.min((int)data.length, (int)newSize));
        }
        return newArray;
    }

    public static Object resize(Object array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        if (null == array) {
            return null;
        }
        int length = ArrayUtil.length(array);
        Object newArray = Array.newInstance((Class)array.getClass().getComponentType(), (int)newSize);
        if (newSize > 0 && ArrayUtil.isNotEmpty(array)) {
            System.arraycopy((Object)array, (int)0, (Object)newArray, (int)0, (int)Math.min((int)length, (int)newSize));
        }
        return newArray;
    }

    public static <T> T[] resize(T[] buffer, int newSize) {
        return ArrayUtil.resize(buffer, newSize, buffer.getClass().getComponentType());
    }

    @SafeVarargs
    public static <T> T[] addAll(T[] ... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int length = 0;
        for (T[] array : arrays) {
            if (!ArrayUtil.isNotEmpty(array)) continue;
            length += array.length;
        }
        T[] result = ArrayUtil.newArray(arrays.getClass().getComponentType().getComponentType(), length);
        length = 0;
        for (T[] array : arrays) {
            if (!ArrayUtil.isNotEmpty(array)) continue;
            System.arraycopy(array, (int)0, result, (int)length, (int)array.length);
            length += array.length;
        }
        return result;
    }

    public static Object copy(Object src, int srcPos, Object dest, int destPos, int length) {
        System.arraycopy((Object)src, (int)srcPos, (Object)dest, (int)destPos, (int)length);
        return dest;
    }

    public static Object copy(Object src, Object dest, int length) {
        System.arraycopy((Object)src, (int)0, (Object)dest, (int)0, (int)length);
        return dest;
    }

    public static <T> T[] clone(T[] array) {
        if (array == null) {
            return null;
        }
        return (Object[])array.clone();
    }

    public static <T> T clone(T obj) {
        if (null == obj) {
            return null;
        }
        if (ArrayUtil.isArray(obj)) {
            Object result;
            Class componentType = obj.getClass().getComponentType();
            if (componentType.isPrimitive()) {
                int length = Array.getLength(obj);
                result = Array.newInstance((Class)componentType, (int)length);
                while (length-- > 0) {
                    Array.set((Object)result, (int)length, (Object)Array.get(obj, (int)length));
                }
            } else {
                result = ((Object[])obj).clone();
            }
            return (T)result;
        }
        return null;
    }

    public static <T> T[] edit(T[] array, Editor<T> editor) {
        if (null == editor) {
            return array;
        }
        ArrayList list = new ArrayList(array.length);
        for (T t : array) {
            T modified = editor.edit(t);
            if (null == modified) continue;
            list.add(modified);
        }
        Object[] result = ArrayUtil.newArray(array.getClass().getComponentType(), list.size());
        return list.toArray(result);
    }

    public static <T> T[] filter(T[] array, Filter<T> filter) {
        if (null == array || null == filter) {
            return array;
        }
        return ArrayUtil.edit(array, t -> filter.accept(t) ? t : null);
    }

    public static <T> T[] removeNull(T[] array) {
        return ArrayUtil.edit(array, t -> t);
    }

    public static <T extends CharSequence> T[] removeEmpty(T[] array) {
        return ArrayUtil.filter(array, CharSequenceUtil::isNotEmpty);
    }

    public static <T extends CharSequence> T[] removeBlank(T[] array) {
        return ArrayUtil.filter(array, CharSequenceUtil::isNotBlank);
    }

    public static String[] nullToEmpty(String[] array) {
        return ArrayUtil.edit(array, t -> null == t ? "" : t);
    }

    public static <K, V> Map<K, V> zip(K[] keys, V[] values, boolean isOrder) {
        if (ArrayUtil.isEmpty(keys) || ArrayUtil.isEmpty(values)) {
            return null;
        }
        int size = Math.min((int)keys.length, (int)values.length);
        HashMap map = MapUtil.newHashMap(size, isOrder);
        for (int i = 0; i < size; ++i) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    public static <K, V> Map<K, V> zip(K[] keys, V[] values) {
        return ArrayUtil.zip(keys, values, false);
    }

    public static <T> int indexOf(T[] array, Object value, int beginIndexInclude) {
        return ArrayUtil.matchIndex((T obj) -> ObjectUtil.equal(value, obj), beginIndexInclude, array);
    }

    public static <T> int indexOf(T[] array, Object value) {
        return ArrayUtil.matchIndex((T obj) -> ObjectUtil.equal(value, obj), array);
    }

    public static int indexOfIgnoreCase(CharSequence[] array, CharSequence value) {
        if (null != array) {
            for (int i = 0; i < array.length; ++i) {
                if (!StrUtil.equalsIgnoreCase(array[i], value)) continue;
                return i;
            }
        }
        return -1;
    }

    public static <T> int lastIndexOf(T[] array, Object value) {
        if (ArrayUtil.isEmpty(array)) {
            return -1;
        }
        return ArrayUtil.lastIndexOf(array, value, array.length - 1);
    }

    public static <T> int lastIndexOf(T[] array, Object value, int endInclude) {
        if (ArrayUtil.isNotEmpty(array)) {
            for (int i = endInclude; i >= 0; --i) {
                if (!ObjectUtil.equal(value, array[i])) continue;
                return i;
            }
        }
        return -1;
    }

    public static <T> boolean contains(T[] array, T value) {
        return ArrayUtil.indexOf(array, value) > -1;
    }

    public static <T> boolean containsAny(T[] array, T ... values) {
        for (T value : values) {
            if (!ArrayUtil.contains(array, value)) continue;
            return true;
        }
        return false;
    }

    public static <T> boolean containsAll(T[] array, T ... values) {
        for (T value : values) {
            if (ArrayUtil.contains(array, value)) continue;
            return false;
        }
        return true;
    }

    public static boolean containsIgnoreCase(CharSequence[] array, CharSequence value) {
        return ArrayUtil.indexOfIgnoreCase(array, value) > -1;
    }

    /*
     * Exception decompiling
     */
    public static Object[] wrap(Object obj) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(Unknown Source:34)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(Unknown Source:0)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(Unknown Source:67)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(Unknown Source:12)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(Unknown Source:8)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(Unknown Source:13)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(Unknown Source:2)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(Unknown Source:648)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(Unknown Source:36)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(Unknown Source:1503)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(Unknown Source:6)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(Unknown Source:94)
         *     at android.s.ۥۣۢۧ.ۥ۟۟(Unknown Source:10)
         *     at org.benf.cfr.reader.entities.Method.ۥ۟۟۟(Unknown Source:4)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۤ(Unknown Source:91)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۨ(Unknown Source:0)
         *     at android.s.ۦۦ۟.ۥ۟۟۟(Unknown Source:190)
         *     at android.s.ۦۦ۟.ۥ۟۟(Unknown Source:144)
         *     at android.s.ۥۧۥ۟.ۥ(Unknown Source:107)
         *     at android.s.ۥۦۨۡ.ۥ(Unknown Source:83)
         *     at com.efs.sdk.pa.a.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁣⁠⁠⁤⁠⁠⁣⁣⁣⁣⁣⁠.⁣⁤⁠⁠⁠⁠⁣⁣⁣⁠⁠⁤⁠⁣⁤⁤⁠⁤⁤⁠⁠⁠⁣⁣⁠(Unknown Source:8)
         *     at android.s.ۥۦۨ۠.ۥ۟(Unknown Source:53)
         *     at org.apache.commons.lang3.builder.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁤⁠⁤⁤⁤⁠⁤⁠⁠⁠⁣.⁣⁤⁠⁠⁠⁣⁤⁤⁣⁤⁤⁤⁣⁤⁠⁠⁤⁤⁤⁠⁤⁤⁠⁠⁣⁠⁠⁠⁣⁣⁣(Unknown Source:10)
         *     at android.s.ۥۦۨ۠.ۥ(Unknown Source:99)
         *     at org.apache.xerces.xni.parser.⁣⁣⁣⁣⁣⁠⁣⁤⁠⁠⁣⁤⁤⁠⁤⁤.⁠⁣⁤⁣⁤⁠⁣⁤⁠⁠⁠⁣⁣⁤⁤⁣⁠(Unknown Source:8)
         *     at android.s.go$ۥ۟۟۠$ۥ.run(Unknown Source:92)
         *     at java.lang.Thread.run(Thread.java:1012)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static boolean isArray(Object obj) {
        return null != obj && obj.getClass().isArray();
    }

    public static <T> T get(Object array, int index) {
        if (null == array) {
            return null;
        }
        if (index < 0) {
            index += Array.getLength((Object)array);
        }
        try {
            return (T)Array.get((Object)array, (int)index);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static <T> T[] getAny(Object array, int ... indexes) {
        if (null == array) {
            return null;
        }
        if (null == indexes) {
            return ArrayUtil.newArray(array.getClass().getComponentType(), 0);
        }
        T[] result = ArrayUtil.newArray(array.getClass().getComponentType(), indexes.length);
        for (int i = 0; i < indexes.length; ++i) {
            result[i] = ArrayUtil.get(array, indexes[i]);
        }
        return result;
    }

    public static <T> T[] sub(T[] array, int start, int end) {
        int length = ArrayUtil.length(array);
        if (start < 0) {
            start += length;
        }
        if (end < 0) {
            end += length;
        }
        if (start == length) {
            return ArrayUtil.newArray(array.getClass().getComponentType(), 0);
        }
        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }
        if (end > length) {
            if (start >= length) {
                return ArrayUtil.newArray(array.getClass().getComponentType(), 0);
            }
            end = length;
        }
        return Arrays.copyOfRange((Object[])array, (int)start, (int)end);
    }

    public static Object[] sub(Object array, int start, int end) {
        return ArrayUtil.sub(array, start, end, 1);
    }

    public static Object[] sub(Object array, int start, int end, int step) {
        int length = ArrayUtil.length(array);
        if (start < 0) {
            start += length;
        }
        if (end < 0) {
            end += length;
        }
        if (start == length) {
            return new Object[0];
        }
        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }
        if (end > length) {
            if (start >= length) {
                return new Object[0];
            }
            end = length;
        }
        if (step <= 1) {
            step = 1;
        }
        ArrayList list = new ArrayList();
        for (int i = start; i < end; i += step) {
            list.add(ArrayUtil.get(array, i));
        }
        return list.toArray();
    }

    public static String toString(Object obj) {
        if (null == obj) {
            return null;
        }
        if (obj instanceof long[]) {
            return Arrays.toString((long[])((long[])obj));
        }
        if (obj instanceof int[]) {
            return Arrays.toString((int[])((int[])obj));
        }
        if (obj instanceof short[]) {
            return Arrays.toString((short[])((short[])obj));
        }
        if (obj instanceof char[]) {
            return Arrays.toString((char[])((char[])obj));
        }
        if (obj instanceof byte[]) {
            return Arrays.toString((byte[])((byte[])obj));
        }
        if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[])((boolean[])obj));
        }
        if (obj instanceof float[]) {
            return Arrays.toString((float[])((float[])obj));
        }
        if (obj instanceof double[]) {
            return Arrays.toString((double[])((double[])obj));
        }
        if (ArrayUtil.isArray(obj)) {
            try {
                return Arrays.deepToString((Object[])((Object[])obj));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return obj.toString();
    }

    public static int length(Object array) throws IllegalArgumentException {
        if (null == array) {
            return 0;
        }
        return Array.getLength((Object)array);
    }

    public static <T> String join(T[] array, CharSequence conjunction) {
        return ArrayUtil.join(array, conjunction, null, null);
    }

    public static <T> String join(T[] array, CharSequence delimiter, String prefix, String suffix) {
        if (null == array) {
            return null;
        }
        return StrJoiner.of(delimiter, prefix, suffix).setWrapElement(true).append(array).toString();
    }

    public static <T> String join(T[] array, CharSequence conjunction, Editor<T> editor) {
        return StrJoiner.of(conjunction).append(array, t -> String.valueOf((Object)editor.edit(t))).toString();
    }

    public static String join(Object array, CharSequence conjunction) {
        if (null == array) {
            return null;
        }
        if (!ArrayUtil.isArray(array)) {
            throw new IllegalArgumentException(StrUtil.format("[{}] is not a Array!", array.getClass()));
        }
        return StrJoiner.of(conjunction).append(array).toString();
    }

    public static byte[] toArray(ByteBuffer bytebuffer) {
        if (bytebuffer.hasArray()) {
            return Arrays.copyOfRange((byte[])bytebuffer.array(), (int)bytebuffer.position(), (int)bytebuffer.limit());
        }
        int oldPosition = bytebuffer.position();
        bytebuffer.position(0);
        int size = bytebuffer.limit();
        byte[] buffers = new byte[size];
        bytebuffer.get(buffers);
        bytebuffer.position(oldPosition);
        return buffers;
    }

    public static <T> T[] toArray(Iterator<T> iterator, Class<T> componentType) {
        return ArrayUtil.toArray(CollUtil.newArrayList(iterator), componentType);
    }

    public static <T> T[] toArray(Iterable<T> iterable, Class<T> componentType) {
        return ArrayUtil.toArray(CollectionUtil.toCollection(iterable), componentType);
    }

    public static <T> T[] toArray(Collection<T> collection, Class<T> componentType) {
        return collection.toArray((Object[])ArrayUtil.newArray(componentType, 0));
    }

    public static <T> T[] remove(T[] array, int index) throws IllegalArgumentException {
        return (Object[])ArrayUtil.remove(array, index);
    }

    public static <T> T[] removeEle(T[] array, T element) throws IllegalArgumentException {
        return ArrayUtil.remove(array, ArrayUtil.indexOf(array, element));
    }

    public static <T> T[] reverse(T[] array, int startIndexInclusive, int endIndexExclusive) {
        if (ArrayUtil.isEmpty(array)) {
            return array;
        }
        int i = Math.max((int)startIndexInclusive, (int)0);
        for (int j = Math.min((int)array.length, (int)endIndexExclusive) - 1; j > i; --j, ++i) {
            T tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
        return array;
    }

    public static <T> T[] reverse(T[] array) {
        return ArrayUtil.reverse(array, 0, array.length);
    }

    public static <T extends Comparable<? super T>> T min(T[] numberArray) {
        return (T)ArrayUtil.min(numberArray, null);
    }

    public static <T extends Comparable<? super T>> T min(T[] numberArray, Comparator<T> comparator) {
        if (ArrayUtil.isEmpty(numberArray)) {
            throw new IllegalArgumentException("Number array must not empty !");
        }
        T min = numberArray[0];
        for (T t : numberArray) {
            if (CompareUtil.compare(min, t, comparator) <= 0) continue;
            min = t;
        }
        return min;
    }

    public static <T extends Comparable<? super T>> T max(T[] numberArray) {
        return (T)ArrayUtil.max(numberArray, null);
    }

    public static <T extends Comparable<? super T>> T max(T[] numberArray, Comparator<T> comparator) {
        if (ArrayUtil.isEmpty(numberArray)) {
            throw new IllegalArgumentException("Number array must not empty !");
        }
        T max = numberArray[0];
        for (int i = 1; i < numberArray.length; ++i) {
            if (CompareUtil.compare(max, numberArray[i], comparator) >= 0) continue;
            max = numberArray[i];
        }
        return max;
    }

    public static <T> T[] shuffle(T[] array) {
        return ArrayUtil.shuffle(array, (Random)RandomUtil.getRandom());
    }

    public static <T> T[] shuffle(T[] array, Random random) {
        if (array == null || random == null || array.length <= 1) {
            return array;
        }
        for (int i = array.length; i > 1; --i) {
            ArrayUtil.swap(array, i - 1, random.nextInt(i));
        }
        return array;
    }

    public static <T> T[] swap(T[] array, int index1, int index2) {
        if (ArrayUtil.isEmpty(array)) {
            throw new IllegalArgumentException("Array must not empty !");
        }
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }

    public static Object swap(Object array, int index1, int index2) {
        if (ArrayUtil.isEmpty(array)) {
            throw new IllegalArgumentException("Array must not empty !");
        }
        Object tmp = ArrayUtil.get(array, index1);
        Array.set((Object)array, (int)index1, (Object)Array.get((Object)array, (int)index2));
        Array.set((Object)array, (int)index2, tmp);
        return array;
    }

    public static int emptyCount(Object ... args) {
        int count = 0;
        if (ArrayUtil.isNotEmpty(args)) {
            for (Object element : args) {
                if (!ObjectUtil.isEmpty(element)) continue;
                ++count;
            }
        }
        return count;
    }

    public static boolean hasEmpty(Object ... args) {
        if (ArrayUtil.isNotEmpty(args)) {
            for (Object element : args) {
                if (!ObjectUtil.isEmpty(element)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean isAllEmpty(Object ... args) {
        for (Object obj : args) {
            if (ObjectUtil.isEmpty(obj)) continue;
            return false;
        }
        return true;
    }

    public static boolean isAllNotEmpty(Object ... args) {
        return false == ArrayUtil.hasEmpty(args);
    }

    public static <T> boolean isAllNotNull(T ... array) {
        return false == ArrayUtil.hasNull(array);
    }

    public static <T> T[] distinct(T[] array) {
        if (ArrayUtil.isEmpty(array)) {
            return array;
        }
        LinkedHashSet set = new LinkedHashSet(array.length, 1.0f);
        Collections.addAll((Collection)set, (Object[])array);
        return ArrayUtil.toArray(set, ArrayUtil.getComponentType(array));
    }

    public static <T, K> T[] distinct(T[] array, Function<T, K> uniqueGenerator, boolean override) {
        if (ArrayUtil.isEmpty(array)) {
            return array;
        }
        UniqueKeySet<K, T> set = new UniqueKeySet<K, T>(true, uniqueGenerator);
        if (override) {
            Collections.addAll(set, (Object[])array);
        } else {
            for (T t : array) {
                set.addIfAbsent(t);
            }
        }
        return ArrayUtil.toArray(set, ArrayUtil.getComponentType(array));
    }

    public static <T, R> R[] map(T[] array, Class<R> targetComponentType, Function<? super T, ? extends R> func) {
        T[] result = ArrayUtil.newArray(targetComponentType, array.length);
        for (int i = 0; i < array.length; ++i) {
            result[i] = func.apply(array[i]);
        }
        return result;
    }

    public static <T, R> R[] map(Object array, Class<R> targetComponentType, Function<? super T, ? extends R> func) {
        int length = ArrayUtil.length(array);
        T[] result = ArrayUtil.newArray(targetComponentType, length);
        for (int i = 0; i < length; ++i) {
            result[i] = func.apply(ArrayUtil.get(array, i));
        }
        return result;
    }

    public static <T, R> List<R> map(T[] array, Function<? super T, ? extends R> func) {
        return (List)Arrays.stream((Object[])array).map(func).collect(Collectors.toList());
    }

    public static <T, R> Set<R> mapToSet(T[] array, Function<? super T, ? extends R> func) {
        return (Set)Arrays.stream((Object[])array).map(func).collect(Collectors.toSet());
    }

    public static boolean equals(Object array1, Object array2) {
        if (array1 == array2) {
            return true;
        }
        if (ArrayUtil.hasNull(array1, array2)) {
            return false;
        }
        Assert.isTrue(ArrayUtil.isArray(array1), "First is not a Array !", new Object[0]);
        Assert.isTrue(ArrayUtil.isArray(array2), "Second is not a Array !", new Object[0]);
        if (array1 instanceof long[]) {
            return Arrays.equals((long[])((long[])array1), (long[])((long[])array2));
        }
        if (array1 instanceof int[]) {
            return Arrays.equals((int[])((int[])array1), (int[])((int[])array2));
        }
        if (array1 instanceof short[]) {
            return Arrays.equals((short[])((short[])array1), (short[])((short[])array2));
        }
        if (array1 instanceof char[]) {
            return Arrays.equals((char[])((char[])array1), (char[])((char[])array2));
        }
        if (array1 instanceof byte[]) {
            return Arrays.equals((byte[])((byte[])array1), (byte[])((byte[])array2));
        }
        if (array1 instanceof double[]) {
            return Arrays.equals((double[])((double[])array1), (double[])((double[])array2));
        }
        if (array1 instanceof float[]) {
            return Arrays.equals((float[])((float[])array1), (float[])((float[])array2));
        }
        if (array1 instanceof boolean[]) {
            return Arrays.equals((boolean[])((boolean[])array1), (boolean[])((boolean[])array2));
        }
        return Arrays.deepEquals((Object[])((Object[])array1), (Object[])((Object[])array2));
    }

    public static <T> boolean isSub(T[] array, T[] subArray) {
        return ArrayUtil.indexOfSub(array, subArray) > -1;
    }

    public static <T> int indexOfSub(T[] array, T[] subArray) {
        return ArrayUtil.indexOfSub(array, 0, subArray);
    }

    public static <T> int indexOfSub(T[] array, int beginInclude, T[] subArray) {
        if (ArrayUtil.isEmpty(array) || ArrayUtil.isEmpty(subArray) || subArray.length > array.length) {
            return -1;
        }
        int firstIndex = ArrayUtil.indexOf(array, subArray[0], beginInclude);
        if (firstIndex < 0 || firstIndex + subArray.length > array.length) {
            return -1;
        }
        for (int i = 0; i < subArray.length; ++i) {
            if (ObjectUtil.equal(array[i + firstIndex], subArray[i])) continue;
            return ArrayUtil.indexOfSub(array, firstIndex + 1, subArray);
        }
        return firstIndex;
    }

    public static <T> int lastIndexOfSub(T[] array, T[] subArray) {
        if (ArrayUtil.isEmpty(array) || ArrayUtil.isEmpty(subArray)) {
            return -1;
        }
        return ArrayUtil.lastIndexOfSub(array, array.length - 1, subArray);
    }

    public static <T> int lastIndexOfSub(T[] array, int endInclude, T[] subArray) {
        if (ArrayUtil.isEmpty(array) || ArrayUtil.isEmpty(subArray) || subArray.length > array.length || endInclude < 0) {
            return -1;
        }
        int firstIndex = ArrayUtil.lastIndexOf(array, subArray[0]);
        if (firstIndex < 0 || firstIndex + subArray.length > array.length) {
            return -1;
        }
        for (int i = 0; i < subArray.length; ++i) {
            if (ObjectUtil.equal(array[i + firstIndex], subArray[i])) continue;
            return ArrayUtil.lastIndexOfSub(array, firstIndex - 1, subArray);
        }
        return firstIndex;
    }

    public static <T> boolean isSorted(T[] array, Comparator<? super T> comparator) {
        if (array == null || comparator == null) {
            return false;
        }
        for (int i = 0; i < array.length - 1; ++i) {
            if (comparator.compare(array[i], array[i + 1]) <= 0) continue;
            return false;
        }
        return true;
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] array) {
        return ArrayUtil.isSortedASC(array);
    }

    public static <T extends Comparable<? super T>> boolean isSortedASC(T[] array) {
        if (array == null) {
            return false;
        }
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) <= 0) continue;
            return false;
        }
        return true;
    }

    public static <T extends Comparable<? super T>> boolean isSortedDESC(T[] array) {
        if (array == null) {
            return false;
        }
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) >= 0) continue;
            return false;
        }
        return true;
    }
}

