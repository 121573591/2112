/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.promeg.pinyinhelper.Pinyin
 *  com.github.promeg.pinyinhelper.Pinyin$Config
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.extra.pinyin.engine.tinypinyin;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.pinyin.PinyinEngine;
import com.github.promeg.pinyinhelper.Pinyin;

public class TinyPinyinEngine
implements PinyinEngine {
    public TinyPinyinEngine() {
        this(null);
    }

    public TinyPinyinEngine(Pinyin.Config config) {
        Pinyin.init((Pinyin.Config)config);
    }

    @Override
    public String getPinyin(char c) {
        if (!Pinyin.isChinese((char)c)) {
            return String.valueOf((char)c);
        }
        return Pinyin.toPinyin((char)c).toLowerCase();
    }

    @Override
    public String getPinyin(String str, String separator) {
        String pinyin = Pinyin.toPinyin((String)str, (String)separator);
        return StrUtil.isEmpty(pinyin) ? pinyin : pinyin.toLowerCase();
    }
}

