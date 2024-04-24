package chapter17.exit_;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException{
        TT t1 = new TT();
        t1.start();

        System.out.println("main");
        Thread.sleep(10000);
        t1.setLoop(false);
    }
}
class TT extends Thread {
    private boolean loop = true;
    private int num = 0;
    @Override
    public void run() {
        while (loop) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(num++);
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
