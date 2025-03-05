/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.MatchResult
 */
package org.openjdk.nashorn.internal.runtime.regexp;

import java.util.regex.MatchResult;

public interface RegExpMatcher
extends MatchResult {
    public boolean search(int var1);

    public String getInput();
}

