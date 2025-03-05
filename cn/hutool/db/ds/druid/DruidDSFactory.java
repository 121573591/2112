/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidDataSource
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Properties
 *  javax.sql.DataSource
 */
package cn.hutool.db.ds.druid;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.ds.AbstractDSFactory;
import cn.hutool.setting.Setting;
import cn.hutool.setting.dialect.Props;
import com.alibaba.druid.pool.DruidDataSource;
import java.util.Properties;
import javax.sql.DataSource;

public class DruidDSFactory
extends AbstractDSFactory {
    private static final long serialVersionUID = 4680621702534433222L;
    public static final String DS_NAME = "Druid";

    public DruidDSFactory() {
        this((Setting)null);
    }

    public DruidDSFactory(Setting setting) {
        super(DS_NAME, DruidDataSource.class, setting);
    }

    @Override
    protected DataSource createDataSource(String jdbcUrl, String driver, String user, String pass, Setting poolSetting) {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(jdbcUrl);
        ds.setDriverClassName(driver);
        ds.setUsername(user);
        ds.setPassword(pass);
        for (String key2 : KEY_CONN_PROPS) {
            String connValue = poolSetting.getAndRemoveStr(key2);
            if (!StrUtil.isNotBlank(connValue)) continue;
            ds.addConnectionProperty(key2, connValue);
        }
        Props druidProps = new Props();
        poolSetting.forEach((key, value) -> druidProps.put(StrUtil.addPrefixIfNot(key, "druid."), value));
        ds.configFromPropety((Properties)druidProps);
        String connectionErrorRetryAttemptsKey = "druid.connectionErrorRetryAttempts";
        if (druidProps.containsKey("druid.connectionErrorRetryAttempts")) {
            ds.setConnectionErrorRetryAttempts(druidProps.getInt("druid.connectionErrorRetryAttempts").intValue());
        }
        String timeBetweenConnectErrorMillisKey = "druid.timeBetweenConnectErrorMillis";
        if (druidProps.containsKey("druid.timeBetweenConnectErrorMillis")) {
            ds.setTimeBetweenConnectErrorMillis((long)druidProps.getInt("druid.timeBetweenConnectErrorMillis").intValue());
        }
        String breakAfterAcquireFailureKey = "druid.breakAfterAcquireFailure";
        if (druidProps.containsKey("druid.breakAfterAcquireFailure")) {
            ds.setBreakAfterAcquireFailure(druidProps.getBool("druid.breakAfterAcquireFailure").booleanValue());
        }
        String validationQueryTimeout = "druid.validationQueryTimeout";
        if (druidProps.containsKey("druid.validationQueryTimeout")) {
            ds.setValidationQueryTimeout(druidProps.getInt("druid.validationQueryTimeout").intValue());
        }
        String queryTimeout = "druid.queryTimeout";
        if (druidProps.containsKey("druid.queryTimeout")) {
            ds.setQueryTimeout(druidProps.getInt("druid.queryTimeout").intValue());
        }
        String connectTimeout = "druid.connectTimeout";
        if (druidProps.containsKey("druid.connectTimeout")) {
            ds.setConnectTimeout(druidProps.getInt("druid.connectTimeout").intValue());
        }
        String socketTimeout = "druid.socketTimeout";
        if (druidProps.containsKey("druid.socketTimeout")) {
            ds.setSocketTimeout(druidProps.getInt("druid.socketTimeout").intValue());
        }
        String transactionQueryTimeout = "druid.transactionQueryTimeout";
        if (druidProps.containsKey("druid.transactionQueryTimeout")) {
            ds.setTransactionQueryTimeout(druidProps.getInt("druid.transactionQueryTimeout").intValue());
        }
        String loginTimeout = "druid.loginTimeout";
        if (druidProps.containsKey("druid.loginTimeout")) {
            ds.setLoginTimeout(druidProps.getInt("druid.loginTimeout").intValue());
        }
        if (null == ds.getValidationQuery()) {
            ds.setTestOnBorrow(false);
            ds.setTestOnReturn(false);
            ds.setTestWhileIdle(false);
        }
        return ds;
    }
}

