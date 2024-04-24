package chapter17.Runnableuse;

@SuppressWarnings({"all"})
public class Runnable_ {
    public static void main(String[] args) {
        Dog dog = new Dog();

        Thread thread = new Thread(dog);
        thread.start();


    }
}

class Dog implements Runnable {
    int count = 0;

    public void run() {
        while(true) {
            System.out.println(++count + "秒 小狗 汪汪叫" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
