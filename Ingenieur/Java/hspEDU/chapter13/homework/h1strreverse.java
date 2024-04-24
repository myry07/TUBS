package chapter13.homework;

/**
 * @author myry
 * @date 2024-43-30 15:43
 * 将字符串反转
 * abcdef <-> aedcbf
 *
 * String.charAt(1) = "3" 会报错
 */

@SuppressWarnings({"all"})
public class h1strreverse {
    public static void main(String[] args) {

        System.out.println(self(args[0], 0, 8));

    }

    public static String self(String str, int start, int end) {
        int temp = end;
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            if (i >= start && i <= end) {
                res += str.charAt(temp--);
            } else {

                res += str.charAt(i);
            }
        }

        return res;

    }
}
