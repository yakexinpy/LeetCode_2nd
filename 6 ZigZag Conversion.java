public class Solution {
    public String convert(String s, int nRows) {
        if(s == null || s.length() < nRows || nRows < 2) return s;
        
        int dif = nRows * 2 - 2;
        String ret = "";
        for(int i = 0; i < nRows; i++){
            for(int j = i; j < s.length(); j += dif){
                ret += s.charAt(j);
                if(i > 0 && i < nRows - 1){
                    if(j + dif - 2 * i < s.length())
                        ret += s.charAt(j + dif - 2 * i);
                }
            }
        }
        return ret;
    }
}
