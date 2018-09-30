package com.ebrightmoon.utils;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class FastJsonUtils {

	  /**
     * ������������JSON����ת����ָ����java����
     * @param jsonData JSON����
     * @param clazz ָ����java����
     * @return ָ����java����
     */
    public static <T> T getJsonToBean(String jsonData, Class<T> clazz) {
        return JSON.parseObject(jsonData, clazz);
    }

    /**
     * ������������java����ת����JSON����
     * @param object java����
     * @return JSON����
     */
    public static String getBeanToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * ������������JSON����ת����ָ����java�����б�
     * @param jsonData JSON����
     * @param clazz ָ����java����
     * @return List<T>
     */
    public static <T> List<T> getJsonToList(String jsonData, Class<T> clazz) {
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * ������������JSON����ת���ɽ�Ϊ���ӵ�List<Map<String, Object>>
     * @param jsonData JSON����
     * @return List<Map<String, Object>>
     */
    public static List<Map<String, Object>> getJsonToListMap(String jsonData) {
        return JSON.parseObject(jsonData, new TypeReference<List<Map<String, Object>>>() {
        });
    }

}
