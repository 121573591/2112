/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Map
 *  javax.sql.DataSource
 */
package cn.hutool.db.ds;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.map.SafeConcurrentHashMap;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.DbRuntimeException;
import cn.hutool.db.DbUtil;
import cn.hutool.db.GlobalDbConfig;
import cn.hutool.db.dialect.DriverUtil;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.db.ds.DataSourceWrapper;
import cn.hutool.setting.Setting;
import java.util.Collection;
import java.util.Map;
import javax.sql.DataSource;

public abstract class AbstractDSFactory
extends DSFactory {
    private static final long serialVersionUID = -6407302276272379881L;
    private final Setting setting;
    private final Map<String, DataSourceWrapper> dsMap;

    public AbstractDSFactory(String dataSourceName, Class<? extends DataSource> dataSourceClass, Setting setting) {
        super(dataSourceName);
        Assert.notNull(dataSourceClass);
        if (null == setting) {
            setting = GlobalDbConfig.createDbSetting();
        }
        DbUtil.setShowSqlGlobal(setting);
        this.setting = setting;
        this.dsMap = new SafeConcurrentHashMap();
    }

    public Setting getSetting() {
        return this.setting;
    }

    @Override
    public synchronized DataSource getDataSource(String group) {
        DataSourceWrapper existedDataSource;
        if (group == null) {
            group = "";
        }
        if ((existedDataSource = (DataSourceWrapper)this.dsMap.get((Object)group)) != null) {
            return existedDataSource;
        }
        DataSourceWrapper ds = this.createDataSource(group);
        this.dsMap.put((Object)group, (Object)ds);
        return ds;
    }

    private DataSourceWrapper createDataSource(String group) {
        Setting config;
        if (group == null) {
            group = "";
        }
        if (MapUtil.isEmpty(config = this.setting.getSetting(group))) {
            throw new DbRuntimeException("No config for group: [{}]", group);
        }
        String url = config.getAndRemoveStr(KEY_ALIAS_URL);
        if (StrUtil.isBlank(url)) {
            throw new DbRuntimeException("No JDBC URL for group: [{}]", group);
        }
        DbUtil.removeShowSqlParams(config);
        String driver = config.getAndRemoveStr(KEY_ALIAS_DRIVER);
        if (StrUtil.isBlank(driver)) {
            driver = DriverUtil.identifyDriver(url);
        }
        String user = config.getAndRemoveStr(KEY_ALIAS_USER);
        String pass = config.getAndRemoveStr(KEY_ALIAS_PASSWORD);
        return DataSourceWrapper.wrap(this.createDataSource(url, driver, user, pass, config), driver);
    }

    protected abstract DataSource createDataSource(String var1, String var2, String var3, String var4, Setting var5);

    @Override
    public void close(String group) {
        DataSourceWrapper ds;
        if (group == null) {
            group = "";
        }
        if ((ds = (DataSourceWrapper)this.dsMap.get((Object)group)) != null) {
            ds.close();
            this.dsMap.remove((Object)group);
        }
    }

    @Override
    public void destroy() {
        if (MapUtil.isNotEmpty(this.dsMap)) {
            Collection values = this.dsMap.values();
            for (DataSourceWrapper ds : values) {
                ds.close();
            }
            this.dsMap.clear();
        }
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.dataSourceName == null ? 0 : this.dataSourceName.hashCode());
        result = 31 * result + (this.setting == null ? 0 : this.setting.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        AbstractDSFactory other = (AbstractDSFactory)obj;
        if (this.dataSourceName == null ? other.dataSourceName != null : !this.dataSourceName.equals((Object)other.dataSourceName)) {
            return false;
        }
        if (this.setting == null) {
            return other.setting == null;
        }
        return this.setting.equals(other.setting);
    }
}

