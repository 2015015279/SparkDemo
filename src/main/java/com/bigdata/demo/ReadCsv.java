package com.bigdata.demo;

import org.datanucleus.store.rdbms.query.AbstractRDBMSQueryResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/9 16:45
 */
public class ReadCsv {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\wangshengyu1\\Desktop\\result\\qiye1.txt");
        StringBuffer sb = new StringBuffer();
        List list = new ArrayList();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        while((line = br.readLine()) != null){
            String[] split = line.split("\\|");
            list.add(split[0]);
        }
        for(Object a: list){
            System.out.println(a);
        }
        reader.close();
        br.close();
    }
}
