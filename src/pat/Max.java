package pat;

import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int sum=0;
        int temp=Integer.MIN_VALUE;
       int low=0,high=a.length-1;
       int start=0;
            for(int i=0;i<a.length;i++){
                sum=sum+a[i];
                if(sum>=0){
                    if(sum>temp) {
                        temp = sum;
                        low = start;
                        high = i;
                    }

                }
                else{
                    sum=0;
                    start=i+1;
                }
            }
            if(temp<0)
                temp=0;

        System.out.println(temp+" "+a[low]+" "+a[high]);
    }
}


