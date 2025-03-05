/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package cn.hutool.setting;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.io.resource.NoResourceException;
import cn.hutool.core.map.SafeConcurrentHashMap;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.Setting;
import java.util.Map;

public class SettingUtil {
    private static final Map<String, Setting> SETTING_MAP = new SafeConcurrentHashMap();

    public static Setting get(String name) {
        return (Setting)SETTING_MAP.computeIfAbsent((Object)name, filePath -> {
            String extName = FileNameUtil.extName(filePath);
            if (StrUtil.isEmpty(extName)) {
                filePath = filePath + "." + "setting";
            }
            return new Setting((String)filePath, true);
        });
    }

    public static Setting getFirstFound(String ... names) {
        for (String name : names) {
            try {
                return SettingUtil.get(name);
            }
            catch (NoResourceException noResourceException) {
            }
        }
        return null;
    }
}

