/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.function.BiConsumer
 *  java.util.function.Function
 */
package cn.hutool.core.map;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.map.TreeEntry;
import cn.hutool.core.util.ObjectUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface ForestMap<K, V>
extends Map<K, TreeEntry<K, V>> {
    default public TreeEntry<K, V> put(K key, TreeEntry<K, V> node) {
        return this.putNode(key, node.getValue());
    }

    default public void putAll(Map<? extends K, ? extends TreeEntry<K, V>> treeEntryMap) {
        if (CollUtil.isEmpty(treeEntryMap)) {
            return;
        }
        treeEntryMap.forEach((k, v) -> {
            if (v.hasParent()) {
                TreeEntry parent = v.getDeclaredParent();
                this.putLinkedNodes(parent.getKey(), parent.getValue(), v.getKey(), v.getValue());
            } else {
                this.putNode(v.getKey(), v.getValue());
            }
        });
    }

    public TreeEntry<K, V> remove(Object var1);

    public void clear();

    default public <C extends Collection<V>> void putAllNode(C values, Function<V, K> keyGenerator, Function<V, K> parentKeyGenerator, boolean ignoreNullNode) {
        if (CollUtil.isEmpty(values)) {
            return;
        }
        values.forEach(v -> {
            Object key = keyGenerator.apply(v);
            Object parentKey = parentKeyGenerator.apply(v);
            boolean hasKey = ObjectUtil.isNotNull(key);
            boolean hasParentKey = ObjectUtil.isNotNull(parentKey);
            if (!ignoreNullNode || hasKey && hasParentKey) {
                this.linkNodes(parentKey, key);
                ((TreeEntry)this.get(key)).setValue(v);
                return;
            }
            if (!hasKey && !hasParentKey) {
                return;
            }
            if (hasKey) {
                this.putNode(key, v);
                return;
            }
            this.putNode(parentKey, null);
        });
    }

    public TreeEntry<K, V> putNode(K var1, V var2);

    default public void putLinkedNodes(K parentKey, V parentValue, K childKey, V childValue) {
        this.putNode(parentKey, parentValue);
        this.putNode(childKey, childValue);
        this.linkNodes(parentKey, childKey);
    }

    public void putLinkedNodes(K var1, K var2, V var3);

    default public void linkNodes(K parentKey, K childKey) {
        this.linkNodes(parentKey, childKey, null);
    }

    public void linkNodes(K var1, K var2, BiConsumer<TreeEntry<K, V>, TreeEntry<K, V>> var3);

    public void unlinkNode(K var1, K var2);

    default public Set<TreeEntry<K, V>> getTreeNodes(K key) {
        TreeEntry target = (TreeEntry)this.get(key);
        if (ObjectUtil.isNull(target)) {
            return Collections.emptySet();
        }
        LinkedHashSet<TreeEntry> results = CollUtil.newLinkedHashSet(target.getRoot());
        CollUtil.addAll(results, target.getRoot().getChildren().values());
        return results;
    }

    default public TreeEntry<K, V> getRootNode(K key) {
        return Opt.ofNullable(this.get(key)).map(TreeEntry::getRoot).orElse(null);
    }

    default public TreeEntry<K, V> getDeclaredParentNode(K key) {
        return Opt.ofNullable(this.get(key)).map(TreeEntry::getDeclaredParent).orElse(null);
    }

    default public TreeEntry<K, V> getParentNode(K key, K parentKey) {
        return Opt.ofNullable(this.get(key)).map(t -> t.getParent(parentKey)).orElse(null);
    }

    default public boolean containsParentNode(K key, K parentKey) {
        return Opt.ofNullable(this.get(key)).map(m -> m.containsParent(parentKey)).orElse(false);
    }

    default public V getNodeValue(K key) {
        return (V)Opt.ofNullable(this.get(key)).map(Map.Entry::getValue).get();
    }

    default public boolean containsChildNode(K parentKey, K childKey) {
        return Opt.ofNullable(this.get(parentKey)).map(m -> m.containsChild(childKey)).orElse(false);
    }

    default public Collection<TreeEntry<K, V>> getDeclaredChildNodes(K key) {
        return (Collection)Opt.ofNullable(this.get(key)).map(TreeEntry::getDeclaredChildren).map(Map::values).orElseGet(Collections::emptyList);
    }

    default public Collection<TreeEntry<K, V>> getChildNodes(K key) {
        return (Collection)Opt.ofNullable(this.get(key)).map(TreeEntry::getChildren).map(Map::values).orElseGet(Collections::emptyList);
    }
}

