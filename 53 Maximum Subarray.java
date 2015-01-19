public class Solution {
    public int maxSubArray(int[] A) {
        if(A == null || A.length < 1) return 0;
        
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < A.length; i++){
            sum = Math.max(A[i], sum + A[i]);
            max= Math.max(sum, max);
        }
        return max;
    }
}
