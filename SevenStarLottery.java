//需求：实现一个七彩星中奖号码生成器，中奖号码为7位随机数。

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SevenStarLottery extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 6787592245621788484L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SevenStarLottery frame = new SevenStarLottery();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SevenStarLottery() {
        setTitle("七彩星号码生成器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(1, 2, 5, 5));

        JLabel label = new JLabel("输入要生成的号码个数");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        panel.add(textField);
        textField.setColumns(10);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton button = new JButton("生成号码");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        buttonPanel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        scrollPane.setViewportView(textArea);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        int times = Integer.parseInt(textField.getText());// 获取用户输入的生成个数
        // 保存中奖号码
        StringBuilder sb = new StringBuilder();//
        for (int i = 0; i < times; i++) {
            int number = new Random().nextInt((int) Math.pow(10, 7));// 生成随机数
            String luckNumber = "" + number;
            while (luckNumber.length() < 7) {
                luckNumber = "0" + luckNumber;// 如果随机数长度小于7，则用0补齐
            }
            sb.append(luckNumber + "\n");
        }
        textArea.setText(sb.toString());// 显示生成的中奖号码
    }
}





