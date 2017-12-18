package sort;

public class Merge extends Example {
    private static Comparable[] aux;  // 归并所需的数组
    public static void sort(Comparable[] a){
        aux=new Comparable[a.length]; //一次性分配空间
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        // 将数组 a[lo..hi]排序
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);  //  sort the left
        sort(a,mid+1,hi);  //  sort the right
        merge(a,lo,mid,hi);   //  merge the result
    }
    public static void merge(Comparable[] a,int lo,int mid,int hi){
           // merge a[lo ..mid] and a[mid+1 .. hi]
        int i=lo,j= mid+1;
        for(int k=lo;k<=hi;k++){
            aux[k]=a[k];   // copy a[lo.. hi] to aux[lo ..hi]
        }
        for(int k=lo;k<=hi;k++)// merge back to thea[lo..hi]
        if(i>mid)
            a[k]=aux[j++];
            else if(j>hi)
                a[k]=aux[j++];
            else if(less(aux[j],aux[i]))
                a[k]=aux[j++];
            else
                a[k]=aux[i++];

    }
    public static void main(String[] args) {
        Comparable a[]={2,5,7,38,1,5,66};
        sort(a);
        show(a);

    }

    }




