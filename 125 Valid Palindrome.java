public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() < 2) return true;
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while(i < j){
            if(!isValid(s, i)){
                i++;
                continue;
            }
            if(!isValid(s, j)){
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    boolean isValid(String s, int pos){
        if((s.charAt(pos) >= 'a' && s.charAt(pos) <= 'z') || (s.charAt(pos) >= '0' && s.charAt(pos) <= '9'))
             return true;
        return false;
    }
}
