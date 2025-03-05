/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.FormulaError
 */
package cn.hutool.poi.excel.cell.values;

import cn.hutool.poi.excel.cell.CellValue;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaError;

public class ErrorCellValue
implements CellValue<String> {
    private final Cell cell;

    public ErrorCellValue(Cell cell) {
        this.cell = cell;
    }

    @Override
    public String getValue() {
        FormulaError error = FormulaError.forInt((byte)this.cell.getErrorCellValue());
        return null == error ? "" : error.getString();
    }
}

