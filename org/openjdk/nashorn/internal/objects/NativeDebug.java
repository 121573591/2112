/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.PrintWriter
 *  java.lang.ClassCastException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimePermission
 *  java.lang.SecurityManager
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.security.Permission
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedList
 *  java.util.Objects
 */
package org.openjdk.nashorn.internal.objects;

import java.io.PrintWriter;
import java.security.Permission;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import org.openjdk.nashorn.internal.objects.Global;
import org.openjdk.nashorn.internal.runtime.Context;
import org.openjdk.nashorn.internal.runtime.JSType;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyMap;
import org.openjdk.nashorn.internal.runtime.PropertySwitchPoints;
import org.openjdk.nashorn.internal.runtime.Scope;
import org.openjdk.nashorn.internal.runtime.ScriptFunction;
import org.openjdk.nashorn.internal.runtime.ScriptObject;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;
import org.openjdk.nashorn.internal.runtime.events.RuntimeEvent;
import org.openjdk.nashorn.internal.runtime.linker.LinkerCallSite;

public final class NativeDebug
extends ScriptObject {
    private static PropertyMap $nasgenmap$;
    private static final String EVENT_QUEUE = "__eventQueue__";
    private static final String EVENT_QUEUE_CAPACITY = "__eventQueueCapacity__";

    private NativeDebug() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getClassName() {
        return "Debug";
    }

    public static Object getArrayDataClass(Object self, Object obj) {
        try {
            return ((ScriptObject)obj).getArray().getClass();
        }
        catch (ClassCastException e) {
            return ScriptRuntime.UNDEFINED;
        }
    }

    public static Object getArrayData(Object self, Object obj) {
        try {
            return ((ScriptObject)obj).getArray();
        }
        catch (ClassCastException e) {
            return ScriptRuntime.UNDEFINED;
        }
    }

    public static Object getContext(Object self) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission((Permission)new RuntimePermission("nashorn.getContext"));
        }
        return Global.getThisContext();
    }

    public static Object map(Object self, Object obj) {
        if (obj instanceof ScriptObject) {
            return ((ScriptObject)obj).getMap();
        }
        return ScriptRuntime.UNDEFINED;
    }

    public static boolean identical(Object self, Object obj1, Object obj2) {
        return obj1 == obj2;
    }

    public static Object equalWithoutType(Object self, Object m1, Object m2) {
        return ((PropertyMap)m1).equalsWithoutType((PropertyMap)m2);
    }

    public static Object diffPropertyMaps(Object self, Object m1, Object m2) {
        return PropertyMap.diff((PropertyMap)m1, (PropertyMap)m2);
    }

    public static Object getClass(Object self, Object obj) {
        if (obj != null) {
            return obj.getClass();
        }
        return ScriptRuntime.UNDEFINED;
    }

    public static boolean equals(Object self, Object obj1, Object obj2) {
        return Objects.equals((Object)obj1, (Object)obj2);
    }

    public static String toJavaString(Object self, Object obj) {
        return Objects.toString((Object)obj);
    }

    public static String toIdentString(Object self, Object obj) {
        if (obj == null) {
            return "null";
        }
        int hash = System.identityHashCode((Object)obj);
        return obj.getClass() + "@" + Integer.toHexString((int)hash);
    }

    public static Object isDebuggableFunction(Object self, Object obj) {
        return obj instanceof ScriptFunction && ((ScriptFunction)obj).hasAllVarsInScope();
    }

    public static int getListenerCount(Object self, Object obj) {
        return obj instanceof ScriptObject ? PropertySwitchPoints.getSwitchPointCount((ScriptObject)obj) : 0;
    }

    public static Object dumpCounters(Object self) {
        PrintWriter out = Context.getCurrentErr();
        out.println("ScriptObject count " + ScriptObject.getCount());
        out.println("Scope count " + Scope.getScopeCount());
        out.println("Property SwitchPoints added " + PropertySwitchPoints.getSwitchPointsAdded());
        out.println("Property SwitchPoints invalidated " + PropertySwitchPoints.getSwitchPointsInvalidated());
        out.println("ScriptFunction constructor calls " + ScriptFunction.getConstructorCount());
        out.println("ScriptFunction invokes " + ScriptFunction.getInvokes());
        out.println("ScriptFunction allocations " + ScriptFunction.getAllocations());
        out.println("PropertyMap count " + PropertyMap.getCount());
        out.println("PropertyMap cloned " + PropertyMap.getClonedCount());
        out.println("PropertyMap history hit " + PropertyMap.getHistoryHit());
        out.println("PropertyMap proto invalidations " + PropertyMap.getProtoInvalidations());
        out.println("PropertyMap proto history hit " + PropertyMap.getProtoHistoryHit());
        out.println("PropertyMap setProtoNewMapCount " + PropertyMap.getSetProtoNewMapCount());
        out.println("Callsite count " + LinkerCallSite.getCount());
        out.println("Callsite misses " + LinkerCallSite.getMissCount());
        out.println("Callsite misses by site at " + LinkerCallSite.getMissSamplingPercentage() + "%");
        LinkerCallSite.getMissCounts(out);
        return ScriptRuntime.UNDEFINED;
    }

    public static Object getEventQueueCapacity(Object self) {
        int cap;
        ScriptObject sobj = (ScriptObject)self;
        if (sobj.has(EVENT_QUEUE_CAPACITY)) {
            cap = JSType.toInt32(sobj.get(EVENT_QUEUE_CAPACITY));
        } else {
            cap = RuntimeEvent.RUNTIME_EVENT_QUEUE_SIZE;
            NativeDebug.setEventQueueCapacity(self, cap);
        }
        return cap;
    }

    public static void setEventQueueCapacity(Object self, Object newCapacity) {
        ((ScriptObject)self).set((Object)EVENT_QUEUE_CAPACITY, newCapacity, 32);
    }

    public static void addRuntimeEvent(Object self, Object event) {
        LinkedList<RuntimeEvent<?>> q = NativeDebug.getEventQueue(self);
        int cap = (Integer)NativeDebug.getEventQueueCapacity(self);
        while (q.size() >= cap) {
            q.removeFirst();
        }
        q.addLast(NativeDebug.getEvent(event));
    }

    public static void expandEventQueueCapacity(Object self, Object newCapacity) {
        LinkedList<RuntimeEvent<?>> q = NativeDebug.getEventQueue(self);
        int nc = JSType.toInt32(newCapacity);
        while (q.size() > nc) {
            q.removeFirst();
        }
        NativeDebug.setEventQueueCapacity(self, nc);
    }

    public static void clearRuntimeEvents(Object self) {
        LinkedList<RuntimeEvent<?>> q = NativeDebug.getEventQueue(self);
        q.clear();
    }

    public static void removeRuntimeEvent(Object self, Object event) {
        RuntimeEvent<?> re;
        LinkedList<RuntimeEvent<?>> q = NativeDebug.getEventQueue(self);
        if (!q.remove(re = NativeDebug.getEvent(event))) {
            throw new IllegalStateException("runtime event " + re + " was not in event queue");
        }
    }

    public static Object getRuntimeEvents(Object self) {
        LinkedList<RuntimeEvent<?>> q = NativeDebug.getEventQueue(self);
        return q.toArray((Object[])new RuntimeEvent[0]);
    }

    public static Object getLastRuntimeEvent(Object self) {
        LinkedList<RuntimeEvent<?>> q = NativeDebug.getEventQueue(self);
        return q.isEmpty() ? null : q.getLast();
    }

    private static LinkedList<RuntimeEvent<?>> getEventQueue(Object self) {
        LinkedList q;
        ScriptObject sobj = (ScriptObject)self;
        if (sobj.has(EVENT_QUEUE)) {
            q = (LinkedList)((ScriptObject)self).get(EVENT_QUEUE);
        } else {
            q = new LinkedList();
            ((ScriptObject)self).set((Object)EVENT_QUEUE, (Object)q, 32);
        }
        return q;
    }

    private static RuntimeEvent<?> getEvent(Object event) {
        return (RuntimeEvent)event;
    }

    static {
        NativeDebug.$clinit$();
    }

    public static void $clinit$() {
        $nasgenmap$ = PropertyMap.newMap((Collection<Property>)Collections.EMPTY_LIST);
    }
}

