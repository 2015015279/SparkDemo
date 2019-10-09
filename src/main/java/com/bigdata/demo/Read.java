package com.bigdata.demo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/8 11:13
 * @ Version 1.0
 */
public class Read {
    /**
     * Java IO读取文件的方式
     * @return
     * @throws Exception
     */
    public static List<Salary> readFileIO() throws Exception {
        File file = new File("C:\\Users\\wangshengyu1\\Desktop\\test.txt");
        List<Salary> list = new ArrayList<>();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        int i = 1;
        while((line = br.readLine()) != null){
            String[] split = line.trim().split(" ");
            list.add(new Salary(split[0], Integer.valueOf(split[1]), Integer.valueOf(split[2])));
            i++;
        }
        reader.close();
        br.close();
        return list;
    }


    /**
     * JDK8 NIO读取文件
     * @return
     * @throws Exception
     */
    public static List<Salary> readFileNIO() throws Exception {
        List<Salary> list = new ArrayList<>();
        Files.lines(Paths.get("C:\\Users\\wangshengyu1\\Desktop\\test.txt")).forEach(line -> {
            String[] split = line.trim().split(" ");// .trim()可以去掉首尾多余的空格
            list.add(new Salary(split[0], Integer.valueOf(split[1]), Integer.valueOf(split[2]))); // 添加一个Salary实体
        });
        return list;
    }

    /**
     * 排序并获取前十数据
     * @param salaries
     */
    public static void sort(List<Salary> salaries) {
        Map<String, GroupSalary> result = new HashMap<>();
        salaries.forEach(salary -> {
            String shortName = salary.getName().substring(0, 2);
            GroupSalary groupSalary = null;
            List<Salary> salaryList = null;
            if (result.containsKey(shortName)) {
                groupSalary = result.get(shortName);
                salaryList = groupSalary.getSalaries();
            } else {
                groupSalary = new GroupSalary();
                salaryList = new ArrayList<>();
                groupSalary.setSalaries(salaryList);
            }
            salaryList.add(salary);
            groupSalary.setShortName(shortName);
            groupSalary.setTotal(groupSalary.getTotal() + salary.getBaseSalary() * 13 + salary.getBonus());
            result.put(shortName, groupSalary);
        });

        List<GroupSalary> r = result.entrySet().stream()
                .sorted((Map.Entry<String, GroupSalary> o1, Map.Entry<String, GroupSalary> o2) -> o2.getValue().getTotal() - o1.getValue().getTotal())
                .map(entry -> entry.getValue()).collect(Collectors.toList()).subList(0,10);

        r.forEach(groupSalary -> {
            System.out.println(groupSalary.getShortName() + " " + groupSalary.getTotal() + " " + groupSalary.getSalaries().size());
        });
    }


    public static void main(String[] args) throws Exception {
        Read read = new Read();
        read.sort(read.readFileIO());
    }

}
