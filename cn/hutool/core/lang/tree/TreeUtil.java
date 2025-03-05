/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 */
package cn.hutool.core.lang.tree;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeBuilder;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.parser.DefaultNodeParser;
import cn.hutool.core.lang.tree.parser.NodeParser;
import cn.hutool.core.util.ObjectUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeUtil {
    public static Tree<Integer> buildSingle(List<TreeNode<Integer>> list) {
        return TreeUtil.buildSingle(list, Integer.valueOf((int)0));
    }

    public static List<Tree<Integer>> build(List<TreeNode<Integer>> list) {
        return TreeUtil.build(list, Integer.valueOf((int)0));
    }

    public static <E> Tree<E> buildSingle(List<TreeNode<E>> list, E parentId) {
        return TreeUtil.buildSingle(list, parentId, TreeNodeConfig.DEFAULT_CONFIG, new DefaultNodeParser());
    }

    public static <E> List<Tree<E>> build(List<TreeNode<E>> list, E parentId) {
        return TreeUtil.build(list, parentId, TreeNodeConfig.DEFAULT_CONFIG, new DefaultNodeParser());
    }

    public static <T, E> Tree<E> buildSingle(List<T> list, E parentId, NodeParser<T, E> nodeParser) {
        return TreeUtil.buildSingle(list, parentId, TreeNodeConfig.DEFAULT_CONFIG, nodeParser);
    }

    public static <T, E> List<Tree<E>> build(List<T> list, E parentId, NodeParser<T, E> nodeParser) {
        return TreeUtil.build(list, parentId, TreeNodeConfig.DEFAULT_CONFIG, nodeParser);
    }

    public static <T, E> List<Tree<E>> build(List<T> list, E rootId, TreeNodeConfig treeNodeConfig, NodeParser<T, E> nodeParser) {
        return TreeUtil.buildSingle(list, rootId, treeNodeConfig, nodeParser).getChildren();
    }

    public static <T, E> Tree<E> buildSingle(List<T> list, E rootId, TreeNodeConfig treeNodeConfig, NodeParser<T, E> nodeParser) {
        return TreeBuilder.of(rootId, treeNodeConfig).append(list, rootId, nodeParser).build();
    }

    public static <E> List<Tree<E>> build(Map<E, Tree<E>> map, E rootId) {
        return TreeUtil.buildSingle(map, rootId).getChildren();
    }

    public static <E> Tree<E> buildSingle(Map<E, Tree<E>> map, E rootId) {
        Tree tree = (Tree)IterUtil.getFirstNoneNull(map.values());
        if (null != tree) {
            TreeNodeConfig config = tree.getConfig();
            return TreeBuilder.of(rootId, config).append(map).build();
        }
        return TreeUtil.createEmptyNode(rootId);
    }

    public static <T> Tree<T> getNode(Tree<T> node, T id) {
        if (ObjectUtil.equal(id, node.getId())) {
            return node;
        }
        List<Tree<T>> children = node.getChildren();
        if (null == children) {
            return null;
        }
        for (Tree child : children) {
            Tree<T> childNode = child.getNode(id);
            if (null == childNode) continue;
            return childNode;
        }
        return null;
    }

    public static <T> List<CharSequence> getParentsName(Tree<T> node, boolean includeCurrentNode) {
        ArrayList result = new ArrayList();
        if (null == node) {
            return result;
        }
        if (includeCurrentNode) {
            result.add((Object)node.getName());
        }
        for (Tree<T> parent = node.getParent(); null != parent; parent = parent.getParent()) {
            CharSequence name = parent.getName();
            if (null == name && null == parent) continue;
            result.add((Object)name);
        }
        return result;
    }

    public static <T> List<T> getParentsId(Tree<T> node, boolean includeCurrentNode) {
        ArrayList result = new ArrayList();
        if (null == node) {
            return result;
        }
        if (includeCurrentNode) {
            result.add(node.getId());
        }
        for (Tree<T> parent = node.getParent(); null != parent; parent = parent.getParent()) {
            T id = parent.getId();
            if (null == id && null == parent) continue;
            result.add(id);
        }
        return result;
    }

    public static <E> Tree<E> createEmptyNode(E id) {
        return new Tree().setId(id);
    }
}

