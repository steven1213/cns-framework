package com.steven.cns.common.tool.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ConcatStringUtilsTest {

    @Test
    void concatString() {

    }

    @Test
    void testConcatString() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "steven.cao");
        map.put("password", "taome");
        map.put("sign", "tttt");
        String result = ConcatStringUtils.concatString(map);
        assert result.equals("password=taome&username=steven.cao");
    }
}