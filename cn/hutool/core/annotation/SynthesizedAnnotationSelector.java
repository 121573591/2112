/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.Hierarchical;
import cn.hutool.core.annotation.SynthesizedAnnotation;

@FunctionalInterface
public interface SynthesizedAnnotationSelector {
    public static final SynthesizedAnnotationSelector NEAREST_AND_OLDEST_PRIORITY = new NearestAndOldestPrioritySelector();
    public static final SynthesizedAnnotationSelector NEAREST_AND_NEWEST_PRIORITY = new NearestAndNewestPrioritySelector();
    public static final SynthesizedAnnotationSelector FARTHEST_AND_OLDEST_PRIORITY = new FarthestAndOldestPrioritySelector();
    public static final SynthesizedAnnotationSelector FARTHEST_AND_NEWEST_PRIORITY = new FarthestAndNewestPrioritySelector();

    public <T extends SynthesizedAnnotation> T choose(T var1, T var2);

    public static class FarthestAndNewestPrioritySelector
    implements SynthesizedAnnotationSelector {
        @Override
        public <T extends SynthesizedAnnotation> T choose(T oldAnnotation, T newAnnotation) {
            return Hierarchical.Selector.FARTHEST_AND_NEWEST_PRIORITY.choose(oldAnnotation, newAnnotation);
        }
    }

    public static class FarthestAndOldestPrioritySelector
    implements SynthesizedAnnotationSelector {
        @Override
        public <T extends SynthesizedAnnotation> T choose(T oldAnnotation, T newAnnotation) {
            return Hierarchical.Selector.FARTHEST_AND_OLDEST_PRIORITY.choose(oldAnnotation, newAnnotation);
        }
    }

    public static class NearestAndNewestPrioritySelector
    implements SynthesizedAnnotationSelector {
        @Override
        public <T extends SynthesizedAnnotation> T choose(T oldAnnotation, T newAnnotation) {
            return Hierarchical.Selector.NEAREST_AND_NEWEST_PRIORITY.choose(oldAnnotation, newAnnotation);
        }
    }

    public static class NearestAndOldestPrioritySelector
    implements SynthesizedAnnotationSelector {
        @Override
        public <T extends SynthesizedAnnotation> T choose(T oldAnnotation, T newAnnotation) {
            return Hierarchical.Selector.NEAREST_AND_OLDEST_PRIORITY.choose(oldAnnotation, newAnnotation);
        }
    }
}

