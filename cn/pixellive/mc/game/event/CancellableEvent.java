/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.openjdk.nashorn.tools.resources.DkeZo.___.____
 */
package cn.pixellive.mc.game.event;

import org.openjdk.nashorn.tools.resources.DkeZo.___;
import org.openjdk.nashorn.tools.resources.DkeZo.___.____;

public class CancellableEvent {
    private boolean cancelled;

    public final boolean getCancelled() {
        return this.cancelled;
    }

    public final void setCancelled(boolean bl) {
        this.cancelled = bl;
    }

    static {
        ___.___(338, CancellableEvent.class);
        ____.___338_30(CancellableEvent.class);
    }
}

