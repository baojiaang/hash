package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /*
    * @param root: A Tree
    * @return: Level order a list of lists of integer
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> l=new ArrayList<>();
        q.add(root);
        if(root==null)
            return l;
        while(!q.isEmpty())
        {
          int count=q.size();
          List<Integer> temp= new ArrayList<>();
            for(int i=0;i<count;i++){
                TreeNode node=q.poll();
                temp.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            } //   after for loop
            l.add(temp);
        }//stop while
        return l;
    }
}
