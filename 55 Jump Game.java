public class Solution {
    public boolean canJump(int[] A) {
        if(A == null) return true;
        int far = A[0]; 
        
        for(int i = 0; i < Math.min(A.length, far + 1); i++){
            if(far < A[i] + i)
                far = A[i] + i;
            if(far >= A.length - 1) return true;
        }
        return false;
    }
}
