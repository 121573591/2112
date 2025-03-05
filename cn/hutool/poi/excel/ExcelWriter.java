/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeMap
 *  java.util.concurrent.atomic.AtomicInteger
 *  org.apache.poi.common.usermodel.Hyperlink
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.CellStyle
 *  org.apache.poi.ss.usermodel.ClientAnchor
 *  org.apache.poi.ss.usermodel.DataValidation
 *  org.apache.poi.ss.usermodel.DataValidationConstraint
 *  org.apache.poi.ss.usermodel.DataValidationHelper
 *  org.apache.poi.ss.usermodel.Drawing
 *  org.apache.poi.ss.usermodel.Font
 *  org.apache.poi.ss.usermodel.Footer
 *  org.apache.poi.ss.usermodel.Row
 *  org.apache.poi.ss.usermodel.Sheet
 *  org.apache.poi.ss.usermodel.Workbook
 *  org.apache.poi.ss.util.CellRangeAddressList
 *  org.apache.poi.xssf.usermodel.XSSFDataValidation
 */
package cn.hutool.poi.excel;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.comparator.IndexedComparator;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.map.SafeConcurrentHashMap;
import cn.hutool.core.map.TableMap;
import cn.hutool.core.map.multi.RowKeyTable;
import cn.hutool.core.map.multi.Table;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.poi.excel.ExcelBase;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.RowUtil;
import cn.hutool.poi.excel.StyleSet;
import cn.hutool.poi.excel.WorkbookUtil;
import cn.hutool.poi.excel.cell.CellLocation;
import cn.hutool.poi.excel.cell.CellUtil;
import cn.hutool.poi.excel.style.Align;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;

