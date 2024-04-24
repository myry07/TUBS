package chapter17;

public class methode02 {
    public static void main(String[] args) throws InterruptedException {
        T22 t2 = new T22();
        t2.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("main线程 " + i);

            if(i == 5) {
                System.out.println("子线程插队成功");
                t2.join();
            }
        }

    }
}

class T22 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程 " + i);
        }
    }
}
