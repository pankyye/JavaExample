//需求：判断输入的年份是否为闰年

/* 地球绕太阳运行周期为365天5小时48分46秒，比我们定义的一年365天多了0.2422日，四年下来多一天。因此在第四年的2月份加上一天，作为弥补。*/

import java.util.Scanner;

public class IfLeapYear {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a year: ");
        long year = scan.nextLong(); //get input
        if(year % 4 == 0 && year % 100 != 0 || year % 400 ==0){
            System.out.println(year +" "+ "is leapyear");
        }else {
            System.out.println(year +" " + "is not leapyear");
        }
    }
}
