/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.sql.Connection
 *  java.sql.PreparedStatement
 *  java.sql.ResultSet
 *  java.sql.SQLException
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  javax.sql.DataSource
 */
package cn.hutool.db;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.func.Func1;
import cn.hutool.db.DbRuntimeException;
import cn.hutool.db.Entity;
import cn.hutool.db.GlobalDbConfig;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;
import cn.hutool.db.SqlConnRunner;
import cn.hutool.db.dialect.Dialect;
import cn.hutool.db.handler.BeanListHandler;
import cn.hutool.db.handler.EntityHandler;
import cn.hutool.db.handler.EntityListHandler;
import cn.hutool.db.handler.HandleHelper;
import cn.hutool.db.handler.NumberHandler;
import cn.hutool.db.handler.RsHandler;
import cn.hutool.db.handler.StringHandler;
import cn.hutool.db.sql.Condition;
import cn.hutool.db.sql.Query;
import cn.hutool.db.sql.SqlBuilder;
import cn.hutool.db.sql.SqlExecutor;
import cn.hutool.db.sql.SqlUtil;
import cn.hutool.db.sql.Wrapper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

public abstract class AbstractDb
implements Serializable {
    private static final long serialVersionUID = 3858951941916349062L;
    protected final DataSource ds;
    protected Boolean isSupportTransaction = null;
    protected boolean caseInsensitive = GlobalDbConfig.caseInsensitive;
    protected SqlConnRunner runner;

    public AbstractDb(DataSource ds, Dialect dialect) {
        this.ds = ds;
        this.runner = new SqlConnRunner(dialect);
    }

    public abstract Connection getConnection() throws SQLException;

    public abstract void closeConnection(Connection var1);

    public List<Entity> query(String sql, Map<String, Object> params) throws SQLException {
        return this.query(sql, (RsHandler)new EntityListHandler(this.caseInsensitive), params);
    }

    public List<Entity> query(String sql, Object ... params) throws SQLException {
        return this.query(sql, new EntityListHandler(this.caseInsensitive), params);
    }

    public <T> List<T> query(String sql, Class<T> beanClass, Object ... params) throws SQLException {
        return (List)this.query(sql, new BeanListHandler<T>(beanClass), params);
    }

    public Entity queryOne(String sql, Object ... params) throws SQLException {
        return this.query(sql, new EntityHandler(this.caseInsensitive), params);
    }

    public Number queryNumber(String sql, Object ... params) throws SQLException {
        return this.query(sql, new NumberHandler(), params);
    }

    public String queryString(String sql, Object ... params) throws SQLException {
        return this.query(sql, new StringHandler(), params);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T query(String sql, RsHandler<T> rsh, Object ... params) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = SqlExecutor.query(conn, sql, rsh, params);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T query(String sql, RsHandler<T> rsh, Map<String, Object> paramMap) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = SqlExecutor.query(conn, sql, rsh, paramMap);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T query(Func1<Connection, PreparedStatement> statementFunc, RsHandler<T> rsh) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = SqlExecutor.query(conn, statementFunc, rsh);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int execute(String sql, Object ... params) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int n = SqlExecutor.execute(conn, sql, params);
            return n;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Long executeForGeneratedKey(String sql, Object ... params) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            Long l = SqlExecutor.executeForGeneratedKey(conn, sql, params);
            return l;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Deprecated
    public int[] executeBatch(String sql, Object[] ... paramsBatch) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int[] nArray = SqlExecutor.executeBatch(conn, sql, paramsBatch);
            return nArray;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] executeBatch(String sql, Iterable<Object[]> paramsBatch) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int[] nArray = SqlExecutor.executeBatch(conn, sql, paramsBatch);
            return nArray;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] executeBatch(String ... sqls) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int[] nArray = SqlExecutor.executeBatch(conn, sqls);
            return nArray;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] executeBatch(Iterable<String> sqls) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int[] nArray = SqlExecutor.executeBatch(conn, sqls);
            return nArray;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int insert(Entity record) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int n = this.runner.insert(conn, record);
            return n;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int insertOrUpdate(Entity record, String ... keys) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int n = this.runner.insertOrUpdate(conn, record, keys);
            return n;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int upsert(Entity record, String ... keys) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int n = this.runner.upsert(conn, record, keys);
            return n;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] insert(Collection<Entity> records) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int[] nArray = this.runner.insert(conn, records);
            return nArray;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List<Object> insertForGeneratedKeys(Entity record) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            List<Object> list = this.runner.insertForGeneratedKeys(conn, record);
            return list;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Long insertForGeneratedKey(Entity record) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            Long l = this.runner.insertForGeneratedKey(conn, record);
            return l;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    public int del(String tableName, String field, Object value) throws SQLException {
        return this.del(Entity.create(tableName).set(field, value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int del(Entity where) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int n = this.runner.del(conn, where);
            return n;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int update(Entity record, Entity where) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            int n = this.runner.update(conn, record, where);
            return n;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    public <T> Entity get(String tableName, String field, T value) throws SQLException {
        return this.get(Entity.create(tableName).set(field, value));
    }

    public Entity get(Entity where) throws SQLException {
        return this.find((Collection<String>)where.getFieldNames(), where, new EntityHandler(this.caseInsensitive));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T find(Collection<String> fields, Entity where, RsHandler<T> rsh) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = this.runner.find(conn, fields, where, rsh);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    public List<Entity> find(Collection<String> fields, Entity where) throws SQLException {
        return this.find(fields, where, new EntityListHandler(this.caseInsensitive));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T find(Query query, RsHandler<T> rsh) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = this.runner.find(conn, query, rsh);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    public <T> T find(Entity where, RsHandler<T> rsh, String ... fields) throws SQLException {
        return this.find((Collection<String>)CollUtil.newArrayList(fields), where, rsh);
    }

    public List<Entity> find(Entity where) throws SQLException {
        return this.find((Collection<String>)where.getFieldNames(), where, new EntityListHandler(this.caseInsensitive));
    }

    public <T> List<T> find(Entity where, Class<T> beanClass) throws SQLException {
        return (List)this.find((Collection<String>)where.getFieldNames(), where, (RsHandler<T>)BeanListHandler.create(beanClass));
    }

    public List<Entity> findAll(Entity where) throws SQLException {
        return this.find(where, new EntityListHandler(this.caseInsensitive), new String[0]);
    }

    public <T> List<T> findAll(Entity where, Class<T> beanClass) throws SQLException {
        return (List)this.find(where, BeanListHandler.create(beanClass), new String[0]);
    }

    public List<Entity> findAll(String tableName) throws SQLException {
        return this.findAll(Entity.create(tableName));
    }

    public List<Entity> findBy(String tableName, String field, Object value) throws SQLException {
        return this.findAll(Entity.create(tableName).set(field, value));
    }

    public List<Entity> findBy(String tableName, Condition ... wheres) throws SQLException {
        Query query = new Query(wheres, tableName);
        return this.find(query, new EntityListHandler(this.caseInsensitive));
    }

    public List<Entity> findLike(String tableName, String field, String value, Condition.LikeType likeType) throws SQLException {
        return this.findAll(Entity.create(tableName).set(field, SqlUtil.buildLikeValue(value, likeType, true)));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long count(Entity where) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            long l = this.runner.count(conn, where);
            return l;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long count(SqlBuilder sql) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            long l = this.runner.count(conn, sql);
            return l;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long count(CharSequence selectSql, Object ... params) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            long l = this.runner.count(conn, selectSql, params);
            return l;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T page(Collection<String> fields, Entity where, int page, int numPerPage, RsHandler<T> rsh) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = this.runner.page(conn, fields, where, page, numPerPage, rsh);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    public <T> T page(Entity where, int page, int numPerPage, RsHandler<T> rsh) throws SQLException {
        return this.page(where, new Page(page, numPerPage), rsh);
    }

    public List<Entity> pageForEntityList(Entity where, int page, int numPerPage) throws SQLException {
        return this.pageForEntityList(where, new Page(page, numPerPage));
    }

    public List<Entity> pageForEntityList(Entity where, Page page) throws SQLException {
        return this.page(where, page, new EntityListHandler(this.caseInsensitive));
    }

    public <T> T page(Entity where, Page page, RsHandler<T> rsh) throws SQLException {
        return this.page((Collection<String>)where.getFieldNames(), where, page, rsh);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T page(Collection<String> fields, Entity where, Page page, RsHandler<T> rsh) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = this.runner.page(conn, fields, where, page, rsh);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T page(CharSequence sql, Page page, RsHandler<T> rsh, Object ... params) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = this.runner.page(conn, SqlBuilder.of(sql).addParams(params), page, rsh);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    public <T> PageResult<T> page(CharSequence sql, Page page, Class<T> elementBeanType, Object ... params) throws SQLException {
        PageResult result = new PageResult(page.getPageNumber(), page.getPageSize(), (int)this.count(sql, params));
        return this.page(sql, page, (ResultSet rs) -> HandleHelper.handleRsToBeanList(rs, result, elementBeanType), params);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T page(SqlBuilder sql, Page page, RsHandler<T> rsh) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            T t = this.runner.page(conn, sql, page, rsh);
            return t;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PageResult<Entity> page(CharSequence sql, Page page, Object ... params) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            PageResult<Entity> pageResult = this.runner.page(conn, SqlBuilder.of(sql).addParams(params), page);
            return pageResult;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    public PageResult<Entity> page(Collection<String> fields, Entity where, int pageNumber, int pageSize) throws SQLException {
        return this.page(fields, where, new Page(pageNumber, pageSize));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PageResult<Entity> page(Collection<String> fields, Entity where, Page page) throws SQLException {
        Connection conn = null;
        try {
            conn = this.getConnection();
            PageResult<Entity> pageResult = this.runner.page(conn, fields, where, page);
            return pageResult;
        }
        finally {
            this.closeConnection(conn);
        }
    }

    public PageResult<Entity> page(Entity where, int page, int numPerPage) throws SQLException {
        return this.page(where, new Page(page, numPerPage));
    }

    public PageResult<Entity> page(Entity where, Page page) throws SQLException {
        return this.page((Collection<String>)where.getFieldNames(), where, page);
    }

    public void setCaseInsensitive(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    public SqlConnRunner getRunner() {
        return this.runner;
    }

    public void setRunner(SqlConnRunner runner) {
        this.runner = runner;
    }

    public AbstractDb setWrapper(Character wrapperChar) {
        return this.setWrapper(new Wrapper(wrapperChar));
    }

    public AbstractDb setWrapper(Wrapper wrapper) {
        this.runner.setWrapper(wrapper);
        return this;
    }

    public AbstractDb disableWrapper() {
        return this.setWrapper((Wrapper)null);
    }

    protected void checkTransactionSupported(Connection conn) throws SQLException, DbRuntimeException {
        if (null == this.isSupportTransaction) {
            this.isSupportTransaction = conn.getMetaData().supportsTransactions();
        }
        if (!this.isSupportTransaction.booleanValue()) {
            throw new DbRuntimeException("Transaction not supported for current database!");
        }
    }
}

