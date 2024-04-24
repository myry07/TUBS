package exception.excDetail;

@SuppressWarnings({"all"})
public class self {
    public static void main(String[] args) {
        try {
            System.out.println(dis(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
            System.out.println(dis(Integer.parseInt(args[0]), Integer.parseInt(args[2])));
        } catch (MyException me) {
            System.out.println(me.getMessage());
        } finally {
            System.out.println("final");
        }
        System.out.println("666");
    }

    public static int dis(int a, int b) throws MyException{
        if(b == 0) {
            throw new MyException("分母不能=0");
        }
        return a / b;
    }
}

class MyException extends RuntimeException {
    public MyException() {}
    public MyException(String msg) {
        super(msg);
    }
}