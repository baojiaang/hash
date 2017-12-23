package sort;

public class SortTest {
    private static int N=10000; //N 为随机数的个数
    public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )  //交换两个数字
    {
        AnyType tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }
    public static void permute( Object [ ] a )  //打乱数字排序
    {
        Random r = new Random( );

        for( int j = 1; j < a.length; j++ )
            Sort.swapReferences( a, j, r.randomInt( 0, j ) );
    }

    public static void main(String[] args) { //生成8个一样的数组 确保 数据的相同
   Integer array[]=new Integer[N];
   Integer array2[]=new Integer[N];
   Integer array3[]=new Integer[N];
   Integer array4[]=new Integer[N];
   Integer array5[]=new Integer[N];
   Integer array6[]=new Integer[N];
   Integer array7[]=new Integer[N];
   Integer array8[]=new Integer[N];

        for(int i=0;i<N;i++){
            array[i]=i;
        }
       permute(array);
      for(int i=0;i<array.length;i++){  //将数据填充
        array2[i]=array[i];
          array3[i]=array[i];
          array4[i]=array[i];
          array5[i]=array[i];
          array6[i]=array[i];
          array7[i]=array[i];
          array8[i]=array[i];
      }
      long s=System.currentTimeMillis();
      Sort.Selectionsort(array);  //选择排序
      long e=System.currentTimeMillis();
        System.out.println(e-s+"selecton");

         s=System.currentTimeMillis();
        Sort.Bubblesort(array2); //冒泡排序
        e=System.currentTimeMillis();
        System.out.println(e-s+"bubble");

        s=System.currentTimeMillis();
        Sort.insertionSort(array3); //插入排序
        e=System.currentTimeMillis();
        System.out.println(e-s+"insertion");

        s=System.currentTimeMillis();
        Sort.shellsort(array4);  //希尔排序
        e=System.currentTimeMillis();
        System.out.println(e-s+"shell");


        s=System.currentTimeMillis();
        Sort.mergeSort(array5);  //归并排序
        e=System.currentTimeMillis();
        System.out.println(e-s+"merge");

        s=System.currentTimeMillis();
        Sort.quicksort(array6);  //快速排序
        e=System.currentTimeMillis();
        System.out.println(e-s+"quick");

        s=System.currentTimeMillis();
        Sort.Bucketsort(array7,100000); // 桶排序 m为最大的数字
        e=System.currentTimeMillis();
        System.out.println(e-s+"Bucket");

        s=System.currentTimeMillis();
        Sort.radixSort(array8,10,6);  //基数排序  radix 为基数 d为最大位数
        e=System.currentTimeMillis();
        System.out.println(e-s+"Radix");













    }
}
