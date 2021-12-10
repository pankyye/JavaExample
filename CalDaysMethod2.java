//需求：输入起始日期和结束日期，计算相差的天数。


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalDaysMethod2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //创建输入流扫描器
        System.out.println("Please input start date: ");
        String line1 = scanner.nextLine();
        System.out.println("Please input end date: ");
        String line2 = scanner.nextLine();

        String[] star1 = line1.split("-");
        String[] end1 = line2.split("-");
        int days = 0;

        if(Integer.parseInt(star1[0])<Integer.parseInt(end1[0])){
            for(int i = Integer.parseInt(star1[0]); i < Integer.parseInt(end1[0]); i++){
                if(i%4==0&&i%100!=0||i%400==0){
                    days += 366;
                }else {
                    days +=365;
                }
            }
        }
        int starday = days(star1[0],star1[1],star1[2]);//得到开始那一年已过去的日期
        int endday = days(end1[0],end1[1],end1[2]); //得到结束那一年已过去的日期
        days = days - starday +endday; //减去开始那一年已过去的日期，加上结束那一年已过去的日期
        System.out.println("相差天数为："+" "+days);

    }
    public static int days(String year, String month, String day){
        int days = 0;
        int nowyear = Integer.parseInt(year);
        int[] monthday ={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] monthday1 ={0,31,29,31,30,31,30,31,31,30,31,30,31};
        boolean flag = true;
        if(nowyear%4==0&&nowyear%100!=0||nowyear%400==0){

        }else {
            flag = false;
        }
        for(int i=0; i<Integer.parseInt(month); i++){
            if(flag){
                days+=monthday1[i];
            }else {
                days+=monthday[i];
            }
        }
        days+=Integer.parseInt(day);
        return days;
    }
}
