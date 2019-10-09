package com.bigdata.demo;

import java.util.List;
import java.util.Map;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/9 19:44
 */
public class Actor {
    private String name;
    private List<Map> fans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map> getFans() {
        return fans;
    }

    public void setFans(List<Map> fans) {
        this.fans = fans;
    }
}
