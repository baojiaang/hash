package acm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class six {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int times=sc.nextInt();
        for(int i=0;i<times;i++){
            int length=sc.nextInt();
            ArrayList<Integer> a=new ArrayList();
            int sum=0;
            for(int j=0;j<length;j++){
           int temp=sc.nextInt();
           a.add(temp);
                 sum=sum+temp;
                }
                int money=sum;
            for(int k=length;k>2;k--){
                a.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return 0;
                    }
                });
                int max=a.get(k-1);
                sum=sum-max;
                money=sum+money;
            }
            System.out.println(money);
        }
    }
}
