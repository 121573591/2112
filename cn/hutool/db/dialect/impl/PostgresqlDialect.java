/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.sql.Connection
 *  java.sql.PreparedStatement
 *  java.sql.SQLException
 */
package cn.hutool.db.dialect.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.StatementUtil;
import cn.hutool.db.dialect.DialectName;
import cn.hutool.db.dialect.impl.AnsiSqlDialect;
import cn.hutool.db.sql.SqlBuilder;
import cn.hutool.db.sql.Wrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresqlDialect
extends AnsiSqlDialect {
    private static final long serialVersionUID = 3889210427543389642L;

    public PostgresqlDialect() {
        this.wrapper = new Wrapper(Character.valueOf((char)'\"'));
    }

    @Override
    public String dialectName() {
        return DialectName.POSTGRESQL.name();
    }

    @Override
    public PreparedStatement psForUpsert(Connection conn, Entity entity, String ... keys) throws SQLException {
        Assert.notEmpty(keys, "Keys must be not empty for Postgres.", new Object[0]);
        SqlBuilder.validateEntity(entity);
        SqlBuilder builder = SqlBuilder.create(this.wrapper);
        StringBuilder fieldsPart = new StringBuilder();
        StringBuilder placeHolder = new StringBuilder();
        StringBuilder updateHolder = new StringBuilder();
        entity.forEach((field, value) -> {
            if (StrUtil.isNotBlank(field)) {
                if (fieldsPart.length() > 0) {
                    fieldsPart.append(", ");
                    placeHolder.append(", ");
                    updateHolder.append(", ");
                }
                String wrapedField = null != this.wrapper ? this.wrapper.wrap((String)field) : field;
                fieldsPart.append(wrapedField);
                updateHolder.append(wrapedField).append("=EXCLUDED.").append(wrapedField);
                placeHolder.append("?");
                builder.addParams(value);
            }
        });
        String tableName = entity.getTableName();
        if (null != this.wrapper) {
            tableName = this.wrapper.wrap(tableName);
            keys = this.wrapper.wrap(keys);
        }
        builder.append("INSERT INTO ").append(tableName).append(" (").append(fieldsPart).append(") VALUES (").append(placeHolder).append(") ON CONFLICT (").append(ArrayUtil.join(keys, (CharSequence)", ")).append(") DO UPDATE SET ").append(updateHolder);
        return StatementUtil.prepareStatement(conn, builder);
    }
}

