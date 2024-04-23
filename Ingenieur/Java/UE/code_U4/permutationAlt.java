public class permutationAlt {
    /**
     * Inverts the decreasing Array
     * @author Arne
     * @param array array to work on
     * @param bot starting index of decreasing array
     * @param top ending index of decreasing array
     */
    public static void invert(int[] array, int bot, int top){
        int mid = (bot + top)/2;
        for (int i = bot; i <= mid; ++i){
            int tmp = array[i];
            array[i] = array[top - i + bot];
            array[top - i + bot] = tmp;
        }
    }
    
    /**
     * Returns starting index of decreasing Array
     * @author Arne
     * @param array array to search for the index
     * @param top ending index of decreasing array (in case you want to to this on a subarray)
     * @return starting index of decreasing array
     */
    public static int getBotDecreasingArray(int[] array, int top){
        int res = top;
        while (res > 0 && array[res] < array[res - 1]){
            --res;
        }
        return res-1;
    }
    
    /**
     * Returns index of successor of the element directly before decreasing array.
     * @author Arne
     * @param array array to search for the index
     * @param num the value, of which we want to find the successor
     * @param top the ending index of the decreasing array
     * @return Index of succesor.
     */
    public static int getIndexOfSuccesor(int[] array, int num, int top){
        int i = top;
        while (i >= 0 && array[i] < num){
            --i;
        }
        return i;
    }
    
    
    /**
     * Inverts the decreasing Array
     * @author Arne
     * @param array array to work on
     * @param a index of first element
     * @param b index of second element
     */
    public static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    
    /**
     * Prints elements of an integer array.
     * @author Arne
     * @param array array to be printed
     */
    public static void printArray(int[] array){
        System.out.print("{ ");
        for (int a : array){
            System.out.print(a + " ");
        }
        System.out.println("}");
    }
    
    /**
     * Main-method. Creates an array and performs some iterations outputting the next permutations.
     * @author Arne
     * @param args String array with parameters
    */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        printArray(array);
        
        for (int i = 0; i < 40000; ++i){
            int a = getBotDecreasingArray(array, array.length-1);
            if (a >= 0){
                int b = getIndexOfSuccesor(array, array[a], array.length-1);
                swap(array, a, b);
            }
            invert(array, a+1, array.length-1);
            printArray(array);
        }
    }
}
