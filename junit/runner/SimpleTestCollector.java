/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package junit.runner;

import junit.runner.ClassPathTestCollector;

public class SimpleTestCollector
extends ClassPathTestCollector {
    protected boolean isTestClass(String classFileName) {
        return classFileName.endsWith(".class") && classFileName.indexOf(36) < 0 && classFileName.indexOf("Test") > 0;
    }
}

