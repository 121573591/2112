/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayDeque
 */
package org.openjdk.nashorn.internal.runtime;

import java.util.ArrayDeque;
import org.openjdk.nashorn.internal.runtime.JSType;

public final class ConsString
implements CharSequence {
    private CharSequence left;
    private CharSequence right;
    private final int length;
    private volatile int state = 0;
    private static final int STATE_NEW = 0;
    private static final int STATE_THRESHOLD = 2;
    private static final int STATE_FLATTENED = -1;

    public ConsString(CharSequence left, CharSequence right) {
        assert (JSType.isString(left));
        assert (JSType.isString(right));
        this.left = left;
        this.right = right;
        this.length = left.length() + right.length();
        if (this.length < 0) {
            throw new IllegalArgumentException("too big concatenated String");
        }
    }

    public String toString() {
        return (String)this.flattened(true);
    }

    public int length() {
        return this.length;
    }

    public char charAt(int index) {
        return this.flattened(true).charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return this.flattened(true).subSequence(start, end);
    }

    public synchronized CharSequence[] getComponents() {
        return new CharSequence[]{this.left, this.right};
    }

    private CharSequence flattened(boolean flattenNested) {
        if (this.state != -1) {
            this.flatten(flattenNested);
        }
        return this.left;
    }

    private synchronized void flatten(boolean flattenNested) {
        char[] chars = new char[this.length];
        int pos = this.length;
        ArrayDeque stack = new ArrayDeque();
        stack.addFirst((Object)this.left);
        CharSequence cs = this.right;
        do {
            if (cs instanceof ConsString) {
                ConsString cons = (ConsString)cs;
                if (cons.state == -1 || flattenNested && ++cons.state >= 2) {
                    cs = cons.flattened(false);
                    continue;
                }
                stack.addFirst((Object)cons.left);
                cs = cons.right;
                continue;
            }
            String str = (String)cs;
            str.getChars(0, str.length(), chars, pos -= str.length());
            CharSequence charSequence = cs = stack.isEmpty() ? null : (CharSequence)stack.pollFirst();
        } while (cs != null);
        this.left = new String(chars);
        this.right = "";
        this.state = -1;
    }
}

