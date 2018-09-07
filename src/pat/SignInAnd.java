package pat;

import java.util.Scanner;

public class SignInAnd {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String first=""; String last="";
        int start=0; int end=0;

        for(int i=0;i<n;i++){
            String id=sc.next();
            String startTime=sc.next();
            String endTime=sc.next();
            String starts[]=startTime.split(":");
            String ends[]=endTime.split(":");
            int curstart=0; int curend=0;
            int shour= Integer.parseInt(starts[0])*3600;
            int ehour= Integer.parseInt(ends[0])*3600;
            int smin=Integer.parseInt(starts[1])*60;
            int emin=Integer.parseInt(ends[1])*60;
            int ssecends=Integer.parseInt(starts[2]);
            int esecends=Integer.parseInt(ends[2]);
            curstart=shour+smin+ssecends;
            curend=ehour+emin+esecends;
            if(start==0&&end==0){
                start=curstart;
                end=curend;
                first=id;
                last=id;
            }
            if(curstart<start){
                start=curstart;
                first=id;
            }
            if(curend>end){
                end=curend;
                last=id;
            }
        }
        System.out.println(first+" "+last);
    }
}
