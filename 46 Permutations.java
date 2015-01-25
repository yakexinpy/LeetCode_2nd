public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[num.length];
        for(int i = 0; i < num.length; i++){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(num[i]);
            visited[i] = true;
            helper(ret, tmp, num, visited);
            visited[i] = false;
        }
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> tmp, int[] num, boolean[] visited){
        if(tmp.size() == num.length){
            ArrayList<Integer> a = new ArrayList<Integer>(tmp);
            ret.add(a);
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(visited[i]) continue;
            tmp.add(num[i]);
            visited[i] = true;
            helper(ret, tmp, num, visited);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
