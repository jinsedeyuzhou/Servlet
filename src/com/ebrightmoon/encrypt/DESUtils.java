package com.ebrightmoon.encrypt;


import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES加解密工具类
 *
 * @Author:chenssy
 * @date:2016�?5�?20�? 下午5:19:00
 *
 */
class DESUtils {
	/** 默认key */
//	protected final static String KEY = "ScAKC0XhadTHT3Al0QIDAQAB";
	public static final String ALGORITHM_DES = "DES";
	
	/**
	 * DES加密
	 * 
	 * @author : chenssy
	 * @date : 2016�?5�?20�? 下午5:51:37
	 *
	 * @param data
	 * 				待加密字符串
	 * @param key
	 * 				校验�?
	 * @return
	 */
    @SuppressWarnings("restriction")
	protected static String encrypt(String data,String key) {  
        String encryptedData = null;  
        try {  
            // DES算法要求有一个可信任的随机数�?  
            SecureRandom sr = new SecureRandom();  
            DESKeySpec deskey = new DESKeySpec(key.getBytes());  
            // 创建�?个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            SecretKey secretKey = keyFactory.generateSecret(deskey);  
            // 加密对象  
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);  
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);  
            // 加密，并把字节数组编码成字符�?  
            encryptedData =Base64.getEncoder().encodeToString((cipher.doFinal(Base64.getEncoder().encode(data.getBytes("GBK")))));  
            
        } catch (Exception e) {  
            throw new RuntimeException("加密错误，错误信息：", e);  
        }  
        return encryptedData;  
    }  
  
    /**
     * DES解密
     * 
     *
     * @param cryptData
     * 						待解密密�?
     * @param key
     * 						校验�?
     * @return
     */
    @SuppressWarnings("restriction")
	protected static String decrypt(String cryptData,String key) {  
        String decryptedData = null;  
        try {  
            // DES算法要求有一个可信任的随机数�?  
            SecureRandom sr = new SecureRandom();  
            DESKeySpec deskey = new DESKeySpec(key.getBytes());  
            // 创建�?个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            SecretKey secretKey = keyFactory.generateSecret(deskey);  
            // 解密对象  
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);  
            cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);  
            // 把字符串解码为字节数组，并解�?  
            decryptedData =new String(Base64.getDecoder().decode(cipher.doFinal(Base64.getDecoder().decode(cryptData))));  
        } catch (Exception e) {  
            throw new RuntimeException("解密错误，错误信息：", e);  
        }  
        return decryptedData;  
    }  
    
    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
            if (hexStr.length() < 1)
                    return null;
            byte[] result = new byte[hexStr.length()/2];
            for (int i = 0;i< hexStr.length()/2; i++) {
                    int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
                    int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
                    result[i] = (byte) (high * 16 + low);
            }
            return result;
    }
    public static final String bytesToHexString(byte[] bArray) {
    	  StringBuffer sb = new StringBuffer(bArray.length);
    	  String sTemp;
    	  for (int i = 0; i < bArray.length; i++) {
    	   sTemp = Integer.toHexString(0xFF & bArray[i]);
    	   if (sTemp.length() < 2)
    	    sb.append(0);
    	   sb.append(sTemp.toUpperCase());
    	  }
    	  return sb.toString();
    	 }
    
    public static String toHexString(byte[] b){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < b.length; ++i){
            buffer.append(toHexString(b[i]));
        }
        return buffer.toString();
    }
    
    public static String toHexString(byte b){
        String s = Integer.toHexString(b & 0xFF);
        if (s.length() == 1){
            return "0" + s;
        }else{
            return s;
        }
    }
    
    
    public static String byteArr2HexStr(byte[] arrB) throws Exception {   

        int iLen = arrB.length;   

        // 每个byte用2个字符才能表示，所以字符串的长度是数组长度的2倍   

        StringBuffer sb = new StringBuffer(iLen * 2);   

        for (int i = 0; i < iLen; i++) {   

            int intTmp = arrB[i];   

            // 把负数转换为正数   

            while (intTmp < 0) {   

                intTmp = intTmp + 256;   

            }   

            // 小于0F的数需要在前面补0   

            if (intTmp < 16) {   

                sb.append("0");   

            }   

            sb.append(Integer.toString(intTmp, 16));   

        }   

        return sb.toString();   

    }   
	
    /**
     * 十六进制字符串转换成字符串
     * @param hexString
     * @return String
     */
       public static String hexStr2Str(String hexStr) { 

           String str = "0123456789ABCDEF";  
           char[] hexs = hexStr.toCharArray();  
           byte[] bytes = new byte[hexStr.length() / 2];  
           int n;  
           for (int i = 0; i < bytes.length; i++) {  
               n = str.indexOf(hexs[2 * i]) * 16;  
               n += str.indexOf(hexs[2 * i + 1]);  
               bytes[i] = (byte) (n & 0xff);  
           }  
           return new String(bytes);  
       }
       
       /**
        * 十六进制字符串转换字符串
        * @param HexString
        * @return String
        */
    public static String toStringHex(String s) {
     byte[] baKeyword = new byte[s.length() / 2];
     for (int i = 0; i < baKeyword.length; i++) {
      try {
       baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
         i * 2, i * 2 + 2), 16));
      } catch (Exception e) {
       e.printStackTrace();
      }
     }
     try {
      s = new String(baKeyword, "utf-8");// UTF-16le:Not
     } catch (Exception e1) {
      e1.printStackTrace();
     }
     return s;
    }
	     
}
