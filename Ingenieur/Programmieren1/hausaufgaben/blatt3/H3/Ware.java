package H3;

public class Ware {
    private int id;
    private String name;
    private int price;

    public Ware() {

    }

    public Ware(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //<-----------get&set----------->
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "商品: " + this.name + '\t' + "ID: " + this.id + '\t' + "价格: " + this.price;
    }
}
