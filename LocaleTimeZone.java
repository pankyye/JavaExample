//需求：根据不同的区域查询该区域所在的时区。

import java.util.TimeZone;

public class LocaleTimeZone {
    public static void main(String[] args) {
        TimeZone zone = TimeZone.getDefault();
        System.out.println("当前主机所在时区："+zone.getDisplayName());
        zone = TimeZone.getTimeZone("Asia/Shanghai");
        System.out.println("中国上海所在时区："+zone.getDisplayName());
        System.out.println("时区的完整名称："+zone.getDisplayName(true,TimeZone.LONG));
        System.out.println("时区的缩写名称："+zone.getDisplayName(true,TimeZone.SHORT));
    }
}
