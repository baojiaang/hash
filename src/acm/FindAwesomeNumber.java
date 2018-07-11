package acm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class FindAwesomeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList a=new ArrayList();
        Stack s=new Stack();
        while(sc.hasNext()){
            int temp=sc.nextInt();
            for(int i=2;i<=temp;i++){
                if(temp%i==0)
                {
                    a.add(i);
                    s.push(i);
                }
            }
            for(int i=0;i<a.size();i++){
                int cur= (int) a.get(i);
                int last= (int) s.peek();
                if(last%(cur*cur)==0){
                    i=0;
                    s.pop();
                }
            }
            System.out.println((int)s.peek());
        }
    }
}
