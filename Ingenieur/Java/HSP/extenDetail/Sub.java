package extenDetail;

public class Sub extends Base {
    public Sub() {//无参
        super("wxl", 6);
        System.out.println("Sub");
    }

    public Sub(String name) {//有参
        super(name);
        System.out.println("Sub有参");
    }
    public void sayOk() {
        System.out.println("n1= " + n1 + " n2= " + n2 + " n3= " + n3);
        getN4();
        getTest400();

    }


}
