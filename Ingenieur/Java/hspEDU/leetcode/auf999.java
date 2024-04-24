package leetcode;

public class auf999 {
    public static void main(String[] args) {
        System.out.println(rek(999));
        System.out.println(ite(999));
    }

    public static int rek(int num) {
        if(num < 10) {
            return num;
        }

        int x = num;
        int res = 0;
        while(x >= 10) {
            res += x % 10;
            x /= 10;
        }
        res += x;
        return rek(res);
    }

    public static int ite(int num) {
       int x = num;
       while(x >= 10) {
           int res = 0;
           while(x >= 10) {
               res += x %10;
               x /= 10;
           }
           x = res + x;
       }
       return x;
    }
}
