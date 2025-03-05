/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Properties
 *  javax.mail.Session
 */
package cn.hutool.extra.mail;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.GlobalMailAccount;
import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.UserPassAuthenticator;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Session;

public class MailUtil {
    public static String sendText(String to, String subject, String content, File ... files) {
        return MailUtil.send(to, subject, content, false, files);
    }

    public static String sendHtml(String to, String subject, String content, File ... files) {
        return MailUtil.send(to, subject, content, true, files);
    }

    public static String send(String to, String subject, String content, boolean isHtml, File ... files) {
        return MailUtil.send(MailUtil.splitAddress(to), subject, content, isHtml, files);
    }

    public static String send(String to, String cc, String bcc, String subject, String content, boolean isHtml, File ... files) {
        return MailUtil.send(MailUtil.splitAddress(to), MailUtil.splitAddress(cc), MailUtil.splitAddress(bcc), subject, content, isHtml, files);
    }

    public static String sendText(Collection<String> tos, String subject, String content, File ... files) {
        return MailUtil.send(tos, subject, content, false, files);
    }

    public static String sendHtml(Collection<String> tos, String subject, String content, File ... files) {
        return MailUtil.send(tos, subject, content, true, files);
    }

    public static String send(Collection<String> tos, String subject, String content, boolean isHtml, File ... files) {
        return MailUtil.send(tos, null, null, subject, content, isHtml, files);
    }

    public static String send(Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content, boolean isHtml, File ... files) {
        return MailUtil.send(GlobalMailAccount.INSTANCE.getAccount(), true, tos, ccs, bccs, subject, content, null, isHtml, files);
    }

    public static String send(MailAccount mailAccount, String to, String subject, String content, boolean isHtml, File ... files) {
        return MailUtil.send(mailAccount, MailUtil.splitAddress(to), subject, content, isHtml, files);
    }

    public static String send(MailAccount mailAccount, Collection<String> tos, String subject, String content, boolean isHtml, File ... files) {
        return MailUtil.send(mailAccount, tos, null, null, subject, content, isHtml, files);
    }

    public static String send(MailAccount mailAccount, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content, boolean isHtml, File ... files) {
        return MailUtil.send(mailAccount, false, tos, ccs, bccs, subject, content, null, isHtml, files);
    }

    public static String sendHtml(String to, String subject, String content, Map<String, InputStream> imageMap, File ... files) {
        return MailUtil.send(to, subject, content, imageMap, true, files);
    }

    public static String send(String to, String subject, String content, Map<String, InputStream> imageMap, boolean isHtml, File ... files) {
        return MailUtil.send(MailUtil.splitAddress(to), subject, content, imageMap, isHtml, files);
    }

    public static String send(String to, String cc, String bcc, String subject, String content, Map<String, InputStream> imageMap, boolean isHtml, File ... files) {
        return MailUtil.send(MailUtil.splitAddress(to), MailUtil.splitAddress(cc), MailUtil.splitAddress(bcc), subject, content, imageMap, isHtml, files);
    }

    public static String sendHtml(Collection<String> tos, String subject, String content, Map<String, InputStream> imageMap, File ... files) {
        return MailUtil.send(tos, subject, content, imageMap, true, files);
    }

    public static String send(Collection<String> tos, String subject, String content, Map<String, InputStream> imageMap, boolean isHtml, File ... files) {
        return MailUtil.send(tos, null, null, subject, content, imageMap, isHtml, files);
    }

    public static String send(Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content, Map<String, InputStream> imageMap, boolean isHtml, File ... files) {
        return MailUtil.send(GlobalMailAccount.INSTANCE.getAccount(), true, tos, ccs, bccs, subject, content, imageMap, isHtml, files);
    }

    public static String send(MailAccount mailAccount, String to, String subject, String content, Map<String, InputStream> imageMap, boolean isHtml, File ... files) {
        return MailUtil.send(mailAccount, MailUtil.splitAddress(to), subject, content, imageMap, isHtml, files);
    }

    public static String send(MailAccount mailAccount, Collection<String> tos, String subject, String content, Map<String, InputStream> imageMap, boolean isHtml, File ... files) {
        return MailUtil.send(mailAccount, tos, null, null, subject, content, imageMap, isHtml, files);
    }

    public static String send(MailAccount mailAccount, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content, Map<String, InputStream> imageMap, boolean isHtml, File ... files) {
        return MailUtil.send(mailAccount, false, tos, ccs, bccs, subject, content, imageMap, isHtml, files);
    }

    public static Session getSession(MailAccount mailAccount, boolean isSingleton) {
        UserPassAuthenticator authenticator = null;
        if (mailAccount.isAuth().booleanValue()) {
            authenticator = new UserPassAuthenticator(mailAccount.getUser(), mailAccount.getPass());
        }
        return isSingleton ? Session.getDefaultInstance((Properties)mailAccount.getSmtpProps(), authenticator) : Session.getInstance((Properties)mailAccount.getSmtpProps(), authenticator);
    }

    private static String send(MailAccount mailAccount, boolean useGlobalSession, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content, Map<String, InputStream> imageMap, boolean isHtml, File ... files) {
        Mail mail = Mail.create(mailAccount).setUseGlobalSession(useGlobalSession);
        if (CollUtil.isNotEmpty(ccs)) {
            mail.setCcs((String[])ccs.toArray((Object[])new String[0]));
        }
        if (CollUtil.isNotEmpty(bccs)) {
            mail.setBccs((String[])bccs.toArray((Object[])new String[0]));
        }
        mail.setTos((String[])tos.toArray((Object[])new String[0]));
        mail.setTitle(subject);
        mail.setContent(content);
        mail.setHtml(isHtml);
        mail.setFiles(files);
        if (MapUtil.isNotEmpty(imageMap)) {
            for (Map.Entry entry : imageMap.entrySet()) {
                mail.addImage((String)entry.getKey(), (InputStream)entry.getValue());
                IoUtil.close((Closeable)entry.getValue());
            }
        }
        return mail.send();
    }

    private static List<String> splitAddress(String addresses) {
        if (StrUtil.isBlank(addresses)) {
            return null;
        }
        Object result = StrUtil.contains((CharSequence)addresses, ',') ? StrUtil.splitTrim((CharSequence)addresses, ',') : (StrUtil.contains((CharSequence)addresses, ';') ? StrUtil.splitTrim((CharSequence)addresses, ';') : CollUtil.newArrayList(addresses));
        return result;
    }
}

