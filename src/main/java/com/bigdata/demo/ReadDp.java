package com.bigdata.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/17 10:13
 */
public class ReadDp {
    public List<Delicious> readFile() throws Exception {
        File file = new File("D:\\JD\\JD_work\\点评热门餐厅\\点评热门餐厅.txt");
        List<Delicious> list = new ArrayList<>();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        while((line = br.readLine()) != null){
            String[] split = line.trim().split(",");
            try {
                if(split.length == 9){
                    list.add(new Delicious(split[0], split[1], split[2], split[3], Double.valueOf(split[4]),
                            Double.valueOf(split[5]), Double.valueOf(split[6]), Integer.valueOf(split[7]), split[8]));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        reader.close();
        br.close();
        return list;
    }

    public void sort(List<Delicious> delicious){
        List<Delicious> list = new ArrayList<>();
        delicious.forEach(s->{
            String city = s.getCity();
            String item = s.getItem();
            String shopName = s.getShopName();
            Double score1 = s.getScore1();
            Double score2 = s.getScore2();
            Double score3 = s.getScore3();
        });
        delicious.stream().filter(s->s.getCity().contains("邯郸"))
                .filter(s->s.getScore1()>=9)
                .map(s->s.getCity() + "," + s.getShopName())
                .forEach(System.out::println);
    }


    public static void main(String[] args) throws Exception {
        ReadDp read = new ReadDp();
//        for(Object info : read.readFile()){
//            System.out.println(info);
//        }
        read.sort(read.readFile());
    }
}
