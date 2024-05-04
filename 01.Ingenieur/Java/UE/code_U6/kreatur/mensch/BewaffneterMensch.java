package kreatur.mensch;
import kreatur.Kreatur;

//Von dieser Klasse am besten keine Instanzen erzeugen lassen. Daher ist die Klasse abstrakt.
abstract public class BewaffneterMensch extends Mensch{
    private Mensch mensch;
    private int weaponStrength;
    
    //Konstruktor der Klasse Dolch
    public BewaffneterMensch(){}
    
    public BewaffneterMensch(Mensch mensch, int weaponStrength){
        this.mensch = mensch;
        this.weaponStrength = weaponStrength;
    }
    
    //Ab hier wird das zusätzliche Verhalten definiert
    @Override
    public String getName(){
        return mensch.getName();
    }
    @Override
    public int getStrength(){
        return mensch.getStrength();
    }
    @Override
    public int getAgility(){
        return mensch.getAgility();
    }
    @Override
    public int getHitpoints(){
        return mensch.getHitpoints();
    }
    
    @Override
    public boolean isAlive(){
        return mensch.isAlive();
    }
    
    public String getWeaponName(){
        return "null";
    }
    
    @Override
    public void hit(int damage){
        mensch.hit(damage);
    }
    
    @Override
    public void attack(Kreatur enemy){
        System.out.println(getName() +  " greift " + enemy.getName() + " mit einem " + this.getWeaponName() + " an. " +  weaponStrength + " Extraschaden");
        enemy.hit(calcDamage(weaponStrength));
        
        //Check, ob das Attribut vom Typen Mensch und keiner Unterklasse ist.
        if (Mensch.class.isAssignableFrom(mensch.getClass().getSuperclass())){
            if (enemy.isAlive()){
                System.out.println(getName() +  " besitzt eine weitere Waffe und greift erneut an!");
                mensch.attack(enemy);
            }
        }
    }
}