/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.db.dialect;

import cn.hutool.core.util.StrUtil;

public enum DialectName {
    ANSI,
    MYSQL,
    ORACLE,
    POSTGRESQL,
    SQLITE3,
    H2,
    SQLSERVER,
    SQLSERVER2012,
    PHOENIX;


    public boolean match(String dialectName) {
        return StrUtil.equalsIgnoreCase(dialectName, this.name());
    }
}

