package pat;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Scanner;

public class HighestPriceInSupplyChain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double price=sc.nextDouble();
        double percentage=sc.nextDouble();
        int array[]=new int[n];
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            array[i]=value;

        }
        int maxlevel=0; int level;
        int times=0;
        int x;
        for(int i=0;i<n;i++) {
            if (visited[i] == false) {
                visited[i] = true;
                x = i;
                level = 0;
                while (array[x] != -1) {
                    visited[x] = true;
                    x = array[x];
                    level++;
                }
                if (level > maxlevel) {
                    maxlevel = level;
                    times = 1;
                } else if (maxlevel == level) {
                    times++;
                }
            }

        }
        for(int i=0;i<maxlevel;i++){
            price=price*(1+percentage/100);
        }
        System.out.printf("%.2f"+" "+"%d",price,times);
    }

}

