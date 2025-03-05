/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.sql.Connection
 *  java.util.Map
 *  javax.sql.DataSource
 */
package cn.hutool.db.dialect;

import cn.hutool.core.map.SafeConcurrentHashMap;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.dialect.Dialect;
import cn.hutool.db.dialect.DriverNamePool;
import cn.hutool.db.dialect.DriverUtil;
import cn.hutool.db.dialect.impl.AnsiSqlDialect;
import cn.hutool.db.dialect.impl.H2Dialect;
import cn.hutool.db.dialect.impl.MysqlDialect;
import cn.hutool.db.dialect.impl.OracleDialect;
import cn.hutool.db.dialect.impl.PhoenixDialect;
import cn.hutool.db.dialect.impl.PostgresqlDialect;
import cn.hutool.db.dialect.impl.SqlServer2012Dialect;
import cn.hutool.db.dialect.impl.Sqlite3Dialect;
import cn.hutool.log.StaticLog;
import java.sql.Connection;
import java.util.Map;
import javax.sql.DataSource;

public class DialectFactory
implements DriverNamePool {
    private static final Map<DataSource, Dialect> DIALECT_POOL = new SafeConcurrentHashMap();

    private DialectFactory() {
    }

    public static Dialect newDialect(String driverName) {
        Dialect dialect = DialectFactory.internalNewDialect(driverName);
        StaticLog.debug("Use Dialect: [{}].", dialect.getClass().getSimpleName());
        return dialect;
    }

    private static Dialect internalNewDialect(String driverName) {
        if (StrUtil.isNotBlank(driverName)) {
            if ("com.mysql.jdbc.Driver".equalsIgnoreCase(driverName) || "com.mysql.cj.jdbc.Driver".equalsIgnoreCase(driverName)) {
                return new MysqlDialect();
            }
            if ("oracle.jdbc.OracleDriver".equalsIgnoreCase(driverName) || "oracle.jdbc.driver.OracleDriver".equalsIgnoreCase(driverName)) {
                return new OracleDialect();
            }
            if ("org.sqlite.JDBC".equalsIgnoreCase(driverName)) {
                return new Sqlite3Dialect();
            }
            if ("org.postgresql.Driver".equalsIgnoreCase(driverName)) {
                return new PostgresqlDialect();
            }
            if ("org.h2.Driver".equalsIgnoreCase(driverName)) {
                return new H2Dialect();
            }
            if ("com.microsoft.sqlserver.jdbc.SQLServerDriver".equalsIgnoreCase(driverName)) {
                return new SqlServer2012Dialect();
            }
            if ("org.apache.phoenix.jdbc.PhoenixDriver".equalsIgnoreCase(driverName)) {
                return new PhoenixDialect();
            }
        }
        return new AnsiSqlDialect();
    }

    public static String identifyDriver(String nameContainsProductInfo) {
        return DialectFactory.identifyDriver(nameContainsProductInfo, null);
    }

    public static String identifyDriver(String nameContainsProductInfo, ClassLoader classLoader) {
        if (StrUtil.isBlank(nameContainsProductInfo)) {
            return null;
        }
        String name = ReUtil.getGroup1("jdbc:(.*?):", (CharSequence)(nameContainsProductInfo = StrUtil.cleanBlank(nameContainsProductInfo.toLowerCase())));
        if (StrUtil.isNotBlank(name)) {
            nameContainsProductInfo = name;
        }
        String driver = null;
        if (nameContainsProductInfo.contains((CharSequence)"mysql") || nameContainsProductInfo.contains((CharSequence)"cobar")) {
            driver = ClassLoaderUtil.isPresent("com.mysql.cj.jdbc.Driver", classLoader) ? "com.mysql.cj.jdbc.Driver" : "com.mysql.jdbc.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"oracle")) {
            driver = ClassLoaderUtil.isPresent("oracle.jdbc.OracleDriver", classLoader) ? "oracle.jdbc.OracleDriver" : "oracle.jdbc.driver.OracleDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"postgresql")) {
            driver = "org.postgresql.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"sqlite")) {
            driver = "org.sqlite.JDBC";
        } else if (nameContainsProductInfo.contains((CharSequence)"sqlserver") || nameContainsProductInfo.contains((CharSequence)"microsoft")) {
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"hive2")) {
            driver = "org.apache.hive.jdbc.HiveDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"hive")) {
            driver = "org.apache.hadoop.hive.jdbc.HiveDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"h2")) {
            driver = "org.h2.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"derby")) {
            driver = "org.apache.derby.jdbc.AutoloadedDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"hsqldb")) {
            driver = "org.hsqldb.jdbc.JDBCDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"dm")) {
            driver = "dm.jdbc.driver.DmDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"kingbase8")) {
            driver = "com.kingbase8.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"ignite")) {
            driver = "org.apache.ignite.IgniteJdbcThinDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"clickhouse")) {
            driver = "com.clickhouse.jdbc.ClickHouseDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"highgo")) {
            driver = "com.highgo.jdbc.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"db2")) {
            driver = "com.ibm.db2.jdbc.app.DB2Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"xugu")) {
            driver = "com.xugu.cloudjdbc.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"phoenix")) {
            driver = "org.apache.phoenix.jdbc.PhoenixDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"zenith")) {
            driver = "com.huawei.gauss.jdbc.ZenithDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"gbase")) {
            driver = "com.gbase.jdbc.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"oscar")) {
            driver = "com.oscar.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"sybase")) {
            driver = "com.sybase.jdbc4.jdbc.SybDriver";
        } else if (nameContainsProductInfo.contains((CharSequence)"mariadb")) {
            driver = "org.mariadb.jdbc.Driver";
        } else if (nameContainsProductInfo.contains((CharSequence)"opengauss")) {
            driver = "org.opengauss.Driver";
        }
        return driver;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Dialect getDialect(DataSource ds) {
        Dialect dialect = (Dialect)DIALECT_POOL.get((Object)ds);
        if (null == dialect) {
            DataSource dataSource = ds;
            synchronized (dataSource) {
                dialect = (Dialect)DIALECT_POOL.computeIfAbsent((Object)ds, DialectFactory::newDialect);
            }
        }
        return dialect;
    }

    public static Dialect newDialect(DataSource ds) {
        return DialectFactory.newDialect(DriverUtil.identifyDriver(ds));
    }

    public static Dialect newDialect(Connection conn) {
        return DialectFactory.newDialect(DriverUtil.identifyDriver(conn));
    }
}

