/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="changed in Okio 2.x")
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" \"\n\n \n\b\n\n \n\t\n\b\n\b\n\b\bÇ 20B\t\b¢\bJ020H¢\b\bJ'0202\n0\t20\tH¢\b\f¨\r"}, d2={"Lokio/-DeprecatedUtf8;", "", "<init>", "()V", "", "string", "", "size", "(Ljava/lang/String;)J", "", "beginIndex", "endIndex", "(Ljava/lang/String;II)J", "okio"})
public final class -DeprecatedUtf8 {
    @NotNull
    public static final -DeprecatedUtf8 INSTANCE = new -DeprecatedUtf8();

    private -DeprecatedUtf8() {
    }

    @Deprecated(message="moved to extension function", replaceWith=@ReplaceWith(expression="string.utf8Size()", imports={"okio.utf8Size"}), level=DeprecationLevel.ERROR)
    public final long size(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    @Deprecated(message="moved to extension function", replaceWith=@ReplaceWith(expression="string.utf8Size(beginIndex, endIndex)", imports={"okio.utf8Size"}), level=DeprecationLevel.ERROR)
    public final long size(@NotNull String string, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        return Utf8.size(string, beginIndex, endIndex);
    }
}

