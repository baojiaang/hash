package pat;

import java.util.*;

public class ShufflingMachine {
    public static void main(String[] args) {
        TreeMap<Integer,String> map=new TreeMap<>();
        TreeMap<Integer,String> map2=new TreeMap<>();
        String card[]={"S","H","C","D"};
        for(int j=1;j<=4;j++) {
            for (int i = 1; i <= 13; i++) {
                StringBuffer sb= new StringBuffer();
                sb.append(card[j-1]);
                sb.append(String.valueOf(i));
                String nowCard=sb.toString();

                map.put(i+(j-1)*13,nowCard);
            }
        }
        map.put(53,"J1");
        map.put(54,"J2");
        Scanner sc=new Scanner(System.in);
        int times=sc.nextInt();
        int array[]=new int[54];
        for(int i=0;i<54;i++){
            array[i]=sc.nextInt();
        }
        for(int i=0;i<times;i++){
             map2=new TreeMap<>();
            for(int j=0;j<array.length;j++){
                int change=array[j];
                String s=map.get(j+1);
                map2.put(change,s);
            }
            map=new TreeMap<>(map2);
        }


        Iterator<java.util.Map.Entry<Integer, String>> it=map2.entrySet().iterator();
        Map.Entry<Integer, String> i=it.next();
        System.out.print(i.getValue());
        while (it.hasNext()){
            Map.Entry<Integer, String> entry=it.next();
            System.out.print(" "+entry.getValue());

        }


    }
}
