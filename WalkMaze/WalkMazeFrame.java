package WalkMaze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

@SuppressWarnings("serial")
public class WalkMazeFrame extends JFrame implements KeyListener, Runnable {
    Rectangle rect1, rect2, rect3, rect4;
    int goButtonX = 0, goButtonY = 0;
    final JButton goButton = new JButton();
    URL url = getClass().getResource("WalkMaze/pig.png");
    ImageIcon imageIcon = new ImageIcon(url);
    final JLabel label = new JLabel();

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WalkMazeFrame frame = new WalkMazeFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public WalkMazeFrame() {
        super();
        addWindowListener(new WindowAdapter() {
            public void windowOpened(final WindowEvent e) {
                goButton.requestFocus();
            }
        });

        getContentPane().setLayout(null);
        setBounds(100, 100, 488, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("小猪走迷宫");
        BackgroundPanel panel = new BackgroundPanel();
        rect1 = new Rectangle(0, 55, 190, 40);
        rect2 = new Rectangle(190, 40, 40, 240);
        rect3 = new Rectangle(190, 180, 230, 40);
        rect4 = new Rectangle(300, 180, 40, 140);
        setResizable(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 482, 341);
        getContentPane().add(panel);
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                buttonAction(e);
            }
        });
        URL url = getClass().getResource("WalkMaze/button.png");
        ImageIcon imageIcons = new ImageIcon(url);
        button.setIcon(imageIcons);
        button.setBounds(27, 100, 106, 28);
        goButton.setBounds(0, 40, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        panel.add(goButton);
        panel.add(button);
        goButtonX = goButton.getBounds().x;
        goButtonY = goButton.getBounds().y;
        goButton.addKeyListener(this);
        goButton.setIcon(imageIcon);
        goButton.setContentAreaFilled(false);
        goButton.setBorder(null);
        url = getClass().getResource("WalkMaze/exit.png");
        imageIcons = new ImageIcon(url);
        label.setIcon(imageIcons);
        label.setBounds(300, 315, imageIcons.getIconWidth(), imageIcons.getIconHeight());
        panel.add(label);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (goButtonY == 286) {
            Thread thread = new Thread(this);
            thread.start();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Rectangle rectAngle = new Rectangle(goButtonX, goButtonY, 20, 20);
            if (rectAngle.intersects(rect1) || rectAngle.intersects(rect2) || rectAngle.intersects(rect3) || rectAngle.intersects(rect4)) {
                goButtonY = goButtonY - 2;
                goButton.setLocation(goButtonX, goButtonY);
            } else {
                JOptionPane.showMessageDialog(this, "****", "*****", JOptionPane.DEFAULT_OPTION);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Rectangle rectAngle = new Rectangle(goButtonX, goButtonY, 20, 20);
            if (rectAngle.intersects(rect1) || rectAngle.intersects(rect2) || rectAngle.intersects(rect3) || rectAngle.intersects(rect4)) {
                goButtonY = goButtonY + 2;
                goButton.setLocation(goButtonX, goButtonY);
            } else {
                JOptionPane.showMessageDialog(this, "****", "****", JOptionPane.DEFAULT_OPTION);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Rectangle rectAngle = new Rectangle(goButtonX, goButtonY, 20, 20);
            if (rectAngle.intersects(rect1)
                    || rectAngle.intersects(rect2)
                    || rectAngle.intersects(rect3)
                    || rectAngle.intersects(rect4)) {
                goButtonX = goButtonX - 2;
                goButton.setLocation(goButtonX, goButtonY);
            } else {
                JOptionPane.showMessageDialog(this, "*****", "*****", JOptionPane.DEFAULT_OPTION);
            }
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Rectangle rectAngle = new Rectangle(goButtonX, goButtonY, 20, 20);
            if (rectAngle.intersects(rect1)
                    || rectAngle.intersects(rect2)
                    || rectAngle.intersects(rect3)
                    || rectAngle.intersects(rect4)) {
                goButtonX = goButtonX + 2;
                goButton.setLocation(goButtonX, goButtonY);
            } else {
                JOptionPane.showMessageDialog(this, "*****", "*****", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void buttonAction(ActionEvent e){
        goButton.setIcon(imageIcon);
        goButton.addKeyListener(this);
        goButton.setBounds(0,40,imageIcon.getIconWidth(),imageIcon.getIconHeight());
        goButtonX = goButton.getBounds().x;
        goButtonY = goButton.getBounds().y;
        goButton.requestFocus();
    }



    @Override
    public void run(){
        URL out = getClass().getResource("WalkMaze/pigOut.png");
        ImageIcon imageout = new ImageIcon(out);
        goButton.setIcon(imageout);
        goButton.setBounds(goButtonX, goButtonY - imageout.getIconHeight() + 50, imageout.getIconWidth(), imageout.getIconHeight());
        goButton.removeKeyListener(this);
    }
}

