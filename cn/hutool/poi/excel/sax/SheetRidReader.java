/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  org.apache.poi.openxml4j.exceptions.InvalidFormatException
 *  org.apache.poi.xssf.eventusermodel.XSSFReader
 *  org.xml.sax.Attributes
 *  org.xml.sax.ContentHandler
 *  org.xml.sax.helpers.DefaultHandler
 */
package cn.hutool.poi.excel.sax;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.sax.ExcelSaxUtil;
import cn.hutool.poi.exceptions.POIException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;

public class SheetRidReader
extends DefaultHandler {
    private static final String TAG_NAME = "sheet";
    private static final String RID_ATTR = "r:id";
    private static final String SHEET_ID_ATTR = "sheetId";
    private static final String NAME_ATTR = "name";
    private final Map<Integer, Integer> ID_RID_MAP = new LinkedHashMap();
    private final Map<String, Integer> NAME_RID_MAP = new LinkedHashMap();

    public static SheetRidReader parse(XSSFReader reader) {
        return new SheetRidReader().read(reader);
    }

    public SheetRidReader read(XSSFReader xssfReader) {
        InputStream workbookData = null;
        try {
            workbookData = xssfReader.getWorkbookData();
            ExcelSaxUtil.readFrom(workbookData, (ContentHandler)this);
        }
        catch (InvalidFormatException e) {
            throw new POIException(e);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        finally {
            IoUtil.close((Closeable)workbookData);
        }
        return this;
    }

    public Integer getRidBySheetId(int sheetId) {
        return (Integer)this.ID_RID_MAP.get((Object)sheetId);
    }

    public Integer getRidBySheetIdBase0(int sheetId) {
        Integer rid = this.getRidBySheetId(sheetId + 1);
        if (null != rid) {
            return rid - 1;
        }
        return null;
    }

    public Integer getRidByName(String sheetName) {
        return (Integer)this.NAME_RID_MAP.get((Object)sheetName);
    }

    public Integer getRidByNameBase0(String sheetName) {
        Integer rid = this.getRidByName(sheetName);
        if (null != rid) {
            return rid - 1;
        }
        return null;
    }

    public Integer getRidByIndex(int index) {
        return (Integer)CollUtil.get(this.NAME_RID_MAP.values(), index);
    }

    public Integer getRidByIndexBase0(int index) {
        Integer rid = (Integer)CollUtil.get(this.NAME_RID_MAP.values(), index);
        if (null != rid) {
            return rid - 1;
        }
        return null;
    }

    public List<String> getSheetNames() {
        return ListUtil.toList(this.NAME_RID_MAP.keySet());
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (TAG_NAME.equalsIgnoreCase(localName)) {
            String sheetIdStr;
            String ridStr = attributes.getValue(RID_ATTR);
            if (StrUtil.isEmpty(ridStr)) {
                return;
            }
            int rid = Integer.parseInt((String)StrUtil.removePrefixIgnoreCase(ridStr, "rId"));
            String name = attributes.getValue(NAME_ATTR);
            if (StrUtil.isNotEmpty(name)) {
                this.NAME_RID_MAP.put((Object)name, (Object)rid);
            }
            if (StrUtil.isNotEmpty(sheetIdStr = attributes.getValue(SHEET_ID_ATTR))) {
                this.ID_RID_MAP.put((Object)Integer.parseInt((String)sheetIdStr), (Object)rid);
            }
        }
    }
}

