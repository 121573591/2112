/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.file.Files
 *  java.nio.file.OpenOption
 *  java.nio.file.Path
 *  java.util.Properties
 */
package org.apache.commons.text.lookup;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.lookup.AbstractPathFencedLookup;
import org.apache.commons.text.lookup.AbstractStringLookup;
import org.apache.commons.text.lookup.IllegalArgumentExceptions;

final class PropertiesStringLookup
extends AbstractPathFencedLookup {
    static final PropertiesStringLookup INSTANCE = new PropertiesStringLookup(null);
    static final String SEPARATOR = "::";

    static String toPropertyKey(String file, String key) {
        return AbstractStringLookup.toLookupKey(file, SEPARATOR, key);
    }

    PropertiesStringLookup(Path ... fences) {
        super(fences);
    }

    @Override
    public String lookup(String key) {
        if (key == null) {
            return null;
        }
        String[] keys = key.split(SEPARATOR);
        int keyLen = keys.length;
        if (keyLen < 2) {
            throw IllegalArgumentExceptions.format("Bad properties key format [%s]; expected format is %s.", key, PropertiesStringLookup.toPropertyKey("DocumentPath", "Key"));
        }
        String documentPath = keys[0];
        String propertyKey = StringUtils.substringAfter(key, SEPARATOR);
        try {
            Properties properties = new Properties();
            try (InputStream inputStream2 = Files.newInputStream((Path)this.getPath(documentPath), (OpenOption[])new OpenOption[0]);){
                properties.load(inputStream2);
            }
            return properties.getProperty(propertyKey);
        }
        catch (Exception e) {
            throw IllegalArgumentExceptions.format(e, "Error looking up properties [%s] and key [%s].", documentPath, propertyKey);
        }
    }
}

