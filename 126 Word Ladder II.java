public class Solution {
    class Node{
        int level;
        String str;
        public Node(int l, String s){
            level = l;
            str = s;
        }
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ret = new ArrayList<List<String>>();
        Set<String> unvisited = new HashSet<String>();
        unvisited.addAll(dict);
        unvisited.add(start);
        unvisited.remove(end);
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : unvisited)
            map.put(s, new ArrayList<String>());
            
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, end));
        
        int curLev = 0, preLev = 0, lastLev = Integer.MAX_VALUE;
        boolean found = false;
        Set<String> visitedCurLev = new HashSet<String>();
        
        while(!q.isEmpty()){
            Node node = q.poll();
            curLev = node.level;
            String curStr = node.str;
            
            if(found && curLev > lastLev) break;
            
            if(curLev > preLev)
                unvisited.removeAll(visitedCurLev);
            
            preLev = curLev;
            char[] chs = curStr.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char old = chs[i];
                boolean foundCur = false;
                for(char c = 'a'; c <= 'z'; c++){
                    if(c == old) continue;
                    chs[i] = c;
                    String newStr = new String(chs);
                    if(unvisited.contains(newStr)){
                        map.get(newStr).add(curStr);
                        if(newStr.equals(start)){
                            found = true;
                            lastLev = curLev;
                            foundCur = true;
                            break;
                        }
                        
                        if(!visitedCurLev.contains(newStr)){
                            visitedCurLev.add(newStr);
                            q.add(new Node(curLev + 1, newStr));
                        }
                    }
                }
                if(foundCur) break;
                chs[i] = old;
            }
        }
        
        if(found){
            List<String> tmp = new ArrayList<String>();
            tmp.add(start);
            buildPath(start, end, tmp, ret, map, lastLev + 1);
        }
        
        return ret;
    }
    
    private void buildPath(String start, String end, List<String> tmp, List<List<String>> ret, Map<String ,List<String>> map, int curLev){
        if(start.equals(end)){
            ret.add(new ArrayList<String>(tmp));
            return;
        }
        
        if(curLev <= 0) return;
        
        for(String s : map.get(start)){
            tmp.add(s);
            buildPath(s, end, tmp, ret, map, curLev - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
