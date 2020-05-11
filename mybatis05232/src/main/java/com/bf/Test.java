package com.bf;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-21 10:43
 **/
public class Test {
    public static void main(String[] args) {

    }

    public void test(Integer key) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "a");
        map.putIfAbsent(key, "123");

        map.computeIfAbsent(key, x -> {
            if (1 == 1) {
                return "123";
            } else {
                return "321";
            }
        });

    }
}
