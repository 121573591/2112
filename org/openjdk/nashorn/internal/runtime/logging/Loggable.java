/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.openjdk.nashorn.internal.runtime.logging;

import org.openjdk.nashorn.internal.runtime.Context;
import org.openjdk.nashorn.internal.runtime.logging.DebugLogger;

public interface Loggable {
    public DebugLogger initLogger(Context var1);

    public DebugLogger getLogger();
}

