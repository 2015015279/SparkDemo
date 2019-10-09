package com.bigdata.demo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/8 10:57
 * @ Version 1.0
 */
public class Write {
    /**
     * 写入文件
     * @return
     * @throws IOException
     */
    public static File writeBuffer() throws IOException {
        File file = new File("C:\\Users\\wangshengyu1\\Desktop\\test.txt");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        int i = 100;
        while (i > 0) {
            Salary salary = new Salary().build();
            writer.write(salary.toString() + "\r\n");
            i--;
        }
        writer.close();
        fos.close();
        return file;
    }


    /**
     * NIO进行写入
     * @throws IOException
     */
    private static void writeNIO() throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\wangshengyu1\\Desktop\\test.txt", true);
        FileChannel channel = fos.getChannel();
        int i = 3;
        StringBuffer content = new StringBuffer();
        while (i > 0) {
            Salary salary = new Salary().build();
            content.append(salary.toString()).append("\r\n");
            i--;
        }
        ByteBuffer buf = ByteBuffer.wrap(content.toString().getBytes());
        buf.put(content.toString().getBytes());
        buf.flip();
        channel.write(buf);
        channel.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {
        Write write = new Write();
        write.writeBuffer();
    }
}
