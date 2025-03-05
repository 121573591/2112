/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Package
 *  java.lang.String
 *  java.util.Objects
 */
package org.apache.commons.lang3;

import java.util.Objects;

public class ClassPathUtils {
    public static String packageToPath(String path) {
        return ((String)Objects.requireNonNull((Object)path, (String)"path")).replace('.', '/');
    }

    public static String pathToPackage(String path) {
        return ((String)Objects.requireNonNull((Object)path, (String)"path")).replace('/', '.');
    }

    public static String toFullyQualifiedName(Class<?> context, String resourceName) {
        Objects.requireNonNull(context, (String)"context");
        Objects.requireNonNull((Object)resourceName, (String)"resourceName");
        return ClassPathUtils.toFullyQualifiedName(context.getPackage(), resourceName);
    }

    public static String toFullyQualifiedName(Package context, String resourceName) {
        Objects.requireNonNull((Object)context, (String)"context");
        Objects.requireNonNull((Object)resourceName, (String)"resourceName");
        return context.getName() + "." + resourceName;
    }

    public static String toFullyQualifiedPath(Class<?> context, String resourceName) {
        Objects.requireNonNull(context, (String)"context");
        Objects.requireNonNull((Object)resourceName, (String)"resourceName");
        return ClassPathUtils.toFullyQualifiedPath(context.getPackage(), resourceName);
    }

    public static String toFullyQualifiedPath(Package context, String resourceName) {
        Objects.requireNonNull((Object)context, (String)"context");
        Objects.requireNonNull((Object)resourceName, (String)"resourceName");
        return ClassPathUtils.packageToPath(context.getName()) + "/" + resourceName;
    }
}

