package acm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class AnAwfulInstructor {
    public static void main(String[] args) {
        PriorityQueue<Integer> p=new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        String a="NEXT ONE";
        String temp;
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            temp=sc.nextLine();
            if(temp.equals(a))
            {
                if(p.size()>0)
                    System.out.println(p.poll());
            }
            else{
                Integer cur=Integer.parseInt(temp);
                p.add(cur);
            }

        }
    }
}
