public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length < 2) return A.length;
        
        int a = 1, count = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] == A[i - 1]){
                if(count < 2){
                    A[a] = A[i];
                    a++;
                    count++;
                }
                else{
                    count++;
                }
            }
            else{
                A[a] = A[i];
                a++;
                count = 1;
            }
        }
        return a;
    }
}
