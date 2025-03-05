/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.UnsupportedOperationException
 *  java.util.AbstractCollection
 *  java.util.Collection
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package com.fasterxml.jackson.databind.util.internal;

import com.fasterxml.jackson.databind.util.internal.Linked;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class LinkedDeque<E extends Linked<E>>
extends AbstractCollection<E>
implements Deque<E> {
    E first;
    E last;

    LinkedDeque() {
    }

    void linkFirst(E e) {
        E f = this.first;
        this.first = e;
        if (f == null) {
            this.last = e;
        } else {
            f.setPrevious(e);
            e.setNext(f);
        }
    }

    void linkLast(E e) {
        E l = this.last;
        this.last = e;
        if (l == null) {
            this.first = e;
        } else {
            l.setNext(e);
            e.setPrevious(l);
        }
    }

    E unlinkFirst() {
        E f = this.first;
        Object next = f.getNext();
        f.setNext(null);
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.setPrevious(null);
        }
        return f;
    }

    E unlinkLast() {
        E l = this.last;
        Object prev = l.getPrevious();
        l.setPrevious(null);
        this.last = prev;
        if (prev == null) {
            this.first = null;
        } else {
            prev.setNext(null);
        }
        return l;
    }

    void unlink(E e) {
        Object prev = e.getPrevious();
        Object next = e.getNext();
        if (prev == null) {
            this.first = next;
        } else {
            prev.setNext(next);
            e.setPrevious(null);
        }
        if (next == null) {
            this.last = prev;
        } else {
            next.setPrevious(prev);
            e.setNext(null);
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    void checkNotEmpty() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    public int size() {
        int size = 0;
        for (Object e = this.first; e != null; e = e.getNext()) {
            ++size;
        }
        return size;
    }

    public void clear() {
        Object e = this.first;
        while (e != null) {
            Object next = e.getNext();
            e.setPrevious(null);
            e.setNext(null);
            e = next;
        }
        this.last = null;
        this.first = null;
    }

    public boolean contains(Object o) {
        return o instanceof Linked && this.contains((Linked)o);
    }

    boolean contains(Linked<?> e) {
        return e.getPrevious() != null || e.getNext() != null || e == this.first;
    }

    public void moveToFront(E e) {
        if (e != this.first) {
            this.unlink(e);
            this.linkFirst(e);
        }
    }

    public void moveToBack(E e) {
        if (e != this.last) {
            this.unlink(e);
            this.linkLast(e);
        }
    }

    public E peek() {
        return (E)this.peekFirst();
    }

    public E peekFirst() {
        return this.first;
    }

    public E peekLast() {
        return this.last;
    }

    public E getFirst() {
        this.checkNotEmpty();
        return (E)this.peekFirst();
    }

    public E getLast() {
        this.checkNotEmpty();
        return (E)this.peekLast();
    }

    public E element() {
        return (E)this.getFirst();
    }

    public boolean offer(E e) {
        return this.offerLast(e);
    }

    public boolean offerFirst(E e) {
        if (this.contains((Linked<?>)e)) {
            return false;
        }
        this.linkFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        if (this.contains((Linked<?>)e)) {
            return false;
        }
        this.linkLast(e);
        return true;
    }

    public boolean add(E e) {
        return this.offerLast(e);
    }

    public void addFirst(E e) {
        if (!this.offerFirst(e)) {
            throw new IllegalArgumentException();
        }
    }

    public void addLast(E e) {
        if (!this.offerLast(e)) {
            throw new IllegalArgumentException();
        }
    }

    public E poll() {
        return (E)this.pollFirst();
    }

    public E pollFirst() {
        return this.isEmpty() ? null : (E)this.unlinkFirst();
    }

    public E pollLast() {
        return this.isEmpty() ? null : (E)this.unlinkLast();
    }

    public E remove() {
        return (E)this.removeFirst();
    }

    public boolean remove(Object o) {
        return o instanceof Linked && this.remove((E)((Linked)o));
    }

    boolean remove(E e) {
        if (this.contains((Linked<?>)e)) {
            this.unlink(e);
            return true;
        }
        return false;
    }

    public E removeFirst() {
        this.checkNotEmpty();
        return (E)this.pollFirst();
    }

    public boolean removeFirstOccurrence(Object o) {
        return this.remove(o);
    }

    public E removeLast() {
        this.checkNotEmpty();
        return (E)this.pollLast();
    }

    public boolean removeLastOccurrence(Object o) {
        return this.remove(o);
    }

    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            modified |= this.remove(o);
        }
        return modified;
    }

    public void push(E e) {
        this.addFirst(e);
    }

    public E pop() {
        return (E)this.removeFirst();
    }

    public Iterator<E> iterator() {
        return new AbstractLinkedIterator((Linked)this.first){

            @Override
            E computeNext() {
                return this.cursor.getNext();
            }
        };
    }

    public Iterator<E> descendingIterator() {
        return new AbstractLinkedIterator((Linked)this.last){

            @Override
            E computeNext() {
                return this.cursor.getPrevious();
            }
        };
    }

    static abstract class AbstractLinkedIterator
    implements Iterator<E> {
        E cursor;
        final /* synthetic */ LinkedDeque this$0;

        AbstractLinkedIterator(E start) {
            this.this$0 = this$0;
            this.cursor = start;
        }

        public boolean hasNext() {
            return this.cursor != null;
        }

        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Object e = this.cursor;
            this.cursor = this.computeNext();
            return e;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        abstract E computeNext();
    }
}

