/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.sql.ResultSet
 *  java.sql.SQLException
 *  java.util.ArrayList
 *  java.util.List
 */
package cn.hutool.db.handler;

import cn.hutool.db.Entity;
import cn.hutool.db.handler.HandleHelper;
import cn.hutool.db.handler.RsHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityListHandler
implements RsHandler<List<Entity>> {
    private static final long serialVersionUID = -2846240126316979895L;
    private final boolean caseInsensitive;

    public static EntityListHandler create() {
        return new EntityListHandler();
    }

    public EntityListHandler() {
        this(false);
    }

    public EntityListHandler(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    @Override
    public List<Entity> handle(ResultSet rs) throws SQLException {
        return (List)HandleHelper.handleRs(rs, new ArrayList(), this.caseInsensitive);
    }
}

