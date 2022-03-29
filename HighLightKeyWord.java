//需求：输入搜索关键词，然后在文本中高亮显示

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
使用Highlighter接口的addHighlight()方法可以用来给指定区域的文本增加高亮。该方法声明如下：
 Object addHighlight(int p0,int p1,Highlighter.HighlightPainter p) throws BadLocationException
 参数说明：
 1、p0：范围的开头，该值>=0
 2、p1：范围的结尾，该值>=p0
 3、p：实际高亮显示的painter
 */

public class HighLightKeyWord extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JEditorPane editorPane;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HighLightKeyWord frame = new HighLightKeyWord();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HighLightKeyWord(){
        setTitle("高亮显示关键字");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JLabel label = new JLabel("关键字");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(label);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(15);

        JButton button = new JButton("高亮");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        editorPane = new JEditorPane();
        editorPane.setText("用户要提出好的查询，一个通常的建议是，应该尽量采用那些最有可能出现在相关文档中 的词来构成查询。信息检索中的语言建模方法直接对上述思路建模:给定查询，如果某篇文档 所对应的文档模型可能生成该查询，那么这篇文档是一个好的匹配文档。此时，查询词项也往 往在该文档中频繁出现。虽然语言建模方法也遵循 6.2 节所讨论的文档排序的概率思路，但是 它却提供了一个与一般概率模型完全不同的文档排序实现方法。在第 11 章传统的概率模型中， 需要对文档 d 与查询 q 的相关概率 P(R = 1|q, d)进行显式建模，而基本的统计建模方法则首先对 每篇文档d建模得到文档的概率语言模型Md，然后按照模型生成查询的概率P(q|Md )的高低来 对文档进行排序。");
        editorPane.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(editorPane);
    }

    protected void do_button_actionPerformed(ActionEvent e){
        String key = textField.getText(); //获得关键字
        String content = editorPane.getText(); // 获取所有文本
        Highlighter highlighter = editorPane.getHighlighter(); //获得默认的highlighter对象
        highlighter.removeAllHighlights(); //移除原有的高亮显示区域
        if (content.contains(key)){ //如果包含关键字
            int index = content.indexOf(key); //确定第一个关键字的未知
            while (true){
                if (index != -1){ //如果还有关键字为高亮
                    try{
                        highlighter.addHighlight(index,index + key.length(), DefaultHighlighter.DefaultPainter); //高亮关键字
                    }catch (BadLocationException e1){
                        e1.printStackTrace();
                    }
                    index = content.indexOf(key, ++index); //确定下一个关键字的位置
                }else {
                    break;
                }
            }
        }
    }
}

