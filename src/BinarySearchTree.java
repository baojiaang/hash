import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinarySearchTree< AnyType extends Comparable<? super AnyType> > {

    BinaryNode BnaryNode;

    /**
     * Construct the tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        root = insert(x, root);
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        root = remove(x, root);
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return smallest item or null if empty.
     */

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item of null if empty.
     */
    public AnyType findMax() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return findMax(root).element;
    }

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)/* Create and return a one-node tree */
            return new BinaryNode<>(x, null, null);

        /* If there is a tree */
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ;  // Duplicate; do nothing
        return t; /* Do not forget this line!! */
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t;   // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        //recursive version
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);

        //iterative version


    }
    public int count2(BinaryNode<AnyType> root) {
        int count2=0;//作为计数
        if(root!=null) {
            if(root.left==null&&root.right==null) //如果当前节点的左节点 右节点都为空
            {count2++;}//那么当前节点为叶子节点
            count2(root.left);//进行递归调用
            count2(root.right);//进行递归调用
        }
        return count2;

    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the subtree.
     */
    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    /**
     * Internal method to compute height of a subtree.
     *
     * @param t the node that roots the subtree.
     */
    private int height(BinaryNode<AnyType> t) {
        if (t == null)
            return -1;
        else
            return 1 + Math.max(height(t.left), height(t.right));
    }
    public ArrayList<AnyType> preorderTraversal(BinaryNode root){
        ArrayList<AnyType> result=new ArrayList<AnyType>();
        if(root == null){
            return result;
        }
        ArrayList<AnyType> left=preorderTraversal(root.left);
        ArrayList<AnyType> right=preorderTraversal(root.right);
        result.add((AnyType) root.element);
        result.addAll(left);
        result.addAll(right);
        return result;
    }


    // Basic node stored in unbalanced binary search trees
    public static class BinaryNode<AnyType> {
        // Constructors
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child

        BinaryNode() {

        }


    }


    /**
     * The tree root.
     */
    private BinaryNode<AnyType> root;




    private static class UnderflowException extends Exception {

        public UnderflowException() {
        }
    }

    public int leafNum(BinarySearchTree.BinaryNode node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                return 1;
            }
            return leafNum(node.left) + leafNum(node.right);
        }
        return 0;
    }

    //中序遍历
    public void SelectTree( BinaryNode node) {
  if(node!=null){
      SelectTree(node.left);
      System.out.print(node.element);
      SelectTree(node.right);
  }
    }

    //先序遍历
    public void SelectTree1( BinaryNode node) {
    if(node!=null){
        System.out.print(node.element);
        SelectTree1(node.left);
        SelectTree1(node.right);
    }

    }

    //后序遍历
    public void SelectTree2( BinaryNode node) {
        if(node!=null){
            SelectTree2(node.left);
            SelectTree2(node.right);
            System.out.print(node.element);
        }

    }
    public List<Integer> inorderTraversal(BinaryNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        BinaryNode node = root;
        //Initialize
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        //iteratively add && process via inorder traversal
        while (!stack.isEmpty()) {
            node = stack.pop();
            rst.add((Integer) node.element);
            if (node.right != null) {//process right, but put right's left children on top of stack
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

        }
        return rst;
    }

//    public ArrayList<Integer> preorderTraversal(BinaryNode root) {
//        ArrayList<Integer> rst = new ArrayList<Integer>();
//        if (root == null) {
//            return rst;
//        }
//        Stack<BinaryNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node != null) {
//                rst.add(node.val);
//                stack.push(node.right);
//                stack.push(node.left);
//            }
//        }
//        return rst;
//    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();

        b.insert(3);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(9);
        b.insert(7);
        b.insert(5);
        b.insert(2);
        b.printTree();

        System.out.println("--------叶子节点个数----------");

        System.out.println(b.count2(b.root));
        System.out.println("--------中序遍历----------");
        b.SelectTree(b.root);


        System.out.println("--------先序遍历----------");
        b.SelectTree1(b.root);
        System.out.println("--------后序遍历----------");
        b.SelectTree2(b.root);


    }
}








