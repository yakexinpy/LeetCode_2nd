public class Solution {
    public class Record{
        int pos;
        String str;
        public Record(int p, String s){
            pos = p;
            str = s;
        }
    }
    
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> ret = new ArrayList<String>();
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        Map<Integer, ArrayList<Record>> map = new HashMap<Integer, ArrayList<Record>>();
        
        for(int i = 0; i < s.length(); i++){
            if(!flag[i]) continue;
            
            for(String str : dict){
                int len = str.length();
                if(i + len > s.length()) continue;
                if(str.equals(s.substring(i, i + len))){
                    flag[i + len] = true;
                    if(map.containsKey(i + len)){
                        Record r = new Record(i, str);
                        ArrayList<Record> a = map.get(i + len);
                        a.add(r);
                        map.put(i + len, a);
                        
                    }else{
                        ArrayList<Record> a = new ArrayList<Record>();
                        a.add(new Record(i, str));
                        map.put(i + len, a);
                    }
                }
            }
        }
        
        
        if(flag[s.length()])
            buildPath(ret, map, s.length(), "");
        return ret;
    }
    
    private void buildPath(List<String> ret, Map<Integer, ArrayList<Record>> map, int index, String s){
        if(index <= 0){
            ret.add(s.trim());
            return;
        }
        
        for(Record r : map.get(index)){
            buildPath(ret, map, r.pos, r.str + " " + s);
        }
    }
}
