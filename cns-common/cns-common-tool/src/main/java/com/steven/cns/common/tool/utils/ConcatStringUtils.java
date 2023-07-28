package com.steven.cns.common.tool.utils;

import com.steven.cns.common.tool.constant.CnsConstant;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: steven
 * @date: 2023/7/17 00:35
 */
@Slf4j
public final class ConcatStringUtils {
    private ConcatStringUtils() {
    }

    public static String concatString(HttpServletRequest request) {
        Map<String, String> requestParamMap = new HashMap<>();
        request.getParameterMap().forEach((key, value) -> requestParamMap.put(key, value[0]));
        return getString(requestParamMap);
    }

    public static String concatString(Map<String, String> map) {
        Map<String, String> requestParamMap = new HashMap<>();
        requestParamMap.putAll(map);
        return getString(requestParamMap);
    }

    private static String getString(Map<String, String> requestParamMap) {
        Set<String> keySet = requestParamMap.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            // 需要过滤掉sign参数
            if (CnsConstant.SIGN.equals(k)) {
                continue;
            }
            if (requestParamMap.get(k).trim().length() > 0) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(k).append("=").append(requestParamMap.get(k).trim());
            }
        }
        return sb.toString();
    }
}
