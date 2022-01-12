//需求：使用java的GregorianCalendar类编写一个会走的、有指针的时钟。

/**
 * 实现步骤：
 * 1、重新JFrame类即成的paint()方法，使用该方法向框架上绘制刻度、表盘、指针等；
 * 2、编写ClockRunnable类，该类实现了Runnable接口。在run()方法中，每隔一秒重新绘制一次图片，由此实现走动的效果。
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class SimulatedClock extends JFrame {
    private JPanel contentPane;
    private JLabel imageLabel;

   //Launch the application

    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (Throwable e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    SimulatedClock frame = new SimulatedClock();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the Frame

    public SimulatedClock(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setTitle("模拟时钟");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,300,300);
    }

    public void paint(Graphics g){
        super.paint(g);
        Rectangle rectangle = getBounds();
        Insets insets = getInsets();
        int radius = 120;
        int x = (rectangle.width - 2*radius - insets.right)/2 + insets.left;
        int y = (rectangle.height - 2 * radius - insets.top - insets.bottom) / 2 + insets.top;
        Point2D.Double center = new Point2D.Double(x +radius, y + radius);
        g.drawOval(x,y,2*radius,2*radius);
        Point2D.Double[] scales = new Point2D.Double[60];
        double angle = Math.PI/30;
        for(int i=0;i<scales.length;i++){
            scales[i] = new Point2D.Double();
            scales[i].setLocation(x + radius + radius * Math.sin(angle * i), y + radius - radius * Math.cos(angle * i));
        }
        for(int i=0;i<scales.length;i++){
            if(i % 5 ==0){
                g.setColor(Color.RED);
                g.fillOval((int) scales[i].x-4,(int) scales[i].y-4,8,8);
            }else {
                g.setColor(Color.CYAN);
                g.fillOval((int) scales[i].x - 2, (int) scales[i].y - 2, 4, 4);
            }
        }
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.draw(new Line2D.Double(center, scales[second]));
        BasicStroke bs = new BasicStroke(3f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
        g2d.setColor(Color.BLUE);
        g2d.draw(new Line2D.Double(center, scales[minute]));// »æÖÆ·ÖÕë
        bs = new BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.setColor(Color.GREEN);
        g2d.draw(new Line2D.Double(center, scales[hour * 5 + minute / 12]));
    }

    private class ClockRunnable implements Runnable{
        @Override
        public void run(){
            while (true){
                repaint();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    protected void do_this_windowActivated(WindowEvent arg0){
        new Thread(new ClockRunnable()).start();
    }

}

