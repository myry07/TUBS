import kreatur.Kreatur;
import kreatur.orc.*;
import kreatur.mensch.Mensch;
import kreatur.mensch.waffen.*;

public class main{
    public static void main(String[] args){
    
        //Mensch 1
        Schwert s0 = new Schwert(new Mensch("Zoro", 30, 60, 5), 10);
        Schwert s1 = new Schwert(s0, 15);
        Schwert m1 = new Schwert(s1, 8);
        
        //Mensch 2
        Mensch m2 = new Mensch("Peter Pan", 70, 60, 8);
        
        //Mensch 3
        Dolch d1 = new Dolch(new Mensch("Brutus", 40, 70, 9), 8);
        Dolch m3 = new Dolch(d1, 9);
        
        //Orc 1
        Orc o1 = new Orc("Arne Schmidt", 80, 130, 6);
        
        //Orc 2
        ClubbedOrc o2 = new ClubbedOrc("Keulchen", 90, 180, 4, 12);
        
        Mensch[] menschen = {m1, m2, m3};
        Orc[] orcs = {o1, o2};
        Kreatur[] kreaturen = {m1, m2, m3, o1, o2};
        
        //Indizes, um festzustellen, welcher die erste lebendige Kreatur in den jeweiligen Arrays ist.
        int mIndex = 0;
        int oIndex = 0;
        
        while (mIndex < menschen.length && oIndex < orcs.length){
            
            for (Kreatur k : kreaturen){
                if(!k.isAlive()){
                    continue;
                }
                
                //Prüfe, ob k ein Mensch oder Orc ist.
                if (k instanceof Mensch){
                    //k ist ein Mensch und greift einen Orc an.
                    k.attack(orcs[oIndex]);
                    
                    if (!orcs[oIndex].isAlive()){
                        ++oIndex;
                    }
                    
                } else{
                    //k ist ein Orc und greift einen Menschen an
                    k.attack(menschen[mIndex]);
                    
                    if (!menschen[mIndex].isAlive()){
                        ++mIndex;
                    }
                
                }
            }
        }      
    }
}