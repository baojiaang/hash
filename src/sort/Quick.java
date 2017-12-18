package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int j=partition(a,lo,hi);  //切分
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static void show(Comparable[] a) {
        for(int i=0;i<a.length;i++) {
            StdOut.print(a[i]+" ");
            StdOut.println();
        }
    }
    private  static int partition(Comparable[] a,int lo,int hi){
        //  将数组 切分 为 a[lo..i-1] ,a[i],a[i+1..hi]
        int i=lo,j=hi+1; // 左右扫描指针
        Comparable v=a[lo];
        while(true){
            while(less(a[++i],v)) if(i==hi) break;
            while (less(v,a[--j]))if(j==lo) break;
            if(i>= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return  j;

    }
    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j) {
        Comparable t =a[i]; a[i] =a[j] ;a[j] =t;
    }

    public static void main(String[] args) {
        Comparable a[]={2,5,7,38,1,5,66};
        sort(a);
        show(a);

    }

}
