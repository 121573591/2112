/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.tuple.ImmutableTriple;

public abstract class Triple<L, M, R>
implements Comparable<Triple<L, M, R>>,
Serializable {
    private static final long serialVersionUID = 1L;
    public static final Triple<?, ?, ?>[] EMPTY_ARRAY = new Triple[0];

    public static <L, M, R> Triple<L, M, R>[] emptyArray() {
        return EMPTY_ARRAY;
    }

    public static <L, M, R> Triple<L, M, R> of(L left, M middle, R right) {
        return ImmutableTriple.of(left, middle, right);
    }

    public static <L, M, R> Triple<L, M, R> ofNonNull(L left, M middle, R right) {
        return ImmutableTriple.ofNonNull(left, middle, right);
    }

    public int compareTo(Triple<L, M, R> other) {
        return new CompareToBuilder().append(this.getLeft(), other.getLeft()).append(this.getMiddle(), other.getMiddle()).append(this.getRight(), other.getRight()).toComparison();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Triple) {
            Triple other = (Triple)obj;
            return Objects.equals(this.getLeft(), other.getLeft()) && Objects.equals(this.getMiddle(), other.getMiddle()) && Objects.equals(this.getRight(), other.getRight());
        }
        return false;
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public int hashCode() {
        return Objects.hashCode(this.getLeft()) ^ Objects.hashCode(this.getMiddle()) ^ Objects.hashCode(this.getRight());
    }

    public String toString() {
        return "(" + this.getLeft() + "," + this.getMiddle() + "," + this.getRight() + ")";
    }

    public String toString(String format) {
        return String.format((String)format, (Object[])new Object[]{this.getLeft(), this.getMiddle(), this.getRight()});
    }
}

