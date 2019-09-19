package com.bigdata.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/9/19 16:07
 * @ Version 1.0
 */
public class Log4jTest {
    private static Logger logger = LoggerFactory.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
