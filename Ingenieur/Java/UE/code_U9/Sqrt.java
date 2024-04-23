class CheckedIllegalArgumentException extends Exception{
    public CheckedIllegalArgumentException(){}
    public CheckedIllegalArgumentException(String msg){
        super(msg);
    }
}

public class Sqrt{
    public static double sqrt(double val) throws 
            CheckedIllegalArgumentException{
        if (val < 0){
            throw new CheckedIllegalArgumentException("Negative Zahlen beim Wurzelziehen nicht erlaubt!");
        } else {
            return Math.sqrt(val);
        }
    }

    public static void main(String[] args){
        int val = Integer.parseInt(args[0]);
        try{
            System.out.println("Wurzel aus " + val + " ist " + sqrt(val));
        } catch (CheckedIllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}