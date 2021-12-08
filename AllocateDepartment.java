//需求：判断输入的年份是否为闰年

/* 地球绕太阳运行周期为365天5小时48分46秒，比我们定义的一年365天多了0.2422日，四年下来多一天。因此在第四年的2月份加上一天，作为弥补。*/

import java.util.Scanner;

public class AllocateDepartment {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the name of new employee: ");
        String name = scan.nextLine();
        System.out.println("Please input the employee's language: ");
        String language = scan.nextLine();

        switch (language.hashCode()){
            case 32554818:
            case 2301506:
            case 2269730:
                System.out.println("employee"+" "+name+" "+"is allocated to Java department");
                break;
            case 3104:
            case 2112:
                System.out.println("employee"+" "+name+" "+"is allocated to C# department");
                break;
            case -709190099:
            case 955463181:
            case 9745901:
                System.out.println("employee"+" "+name+" "+"is allocated to ASP.NET department");
                break;
            default:
                System.out.println("we do not need"+" "+language+" "+"program developer");
        }
    }
}
