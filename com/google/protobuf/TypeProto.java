/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.protobuf;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.SourceContextProto;

public final class TypeProto {
    static final Descriptors.Descriptor internal_static_google_protobuf_Type_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Type_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_protobuf_Field_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Field_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_protobuf_Enum_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Enum_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_protobuf_EnumValue_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_EnumValue_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_protobuf_Option_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Option_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private TypeProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        TypeProto.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\ngoogle/protobuf/type.protogoogle.protobufgoogle/protobuf/any.proto$google/protobuf/source_context.proto\"§\nType\nname (\tRname.\nfields (2.google.protobuf.FieldRfields\noneofs (\tRoneofs1\noptions (2.google.protobuf.OptionRoptionsE\nsource_context (2.google.protobuf.SourceContextR\rsourceContext/\nsyntax (2.google.protobuf.SyntaxRsyntax\nedition (\tRedition\"´\nField/\nkind (2.google.protobuf.Field.KindRkindD\ncardinality (2\".google.protobuf.Field.CardinalityRcardinality\nnumber (Rnumber\nname (\tRname\n\btype_url (\tRtypeUrl\noneof_index (R\noneofIndex\npacked\b (\bRpacked1\noptions\t (2.google.protobuf.OptionRoptions\n\tjson_name\n (\tR\bjsonName#\n\rdefault_value (\tR\fdefaultValue\"È\nKind\n\fTYPE_UNKNOWN \nTYPE_DOUBLE\n\nTYPE_FLOAT\n\nTYPE_INT64\nTYPE_UINT64\n\nTYPE_INT32\n\fTYPE_FIXED64\n\fTYPE_FIXED32\r\n\tTYPE_BOOL\b\nTYPE_STRING\t\n\nTYPE_GROUP\n\n\fTYPE_MESSAGE\n\nTYPE_BYTES\f\nTYPE_UINT32\r\r\n\tTYPE_ENUM\n\rTYPE_SFIXED32\n\rTYPE_SFIXED64\nTYPE_SINT32\nTYPE_SINT64\"t\nCardinality\nCARDINALITY_UNKNOWN \nCARDINALITY_OPTIONAL\nCARDINALITY_REQUIRED\nCARDINALITY_REPEATED\"\nEnum\nname (\tRname8\n\tenumvalue (2.google.protobuf.EnumValueR\tenumvalue1\noptions (2.google.protobuf.OptionRoptionsE\nsource_context (2.google.protobuf.SourceContextR\rsourceContext/\nsyntax (2.google.protobuf.SyntaxRsyntax\nedition (\tRedition\"j\n\tEnumValue\nname (\tRname\nnumber (Rnumber1\noptions (2.google.protobuf.OptionRoptions\"H\nOption\nname (\tRname*\nvalue (2.google.protobuf.AnyRvalue*C\nSyntax\n\rSYNTAX_PROTO2 \n\rSYNTAX_PROTO3\nSYNTAX_EDITIONSB{\ncom.google.protobufB\tTypeProtoPZ-google.golang.org/protobuf/types/known/typepbø¢GPBªGoogle.Protobuf.WellKnownTypesbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor(), SourceContextProto.getDescriptor()});
        internal_static_google_protobuf_Type_descriptor = (Descriptors.Descriptor)TypeProto.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Type_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Type_descriptor, new String[]{"Name", "Fields", "Oneofs", "Options", "SourceContext", "Syntax", "Edition"});
        internal_static_google_protobuf_Field_descriptor = (Descriptors.Descriptor)TypeProto.getDescriptor().getMessageTypes().get(1);
        internal_static_google_protobuf_Field_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Field_descriptor, new String[]{"Kind", "Cardinality", "Number", "Name", "TypeUrl", "OneofIndex", "Packed", "Options", "JsonName", "DefaultValue"});
        internal_static_google_protobuf_Enum_descriptor = (Descriptors.Descriptor)TypeProto.getDescriptor().getMessageTypes().get(2);
        internal_static_google_protobuf_Enum_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Enum_descriptor, new String[]{"Name", "Enumvalue", "Options", "SourceContext", "Syntax", "Edition"});
        internal_static_google_protobuf_EnumValue_descriptor = (Descriptors.Descriptor)TypeProto.getDescriptor().getMessageTypes().get(3);
        internal_static_google_protobuf_EnumValue_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_EnumValue_descriptor, new String[]{"Name", "Number", "Options"});
        internal_static_google_protobuf_Option_descriptor = (Descriptors.Descriptor)TypeProto.getDescriptor().getMessageTypes().get(4);
        internal_static_google_protobuf_Option_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Option_descriptor, new String[]{"Name", "Value"});
        AnyProto.getDescriptor();
        SourceContextProto.getDescriptor();
    }
}

