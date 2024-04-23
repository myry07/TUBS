package interface_.interVsExtend;

public class test {
    public static void main(String[] args) {
        Monkey wukong = new LittleMonkey("悟空");
        wukong.climbing();


        LittleMonkey lm = (LittleMonkey) wukong;
        getFish(lm);


        LittleMonkey wukeng = new LittleMonkey("悟坑");
        wukeng.flying();

    }

    public static void getFish(Fish f) {
        f.swimming();
    }
}
