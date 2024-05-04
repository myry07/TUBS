package kreatur.orc;
import kreatur.orc.Orc;
import kreatur.Kreatur;

public class ClubbedOrc extends Orc{
    private int weaponStrength;
    
    public ClubbedOrc(String name,  
            int strength,
            int hitpoints,
            int agility,
            int weaponStrength){ 
        super(name, strength, hitpoints, agility);
        this.weaponStrength = weaponStrength;
    }
    
    @Override
    public void attack(Kreatur enemy){   
        int damage = calcDamage(this.weaponStrength);
        System.out.println(this.getName() + " schlägt " + enemy.getName() + " mit einer Keule und verursacht " + damage + " Schaden.");
        enemy.hit(damage);
    }
}