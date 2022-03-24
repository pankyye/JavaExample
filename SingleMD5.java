//需求：MD5加密是一种单项加密技术，加密后生成固定的byte[]类型的数据，通常用于用户密码的加密。
// 用户注册时，把用户密码进行加密后保存起来，每次用户登陆时输入的密码也会被加密，然后之前保存的加密密码做比较验证。


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SingleMD5 {
    static String algorithm = "MD5"; //参数 algorithm 表示指定算法的信息摘要

    public static byte[] encryptMD5(byte[] data)
        throws NoSuchAlgorithmException{
        //指定加密算法
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        //进行加密
        digest.update(data);
        return digest.digest();
    }

    //创建encryptMD5toString()方法把byte[]类型的数据转换成16进制的字符串
    public static String encryptMD5toString(byte[] data)
        throws NoSuchAlgorithmException{
        String str = "";
        String str16;
        System.out.println(data.length);
        for(int i = 0; i<data.length; i++){
            //转换成十六进制数据
            str16 = Integer.toHexString(0xFF & data[i]);
            //如果长度为1，前位补0
            if(str16.length() ==1){
                str = str + "0" + str16;
            }else {
                str = str +str16;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String data = "我爱你";
        System.out.println("加密前："+data);
        byte[] data1 = null;
        String str = null;
        try {
            data1 = SingleMD5.encryptMD5(data.getBytes());
            str = SingleMD5.encryptMD5toString(data1);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        System.out.println("加密后byte[]类型："+new String(data1));
        System.out.println("加密后String类型："+str);
    }
}
