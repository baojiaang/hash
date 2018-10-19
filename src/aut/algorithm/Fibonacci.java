package aut.algorithm;

public class Fibonacci {
    public long fib1(int n){
        if (n==0)
            return 0;
        if(n==1)
            return 1;
        return fib1(n-1)+fib1(n-2);
    }
    public long fib2(int n){
        if (n==0)
            return 0;
        long a[]=new long[n+1];
        a[0]=0;a[1]=1;
        for(int i=2;i<=n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n];
    }
//    public long fib3(int n){
//        if (n==0)
//            return 0;
//        if(n==1)
//            return 1;
//        long A[][]=new long[n][n];
//        long B[][]=new long[n][n];
//        A[0][0]=0;A[0][1]=1;A[1][0]=1;A[1][1]=1;
//        B[0][0]=1;B[0][1]=0;B[1][0]=0;B[1][1]=1;
//        for(int i=1;i<=n;i++) {
//            B = multiply2by2(B, A);
//        }
//        return B[0][1];
//    }
//   public long[][] multiply2by2(long [][]a,long [][]b){  // this methond is slower than next one
//        long [][]result=new long[a.length][b[0].length];
//        for(int i=0;i<a.length;i++){
//            for(int j=0;j<b[0].length;j++){
//                for(int k=0;k<a[0].length;k++){
//                    result[i][j]=result[i][j]+a[i][k]*b[k][j];
//                }
//            }
//        }
//        return result;
//   }
    public long[][] multiply2by2(long [][]a,long [][]b){
        long [][]result=new long[2][2];
       result[0][0]=a[0][0]*b[0][0]+a[0][1]*b[1][0];
       result[0][1]=a[0][0]*b[0][1]+a[0][1]*b[1][1];
       result[1][0]=a[1][0]*b[0][0]+a[1][1]*b[1][0];
       result[1][1]=a[1][0]*b[0][1]+a[1][1]*b[1][1];
        return result;
    }
    public long fib3(int n){
        if (n==0)
            return 0;
        if(n==1)
            return 1;
        long A[][]=new long[2][2];
        long B[][]=new long[2][2];
        A[0][0]=0;A[0][1]=1;A[1][0]=1;A[1][1]=1;
        B[0][0]=1;B[0][1]=0;B[1][0]=0;B[1][1]=1;
        for(int i=1;i<=n;i++) {
            B = multiply2by2(B, A);
        }
        return B[0][1];
    }
   public long fib4(int n){
       if (n==0)
           return 0;
       if(n==1)
           return 1;
       long A[][]=new long[2][2];
       long B[][]=new long[2][2];
       A[0][0]=0;A[0][1]=1;A[1][0]=1;A[1][1]=1;
       B[0][0]=1;B[0][1]=0;B[1][0]=0;B[1][1]=1;


       while(n>0){
           if(n%2==1){
               B=multiply2by2(B,A);
           }
           A=multiply2by2(A,A);
           n=n/2;
       }
       return B[0][1];
   }


    public static void main(String[] args) {
        Fibonacci fib=new Fibonacci();
        for(int n=10;n<=100;n++){
            long start=System.currentTimeMillis();
            for(int i=0;i<100;i++) {
                long value = fib.fib3(n);
            }
            long end=System.currentTimeMillis();
            System.out.println( " n is (compute 100 times)" + n + " takes " + (end - start) + "ms");

        }


    }



}
