package throws_;

public class exercise {
    public static void main(String[] args) {

        try {
            if(args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数不对");
            }

            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            System.out.println(EcmDef.cal(n1, n2));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }
}

class EcmDef {
    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
