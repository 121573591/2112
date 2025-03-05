/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Double
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.invoke.MethodHandle
 *  java.lang.invoke.MethodHandles
 *  java.lang.invoke.MethodType
 *  java.lang.reflect.Array
 *  java.text.Collator
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.LinkedList
 *  java.util.Locale
 *  java.util.Set
 *  jdk.dynalink.CallSiteDescriptor
 *  jdk.dynalink.linker.GuardedInvocation
 *  jdk.dynalink.linker.LinkRequest
 */
package org.openjdk.nashorn.internal.objects;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Array;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import jdk.dynalink.CallSiteDescriptor;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.LinkRequest;
import org.openjdk.nashorn.internal.lookup.Lookup;
import org.openjdk.nashorn.internal.lookup.MethodHandleFactory;
import org.openjdk.nashorn.internal.objects.Global;
import org.openjdk.nashorn.internal.objects.NativeArray;
import org.openjdk.nashorn.internal.objects.NativeRegExp;
import org.openjdk.nashorn.internal.objects.NativeRegExpExecResult;
import org.openjdk.nashorn.internal.objects.StringIterator;
import org.openjdk.nashorn.internal.objects.annotations.SpecializedFunction;
import org.openjdk.nashorn.internal.runtime.AccessorProperty;
import org.openjdk.nashorn.internal.runtime.ConsString;
import org.openjdk.nashorn.internal.runtime.ECMAErrors;
import org.openjdk.nashorn.internal.runtime.JSType;
import org.openjdk.nashorn.internal.runtime.OptimisticBuiltins;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyMap;
import org.openjdk.nashorn.internal.runtime.ScriptObject;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayIndex;
import org.openjdk.nashorn.internal.runtime.linker.Bootstrap;
import org.openjdk.nashorn.internal.runtime.linker.NashornCallSiteDescriptor;
import org.openjdk.nashorn.internal.runtime.linker.NashornGuards;
import org.openjdk.nashorn.internal.runtime.linker.PrimitiveLookup;

