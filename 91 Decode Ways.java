public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() < 1) return 0;
        if(s.charAt(0) == '0') return 0;
        
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        for(int i = 1; i <= s.length(); i++){
            int cur = 0;
            if(s.charAt(i - 1) != '0') cur = count[i - 1];
            if(i > 1 && Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) < 27)
                cur += count[i - 2];
            count[i] = cur;
        }
        return count[s.length()];
    }
}
