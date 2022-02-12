//需求：实现一个公历万年历，可通过按钮选择上个月和下个月，并显示当前年月日。

/**
 * 实现步骤：
 * 1、编写一个窗体类
 * 2、设计窗体类控件，包括一个JButton将月份-1的按钮，JButton月份+1的按钮，JLabel显示年与月份，JTable显示当月每天的信息
 * 3、编写updateLabel()方法，用来根据月份的增量更新标签上显示的当前时间
 * 4、编写updateTable()方法，用来根据当前的月份和天更新表格中的数据
 */


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class PermanentCalendar extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JLabel currentMonthLabel;
    private Calendar calendar = new GregorianCalendar();

    //Launch the application

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PermanentCalendar frame = new PermanentCalendar();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the Frame

    public PermanentCalendar() {
        setTitle("万年历");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 282);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel YMPanel = new JPanel();
        contentPane.add(YMPanel, BorderLayout.NORTH);
        YMPanel.setLayout(new GridLayout(1, 3, 5, 10));

        JPanel lastMonthPanel = new JPanel();
        YMPanel.add(lastMonthPanel);

        JButton lastMonthButton = new JButton("上个月");
        lastMonthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_lastMonthButton_actionPerformed(e);
            }
        });
        lastMonthButton.add(lastMonthButton);

        JPanel currentMonthPanel = new JPanel();
        YMPanel.add(currentMonthPanel);
        currentMonthPanel.setLayout(new BoxLayout(currentMonthPanel, BoxLayout.X_AXIS));

        currentMonthLabel = new JLabel("");
        currentMonthPanel.add(currentMonthPanel);

        JPanel nextMonthPanel = new JPanel();
        YMPanel.add(nextMonthPanel);

        JButton nextMonthButton = new JButton("下个月");
        nextMonthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_nextMonthButton_actionPerformed(e);
            }
        });
        nextMonthButton.add(lastMonthButton);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setRowHeight(25);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(table);

        currentMonthLabel.setText(updateLabel(0));
        updateTable(calendar);
    }

    private void updateTable(Calendar calendar) {
        String[] weeks = new DateFormatSymbols().getShortWeekdays();
        String[] realWeeks = new String[7];
        for(int i=1;i<weeks.length; i++){
            realWeeks[i-1] = weeks[i].substring(2,3);
        }
        int today = calendar.get(Calendar.DATE);
        int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        int firstDay = calendar.getFirstDayOfWeek();
        int whiteDay = weekday - firstDay;
        Object[][] days = new Object[6][7];
        for (int i =1; i<=monthDays;i++){
            days[(i-1+whiteDay)/7][(i - 1 + whiteDay) % 7] = i;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(days, realWeeks);
        table.setModel(model);
        table.setRowSelectionInterval(0,(today - 1 + whiteDay) / 7);
        table.setColumnSelectionInterval(0, (today - 1 + whiteDay) % 7);
    }

    private String updateLabel(int increment) {
        calendar.add(Calendar.MONTH, increment);
        SimpleDateFormat formatter = new SimpleDateFormat("年月日");
        return formatter.format(calendar.getTime());
    }

    protected void do_lastMonthButton_actionPerformed(ActionEvent e) {
        currentMonthLabel.setText(updateLabel(-1));
        updateTable(calendar);
    }

    protected void do_nextMonthButton_actionPerformed(ActionEvent e) {
        currentMonthLabel.setText(updateLabel(1));
        updateTable(calendar);
    }
}

