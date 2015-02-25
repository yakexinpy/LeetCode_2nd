public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int cur = 0, last = 0, pos = 0, max = 0, len = 0;
        while(cur < s.length()){
            if(map.containsKey(s.charAt(cur))){
                pos = map.get(s.charAt(cur));
                if(pos >= last){
                    max = Math.max(max, len);
                    map.put(s.charAt(cur), cur);
                    last = pos + 1;
                    len = cur - pos;
                    cur++;
                    continue;
                }
            }
            map.put(s.charAt(cur), cur);
            cur++;
            len++;
        }
        return Math.max(max, len);
    }
}
