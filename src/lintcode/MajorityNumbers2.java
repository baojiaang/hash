package lintcode;

import java.util.List;

public class MajorityNumbers2 {
    public int majorityNumber(List<Integer> nums){
        int candidate1=0;
        int candidate2=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.size();i++){
            if(count1==0){
                candidate1=nums.get(i);
            }
            if(count2==0&&nums.get(i)!=candidate1){
                candidate2=nums.get(i);
            }
            if(nums.get(i)!=candidate1&&nums.get(i)!=candidate2&&count1!=0&&count2!=0){
                count1--;
                count2--;
            }
            if(nums.get(i)==candidate1){
                count1++;
            }
            if(nums.get(i)==candidate2){
                count2++;
            }
        }
       count1=0;
       count2=0;
       for(int cur:nums){
           if (cur==candidate1) count1++;
           else if(cur==candidate2) count2++;
       }
       return count1>count2?candidate1:candidate2;
    }
}
