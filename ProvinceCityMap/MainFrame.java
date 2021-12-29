package ProvinceCityMap;

//需求：

/*
实现方法：

 */


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import ProvinceCityMap.BackgroundPanel;
import ProvinceCityMap.SwingResourceManager;
import java.util.Map;


public class MainFrame extends JFrame {
    private JTextField textField_3;
    private JTextField textField_1;
    private JComboBox comboBox_1;
    private JTextField textField;
    private JComboBox comboBox;
    private JComboBox cityComboBox;

    // Launch the application

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    UIManager.setLookAndFeel("****");
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

    // Create the frame.
    public MainFrame() {
        getContentPane().setLayout(null);
        setBounds(100, 100, 518, 379);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String province = (String) getProvince()[0];
        setTitle("*****");

        final BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setImage(SwingResourceManager.getImage(MainFrame.class, "/images/background.jpg"));
        backgroundPanel.setBounds(0, 0, 510, 380);
        getContentPane().add(backgroundPanel);

        final JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBounds(36, 126, 438, 70);
        backgroundPanel.add(panel);
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null, "****", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        cityComboBox = new JComboBox();
        cityComboBox.setBounds(245, 25, 124, 27);
        panel.add(cityComboBox);

        cityComboBox.setModel(new DefaultComboBoxModel(getCity(province)));

        comboBox = new JComboBox();
        comboBox.setBounds(25, 25, 124, 27);
        panel.add(comboBox);
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent e) {
                itemChanged();

            }
        });

        comboBox.setModel((new DefaultComboBoxModel(getProvince())));

        final JLabel label = new JLabel();
        label.setText("*****");
        label.setBounds(155, 30, 66, 18);
        panel.add(label);

        final JLabel label1 = new JLabel();
        label1.setText("*****");
        label1.setBounds(375, 30, 37, 18);
        panel.add(label1);

        final JLabel label2 = new JLabel();
        label2.setBounds(36, 43, 65, 18);
        backgroundPanel.add(label2);
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        label2.setHorizontalTextPosition(SwingConstants.LEADING);
        label2.setText("*****");

        textField = new JTextField();
        textField.setBounds(113, 38, 154, 28);
        backgroundPanel.add(textField);

        final JLabel label3 = new JLabel();
        label3.setBounds(36, 84, 65, 18);
        backgroundPanel.add(label3);
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        label3.setHorizontalTextPosition(SwingConstants.LEADING);
        label3.setText("*****");

        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(113, 81, 66, 25);
        backgroundPanel.add(comboBox_1);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"**", "**"}));

        final JLabel label4 = new JLabel();
        label4.setBounds(36, 212, 65, 18);
        backgroundPanel.add(label4);
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        label4.setHorizontalTextPosition(SwingConstants.LEADING);
        label4.setText("*****");

        textField_1 = new JTextField();
        textField_1.setBounds(113, 208, 367, 28);
        backgroundPanel.add(textField_1);

        final JLabel label4_1 = new JLabel();
        label4_1.setBounds(36, 252, 65, 18);
        backgroundPanel.add(label4_1);
        label4_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label4_1.setHorizontalTextPosition(SwingConstants.LEADING);
        label4_1.setText("*****");

        textField_3 = new JTextField();
        textField_3.setBounds(113, 248, 367, 27);
        backgroundPanel.add(textField_3);

        final JButton button = new JButton();
        button.setBounds(159, 289, 75, 28);
        backgroundPanel.add(button);
        button.setText("***");

        final JButton button1 = new JButton();
        button1.setBounds(265, 289, 75, 28);
        backgroundPanel.add(button1);
        button1.setText("***");
    }

    //
    public Object[] getProvince(){
        Map<String,String[]> map = ProvinceCityMap.model;
        Set<String> set = map.keySet();
        Object[] province = set.toArray();
        return province;
    }

    public String[] getCity(String selectProvince){
        Map<String,String[]> map = ProvinceCityMap.model;
        String[] arrCity = map.get(selectProvince);
        return arrCity;
    }

    private void itemChanged(){
        String selectProvince = (String) comboBox.getSelectedItem();
        cityComboBox.removeAllItems();
        String[] arrCity = getCity(selectProvince);
        cityComboBox.setModel(new DefaultComboBoxModel(arrCity));
    }
}
