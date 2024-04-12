public class Typetest{
    
    public static void main(String[] args) {
        var result = 247 >> 4; // Durch var wird der Datentyp automatisch zur Kompilierzeit ermittelt.
        Object resultClass = result; // Nutzung von Wrapper-Klassen!
        System.out.println(result + " is a(n) " + resultClass.getClass().getSimpleName());
        
        //Object.getClass() gibt aus, um welche Klasse es sich handelt. getSimpleName() macht den Namen etwas lesbarer.
    }
}