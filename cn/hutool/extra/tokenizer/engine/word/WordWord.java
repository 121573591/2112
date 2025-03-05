/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  org.apdplat.word.segmentation.Word
 */
package cn.hutool.extra.tokenizer.engine.word;

import cn.hutool.extra.tokenizer.Word;

public class WordWord
implements Word {
    private static final long serialVersionUID = 1L;
    private final org.apdplat.word.segmentation.Word word;

    public WordWord(org.apdplat.word.segmentation.Word word) {
        this.word = word;
    }

    @Override
    public String getText() {
        return this.word.getText();
    }

    @Override
    public int getStartOffset() {
        return -1;
    }

    @Override
    public int getEndOffset() {
        return -1;
    }

    public String toString() {
        return this.getText();
    }
}

