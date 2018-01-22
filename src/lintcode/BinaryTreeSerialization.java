package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {
    public String serialize(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        StringBuffer sb=new StringBuffer();
        queue.offer(root);
        while(queue.isEmpty()==false){
            sb.append(queue.poll().val);
            if(root.left!=null){
                queue.offer(root.left);
            }
            else
                sb.append("#");
            if(root.right!=null){
                queue.offer(root.right);
            }
            else
                sb.append("#");
        }
        String result=sb.toString();
        return result;
    }
    public TreeNode deserialize(String data){
        TreeNode root=new TreeNode(data.charAt(0));
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int size=0;
        int j=1;
        while(!queue.isEmpty()){
            size=queue.size();
            for(int i=0;i<queue.size();i++){
                TreeNode node=queue.poll();
                char temp=data.charAt(j);
                if(temp!='#'){
                    node.left=new TreeNode((int)temp);
                    queue.offer(node.left);
                    j++;
                }
                temp=data.charAt(j);
                if(temp!='#'){
                    node.right=new TreeNode((int)temp);
                    queue.offer(node.right);
                    j++;
                }
            }
        }
        return  root;
    }
}
class TreeNode{
    public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
