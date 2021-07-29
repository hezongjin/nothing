package com.dadi.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

public class Demo {
    public static void main(String[] args) throws Exception {


        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "test-hdp1.novalocal");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        conf.set("zookeeper.znode.parent", "/hbase-unsecure");
//        conf.set("COLUMN_ENCODED_BYTES", "0");
        Connection hbaseConn = ConnectionFactory.createConnection(conf);


        Table person = hbaseConn.getTable(TableName.valueOf("TEST.PERSON"));
//        Result result = person.get(new Get(Bytes.toBytes("1")));

        /*Scan scan = new Scan();
        ResultScanner scanner = person.getScanner(scan);
        for (Result result : scanner) {
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {
                System.out.println("行键:" + Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println("列族:" + Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("列  :" + Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("值  :" + Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }
*/
        Put put = new Put(Bytes.toBytes("2"));
        put.addColumn(Bytes.toBytes("0"), Bytes.toBytes("\\x80\\x0B"), Bytes.toBytes("wangwu"));
        person.put(put);

    }
}
