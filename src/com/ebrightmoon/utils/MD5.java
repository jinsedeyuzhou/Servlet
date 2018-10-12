package com.ebrightmoon.utils;



import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {

    /**
     * 鑾峰彇瀛楃涓茬殑 MD5
     */
    public static String encode(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            byte messageDigest[] = md5.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", b));
            }
            return hexString.toString().toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 鑾峰彇鏂囦欢鐨� MD5
     */
    public static String encode(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream inputStream = new FileInputStream(file);
            DigestInputStream digestInputStream = new DigestInputStream(inputStream, messageDigest);
            //蹇呴』鎶婃枃浠惰鍙栧畬姣曟墠鑳芥嬁鍒癿d5
            byte[] buffer = new byte[4096];
            while (digestInputStream.read(buffer) > -1) {
            }
            MessageDigest digest = digestInputStream.getMessageDigest();
            digestInputStream.close();
            byte[] md5 = digest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : md5) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String encode(String str, String method) {

        MessageDigest md = null;
        String dstr = null;
        try {
            md = MessageDigest.getInstance(method);
            md.update(str.getBytes());
            dstr = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dstr;
    }

    public static String encodeMD5String(String str){
        return encode(str, "MD5");
    }

    public static String Md5(String str) {
        if (str != null && !str.equals("")) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
                byte[] md5Byte = md5.digest(str.getBytes("UTF8"));
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < md5Byte.length; i++) {
                    sb.append(HEX[(int) (md5Byte[i] & 0xff) / 16]);
                    sb.append(HEX[(int) (md5Byte[i] & 0xff) % 16]);
                }
                str = sb.toString();
            } catch (NoSuchAlgorithmException e) {
            } catch (Exception e) {
            }
        }
        return str;
    }



    /**
     *
     * @param plainText
     *            鏄庢枃
     * @return 32浣嶅瘑鏂�
     */
    public static String encryption(String plainText) {
        String re_md5 = new String();
        try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(plainText.getBytes());
//			byte b[] = md.digest();
//
//			int i;
//
//			StringBuffer buf = new StringBuffer("");
//			for (int offset = 0; offset < b.length; offset++) {
//				i = b[offset];
//				if (i < 0)
//					i += 256;
//				if (i < 16)
//					buf.append("0");
//				buf.append(Integer.toHexString(i));
//			}
//
//			re_md5 = buf.toString();

            // MessageDigest涓撻棬鐢ㄤ簬鍔犲瘑鐨勭被

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] result = messageDigest.digest(plainText.getBytes()); // 寰楀埌鍔犲瘑鍚庣殑瀛楃缁勬暟

            StringBuffer sb = new StringBuffer();

            for (byte b : result) {
                int num = b & 0xff; // 杩欓噷鐨勬槸涓轰簡灏嗗師鏈槸byte鍨嬬殑鏁板悜涓婃彁鍗囦负int鍨嬶紝浠庤�屼娇寰楀師鏈殑璐熸暟杞负浜嗘鏁�
                String hex = Integer.toHexString(num); //杩欓噷灏唅nt鍨嬬殑鏁扮洿鎺ヨ浆鎹㈡垚16杩涘埗琛ㄧず
                //16杩涘埗鍙兘鏄负1鐨勯暱搴︼紝杩欑鎯呭喌涓嬶紝闇�瑕佸湪鍓嶉潰琛�0锛�
                if (hex.length() == 1) {
                    sb.append(0);
                }
                sb.append(hex);
            }

            return sb.toString();



        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

    public static String encryption(String [] tmpplainText){


        StringBuffer plainText=new StringBuffer();

        for(int i = 0;i<tmpplainText.length;i++){
            plainText.append(tmpplainText[i]);
        }


        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((plainText.toString().substring(0,plainText.length()-1)).getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        return re_md5;
    }

}
