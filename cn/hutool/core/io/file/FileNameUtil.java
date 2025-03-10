/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Pattern
 */
package cn.hutool.core.io.file;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import java.io.File;
import java.util.regex.Pattern;

public class FileNameUtil {
    public static final String EXT_JAVA = ".java";
    public static final String EXT_CLASS = ".class";
    public static final String EXT_JAR = ".jar";
    public static final char UNIX_SEPARATOR = '/';
    public static final char WINDOWS_SEPARATOR = '\\';
    private static final Pattern FILE_NAME_INVALID_PATTERN_WIN = Pattern.compile((String)"[\\\\/:*?\"<>|\r\n]");
    private static final CharSequence[] SPECIAL_SUFFIX = new CharSequence[]{"tar.bz2", "tar.Z", "tar.gz", "tar.xz"};

    public static String getName(File file) {
        return null != file ? file.getName() : null;
    }

    public static String getName(String filePath) {
        if (null == filePath) {
            return null;
        }
        int len = filePath.length();
        if (0 == len) {
            return filePath;
        }
        if (CharUtil.isFileSeparator(filePath.charAt(len - 1))) {
            --len;
        }
        int begin = 0;
        for (int i = len - 1; i > -1; --i) {
            char c = filePath.charAt(i);
            if (!CharUtil.isFileSeparator(c)) continue;
            begin = i + 1;
            break;
        }
        return filePath.substring(begin, len);
    }

    public static String getSuffix(File file) {
        return FileNameUtil.extName(file);
    }

    public static String getSuffix(String fileName) {
        return FileNameUtil.extName(fileName);
    }

    public static String getPrefix(File file) {
        return FileNameUtil.mainName(file);
    }

    public static String getPrefix(String fileName) {
        return FileNameUtil.mainName(fileName);
    }

    public static String mainName(File file) {
        if (file.isDirectory()) {
            return file.getName();
        }
        return FileNameUtil.mainName(file.getName());
    }

    public static String mainName(String fileName) {
        if (null == fileName) {
            return null;
        }
        int len = fileName.length();
        if (0 == len) {
            return fileName;
        }
        for (CharSequence specialSuffix : SPECIAL_SUFFIX) {
            if (!StrUtil.endWith((CharSequence)fileName, "." + specialSuffix)) continue;
            return StrUtil.subPre(fileName, len - specialSuffix.length() - 1);
        }
        if (CharUtil.isFileSeparator(fileName.charAt(len - 1))) {
            --len;
        }
        int begin = 0;
        int end = len;
        for (int i = len - 1; i >= 0; --i) {
            char c = fileName.charAt(i);
            if (len == end && '.' == c) {
                end = i;
            }
            if (!CharUtil.isFileSeparator(c)) continue;
            begin = i + 1;
            break;
        }
        return fileName.substring(begin, end);
    }

    public static String extName(File file) {
        if (null == file) {
            return null;
        }
        if (file.isDirectory()) {
            return null;
        }
        return FileNameUtil.extName(file.getName());
    }

    public static String extName(String fileName) {
        if (fileName == null) {
            return null;
        }
        int index = fileName.lastIndexOf(".");
        if (index == -1) {
            return "";
        }
        int secondToLastIndex = fileName.substring(0, index).lastIndexOf(".");
        String substr = fileName.substring(secondToLastIndex == -1 ? index : secondToLastIndex + 1);
        if (StrUtil.containsAny((CharSequence)substr, SPECIAL_SUFFIX)) {
            return substr;
        }
        String ext = fileName.substring(index + 1);
        return StrUtil.containsAny((CharSequence)ext, '/', '\\') ? "" : ext;
    }

    public static String cleanInvalid(String fileName) {
        return StrUtil.isBlank(fileName) ? fileName : ReUtil.delAll(FILE_NAME_INVALID_PATTERN_WIN, (CharSequence)fileName);
    }

    public static boolean containsInvalid(String fileName) {
        return false == StrUtil.isBlank(fileName) && ReUtil.contains(FILE_NAME_INVALID_PATTERN_WIN, (CharSequence)fileName);
    }

    public static boolean isType(String fileName, String ... extNames) {
        return StrUtil.equalsAnyIgnoreCase(FileNameUtil.extName(fileName), extNames);
    }
}

