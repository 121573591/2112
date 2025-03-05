/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.json;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import cn.hutool.json.xml.JSONXMLParser;
import cn.hutool.json.xml.JSONXMLSerializer;
import cn.hutool.json.xml.ParseConfig;

public class XML {
    public static final Character AMP = Character.valueOf((char)'&');
    public static final Character APOS = Character.valueOf((char)'\'');
    public static final Character BANG = Character.valueOf((char)'!');
    public static final Character EQ = Character.valueOf((char)'=');
    public static final Character GT = Character.valueOf((char)'>');
    public static final Character LT = Character.valueOf((char)'<');
    public static final Character QUEST = Character.valueOf((char)'?');
    public static final Character QUOT = Character.valueOf((char)'\"');
    public static final Character SLASH = Character.valueOf((char)'/');

    public static JSONObject toJSONObject(String string) throws JSONException {
        return XML.toJSONObject(string, false);
    }

    public static JSONObject toJSONObject(String string, boolean keepStrings) throws JSONException {
        return XML.toJSONObject(new JSONObject(), string, keepStrings);
    }

    public static JSONObject toJSONObject(String string, ParseConfig parseConfig) throws JSONException {
        return XML.toJSONObject(new JSONObject(), string, parseConfig);
    }

    public static JSONObject toJSONObject(JSONObject jo, String xmlStr, boolean keepStrings) throws JSONException {
        JSONXMLParser.parseJSONObject(jo, xmlStr, keepStrings);
        return jo;
    }

    public static JSONObject toJSONObject(JSONObject jo, String xmlStr, ParseConfig parseConfig) throws JSONException {
        JSONXMLParser.parseJSONObject(jo, xmlStr, parseConfig);
        return jo;
    }

    public static String toXml(Object object) throws JSONException {
        return XML.toXml(object, null);
    }

    public static String toXml(Object object, String tagName) throws JSONException {
        return XML.toXml(object, tagName, "content");
    }

    public static String toXml(Object object, String tagName, String ... contentKeys) throws JSONException {
        return JSONXMLSerializer.toXml(object, tagName, contentKeys);
    }
}

