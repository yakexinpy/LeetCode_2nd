public class Solution {
    /* solution 2: DP
       Instead of seperating the string, match words in dict
    */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() < 1) return true;
        
        boolean[] ret = new boolean[s.length() + 1];
        ret[0] = true;
        for(int i = 0; i < s.length(); i++){
            if(!ret[i]) continue;
            
            for(String str : dict){
                int len = str.length();
                if(i + len > s.length()) continue;
                if(ret[i + len]) continue;
                if(str.equals(s.substring(i, i + len)))
                    ret[i + len] = true;
            }
        }
        
        return ret[s.length()];
    }
    
    /* solution 1: backtracking, TLE
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() < 1) return true;
        return helper(s, 0, dict);
    }
    
    private boolean helper(String s, int start, Set<String> dict){
        if(start >= s.length()) return true;
        
        for(int i = start; i < s.length(); i++){
            if(dict.contains(s.substring(start, i + 1))){
                boolean res = helper(s, i + 1, dict);
                if(res) return res;
            }
        }
        return false;
    }*/
}
