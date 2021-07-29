package com.dadi.j;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.FamilyFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.Arrays;

public class ABC {

    public static void main(String[] args) throws Exception {

        Configuration conf = HBaseConfiguration.create();

//        conf.set(HConstants.ZOOKEEPER_QUORUM, "test-hdp1.novalocal");
        conf.set(HConstants.ZOOKEEPER_QUORUM, "server1,server2,tool");
        conf.set(HConstants.ZOOKEEPER_CLIENT_PORT, "2181");
        conf.set(HConstants.ZOOKEEPER_ZNODE_PARENT, "/hbase-unsecure");

        Connection conn = ConnectionFactory.createConnection(conf);
        Table table = conn.getTable(TableName.valueOf("EDS.T_EDS_ENT_NET_POPULARIZATION"));

//        System.out.println(table.exists(new Get(Bytes.toBytes(" 0_201_00401a79a04d8bfc264b2145de0c38fc"))));

        ResultScanner scanner = table.getScanner(new Scan());


        for (Result result : scanner) {
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {

                System.out.println("行键:" + Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println("列族:" + Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("列:" + Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("值:" + Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }


    }
}
