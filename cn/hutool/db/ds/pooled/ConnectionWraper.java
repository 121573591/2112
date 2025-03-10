/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.sql.Array
 *  java.sql.Blob
 *  java.sql.CallableStatement
 *  java.sql.Clob
 *  java.sql.Connection
 *  java.sql.DatabaseMetaData
 *  java.sql.NClob
 *  java.sql.PreparedStatement
 *  java.sql.SQLClientInfoException
 *  java.sql.SQLException
 *  java.sql.SQLWarning
 *  java.sql.SQLXML
 *  java.sql.Savepoint
 *  java.sql.Statement
 *  java.sql.Struct
 *  java.util.Map
 *  java.util.Properties
 *  java.util.concurrent.Executor
 */
package cn.hutool.db.ds.pooled;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public abstract class ConnectionWraper
implements Connection {
    protected Connection raw;

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return (T)this.raw.unwrap(iface);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return this.raw.isWrapperFor(iface);
    }

    public Statement createStatement() throws SQLException {
        return this.raw.createStatement();
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return this.raw.prepareStatement(sql);
    }

    public CallableStatement prepareCall(String sql) throws SQLException {
        return this.raw.prepareCall(sql);
    }

    public String nativeSQL(String sql) throws SQLException {
        return this.raw.nativeSQL(sql);
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        this.raw.setAutoCommit(autoCommit);
    }

    public boolean getAutoCommit() throws SQLException {
        return this.raw.getAutoCommit();
    }

    public void commit() throws SQLException {
        this.raw.commit();
    }

    public void rollback() throws SQLException {
        this.raw.rollback();
    }

    public DatabaseMetaData getMetaData() throws SQLException {
        return this.raw.getMetaData();
    }

    public void setReadOnly(boolean readOnly) throws SQLException {
        this.raw.setReadOnly(readOnly);
    }

    public boolean isReadOnly() throws SQLException {
        return this.raw.isReadOnly();
    }

    public void setCatalog(String catalog) throws SQLException {
        this.raw.setCatalog(catalog);
    }

    public String getCatalog() throws SQLException {
        return this.raw.getCatalog();
    }

    public void setTransactionIsolation(int level) throws SQLException {
        this.raw.setTransactionIsolation(level);
    }

    public int getTransactionIsolation() throws SQLException {
        return this.raw.getTransactionIsolation();
    }

    public SQLWarning getWarnings() throws SQLException {
        return this.raw.getWarnings();
    }

    public void clearWarnings() throws SQLException {
        this.raw.clearWarnings();
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return this.raw.createStatement(resultSetType, resultSetConcurrency);
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return this.raw.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return this.raw.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return this.raw.getTypeMap();
    }

    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        this.raw.setTypeMap(map);
    }

    public void setHoldability(int holdability) throws SQLException {
        this.raw.setHoldability(holdability);
    }

    public int getHoldability() throws SQLException {
        return this.raw.getHoldability();
    }

    public Savepoint setSavepoint() throws SQLException {
        return this.raw.setSavepoint();
    }

    public Savepoint setSavepoint(String name) throws SQLException {
        return this.raw.setSavepoint(name);
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        this.raw.rollback(savepoint);
    }

    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        this.raw.releaseSavepoint(savepoint);
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return this.raw.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return this.raw.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return this.raw.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return this.raw.prepareStatement(sql, autoGeneratedKeys);
    }

    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return this.raw.prepareStatement(sql, columnIndexes);
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return this.raw.prepareStatement(sql, columnNames);
    }

    public Clob createClob() throws SQLException {
        return this.raw.createClob();
    }

    public Blob createBlob() throws SQLException {
        return this.raw.createBlob();
    }

    public NClob createNClob() throws SQLException {
        return this.raw.createNClob();
    }

    public SQLXML createSQLXML() throws SQLException {
        return this.raw.createSQLXML();
    }

    public boolean isValid(int timeout2) throws SQLException {
        return this.raw.isValid(timeout2);
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        this.raw.setClientInfo(name, value);
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        this.raw.setClientInfo(properties);
    }

    public String getClientInfo(String name) throws SQLException {
        return this.raw.getClientInfo(name);
    }

    public Properties getClientInfo() throws SQLException {
        return this.raw.getClientInfo();
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return this.raw.createArrayOf(typeName, elements);
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return this.raw.createStruct(typeName, attributes);
    }

    public void setSchema(String schema) throws SQLException {
        this.raw.setSchema(schema);
    }

    public String getSchema() throws SQLException {
        return this.raw.getSchema();
    }

    public void abort(Executor executor) throws SQLException {
        this.raw.abort(executor);
    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        this.raw.setNetworkTimeout(executor, milliseconds);
    }

    public int getNetworkTimeout() throws SQLException {
        return this.raw.getNetworkTimeout();
    }

    public Connection getRaw() {
        return this.raw;
    }
}

