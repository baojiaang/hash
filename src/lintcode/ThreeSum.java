package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                continue;
            }
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] == 0) {
                    final Integer[] intarr = {nums[start], nums[end], nums[i]};
                    result.add(Arrays.asList(intarr));
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                } else if (nums[start] + nums[end] + nums[i] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
