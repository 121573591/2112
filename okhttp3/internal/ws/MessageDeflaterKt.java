/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.ws;

import kotlin.Metadata;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={" \n\n\b\n\b\n\b\"0 8X¢\n\b\"08XT¢\n\b¨"}, d2={"Lokio/ByteString;", "EMPTY_DEFLATE_BLOCK", "Lokio/ByteString;", "", "LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION", "I", "okhttp"})
public final class MessageDeflaterKt {
    @NotNull
    private static final ByteString EMPTY_DEFLATE_BLOCK = ByteString.Companion.decodeHex("000000ffff");
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    public static final /* synthetic */ ByteString access$getEMPTY_DEFLATE_BLOCK$p() {
        return EMPTY_DEFLATE_BLOCK;
    }
}

