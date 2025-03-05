/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Comparator
 */
package cn.hutool.core.annotation;

import java.util.Comparator;

public interface Hierarchical
extends Comparable<Hierarchical> {
    public static final Comparator<Hierarchical> DEFAULT_HIERARCHICAL_COMPARATOR = Comparator.comparing(Hierarchical::getVerticalDistance).thenComparing(Hierarchical::getHorizontalDistance);

    default public int compareTo(Hierarchical o) {
        return DEFAULT_HIERARCHICAL_COMPARATOR.compare((Object)this, (Object)o);
    }

    public Object getRoot();

    public int getVerticalDistance();

    public int getHorizontalDistance();

    @FunctionalInterface
    public static interface Selector {
        public static final Selector NEAREST_AND_OLDEST_PRIORITY = new NearestAndOldestPrioritySelector();
        public static final Selector NEAREST_AND_NEWEST_PRIORITY = new NearestAndNewestPrioritySelector();
        public static final Selector FARTHEST_AND_OLDEST_PRIORITY = new FarthestAndOldestPrioritySelector();
        public static final Selector FARTHEST_AND_NEWEST_PRIORITY = new FarthestAndNewestPrioritySelector();

        public <T extends Hierarchical> T choose(T var1, T var2);

        public static class FarthestAndNewestPrioritySelector
        implements Selector {
            @Override
            public <T extends Hierarchical> T choose(T oldAnnotation, T newAnnotation) {
                return newAnnotation.getVerticalDistance() >= oldAnnotation.getVerticalDistance() ? newAnnotation : oldAnnotation;
            }
        }

        public static class FarthestAndOldestPrioritySelector
        implements Selector {
            @Override
            public <T extends Hierarchical> T choose(T oldAnnotation, T newAnnotation) {
                return newAnnotation.getVerticalDistance() > oldAnnotation.getVerticalDistance() ? newAnnotation : oldAnnotation;
            }
        }

        public static class NearestAndNewestPrioritySelector
        implements Selector {
            @Override
            public <T extends Hierarchical> T choose(T oldAnnotation, T newAnnotation) {
                return newAnnotation.getVerticalDistance() <= oldAnnotation.getVerticalDistance() ? newAnnotation : oldAnnotation;
            }
        }

        public static class NearestAndOldestPrioritySelector
        implements Selector {
            @Override
            public <T extends Hierarchical> T choose(T oldAnnotation, T newAnnotation) {
                return newAnnotation.getVerticalDistance() < oldAnnotation.getVerticalDistance() ? newAnnotation : oldAnnotation;
            }
        }
    }
}

