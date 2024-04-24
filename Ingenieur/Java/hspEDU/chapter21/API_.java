package chapter21;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author myry
 * @date 2024-17-28 01:17
 * 演示 InetAddress 类的使用
 */

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本季的InetAddress对象
        //该方法要抛出异常
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //wangjiaqideAir/192.168.2.97

        //根据主机名 获取ip
        InetAddress my = InetAddress.getByName("wangjiaqideAir");
        System.out.println(my);
        //wangjiaqideAir/192.168.2.97

        //根据域名返回ip 比如baidu的
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
        //www.baidu.com/103.235.46.40

        //通过对象 获取地址
        String ad = byName.getHostAddress();
        System.out.println(ad);

        //通过对象获取主机名/域名
        String name = byName.getHostName();
        System.out.println(name);

    }
}
