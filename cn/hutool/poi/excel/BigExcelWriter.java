/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  org.apache.poi.ss.usermodel.Sheet
 *  org.apache.poi.ss.usermodel.Workbook
 *  org.apache.poi.xssf.streaming.SXSSFSheet
 *  org.apache.poi.xssf.streaming.SXSSFWorkbook
 */
package cn.hutool.poi.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.WorkbookUtil;
import java.io.File;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class BigExcelWriter
extends ExcelWriter {
    public static final int DEFAULT_WINDOW_SIZE = 100;
    private boolean isFlushed;

    public BigExcelWriter() {
        this(100);
    }

    public BigExcelWriter(int rowAccessWindowSize) {
        this(WorkbookUtil.createSXSSFBook(rowAccessWindowSize), null);
    }

    public BigExcelWriter(int rowAccessWindowSize, boolean compressTmpFiles, boolean useSharedStringsTable, String sheetName) {
        this(WorkbookUtil.createSXSSFBook(rowAccessWindowSize, compressTmpFiles, useSharedStringsTable), sheetName);
    }

    public BigExcelWriter(String destFilePath) {
        this(destFilePath, null);
    }

    public BigExcelWriter(int rowAccessWindowSize, String sheetName) {
        this(WorkbookUtil.createSXSSFBook(rowAccessWindowSize), sheetName);
    }

    public BigExcelWriter(String destFilePath, String sheetName) {
        this(FileUtil.file(destFilePath), sheetName);
    }

    public BigExcelWriter(File destFile) {
        this(destFile, null);
    }

    public BigExcelWriter(File destFile, String sheetName) {
        this(destFile.exists() ? WorkbookUtil.createSXSSFBook(destFile) : WorkbookUtil.createSXSSFBook(), sheetName);
        this.destFile = destFile;
    }

    public BigExcelWriter(SXSSFWorkbook workbook, String sheetName) {
        this(WorkbookUtil.getOrCreateSheet((Workbook)workbook, sheetName));
    }

    public BigExcelWriter(Sheet sheet) {
        super(sheet);
    }

    @Override
    public BigExcelWriter autoSizeColumn(int columnIndex) {
        SXSSFSheet sheet = (SXSSFSheet)this.sheet;
        sheet.trackColumnForAutoSizing(columnIndex);
        super.autoSizeColumn(columnIndex);
        sheet.untrackColumnForAutoSizing(columnIndex);
        return this;
    }

    @Override
    public BigExcelWriter autoSizeColumnAll() {
        SXSSFSheet sheet = (SXSSFSheet)this.sheet;
        sheet.trackAllColumnsForAutoSizing();
        super.autoSizeColumnAll();
        sheet.untrackAllColumnsForAutoSizing();
        return this;
    }

    @Override
    public ExcelWriter flush(OutputStream out, boolean isCloseOut) throws IORuntimeException {
        if (!this.isFlushed) {
            this.isFlushed = true;
            return super.flush(out, isCloseOut);
        }
        return this;
    }

    @Override
    public void close() {
        if (null != this.destFile && !this.isFlushed) {
            this.flush();
        }
        ((SXSSFWorkbook)this.workbook).dispose();
        super.closeWithoutFlush();
    }
}

