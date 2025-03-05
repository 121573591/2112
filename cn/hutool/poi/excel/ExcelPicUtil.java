/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  org.apache.poi.hssf.usermodel.HSSFClientAnchor
 *  org.apache.poi.hssf.usermodel.HSSFPicture
 *  org.apache.poi.hssf.usermodel.HSSFShape
 *  org.apache.poi.hssf.usermodel.HSSFSheet
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.ooxml.POIXMLDocumentPart
 *  org.apache.poi.ss.usermodel.PictureData
 *  org.apache.poi.ss.usermodel.Workbook
 *  org.apache.poi.xssf.usermodel.XSSFDrawing
 *  org.apache.poi.xssf.usermodel.XSSFPicture
 *  org.apache.poi.xssf.usermodel.XSSFShape
 *  org.apache.poi.xssf.usermodel.XSSFSheet
 *  org.apache.poi.xssf.usermodel.XSSFWorkbook
 *  org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker
 */
package cn.hutool.poi.excel;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

public class ExcelPicUtil {
    public static Map<String, PictureData> getPicMap(Workbook workbook, int sheetIndex) {
        Assert.notNull(workbook, "Workbook must be not null !", new Object[0]);
        if (sheetIndex < 0) {
            sheetIndex = 0;
        }
        if (workbook instanceof HSSFWorkbook) {
            return ExcelPicUtil.getPicMapXls((HSSFWorkbook)workbook, sheetIndex);
        }
        if (workbook instanceof XSSFWorkbook) {
            return ExcelPicUtil.getPicMapXlsx((XSSFWorkbook)workbook, sheetIndex);
        }
        throw new IllegalArgumentException(StrUtil.format("Workbook type [{}] is not supported!", workbook.getClass()));
    }

    private static Map<String, PictureData> getPicMapXls(HSSFWorkbook workbook, int sheetIndex) {
        HashMap picMap = new HashMap();
        List pictures = workbook.getAllPictures();
        if (CollectionUtil.isNotEmpty(pictures)) {
            HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
            for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
                if (!(shape instanceof HSSFPicture)) continue;
                int pictureIndex = ((HSSFPicture)shape).getPictureIndex() - 1;
                HSSFClientAnchor anchor = (HSSFClientAnchor)shape.getAnchor();
                picMap.put((Object)StrUtil.format("{}_{}", anchor.getRow1(), anchor.getCol1()), pictures.get(pictureIndex));
            }
        }
        return picMap;
    }

    private static Map<String, PictureData> getPicMapXlsx(XSSFWorkbook workbook, int sheetIndex) {
        LinkedHashMap sheetIndexPicMap = new LinkedHashMap();
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        for (POIXMLDocumentPart dr : sheet.getRelations()) {
            if (!(dr instanceof XSSFDrawing)) continue;
            XSSFDrawing drawing = (XSSFDrawing)dr;
            List shapes = drawing.getShapes();
            for (XSSFShape shape : shapes) {
                if (!(shape instanceof XSSFPicture)) continue;
                XSSFPicture pic = (XSSFPicture)shape;
                CTMarker ctMarker = pic.getPreferredSize().getFrom();
                sheetIndexPicMap.put((Object)StrUtil.format("{}_{}", ctMarker.getRow(), ctMarker.getCol()), (Object)pic.getPictureData());
            }
        }
        return sheetIndexPicMap;
    }
}

