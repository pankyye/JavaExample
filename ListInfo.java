//需求：在业务方法中将学生信息、商品信息等存储到集合中，然后作为方法的返回值返回给调用者，用来传递有序数据。


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


//新建窗体类ListInfo，在窗体中添加滚动面板，用于放置表格控件。
public class ListInfo extends JFrame {
    private JPanel contentPane;
    private JTable table;

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
                    ListInfo frame = new ListInfo();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
    // Create the frame.
    public ListInfo(){
        setTitle("用List集合传递学生信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,392,223);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(getTable());
    }

    //编写getTable()方法，在该方法中创建表格对象，并设置表格的数据模型，然后通过调用getStudents()方法获取保存学生信息的集合对象，在遍历该集合对象的同时把每个元素添加到表格模型的行
    //并显示到表格控件中。
    private JTable getTable(){
        if (table == null){
            table = new JTable(); //创建表格控件
            table.setRowHeight(23); //设置行高度
            String[] columns = {"name","gender","date"};  //创建列名称数组
            //创建表格模型
            DefaultTableModel model = new DefaultTableModel(columns,0);
            table.setModel(model);  //设置表格模型
            //调用方法传递List集合对象
            List<String> students = getStudents();
            for (String info : students){     //遍历学生集合对象
                String[] args = info.split(",");   //把学生信息拆分为数组
                model.addRow(args);   //把学生信息添加到表格的行
            }
        }
        return table;
    }

    //编写getStudents()方法，该方法将向调用者传递List集合对象，并为集合对象添加多个元素，每个元素值都是一个学生信息，其中包括姓名，性别，出生日期。
    private java.util.List<String> getStudents(){
        //创建List集合
        java.util.List<String> list = new ArrayList<String>();
        list.add("Alex,male,1981-1-1");  //添加数据到集合对象
        list.add("Bob,male,1986-1-1");
        list.add("Claire,female,1981-4-5");
        list.add("Dogsma,male,1981-1-1");
        list.add("Fill,male,1988-1-3");
        list.add("Rechal,male,1988-10-10");
        list.add("Ross,male,1998-10-19");
        list.add("Chandellar,male,1981-1-14");
        list.add("Pheobe,male,1986-3-4");
        return list;

    }


}
