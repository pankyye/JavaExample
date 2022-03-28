import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.jar.JarFile;

public class JListTest extends JFrame {
    private static final long serialVersionUID = -8058544817222710208L;
    private JPanel contentPane;
    private JList list;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("****");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JListTest frame = new JListTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public JListTest(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("修改列表框显示方式");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel,BorderLayout.SOUTH);

        JRadioButton radioButton1 = new JRadioButton("HORIZONTAL_WRAP");
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_radioButton1_actionPerformed(e);
            }
        });
        radioButton1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel.add(radioButton1);

        JRadioButton radioButton2 = new JRadioButton("VERTICAL");
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton2_actionPerformed(e);
            }
        });
        radioButton2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel.add(radioButton2);

        JRadioButton radioButton3 = new JRadioButton("VERTICAL_WRAP ");
        radioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton3_actionPerformed(e);
            }
        });
        radioButton3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel.add(radioButton3);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        list = new JList();
        list.setVisibleRowCount(3);
        list.setFont(new Font("微软雅黑",Font.PLAIN,16));
        scrollPane.setViewportView(list);
    }

    protected void do_this_windowActivated(WindowEvent e){
        String[] listData = new String[12];
        for (int i=0; i<listData.length; i++){
            listData[i] = "认知科学"+(i+1);
        }
        list.setListData(listData);
    }
    protected void do_radioButton1_actionPerformed(ActionEvent e){
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        scrollPane.revalidate();
    }
    protected void do_radioButton2_actionPerformed(ActionEvent e){
        list.setLayoutOrientation(JList.VERTICAL);
        scrollPane.revalidate();
    }
    protected void do_radioButton3_actionPerformed(ActionEvent e){
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        scrollPane.revalidate();
    }
}

