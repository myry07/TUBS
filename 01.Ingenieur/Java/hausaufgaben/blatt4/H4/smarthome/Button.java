package H4.smarthome;

public class Button extends PowerDevice {

    public void poll(Device device){
        System.out.println("蓝牙操作");
        device.run();
        device.stop();
    }
}
