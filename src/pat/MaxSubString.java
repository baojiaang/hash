package pat;

import java.util.Scanner;

public class MaxSubString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        int result=0;
        int end=0;
        int check[][]=new int[a.length()+1][b.length()+1];
        for(int i=0;i<a.length()+1;i++){
            for(int j=0;j<b.length()+1;j++){
                if(i==0||j==0)
                    check[i][j]=0;
               else if(a.charAt(i-1)==b.charAt(j-1)) {
                    check[i][j] = check[i - 1][j - 1] + 1;
                    if(check[i][j]>result)
                    {
                        result=check[i][j];
                        end=j-1;
                    }
                }
                else
                    check[i][j]=0;
            }
        }
        System.out.println(end);
        System.out.println("length="+result);
        for(int i=end+1-result;i<=end;i++){
            System.out.print(a.charAt(i));
        }
    }
}
