package H4.binaryjianyiban;

public class test {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");

        a.setLeft(b);
        a.setRight(c);

        b.setLeft(d);
        b.setRight(e);

        d.setLeft(h);

        c.setLeft(f);
        c.setRight(g);

        inorder(a);
        System.out.println();
        preorder(a);
        System.out.println();
        postorder(a);
    }

    //中序
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root + " ");
            inorder(root.right);
        }
    }

    //前序
    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    //后序
    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root + " ");
        }
    }
}
