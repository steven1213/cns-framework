package com.steven.cns.common.tool.utils;


import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author: steven
 * @date: 2023/7/17 00:14
 */
@Slf4j
public final class AppUtils {

    private AppUtils() {
    }

    private static final String SERVER_NAME = "cns_framework";

    // chars 包括a-z,0-9,A-Z
    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    /**
     * 生成AppId
     * 本算法利用62个可打印字符，通过随机生成32UUID,由于UUID都为十六进制，所以交UUID分成8组，每4个为一组，然后通过模62操作，结果作为索引取出字符
     * 这样重复率大大降低
     */
    public static String getAppId() {
        StringBuilder stringBuilder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int strInteger = Integer.parseInt(str, 16);
            stringBuilder.append(CHARS[strInteger % 0x3E]);
        }
        return stringBuilder.toString();
    }

    /**
     * 通过AppId和内置的关键词生成AppSecret
     */
    public static String getAppSecret(String appId) {
        try {
            String[] array = new String[]{appId, SERVER_NAME};
            StringBuilder sb = new StringBuilder();
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            StringBuilder hexString = new StringBuilder();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithmException", e);
            throw new RuntimeException(e);
        }
    }
}
