
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.xml.crypto.Data;

public class MFrame {
    String srcpath=null,t=null,dir=null;
    private void setdir(String p) {
        dir = p;
    }
    private String getdir() {
        return dir;
    }
    private void setT(String p) {
        t = p;
    }
    private String getT() {
        return t;
    }
    private void setsrcpath(String p) {
        srcpath = p;
    }
    private String getsrcpath() {
        return srcpath;
    }
    public void display() throws UnknownHostException {
        JFrame jf = new JFrame();
        //	MenuBar m = new MenuBar();
        Container container =jf.getContentPane();
        container.setLayout(new BorderLayout());
        File treefile = new File("事件处理");
        DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode(new MyFile(treefile));
        for( char i='c';i<'z';i++ )
        {
            String path = i+":\\";
            File file = new File(path);
            if( file.exists() )
            {
                MyFile mf = new MyFile(file);
                DefaultMutableTreeNode bdp = new DefaultMutableTreeNode(mf);
                traversal(mf,bdp);
                treeRoot.add(bdp);
            }
        }
        DefaultTreeModel myModel = new DefaultTreeModel(treeRoot);
        final JTree tree = new JTree(myModel);
        tree.addTreeWillExpandListener(new TreeWillExpandListener() {

            @Override
            public void treeWillCollapse(TreeExpansionEvent arg0) throws ExpandVetoException {
                // TODO Auto-generated method stub

            }
            @Override
            public void treeWillExpand(TreeExpansionEvent e) throws ExpandVetoException {
                // TODO Auto-generated method stub
                TreePath path = e.getPath();
                if( path==null )
                {
                    return;
                }
                else
                {
                    DefaultMutableTreeNode tmp=(DefaultMutableTreeNode)path.getLastPathComponent();
                    traversal((MyFile)tmp.getUserObject(),tmp);
                    //	tmp.remove(0);
                }
            }

        });
        JScrollPane scrolltree = new JScrollPane(tree);
        scrolltree.setPreferredSize(new Dimension(200,300));
        Vector<Object> columnNames = new Vector<Object>();
        columnNames.add("事件名");
        columnNames.add("类型");
        columnNames.add("占用CPU比率");
        columnNames.add("运行时间");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>(100);
        DefaultTableModel myTableModel = new DefaultTableModel(data,columnNames) {
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        JTable table = new JTable(myTableModel);
        table.setRowSelectionAllowed(true);
        container.add(scrolltree,BorderLayout.WEST);
        JScrollPane scrolltable = new JScrollPane(table);
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // TODO Auto-generated method stub
                TreePath path= e.getPath();
                if( path==null )
                    return;
                else
                {

                    DefaultMutableTreeNode tmp=(DefaultMutableTreeNode)path.getLastPathComponent();
                    MyFile mf = (MyFile)tmp.getUserObject();
                    File file = mf.getFile();
                    update(file,table,data);
                }
            }

        });
        JPopupMenu m_popupMenu;
        m_popupMenu = new JPopupMenu();
        JMenuItem del = new JMenuItem("删除");
        //	JMenuItem cut = new JMenuItem("剪切");  //  剪切标记为1,复制标记为2
        JMenuItem copy = new JMenuItem("备份");
        JMenuItem paste = new JMenuItem("添加");
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String path = getT();
                if( new File(path).delete() )
                {
                    JOptionPane.showMessageDialog(container, "删除成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
                    update(new File(path).getParentFile(),table,data);
                    DefaultMutableTreeNode now = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
                    MyFile myfile = (MyFile)now.getUserObject();
                    traversal(myfile,now);
                    tree.updateUI();
                }
                else
                    JOptionPane.showMessageDialog(container, "删除失败!", "提示", JOptionPane.ERROR_MESSAGE);
            }

        });
        copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String path = getT();
                setsrcpath(path);
            }

        });
        paste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String	descpath = getT();
                descpath += srcpath.substring(srcpath.lastIndexOf(File.separator));
                String	srcpath = getsrcpath();
                //	System.out.println(descpath+"     "+srcpath);
                Path dpath = Paths.get(descpath);
                Path spath = Paths.get(srcpath);
                try {
                    Files.copy(spath, dpath);
                    DefaultMutableTreeNode now = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
                    MyFile myfile = (MyFile)now.getUserObject();
                    traversal(myfile,now);
                    tree.updateUI();
                    update(new File(getT()),table,data);
                    JOptionPane.showMessageDialog(container, "备份成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
                } catch (FileAlreadyExistsException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(container, "事件已存在!", "提示", JOptionPane.ERROR_MESSAGE);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        m_popupMenu.add(copy);
        m_popupMenu.add(paste);
        m_popupMenu.add(del);
        table.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                // BUTTON3为鼠标右键
                if( e.getButton() == MouseEvent.BUTTON3 )
                {
                    int focusedR = table.rowAtPoint(e.getPoint());
                    if( focusedR == -1 )
                    {
                        return;
                    }
                    table.setRowSelectionInterval(focusedR,focusedR);
                    if( table.getRowCount() !=1 )
                    {
                        if( focusedR!=table.getRowCount()-1 ) //选中行不是最后一行
                            setT((String)data.get(focusedR).get(4));
                        else
                        {
                            setT(getdir());
                        }
                    }
                    else
                    {
                        setT(getdir());
                    }
                    m_popupMenu.show(table, e.getX(), e.getY());
                }
            }
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

        container.add(scrolltable,BorderLayout.CENTER);
        jf.setSize(1000,600);
        jf.setVisible(true);
    }
    public void traversal(MyFile fi,DefaultMutableTreeNode sqy)
    {
        sqy.removeAllChildren();
        File file = fi.getFile();
        if( file.exists() )
        {
            File[] files = file.listFiles();
            int cnt=0;
            try {
                for( File f:files )
                {
                    DefaultMutableTreeNode df = new DefaultMutableTreeNode(new MyFile(f));
                    if( f.isDirectory() )
                    {
                        DefaultMutableTreeNode tmp =new DefaultMutableTreeNode(new MyFile(null));
                        df.add(tmp);
                        sqy.add(df);
                    }
                    else
                    {
                        sqy.add(df);
                    }
                }
            }
            catch(NullPointerException ex) {

            }
        }
    }
    public class MyFile
    {
        private File file;
        MyFile(File file)
        {
            this.file=file;
        }
        File getFile()
        {
            return this.file;
        }
        public String toString()
        {
            String name = this.file.getName();
            if( name.length()!=0 )
                return name;
            else
                return this.file.getPath();
        }
    }
    public void update(File file,JTable table,Vector<Vector<Object>> data) {
        try {
            File[] files = file.listFiles();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            data.removeAllElements();
            for( File f:files )
            {
                Vector<Object> ob = new Vector<Object>();
                ob.insertElementAt(f.getName(), 0);
                if( f.isDirectory() )
                {
                    ob.insertElementAt("目录", 1);
                }
                else if( f.isFile() )
                {
                    ob.insertElementAt("事件", 1);
                }
                ob.insertElementAt(f.length()/1024+"kb", 2);
                cal.setTimeInMillis(f.lastModified());
                ob.insertElementAt(sdf.format(cal.getTime()), 3);
                ob.insertElementAt(f.getAbsolutePath(), 4);
                data.addElement(ob);
            }
            Vector<Object> ob = new Vector<Object>();
            for(int i=0;i<=4;i++ )
                ob.insertElementAt(null, i);
            data.addElement(ob);
            setdir(file.getAbsolutePath());
            table.updateUI();

        }
        catch(NullPointerException ex)
        {

        }
    }
    public static void main(String[] args) throws UnknownHostException
    {
        MFrame mf=new MFrame();
        mf.display();
    }
}