/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Double
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.invoke.MethodHandle
 *  java.lang.invoke.MethodHandles
 *  java.nio.ByteBuffer
 *  java.nio.FloatBuffer
 *  java.util.Collection
 *  java.util.Collections
 */
package org.openjdk.nashorn.internal.objects;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.Collections;
import org.openjdk.nashorn.internal.codegen.CompilerConstants;
import org.openjdk.nashorn.internal.objects.ArrayBufferView;
import org.openjdk.nashorn.internal.objects.ArrayIterator;
import org.openjdk.nashorn.internal.objects.Global;
import org.openjdk.nashorn.internal.objects.NativeArrayBuffer;
import org.openjdk.nashorn.internal.runtime.JSType;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyMap;
import org.openjdk.nashorn.internal.runtime.ScriptObject;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayData;
import org.openjdk.nashorn.internal.runtime.arrays.ContinuousArrayData;
import org.openjdk.nashorn.internal.runtime.arrays.TypedArrayData;

public final class NativeFloat32Array
extends ArrayBufferView {
    public static final int BYTES_PER_ELEMENT = 4;
    private static PropertyMap $nasgenmap$;
    private static final ArrayBufferView.Factory FACTORY;

    public static NativeFloat32Array constructor(boolean newObj, Object self, Object ... args) {
        return (NativeFloat32Array)NativeFloat32Array.constructorImpl(newObj, args, FACTORY);
    }

    NativeFloat32Array(NativeArrayBuffer buffer, int byteOffset, int length) {
        super(buffer, byteOffset, length);
    }

    @Override
    protected ArrayBufferView.Factory factory() {
        return FACTORY;
    }

    @Override
    protected boolean isFloatArray() {
        return true;
    }

    protected static Object set(Object self, Object array, Object offset) {
        return ArrayBufferView.setImpl(self, array, offset);
    }

    protected static NativeFloat32Array subarray(Object self, Object begin, Object end) {
        return (NativeFloat32Array)ArrayBufferView.subarrayImpl(self, begin, end);
    }

    public static Object getIterator(Object self) {
        return ArrayIterator.newArrayValueIterator(self);
    }

    @Override
    protected ScriptObject getPrototype(Global global) {
        return global.getFloat32ArrayPrototype();
    }

    static {
        FACTORY = new ArrayBufferView.Factory(4){

            @Override
            public ArrayBufferView construct(NativeArrayBuffer buffer, int byteOffset, int length) {
                return new NativeFloat32Array(buffer, byteOffset, length);
            }

            public Float32ArrayData createArrayData(ByteBuffer nb, int start, int end) {
                return new Float32ArrayData(nb.asFloatBuffer(), start, end);
            }

            @Override
            public String getClassName() {
                return "Float32Array";
            }
        };
        NativeFloat32Array.$clinit$();
    }

    public static void $clinit$() {
        $nasgenmap$ = PropertyMap.newMap((Collection<Property>)Collections.EMPTY_LIST);
    }

    private static final class Float32ArrayData
    extends TypedArrayData<FloatBuffer> {
        private static final MethodHandle GET_ELEM = CompilerConstants.specialCall(MethodHandles.lookup(), Float32ArrayData.class, "getElem", Double.TYPE, Integer.TYPE).methodHandle();
        private static final MethodHandle SET_ELEM = CompilerConstants.specialCall(MethodHandles.lookup(), Float32ArrayData.class, "setElem", Void.TYPE, Integer.TYPE, Double.TYPE).methodHandle();

        private Float32ArrayData(FloatBuffer nb, int start, int end) {
            super(nb.position(start).limit(end).slice(), end - start);
        }

        @Override
        public Class<?> getElementType() {
            return Double.TYPE;
        }

        @Override
        public Class<?> getBoxedElementType() {
            return Double.class;
        }

        @Override
        protected MethodHandle getGetElem() {
            return GET_ELEM;
        }

        @Override
        protected MethodHandle getSetElem() {
            return SET_ELEM;
        }

        private double getElem(int index) {
            try {
                return ((FloatBuffer)this.nb).get(index);
            }
            catch (IndexOutOfBoundsException e) {
                throw new ClassCastException();
            }
        }

        private void setElem(int index, double elem) {
            try {
                if (index < ((FloatBuffer)this.nb).limit()) {
                    ((FloatBuffer)this.nb).put(index, (float)elem);
                }
            }
            catch (IndexOutOfBoundsException e) {
                throw new ClassCastException();
            }
        }

        @Override
        public MethodHandle getElementGetter(Class<?> returnType, int programPoint) {
            if (returnType == Integer.TYPE) {
                return null;
            }
            return this.getContinuousElementGetter((Class<? extends ContinuousArrayData>)this.getClass(), GET_ELEM, returnType, programPoint);
        }

        @Override
        public int getInt(int index) {
            return (int)this.getDouble(index);
        }

        @Override
        public double getDouble(int index) {
            return this.getElem(index);
        }

        @Override
        public double getDoubleOptimistic(int index, int programPoint) {
            return this.getElem(index);
        }

        @Override
        public Object getObject(int index) {
            return this.getDouble(index);
        }

        @Override
        public ArrayData set(int index, Object value, boolean strict) {
            return this.set(index, JSType.toNumber(value), strict);
        }

        @Override
        public ArrayData set(int index, int value, boolean strict) {
            return this.set(index, (double)value, strict);
        }

        @Override
        public ArrayData set(int index, double value, boolean strict) {
            this.setElem(index, value);
            return this;
        }
    }
}

