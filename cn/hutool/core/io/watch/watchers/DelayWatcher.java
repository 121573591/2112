/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.file.Path
 *  java.nio.file.Paths
 *  java.nio.file.WatchEvent
 *  java.util.Set
 */
package cn.hutool.core.io.watch.watchers;

import cn.hutool.core.collection.ConcurrentHashSet;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.thread.ThreadUtil;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.util.Set;

public class DelayWatcher
implements Watcher {
    private final Set<Path> eventSet = new ConcurrentHashSet();
    private final Watcher watcher;
    private final long delay;

    public DelayWatcher(Watcher watcher, long delay) {
        Assert.notNull(watcher);
        if (watcher instanceof DelayWatcher) {
            throw new IllegalArgumentException("Watcher must not be a DelayWatcher");
        }
        this.watcher = watcher;
        this.delay = delay;
    }

    @Override
    public void onModify(WatchEvent<?> event, Path currentPath) {
        if (this.delay < 1L) {
            this.watcher.onModify(event, currentPath);
        } else {
            this.onDelayModify(event, currentPath);
        }
    }

    @Override
    public void onCreate(WatchEvent<?> event, Path currentPath) {
        this.watcher.onCreate(event, currentPath);
    }

    @Override
    public void onDelete(WatchEvent<?> event, Path currentPath) {
        this.watcher.onDelete(event, currentPath);
    }

    @Override
    public void onOverflow(WatchEvent<?> event, Path currentPath) {
        this.watcher.onOverflow(event, currentPath);
    }

    private void onDelayModify(WatchEvent<?> event, Path currentPath) {
        Path eventPath = Paths.get((String)currentPath.toString(), (String[])new String[]{event.context().toString()});
        if (this.eventSet.contains((Object)eventPath)) {
            return;
        }
        this.eventSet.add((Object)eventPath);
        this.startHandleModifyThread(event, currentPath);
    }

    private void startHandleModifyThread(WatchEvent<?> event, Path currentPath) {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(this.delay);
            this.eventSet.remove((Object)Paths.get((String)currentPath.toString(), (String[])new String[]{event.context().toString()}));
            this.watcher.onModify(event, currentPath);
        });
    }
}

