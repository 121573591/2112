/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.invoke.MethodHandle
 *  java.lang.invoke.MethodHandles
 *  java.lang.invoke.MethodHandles$Lookup
 *  java.lang.invoke.MethodType
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.function.Supplier
 *  jdk.dynalink.CallSiteDescriptor
 *  jdk.dynalink.NamedOperation
 *  jdk.dynalink.Operation
 *  jdk.dynalink.beans.BeansLinker
 *  jdk.dynalink.beans.StaticClass
 *  jdk.dynalink.linker.GuardedInvocation
 *  jdk.dynalink.linker.GuardingDynamicLinker
 *  jdk.dynalink.linker.GuardingTypeConverterFactory
 *  jdk.dynalink.linker.LinkRequest
 *  jdk.dynalink.linker.LinkerServices
 *  jdk.dynalink.linker.support.Lookup
 */
package org.openjdk.nashorn.internal.runtime.linker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import jdk.dynalink.CallSiteDescriptor;
import jdk.dynalink.NamedOperation;
import jdk.dynalink.Operation;
import jdk.dynalink.beans.BeansLinker;
import jdk.dynalink.beans.StaticClass;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.GuardingDynamicLinker;
import jdk.dynalink.linker.GuardingTypeConverterFactory;
import jdk.dynalink.linker.LinkRequest;
import jdk.dynalink.linker.LinkerServices;
import jdk.dynalink.linker.support.Lookup;
import org.openjdk.nashorn.internal.codegen.types.Type;
import org.openjdk.nashorn.internal.runtime.ECMAErrors;
import org.openjdk.nashorn.internal.runtime.ECMAException;
import org.openjdk.nashorn.internal.runtime.JSType;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;
import org.openjdk.nashorn.internal.runtime.UnwarrantedOptimismException;
import org.openjdk.nashorn.internal.runtime.linker.NashornCallSiteDescriptor;
import org.openjdk.nashorn.internal.runtime.linker.NashornLinker;

