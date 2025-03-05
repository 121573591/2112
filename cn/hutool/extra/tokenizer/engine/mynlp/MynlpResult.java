/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mayabot.nlp.segment.Sentence
 *  com.mayabot.nlp.segment.WordTerm
 *  java.lang.Object
 *  java.util.Iterator
 */
package cn.hutool.extra.tokenizer.engine.mynlp;

import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.Word;
import cn.hutool.extra.tokenizer.engine.mynlp.MynlpWord;
import com.mayabot.nlp.segment.Sentence;
import com.mayabot.nlp.segment.WordTerm;
import java.util.Iterator;

public class MynlpResult
implements Result {
    private final Iterator<WordTerm> result;

    public MynlpResult(Sentence sentence) {
        this.result = sentence.iterator();
    }

    public boolean hasNext() {
        return this.result.hasNext();
    }

    public Word next() {
        return new MynlpWord((WordTerm)this.result.next());
    }

    public void remove() {
        this.result.remove();
    }
}