public final class NativeString
extends ScriptObject
implements OptimisticBuiltins {
    private final CharSequence value;
    static final MethodHandle WRAPFILTER = NativeString.findOwnMH("wrapFilter", Lookup.MH.type(NativeString.class, Object.class));
    private static final MethodHandle PROTOFILTER = NativeString.findOwnMH("protoFilter", Lookup.MH.type(Object.class, Object.class));
    private static PropertyMap $nasgenmap$;

    private NativeString(CharSequence value) {
        this(value, Global.instance());
    }

    NativeString(CharSequence value, Global global) {
        this(value, global.getStringPrototype(), $nasgenmap$);
    }

    private NativeString(CharSequence value, ScriptObject proto, PropertyMap map) {
        super(proto, map);
        assert (JSType.isString(value));
        this.value = value;
    }

    @Override
    public String safeToString() {
        return "[String " + this.toString() + "]";
    }

    public String toString() {
        return this.getStringValue();
    }

    private String getStringValue() {
        return this.value instanceof String ? (String)this.value : this.value.toString();
    }

    private CharSequence getValue() {
        return this.value;
    }

    @Override
    public String getClassName() {
        return "String";
    }

    @Override
    public Object getLength() {
        return this.value.length();
    }

    @Override
    protected GuardedInvocation findGetMethod(CallSiteDescriptor desc, LinkRequest request) {
        String name = NashornCallSiteDescriptor.getOperand(desc);
        if ("length".equals((Object)name) && NashornCallSiteDescriptor.isMethodFirstOperation(desc)) {
            return null;
        }
        return super.findGetMethod(desc, request);
    }

    @Override
    protected GuardedInvocation findGetIndexMethod(CallSiteDescriptor desc, LinkRequest request) {
        Object self = request.getReceiver();
        Class returnType = desc.getMethodType().returnType();
        if (returnType == Object.class && JSType.isString(self)) {
            try {
                return new GuardedInvocation(Lookup.MH.findStatic(MethodHandles.lookup(), NativeString.class, "get", desc.getMethodType()), NashornGuards.getStringGuard());
            }
            catch (MethodHandleFactory.LookupException lookupException) {
                // empty catch block
            }
        }
        return super.findGetIndexMethod(desc, request);
    }

    private static Object get(Object self, Object key) {
        CharSequence cs = JSType.toCharSequence(self);
        Object primitiveKey = JSType.toPrimitive(key, String.class);
        int index = ArrayIndex.getArrayIndex(primitiveKey);
        if (index >= 0 && index < cs.length()) {
            return String.valueOf((char)cs.charAt(index));
        }
        return ((ScriptObject)Global.toObject(self)).get(primitiveKey);
    }

    private static Object get(Object self, double key) {
        if (JSType.isRepresentableAsInt(key)) {
            return NativeString.get(self, (int)key);
        }
        return ((ScriptObject)Global.toObject(self)).get(key);
    }

    private static Object get(Object self, long key) {
        CharSequence cs = JSType.toCharSequence(self);
        if (key >= 0L && key < (long)cs.length()) {
            return String.valueOf((char)cs.charAt((int)key));
        }
        return ((ScriptObject)Global.toObject(self)).get(key);
    }

    private static Object get(Object self, int key) {
        CharSequence cs = JSType.toCharSequence(self);
        if (key >= 0 && key < cs.length()) {
            return String.valueOf((char)cs.charAt(key));
        }
        return ((ScriptObject)Global.toObject(self)).get(key);
    }

    @Override
    public Object get(Object key) {
        Object primitiveKey = JSType.toPrimitive(key, String.class);
        int index = ArrayIndex.getArrayIndex(primitiveKey);
        if (index >= 0 && index < this.value.length()) {
            return String.valueOf((char)this.value.charAt(index));
        }
        return super.get(primitiveKey);
    }

    @Override
    public Object get(double key) {
        if (JSType.isRepresentableAsInt(key)) {
            return this.get((int)key);
        }
        return super.get(key);
    }

    @Override
    public Object get(int key) {
        if (key >= 0 && key < this.value.length()) {
            return String.valueOf((char)this.value.charAt(key));
        }
        return super.get(key);
    }

    @Override
    public int getInt(Object key, int programPoint) {
        return JSType.toInt32MaybeOptimistic(this.get(key), programPoint);
    }

    @Override
    public int getInt(double key, int programPoint) {
        return JSType.toInt32MaybeOptimistic(this.get(key), programPoint);
    }

    @Override
    public int getInt(int key, int programPoint) {
        return JSType.toInt32MaybeOptimistic(this.get(key), programPoint);
    }

    @Override
    public double getDouble(Object key, int programPoint) {
        return JSType.toNumberMaybeOptimistic(this.get(key), programPoint);
    }

    @Override
    public double getDouble(double key, int programPoint) {
        return JSType.toNumberMaybeOptimistic(this.get(key), programPoint);
    }

    @Override
    public double getDouble(int key, int programPoint) {
        return JSType.toNumberMaybeOptimistic(this.get(key), programPoint);
    }

    @Override
    public boolean has(Object key) {
        Object primitiveKey = JSType.toPrimitive(key, String.class);
        int index = ArrayIndex.getArrayIndex(primitiveKey);
        return this.isValidStringIndex(index) || super.has(primitiveKey);
    }

    @Override
    public boolean has(int key) {
        return this.isValidStringIndex(key) || super.has(key);
    }

    @Override
    public boolean has(double key) {
        int index = ArrayIndex.getArrayIndex(key);
        return this.isValidStringIndex(index) || super.has(key);
    }

    @Override
    public boolean hasOwnProperty(Object key) {
        Object primitiveKey = JSType.toPrimitive(key, String.class);
        int index = ArrayIndex.getArrayIndex(primitiveKey);
        return this.isValidStringIndex(index) || super.hasOwnProperty(primitiveKey);
    }

    @Override
    public boolean hasOwnProperty(int key) {
        return this.isValidStringIndex(key) || super.hasOwnProperty(key);
    }

    @Override
    public boolean hasOwnProperty(double key) {
        int index = ArrayIndex.getArrayIndex(key);
        return this.isValidStringIndex(index) || super.hasOwnProperty(key);
    }

    @Override
    public boolean delete(int key, boolean strict) {
        return !this.checkDeleteIndex(key, strict) && super.delete(key, strict);
    }

    @Override
    public boolean delete(double key, boolean strict) {
        int index = ArrayIndex.getArrayIndex(key);
        return !this.checkDeleteIndex(index, strict) && super.delete(key, strict);
    }

    @Override
    public boolean delete(Object key, boolean strict) {
        Object primitiveKey = JSType.toPrimitive(key, String.class);
        int index = ArrayIndex.getArrayIndex(primitiveKey);
        return !this.checkDeleteIndex(index, strict) && super.delete(primitiveKey, strict);
    }

    private boolean checkDeleteIndex(int index, boolean strict) {
        if (this.isValidStringIndex(index)) {
            if (strict) {
                throw ECMAErrors.typeError("cant.delete.property", Integer.toString((int)index), ScriptRuntime.safeToString(this));
            }
            return true;
        }
        return false;
    }

    @Override
    public Object getOwnPropertyDescriptor(Object key) {
        int index = ArrayIndex.getArrayIndex(key);
        if (index >= 0 && index < this.value.length()) {
            Global global = Global.instance();
            return global.newDataDescriptor(String.valueOf((char)this.value.charAt(index)), false, true, false);
        }
        return super.getOwnPropertyDescriptor(key);
    }

    @Override
    protected <T> T[] getOwnKeys(Class<T> type, boolean all, Set<T> nonEnumerable) {
        if (type != String.class) {
            return super.getOwnKeys(type, all, nonEnumerable);
        }
        ArrayList keys = new ArrayList();
        for (int i = 0; i < this.value.length(); ++i) {
            keys.add((Object)JSType.toString(i));
        }
        keys.addAll((Collection)Arrays.asList((Object[])super.getOwnKeys(type, all, nonEnumerable)));
        return keys.toArray((Object[])Array.newInstance(type, (int)keys.size()));
    }

    public static Object length(Object self) {
        return NativeString.getCharSequence(self).length();
    }

    public static String fromCharCode(Object self, Object ... args) {
        char[] buf = new char[args.length];
        int index = 0;
        for (Object arg : args) {
            buf[index++] = (char)JSType.toUint16(arg);
        }
        return new String(buf);
    }

    public static Object fromCharCode(Object self, Object value) {
        if (value instanceof Integer) {
            return NativeString.fromCharCode(self, (Integer)value);
        }
        return Character.toString((char)((char)JSType.toUint16(value)));
    }

    public static String fromCharCode(Object self, int value) {
        return Character.toString((char)((char)(value & 0xFFFF)));
    }

    public static Object fromCharCode(Object self, int ch1, int ch2) {
        return Character.toString((char)((char)(ch1 & 0xFFFF))) + Character.toString((char)((char)(ch2 & 0xFFFF)));
    }

    public static Object fromCharCode(Object self, int ch1, int ch2, int ch3) {
        return Character.toString((char)((char)(ch1 & 0xFFFF))) + Character.toString((char)((char)(ch2 & 0xFFFF))) + Character.toString((char)((char)(ch3 & 0xFFFF)));
    }

    public static String fromCharCode(Object self, int ch1, int ch2, int ch3, int ch4) {
        return Character.toString((char)((char)(ch1 & 0xFFFF))) + Character.toString((char)((char)(ch2 & 0xFFFF))) + Character.toString((char)((char)(ch3 & 0xFFFF))) + Character.toString((char)((char)(ch4 & 0xFFFF)));
    }

    public static String fromCharCode(Object self, double value) {
        return Character.toString((char)((char)JSType.toUint16(value)));
    }

    public static String toString(Object self) {
        return NativeString.getString(self);
    }

    public static String valueOf(Object self) {
        return NativeString.getString(self);
    }

    public static String charAt(Object self, Object pos) {
        return NativeString.charAtImpl(NativeString.checkObjectToString(self), JSType.toInteger(pos));
    }

    public static String charAt(Object self, double pos) {
        return NativeString.charAt(self, (int)pos);
    }

    public static String charAt(Object self, int pos) {
        return NativeString.charAtImpl(NativeString.checkObjectToString(self), pos);
    }

    private static String charAtImpl(String str, int pos) {
        return pos < 0 || pos >= str.length() ? "" : String.valueOf((char)str.charAt(pos));
    }

    private static int getValidChar(Object self, int pos) {
        try {
            return ((CharSequence)self).charAt(pos);
        }
        catch (IndexOutOfBoundsException e) {
            throw new ClassCastException();
        }
    }

    public static double charCodeAt(Object self, Object pos) {
        String str = NativeString.checkObjectToString(self);
        int idx = JSType.toInteger(pos);
        return idx < 0 || idx >= str.length() ? Double.NaN : (double)str.charAt(idx);
    }

    public static int charCodeAt(Object self, double pos) {
        return NativeString.charCodeAt(self, (int)pos);
    }

    public static int charCodeAt(Object self, int pos) {
        return NativeString.getValidChar(self, pos);
    }

    public static Object concat(Object self, Object ... args) {
        CharSequence cs = NativeString.checkObjectToString(self);
        if (args != null) {
            for (Object obj : args) {
                cs = new ConsString(cs, JSType.toCharSequence(obj));
            }
        }
        return cs;
    }

    public static int indexOf(Object self, Object search, Object pos) {
        String str = NativeString.checkObjectToString(self);
        return str.indexOf(JSType.toString(search), JSType.toInteger(pos));
    }

    public static int indexOf(Object self, Object search) {
        return NativeString.indexOf(self, search, 0);
    }

    public static int indexOf(Object self, Object search, double pos) {
        return NativeString.indexOf(self, search, (int)pos);
    }

    public static int indexOf(Object self, Object search, int pos) {
        return NativeString.checkObjectToString(self).indexOf(JSType.toString(search), pos);
    }

    public static int lastIndexOf(Object self, Object search, Object pos) {
        int end;
        String str = NativeString.checkObjectToString(self);
        String searchStr = JSType.toString(search);
        int length = str.length();
        if (pos == ScriptRuntime.UNDEFINED) {
            end = length;
        } else {
            double numPos = JSType.toNumber(pos);
            int n = end = Double.isNaN((double)numPos) ? length : (int)numPos;
            if (end < 0) {
                end = 0;
            } else if (end > length) {
                end = length;
            }
        }
        return str.lastIndexOf(searchStr, end);
    }

    public static double localeCompare(Object self, Object that) {
        String str = NativeString.checkObjectToString(self);
        Collator collator = Collator.getInstance((Locale)Global.getEnv()._locale);
        collator.setStrength(3);
        collator.setDecomposition(1);
        return collator.compare(str, JSType.toString(that));
    }

    public static ScriptObject match(Object self, Object regexp) {
        NativeRegExpExecResult result;
        String str = NativeString.checkObjectToString(self);
        NativeRegExp nativeRegExp = regexp == ScriptRuntime.UNDEFINED ? new NativeRegExp("") : Global.toRegExp(regexp);
        if (!nativeRegExp.getGlobal()) {
            return nativeRegExp.exec(str);
        }
        nativeRegExp.setLastIndex(0);
        ArrayList matches = new ArrayList();
        while ((result = nativeRegExp.exec(str)) != null) {
            String matchStr = JSType.toString(result.get(0));
            if (matchStr.isEmpty()) {
                nativeRegExp.setLastIndex(nativeRegExp.getLastIndex() + 1);
            }
            matches.add((Object)matchStr);
        }
        if (matches.isEmpty()) {
            return null;
        }
        return new NativeArray(matches.toArray());
    }

    public static String replace(Object self, Object string, Object replacement) throws Throwable {
        String str = NativeString.checkObjectToString(self);
        NativeRegExp nativeRegExp = string instanceof NativeRegExp ? (NativeRegExp)string : NativeRegExp.flatRegExp(JSType.toString(string));
        if (Bootstrap.isCallable(replacement)) {
            return nativeRegExp.replace(str, "", replacement);
        }
        return nativeRegExp.replace(str, JSType.toString(replacement), null);
    }

    public static int search(Object self, Object string) {
        String str = NativeString.checkObjectToString(self);
        NativeRegExp nativeRegExp = Global.toRegExp(string == ScriptRuntime.UNDEFINED ? "" : string);
        return nativeRegExp.search(str);
    }

    public static String slice(Object self, Object start, Object end) {
        String str = NativeString.checkObjectToString(self);
        if (end == ScriptRuntime.UNDEFINED) {
            return NativeString.slice((Object)str, JSType.toInteger(start));
        }
        return NativeString.slice((Object)str, JSType.toInteger(start), JSType.toInteger(end));
    }

    public static String slice(Object self, int start) {
        String str = NativeString.checkObjectToString(self);
        int from = start < 0 ? Math.max((int)(str.length() + start), (int)0) : Math.min((int)start, (int)str.length());
        return str.substring(from);
    }

    public static String slice(Object self, double start) {
        return NativeString.slice(self, (int)start);
    }

    public static String slice(Object self, int start, int end) {
        String str = NativeString.checkObjectToString(self);
        int len = str.length();
        int from = start < 0 ? Math.max((int)(len + start), (int)0) : Math.min((int)start, (int)len);
        int to = end < 0 ? Math.max((int)(len + end), (int)0) : Math.min((int)end, (int)len);
        return str.substring(Math.min((int)from, (int)to), to);
    }

    public static String slice(Object self, double start, double end) {
        return NativeString.slice(self, (int)start, (int)end);
    }

    public static ScriptObject split(Object self, Object separator, Object limit) {
        long lim;
        String str = NativeString.checkObjectToString(self);
        long l = lim = limit == ScriptRuntime.UNDEFINED ? 0xFFFFFFFFL : JSType.toUint32(limit);
        if (separator == ScriptRuntime.UNDEFINED) {
            return lim == 0L ? new NativeArray() : new NativeArray(new Object[]{str});
        }
        if (separator instanceof NativeRegExp) {
            return ((NativeRegExp)separator).split(str, lim);
        }
        return NativeString.splitString(str, JSType.toString(separator), lim);
    }

    private static ScriptObject splitString(String str, String separator, long limit) {
        int found;
        if (separator.isEmpty()) {
            int length = (int)Math.min((long)str.length(), (long)limit);
            Object[] array = new Object[length];
            for (int i = 0; i < length; ++i) {
                array[i] = String.valueOf((char)str.charAt(i));
            }
            return new NativeArray(array);
        }
        LinkedList elements = new LinkedList();
        int strLength = str.length();
        int sepLength = separator.length();
        int pos = 0;
        int n = 0;
        while (pos < strLength && (long)n < limit && (found = str.indexOf(separator, pos)) != -1) {
            elements.add((Object)str.substring(pos, found));
            ++n;
            pos = found + sepLength;
        }
        if (pos <= strLength && (long)n < limit) {
            elements.add((Object)str.substring(pos));
        }
        return new NativeArray(elements.toArray());
    }

    public static String substr(Object self, Object start, Object length) {
        String str = JSType.toString(self);
        int strLength = str.length();
        int intStart = JSType.toInteger(start);
        if (intStart < 0) {
            intStart = Math.max((int)(intStart + strLength), (int)0);
        }
        int intLen = Math.min((int)Math.max((int)(length == ScriptRuntime.UNDEFINED ? Integer.MAX_VALUE : JSType.toInteger(length)), (int)0), (int)(strLength - intStart));
        return intLen <= 0 ? "" : str.substring(intStart, intStart + intLen);
    }

    public static String substring(Object self, Object start, Object end) {
        String str = NativeString.checkObjectToString(self);
        if (end == ScriptRuntime.UNDEFINED) {
            return NativeString.substring((Object)str, JSType.toInteger(start));
        }
        return NativeString.substring((Object)str, JSType.toInteger(start), JSType.toInteger(end));
    }

    public static String substring(Object self, int start) {
        String str = NativeString.checkObjectToString(self);
        if (start < 0) {
            return str;
        }
        if (start >= str.length()) {
            return "";
        }
        return str.substring(start);
    }

    public static String substring(Object self, double start) {
        return NativeString.substring(self, (int)start);
    }

    public static String substring(Object self, int start, int end) {
        int validEnd;
        String str = NativeString.checkObjectToString(self);
        int len = str.length();
        int validStart = start < 0 ? 0 : Math.min((int)start, (int)len);
        int n = validEnd = end < 0 ? 0 : Math.min((int)end, (int)len);
        if (validStart < validEnd) {
            return str.substring(validStart, validEnd);
        }
        return str.substring(validEnd, validStart);
    }

    public static String substring(Object self, double start, double end) {
        return NativeString.substring(self, (int)start, (int)end);
    }

    public static String toLowerCase(Object self) {
        return NativeString.checkObjectToString(self).toLowerCase(Locale.ROOT);
    }

    public static String toLocaleLowerCase(Object self) {
        return NativeString.checkObjectToString(self).toLowerCase(Global.getEnv()._locale);
    }

    public static String toUpperCase(Object self) {
        return NativeString.checkObjectToString(self).toUpperCase(Locale.ROOT);
    }

    public static String toLocaleUpperCase(Object self) {
        return NativeString.checkObjectToString(self).toUpperCase(Global.getEnv()._locale);
    }

    public static String trim(Object self) {
        int start;
        String str = NativeString.checkObjectToString(self);
        int end = str.length() - 1;
        for (start = 0; start <= end && ScriptRuntime.isJSWhitespace(str.charAt(start)); ++start) {
        }
        while (end > start && ScriptRuntime.isJSWhitespace(str.charAt(end))) {
            --end;
        }
        return str.substring(start, end + 1);
    }

    public static String trimLeft(Object self) {
        int start;
        String str = NativeString.checkObjectToString(self);
        int end = str.length() - 1;
        for (start = 0; start <= end && ScriptRuntime.isJSWhitespace(str.charAt(start)); ++start) {
        }
        return str.substring(start, end + 1);
    }

    public static String trimRight(Object self) {
        int end;
        String str = NativeString.checkObjectToString(self);
        boolean start = false;
        for (end = str.length() - 1; end >= 0 && ScriptRuntime.isJSWhitespace(str.charAt(end)); --end) {
        }
        return str.substring(0, end + 1);
    }

    private static ScriptObject newObj(CharSequence str) {
        return new NativeString(str);
    }

    public static Object constructor(boolean newObj, Object self, Object ... args) {
        String str = args.length > 0 ? JSType.toCharSequence(args[0]) : "";
        return newObj ? NativeString.newObj(str) : str.toString();
    }

    public static Object constructor(boolean newObj, Object self) {
        return newObj ? NativeString.newObj("") : "";
    }

    public static Object constructor(boolean newObj, Object self, Object arg) {
        CharSequence str = JSType.toCharSequence(arg);
        return newObj ? NativeString.newObj(str) : str.toString();
    }

    public static Object constructor(boolean newObj, Object self, int arg) {
        String str = Integer.toString((int)arg);
        return newObj ? NativeString.newObj(str) : str;
    }

    public static Object constructor(boolean newObj, Object self, double arg) {
        String str = JSType.toString(arg);
        return newObj ? NativeString.newObj(str) : str;
    }

    public static Object constructor(boolean newObj, Object self, boolean arg) {
        String str = Boolean.toString((boolean)arg);
        return newObj ? NativeString.newObj(str) : str;
    }

    public static Object getIterator(Object self) {
        return new StringIterator(NativeString.checkObjectToString(self), Global.instance());
    }

    public static GuardedInvocation lookupPrimitive(LinkRequest request, Object receiver) {
        return PrimitiveLookup.lookupPrimitive(request, NashornGuards.getStringGuard(), (ScriptObject)new NativeString((CharSequence)receiver), WRAPFILTER, PROTOFILTER);
    }

    private static NativeString wrapFilter(Object receiver) {
        return new NativeString((CharSequence)receiver);
    }

    private static Object protoFilter(Object object) {
        return Global.instance().getStringPrototype();
    }

    private static CharSequence getCharSequence(Object self) {
        if (JSType.isString(self)) {
            return (CharSequence)self;
        }
        if (self instanceof NativeString) {
            return ((NativeString)self).getValue();
        }
        if (self != null && self == Global.instance().getStringPrototype()) {
            return "";
        }
        throw ECMAErrors.typeError("not.a.string", ScriptRuntime.safeToString(self));
    }

    private static String getString(Object self) {
        if (self instanceof String) {
            return (String)self;
        }
        if (self instanceof ConsString) {
            return self.toString();
        }
        if (self instanceof NativeString) {
            return ((NativeString)self).getStringValue();
        }
        if (self != null && self == Global.instance().getStringPrototype()) {
            return "";
        }
        throw ECMAErrors.typeError("not.a.string", ScriptRuntime.safeToString(self));
    }

    private static String checkObjectToString(Object self) {
        if (self instanceof String) {
            return (String)self;
        }
        if (self instanceof ConsString) {
            return self.toString();
        }
        Global.checkObjectCoercible(self);
        return JSType.toString(self);
    }

    private boolean isValidStringIndex(int key) {
        return key >= 0 && key < this.value.length();
    }

    private static MethodHandle findOwnMH(String name, MethodType type) {
        return Lookup.MH.findStatic(MethodHandles.lookup(), NativeString.class, name, type);
    }

    @Override
    public SpecializedFunction.LinkLogic getLinkLogic(Class<? extends SpecializedFunction.LinkLogic> clazz) {
        if (clazz == CharCodeAtLinkLogic.class) {
            return CharCodeAtLinkLogic.INSTANCE;
        }
        return null;
    }

    @Override
    public boolean hasPerInstanceAssumptions() {
        return false;
    }

    static {
        NativeString.$clinit$();
    }

    public static void $clinit$() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((Object)AccessorProperty.create("length", 7, cfr_ldc_0(), null));
        $nasgenmap$ = PropertyMap.newMap((Collection<Property>)arrayList);
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_0() {
        try {
            return MethodHandles.lookup().findStatic(NativeString.class, "length", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    private static final class CharCodeAtLinkLogic
    extends SpecializedFunction.LinkLogic {
        private static final CharCodeAtLinkLogic INSTANCE = new CharCodeAtLinkLogic();

        private CharCodeAtLinkLogic() {
        }

        @Override
        public boolean canLink(Object self, CallSiteDescriptor desc, LinkRequest request) {
            try {
                CharSequence cs = (CharSequence)self;
                int intIndex = JSType.toInteger(request.getArguments()[2]);
                return intIndex >= 0 && intIndex < cs.length();
            }
            catch (ClassCastException | IndexOutOfBoundsException throwable) {
                return false;
            }
        }

        @Override
        public Class<? extends Throwable> getRelinkException() {
            return ClassCastException.class;
        }
    }
}

