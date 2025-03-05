/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.commons.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class OrJacksonUtil
extends ObjectMapper {
    private static final OrJacksonUtil INSTANCE = new OrJacksonUtil(){
        {
            this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        }
    };

    public static OrJacksonUtil getInstance() {
        return INSTANCE;
    }

    public static String getTextOrDefault(JsonNode jsonNode, String property, String defaultValue) {
        if (jsonNode.has(property)) {
            return jsonNode.get(property).asText(defaultValue);
        }
        return defaultValue;
    }
}

