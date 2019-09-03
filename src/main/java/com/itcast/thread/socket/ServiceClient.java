package com.itcast.thread.socket;

import kafka.network.SocketServer;

import java.io.*;
import java.net.Socket;

/**
 * @author : wangshengyu
 * @date : 2019/9/3
 */
public class ServiceClient {
    public static void main(String[] args) {
        try {
            // 向服务器发出请求建立连接
            Socket socket = new Socket("localhost", 8899);
            // 从socket中获取输入输出流
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            PrintWriter pw = new PrintWriter(out);
            pw.println("hello");
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String result = br.readLine();
            System.out.println(result);

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
