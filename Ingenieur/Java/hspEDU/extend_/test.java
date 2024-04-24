package extend_;

import java.security.PublicKey;

public class test {
    public static void main(String[] args) {
        Pupil p = new Pupil();
        p.name = "小学生";
        p.age = 6;
        p.setScore(100);

        p.shouInfo();
        p.testing();

        Graduate g = new Graduate();
        g.name = "da";
        g.age = 9;
        g.setScore(9);

        g.shouInfo();
        g.testing();
    }
}
