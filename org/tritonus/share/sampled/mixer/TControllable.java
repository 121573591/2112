/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tritonus.share.sampled.mixer;

import org.tritonus.share.sampled.mixer.TCompoundControl;

public interface TControllable {
    public void setParentControl(TCompoundControl var1);

    public TCompoundControl getParentControl();

    public void commit();
}

