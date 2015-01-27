public class Solution {
    public int maxProduct(int[] A) {
        
        int max = A[0];  
        int min = A[0];
        int pro = A[0];
        
        for(int i = 1; i < A.length; i++){
            int tmpMax = A[i] * max;
            int tmpMin = A[i] * min;
            
            max = Math.max(Math.max(tmpMax, tmpMin), A[i]);
            min = Math.min(Math.min(tmpMax, tmpMin), A[i]);
            pro = Math.max(max, pro);
        }
        return pro;
    }
}
