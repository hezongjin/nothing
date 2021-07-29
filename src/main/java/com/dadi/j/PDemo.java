package com.dadi.j;

import java.sql.*;

public class PDemo {
    private static String driver = "org.apache.phoenix.jdbc.PhoenixDriver";

    public static void main(String[] args) throws SQLException {
        PreparedStatement stat = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection("jdbc:phoenix:test-hdp1.novalocal:2181:/hbase-unsecure");
            stat = conn.prepareStatement("SELECT * FROM EDS.T_EDS_ENT_BASE_INFO LIMIT 10");
            resultSet = stat.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stat.close();
            resultSet.close();
        }


    }
}
