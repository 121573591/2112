/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.apache.poi.hssf.eventusermodel.EventWorkbookBuilder$SheetRecordCollectingListener
 *  org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener
 *  org.apache.poi.hssf.eventusermodel.HSSFEventFactory
 *  org.apache.poi.hssf.eventusermodel.HSSFListener
 *  org.apache.poi.hssf.eventusermodel.HSSFRequest
 *  org.apache.poi.hssf.eventusermodel.MissingRecordAwareHSSFListener
 *  org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord
 *  org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord
 *  org.apache.poi.hssf.record.BOFRecord
 *  org.apache.poi.hssf.record.BlankRecord
 *  org.apache.poi.hssf.record.BoolErrRecord
 *  org.apache.poi.hssf.record.BoundSheetRecord
 *  org.apache.poi.hssf.record.CellValueRecordInterface
 *  org.apache.poi.hssf.record.EOFRecord
 *  org.apache.poi.hssf.record.FormulaRecord
 *  org.apache.poi.hssf.record.LabelRecord
 *  org.apache.poi.hssf.record.LabelSSTRecord
 *  org.apache.poi.hssf.record.NumberRecord
 *  org.apache.poi.hssf.record.Record
 *  org.apache.poi.hssf.record.SSTRecord
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.poifs.filesystem.POIFSFileSystem
 */
