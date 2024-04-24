package chapter21.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author myry
 * @date 2024-30-28 13:30
 * 服务端 server
 */

@SuppressWarnings({"all"})//忽略警告
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("server 在9999端口监听 等待连接");

        //若无9999连接 程序阻塞 若连接 返回socket对象
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket " + socket.getClass());//看一下类型

        InputStream inputStream = socket.getInputStream();

        //IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }


        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端关闭");

    }
}
