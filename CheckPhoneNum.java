//需求：检查电话号码有效性

/**
 * 实现步骤：
 * 1 创建窗体类CheckPhoneNum，在该窗体类中添加三个文本框，分别用于输入姓名、年龄、电话号码，然后再添加一个【验证】按钮；
 * 2 编写验证按钮的事件处理方法，该方法：
 *      a.获取用户输入的电话号码字符串
 *      b.调用chech()方法对输入进行判断
 *      c.调用对话框输出验证结果
 */


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CheckPhoneNum extends JFrame {
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField phoneNumField;
    private JTextField ageField;

   //Launch the application

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    CheckPhoneNum frame = new CheckPhoneNum();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the Frame

    public CheckPhoneNum(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,460,390);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(50,50,50,50));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblip = new JLabel("姓名");
        lblip.setBounds(10,15,122,15);
        contentPane.add(lblip);

        nameField = new JTextField();
        nameField.setBounds(80,10,141,25);
        contentPane.add(nameField);

        JButton button = new JButton("验证");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(90,119,93,23);
        contentPane.add(button);

        JLabel label = new JLabel("电话号码");
        label.setBounds(10, 87, 60, 15);
        contentPane.add(label);

        phoneNumField = new JTextField();
        phoneNumField.setBounds(80,82,141,25);
        contentPane.add(phoneNumField);

        JLabel label_1 = new JLabel("年龄");
        label_1.setBounds(10, 50, 122, 15);
        contentPane.add(label_1);

        ageField = new JTextField();
        ageField.setBounds(80, 45, 141, 25);
        contentPane.add(ageField);
    }

    protected void do_button_actionPerformed(ActionEvent e){
        String text = phoneNumField.getText(); //获取用户输入
        String info = check(text); //对输入文本进行有效应验证
        JOptionPane.showMessageDialog(null,info); //用对话框输出验证结果
    }

    public String check(String text) {
        if (text == null || text.isEmpty()) {
            return "请输入电话号码";
        }
        //定义正则表达式
        String regex = "^\\d{3}-?\\d{8}|\\d{4}-?\\d{8}$";
        //判断输入字符串是否为电话号码
        if(text.matches(regex)){
            return text +"\n是一个合法的电话号码";
        }else {
            return text + "\n是一个非法的电话号码";
        }
    }
}


