package kreatur;

public class Kreatur{
    //Attribute der Klasse Kreatur
    private String name;
    private int strength;
    private int hitpoints;
    private int agility; 
    
    //Konstruktoren der Klasse Kreatur
    public Kreatur(){}
    
    public Kreatur(String name,  
            int strength,
            int hitpoints,
            int agility){
        this.name = name;
        this.strength = strength;
        this.hitpoints = hitpoints;
        this.agility = agility; 
    }
    
    /**** Get-Methoden ***/
    public String getName(){
        return this.name;
    }
    
    public int getStrength(){
        return this.strength;
    }
    
    public int getHitpoints(){
        return this.hitpoints;
    }
    
    public int getAgility(){
        return this.agility;
    }
    
    //Optional, macht manche if-Verzweigungen einfacher
    public boolean isAlive(){
        return this.hitpoints > 0;
    }
    
    /**** Weitere Funktionen ****/
    public void attack(Kreatur enemy){
        int damage = calcDamage(0);
        System.out.println(this.getName() + " schlägt " + enemy.getName() + " mit " + damage + " Schaden.");
        enemy.hit(damage);
    }
    
    public int calcDamage(int strengthBuff){
        int damage = this.strength / 10;
        damage += strengthBuff;
        
        //Optional, falls man kritische Treffer mit einbauen möchte.
        if (Math.random() < .5){
            damage *= 1.4;
            System.out.println("Kritischer Treffer!");
        }
        return damage;
    }
    
    public void hit(int damage){
        this.hitpoints -= damage;
        
        if (!this.isAlive()){
            System.out.println(this.getName() + " wurde besiegt!");
        } 
    }
}