package com.bigdata.redis.list;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/11/4 16:31
 */
public class SingleArticle {
    public static void main(String[] args) throws Exception {
        // 第一步：访问页面
        String url = "http://www.huxiu.com/article/102062/1.html";
        Document document = Jsoup.connect(url).get();

        // 第二步：解析页面
        Elements titleElements = document.getElementsByTag("title");
        String title = titleElements.get(0).text();

        Elements elements = document.select("div #article_content");
        String content = elements.text();

        // 第三步：打印
        System.out.println("title:" + title);
        System.out.println("content:" + content);
    }
}
