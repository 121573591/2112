/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"  \n\n \n\n\b\n\n\b\n\n\b\b   20:B%\b0\b0\b0¢\bJ\n02\t0\b¢\b\nJ0\r2\b\f0¢\bR08X¢\n\bR08X¢\n\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/platform/android/CloseGuard;", "", "Ljava/lang/reflect/Method;", "getMethod", "openMethod", "warnIfOpenMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "", "closer", "createAndOpen", "(Ljava/lang/String;)Ljava/lang/Object;", "closeGuardInstance", "", "warnIfOpen", "(Ljava/lang/Object;)Z", "Ljava/lang/reflect/Method;", "Companion", "okhttp"})
public final class CloseGuard {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Method getMethod;
    @Nullable
    private final Method openMethod;
    @Nullable
    private final Method warnIfOpenMethod;

    public CloseGuard(@Nullable Method getMethod, @Nullable Method openMethod, @Nullable Method warnIfOpenMethod) {
        this.getMethod = getMethod;
        this.openMethod = openMethod;
        this.warnIfOpenMethod = warnIfOpenMethod;
    }

    @Nullable
    public final Object createAndOpen(@NotNull String closer) {
        Intrinsics.checkNotNullParameter((Object)closer, (String)"closer");
        if (this.getMethod != null) {
            try {
                Object closeGuardInstance = this.getMethod.invoke(null, new Object[0]);
                Method method = this.openMethod;
                Intrinsics.checkNotNull((Object)method);
                Object[] objectArray = new Object[]{closer};
                method.invoke(closeGuardInstance, objectArray);
                return closeGuardInstance;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    public final boolean warnIfOpen(@Nullable Object closeGuardInstance) {
        boolean reported = false;
        if (closeGuardInstance != null) {
            try {
                Method method = this.warnIfOpenMethod;
                Intrinsics.checkNotNull((Object)method);
                method.invoke(closeGuardInstance, new Object[0]);
                reported = true;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return reported;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\b\b 20B\t\b¢\bJ\r0¢\b¨"}, d2={"Lokhttp3/internal/platform/android/CloseGuard$Companion;", "", "<init>", "()V", "Lokhttp3/internal/platform/android/CloseGuard;", "get", "()Lokhttp3/internal/platform/android/CloseGuard;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CloseGuard get() {
            Method getMethod = null;
            Method openMethod = null;
            Method warnIfOpenMethod = null;
            try {
                Class closeGuardClass = Class.forName((String)"dalvik.system.CloseGuard");
                getMethod = closeGuardClass.getMethod("get", new Class[0]);
                Class[] classArray = new Class[]{String.class};
                openMethod = closeGuardClass.getMethod("open", classArray);
                warnIfOpenMethod = closeGuardClass.getMethod("warnIfOpen", new Class[0]);
            }
            catch (Exception _) {
                getMethod = null;
                openMethod = null;
                warnIfOpenMethod = null;
            }
            return new CloseGuard(getMethod, openMethod, warnIfOpenMethod);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

