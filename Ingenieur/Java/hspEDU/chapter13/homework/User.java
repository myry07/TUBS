package chapter13.homework;

public class User {
    private String Name;
    private String password;
    private String mail;

    public User(String name, String password, String mail) {
        Name = name;
        this.password = password;
        this.mail = mail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
