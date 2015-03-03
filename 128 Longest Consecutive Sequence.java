public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < num.length; i++)
            set.add(num[i]);
        
        int next = 0, max = 0, len = 1;
        
        for(int i = 0; i < num.length; i++){
            if(!set.contains(num[i])) continue;
            set.remove(num[i]);
            next = num[i] - 1;
            while(set.contains(next)){
                set.remove(next);
                next--;
                len++;
            }
            
            next = num[i] + 1;
            while(set.contains(next)){
                set.remove(next);
                next++;
                len++;
            }
            
            max = Math.max(max,len);
            len = 1;
        }
        return max;
    }
}
