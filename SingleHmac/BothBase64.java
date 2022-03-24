package SingleHmac;

import java.io.*;


public class BothBase64 {
    public static String encryptBASE64(byte[] data){
        return (new BASE64Encoder()).encodeBuffer(data);
    }

    public static byte[] decryptBASE64(String data) throws IOException{
        return (new BASE64Decoder()).decodeBuffer(data);
    }

    public static void main(String[] args){
        String data = "***";
        System.out.println("***"+data);
        String data1 = BothBase64.encryptBASE64(data.getBytes());
        System.out.println("***"+data1);
        byte[] data2 = null;
        try{
            data2 = BothBase64.decryptBASE64(data1);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("***"+ new String(data2));
    }

}

