package poly;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    //多态机制
    public void feed(Animal a, Food f) {
        System.out.println("主人 " + name + " 给 " + a.getName() + " 吃 " + f.getName());
    }

//    public void feed(Dog d, Bone b) {
//        System.out.println("主人 " + name + " 给 " + d.getName() + " 吃 " + b.getName());
//    }
//
//   public void feed(Cat c, Fisch f) {
//       System.out.println("主人 " + name + " 给 " + c.getName() + " 吃 " + f.getName());
//   }
}
