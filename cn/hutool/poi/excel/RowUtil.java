/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Short
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.stream.Collectors
 *  java.util.stream.IntStream
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.Row
 *  org.apache.poi.ss.usermodel.Sheet
 *  org.apache.poi.ss.util.CellRangeAddress
 *  org.apache.poi.ss.util.CellRangeUtil
 */
package cn.hutool.poi.excel;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.StyleSet;
import cn.hutool.poi.excel.cell.CellEditor;
import cn.hutool.poi.excel.cell.CellUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeUtil;

public class RowUtil {
    public static Row getOrCreateRow(Sheet sheet, int rowIndex) {
        Row row = sheet.getRow(rowIndex);
        if (null == row) {
            row = sheet.createRow(rowIndex);
        }
        return row;
    }

    public static List<Object> readRow(Row row, CellEditor cellEditor) {
        return RowUtil.readRow(row, 0, Short.MAX_VALUE, cellEditor);
    }

    public static List<Object> readRow(Row row, int startCellNumInclude, int endCellNumInclude, CellEditor cellEditor) {
        if (null == row) {
            return new ArrayList(0);
        }
        short rowLength = row.getLastCellNum();
        if (rowLength < 0) {
            return ListUtil.empty();
        }
        int size = Math.min((int)(endCellNumInclude + 1), (int)rowLength);
        ArrayList cellValues = new ArrayList(size);
        boolean isAllNull = true;
        for (int i = startCellNumInclude; i < size; ++i) {
            Object cellValue = CellUtil.getCellValue(CellUtil.getCell(row, i), cellEditor);
            isAllNull &= StrUtil.isEmptyIfStr(cellValue);
            cellValues.add(cellValue);
        }
        if (isAllNull) {
            return ListUtil.empty();
        }
        return cellValues;
    }

    public static void writeRow(Row row, Iterable<?> rowData) {
        RowUtil.writeRow(row, rowData, null, false);
    }

    public static void writeRow(Row row, Iterable<?> rowData, StyleSet styleSet, boolean isHeader) {
        int i = 0;
        for (Object value : rowData) {
            Cell cell = row.createCell(i);
            CellUtil.setCellValue(cell, value, styleSet, isHeader);
            ++i;
        }
    }

    public static void insertRow(Sheet sheet, int startRow, int insertNumber) {
        if (insertNumber <= 0) {
            return;
        }
        Row sourceRow = RowUtil.getOrCreateRow(sheet, startRow);
        sheet.shiftRows(startRow, sheet.getLastRowNum(), insertNumber, true, false);
        IntStream.range((int)startRow, (int)(startRow + insertNumber)).forEachOrdered(i -> {
            Row row = sheet.createRow(i);
            row.setHeightInPoints(sourceRow.getHeightInPoints());
            short lastCellNum = sourceRow.getLastCellNum();
            IntStream.range((int)0, (int)lastCellNum).forEachOrdered(j -> {
                Cell cell = row.createCell(j);
                cell.setCellStyle(sourceRow.getCell(j).getCellStyle());
            });
        });
    }

    public static void removeRow(Row row) {
        Row removingRow;
        if (row == null) {
            return;
        }
        int rowIndex = row.getRowNum();
        Sheet sheet = row.getSheet();
        int lastRow = sheet.getLastRowNum();
        if (rowIndex >= 0 && rowIndex < lastRow) {
            ArrayList updateMergedRegions = new ArrayList();
            IntStream.range((int)0, (int)sheet.getNumMergedRegions()).forEach(arg_0 -> RowUtil.lambda$removeRow$2(sheet, rowIndex, (List)updateMergedRegions, arg_0));
            sheet.shiftRows(rowIndex + 1, lastRow, -1);
            List removeMergedRegions = (List)IntStream.range((int)0, (int)sheet.getNumMergedRegions()).filter(arg_0 -> RowUtil.lambda$removeRow$4((List)updateMergedRegions, sheet, arg_0)).boxed().collect(Collectors.toList());
            sheet.removeMergedRegions((Collection)removeMergedRegions);
            updateMergedRegions.forEach(mr -> {
                mr.setLastRow(mr.getLastRow() - 1);
                sheet.addMergedRegion(mr);
            });
            sheet.validateMergedRegions();
        }
        if (rowIndex == lastRow && (removingRow = sheet.getRow(rowIndex)) != null) {
            sheet.removeRow(removingRow);
        }
    }

    private static /* synthetic */ boolean lambda$removeRow$4(List updateMergedRegions, Sheet sheet, int i) {
        return updateMergedRegions.stream().anyMatch(umr -> CellRangeUtil.contains((CellRangeAddress)umr, (CellRangeAddress)sheet.getMergedRegion(i)));
    }

    private static /* synthetic */ void lambda$removeRow$2(Sheet sheet, int rowIndex, List updateMergedRegions, int i) {
        CellRangeAddress mr = sheet.getMergedRegion(i);
        if (!mr.containsRow(rowIndex)) {
            return;
        }
        if (mr.getFirstRow() == mr.getLastRow() - 1 && mr.getFirstColumn() == mr.getLastColumn()) {
            return;
        }
        updateMergedRegions.add((Object)mr);
    }
}

