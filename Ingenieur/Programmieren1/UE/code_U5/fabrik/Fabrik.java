package fabrik;

public class Fabrik{
    //Attribute der Klasse Fabrik
    private Person[] mitarb;
    private double kapital;
    private Ware[] produkte;
    private int[] bestand;
    
    //Konstruktor der Klasse Ware
    public Fabrik(Person[] mitarb, Ware[] produkte, double kapital){
        this.mitarb = mitarb;
        this.produkte = produkte;
        this.kapital = kapital;
        this.bestand = new int[produkte.length]; 
    }
    
    /********* Ab hier werden Personen zu mitarb hinzugefügt und gelöscht **********/
    
    public void einstellen(Person pers){
        //Ausgelassen in der großen Übung
        
        Person[] tmp = new Person[mitarb.length+1];
        
        //Fülle neues Array mit alten Einträgen
        for (int i = 0; i < mitarb.length; ++i){
            tmp[i] = mitarb[i];
        }
        //Füge neuen Eintrag hinzu
        tmp[tmp.length-1] = pers;
        
        //Setze Attribut auf das neue Array
        mitarb = tmp;
    }
    
    public void kuendigen(Person pers){
        //Ausgelassen in der großen Übung
        
        //Prüfe, ob Person existiert.
        boolean exists = false;
        for (Person p : mitarb){
            if (p.getName().equals(pers.getName())){
                exists = true;
                break;
            }
        }
        
        //Wenn Person nicht existiert, können wir stoppen.
        if (!exists){
            System.out.println("Person existiert nicht und kann nicht gekündigt werden.");
            return;
        }
        
        
        Person[] tmp = new Person[mitarb.length-1];
        
        int index = 0; //Enthält das nächste Feld von tmp, in welches wir eine Person schreiben wollen.
        for (int i = 0; i < mitarb.length; ++i){
            
            //Falls das Feld die Person enthält, die gekündigt werden soll, überspringen wir.
            //Achtung: Was passiert, wenn die Person mehrfach existiert?
            if (mitarb[i].getName().equals(pers.getName())){
                System.out.println(pers.getName() + " wurde gefeuert!");
                continue;
            }
            
            tmp[index] = mitarb[i];
            ++index;
        }
    }
    
    
    /********* Ab hier werden Produkte überprüft, produziert und verkauft **********/
    public void inventur(){
        for (int i = 0; i < bestand.length; ++i){
            //Check, ob Ware i zu wenig vorhanden ist.
            if (bestand[i] < 10){
                System.out.println("Ware " + produkte[i].getName() + " ist zu wenig vorhanden!");
                produziere(i, 1);
            }
        }
    }
    
    public void produziere(int wareIndex, int stunden){
        //Berechne, wie viel von Ware i produziert werden kann (abgerundet).
        int produziert = (int) (mitarb.length * stunden * produkte[wareIndex].getProdGeschw());
        
        //Passe Bestand und Kapital an.
        bestand[wareIndex] += produziert;
        kapital -= produziert *  produkte[wareIndex].getProdPreis();
    }
    
    public void verkaufe(){
        for (int i = 0; i < produkte.length; ++i){
            //Bestimme den zu verkaufenden Anteil für Ware i.
            double anteil = Math.random();
            
            //Falls Anteil zu gering ist (20% werden immer verkauft),
            if (anteil < 0.2){
                anteil = 0.2;
            }
            
            //Bestimme die Anzahl an verkauften Waren.
            int verkauft = (int) (anteil * bestand[i]);
            
            //Passe Bestand und Kapital an.
            bestand[i] -= verkauft;
            kapital += verkauft * produkte[i].getVerkPreis();
            System.out.println(produkte[i].getName() + " wurde " + verkauft + " oft verkauft. Kapital ist nun bei " + kapital);
        }
    }
}