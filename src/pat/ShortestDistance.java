package pat;

import java.util.Scanner;

public class ShortestDistance {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        int all=0;
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
            all=array[i]+all;
        }
        int clockwise[]=new int[n+1];

        for(int  i=2;i<=n;i++){
            clockwise[i]=array[i-2];
            clockwise[i]=clockwise[i]+clockwise[i-1];
        }
        clockwise[1]=0; clockwise[0]=0;
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int clock=clockwise[b]-clockwise[a];
            clock=Math.abs(clock);
            int anticlock=all-clock;
          System.out.println((clock>anticlock)?anticlock:clock);
        }
    }

}
