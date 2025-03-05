/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.sql.ResultSet
 *  java.sql.SQLException
 */
package cn.hutool.db.handler;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RsHandler<T>
extends Serializable {
    public T handle(ResultSet var1) throws SQLException;
}

