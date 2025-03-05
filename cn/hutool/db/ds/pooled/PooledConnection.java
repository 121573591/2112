/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.sql.Connection
 *  java.sql.DriverManager
 *  java.sql.SQLException
 *  java.util.Map
 *  java.util.Properties
 */
package cn.hutool.db.ds.pooled;

import cn.hutool.core.map.MapUtil;
import cn.hutool.db.DbUtil;
import cn.hutool.db.ds.pooled.ConnectionWraper;
import cn.hutool.db.ds.pooled.DbConfig;
import cn.hutool.db.ds.pooled.PooledDataSource;
import cn.hutool.setting.dialect.Props;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class PooledConnection
extends ConnectionWraper {
    private final PooledDataSource ds;
    private boolean isClosed;

    public PooledConnection(PooledDataSource ds) throws SQLException {
        Properties connProps;
        String password;
        this.ds = ds;
        DbConfig config = ds.getConfig();
        Props info = new Props();
        String user = config.getUser();
        if (user != null) {
            info.setProperty("user", user);
        }
        if ((password = config.getPass()) != null) {
            info.setProperty("password", password);
        }
        if (MapUtil.isNotEmpty(connProps = config.getConnProps())) {
            info.putAll((Map)connProps);
        }
        this.raw = DriverManager.getConnection((String)config.getUrl(), (Properties)info);
    }

    public PooledConnection(PooledDataSource ds, Connection conn) {
        this.ds = ds;
        this.raw = conn;
    }

    public void close() {
        this.ds.free(this);
        this.isClosed = true;
    }

    public boolean isClosed() throws SQLException {
        return this.isClosed || this.raw.isClosed();
    }

    protected PooledConnection open() {
        this.isClosed = false;
        return this;
    }

    protected PooledConnection release() {
        DbUtil.close(this.raw);
        return this;
    }
}

