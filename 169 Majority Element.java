public class Solution {
    public int majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            if(map.containsKey(num[i]))
                map.put(num[i], map.get(num[i]) + 1);
            else
                map.put(num[i], 1);
        }
        
        int max = -1;
        for(Integer i : map.keySet())
            if(map.get(i) > num.length / 2)
                max = i;
        return max;
    }
}
