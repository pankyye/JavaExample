package InfoWindow;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class InfoDemoFrame extends JFrame {
    private JPanel contentPane;
    private InfoWindow window = new InfoWindow();
    private Timer timer;
    private Point location;
    private Dimension screenSize;
    private Dimension windowSize;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    InfoDemoFrame frame = new InfoDemoFrame();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public InfoDemoFrame(){
        setTitle("demo窗口");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,500,200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton button = new JButton("点击出现屏幕右下角弹框");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(97,59,300,70);
        contentPane.add(button);
    }

    protected void do_button_actionPerformed(ActionEvent e){
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                location.y -=1;
                if (window.isShowing() && location.y > screenSize.height - windowSize.height){
                    window.setLocation(location);
                }else {
                    Timer source = (Timer) e.getSource();
                    source.stop();
                }
            }
        });
        screenSize = getToolkit().getScreenSize();
        window.setVisible(true);
        window.setAlwaysOnTop(true);
        windowSize = window.getSize();
        location = new Point();
        location.x = screenSize.width - windowSize.width;
        location.y = screenSize.height;
        timer.start();

    }
}
