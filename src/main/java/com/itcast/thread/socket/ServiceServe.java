package com.itcast.thread.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : wangshengyu
 * @date : 2019/9/3
 */
public class ServiceServe {
    public static void main(String[] args) throws IOException {

        // 创建一个serversocket，绑定到本机的8899端口上
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress("localhost",8899));

        // 接受客户端的连接请求;accept是一个阻塞方法，会一直等待，到有客户端请求连接才返回
        while (true){
            Socket socket = server.accept();
            new Thread(new ServiceServerTask(socket)).start();
        }
    }

}
