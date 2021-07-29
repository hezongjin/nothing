package com.dadi.trash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MasterJava {

    //这是我的masterjava

    //添加了一个dev的分支


    //又添加了一个dev


    //abc & this  is in dev & 123

    //abc and this is in dev and abc

    public static void main(String[] args) {


        HashMap<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        String str = show();
        int i = 30;
        i += 50;
        System.out.println(str);

    }

    public static String show() {
        System.out.println("你好吗");
        return "hello myfriend";
    }

}
