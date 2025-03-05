/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Canvas
 *  java.awt.Color
 *  java.awt.Graphics
 *  java.awt.Rectangle
 *  java.awt.SystemColor
 *  java.lang.Math
 *  java.lang.Object
 */
package junit.awtui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.SystemColor;

public class ProgressBar
extends Canvas {
    public boolean fError = false;
    public int fTotal = 0;
    public int fProgress = 0;
    public int fProgressX = 0;

    public ProgressBar() {
        this.setSize(20, 30);
    }

    private Color getStatusColor() {
        if (this.fError) {
            return Color.red;
        }
        return Color.green;
    }

    public void paint(Graphics g) {
        this.paintBackground(g);
        this.paintStatus(g);
    }

    public void paintBackground(Graphics g) {
        g.setColor((Color)SystemColor.control);
        Rectangle r = this.getBounds();
        g.fillRect(0, 0, r.width, r.height);
        g.setColor(Color.darkGray);
        g.drawLine(0, 0, r.width - 1, 0);
        g.drawLine(0, 0, 0, r.height - 1);
        g.setColor(Color.white);
        g.drawLine(r.width - 1, 0, r.width - 1, r.height - 1);
        g.drawLine(0, r.height - 1, r.width - 1, r.height - 1);
    }

    public void paintStatus(Graphics g) {
        g.setColor(this.getStatusColor());
        Rectangle r = new Rectangle(0, 0, this.fProgressX, this.getBounds().height);
        g.fillRect(1, 1, r.width - 1, r.height - 2);
    }

    private void paintStep(int startX, int endX) {
        this.repaint(startX, 1, endX - startX, this.getBounds().height - 2);
    }

    public void reset() {
        this.fProgressX = 1;
        this.fProgress = 0;
        this.fError = false;
        this.paint(this.getGraphics());
    }

    public int scale(int value) {
        if (this.fTotal > 0) {
            return Math.max((int)1, (int)(value * (this.getBounds().width - 1) / this.fTotal));
        }
        return value;
    }

    public void setBounds(int x, int y, int w, int h) {
        super.setBounds(x, y, w, h);
        this.fProgressX = this.scale(this.fProgress);
    }

    public void start(int total) {
        this.fTotal = total;
        this.reset();
    }

    public void step(boolean successful) {
        ++this.fProgress;
        int x = this.fProgressX;
        this.fProgressX = this.scale(this.fProgress);
        if (!this.fError && !successful) {
            this.fError = true;
            x = 1;
        }
        this.paintStep(x, this.fProgressX);
    }
}

