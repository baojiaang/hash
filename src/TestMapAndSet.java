import java.util.*;

public class TestMapAndSet {
    public static void main(String[] args) {
        int salary[]={43711, 12231, 61731, 41991, 43441, 96791, 11989};
        String name[]={"张三","李四","王五","校长","哈哈","蛤","包哥"};
        HashMap hm=new HashMap(); //test hash map
        HashSet hs=new HashSet();// test hash set
        TreeMap tm=new TreeMap();//test treemap
        TreeSet ts=new TreeSet();//test tree set
        long startTime=System.currentTimeMillis();
        for(int i=0;i<salary.length;i++){//insert
            hm.put(name[i],salary[i]);

            hs.add(salary[i]);
            tm.put(name[i],salary[i]);
            ts.add(salary[i]);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("time="+(endTime-startTime));
        hm.remove("张三");//delate
        hs.remove(43711);
        tm.remove("李四");
        ts.remove(12231);
        System.out.println(hm); //print hashmap
        System.out.println(hs);//print hashset
        System.out.println(tm);//print treemap
        System.out.println(ts);//print treeset


    }



}
