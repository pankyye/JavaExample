//Hmac加密可用于数据传输的确认。

/**
 * 应用举例：用户需要做一次投票，需要保证投票数据
 * 1）在投票之前服务端先生成一个密钥，然后把密钥发送给客户端；
 * 2）服务端同时使用该密钥对投票题目进行加密并生成一个信息摘要；
 * 3）客户端得到密钥后也使用这个密钥对投票的题目进行加密并生成信息摘要；
 * 4）客户端将信息摘要和投票结果发送给服务端；
 * 5）服务端收到后，把客户端的信息摘要和服务端的信息摘要进行比较，如果二者一致则认为是有效的投票；
 */



package SingleHmac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SingleHmacClientFile {
    static String algorithm ="HmacMD5";
    static String keyFile = "keyData.dat";
    static String dataFile = "fileData.dat";

    // //在客户端通过encryptHMAC()方法加密原文，然后生成byte[]类型的数据摘要
    public byte[] encryptHMAC(byte[] data) throws NoSuchAlgorithmException,InvalidKeyException{
        //读取密钥
        byte key[] = readFile(keyFile);
        SecretKey secretKey = new SecretKeySpec(key,algorithm);
        //进行加密操作
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return mac.doFinal();
    }

    public byte[] readFile(String fileName){
        try{
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fileInputStream.read(data);
            fileInputStream.close();
            return data;
        }catch (FileNotFoundException e1){
            e1.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}

