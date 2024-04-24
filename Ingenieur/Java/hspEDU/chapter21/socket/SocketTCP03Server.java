package chapter21.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author myry
 * @date 2024-31-28 14:31
 * 服务端 字符流
 */

@SuppressWarnings({"all"})//忽略警告
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("server 在9999端口监听 等待连接");

        //若无9999连接 程序阻塞 若连接 返回socket对象
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket " + socket.getClass());//看一下类型

        InputStream inputStream = socket.getInputStream();

        //IO读取
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf)) != -1) {
//            System.out.println(new String(buf, 0, readLen));
//        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
        String s = bufferedReader.readLine();
        System.out.println(s);


        //获取socket相关的输出流
        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello client".getBytes());
        //类似于对讲机 讲完要发一个完毕 不然对方不知道你有没有说完
//        socket.shutdownOutput();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端关闭");

    }
}
