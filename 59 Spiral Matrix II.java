public class Solution {
    public int[][] generateMatrix(int n) {
        int k = 0;
        int count = 1;
        int[][] A = new int[n][n];
        
        while(k < n / 2){
            int r = k, c = k;
            while(c < n - 1 - k)
                A[r][c++] = count++;
            while(r < n - 1 - k)
                A[r++][c] = count++;
            while(c > k)
                A[r][c--] = count++;
            while(r > k)
                A[r--][c] = count++;
            k++;
        }
        
        if(n % 2 == 1)
            A[n / 2][n / 2] = count;
        
        return A;
    }
}
