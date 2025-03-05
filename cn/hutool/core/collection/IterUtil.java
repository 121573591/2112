/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Dictionary
 *  java.util.Enumeration
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.function.Consumer
 *  java.util.function.Function
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package cn.hutool.core.collection;

import cn.hutool.core.collection.ArrayIter;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.EnumerationIter;
import cn.hutool.core.collection.FilterIter;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.collection.NodeListIter;
import cn.hutool.core.collection.TransIter;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.lang.Matcher;
import cn.hutool.core.lang.func.Func1;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.StrJoiner;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IterUtil {
    public static <T> Iterator<T> getIter(Iterable<T> iterable) {
        return null == iterable ? null : iterable.iterator();
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        return null == iterable || IterUtil.isEmpty(iterable.iterator());
    }

    public static boolean isEmpty(Iterator<?> Iterator2) {
        return null == Iterator2 || false == Iterator2.hasNext();
    }

    public static boolean isNotEmpty(Iterable<?> iterable) {
        return null != iterable && IterUtil.isNotEmpty(iterable.iterator());
    }

    public static boolean isNotEmpty(Iterator<?> Iterator2) {
        return null != Iterator2 && Iterator2.hasNext();
    }

    public static boolean hasNull(Iterable<?> iter) {
        return IterUtil.hasNull(null == iter ? null : iter.iterator());
    }

    public static boolean hasNull(Iterator<?> iter) {
        if (null == iter) {
            return true;
        }
        while (iter.hasNext()) {
            if (null != iter.next()) continue;
            return true;
        }
        return false;
    }

    public static boolean isAllNull(Iterable<?> iter) {
        return IterUtil.isAllNull(null == iter ? null : iter.iterator());
    }

    public static boolean isAllNull(Iterator<?> iter) {
        return null == IterUtil.getFirstNoneNull(iter);
    }

    public static <T> Map<T, Integer> countMap(Iterator<T> iter) {
        HashMap countMap = new HashMap();
        if (null != iter) {
            while (iter.hasNext()) {
                Object t = iter.next();
                countMap.put(t, (Object)((Integer)countMap.getOrDefault(t, (Object)0) + 1));
            }
        }
        return countMap;
    }

    public static <K, V> Map<K, V> fieldValueMap(Iterator<V> iter, String fieldName) {
        return IterUtil.toMap(iter, new HashMap(), (V value) -> ReflectUtil.getFieldValue(value, fieldName));
    }

    public static <K, V> Map<K, V> fieldValueAsMap(Iterator<?> iter, String fieldNameForKey, String fieldNameForValue) {
        return IterUtil.toMap(iter, new HashMap(), (E value) -> ReflectUtil.getFieldValue(value, fieldNameForKey), (E value) -> ReflectUtil.getFieldValue(value, fieldNameForValue));
    }

    public static <V> List<Object> fieldValueList(Iterable<V> iterable, String fieldName) {
        return IterUtil.fieldValueList(IterUtil.getIter(iterable), fieldName);
    }

    public static <V> List<Object> fieldValueList(Iterator<V> iter, String fieldName) {
        ArrayList result = new ArrayList();
        if (null != iter) {
            while (iter.hasNext()) {
                Object value = iter.next();
                result.add(ReflectUtil.getFieldValue(value, fieldName));
            }
        }
        return result;
    }

    public static <T> String join(Iterator<T> iterator, CharSequence conjunction) {
        return StrJoiner.of(conjunction).append(iterator).toString();
    }

    public static <T> String join(Iterator<T> iterator, CharSequence conjunction, String prefix, String suffix) {
        return StrJoiner.of(conjunction, prefix, suffix).setWrapElement(true).append(iterator).toString();
    }

    public static <T> String join(Iterator<T> iterator, CharSequence conjunction, Function<T, ? extends CharSequence> func) {
        if (null == iterator) {
            return null;
        }
        return StrJoiner.of(conjunction).append(iterator, func).toString();
    }

    public static <K, V> HashMap<K, V> toMap(Iterable<Map.Entry<K, V>> entryIter) {
        HashMap map = new HashMap();
        if (IterUtil.isNotEmpty(entryIter)) {
            for (Map.Entry entry : entryIter) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public static <K, V> Map<K, V> toMap(Iterable<K> keys, Iterable<V> values) {
        return IterUtil.toMap(keys, values, false);
    }

    public static <K, V> Map<K, V> toMap(Iterable<K> keys, Iterable<V> values, boolean isOrder) {
        return IterUtil.toMap(null == keys ? null : keys.iterator(), null == values ? null : values.iterator(), isOrder);
    }

    public static <K, V> Map<K, V> toMap(Iterator<K> keys, Iterator<V> values) {
        return IterUtil.toMap(keys, values, false);
    }

    public static <K, V> Map<K, V> toMap(Iterator<K> keys, Iterator<V> values, boolean isOrder) {
        HashMap resultMap = MapUtil.newHashMap(isOrder);
        if (IterUtil.isNotEmpty(keys)) {
            while (keys.hasNext()) {
                resultMap.put(keys.next(), null != values && values.hasNext() ? values.next() : null);
            }
        }
        return resultMap;
    }

    public static <K, V> Map<K, List<V>> toListMap(Iterable<V> iterable, Function<V, K> keyMapper) {
        return IterUtil.toListMap(iterable, keyMapper, v -> v);
    }

    public static <T, K, V> Map<K, List<V>> toListMap(Iterable<T> iterable, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return IterUtil.toListMap(MapUtil.newHashMap(), iterable, keyMapper, valueMapper);
    }

    public static <T, K, V> Map<K, List<V>> toListMap(Map<K, List<V>> resultMap, Iterable<T> iterable, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        if (null == resultMap) {
            resultMap = MapUtil.newHashMap();
        }
        if (ObjectUtil.isNull(iterable)) {
            return resultMap;
        }
        for (Object value : iterable) {
            ((List)resultMap.computeIfAbsent(keyMapper.apply(value), k -> new ArrayList())).add(valueMapper.apply(value));
        }
        return resultMap;
    }

    public static <K, V> Map<K, V> toMap(Iterable<V> iterable, Function<V, K> keyMapper) {
        return IterUtil.toMap(iterable, keyMapper, v -> v);
    }

    public static <T, K, V> Map<K, V> toMap(Iterable<T> iterable, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return IterUtil.toMap(MapUtil.newHashMap(), iterable, keyMapper, valueMapper);
    }

    public static <T, K, V> Map<K, V> toMap(Map<K, V> resultMap, Iterable<T> iterable, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        if (null == resultMap) {
            resultMap = MapUtil.newHashMap();
        }
        if (ObjectUtil.isNull(iterable)) {
            return resultMap;
        }
        for (Object value : iterable) {
            resultMap.put(keyMapper.apply(value), valueMapper.apply(value));
        }
        return resultMap;
    }

    public static <E> List<E> toList(Iterable<E> iter) {
        if (null == iter) {
            return null;
        }
        return IterUtil.toList(iter.iterator());
    }

    public static <E> List<E> toList(Iterator<E> iter) {
        return ListUtil.toList(iter);
    }

    public static <E> Iterator<E> asIterator(Enumeration<E> e) {
        return new EnumerationIter<E>(e);
    }

    public static <E> Iterable<E> asIterable(Iterator<E> iter) {
        return () -> iter;
    }

    public static <E> E get(Iterator<E> iterator, int index) throws IndexOutOfBoundsException {
        if (null == iterator) {
            return null;
        }
        Assert.isTrue(index >= 0, "[index] must be >= 0", new Object[0]);
        while (iterator.hasNext()) {
            if (-1 == --index) {
                return (E)iterator.next();
            }
            iterator.next();
        }
        return null;
    }

    public static <T> T getFirst(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List)iterable;
            return (T)(CollUtil.isEmpty(list) ? null : list.get(0));
        }
        return IterUtil.getFirst(IterUtil.getIter(iterable));
    }

    public static <T> T getFirstNoneNull(Iterable<T> iterable) {
        if (null == iterable) {
            return null;
        }
        return IterUtil.getFirstNoneNull(iterable.iterator());
    }

    public static <T> T getFirst(Iterator<T> iterator) {
        return IterUtil.get(iterator, 0);
    }

    public static <T> T getFirstNoneNull(Iterator<T> iterator) {
        return (T)IterUtil.firstMatch(iterator, Objects::nonNull);
    }

    public static <T> T firstMatch(Iterator<T> iterator, Matcher<T> matcher) {
        Assert.notNull(matcher, "Matcher must be not null !", new Object[0]);
        if (null != iterator) {
            while (iterator.hasNext()) {
                Object next = iterator.next();
                if (!matcher.match(next)) continue;
                return (T)next;
            }
        }
        return null;
    }

    public static Class<?> getElementType(Iterable<?> iterable) {
        return IterUtil.getElementType(IterUtil.getIter(iterable));
    }

    public static Class<?> getElementType(Iterator<?> iterator) {
        if (null == iterator) {
            return null;
        }
        Object ele = IterUtil.getFirstNoneNull(iterator);
        return null == ele ? null : ele.getClass();
    }

    public static <T> List<T> edit(Iterable<T> iter, Editor<T> editor) {
        ArrayList result = new ArrayList();
        if (null == iter) {
            return result;
        }
        for (Object t : iter) {
            Object modified = null == editor ? t : editor.edit(t);
            if (null == modified) continue;
            result.add(modified);
        }
        return result;
    }

    public static <T extends Iterable<E>, E> T filter(T iter, Filter<E> filter) {
        if (null == iter) {
            return null;
        }
        IterUtil.filter(iter.iterator(), filter);
        return iter;
    }

    public static <E> Iterator<E> filter(Iterator<E> iter, Filter<E> filter) {
        if (null == iter || null == filter) {
            return iter;
        }
        while (iter.hasNext()) {
            if (filter.accept(iter.next())) continue;
            iter.remove();
        }
        return iter;
    }

    public static <E> List<E> filterToList(Iterator<E> iter, Filter<E> filter) {
        return IterUtil.toList(IterUtil.filtered(iter, filter));
    }

    public static <E> FilterIter<E> filtered(Iterator<? extends E> iterator, Filter<? super E> filter) {
        return new FilterIter<E>(iterator, filter);
    }

    public static <K, V> Map<K, V> toMap(Iterator<V> iterator, Map<K, V> map, Func1<V, K> keyFunc) {
        return IterUtil.toMap(iterator, map, keyFunc, (E value) -> value);
    }

    public static <K, V, E> Map<K, V> toMap(Iterator<E> iterator, Map<K, V> map, Func1<E, K> keyFunc, Func1<E, V> valueFunc) {
        if (null == iterator) {
            return map;
        }
        if (null == map) {
            map = MapUtil.newHashMap(true);
        }
        while (iterator.hasNext()) {
            Object element = iterator.next();
            try {
                map.put(keyFunc.call(element), valueFunc.call(element));
            }
            catch (Exception e) {
                throw new UtilException(e);
            }
        }
        return map;
    }

    public static <T> Iterator<T> empty() {
        return Collections.emptyIterator();
    }

    public static <F, T> Iterator<T> trans(Iterator<F> iterator, Function<? super F, ? extends T> function) {
        return new TransIter<F, T>(iterator, function);
    }

    public static int size(Iterable<?> iterable) {
        if (null == iterable) {
            return 0;
        }
        if (iterable instanceof Collection) {
            return ((Collection)iterable).size();
        }
        return IterUtil.size(iterable.iterator());
    }

    public static int size(Iterator<?> iterator) {
        int size = 0;
        if (iterator != null) {
            while (iterator.hasNext()) {
                iterator.next();
                ++size;
            }
        }
        return size;
    }

    public static boolean isEqualList(Iterable<?> list1, Iterable<?> list2) {
        if (list1 == list2) {
            return true;
        }
        Iterator it1 = list1.iterator();
        Iterator it2 = list2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            Object obj2;
            Object obj1 = it1.next();
            if (Objects.equals((Object)obj1, (Object)(obj2 = it2.next()))) continue;
            return false;
        }
        return false == (it1.hasNext() || it2.hasNext());
    }

    public static void clear(Iterator<?> iterator) {
        if (null != iterator) {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
    }

    public static <E> void forEach(Iterator<E> iterator, Consumer<? super E> consumer) {
        if (iterator != null) {
            while (iterator.hasNext()) {
                Object element = iterator.next();
                if (null == consumer) continue;
                consumer.accept(element);
            }
        }
    }

    public static <E> String toStr(Iterator<E> iterator) {
        return IterUtil.toStr(iterator, ObjectUtil::toString);
    }

    public static <E> String toStr(Iterator<E> iterator, Function<? super E, String> transFunc) {
        return IterUtil.toStr(iterator, transFunc, ", ", "[", "]");
    }

    public static <E> String toStr(Iterator<E> iterator, Function<? super E, String> transFunc, String delimiter, String prefix, String suffix) {
        StrJoiner strJoiner = StrJoiner.of(delimiter, prefix, suffix);
        strJoiner.append(iterator, transFunc);
        return strJoiner.toString();
    }

    public static Iterator<?> getIter(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Iterator) {
            return (Iterator)obj;
        }
        if (obj instanceof Iterable) {
            return ((Iterable)obj).iterator();
        }
        if (ArrayUtil.isArray(obj)) {
            return new ArrayIter(obj);
        }
        if (obj instanceof Enumeration) {
            return new EnumerationIter((Enumeration)obj);
        }
        if (obj instanceof Map) {
            return ((Map)obj).entrySet().iterator();
        }
        if (obj instanceof NodeList) {
            return new NodeListIter((NodeList)obj);
        }
        if (obj instanceof Node) {
            return new NodeListIter(((Node)obj).getChildNodes());
        }
        if (obj instanceof Dictionary) {
            return new EnumerationIter(((Dictionary)obj).elements());
        }
        try {
            Object iterator = ReflectUtil.invoke(obj, "iterator", new Object[0]);
            if (iterator instanceof Iterator) {
                return (Iterator)iterator;
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        return new ArrayIter<Object>(new Object[]{obj});
    }
}

