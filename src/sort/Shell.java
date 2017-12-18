package sort;

import static sort.Example.exch;
import static sort.Example.less;

public class Shell {
    public static void sort(Comparable[] a){
        int N=a.length;
        int h=1;
        while(h<N/3)
            h=3*h+1;
        while(h>=1){
            for(int i=h;i<N;i++){
                //将 a[i] 插入到 a[i-h],a[i-2h]  ,a[i-3h]
                for (int j=i;j>=h&&less(a[j],a[j-h]);j=j-h)
                {
                    exch(a,j,j-h);
                }
                    h=h/3;
            }
        }
    }
}
