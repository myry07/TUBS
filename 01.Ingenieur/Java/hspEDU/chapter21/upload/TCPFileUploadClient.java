package chapter21.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author myry
 * @date 2024-18-28 15:18
 * 客户端 发送文件
 */

@SuppressWarnings({"all"})
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //1.创建客户端连接 得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //2.创建读取磁盘文件的输入流
        String filePath = "/Users/myry/Desktop/img/hc.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        //bytes就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流 将bytes数据发送给server
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将字节数组 上传到通道中

        bis.close();
        socket.shutdownOutput();

        //接受从服务端 回复的消息 字节
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭相关流
        inputStream.close();
        bos.close();
        socket.close();


    }

}
