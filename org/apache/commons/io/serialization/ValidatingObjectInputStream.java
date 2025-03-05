/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InvalidClassException
 *  java.io.ObjectInputStream
 *  java.io.ObjectStreamClass
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.regex.Pattern
 */
package org.apache.commons.io.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.io.serialization.ClassNameMatcher;
import org.apache.commons.io.serialization.FullClassNameMatcher;
import org.apache.commons.io.serialization.RegexpClassNameMatcher;
import org.apache.commons.io.serialization.WildcardClassNameMatcher;

public class ValidatingObjectInputStream
extends ObjectInputStream {
    private final List<ClassNameMatcher> acceptMatchers = new ArrayList();
    private final List<ClassNameMatcher> rejectMatchers = new ArrayList();

    public ValidatingObjectInputStream(InputStream input) throws IOException {
        super(input);
    }

    private void validateClassName(String name) throws InvalidClassException {
        for (ClassNameMatcher m : this.rejectMatchers) {
            if (!m.matches(name)) continue;
            this.invalidClassNameFound(name);
        }
        boolean ok = false;
        for (ClassNameMatcher m : this.acceptMatchers) {
            if (!m.matches(name)) continue;
            ok = true;
            break;
        }
        if (!ok) {
            this.invalidClassNameFound(name);
        }
    }

    protected void invalidClassNameFound(String className) throws InvalidClassException {
        throw new InvalidClassException("Class name not accepted: " + className);
    }

    protected Class<?> resolveClass(ObjectStreamClass osc) throws IOException, ClassNotFoundException {
        this.validateClassName(osc.getName());
        return super.resolveClass(osc);
    }

    public ValidatingObjectInputStream accept(Class<?> ... classes) {
        for (Class<?> c : classes) {
            this.acceptMatchers.add((Object)new FullClassNameMatcher(c.getName()));
        }
        return this;
    }

    public ValidatingObjectInputStream reject(Class<?> ... classes) {
        for (Class<?> c : classes) {
            this.rejectMatchers.add((Object)new FullClassNameMatcher(c.getName()));
        }
        return this;
    }

    public ValidatingObjectInputStream accept(String ... patterns) {
        for (String pattern : patterns) {
            this.acceptMatchers.add((Object)new WildcardClassNameMatcher(pattern));
        }
        return this;
    }

    public ValidatingObjectInputStream reject(String ... patterns) {
        for (String pattern : patterns) {
            this.rejectMatchers.add((Object)new WildcardClassNameMatcher(pattern));
        }
        return this;
    }

    public ValidatingObjectInputStream accept(Pattern pattern) {
        this.acceptMatchers.add((Object)new RegexpClassNameMatcher(pattern));
        return this;
    }

    public ValidatingObjectInputStream reject(Pattern pattern) {
        this.rejectMatchers.add((Object)new RegexpClassNameMatcher(pattern));
        return this;
    }

    public ValidatingObjectInputStream accept(ClassNameMatcher m) {
        this.acceptMatchers.add((Object)m);
        return this;
    }

    public ValidatingObjectInputStream reject(ClassNameMatcher m) {
        this.rejectMatchers.add((Object)m);
        return this;
    }
}

