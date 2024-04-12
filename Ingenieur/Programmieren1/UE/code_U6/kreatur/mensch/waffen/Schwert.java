package kreatur.mensch.waffen;
import kreatur.mensch.*;
import kreatur.Kreatur;

public class Schwert extends BewaffneterMensch{
    
    //Konstruktor der Klasse Schwert
    public Schwert(Mensch mensch, int weaponStrength){
        super(mensch, weaponStrength);
    }
    
    @Override 
    public String getWeaponName(){
        return "Schwert";
    }
}