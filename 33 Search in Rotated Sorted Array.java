public class Solution {
    public int search(int[] A, int target) {
        int offset = 0;
        for(int i = 0; i < A.length - 1; i++)
            if(A[i] > A[i + 1]){
                offset = i + 1;
                break;
            }
        
        int left = 0, right = A.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(A[(mid + offset) % A.length] == target) return (mid + offset) % A.length;
            if(A[(mid + offset) % A.length] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
