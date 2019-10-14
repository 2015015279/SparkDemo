package com.bigdata.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/12 18:29
 */
public class HBaseTest {
    static Configuration config = null;
    private Connection connection = null;
    private Table table = null;
    private Admin admin = null;

    @Before
    public void init() throws Exception {
        config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "192.168.183.136,192.168.183.137,192.168.183.140");
        config.set("hbase.zookeeper.property.clientPort", "2181");
        connection = ConnectionFactory.createConnection();
        admin = connection.getAdmin();
    }

    /**
     * 结束之后 关闭对象
     */
    @After
    public void End_up() throws Exception {
        if (connection != null) connection.close();
    }

    /**
     * 创建一个表
     *
     * @throws Exception
     */
    /**
     * 创建表
     */
    @Test
    public void CreateTable() throws Exception {
        String tablename = "school";
        if (admin.tableExists(TableName.valueOf(tablename))) {
            System.out.println("表已经存在");
        } else {
            HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tablename));
            //添加列族columnFamily ，不必指定列
            hTableDescriptor.addFamily(new HColumnDescriptor("address"));
            hTableDescriptor.addFamily(new HColumnDescriptor("more"));
            hTableDescriptor.addFamily(new HColumnDescriptor("info"));
            admin.createTable(hTableDescriptor);
            System.out.println("表" + tablename + "创建成功");
        }
    }

    /**
     * 查询表
     **/
    @Test
    public void ShowTableData() throws Exception {
        HTableDescriptor[] listTables = admin.listTables();
        if (listTables.length > 0) {
            for (HTableDescriptor ta : listTables) {
                System.out.println(ta.getNameAsString());
                for (HColumnDescriptor column : ta.getColumnFamilies()) {
                    System.out.println("\t" + column.getNameAsString());
                }
            }
        }
    }

    /**
     * 添加多条数据
     * 添加单条数据 传入参数换成put 对象就可以了
     * table.put(Put put);
     */
    @Test
    public void PutTable() throws Exception {
        Table table = connection.getTable(TableName.valueOf("school"));
        //创建 put，并制定 put 的Rowkey
        Put put = new Put(Bytes.toBytes("zhangsan"));
        //byte [] family, byte [] qualifier, byte [] value
//        put.addColumn(Bytes.toBytes("student"), Bytes.toBytes("age"), Bytes.toBytes(18));
//        put.addColumn(Bytes.toBytes("student"), Bytes.toBytes("sex"), Bytes.toBytes("男"));
//        put.addColumn(Bytes.toBytes("student"), Bytes.toBytes("city"), Bytes.toBytes("beijing"));
//        put.addColumn(Bytes.toBytes("student"), Bytes.toBytes("address"), Bytes.toBytes("henan"));
        put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("hobby"), Bytes.toBytes("girl"));
        put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("good"), Bytes.toBytes("basketball"));

        Put put1 = new Put(Bytes.toBytes("lisi"));
        // family ,qualifier, value  顺序不可乱，列族，列，内容
        put1.addColumn(Bytes.toBytes("student"), Bytes.toBytes("age"), Bytes.toBytes(22));
        put1.addColumn(Bytes.toBytes("student"), Bytes.toBytes("sex"), Bytes.toBytes("女"));
        put1.addColumn(Bytes.toBytes("student"), Bytes.toBytes("city"), Bytes.toBytes("nanjing"));
        put1.addColumn(Bytes.toBytes("student"), Bytes.toBytes("address"), Bytes.toBytes("hebei"));
        put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("hobby"), Bytes.toBytes("boy"));
        put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("good"), Bytes.toBytes("ball"));

        List<Put> list = new ArrayList();
        list.add(put);
        list.add(put1);

        table.put(put1);
    }


    /**
     * 根据Rowkey进行查询
     */
    @Test
    public void ScanByRowkey() throws Exception {
        String rowKey = "zhangsan";
        table = connection.getTable(TableName.valueOf("school"));
        Get get = new Get(rowKey.getBytes());

        Result result = table.get(get);
        System.out.println("Rowkey\t列族\t列名\t内容");
        for (Cell cell : result.rawCells()) {
            System.out.println(
                    Bytes.toString(CellUtil.cloneRow(cell)) + "\t" +  //Rowkey
                            Bytes.toString(CellUtil.cloneFamily(cell)) + "\t" + //CF
                            Bytes.toString(CellUtil.cloneQualifier(cell)) + "\t" +//qualifier
                            Bytes.toString(CellUtil.cloneValue(cell)) //value
            );
        }
    }

    /**
     * 根据Rowkey 和列簇和列进行查询内容
     */
    @Test
    public void ScanByRowkey1() throws Exception {
        String rowKey = "zhangsan";
        table = connection.getTable(TableName.valueOf("school"));
        Get get = new Get(rowKey.getBytes());
        get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("good"));

        Result result = table.get(get);
        System.out.println("列族rowKey = \"zhangsan\"列族为info,列为age的值是：");
        String age = Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("age")));
        System.out.println(age);
    }

    /**
     * Scan 全表  在实际生产当中是不这样干的，内容上百万千万的，很浪费时间的
     * S
     * 一般添加过滤器Filter
     */
    @Test
    public void ScanTable() throws Exception {
        table = connection.getTable(TableName.valueOf("school"));
        Scan scan = new Scan();
        ResultScanner rs = table.getScanner(scan);
        for (Result result : rs) {
            PrintResult(result);
        }
    }


    /**
     * 定义私有方法 用于打印表的信息
     */
    private void PrintResult(Result result) {
        for (Cell cell :result.rawCells()) {
            System.out.println(
                    Bytes.toString(CellUtil.cloneRow(cell)) + "\t" +//Rowkey
                            Bytes.toString(CellUtil.cloneFamily(cell)) + "\t" +//CF
                            Bytes.toString(CellUtil.cloneQualifier(cell)) + "\t" +//qualifier
                            Bytes.toString(CellUtil.cloneValue(cell)) //value
            );
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * 条件过滤  Filter
     * 查询后最名 为  wu的
     * Hbase 中数据是按照字典顺序进行排列的
     * 不会因为插入的时间不同而不同
     */
    @Test
    public void Filter01() throws Exception {
        table = connection.getTable(TableName.valueOf("school"));
        String reg = "^*wu";
        org.apache.hadoop.hbase.filter.Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator(reg));
        Scan scan = new Scan();
        scan.setFilter(filter);
        ResultScanner results = table.getScanner(scan);
        for (Result result :results) {
            PrintResult(result);
        }
    }

    /**
     * 多条件过滤  FilterList
     * <p>
     * MUST_PASS_ALL 全都满足条件
     * <p>
     * MUST_PASS_ONE  满足一个就可以
     */
    @Test
    public void FilterList() throws Exception {
        table = connection.getTable(TableName.valueOf("school"));
        String reg = "^*wu";
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);
        org.apache.hadoop.hbase.filter.Filter filter = new PrefixFilter(Bytes.toBytes("li"));
        org.apache.hadoop.hbase.filter.Filter filter2 = new PrefixFilter(Bytes.toBytes("zh"));
        filterList.addFilter(filter);
        filterList.addFilter(filter2);
        Scan scan = new Scan();
        scan.setFilter(filterList);
        ResultScanner results = table.getScanner(scan);
        for (Result result : results) {
            PrintResult(result);
        }
    }

    /**
     * 删除数据
     */
    @Test
    public void DeleteData() throws Exception {
        table = connection.getTable(TableName.valueOf("school"));
        Delete delete = new Delete(Bytes.toBytes("lisi"));
        table.delete(delete);
    }

    @Test
    public void DeleteDataMutilDelete() throws Exception {
        table = connection.getTable(TableName.valueOf("school"));
        Delete delete = new Delete(Bytes.toBytes("zhangsan"));
        //删除当前版本的内容
        // delete.addColumn(Bytes.toBytes("info"),Bytes.toBytes("good"));
        //删除所有版本
        //delete.addColumns(Bytes.toBytes("info"),Bytes.toBytes("good"));

        /**
         * addColumn addColumns 是不一样的 ，记住了，
         *
         * addColumn 是删除单元格当前最近版本的 内容，
         *
         * addColumns 是删除单元格所有版本的内容
         * */
        //删除列族
        delete.addFamily(Bytes.toBytes("info"));
        table.delete(delete);
    }

    /**
     * 删除表
     */
    @Test
    public void DropTable() throws Exception {
        table = connection.getTable(TableName.valueOf("test3"));
        if (admin.tableExists(TableName.valueOf("test3"))) {
            admin.disableTable(TableName.valueOf("test3"));
            admin.deleteTable(TableName.valueOf("test3"));
            System.out.println("删除成功");
        } else {
            System.out.println("表不存在");
        }
    }
}
