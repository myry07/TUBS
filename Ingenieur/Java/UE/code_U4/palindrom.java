public class palindrom{
    /* Idee: Anzahl Zeichen zählen (n)
     * Das durch 2 teilen
     * Iteriere durch Zeichen
     * Prüfe, ob i-tes Zeichen mit Zeichen n-i übereinstimmt
     */
    public static boolean isPalindrom(String s){
        //n ist Index des letzten Zeichens.
        int n = s.length()-1;
        
        //Vergleiche Zeichen von vorne und von hinten
        for (int i = 0; i <= n/2; ++i){
            if (s.charAt(i) != s.charAt(n-i)){
                return false;
            }
        }
        return true;
    }
     
    public static void main(String[] args){
        String s = args[0];
        
        if (isPalindrom(s)){
            System.out.println(s + " ist ein Palindrom.");
        }else{
            System.out.println(s + " ist kein Palindrom.");
        }
    }
}