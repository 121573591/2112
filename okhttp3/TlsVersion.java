/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n\n\n\b\r\b  \t2\b0 0:\tB\b0¢\bJ0H¢\bR08¢\f\n\b\b\bj\b\nj\bj\b\fj\b\rj\b¨"}, d2={"Lokhttp3/TlsVersion;", "", "", "javaName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "-deprecated_javaName", "()Ljava/lang/String;", "Ljava/lang/String;", "Companion", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "okhttp"})
public final class TlsVersion
extends Enum<TlsVersion> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String javaName;
    public static final /* enum */ TlsVersion TLS_1_3;
    public static final /* enum */ TlsVersion TLS_1_2;
    public static final /* enum */ TlsVersion TLS_1_1;
    public static final /* enum */ TlsVersion TLS_1_0;
    public static final /* enum */ TlsVersion SSL_3_0;
    private static final /* synthetic */ TlsVersion[] $VALUES;

    private TlsVersion(String javaName) {
        this.javaName = javaName;
    }

    @JvmName(name="javaName")
    @NotNull
    public final String javaName() {
        return this.javaName;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="javaName", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_javaName")
    @NotNull
    public final String -deprecated_javaName() {
        return this.javaName;
    }

    public static TlsVersion[] values() {
        return (TlsVersion[])$VALUES.clone();
    }

    public static TlsVersion valueOf(String value) {
        return (TlsVersion)Enum.valueOf(TlsVersion.class, (String)value);
    }

    @JvmStatic
    @NotNull
    public static final TlsVersion forJavaName(@NotNull String javaName) {
        return Companion.forJavaName(javaName);
    }

    static {
        TLS_1_3 = new TlsVersion("TLSv1.3");
        TLS_1_2 = new TlsVersion("TLSv1.2");
        TLS_1_1 = new TlsVersion("TLSv1.1");
        TLS_1_0 = new TlsVersion("TLSv1");
        SSL_3_0 = new TlsVersion("SSLv3");
        $VALUES = tlsVersionArray = new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0, TlsVersion.SSL_3_0};
        Companion = new Companion(null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n \n\n\b\b 20B\t\b¢\bJ020H¢\b\b¨\t"}, d2={"Lokhttp3/TlsVersion$Companion;", "", "<init>", "()V", "", "javaName", "Lokhttp3/TlsVersion;", "forJavaName", "(Ljava/lang/String;)Lokhttp3/TlsVersion;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * Exception decompiling
         */
        @JvmStatic
        @NotNull
        public final TlsVersion forJavaName(@NotNull String javaName) {
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
             *     at org.benf.cfr.reader.entities.ۥ.ۥۣ۟۟(Unknown Source:31)
             *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۤ(Unknown Source:26)
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

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

