/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 *  org.apache.poi.ss.extractor.ExcelExtractor
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.Row
 *  org.apache.poi.ss.usermodel.Sheet
 *  org.apache.poi.ss.usermodel.Workbook
 */
package cn.hutool.poi.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.poi.excel.ExcelBase;
import cn.hutool.poi.excel.ExcelExtractorUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.RowUtil;
import cn.hutool.poi.excel.WorkbookUtil;
import cn.hutool.poi.excel.cell.CellEditor;
import cn.hutool.poi.excel.cell.CellHandler;
import cn.hutool.poi.excel.cell.CellUtil;
import cn.hutool.poi.excel.reader.BeanSheetReader;
import cn.hutool.poi.excel.reader.ColumnSheetReader;
import cn.hutool.poi.excel.reader.ListSheetReader;
import cn.hutool.poi.excel.reader.MapSheetReader;
import cn.hutool.poi.excel.reader.SheetReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader
extends ExcelBase<ExcelReader> {
    private boolean ignoreEmptyRow = true;
    private CellEditor cellEditor;

    public ExcelReader(String excelFilePath, int sheetIndex) {
        this(FileUtil.file(excelFilePath), sheetIndex);
    }

    public ExcelReader(String excelFilePath, String sheetName) {
        this(FileUtil.file(excelFilePath), sheetName);
    }

    public ExcelReader(File bookFile, int sheetIndex) {
        this(WorkbookUtil.createBook(bookFile, true), sheetIndex);
        this.destFile = bookFile;
    }

    public ExcelReader(File bookFile, String sheetName) {
        this(WorkbookUtil.createBook(bookFile, true), sheetName);
        this.destFile = bookFile;
    }

    public ExcelReader(InputStream bookStream, int sheetIndex) {
        this(WorkbookUtil.createBook(bookStream), sheetIndex);
    }

    public ExcelReader(InputStream bookStream, String sheetName) {
        this(WorkbookUtil.createBook(bookStream), sheetName);
    }

    public ExcelReader(Workbook book, int sheetIndex) {
        this(ExcelReader.getSheetOrCloseWorkbook(book, sheetIndex));
    }

    public ExcelReader(Workbook book, String sheetName) {
        this(ExcelReader.getSheetOrCloseWorkbook(book, sheetName));
    }

    public ExcelReader(Sheet sheet) {
        super(sheet);
    }

    public boolean isIgnoreEmptyRow() {
        return this.ignoreEmptyRow;
    }

    public ExcelReader setIgnoreEmptyRow(boolean ignoreEmptyRow) {
        this.ignoreEmptyRow = ignoreEmptyRow;
        return this;
    }

    public ExcelReader setCellEditor(CellEditor cellEditor) {
        this.cellEditor = cellEditor;
        return this;
    }

    public List<List<Object>> read() {
        return this.read(0);
    }

    public List<List<Object>> read(int startRowIndex) {
        return this.read(startRowIndex, Integer.MAX_VALUE);
    }

    public List<List<Object>> read(int startRowIndex, int endRowIndex) {
        return this.read(startRowIndex, endRowIndex, true);
    }

    public List<List<Object>> read(int startRowIndex, int endRowIndex, boolean aliasFirstLine) {
        ListSheetReader reader = new ListSheetReader(startRowIndex, endRowIndex, aliasFirstLine);
        reader.setCellEditor(this.cellEditor);
        reader.setIgnoreEmptyRow(this.ignoreEmptyRow);
        reader.setHeaderAlias((Map<String, String>)this.headerAlias);
        return this.read(reader);
    }

    public List<Object> readColumn(int columnIndex, int startRowIndex) {
        return this.readColumn(columnIndex, startRowIndex, Integer.MAX_VALUE);
    }

    public List<Object> readColumn(int columnIndex, int startRowIndex, int endRowIndex) {
        ColumnSheetReader reader = new ColumnSheetReader(columnIndex, startRowIndex, endRowIndex);
        reader.setCellEditor(this.cellEditor);
        reader.setIgnoreEmptyRow(this.ignoreEmptyRow);
        reader.setHeaderAlias((Map<String, String>)this.headerAlias);
        return this.read(reader);
    }

    public void read(CellHandler cellHandler) {
        this.read(0, Integer.MAX_VALUE, cellHandler);
    }

    public void read(int startRowIndex, int endRowIndex, CellHandler cellHandler) {
        this.checkNotClosed();
        startRowIndex = Math.max((int)startRowIndex, (int)this.sheet.getFirstRowNum());
        endRowIndex = Math.min((int)endRowIndex, (int)this.sheet.getLastRowNum());
        for (int y = startRowIndex; y <= endRowIndex; ++y) {
            Row row = this.sheet.getRow(y);
            if (null == row) continue;
            short columnSize = row.getLastCellNum();
            for (short x = 0; x < columnSize; x = (short)(x + 1)) {
                Cell cell = row.getCell((int)x);
                cellHandler.handle(cell, CellUtil.getCellValue(cell));
            }
        }
    }

    public List<Map<String, Object>> readAll() {
        return this.read(0, 1, Integer.MAX_VALUE);
    }

    public List<Map<String, Object>> read(int headerRowIndex, int startRowIndex, int endRowIndex) {
        MapSheetReader reader = new MapSheetReader(headerRowIndex, startRowIndex, endRowIndex);
        reader.setCellEditor(this.cellEditor);
        reader.setIgnoreEmptyRow(this.ignoreEmptyRow);
        reader.setHeaderAlias((Map<String, String>)this.headerAlias);
        return this.read(reader);
    }

    public <T> List<T> readAll(Class<T> beanType) {
        return this.read(0, 1, Integer.MAX_VALUE, beanType);
    }

    public <T> List<T> read(int headerRowIndex, int startRowIndex, Class<T> beanType) {
        return this.read(headerRowIndex, startRowIndex, Integer.MAX_VALUE, beanType);
    }

    public <T> List<T> read(int headerRowIndex, int startRowIndex, int endRowIndex, Class<T> beanType) {
        BeanSheetReader<T> reader = new BeanSheetReader<T>(headerRowIndex, startRowIndex, endRowIndex, beanType);
        reader.setCellEditor(this.cellEditor);
        reader.setIgnoreEmptyRow(this.ignoreEmptyRow);
        reader.setHeaderAlias((Map<String, String>)this.headerAlias);
        return (List)this.read(reader);
    }

    public <T> T read(SheetReader<T> sheetReader) {
        this.checkNotClosed();
        return Assert.notNull(sheetReader).read(this.sheet);
    }

    public String readAsText(boolean withSheetName) {
        return ExcelExtractorUtil.readAsText(this.workbook, withSheetName);
    }

    public ExcelExtractor getExtractor() {
        return ExcelExtractorUtil.getExtractor(this.workbook);
    }

    public List<Object> readRow(int rowIndex) {
        return this.readRow(this.sheet.getRow(rowIndex));
    }

    public Object readCellValue(int x, int y) {
        return CellUtil.getCellValue(this.getCell(x, y), this.cellEditor);
    }

    public ExcelWriter getWriter() {
        if (null == this.destFile) {
            return new ExcelWriter(this.sheet);
        }
        return ExcelUtil.getWriter(this.destFile, this.sheet.getSheetName());
    }

    private List<Object> readRow(Row row) {
        return RowUtil.readRow(row, this.cellEditor);
    }

    private void checkNotClosed() {
        Assert.isFalse(this.isClosed, "ExcelReader has been closed!", new Object[0]);
    }

    private static Sheet getSheetOrCloseWorkbook(Workbook workbook, String name) throws IllegalArgumentException {
        Sheet sheet;
        Assert.notNull(workbook);
        if (null == name) {
            name = "sheet1";
        }
        if (null == (sheet = workbook.getSheet(name))) {
            IoUtil.close((Closeable)workbook);
            throw new IllegalArgumentException("Sheet [" + name + "] not exist!");
        }
        return sheet;
    }

    private static Sheet getSheetOrCloseWorkbook(Workbook workbook, int sheetIndex) throws IllegalArgumentException {
        Sheet sheet;
        Assert.notNull(workbook);
        try {
            sheet = workbook.getSheetAt(sheetIndex);
        }
        catch (IllegalArgumentException e) {
            IoUtil.close((Closeable)workbook);
            throw e;
        }
        if (null == sheet) {
            IoUtil.close((Closeable)workbook);
            throw new IllegalArgumentException("Sheet at [" + sheetIndex + "] not exist!");
        }
        return sheet;
    }
}

