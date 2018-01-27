package lintcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        if(nums==null)
            return result;
        boolean[] visited=new boolean[nums.length];
        permutationHelper(nums,result,temp,visited);
        return result;
    }
    public void permutationHelper(int[] nums,List<List<Integer>> result,List<Integer> temp,boolean[] visited){
        if(temp.size()==nums.length)
        {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited [i]){
                visited[i]=true;
                temp.add(nums[i]);
                permutationHelper(nums,result,temp,visited);
                temp.remove(temp.size()-1); //递归结束删除 尾部元素
                visited[i]=false;
            }
        }
    }

}
