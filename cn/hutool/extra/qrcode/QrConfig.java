/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.zxing.BarcodeFormat
 *  com.google.zxing.EncodeHintType
 *  com.google.zxing.datamatrix.encoder.SymbolShapeHint
 *  com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
 *  java.awt.Color
 *  java.awt.Image
 *  java.io.File
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.HashMap
 */
package cn.hutool.extra.qrcode;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;

public class QrConfig {
    private static final int BLACK = -16777216;
    private static final int WHITE = -1;
    protected int width;
    protected int height;
    protected Integer foreColor = -16777216;
    protected Integer backColor = -1;
    protected Integer margin = 2;
    protected Integer qrVersion;
    protected ErrorCorrectionLevel errorCorrection = ErrorCorrectionLevel.M;
    protected Charset charset = CharsetUtil.CHARSET_UTF_8;
    protected Image img;
    protected int ratio = 6;
    protected SymbolShapeHint shapeHint = SymbolShapeHint.FORCE_NONE;

    public static QrConfig create() {
        return new QrConfig();
    }

    public QrConfig() {
        this(300, 300);
    }

    public QrConfig(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public QrConfig setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return this.height;
    }

    public QrConfig setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getForeColor() {
        return this.foreColor;
    }

    @Deprecated
    public QrConfig setForeColor(int foreColor) {
        this.foreColor = foreColor;
        return this;
    }

    public QrConfig setForeColor(Color foreColor) {
        this.foreColor = null == foreColor ? null : Integer.valueOf((int)foreColor.getRGB());
        return this;
    }

    public int getBackColor() {
        return this.backColor;
    }

    @Deprecated
    public QrConfig setBackColor(int backColor) {
        this.backColor = backColor;
        return this;
    }

    public QrConfig setBackColor(Color backColor) {
        this.backColor = null == backColor ? null : Integer.valueOf((int)backColor.getRGB());
        return this;
    }

    public Integer getMargin() {
        return this.margin;
    }

    public QrConfig setMargin(Integer margin) {
        this.margin = margin;
        return this;
    }

    public Integer getQrVersion() {
        return this.qrVersion;
    }

    public QrConfig setQrVersion(Integer qrVersion) {
        this.qrVersion = qrVersion;
        return this;
    }

    public ErrorCorrectionLevel getErrorCorrection() {
        return this.errorCorrection;
    }

    public QrConfig setErrorCorrection(ErrorCorrectionLevel errorCorrection) {
        this.errorCorrection = errorCorrection;
        return this;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public QrConfig setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public Image getImg() {
        return this.img;
    }

    public QrConfig setImg(String imgPath) {
        return this.setImg(FileUtil.file(imgPath));
    }

    public QrConfig setImg(File imgFile) {
        return this.setImg((Image)ImgUtil.read(imgFile));
    }

    public QrConfig setImg(Image img) {
        this.img = img;
        return this;
    }

    public int getRatio() {
        return this.ratio;
    }

    public QrConfig setRatio(int ratio) {
        this.ratio = ratio;
        return this;
    }

    public QrConfig setShapeHint(SymbolShapeHint shapeHint) {
        this.shapeHint = shapeHint;
        return this;
    }

    public HashMap<EncodeHintType, Object> toHints() {
        return this.toHints(BarcodeFormat.QR_CODE);
    }

    public HashMap<EncodeHintType, Object> toHints(BarcodeFormat format) {
        HashMap hints = new HashMap();
        if (null != this.charset) {
            hints.put((Object)EncodeHintType.CHARACTER_SET, (Object)this.charset.toString().toLowerCase());
        }
        if (null != this.errorCorrection) {
            Object value = BarcodeFormat.AZTEC == format || BarcodeFormat.PDF_417 == format ? Integer.valueOf((int)this.errorCorrection.getBits()) : this.errorCorrection;
            hints.put((Object)EncodeHintType.ERROR_CORRECTION, value);
            hints.put((Object)EncodeHintType.DATA_MATRIX_SHAPE, (Object)this.shapeHint);
        }
        if (null != this.margin) {
            hints.put((Object)EncodeHintType.MARGIN, (Object)this.margin);
        }
        if (null != this.qrVersion) {
            hints.put((Object)EncodeHintType.QR_VERSION, (Object)this.qrVersion);
        }
        return hints;
    }
}

