public class Solution {
    private int[] checkTable(String s){
        int[] table = new int[s.length()];
        
        int val = 0;
        for(int i = 1; i < s.length(); i++){
            while(val > 0 && s.charAt(i) != s.charAt(val))
                val = table[val - 1];
            if(s.charAt(i) == s.charAt(val))
                val++;
            table[i] = val;
        }
        return table;
    }
    
    public int strStr(String haystack, String needle) {
        /*
        // solution 2: KMP
        */
        if(needle == null || needle.length() < 1) return 0;
        if(haystack == null || haystack.length() < needle.length()) return -1;
        
        int[] T = checkTable(needle);
        int index = 0, start = 0;
        boolean flag = false;
        for(int i = 0; i < haystack.length(); i++){
            while(index > 0 && haystack.charAt(i) != needle.charAt(index)){
                index = T[index - 1];
                flag = false;
            }
            if(haystack.charAt(i) == needle.charAt(index)){
                if(!flag) start = i - index;
                flag = true;
                index++;
            }
            if(index == needle.length()) return start;
        }
        return -1;
        
        /*
        //solution 1: brutal force
        if(needle == null || needle.length() < 1) return 0;
        if(haystack == null || haystack.length() < needle.length()) return -1;
        
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            int k = i;
            int j = 0;
            for(; j < needle.length(); j++){
                if(haystack.charAt(k) != needle.charAt(j))
                    break;
                k++;
            }
            if(j == needle.length())    
                return i;
        }
        return -1;
        */
    }
}
