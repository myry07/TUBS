package interface_;

public class Phone implements Usb{
    @Override
    public void start() {
        System.out.println("手机开机");
    }

    @Override
    public void stop() {
        System.out.println("手机关机");
    }
}
