package interface_;

public class Computer {
    public void work(Usb usb) {
        usb.start();
        usb.stop();
    }
}
