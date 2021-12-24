//需求：通过 DateFormat类，对日期进行格式化处理。根据输入的不同国家，用该国家的语言展示出当前日期。


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class FormatDate {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        String string = formater.format(date);
        System.out.println("China time: \t"+string);

        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println("Canada time: \t"+formater.format(date));

        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.JAPAN);
        System.out.println("Japan time: \t"+formater.format(date));

        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
        System.out.println("France time: \t"+formater.format(date));

        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.KOREA);
        System.out.println("France time: \t"+formater.format(date));

        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println("France time: \t"+formater.format(date));
    }
}
