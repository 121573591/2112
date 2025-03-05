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

class ParserContextSwitchNode
extends ParserContextBaseNode
implements ParserContextBreakableNode {
    ParserContextSwitchNode() {
    }

    @Override
    public boolean isBreakableWithoutLabel() {
        return true;
    }
}

