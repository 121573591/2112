/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  javax.swing.ListModel
 */
package junit.swingui;

import javax.swing.ListModel;
import junit.framework.Test;

public interface TestRunContext {
    public void handleTestSelected(Test var1);

    public ListModel getFailures();
}

