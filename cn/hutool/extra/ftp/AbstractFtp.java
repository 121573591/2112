/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.List
 */
package cn.hutool.extra.ftp;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.ftp.FtpConfig;
import cn.hutool.extra.ftp.FtpException;
import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

public abstract class AbstractFtp
implements Closeable {
    public static final Charset DEFAULT_CHARSET = CharsetUtil.CHARSET_UTF_8;
    protected FtpConfig ftpConfig;

    protected AbstractFtp(FtpConfig config) {
        this.ftpConfig = config;
    }

    public abstract AbstractFtp reconnectIfTimeout();

    public abstract boolean cd(String var1);

    public boolean toParent() {
        return this.cd("..");
    }

    public abstract String pwd();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isDir(String dir) {
        String workDir = this.pwd();
        try {
            boolean bl = this.cd(dir);
            return bl;
        }
        finally {
            this.cd(workDir);
        }
    }

    public abstract boolean mkdir(String var1);

    public boolean exist(String path) {
        List<String> names;
        if (StrUtil.isBlank(path)) {
            return false;
        }
        if (this.isDir(path)) {
            return true;
        }
        if (CharUtil.isFileSeparator(path.charAt(path.length() - 1))) {
            return false;
        }
        String fileName = FileUtil.getName(path);
        if (".".equals((Object)fileName) || "..".equals((Object)fileName)) {
            return false;
        }
        String dir = StrUtil.emptyToDefault(StrUtil.removeSuffix(path, fileName), ".");
        if (!this.isDir(dir)) {
            return false;
        }
        try {
            names = this.ls(dir);
        }
        catch (FtpException ignore) {
            return false;
        }
        return AbstractFtp.containsIgnoreCase(names, fileName);
    }

    public abstract List<String> ls(String var1);

    public abstract boolean delFile(String var1);

    public abstract boolean delDir(String var1);

    public void mkDirs(String dir) {
        String[] dirs = StrUtil.trim(dir).split("[\\\\/]+");
        String now = this.pwd();
        if (dirs.length > 0 && StrUtil.isEmpty(dirs[0])) {
            this.cd("/");
        }
        for (String s : dirs) {
            if (!StrUtil.isNotEmpty(s)) continue;
            boolean exist = true;
            try {
                if (!this.cd(s)) {
                    exist = false;
                }
            }
            catch (FtpException e) {
                exist = false;
            }
            if (exist) continue;
            this.mkdir(s);
            this.cd(s);
        }
        this.cd(now);
    }

    public abstract boolean upload(String var1, File var2);

    public abstract void download(String var1, File var2);

    public void download(String path, File outFile, String tempFileSuffix) {
        tempFileSuffix = StrUtil.isBlank(tempFileSuffix) ? ".temp" : StrUtil.addPrefixIfNot(tempFileSuffix, ".");
        String fileName = outFile.isDirectory() ? FileUtil.getName(path) : outFile.getName();
        String tempFileName = fileName + tempFileSuffix;
        outFile = new File(outFile.isDirectory() ? outFile : outFile.getParentFile(), tempFileName);
        try {
            this.download(path, outFile);
            FileUtil.rename(outFile, fileName, true);
        }
        catch (Throwable e) {
            FileUtil.del(outFile);
            throw new FtpException(e);
        }
    }

    public abstract void recursiveDownloadFolder(String var1, File var2);

    private static boolean containsIgnoreCase(List<String> names, String nameToFind) {
        if (CollUtil.isEmpty(names)) {
            return false;
        }
        if (StrUtil.isEmpty(nameToFind)) {
            return false;
        }
        for (String name : names) {
            if (!nameToFind.equalsIgnoreCase(name)) continue;
            return true;
        }
        return false;
    }
}

