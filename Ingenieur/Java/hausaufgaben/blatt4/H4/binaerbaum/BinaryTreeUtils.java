package H4.binaerbaum;

final public class BinaryTreeUtils {
    private BinaryTreeUtils() {}

    /**
     *
     *传入数组 索引范围: 数组的[左,右)
     *
     */

    public static Element createBinaryTree(Pair[] data, int left, int right) {
        //如果left == right : 没有树枝
        if(left == right) {
            return null;
        }


        //得到中间索引 并且创建树根
        int mid = (left + right) / 2;
        Element ex = new Element(data[mid]);


        //采用递归思想 完成左右树枝
        Element el = createBinaryTree(data, left, mid);
        Element er = createBinaryTree(data, mid + 1, right);

        //完善指针
        if(el != null) {
            el.parent = ex;
            ex.left = el;
        }

        if(er != null) {
            er.parent = ex;
            ex.right = er;
        }

        //返回树根
        return ex;
    }

    //中序遍历
    public static void inorder(Element root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root + " ");
            inorder(root.right);
        }
    }

    //前序遍历
    public static void preorder(Element root) {
        if (root != null) {
            System.out.print(root + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    //后序遍历
    public static void postorder(Element root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root + " ");
        }
    }

    //树的深度
    //左节点和右节点的最大值 + 1
    public static int getHigh(Element root) {
        if(root != null) {
            return Math.max(getHigh(root.left), getHigh(root.right)) + 1;
        }
        return 0;
    }



}
