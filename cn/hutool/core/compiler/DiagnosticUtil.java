/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.List
 *  java.util.stream.Collectors
 *  javax.tools.DiagnosticCollector
 */
package cn.hutool.core.compiler;

import java.util.List;
import java.util.stream.Collectors;
import javax.tools.DiagnosticCollector;

public class DiagnosticUtil {
    public static String getMessages(DiagnosticCollector<?> collector) {
        List diagnostics = collector.getDiagnostics();
        return (String)diagnostics.stream().map(String::valueOf).collect(Collectors.joining((CharSequence)System.lineSeparator()));
    }
}