final class NashornBottomLinker
implements GuardingDynamicLinker,
GuardingTypeConverterFactory {
    private static final MethodHandle EMPTY_PROP_GETTER = org.openjdk.nashorn.internal.lookup.Lookup.MH.dropArguments(org.openjdk.nashorn.internal.lookup.Lookup.MH.constant(Object.class, ScriptRuntime.UNDEFINED), 0, Object.class);
    private static final MethodHandle EMPTY_ELEM_GETTER = org.openjdk.nashorn.internal.lookup.Lookup.MH.dropArguments(EMPTY_PROP_GETTER, 0, Object.class);
    private static final MethodHandle EMPTY_PROP_SETTER = org.openjdk.nashorn.internal.lookup.Lookup.MH.asType(EMPTY_ELEM_GETTER, EMPTY_ELEM_GETTER.type().changeReturnType(Void.TYPE));
    private static final MethodHandle EMPTY_ELEM_SETTER = org.openjdk.nashorn.internal.lookup.Lookup.MH.dropArguments(EMPTY_PROP_SETTER, 0, Object.class);
    private static final MethodHandle THROW_STRICT_PROPERTY_SETTER;
    private static final MethodHandle THROW_STRICT_PROPERTY_REMOVER;
    private static final MethodHandle THROW_OPTIMISTIC_UNDEFINED;
    private static final MethodHandle MISSING_PROPERTY_REMOVER;
    private static final MethodHandle IS_DYNAMIC_METHOD;
    private static final Map<Class<?>, MethodHandle> CONVERTERS;

    NashornBottomLinker() {
    }

    public GuardedInvocation getGuardedInvocation(LinkRequest linkRequest, LinkerServices linkerServices) {
        Object self = linkRequest.getReceiver();
        if (self == null) {
            return NashornBottomLinker.linkNull(linkRequest);
        }
        assert (NashornBottomLinker.isExpectedObject(self)) : "Couldn't link " + linkRequest.getCallSiteDescriptor() + " for " + self.getClass().getName();
        return NashornBottomLinker.linkBean(linkRequest, linkerServices);
    }

    private static GuardedInvocation linkBean(LinkRequest linkRequest, LinkerServices linkerServices) {
        CallSiteDescriptor desc = linkRequest.getCallSiteDescriptor();
        Object self = linkRequest.getReceiver();
        switch (NashornCallSiteDescriptor.getStandardOperation(desc)) {
            case NEW: {
                if (BeansLinker.isDynamicConstructor((Object)self)) {
                    throw ECMAErrors.typeError("no.constructor.matches.args", ScriptRuntime.safeToString(self));
                }
                if (BeansLinker.isDynamicMethod((Object)self)) {
                    throw ECMAErrors.typeError("method.not.constructor", ScriptRuntime.safeToString(self));
                }
                throw ECMAErrors.typeError("not.a.function", NashornCallSiteDescriptor.getFunctionErrorMessage(desc, self));
            }
            case CALL: {
                if (BeansLinker.isDynamicConstructor((Object)self)) {
                    throw ECMAErrors.typeError("constructor.requires.new", ScriptRuntime.safeToString(self));
                }
                if (BeansLinker.isDynamicMethod((Object)self)) {
                    throw ECMAErrors.typeError("no.method.matches.args", ScriptRuntime.safeToString(self));
                }
                throw ECMAErrors.typeError("not.a.function", NashornCallSiteDescriptor.getFunctionErrorMessage(desc, self));
            }
        }
        if (BeansLinker.isDynamicMethod((Object)self)) {
            return new GuardedInvocation(NashornBottomLinker.linkMissingBeanMember(linkRequest, linkerServices), IS_DYNAMIC_METHOD);
        }
        throw new AssertionError((Object)("unknown call type " + desc));
    }

    static MethodHandle linkMissingBeanMember(LinkRequest linkRequest, LinkerServices linkerServices) {
        CallSiteDescriptor desc = linkRequest.getCallSiteDescriptor();
        String operand = NashornCallSiteDescriptor.getOperand(desc);
        boolean strict = NashornCallSiteDescriptor.isStrict(desc);
        switch (NashornCallSiteDescriptor.getStandardOperation(desc)) {
            case GET: {
                if (NashornCallSiteDescriptor.isOptimistic(desc)) {
                    return NashornBottomLinker.adaptThrower(MethodHandles.insertArguments((MethodHandle)THROW_OPTIMISTIC_UNDEFINED, (int)0, (Object[])new Object[]{NashornCallSiteDescriptor.getProgramPoint(desc)}), desc);
                }
                if (operand != null) {
                    return NashornBottomLinker.getInvocation(EMPTY_PROP_GETTER, linkerServices, desc);
                }
                return NashornBottomLinker.getInvocation(EMPTY_ELEM_GETTER, linkerServices, desc);
            }
            case SET: {
                if (strict) {
                    return NashornBottomLinker.adaptThrower(NashornBottomLinker.bindOperand(THROW_STRICT_PROPERTY_SETTER, operand), desc);
                }
                if (operand != null) {
                    return NashornBottomLinker.getInvocation(EMPTY_PROP_SETTER, linkerServices, desc);
                }
                return NashornBottomLinker.getInvocation(EMPTY_ELEM_SETTER, linkerServices, desc);
            }
            case REMOVE: {
                if (strict) {
                    return NashornBottomLinker.adaptThrower(NashornBottomLinker.bindOperand(THROW_STRICT_PROPERTY_REMOVER, operand), desc);
                }
                return NashornBottomLinker.getInvocation(NashornBottomLinker.bindOperand(MISSING_PROPERTY_REMOVER, operand), linkerServices, desc);
            }
        }
        throw new AssertionError((Object)("unknown call type " + desc));
    }

    private static MethodHandle bindOperand(MethodHandle handle, String operand) {
        return operand == null ? handle : MethodHandles.insertArguments((MethodHandle)handle, (int)1, (Object[])new Object[]{operand});
    }

    private static MethodHandle adaptThrower(MethodHandle handle, CallSiteDescriptor desc) {
        MethodType targetType = desc.getMethodType();
        int paramCount = handle.type().parameterCount();
        return MethodHandles.dropArguments((MethodHandle)handle, (int)paramCount, (List)targetType.parameterList().subList(paramCount, targetType.parameterCount())).asType(targetType);
    }

    private static void throwStrictPropertySetter(Object self, Object name) {
        throw NashornBottomLinker.createTypeError(self, name, "cant.set.property");
    }

    private static boolean throwStrictPropertyRemover(Object self, Object name) {
        if (NashornBottomLinker.isNonConfigurableProperty(self, name)) {
            throw NashornBottomLinker.createTypeError(self, name, "cant.delete.property");
        }
        return true;
    }

    private static boolean missingPropertyRemover(Object self, Object name) {
        return !NashornBottomLinker.isNonConfigurableProperty(self, name);
    }

    private static boolean isNonConfigurableProperty(Object self, Object name) {
        if (self instanceof StaticClass) {
            Class clazz = ((StaticClass)self).getRepresentedClass();
            return BeansLinker.getReadableStaticPropertyNames((Class)clazz).contains(name) || BeansLinker.getWritableStaticPropertyNames((Class)clazz).contains(name) || BeansLinker.getStaticMethodNames((Class)clazz).contains(name);
        }
        Class clazz = self.getClass();
        return BeansLinker.getReadableInstancePropertyNames((Class)clazz).contains(name) || BeansLinker.getWritableInstancePropertyNames((Class)clazz).contains(name) || BeansLinker.getInstanceMethodNames((Class)clazz).contains(name);
    }

    private static ECMAException createTypeError(Object self, Object name, String msg) {
        return ECMAErrors.typeError(msg, String.valueOf((Object)name), ScriptRuntime.safeToString(self));
    }

    private static Object throwOptimisticUndefined(int programPoint) {
        throw new UnwarrantedOptimismException(ScriptRuntime.UNDEFINED, programPoint, Type.OBJECT);
    }

    public GuardedInvocation convertToType(Class<?> sourceType, Class<?> targetType, Supplier<MethodHandles.Lookup> lookupSupplier) {
        GuardedInvocation gi = NashornBottomLinker.convertToTypeNoCast(targetType);
        return gi == null ? null : gi.asType(org.openjdk.nashorn.internal.lookup.Lookup.MH.type(targetType, sourceType));
    }

    private static GuardedInvocation convertToTypeNoCast(Class<?> targetType) {
        MethodHandle mh = (MethodHandle)CONVERTERS.get(targetType);
        if (mh != null) {
            return new GuardedInvocation(mh);
        }
        return null;
    }

    private static MethodHandle getInvocation(MethodHandle handle, LinkerServices linkerServices, CallSiteDescriptor desc) {
        return linkerServices.asTypeLosslessReturn(handle, desc.getMethodType());
    }

    private static boolean isExpectedObject(Object obj) {
        return !NashornLinker.canLinkTypeStatic(obj.getClass());
    }

    private static GuardedInvocation linkNull(LinkRequest linkRequest) {
        CallSiteDescriptor desc = linkRequest.getCallSiteDescriptor();
        switch (NashornCallSiteDescriptor.getStandardOperation(desc)) {
            case NEW: 
            case CALL: {
                throw ECMAErrors.typeError("not.a.function", "null");
            }
            case GET: {
                throw ECMAErrors.typeError(NashornCallSiteDescriptor.isMethodFirstOperation(desc) ? "no.such.function" : "cant.get.property", NashornBottomLinker.getArgument(linkRequest), "null");
            }
            case SET: {
                throw ECMAErrors.typeError("cant.set.property", NashornBottomLinker.getArgument(linkRequest), "null");
            }
            case REMOVE: {
                throw ECMAErrors.typeError("cant.delete.property", NashornBottomLinker.getArgument(linkRequest), "null");
            }
        }
        throw new AssertionError((Object)("unknown call type " + desc));
    }

    private static String getArgument(LinkRequest linkRequest) {
        Operation op = linkRequest.getCallSiteDescriptor().getOperation();
        if (op instanceof NamedOperation) {
            return ((NamedOperation)op).getName().toString();
        }
        return ScriptRuntime.safeToString(linkRequest.getArguments()[1]);
    }

    static {
        Lookup lookup = new Lookup(MethodHandles.lookup());
        THROW_STRICT_PROPERTY_SETTER = lookup.findOwnStatic("throwStrictPropertySetter", Void.TYPE, new Class[]{Object.class, Object.class});
        THROW_STRICT_PROPERTY_REMOVER = lookup.findOwnStatic("throwStrictPropertyRemover", Boolean.TYPE, new Class[]{Object.class, Object.class});
        THROW_OPTIMISTIC_UNDEFINED = lookup.findOwnStatic("throwOptimisticUndefined", Object.class, new Class[]{Integer.TYPE});
        MISSING_PROPERTY_REMOVER = lookup.findOwnStatic("missingPropertyRemover", Boolean.TYPE, new Class[]{Object.class, Object.class});
        IS_DYNAMIC_METHOD = lookup.findStatic(BeansLinker.class, "isDynamicMethod", MethodType.methodType((Class)Boolean.TYPE, Object.class));
        CONVERTERS = new HashMap();
        CONVERTERS.put((Object)Boolean.TYPE, (Object)JSType.TO_BOOLEAN.methodHandle());
        CONVERTERS.put((Object)Double.TYPE, (Object)JSType.TO_NUMBER.methodHandle());
        CONVERTERS.put((Object)Integer.TYPE, (Object)JSType.TO_INTEGER.methodHandle());
        CONVERTERS.put((Object)Long.TYPE, (Object)JSType.TO_LONG.methodHandle());
        CONVERTERS.put(String.class, (Object)JSType.TO_STRING.methodHandle());
    }
}

