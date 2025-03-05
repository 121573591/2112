/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.UnsatisfiedLinkError
 *  java.lang.UnsupportedOperationException
 *  java.nio.file.CopyOption
 *  java.nio.file.Files
 *  java.nio.file.Path
 *  java.nio.file.StandardCopyOption
 *  java.util.ServiceLoader
 */
package com.aayushatharva.brotli4j;

import com.aayushatharva.brotli4j.service.BrotliNativeProvider;
import java.io.File;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ServiceLoader;

public class Brotli4jLoader {
    private static final Throwable UNAVAILABILITY_CAUSE;

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static void ensureAvailability() {
        if (UNAVAILABILITY_CAUSE != null) {
            UnsatisfiedLinkError error = new UnsatisfiedLinkError("Failed to load Brotli native library");
            error.initCause(UNAVAILABILITY_CAUSE);
            throw error;
        }
    }

    public static Throwable getUnavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    private static String getPlatform() {
        String osName = System.getProperty((String)"os.name");
        String archName = System.getProperty((String)"os.arch");
        if ("Linux".equalsIgnoreCase(osName)) {
            if ("amd64".equalsIgnoreCase(archName)) {
                return "linux-x86_64";
            }
            if ("aarch64".equalsIgnoreCase(archName)) {
                return "linux-aarch64";
            }
            if ("arm".equalsIgnoreCase(archName)) {
                return "linux-armv7";
            }
            if ("s390x".equalsIgnoreCase(archName)) {
                return "linux-s390x";
            }
            if ("ppc64le".equalsIgnoreCase(archName)) {
                return "linux-ppc64le";
            }
            if ("riscv64".equalsIgnoreCase(archName)) {
                return "linux-riscv64";
            }
        } else if (osName.startsWith("Windows")) {
            if ("amd64".equalsIgnoreCase(archName)) {
                return "windows-x86_64";
            }
            if ("aarch64".equalsIgnoreCase(archName)) {
                return "windows-aarch64";
            }
        } else if (osName.startsWith("Mac")) {
            if ("x86_64".equalsIgnoreCase(archName)) {
                return "osx-x86_64";
            }
            if ("aarch64".equalsIgnoreCase(archName)) {
                return "osx-aarch64";
            }
        }
        throw new UnsupportedOperationException("Unsupported OS and Architecture: " + osName + ", " + archName);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        Throwable cause = null;
        String customPath = System.getProperty((String)"brotli4j.library.path");
        if (customPath != null) {
            try {
                System.load((String)customPath);
            }
            catch (Throwable throwable) {
                cause = throwable;
            }
        } else {
            try {
                System.loadLibrary((String)"brotli");
            }
            catch (Throwable t) {
                try {
                    String nativeLibName = System.mapLibraryName((String)"brotli");
                    String platform = Brotli4jLoader.getPlatform();
                    String libPath = "/lib/" + platform + '/' + nativeLibName;
                    File tempDir = new File(System.getProperty((String)"java.io.tmpdir"), "com_aayushatharva_brotli4j_" + System.nanoTime());
                    tempDir.mkdir();
                    tempDir.deleteOnExit();
                    File tempFile = new File(tempDir, nativeLibName);
                    Class loaderClassToUse = Brotli4jLoader.class;
                    ServiceLoader nativeProviders = ServiceLoader.load(BrotliNativeProvider.class, (ClassLoader)Brotli4jLoader.class.getClassLoader());
                    for (BrotliNativeProvider nativeProvider : nativeProviders) {
                        if (!nativeProvider.platformName().equals((Object)platform)) continue;
                        loaderClassToUse = nativeProvider.getClass();
                        break;
                    }
                    try (InputStream in = loaderClassToUse.getResourceAsStream(libPath);){
                        if (in == null) {
                            throw new UnsatisfiedLinkError("Failed to find Brotli native library in classpath: " + libPath);
                        }
                        Files.copy((InputStream)in, (Path)tempFile.toPath(), (CopyOption[])new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                        System.load((String)tempFile.getAbsolutePath());
                    }
                    finally {
                        tempFile.deleteOnExit();
                    }
                }
                catch (Throwable throwable) {
                    cause = throwable;
                }
            }
        }
        UNAVAILABILITY_CAUSE = cause;
    }
}

