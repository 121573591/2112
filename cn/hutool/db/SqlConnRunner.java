/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.sql.Connection
 *  java.sql.ResultSet
 *  java.sql.SQLException
 *  java.util.Collection
 *  java.util.List
 *  javax.sql.DataSource
 */
package cn.hutool.db;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.db.DialectRunner;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;
import cn.hutool.db.dialect.Dialect;
import cn.hutool.db.dialect.DialectFactory;
import cn.hutool.db.handler.EntityListHandler;
import cn.hutool.db.handler.HandleHelper;
import cn.hutool.db.handler.PageResultHandler;
import cn.hutool.db.handler.RsHandler;
import cn.hutool.db.sql.Condition;
import cn.hutool.db.sql.Query;
import cn.hutool.db.sql.SqlBuilder;
import cn.hutool.db.sql.SqlUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import javax.sql.DataSource;

public class SqlConnRunner
extends DialectRunner {
    private static final long serialVersionUID = 1L;

    public static SqlConnRunner create(Dialect dialect) {
        return new SqlConnRunner(dialect);
    }

    public static SqlConnRunner create(DataSource ds) {
        return new SqlConnRunner(DialectFactory.getDialect(ds));
    }

    public static SqlConnRunner create(String driverClassName) {
        return new SqlConnRunner(driverClassName);
    }

    public SqlConnRunner(Dialect dialect) {
        super(dialect);
    }

    public SqlConnRunner(String driverClassName) {
        super(driverClassName);
    }

    public int[] insert(Connection conn, Collection<Entity> records) throws SQLException {
        return this.insert(conn, (Entity[])records.toArray((Object[])new Entity[0]));
    }

    public int insert(Connection conn, Entity record) throws SQLException {
        return this.insert(conn, new Entity[]{record})[0];
    }

    public List<Object> insertForGeneratedKeys(Connection conn, Entity record) throws SQLException {
        return this.insert(conn, record, HandleHelper::handleRowToList);
    }

    public Long insertForGeneratedKey(Connection conn, Entity record) throws SQLException {
        return this.insert(conn, record, (ResultSet rs) -> {
            Long generatedKey = null;
            if (rs != null && rs.next()) {
                try {
                    generatedKey = rs.getLong(1);
                }
                catch (SQLException sQLException) {
                    // empty catch block
                }
            }
            return generatedKey;
        });
    }

    public <T> T find(Connection conn, Collection<String> fields, Entity where, RsHandler<T> rsh) throws SQLException {
        return this.find(conn, Query.of(where).setFields(fields), rsh);
    }

    public <T> T find(Connection conn, Entity where, RsHandler<T> rsh, String ... fields) throws SQLException {
        return this.find(conn, (Collection<String>)CollUtil.newArrayList(fields), where, rsh);
    }

    public List<Entity> find(Connection conn, Entity where) throws SQLException {
        return this.find(conn, (Collection<String>)where.getFieldNames(), where, new EntityListHandler(this.caseInsensitive));
    }

    public List<Entity> findAll(Connection conn, Entity where) throws SQLException {
        return this.find(conn, where, new EntityListHandler(this.caseInsensitive), new String[0]);
    }

    public List<Entity> findAll(Connection conn, String tableName) throws SQLException {
        return this.findAll(conn, Entity.create(tableName));
    }

    public List<Entity> findBy(Connection conn, String tableName, String field, Object value) throws SQLException {
        return this.findAll(conn, Entity.create(tableName).set(field, value));
    }

    public List<Entity> findLike(Connection conn, String tableName, String field, String value, Condition.LikeType likeType) throws SQLException {
        return this.findAll(conn, Entity.create(tableName).set(field, SqlUtil.buildLikeValue(value, likeType, true)));
    }

    public List<Entity> findIn(Connection conn, String tableName, String field, Object ... values) throws SQLException {
        return this.findAll(conn, Entity.create(tableName).set(field, values));
    }

    public long count(Connection conn, CharSequence selectSql, Object ... params) throws SQLException {
        return this.count(conn, SqlBuilder.of(selectSql).addParams(params));
    }

    public <T> T page(Connection conn, Collection<String> fields, Entity where, int pageNumber, int numPerPage, RsHandler<T> rsh) throws SQLException {
        return this.page(conn, Query.of(where).setFields(fields).setPage(new Page(pageNumber, numPerPage)), rsh);
    }

    public PageResult<Entity> page(Connection conn, SqlBuilder sqlBuilder, Page page) throws SQLException {
        PageResultHandler pageResultHandler = new PageResultHandler(new PageResult<Entity>(page.getPageNumber(), page.getPageSize(), (int)this.count(conn, sqlBuilder)), this.caseInsensitive);
        return this.page(conn, sqlBuilder, page, pageResultHandler);
    }

    public PageResult<Entity> page(Connection conn, Collection<String> fields, Entity where, int page, int numPerPage) throws SQLException {
        return this.page(conn, fields, where, new Page(page, numPerPage));
    }

    public PageResult<Entity> page(Connection conn, Entity where, Page page) throws SQLException {
        return this.page(conn, null, where, page);
    }

    public PageResult<Entity> page(Connection conn, Collection<String> fields, Entity where, Page page) throws SQLException {
        PageResultHandler pageResultHandler = new PageResultHandler(new PageResult<Entity>(page.getPageNumber(), page.getPageSize(), (int)this.count(conn, where)), this.caseInsensitive);
        return this.page(conn, fields, where, page, pageResultHandler);
    }

    public <T> T page(Connection conn, Collection<String> fields, Entity where, Page page, RsHandler<T> handler) throws SQLException {
        return this.page(conn, Query.of(where).setFields(fields).setPage(page), handler);
    }
}

