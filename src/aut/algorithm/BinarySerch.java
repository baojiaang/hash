package aut.algorithm;

public class BinarySerch {
    public  int binarySearch(Integer[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (low <= high) {
            //计算出中间索引值
            int middle = (high + low)>>>1 ;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

    public static void main(String[] args) {
        BinarySerch b=new BinarySerch();
        long x[]=new long[100001];
        long y[]=new long[100001];
        for(int i=0;i<100000;i++){
            x[i]=i;
            long  all=0;
            for(int j=0;j<1000;j++){
                Integer a[]=new Integer[i+1];
                for(int k=0;k<a.length;k++){
                    a[k]=k;
                }
                long start = System.nanoTime();
                b.binarySearch(a,a[0]);
                long end = System.nanoTime();
                long time = end - start;
                all=all+time;
            }
            y[i]=all/1000;
            System.out.println(y[i]);
        }
        GraphingData g=new GraphingData("",x,y);
    }
}
