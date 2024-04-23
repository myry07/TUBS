package exception.excDetail;

public class test {
    public static void main(String[] args) {

        try {
            String s = "hsp";
            int n = Integer.parseInt(s);
            System.out.println(n);
        } catch (Exception e) {
            System.out.println("catch 执行 " + e.getMessage());
        } finally {
            System.out.println("finally 执行");
        }
    }
}
