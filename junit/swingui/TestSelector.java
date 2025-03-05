/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Component
 *  java.awt.Cursor
 *  java.awt.Dimension
 *  java.awt.Frame
 *  java.awt.GridBagConstraints
 *  java.awt.GridBagLayout
 *  java.awt.Insets
 *  java.awt.LayoutManager
 *  java.awt.Toolkit
 *  java.awt.event.ActionEvent
 *  java.awt.event.ActionListener
 *  java.awt.event.KeyAdapter
 *  java.awt.event.KeyEvent
 *  java.awt.event.KeyListener
 *  java.awt.event.MouseAdapter
 *  java.awt.event.MouseEvent
 *  java.awt.event.MouseListener
 *  java.awt.event.WindowAdapter
 *  java.awt.event.WindowEvent
 *  java.awt.event.WindowListener
 *  java.lang.Character
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Enumeration
 *  java.util.Vector
 *  javax.swing.DefaultListCellRenderer
 *  javax.swing.Icon
 *  javax.swing.JButton
 *  javax.swing.JDialog
 *  javax.swing.JLabel
 *  javax.swing.JList
 *  javax.swing.JScrollPane
 *  javax.swing.ListCellRenderer
 *  javax.swing.ListModel
 *  javax.swing.UIManager
 *  javax.swing.event.ListSelectionEvent
 *  javax.swing.event.ListSelectionListener
 */
package junit.swingui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import junit.runner.Sorter;
import junit.runner.TestCollector;

