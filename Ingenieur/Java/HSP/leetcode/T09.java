package leetcode;

public class T09 {
    public static void main(String[] args) {
        T09 t09 = new T09();
        System.out.println(t09.isPalindrome(121));
    }
    public boolean isPalindrome(int x) {
       if(x < 11) {
           return false;
       }
       int num = x;
       int res = 0;
       while(num > 11) {
           res += num % 10;
           num /= 10;
           res *= 10;
       }
       res += num;

       if(res == x) {
           return true;
       } else
           return false;
    }
}
