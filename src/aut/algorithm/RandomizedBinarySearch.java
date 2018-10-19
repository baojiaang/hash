package aut.algorithm;
import java.util.Arrays;
import java.util.Random;

public class RandomizedBinarySearch {
    public int seach2(int target, Integer array[],int start ,int end) {

        if (start>end||target<array[start]||target>array[end]) {
        //  System.out.println("the element not exits in array");
            return -1;
        }
        int i = (int)(start+Math.random()*(end-start+1));  // generate the i between start to end
        if (target == array[i]) {
     //      System.out.println("x is found");
            return i;
        } else if (target<array[i]) {
            return seach2(target, array,start,i-1);
        } else {
            return seach2(target, array,i+1,end);
        }
    }


    public static void main(String[] args) {
        int n=1000;
        Random r = new Random();
        RandomizedBinarySearch rbinarySearch = new RandomizedBinarySearch();
        long times[]=new long[n+1];
        long x[]=new long[n+1];
        for(int m=1;m<=n;m++) {  //start from 1
            long alltime=0;
            for (int i = 0; i < 1000; i++) {//run 1000 different arrays of size n
                Integer a[] = new Integer[m]; // a size is the size of m
                for (int j = 0; j < m; j++) {
                   int random= r.nextInt(m);
                    a[j] = random;
                }
                Arrays.sort(a);
                long start = System.nanoTime();
               rbinarySearch.seach2(a[0], a,0,a.length-1);
                long end = System.nanoTime();
                long time = end - start;
                alltime += time;
            }
            times[m]=alltime/1000;
            x[m]=m;
        }
        GraphingData data=new GraphingData("",x,times);
    }

}
