package pat;

import java.util.*;

public class BeUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

       HashSet<Integer> a=new HashSet();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int m=sc.nextInt();
            if(a.contains(m)){
                if(q.contains(m))
                    q.remove(m);
            }
            else{
                q.add(m);
            }
            a.add(m);
        }
        if(q.size()==0){
            System.out.println("None");
        }
        else
            System.out.println(q.poll());
    }
}
