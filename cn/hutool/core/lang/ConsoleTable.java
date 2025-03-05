/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 */
package cn.hutool.core.lang;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConsoleTable {
    private static final char ROW_LINE = '\uff0d';
    private static final char COLUMN_LINE = '|';
    private static final char CORNER = '+';
    private static final char SPACE = '\u3000';
    private static final char LF = '\n';
    private boolean isSBCMode = true;
    private final List<List<String>> headerList = new ArrayList();
    private final List<List<String>> bodyList = new ArrayList();
    private List<Integer> columnCharNumber;

    public static ConsoleTable create() {
        return new ConsoleTable();
    }

    public ConsoleTable setSBCMode(boolean isSBCMode) {
        this.isSBCMode = isSBCMode;
        return this;
    }

    public ConsoleTable addHeader(String ... titles) {
        if (this.columnCharNumber == null) {
            this.columnCharNumber = new ArrayList((Collection)Collections.nCopies((int)titles.length, (Object)0));
        }
        ArrayList l = new ArrayList();
        this.fillColumns((List<String>)l, titles);
        this.headerList.add((Object)l);
        return this;
    }

    public ConsoleTable addBody(String ... values) {
        ArrayList l = new ArrayList();
        this.bodyList.add((Object)l);
        this.fillColumns((List<String>)l, values);
        return this;
    }

    private void fillColumns(List<String> l, String[] columns) {
        for (int i = 0; i < columns.length; ++i) {
            String column = StrUtil.toString(columns[i]);
            if (this.isSBCMode) {
                column = Convert.toSBC(column);
            }
            l.add((Object)column);
            int width = column.length();
            if (width <= (Integer)this.columnCharNumber.get(i)) continue;
            this.columnCharNumber.set(i, (Object)width);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.fillBorder(sb);
        this.fillRows(sb, this.headerList);
        this.fillBorder(sb);
        this.fillRows(sb, this.bodyList);
        this.fillBorder(sb);
        return sb.toString();
    }

    private void fillRows(StringBuilder sb, List<List<String>> list) {
        for (List row : list) {
            sb.append('|');
            this.fillRow(sb, (List<String>)row);
            sb.append('\n');
        }
    }

    private void fillRow(StringBuilder sb, List<String> row) {
        int size = row.size();
        for (int i = 0; i < size; ++i) {
            String value = (String)row.get(i);
            sb.append('\u3000');
            sb.append(value);
            int length = value.length();
            int sbcCount = this.sbcCount(value);
            if (sbcCount % 2 == 1) {
                sb.append(' ');
            }
            sb.append('\u3000');
            int maxLength = (Integer)this.columnCharNumber.get(i);
            for (int j = 0; j < maxLength - length + sbcCount / 2; ++j) {
                sb.append('\u3000');
            }
            sb.append('|');
        }
    }

    private void fillBorder(StringBuilder sb) {
        sb.append('+');
        for (Integer width : this.columnCharNumber) {
            sb.append(StrUtil.repeat('\uff0d', width + 2));
            sb.append('+');
        }
        sb.append('\n');
    }

    public void print() {
        Console.print(this.toString());
    }

    private int sbcCount(String value) {
        int count = 0;
        for (int i = 0; i < value.length(); ++i) {
            if (value.charAt(i) >= '') continue;
            ++count;
        }
        return count;
    }
}

