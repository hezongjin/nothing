package com.demo;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        //region Description
       /* HttpClient client = new HttpClient();

        HttpClientParams httpClientParams = new HttpClientParams();
        httpClientParams.setUriCharset("UTF-8");
        client.setParams(httpClientParams);

        int method = client.executeMethod(new PostMethod());*/
        //endregion
        executeSql2();

    }

    private static void executeSql() throws SQLException {
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("", "", "");
            conn.setAutoCommit(false);
            ptst = conn.prepareStatement("");
            resultSet = ptst.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<HashMap<String, String>> list = new ArrayList<>();
            while (resultSet.next()) {
                HashMap<String, String> map = new HashMap<>();
                for (int i = 0; i < columnCount; i++) {
                    String str = resultSet.getString(metaData.getColumnName(i));
                    map.put(metaData.getColumnName(i), str);
                }
                list.add(map);
            }
            conn.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            if (null != ptst) {
                ptst.close();
            }
            if (null != conn) {
                conn.close();
            }
            if (null != resultSet) {
                resultSet.close();
            }
        }
    }

    public static void executeSql2() {
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);
            ptst = conn.prepareStatement("insert into test.person(name,age) values (?,?)");
            for (int i = 0; i < 100; i++) {
                ptst.setObject(1, i + "");
                ptst.setObject(2, i);
                ptst.addBatch();
            }
            int[] ints = ptst.executeBatch();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConnecton(conn, ptst, resultSet);
        }
    }

    public static void closeConnecton(Connection conn, PreparedStatement ptst, ResultSet resultSet) {
        try {
            if (null != conn) {
                conn.close();
            }
            if (null != ptst) {
                ptst.close();
            }
            if (null != resultSet) {
                resultSet.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int[] getNextGreaterNum(int[] data) {
        int[] res = new int[data.length];
        Stack<String> s = new Stack<>();

        for (int i = data.length - 1; i >= 0; i--) {
            while (!s.empty() && tem(s.peek(), data[i])) {
                s.pop();
            }

            res[i] = s.empty() ? 0 : Integer.valueOf(s.peek().split("_")[1]) - i;
            s.push(data[i] + "_" + i);
        }

        return res;
    }

    public static boolean tem(String lastTem, int thisTem) {
        boolean flag = true;
        flag = thisTem >= Integer.valueOf(lastTem.split("_")[0]);
        return flag;
    }

    public static int[] getNextGreaterNum2(int[] data) {
        int[] res = new int[data.length];
        Stack<Integer> s = new Stack<>();

        for (int i = data.length - 1; i >= 0; i--) {
            while (!s.empty() && data[s.peek()] <= data[i]) {
                s.pop();
            }

            res[i] = s.empty() ? 0 : s.peek() - i;
            s.push(i);
        }

        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.empty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            res[i] = s.empty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return res;
    }


}





















