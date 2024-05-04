package chapter13.StringBuffer;

/**
 * @author myry
 * @date 2024-17-29 15:17
 * StringBUffer <-> String
 */

@SuppressWarnings({"all"})
public class strBuffer02 {
    public static void main(String[] args) {
        //1.
        String str = "hello tom";
        StringBuffer stringBuffer = new StringBuffer(str);

        //2.
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        //1.
        StringBuffer stringBuffer2 = new StringBuffer("hsp");
        String string = stringBuffer2.toString();

        //2.
        String  s = new String(stringBuffer2);

        System.out.println(str);
        System.out.println(stringBuffer);


        StringBuffer sb = new StringBuffer("hello");
        //sb.append("hui").append(true).append(10);
        //sb.replace(1,4,"666");
       // System.out.println(sb.indexOf("h"));
        sb.insert(3, "e");
        System.out.println(sb);
    }
}
