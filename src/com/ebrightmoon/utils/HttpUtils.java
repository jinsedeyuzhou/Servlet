package com.ebrightmoon.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtils {

	  /**
     * 拼接参数
     *
     * @param hashmap
     * @return
     * @throws UnsupportedEncodingException
     */
    public static StringBuffer spellParams(Map<String, Object> hashmap) {
        List<String> array = new ArrayList();
        Object[] key = hashmap.keySet().toArray();
        Arrays.sort(key);
        for (int i = 0; i < key.length; i++) {
            if (isContainChinese(hashmap.get(key[i]).toString())) {
                String encode = null;
                try {
                    encode = URLEncoder.encode(hashmap.get(key[i]).toString(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                array.add(key[i] + "="+encode + "");
            } else {
                array.add(key[i] + "="+hashmap.get(key[i]) + "");
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.size(); i++) {
            if ((array.size() - 1) == i) {
                sb.append(array.get(i).toString());
            } else {
                sb.append(array.get(i).toString() + "&");
            }
        }
        return sb;
    }
    

	  /**
   * 拼接参数
   *
   * @param hashmap
   * @return
   * @throws UnsupportedEncodingException
   */
  public static StringBuffer spellParam(Map<String, String> hashmap) {
      List<String> array = new ArrayList();
      Object[] key = hashmap.keySet().toArray();
      Arrays.sort(key);
      for (int i = 0; i < key.length; i++) {
          if (isContainChinese(hashmap.get(key[i]))) {
              String encode = null;
              try {
                  encode = URLEncoder.encode(hashmap.get(key[i]), "UTF-8");
              } catch (UnsupportedEncodingException e) {
                  e.printStackTrace();
              }
              array.add(key[i] + "="+encode + "");
          } else {
              array.add(key[i] + "="+hashmap.get(key[i]) + "");
          }
      }
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.size(); i++) {
          if ((array.size() - 1) == i) {
              sb.append(array.get(i).toString());
          } else {
              sb.append(array.get(i).toString() + "&");
          }
      }
      return sb;
  }
  
    /**
     * 是否是中文
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[u4e00-u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
