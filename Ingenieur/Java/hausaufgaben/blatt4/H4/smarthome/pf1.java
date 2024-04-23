package H4.smarthome;

import Dynamik.B;

public class pf1 {
    public static void main(String[] args) {
        Lamp schlafzimmerlich = new Lamp("卧室灯");
        Lamp badezimmerlich = new Lamp("浴室灯");
        Heater duschwasserheizsystem = new Heater("洗澡水暖气装置");
        CoffeeMaschine kaffee = new CoffeeMaschine();

        Button b = new Button();
        Switch s = new Switch();

        s.poll(schlafzimmerlich);
        s.poll(badezimmerlich);
        s.poll(duschwasserheizsystem);

        b.poll(kaffee);
    }
}
