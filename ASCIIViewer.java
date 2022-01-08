//需求：输入字符，转换成数字；或者反向输入数字，转换成对应字符。

/**
 * 实现步骤：
 * 1 创建一个ASCIIViewer类，框架中包含两个文本输入框和两个按钮；
 * 2 编写方法1（）监听点击第一个【转换】按钮事件；
 * 3 编写方法2（）监听点击第二个【转换】按钮事件；
 */


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ASCIIViewer extends JFrame {
    private static final long serialVersionUID = -6067423561196663639L;
    private JPanel contentPane;
    private JTextField asciiTextField;
    private JTextField numberTextField;
    private JLabel label3;
    private JLabel label6;

   //Launch the application

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("");
        }catch (Throwable e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    ASCIIViewer frame = new ASCIIViewer();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the Frame

    public ASCIIViewer(){
        setTitle("ASCII编码查看器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel,BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2,1,5,5));

        JPanel asciiPanel = new JPanel();
        asciiPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
        panel.add(asciiPanel);
        asciiPanel.setLayout(new GridLayout(1,5,5,5));

        JLabel label1 = new JLabel("输入字符");
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        asciiPanel.add(label1);

        asciiTextField = new JTextField();
        asciiTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        asciiPanel.add(asciiTextField);
        asciiTextField.setColumns(3);

        JLabel label2 = new JLabel("转换结果");
        label2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        asciiPanel.add(label2);

        label3 = new JLabel("");
        label3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        asciiPanel.add(label3);

        JButton toNumberButton = new JButton("转换");
        toNumberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_toNumberButton_actionPerformed(e);
            }
        });
        toNumberButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        asciiPanel.add(toNumberButton);

        JPanel numberPanel = new JPanel();
        numberPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(numberPanel);
        numberPanel.setLayout(new GridLayout(1, 5, 5, 5));

        JLabel label4 = new JLabel("输入字符");
        label4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        numberPanel.add(label4);

        numberTextField = new JTextField();
        numberTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        numberPanel.add(numberTextField);
        numberTextField.setColumns(3);

        JLabel label5 = new JLabel("转换结果");
        label5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        numberPanel.add(label5);

        label6 = new JLabel("");
        label6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        numberPanel.add(label6);

        JButton toASCIIButton = new JButton("转换");
        toASCIIButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_toASCIIButton_actionPerformed(e);
            }
        });
        toASCIIButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        numberPanel.add(toASCIIButton);
    }

    protected void do_toNumberButton_actionPerformed(ActionEvent e){
        String ascii = asciiTextField.getText();
        int i = Character.codePointAt(ascii,0);
        label3.setText(""+i);
    }

    protected void do_toASCIIButton_actionPerformed(ActionEvent e){
        String number = numberTextField.getText();
        char[] a = Character.toChars(Integer.parseInt(number));
        label6.setText(new String(a));
    }
}


