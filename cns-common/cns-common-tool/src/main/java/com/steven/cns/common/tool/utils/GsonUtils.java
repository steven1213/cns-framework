package com.steven.cns.common.tool.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Gson 工具类
 *
 * @author: steven
 * @date: 2023/7/15 11:06
 */
public final class GsonUtils {

    public static String toJson(Object obj) {
        return new Gson().toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }

    public static <T> T fromJson(String json, Class<T> clazz, T defaultValue) {
        try {
            return new Gson().fromJson(json, clazz);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> T fromJson(String json, Type type) {
        return new Gson().fromJson(json, type);
    }

}
