package H4.smarthome;

public class Switch extends PowerDevice {

    public void poll(Device device){
        System.out.println("开关操作");
        device.run();
        device.stop();
    }

    public boolean isOn() {
        return false;
    }
}
