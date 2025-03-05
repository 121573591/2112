/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.io.checksum.crc16;

import cn.hutool.core.io.checksum.crc16.CRC16Checksum;

public class CRC16USB
extends CRC16Checksum {
    private static final long serialVersionUID = 1L;
    private static final int WC_POLY = 40961;

    @Override
    public void reset() {
        this.wCRCin = 65535;
    }

    @Override
    public void update(byte[] b, int off, int len) {
        super.update(b, off, len);
        this.wCRCin ^= 0xFFFF;
    }

    public void update(int b) {
        this.wCRCin ^= b & 0xFF;
        for (int j = 0; j < 8; ++j) {
            if ((this.wCRCin & 1) != 0) {
                this.wCRCin >>= 1;
                this.wCRCin ^= 0xA001;
                continue;
            }
            this.wCRCin >>= 1;
        }
    }
}

