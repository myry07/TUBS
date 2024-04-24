package PolyParameter;

public class test {
    public static void main(String[] args) {
        test t = new test();

        Employee ee = new Employee("王小笼", 10);
        System.out.println(t.showEmpAnnal(ee));

        Employee[] ees = new Employee[4];
        ees[0] = new Mana("王小笼", 15, -1);
        ees[1] = new Mana("王小笼", 5, -9);
        ees[2] = new wo("王小笼", 9);
        ees[3] = new wo("王小笼", 1);

        for (int i = 0; i < ees.length; i++) {
            System.out.println(t.showEmpAnnal(ees[i]));
            t.getManaWo(ees[i]);
        }
    }

    public String showEmpAnnal(Employee e) {
        return e.getAnnual();
    }

    public void getManaWo(Employee e) {
        if(e instanceof Mana) {
            ((Mana) e).manager();
        } else if(e instanceof wo) {
            ((wo) e).work();
        }
    }
}
