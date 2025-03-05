/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  org.wltea.analyzer.core.Lexeme
 */
package cn.hutool.extra.tokenizer.engine.ikanalyzer;

import cn.hutool.extra.tokenizer.Word;
import org.wltea.analyzer.core.Lexeme;

public class IKAnalyzerWord
implements Word {
    private static final long serialVersionUID = 1L;
    private final Lexeme word;

    public IKAnalyzerWord(Lexeme word) {
        this.word = word;
    }

    @Override
    public String getText() {
        return this.word.getLexemeText();
    }

    @Override
    public int getStartOffset() {
        return this.word.getBeginPosition();
    }

    @Override
    public int getEndOffset() {
        return this.word.getEndPosition();
    }

    public String toString() {
        return this.getText();
    }
}

