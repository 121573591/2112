/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.util.function.Predicate
 */
package org.apache.commons.lang3.compare;

import java.util.function.Predicate;
import org.apache.commons.lang3.ObjectUtils;

public class ComparableUtils {
    public static <A extends Comparable<A>> Predicate<A> between(A b, A c) {
        return a -> ComparableUtils.is(a).between(b, c);
    }

    public static <A extends Comparable<A>> Predicate<A> betweenExclusive(A b, A c) {
        return a -> ComparableUtils.is(a).betweenExclusive(b, c);
    }

    public static <A extends Comparable<A>> Predicate<A> ge(A b) {
        return a -> ComparableUtils.is(a).greaterThanOrEqualTo(b);
    }

    public static <A extends Comparable<A>> Predicate<A> gt(A b) {
        return a -> ComparableUtils.is(a).greaterThan(b);
    }

    public static <A extends Comparable<A>> ComparableCheckBuilder<A> is(A a) {
        return new ComparableCheckBuilder(a, null);
    }

    public static <A extends Comparable<A>> Predicate<A> le(A b) {
        return a -> ComparableUtils.is(a).lessThanOrEqualTo(b);
    }

    public static <A extends Comparable<A>> Predicate<A> lt(A b) {
        return a -> ComparableUtils.is(a).lessThan(b);
    }

    public static <A extends Comparable<A>> A max(A comparable1, A comparable2) {
        return ObjectUtils.compare(comparable1, comparable2, false) > 0 ? comparable1 : comparable2;
    }

    public static <A extends Comparable<A>> A min(A comparable1, A comparable2) {
        return ObjectUtils.compare(comparable1, comparable2, true) < 0 ? comparable1 : comparable2;
    }

    private ComparableUtils() {
    }

    public static class ComparableCheckBuilder<A extends Comparable<A>> {
        private final A a;

        private ComparableCheckBuilder(A a) {
            this.a = a;
        }

        public boolean between(A b, A c) {
            return this.betweenOrdered(b, c) || this.betweenOrdered(c, b);
        }

        public boolean betweenExclusive(A b, A c) {
            return this.betweenOrderedExclusive(b, c) || this.betweenOrderedExclusive(c, b);
        }

        private boolean betweenOrdered(A b, A c) {
            return this.greaterThanOrEqualTo(b) && this.lessThanOrEqualTo(c);
        }

        private boolean betweenOrderedExclusive(A b, A c) {
            return this.greaterThan(b) && this.lessThan(c);
        }

        public boolean equalTo(A b) {
            return this.a.compareTo(b) == 0;
        }

        public boolean greaterThan(A b) {
            return this.a.compareTo(b) > 0;
        }

        public boolean greaterThanOrEqualTo(A b) {
            return this.a.compareTo(b) >= 0;
        }

        public boolean lessThan(A b) {
            return this.a.compareTo(b) < 0;
        }

        public boolean lessThanOrEqualTo(A b) {
            return this.a.compareTo(b) <= 0;
        }

        /* synthetic */ ComparableCheckBuilder(Comparable x0, 1 x1) {
            this(x0);
        }
    }
}

