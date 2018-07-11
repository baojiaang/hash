package pat;

import java.util.Scanner;

public class Kuchiguse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int same=0;
        String suffix[]=new String[n];
        suffix[0]=sc.nextLine();
        for(int i=0;i<n;i++){
            suffix[i]=sc.nextLine();
            StringBuffer sb=new StringBuffer(suffix[i]);
             String temp=sb.reverse().toString();
           suffix[i]=temp;
        }

        for(int i=0;i+1<suffix.length;i++){ ;
            if(suffix[i].charAt(0)==suffix[i+1].charAt(0))
                same=1;
        }
            if(same==1)
                System.out.println("nyan~");
            else
                System.out.println("nai");
    }
}
