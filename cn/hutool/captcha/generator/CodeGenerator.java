/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.captcha.generator;

import java.io.Serializable;

public interface CodeGenerator
extends Serializable {
    public String generate();

    public boolean verify(String var1, String var2);
}

