package leetcode;

public class auf90 {
    public static void main(String[] args) {
        System.out.println(solution(77));
    }

    public static String solution(int num) {
        if(num < 10) {
            return String.valueOf(num);
        }

        int n = num;
        String res = "";
        while(n > 1) {
            for (int i = 2; i < 20; i++) {
                if(n % i == 0) {
                    n /= i;
                    if(n > 1) {
                        res += i + "*";
                        break;
                    } else {
                        res += i + "";
                        break;
                    }
                }
            }
        }
        return res;
    }
}
