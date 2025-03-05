/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package net.lingala.zip4j.model;

import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.model.DigitalSignature;
import net.lingala.zip4j.model.FileHeader;

public class CentralDirectory {
    private List<FileHeader> fileHeaders = new ArrayList();
    private DigitalSignature digitalSignature = new DigitalSignature();

    public List<FileHeader> getFileHeaders() {
        return this.fileHeaders;
    }

    public void setFileHeaders(List<FileHeader> fileHeaders) {
        this.fileHeaders = fileHeaders;
    }

    public DigitalSignature getDigitalSignature() {
        return this.digitalSignature;
    }

    public void setDigitalSignature(DigitalSignature digitalSignature) {
        this.digitalSignature = digitalSignature;
    }
}

