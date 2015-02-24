public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 1) return 0;
        int last = A[0], pos = 1, size = A.length;
        for(int i = 1; i < A.length; i++){
            while(i < A.length && A[i] == last){
                i++;
                size--;
            }
            if(i >= A.length) break;
            A[pos++] = A[i];
            last = A[i];
        }
        return size;
    }
}
