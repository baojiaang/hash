package lintcode;



public class BalancedBinaryTree {
    /*
         * @param root: The root of binary tree.
         * @return: True if this Binary tree is Balanced, or false.
         */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return depth(root)!=-1;
    }
    int depth(TreeNode root){
        if(root==null)
            return 0;
        int left=depth(root.left);
        int right=depth(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}
