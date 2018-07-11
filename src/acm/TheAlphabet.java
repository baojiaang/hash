package acm;

import java.util.*;

public class TheAlphabet {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String test[]=new String[n];
        for(int i=0;i<n;i++){
            test[i]=sc.next();
            HashSet<Character> h=new HashSet<>();
            ArrayList<Character> a=new ArrayList<>();
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<test[i].length();j++){
                if(!h.contains(test[i].charAt(j))) {
                    h.add(test[i].charAt(j));
                }
            }
           Iterator it=h.iterator();
            while(it.hasNext())
                a.add((Character) it.next());
            a.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1.compareTo(o2);
                }
            });
            for (Character c:a
                 ) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
