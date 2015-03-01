public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 + len2 != s3.length()) return false;
        
        boolean[][] flag = new boolean[len1 + 1][len2 + 1];
        flag[0][0] = true;
        
        for(int i = 1; i <= len1; i++)
            if(s1.charAt(i - 1) == s3.charAt(i - 1) && flag[i - 1][0])
                flag[i][0] = true;
        
        for(int j = 1; j <= len2; j++)
            if(s2.charAt(j - 1) == s3.charAt(j - 1) && flag[0][j - 1])
                flag[0][j] = true;
        
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && flag[i - 1][j])
                    flag[i][j] = true;
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1) && flag[i][j - 1])
                    flag[i][j] = true;
            }
        }
        return flag[len1][len2];
    }
}
