package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(res, temp, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, ArrayList<Integer> temp, int nums[], int index) {
        if(!res.contains(temp))
        {
            res.add(new ArrayList<Integer>(temp));
        }
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}