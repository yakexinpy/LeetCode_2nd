public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
    
        String str = "";
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < 1) continue;
            str = strs[i].trim() +" "+ str;
        }
        return str.trim();
    }
}
