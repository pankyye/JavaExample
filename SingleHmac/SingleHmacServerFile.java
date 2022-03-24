package SingleHmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SingleHmacServerFile {
    static String algorithm = "HmacMD5";
    static String keyFile = "keyData.dat";

    public void initMacKey() throws NoSuchAlgorithmException{
        //生成密钥生成器
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        //生成密钥
        SecretKey key = generator.generateKey();
        //把密钥保存在keyData.bat文件里
        writeFile(key.getEncoded(), keyFile);
    }

    //在服务端通过encryptHMAC()方法加密原文，然后生成byte[]类型的数据摘要
    public byte[] encryptHMAC(byte[] data) throws NoSuchAlgorithmException, InvalidKeyException{
        //读取密钥
        byte key[] = readFile(keyFile);
        SecretKey secretKey = new SecretKeySpec(key, algorithm);
        //进行加密操作
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return mac.doFinal();
    }

    public void writeFile(byte[] data, String fileName){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(data);
            fileOutputStream.close();
        }catch (FileNotFoundException e2){
            e2.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
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

    public static void main(String[] args) throws NoSuchAlgorithmException,InvalidKeyException{
        SingleHmacServerFile singleHmacServerFile = new SingleHmacServerFile();
        SingleHmacClientFile singleHmacClientFile = new SingleHmacClientFile();
        String data = "模仿游戏";
        System.out.println("加密前:"+data);
        String strData = null;
        String strDataClient = null;

        //生成密钥
        singleHmacServerFile.initMacKey();
        //服务端加密
        strData = BothBase64.encryptBASE64(singleHmacServerFile.encryptHMAC(data.getBytes()));
        //客户端加密
        strDataClient = BothBase64.encryptBASE64(singleHmacClientFile.encryptHMAC(data.getBytes()));

        System.out.println("服务端加密后："+strData);
        System.out.println("客户端加密后："+strDataClient);
        //比较加密结果
        if(strData.equals(strDataClient)){
            System.out.println("验证通过");
        }else {
            System.out.println("验证不通过");
        }
    }

}

