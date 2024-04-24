package interface_.interVsExtend;

import Dynamik.B;

public class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println("猴子 " + name + " 会爬树");
    }
}

interface Fish {
    void swimming();
}

interface Bird {
    void flying();
}

class LittleMonkey extends Monkey implements Fish, Bird {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(super.getName() + " 学会了游泳");
    }

    public void flying() {
        System.out.println(super.getName() + " 学会了飞行");
    }
}