/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InterruptedIOException
 *  java.io.OutputStream
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Objects
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 */
package org.apache.commons.io.output;

import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.io.input.QueueInputStream;

public class QueueOutputStream
extends OutputStream {
    private final BlockingQueue<Integer> blockingQueue;

    public QueueOutputStream() {
        this((BlockingQueue<Integer>)new LinkedBlockingQueue());
    }

    public QueueOutputStream(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = (BlockingQueue)Objects.requireNonNull(blockingQueue, (String)"blockingQueue");
    }

    public QueueInputStream newQueueInputStream() {
        return new QueueInputStream(this.blockingQueue);
    }

    public void write(int b) throws InterruptedIOException {
        try {
            this.blockingQueue.put((Object)(0xFF & b));
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            InterruptedIOException interruptedIoException = new InterruptedIOException();
            interruptedIoException.initCause((Throwable)e);
            throw interruptedIoException;
        }
    }
}

