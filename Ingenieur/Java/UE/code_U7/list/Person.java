package list;

public class Person implements Comparable<Person>{
    static int createdPersons = 0; //Für das Setzen der ID
    
    private int id;
    private String name;
    
    public Person(String name){
        this.id = createdPersons++; //Weist ID zu und setzt createdPersons um 1 höher.
        this.name = name;
    }
    
    public int getID(){
        return id;
    }
    
    public int compareTo(Person pers){
        return this.id - pers.getID();
    }
    
    public String toString(){
        return "ID: " + this.id + "; Name: " + this.name;
    }
}