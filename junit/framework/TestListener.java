/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package junit.framework;

import junit.framework.AssertionFailedError;
import junit.framework.Test;

public interface TestListener {
    public void addError(Test var1, Throwable var2);

    public void addFailure(Test var1, AssertionFailedError var2);

    public void endTest(Test var1);

    public void startTest(Test var1);
}

