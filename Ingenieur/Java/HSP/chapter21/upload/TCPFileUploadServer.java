package chapter21.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author myry
 * @date 2024-18-28 15:18
 * 服务端 接受图片
 */

@SuppressWarnings({"all"})
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1.服务端代码 在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端 在8888监听 等待连接");

        //2.等待连接
        Socket socket = serverSocket.accept();

        //3.读取客户端发送的数据
        //  通过socket得到输入流
        BufferedInputStream bis = new BufferedInputStream((socket.getInputStream()));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //4.将得到的bytes数组 写入到指定的路径 就可以得到文件
        String destFilePath = "/Users/myry/Documents/Pro.java/src/hccopy.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        //5.向客户端回复收到 这边使用字符
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("Server 收到信息");
        writer.flush();
        socket.shutdownOutput();//这边没有用newLine 那么Client可以用字节

        //关闭流
        writer.close();
        serverSocket.close();
        socket.close();
        bis.close();
    }
}
