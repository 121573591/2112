/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package org.openjdk.nashorn.internal.parser;

import org.openjdk.nashorn.internal.parser.ParserContextBaseNode;
import org.openjdk.nashorn.internal.parser.ParserContextBreakableNode;

class ParserContextBlockNode
extends ParserContextBaseNode
implements ParserContextBreakableNode {
    private final long token;

    public ParserContextBlockNode(long token) {
        this.token = token;
    }

    @Override
    public boolean isBreakableWithoutLabel() {
        return false;
    }

    public long getToken() {
        return this.token;
    }
}

