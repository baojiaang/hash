package acm;

import java.util.ArrayList;
import java.util.Scanner;

public class daffodil {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i = (int) Math.pow(10,n-1); i<Math.pow(10,n); i++)
        {   int number[]=new int[n];
            int sum=0;
            int temp=i;
            for(int j=0;j<n;j++){
                number[j]= (int) (temp%10);
                temp=temp/10;
            }
            for(int j=0;j<n;j++){
                sum= (int) Math.pow(number[j],n)+sum;
            }
            if(sum==i)
                System.out.println(i);
        }
    }
}
