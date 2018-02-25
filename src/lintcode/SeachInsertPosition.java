package lintcode;

public class SeachInsertPosition {
    public int searchInsert(int[] A, int target) {
        // write your code here
        int length=A.length;
        if(length==0||A==null){
            return 0;
        }
        int left=0;
        int right=length;
        if(target>A[right-1])
            return right;
        if(target<A[left])
            return left;
        int index=search(A,target,left,right-1);
        return index;

    }
    public int search(int[] A,int target,int left,int right){
        int mid=(left+right)/2;
        if(target==A[mid])
            return mid;
        if(left==right-1)
            return left+1;
         if(target>A[mid]){
          return search(A,target,mid,right);
        }
         if(target<A[mid])
        {
            return search(A,target,left,mid);
        }
        return 0;
    }
}
