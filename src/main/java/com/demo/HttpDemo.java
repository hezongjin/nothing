package com.demo;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpDemo {
    public static void main(String[] args) throws Exception {
        URL url = new URL("www.baidu.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        conn.setConnectTimeout(5000);
        //设置HTTP头
        conn.setRequestProperty("Accept", "*/*");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 11; Windows NT 5.1)");
        conn.connect();

        if (conn.getResponseCode() != 200) {
            System.out.println("访问失败");
        }
    }
}
