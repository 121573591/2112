/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectStreamClass
 *  java.io.StreamCorruptedException
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Proxy
 */
package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.lang.reflect.Proxy;

public class ClassLoaderObjectInputStream
extends ObjectInputStream {
    private final ClassLoader classLoader;

    public ClassLoaderObjectInputStream(ClassLoader classLoader, InputStream inputStream2) throws IOException, StreamCorruptedException {
        super(inputStream2);
        this.classLoader = classLoader;
    }

    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            return Class.forName((String)objectStreamClass.getName(), (boolean)false, (ClassLoader)this.classLoader);
        }
        catch (ClassNotFoundException cnfe) {
            return super.resolveClass(objectStreamClass);
        }
    }

    protected Class<?> resolveProxyClass(String[] interfaces) throws IOException, ClassNotFoundException {
        Class[] interfaceClasses = new Class[interfaces.length];
        for (int i = 0; i < interfaces.length; ++i) {
            interfaceClasses[i] = Class.forName((String)interfaces[i], (boolean)false, (ClassLoader)this.classLoader);
        }
        try {
            return Proxy.getProxyClass((ClassLoader)this.classLoader, (Class[])interfaceClasses);
        }
        catch (IllegalArgumentException e) {
            return super.resolveProxyClass(interfaces);
        }
    }
}

