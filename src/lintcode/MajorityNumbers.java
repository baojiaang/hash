package lintcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MajorityNumbers {
    public int majorityNumber(List<Integer> nums){
        //HashMap<Integer,Integer> h=new HashMap<Integer, Integer>();
      //  h.put(nums.get(0),1);
        Collections.sort(nums);
        return nums.get((0+nums.size())/2);
    }
}
