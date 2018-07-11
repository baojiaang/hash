package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindAwesomeNumber {
    public int number(int n){
        ArrayList a=new ArrayList();
        Stack s=new Stack();
        for (int i=2;i<=n;i++){
            if(n%i==0){
              a.add(i);
                s.push(i);
            }
        }
        for(int i=0;i<a.size();i++){
            int temp= (int) a.get(i);
            int last= (int) s.peek();
            if(last%(temp*temp)==0){
                s.pop();
                i=0;
            }

        }
        return (int)s.peek();
    }
    public static void main(String[] args) {
        FindAwesomeNumber f=new FindAwesomeNumber();
        System.out.println(f.number(12));
    }
}
