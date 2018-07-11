package pat;

import java.util.ArrayList;
import java.util.Scanner;

public class APlusBFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
           Integer c=a+b;
            int length=c.toString().length();
            String print=c.toString();
            for(int i=0,count=1;i<length;i++,count++){
                System.out.print(print.charAt(i));
              if(print.charAt(i)=='-')
                  continue;
                if(count%3==length%3&&i!=length-1)
                    System.out.print(",");
            }
        }
    }
}
