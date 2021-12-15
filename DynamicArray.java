//需求：输入学生姓名，点击添加按钮后，将该学生姓名添加到学生列表中。同时选中某个学生姓名，点击删除按钮，即可从学生列表中删除该学生姓名。


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



//新建窗体类DynamicArray。在窗体中添加文本框控件、列表控件，以及"添加学生"和"删除学生"两个按钮。
public class DynamicArray extends JFrame {
    private JPanel contentPane;
    private final JPanel panel = new JPanel();

    // Launch the application

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("");
        }catch (Throwable e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    DynamicArray frame = new DynamicArray();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
    // Create the frame.
    public DynamicArray(){
        setTitle("用动态数组保存学生姓名");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,337,269);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane,BorderLayout.CENTER);

        list = new JList();
        scrollPane.setViewportView(list);

        JPanel panel_1 = new JPanel();
        scrollPane.setColumnHeaderView(panel_1);

        JLabel label = new JLabel("学生姓名");
        panel_1.add(label);

        textField = new JTextField();
        panel_1.add(textField);
        textField.setColumns(10);
        panel.setPreferredSize(new Dimension(100,10));
        contentPane.add(panel, BorderLayout.EAST);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));

        JButton button = new JButton("添加学生");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                do_button_actionperformed(e);
            }
        });
        panel.add(button);

        JButton button_1 = new JButton("删除学生");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                do_button_1_actionPerformed(e);
            }
        });
        panel.add(button_1);
    }

    private ArrayList<String> arrayList = new ArrayList<String>();
    private JTextField textField;
    private JList list;

    protected void do_button_actionperformed(ActionEvent e){
        textField.requestFocusInWindow();
        textField.selectAll();
        String text = textField.getText(); //获取用户输入的姓名
        if (text.isEmpty())
            return;
        arrayList.add(text);  //把姓名添加到数组集合中
        replaceModel(); //把数组集合中的内容显示到界面列表控件中
    }

    protected void do_button_1_actionPerformed(ActionEvent e){
        Object value = list.getSelectedValue(); //获取列表控件中的选择项
        arrayList.remove(value); //从数组集合中移除用户的选择项
        replaceModel();  //把数组集合中的内容显示到界面列表控件中
    }

    private void replaceModel(){
        // 为列表控件设置数据模型，用于显示数组集合中的数据
        list.setModel(new AbstractListModel() {
            @Override
            public int getSize(){         // 获取数组大小
                return arrayList.size();
            }
            @Override
            public Object getElementAt(int index){   // 获取指定索引元素
                return arrayList.get(index);
            }
        });
    }

}
