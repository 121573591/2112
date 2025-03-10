/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public final class WebUserPauseTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor;

    private WebUserPauseTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        WebUserPauseTypeOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nWebUserPauseType.proto*?\nWebUserPauseType\nUNKNOWN_USER_PAUSE_TYPE \n\nBACKGROUNDB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
    }

    public static enum WebUserPauseType implements ProtocolMessageEnum
    {
        UNKNOWN_USER_PAUSE_TYPE(0),
        BACKGROUND(1),
        UNRECOGNIZED(-1);

        public static final int UNKNOWN_USER_PAUSE_TYPE_VALUE = 0;
        public static final int BACKGROUND_VALUE = 1;
        private static final Internal.EnumLiteMap<WebUserPauseType> internalValueMap;
        private static final WebUserPauseType[] VALUES;
        private final int value;

        @Override
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static WebUserPauseType valueOf(int value) {
            return WebUserPauseType.forNumber(value);
        }

        public static WebUserPauseType forNumber(int value) {
            switch (value) {
                case 0: {
                    return UNKNOWN_USER_PAUSE_TYPE;
                }
                case 1: {
                    return BACKGROUND;
                }
            }
            return null;
        }

        public static Internal.EnumLiteMap<WebUserPauseType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this == UNRECOGNIZED) {
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }
            return (Descriptors.EnumValueDescriptor)WebUserPauseType.getDescriptor().getValues().get(this.ordinal());
        }

        @Override
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return WebUserPauseType.getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor)WebUserPauseTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static WebUserPauseType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != WebUserPauseType.getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[desc.getIndex()];
        }

        private WebUserPauseType(int value) {
            this.value = value;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<WebUserPauseType>(){

                @Override
                public WebUserPauseType findValueByNumber(int number) {
                    return WebUserPauseType.forNumber(number);
                }
            };
            VALUES = WebUserPauseType.values();
        }
    }
}

