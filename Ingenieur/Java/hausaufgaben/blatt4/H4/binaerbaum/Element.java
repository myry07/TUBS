package H4.binaerbaum;

public class Element {
    Element left;
    Element right;
    Element parent;
    Pair pair;

    public Element(Pair pair) {
        this.pair = pair;
    }

    public Element getLeft() {
        return left;
    }

    public void setLeft(Element left) {
        this.left = left;
    }

    public Element getRight() {
        return right;
    }

    public void setRight(Element right) {
        this.right = right;
    }

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }

    public String toString() {
        return pair.val;
    }
}
