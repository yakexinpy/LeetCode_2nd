public class Solution {
    public int searchInsert(int[] A, int target) {
        int start = 0, end = A.length - 1;
        
        while(end >= start){
            int mid = (end - start) / 2 + start;
            if(A[mid] == target) return mid;
            if(A[mid] > target)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return start;
    }
}
