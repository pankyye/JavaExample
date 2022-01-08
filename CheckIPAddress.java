//需求：检查IP地址的有效性

/**
 * 实现步骤：
 * 1 创建窗体类CheckIPAddress，在该类中添加一个输入IP地址的文本框和一个【验证】按钮；
 * 2 编写验证按钮的事件处理方法，该方法：
 *      a.获取用户输入
 *      b.调用matches方法对输入进行判断
 *      c.在对话框中输出结果
 */


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CheckIPAddress extends JFrame {
    private JPanel contentPane;
    private JTextField ipField;

   //Launch the application

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    CheckIPAddress frame = new CheckIPAddress();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the Frame

    public CheckIPAddress(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,280,128);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblip = new JLabel("请输入IP地址：");
        lblip.setBounds(12,14,92,15);
        contentPane.add(lblip);

        ipField = new JTextField();
        ipField.setBounds(100,10,141,25);
        contentPane.add(ipField);

        JButton button = new JButton("验证");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(66,57,93,23);
        contentPane.add(button);
    }

    protected void do_button_actionPerformed(ActionEvent e){
        String text = ipField.getText(); //获取用户输入
        String info = matches(text); //对输入文本进行IP有效应验证
        JOptionPane.showMessageDialog(null,info); //用对话框输出验证结果
    }

    public String matches(String text){
        if(text != null&& !text.isEmpty()){
            //定义正则表达式
            String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
            //判断IP地址是否与正则表达式匹配
            if(text.matches(regex)){
                //返回判断信息
                return text + "\n是一个合法的IP地址";
            }else {
                //返回判断信息
                return text +"\n不是一个合法的IP地址";
            }
        }
        //返回判断信息
        return "请输入要验证的IP地址";
    }
}

