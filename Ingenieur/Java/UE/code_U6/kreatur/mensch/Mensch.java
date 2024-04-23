package kreatur.mensch;
import kreatur.Kreatur;

public class Mensch extends Kreatur{
    public Mensch(){}

    //Konstruktor der Klasse Mensch
    public Mensch(String name,  
            int strength,
            int hitpoints,
            int agility){
        super(name, strength, hitpoints, agility);
    }
}