public class U3_code{
    //Summe natürliche Zahlen
    public static int intSum(int x){
        int summe = 0;
        
        //Addiere 1, 2, 3, 4, ..., x auf summe
        for (int i = 1; i <= x; ++i){
            summe += i;
        }
        
        return summe;
    }
    
    public static int collatz(int x){
        int counter = 0;
        System.out.print(x + "");
        
        //Solange x != 1 läuft das Verfahren weiter
        while (x != 1) {
            ++counter;
            
            if (x % 2 == 0) { //x gerade
                x /= 2;
            } else { //x ungerade
                x = 3*x +1;
            }
            
            System.out.print(" -> " + x);
        } 
        System.out.println("");
        
        return counter;
    }
    
    public static int crossSum(int x){
        int summe = 0;
        
        // x % 10 gibt letzte Ziffer
        // x / 10 gibt die restlichen Ziffern
        while (x >= 10) {
            summe += x % 10;
            x /= 10;
        }
        
        summe += x;
        
        return summe;
    }
    
    /* 
     * Das Programm erwartet zwei Eingaben:
     * Zuerst eine positive ganze Zahl
     * Dann ein String (summe für die Summe der natürlichen Zahlen, 
     * collatz für das Collatz-Verfahren. Default ist Quersumme)
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        
        /* 
         * If-Abfragen bzgl. des 2. Inputs.
         * Der Inhalt von Strings kann nicht per == getestet werden.
         * Stattdessen kann für einen String s die Methode s.compareTo(String) verwendet werden.
         * Mehr dazu in späteren Vorlesungen. 
         */
        if (args[1].compareTo("summe") == 0){
            int res = intSum(x);
            System.out.println(res+" (Summe)");
        
        } else if (args[1].compareTo("collatz") == 0){
            int res = collatz(x);
            System.out.println(res+" Iterationen");
        } else {
            int res = crossSum(x);
            System.out.println(res+" (Quersumme)");   
        }
    }
}