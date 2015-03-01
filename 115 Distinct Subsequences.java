public class Solution {
    public int numDistinct(String S, String T) {
        int s = S.length(), t = T.length();
        int[][] count = new int[s + 1][t + 1];
        count[0][0] = 1;
        
        for(int i = 1; i <= s; i++)
            count[i][0] = 1;
        
        for(int j = 1; j <= t; j++){
            for(int i = 1; i <= s; i++){
                if(S.charAt(i - 1) == T.charAt(j - 1))
                    count[i][j] = count[i - 1][j - 1] + count[i - 1][j];
                else
                    count[i][j] = count[i - 1][j];
            }
        }
        return count[s][t];
    }
}
