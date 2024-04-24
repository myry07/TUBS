package chapter13.homework;

/**
 * @author myry
 * @date 2024-12-30 16:12
 * <p>
 * 登陆界面 输入用户名 密码 邮箱
 * 如果全对 显示成功 错误 抛出异常
 * <p>
 * 用户名长度为 2，3，4
 * 密码为6位 全数字
 * 邮箱包括@ .
 */

@SuppressWarnings({"all"})
public class h2einlogen {
    public static void main(String[] args) {
        User user = new User("www", "123433", "www@l.com");

        try {
            einlogen(user);
        } catch (MyException me) {
            System.out.println(me.getMessage());
        }
    }

    public static void einlogen(User user) throws MyException{
        if (user.getName().length() > 4 || user.getName().length() < 2) {
            throw new MyException("name error");
        }

        if (user.getPassword().length() != 6) {
            throw new MyException("password len error");
        }
         for (int i = 0; i < user.getPassword().length(); i++) {
            int count = -1;
            switch (user.getPassword().charAt(i)) {
                case '0':
                    count = 0;
                    break;
                case '1':
                    count = 0;
                    break;
                case '2':
                    count = 0;
                    break;
                case '3':
                    count = 0;
                    break;
                case '4':
                    count = 0;
                    break;
                case '5':
                    count = 0;
                    break;
                case '6':
                    count = 0;
                    break;
                case '7':
                    count = 0;
                    break;
                case '8':
                    count = 0;
                    break;
                case '9':
                    count = 0;
                    break;
                default:
                    count = -1;

            }
            if (count == -1) {
                throw new MyException("password error");
            }
        }

        int temp = -1;
        int res = -1;
        for (int i = 0; i < user.getMail().length(); i++) {
            if(user.getMail().charAt(i) == '@') {
                temp = 0;
            }

            if(temp != -1 && user.getMail().charAt(i) == '.') {
                res = 0;
            }

        }

        if(res == -1) {
            throw new MyException("mail error");
        }

        System.out.println("erfolg");
    }

}


class MyException extends RuntimeException {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}