package chapter17;

public class methode_ {
    public static void main(String[] args) throws InterruptedException {

        //方法测试
        TH t = new TH();
        t.setName("hsp");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();

        //主线程打印五个hi 然后中断子线程
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("主线程 " + Thread.currentThread().getName() + " hi");
        }
        t.interrupt();
    }
}

class TH extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + "线程: " + Thread.currentThread().getName());
            }
            try {
                System.out.println("线程: " + Thread.currentThread().getName() + " 休眠中");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被interrupt了");
            }
        }
    }
}