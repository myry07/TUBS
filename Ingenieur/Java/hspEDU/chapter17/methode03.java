package chapter17;

public class methode03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();

        //希望主线程结束 子线程可以自动结束
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("宝强在辛苦工作");
            Thread.sleep(10000);
        }

        System.out.println("线程退出");
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for( ; ;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("马融在和宋喆快乐聊天 哈哈哈");
        }
    }
}