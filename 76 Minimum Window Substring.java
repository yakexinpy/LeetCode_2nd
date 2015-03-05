public class Solution {
    public String minWindow(String S, String T) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++){
            if(map.containsKey(T.charAt(i)))
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            else
                map.put(T.charAt(i), 1);
        }
        
        int l = 0, r = 0, minLen = S.length() + 1, count = 0, start = 0;
        for(; r < S.length(); r++){
            if(map.containsKey(S.charAt(r))){
                map.put(S.charAt(r), map.get(S.charAt(r)) - 1);
                
                if(map.get(S.charAt(r)) >= 0)
                    count++;
            }
            
            while(count == T.length()){
                if(r - l + 1 < minLen){
                    start = l;
                    minLen = r - l + 1;
                }
                
                if(map.containsKey(S.charAt(l))){
                    map.put(S.charAt(l), map.get(S.charAt(l)) + 1);
                    
                    if(map.get(S.charAt(l)) > 0)
                        count--;
                }
                
                l++;
            }
        }
        
        if(minLen > S.length())
            return "";
        return S.substring(start, start + minLen);
    }
}
