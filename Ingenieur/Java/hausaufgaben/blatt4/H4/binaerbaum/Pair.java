package H4.binaerbaum;

public class Pair implements Comparable<Pair> {
    int key;
    String val;
    static int count = 0;

    public Pair(String val) {
        this.key = count++;
        this.val = val;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public int compareTo(Pair obj) {
        return this.key - obj.key;
    }

}
