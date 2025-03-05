/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.datatransfer.Clipboard
 *  java.awt.datatransfer.ClipboardOwner
 *  java.awt.datatransfer.Transferable
 *  java.io.Closeable
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package cn.hutool.core.swing.clipboard;

import cn.hutool.core.swing.clipboard.ClipboardListener;
import cn.hutool.core.swing.clipboard.ClipboardUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ObjectUtil;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.io.Closeable;
import java.util.LinkedHashSet;
import java.util.Set;

public enum ClipboardMonitor implements ClipboardOwner,
Runnable,
Closeable
{
    INSTANCE;

    public static final int DEFAULT_TRY_COUNT = 10;
    public static final long DEFAULT_DELAY = 100L;
    private int tryCount;
    private long delay;
    private final Clipboard clipboard;
    private final Set<ClipboardListener> listenerSet = new LinkedHashSet();
    private boolean isRunning;

    private ClipboardMonitor() {
        this(10, 100L);
    }

    private ClipboardMonitor(int tryCount, long delay) {
        this(tryCount, delay, ClipboardUtil.getClipboard());
    }

    private ClipboardMonitor(int tryCount, long delay, Clipboard clipboard) {
        this.tryCount = tryCount;
        this.delay = delay;
        this.clipboard = clipboard;
    }

    public ClipboardMonitor setTryCount(int tryCount) {
        this.tryCount = tryCount;
        return this;
    }

    public ClipboardMonitor setDelay(long delay) {
        this.delay = delay;
        return this;
    }

    public ClipboardMonitor addListener(ClipboardListener listener) {
        this.listenerSet.add((Object)listener);
        return this;
    }

    public ClipboardMonitor removeListener(ClipboardListener listener) {
        this.listenerSet.remove((Object)listener);
        return this;
    }

    public ClipboardMonitor clearListener() {
        this.listenerSet.clear();
        return this;
    }

    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        Transferable newContents;
        try {
            newContents = this.tryGetContent(clipboard);
        }
        catch (InterruptedException e) {
            return;
        }
        Transferable transferable = null;
        for (ClipboardListener listener : this.listenerSet) {
            try {
                transferable = listener.onChange(clipboard, ObjectUtil.defaultIfNull(transferable, newContents));
            }
            catch (Throwable throwable) {}
        }
        if (this.isRunning) {
            clipboard.setContents(ObjectUtil.defaultIfNull(transferable, ObjectUtil.defaultIfNull(newContents, contents)), (ClipboardOwner)this);
        }
    }

    public synchronized void run() {
        if (!this.isRunning) {
            Clipboard clipboard = this.clipboard;
            clipboard.setContents(clipboard.getContents(null), (ClipboardOwner)this);
            this.isRunning = true;
        }
    }

    public void listen(boolean sync) {
        this.run();
        if (sync) {
            ThreadUtil.sync((Object)this);
        }
    }

    public void close() {
        this.isRunning = false;
    }

    private Transferable tryGetContent(Clipboard clipboard) throws InterruptedException {
        Transferable newContents = null;
        for (int i = 0; i < this.tryCount; ++i) {
            if (this.delay > 0L && i > 0) {
                Thread.sleep((long)this.delay);
            }
            try {
                newContents = clipboard.getContents(null);
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
            if (null == newContents) continue;
            return newContents;
        }
        return null;
    }
}

