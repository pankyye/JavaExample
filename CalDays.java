//需求：输入起始日期和结束日期，计算相差的天数。


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalDays {
    public static void main(String[] args) {
        DateFormat dft = new SimpleDateFormat("yyyy-mm-dd");

        Scanner scanner = new Scanner(System.in); //创建输入流扫描器
        System.out.println("Please input start date: ");
        String line1 = scanner.nextLine();
        System.out.println("Please input end date: ");
        String line2 = scanner.nextLine();

        try{
            Date staDay = dft.parse(line1);
            Date endDay = dft.parse(line2);
            long starTime = staDay.getTime();
            long endTime = endDay.getTime();
            long num = endTime - starTime;
            System.out.println("相差天数为："+" "+num/24/60/60/1000);
        }catch (ParseException e){
            e.printStackTrace();
        }

    }
}
