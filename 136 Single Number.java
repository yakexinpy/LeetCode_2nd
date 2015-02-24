public class Solution {
    public int singleNumber(int[] A) {
        if(A.length < 2) return A[0];
        int size = A[0];
        for(int i = 1; i < A.length; i++)
            size = size ^ A[i];
        return size;
    }
}
