/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.sql.Connection
 *  java.sql.PreparedStatement
 *  java.sql.SQLException
 *  java.sql.Statement
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package cn.hutool.db;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.GlobalDbConfig;
import cn.hutool.db.Page;
import cn.hutool.db.StatementUtil;
import cn.hutool.db.dialect.Dialect;
import cn.hutool.db.dialect.DialectFactory;
import cn.hutool.db.handler.NumberHandler;
import cn.hutool.db.handler.RsHandler;
import cn.hutool.db.sql.Query;
import cn.hutool.db.sql.SqlBuilder;
import cn.hutool.db.sql.SqlExecutor;
import cn.hutool.db.sql.SqlUtil;
import cn.hutool.db.sql.Wrapper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DialectRunner
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Dialect dialect;
    protected boolean caseInsensitive = GlobalDbConfig.caseInsensitive;

    public DialectRunner(Dialect dialect) {
        this.dialect = dialect;
    }

    public DialectRunner(String driverClassName) {
        this(DialectFactory.newDialect(driverClassName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] insert(Connection conn, Entity ... records) throws SQLException {
        PreparedStatement ps;
        block4: {
            int[] nArray;
            this.checkConn(conn);
            if (ArrayUtil.isEmpty(records)) {
                return new int[]{0};
            }
            ps = null;
            try {
                if (1 != records.length) break block4;
                ps = this.dialect.psForInsert(conn, records[0]);
                nArray = new int[]{ps.executeUpdate()};
            }
            catch (Throwable throwable) {
                DbUtil.close(ps);
                throw throwable;
            }
            DbUtil.close(ps);
            return nArray;
        }
        ps = this.dialect.psForInsertBatch(conn, records);
        int[] nArray = ps.executeBatch();
        DbUtil.close(ps);
        return nArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int upsert(Connection conn, Entity record, String ... keys) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = this.getDialect().psForUpsert(conn, record, keys);
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
        if (null != ps) {
            int n;
            try {
                n = ps.executeUpdate();
            }
            catch (Throwable throwable) {
                DbUtil.close(ps);
                throw throwable;
            }
            DbUtil.close(ps);
            return n;
        }
        return this.insertOrUpdate(conn, record, keys);
    }

    public int insertOrUpdate(Connection conn, Entity record, String ... keys) throws SQLException {
        Entity where = record.filter(keys);
        if (MapUtil.isNotEmpty(where) && this.count(conn, where) > 0L) {
            return this.update(conn, record.removeNew(keys), where);
        }
        return this.insert(conn, record)[0];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T insert(Connection conn, Entity record, RsHandler<T> generatedKeysHandler) throws SQLException {
        PreparedStatement ps;
        block4: {
            T t;
            this.checkConn(conn);
            if (MapUtil.isEmpty(record)) {
                throw new SQLException("Empty entity provided!");
            }
            ps = null;
            try {
                ps = this.dialect.psForInsert(conn, record);
                ps.executeUpdate();
                if (null != generatedKeysHandler) break block4;
                t = null;
            }
            catch (Throwable throwable) {
                DbUtil.close(ps);
                throw throwable;
            }
            DbUtil.close(ps);
            return t;
        }
        T t = StatementUtil.getGeneratedKeys((Statement)ps, generatedKeysHandler);
        DbUtil.close(ps);
        return t;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int del(Connection conn, Entity where) throws SQLException {
        int n;
        this.checkConn(conn);
        if (MapUtil.isEmpty(where)) {
            throw new SQLException("Empty entity provided!");
        }
        PreparedStatement ps = null;
        try {
            ps = this.dialect.psForDelete(conn, Query.of(where));
            n = ps.executeUpdate();
        }
        catch (Throwable throwable) {
            DbUtil.close(ps);
            throw throwable;
        }
        DbUtil.close(ps);
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int update(Connection conn, Entity record, Entity where) throws SQLException {
        int n;
        this.checkConn(conn);
        if (MapUtil.isEmpty(record)) {
            throw new SQLException("Empty entity provided!");
        }
        if (MapUtil.isEmpty(where)) {
            throw new SQLException("Empty where provided!");
        }
        String tableName = record.getTableName();
        if (StrUtil.isBlank(tableName)) {
            tableName = where.getTableName();
            record.setTableName(tableName);
        }
        Query query = new Query(SqlUtil.buildConditions(where), tableName);
        PreparedStatement ps = null;
        try {
            ps = this.dialect.psForUpdate(conn, record, query);
            n = ps.executeUpdate();
        }
        catch (Throwable throwable) {
            DbUtil.close(ps);
            throw throwable;
        }
        DbUtil.close(ps);
        return n;
    }

    public <T> T find(Connection conn, Query query, RsHandler<T> rsh) throws SQLException {
        this.checkConn(conn);
        Assert.notNull(query, "[query] is null !", new Object[0]);
        return SqlExecutor.queryAndClosePs(this.dialect.psForFind(conn, query), rsh, new Object[0]);
    }

    public long count(Connection conn, Entity where) throws SQLException {
        this.checkConn(conn);
        return SqlExecutor.queryAndClosePs(this.dialect.psForCount(conn, Query.of(where)), new NumberHandler(), new Object[0]).longValue();
    }

    public long count(Connection conn, SqlBuilder sqlBuilder) throws SQLException {
        this.checkConn(conn);
        String selectSql = sqlBuilder.build();
        Pattern pattern = PatternPool.get("(.*?)[\\s]order[\\s]by[\\s][^\\s]+\\s(asc|desc)?", 2);
        Matcher matcher = pattern.matcher((CharSequence)selectSql);
        if (matcher.matches()) {
            selectSql = matcher.group(1);
        }
        return SqlExecutor.queryAndClosePs(this.dialect.psForCount(conn, SqlBuilder.of(selectSql).addParams(sqlBuilder.getParamValueArray())), new NumberHandler(), new Object[0]).longValue();
    }

    public <T> T page(Connection conn, Query query, RsHandler<T> rsh) throws SQLException {
        this.checkConn(conn);
        if (null == query.getPage()) {
            return this.find(conn, query, rsh);
        }
        return SqlExecutor.queryAndClosePs(this.dialect.psForPage(conn, query), rsh, new Object[0]);
    }

    public <T> T page(Connection conn, SqlBuilder sqlBuilder, Page page, RsHandler<T> rsh) throws SQLException {
        this.checkConn(conn);
        if (null == page) {
            return SqlExecutor.query(conn, sqlBuilder, rsh);
        }
        return SqlExecutor.queryAndClosePs(this.dialect.psForPage(conn, sqlBuilder, page), rsh, new Object[0]);
    }

    public void setCaseInsensitive(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    public Dialect getDialect() {
        return this.dialect;
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public void setWrapper(Character wrapperChar) {
        this.setWrapper(new Wrapper(wrapperChar));
    }

    public void setWrapper(Wrapper wrapper) {
        this.dialect.setWrapper(wrapper);
    }

    private void checkConn(Connection conn) {
        Assert.notNull(conn, "Connection object must be not null!", new Object[0]);
    }
}

