package lintcode;

public class SearchInRotatedSortedArray {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A.length==0||A==null){
            return -1;
        }
        int left=0;
        int right=A.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(target==A[mid])
                return mid;
            if(A[mid]<A[right])
            {
                if(target>A[mid]&&target<=A[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
            else{
                if(target>=A[left]&&target<A[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }

        }
        return -1;
    }
}
