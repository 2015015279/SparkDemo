package com.bigdata.hdfs;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;

/**
 * @author : wangshengyu
 * @date : 2019/9/11
 */
public class HdfsStreamAccess {
    FileSystem fs = null;
    Configuration conf = null;
    @Before
    public void init() throws Exception{

        conf = new Configuration();
//		conf.set("fs.defaultFS", "hdfs://mini1:9000");
        conf.set("dfs.replication", "5");

        //拿到一个文件系统操作的客户端实例对象
        fs = FileSystem.get(conf);
        //可以直接传入 uri和用户身份
        fs = FileSystem.get(new URI("hdfs://mini1:9000"),conf,"hadoop");
    }

    /**
     * 通过流的方式上传文件到hdfs
     * @throws Exception
     */
    @Test
    public void testUpload() throws Exception {

        FSDataOutputStream outputStream = fs.create(new Path("/angelababy.love"), true);
        FileInputStream inputStream = new FileInputStream("c:/angelababy.love");

        IOUtils.copy(inputStream, outputStream);

    }


    /**
     * 通过流的方式获取hdfs上数据
     * @throws Exception
     */
    @Test
    public void testDownLoad() throws Exception {

        FSDataInputStream inputStream = fs.open(new Path("/angelababy.love"));

        FileOutputStream outputStream = new FileOutputStream("d:/angelababy.love");

        IOUtils.copy(inputStream, outputStream);

    }


    @Test
    public void testRandomAccess() throws Exception{

        FSDataInputStream inputStream = fs.open(new Path("/angelababy.love"));

        inputStream.seek(12);

        FileOutputStream outputStream = new FileOutputStream("d:/angelababy.love.part2");

        IOUtils.copy(inputStream, outputStream);


    }
}
