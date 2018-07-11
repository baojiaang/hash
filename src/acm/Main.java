package acm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] firstLine =sc.nextLine().split(" ");
        int  n =Integer.parseInt(firstLine[0]);
        char c =firstLine[1].charAt(0);

        int i=1;
        for(;;i++){
            if(n<2*(i+1)*(i+1)-1){
                break;
            }
        }
        for(int j=i;j>0;j--){
            for(int blank=i-j;blank>0;blank--){
                System.out.print(" ");
            }
            for(int count=j*2-1;count>0;count--){
                System.out.print(c);
            }
            System.out.println();
        }

        for(int j=2;j<=i;j++){
            for(int blank=i-j;blank>0;blank--){
                System.out.print(" ");
            }
            for(int count=j*2-1;count>0;count--){
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println(n-(2*i*i-1));
    }
}
