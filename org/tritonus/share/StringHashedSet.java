/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 */
package org.tritonus.share;

import java.util.Collection;
import java.util.Iterator;
import org.tritonus.share.ArraySet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class StringHashedSet<E>
extends ArraySet<E> {
    private static final long serialVersionUID = 1L;

    public StringHashedSet() {
    }

    public StringHashedSet(Collection<E> c) {
        super(c);
    }

    @Override
    public boolean add(E elem) {
        if (elem == null) {
            return false;
        }
        return super.add(elem);
    }

    public boolean contains(Object elem) {
        if (elem == null) {
            return false;
        }
        String comp = elem.toString();
        Iterator it = this.iterator();
        while (it.hasNext()) {
            if (!comp.equals((Object)it.next().toString())) continue;
            return true;
        }
        return false;
    }

    public E get(Object elem) {
        if (elem == null) {
            return null;
        }
        String comp = elem.toString();
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Object thisElem = it.next();
            if (!comp.equals((Object)thisElem.toString())) continue;
            return (E)thisElem;
        }
        return null;
    }
}

