package pat;

import java.util.ArrayList;

public class Print {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            for (int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
            aa(50);
    }

       public void fib(int n){
        int a[]=new int[n];
        a[0]=0;
        a[1]=1;
        for(int i=2;i<n;i++){
            a[i]=a[i-1]+a[i-2];
        }
    }


    public static void aa(int m){
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=2;i<m;i++){
            int sum=0;
            for(int j=1;j<i-1;j++){
                if(i%j==0)
                    sum+=j;
            }
            if(sum==i)
                a.add(i);
        }
        System.out.println(a);
    }
}
