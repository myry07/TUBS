package H4.smarthome;

public class Heater implements Device{
    private String name;

    public Heater(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(getName() + " 打开");
    }

    public void stop() {
        System.out.println(getName() + " 关闭");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
