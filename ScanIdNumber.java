//需求：判断输入的年份是否为闰年

/* 地球绕太阳运行周期为365天5小时48分46秒，比我们定义的一年365天多了0.2422日，四年下来多一天。因此在第四年的2月份加上一天，作为弥补。*/

import java.util.Scanner;

public class ScanIdNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //创建输入流扫描器
        System.out.println("Please input your ID number: ");
        String line = scanner.nextLine(); //获取用户输入的一行文本
        System.out.println("Your ID number is" + " "+line.length() +" "+ "digits");
    }
}
