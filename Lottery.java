//需求：从观众姓名列表中随机抽取幸运观众。

/*
实现方法：
1）将所有观众姓名生成数组
2）获得数组元素的总数量
3）从数据元素中随机抽取元素的下标
4）根据抽取的下标抽取幸运观众
 */


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Lottery extends JFrame {
    private JPanel contentPane;
    private JTextField nameField;
    private JTextArea personalArea;
    private JTextArea resultArea;

    // Launch the application

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("");
        }catch (Throwable e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    Lottery frame = new Lottery();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

    // Create the frame.
    public Lottery(){
        setTitle("抽奖程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,498,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null,"输入参与抽奖的人",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(59,59,59)));
        panel.setBounds(10,10,174,242);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0,5));

        nameField = new JTextField();
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                do_textField_keyPressed(e);
            }
        });

        panel.add(nameField,BorderLayout.NORTH);
        nameField.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        personalArea = new JTextArea();
        personalArea.setEditable(false);
        scrollPane.setViewportView(personalArea);

        JPanel panel1 = new JPanel();
        panel1.setBorder(new TitledBorder(null,"获奖人",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(59,59,59)));
        panel1.setBounds(183,10,219,242);
        contentPane.add(panel1);
        panel1.setLayout(new BorderLayout(0,0));

        JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        scrollPane1.setViewportView(resultArea);

        JButton button = new JButton("抽奖");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(407,164,63,25);
        contentPane.add(button);

        JButton button1 = new JButton("退出");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button1_actionPerformed(e);
            }
        });
        button1.setBounds(407,215,63,25);
        contentPane.add(button1);
    }

    protected void do_textField_keyPressed(KeyEvent e){
        if(e.getKeyChar() != '\n')  //不是回车字符不做处理
            return;
        String name = nameField.getText();
        if(name.isEmpty())  //如果文本框没有字符串，则不做处理
            return;
        personalArea.append(name+"\n");  //把输入人名与回车符添加到人员列表中
        nameField.selectAll();  //选择文本框的所有字符
    }

    //
    protected void do_button_actionPerformed(ActionEvent e){
        String perstring = personalArea.getText();  //获取人员列表文本
        String[] personnalArray = perstring.split("\n{1,}");  //获取人员数组
        // 生成随机数组索引
        int index = (int) (Math.random()*personnalArray.length); // 把随机数组与数组长度的乘积转换为整型，作为随机数组下标索引
        // 定义包含格式参数的中奖信息
        String formatArg = "幸运儿是：\n\t%1$s\n恭喜%1$s！"+"\n\n%1$s将获得: \n\t太空旅行一次";
        // 为中奖信息添加人员参数
        String info = String.format(formatArg,personnalArray[index]);
        resultArea.setText(info); // 在文本域中显示中奖信息
    }

    protected void do_button1_actionPerformed(ActionEvent e){
        dispose();
    }
}
