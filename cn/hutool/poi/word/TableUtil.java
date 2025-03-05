/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  org.apache.poi.xwpf.usermodel.XWPFDocument
 *  org.apache.poi.xwpf.usermodel.XWPFTable
 *  org.apache.poi.xwpf.usermodel.XWPFTableCell
 *  org.apache.poi.xwpf.usermodel.XWPFTableRow
 */
package cn.hutool.poi.word;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class TableUtil {
    public static XWPFTable createTable(XWPFDocument doc) {
        return TableUtil.createTable(doc, null);
    }

    public static XWPFTable createTable(XWPFDocument doc, Iterable<?> data) {
        Assert.notNull(doc, "XWPFDocument must be not null !", new Object[0]);
        XWPFTable table = doc.createTable();
        table.removeRow(0);
        return TableUtil.writeTable(table, data);
    }

    public static XWPFTable writeTable(XWPFTable table, Iterable<?> data) {
        Assert.notNull(table, "XWPFTable must be not null !", new Object[0]);
        if (IterUtil.isEmpty(data)) {
            return table;
        }
        boolean isFirst = true;
        for (Object rowData : data) {
            TableUtil.writeRow(table.createRow(), rowData, isFirst);
            if (!isFirst) continue;
            isFirst = false;
        }
        return table;
    }

    public static void writeRow(XWPFTableRow row, Object rowBean, boolean isWriteKeyAsHead) {
        Map<String, Object> rowMap;
        if (rowBean instanceof Iterable) {
            TableUtil.writeRow(row, (Iterable)rowBean);
            return;
        }
        if (rowBean instanceof Map) {
            rowMap = (Map<String, Object>)rowBean;
        } else if (BeanUtil.isBean(rowBean.getClass())) {
            rowMap = BeanUtil.beanToMap(rowBean, (Map<String, Object>)new LinkedHashMap(), false, false);
        } else {
            TableUtil.writeRow(row, CollUtil.newArrayList(rowBean), isWriteKeyAsHead);
            return;
        }
        TableUtil.writeRow(row, rowMap, isWriteKeyAsHead);
    }

    public static void writeRow(XWPFTableRow row, Map<?, ?> rowMap, boolean isWriteKeyAsHead) {
        if (MapUtil.isEmpty(rowMap)) {
            return;
        }
        if (isWriteKeyAsHead) {
            TableUtil.writeRow(row, rowMap.keySet());
            row = row.getTable().createRow();
        }
        TableUtil.writeRow(row, rowMap.values());
    }

    public static void writeRow(XWPFTableRow row, Iterable<?> rowData) {
        int index = 0;
        for (Object cellData : rowData) {
            XWPFTableCell cell = TableUtil.getOrCreateCell(row, index);
            cell.setText(Convert.toStr(cellData));
            ++index;
        }
    }

    public static XWPFTableRow getOrCreateRow(XWPFTable table, int index) {
        XWPFTableRow row = table.getRow(index);
        if (null == row) {
            row = table.createRow();
        }
        return row;
    }

    public static XWPFTableCell getOrCreateCell(XWPFTableRow row, int index) {
        XWPFTableCell cell = row.getCell(index);
        if (null == cell) {
            cell = row.createCell();
        }
        return cell;
    }
}

