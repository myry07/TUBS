public class Teilbar{
    public static boolean isDivisible(int n){
        //Abbruchbedingung für Rekursion
        if (n <= 17){
            return n == 17 || n == 0;
        }
        
        //Berechne die neue Zahl
        int neueZahl = n / 10 * 3;
        neueZahl += n%10 * 2;
        
        //Gib das Ergebnis des rekursiven Aufrufs zurück
        return isDivisible(neueZahl);
    }
    
    public static boolean isDivisibleIterative(int n){
        //Da obige Funktion eine Endrekursion ist, können wir einfach eine while-Schleife nutzen.
        while (n > 17){
            int neueZahl = n / 10 * 3;
            neueZahl += n%10 * 2;
            n = neueZahl;
        }
        
        return n == 17 || n == 0;
    }
    
    public static void main(String[] args){
        //Teste Zahlen mit einer der beiden Funktionen
        for (int i = 1; i <= 51; ++i){
            System.out.println(i + " ist durch 17 teilbar?" + isDivisibleIterative(i));
        }
    }
}