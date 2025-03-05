/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.ObjectStreamClass
 *  java.io.OutputStream
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Void
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 */
package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationException;

public class SerializationUtils {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T extends Serializable> T clone(T object) {
        if (object == null) {
            return null;
        }
        byte[] objectData = SerializationUtils.serialize(object);
        ByteArrayInputStream bais = new ByteArrayInputStream(objectData);
        Class<T> cls = ObjectUtils.getClass(object);
        try (ClassLoaderAwareObjectInputStream in = new ClassLoaderAwareObjectInputStream((InputStream)bais, cls.getClassLoader());){
            Serializable serializable = (Serializable)cls.cast(in.readObject());
            return (T)serializable;
        }
        catch (IOException | ClassNotFoundException ex) {
            throw new SerializationException(String.format((String)"%s while reading cloned object data", (Object[])new Object[]{ex.getClass().getSimpleName()}), ex);
        }
    }

    public static <T> T deserialize(byte[] objectData) {
        Objects.requireNonNull((Object)objectData, (String)"objectData");
        return SerializationUtils.deserialize((InputStream)new ByteArrayInputStream(objectData));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T> T deserialize(InputStream inputStream2) {
        Objects.requireNonNull((Object)inputStream2, (String)"inputStream");
        try (ObjectInputStream in = new ObjectInputStream(inputStream2);){
            Object obj;
            Object object = obj = in.readObject();
            return (T)object;
        }
        catch (IOException | ClassNotFoundException ex) {
            throw new SerializationException(ex);
        }
    }

    public static <T extends Serializable> T roundtrip(T obj) {
        return (T)((Serializable)SerializationUtils.deserialize(SerializationUtils.serialize(obj)));
    }

    public static byte[] serialize(Serializable obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(512);
        SerializationUtils.serialize(obj, (OutputStream)baos);
        return baos.toByteArray();
    }

    public static void serialize(Serializable obj, OutputStream outputStream2) {
        Objects.requireNonNull((Object)outputStream2, (String)"outputStream");
        try (ObjectOutputStream out = new ObjectOutputStream(outputStream2);){
            out.writeObject((Object)obj);
        }
        catch (IOException ex) {
            throw new SerializationException(ex);
        }
    }

    static class ClassLoaderAwareObjectInputStream
    extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes = new HashMap();
        private final ClassLoader classLoader;

        ClassLoaderAwareObjectInputStream(InputStream in, ClassLoader classLoader) throws IOException {
            super(in);
            this.classLoader = classLoader;
        }

        protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
            String name = desc.getName();
            try {
                return Class.forName((String)name, (boolean)false, (ClassLoader)this.classLoader);
            }
            catch (ClassNotFoundException ex) {
                try {
                    return Class.forName((String)name, (boolean)false, (ClassLoader)Thread.currentThread().getContextClassLoader());
                }
                catch (ClassNotFoundException cnfe) {
                    Class cls = (Class)primitiveTypes.get((Object)name);
                    if (cls != null) {
                        return cls;
                    }
                    throw cnfe;
                }
            }
        }

        static {
            primitiveTypes.put((Object)"byte", (Object)Byte.TYPE);
            primitiveTypes.put((Object)"short", (Object)Short.TYPE);
            primitiveTypes.put((Object)"int", (Object)Integer.TYPE);
            primitiveTypes.put((Object)"long", (Object)Long.TYPE);
            primitiveTypes.put((Object)"float", (Object)Float.TYPE);
            primitiveTypes.put((Object)"double", (Object)Double.TYPE);
            primitiveTypes.put((Object)"boolean", (Object)Boolean.TYPE);
            primitiveTypes.put((Object)"char", (Object)Character.TYPE);
            primitiveTypes.put((Object)"void", (Object)Void.TYPE);
        }
    }
}