public class TestSelector
extends JDialog {
    private JButton fCancel;
    private JButton fOk;
    private JList fList;
    private JScrollPane fScrolledList;
    private JLabel fDescription;
    private String fSelectedItem;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TestSelector(Frame parent, TestCollector testCollector) {
        super(parent, true);
        this.setSize(350, 300);
        this.setResizable(false);
        try {
            this.setLocationRelativeTo((Component)parent);
        }
        catch (NoSuchMethodError e) {
            TestSelector.centerWindow((Component)this);
        }
        this.setTitle("Test Selector");
        Vector list = null;
        try {
            parent.setCursor(Cursor.getPredefinedCursor((int)3));
            list = this.createTestList(testCollector);
        }
        finally {
            parent.setCursor(Cursor.getDefaultCursor());
        }
        this.fList = new JList(list);
        this.fList.setSelectionMode(0);
        this.fList.setCellRenderer((ListCellRenderer)new TestCellRenderer());
        this.fScrolledList = new JScrollPane((Component)this.fList);
        this.fCancel = new JButton("Cancel");
        this.fDescription = new JLabel("Select the Test class:");
        this.fOk = new JButton("OK");
        this.fOk.setEnabled(false);
        this.getRootPane().setDefaultButton(this.fOk);
        this.defineLayout();
        this.addListeners();
    }

    public static void centerWindow(Component c) {
        Dimension paneSize = c.getSize();
        Dimension screenSize = c.getToolkit().getScreenSize();
        c.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
    }

    private void addListeners() {
        this.fCancel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                TestSelector.this.dispose();
            }
        });
        this.fOk.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                TestSelector.this.okSelected();
            }
        });
        this.fList.addMouseListener((MouseListener)new DoubleClickListener());
        this.fList.addKeyListener((KeyListener)new KeySelectListener());
        this.fList.addListSelectionListener(new ListSelectionListener(){

            public void valueChanged(ListSelectionEvent e) {
                TestSelector.this.checkEnableOK(e);
            }
        });
        this.addWindowListener((WindowListener)new WindowAdapter(){

            public void windowClosing(WindowEvent e) {
                TestSelector.this.dispose();
            }
        });
    }

    private void defineLayout() {
        this.getContentPane().setLayout((LayoutManager)new GridBagLayout());
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.gridx = 0;
        labelConstraints.gridy = 0;
        labelConstraints.gridwidth = 1;
        labelConstraints.gridheight = 1;
        labelConstraints.fill = 1;
        labelConstraints.anchor = 17;
        labelConstraints.weightx = 1.0;
        labelConstraints.weighty = 0.0;
        labelConstraints.insets = new Insets(8, 8, 0, 8);
        this.getContentPane().add((Component)this.fDescription, (Object)labelConstraints);
        GridBagConstraints listConstraints = new GridBagConstraints();
        listConstraints.gridx = 0;
        listConstraints.gridy = 1;
        listConstraints.gridwidth = 4;
        listConstraints.gridheight = 1;
        listConstraints.fill = 1;
        listConstraints.anchor = 10;
        listConstraints.weightx = 1.0;
        listConstraints.weighty = 1.0;
        listConstraints.insets = new Insets(8, 8, 8, 8);
        this.getContentPane().add((Component)this.fScrolledList, (Object)listConstraints);
        GridBagConstraints okConstraints = new GridBagConstraints();
        okConstraints.gridx = 2;
        okConstraints.gridy = 2;
        okConstraints.gridwidth = 1;
        okConstraints.gridheight = 1;
        okConstraints.anchor = 13;
        okConstraints.insets = new Insets(0, 8, 8, 8);
        this.getContentPane().add((Component)this.fOk, (Object)okConstraints);
        GridBagConstraints cancelConstraints = new GridBagConstraints();
        cancelConstraints.gridx = 3;
        cancelConstraints.gridy = 2;
        cancelConstraints.gridwidth = 1;
        cancelConstraints.gridheight = 1;
        cancelConstraints.anchor = 13;
        cancelConstraints.insets = new Insets(0, 8, 8, 8);
        this.getContentPane().add((Component)this.fCancel, (Object)cancelConstraints);
    }

    public void checkEnableOK(ListSelectionEvent e) {
        this.fOk.setEnabled(this.fList.getSelectedIndex() != -1);
    }

    public void okSelected() {
        this.fSelectedItem = (String)this.fList.getSelectedValue();
        this.dispose();
    }

    public boolean isEmpty() {
        return this.fList.getModel().getSize() == 0;
    }

    public void keySelectTestClass(char ch) {
        ListModel model = this.fList.getModel();
        if (!Character.isJavaIdentifierStart((char)ch)) {
            return;
        }
        for (int i = 0; i < model.getSize(); ++i) {
            String s = (String)model.getElementAt(i);
            if (!TestCellRenderer.matchesKey(s, Character.toUpperCase((char)ch))) continue;
            this.fList.setSelectedIndex(i);
            this.fList.ensureIndexIsVisible(i);
            return;
        }
        Toolkit.getDefaultToolkit().beep();
    }

    public String getSelectedItem() {
        return this.fSelectedItem;
    }

    private Vector createTestList(TestCollector collector) {
        Enumeration each = collector.collectTests();
        Vector v = new Vector(200);
        Vector displayVector = new Vector(v.size());
        while (each.hasMoreElements()) {
            String s = (String)each.nextElement();
            v.addElement((Object)s);
            displayVector.addElement((Object)TestCellRenderer.displayString(s));
        }
        if (v.size() > 0) {
            Sorter.sortStrings(displayVector, 0, displayVector.size() - 1, new ParallelSwapper(v));
        }
        return v;
    }

    private class ParallelSwapper
    implements Sorter.Swapper {
        Vector fOther;

        ParallelSwapper(Vector other) {
            this.fOther = other;
        }

        public void swap(Vector values, int left, int right) {
            Object tmp = values.elementAt(left);
            values.setElementAt(values.elementAt(right), left);
            values.setElementAt(tmp, right);
            Object tmp2 = this.fOther.elementAt(left);
            this.fOther.setElementAt(this.fOther.elementAt(right), left);
            this.fOther.setElementAt(tmp2, right);
        }
    }

    protected class KeySelectListener
    extends KeyAdapter {
        protected KeySelectListener() {
        }

        public void keyTyped(KeyEvent e) {
            TestSelector.this.keySelectTestClass(e.getKeyChar());
        }
    }

    protected class DoubleClickListener
    extends MouseAdapter {
        protected DoubleClickListener() {
        }

        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                TestSelector.this.okSelected();
            }
        }
    }

    static class TestCellRenderer
    extends DefaultListCellRenderer {
        Icon fLeafIcon = UIManager.getIcon((Object)"Tree.leafIcon");
        Icon fSuiteIcon = UIManager.getIcon((Object)"Tree.closedIcon");

        public Component getListCellRendererComponent(JList list, Object value, int modelIndex, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, modelIndex, isSelected, cellHasFocus);
            String displayString = TestCellRenderer.displayString((String)value);
            if (displayString.startsWith("AllTests")) {
                this.setIcon(this.fSuiteIcon);
            } else {
                this.setIcon(this.fLeafIcon);
            }
            this.setText(displayString);
            return c;
        }

        public static String displayString(String className) {
            int typeIndex = className.lastIndexOf(46);
            if (typeIndex < 0) {
                return className;
            }
            return className.substring(typeIndex + 1) + " - " + className.substring(0, typeIndex);
        }

        public static boolean matchesKey(String s, char ch) {
            return ch == Character.toUpperCase((char)s.charAt(TestCellRenderer.typeIndex(s)));
        }

        private static int typeIndex(String s) {
            int typeIndex = s.lastIndexOf(46);
            int i = 0;
            if (typeIndex > 0) {
                i = typeIndex + 1;
            }
            return i;
        }
    }
}

