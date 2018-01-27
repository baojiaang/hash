package lintcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n){
        List<String> l=new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0)
                l.add("fizz buzz");
                else if(i%3==0)
                    l.add("fizz");
                else if(i%5==0)
                    l.add("buzz");
                else
                    l.add(String.valueOf(i));

        }
        return l;
    }
}
