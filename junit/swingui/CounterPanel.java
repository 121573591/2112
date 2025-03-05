/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Component
 *  java.awt.GridBagConstraints
 *  java.awt.GridBagLayout
 *  java.awt.Insets
 *  java.awt.LayoutManager
 *  java.lang.Integer
 *  java.lang.Object
 *  javax.swing.BorderFactory
 *  javax.swing.Icon
 *  javax.swing.JLabel
 *  javax.swing.JPanel
 *  javax.swing.JTextField
 */
package junit.swingui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import junit.swingui.StatusLine;
import junit.swingui.TestRunner;

public class CounterPanel
extends JPanel {
    private JTextField fNumberOfErrors;
    private JTextField fNumberOfFailures;
    private JTextField fNumberOfRuns;
    private Icon fFailureIcon = TestRunner.getIconResource(this.getClass(), "icons/failure.gif");
    private Icon fErrorIcon = TestRunner.getIconResource(this.getClass(), "icons/error.gif");
    private int fTotal;

    public CounterPanel() {
        super((LayoutManager)new GridBagLayout());
        this.fNumberOfErrors = this.createOutputField(5);
        this.fNumberOfFailures = this.createOutputField(5);
        this.fNumberOfRuns = this.createOutputField(9);
        this.addToGrid((Component)new JLabel("Runs:", 0), 0, 0, 1, 1, 0.0, 0.0, 10, 0, new Insets(0, 0, 0, 0));
        this.addToGrid((Component)this.fNumberOfRuns, 1, 0, 1, 1, 0.33, 0.0, 10, 2, new Insets(0, 8, 0, 0));
        this.addToGrid((Component)new JLabel("Errors:", this.fErrorIcon, 2), 2, 0, 1, 1, 0.0, 0.0, 10, 0, new Insets(0, 8, 0, 0));
        this.addToGrid((Component)this.fNumberOfErrors, 3, 0, 1, 1, 0.33, 0.0, 10, 2, new Insets(0, 8, 0, 0));
        this.addToGrid((Component)new JLabel("Failures:", this.fFailureIcon, 2), 4, 0, 1, 1, 0.0, 0.0, 10, 0, new Insets(0, 8, 0, 0));
        this.addToGrid((Component)this.fNumberOfFailures, 5, 0, 1, 1, 0.33, 0.0, 10, 2, new Insets(0, 8, 0, 0));
    }

    private JTextField createOutputField(int width) {
        JTextField field = new JTextField("0", width);
        field.setMinimumSize(field.getPreferredSize());
        field.setMaximumSize(field.getPreferredSize());
        field.setHorizontalAlignment(2);
        field.setFont(StatusLine.BOLD_FONT);
        field.setEditable(false);
        field.setBorder(BorderFactory.createEmptyBorder());
        return field;
    }

    public void addToGrid(Component comp, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int fill, Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.anchor = anchor;
        constraints.fill = fill;
        constraints.insets = insets;
        this.add(comp, constraints);
    }

    public void reset() {
        this.setLabelValue(this.fNumberOfErrors, 0);
        this.setLabelValue(this.fNumberOfFailures, 0);
        this.setLabelValue(this.fNumberOfRuns, 0);
        this.fTotal = 0;
    }

    public void setTotal(int value) {
        this.fTotal = value;
    }

    public void setRunValue(int value) {
        this.fNumberOfRuns.setText(Integer.toString((int)value) + "/" + this.fTotal);
    }

    public void setErrorValue(int value) {
        this.setLabelValue(this.fNumberOfErrors, value);
    }

    public void setFailureValue(int value) {
        this.setLabelValue(this.fNumberOfFailures, value);
    }

    private void setLabelValue(JTextField label, int value) {
        label.setText(Integer.toString((int)value));
    }
}

