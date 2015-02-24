public class Solution {
    public int singleNumber(int[] A) {
        if(A.length < 2) return A[0];
        int one = 0, two = 0, three = 0;
        for(int i = 0; i < A.length; i++){
            two |= one & A[i];
            one ^= A[i];
            three = one & two;
            two &= ~three;
            one &= ~three;
        }
        return one;
    }
}
