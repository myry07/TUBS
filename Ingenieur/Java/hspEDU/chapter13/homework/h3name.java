package chapter13.homework;

/**
 * @author myry
 * @date 2024-33-30 16:33
 * Han shun Ping --> Ping,Han,S
 */
public class h3name {
    public static void main(String[] args) {
        System.out.println(conver("Willian xjj Liii"));
    }

    public static String conver(String str) {
        String[] arr = new String[3];
        arr[0] = "";
        arr[1] = "";
        arr[2] = "";

        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ') {
                arr[index] += str.charAt(i);
            } else {
                index++;
            }
        }

        char ka = 'a';
        char ga = 'A';
        int dif = (int)ka - (int)ga;

        char c = arr[1].charAt(0);
        int a_c = (int)c - dif;
        char res_c = (char)a_c;

        String res = arr[2] + "," + arr[0] + "," + res_c;
        return res;
    }
}
