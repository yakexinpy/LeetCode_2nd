public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String str = new String(chs);
            
            if(map.containsKey(str)){
                List<String> list = map.get(str);
                list.add(strs[i]);
                map.put(str, list);
            }
            else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        
        Set<String> set = map.keySet();
        List<String> ret = new ArrayList<String>();
        for(String i : set){
            List<String> list = map.get(i);
            if(list.size() > 1)
                ret.addAll(list);
        }
        return ret;
    }
}
