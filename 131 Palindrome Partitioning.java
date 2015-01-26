public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<String>();
        
        helper(ret, tmp, 0, s);
        return ret;
    }
    
    private void helper(List<List<String>> ret, List<String> tmp, int start, String s){
        if(start >= s.length()){
            ret.add(new ArrayList<String>(tmp));
        }
        
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s.substring(start, i + 1))){
                tmp.add(s.substring(start, i + 1));
                helper(ret, tmp, i + 1, s);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
