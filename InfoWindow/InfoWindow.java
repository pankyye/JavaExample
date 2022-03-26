package InfoWindow;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InfoWindow extends JWindow {
    public InfoWindow(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                do_this_mousePressed(e);
            }
        });
        setBounds(100,100,359,228);
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    protected void do_this_mousePressed(MouseEvent e){
        dispose();
    }
}
