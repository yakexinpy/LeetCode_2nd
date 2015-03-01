public class Solution {
    public int minCut(String s) {
        int[] cuts = new int[s.length() + 1];
        int len = s.length();
        for(int i = 0; i < len; i++)
            cuts[i] = len - i;
        
        boolean[][] flag = new boolean[len][len];
        char[] chs = s.toCharArray();
        
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(chs[i] == chs[j] && (j - i < 2 || flag[i + 1][j - 1])){
                    flag[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        return cuts[0] - 1;
    }
}
