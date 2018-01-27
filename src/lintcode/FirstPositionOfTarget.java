package lintcode;

public class FirstPositionOfTarget {
    public int binarySearch(int[] nums, int target) {
        //write your code here
       if(nums.length==1&&target==nums[0]) return 0;
       int len=nums.length;
       int index=serach(nums,0,len,target);
       return index;

    }
   public int serach(int[] nums,int low,int high,int target) {
       int mid = (low + high) / 2;
       if (nums[low] == target) return low;
       if (low >= high) return -1;
       if (target == nums[mid] && target != nums[mid - 1]) return mid;
       if (target > nums[mid]) return serach(nums, mid + 1, high, target);
       if (target <= nums[mid]) return serach(nums, low, mid, target);
       return -1;
   }
}
