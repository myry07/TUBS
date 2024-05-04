package exception.excDetail;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("输入整数");
                String str = s.next();
                int num = Integer.parseInt(str);
                System.out.println("整数为 " + num);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
