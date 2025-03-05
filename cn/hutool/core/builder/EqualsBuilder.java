/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InternalError
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.lang.reflect.AccessibleObject
 *  java.lang.reflect.Field
 *  java.lang.reflect.Modifier
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 */
package cn.hutool.core.builder;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.builder.IDKey;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ArrayUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class EqualsBuilder
implements Builder<Boolean> {
    private static final long serialVersionUID = 1L;
    private static final ThreadLocal<Set<Pair<IDKey, IDKey>>> REGISTRY = new ThreadLocal();
    private boolean isEquals = true;

    static Set<Pair<IDKey, IDKey>> getRegistry() {
        return (Set)REGISTRY.get();
    }

    static Pair<IDKey, IDKey> getRegisterPair(Object lhs, Object rhs) {
        IDKey left = new IDKey(lhs);
        IDKey right = new IDKey(rhs);
        return new Pair<IDKey, IDKey>(left, right);
    }

    static boolean isRegistered(Object lhs, Object rhs) {
        Set<Pair<IDKey, IDKey>> registry = EqualsBuilder.getRegistry();
        Pair<IDKey, IDKey> pair = EqualsBuilder.getRegisterPair(lhs, rhs);
        Pair<IDKey, IDKey> swappedPair = new Pair<IDKey, IDKey>(pair.getKey(), pair.getValue());
        return registry != null && (registry.contains(pair) || registry.contains(swappedPair));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void register(Object lhs, Object rhs) {
        Class<EqualsBuilder> clazz = EqualsBuilder.class;
        synchronized (EqualsBuilder.class) {
            if (EqualsBuilder.getRegistry() == null) {
                REGISTRY.set((Object)new HashSet());
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            Set<Pair<IDKey, IDKey>> registry = EqualsBuilder.getRegistry();
            Pair<IDKey, IDKey> pair = EqualsBuilder.getRegisterPair(lhs, rhs);
            registry.add(pair);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void unregister(Object lhs, Object rhs) {
        Set<Pair<IDKey, IDKey>> registry = EqualsBuilder.getRegistry();
        if (registry == null) return;
        Pair<IDKey, IDKey> pair = EqualsBuilder.getRegisterPair(lhs, rhs);
        registry.remove(pair);
        Class<EqualsBuilder> clazz = EqualsBuilder.class;
        synchronized (EqualsBuilder.class) {
            registry = EqualsBuilder.getRegistry();
            if (registry == null || !registry.isEmpty()) return;
            REGISTRY.remove();
            // ** MonitorExit[var4_4] (shouldn't be in output)
            return;
        }
    }

    public static boolean reflectionEquals(Object lhs, Object rhs, Collection<String> excludeFields) {
        return EqualsBuilder.reflectionEquals(lhs, rhs, ArrayUtil.toArray(excludeFields, String.class));
    }

    public static boolean reflectionEquals(Object lhs, Object rhs, String ... excludeFields) {
        return EqualsBuilder.reflectionEquals(lhs, rhs, false, null, excludeFields);
    }

    public static boolean reflectionEquals(Object lhs, Object rhs, boolean testTransients) {
        return EqualsBuilder.reflectionEquals(lhs, rhs, testTransients, null, new String[0]);
    }

    public static boolean reflectionEquals(Object lhs, Object rhs, boolean testTransients, Class<?> reflectUpToClass, String ... excludeFields) {
        Class testClass;
        if (lhs == rhs) {
            return true;
        }
        if (lhs == null || rhs == null) {
            return false;
        }
        Class lhsClass = lhs.getClass();
        Class rhsClass = rhs.getClass();
        if (lhsClass.isInstance(rhs)) {
            testClass = lhsClass;
            if (!rhsClass.isInstance(lhs)) {
                testClass = rhsClass;
            }
        } else if (rhsClass.isInstance(lhs)) {
            testClass = rhsClass;
            if (!lhsClass.isInstance(rhs)) {
                testClass = lhsClass;
            }
        } else {
            return false;
        }
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        try {
            if (testClass.isArray()) {
                equalsBuilder.append(lhs, rhs);
            } else {
                EqualsBuilder.reflectionAppend(lhs, rhs, testClass, equalsBuilder, testTransients, excludeFields);
                while (testClass.getSuperclass() != null && testClass != reflectUpToClass) {
                    testClass = testClass.getSuperclass();
                    EqualsBuilder.reflectionAppend(lhs, rhs, testClass, equalsBuilder, testTransients, excludeFields);
                }
            }
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        return equalsBuilder.isEquals();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void reflectionAppend(Object lhs, Object rhs, Class<?> clazz, EqualsBuilder builder, boolean useTransients, String[] excludeFields) {
        if (EqualsBuilder.isRegistered(lhs, rhs)) {
            return;
        }
        try {
            EqualsBuilder.register(lhs, rhs);
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible((AccessibleObject[])fields, (boolean)true);
            for (int i = 0; i < fields.length && builder.isEquals; ++i) {
                Field f = fields[i];
                if (ArrayUtil.contains(excludeFields, f.getName()) || f.getName().indexOf(36) != -1 || !useTransients && Modifier.isTransient((int)f.getModifiers()) || Modifier.isStatic((int)f.getModifiers())) continue;
                try {
                    builder.append(f.get(lhs), f.get(rhs));
                    continue;
                }
                catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
        finally {
            EqualsBuilder.unregister(lhs, rhs);
        }
    }

    public EqualsBuilder appendSuper(boolean superEquals) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = superEquals;
        return this;
    }

    public EqualsBuilder append(Object lhs, Object rhs) {
        if (!this.isEquals) {
            return this;
        }
        if (lhs == rhs) {
            return this;
        }
        if (lhs == null || rhs == null) {
            return this.setEquals(false);
        }
        if (ArrayUtil.isArray(lhs)) {
            return this.setEquals(ArrayUtil.equals(lhs, rhs));
        }
        return this.setEquals(lhs.equals(rhs));
    }

    public EqualsBuilder append(long lhs, long rhs) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = lhs == rhs;
        return this;
    }

    public EqualsBuilder append(int lhs, int rhs) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = lhs == rhs;
        return this;
    }

    public EqualsBuilder append(short lhs, short rhs) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = lhs == rhs;
        return this;
    }

    public EqualsBuilder append(char lhs, char rhs) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = lhs == rhs;
        return this;
    }

    public EqualsBuilder append(byte lhs, byte rhs) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = lhs == rhs;
        return this;
    }

    public EqualsBuilder append(double lhs, double rhs) {
        if (!this.isEquals) {
            return this;
        }
        return this.append(Double.doubleToLongBits((double)lhs), Double.doubleToLongBits((double)rhs));
    }

    public EqualsBuilder append(float lhs, float rhs) {
        if (!this.isEquals) {
            return this;
        }
        return this.append(Float.floatToIntBits((float)lhs), Float.floatToIntBits((float)rhs));
    }

    public EqualsBuilder append(boolean lhs, boolean rhs) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = lhs == rhs;
        return this;
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    @Override
    public Boolean build() {
        return this.isEquals();
    }

    protected EqualsBuilder setEquals(boolean isEquals) {
        this.isEquals = isEquals;
        return this;
    }

    public void reset() {
        this.isEquals = true;
    }
}

