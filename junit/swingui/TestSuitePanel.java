/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.BorderLayout
 *  java.awt.Component
 *  java.awt.Dimension
 *  java.awt.LayoutManager
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Vector
 *  javax.swing.Icon
 *  javax.swing.JComponent
 *  javax.swing.JPanel
 *  javax.swing.JScrollPane
 *  javax.swing.JTree
 *  javax.swing.SwingUtilities
 *  javax.swing.ToolTipManager
 *  javax.swing.tree.DefaultTreeCellRenderer
 *  javax.swing.tree.TreeCellRenderer
 *  javax.swing.tree.TreeModel
 *  javax.swing.tree.TreePath
 */
package junit.swingui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.swingui.TestRunner;
import junit.swingui.TestTreeModel;

class TestSuitePanel
extends JPanel
implements TestListener {
    private JTree fTree;
    private JScrollPane fScrollTree;
    private TestTreeModel fModel;

    public TestSuitePanel() {
        super((LayoutManager)new BorderLayout());
        this.setPreferredSize(new Dimension(300, 100));
        this.fTree = new JTree();
        this.fTree.setModel(null);
        this.fTree.setRowHeight(20);
        ToolTipManager.sharedInstance().registerComponent((JComponent)this.fTree);
        this.fTree.putClientProperty((Object)"JTree.lineStyle", (Object)"Angled");
        this.fScrollTree = new JScrollPane((Component)this.fTree);
        this.add((Component)this.fScrollTree, "Center");
    }

    public void addError(Test test, Throwable t) {
        this.fModel.addError(test);
        this.fireTestChanged(test, true);
    }

    public void addFailure(Test test, AssertionFailedError t) {
        this.fModel.addFailure(test);
        this.fireTestChanged(test, true);
    }

    public void endTest(Test test) {
        this.fModel.addRunTest(test);
        this.fireTestChanged(test, false);
    }

    public void startTest(Test test) {
    }

    public Test getSelectedTest() {
        TreePath[] paths = this.fTree.getSelectionPaths();
        if (paths != null && paths.length == 1) {
            return (Test)paths[0].getLastPathComponent();
        }
        return null;
    }

    public JTree getTree() {
        return this.fTree;
    }

    public void showTestTree(Test root) {
        this.fModel = new TestTreeModel(root);
        this.fTree.setModel((TreeModel)this.fModel);
        this.fTree.setCellRenderer((TreeCellRenderer)new TestTreeCellRenderer());
    }

    private void fireTestChanged(final Test test, final boolean expand) {
        SwingUtilities.invokeLater((Runnable)new Runnable(){

            public void run() {
                Vector vpath = new Vector();
                int index = TestSuitePanel.this.fModel.findTest(test, (Test)TestSuitePanel.this.fModel.getRoot(), vpath);
                if (index >= 0) {
                    Object[] path = new Object[vpath.size()];
                    vpath.copyInto(path);
                    TreePath treePath = new TreePath(path);
                    TestSuitePanel.this.fModel.fireNodeChanged(treePath, index);
                    if (expand) {
                        Object[] fullPath = new Object[vpath.size() + 1];
                        vpath.copyInto(fullPath);
                        fullPath[vpath.size()] = TestSuitePanel.this.fModel.getChild(treePath.getLastPathComponent(), index);
                        TreePath fullTreePath = new TreePath(fullPath);
                        TestSuitePanel.this.fTree.scrollPathToVisible(fullTreePath);
                    }
                }
            }
        });
    }

    static class TestTreeCellRenderer
    extends DefaultTreeCellRenderer {
        private Icon fErrorIcon;
        private Icon fOkIcon;
        private Icon fFailureIcon;

        TestTreeCellRenderer() {
            this.loadIcons();
        }

        void loadIcons() {
            this.fErrorIcon = TestRunner.getIconResource(this.getClass(), "icons/error.gif");
            this.fOkIcon = TestRunner.getIconResource(this.getClass(), "icons/ok.gif");
            this.fFailureIcon = TestRunner.getIconResource(this.getClass(), "icons/failure.gif");
        }

        String stripParenthesis(Object o) {
            String text = o.toString();
            int pos = text.indexOf(40);
            if (pos < 1) {
                return text;
            }
            return text.substring(0, pos);
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            TreeModel model = tree.getModel();
            if (model instanceof TestTreeModel) {
                TestTreeModel testModel = (TestTreeModel)model;
                Test t = (Test)value;
                String s = "";
                if (testModel.isFailure(t)) {
                    if (this.fFailureIcon != null) {
                        this.setIcon(this.fFailureIcon);
                    }
                    s = " - Failed";
                } else if (testModel.isError(t)) {
                    if (this.fErrorIcon != null) {
                        this.setIcon(this.fErrorIcon);
                    }
                    s = " - Error";
                } else if (testModel.wasRun(t)) {
                    if (this.fOkIcon != null) {
                        this.setIcon(this.fOkIcon);
                    }
                    s = " - Passed";
                }
                if (c instanceof JComponent) {
                    ((JComponent)c).setToolTipText(this.getText() + s);
                }
            }
            this.setText(this.stripParenthesis(value));
            return c;
        }
    }
}

