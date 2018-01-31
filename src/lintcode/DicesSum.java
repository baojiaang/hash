package lintcode;

import java.util.*;

public class DicesSum {
    public List<Map.Entry<Integer,Double>> dicesSum(int n){
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>>list=new ArrayList<Map.Entry<Integer,Double>>(5*n+1);
        Double pro=0.0;//概率
        double total=Math.pow(6, n);
        double conditions=0;    //刚开始我用的int，发现计算结果又精度问题，改成long还是有精度问题，最后改成double就没问题了
        //但严格来说，情况数应该是整数，是没问题的，计算过程中没有出现溢出的情况，total已经是double了，
        //难道 1/1.0 根1.0/1.0不一样？
        HashMap<String,Double> hashMap=new HashMap<>();
        for(int i=n;i<=6*n;i++){
            pro=0.0;
            conditions=findCombs(i, n,hashMap);
            pro=conditions/total;
            list.add(new AbstractMap.SimpleEntry<Integer, Double>(i,pro));
        }

        return list;
    }
    public static double findCombs(int num,int n,HashMap<String, Double>hashMap){
        //为了简化计算，假设每个骰子最小值为0，最大值为5，共n个骰子
        double total=0;
        String key=String.valueOf(num)+","+String.valueOf(n);
        if(hashMap.containsKey(key)){
            return hashMap.get(key);
        }

        if(num<=0){
            if(n>=1)
                total=0;
            else
                total=1;//0 个骰子得到0 是可以的
        }
        else{
            //num >0
            if(n<1){
                total=0;
            }
            else if(n==1){
                if(num>6){
                    total=0;
                }
                else{
                    total=1;
                }
            }
            else{
                int ceil=num<=6?num:6;
                for(int i=1;i<=ceil;i++){
                    total+=findCombs(num-i, n-1,hashMap);
                }
            }
        }
        hashMap.put(key, total);
        return total;
    }
}
