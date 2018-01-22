package sort;

public class Insert {
   public static void insertSort(Integer a[]){
       for(int i=1;i<a.length;i++){
           for(int j=i;j>0&&a[j].compareTo(a[j-1])<0;j--)
               swapReference(a,j,j-1);
       }
   }
   public static void swapReference(Integer a[],int i,int j){
        Integer temp=a[j];
        a[j]=a[i];
        a[i]=temp;
   }

    public static void main(String[] args) {
        Integer a[]={5,6,1};
        insertSort(a);
        for (int b:a
             ) {
            System.out.println(b);
        }
    }

}
