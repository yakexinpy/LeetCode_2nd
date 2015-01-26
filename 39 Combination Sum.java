public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        
        helper(ret, tmp, candidates, target);
        
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> tmp, int[] candidates, int target){
        if(target < 0) return;
        if(target == 0){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i = 0; i < candidates.length; i++){
            if(tmp.size() > 0 && candidates[i] < tmp.get(tmp.size() - 1)) continue;
            if(candidates[i] > target) break;
            tmp.add(candidates[i]);
            helper(ret, tmp, candidates, target - candidates[i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}
