/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.Date
 *  javax.activation.DataHandler
 *  javax.activation.DataSource
 *  javax.activation.FileDataSource
 *  javax.activation.FileTypeMap
 *  javax.mail.Address
 *  javax.mail.BodyPart
 *  javax.mail.Message
 *  javax.mail.MessagingException
 *  javax.mail.Multipart
 *  javax.mail.SendFailedException
 *  javax.mail.Session
 *  javax.mail.Transport
 *  javax.mail.internet.MimeBodyPart
 *  javax.mail.internet.MimeMessage
 *  javax.mail.internet.MimeMessage$RecipientType
 *  javax.mail.internet.MimeMultipart
 *  javax.mail.internet.MimeUtility
 *  javax.mail.util.ByteArrayDataSource
 */
package cn.hutool.extra.mail;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.GlobalMailAccount;
import cn.hutool.extra.mail.InternalMailUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailException;
import cn.hutool.extra.mail.MailUtil;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Date;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.FileTypeMap;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

public class Mail
implements Builder<MimeMessage> {
    private static final long serialVersionUID = 1L;
    private final MailAccount mailAccount;
    private String[] tos;
    private String[] ccs;
    private String[] bccs;
    private String[] reply;
    private String title;
    private String content;
    private boolean isHtml;
    private final Multipart multipart = new MimeMultipart();
    private boolean useGlobalSession = false;
    private PrintStream debugOutput;

    public static Mail create(MailAccount mailAccount) {
        return new Mail(mailAccount);
    }

    public static Mail create() {
        return new Mail();
    }

    public Mail() {
        this(GlobalMailAccount.INSTANCE.getAccount());
    }

    public Mail(MailAccount mailAccount) {
        mailAccount = null != mailAccount ? mailAccount : GlobalMailAccount.INSTANCE.getAccount();
        this.mailAccount = mailAccount.defaultIfEmpty();
    }

    public Mail to(String ... tos) {
        return this.setTos(tos);
    }

    public Mail setTos(String ... tos) {
        this.tos = tos;
        return this;
    }

    public Mail setCcs(String ... ccs) {
        this.ccs = ccs;
        return this;
    }

    public Mail setBccs(String ... bccs) {
        this.bccs = bccs;
        return this;
    }

    public Mail setReply(String ... reply) {
        this.reply = reply;
        return this;
    }

    public Mail setTitle(String title) {
        this.title = title;
        return this;
    }

    public Mail setContent(String content) {
        this.content = content;
        return this;
    }

    public Mail setHtml(boolean isHtml) {
        this.isHtml = isHtml;
        return this;
    }

    public Mail setContent(String content, boolean isHtml) {
        this.setContent(content);
        return this.setHtml(isHtml);
    }

    public Mail setFiles(File ... files) {
        if (ArrayUtil.isEmpty(files)) {
            return this;
        }
        DataSource[] attachments = new DataSource[files.length];
        for (int i = 0; i < files.length; ++i) {
            attachments[i] = new FileDataSource(files[i]);
        }
        return this.setAttachments(attachments);
    }

    public Mail setAttachments(DataSource ... attachments) {
        if (ArrayUtil.isNotEmpty(attachments)) {
            Charset charset = this.mailAccount.getCharset();
            try {
                for (DataSource attachment : attachments) {
                    MimeBodyPart bodyPart = new MimeBodyPart();
                    bodyPart.setDataHandler(new DataHandler(attachment));
                    String nameEncoded = attachment.getName();
                    if (this.mailAccount.isEncodefilename()) {
                        nameEncoded = InternalMailUtil.encodeText(nameEncoded, charset);
                    }
                    bodyPart.setFileName(nameEncoded);
                    if (StrUtil.startWith((CharSequence)attachment.getContentType(), "image/")) {
                        bodyPart.setContentID(nameEncoded);
                    }
                    this.multipart.addBodyPart((BodyPart)bodyPart);
                }
            }
            catch (MessagingException e) {
                throw new MailException(e);
            }
        }
        return this;
    }

    public Mail addImage(String cid, InputStream imageStream) {
        return this.addImage(cid, imageStream, null);
    }

    public Mail addImage(String cid, InputStream imageStream, String contentType) {
        ByteArrayDataSource imgSource;
        try {
            imgSource = new ByteArrayDataSource(imageStream, ObjectUtil.defaultIfNull(contentType, "image/jpeg"));
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        imgSource.setName(cid);
        return this.setAttachments(new DataSource[]{imgSource});
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Mail addImage(String cid, File imageFile) {
        BufferedInputStream in = null;
        try {
            in = FileUtil.getInputStream(imageFile);
            Mail mail = this.addImage(cid, (InputStream)in, FileTypeMap.getDefaultFileTypeMap().getContentType(imageFile));
            return mail;
        }
        finally {
            IoUtil.close((Closeable)in);
        }
    }

    public Mail setCharset(Charset charset) {
        this.mailAccount.setCharset(charset);
        return this;
    }

    public Mail setUseGlobalSession(boolean isUseGlobalSession) {
        this.useGlobalSession = isUseGlobalSession;
        return this;
    }

    public Mail setDebugOutput(PrintStream debugOutput) {
        this.debugOutput = debugOutput;
        return this;
    }

    @Override
    public MimeMessage build() {
        try {
            return this.buildMsg();
        }
        catch (MessagingException e) {
            throw new MailException(e);
        }
    }

    public String send() throws MailException {
        try {
            return this.doSend();
        }
        catch (MessagingException e) {
            if (e instanceof SendFailedException) {
                Address[] invalidAddresses = ((SendFailedException)e).getInvalidAddresses();
                String msg = StrUtil.format("Invalid Addresses: {}", ArrayUtil.toString(invalidAddresses));
                throw new MailException(msg, e);
            }
            throw new MailException(e);
        }
    }

    private String doSend() throws MessagingException {
        MimeMessage mimeMessage = this.buildMsg();
        Transport.send((Message)mimeMessage);
        return mimeMessage.getMessageID();
    }

    private MimeMessage buildMsg() throws MessagingException {
        Charset charset = this.mailAccount.getCharset();
        MimeMessage msg = new MimeMessage(this.getSession());
        String from = this.mailAccount.getFrom();
        if (StrUtil.isEmpty(from)) {
            msg.setFrom();
        } else {
            msg.setFrom((Address)InternalMailUtil.parseFirstAddress(from, charset));
        }
        msg.setSubject(this.title, null == charset ? null : charset.name());
        msg.setSentDate(new Date());
        msg.setContent(this.buildContent(charset));
        msg.setRecipients(MimeMessage.RecipientType.TO, (Address[])InternalMailUtil.parseAddressFromStrs(this.tos, charset));
        if (ArrayUtil.isNotEmpty(this.ccs)) {
            msg.setRecipients(MimeMessage.RecipientType.CC, (Address[])InternalMailUtil.parseAddressFromStrs(this.ccs, charset));
        }
        if (ArrayUtil.isNotEmpty(this.bccs)) {
            msg.setRecipients(MimeMessage.RecipientType.BCC, (Address[])InternalMailUtil.parseAddressFromStrs(this.bccs, charset));
        }
        if (ArrayUtil.isNotEmpty(this.reply)) {
            msg.setReplyTo((Address[])InternalMailUtil.parseAddressFromStrs(this.reply, charset));
        }
        return msg;
    }

    private Multipart buildContent(Charset charset) throws MessagingException {
        String charsetStr = null != charset ? charset.name() : MimeUtility.getDefaultJavaCharset();
        MimeBodyPart body = new MimeBodyPart();
        body.setContent((Object)this.content, StrUtil.format("text/{}; charset={}", this.isHtml ? "html" : "plain", charsetStr));
        this.multipart.addBodyPart((BodyPart)body);
        return this.multipart;
    }

    private Session getSession() {
        Session session = MailUtil.getSession(this.mailAccount, this.useGlobalSession);
        if (null != this.debugOutput) {
            session.setDebugOut(this.debugOutput);
        }
        return session;
    }
}

