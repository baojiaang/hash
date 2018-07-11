package acm;

import java.util.Scanner;

public class Zero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int times=sc.nextInt();
        String array[]=new String[times];
        for(int i=0;i<times;i++){
           String temp=sc.next();
            String a=temp.replace('0','1');
           array[i]=a;
        }
        for (String a:array
             ) {
            System.out.println(a);
        }
    }
}
