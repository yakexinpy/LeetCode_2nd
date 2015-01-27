public class Solution {
    /*
    solution 2 : divide and conquer
    */
    public int maxSubArray(int[] A) {
        return helper(A, 0, A.length - 1);
    }
    
    private int helper(int[] A, int left, int right){
        if(left > right) return Integer.MIN_VALUE;
        int mid = (left + right) / 2;
        int leftR = helper(A, left, mid - 1);
        int rightR = helper(A, mid + 1, right);
        
        int lMax = 0;
        int lSum = 0;
        for(int i = mid - 1; i >= left; i--){
            lSum += A[i];
            lMax = Math.max(lMax, lSum);
        }
        
        int rMax = 0;
        int rSum = 0;
        for(int i = mid + 1; i <= right; i++){
            rSum += A[i];
            rMax = Math.max(rMax, rSum);
        }
        
        return Math.max(lMax + A[mid] + rMax, Math.max(leftR, rightR));
    }
    
    /* solution 1: DP
    public int maxSubArray(int[] A) {
        int sum = A[0];
        int cur = A[0];
        for(int i = 1; i < A.length; i++){
            cur = Math.max(A[i], cur + A[i]);
            sum = Math.max(sum, cur);
        }
        
        return sum;
    }
    */
}
