import kreatur.Kreatur;
import kreatur.orc.*;
import kreatur.mensch.Mensch;
import kreatur.mensch.waffen.*;

public class main_alt{

    //Sortiert Kreaturen absteigend nach dem Attribut agility.
    public static void sortKreaturen(Kreatur[] kreaturen){
        for (int i = kreaturen.length-1; i > 0; --i){
            for (int j = 0; j < i; ++j){
                if (kreaturen[j].getAgility() < kreaturen[j+1].getAgility()){
                    Kreatur tmp = kreaturen[j];
                    kreaturen[j] = kreaturen[j+1];
                    kreaturen[j+1] = tmp;
                }
            }
        }
    }
    
    //Simuliert einen Kampf mit Kreaturen aus turns, welche in menschen und orcs aufgeteilt sind.
    //Weiterer Verlauf ist analog zu main.java
    public static boolean simFight(Kreatur[] turns, Mensch[] menschen, Orc[] orcs){
        sortKreaturen(turns);
        
        int mIndex = 0;
        int oIndex = 0;
        
        while (mIndex < menschen.length && oIndex < orcs.length){
            for (Kreatur kreatur : turns){
                if (!kreatur.isAlive()){
                    continue;
                }
                
                if (kreatur instanceof Mensch){
                    kreatur.attack(orcs[oIndex]);
                    
                    if (!orcs[oIndex].isAlive()){
                        ++oIndex; 
                    }
                    
                    //Letzter Orc besiegt?
                    if (oIndex == orcs.length){
                        break;
                    }
                }
                
                if (kreatur instanceof Orc){
                    kreatur.attack(menschen[mIndex]);
                    
                    if (!menschen[mIndex].isAlive()){
                        ++mIndex; 
                    }
                    
                    //Letzter Mensch besiegt?
                    if (mIndex == menschen.length){
                        break;
                    }
                }
                System.out.println("\n");
            }
        }
        
        System.out.println(mIndex < menschen.length ? "Menschen haben gesiegt!" : "Orcs haben gesiegt!");
        return mIndex < menschen.length;

    }

    public static void main(String[] args){
        int cMenschenSiege = 0;
        int cOrcsSiege = 0;
        
        for (int i = 0; i < 20; ++i){
            System.out.println("\n\n ******** Es beginnt eine neue Runde!! ********\n\n");
            Schwert s1 = new Schwert(new Mensch("Berndt", 30, 60, 5), 15);
            Schwert s2 = new Schwert(new Mensch("Anna", 20, 60, 6), 12);
    
            Mensch m1 = new Mensch("Zorro", 20, 50, 10);
            Dolch d1 = new Dolch(m1, 5);
            Schwert d2 = new Schwert(d1, 12);
            Schwert zorro = new Schwert(d2, 15);
        
            Dolch t3 = new Dolch(new Mensch("Paul", 30, 60, 4), 5);
            Dolch d3 = new Dolch(t3, 12);
        
            Dolch d4 = new Dolch(new Mensch("Simon", 30, 60, 10), 5);
        
            Mensch[] menschen = {s1, s2, zorro, d3, d4};
        
            Orc o1 = new Orc("Haudrauff", 90, 140, 6);
            ClubbedOrc co1 = new ClubbedOrc("Keulchen", 40, 130, 1, 20);
            ClubbedOrc co2 = new ClubbedOrc("Mister Hyde", 30, 120, 6, 15);
        
            Orc[] orcs = {o1, co1, co2};
            Kreatur[] turns = {s1, s2, zorro, d3, d4, o1, co1, co2};
            boolean res = simFight(turns, menschen, orcs);
            
            if (res){
                ++cMenschenSiege;
            }else{
                ++cOrcsSiege;
            }
        }
        
        System.out.println("Menschen haben " + cMenschenSiege + " oft gewonnen.");
        System.out.println("Orcs haben " + cOrcsSiege + " oft gewonnen.");
        
        
    }
}