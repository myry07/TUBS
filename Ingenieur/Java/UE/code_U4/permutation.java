public class permutation{
    
    //Gibt den Index zurück, ab welchem die Zahlen nur noch absteigend sind
    static int getIndexDescendingSequence(int[] arr){
        int n = arr.length-1;
        while(n > 0 && arr[n] < arr[n-1]){
            --n;
        }
        return n;
    }
    
    /*
     * Findet Nachfolger der Zahl an der Stelle x im Bereich x+1 bis arr.length
     */
    static int getSuccessorIndex(int[] arr, int x){
        int index = x+1;
        for (int i = x+1; i < arr.length; ++i){
            if (arr[i] > arr[x]){
                ++index;
            }
        }
        return index - 1;
    }
    
    //Dreht die absteigende Sequenz um.
    static void invertDescendingSequence(int[] arr, int index){
        int mid = (arr.length + index)/2;
        
        //Tausche innerhalb der Sequenz erstes mit letztem, zweites mit vorletztem, etc.
        for (int i = index; i < mid; ++i){
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 + index - i];
            arr[arr.length - 1 + index - i] = tmp;
        }
    }
    
    /*
     * Ändert das Array zur nächsten Permutation über Seiteneffekte
     *
     */
     static void nextPermutation(int[] arr){
        int index = getIndexDescendingSequence(arr);
        
        /* 
         * Falls index == 0, dann ist das gesamte Array absteigend sortiert.
         * Einfaches Invertieren gibt wieder eine aufsteigend sortierte Reihenfolge.
         */
        if (index != 0){
            int x = index - 1;
            int y = getSuccessorIndex(arr, x);
        
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }
        
        invertDescendingSequence(arr, index);
    }
    
    //Einfache Ausgabe für ein Array
    static void print(int[] arr){
        System.out.print("{ ");
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println("}");
    }
    
    //Main Methode, die mehrfach die nächste Permutation für ein Array ausgibt.
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        print(arr);
        for (int i = 0; i < 5000; ++i){
            nextPermutation(arr);
            print(arr);
        }
    }
}