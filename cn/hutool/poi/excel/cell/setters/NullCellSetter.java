/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  org.apache.poi.ss.usermodel.Cell
 */
package cn.hutool.poi.excel.cell.setters;

import cn.hutool.poi.excel.cell.CellSetter;
import org.apache.poi.ss.usermodel.Cell;

public class NullCellSetter
implements CellSetter {
    public static final NullCellSetter INSTANCE = new NullCellSetter();

    @Override
    public void setValue(Cell cell) {
        cell.setCellValue("");
    }
}

