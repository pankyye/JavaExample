package WalkMaze;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {
    public BackgroundPanel(){
        super();
    }
    public void paintComponent(Graphics g){
        try{
            URL url = getClass().getResource("WalkMaze/back.jpg");
            ImageIcon image = new ImageIcon(url);
            g.drawImage(image.getImage(),0,0,this);
            g.setColor(Color.RED);
            g.fillRect(0, 40, 190, 40);
            g.setColor(Color.yellow);
            g.fillRect(190, 40, 40, 240);
            g.setColor(Color.pink);
            g.fillRect(190, 180, 230, 40);
            g.setColor(Color.cyan);
            g.fillRect(300, 180, 40, 140);
        }catch (Exception e){
        }
    }
}
