import fabrik.*;

public class main{
    public static void main(String[] args){
        
        Person p1 = new Person("Jeff Pesos");
        Person p2 = new Person("Elon Dusk");
        Person p3 = new Person("Tony Strong");
        Person p4 = new Person("Bruce Pain");
        
        Person[] personen = {p1, p2, p3, p4};
        
        for (Person p : personen){
            System.out.println(p.getName());
        }
        System.out.println("");
        
        Ware w1 = new Ware("Batarang", 100.0, 80.0, 0.5);
        Ware w2 = new Ware("Coke", 75.0, 45.0, 5);
        Ware w3 = new Ware("Computer Chips", 150.0, 100.0, 2.5);
        
        Ware[] waren = {w1, w2, w3};
        for (Ware w : waren){
            System.out.println(w.getName() + " kann für " + w.getVerkPreis() + " Euro verkauft werden.");
        }
        System.out.println("");
        
        Fabrik fabrik = new Fabrik(personen, waren, 3000.0);
        
        for (int i = 0; i < 3; ++i){
            fabrik.inventur();
            fabrik.verkaufe();
        }
        
        fabrik.einstellen(new Person("Tony Eagle"));
        fabrik.kuendigen(p4);
        fabrik.einstellen(new Person("Frank N. Stein"));
        System.out.println("");
        
        for (int i = 0; i < 3; ++i){
            fabrik.inventur();
            fabrik.verkaufe();
        }
    }
}