/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.time.Instant
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 *  java.util.TreeSet
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ReplaceWith
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.ArrayIteratorKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.StringCompanionObject
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.text.StringsKt
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" j\n\n\n\n\n\n\b\n\t\n\b\n \n \n\n\b\n\n\b\n\n\b\n\b\n\b\n(\n\b\n\"\n\b\n\n\b\n$\n \n\b  320000:43B\b\f\b00¢\bJ\r\t0\b¢\b\t\nJ0\r2\b\f0H¢\bJ020H¢\bJ020¢\bJ020H¢\bJ0H¢\bJ\"0000H¢\bJ020¢\b J\"\b00!¢\b\"#J\r%0$¢\b%&J(0H¢\b'J+0\n\b00*0)¢\b+,J-0H¢\b-.J/020¢\b/ J0\b00*20¢\b01R\b008X¢\n\b2R(08G¢\b(¨5"}, d2={"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "", "namesAndValues", "<init>", "([Ljava/lang/String;)V", "", "byteCount", "()J", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Date;", "getDate", "(Ljava/lang/String;)Ljava/util/Date;", "Ljava/time/Instant;", "getInstant", "(Ljava/lang/String;)Ljava/time/Instant;", "", "hashCode", "()I", "", "iterator", "()Ljava/util/Iterator;", "index", "(I)Ljava/lang/String;", "", "names", "()Ljava/util/Set;", "Lokhttp3/Headers$Builder;", "newBuilder", "()Lokhttp3/Headers$Builder;", "-deprecated_size", "size", "", "", "toMultimap", "()Ljava/util/Map;", "toString", "()Ljava/lang/String;", "value", "values", "(Ljava/lang/String;)Ljava/util/List;", "[Ljava/lang/String;", "Companion", "Builder", "okhttp"})
public final class Headers
implements Iterable<Pair<? extends String, ? extends String>>,
KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String[] namesAndValues;

    private Headers(String[] namesAndValues) {
        this.namesAndValues = namesAndValues;
    }

    @Nullable
    public final String get(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return Headers.Companion.get(this.namesAndValues, name);
    }

    @Nullable
    public final Date getDate(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        String string = this.get(name);
        return string != null ? DatesKt.toHttpDateOrNull(string) : null;
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String name) {
        Date value;
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Date date = value = this.getDate(name);
        return date != null ? date.toInstant() : null;
    }

    @JvmName(name="size")
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_size")
    public final int -deprecated_size() {
        return this.size();
    }

    @NotNull
    public final String name(int index) {
        return this.namesAndValues[index * 2];
    }

    @NotNull
    public final String value(int index) {
        return this.namesAndValues[index * 2 + 1];
    }

    @NotNull
    public final Set<String> names() {
        TreeSet result = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER((StringCompanionObject)StringCompanionObject.INSTANCE));
        int n = this.size();
        for (int i = 0; i < n; ++i) {
            result.add((Object)this.name(i));
        }
        Set set = Collections.unmodifiableSet((Set)((Set)result));
        Intrinsics.checkNotNullExpressionValue((Object)set, (String)"unmodifiableSet(result)");
        return set;
    }

    @NotNull
    public final List<String> values(@NotNull String name) {
        List list;
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        List result = null;
        int n = this.size();
        for (int i = 0; i < n; ++i) {
            if (!StringsKt.equals((String)name, (String)this.name(i), (boolean)true)) continue;
            if (result == null) {
                result = (List)new ArrayList(2);
            }
            result.add((Object)this.value(i));
        }
        if (result != null) {
            List list2 = Collections.unmodifiableList(result);
            list = list2;
            Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"{\n      Collections.unmodifiableList(result)\n    }");
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    public final long byteCount() {
        long result = this.namesAndValues.length * 2;
        int n = this.namesAndValues.length;
        for (int i = 0; i < n; ++i) {
            result += (long)this.namesAndValues[i].length();
        }
        return result;
    }

    @NotNull
    public Iterator<Pair<String, String>> iterator() {
        int n = 0;
        int n2 = this.size();
        Object[] objectArray = new Pair[n2];
        while (n < n2) {
            int n3 = n++;
            objectArray[n3] = TuplesKt.to((Object)this.name(n3), (Object)this.value(n3));
        }
        return ArrayIteratorKt.iterator((Object[])objectArray);
    }

    @NotNull
    public final Builder newBuilder() {
        Builder result = new Builder();
        CollectionsKt.addAll((Collection)((Collection)result.getNamesAndValues$okhttp()), (Object[])this.namesAndValues);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof Headers && Arrays.equals((Object[])this.namesAndValues, (Object[])((Headers)other).namesAndValues);
    }

    public int hashCode() {
        return Arrays.hashCode((Object[])this.namesAndValues);
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder;
        StringBuilder $this$toString_u24lambda_u240 = stringBuilder = new StringBuilder();
        boolean bl = false;
        int n = this.size();
        for (int i = 0; i < n; ++i) {
            String name = this.name(i);
            String value = this.value(i);
            $this$toString_u24lambda_u240.append(name);
            $this$toString_u24lambda_u240.append(": ");
            $this$toString_u24lambda_u240.append(Util.isSensitiveHeader(name) ? "██" : value);
            $this$toString_u24lambda_u240.append("\n");
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        TreeMap result = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER((StringCompanionObject)StringCompanionObject.INSTANCE));
        int n = this.size();
        for (int i = 0; i < n; ++i) {
            String name;
            String string = this.name(i);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
            Intrinsics.checkNotNullExpressionValue((Object)string.toLowerCase(locale), (String)"this as java.lang.String).toLowerCase(locale)");
            List values = (List)result.get((Object)name);
            if (values == null) {
                values = (List)new ArrayList(2);
                ((Map)result).put((Object)name, (Object)values);
            }
            values.add((Object)this.value(i));
        }
        return (Map)result;
    }

    @JvmStatic
    @JvmName(name="of")
    @NotNull
    public static final Headers of(String ... namesAndValues) {
        return Companion.of(namesAndValues);
    }

    @JvmStatic
    @JvmName(name="of")
    @NotNull
    public static final Headers of(@NotNull Map<String, String> $this$of) {
        return Companion.of($this$of);
    }

    public /* synthetic */ Headers(String[] namesAndValues, DefaultConstructorMarker $constructor_marker) {
        this(namesAndValues);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 4\n\n \n\b\n\n\b\n\n\b\n\n\b\n\n\b\f\n!\n\b 20B¢\bJ0 20¢\bJ0 2\b02\n0\tH¢\bJ0 2\b02\n0\f¢\b\rJ0 2\b02\n0¢\bJ0 20¢\bJ0 20H ¢\bJ0 2\b02\n0H ¢\bJ0 2\b02\n0¢\bJ\r0¢\bJ02\b0H¢\bJ0 2\b0¢\bJ 0 2\b02\n0\tH¢\bJ 0 2\b02\n0\fH¢\b\rJ 0 2\b02\n0H¢\bR \b008 X¢\f\n\b\b ¨!"}, d2={"Lokhttp3/Headers$Builder;", "", "<init>", "()V", "", "line", "add", "(Ljava/lang/String;)Lokhttp3/Headers$Builder;", "name", "Ljava/time/Instant;", "value", "(Ljava/lang/String;Ljava/time/Instant;)Lokhttp3/Headers$Builder;", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)Lokhttp3/Headers$Builder;", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "Lokhttp3/Headers;", "headers", "addAll", "(Lokhttp3/Headers;)Lokhttp3/Headers$Builder;", "addLenient$okhttp", "addLenient", "addUnsafeNonAscii", "build", "()Lokhttp3/Headers;", "get", "(Ljava/lang/String;)Ljava/lang/String;", "removeAll", "set", "", "namesAndValues", "Ljava/util/List;", "getNamesAndValues$okhttp", "()Ljava/util/List;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,458:1\n1#2:459\n37#3,2:460\n*S KotlinDebug\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n*L\n359#1:460,2\n*E\n"})
    public static final class Builder {
        @NotNull
        private final List<String> namesAndValues = (List)new ArrayList(20);

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String line) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)line, (String)"line");
            Builder $this$addLenient_u24lambda_u240 = builder = this;
            boolean bl = false;
            int index = StringsKt.indexOf$default((CharSequence)line, (char)':', (int)1, (boolean)false, (int)4, null);
            if (index != -1) {
                String string = line.substring(0, index);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"this as java.lang.String…ing(startIndex, endIndex)");
                String string2 = line.substring(index + 1);
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String).substring(startIndex)");
                $this$addLenient_u24lambda_u240.addLenient$okhttp(string, string2);
            } else if (line.charAt(0) == ':') {
                String string = line.substring(1);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"this as java.lang.String).substring(startIndex)");
                $this$addLenient_u24lambda_u240.addLenient$okhttp("", string);
            } else {
                $this$addLenient_u24lambda_u240.addLenient$okhttp("", line);
            }
            return builder;
        }

        @NotNull
        public final Builder add(@NotNull String line) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)line, (String)"line");
            Builder $this$add_u24lambda_u242 = builder = this;
            boolean bl = false;
            int index = StringsKt.indexOf$default((CharSequence)line, (char)':', (int)0, (boolean)false, (int)6, null);
            if (!(index != -1)) {
                boolean bl2 = false;
                String string = "Unexpected header: " + line;
                throw new IllegalArgumentException(string.toString());
            }
            String string = line.substring(0, index);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"this as java.lang.String…ing(startIndex, endIndex)");
            String string2 = StringsKt.trim((CharSequence)string).toString();
            String string3 = line.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String).substring(startIndex)");
            $this$add_u24lambda_u242.add(string2, string3);
            return builder;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$add_u24lambda_u243 = builder = this;
            boolean bl = false;
            Companion.checkName(name);
            Companion.checkValue(value, name);
            $this$add_u24lambda_u243.addLenient$okhttp(name, value);
            return builder;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String name, @NotNull String value) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$addUnsafeNonAscii_u24lambda_u244 = builder = this;
            boolean bl = false;
            Companion.checkName(name);
            $this$addUnsafeNonAscii_u24lambda_u244.addLenient$okhttp(name, value);
            return builder;
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
            Builder $this$addAll_u24lambda_u245 = builder = this;
            boolean bl = false;
            int n = headers.size();
            for (int i = 0; i < n; ++i) {
                $this$addAll_u24lambda_u245.addLenient$okhttp(headers.name(i), headers.value(i));
            }
            return builder;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Date value) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$add_u24lambda_u246 = builder = this;
            boolean bl = false;
            $this$add_u24lambda_u246.add(name, DatesKt.toHttpDateString(value));
            return builder;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String name, @NotNull Instant value) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$add_u24lambda_u247 = builder = this;
            boolean bl = false;
            $this$add_u24lambda_u247.add(name, new Date(value.toEpochMilli()));
            return builder;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Date value) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$set_u24lambda_u248 = builder = this;
            boolean bl = false;
            $this$set_u24lambda_u248.set(name, DatesKt.toHttpDateString(value));
            return builder;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String name, @NotNull Instant value) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$set_u24lambda_u249 = this;
            boolean bl = false;
            return $this$set_u24lambda_u249.set(name, new Date(value.toEpochMilli()));
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String name, @NotNull String value) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$addLenient_u24lambda_u2410 = builder = this;
            boolean bl = false;
            $this$addLenient_u24lambda_u2410.namesAndValues.add((Object)name);
            $this$addLenient_u24lambda_u2410.namesAndValues.add((Object)StringsKt.trim((CharSequence)value).toString());
            return builder;
        }

        @NotNull
        public final Builder removeAll(@NotNull String name) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Builder $this$removeAll_u24lambda_u2411 = builder = this;
            boolean bl = false;
            for (int i = 0; i < $this$removeAll_u24lambda_u2411.namesAndValues.size(); i += 2) {
                if (!StringsKt.equals((String)name, (String)((String)$this$removeAll_u24lambda_u2411.namesAndValues.get(i)), (boolean)true)) continue;
                $this$removeAll_u24lambda_u2411.namesAndValues.remove(i);
                $this$removeAll_u24lambda_u2411.namesAndValues.remove(i);
                i -= 2;
            }
            return builder;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull String value) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$set_u24lambda_u2412 = builder = this;
            boolean bl = false;
            Companion.checkName(name);
            Companion.checkValue(value, name);
            $this$set_u24lambda_u2412.removeAll(name);
            $this$set_u24lambda_u2412.addLenient$okhttp(name, value);
            return builder;
        }

        @Nullable
        public final String get(@NotNull String name) {
            int n;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            int i = n = this.namesAndValues.size() - 2;
            int n2 = ProgressionUtilKt.getProgressionLastElement((int)n, (int)0, (int)-2);
            if (n2 <= i) {
                while (true) {
                    if (StringsKt.equals((String)name, (String)((String)this.namesAndValues.get(i)), (boolean)true)) {
                        return (String)this.namesAndValues.get(i + 1);
                    }
                    if (i == n2) break;
                    i -= 2;
                }
            }
            return null;
        }

        @NotNull
        public final Headers build() {
            Collection $this$toTypedArray$iv = (Collection)this.namesAndValues;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            return new Headers((String[])thisCollection$iv.toArray((Object[])new String[0]), null);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 2\n\n \n\b\n\n \n\n\b\n\n\b\n\n\b\n$\n\b\b 20B\t\b¢\bJ020H¢\b\bJ\n02\t020H¢\b\nJ'02\f\r\b00\f20H¢\bJ#02\r\n\b00\f\"0H¢\bJ#02\r\n\b00\f\"0H¢\bJ#02000H¢\bJ0*000H¢\b¨"}, d2={"Lokhttp3/Headers$Companion;", "", "<init>", "()V", "", "name", "", "checkName", "(Ljava/lang/String;)V", "value", "checkValue", "(Ljava/lang/String;Ljava/lang/String;)V", "", "namesAndValues", "get", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersOf", "-deprecated_of", "", "headers", "(Ljava/util/Map;)Lokhttp3/Headers;", "toHeaders", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,458:1\n1#2:459\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        private final String get(String[] namesAndValues, String name) {
            int n;
            int i = n = namesAndValues.length - 2;
            int n2 = ProgressionUtilKt.getProgressionLastElement((int)n, (int)0, (int)-2);
            if (n2 <= i) {
                while (true) {
                    if (StringsKt.equals((String)name, (String)namesAndValues[i], (boolean)true)) {
                        return namesAndValues[i + 1];
                    }
                    if (i == n2) break;
                    i -= 2;
                }
            }
            return null;
        }

        @JvmStatic
        @JvmName(name="of")
        @NotNull
        public final Headers of(String ... namesAndValues) {
            Intrinsics.checkNotNullParameter((Object)namesAndValues, (String)"namesAndValues");
            if (!(namesAndValues.length % 2 == 0)) {
                boolean $i$a$-require-Headers$Companion$headersOf$32 = false;
                String $i$a$-require-Headers$Companion$headersOf$32 = "Expected alternating header names and values";
                throw new IllegalArgumentException($i$a$-require-Headers$Companion$headersOf$32.toString());
            }
            String[] namesAndValues2 = (String[])namesAndValues.clone();
            int n = namesAndValues2.length;
            for (int i = 0; i < n; ++i) {
                if (!(namesAndValues2[i] != null)) {
                    boolean $i$a$-require-Headers$Companion$headersOf$42 = false;
                    String $i$a$-require-Headers$Companion$headersOf$42 = "Headers cannot be null";
                    throw new IllegalArgumentException($i$a$-require-Headers$Companion$headersOf$42.toString());
                }
                namesAndValues2[i] = StringsKt.trim((CharSequence)namesAndValues2[i]).toString();
            }
            int i = 0;
            int n2 = namesAndValues2.length + -1;
            int n3 = ProgressionUtilKt.getProgressionLastElement((int)0, (int)n2, (int)2);
            if (i <= n3) {
                while (true) {
                    String name = namesAndValues2[i];
                    String value = namesAndValues2[i + 1];
                    this.checkName(name);
                    this.checkValue(value, name);
                    if (i == n3) break;
                    i += 2;
                }
            }
            return new Headers(namesAndValues2, null);
        }

        @Deprecated(message="function name changed", replaceWith=@ReplaceWith(expression="headersOf(*namesAndValues)", imports={}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_of")
        @NotNull
        public final Headers -deprecated_of(String ... namesAndValues) {
            Intrinsics.checkNotNullParameter((Object)namesAndValues, (String)"namesAndValues");
            return this.of((String[])Arrays.copyOf((Object[])namesAndValues, (int)namesAndValues.length));
        }

        @JvmStatic
        @JvmName(name="of")
        @NotNull
        public final Headers of(@NotNull Map<String, String> $this$toHeaders) {
            Intrinsics.checkNotNullParameter($this$toHeaders, (String)"<this>");
            String[] namesAndValues = new String[$this$toHeaders.size() * 2];
            int i = 0;
            for (Map.Entry entry : $this$toHeaders.entrySet()) {
                String k = (String)entry.getKey();
                String v = (String)entry.getValue();
                String name = StringsKt.trim((CharSequence)k).toString();
                String value = StringsKt.trim((CharSequence)v).toString();
                this.checkName(name);
                this.checkValue(value, name);
                namesAndValues[i] = name;
                namesAndValues[i + 1] = value;
                i += 2;
            }
            return new Headers(namesAndValues, null);
        }

        @Deprecated(message="function moved to extension", replaceWith=@ReplaceWith(expression="headers.toHeaders()", imports={}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_of")
        @NotNull
        public final Headers -deprecated_of(@NotNull Map<String, String> headers) {
            Intrinsics.checkNotNullParameter(headers, (String)"headers");
            return this.of(headers);
        }

        private final void checkName(String name) {
            if (!(((CharSequence)name).length() > 0)) {
                boolean bl = false;
                String string = "name is empty";
                throw new IllegalArgumentException(string.toString());
            }
            int n = name.length();
            for (int i = 0; i < n; ++i) {
                char c = name.charAt(i);
                if ('!' <= c ? c < '' : false) continue;
                boolean bl = false;
                Object[] objectArray = new Object[]{(int)c, i, name};
                String string = Util.format("Unexpected char %#04x at %d in header name: %s", objectArray);
                throw new IllegalArgumentException(string.toString());
            }
        }

        /*
         * Unable to fully structure code
         */
        private final void checkValue(String value, String name) {
            var4_4 = value.length();
            for (i = 0; i < var4_4; ++i) {
                c = value.charAt(i);
                if (c == '\t') ** GOTO lbl-1000
                v0 = ' ' <= c ? c < '' : false;
                if (v0) lbl-1000:
                // 2 sources

                {
                    v1 = true;
                } else {
                    v1 = false;
                }
                if (v1) continue;
                $i$a$-require-Headers$Companion$checkValue$1 = false;
                var7_8 = new Object[]{(int)c, i, name};
                var6_7 = Util.format("Unexpected char %#04x at %d in %s value", var7_8) + (Util.isSensitiveHeader(name) != false ? "" : ": " + value);
                throw new IllegalArgumentException(var6_7.toString());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

