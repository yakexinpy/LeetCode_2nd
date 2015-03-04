public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.trim().split(" ");
        
        for(int i = strs.length - 1; i >= 0; i--)
            if(strs[i].length() > 0)
                return strs[i].length();
        
        return 0;
    }
}
