package lintcode;

public class mergeSortedArray {
    public int[] mergeSortedArray(int[] A,int[] B){
        int C[]=new int[A.length+B.length];
        int ia=0;
        int ib=0;
        int i=0;
        while(ia<A.length&&ib<B.length){
            if(A[ia]<B[ib])
            {
                C[i]=A[ia];
                ia++;
                i++;
            }
            else if(A[ia]>B[ib])
            {
                C[i]=B[ib];
                ib++;
                i++;
            }
            else
            {
                C[i]=A[ia];
                C[i+1]=B[ib];
                ia++;
                ib++;
                i=i+2;
            }
        }
        for(;ia<A.length;ia++){
            C[i]=A[ia];
            i++;
        }
        for(;ib<B.length;ib++){
            C[i]=B[ib];
            i++;
        }
        return C;
    }

}
