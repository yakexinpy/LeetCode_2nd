public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 1) return null;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            map.put(target - numbers[i], i + 1);
        }
        
        int[] ret = new int[2];
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(numbers[i]) && map.get(numbers[i]) != i + 1){
                ret[0] = map.get(numbers[i]) < i + 1 ? map.get(numbers[i]) : i + 1;
                ret[1] = map.get(numbers[i]) < i + 1 ? i + 1 :map.get(numbers[i]);
                return ret;
            }
        }
        return ret;
    }
}
