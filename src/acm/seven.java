package acm;

import java.util.Scanner;

public class seven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int time=sc.nextInt();
        for(int i=0;i<time;i++){
            String temp=sc.next();
            int length=temp.length();
            if(temp.length()==5)
                System.out.println(3);
          else{ int mark=0;
            if(temp.charAt(0)=='o')
                mark++;
            if(temp.charAt(1)=='n')
                mark++;
            if(temp.charAt(2)=='e')
               mark++;
            if(mark>=2)
                System.out.println(1);
            else
                System.out.println(2);}
        }
    }
}
