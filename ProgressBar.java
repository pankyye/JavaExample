//需求：点击运行程序，文本框中依次输出500以内的全部素数，并通过进度条显示输出进度。

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProgressBar extends JFrame {
    private JPanel contentPane;
    private JButton button;
    private JTextArea textArea;
    private JProgressBar progressBar;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProgressBar frame = new ProgressBar();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProgressBar(){
        setTitle("查看程序运行进度");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,396,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel,BorderLayout.SOUTH);

        button = new JButton("运行程序");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑",Font.PLAIN,16));
        panel.add(button);

        progressBar = new JProgressBar();
        progressBar.setPreferredSize(new Dimension(200,100));
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("微软雅黑",Font.PLAIN,16));
        panel.add(progressBar);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        scrollPane.setViewportView(textArea);
    }
    protected void do_button_actionPerformed(ActionEvent e){
        button.setEnabled(false); //禁用按钮
        Activity activity = new Activity(500);
        activity.execute(); //启动线程
    }

    protected class Activity extends SwingWorker<Void,Integer>{ //activity类负责计算素数并更新进度条
        private int current;
        private int target;

        public Activity(int target){
            this.target = target;
        }
        @Override
        //筛选出所有满足条件的素数
        protected Void doInBackground() throws Exception{
            while(current<target){
                Thread.sleep(50);
                if (isPrime(current)){
                    publish(current);
                }
                current++;
            }
            return null;
        }

        @Override
        //更新文本区和进度条
        protected void process(List<Integer> chunks){
            for (Integer chunk: chunks){
                textArea.append(chunk + " ");
                progressBar.setValue(chunk/5);
                if (chunk == 499){
                    progressBar.setValue(100);
                }
            }
        }

        @Override
        protected void done(){
            button.setEnabled(true);
        } //启动按钮

        //计算素数值
        private boolean isPrime(int number){
            if (number<2){ //0、1不是素数
                return false;
            }else {
                int sqrt = (int) Math.sqrt(number); //求给定数的平方根
                for (int i=2; i<=sqrt;i++){ //遍历可能的公因数
                    if (number % i ==0){ //如果有公因数则不是素数
                        return false;
                    }
                }
            }
            return true;
        }
    }

}

