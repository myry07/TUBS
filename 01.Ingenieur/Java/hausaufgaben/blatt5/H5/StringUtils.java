package H5;

import org.junit.jupiter.api.Test;

/**
 * @author myry
 * @date 2024-05-27 22:05
 */

public class StringUtils {
    public static void main(String[] args) {
        System.out.println(new StringUtils().isPalindrome(args[0]));
        System.out.println(new StringUtils().areAnagrams(args[0], args[1]));

        char[] c = {'c', 'b', 'a'};
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }

        System.out.println();
        new StringUtils().sort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }

        System.out.println();
        System.out.println(new StringUtils().hasPrefix(args[0], args[1]));
        System.out.println(new StringUtils().hasSuffix(args[0], args[1]));
    }

    //检测字符串 是否反转后的等于反转前的
    boolean isPalindrome(String text) {
        for (int v = 0, r = text.length() - 1
             ; v < text.length() / 2
                ; v++, r--) {
            if(text.charAt(v) != text.charAt(r)) {
                return false;
            }
        }
        return true;
    }

    @Test
    void sort(char[] text) {
        char temp = '\0';
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text.length - i - 1; j++) {
                if(text[j] > text[j + 1]) {
                    temp = text[j];
                    text[j] = text[j + 1];
                    text[j + 1] = temp;
                }
            }
        }
    }


    //检测字符串所含字符是否相等
    boolean areAnagrams(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    count++;
                }
            }
        }

        if(count == str1.length()) {
            return true;
        }

        return false;
    }

    @Test
    boolean hasPrefix(String text, String prefix) {
        for (int firstPre = 0, secPre = 0;
             firstPre < prefix.length();
             firstPre++, secPre++) {
            if(text.charAt(firstPre) != prefix.charAt(secPre)) {
                return false;
            }
        }
        return true;
    }

    boolean hasSuffix(String text, String suffix) {
        for (int firstPre = text.length() - 1, secPre = suffix.length() - 1;
             secPre >= 0 ;
             firstPre--, secPre--) {
            if(text.charAt(firstPre) != suffix.charAt(secPre)) {
                return false;
            }
        }
        return true;
    }
}
