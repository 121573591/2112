/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.zaxxer.hikari.HikariConfig
 *  com.zaxxer.hikari.HikariDataSource
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Properties
 *  javax.sql.DataSource
 */
package cn.hutool.db.ds.hikari;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.ds.AbstractDSFactory;
import cn.hutool.setting.Setting;
import cn.hutool.setting.dialect.Props;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;

public class HikariDSFactory
extends AbstractDSFactory {
    private static final long serialVersionUID = -8834744983614749401L;
    public static final String DS_NAME = "HikariCP";

    public HikariDSFactory() {
        this((Setting)null);
    }

    public HikariDSFactory(Setting setting) {
        super(DS_NAME, HikariDataSource.class, setting);
    }

    @Override
    protected DataSource createDataSource(String jdbcUrl, String driver, String user, String pass, Setting poolSetting) {
        Props connProps = new Props();
        for (String key : KEY_CONN_PROPS) {
            String connValue = poolSetting.getAndRemoveStr(key);
            if (!StrUtil.isNotBlank(connValue)) continue;
            connProps.setProperty(key, connValue);
        }
        Props config = new Props();
        config.putAll(poolSetting);
        config.put("jdbcUrl", jdbcUrl);
        if (null != driver) {
            config.put("driverClassName", driver);
        }
        if (null != user) {
            config.put("username", user);
        }
        if (null != pass) {
            config.put("password", pass);
        }
        HikariConfig hikariConfig = new HikariConfig((Properties)config);
        hikariConfig.setDataSourceProperties((Properties)connProps);
        return new HikariDataSource(hikariConfig);
    }
}

