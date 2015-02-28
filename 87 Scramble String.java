public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1 && s2.length() == 1) return s1.equals(s2);
        if(s1.equals(s2)) return true;
        
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        Arrays.sort(chs1);
        Arrays.sort(chs2);
        String ns1 = new String(chs1);
        String ns2 = new String(chs2);
        
        if(!ns1.equals(ns2)) return false;
        
        for(int i = 1; i < s1.length(); i++){
            boolean res = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()));
            
            res = res || (isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length())) && isScramble(s1.substring(i, s1.length()), s2.substring(0, s2.length() - i)));
            if(res) return true;
        }
        
        return false;
    }
}
