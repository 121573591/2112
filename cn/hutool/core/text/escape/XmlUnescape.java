/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.core.text.escape;

import cn.hutool.core.text.escape.InternalEscapeUtil;
import cn.hutool.core.text.escape.NumericEntityUnescaper;
import cn.hutool.core.text.escape.XmlEscape;
import cn.hutool.core.text.replacer.LookupReplacer;
import cn.hutool.core.text.replacer.ReplacerChain;
import cn.hutool.core.text.replacer.StrReplacer;

public class XmlUnescape
extends ReplacerChain {
    private static final long serialVersionUID = 1L;
    protected static final String[][] BASIC_UNESCAPE = InternalEscapeUtil.invert(XmlEscape.BASIC_ESCAPE);
    protected static final String[][] OTHER_UNESCAPE = new String[][]{{"&apos;", "'"}};

    public XmlUnescape() {
        super(new StrReplacer[0]);
        this.addChain(new LookupReplacer(BASIC_UNESCAPE));
        this.addChain(new NumericEntityUnescaper());
        this.addChain(new LookupReplacer(OTHER_UNESCAPE));
    }
}

