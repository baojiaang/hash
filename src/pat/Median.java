package pat;

import java.math.BigInteger;
import java.util.Scanner;

public class Median {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

       int first[]=new int[n];
        for(int i=0;i<n;i++){
            first[i]=(sc.nextInt());
        }
        int m=sc.nextInt();
       int second[]=new int[m];
       int result[]=new int[m+n];
        for(int i=0;i<m;i++){
            second[i]=(sc.nextInt());
        }
        int i=0,j=0,k=0;
        for(;i<first.length&&j<second.length;){
            if(first[i]<second[j])
                result[k++]=first[i++];
            else  if(first[i]==second[j]){
                result[k++]=first[i++];
                result[k++]=second[j++];
            }
            else
                result[k++]=second[j++];

        }
        while(i<first.length){
            result[k++]=first[i++];
        }
        while(j<second.length){
            result[k++]=second[j++];
        }

        System.out.println(result[(m+n-1)/2]);
    }
}
