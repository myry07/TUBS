package H4.binaerbaum;

public class test {
    public static void main(String[] args) {
        //创建数组
        Pair p0 = new Pair("1");
        Pair p1 = new Pair("4");
        Pair p2 = new Pair("7");
        Pair p3 = new Pair("8");
        Pair p4 = new Pair("13");
        Pair p5 = new Pair("21");
        Pair p6 = new Pair("42");

        Pair[] data = {p0, p1, p2, p3, p4, p5, p6};


        //调用方法
        Element binarybaum = BinaryTreeUtils.createBinaryTree(data, 0 ,7);

        //中序遍历
        BinaryTreeUtils.inorder(binarybaum);
        System.out.println();

        //前序遍历
        BinaryTreeUtils.preorder(binarybaum);
        System.out.println();

        //后续遍历
        BinaryTreeUtils.postorder(binarybaum);
        System.out.println();

        //深度
        System.out.println(BinaryTreeUtils.getHigh(binarybaum));
    }
}
