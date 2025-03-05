/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.stuxuhai.jpinyin.PinyinException
 *  com.github.stuxuhai.jpinyin.PinyinFormat
 *  com.github.stuxuhai.jpinyin.PinyinHelper
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.extra.pinyin.engine.jpinyin;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.extra.pinyin.PinyinEngine;
import cn.hutool.extra.pinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class JPinyinEngine
implements PinyinEngine {
    PinyinFormat format;

    public JPinyinEngine() {
        this(null);
    }

    public JPinyinEngine(PinyinFormat format) {
        this.init(format);
    }

    public void init(PinyinFormat format) {
        if (null == format) {
            format = PinyinFormat.WITHOUT_TONE;
        }
        this.format = format;
    }

    @Override
    public String getPinyin(char c) {
        String[] results = PinyinHelper.convertToPinyinArray((char)c, (PinyinFormat)this.format);
        return ArrayUtil.isEmpty(results) ? String.valueOf((char)c) : results[0];
    }

    @Override
    public String getPinyin(String str, String separator) {
        try {
            return PinyinHelper.convertToPinyinString((String)str, (String)separator, (PinyinFormat)this.format);
        }
        catch (com.github.stuxuhai.jpinyin.PinyinException e) {
            throw new PinyinException(e);
        }
    }
}

