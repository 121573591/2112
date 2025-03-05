/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 */
package cn.hutool.core.math;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrangement
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String[] datas;

    public Arrangement(String[] datas) {
        this.datas = datas;
    }

    public static long count(int n) {
        return Arrangement.count(n, n);
    }

    public static long count(int n, int m) {
        if (n == m) {
            return NumberUtil.factorial(n);
        }
        return n > m ? NumberUtil.factorial(n, n - m) : 0L;
    }

    public static long countAll(int n) {
        long total = 0L;
        for (int i = 1; i <= n; ++i) {
            total += Arrangement.count(n, i);
        }
        return total;
    }

    public List<String[]> select() {
        return this.select(this.datas.length);
    }

    public List<String[]> select(int m) {
        ArrayList result = new ArrayList((int)Arrangement.count(this.datas.length, m));
        this.select(this.datas, new String[m], 0, (List<String[]>)result);
        return result;
    }

    public List<String[]> selectAll() {
        ArrayList result = new ArrayList((int)Arrangement.countAll(this.datas.length));
        for (int i = 1; i <= this.datas.length; ++i) {
            result.addAll(this.select(i));
        }
        return result;
    }

    private void select(String[] datas, String[] resultList, int resultIndex, List<String[]> result) {
        if (resultIndex >= resultList.length) {
            if (!result.contains((Object)resultList)) {
                result.add((Object)Arrays.copyOf((Object[])resultList, (int)resultList.length));
            }
            return;
        }
        for (int i = 0; i < datas.length; ++i) {
            resultList[resultIndex] = datas[i];
            this.select(ArrayUtil.remove(datas, i), resultList, resultIndex + 1, result);
        }
    }
}

