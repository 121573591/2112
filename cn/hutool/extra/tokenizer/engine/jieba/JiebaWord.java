/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.huaban.analysis.jieba.SegToken
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.extra.tokenizer.engine.jieba;

import cn.hutool.extra.tokenizer.Word;
import com.huaban.analysis.jieba.SegToken;

public class JiebaWord
implements Word {
    private static final long serialVersionUID = 1L;
    private final SegToken segToken;

    public JiebaWord(SegToken segToken) {
        this.segToken = segToken;
    }

    @Override
    public String getText() {
        return this.segToken.word;
    }

    @Override
    public int getStartOffset() {
        return this.segToken.startOffset;
    }

    @Override
    public int getEndOffset() {
        return this.segToken.endOffset;
    }

    public String toString() {
        return this.getText();
    }
}

