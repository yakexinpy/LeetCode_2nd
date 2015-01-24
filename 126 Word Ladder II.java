public class Solution {
    class Node{
        public Node parent;
        public int curLev;
        public String str;
        
        public Node(Node n, String s, int l){
            parent = n;
            curLev = l;
            str = s;
        }
    }
    
    public void calNeighbors(Set<String> dict, String str, HashMap<String, HashSet<String>> neighbors){
        char[] chs = str.toCharArray();
        
        for(int i = 0; i < str.length(); i++){
            char ch = chs[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c == ch) continue;
                chs[i] = c;
                String newStr = new String(chs);
                if(dict.contains(newStr)){
                    HashSet<String> set = neighbors.get(str);
                    if(set != null) 
                        set.add(newStr);
                    else{
                        set = new HashSet<String>();
                        set.add(newStr);
                        neighbors.put(str, set);
                    }
                }
            }
            chs[i] = ch;
        }
    }
    
    public void findPath(Node n, List<List<String>> ret){
        List<String> res = new ArrayList<String>();
        Node p = n;
        
        while(p != null){
            res.add(0, p.str);
            p = p.parent;
        }
        ret.add(res);
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ret = new ArrayList<List<String>>();
       
        dict.add(start);
        dict.add(end);
               
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>(); 
        for(String s : dict){
            calNeighbors(dict, s, map);
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(null, start, 1));
        
        Map<String, Integer> visited = new HashMap<String, Integer>();
        int pre = 0;
        
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.str.equals(end)){
                if(pre == 0 || n.curLev == pre){
                    pre = n.curLev;
                    findPath(n, ret);
                }
                else
                    break;
            }
            else{
                HashSet<String> set = map.get(n.str);
                if(set == null || set.isEmpty()) continue;
                
                List<String> remove = new ArrayList<String>();
                for(String s : set){
                    if(visited.containsKey(s)){
                        int level = visited.get(s);
                        if(n.curLev + 1 > level){
                            map.get(s).remove(n.str);
                            remove.add(s);
                            continue;
                        }
                    }
                        visited.put(s, n.curLev + 1);
                        q.add(new Node(n, s, n.curLev + 1));
                        if(map.containsKey(s))
                            map.get(s).remove(n.str);
                }
                for(String s : remove)
                    set.remove(s);
            }
        }
        
        return ret;
    }
}
