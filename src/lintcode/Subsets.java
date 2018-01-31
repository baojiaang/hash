package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
  public List<List<Integer>> subsets(int[] nums){
      List<List<Integer>> res= new ArrayList<List<Integer>>();
      ArrayList<Integer> list=new ArrayList<Integer>();
      Arrays.sort(nums);

      dfs(res,list,nums,0);
      return res;
  }
  public void dfs(List<List<Integer>> res,ArrayList<Integer> list,int nums[],int index){
      res.add(new ArrayList<>(list));
      for(int i=index;i<nums.length;i++){
          list.add(nums[i]);
          dfs(res,list,nums,i+1);
          list.remove(list.size()-1);
      }
  }



}
