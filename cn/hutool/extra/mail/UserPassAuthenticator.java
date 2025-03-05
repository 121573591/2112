/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  javax.mail.Authenticator
 *  javax.mail.PasswordAuthentication
 */
package cn.hutool.extra.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class UserPassAuthenticator
extends Authenticator {
    private final String user;
    private final String pass;

    public UserPassAuthenticator(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.user, this.pass);
    }
}

