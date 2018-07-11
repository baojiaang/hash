package lintcode;

public class NextPermutation {
    //Revers the given part of a int[]
    public int[] reverse(int start, int end, int[] nums) {
        for (int i = start, j = end; i < j; i++,j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        //Find last increasing point before decreasing. nums[k] < nums[k+1]
        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return reverse(0, nums.length - 1, nums);
        }
        //Find first bigger point, from right to left
        int bigIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[k]) {
                bigIndex = i;
                break;
            }
        }
        //1. Swap bigger index with k; 2. Reverse the right side of k. [Try to make the smallest next permutation]
        int temp = nums[k];
        nums[k] = nums[bigIndex];
        nums[bigIndex] = temp;

        return reverse(k + 1, nums.length - 1, nums);
    }
}
