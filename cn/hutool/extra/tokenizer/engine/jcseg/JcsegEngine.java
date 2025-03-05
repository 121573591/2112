/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  org.lionsoul.jcseg.ISegment
 *  org.lionsoul.jcseg.dic.ADictionary
 *  org.lionsoul.jcseg.dic.DictionaryFactory
 *  org.lionsoul.jcseg.segmenter.SegmenterConfig
 */
package cn.hutool.extra.tokenizer.engine.jcseg;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerException;
import cn.hutool.extra.tokenizer.engine.jcseg.JcsegResult;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.lionsoul.jcseg.ISegment;
import org.lionsoul.jcseg.dic.ADictionary;
import org.lionsoul.jcseg.dic.DictionaryFactory;
import org.lionsoul.jcseg.segmenter.SegmenterConfig;

public class JcsegEngine
implements TokenizerEngine {
    private final ISegment segment;

    public JcsegEngine() {
        SegmenterConfig config = new SegmenterConfig(true);
        ADictionary dic = DictionaryFactory.createSingletonDictionary((SegmenterConfig)config);
        this.segment = ISegment.COMPLEX.factory.create(config, dic);
    }

    public JcsegEngine(ISegment segment) {
        this.segment = segment;
    }

    @Override
    public Result parse(CharSequence text) {
        try {
            this.segment.reset((Reader)new StringReader(StrUtil.str(text)));
        }
        catch (IOException e) {
            throw new TokenizerException(e);
        }
        return new JcsegResult(this.segment);
    }
}

