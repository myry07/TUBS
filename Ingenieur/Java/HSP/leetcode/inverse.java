package leetcode;

public class inverse {
    public static void main(String[] args) {
        System.out.println(solution(120));
    }

    public static int solution(int num) {
        int temp = 0;
        int x = 0;
        int res = 0;
        if(num < 0) {
            x = num * -1;
            temp = -1;
        } else {
            x = num;
        }

        if(x < 10) {
            return x;
        }

        while(x > 9) {
            res += x % 10;
            x /= 10;
            res *= 10;
        }
        res += x;

        if(temp == -1) {
            return res * -1;
        } else
            return res;
    }
}
