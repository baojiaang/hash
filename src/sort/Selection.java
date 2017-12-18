package sort;

public class Selection extends Example {
    public static void sort(Comparable[] a){
        int N=a.length;  // length of array
        for(int i=0;i<N;i++){
            //change the min element in a[i] between a[i+1..N]
            int min=i;
            for(int j=i+1;j<N;j++)
                if(less(a[j],a[min])) min =j;
            exch(a,i,min);
        }
    }
}
