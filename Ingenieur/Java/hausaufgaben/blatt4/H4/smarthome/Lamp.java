package H4.smarthome;

public class Lamp implements Device {
    private String name;

    public void run() {
        System.out.println(getName() + " 打开");
    }

    public void stop() {
        System.out.println(getName() + " 关闭");
    }

    public Lamp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
