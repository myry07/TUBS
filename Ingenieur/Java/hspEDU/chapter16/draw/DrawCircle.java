package chapter16.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author myry
 * @date 2024-27-27 14:27
 * 演示 在面板上画圆形
 */

/**
 * 常用方法
 * 1.画直线 drawLine(int x1,int y1,int x2,int y2)
 * 2.画矩形边框 drawRect(int x, int y , int width, int height)
 * 3.画椭圆边框 drawOval(int x, int y, int width, int height)
 * 4.填充矩形 fillRect(int x, int y, int width, int height)
 * 5.填充圆形 fillOval(int x, int y, int width, int height)
 * 6.画图片 drawImage (Image img, int x, int y,...)
 * 7.画字符串 drawString(String str, int x, int y)
 * 8.设置画笔的字体 setFont(Font font)
 * 9. 设置画笔的顔色 setColor(Color c)
 */

public class DrawCircle extends JFrame {
    //要画图 需要继承JFrame Frame框架(前端) --> 画图框架
    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        DrawCircle dc = new DrawCircle();
    }

    //初始化面板
    public DrawCircle() {//构造器
        mp = new MyPanel();
        this.add(mp);//把画板放入画框中
        this.setSize(400, 300);//设置窗口大小
        this.setVisible(true);//使其可视化
    }
}

//1.定义一个MyPanel 继承JPanel
class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法 完成初始化
        //画圆形
        g.drawOval(10, 10, 100, 100);
        //x坐标 y坐标 宽 高

        //设置画笔颜色
        g.setColor(Color.BLUE);
        //填充
        g.fillOval(10, 10, 100, 100);

        //画字符串
        g.setColor(Color.BLACK);
        //设置字体
        g.setFont(new Font("宋体", Font.BOLD, 30));
        g.drawString("hello world!", 120, 120);

    }


}
