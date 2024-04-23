package list;

public class ListElement{
    private ListElement next;
    private ListElement prev;
    Person person;
    
    public ListElement(Person person){
        this.person = person;
    }
    
    public void setNext(ListElement next){
        this.next = next;
    }
    
    public void setPrev(ListElement prev){
        this.prev = prev;
    }
    
    public ListElement getNext(){
        return next;
    }
    
    public ListElement getPrev(){
        return prev;
    }
    
    public Person getPerson(){
        return person;
    }
    
    //ToDo! Es soll die gesamte Liste ab this ausgegeben werden.
    public String toString(){
        String res = person.toString();
        if (this.getNext() != null){
            //Der Nachfolger soll seine Ausgabe dazu geben.
            res += " -> " + this.getNext().toString();
        }
        return res;
    }
}