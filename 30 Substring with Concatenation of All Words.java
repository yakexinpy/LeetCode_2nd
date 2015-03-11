public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String str : L) 
            if(dict.containsKey(str))
                dict.put(str, dict.get(str) + 1);
            else
                dict.put(str, 1);
        
        List<Integer> ret = new ArrayList<Integer>();
        int len = L[0].length();
        for(int i = 0; i <= S.length() - len * L.length; i++){
            Map<String, Integer> map = (HashMap<String, Integer>)dict.clone();
            String sub = S.substring(i, i + len * L.length);

            for(int j = 0; j < sub.length(); j += len){
                String tmp = sub.substring(j, j + len);
                if(map.containsKey(tmp)){
                    map.put(tmp, map.get(tmp) - 1);
                    int count = map.get(tmp);
                    if(count < 0) break;
                    if(count == 0 && j + len == sub.length()){
                        ret.add(i);
                        break;
                    }
                }
                else
                    break;
            }
        }
        return ret;
    }
}