package cn.hutool.poi.excel.sax;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.sax.ExcelSaxReader;
import cn.hutool.poi.excel.sax.ExcelSaxUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import cn.hutool.poi.exceptions.POIException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.eventusermodel.EventWorkbookBuilder;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.eventusermodel.MissingRecordAwareHSSFListener;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Excel03SaxReader
implements HSSFListener,
ExcelSaxReader<Excel03SaxReader> {
    private final boolean isOutputFormulaValues = true;
    private EventWorkbookBuilder.SheetRecordCollectingListener workbookBuildingListener;
    private HSSFWorkbook stubWorkbook;
    private SSTRecord sstRecord;
    private FormatTrackingHSSFListener formatListener;
    private final List<BoundSheetRecord> boundSheetRecords = new ArrayList();
    private boolean isOutputNextStringRecord;
    private List<Object> rowCellList = new ArrayList();
    private int rid = -1;
    private String sheetName;
    private int curRid = -1;
    private final RowHandler rowHandler;

    public Excel03SaxReader(RowHandler rowHandler) {
        this.rowHandler = rowHandler;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Excel03SaxReader read(File file, String idOrRidOrSheetName) throws POIException {
        try (POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file, true);){
            Excel03SaxReader excel03SaxReader = this.read(poifsFileSystem, idOrRidOrSheetName);
            return excel03SaxReader;
        }
        catch (IOException e) {
            throw new POIException(e);
        }
    }

    @Override
    public Excel03SaxReader read(InputStream excelStream, String idOrRidOrSheetName) throws POIException {
        try {
            return this.read(new POIFSFileSystem(excelStream), idOrRidOrSheetName);
        }
        catch (IOException e) {
            throw new POIException(e);
        }
    }

    public Excel03SaxReader read(POIFSFileSystem fs, String idOrRidOrSheetName) throws POIException {
        this.rid = this.getSheetIndex(idOrRidOrSheetName);
        this.formatListener = new FormatTrackingHSSFListener((HSSFListener)new MissingRecordAwareHSSFListener((HSSFListener)this));
        HSSFRequest request = new HSSFRequest();
        request.addListenerForAllRecords((HSSFListener)this.formatListener);
        HSSFEventFactory factory2 = new HSSFEventFactory();
        try {
            factory2.processWorkbookEvents(request, fs);
        }
        catch (IOException e) {
            throw new POIException(e);
        }
        finally {
            IoUtil.close((Closeable)fs);
        }
        return this;
    }

    public int getSheetIndex() {
        return this.rid;
    }

    public String getSheetName() {
        if (null != this.sheetName) {
            return this.sheetName;
        }
        if (this.boundSheetRecords.size() > this.rid) {
            return ((BoundSheetRecord)this.boundSheetRecords.get(this.rid > -1 ? this.rid : this.curRid)).getSheetname();
        }
        return null;
    }

    public void processRecord(Record record) {
        if (this.rid > -1 && this.curRid > this.rid) {
            return;
        }
        if (record instanceof BoundSheetRecord) {
            BoundSheetRecord boundSheetRecord = (BoundSheetRecord)record;
            this.boundSheetRecords.add((Object)boundSheetRecord);
            String currentSheetName = boundSheetRecord.getSheetname();
            if (null != this.sheetName && StrUtil.equals(this.sheetName, currentSheetName)) {
                this.rid = this.boundSheetRecords.size() - 1;
            }
        } else if (record instanceof SSTRecord) {
            this.sstRecord = (SSTRecord)record;
        } else if (record instanceof BOFRecord) {
            BOFRecord bofRecord = (BOFRecord)record;
            if (bofRecord.getType() == 16) {
                if (this.workbookBuildingListener != null && this.stubWorkbook == null) {
                    this.stubWorkbook = this.workbookBuildingListener.getStubHSSFWorkbook();
                }
                ++this.curRid;
            }
        } else if (record instanceof EOFRecord) {
            if (this.rid < 0 && null != this.sheetName) {
                throw new POIException("Sheet [{}] not exist!", this.sheetName);
            }
            if (this.curRid != -1 && this.isProcessCurrentSheet()) {
                this.processLastCellSheet();
            }
        } else if (this.isProcessCurrentSheet()) {
            if (record instanceof MissingCellDummyRecord) {
                MissingCellDummyRecord mc = (MissingCellDummyRecord)record;
                this.addToRowCellList(mc);
            } else if (record instanceof LastCellOfRowDummyRecord) {
                this.processLastCell((LastCellOfRowDummyRecord)record);
            } else {
                this.processCellValue(record);
            }
        }
    }

    private void addToRowCellList(MissingCellDummyRecord record) {
        this.addToRowCellList(record.getRow(), record.getColumn(), "");
    }

    private void addToRowCellList(CellValueRecordInterface record, Object value) {
        this.addToRowCellList(record.getRow(), record.getColumn(), value);
    }

    private void addToRowCellList(int row, int column, Object value) {
        while (column > this.rowCellList.size()) {
            this.rowCellList.add((Object)"");
            this.rowHandler.handleCell(this.curRid, row, this.rowCellList.size() - 1, value, null);
        }
        this.rowCellList.add(column, value);
        this.rowHandler.handleCell(this.curRid, row, column, value, null);
    }

    private void processCellValue(Record record) {
        Object value = null;
        switch (record.getSid()) {
            case 513: {
                this.addToRowCellList((CellValueRecordInterface)((BlankRecord)record), "");
                break;
            }
            case 517: {
                BoolErrRecord berec = (BoolErrRecord)record;
                this.addToRowCellList((CellValueRecordInterface)berec, berec.getBooleanValue());
                break;
            }
            case 6: {
                FormulaRecord formulaRec = (FormulaRecord)record;
                if (Double.isNaN((double)formulaRec.getValue())) {
                    this.isOutputNextStringRecord = true;
                } else {
                    value = ExcelSaxUtil.getNumberOrDateValue((CellValueRecordInterface)formulaRec, formulaRec.getValue(), this.formatListener);
                }
                this.addToRowCellList((CellValueRecordInterface)formulaRec, value);
                break;
            }
            case 519: {
                if (!this.isOutputNextStringRecord) break;
                this.isOutputNextStringRecord = false;
                break;
            }
            case 516: {
                LabelRecord lrec = (LabelRecord)record;
                value = lrec.getValue();
                this.addToRowCellList((CellValueRecordInterface)lrec, value);
                break;
            }
            case 253: {
                LabelSSTRecord lsrec = (LabelSSTRecord)record;
                if (null != this.sstRecord) {
                    value = this.sstRecord.getString(lsrec.getSSTIndex()).toString();
                }
                this.addToRowCellList((CellValueRecordInterface)lsrec, ObjectUtil.defaultIfNull(value, ""));
                break;
            }
            case 515: {
                NumberRecord numrec = (NumberRecord)record;
                value = ExcelSaxUtil.getNumberOrDateValue((CellValueRecordInterface)numrec, numrec.getValue(), this.formatListener);
                this.addToRowCellList((CellValueRecordInterface)numrec, value);
                break;
            }
        }
    }

    private void processLastCell(LastCellOfRowDummyRecord lastCell) {
        this.rowHandler.handle(this.curRid, lastCell.getRow(), this.rowCellList);
        this.rowCellList = new ArrayList(this.rowCellList.size());
    }

    private void processLastCellSheet() {
        this.rowHandler.doAfterAllAnalysed();
    }

    private boolean isProcessCurrentSheet() {
        return this.rid < 0 && null == this.sheetName || this.rid == this.curRid;
    }

    private int getSheetIndex(String idOrRidOrSheetName) {
        Assert.notBlank(idOrRidOrSheetName, "id or rid or sheetName must be not blank!", new Object[0]);
        if (StrUtil.startWithIgnoreCase(idOrRidOrSheetName, "rId")) {
            return Integer.parseInt((String)StrUtil.removePrefixIgnoreCase(idOrRidOrSheetName, "rId"));
        }
        if (StrUtil.startWithIgnoreCase(idOrRidOrSheetName, "sheetName:")) {
            this.sheetName = StrUtil.removePrefixIgnoreCase(idOrRidOrSheetName, "sheetName:");
        } else {
            try {
                return Integer.parseInt((String)idOrRidOrSheetName);
            }
            catch (NumberFormatException ignore) {
                this.sheetName = idOrRidOrSheetName;
            }
        }
        return -1;
    }
}

