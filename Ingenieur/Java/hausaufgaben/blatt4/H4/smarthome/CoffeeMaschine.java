package H4.smarthome;

public class CoffeeMaschine implements Device{
    public void run() {
        System.out.println("咖啡机 打开");
    }

    public void stop() {
        System.out.println("咖啡机 关闭");
    }
}
