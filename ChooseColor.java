import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ChooseColor {
    private final int AREA_WIDTH = 500; //画图区的宽度
    private final int AREA_HEIGHT = 400; //画图区的高度
    // preX和preY用来保存上一次鼠标拖动事件的鼠标坐标
    private int preX = -1;
    private int preY = -1;

    JPopupMenu pop = new JPopupMenu(); //定义一个右键菜单用于设置画笔颜色
    JMenuItem chooseColor = new JMenuItem("选择颜色");
    //定义一个BufferedImage对象
    BufferedImage image = new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);

    Graphics g = image.getGraphics(); //获取image对象的Graphics
    private JFrame f = new JFrame("简单的手绘程序");
    private DrawCanvas drawArea = new DrawCanvas();
    private String shape = ""; //用于保存需要绘制什么图形的字符串属性
    private Color foreColor = new Color(255,0,0); //用于保存画笔颜色

    public void init(){
        chooseColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //弹出一个模式的颜色选择器对话框，并返回用户选择的颜色
                foreColor = JColorChooser.showDialog(f,"选择画笔颜色",foreColor);
                //弹出一个非模式的颜色选择对话框，并分别为确定按钮、取消按钮指定事件监听器
                final JColorChooser colorPane = new JColorChooser(foreColor);
                JDialog jd = JColorChooser.createDialog(f, "选择画笔颜色", false,
                        colorPane, new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                foreColor = colorPane.getColor();
                            }
                        },null);
                jd.setVisible(true);
            }
        });
        pop.add(chooseColor); //将菜单项组合成右键菜单
        drawArea.setComponentPopupMenu(pop); //将右键菜单添加到drawArea对象中
        g.fillRect(0,0,AREA_WIDTH,AREA_HEIGHT); //将image对象的背景填充为白色
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));
        drawArea.addMouseMotionListener(new MouseAdapter(){ //监听鼠标移动动作
            //实现按下鼠标键并拖动的事件处理器
            public void mouseDragged(MouseEvent e){
                if(preX >0 && preY > 0){
                    g.setColor(foreColor); //设置当前颜色
                    g.drawLine(preX,preY,e.getX(),e.getY()); //绘制从上一次鼠标拖动事件点到本次鼠标拖动事件点的线段
                }
                //将当前鼠标事件点的x,y坐标保存起来
                preX = e.getX();
                preY = e.getY();
                drawArea.repaint();
            }
        });
        //监听鼠标事件
        drawArea.addMouseListener(new MouseAdapter(){
            //实现鼠标松开的事件处理器
            public void mouseReleased(MouseEvent e){
                //鼠标松开时，把上一次鼠标拖动事件的x,y坐标设为-1
                preX = -1;
                preY = -1;
            }
        });
        f.add(drawArea);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args){
        new ChooseColor().init();
    }
    //让画图区继承JPanel类
    class DrawCanvas extends JPanel{
        //重写JPanel的paint方法，实现绘画
        public void paint(Graphics g){
            //将image绘制到该组件上
            g.drawImage(image,0,0,null);
        }
    }
}
