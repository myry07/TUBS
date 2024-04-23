package interface_.poly;

public class poly {
    public static void main(String[] args) {
        IF[] if01 = new IF[2];
        if01[0] = new A();
        if01[1] = new B();

        for (int i = 0; i < if01.length; i++) {
            if01[i].work();
            if(if01[i] instanceof A) {
                ((A)if01[i]).aa();
            } else if(if01[i] instanceof B) {
                ((B)if01[i]).bb();
            }
        }
    }
}

interface IF {
    void work();
}
class A implements IF {
    public void work() {
        System.out.println("A work");
    }

    public void aa() {
        System.out.println("aa特有");
    }
}
class B implements IF {
    public void work() {
        System.out.println("B work");
    }

    public void bb() {
        System.out.println("bb特有");
    }
}

class OOO {}

class AAA extends OOO {}
class BBB extends OOO {}