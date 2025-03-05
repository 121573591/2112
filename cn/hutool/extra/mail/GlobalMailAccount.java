/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.extra.mail;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.extra.mail.MailAccount;

public enum GlobalMailAccount {
    INSTANCE;

    private final MailAccount mailAccount = this.createDefaultAccount();

    public MailAccount getAccount() {
        return this.mailAccount;
    }

    private MailAccount createDefaultAccount() {
        for (String mailSettingPath : MailAccount.MAIL_SETTING_PATHS) {
            try {
                return new MailAccount(mailSettingPath);
            }
            catch (IORuntimeException iORuntimeException) {
            }
        }
        return null;
    }
}

