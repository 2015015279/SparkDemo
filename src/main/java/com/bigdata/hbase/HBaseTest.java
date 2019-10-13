package com.bigdata.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Table;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/12 18:29
 */
public class HBaseTest {
    static Configuration config = null;
    private Connection connection = null;
    private Table table = null;

    @Before
    public void init() throws Exception {
        config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "192.168.157.141,192.168.157.140,192.168.157.139");
        config.set("hbase.zookeeper.property.clientPort", "2181");
        connection = ConnectionFactory.createConnection();
        table = connection.getTable(TableName.valueOf("student"));
    }

    /**
     * 创建一个表
     *
     * @throws Exception
     */
    @Test
    public void createTable() throws Exception {
        // 创建表管理类
        HBaseAdmin admin = new HBaseAdmin(config);
        // 创建表描述类
        TableName tableName = TableName.valueOf("test3");
        HTableDescriptor desc = new HTableDescriptor(tableName);
        // 创建列族的描述类
        HColumnDescriptor family = new HColumnDescriptor("info");
        // 将列族添加到表中
        desc.addFamily(family);
        HColumnDescriptor family2 = new HColumnDescriptor("info2");
        // 将列族添加到表中
        desc.addFamily(family2);
        // 创建表
        admin.createTable(desc);
    }
}
