package acm;

import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
          {
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c= (int) Math.pow(2,a);
                int num=b%c;
                System.out.println(num);
            }
        }
    }
}
