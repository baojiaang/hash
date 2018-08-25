package pat;

import java.util.Arrays;
import java.util.Scanner;

public class CompleteBinarySearchTree {
    static int b[]=new int[1005];
    static int j=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        mid_tre(1,n,a);
        System.out.print(b[1]);
        for(int i=2;i<=n;i++){
            System.out.print(" "+b[i]);
        }
    }
    public static void mid_tre(int root,int n,int a[]){
        if(root<=n){
            mid_tre(2*root,n,a);
            b[root]=a[j++];
            mid_tre(2*root+1,n,a);
        }
    }
}
