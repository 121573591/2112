/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package cn.hutool.core.date.chinese;

import cn.hutool.core.date.chinese.LunarInfo;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.map.TableMap;
import java.util.List;

public class LunarFestival {
    private static final TableMap<Pair<Integer, Integer>, String> L_FTV = new TableMap(16);

    public static List<String> getFestivals(int year, int month, int day) {
        if (12 == month && 29 == day && 29 == LunarInfo.monthDays(year, month)) {
            ++day;
        }
        return LunarFestival.getFestivals(month, day);
    }

    public static List<String> getFestivals(int month, int day) {
        return L_FTV.getValues(new Pair<Integer, Integer>(month, day));
    }

    static {
        L_FTV.put(new Pair<Integer, Integer>(1, 1), "春节");
        L_FTV.put(new Pair<Integer, Integer>(1, 2), "犬日");
        L_FTV.put(new Pair<Integer, Integer>(1, 3), "猪日");
        L_FTV.put(new Pair<Integer, Integer>(1, 4), "羊日");
        L_FTV.put(new Pair<Integer, Integer>(1, 5), "牛日 破五日");
        L_FTV.put(new Pair<Integer, Integer>(1, 6), "马日 送穷日");
        L_FTV.put(new Pair<Integer, Integer>(1, 7), "人日 人胜节");
        L_FTV.put(new Pair<Integer, Integer>(1, 8), "谷日 八仙日");
        L_FTV.put(new Pair<Integer, Integer>(1, 9), "天日 九皇会");
        L_FTV.put(new Pair<Integer, Integer>(1, 10), "地日 石头生日");
        L_FTV.put(new Pair<Integer, Integer>(1, 12), "火日 老鼠娶媳妇日");
        L_FTV.put(new Pair<Integer, Integer>(1, 13), "上（试）灯日 关公升天日");
        L_FTV.put(new Pair<Integer, Integer>(1, 15), "元宵节 上元节");
        L_FTV.put(new Pair<Integer, Integer>(1, 18), "落灯日");
        L_FTV.put(new Pair<Integer, Integer>(2, 1), "中和节 太阳生日");
        L_FTV.put(new Pair<Integer, Integer>(2, 2), "龙抬头");
        L_FTV.put(new Pair<Integer, Integer>(2, 12), "花朝节");
        L_FTV.put(new Pair<Integer, Integer>(2, 19), "观世音圣诞");
        L_FTV.put(new Pair<Integer, Integer>(3, 3), "上巳节");
        L_FTV.put(new Pair<Integer, Integer>(4, 1), "祭雹神");
        L_FTV.put(new Pair<Integer, Integer>(4, 4), "文殊菩萨诞辰");
        L_FTV.put(new Pair<Integer, Integer>(4, 8), "佛诞节");
        L_FTV.put(new Pair<Integer, Integer>(5, 5), "端午节 端阳节");
        L_FTV.put(new Pair<Integer, Integer>(6, 6), "晒衣节 姑姑节");
        L_FTV.put(new Pair<Integer, Integer>(6, 6), "天贶节");
        L_FTV.put(new Pair<Integer, Integer>(6, 24), "彝族火把节");
        L_FTV.put(new Pair<Integer, Integer>(7, 7), "七夕");
        L_FTV.put(new Pair<Integer, Integer>(7, 14), "鬼节(南方)");
        L_FTV.put(new Pair<Integer, Integer>(7, 15), "中元节");
        L_FTV.put(new Pair<Integer, Integer>(7, 15), "盂兰盆节 中元节");
        L_FTV.put(new Pair<Integer, Integer>(7, 30), "地藏节");
        L_FTV.put(new Pair<Integer, Integer>(8, 15), "中秋节");
        L_FTV.put(new Pair<Integer, Integer>(9, 9), "重阳节");
        L_FTV.put(new Pair<Integer, Integer>(10, 1), "祭祖节");
        L_FTV.put(new Pair<Integer, Integer>(10, 15), "下元节");
        L_FTV.put(new Pair<Integer, Integer>(11, 17), "阿弥陀佛圣诞");
        L_FTV.put(new Pair<Integer, Integer>(12, 8), "腊八节");
        L_FTV.put(new Pair<Integer, Integer>(12, 16), "尾牙");
        L_FTV.put(new Pair<Integer, Integer>(12, 23), "小年");
        L_FTV.put(new Pair<Integer, Integer>(12, 30), "除夕");
    }
}

