package lintcode;

import java.util.Stack;

public class MinStack {
    Stack s=new Stack();
    Stack min=new Stack();
    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        s.push(number);
        if(!min.isEmpty()){
            int temp= (int) min.peek();
            if(temp>=number)
                min.push(number);
        }
        else
            min.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int temp=(int) min.peek();
        if(temp==(int)s.peek())
            min.pop();
        return (int) s.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return (int)min.peek();
    }
}
