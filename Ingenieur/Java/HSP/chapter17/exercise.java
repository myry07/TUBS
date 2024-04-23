package chapter17;

public class exercise {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);

        th1.start();
        th2.start();

        System.out.println("main " + Thread.currentThread().getName());
    }
}

class T1 implements Runnable {

    int count = 0;

    public void run() {

        while (true) {
            System.out.println("hello world " + Thread.currentThread().getName());
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (count == 10) {
                break;
            }
        }
    }
}

class T2 implements Runnable {

    int count = 0;

    public void run() {

        while (true) {
            System.out.println("hi " + Thread.currentThread().getName());
            count++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (count == 10) {
                break;
            }
        }
    }
}


