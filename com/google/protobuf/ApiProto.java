/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.TypeProto;

public final class ApiProto {
    static final Descriptors.Descriptor internal_static_google_protobuf_Api_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Api_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_protobuf_Method_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Method_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_google_protobuf_Mixin_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Mixin_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private ApiProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        ApiProto.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\ngoogle/protobuf/api.protogoogle.protobuf$google/protobuf/source_context.protogoogle/protobuf/type.proto\"Á\nApi\nname (\tRname1\nmethods (2.google.protobuf.MethodRmethods1\noptions (2.google.protobuf.OptionRoptions\nversion (\tRversionE\nsource_context (2.google.protobuf.SourceContextR\rsourceContext.\nmixins (2.google.protobuf.MixinRmixins/\nsyntax (2.google.protobuf.SyntaxRsyntax\"²\nMethod\nname (\tRname(\nrequest_type_url (\tRrequestTypeUrl+\nrequest_streaming (\bRrequestStreaming*\nresponse_type_url (\tRresponseTypeUrl-\nresponse_streaming (\bRresponseStreaming1\noptions (2.google.protobuf.OptionRoptions/\nsyntax (2.google.protobuf.SyntaxRsyntax\"/\nMixin\nname (\tRname\nroot (\tRrootBv\ncom.google.protobufB\bApiProtoPZ,google.golang.org/protobuf/types/known/apipb¢GPBªGoogle.Protobuf.WellKnownTypesbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{SourceContextProto.getDescriptor(), TypeProto.getDescriptor()});
        internal_static_google_protobuf_Api_descriptor = (Descriptors.Descriptor)ApiProto.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Api_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Api_descriptor, new String[]{"Name", "Methods", "Options", "Version", "SourceContext", "Mixins", "Syntax"});
        internal_static_google_protobuf_Method_descriptor = (Descriptors.Descriptor)ApiProto.getDescriptor().getMessageTypes().get(1);
        internal_static_google_protobuf_Method_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Method_descriptor, new String[]{"Name", "RequestTypeUrl", "RequestStreaming", "ResponseTypeUrl", "ResponseStreaming", "Options", "Syntax"});
        internal_static_google_protobuf_Mixin_descriptor = (Descriptors.Descriptor)ApiProto.getDescriptor().getMessageTypes().get(2);
        internal_static_google_protobuf_Mixin_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Mixin_descriptor, new String[]{"Name", "Root"});
        SourceContextProto.getDescriptor();
        TypeProto.getDescriptor();
    }
}

