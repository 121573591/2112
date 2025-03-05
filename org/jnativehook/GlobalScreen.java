/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.UnsatisfiedLinkError
 *  java.util.EventListener
 *  java.util.Iterator
 *  java.util.concurrent.ExecutorService
 *  java.util.logging.Logger
 *  javax.swing.event.EventListenerList
 */
package org.jnativehook;

import java.io.File;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.NativeLibraryLocator;
import org.jnativehook.NativeMonitorInfo;
import org.jnativehook.dispatcher.DefaultDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class GlobalScreen {
    protected static Logger log;
    protected static NativeHookThread hookThread;
    protected static ExecutorService eventExecutor;
    protected static EventListenerList eventListeners;

    protected GlobalScreen() {
    }

    public static void addNativeKeyListener(NativeKeyListener nativeKeyListener) {
        if (nativeKeyListener != null) {
            eventListeners.add(NativeKeyListener.class, (EventListener)nativeKeyListener);
        }
    }

    public static void removeNativeKeyListener(NativeKeyListener nativeKeyListener) {
        if (nativeKeyListener != null) {
            eventListeners.remove(NativeKeyListener.class, (EventListener)nativeKeyListener);
        }
    }

    public static void addNativeMouseListener(NativeMouseListener nativeMouseListener) {
        if (nativeMouseListener != null) {
            eventListeners.add(NativeMouseListener.class, (EventListener)nativeMouseListener);
        }
    }

    public static void removeNativeMouseListener(NativeMouseListener nativeMouseListener) {
        if (nativeMouseListener != null) {
            eventListeners.remove(NativeMouseListener.class, (EventListener)nativeMouseListener);
        }
    }

    public static void addNativeMouseMotionListener(NativeMouseMotionListener nativeMouseMotionListener) {
        if (nativeMouseMotionListener != null) {
            eventListeners.add(NativeMouseMotionListener.class, (EventListener)nativeMouseMotionListener);
        }
    }

    public static void removeNativeMouseMotionListener(NativeMouseMotionListener nativeMouseMotionListener) {
        if (nativeMouseMotionListener != null) {
            eventListeners.remove(NativeMouseMotionListener.class, (EventListener)nativeMouseMotionListener);
        }
    }

    public static void addNativeMouseWheelListener(NativeMouseWheelListener nativeMouseWheelListener) {
        if (nativeMouseWheelListener != null) {
            eventListeners.add(NativeMouseWheelListener.class, (EventListener)nativeMouseWheelListener);
        }
    }

    public static void removeNativeMouseWheelListener(NativeMouseWheelListener nativeMouseWheelListener) {
        if (nativeMouseWheelListener != null) {
            eventListeners.remove(NativeMouseWheelListener.class, (EventListener)nativeMouseWheelListener);
        }
    }

    public static native NativeMonitorInfo[] getNativeMonitors();

    public static native Integer getAutoRepeatRate();

    public static native Integer getAutoRepeatDelay();

    public static native Integer getPointerAccelerationMultiplier();

    public static native Integer getPointerAccelerationThreshold();

    public static native Integer getPointerSensitivity();

    public static native Integer getMultiClickIterval();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registerNativeHook() throws NativeHookException {
        if (hookThread == null || !hookThread.isAlive()) {
            NativeHookThread nativeHookThread = hookThread = new NativeHookThread();
            synchronized (nativeHookThread) {
                hookThread.start();
                try {
                    hookThread.wait();
                }
                catch (InterruptedException interruptedException) {
                    throw new NativeHookException(interruptedException);
                }
                NativeHookException nativeHookException = hookThread.getException();
                if (nativeHookException != null) {
                    throw nativeHookException;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void unregisterNativeHook() throws NativeHookException {
        if (GlobalScreen.isNativeHookRegistered()) {
            NativeHookThread nativeHookThread = hookThread;
            synchronized (nativeHookThread) {
                hookThread.disable();
                try {
                    hookThread.join();
                }
                catch (InterruptedException interruptedException) {
                    throw new NativeHookException(interruptedException.getCause());
                }
            }
        }
    }

    public static boolean isNativeHookRegistered() {
        return hookThread != null && hookThread.isAlive();
    }

    public static native void postNativeEvent(NativeInputEvent var0);

    public static void setEventDispatcher(ExecutorService executorService) {
        if (eventExecutor != null) {
            eventExecutor.shutdown();
        }
        eventExecutor = executorService;
    }

    static {
        Integer n;
        Integer n2;
        Iterator<File> iterator;
        Object object;
        String string;
        log = Logger.getLogger((String)GlobalScreen.class.getPackage().getName());
        eventExecutor = new DefaultDispatchService();
        eventListeners = new EventListenerList();
        String string2 = System.getProperty((String)"jnativehook.lib.name", (String)"JNativeHook");
        try {
            System.loadLibrary((String)string2);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            string = System.getProperty((String)"jnativehook.lib.locator", (String)"org.jnativehook.DefaultLibraryLocator");
            try {
                object = (NativeLibraryLocator)Class.forName((String)string).asSubclass(NativeLibraryLocator.class).newInstance();
                iterator = object.getLibraries();
                while (iterator.hasNext()) {
                    n2 = (File)iterator.next();
                    if (!n2.exists() || !n2.isFile() || !n2.canRead()) continue;
                    System.load((String)n2.getPath());
                }
            }
            catch (Exception exception) {
                log.severe(exception.getMessage());
                throw new UnsatisfiedLinkError(exception.getMessage());
            }
        }
        Integer n3 = GlobalScreen.getAutoRepeatRate();
        if (n3 != null) {
            System.setProperty((String)"jnativehook.key.repeat.rate", (String)n3.toString());
        }
        if ((string = GlobalScreen.getAutoRepeatDelay()) != null) {
            System.setProperty((String)"jnativehook.key.repeat.delay", (String)string.toString());
        }
        if ((object = GlobalScreen.getMultiClickIterval()) != null) {
            System.setProperty((String)"jnativehook.button.multiclick.iterval", (String)object.toString());
        }
        if ((iterator = GlobalScreen.getPointerSensitivity()) != null) {
            System.setProperty((String)"jnativehook.pointer.sensitivity", (String)iterator.toString());
        }
        if ((n2 = GlobalScreen.getPointerAccelerationMultiplier()) != null) {
            System.setProperty((String)"jnativehook.pointer.acceleration.multiplier", (String)n2.toString());
        }
        if ((n = GlobalScreen.getPointerAccelerationThreshold()) != null) {
            System.setProperty((String)"jnativehook.pointer.acceleration.threshold", (String)n.toString());
        }
    }

    private static class EventDispatchTask
    implements Runnable {
        private NativeInputEvent event;

        public EventDispatchTask(NativeInputEvent nativeInputEvent) {
            this.event = nativeInputEvent;
        }

        public void run() {
            if (this.event instanceof NativeKeyEvent) {
                this.processKeyEvent((NativeKeyEvent)this.event);
            } else if (this.event instanceof NativeMouseWheelEvent) {
                this.processMouseWheelEvent((NativeMouseWheelEvent)this.event);
            } else if (this.event instanceof NativeMouseEvent) {
                switch (this.event.getID()) {
                    case 2500: 
                    case 2501: 
                    case 2502: {
                        this.processButtonEvent((NativeMouseEvent)this.event);
                        break;
                    }
                    case 2503: 
                    case 2504: {
                        this.processMouseEvent((NativeMouseEvent)this.event);
                    }
                }
            } else if (this.event instanceof NativeMouseWheelEvent) {
                this.processMouseWheelEvent((NativeMouseWheelEvent)this.event);
            }
        }

        private void processKeyEvent(NativeKeyEvent nativeKeyEvent) {
            NativeKeyListener[] nativeKeyListenerArray = (NativeKeyListener[])eventListeners.getListeners(NativeKeyListener.class);
            block5: for (int i = 0; i < nativeKeyListenerArray.length; ++i) {
                switch (nativeKeyEvent.getID()) {
                    case 2401: {
                        nativeKeyListenerArray[i].nativeKeyPressed(nativeKeyEvent);
                        continue block5;
                    }
                    case 2400: {
                        nativeKeyListenerArray[i].nativeKeyTyped(nativeKeyEvent);
                        continue block5;
                    }
                    case 2402: {
                        nativeKeyListenerArray[i].nativeKeyReleased(nativeKeyEvent);
                    }
                }
            }
        }

        private void processButtonEvent(NativeMouseEvent nativeMouseEvent) {
            NativeMouseListener[] nativeMouseListenerArray = (NativeMouseListener[])eventListeners.getListeners(NativeMouseListener.class);
            block5: for (int i = 0; i < nativeMouseListenerArray.length; ++i) {
                switch (nativeMouseEvent.getID()) {
                    case 2500: {
                        nativeMouseListenerArray[i].nativeMouseClicked(nativeMouseEvent);
                        continue block5;
                    }
                    case 2501: {
                        nativeMouseListenerArray[i].nativeMousePressed(nativeMouseEvent);
                        continue block5;
                    }
                    case 2502: {
                        nativeMouseListenerArray[i].nativeMouseReleased(nativeMouseEvent);
                    }
                }
            }
        }

        private void processMouseEvent(NativeMouseEvent nativeMouseEvent) {
            NativeMouseMotionListener[] nativeMouseMotionListenerArray = (NativeMouseMotionListener[])eventListeners.getListeners(NativeMouseMotionListener.class);
            block4: for (int i = 0; i < nativeMouseMotionListenerArray.length; ++i) {
                switch (nativeMouseEvent.getID()) {
                    case 2503: {
                        nativeMouseMotionListenerArray[i].nativeMouseMoved(nativeMouseEvent);
                        continue block4;
                    }
                    case 2504: {
                        nativeMouseMotionListenerArray[i].nativeMouseDragged(nativeMouseEvent);
                    }
                }
            }
        }

        private void processMouseWheelEvent(NativeMouseWheelEvent nativeMouseWheelEvent) {
            NativeMouseWheelListener[] nativeMouseWheelListenerArray = (NativeMouseWheelListener[])eventListeners.getListeners(NativeMouseWheelListener.class);
            for (int i = 0; i < nativeMouseWheelListenerArray.length; ++i) {
                nativeMouseWheelListenerArray[i].nativeMouseWheelMoved(nativeMouseWheelEvent);
            }
        }
    }

    protected static class NativeHookThread
    extends Thread {
        protected NativeHookException exception;

        public NativeHookThread() {
            this.setName("JNativeHook Hook Thread");
            this.setDaemon(false);
            this.setPriority(10);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            this.exception = null;
            try {
                this.enable();
            }
            catch (NativeHookException nativeHookException) {
                this.exception = nativeHookException;
            }
            NativeHookThread nativeHookThread = this;
            synchronized (nativeHookThread) {
                this.notifyAll();
            }
        }

        public NativeHookException getException() {
            return this.exception;
        }

        protected native void enable() throws NativeHookException;

        public native void disable() throws NativeHookException;

        protected static void dispatchEvent(NativeInputEvent nativeInputEvent) {
            if (eventExecutor != null) {
                eventExecutor.execute((Runnable)new EventDispatchTask(nativeInputEvent));
            }
        }
    }
}

