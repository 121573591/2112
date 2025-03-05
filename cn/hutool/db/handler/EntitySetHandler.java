/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.sql.ResultSet
 *  java.sql.SQLException
 *  java.util.LinkedHashSet
 */
package cn.hutool.db.handler;

import cn.hutool.db.Entity;
import cn.hutool.db.handler.HandleHelper;
import cn.hutool.db.handler.RsHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;

public class EntitySetHandler
implements RsHandler<LinkedHashSet<Entity>> {
    private static final long serialVersionUID = 8191723216703506736L;
    private final boolean caseInsensitive;

    public static EntitySetHandler create() {
        return new EntitySetHandler();
    }

    public EntitySetHandler() {
        this(false);
    }

    public EntitySetHandler(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    @Override
    public LinkedHashSet<Entity> handle(ResultSet rs) throws SQLException {
        return HandleHelper.handleRs(rs, new LinkedHashSet(), this.caseInsensitive);
    }
}

