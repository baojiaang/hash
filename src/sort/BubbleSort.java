package sort;

import static sort.Example.exch;
import static sort.Example.less;

public class BubbleSort {
    public static void sort(int a[]){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j+1]<a[j]) {
                    int temp = a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[]={1,355,7};
        BubbleSort.sort(a);

    }
}
