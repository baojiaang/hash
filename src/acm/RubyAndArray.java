package acm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RubyAndArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int mark=0;
            int mark2=0;
            boolean same=false;
            int n=sc.nextInt();
            ArrayList<Integer> a=new ArrayList();
            ArrayList<Integer> b=new ArrayList<>();
            ArrayList<Integer> c=new ArrayList<>();
            for(int i=0;i<n;i++){
                int cur=sc.nextInt();
                a.add(cur);
                b.add(cur);
                c.add(cur);
            }
            a.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            Collections.sort(c);
            for(int i=0;i<a.size();i++){
                if(i+1<a.size())
                if(a.get(i+1)==a.get(i))
                same=true;
                if(a.get(i)!=b.get(i))
                    mark++;
                if(c.get(i)!=b.get(i))
                    mark2++;
            }
            if((mark<=2&&same)||mark2<=2)
                System.out.println("YES");
           else
                System.out.println("NO");
        }
    }
}
