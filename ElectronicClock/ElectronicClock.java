//需求：编写一个电子时钟。

package ElectronicClock;



/**
 * 实现步骤：
 * 1.编写一个名为ElectronicClock的窗体类，继承JFrame;
 * 2.该窗体类包含8个Jlabel控件，分别显示电子时钟的：
 * 小时第一位图片
 * 小时第二位图片
 * 小时和分钟的分隔符
 * 分钟的第一位图片
 * 分钟的第二位图片
 * 分钟和秒钟的分隔符
 * 秒钟的第一位图片
 * 秒钟的第二位图片
 * 3.编写numbers数组，获取所有图片资源；
 * 4.编写getTime()方法，获取当前时间并更新图片；
 * 5.编写ClockRunnable类，该类实现了Runnable接口。在run()方法中，每隔一秒更新一次图片，由此实现走动的效果。
 */


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ElectronicClock extends JFrame {
    private static final long serialVersionUID = 3688891358876658465L;
    private JPanel contentPane;
    private ImageIcon colon = new ImageIcon("ElectronicClock/colon/png");
    private ImageIcon[] numbers = {
            new ImageIcon("ElectronicClock/0.png"),new ImageIcon("ElectronicClock/1.png"),new ImageIcon("ElectronicClock/2.png"),new ImageIcon("ElectronicClock/3.png"),new ImageIcon("ElectronicClock/4.png"),
            new ImageIcon("ElectronicClock/5.png"),new ImageIcon("ElectronicClock/6.png"),new ImageIcon("ElectronicClock/7.png"),new ImageIcon("ElectronicClock/8.png"),new ImageIcon("ElectronicClock/9.png"),
    };
    private JLabel hour1Label;
    private JLabel hour2Label;
    private JLabel colon1Label;
    private JLabel minute1Label;
    private JLabel minute2Label;
    private JLabel colon2Label;
    private JLabel second1Label;
    private JLabel second2Label;

   //Launch the application

    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("");
        }catch (Throwable e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    ElectronicClock frame = new ElectronicClock();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the Frame

    public ElectronicClock(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
               do_this_windowActivated(arg0);
            }
        });
        setTitle("电子时钟");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 100);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 8, 5, 5));

        JPanel hour1Panel = new JPanel();
        contentPane.add(hour1Panel);

        hour1Label = new JLabel("");
        hour1Label.setHorizontalAlignment(SwingConstants.CENTER);
        hour1Panel.add(hour1Label);

        JPanel hour2Panel = new JPanel();
        contentPane.add(hour2Panel);

        hour2Label = new JLabel("");
        hour2Label.setHorizontalAlignment(SwingConstants.CENTER);
        hour2Panel.add(hour2Label);

        JPanel colon1Panel = new JPanel();
        contentPane.add(colon1Panel);

        colon1Label = new JLabel("");
        colon1Label.setHorizontalAlignment(SwingConstants.CENTER);
        colon1Panel.add(colon1Label);

        JPanel minute1Panel = new JPanel();
        contentPane.add(minute1Panel);

        minute1Label = new JLabel("");
        minute1Label.setHorizontalAlignment(SwingConstants.CENTER);
        minute1Panel.add(minute1Label);

        JPanel minute2Panel = new JPanel();
        contentPane.add(minute2Panel);

        minute2Label = new JLabel("");
        minute2Label.setHorizontalAlignment(SwingConstants.CENTER);
        minute2Panel.add(minute2Label);

        JPanel colon2Panel = new JPanel();
        contentPane.add(colon2Panel);

        colon2Label = new JLabel("");
        colon2Label.setHorizontalAlignment(SwingConstants.CENTER);
        colon2Panel.add(colon2Label);

        JPanel second1Panel = new JPanel();
        contentPane.add(second1Panel);

        second1Label = new JLabel("");
        second1Label.setHorizontalAlignment(SwingConstants.CENTER);
        second1Panel.add(second1Label);

        JPanel second2Panel = new JPanel();
        contentPane.add(second2Panel);

        second2Label = new JLabel("");
        second2Label.setHorizontalAlignment(SwingConstants.CENTER);
        second2Panel.add(second2Label);
    }

    private void getTime(){
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); //获取当前的小时
        int minute = calendar.get(Calendar.MINUTE);  //获取当前的分钟
        int second = calendar.get(Calendar.SECOND);  //获取当前的秒钟
        hour1Label.setIcon(numbers[hour/10]); //利用商获取小时第一位图片
        hour2Label.setIcon(numbers[hour%10]); //利用余数获取小时第二位图片
        minute1Label.setIcon(numbers[minute/10]);
        minute2Label.setIcon(numbers[minute%10]);
        second1Label.setIcon(numbers[second/10]);
        second2Label.setIcon(numbers[second%10]);
    }

    private class ClockRunnable implements Runnable{
        @Override
        public void run(){
            while (true){
                getTime();
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    protected void do_this_windowActivated(WindowEvent arg0){
        colon1Label.setIcon(colon);
        colon2Label.setIcon(colon);
        new Thread(new ClockRunnable()).start();
    }
    }



