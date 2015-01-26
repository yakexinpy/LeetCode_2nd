public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        
        helper(ret, res, num, 0, target);
        
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> res, int[] num, int start, int target){
        if(target < 0) return;
        if(target == 0){
            ret.add(new ArrayList<Integer>(res));
            return;
        }
        
        for(int i = start; i < num.length; i++){
            if(i > start && num[i] == num[i - 1]) continue;
            //if(res.size() > 1 && num[i] > res.get(res.size() - 1)) break;
            
            res.add(num[i]);
            helper(ret, res, num, i + 1, target - num[i]);
            res.remove(res.size() - 1);
        }
    }
}
