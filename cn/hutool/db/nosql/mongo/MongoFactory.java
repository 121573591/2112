/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Map
 */
package cn.hutool.db.nosql.mongo;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.map.SafeConcurrentHashMap;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.db.nosql.mongo.MongoDS;
import cn.hutool.setting.Setting;
import java.util.Collection;
import java.util.Map;

public class MongoFactory {
    private static final String GROUP_SEPRATER = ",";
    private static final Map<String, MongoDS> DS_MAP = new SafeConcurrentHashMap();

    public static MongoDS getDS(String host, int port) {
        String key = host + ":" + port;
        return (MongoDS)DS_MAP.computeIfAbsent((Object)key, k -> new MongoDS(host, port));
    }

    public static MongoDS getDS(String ... groups) {
        String key = ArrayUtil.join(groups, (CharSequence)GROUP_SEPRATER);
        MongoDS ds = (MongoDS)DS_MAP.get((Object)key);
        if (null == ds) {
            ds = new MongoDS(groups);
            DS_MAP.put((Object)key, (Object)ds);
        }
        return ds;
    }

    public static MongoDS getDS(Collection<String> groups) {
        return MongoFactory.getDS((String[])groups.toArray((Object[])new String[0]));
    }

    public static MongoDS getDS(Setting setting, String ... groups) {
        String key = setting.getSettingPath() + GROUP_SEPRATER + ArrayUtil.join(groups, (CharSequence)GROUP_SEPRATER);
        MongoDS ds = (MongoDS)DS_MAP.get((Object)key);
        if (null == ds) {
            ds = new MongoDS(setting, groups);
            DS_MAP.put((Object)key, (Object)ds);
        }
        return ds;
    }

    public static MongoDS getDS(Setting setting, Collection<String> groups) {
        return MongoFactory.getDS(setting, (String[])groups.toArray((Object[])new String[0]));
    }

    public static void closeAll() {
        if (MapUtil.isNotEmpty(DS_MAP)) {
            for (MongoDS ds : DS_MAP.values()) {
                ds.close();
            }
            DS_MAP.clear();
        }
    }

    static {
        RuntimeUtil.addShutdownHook(MongoFactory::closeAll);
    }
}

