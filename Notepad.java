import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Notepad extends JFrame {
    private static final long serialVersionUID = 5927958872707427777L;
    private JPanel contentPane;

    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("****");
        }catch (Throwable e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Notepad frame = new Notepad();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public Notepad(){
        setTitle("模仿记事本的菜单项");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("文件(F)");
        fileMenu.setFont(new Font("微软雅黑",Font.PLAIN,16));
        fileMenu.add(fileMenu);

        JMenuItem newMenuItem = new JMenuItem("新建(N)");
        newMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        fileMenu.add(newMenuItem);

        JMenuItem openMenuItem = new JMenuItem("打开(O)...");
        openMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("保存(S)");
        saveMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        fileMenu.add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem("另存为(A)...");
        saveAsMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        fileMenu.add(saveAsMenuItem);

        JSeparator separator1 = new JSeparator();
        fileMenu.add(separator1);

        JMenuItem pageSetMenuItem = new JMenuItem("页面设置(U)...");
        pageSetMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        fileMenu.add(pageSetMenuItem);

        JMenuItem printMenuItem = new JMenuItem("打印(P)...");
        printMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        fileMenu.add(printMenuItem);

        JSeparator separator2 = new JSeparator();
        fileMenu.add(separator2);

        JMenuItem exitMenuItem = new JMenuItem("退出(X)");
        exitMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        fileMenu.add(exitMenuItem);

        JMenu editMenu = new JMenu("编辑(E)");
        editMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        menuBar.add(editMenu);

        JMenuItem undoMenuItem = new JMenuItem("撤销(U)");
        undoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(undoMenuItem);

        JSeparator separator3 = new JSeparator();
        editMenu.add(separator3);

        JMenuItem cutMenuItem = new JMenuItem("剪切(T)");
        cutMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(cutMenuItem);

        JMenuItem copyMenuItem = new JMenuItem("复制(C)");
        copyMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(copyMenuItem);

        JMenuItem pasteMenuItem = new JMenuItem("黏贴(P)");
        pasteMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(pasteMenuItem);

        JMenuItem deleteMenuItem = new JMenuItem("删除(L)");
        deleteMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(deleteMenuItem);

        JSeparator separator4 = new JSeparator();
        editMenu.add(separator4);

        JMenuItem findMenuItem = new JMenuItem("查找(F)...");
        findMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(findMenuItem);

        JMenuItem findNextMenuItem = new JMenuItem("下一个(N)");
        findNextMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(findNextMenuItem);

        JMenuItem replaceMenuItem = new JMenuItem("替换(R)...");
        replaceMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(replaceMenuItem);

        JMenuItem gotoMenuItem = new JMenuItem("去往(G)...");
        gotoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(gotoMenuItem);

        JSeparator separator5 = new JSeparator();
        editMenu.add(separator5);

        JMenuItem allMenuItem = new JMenuItem("全选(A)");
        allMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(allMenuItem);

        JMenuItem dateMenuItem = new JMenuItem("日期(D)");
        dateMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        editMenu.add(dateMenuItem);

        JMenu formatMenu = new JMenu("格式(O)");
        formatMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        menuBar.add(formatMenu);

        JMenuItem wrapMenuItem = new JMenuItem("边框(W)");
        wrapMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        formatMenu.add(wrapMenuItem);

        JMenuItem FontMenuItem = new JMenuItem("字体(F)...");
        FontMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        formatMenu.add(FontMenuItem);

        JMenu viewMenu = new JMenu("查看(V)");
        viewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        menuBar.add(viewMenu);

        JMenuItem statusMenuItem = new JMenuItem("状态(S)");
        statusMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        viewMenu.add(statusMenuItem);

        JMenu helpMenu = new JMenu("帮助(H)");
        helpMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        menuBar.add(helpMenu);

        JMenuItem helpMenuItem = new JMenuItem("帮助(H)");
        helpMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        helpMenu.add(helpMenuItem);

        JSeparator separator6 = new JSeparator();
        helpMenu.add(separator6);

        JMenuItem aboutMenuItem = new JMenuItem("关于(A)");
        aboutMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        helpMenu.add(aboutMenuItem);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        textArea.setWrapStyleWord(true);
        scrollPane.setViewportView(textArea);
    }
}

