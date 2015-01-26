public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        
        helper(ret, res, 1, n, k);
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> res, int start, int n, int k){
        if(res.size() == k){
            ret.add(new ArrayList<Integer>(res));
            return;
        }
        
        for(int i = start; i <= n; i++){
            res.add(i);
            helper(ret, res, i + 1, n, k);
            res.remove(res.size() - 1);
        }
    }
}
