import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.*;

public class WinText extends Frame implements TextListener {
    TextArea ta = new TextArea("请输入心中想说的话：");
    WinText(){
        this.setTitle("");
        this.add(ta);
        Font f = new Font("楷体",Font.ITALIC + Font.BOLD,18);
        ta.setFont(f);
        ta.addTextListener(this);
        ta.setForeground(Color.RED);
        this.setBounds(100,100,450,400);
        this.setVisible(true);
    }
    public void textValueChanged(TextEvent e){
        System.out.println(ta.getText());
    }
    public static void main(String args[]){
        new WinText();
    }
}
