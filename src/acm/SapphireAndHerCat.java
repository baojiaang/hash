package acm;

import java.util.Scanner;

public class SapphireAndHerCat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int days=sc.nextInt();
            int food[]=new int[days];
            int money[]=new int[days];
            for(int j=0;j<days;j++){
                food[j]=sc.nextInt();
                money[j]=sc.nextInt();
            }
            int min;
            int sum=food[0]*money[0];
            min=money[0];
            for(int i=1;i<days;i++){
                if(money[i]<min)
                {
                    min=money[i];
                }
                sum=sum+food[i]*min;

            }
            System.out.println(sum);
        }
    }
}
