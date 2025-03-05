/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Component
 *  java.awt.Font
 *  java.lang.Object
 *  java.lang.String
 *  java.util.StringTokenizer
 *  java.util.Vector
 *  javax.swing.AbstractListModel
 *  javax.swing.DefaultListCellRenderer
 *  javax.swing.JList
 *  javax.swing.ListCellRenderer
 *  javax.swing.ListModel
 */
package junit.swingui;

import java.awt.Component;
import java.awt.Font;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import junit.framework.TestFailure;
import junit.runner.BaseTestRunner;
import junit.runner.FailureDetailView;

public class DefaultFailureDetailView
implements FailureDetailView {
    JList fList;

    public Component getComponent() {
        if (this.fList == null) {
            this.fList = new JList((ListModel)new StackTraceListModel());
            this.fList.setFont(new Font("Dialog", 0, 12));
            this.fList.setSelectionMode(0);
            this.fList.setVisibleRowCount(5);
            this.fList.setCellRenderer((ListCellRenderer)new StackEntryRenderer());
        }
        return this.fList;
    }

    public void showFailure(TestFailure failure) {
        this.getModel().setTrace(BaseTestRunner.getFilteredTrace(failure.trace()));
    }

    public void clear() {
        this.getModel().clear();
    }

    private StackTraceListModel getModel() {
        return (StackTraceListModel)this.fList.getModel();
    }

    static class StackEntryRenderer
    extends DefaultListCellRenderer {
        StackEntryRenderer() {
        }

        public Component getListCellRendererComponent(JList list, Object value, int modelIndex, boolean isSelected, boolean cellHasFocus) {
            String text = ((String)value).replace('\t', ' ');
            Component c = super.getListCellRendererComponent(list, (Object)text, modelIndex, isSelected, cellHasFocus);
            this.setText(text);
            this.setToolTipText(text);
            return c;
        }
    }

    static class StackTraceListModel
    extends AbstractListModel {
        private Vector fLines = new Vector(20);

        StackTraceListModel() {
        }

        public Object getElementAt(int index) {
            return this.fLines.elementAt(index);
        }

        public int getSize() {
            return this.fLines.size();
        }

        public void setTrace(String trace) {
            this.scan(trace);
            this.fireContentsChanged((Object)this, 0, this.fLines.size());
        }

        public void clear() {
            this.fLines.removeAllElements();
            this.fireContentsChanged((Object)this, 0, this.fLines.size());
        }

        private void scan(String trace) {
            this.fLines.removeAllElements();
            StringTokenizer st = new StringTokenizer(trace, "\n\r", false);
            while (st.hasMoreTokens()) {
                this.fLines.addElement((Object)st.nextToken());
            }
        }
    }
}

