/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 */
package cn.hutool.core.lang.tree.parser;

import cn.hutool.core.lang.tree.Tree;

@FunctionalInterface
public interface NodeParser<T, E> {
    public void parse(T var1, Tree<E> var2);
}

