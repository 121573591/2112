/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.db.dialect.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Page;
import cn.hutool.db.dialect.DialectName;
import cn.hutool.db.dialect.impl.AnsiSqlDialect;
import cn.hutool.db.sql.SqlBuilder;

public class OracleDialect
extends AnsiSqlDialect {
    private static final long serialVersionUID = 6122761762247483015L;

    public static boolean isNextVal(Object value) {
        return value instanceof CharSequence && StrUtil.endWithIgnoreCase(value.toString(), ".nextval");
    }

    @Override
    protected SqlBuilder wrapPageSql(SqlBuilder find, Page page) {
        int[] startEnd = page.getStartEnd();
        return find.insertPreFragment("SELECT * FROM ( SELECT row_.*, rownum rownum_ from ( ").append(" ) row_ where rownum <= ").append(startEnd[1]).append(") table_alias_").append(" where table_alias_.rownum_ > ").append(startEnd[0]);
    }

    @Override
    public String dialectName() {
        return DialectName.ORACLE.name();
    }
}

