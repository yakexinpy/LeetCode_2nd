public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(num);
        
        helper(ret, res, 0, num);
        
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> res, int start, int[] num){
        if(start < num.length){
            ret.add(new ArrayList<Integer>(res));
        }
        else{
            ret.add(new ArrayList<Integer>(res));
            return;
        }
        
        for(int i = start; i < num.length; i++){
            if(i > start && num[i] == num[i - 1]) continue;
            res.add(num[i]);
            helper(ret, res, i + 1, num);
            res.remove(res.size() - 1);
        }
    }
}