public class ExcelWriter
extends ExcelBase<ExcelWriter> {
    private final AtomicInteger currentRow;
    private boolean onlyAlias;
    private Comparator<String> aliasComparator;
    private StyleSet styleSet;
    private Map<String, Integer> headLocationCache;

    public ExcelWriter() {
        this(false);
    }

    public ExcelWriter(boolean isXlsx) {
        this(WorkbookUtil.createBook(isXlsx), null);
    }

    public ExcelWriter(String destFilePath) {
        this(destFilePath, null);
    }

    public ExcelWriter(boolean isXlsx, String sheetName) {
        this(WorkbookUtil.createBook(isXlsx), sheetName);
    }

    public ExcelWriter(String destFilePath, String sheetName) {
        this(FileUtil.file(destFilePath), sheetName);
    }

    public ExcelWriter(File destFile) {
        this(destFile, null);
    }

    public ExcelWriter(File destFile, String sheetName) {
        this(WorkbookUtil.createBookForWriter(destFile), sheetName);
        this.destFile = destFile;
    }

    public ExcelWriter(Workbook workbook, String sheetName) {
        this(WorkbookUtil.getOrCreateSheet(workbook, sheetName));
    }

    public ExcelWriter(Sheet sheet) {
        super(sheet);
        this.styleSet = new StyleSet(this.workbook);
        this.currentRow = new AtomicInteger(0);
    }

    @Override
    public ExcelWriter setSheet(int sheetIndex) {
        this.reset();
        return (ExcelWriter)super.setSheet(sheetIndex);
    }

    @Override
    public ExcelWriter setSheet(String sheetName) {
        this.reset();
        return (ExcelWriter)super.setSheet(sheetName);
    }

    public ExcelWriter reset() {
        this.resetRow();
        return this;
    }

    @Override
    public ExcelWriter renameSheet(String sheetName) {
        return this.renameSheet(this.workbook.getSheetIndex(this.sheet), sheetName);
    }

    public ExcelWriter renameSheet(int sheet, String sheetName) {
        this.workbook.setSheetName(sheet, sheetName);
        return this;
    }

    public ExcelWriter autoSizeColumnAll() {
        int columnCount = this.getColumnCount();
        for (int i = 0; i < columnCount; ++i) {
            this.autoSizeColumn(i);
        }
        return this;
    }

    public ExcelWriter autoSizeColumn(int columnIndex) {
        this.sheet.autoSizeColumn(columnIndex);
        return this;
    }

    public ExcelWriter autoSizeColumn(int columnIndex, boolean useMergedCells) {
        this.sheet.autoSizeColumn(columnIndex, useMergedCells);
        return this;
    }

    public ExcelWriter disableDefaultStyle() {
        return this.setStyleSet(null);
    }

    public ExcelWriter setStyleSet(StyleSet styleSet) {
        this.styleSet = styleSet;
        return this;
    }

    public StyleSet getStyleSet() {
        return this.styleSet;
    }

    public CellStyle getHeadCellStyle() {
        return this.styleSet.headCellStyle;
    }

    public CellStyle getCellStyle() {
        if (null == this.styleSet) {
            return null;
        }
        return this.styleSet.cellStyle;
    }

    public int getCurrentRow() {
        return this.currentRow.get();
    }

    public String getDisposition(String fileName, Charset charset) {
        if (null == charset) {
            charset = CharsetUtil.CHARSET_UTF_8;
        }
        if (StrUtil.isBlank(fileName)) {
            fileName = IdUtil.fastSimpleUUID();
        }
        fileName = StrUtil.addSuffixIfNot(URLUtil.encodeAll(fileName, charset), this.isXlsx() ? ".xlsx" : ".xls");
        return StrUtil.format("attachment; filename=\"{}\"", fileName);
    }

    public String getContentType() {
        return this.isXlsx() ? "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" : "application/vnd.ms-excel";
    }

    public ExcelWriter setCurrentRow(int rowIndex) {
        this.currentRow.set(rowIndex);
        return this;
    }

    public ExcelWriter setCurrentRowToEnd() {
        return this.setCurrentRow(this.getRowCount());
    }

    public ExcelWriter passCurrentRow() {
        this.currentRow.incrementAndGet();
        return this;
    }

    public ExcelWriter passRows(int rows) {
        this.currentRow.addAndGet(rows);
        return this;
    }

    public ExcelWriter resetRow() {
        this.currentRow.set(0);
        return this;
    }

    public ExcelWriter setDestFile(File destFile) {
        this.destFile = destFile;
        return this;
    }

    @Override
    public ExcelWriter setHeaderAlias(Map<String, String> headerAlias) {
        this.aliasComparator = null;
        return (ExcelWriter)super.setHeaderAlias(headerAlias);
    }

    @Override
    public ExcelWriter clearHeaderAlias() {
        this.aliasComparator = null;
        return (ExcelWriter)super.clearHeaderAlias();
    }

    @Override
    public ExcelWriter addHeaderAlias(String name, String alias) {
        this.aliasComparator = null;
        return (ExcelWriter)super.addHeaderAlias(name, alias);
    }

    public ExcelWriter setOnlyAlias(boolean isOnlyAlias) {
        this.onlyAlias = isOnlyAlias;
        return this;
    }

    public ExcelWriter setFreezePane(int rowSplit) {
        return this.setFreezePane(0, rowSplit);
    }

    public ExcelWriter setFreezePane(int colSplit, int rowSplit) {
        this.getSheet().createFreezePane(colSplit, rowSplit);
        return this;
    }

    public ExcelWriter setColumnWidth(int columnIndex, int width) {
        if (columnIndex < 0) {
            this.sheet.setDefaultColumnWidth(width);
        } else {
            this.sheet.setColumnWidth(columnIndex, width * 256);
        }
        return this;
    }

    public ExcelWriter setDefaultRowHeight(int height) {
        return this.setRowHeight(-1, height);
    }

    public ExcelWriter setRowHeight(int rownum, int height) {
        if (rownum < 0) {
            this.sheet.setDefaultRowHeightInPoints((float)height);
        } else {
            Row row = this.sheet.getRow(rownum);
            if (null != row) {
                row.setHeightInPoints((float)height);
            }
        }
        return this;
    }

    public ExcelWriter setHeaderOrFooter(String text, Align align, boolean isFooter) {
        Footer headerFooter = isFooter ? this.sheet.getFooter() : this.sheet.getHeader();
        switch (align) {
            case LEFT: {
                headerFooter.setLeft(text);
                break;
            }
            case RIGHT: {
                headerFooter.setRight(text);
                break;
            }
            case CENTER: {
                headerFooter.setCenter(text);
                break;
            }
        }
        return this;
    }

    public ExcelWriter addSelect(int x, int y, String ... selectList) {
        return this.addSelect(new CellRangeAddressList(y, y, x, x), selectList);
    }

    public ExcelWriter addSelect(CellRangeAddressList regions, String ... selectList) {
        DataValidationConstraint constraint;
        DataValidationHelper validationHelper = this.sheet.getDataValidationHelper();
        DataValidation dataValidation = validationHelper.createValidation(constraint = validationHelper.createExplicitListConstraint(selectList), regions);
        if (dataValidation instanceof XSSFDataValidation) {
            dataValidation.setSuppressDropDownArrow(true);
            dataValidation.setShowErrorBox(true);
        } else {
            dataValidation.setSuppressDropDownArrow(false);
        }
        return this.addValidationData(dataValidation);
    }

    public ExcelWriter addValidationData(DataValidation dataValidation) {
        this.sheet.addValidationData(dataValidation);
        return this;
    }

    public ExcelWriter merge(int lastColumn) {
        return this.merge(lastColumn, null);
    }

    public ExcelWriter merge(int lastColumn, Object content) {
        return this.merge(lastColumn, content, true);
    }

    public ExcelWriter merge(int lastColumn, Object content, boolean isSetHeaderStyle) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        int rowIndex = this.currentRow.get();
        this.merge(rowIndex, rowIndex, 0, lastColumn, content, isSetHeaderStyle);
        if (null != content) {
            this.currentRow.incrementAndGet();
        }
        return this;
    }

    public ExcelWriter merge(int firstRow, int lastRow, int firstColumn, int lastColumn, Object content, boolean isSetHeaderStyle) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        CellStyle style = null;
        if (null != this.styleSet) {
            style = this.styleSet.getStyleByValueType(content, isSetHeaderStyle);
        }
        return this.merge(firstRow, lastRow, firstColumn, lastColumn, content, style);
    }

    public ExcelWriter merge(int firstRow, int lastRow, int firstColumn, int lastColumn, Object content, CellStyle cellStyle) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        CellUtil.mergingCells(this.getSheet(), firstRow, lastRow, firstColumn, lastColumn, cellStyle);
        if (null != content) {
            Cell cell = this.getOrCreateCell(firstColumn, firstRow);
            CellUtil.setCellValue(cell, content, cellStyle);
        }
        return this;
    }

    public ExcelWriter write(Iterable<?> data) {
        return this.write(data, 0 == this.getCurrentRow());
    }

    public ExcelWriter write(Iterable<?> data, boolean isWriteKeyAsHead) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        boolean isFirst = true;
        for (Object object : data) {
            this.writeRow(object, isFirst && isWriteKeyAsHead);
            if (!isFirst) continue;
            isFirst = false;
        }
        return this;
    }

    public ExcelWriter write(Iterable<?> data, Comparator<String> comparator) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        boolean isFirstRow = true;
        for (Object obj : data) {
            Map<String, Object> map;
            if (obj instanceof Map) {
                map = new Map<String, Object>(comparator);
                map.putAll((Map)obj);
            } else {
                map = BeanUtil.beanToMap(obj, (Map<String, Object>)new TreeMap(comparator), false, false);
            }
            this.writeRow(map, isFirstRow);
            if (!isFirstRow) continue;
            isFirstRow = false;
        }
        return this;
    }

    public ExcelWriter writeImg(File imgFile, int col1, int row1, int col2, int row2) {
        return this.writeImg(imgFile, 0, 0, 0, 0, col1, row1, col2, row2);
    }

    public ExcelWriter writeImg(File imgFile, int dx1, int dy1, int dx2, int dy2, int col1, int row1, int col2, int row2) {
        return this.writeImg(imgFile, 6, dx1, dy1, dx2, dy2, col1, row1, col2, row2);
    }

    public ExcelWriter writeImg(File imgFile, int imgType, int dx1, int dy1, int dx2, int dy2, int col1, int row1, int col2, int row2) {
        return this.writeImg(FileUtil.readBytes(imgFile), imgType, dx1, dy1, dx2, dy2, col1, row1, col2, row2);
    }

    public ExcelWriter writeImg(byte[] pictureData, int imgType, int dx1, int dy1, int dx2, int dy2, int col1, int row1, int col2, int row2) {
        Drawing patriarch = this.sheet.createDrawingPatriarch();
        ClientAnchor anchor = this.workbook.getCreationHelper().createClientAnchor();
        anchor.setDx1(dx1);
        anchor.setDy1(dy1);
        anchor.setDx2(dx2);
        anchor.setDy2(dy2);
        anchor.setCol1(col1);
        anchor.setRow1(row1);
        anchor.setCol2(col2);
        anchor.setRow2(row2);
        patriarch.createPicture(anchor, this.workbook.addPicture(pictureData, imgType));
        return this;
    }

    public ExcelWriter writeHeadRow(Iterable<?> rowData) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        this.headLocationCache = new SafeConcurrentHashMap();
        Row row = this.sheet.createRow(this.currentRow.getAndIncrement());
        int i = 0;
        for (Object value : rowData) {
            Cell cell = row.createCell(i);
            CellUtil.setCellValue(cell, value, this.styleSet, true);
            this.headLocationCache.put((Object)StrUtil.toString(value), (Object)i);
            ++i;
        }
        return this;
    }

    public ExcelWriter writeSecHeadRow(Iterable<?> rowData) {
        Row row = RowUtil.getOrCreateRow(this.sheet, this.currentRow.getAndIncrement());
        Iterator iterator = rowData.iterator();
        if (row.getLastCellNum() != 0) {
            for (int i = 0; i < this.workbook.getSpreadsheetVersion().getMaxColumns(); ++i) {
                Cell cell = row.getCell(i);
                if (cell != null) continue;
                if (iterator.hasNext()) {
                    cell = row.createCell(i);
                    CellUtil.setCellValue(cell, iterator.next(), this.styleSet, true);
                    continue;
                }
                break;
            }
        } else {
            this.writeHeadRow(rowData);
        }
        return this;
    }

    public ExcelWriter writeRow(Object rowBean, boolean isWriteKeyAsHead) {
        TreeMap rowMap;
        if (rowBean instanceof Map) {
            rowMap = MapUtil.isNotEmpty(this.headerAlias) ? MapUtil.newTreeMap((Map)rowBean, this.getCachedAliasComparator()) : (TreeMap)rowBean;
        } else {
            if (rowBean instanceof Iterable) {
                return this.writeRow((Iterable)rowBean);
            }
            if (rowBean instanceof Hyperlink) {
                return this.writeRow(CollUtil.newArrayList(rowBean), isWriteKeyAsHead);
            }
            if (BeanUtil.isBean(rowBean.getClass())) {
                rowMap = MapUtil.isEmpty(this.headerAlias) ? BeanUtil.beanToMap(rowBean, (Map<String, Object>)new LinkedHashMap(), false, false) : BeanUtil.beanToMap(rowBean, (Map<String, Object>)new TreeMap(this.getCachedAliasComparator()), false, false);
            } else {
                return this.writeRow(CollUtil.newArrayList(rowBean), isWriteKeyAsHead);
            }
        }
        return this.writeRow((Map<?, ?>)rowMap, isWriteKeyAsHead);
    }

    public ExcelWriter writeRow(Map<?, ?> rowMap, boolean isWriteKeyAsHead) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        if (MapUtil.isEmpty(rowMap)) {
            return this.passCurrentRow();
        }
        Table<?, ?, ?> aliasTable = this.aliasTable(rowMap);
        if (isWriteKeyAsHead) {
            this.writeHeadRow((Iterable<?>)aliasTable.columnKeys());
            int i = 0;
            for (Object key : aliasTable.rowKeySet()) {
                this.headLocationCache.putIfAbsent((Object)StrUtil.toString(key), (Object)i);
                ++i;
            }
        }
        if (MapUtil.isNotEmpty(this.headLocationCache)) {
            Row row = RowUtil.getOrCreateRow(this.sheet, this.currentRow.getAndIncrement());
            for (Table.Cell cell : aliasTable) {
                Integer location = (Integer)this.headLocationCache.get((Object)StrUtil.toString(cell.getRowKey()));
                if (null == location) {
                    location = (Integer)this.headLocationCache.get((Object)StrUtil.toString(cell.getColumnKey()));
                }
                if (null == location) continue;
                CellUtil.setCellValue(CellUtil.getOrCreateCell(row, location), cell.getValue(), this.styleSet, false);
            }
        } else {
            this.writeRow((Iterable<?>)aliasTable.values());
        }
        return this;
    }

    public ExcelWriter writeRow(Iterable<?> rowData) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        RowUtil.writeRow(this.sheet.createRow(this.currentRow.getAndIncrement()), rowData, this.styleSet, false);
        return this;
    }

    public ExcelWriter writeCol(Map<?, ? extends Iterable<?>> colMap, boolean isWriteKeyAsHead) {
        return this.writeCol(colMap, 0, isWriteKeyAsHead);
    }

    public ExcelWriter writeCol(Map<?, ? extends Iterable<?>> colMap, int startColIndex, boolean isWriteKeyAsHead) {
        for (Object k : colMap.keySet()) {
            Iterable v = (Iterable)colMap.get(k);
            if (v == null) continue;
            this.writeCol(isWriteKeyAsHead ? k : null, startColIndex, v, startColIndex != colMap.size() - 1);
            ++startColIndex;
        }
        return this;
    }

    public ExcelWriter writeCol(Object headerVal, Iterable<?> colData, boolean isResetRowIndex) {
        return this.writeCol(headerVal, 0, colData, isResetRowIndex);
    }

    public ExcelWriter writeCol(Object headerVal, int colIndex, Iterable<?> colData, boolean isResetRowIndex) {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        int currentRowIndex = this.currentRow.get();
        if (null != headerVal) {
            this.writeCellValue(colIndex, currentRowIndex, headerVal, true);
            ++currentRowIndex;
        }
        for (Object colDatum : colData) {
            this.writeCellValue(colIndex, currentRowIndex, colDatum);
            ++currentRowIndex;
        }
        if (!isResetRowIndex) {
            this.currentRow.set(currentRowIndex);
        }
        return this;
    }

    public ExcelWriter writeCellValue(String locationRef, Object value) {
        return this.writeCellValue(locationRef, value, false);
    }

    public ExcelWriter writeCellValue(String locationRef, Object value, boolean isHeader) {
        CellLocation cellLocation = ExcelUtil.toLocation(locationRef);
        return this.writeCellValue(cellLocation.getX(), cellLocation.getY(), value, isHeader);
    }

    public ExcelWriter writeCellValue(int x, int y, Object value) {
        return this.writeCellValue(x, y, value, false);
    }

    public ExcelWriter writeCellValue(int x, int y, Object value, boolean isHeader) {
        Cell cell = this.getOrCreateCell(x, y);
        CellUtil.setCellValue(cell, value, this.styleSet, isHeader);
        return this;
    }

    public ExcelWriter setStyle(CellStyle style, String locationRef) {
        CellLocation cellLocation = ExcelUtil.toLocation(locationRef);
        return this.setStyle(style, cellLocation.getX(), cellLocation.getY());
    }

    public ExcelWriter setStyle(CellStyle style, int x, int y) {
        Cell cell = this.getOrCreateCell(x, y);
        cell.setCellStyle(style);
        return this;
    }

    public ExcelWriter setRowStyle(int y, CellStyle style) {
        this.getOrCreateRow(y).setRowStyle(style);
        return this;
    }

    public ExcelWriter setRowStyleIfHasData(int y, CellStyle style) {
        if (y < 0) {
            throw new IllegalArgumentException("Invalid row number (" + y + ")");
        }
        int columnCount = this.getColumnCount();
        for (int i = 0; i < columnCount; ++i) {
            this.setStyle(style, i, y);
        }
        return this;
    }

    public ExcelWriter setColumnStyle(int x, CellStyle style) {
        this.sheet.setDefaultColumnStyle(x, style);
        return this;
    }

    public ExcelWriter setColumnStyleIfHasData(int x, int y, CellStyle style) {
        if (x < 0) {
            throw new IllegalArgumentException("Invalid column number (" + x + ")");
        }
        if (y < 0) {
            throw new IllegalArgumentException("Invalid row number (" + y + ")");
        }
        int rowCount = this.getRowCount();
        for (int i = y; i < rowCount; ++i) {
            this.setStyle(style, x, i);
        }
        return this;
    }

    public Font createFont() {
        return this.getWorkbook().createFont();
    }

    public ExcelWriter flush() throws IORuntimeException {
        return this.flush(this.destFile);
    }

    public ExcelWriter flush(File destFile) throws IORuntimeException {
        Assert.notNull(destFile, "[destFile] is null, and you must call setDestFile(File) first or call flush(OutputStream).", new Object[0]);
        return this.flush((OutputStream)FileUtil.getOutputStream(destFile), true);
    }

    public ExcelWriter flush(OutputStream out) throws IORuntimeException {
        return this.flush(out, false);
    }

    public ExcelWriter flush(OutputStream out, boolean isCloseOut) throws IORuntimeException {
        Assert.isFalse(this.isClosed, "ExcelWriter has been closed!", new Object[0]);
        try {
            this.workbook.write(out);
            out.flush();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        finally {
            if (isCloseOut) {
                IoUtil.close((Closeable)out);
            }
        }
        return this;
    }

    @Override
    public void close() {
        if (null != this.destFile) {
            this.flush();
        }
        this.closeWithoutFlush();
    }

    protected void closeWithoutFlush() {
        super.close();
        this.currentRow.set(0);
        this.styleSet = null;
    }

    private Table<?, ?, ?> aliasTable(Map<?, ?> rowMap) {
        RowKeyTable filteredTable = new RowKeyTable(new LinkedHashMap(), TableMap::new);
        if (MapUtil.isEmpty(this.headerAlias)) {
            rowMap.forEach((key, value) -> filteredTable.put(key, key, value));
        } else {
            rowMap.forEach((key, value) -> {
                String aliasName = (String)this.headerAlias.get((Object)StrUtil.toString(key));
                if (null != aliasName) {
                    filteredTable.put(key, aliasName, value);
                } else if (!this.onlyAlias) {
                    filteredTable.put(key, key, value);
                }
            });
        }
        return filteredTable;
    }

    private Comparator<String> getCachedAliasComparator() {
        if (MapUtil.isEmpty(this.headerAlias)) {
            return null;
        }
        Comparator<String> aliasComparator = this.aliasComparator;
        if (null == aliasComparator) {
            Set keySet = this.headerAlias.keySet();
            this.aliasComparator = aliasComparator = new IndexedComparator<Object>(keySet.toArray((Object[])new String[0]));
        }
        return aliasComparator;
    }
}

