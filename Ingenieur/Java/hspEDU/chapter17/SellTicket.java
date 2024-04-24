package chapter17;

/**
 * @author myry
 * @date 2024-31-02 21:31
 * <p>
 * 使用多线程 模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {

        SellTicket01 s0 = new SellTicket01();
        SellTicket01 s1 = new SellTicket01();
        SellTicket01 s2 = new SellTicket01();

//        s0.start();
//        s1.start();
//        s2.start();

        SellTicket02 s3 = new SellTicket02();
        Thread t0 = new Thread(s3);
        Thread t1 = new Thread(s3);
        Thread t2 = new Thread(s3);

        t0.start();
        t1.start();
        t2.start();

        /*
           窗口 Thread-0售卖了一张票 剩余 1 张票
           窗口 Thread-1售卖了一张票 剩余 0 张票
           窗口 Thread-2售卖了一张票 剩余 -1 张票
           售票结束
           售票结束
           窗口 Thread-0售卖了一张票 剩余 -2 张票
           售票结束
         */
    }
}

class SellTicket01 extends Thread {
    private static int ticktNum = 50;//静态让多个线程共享

    @Override
    public void run() {

        while (true) {

            if (ticktNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() +
                    "售卖了一张票 剩余 " + --ticktNum + " 张票");
        }
    }
}

class SellTicket02 implements Runnable {
    private static int ticktNum = 50;//静态让多个线程共享

    @Override
    public void run() {

        while (true) {

            if (ticktNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() +
                    "售卖了一张票 剩余 " + --ticktNum + " 张票");
        }
    }
}

