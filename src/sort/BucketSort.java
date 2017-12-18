package sort;

public class BucketSort {
    public static void sort(int [] A,int M){
        //M is the max number in A
        int [] count=new int[M+1];
        for(int i=0;i<A.length;i++)
        {
            count[A[i]]++;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]!=0)
                System.out.println(i);
        }

    }

    public static void main(String[] args) {
        int a[]={1,66,88,7,5,4,77};
        BucketSort.sort(a,88);
  }

}
