/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.io.checksum.crc16;

import cn.hutool.core.io.checksum.crc16.CRC16Checksum;

public class CRC16Ansi
extends CRC16Checksum {
    private static final long serialVersionUID = 1L;
    private static final int WC_POLY = 40961;

    @Override
    public void reset() {
        this.wCRCin = 65535;
    }

    public void update(int b) {
        int hi = this.wCRCin >> 8;
        this.wCRCin = hi ^= b;
        for (int i = 0; i < 8; ++i) {
            int flag = this.wCRCin & 1;
            this.wCRCin >>= 1;
            if (flag != 1) continue;
            this.wCRCin ^= 0xA001;
        }
    }
}

