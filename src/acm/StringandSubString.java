package acm;

import java.util.Scanner;

public class StringandSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String firstLine[] = sc.nextLine().split(" ");
            String s = firstLine[0];
            String t = firstLine[1];
            boolean b[] = new boolean[t.length()];
            for(int i=0,j=0;i<s.length()&&j<t.length();i++){
                if(s.charAt(i)==t.charAt(j))
                {
                    b[j]=true;
                    j++;
                }
            }
            if(b[t.length()-1]==true)
                System.out.println("yes");
            else
                System.out.println("no");
        }

    }
}
