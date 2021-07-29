package com.dadi.j;

import java.sql.*;

public class JDemo {
    public static void main(String[] args) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            String sql = "delete from test.test where id > ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 3);
            int i = ps.executeUpdate();
            System.out.println(i);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
                if (null != ps) {
                    ps.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
