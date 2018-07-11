package pat;

import java.text.DecimalFormat;
import java.util.*;

public class AplusBForPolynomials {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DecimalFormat decimalFormat=new DecimalFormat("##0.0");

        TreeMap<Integer,Double> map=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            Integer exp=sc.nextInt();
            double coe=sc.nextDouble();
            map.put(exp,coe);
        }
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            Integer exp=sc.nextInt();
            double coe=sc.nextDouble();
            if(map.containsKey(exp)) {
                String d=decimalFormat.format(map.get(exp)+coe);
                map.put(exp,Double.parseDouble(d));
            }
            else
                map.put(exp,coe);
            if(map.get(exp)==0)
                map.remove(exp);
        }
    //    System.out.println(map.size()+" ");
        Set<Integer> keyset=map.keySet();
        Iterator<Integer> it=keyset.iterator();
        System.out.print(map.size());
        while(it.hasNext()){
            Integer i=it.next();
            System.out.print(" "+i+" "+map.get(i));
        }
    }
}
