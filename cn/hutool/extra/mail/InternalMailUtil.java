/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  javax.mail.internet.AddressException
 *  javax.mail.internet.InternetAddress
 *  javax.mail.internet.MimeUtility
 */
package cn.hutool.extra.mail;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.extra.mail.MailException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;

public class InternalMailUtil {
    public static InternetAddress[] parseAddressFromStrs(String[] addrStrs, Charset charset) {
        ArrayList resultList = new ArrayList(addrStrs.length);
        for (String addrStr : addrStrs) {
            Object[] addrs = InternalMailUtil.parseAddress(addrStr, charset);
            if (!ArrayUtil.isNotEmpty(addrs)) continue;
            Collections.addAll((Collection)resultList, (Object[])addrs);
        }
        return (InternetAddress[])resultList.toArray((Object[])new InternetAddress[0]);
    }

    public static InternetAddress parseFirstAddress(String address, Charset charset) {
        InternetAddress[] internetAddresses = InternalMailUtil.parseAddress(address, charset);
        if (ArrayUtil.isEmpty(internetAddresses)) {
            try {
                return new InternetAddress(address);
            }
            catch (AddressException e) {
                throw new MailException(e);
            }
        }
        return internetAddresses[0];
    }

    public static InternetAddress[] parseAddress(String address, Charset charset) {
        InternetAddress[] addresses;
        try {
            addresses = InternetAddress.parse((String)address);
        }
        catch (AddressException e) {
            throw new MailException(e);
        }
        if (ArrayUtil.isNotEmpty(addresses)) {
            String charsetStr = null == charset ? null : charset.name();
            for (InternetAddress internetAddress : addresses) {
                try {
                    internetAddress.setPersonal(internetAddress.getPersonal(), charsetStr);
                }
                catch (UnsupportedEncodingException e) {
                    throw new MailException(e);
                }
            }
        }
        return addresses;
    }

    public static String encodeText(String text, Charset charset) {
        try {
            return MimeUtility.encodeText((String)text, (String)charset.name(), null);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return text;
        }
    }
}

