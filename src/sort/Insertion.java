package sort;

public class Insertion extends Example {
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=1;i<N;i++){
            //将 a[i] insert into a[i-1] ,a[i-2] a[i-3] ......之中
            for(int j=i;j>0&&less(a[j],a[j-1]);j--)
            {
                exch(a,j,j-1);
            }
        }
    }
}
