/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  org.bouncycastle.asn1.ASN1Encodable
 *  org.bouncycastle.asn1.ASN1InputStream
 *  org.bouncycastle.asn1.ASN1Object
 *  org.bouncycastle.asn1.util.ASN1Dump
 */
package cn.hutool.crypto;

import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.io.IORuntimeException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.util.ASN1Dump;

public class ASN1Util {
    public static byte[] encodeDer(ASN1Encodable ... elements) {
        return ASN1Util.encode("DER", elements);
    }

    public static byte[] encode(String asn1Encoding, ASN1Encodable ... elements) {
        FastByteArrayOutputStream out = new FastByteArrayOutputStream();
        ASN1Util.encodeTo(asn1Encoding, out, elements);
        return out.toByteArray();
    }

    /*
     * Exception decompiling
     */
    public static void encodeTo(String asn1Encoding, OutputStream out, ASN1Encodable ... elements) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(Unknown Source:34)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(Unknown Source:0)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(Unknown Source:67)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(Unknown Source:12)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(Unknown Source:8)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(Unknown Source:13)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(Unknown Source:2)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(Unknown Source:648)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(Unknown Source:36)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(Unknown Source:1503)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(Unknown Source:6)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(Unknown Source:94)
         *     at android.s.ۥۣۢۧ.ۥ۟۟(Unknown Source:10)
         *     at org.benf.cfr.reader.entities.Method.ۥ۟۟۟(Unknown Source:4)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۤ(Unknown Source:91)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۨ(Unknown Source:0)
         *     at android.s.ۦۦ۟.ۥ۟۟۟(Unknown Source:190)
         *     at android.s.ۦۦ۟.ۥ۟۟(Unknown Source:144)
         *     at android.s.ۥۧۥ۟.ۥ(Unknown Source:107)
         *     at android.s.ۥۦۨۡ.ۥ(Unknown Source:83)
         *     at com.efs.sdk.pa.a.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁣⁠⁠⁤⁠⁠⁣⁣⁣⁣⁣⁠.⁣⁤⁠⁠⁠⁠⁣⁣⁣⁠⁠⁤⁠⁣⁤⁤⁠⁤⁤⁠⁠⁠⁣⁣⁠(Unknown Source:8)
         *     at android.s.ۥۦۨ۠.ۥ۟(Unknown Source:53)
         *     at org.apache.commons.lang3.builder.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁤⁠⁤⁤⁤⁠⁤⁠⁠⁠⁣.⁣⁤⁠⁠⁠⁣⁤⁤⁣⁤⁤⁤⁣⁤⁠⁠⁤⁤⁤⁠⁤⁤⁠⁠⁣⁠⁠⁠⁣⁣⁣(Unknown Source:10)
         *     at android.s.ۥۦۨ۠.ۥ(Unknown Source:99)
         *     at org.apache.xerces.xni.parser.⁣⁣⁣⁣⁣⁠⁣⁤⁠⁠⁣⁤⁤⁠⁤⁤.⁠⁣⁤⁣⁤⁠⁣⁤⁠⁠⁠⁣⁣⁤⁤⁣⁠(Unknown Source:8)
         *     at android.s.go$ۥ۟۟۠$ۥ.run(Unknown Source:92)
         *     at java.lang.Thread.run(Thread.java:1012)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static ASN1Object decode(InputStream in) {
        ASN1InputStream asn1In = new ASN1InputStream(in);
        try {
            return asn1In.readObject();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public static String getDumpStr(InputStream in) {
        return ASN1Dump.dumpAsString((Object)ASN1Util.decode(in));
    }
}

