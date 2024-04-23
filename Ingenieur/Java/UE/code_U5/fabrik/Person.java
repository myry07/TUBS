package fabrik;

public class Person{
    //Attribute der Klasse Person
    private String name;
    
    //Konstruktor der Klasse Person
    public Person(String name){
        this.name = name;
    }
    
    /**** Get-Methoden ***/
    public String getName(){
        return this.name;
    }
}