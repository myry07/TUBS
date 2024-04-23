package chapter21.socket;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author myry
 * @date 2024-31-28 14:31
 * 客户端 字符流
 */

@SuppressWarnings({"all"})
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket " + socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        //outputStream.write("hello, server".getBytes());

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello server 字符流");
        bufferedWriter.newLine();//插入换行符 表示写入内容结束
        bufferedWriter.flush();//刷新


        //获取输入流 并且读取
        InputStream inputStream = socket.getInputStream();
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf)) != -1) {
//            System.out.println(new String(buf, 0, readLen));
//        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出");

    }
}

