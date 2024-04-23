package kreatur.mensch.waffen;
import kreatur.mensch.*;
import kreatur.Kreatur;

public class Dolch extends BewaffneterMensch{
    
    //Konstruktor der Klasse Dolch
    public Dolch(Mensch mensch, int weaponStrength){
        super(mensch, weaponStrength);
    }
    
    @Override 
    public String getWeaponName(){
        return "Dolch";
    }
}