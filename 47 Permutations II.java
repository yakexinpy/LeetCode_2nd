public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[num.length];
        List<Integer> tmp = new ArrayList<Integer>();
        
        helper(ret, tmp, num, visited);
        
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> tmp, int[] num, boolean[] visited){
        if(tmp.size() == num.length){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            if(visited[i]) continue;
            if(i > 0 && num[i] == num[i - 1] && visited[i - 1]) continue;
            tmp.add(num[i]);
            visited[i] = true;
            helper(ret, tmp, num, visited);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
