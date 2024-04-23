public class Monus {
    public static int monus(int a, int b){
        int res = 0;
        
        if (a > b && a >= 0 && b >= 0){
            res = a - b;
        }
        
        return res;
    }
}