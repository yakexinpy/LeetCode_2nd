public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        
        helper(ret, res, 0, S);
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> res, int start, int[] S){
        if(start < S.length){
            ret.add(new ArrayList<Integer>(res));
        }
        else{
            ret.add(new ArrayList<Integer>(res));
            return;
        }
        
        for(int i = start; i < S.length; i++){
            res.add(S[i]);
            helper(ret, res, i + 1, S);
            res.remove(res.size() - 1);
        }
    }
}
