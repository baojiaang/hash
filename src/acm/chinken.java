package acm;

import java.util.Scanner;

public class chinken {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int count=input.nextInt();
            for(int i=0;i<count;i++){
                int chicken=0,rabbit=0;
                int re=0,head=0,foot=0,m,n;
                head = input.nextInt();
                foot = input.nextInt();
                for(m=0;m<=head;m++){
                    n=head-m;
                    if(m*2+n*4==foot){
                        re=1;
                        chicken=m;
                        rabbit=n;
                    }
                }
                if(re == 1)
                {
                    System.out.println(chicken+" "+rabbit);
                }
                else
                {
                    System.out.println("No answer");
                }
            }
        }
    }
}
