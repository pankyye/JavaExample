//需求：判断输入的年份是否为闰年

/* 地球绕太阳运行周期为365天5小时48分46秒，比我们定义的一年365天多了0.2422日，四年下来多一天。因此在第四年的2月份加上一天，作为弥补。*/

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutputStream {
    public static void main(String[] args){
        try{
            PrintStream out = System.out; // 保存原输出流
            PrintStream ps = new PrintStream("./log.txt");
            System.setOut(ps);

            int age = 18;
            System.out.println("年龄变量成功定义，初始值为18");
            String sex = "female";
            System.out.println("性别变量成功定义，初始值为女");

            //整合两个变量
            String info = "这个是"+sex+"孩子应该有"+age+"岁了";
            System.out.println("整合两个变量为info字符串变量，其结果是："+" "+info);
            System.setOut(out);
            System.out.println("程序运行完毕，请查看日志文件。");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
