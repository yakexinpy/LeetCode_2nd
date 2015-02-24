public class Solution {
    public void sortColors(int[] A) {
        int i = 0, j = 0, k = A.length - 1;
        for(; i <= k; i++){
            if(A[i] == 0){
                A[i] = A[j];
                A[j++] = 0;
            }
            else if(A[i] == 2){
                A[i--] = A[k];
                A[k--] = 2;
            }
        }
    }
}
