package chapter17.threaduse;

/**
 * @author myry
 * @date 2024-00-02 15:00
 *
 * 通过演示 继承Thread类 创建线程
 */

@SuppressWarnings({"all"})
public class Thread01 {
    public static void main(String[] args) throws Exception{
        //创建Cat对象 当坐线程

        Cat cat = new Cat();
        cat.start();//启动线程

        System.out.println("main线程: " + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }


    }
}

//1. 当一个类继承了Thread 就是一个线程
//2. 重写run方法 写自己的逻辑
//3. Thread实现了runnable接口 才有的run方法
/*
 * @Override
    public void run() {
        Runnable task = holder.task;
        if (task != null) {
            Object bindings = scopedValueBindings();
            runWith(bindings, task);
        }
    }
 */


class Cat extends Thread {

    int times;
    @Override
    public void run() {
        while (true) {
            System.out.println(++times + "秒 喵喵 我是小猫咪 线程名字: " + Thread.currentThread().getName());
            //休眠一秒
            try {
                Thread.sleep(1000);//毫秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //线程也退出了
            if(times == 80) {
                break;
            }
        }
        System.out.println("线程结束");
    }
}
