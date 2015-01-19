public class Solution {
//manacher algorithm
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        
        String str = "#";
        for(int i = 0; i < s.length(); i++)
            str += s.charAt(i) + "#";
        
        int[] rad = new int[str.length()];
        int i = 0, j = 0, k;
        int max = 0, pos = 0;
        while(i < str.length()){
            while(i - j - 1 >= 0 && i + j + 1 < str.length() && str.charAt(i - j - 1) == str.charAt(i + j + 1))
                j++;
            rad[i] = j;
            
            if(max < j){
                max = j;
                pos = i;
            }
            
            k = 1;
            while(k <= rad[i] && rad[i] - k != rad[i - k]){
                rad[i + k] = Math.min(rad[i] - k, rad[i - k]);
                k++;
            }
            i = i + k;
            j = Math.max(j - k, 0);
        }
        
        if(str.charAt(pos) == '#')
        	pos = pos / 2;
        else
        	pos = (pos - 1) / 2;
        
        pos = pos - max / 2;
        return s.substring(pos, pos + max);
    }
}
