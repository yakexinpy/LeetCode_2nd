public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        
        int a = m - 1, b = n - 1, i = A.length - 1;
        while(a >= 0 && b >= 0){
            if(A[a] >= B[b])
                A[i--] = A[a--];
            else
                A[i--] = B[b--];
        }
        
        while(a >= 0)
            A[i--] = A[a--];
        while(b >= 0)
            A[i--] = B[b--];
    }
}
