public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int k = (m + n) / 2;
        
        if((m + n) % 2 != 0){
            return helper(A, B, 0, m - 1, 0, n - 1, k);
        }
        else
            return (helper(A, B, 0, m - 1, 0, n - 1, k) + helper(A, B, 0, m - 1, 0, n - 1, k - 1)) * 0.5;
    }
    
    public double helper(int[] A, int[] B, int startA, int endA, int startB, int endB, int k){
        if(startA > endA)
            return (double) B[startB + k];
        if(startB > endB)
            return (double) A[startA + k];
        if(k == 0)
            return (A[startA] <= B[startB]) ? (double)A[startA] : (double)B[startB];
            
        int lenA = endA - startA + 1;
        int lenB = endB - startB + 1;
        int midA = k * lenA / (lenA + lenB);
        int midB = k - midA - 1;
        midA = midA + startA;
        midB = midB + startB;
        
        if(A[midA] <= B[midB]){
            k = k - (midA - startA + 1);
            startA = midA + 1;
            endB = midB;
        }
        else{
            k = k - (midB - startB + 1);
            startB = midB + 1;
            endA = midA;
        }
        return helper(A, B, startA, endA, startB, endB, k);
    }
}
