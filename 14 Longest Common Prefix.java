public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++)
            min = Math.min(min, strs[i].length());
        
        String ret = "";
        for(int i = 0; i < min; i++){
            for(int j = 1; j < strs.length; j++)
                if(strs[j].charAt(i) != strs[j - 1].charAt(i))  
                    return ret;
            ret += strs[0].charAt(i) + "";
        }
        return ret;
    }
}
