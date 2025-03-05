/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  org.ansj.splitWord.Analysis
 *  org.ansj.splitWord.analysis.ToAnalysis
 */
package cn.hutool.extra.tokenizer.engine.ansj;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.engine.ansj.AnsjResult;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.ToAnalysis;

public class AnsjEngine
implements TokenizerEngine {
    private final Analysis analysis;

    public AnsjEngine() {
        this((Analysis)new ToAnalysis());
    }

    public AnsjEngine(Analysis analysis) {
        this.analysis = analysis;
    }

    @Override
    public Result parse(CharSequence text) {
        return new AnsjResult(this.analysis.parseStr(StrUtil.str(text)));
    }
}

