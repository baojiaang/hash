package lintcode;

import java.util.ArrayList;
import java.util.List;

public class SearchRangeInBinaryTree {
    public List<Integer> searchRange(TreeNode root,int k1,int k2){
        List<Integer> l=new ArrayList<Integer>();
        if(root!=null){
            searchRange(root.left,k1,k2);
            if(root.val<=k2&&root.val>=k1){
                l.add(root.val);
            }
            searchRange(root.right,k1,k2);
        }
        return l;
    }
}
