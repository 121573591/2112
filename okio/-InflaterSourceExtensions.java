/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.zip.Inflater
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.InflaterSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={" \n\n\n \n\n\b0*0 2\b\b0H\b¢\b¨"}, d2={"Lokio/Source;", "Ljava/util/zip/Inflater;", "inflater", "Lokio/InflaterSource;", "inflate", "(Lokio/Source;Ljava/util/zip/Inflater;)Lokio/InflaterSource;", "okio"})
@JvmName(name="-InflaterSourceExtensions")
public final class -InflaterSourceExtensions {
    @NotNull
    public static final InflaterSource inflate(@NotNull Source $this$inflate, @NotNull Inflater inflater) {
        Intrinsics.checkNotNullParameter((Object)$this$inflate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)inflater, (String)"inflater");
        boolean $i$f$inflate = false;
        return new InflaterSource($this$inflate, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source $this$inflate_u24default, Inflater inflater, int n, Object object) {
        if ((n & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.checkNotNullParameter((Object)$this$inflate_u24default, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)inflater, (String)"inflater");
        boolean $i$f$inflate = false;
        return new InflaterSource($this$inflate_u24default, inflater);
    }
}

