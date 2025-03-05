/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.extra.tokenizer;

import cn.hutool.core.collection.ComputeIter;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.Word;

public abstract class AbstractResult
extends ComputeIter<Word>
implements Result {
    protected abstract Word nextWord();

    @Override
    protected Word computeNext() {
        return this.nextWord();
    }
}

