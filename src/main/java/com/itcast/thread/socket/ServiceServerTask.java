package com.itcast.thread.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author : wangshengyu
 * @date : 2019/9/3
 */
public class ServiceServerTask  implements Runnable {
    Socket socket;
    InputStream in = null;
    OutputStream out = null;
    public ServiceServerTask(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            //从socket连接中获取到与client之间的网络通信输入输出流
            in = socket.getInputStream();
            out = socket.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            //从网络通信的输入流中获取客户端的数据
            //socketinputstream的读数据都是阻塞的
            String param = br.readLine();

            GetDataServiceImpl getDataService = new GetDataServiceImpl();
            String result = getDataService.getData(param);

            //将调用结果写到socket输出流中，发送给客户端
            PrintWriter pw = new PrintWriter(out);
            pw.println(result);
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
