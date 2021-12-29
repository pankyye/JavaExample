package ProvinceCityMap;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;


public class BackgroundPanel extends JPanel{
    private Image image;
    public BackgroundPanel(){
        super();
        setOpaque(false);
        setLayout(null);
    }

    public void setImage(Image image){
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g){
        if(image != null){
            int width = getWidth();
            int height = getHeight();
            g.drawImage(image,0,0,width,height,this);
        }
        super.paintComponent(g);
    }
}
