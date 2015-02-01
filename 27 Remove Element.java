public class Solution {
    public int removeElement(int[] A, int elem) {
        int end = A.length - 1;
        int len = A.length;
        int i = 0;
        while(i < len){
            if(A[i] == elem){
                A[i] = A[end];
                end--;
                len--;
            }
            else
                i++;
        }
        return len;
    }
}
