package lintcode;

import java.util.*;

public class SingleNumber {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        HashSet<Integer> s1=new HashSet<>();
        for(int i=0;i<A.length;i++){
            if(!s1.contains(A[i]))
            {
                s1.add(A[i]);
            }
            else
                s1.remove(A[i]);
        }
        Iterator it=s1.iterator();
        return (int) it.next();
    }
}
