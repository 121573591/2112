/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.TypeProto;

public enum Syntax implements ProtocolMessageEnum
{
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    SYNTAX_EDITIONS(2),
    UNRECOGNIZED(-1);

    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final int SYNTAX_EDITIONS_VALUE = 2;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap;
    private static final Syntax[] VALUES;
    private final int value;

    @Override
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static Syntax valueOf(int value) {
        return Syntax.forNumber(value);
    }

    public static Syntax forNumber(int value) {
        switch (value) {
            case 0: {
                return SYNTAX_PROTO2;
            }
            case 1: {
                return SYNTAX_PROTO3;
            }
            case 2: {
                return SYNTAX_EDITIONS;
            }
        }
        return null;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    @Override
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this == UNRECOGNIZED) {
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
        return (Descriptors.EnumValueDescriptor)Syntax.getDescriptor().getValues().get(this.ordinal());
    }

    @Override
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return Syntax.getDescriptor();
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor)TypeProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Syntax valueOf(Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != Syntax.getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
    }

    private Syntax(int value) {
        this.value = value;
    }

    static {
        internalValueMap = new Internal.EnumLiteMap<Syntax>(){

            @Override
            public Syntax findValueByNumber(int number) {
                return Syntax.forNumber(number);
            }
        };
        VALUES = Syntax.values();
    }
}

