/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.db;

import cn.hutool.core.io.resource.NoResourceException;
import cn.hutool.db.sql.SqlLog;
import cn.hutool.log.level.Level;
import cn.hutool.setting.Setting;

public class GlobalDbConfig {
    private static final String DEFAULT_DB_SETTING_PATH = "config/db.setting";
    private static final String DEFAULT_DB_SETTING_PATH2 = "db.setting";
    protected static boolean caseInsensitive = true;
    protected static boolean returnGeneratedKey = true;
    private static String dbSettingPath = null;

    public static void setCaseInsensitive(boolean isCaseInsensitive) {
        caseInsensitive = isCaseInsensitive;
    }

    public static void setReturnGeneratedKey(boolean isReturnGeneratedKey) {
        returnGeneratedKey = isReturnGeneratedKey;
    }

    public static void setDbSettingPath(String customDbSettingPath) {
        dbSettingPath = customDbSettingPath;
    }

    public static Setting createDbSetting() {
        Setting setting;
        if (null != dbSettingPath) {
            try {
                setting = new Setting(dbSettingPath, false);
            }
            catch (NoResourceException e3) {
                throw new NoResourceException("Customize db setting file [{}] not found !", dbSettingPath);
            }
        }
        try {
            setting = new Setting(DEFAULT_DB_SETTING_PATH, true);
        }
        catch (NoResourceException e) {
            try {
                setting = new Setting(DEFAULT_DB_SETTING_PATH2, true);
            }
            catch (NoResourceException e2) {
                throw new NoResourceException("Default db setting [{}] or [{}] in classpath not found !", DEFAULT_DB_SETTING_PATH, DEFAULT_DB_SETTING_PATH2);
            }
        }
        return setting;
    }

    public static void setShowSql(boolean isShowSql, boolean isFormatSql, boolean isShowParams, Level level) {
        SqlLog.INSTANCE.init(isShowSql, isFormatSql, isShowParams, level);
    }
}

