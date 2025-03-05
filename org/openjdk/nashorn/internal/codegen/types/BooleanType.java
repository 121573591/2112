/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  org.objectweb.asm.MethodVisitor
 */
package org.openjdk.nashorn.internal.codegen.types;

import org.objectweb.asm.MethodVisitor;
import org.openjdk.nashorn.internal.codegen.CompilerConstants;
import org.openjdk.nashorn.internal.codegen.types.Type;

public final class BooleanType
extends Type {
    private static final long serialVersionUID = 1L;
    private static final CompilerConstants.Call VALUE_OF = CompilerConstants.staticCallNoLookup(Boolean.class, "valueOf", Boolean.class, Boolean.TYPE);
    private static final CompilerConstants.Call TO_STRING = CompilerConstants.staticCallNoLookup(Boolean.class, "toString", String.class, Boolean.TYPE);

    protected BooleanType() {
        super("boolean", Boolean.TYPE, 1, 1);
    }

    @Override
    public Type nextWider() {
        return INT;
    }

    @Override
    public Class<?> getBoxedType() {
        return Boolean.class;
    }

    @Override
    public char getBytecodeStackType() {
        return 'I';
    }

    @Override
    public Type loadUndefined(MethodVisitor method) {
        method.visitLdcInsn((Object)0);
        return BOOLEAN;
    }

    @Override
    public Type loadForcedInitializer(MethodVisitor method) {
        method.visitInsn(3);
        return BOOLEAN;
    }

    @Override
    public void _return(MethodVisitor method) {
        method.visitInsn(172);
    }

    @Override
    public Type load(MethodVisitor method, int slot) {
        assert (slot != -1);
        method.visitVarInsn(21, slot);
        return BOOLEAN;
    }

    @Override
    public void store(MethodVisitor method, int slot) {
        assert (slot != -1);
        method.visitVarInsn(54, slot);
    }

    @Override
    public Type ldc(MethodVisitor method, Object c) {
        assert (c instanceof Boolean);
        method.visitInsn((Boolean)c != false ? 4 : 3);
        return BOOLEAN;
    }

    @Override
    public Type convert(MethodVisitor method, Type to) {
        if (this.isEquivalentTo(to)) {
            return to;
        }
        if (to.isNumber()) {
            method.visitInsn(135);
        } else if (to.isLong()) {
            method.visitInsn(133);
        } else if (!to.isInteger()) {
            if (to.isString()) {
                BooleanType.invokestatic(method, TO_STRING);
            } else if (to.isObject()) {
                BooleanType.invokestatic(method, VALUE_OF);
            } else {
                throw new UnsupportedOperationException("Illegal conversion " + this + " -> " + to);
            }
        }
        return to;
    }

    @Override
    public Type add(MethodVisitor method, int programPoint) {
        return Type.INT.add(method, programPoint);
    }
}

