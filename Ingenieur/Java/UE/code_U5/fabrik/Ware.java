package fabrik;

public class Ware{
    //Attribute der Klasse Ware
    private String name;
    private double verkPreis;
    private double prodPreis;
    private double prodGeschw;
    
    //Konstruktor der Klasse Ware
    public Ware(String name,  
            double verkPreis,
            double prodPreis,
            double prodGeschw){
        this.name = name;
        this.verkPreis = verkPreis;
        this.prodPreis = prodPreis;
        this.prodGeschw = prodGeschw; 
    }
    
    /**** Get-Methoden ***/
    public String getName(){
        return this.name;
    }
    
    public double getVerkPreis(){
        return this.verkPreis;
    }
    
    public double getProdPreis(){
        return this.prodPreis;
    }
    
    public double getProdGeschw(){
        return this.prodGeschw;
    }
}