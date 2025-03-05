/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Component
 *  java.awt.Font
 *  java.awt.Frame
 *  java.awt.GridBagConstraints
 *  java.awt.GridBagLayout
 *  java.awt.Insets
 *  java.awt.LayoutManager
 *  java.awt.event.ActionEvent
 *  java.awt.event.ActionListener
 *  java.awt.event.WindowAdapter
 *  java.awt.event.WindowEvent
 *  java.awt.event.WindowListener
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.NoClassDefFoundError
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.String
 *  javax.swing.Icon
 *  javax.swing.JButton
 *  javax.swing.JDialog
 *  javax.swing.JFrame
 *  javax.swing.JLabel
 */
package junit.swingui;

import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import junit.runner.Version;
import junit.swingui.TestRunner;
import junit.swingui.TestSelector;

class AboutDialog
extends JDialog {
    static /* synthetic */ Class class$junit$runner$BaseTestRunner;

    public AboutDialog(JFrame parent) {
        super((Frame)parent, true);
        this.setResizable(false);
        this.getContentPane().setLayout((LayoutManager)new GridBagLayout());
        this.setSize(330, 138);
        this.setTitle("About");
        try {
            this.setLocationRelativeTo((Component)parent);
        }
        catch (NoSuchMethodError e) {
            TestSelector.centerWindow((Component)this);
        }
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                AboutDialog.this.dispose();
            }
        });
        this.getRootPane().setDefaultButton(close);
        JLabel label1 = new JLabel("JUnit");
        label1.setFont(new Font("dialog", 0, 36));
        JLabel label2 = new JLabel("JUnit " + Version.id() + " by Kent Beck and Erich Gamma");
        label2.setFont(new Font("dialog", 0, 14));
        JLabel logo = this.createLogo();
        GridBagConstraints constraintsLabel1 = new GridBagConstraints();
        constraintsLabel1.gridx = 3;
        constraintsLabel1.gridy = 0;
        constraintsLabel1.gridwidth = 1;
        constraintsLabel1.gridheight = 1;
        constraintsLabel1.anchor = 10;
        this.getContentPane().add((Component)label1, (Object)constraintsLabel1);
        GridBagConstraints constraintsLabel2 = new GridBagConstraints();
        constraintsLabel2.gridx = 2;
        constraintsLabel2.gridy = 1;
        constraintsLabel2.gridwidth = 2;
        constraintsLabel2.gridheight = 1;
        constraintsLabel2.anchor = 10;
        this.getContentPane().add((Component)label2, (Object)constraintsLabel2);
        GridBagConstraints constraintsButton1 = new GridBagConstraints();
        constraintsButton1.gridx = 2;
        constraintsButton1.gridy = 2;
        constraintsButton1.gridwidth = 2;
        constraintsButton1.gridheight = 1;
        constraintsButton1.anchor = 10;
        constraintsButton1.insets = new Insets(8, 0, 8, 0);
        this.getContentPane().add((Component)close, (Object)constraintsButton1);
        GridBagConstraints constraintsLogo1 = new GridBagConstraints();
        constraintsLogo1.gridx = 2;
        constraintsLogo1.gridy = 0;
        constraintsLogo1.gridwidth = 1;
        constraintsLogo1.gridheight = 1;
        constraintsLogo1.anchor = 10;
        this.getContentPane().add((Component)logo, (Object)constraintsLogo1);
        this.addWindowListener((WindowListener)new WindowAdapter(){

            public void windowClosing(WindowEvent e) {
                AboutDialog.this.dispose();
            }
        });
    }

    protected JLabel createLogo() {
        Icon icon = TestRunner.getIconResource(class$junit$runner$BaseTestRunner == null ? (class$junit$runner$BaseTestRunner = AboutDialog.class$("junit.runner.BaseTestRunner")) : class$junit$runner$BaseTestRunner, "logo.gif");
        return new JLabel(icon);
    }

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName((String)x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }
}

