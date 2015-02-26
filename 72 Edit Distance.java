public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] A = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i++)
            A[i][0] = i;
        for(int j = 0; j <= n; j++)
            A[0][j] = j;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    A[i][j] = A[i - 1][j - 1];
                else
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
            }
        }
        return A[m][n];
    }
}
