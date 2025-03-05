/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 *  java.util.Objects
 */
package cn.hutool.core.lang.tree;

import cn.hutool.core.lang.tree.Node;
import java.util.Map;
import java.util.Objects;

public class TreeNode<T>
implements Node<T> {
    private static final long serialVersionUID = 1L;
    private T id;
    private T parentId;
    private CharSequence name;
    private Comparable<?> weight = 0;
    private Map<String, Object> extra;

    public TreeNode() {
    }

    public TreeNode(T id, T parentId, String name, Comparable<?> weight) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        if (weight != null) {
            this.weight = weight;
        }
    }

    @Override
    public T getId() {
        return this.id;
    }

    @Override
    public TreeNode<T> setId(T id) {
        this.id = id;
        return this;
    }

    @Override
    public T getParentId() {
        return this.parentId;
    }

    @Override
    public TreeNode<T> setParentId(T parentId) {
        this.parentId = parentId;
        return this;
    }

    @Override
    public CharSequence getName() {
        return this.name;
    }

    @Override
    public TreeNode<T> setName(CharSequence name) {
        this.name = name;
        return this;
    }

    @Override
    public Comparable<?> getWeight() {
        return this.weight;
    }

    @Override
    public TreeNode<T> setWeight(Comparable<?> weight) {
        this.weight = weight;
        return this;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public TreeNode<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode)o;
        return Objects.equals(this.id, treeNode.id);
    }

    public int hashCode() {
        return Objects.hash((Object[])new Object[]{this.id});
    }
}

