public class Mergesort{
    /*
     * merge kombiniert Teilarrays auf Indizes [left, middle) und [middle, right)
     */
    public static void merge(int[] array, int 
            left, int middle, int right){
        
        //Erstelle Hilfsarrays
        int[] leftArray = new int[middle-left];
        int[] rightArray = new int[right - middle];
        
        // Kopiere Inhalt aus array in die zwei Teilarrays
        for (int i = 0; i < leftArray.length; ++i){
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightArray.length; ++i){
            rightArray[i] = array[middle + i];
        }
        
        // Merge beide Teilarray in array
        int l = 0;
        int r = 0;
        
        for (int i = 0; i < right - left; ++i){
            //In der Übung vergessen: Bei einem Test a || b wird b nur dann getestet, wenn a falsch ist. (Prinzip wird auch Short-circuit evaluation genannt)
            //Gleiches mit &&: Bei dem Test a && b wird b nur dann getestet, wenn a wahr ist.
            if (l < leftArray.length &&         //Zeigt l auf ein Element in leftArray?
                    (r >= rightArray.length || leftArray[l] < rightArray[r])){      //rightArray schon abgearbeitet oder Element vergleich
                
                array[left + i] = leftArray[l];
                ++l;
            } else {
                array[left + i] = rightArray[r];
                ++r;
            }
        }
    }

    /*
     * mergesort sortiert ein Array über Seiteneffekte
     * Erhält das zu sortierende Array und den Bereich [left, right) auf dem sortiert werden soll.
     * Wichtig: Index left ist inklusive, Index right ist exklusive!
     */
    public static void mergesort(int[] array,     
            int left, int right){
        if (right - left <= 1){
            return;
        }
        
        //Sortiere linke und rechte Hälfte
        int middle = (left + right)/2;
        mergesort(array, left, middle);
        mergesort(array, middle, right);
        
        //Merge beide Hälften
        merge(array, left, middle, right); 
        print(array);
    }
    
    private static void print(int[] array){
        for (int a : array){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] array = {5,1,8,7,3,4,2,0,9,6};
        mergesort(array, 0 , array.length);
    }
}