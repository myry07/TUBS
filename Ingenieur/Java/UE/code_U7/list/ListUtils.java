package list;

final public class ListUtils{
    private ListUtils(){}
    
    public static ListElement find(ListElement head, Person person){
    
        ListElement current = head;
        
        while(current != null && 
                current.getPerson().compareTo(person) != 0){
            current = current.getNext();
        }
        
        return current;
    }
    
    /*
     * Fügt ein neues Element in Liste mit Start head ein
     * Gibt den neuen Kopf der Liste zurück
     */
    public static ListElement insert(ListElement head,
            Person person){
        //ToDo: Check, ob person bereits in der Liste existiert.
        ListElement le_new = new ListElement(person);
        le_new.setNext(head);
        head.setPrev(le_new);
        
        //Neues Element ist der neue Anfang!
        return le_new;
    }
    
    /*
     * Entfernt ein Element mit Inhalt person aus der Liste mit Anfang head.
     * Gibt den Anfang der Liste zurück.
     */
    public static ListElement remove(ListElement head, 
            Person person){
            
        ListElement le_person = find(head, person);
        
        if (le_person == null){
            System.out.println("Person " + person + " existiert nicht.");
            return head;
        }
        
        ListElement le_prev = le_person.getPrev();
        ListElement le_next = le_person.getNext();
        
        //Prüfe, ob Vorgänger existiert.
        if (le_prev != null){
            le_prev.setNext(le_next);
        } else {     
            //Vorgänger existiert nicht, setze neuen Anfang der Liste
            head = le_next;
        }
        
        //Prüfe, ob Nachfolger existiert.
        if (le_next != null){
            le_next.setPrev(le_prev);
        }
        
        le_person.setNext(null);
        le_person.setPrev(null);
        
        return head;
    }
}