package ProvinceCityMap;

//需求

/*
实现方法：

 */


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProvinceCityMap {
    public static Map<String,String[]> model = new LinkedHashMap<>();
    static {
        model.put("北京",new String[]{"北京"});
        model.put("上海",new String[]{"上海"});
        model.put("天津",new String[]{"天津"});
        model.put("重庆",new String[]{"重庆"});
        model.put("陕西",new String[]{"西安","宝鸡","咸阳","榆林","铜川","汉中","安康"});
        model.put("浙江",new String[]{"杭州","宁波","嘉兴","绍兴"});
        model.put("江苏",new String[]{"南京","苏州","常州","湖州","无锡","扬州"});
    }
}
