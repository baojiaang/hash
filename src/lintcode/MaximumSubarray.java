package lintcode;

import java.util.ArrayList;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int count = 0;
        int max =Integer.MIN_VALUE;
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        //  int res=0;
        //  ArrayList<Integer> a=new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            count = Math.max(nums[i], count + nums[i]);
            max = Math.max(max, count);
        }
        return max;
    }
}
