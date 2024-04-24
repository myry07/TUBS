package leetcode;

public class Auf13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("VX"));
    }

    public static int romanToInt(String s) {
        int temp = 0, res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I' : temp = 1; break;
                case 'V' : temp = 5; break;
                case 'X' : temp = 10; break;
                case 'L' : temp = 50; break;
                case 'C' : temp = 100; break;
                case 'D' : temp = 500; break;
                case 'M' : temp = 1000; break;
            }
            if(4 * temp < res) {
                res -= temp;
            } else {
                res += temp;
            }
        }
        return res;
    }
}

