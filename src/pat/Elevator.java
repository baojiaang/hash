package pat;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int time=0;
        int nowFloor=0;
        for(int i=0;i<n;i++){
            int destination=sc.nextInt();
            if(destination>nowFloor){
                time=(destination-nowFloor)*6+5+time;
            }
           else{
                time=(nowFloor-destination)*4+5+time;
            }
            nowFloor=destination;

        }
        System.out.println(time);
    }
}
