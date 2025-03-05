/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.StringTokenizer
 */
package org.openjdk.nashorn.internal.runtime.options;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.openjdk.nashorn.internal.runtime.options.Option;

public class KeyValueOption
extends Option<String> {
    protected Map<String, String> map;

    KeyValueOption(String value) {
        super(value);
        this.initialize();
    }

    Map<String, String> getValues() {
        return Collections.unmodifiableMap(this.map);
    }

    public boolean hasValue(String key) {
        return this.map != null && this.map.get((Object)key) != null;
    }

    String getValue(String key) {
        if (this.map == null) {
            return null;
        }
        String val = (String)this.map.get((Object)key);
        return "".equals((Object)val) ? null : val;
    }

    private void initialize() {
        if (this.getValue() == null) {
            return;
        }
        this.map = new LinkedHashMap();
        StringTokenizer st = new StringTokenizer((String)this.getValue(), ",");
        while (st.hasMoreElements()) {
            String token = st.nextToken();
            String[] keyValue = token.split(":");
            if (keyValue.length == 1) {
                this.map.put((Object)keyValue[0], (Object)"");
                continue;
            }
            if (keyValue.length == 2) {
                this.map.put((Object)keyValue[0], (Object)keyValue[1]);
                continue;
            }
            throw new IllegalArgumentException(token);
        }
    }
}

