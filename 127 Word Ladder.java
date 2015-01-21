public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        
        queue.add(start);
        visited.add(start);
        int step = 1, curLev = 1, nextLev = 0;
        
        while(!queue.isEmpty()){
            String cur = queue.poll();
            curLev--;
            for(int i = 0; i < cur.length(); i++){
                char[] chs = cur.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    chs[i] = c;
                    String s = new String(chs);
                    if(s.equals(end)) return step + 1;
                    if(dict.contains(s) && !visited.contains(s)){
                        queue.add(s);
                        visited.add(s);
                        nextLev++;
                    }
                }
            }
            
            if(curLev == 0){
                curLev = nextLev;
                nextLev = 0;
                step++;
            }
            
        }
        return 0;
    }
}
