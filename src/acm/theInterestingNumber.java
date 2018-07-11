package acm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class theInterestingNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(sc.hasNext()){
            double l=0,r=0,cout=0;
                l=sc.nextDouble();
               r=sc.nextDouble();
               int m=0;
               while(Math.pow(2,m)<r)
                   m++;
               int n=0;
               while (Math.pow(3,n)<r)
                   n++;
            TreeSet<Double> t=new TreeSet<>();
            for(int x=0;x<19
                    ;x++)
                for(int y=0;y<18;y++)
                {
                    t.add(Math.pow(2,x)*Math.pow(3,y));
                }
            Iterator it=t.iterator();
            while(it.hasNext()) {
                double i= (double) it.next();
                for (int x = 0, y = 0; x < m; x++) {
                    for (y = 0; y < n; y++)
                        if (i == Math.pow(2, x) * Math.pow(3, y))
                            cout++;
                }
            }
            System.out.println((int)cout);
        }
    }
}
