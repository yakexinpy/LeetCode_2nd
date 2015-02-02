public class Solution {
    public int trap(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        
        int high = 0;
        for(int i = 0; i < A.length; i++){
            high = Math.max(high, A[i]);
            left[i] = high;
        }
        
        high = 0;
        for(int i = A.length - 1; i >= 0; i--){
            high = Math.max(high, A[i]);
            right[i] = high;
        }
        
        int water = 0;
        for(int i = 0; i < A.length; i++){
            water += Math.min(left[i], right[i]) - A[i];
        }
        return water;
    }
}
