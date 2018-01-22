package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class kthLargestElement {
    public int kthLargestElement(int k,int[] nums){
        List l=new ArrayList();
        for(int i:nums){
            l.add(i);
        }
        Collections.sort(l,new MyComparable());
        Collections.sort(l);
        return (int) l.get(k-1);
    }

    public static void main(String[] args) {
        kthLargestElement k=new kthLargestElement();
        int[] nums={1,5,7,2,6,9};

        System.out.println(k.kthLargestElement(3,nums));
    }


}
class MyComparable implements Comparator<Integer> {
    @Override
    public int compare(Integer o1,Integer o2){
        return  o2.compareTo(o1);
    }
}
