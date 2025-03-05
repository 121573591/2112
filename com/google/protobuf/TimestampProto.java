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

public final class TimestampProto {
    static final Descriptors.Descriptor internal_static_google_protobuf_Timestamp_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Timestamp_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private TimestampProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        TimestampProto.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\ngoogle/protobuf/timestamp.protogoogle.protobuf\";\n\tTimestamp\nseconds (Rseconds\nnanos (RnanosB\ncom.google.protobufBTimestampProtoPZ2google.golang.org/protobuf/types/known/timestamppbø¢GPBªGoogle.Protobuf.WellKnownTypesbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
        internal_static_google_protobuf_Timestamp_descriptor = (Descriptors.Descriptor)TimestampProto.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Timestamp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_Timestamp_descriptor, new String[]{"Seconds", "Nanos"});
    }
}

